package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.co */
class C0362co extends C0360cm {

    /* renamed from: a */
    private int f602a;

    /* renamed from: b */
    private final AppLovinNativeAdLoadListener f603b;

    public C0362co(AppLovinSdkImpl appLovinSdkImpl, int i, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super(NativeAdImpl.SIZE_NATIVE, NativeAdImpl.TYPE_NATIVE, (AppLovinAdLoadListener) null, appLovinSdkImpl);
        this.f603b = appLovinNativeAdLoadListener;
        this.f602a = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0342bv mo5621a(JSONObject jSONObject) {
        return new C0370cw(jSONObject, this.f438f, this.f603b);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5622a(int i) {
        if (this.f603b != null) {
            this.f603b.onNativeAdsFailedToLoad(i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5625b(Map map) {
        map.put("slot_count", Integer.toString(this.f602a));
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo5627c(Map map) {
        C0378dd a = C0376db.m561a().mo5651a("tFNW");
        if (a != null) {
            map.put("etfw", Long.toString(a.mo5654b()));
            map.put("ntfw", a.mo5653a());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo5628d() {
        return C0395q.m635b("nad", this.f438f);
    }

    /* renamed from: e */
    public String mo5629e() {
        return "tFNW";
    }
}
