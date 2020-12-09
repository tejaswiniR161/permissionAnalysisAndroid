package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.al */
class C0305al implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAd f337a;

    /* renamed from: b */
    final /* synthetic */ Map f338b;

    /* renamed from: c */
    final /* synthetic */ C0298ae f339c;

    C0305al(C0298ae aeVar, AppLovinAd appLovinAd, Map map) {
        this.f339c = aeVar;
        this.f337a = appLovinAd;
        this.f338b = map;
    }

    public void run() {
        this.f339c.f320f.userOverQuota(this.f337a, this.f338b);
    }
}
