package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;

/* renamed from: com.applovin.impl.adview.e */
class C0271e implements AppLovinAdVideoPlaybackListener {

    /* renamed from: a */
    final /* synthetic */ AdViewControllerImpl f161a;

    C0271e(AdViewControllerImpl adViewControllerImpl) {
        this.f161a = adViewControllerImpl;
    }

    public void videoPlaybackBegan(AppLovinAd appLovinAd) {
        if (this.f161a.f106w != null) {
            this.f161a.f106w.videoPlaybackBegan(appLovinAd);
        }
    }

    public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
        if (this.f161a.f106w != null) {
            this.f161a.f106w.videoPlaybackEnded(appLovinAd, d, z);
        }
    }
}
