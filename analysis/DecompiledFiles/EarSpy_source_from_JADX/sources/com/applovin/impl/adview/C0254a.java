package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinLogger;

/* renamed from: com.applovin.impl.adview.a */
class C0254a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinAd f114a;

    /* renamed from: b */
    final /* synthetic */ AdViewControllerImpl f115b;

    C0254a(AdViewControllerImpl adViewControllerImpl, AppLovinAd appLovinAd) {
        this.f115b = adViewControllerImpl;
        this.f114a = appLovinAd;
    }

    public void run() {
        try {
            if (this.f115b.f104u != null) {
                this.f115b.f104u.adReceived(this.f114a);
            }
        } catch (Throwable th) {
            this.f115b.f87d.userError(AppLovinLogger.SDK_TAG, "Exception while running app load callback: " + th.getMessage());
        }
    }
}
