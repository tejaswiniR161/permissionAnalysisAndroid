package com.applovin.adview;

import android.view.View;
import android.view.animation.AlphaAnimation;

/* renamed from: com.applovin.adview.n */
class C0246n implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AppLovinInterstitialActivity f74a;

    C0246n(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f74a = appLovinInterstitialActivity;
    }

    public void onClick(View view) {
        float f = 1.0f;
        this.f74a.f27f.getLogger().mo5665d("AppLovinInterstitialActivity", "Video view tapped!");
        if (this.f74a.f26e.mo5594z() && this.f74a.f18B != null && this.f74a.f18B.getVisibility() != 8) {
            boolean z = this.f74a.f18B.getVisibility() == 4;
            float f2 = z ? 0.0f : 1.0f;
            if (!z) {
                f = 0.0f;
            }
            AlphaAnimation alphaAnimation = new AlphaAnimation(f2, f);
            alphaAnimation.setDuration(750);
            alphaAnimation.setAnimationListener(new C0247o(this, z));
            this.f74a.f18B.startAnimation(alphaAnimation);
        }
    }
}
