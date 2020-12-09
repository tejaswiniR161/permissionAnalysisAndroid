package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.bi */
class C0329bi implements AppLovinNativeAdLoadListener {

    /* renamed from: a */
    final /* synthetic */ C0328bh f397a;

    C0329bi(C0328bh bhVar) {
        this.f397a = bhVar;
    }

    public void onNativeAdsFailedToLoad(int i) {
        if (this.f397a.f394b != null) {
            this.f397a.f394b.onNativeAdsFailedToLoad(i);
        }
    }

    public void onNativeAdsLoaded(List list) {
        if (this.f397a.f394b != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(this.f397a.f393a);
            arrayList.addAll(this.f397a.f395c);
            this.f397a.f394b.onNativeAdsLoaded(arrayList);
        }
    }
}
