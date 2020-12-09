package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;

/* renamed from: com.applovin.impl.adview.h */
class C0274h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdViewControllerImpl f165a;

    /* renamed from: b */
    private final AppLovinAd f166b;

    public C0274h(AdViewControllerImpl adViewControllerImpl, AppLovinAd appLovinAd) {
        this.f165a = adViewControllerImpl;
        this.f166b = appLovinAd;
    }

    public void run() {
        AppLovinAdDisplayListener g = this.f165a.f105v;
        if (g != null && this.f166b != null) {
            try {
                g.adHidden(this.f166b);
            } catch (Throwable th) {
                this.f165a.f87d.userError("AppLovinAdView", "Exception while notifying ad display listener", th);
            }
        }
    }
}
