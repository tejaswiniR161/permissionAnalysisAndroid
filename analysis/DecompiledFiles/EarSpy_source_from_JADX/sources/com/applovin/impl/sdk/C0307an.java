package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;

/* renamed from: com.applovin.impl.sdk.an */
class C0307an implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAd f343a;

    /* renamed from: b */
    final /* synthetic */ int f344b;

    /* renamed from: c */
    final /* synthetic */ C0298ae f345c;

    C0307an(C0298ae aeVar, AppLovinAd appLovinAd, int i) {
        this.f345c = aeVar;
        this.f343a = appLovinAd;
        this.f344b = i;
    }

    public void run() {
        this.f345c.f320f.validationRequestFailed(this.f343a, this.f344b);
    }
}
