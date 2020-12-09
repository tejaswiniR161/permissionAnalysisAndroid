package com.applovin.adview;

import android.media.MediaPlayer;

/* renamed from: com.applovin.adview.l */
class C0244l implements MediaPlayer.OnErrorListener {

    /* renamed from: a */
    final /* synthetic */ AppLovinInterstitialActivity f70a;

    C0244l(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f70a = appLovinInterstitialActivity;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.f70a.f42u.post(new C0245m(this, i, i2));
        return true;
    }
}
