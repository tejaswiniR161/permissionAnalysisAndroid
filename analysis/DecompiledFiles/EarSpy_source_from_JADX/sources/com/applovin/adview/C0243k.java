package com.applovin.adview;

import android.media.MediaPlayer;

/* renamed from: com.applovin.adview.k */
class C0243k implements MediaPlayer.OnCompletionListener {

    /* renamed from: a */
    final /* synthetic */ AppLovinInterstitialActivity f69a;

    C0243k(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f69a = appLovinInterstitialActivity;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        boolean unused = this.f69a.f34m = true;
        this.f69a.m81t();
    }
}
