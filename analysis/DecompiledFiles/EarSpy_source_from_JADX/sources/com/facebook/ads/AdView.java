package com.facebook.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.internal.C0433a;
import com.facebook.ads.internal.C0462b;
import com.facebook.ads.internal.C0463c;
import com.facebook.ads.internal.C0480h;
import com.facebook.ads.internal.util.C0537g;
import com.facebook.ads.internal.view.C0556a;

public class AdView extends RelativeLayout implements C0405Ad {

    /* renamed from: a */
    private static final C0463c f752a = C0463c.ADS;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final DisplayMetrics f753b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final AdSize f754c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C0480h f755d;

    /* renamed from: e */
    private volatile boolean f756e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public AdListener f757f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public ImpressionListener f758g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public View f759h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public boolean f760i = false;

    public AdView(Context context, String str, AdSize adSize) {
        super(context);
        if (adSize == null || adSize == AdSize.INTERSTITIAL) {
            throw new IllegalArgumentException("adSize");
        }
        this.f753b = getContext().getResources().getDisplayMetrics();
        this.f754c = adSize;
        this.f755d = new C0480h(context, str, C0537g.m1197a(adSize), adSize, f752a, 1, false);
        this.f755d.mo6012a((C0433a) new C0433a() {
            /* renamed from: a */
            public void mo5765a() {
                if (AdView.this.f755d != null) {
                    AdView.this.f755d.mo6016c();
                }
            }

            /* renamed from: a */
            public void mo5766a(View view) {
                if (view == null) {
                    throw new IllegalStateException("Cannot present null view");
                }
                boolean unused = AdView.this.f760i = true;
                View unused2 = AdView.this.f759h = view;
                AdView.this.removeAllViews();
                AdView.this.addView(AdView.this.f759h);
                if (AdView.this.f759h instanceof C0556a) {
                    C0537g.m1207a(AdView.this.f753b, AdView.this.f759h, AdView.this.f754c);
                }
                if (AdView.this.f757f != null) {
                    AdView.this.f757f.onAdLoaded(AdView.this);
                }
            }

            /* renamed from: a */
            public void mo5767a(C0462b bVar) {
                if (AdView.this.f757f != null) {
                    AdView.this.f757f.onError(AdView.this, bVar.mo5976b());
                }
            }

            /* renamed from: b */
            public void mo5768b() {
                if (AdView.this.f757f != null) {
                    AdView.this.f757f.onAdClicked(AdView.this);
                }
            }

            /* renamed from: c */
            public void mo5769c() {
                if (AdView.this.f758g != null) {
                    AdView.this.f758g.onLoggingImpression(AdView.this);
                }
                if ((AdView.this.f757f instanceof ImpressionListener) && AdView.this.f757f != AdView.this.f758g) {
                    ((ImpressionListener) AdView.this.f757f).onLoggingImpression(AdView.this);
                }
            }
        });
    }

    public void destroy() {
        if (this.f755d != null) {
            this.f755d.mo6017d();
            this.f755d = null;
        }
        removeAllViews();
        this.f759h = null;
    }

    public void disableAutoRefresh() {
        if (this.f755d != null) {
            this.f755d.mo6021h();
        }
    }

    public void loadAd() {
        if (!this.f756e) {
            this.f755d.mo6015b();
            this.f756e = true;
        } else if (this.f755d != null) {
            this.f755d.mo6020g();
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f759h != null) {
            C0537g.m1207a(this.f753b, this.f759h, this.f754c);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.f755d != null) {
            if (i == 0) {
                this.f755d.mo6019f();
            } else if (i == 8) {
                this.f755d.mo6018e();
            }
        }
    }

    public void setAdListener(AdListener adListener) {
        this.f757f = adListener;
    }

    @Deprecated
    public void setImpressionListener(ImpressionListener impressionListener) {
        this.f758g = impressionListener;
    }
}
