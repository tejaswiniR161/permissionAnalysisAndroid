package com.applovin.adview;

import android.media.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.adview.b */
class C0234b implements MediaPlayer.OnPreparedListener {

    /* renamed from: a */
    final /* synthetic */ AppLovinInterstitialActivity f55a;

    C0234b(AppLovinInterstitialActivity appLovinInterstitialActivity) {
        this.f55a = appLovinInterstitialActivity;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        WeakReference unused = this.f55a.f21E = new WeakReference(mediaPlayer);
        int i = this.f55a.m49d() ? 0 : 1;
        mediaPlayer.setVolume((float) i, (float) i);
        int videoWidth = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        int unused2 = this.f55a.f41t = (int) TimeUnit.MILLISECONDS.toSeconds((long) mediaPlayer.getDuration());
        this.f55a.f44w.setVideoSize(videoWidth, videoHeight);
        mediaPlayer.setDisplay(this.f55a.f44w.getHolder());
        mediaPlayer.setOnErrorListener(new C0235c(this));
        this.f55a.m68n();
        this.f55a.m58i();
        this.f55a.m73p();
        this.f55a.m54g();
    }
}
