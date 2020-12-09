package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;

/* renamed from: com.applovin.impl.sdk.ai */
class C0302ai implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAd f328a;

    /* renamed from: b */
    final /* synthetic */ C0298ae f329b;

    C0302ai(C0298ae aeVar, AppLovinAd appLovinAd) {
        this.f329b = aeVar;
        this.f328a = appLovinAd;
    }

    public void run() {
        this.f329b.f319e.videoPlaybackBegan(this.f328a);
    }
}
