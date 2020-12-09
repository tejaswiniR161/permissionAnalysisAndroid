package com.applovin.adview;

import android.view.View;

/* renamed from: com.applovin.adview.p */
class C0248p implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ AppLovinInterstitialActivity f77a;

    C0248p(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f77a = appLovinInterstitialActivity;
    }

    public void onClick(View view) {
        this.f77a.dismiss();
    }
}
