package com.applovin.impl.adview;

import com.applovin.impl.sdk.AppLovinAdImpl;
import com.applovin.sdk.AppLovinAd;

/* renamed from: com.applovin.impl.adview.ab */
class C0256ab implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAd f118a;

    /* renamed from: b */
    final /* synthetic */ C0290x f119b;

    C0256ab(C0290x xVar, AppLovinAd appLovinAd) {
        this.f119b = xVar;
        this.f118a = appLovinAd;
    }

    public void run() {
        this.f119b.f217e.renderAd(this.f118a);
        this.f119b.m186a(((AppLovinAdImpl) this.f118a).getCloseStyle());
    }
}
