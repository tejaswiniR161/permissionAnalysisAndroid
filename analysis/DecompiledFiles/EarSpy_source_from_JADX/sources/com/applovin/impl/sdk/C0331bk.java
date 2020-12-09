package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.bk */
class C0331bk implements AppLovinNativeAdLoadListener {

    /* renamed from: a */
    final /* synthetic */ AppLovinNativeAdLoadListener f400a;

    /* renamed from: b */
    final /* synthetic */ C0324bd f401b;

    C0331bk(C0324bd bdVar, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.f401b = bdVar;
        this.f400a = appLovinNativeAdLoadListener;
    }

    public void onNativeAdsFailedToLoad(int i) {
        this.f401b.m323a(this.f400a, i);
    }

    public void onNativeAdsLoaded(List list) {
        this.f401b.m324a(this.f400a, list);
    }
}
