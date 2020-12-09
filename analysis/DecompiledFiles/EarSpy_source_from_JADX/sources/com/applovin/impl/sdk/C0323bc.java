package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.sdk.bc */
class C0323bc implements AppLovinNativeAdPrecacheListener {

    /* renamed from: a */
    final /* synthetic */ C0322bb f384a;

    C0323bc(C0322bb bbVar) {
        this.f384a = bbVar;
    }

    public void onNativeAdImagePrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
        this.f384a.mo5518b(NativeAdImpl.SPEC_NATIVE, i);
    }

    public void onNativeAdImagesPrecached(AppLovinNativeAd appLovinNativeAd) {
        if (!AppLovinSdkUtils.isValidString(appLovinNativeAd.getVideoUrl())) {
            this.f384a.mo5519c((C0318ay) appLovinNativeAd);
        }
    }

    public void onNativeAdVideoPrecachingFailed(AppLovinNativeAd appLovinNativeAd, int i) {
        this.f384a.f421b.mo5671w("NativeAdPreloadManager", "Video failed to cache during native ad preload. " + i);
        this.f384a.mo5519c((C0318ay) appLovinNativeAd);
    }

    public void onNativeAdVideoPreceached(AppLovinNativeAd appLovinNativeAd) {
        this.f384a.mo5519c((C0318ay) appLovinNativeAd);
    }
}
