package com.applovin.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;

/* renamed from: com.applovin.adview.j */
class C0242j implements AppLovinAdClickListener {

    /* renamed from: a */
    final /* synthetic */ AppLovinInterstitialActivity f68a;

    C0242j(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f68a = appLovinInterstitialActivity;
    }

    public void adClicked(AppLovinAd appLovinAd) {
        AppLovinAdClickListener e = this.f68a.f23b.mo5235e();
        if (e != null) {
            e.adClicked(appLovinAd);
        }
    }
}
