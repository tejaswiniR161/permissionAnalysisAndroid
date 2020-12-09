package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import com.applovin.nativeAds.AppLovinNativeAdService;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.bd */
class C0324bd implements AppLovinNativeAdService {

    /* renamed from: a */
    private final AppLovinSdkImpl f385a;

    /* renamed from: b */
    private final Object f386b = new Object();

    C0324bd(AppLovinSdkImpl appLovinSdkImpl) {
        this.f385a = appLovinSdkImpl;
    }

    /* renamed from: a */
    private List m315a(AppLovinNativeAd appLovinNativeAd) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add((NativeAdImpl) appLovinNativeAd);
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m322a(AppLovinNativeAd appLovinNativeAd, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        if (appLovinNativeAd.isVideoPrecached()) {
            appLovinNativeAdPrecacheListener.onNativeAdVideoPreceached(appLovinNativeAd);
            return;
        }
        this.f385a.mo5362a().mo5636a((C0342bv) new C0355ch(this.f385a, m315a(appLovinNativeAd), (AppLovinNativeAdPrecacheListener) new C0327bg(this, appLovinNativeAdPrecacheListener)), C0365cr.MAIN);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m323a(AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, int i) {
        if (appLovinNativeAdLoadListener != null) {
            try {
                appLovinNativeAdLoadListener.onNativeAdsFailedToLoad(i);
            } catch (Exception e) {
                this.f385a.getLogger().userError("WidgetServiceImpl", "Encountered exception whilst notifying user callback", e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m324a(AppLovinNativeAdLoadListener appLovinNativeAdLoadListener, List list) {
        if (appLovinNativeAdLoadListener != null) {
            try {
                appLovinNativeAdLoadListener.onNativeAdsLoaded(list);
            } catch (Exception e) {
                this.f385a.getLogger().userError("WidgetServiceImpl", "Encountered exception whilst notifying user callback", e);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m325a(AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener, AppLovinNativeAd appLovinNativeAd, int i, boolean z) {
        if (appLovinNativeAdPrecacheListener == null) {
            return;
        }
        if (z) {
            try {
                appLovinNativeAdPrecacheListener.onNativeAdVideoPrecachingFailed(appLovinNativeAd, i);
            } catch (Exception e) {
                this.f385a.getLogger().userError("WidgetServiceImpl", "Encountered exception whilst notifying user callback", e);
            }
        } else {
            appLovinNativeAdPrecacheListener.onNativeAdImagePrecachingFailed(appLovinNativeAd, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m326a(AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener, AppLovinNativeAd appLovinNativeAd, boolean z) {
        if (appLovinNativeAdPrecacheListener == null) {
            return;
        }
        if (z) {
            try {
                appLovinNativeAdPrecacheListener.onNativeAdVideoPreceached(appLovinNativeAd);
            } catch (Exception e) {
                this.f385a.getLogger().userError("WidgetServiceImpl", "Encountered exception whilst notifying user callback", e);
            }
        } else {
            appLovinNativeAdPrecacheListener.onNativeAdImagesPrecached(appLovinNativeAd);
        }
    }

    /* renamed from: b */
    private void m327b(List list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.f385a.mo5362a().mo5636a((C0342bv) new C0353cf(this.f385a, list, (AppLovinNativeAdLoadListener) new C0330bj(this, appLovinNativeAdLoadListener)), C0365cr.MAIN);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m328c(List list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        this.f385a.mo5362a().mo5636a((C0342bv) new C0355ch(this.f385a, list, (AppLovinNativeAdLoadListener) new C0331bk(this, appLovinNativeAdLoadListener)), C0365cr.MAIN);
    }

    /* renamed from: a */
    public void mo5498a(List list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        int intValue = ((Integer) this.f385a.mo5363a(C0343bw.f492aY)).intValue();
        if (intValue > 0) {
            List list2 = list;
            int size = list2.size();
            if (size != 0) {
                int min = Math.min(intValue, size);
                List subList = list2.subList(0, min);
                m327b(subList, new C0328bh(this, subList, appLovinNativeAdLoadListener, list2.subList(min, size)));
            } else if (appLovinNativeAdLoadListener != null) {
                appLovinNativeAdLoadListener.onNativeAdsFailedToLoad(AppLovinErrorCodes.UNABLE_TO_PREPARE_NATIVE_AD);
            }
        } else if (appLovinNativeAdLoadListener != null) {
            appLovinNativeAdLoadListener.onNativeAdsLoaded(list);
        }
    }

    public void loadNativeAds(int i, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        AppLovinNativeAd appLovinNativeAd = null;
        synchronized (this.f386b) {
            if (i == 1) {
                if (this.f385a.mo5368d().mo5470e(NativeAdImpl.SPEC_NATIVE)) {
                    appLovinNativeAd = (AppLovinNativeAd) this.f385a.mo5368d().mo5466b(NativeAdImpl.SPEC_NATIVE);
                }
            }
        }
        if (appLovinNativeAd != null) {
            m324a(appLovinNativeAdLoadListener, Arrays.asList(new AppLovinNativeAd[]{appLovinNativeAd}));
            return;
        }
        this.f385a.mo5362a().mo5636a((C0342bv) new C0362co(this.f385a, i, new C0325be(this, appLovinNativeAdLoadListener)), C0365cr.MAIN);
    }

    public void precacheResources(AppLovinNativeAd appLovinNativeAd, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        if (appLovinNativeAd.isImagePrecached()) {
            appLovinNativeAdPrecacheListener.onNativeAdImagesPrecached(appLovinNativeAd);
            m322a(appLovinNativeAd, appLovinNativeAdPrecacheListener);
            return;
        }
        this.f385a.mo5362a().mo5636a((C0342bv) new C0353cf(this.f385a, m315a(appLovinNativeAd), (AppLovinNativeAdPrecacheListener) new C0326bf(this, appLovinNativeAdPrecacheListener)), C0365cr.MAIN);
    }
}
