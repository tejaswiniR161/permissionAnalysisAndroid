package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;

/* renamed from: com.applovin.impl.sdk.ab */
class C0295ab implements AppLovinAdLoadListener {

    /* renamed from: a */
    final /* synthetic */ C0404z f309a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final AppLovinAdLoadListener f310b;

    C0295ab(C0404z zVar, AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f309a = zVar;
        this.f310b = appLovinAdLoadListener;
    }

    public void adReceived(AppLovinAd appLovinAd) {
        AppLovinAdImpl unused = this.f309a.f708c = (AppLovinAdImpl) appLovinAd;
        if (this.f310b != null) {
            this.f309a.f710e.post(new C0296ac(this, appLovinAd));
        }
    }

    public void failedToReceiveAd(int i) {
        if (this.f310b != null) {
            this.f309a.f710e.post(new C0297ad(this, i));
        }
    }
}
