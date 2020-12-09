package com.google.android.gms.common.images;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.p000v4.util.LruCache;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.images.zza;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzrv;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    /* access modifiers changed from: private */

    /* renamed from: Ae */
    public static final Object f1594Ae = new Object();
    /* access modifiers changed from: private */

    /* renamed from: Af */
    public static HashSet<Uri> f1595Af = new HashSet<>();

    /* renamed from: Ag */
    private static ImageManager f1596Ag;

    /* renamed from: Ah */
    private static ImageManager f1597Ah;
    /* access modifiers changed from: private */

    /* renamed from: Ai */
    public final ExecutorService f1598Ai = Executors.newFixedThreadPool(4);
    /* access modifiers changed from: private */

    /* renamed from: Aj */
    public final zzb f1599Aj;
    /* access modifiers changed from: private */

    /* renamed from: Ak */
    public final zzrv f1600Ak;
    /* access modifiers changed from: private */

    /* renamed from: Al */
    public final Map<zza, ImageReceiver> f1601Al;
    /* access modifiers changed from: private */

    /* renamed from: Am */
    public final Map<Uri, ImageReceiver> f1602Am;
    /* access modifiers changed from: private */

    /* renamed from: An */
    public final Map<Uri, Long> f1603An;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final Handler mHandler = new Handler(Looper.getMainLooper());

    @KeepName
    private final class ImageReceiver extends ResultReceiver {
        /* access modifiers changed from: private */

        /* renamed from: Ao */
        public final ArrayList<zza> f1604Ao = new ArrayList<>();
        private final Uri mUri;

        ImageReceiver(Uri uri) {
            super(new Handler(Looper.getMainLooper()));
            this.mUri = uri;
        }

        public void onReceiveResult(int i, Bundle bundle) {
            ImageManager.this.f1598Ai.execute(new zzc(this.mUri, (ParcelFileDescriptor) bundle.getParcelable("com.google.android.gms.extra.fileDescriptor")));
        }

        public void zzatm() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.this.mContext.sendBroadcast(intent);
        }

        public void zzb(zza zza) {
            com.google.android.gms.common.internal.zzc.zzhq("ImageReceiver.addImageRequest() must be called in the main thread");
            this.f1604Ao.add(zza);
        }

        public void zzc(zza zza) {
            com.google.android.gms.common.internal.zzc.zzhq("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.f1604Ao.remove(zza);
        }
    }

    public interface OnImageLoadedListener {
        void onImageLoaded(Uri uri, Drawable drawable, boolean z);
    }

    @TargetApi(11)
    private static final class zza {
        static int zza(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    private static final class zzb extends LruCache<zza.C1270zza, Bitmap> {
        public zzb(Context context) {
            super(zzcc(context));
        }

        @TargetApi(11)
        private static int zzcc(Context context) {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            return (int) (((float) (((!((context.getApplicationInfo().flags & 1048576) != 0) || !zzs.zzaxk()) ? activityManager.getMemoryClass() : zza.zza(activityManager)) * 1048576)) * 0.33f);
        }

        /* access modifiers changed from: protected */
        /* renamed from: zza */
        public int sizeOf(zza.C1270zza zza, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        /* access modifiers changed from: protected */
        /* renamed from: zza */
        public void entryRemoved(boolean z, zza.C1270zza zza, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(z, zza, bitmap, bitmap2);
        }
    }

    private final class zzc implements Runnable {

        /* renamed from: Aq */
        private final ParcelFileDescriptor f1607Aq;
        private final Uri mUri;

        public zzc(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.mUri = uri;
            this.f1607Aq = parcelFileDescriptor;
        }

        public void run() {
            com.google.android.gms.common.internal.zzc.zzhr("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean z = false;
            Bitmap bitmap = null;
            if (this.f1607Aq != null) {
                try {
                    bitmap = BitmapFactory.decodeFileDescriptor(this.f1607Aq.getFileDescriptor());
                } catch (OutOfMemoryError e) {
                    String valueOf = String.valueOf(this.mUri);
                    Log.e("ImageManager", new StringBuilder(String.valueOf(valueOf).length() + 34).append("OOM while loading bitmap for uri: ").append(valueOf).toString(), e);
                    z = true;
                }
                try {
                    this.f1607Aq.close();
                } catch (IOException e2) {
                    Log.e("ImageManager", "closed failed", e2);
                }
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            ImageManager.this.mHandler.post(new zzf(this.mUri, bitmap, z, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException e3) {
                String valueOf2 = String.valueOf(this.mUri);
                Log.w("ImageManager", new StringBuilder(String.valueOf(valueOf2).length() + 32).append("Latch interrupted while posting ").append(valueOf2).toString());
            }
        }
    }

    private final class zzd implements Runnable {

        /* renamed from: Ar */
        private final zza f1609Ar;

        public zzd(zza zza) {
            this.f1609Ar = zza;
        }

        public void run() {
            com.google.android.gms.common.internal.zzc.zzhq("LoadImageRunnable must be executed on the main thread");
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.f1601Al.get(this.f1609Ar);
            if (imageReceiver != null) {
                ImageManager.this.f1601Al.remove(this.f1609Ar);
                imageReceiver.zzc(this.f1609Ar);
            }
            zza.C1270zza zza = this.f1609Ar.f1614At;
            if (zza.uri == null) {
                this.f1609Ar.zza(ImageManager.this.mContext, ImageManager.this.f1600Ak, true);
                return;
            }
            Bitmap zza2 = ImageManager.this.zza(zza);
            if (zza2 != null) {
                this.f1609Ar.zza(ImageManager.this.mContext, zza2, true);
                return;
            }
            Long l = (Long) ImageManager.this.f1603An.get(zza.uri);
            if (l != null) {
                if (SystemClock.elapsedRealtime() - l.longValue() < 3600000) {
                    this.f1609Ar.zza(ImageManager.this.mContext, ImageManager.this.f1600Ak, true);
                    return;
                }
                ImageManager.this.f1603An.remove(zza.uri);
            }
            this.f1609Ar.zza(ImageManager.this.mContext, ImageManager.this.f1600Ak);
            ImageReceiver imageReceiver2 = (ImageReceiver) ImageManager.this.f1602Am.get(zza.uri);
            if (imageReceiver2 == null) {
                imageReceiver2 = new ImageReceiver(zza.uri);
                ImageManager.this.f1602Am.put(zza.uri, imageReceiver2);
            }
            imageReceiver2.zzb(this.f1609Ar);
            if (!(this.f1609Ar instanceof zza.zzc)) {
                ImageManager.this.f1601Al.put(this.f1609Ar, imageReceiver2);
            }
            synchronized (ImageManager.f1594Ae) {
                if (!ImageManager.f1595Af.contains(zza.uri)) {
                    ImageManager.f1595Af.add(zza.uri);
                    imageReceiver2.zzatm();
                }
            }
        }
    }

    @TargetApi(14)
    private static final class zze implements ComponentCallbacks2 {

        /* renamed from: Aj */
        private final zzb f1610Aj;

        public zze(zzb zzb) {
            this.f1610Aj = zzb;
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
            this.f1610Aj.evictAll();
        }

        public void onTrimMemory(int i) {
            if (i >= 60) {
                this.f1610Aj.evictAll();
            } else if (i >= 20) {
                this.f1610Aj.trimToSize(this.f1610Aj.size() / 2);
            }
        }
    }

    private final class zzf implements Runnable {

        /* renamed from: As */
        private boolean f1612As;
        private final Bitmap mBitmap;
        private final Uri mUri;
        private final CountDownLatch zzamx;

        public zzf(Uri uri, Bitmap bitmap, boolean z, CountDownLatch countDownLatch) {
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.f1612As = z;
            this.zzamx = countDownLatch;
        }

        private void zza(ImageReceiver imageReceiver, boolean z) {
            ArrayList zza = imageReceiver.f1604Ao;
            int size = zza.size();
            for (int i = 0; i < size; i++) {
                zza zza2 = (zza) zza.get(i);
                if (z) {
                    zza2.zza(ImageManager.this.mContext, this.mBitmap, false);
                } else {
                    ImageManager.this.f1603An.put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
                    zza2.zza(ImageManager.this.mContext, ImageManager.this.f1600Ak, false);
                }
                if (!(zza2 instanceof zza.zzc)) {
                    ImageManager.this.f1601Al.remove(zza2);
                }
            }
        }

        public void run() {
            com.google.android.gms.common.internal.zzc.zzhq("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean z = this.mBitmap != null;
            if (ImageManager.this.f1599Aj != null) {
                if (this.f1612As) {
                    ImageManager.this.f1599Aj.evictAll();
                    System.gc();
                    this.f1612As = false;
                    ImageManager.this.mHandler.post(this);
                    return;
                } else if (z) {
                    ImageManager.this.f1599Aj.put(new zza.C1270zza(this.mUri), this.mBitmap);
                }
            }
            ImageReceiver imageReceiver = (ImageReceiver) ImageManager.this.f1602Am.remove(this.mUri);
            if (imageReceiver != null) {
                zza(imageReceiver, z);
            }
            this.zzamx.countDown();
            synchronized (ImageManager.f1594Ae) {
                ImageManager.f1595Af.remove(this.mUri);
            }
        }
    }

    private ImageManager(Context context, boolean z) {
        this.mContext = context.getApplicationContext();
        if (z) {
            this.f1599Aj = new zzb(this.mContext);
            if (zzs.zzaxn()) {
                zzatk();
            }
        } else {
            this.f1599Aj = null;
        }
        this.f1600Ak = new zzrv();
        this.f1601Al = new HashMap();
        this.f1602Am = new HashMap();
        this.f1603An = new HashMap();
    }

    public static ImageManager create(Context context) {
        return zzg(context, false);
    }

    /* access modifiers changed from: private */
    public Bitmap zza(zza.C1270zza zza2) {
        if (this.f1599Aj == null) {
            return null;
        }
        return (Bitmap) this.f1599Aj.get(zza2);
    }

    @TargetApi(14)
    private void zzatk() {
        this.mContext.registerComponentCallbacks(new zze(this.f1599Aj));
    }

    public static ImageManager zzg(Context context, boolean z) {
        if (z) {
            if (f1597Ah == null) {
                f1597Ah = new ImageManager(context, true);
            }
            return f1597Ah;
        }
        if (f1596Ag == null) {
            f1596Ag = new ImageManager(context, false);
        }
        return f1596Ag;
    }

    public void loadImage(ImageView imageView, int i) {
        zza((zza) new zza.zzb(imageView, i));
    }

    public void loadImage(ImageView imageView, Uri uri) {
        zza((zza) new zza.zzb(imageView, uri));
    }

    public void loadImage(ImageView imageView, Uri uri, int i) {
        zza.zzb zzb2 = new zza.zzb(imageView, uri);
        zzb2.zzgh(i);
        zza((zza) zzb2);
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri) {
        zza((zza) new zza.zzc(onImageLoadedListener, uri));
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri uri, int i) {
        zza.zzc zzc2 = new zza.zzc(onImageLoadedListener, uri);
        zzc2.zzgh(i);
        zza((zza) zzc2);
    }

    public void zza(zza zza2) {
        com.google.android.gms.common.internal.zzc.zzhq("ImageManager.loadImage() must be called in the main thread");
        new zzd(zza2).run();
    }
}
