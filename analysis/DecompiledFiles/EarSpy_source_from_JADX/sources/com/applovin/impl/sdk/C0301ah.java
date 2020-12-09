package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;

/* renamed from: com.applovin.impl.sdk.ah */
class C0301ah implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAd f326a;

    /* renamed from: b */
    final /* synthetic */ C0298ae f327b;

    C0301ah(C0298ae aeVar, AppLovinAd appLovinAd) {
        this.f327b = aeVar;
        this.f326a = appLovinAd;
    }

    public void run() {
        this.f327b.f318d.adClicked(this.f326a);
    }
}
