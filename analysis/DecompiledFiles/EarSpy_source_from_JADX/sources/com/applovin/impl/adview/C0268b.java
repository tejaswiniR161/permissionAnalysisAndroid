package com.applovin.impl.adview;

/* renamed from: com.applovin.impl.adview.b */
class C0268b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f157a;

    /* renamed from: b */
    final /* synthetic */ AdViewControllerImpl f158b;

    C0268b(AdViewControllerImpl adViewControllerImpl, int i) {
        this.f158b = adViewControllerImpl;
        this.f157a = i;
    }

    public void run() {
        try {
            if (this.f158b.f104u != null) {
                this.f158b.f104u.failedToReceiveAd(this.f157a);
            }
        } catch (Throwable th) {
            this.f158b.f87d.userError("AppLovinAdView", "Exception while running app load  callback", th);
        }
    }
}
