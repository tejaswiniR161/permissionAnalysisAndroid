package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.bj */
class C0330bj implements AppLovinNativeAdLoadListener {

    /* renamed from: a */
    final /* synthetic */ AppLovinNativeAdLoadListener f398a;

    /* renamed from: b */
    final /* synthetic */ C0324bd f399b;

    C0330bj(C0324bd bdVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.f399b = bdVar;
        this.f398a = appLovinNativeAdLoadListener;
    }

    public void onNativeAdsFailedToLoad(int i) {
        if (this.f398a != null) {
            this.f398a.onNativeAdsFailedToLoad(i);
        }
    }

    public void onNativeAdsLoaded(List list) {
        if (this.f398a != null) {
            this.f398a.onNativeAdsLoaded(list);
        }
    }
}
