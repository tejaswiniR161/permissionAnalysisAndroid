package com.applovin.adview;

import android.view.animation.AlphaAnimation;

/* renamed from: com.applovin.adview.f */
class C0238f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinInterstitialActivity f61a;

    C0238f(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f61a = appLovinInterstitialActivity;
    }

    public void run() {
        try {
            if (!this.f61a.f36o && this.f61a.f47z != null) {
                boolean unused = this.f61a.f36o = true;
                this.f61a.f47z.setVisibility(0);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setDuration((long) this.f61a.f26e.mo5573e());
                alphaAnimation.setRepeatCount(0);
                this.f61a.f47z.startAnimation(alphaAnimation);
                if (this.f61a.m63k() && this.f61a.f17A != null) {
                    this.f61a.f17A.setVisibility(0);
                    this.f61a.f17A.bringToFront();
                }
            }
        } catch (Throwable th) {
            this.f61a.f25d.mo5671w("AppLovinInterstitialActivity", "Unable to show skip button: " + th);
        }
    }
}
