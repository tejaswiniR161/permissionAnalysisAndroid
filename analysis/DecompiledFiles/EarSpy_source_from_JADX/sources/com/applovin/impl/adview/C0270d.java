package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;

/* renamed from: com.applovin.impl.adview.d */
class C0270d implements AppLovinAdDisplayListener {

    /* renamed from: a */
    final /* synthetic */ AdViewControllerImpl f160a;

    C0270d(AdViewControllerImpl adViewControllerImpl) {
        this.f160a = adViewControllerImpl;
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
    }

    public void adHidden(AppLovinAd appLovinAd) {
        if (this.f160a.f105v != null) {
            this.f160a.f105v.adHidden(appLovinAd);
        }
    }
}
