package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.cf */
public class C0353cf extends C0354cg {
    public C0353cf(AppLovinSdkImpl appLovinSdkImpl, List list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super("TaskCacheNativeAdImages", appLovinSdkImpl, list, appLovinNativeAdLoadListener);
    }

    public C0353cf(AppLovinSdkImpl appLovinSdkImpl, List list, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        super("TaskCacheNativeAdImages", appLovinSdkImpl, list, appLovinNativeAdPrecacheListener);
    }

    /* renamed from: b */
    private boolean m460b(NativeAdImpl nativeAdImpl) {
        mo5610a(nativeAdImpl, (int) AppLovinErrorCodes.UNABLE_TO_PRECACHE_IMAGE_RESOURCES);
        return false;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5609a(NativeAdImpl nativeAdImpl) {
        if (this.f586b != null) {
            this.f586b.onNativeAdImagesPrecached(nativeAdImpl);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5610a(NativeAdImpl nativeAdImpl, int i) {
        if (this.f586b != null) {
            this.f586b.onNativeAdImagePrecachingFailed(nativeAdImpl, i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo5611a(NativeAdImpl nativeAdImpl, C0403y yVar) {
        this.f438f.getLogger().mo5665d("TaskCacheNativeAdImages", "Beginning slot image caching for ad " + nativeAdImpl.getAdId());
        String a = mo5613a(nativeAdImpl.getSourceIconUrl(), yVar);
        if (a == null) {
            return m460b(nativeAdImpl);
        }
        nativeAdImpl.setIconUrl(a);
        String a2 = mo5613a(nativeAdImpl.getSourceImageUrl(), yVar);
        if (a2 == null) {
            return m460b(nativeAdImpl);
        }
        nativeAdImpl.setImageUrl(a2);
        return true;
    }

    public /* bridge */ /* synthetic */ void run() {
        super.run();
    }
}
