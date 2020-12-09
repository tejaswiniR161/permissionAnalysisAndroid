package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;

/* renamed from: com.applovin.impl.adview.c */
class C0269c implements AppLovinAdClickListener {

    /* renamed from: a */
    final /* synthetic */ AdViewControllerImpl f159a;

    C0269c(AdViewControllerImpl adViewControllerImpl) {
        this.f159a = adViewControllerImpl;
    }

    public void adClicked(AppLovinAd appLovinAd) {
        if (this.f159a.f107x != null) {
            this.f159a.f107x.adClicked(appLovinAd);
        }
    }
}
