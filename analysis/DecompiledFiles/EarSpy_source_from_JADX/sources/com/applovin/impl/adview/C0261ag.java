package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;

/* renamed from: com.applovin.impl.adview.ag */
class C0261ag implements AppLovinAdLoadListener {

    /* renamed from: a */
    final /* synthetic */ C0260af f138a;

    C0261ag(C0260af afVar) {
        this.f138a = afVar;
    }

    public void adReceived(AppLovinAd appLovinAd) {
        this.f138a.m120a(appLovinAd);
        this.f138a.showAndRender(appLovinAd);
    }

    public void failedToReceiveAd(int i) {
        this.f138a.m116a(i);
    }
}
