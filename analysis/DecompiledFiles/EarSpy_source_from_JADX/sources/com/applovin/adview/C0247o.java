package com.applovin.adview;

import android.view.animation.Animation;

/* renamed from: com.applovin.adview.o */
class C0247o implements Animation.AnimationListener {

    /* renamed from: a */
    final /* synthetic */ boolean f75a;

    /* renamed from: b */
    final /* synthetic */ C0246n f76b;

    C0247o(C0246n nVar, boolean z) {
        this.f76b = nVar;
        this.f75a = z;
    }

    public void onAnimationEnd(Animation animation) {
        if (!this.f75a) {
            this.f76b.f74a.f18B.setVisibility(4);
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
        this.f76b.f74a.f18B.setVisibility(0);
    }
}
