package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.nativeAds.AppLovinNativeAdPrecacheListener;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.cg */
abstract class C0354cg extends C0342bv {

    /* renamed from: a */
    protected AppLovinNativeAdLoadListener f585a;

    /* renamed from: b */
    protected AppLovinNativeAdPrecacheListener f586b;

    /* renamed from: c */
    private List f587c;

    /* renamed from: d */
    private int f588d = 0;

    C0354cg(String str, AppLovinSdkImpl appLovinSdkImpl, List list, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super(str, appLovinSdkImpl);
        this.f585a = appLovinNativeAdLoadListener;
        this.f587c = list;
    }

    C0354cg(String str, AppLovinSdkImpl appLovinSdkImpl, List list, AppLovinNativeAdPrecacheListener appLovinNativeAdPrecacheListener) {
        super(str, appLovinSdkImpl);
        if (list == null) {
            throw new IllegalArgumentException("Slots cannot be null");
        }
        this.f587c = list;
        this.f586b = appLovinNativeAdPrecacheListener;
    }

    /* renamed from: a */
    private void m464a(int i) {
        if (this.f585a != null) {
            this.f585a.onNativeAdsFailedToLoad(i);
        }
    }

    /* renamed from: a */
    private void m465a(List list) {
        if (this.f585a != null) {
            this.f585a.onNativeAdsLoaded(list);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo5613a(String str, C0403y yVar) {
        try {
            String a = yVar.mo5697a(this.f440h, str, true);
            if (a != null) {
                return a;
            }
            this.f439g.mo5671w(mo5537a(), "Unable to cache icon resource " + str);
            return null;
        } catch (Exception e) {
            this.f439g.mo5672w(mo5537a(), "Unable to cache icon resource " + str, e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo5609a(NativeAdImpl nativeAdImpl);

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract boolean mo5611a(NativeAdImpl nativeAdImpl, C0403y yVar);

    public void run() {
        for (NativeAdImpl nativeAdImpl : this.f587c) {
            C0403y fileManager = this.f438f.getFileManager();
            this.f438f.getLogger().mo5665d(mo5537a(), "Beginning resource caching phase...");
            if (mo5611a(nativeAdImpl, fileManager)) {
                this.f588d++;
                mo5609a(nativeAdImpl);
            } else {
                this.f438f.getLogger().mo5666e(mo5537a(), "Unable to cache resources");
            }
        }
        try {
            if (this.f588d == this.f587c.size()) {
                m465a(this.f587c);
            } else if (((Boolean) this.f438f.mo5363a(C0343bw.f481aN)).booleanValue()) {
                this.f438f.getLogger().mo5666e(mo5537a(), "Mismatch between successful populations and requested size");
                m464a(-6);
            } else {
                m465a(this.f587c);
            }
        } catch (Throwable th) {
            this.f438f.getLogger().userError(mo5537a(), "Encountered exception while notifying publisher code", th);
        }
    }
}
