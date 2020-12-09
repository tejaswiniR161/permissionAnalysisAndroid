package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;

/* renamed from: com.applovin.impl.sdk.aj */
class C0303aj implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAd f330a;

    /* renamed from: b */
    final /* synthetic */ double f331b;

    /* renamed from: c */
    final /* synthetic */ boolean f332c;

    /* renamed from: d */
    final /* synthetic */ C0298ae f333d;

    C0303aj(C0298ae aeVar, AppLovinAd appLovinAd, double d, boolean z) {
        this.f333d = aeVar;
        this.f330a = appLovinAd;
        this.f331b = d;
        this.f332c = z;
    }

    public void run() {
        this.f333d.f319e.videoPlaybackEnded(this.f330a, this.f331b, this.f332c);
    }
}
