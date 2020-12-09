package com.applovin.impl.adview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.impl.sdk.AppLovinAdImpl;
import com.applovin.impl.sdk.AppLovinSdkImpl;
import com.applovin.impl.sdk.C0392n;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* renamed from: com.applovin.impl.adview.af */
public class C0260af implements AppLovinInterstitialAdDialog {

    /* renamed from: a */
    public static volatile boolean f124a = false;

    /* renamed from: b */
    public static volatile boolean f125b = false;

    /* renamed from: c */
    private static final Map f126c = Collections.synchronizedMap(new HashMap());

    /* renamed from: n */
    private static volatile boolean f127n;

    /* renamed from: d */
    private final String f128d;

    /* renamed from: e */
    private final AppLovinSdkImpl f129e;

    /* renamed from: f */
    private final Activity f130f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public volatile AppLovinAdLoadListener f131g;

    /* renamed from: h */
    private volatile AppLovinAdDisplayListener f132h;

    /* renamed from: i */
    private volatile AppLovinAdVideoPlaybackListener f133i;

    /* renamed from: j */
    private volatile AppLovinAdClickListener f134j;

    /* renamed from: k */
    private volatile AppLovinAdImpl f135k;

    /* renamed from: l */
    private volatile AppLovinAdImpl.AdTarget f136l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public volatile C0289w f137m;

    C0260af(AppLovinSdk appLovinSdk, Activity activity) {
        if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else if (activity == null) {
            throw new IllegalArgumentException("No activity specified");
        } else {
            this.f129e = (AppLovinSdkImpl) appLovinSdk;
            this.f128d = UUID.randomUUID().toString();
            f124a = true;
            f125b = false;
            this.f130f = activity;
            f126c.put(this.f128d, this);
        }
    }

    /* renamed from: a */
    public static C0260af m115a(String str) {
        return (C0260af) f126c.get(str);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m116a(int i) {
        this.f130f.runOnUiThread(new C0264aj(this, i));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m120a(AppLovinAd appLovinAd) {
        this.f130f.runOnUiThread(new C0263ai(this, appLovinAd));
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m124h() {
        C0290x xVar = new C0290x(this.f129e, this.f130f);
        xVar.mo5313a(this);
        this.f137m = xVar;
        xVar.mo5314a((AppLovinAd) this.f135k);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m125i() {
        Intent intent = new Intent(this.f130f, AppLovinInterstitialActivity.class);
        intent.putExtra(AppLovinInterstitialActivity.KEY_WRAPPER_ID, this.f128d);
        AppLovinInterstitialActivity.lastKnownWrapper = this;
        this.f130f.startActivity(intent);
        mo5231a(true);
    }

    /* renamed from: a */
    public AppLovinSdk mo5229a() {
        return this.f129e;
    }

    /* renamed from: a */
    public void mo5230a(C0289w wVar) {
        this.f137m = wVar;
    }

    /* renamed from: a */
    public void mo5231a(boolean z) {
        f127n = z;
    }

    /* renamed from: b */
    public AppLovinAd mo5232b() {
        return this.f135k;
    }

    /* renamed from: c */
    public AppLovinAdVideoPlaybackListener mo5233c() {
        return this.f133i;
    }

    /* renamed from: d */
    public AppLovinAdDisplayListener mo5234d() {
        return this.f132h;
    }

    public void dismiss() {
        if (this.f137m != null) {
            this.f130f.runOnUiThread(new C0265ak(this));
        }
    }

    /* renamed from: e */
    public AppLovinAdClickListener mo5235e() {
        return this.f134j;
    }

    /* renamed from: f */
    public AppLovinAdImpl.AdTarget mo5236f() {
        return this.f136l;
    }

    /* renamed from: g */
    public void mo5237g() {
        f124a = false;
        f125b = true;
        f126c.remove(this.f128d);
    }

    public boolean isAdReadyToDisplay() {
        return this.f129e.getAdService().hasPreloadedAd(AppLovinAdSize.INTERSTITIAL);
    }

    public boolean isShowing() {
        return f127n;
    }

    public void setAdClickListener(AppLovinAdClickListener appLovinAdClickListener) {
        this.f134j = appLovinAdClickListener;
    }

    public void setAdDisplayListener(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f132h = appLovinAdDisplayListener;
    }

    public void setAdLoadListener(AppLovinAdLoadListener appLovinAdLoadListener) {
        this.f131g = appLovinAdLoadListener;
    }

    public void setAdVideoPlaybackListener(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f133i = appLovinAdVideoPlaybackListener;
    }

    public void show() {
        this.f129e.getAdService().loadNextAd(AppLovinAdSize.INTERSTITIAL, new C0261ag(this));
    }

    public void showAndRender(AppLovinAd appLovinAd) {
        if (isShowing()) {
            this.f129e.getLogger().userError("AppLovinInterstitialAdDialog", "Attempted to show an interstitial while one is already displayed; ignoring.");
            return;
        }
        this.f135k = (AppLovinAdImpl) appLovinAd;
        this.f136l = this.f135k != null ? this.f135k.getTarget() : AppLovinAdImpl.AdTarget.DEFAULT;
        if (!AppLovinSdkUtils.isValidString(this.f135k.getVideoFilename()) || this.f129e.getFileManager().mo5704a(this.f135k.getVideoFilename(), (Context) this.f130f)) {
            this.f130f.runOnUiThread(new C0262ah(this, C0392n.m608a(AppLovinInterstitialActivity.class, (Context) this.f130f), this.f136l == AppLovinAdImpl.AdTarget.ACTIVITY_LANDSCAPE || this.f136l == AppLovinAdImpl.AdTarget.ACTIVITY_PORTRAIT));
        }
    }
}
