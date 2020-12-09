package com.applovin.adview;

import java.util.UUID;

/* renamed from: com.applovin.adview.h */
class C0240h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f64a;

    /* renamed from: b */
    final /* synthetic */ UUID f65b;

    /* renamed from: c */
    final /* synthetic */ AppLovinInterstitialActivity f66c;

    C0240h(AppLovinInterstitialActivity appLovinInterstitialActivity, int i, UUID uuid) {
        this.f66c = appLovinInterstitialActivity;
        this.f64a = i;
        this.f65b = uuid;
    }

    public void run() {
        this.f66c.m26a(this.f64a, this.f65b);
    }
}
