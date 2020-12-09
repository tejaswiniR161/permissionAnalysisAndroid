package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;

/* renamed from: com.applovin.impl.sdk.af */
class C0299af implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAd f321a;

    /* renamed from: b */
    final /* synthetic */ int f322b;

    /* renamed from: c */
    final /* synthetic */ C0298ae f323c;

    C0299af(C0298ae aeVar, AppLovinAd appLovinAd, int i) {
        this.f323c = aeVar;
        this.f321a = appLovinAd;
        this.f322b = i;
    }

    public void run() {
        this.f323c.f320f.validationRequestFailed(this.f321a, this.f322b);
    }
}
