package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.lang.ref.SoftReference;

/* renamed from: com.applovin.impl.sdk.z */
public class C0404z {

    /* renamed from: k */
    private static String f705k = null;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final AppLovinSdkImpl f706a;

    /* renamed from: b */
    private final AppLovinAdServiceImpl f707b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public AppLovinAdImpl f708c;

    /* renamed from: d */
    private SoftReference f709d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final Handler f710e;

    /* renamed from: f */
    private final Object f711f = new Object();

    /* renamed from: g */
    private volatile String f712g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C0379de f713h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public volatile boolean f714i = false;

    /* renamed from: j */
    private SoftReference f715j;

    public C0404z(AppLovinSdk appLovinSdk) {
        this.f706a = (AppLovinSdkImpl) appLovinSdk;
        this.f707b = (AppLovinAdServiceImpl) appLovinSdk.getAdService();
        this.f710e = new Handler(Looper.getMainLooper());
    }

    /* renamed from: a */
    public static void m664a(String str) {
        f705k = str;
    }

    /* renamed from: b */
    public static String m668b() {
        return f705k;
    }

    /* renamed from: e */
    private void m671e() {
        AppLovinAdLoadListener appLovinAdLoadListener;
        if (this.f709d != null && (appLovinAdLoadListener = (AppLovinAdLoadListener) this.f709d.get()) != null) {
            appLovinAdLoadListener.failedToReceiveAd(AppLovinErrorCodes.INCENTIVIZED_NO_AD_PRELOADED);
        }
    }

    /* renamed from: f */
    private AppLovinAdRewardListener m672f() {
        return new C0294aa(this);
    }

    /* renamed from: a */
    public void mo5713a(Activity activity, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        AppLovinAdRewardListener f = appLovinAdRewardListener == null ? m672f() : appLovinAdRewardListener;
        if (!mo5718a()) {
            this.f706a.getLogger().userError("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
            m671e();
        } else if (AppLovinSdkUtils.isValidString(this.f708c.getVideoFilename()) && !this.f706a.getFileManager().mo5704a(this.f708c.getVideoFilename(), (Context) activity)) {
        } else {
            if (((Boolean) this.f706a.mo5363a(C0343bw.f501ah)).booleanValue()) {
                C0310aq aqVar = new C0310aq(this.f706a, this);
                aqVar.mo5447a(activity);
                aqVar.mo5449a(appLovinAdDisplayListener);
                aqVar.mo5448a(appLovinAdClickListener);
                aqVar.mo5451a(appLovinAdVideoPlaybackListener);
                aqVar.mo5450a(f);
                aqVar.mo5446a();
                return;
            }
            mo5719b(activity, f, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5714a(AppLovinAd appLovinAd, AppLovinAdRewardListener appLovinAdRewardListener) {
        this.f713h = new C0379de(this.f706a, appLovinAd, appLovinAdRewardListener);
        this.f706a.mo5362a().mo5636a((C0342bv) this.f713h, C0365cr.BACKGROUND);
    }

    /* renamed from: a */
    public void mo5715a(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f709d = new SoftReference(appLovinAdLoadListener);
        if (mo5718a()) {
            this.f706a.getLogger().userError("IncentivizedAdController", "Attempted to call preloadAndNotify: while an ad was already loaded or currently being played. Do not call preloadAndNotify: again until the last ad has been closed (adHidden).");
            if (appLovinAdLoadListener != null) {
                appLovinAdLoadListener.adReceived(this.f708c);
                return;
            }
            return;
        }
        this.f707b.loadNextAd(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED, new C0295ab(this, appLovinAdLoadListener));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5716a(AppLovinAdRewardListener appLovinAdRewardListener) {
        appLovinAdRewardListener.userDeclinedToViewAd(this.f708c);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5717a(String str, Activity activity) {
        if (str != null && ((Boolean) this.f706a.mo5363a(C0343bw.f502ai)).booleanValue()) {
            new C0308ao(this.f706a, activity, str).mo5442a();
        }
    }

    /* renamed from: a */
    public boolean mo5718a() {
        return this.f708c != null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5719b(Activity activity, AppLovinAdRewardListener appLovinAdRewardListener, AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener, AppLovinAdDisplayListener appLovinAdDisplayListener, AppLovinAdClickListener appLovinAdClickListener) {
        if (mo5718a()) {
            AppLovinAdImpl appLovinAdImpl = this.f708c;
            if (appLovinAdImpl.getType().equals(AppLovinAdType.INCENTIVIZED)) {
                AppLovinInterstitialAdDialog create = AppLovinInterstitialAd.create(this.f706a, activity);
                C0298ae aeVar = new C0298ae(this, activity, appLovinAdRewardListener, appLovinAdVideoPlaybackListener, appLovinAdDisplayListener, appLovinAdClickListener, (C0294aa) null);
                create.setAdDisplayListener(aeVar);
                create.setAdVideoPlaybackListener(aeVar);
                create.setAdClickListener(aeVar);
                create.showAndRender(appLovinAdImpl);
                this.f715j = new SoftReference(create);
                mo5714a((AppLovinAd) appLovinAdImpl, (AppLovinAdRewardListener) aeVar);
                return;
            }
            this.f706a.getLogger().mo5666e("IncentivizedAdController", "Attempted to render an ad of type " + this.f708c.getType() + " in an Incentivized Ad interstitial.");
            appLovinAdVideoPlaybackListener.videoPlaybackEnded(this.f708c, 0.0d, false);
            return;
        }
        this.f706a.getLogger().userError("IncentivizedAdController", "Skipping incentivized video playback: user attempted to play an incentivized video before one was preloaded.");
        m671e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5720b(String str) {
        synchronized (this.f711f) {
            this.f712g = str;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo5721c() {
        String str;
        synchronized (this.f711f) {
            str = this.f712g;
        }
        return str;
    }

    /* renamed from: d */
    public void mo5722d() {
        AppLovinInterstitialAdDialog appLovinInterstitialAdDialog;
        if (this.f715j != null && (appLovinInterstitialAdDialog = (AppLovinInterstitialAdDialog) this.f715j.get()) != null) {
            appLovinInterstitialAdDialog.dismiss();
        }
    }
}
