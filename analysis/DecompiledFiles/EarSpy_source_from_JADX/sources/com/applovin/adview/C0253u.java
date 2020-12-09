package com.applovin.adview;

import android.app.Activity;
import com.applovin.impl.adview.InterstitialAdDialogCreatorImpl;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.adview.u */
final class C0253u implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AppLovinSdk f82a;

    /* renamed from: b */
    final /* synthetic */ Activity f83b;

    C0253u(AppLovinSdk appLovinSdk, Activity activity) {
        this.f82a = appLovinSdk;
        this.f83b = activity;
    }

    public void run() {
        new InterstitialAdDialogCreatorImpl().createInterstitialAdDialog(this.f82a, this.f83b).show();
    }
}
