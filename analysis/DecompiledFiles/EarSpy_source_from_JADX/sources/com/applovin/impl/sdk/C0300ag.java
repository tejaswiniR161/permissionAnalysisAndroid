package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;

/* renamed from: com.applovin.impl.sdk.ag */
class C0300ag implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAd f324a;

    /* renamed from: b */
    final /* synthetic */ C0298ae f325b;

    C0300ag(C0298ae aeVar, AppLovinAd appLovinAd) {
        this.f325b = aeVar;
        this.f324a = appLovinAd;
    }

    public void run() {
        this.f325b.f317c.adHidden(this.f324a);
    }
}
