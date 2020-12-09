package com.applovin.adview;

import com.applovin.impl.sdk.AppLovinAdImpl;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;

/* renamed from: com.applovin.adview.i */
class C0241i implements AppLovinAdDisplayListener {

    /* renamed from: a */
    final /* synthetic */ AppLovinInterstitialActivity f67a;

    C0241i(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f67a = appLovinInterstitialActivity;
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
        AppLovinAdImpl unused = this.f67a.f28g = (AppLovinAdImpl) appLovinAd;
        if (!this.f67a.f30i) {
            this.f67a.m30a(appLovinAd);
        }
    }

    public void adHidden(AppLovinAd appLovinAd) {
        this.f67a.m40b(appLovinAd);
    }
}
