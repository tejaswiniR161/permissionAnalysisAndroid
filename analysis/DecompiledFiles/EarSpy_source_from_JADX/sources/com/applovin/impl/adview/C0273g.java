package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;

/* renamed from: com.applovin.impl.adview.g */
class C0273g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdViewControllerImpl f163a;

    /* renamed from: b */
    private final AppLovinAd f164b;

    public C0273g(AdViewControllerImpl adViewControllerImpl, AppLovinAd appLovinAd) {
        this.f163a = adViewControllerImpl;
        this.f164b = appLovinAd;
    }

    public void run() {
        AppLovinAdClickListener h = this.f163a.f107x;
        if (h != null && this.f164b != null) {
            try {
                h.adClicked(this.f164b);
            } catch (Throwable th) {
                this.f163a.f87d.userError("AppLovinAdView", "Exception while notifying ad click listener", th);
            }
        }
    }
}
