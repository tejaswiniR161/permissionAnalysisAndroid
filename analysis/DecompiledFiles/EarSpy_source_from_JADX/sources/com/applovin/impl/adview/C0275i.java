package com.applovin.impl.adview;

import com.applovin.adview.AppLovinInterstitialAdDialog;

/* renamed from: com.applovin.impl.adview.i */
class C0275i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdViewControllerImpl f167a;

    private C0275i(AdViewControllerImpl adViewControllerImpl) {
        this.f167a = adViewControllerImpl;
    }

    /* synthetic */ C0275i(AdViewControllerImpl adViewControllerImpl, C0254a aVar) {
        this(adViewControllerImpl);
    }

    public void run() {
        if (this.f167a.f96m != null) {
            try {
                AppLovinInterstitialAdDialog createInterstitialAdDialog = new InterstitialAdDialogCreatorImpl().createInterstitialAdDialog(this.f167a.f85b, this.f167a.f84a);
                createInterstitialAdDialog.setAdDisplayListener(new C0270d(this.f167a));
                createInterstitialAdDialog.setAdVideoPlaybackListener(new C0271e(this.f167a));
                createInterstitialAdDialog.setAdClickListener(new C0269c(this.f167a));
                createInterstitialAdDialog.showAndRender(this.f167a.f96m);
            } catch (Throwable th) {
            }
        }
    }
}
