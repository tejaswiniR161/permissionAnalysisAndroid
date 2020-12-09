package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.bh */
class C0328bh implements AppLovinNativeAdLoadListener {

    /* renamed from: a */
    final /* synthetic */ List f393a;

    /* renamed from: b */
    final /* synthetic */ AppLovinNativeAdLoadListener f394b;

    /* renamed from: c */
    final /* synthetic */ List f395c;

    /* renamed from: d */
    final /* synthetic */ C0324bd f396d;

    C0328bh(C0324bd bdVar, List list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, List list2) {
        this.f396d = bdVar;
        this.f393a = list;
        this.f394b = appLovinNativeAdLoadListener;
        this.f395c = list2;
    }

    public void onNativeAdsFailedToLoad(int i) {
        if (this.f394b != null) {
            this.f394b.onNativeAdsFailedToLoad(i);
        }
    }

    public void onNativeAdsLoaded(List list) {
        this.f396d.m328c(this.f393a, new C0329bi(this));
    }
}
