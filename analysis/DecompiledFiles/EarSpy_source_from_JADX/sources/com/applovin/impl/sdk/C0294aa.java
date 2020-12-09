package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdRewardListener;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.aa */
class C0294aa implements AppLovinAdRewardListener {

    /* renamed from: a */
    final /* synthetic */ C0404z f308a;

    C0294aa(C0404z zVar) {
        this.f308a = zVar;
    }

    public void userDeclinedToViewAd(AppLovinAd appLovinAd) {
        this.f308a.f706a.getLogger().mo5665d("IncentivizedAdController", "User declined to view");
    }

    public void userOverQuota(AppLovinAd appLovinAd, Map map) {
        this.f308a.f706a.getLogger().mo5665d("IncentivizedAdController", "User over quota: " + map);
    }

    public void userRewardRejected(AppLovinAd appLovinAd, Map map) {
        this.f308a.f706a.getLogger().mo5665d("IncentivizedAdController", "Reward rejected: " + map);
    }

    public void userRewardVerified(AppLovinAd appLovinAd, Map map) {
        this.f308a.f706a.getLogger().mo5665d("IncentivizedAdController", "Reward validated: " + map);
    }

    public void validationRequestFailed(AppLovinAd appLovinAd, int i) {
        this.f308a.f706a.getLogger().mo5665d("IncentivizedAdController", "Reward validation failed: " + i);
    }
}
