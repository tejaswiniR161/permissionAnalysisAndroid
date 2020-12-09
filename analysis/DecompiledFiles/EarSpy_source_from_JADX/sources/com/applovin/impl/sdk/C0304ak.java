package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.ak */
class C0304ak implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAd f334a;

    /* renamed from: b */
    final /* synthetic */ Map f335b;

    /* renamed from: c */
    final /* synthetic */ C0298ae f336c;

    C0304ak(C0298ae aeVar, AppLovinAd appLovinAd, Map map) {
        this.f336c = aeVar;
        this.f334a = appLovinAd;
        this.f335b = map;
    }

    public void run() {
        this.f336c.f320f.userRewardVerified(this.f334a, this.f335b);
    }
}
