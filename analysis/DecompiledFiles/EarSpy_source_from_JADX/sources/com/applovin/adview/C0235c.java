package com.applovin.adview;

import android.media.MediaPlayer;

/* renamed from: com.applovin.adview.c */
class C0235c implements MediaPlayer.OnErrorListener {

    /* renamed from: a */
    final /* synthetic */ C0234b f56a;

    C0235c(C0234b bVar) {
        this.f56a = bVar;
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.f56a.f55a.f42u.post(new C0236d(this, i, i2));
        return true;
    }
}
