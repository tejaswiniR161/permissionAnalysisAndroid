package com.facebook.ads.internal.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import com.facebook.ads.internal.thirdparty.http.C0509a;
import com.facebook.ads.internal.thirdparty.http.C0524o;
import com.facebook.ads.internal.view.C0573e;

/* renamed from: com.facebook.ads.internal.util.k */
public class C0544k extends AsyncTask<String, Void, Bitmap[]> {

    /* renamed from: a */
    private static final String f1268a = C0544k.class.getSimpleName();

    /* renamed from: b */
    private final Context f1269b;

    /* renamed from: c */
    private final ImageView f1270c;

    /* renamed from: d */
    private final C0573e f1271d;

    /* renamed from: e */
    private C0545l f1272e;

    public C0544k(Context context) {
        this.f1269b = context;
        this.f1271d = null;
        this.f1270c = null;
    }

    public C0544k(ImageView imageView) {
        this.f1269b = imageView.getContext();
        this.f1271d = null;
        this.f1270c = imageView;
    }

    public C0544k(C0573e eVar) {
        this.f1269b = eVar.getContext();
        this.f1271d = eVar;
        this.f1270c = null;
    }

    /* renamed from: a */
    public C0544k mo6128a(C0545l lVar) {
        this.f1272e = lVar;
        return this;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(Bitmap[] bitmapArr) {
        if (this.f1270c != null) {
            this.f1270c.setImageBitmap(bitmapArr[0]);
        }
        if (this.f1271d != null) {
            this.f1271d.mo6162a(bitmapArr[0], bitmapArr[1]);
        }
        if (this.f1272e != null) {
            this.f1272e.mo5820a();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Bitmap[] doInBackground(String... strArr) {
        Throwable th;
        Bitmap bitmap;
        Bitmap bitmap2;
        Bitmap bitmap3 = null;
        String str = strArr[0];
        try {
            bitmap = C0546m.m1230a(this.f1269b, str);
            if (bitmap == null) {
                try {
                    byte[] d = new C0509a(this.f1269b).mo6058a(str, (C0524o) null).mo6100d();
                    bitmap = BitmapFactory.decodeByteArray(d, 0, d.length);
                    C0546m.m1231a(this.f1269b, str, bitmap);
                } catch (Throwable th2) {
                    th = th2;
                    bitmap2 = null;
                    Log.e(f1268a, "Error downloading image: " + str, th);
                    C0531c.m1182a(C0528b.m1179a(th, (String) null));
                    bitmap3 = bitmap2;
                    bitmap2 = bitmap;
                    return new Bitmap[]{bitmap2, bitmap3};
                }
            }
            bitmap2 = bitmap;
            try {
                if (!(this.f1271d == null || bitmap2 == null)) {
                    try {
                        C0552q qVar = new C0552q(bitmap2);
                        qVar.mo6140a(Math.round(((float) bitmap2.getWidth()) / 40.0f));
                        bitmap3 = qVar.mo6139a();
                    } catch (Throwable th3) {
                        th = th3;
                        bitmap = bitmap2;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bitmap = bitmap2;
                bitmap2 = null;
                Log.e(f1268a, "Error downloading image: " + str, th);
                C0531c.m1182a(C0528b.m1179a(th, (String) null));
                bitmap3 = bitmap2;
                bitmap2 = bitmap;
                return new Bitmap[]{bitmap2, bitmap3};
            }
        } catch (Throwable th5) {
            th = th5;
            bitmap = null;
            bitmap2 = null;
        }
        return new Bitmap[]{bitmap2, bitmap3};
    }
}
