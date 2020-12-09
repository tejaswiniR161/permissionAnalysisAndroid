package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;

/* renamed from: com.applovin.impl.sdk.bg */
class C0327bg implements AppLovinNativeAdPrecacheListener {

    /* renamed from: a */
    final /* synthetic */ AppLovinNativeAdPrecacheListener f391a;

    /* renamed from: b */
    final /* synthetic */ C0324bd f392b;

    C0327bg(C0324bd bdVar, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        this.f392b = bdVar;
        this.f391a = appLovinNativeAdPrecacheListener;
    }

    public void onNativeAdImagePrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
    }

    public void onNativeAdImagesPrecached(AppLovinNativeAd appLovinNativeAd) {
    }

    public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
        this.f392b.m325a(this.f391a, appLovinNativeAd, i, true);
    }

    public void onNativeAdVideoPreceached(AppLovinNativeAd appLovinNativeAd) {
        this.f392b.m326a(this.f391a, appLovinNativeAd, true);
    }
}
