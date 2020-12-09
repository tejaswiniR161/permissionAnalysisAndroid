package com.applovin.impl.sdk;

import android.app.Activity;
import com.applovin.sdk.AppLovinAdClickListener;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;
import java.util.Timer;

/* renamed from: com.applovin.impl.sdk.aq */
class C0310aq {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final AppLovinSdkImpl f350a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final C0404z f351b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Activity f352c;

    /* renamed from: d */
    private AppLovinAdDisplayListener f353d;

    /* renamed from: e */
    private AppLovinAdVideoPlaybackListener f354e;

    /* renamed from: f */
    private AppLovinAdClickListener f355f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public AppLovinAdRewardListener f356g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public final Timer f357h = new Timer("IncentivizedAdLauncher");

    C0310aq(AppLovinSdkImpl appLovinSdkImpl, C0404z zVar) {
        this.f350a = appLovinSdkImpl;
        this.f351b = zVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m251b() {
        this.f351b.mo5719b(this.f352c, this.f356g, this.f354e, this.f353d, this.f355f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5446a() {
        this.f352c.runOnUiThread(new C0311ar(this));
    }

    /* renamed from: a */
    public void mo5447a(Activity activity) {
        this.f352c = activity;
    }

    /* renamed from: a */
    public void mo5448a(AppLovinAdClickListener appLovinAdClickListener) {
        this.f355f = appLovinAdClickListener;
    }

    /* renamed from: a */
    public void mo5449a(AppLovinAdDisplayListener appLovinAdDisplayListener) {
        this.f353d = appLovinAdDisplayListener;
    }

    /* renamed from: a */
    public void mo5450a(AppLovinAdRewardListener appLovinAdRewardListener) {
        this.f356g = appLovinAdRewardListener;
    }

    /* renamed from: a */
    public void mo5451a(AppLovinAdVideoPlaybackListener appLovinAdVideoPlaybackListener) {
        this.f354e = appLovinAdVideoPlaybackListener;
    }
}
