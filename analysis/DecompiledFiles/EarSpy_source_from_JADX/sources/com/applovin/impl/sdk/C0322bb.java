package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAd;
import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.sdk.AppLovinAd;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.bb */
public class C0322bb extends C0337bq {
    public C0322bb(AppLovinSdkImpl appLovinSdkImpl) {
        super(appLovinSdkImpl);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0342bv mo5459a(C0347c cVar) {
        C0362co coVar = new C0362co(this.f420a, 1, this);
        coVar.mo5624a(true);
        return coVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0347c mo5460a(C0318ay ayVar) {
        return NativeAdImpl.SPEC_NATIVE;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Map mo5461a() {
        HashMap hashMap = new HashMap(1);
        hashMap.put(NativeAdImpl.SPEC_NATIVE, new C0338br(((Integer) this.f420a.mo5363a(C0343bw.f485aR)).intValue()));
        return hashMap;
    }

    /* renamed from: a */
    public void mo5462a(C0347c cVar, int i) {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5463a(Object obj, C0318ay ayVar) {
        AppLovinNativeAdLoadListener appLovinNativeAdLoadListener = (AppLovinNativeAdLoadListener) obj;
        appLovinNativeAdLoadListener.onNativeAdsLoaded(Arrays.asList(new AppLovinNativeAd[]{(AppLovinNativeAd) ayVar}));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5464a(Object obj, C0347c cVar, int i) {
        ((AppLovinNativeAdLoadListener) obj).onNativeAdsFailedToLoad(i);
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo5465a(C0347c cVar, Object obj) {
        return super.mo5465a(cVar, obj);
    }

    public void adReceived(AppLovinAd appLovinAd) {
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ C0318ay mo5466b(C0347c cVar) {
        return super.mo5466b(cVar);
    }

    /* renamed from: b */
    public /* bridge */ /* synthetic */ void mo5467b(C0347c cVar, Object obj) {
        super.mo5467b(cVar, obj);
    }

    /* renamed from: c */
    public /* bridge */ /* synthetic */ boolean mo5468c(C0347c cVar) {
        return super.mo5468c(cVar);
    }

    /* renamed from: d */
    public /* bridge */ /* synthetic */ void mo5469d(C0347c cVar) {
        super.mo5469d(cVar);
    }

    /* renamed from: e */
    public /* bridge */ /* synthetic */ boolean mo5470e(C0347c cVar) {
        return super.mo5470e(cVar);
    }

    /* renamed from: f */
    public /* bridge */ /* synthetic */ void mo5471f(C0347c cVar) {
        super.mo5471f(cVar);
    }

    public void failedToReceiveAd(int i) {
    }

    public void onNativeAdsFailedToLoad(int i) {
        mo5518b(NativeAdImpl.SPEC_NATIVE, i);
    }

    public void onNativeAdsLoaded(List list) {
        this.f420a.getNativeAdService().precacheResources((AppLovinNativeAd) list.get(0), new C0323bc(this));
    }
}
