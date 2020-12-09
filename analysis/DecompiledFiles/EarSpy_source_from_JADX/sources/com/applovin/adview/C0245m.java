package com.applovin.adview;

/* renamed from: com.applovin.adview.m */
class C0245m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f71a;

    /* renamed from: b */
    final /* synthetic */ int f72b;

    /* renamed from: c */
    final /* synthetic */ C0244l f73c;

    C0245m(C0244l lVar, int i, int i2) {
        this.f73c = lVar;
        this.f71a = i;
        this.f72b = i2;
    }

    public void run() {
        this.f73c.f70a.f25d.mo5666e("AppLovinInterstitialActivity", "Video view error (" + this.f71a + "," + this.f72b + ") - showing close button.");
        this.f73c.f70a.m52f();
    }
}
