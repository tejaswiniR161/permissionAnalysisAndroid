package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;

/* renamed from: com.applovin.impl.adview.ai */
class C0263ai implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAd f142a;

    /* renamed from: b */
    final /* synthetic */ C0260af f143b;

    C0263ai(C0260af afVar, AppLovinAd appLovinAd) {
        this.f143b = afVar;
        this.f142a = appLovinAd;
    }

    public void run() {
        if (this.f143b.f131g != null) {
            this.f143b.f131g.adReceived(this.f142a);
        }
    }
}
