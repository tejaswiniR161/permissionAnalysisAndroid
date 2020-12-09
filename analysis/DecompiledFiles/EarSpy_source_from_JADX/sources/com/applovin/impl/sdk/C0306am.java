package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.am */
class C0306am implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAd f340a;

    /* renamed from: b */
    final /* synthetic */ Map f341b;

    /* renamed from: c */
    final /* synthetic */ C0298ae f342c;

    C0306am(C0298ae aeVar, AppLovinAd appLovinAd, Map map) {
        this.f342c = aeVar;
        this.f340a = appLovinAd;
        this.f341b = map;
    }

    public void run() {
        this.f342c.f320f.userRewardRejected(this.f340a, this.f341b);
    }
}
