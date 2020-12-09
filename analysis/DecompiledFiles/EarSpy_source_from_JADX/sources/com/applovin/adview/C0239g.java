package com.applovin.adview;

import com.applovin.impl.adview.C0287u;

/* renamed from: com.applovin.adview.g */
class C0239g implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0287u f62a;

    /* renamed from: b */
    final /* synthetic */ AppLovinInterstitialActivity f63b;

    C0239g(AppLovinInterstitialActivity appLovinInterstitialActivity, C0287u uVar) {
        this.f63b = appLovinInterstitialActivity;
        this.f62a = uVar;
    }

    public void run() {
        if (this.f62a.equals(this.f63b.f45x)) {
            this.f63b.m60j();
        } else if (this.f62a.equals(this.f63b.f47z)) {
            this.f63b.m65l();
        }
    }
}
