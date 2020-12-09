package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;

/* renamed from: com.applovin.impl.sdk.ac */
class C0296ac implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAd f311a;

    /* renamed from: b */
    final /* synthetic */ C0295ab f312b;

    C0296ac(C0295ab abVar, AppLovinAd appLovinAd) {
        this.f312b = abVar;
        this.f311a = appLovinAd;
    }

    public void run() {
        this.f312b.f310b.adReceived(this.f311a);
    }
}
