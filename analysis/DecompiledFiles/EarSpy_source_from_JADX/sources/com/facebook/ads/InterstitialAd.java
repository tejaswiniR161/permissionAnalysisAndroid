package com.facebook.ads;

import android.content.Context;
import android.view.View;
import com.facebook.ads.internal.C0433a;
import com.facebook.ads.internal.C0462b;
import com.facebook.ads.internal.C0463c;
import com.facebook.ads.internal.C0480h;
import com.facebook.ads.internal.util.C0537g;

public class InterstitialAd implements C0405Ad {

    /* renamed from: a */
    private static final C0463c f762a = C0463c.ADS;

    /* renamed from: b */
    private final Context f763b;

    /* renamed from: c */
    private final String f764c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C0480h f765d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f766e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f767f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public InterstitialAdListener f768g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ImpressionListener f769h;

    public InterstitialAd(Context context, String str) {
        this.f763b = context;
        this.f764c = str;
    }

    public void destroy() {
        if (this.f765d != null) {
            this.f765d.mo6017d();
            this.f765d = null;
        }
    }

    public boolean isAdLoaded() {
        return this.f766e;
    }

    public void loadAd() {
        this.f766e = false;
        if (this.f767f) {
            throw new IllegalStateException("InterstitialAd cannot be loaded while being displayed. Make sure your adapter calls adapterListener.onInterstitialDismissed().");
        }
        if (this.f765d != null) {
            this.f765d.mo6017d();
            this.f765d = null;
        }
        AdSize adSize = AdSize.INTERSTITIAL;
        this.f765d = new C0480h(this.f763b, this.f764c, C0537g.m1197a(AdSize.INTERSTITIAL), adSize, f762a, 1, true);
        this.f765d.mo6012a((C0433a) new C0433a() {
            /* renamed from: a */
            public void mo5765a() {
                boolean unused = InterstitialAd.this.f766e = true;
                if (InterstitialAd.this.f768g != null) {
                    InterstitialAd.this.f768g.onAdLoaded(InterstitialAd.this);
                }
            }

            /* renamed from: a */
            public void mo5766a(View view) {
            }

            /* renamed from: a */
            public void mo5767a(C0462b bVar) {
                if (InterstitialAd.this.f768g != null) {
                    InterstitialAd.this.f768g.onError(InterstitialAd.this, bVar.mo5976b());
                }
            }

            /* renamed from: b */
            public void mo5768b() {
                if (InterstitialAd.this.f768g != null) {
                    InterstitialAd.this.f768g.onAdClicked(InterstitialAd.this);
                }
            }

            /* renamed from: c */
            public void mo5769c() {
                if (InterstitialAd.this.f769h != null) {
                    InterstitialAd.this.f769h.onLoggingImpression(InterstitialAd.this);
                }
                if ((InterstitialAd.this.f768g instanceof ImpressionListener) && InterstitialAd.this.f768g != InterstitialAd.this.f769h) {
                    ((ImpressionListener) InterstitialAd.this.f768g).onLoggingImpression(InterstitialAd.this);
                }
            }

            /* renamed from: d */
            public void mo5774d() {
                if (InterstitialAd.this.f768g != null) {
                    InterstitialAd.this.f768g.onInterstitialDisplayed(InterstitialAd.this);
                }
            }

            /* renamed from: e */
            public void mo5775e() {
                boolean unused = InterstitialAd.this.f767f = false;
                if (InterstitialAd.this.f765d != null) {
                    InterstitialAd.this.f765d.mo6017d();
                    C0480h unused2 = InterstitialAd.this.f765d = null;
                }
                if (InterstitialAd.this.f768g != null) {
                    InterstitialAd.this.f768g.onInterstitialDismissed(InterstitialAd.this);
                }
            }
        });
        this.f765d.mo6015b();
    }

    public void setAdListener(InterstitialAdListener interstitialAdListener) {
        this.f768g = interstitialAdListener;
    }

    @Deprecated
    public void setImpressionListener(ImpressionListener impressionListener) {
        this.f769h = impressionListener;
    }

    public boolean show() {
        if (this.f766e) {
            this.f765d.mo6016c();
            this.f767f = true;
            this.f766e = false;
            return true;
        } else if (this.f768g == null) {
            return false;
        } else {
            this.f768g.onError(this, AdError.INTERNAL_ERROR);
            return false;
        }
    }
}
