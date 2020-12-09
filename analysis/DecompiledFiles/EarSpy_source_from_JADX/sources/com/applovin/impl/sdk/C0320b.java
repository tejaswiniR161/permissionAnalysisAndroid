package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.b */
public class C0320b extends C0337bq {
    public C0320b(AppLovinSdkImpl appLovinSdkImpl) {
        super(appLovinSdkImpl);
    }

    /* renamed from: a */
    private C0345by m268a(AppLovinAdType appLovinAdType, AppLovinAdSize appLovinAdSize) {
        return appLovinAdSize.equals(AppLovinAdSize.BANNER) ? C0343bw.f503aj : appLovinAdSize.equals(AppLovinAdSize.MREC) ? C0343bw.f504ak : appLovinAdSize.equals(AppLovinAdSize.INTERSTITIAL) ? C0343bw.f505al : appLovinAdSize.equals(AppLovinAdSize.LEADER) ? C0343bw.f506am : C0343bw.f503aj;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0342bv mo5459a(C0347c cVar) {
        C0360cm cmVar = new C0360cm(cVar.mo5552a(), cVar.mo5553b(), this, this.f420a);
        cmVar.mo5624a(true);
        return cmVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0347c mo5460a(C0318ay ayVar) {
        return new C0347c((AppLovinAd) ayVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Map mo5461a() {
        HashMap hashMap = new HashMap(5);
        for (AppLovinAdSize appLovinAdSize : AppLovinAdSize.allSizes()) {
            hashMap.put(new C0347c(appLovinAdSize, AppLovinAdType.REGULAR), new C0338br(((Integer) this.f420a.mo5363a(m268a(AppLovinAdType.REGULAR, appLovinAdSize))).intValue()));
        }
        hashMap.put(new C0347c(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED), new C0338br(((Integer) this.f420a.mo5363a(C0343bw.f507an)).intValue()));
        return hashMap;
    }

    /* renamed from: a */
    public void mo5462a(C0347c cVar, int i) {
        mo5518b(cVar, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5463a(Object obj, C0318ay ayVar) {
        ((AppLovinAdLoadListener) obj).adReceived((AppLovinAd) ayVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5464a(Object obj, C0347c cVar, int i) {
        if (obj instanceof C0401w) {
            ((C0401w) obj).mo5462a(cVar, i);
        }
        if (obj instanceof AppLovinAdLoadListener) {
            ((AppLovinAdLoadListener) obj).failedToReceiveAd(i);
        }
    }

    /* renamed from: a */
    public /* bridge */ /* synthetic */ boolean mo5465a(C0347c cVar, Object obj) {
        return super.mo5465a(cVar, obj);
    }

    public void adReceived(AppLovinAd appLovinAd) {
        mo5519c((C0318ay) appLovinAd);
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
    }

    public void onNativeAdsLoaded(List list) {
    }
}
