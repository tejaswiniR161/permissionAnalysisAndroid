package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.ch */
public class C0355ch extends C0354cg {
    public C0355ch(AppLovinSdkImpl appLovinSdkImpl, List list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super("TaskCacheNativeAdVideos", appLovinSdkImpl, list, appLovinNativeAdLoadListener);
    }

    public C0355ch(AppLovinSdkImpl appLovinSdkImpl, List list, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        super("TaskCacheNativeAdVideos", appLovinSdkImpl, list, appLovinNativeAdPrecacheListener);
    }

    /* renamed from: b */
    private boolean m469b(NativeAdImpl nativeAdImpl) {
        this.f439g.mo5671w("TaskCacheNativeAdVideos", "Unable to cache video resource " + nativeAdImpl.getSourceVideoUrl());
        mo5614a(nativeAdImpl, (int) AppLovinErrorCodes.UNABLE_TO_PRECACHE_VIDEO_RESOURCES);
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5609a(NativeAdImpl nativeAdImpl) {
        if (this.f586b != null) {
            this.f586b.onNativeAdVideoPreceached(nativeAdImpl);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5614a(NativeAdImpl nativeAdImpl, int i) {
        if (this.f586b != null) {
            this.f586b.onNativeAdVideoPrecachingFailed(nativeAdImpl, i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo5611a(NativeAdImpl nativeAdImpl, C0403y yVar) {
        if (!AppLovinSdkUtils.isValidString(nativeAdImpl.getSourceVideoUrl())) {
            this.f438f.getLogger().mo5665d("TaskCacheNativeAdVideos", "No video attached to ad, nothing to cache...");
        }
        this.f438f.getLogger().mo5665d("TaskCacheNativeAdVideos", "Beginning slot video caching for ad " + nativeAdImpl.getAdId());
        String a = mo5613a(nativeAdImpl.getSourceVideoUrl(), yVar);
        if (a == null) {
            return m469b(nativeAdImpl);
        }
        nativeAdImpl.setVideoUrl(a);
        return true;
    }

    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }
}
