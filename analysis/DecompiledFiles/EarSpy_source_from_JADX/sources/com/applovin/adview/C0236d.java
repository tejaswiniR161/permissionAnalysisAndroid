package com.applovin.adview;

/* renamed from: com.applovin.adview.d */
class C0236d implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f57a;

    /* renamed from: b */
    final /* synthetic */ int f58b;

    /* renamed from: c */
    final /* synthetic */ C0235c f59c;

    C0236d(C0235c cVar, int i, int i2) {
        this.f59c = cVar;
        this.f57a = i;
        this.f58b = i2;
    }

    public void run() {
        this.f59c.f56a.f55a.f25d.mo5666e("AppLovinInterstitialActivity", "Media player error (" + this.f57a + "," + this.f58b + ") - showing close button.");
        this.f59c.f56a.f55a.m52f();
    }
}
