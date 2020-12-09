package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinAdUpdateListener;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import java.lang.ref.WeakReference;

/* renamed from: com.applovin.impl.adview.l */
class C0278l implements AppLovinAdLoadListener, AppLovinAdUpdateListener {

    /* renamed from: a */
    private final WeakReference f170a;

    /* renamed from: b */
    private final AppLovinAdService f171b;

    /* renamed from: c */
    private final AppLovinLogger f172c;

    C0278l(AdViewControllerImpl adViewControllerImpl, AppLovinSdk appLovinSdk) {
        if (adViewControllerImpl == null) {
            throw new IllegalArgumentException("No view specified");
        } else if (appLovinSdk == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else {
            this.f170a = new WeakReference(adViewControllerImpl);
            this.f172c = appLovinSdk.getLogger();
            this.f171b = appLovinSdk.getAdService();
        }
    }

    public void adReceived(AppLovinAd appLovinAd) {
        AdViewControllerImpl adViewControllerImpl = (AdViewControllerImpl) this.f170a.get();
        if (adViewControllerImpl != null) {
            adViewControllerImpl.mo5212a(appLovinAd);
        } else {
            this.f172c.userError("AppLovinAdView", "Ad view has been garbage collected by the time an ad was recieved");
        }
    }

    public void adUpdated(AppLovinAd appLovinAd) {
        AdViewControllerImpl adViewControllerImpl = (AdViewControllerImpl) this.f170a.get();
        if (adViewControllerImpl != null) {
            adViewControllerImpl.mo5212a(appLovinAd);
            return;
        }
        this.f171b.removeAdUpdateListener(this, appLovinAd.getSize());
        this.f172c.userError("AppLovinAdView", "Ad view has been garbage collected by the time an ad was updated");
    }

    public void failedToReceiveAd(int i) {
        AdViewControllerImpl adViewControllerImpl = (AdViewControllerImpl) this.f170a.get();
        if (adViewControllerImpl != null) {
            adViewControllerImpl.mo5211a(i);
        }
    }

    public String toString() {
        return "[AdViewController listener: " + hashCode() + "]";
    }
}
