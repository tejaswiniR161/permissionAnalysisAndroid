package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;

/* renamed from: com.applovin.impl.sdk.bf */
class C0326bf implements AppLovinNativeAdPrecacheListener {

    /* renamed from: a */
    final /* synthetic */ AppLovinNativeAdPrecacheListener f389a;

    /* renamed from: b */
    final /* synthetic */ C0324bd f390b;

    C0326bf(C0324bd bdVar, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        this.f390b = bdVar;
        this.f389a = appLovinNativeAdPrecacheListener;
    }

    public void onNativeAdImagePrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
        this.f390b.m325a(this.f389a, appLovinNativeAd, i, false);
    }

    public void onNativeAdImagesPrecached(AppLovinNativeAd appLovinNativeAd) {
        this.f390b.m326a(this.f389a, appLovinNativeAd, false);
        this.f390b.m322a(appLovinNativeAd, this.f389a);
    }

    public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
    }

    public void onNativeAdVideoPreceached(AppLovinNativeAd appLovinNativeAd) {
    }
}
