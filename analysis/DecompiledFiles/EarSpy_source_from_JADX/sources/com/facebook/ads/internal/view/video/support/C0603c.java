package com.facebook.ads.internal.view.video.support;

import android.media.MediaPlayer;
import android.view.View;

/* renamed from: com.facebook.ads.internal.view.video.support.c */
public class C0603c implements MediaPlayer.OnInfoListener {

    /* renamed from: a */
    private View f1401a;

    public C0603c(View view) {
        this.f1401a = view;
    }

    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        if (i != 3) {
            return false;
        }
        this.f1401a.setVisibility(8);
        return true;
    }
}
