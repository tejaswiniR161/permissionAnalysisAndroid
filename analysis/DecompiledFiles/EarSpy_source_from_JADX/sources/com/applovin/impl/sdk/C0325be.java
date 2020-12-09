package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.be */
class C0325be implements AppLovinNativeAdLoadListener {

    /* renamed from: a */
    final /* synthetic */ AppLovinNativeAdLoadListener f387a;

    /* renamed from: b */
    final /* synthetic */ C0324bd f388b;

    C0325be(C0324bd bdVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.f388b = bdVar;
        this.f387a = appLovinNativeAdLoadListener;
    }

    public void onNativeAdsFailedToLoad(int i) {
        this.f388b.m323a(this.f387a, i);
    }

    public void onNativeAdsLoaded(List list) {
        this.f388b.mo5498a(list, this.f387a);
    }
}
