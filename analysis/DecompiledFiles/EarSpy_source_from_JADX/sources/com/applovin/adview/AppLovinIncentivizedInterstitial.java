package com.applovin.adview;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import com.applovin.impl.sdk.C0404z;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;

public class AppLovinIncentivizedInterstitial {

    /* renamed from: a */
    private C0404z f16a;

    public AppLovinIncentivizedInterstitial(Context context) {
        this(AppLovinSdk.getInstance(context));
    }

    public AppLovinIncentivizedInterstitial(AppLovinSdk appLovinSdk) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("SDK cannot be null");
        }
        this.f16a = new C0404z(appLovinSdk);
    }

    public static AppLovinIncentivizedInterstitial create(Context context) {
        return create(AppLovinSdk.getInstance(context));
    }

    public static AppLovinIncentivizedInterstitial create(AppLovinSdk appLovinSdk) {
        return new AppLovinIncentivizedInterstitial(appLovinSdk);
    }

    public void dismiss() {
        this.f16a.mo5722d();
    }

    public String getUserIdentifier() {
        return C0404z.m668b();
    }

    public boolean isAdReadyToDisplay() {
        return this.f16a.mo5718a();
    }

    public void preload(AppLovinAdLoadListener appLovinAdLoadListener) {
        if (appLovinAdLoadListener == null) {
            Log.i("AppLovinIncentivizedInterstitial", "AppLovinAdLoadListener was null when preloading incentivized interstitials; using a listener is highly recommended.");
        }
        this.f16a.mo5715a(appLovinAdLoadListener);
    }

    public void setUserIdentifier(String str) {
        C0404z.m664a(str);
    }

    public void show(Activity activity) {
        show(activity, (AppLovinAdRewardListener) null, (AppLovinAdVideoPlaybackListener) null);
    }

    public void show(Activity activity, AppLovinAdRewardListener appLovinAdRewardListener) {
        show(activity, appLovinAdRewardListener, (AppLovinAdVideoPlaybackListener) null);
    }

    public void show(Activity activity, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        show(activity, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, (AppLovinAdDisplayListener) null);
    }

    public void show(Activity activity, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener) {
        show(activity, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, (AppLovinAdClickListener) null);
    }

    public void show(Activity activity, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        this.f16a.mo5713a(activity, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
    }
}
