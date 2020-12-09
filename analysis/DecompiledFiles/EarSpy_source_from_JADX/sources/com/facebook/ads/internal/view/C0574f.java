package com.facebook.ads.internal.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.facebook.ads.InterstitialAdActivity;
import com.facebook.ads.internal.action.C0434a;
import com.facebook.ads.internal.action.C0435b;
import com.facebook.ads.internal.adapters.C0439b;
import com.facebook.ads.internal.adapters.C0456k;
import com.facebook.ads.internal.adapters.C0457l;
import com.facebook.ads.internal.util.C0528b;
import com.facebook.ads.internal.util.C0531c;
import com.facebook.ads.internal.util.C0541h;
import com.facebook.ads.internal.view.C0556a;
import com.facebook.ads.internal.view.C0580h;

/* renamed from: com.facebook.ads.internal.view.f */
public class C0574f implements C0580h {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f1336a = C0574f.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C0580h.C0581a f1337b;

    /* renamed from: c */
    private C0556a f1338c;

    /* renamed from: d */
    private C0456k f1339d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C0457l f1340e;

    /* renamed from: f */
    private long f1341f = System.currentTimeMillis();
    /* access modifiers changed from: private */

    /* renamed from: g */
    public long f1342g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C0528b.C0529a f1343h;

    public C0574f(final InterstitialAdActivity interstitialAdActivity, C0580h.C0581a aVar) {
        this.f1337b = aVar;
        this.f1338c = new C0556a(interstitialAdActivity, new C0556a.C0558a() {
            /* renamed from: a */
            public void mo5916a() {
                C0574f.this.f1340e.mo5964c();
            }

            /* renamed from: a */
            public void mo5917a(int i) {
            }

            /* renamed from: a */
            public void mo5918a(String str) {
                Uri parse = Uri.parse(str);
                if (!"fbad".equals(parse.getScheme()) || !"close".equals(parse.getAuthority())) {
                    C0574f.this.f1337b.mo5786a("com.facebook.ads.interstitial.clicked");
                    C0434a a = C0435b.m813a(interstitialAdActivity, parse);
                    if (a != null) {
                        try {
                            C0528b.C0529a unused = C0574f.this.f1343h = a.mo5881a();
                            long unused2 = C0574f.this.f1342g = System.currentTimeMillis();
                            a.mo5883b();
                        } catch (Exception e) {
                            Log.e(C0574f.f1336a, "Error executing action", e);
                        }
                    }
                } else {
                    interstitialAdActivity.finish();
                }
            }

            /* renamed from: b */
            public void mo5919b() {
                C0574f.this.f1340e.mo5905a();
            }
        }, 1);
        this.f1338c.setId(100001);
        this.f1338c.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        this.f1340e = new C0457l(interstitialAdActivity, this.f1338c, new C0439b() {
            /* renamed from: d */
            public void mo5838d() {
                C0574f.this.f1337b.mo5786a("com.facebook.ads.interstitial.impression.logged");
            }
        });
        this.f1340e.mo5965d();
        aVar.mo5785a((View) this.f1338c);
    }

    /* renamed from: a */
    public void mo6164a() {
        if (this.f1338c != null) {
            this.f1338c.onPause();
        }
    }

    /* renamed from: a */
    public void mo6165a(Intent intent, Bundle bundle) {
        if (bundle == null || !bundle.containsKey("dataModel")) {
            this.f1339d = C0456k.m911b(intent);
            if (this.f1339d != null) {
                this.f1340e.mo5963a(this.f1339d);
                this.f1338c.loadDataWithBaseURL(C0541h.m1215a(), this.f1339d.mo5954d(), "text/html", "utf-8", (String) null);
                this.f1338c.mo6142a(this.f1339d.mo5960j(), this.f1339d.mo5961k());
                return;
            }
            return;
        }
        this.f1339d = C0456k.m909a(bundle.getBundle("dataModel"));
        if (this.f1339d != null) {
            this.f1338c.loadDataWithBaseURL(C0541h.m1215a(), this.f1339d.mo5954d(), "text/html", "utf-8", (String) null);
            this.f1338c.mo6142a(this.f1339d.mo5960j(), this.f1339d.mo5961k());
        }
    }

    /* renamed from: a */
    public void mo6166a(Bundle bundle) {
        if (this.f1339d != null) {
            bundle.putBundle("dataModel", this.f1339d.mo5962l());
        }
    }

    /* renamed from: b */
    public void mo6167b() {
        if (!(this.f1342g <= 0 || this.f1343h == null || this.f1339d == null)) {
            C0531c.m1182a(C0528b.m1177a(this.f1342g, this.f1343h, this.f1339d.mo5959i()));
        }
        if (this.f1338c != null) {
            this.f1338c.onResume();
        }
    }

    /* renamed from: c */
    public void mo6168c() {
        if (this.f1339d != null) {
            C0531c.m1182a(C0528b.m1177a(this.f1341f, C0528b.C0529a.XOUT, this.f1339d.mo5959i()));
        }
        if (this.f1338c != null) {
            C0541h.m1219a((WebView) this.f1338c);
            this.f1338c.destroy();
            this.f1338c = null;
        }
    }
}
