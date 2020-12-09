package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzlu;

@zziy
public class zzii implements Runnable {
    /* access modifiers changed from: private */
    public final int zzajw;
    /* access modifiers changed from: private */
    public final int zzajx;
    protected final zzlt zzbkr;
    /* access modifiers changed from: private */
    public final Handler zzccq;
    /* access modifiers changed from: private */
    public final long zzccr;
    /* access modifiers changed from: private */
    public long zzccs;
    /* access modifiers changed from: private */
    public zzlu.zza zzcct;
    protected boolean zzccu;
    protected boolean zzccv;

    protected final class zza extends AsyncTask<Void, Void, Boolean> {
        private final WebView zzccw;
        private Bitmap zzccx;

        public zza(WebView webView) {
            this.zzccw = webView;
        }

        /* access modifiers changed from: protected */
        public synchronized void onPreExecute() {
            this.zzccx = Bitmap.createBitmap(zzii.this.zzajw, zzii.this.zzajx, Bitmap.Config.ARGB_8888);
            this.zzccw.setVisibility(0);
            this.zzccw.measure(View.MeasureSpec.makeMeasureSpec(zzii.this.zzajw, 0), View.MeasureSpec.makeMeasureSpec(zzii.this.zzajx, 0));
            this.zzccw.layout(0, 0, zzii.this.zzajw, zzii.this.zzajx);
            this.zzccw.draw(new Canvas(this.zzccx));
            this.zzccw.invalidate();
        }

        /* access modifiers changed from: protected */
        /* renamed from: zza */
        public synchronized Boolean doInBackground(Void... voidArr) {
            boolean z;
            int width = this.zzccx.getWidth();
            int height = this.zzccx.getHeight();
            if (width == 0 || height == 0) {
                z = false;
            } else {
                int i = 0;
                for (int i2 = 0; i2 < width; i2 += 10) {
                    for (int i3 = 0; i3 < height; i3 += 10) {
                        if (this.zzccx.getPixel(i2, i3) != 0) {
                            i++;
                        }
                    }
                }
                z = Boolean.valueOf(((double) i) / (((double) (width * height)) / 100.0d) > 0.1d);
            }
            return z;
        }

        /* access modifiers changed from: protected */
        /* renamed from: zza */
        public void onPostExecute(Boolean bool) {
            zzii.zzc(zzii.this);
            if (bool.booleanValue() || zzii.this.zzqz() || zzii.this.zzccs <= 0) {
                zzii.this.zzccv = bool.booleanValue();
                zzii.this.zzcct.zza(zzii.this.zzbkr, true);
            } else if (zzii.this.zzccs > 0) {
                if (zzkn.zzbf(2)) {
                    zzkn.zzdd("Ad not detected, scheduling another run.");
                }
                zzii.this.zzccq.postDelayed(zzii.this, zzii.this.zzccr);
            }
        }
    }

    public zzii(zzlu.zza zza2, zzlt zzlt, int i, int i2) {
        this(zza2, zzlt, i, i2, 200, 50);
    }

    public zzii(zzlu.zza zza2, zzlt zzlt, int i, int i2, long j, long j2) {
        this.zzccr = j;
        this.zzccs = j2;
        this.zzccq = new Handler(Looper.getMainLooper());
        this.zzbkr = zzlt;
        this.zzcct = zza2;
        this.zzccu = false;
        this.zzccv = false;
        this.zzajx = i2;
        this.zzajw = i;
    }

    static /* synthetic */ long zzc(zzii zzii) {
        long j = zzii.zzccs - 1;
        zzii.zzccs = j;
        return j;
    }

    public void run() {
        if (this.zzbkr == null || zzqz()) {
            this.zzcct.zza(this.zzbkr, true);
        } else {
            new zza(this.zzbkr.getWebView()).execute(new Void[0]);
        }
    }

    public void zza(AdResponseParcel adResponseParcel) {
        zza(adResponseParcel, new zzme(this, this.zzbkr, adResponseParcel.zzchj));
    }

    public void zza(AdResponseParcel adResponseParcel, zzme zzme) {
        this.zzbkr.setWebViewClient(zzme);
        this.zzbkr.loadDataWithBaseURL(TextUtils.isEmpty(adResponseParcel.zzbyj) ? null : zzu.zzfz().zzcv(adResponseParcel.zzbyj), adResponseParcel.body, "text/html", "UTF-8", (String) null);
    }

    public void zzqx() {
        this.zzccq.postDelayed(this, this.zzccr);
    }

    public synchronized void zzqy() {
        this.zzccu = true;
    }

    public synchronized boolean zzqz() {
        return this.zzccu;
    }

    public boolean zzra() {
        return this.zzccv;
    }
}
