package com.applovin.adview;

import android.view.animation.AlphaAnimation;

/* renamed from: com.applovin.adview.e */
class C0237e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinInterstitialActivity f60a;

    C0237e(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f60a = appLovinInterstitialActivity;
    }

    public void run() {
        try {
            if (this.f60a.f35n) {
                this.f60a.f45x.setVisibility(0);
                return;
            }
            boolean unused = this.f60a.f35n = true;
            if (this.f60a.m63k() && this.f60a.f46y != null) {
                this.f60a.f46y.setVisibility(0);
                this.f60a.f46y.bringToFront();
            }
            this.f60a.f45x.setVisibility(0);
            this.f60a.f45x.bringToFront();
            AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration((long) this.f60a.f26e.mo5573e());
            alphaAnimation.setRepeatCount(0);
            this.f60a.f45x.startAnimation(alphaAnimation);
        } catch (Throwable th) {
            this.f60a.dismiss();
        }
    }
}
