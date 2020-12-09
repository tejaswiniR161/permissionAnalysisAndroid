package com.facebook.ads.internal.view.video.support;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;
import android.widget.VideoView;

/* renamed from: com.facebook.ads.internal.view.video.support.g */
public class C0607g extends VideoView implements MediaPlayer.OnPreparedListener, C0605e {

    /* renamed from: a */
    private View f1414a;

    /* renamed from: b */
    private Uri f1415b;

    /* renamed from: c */
    private C0602b f1416c;

    public C0607g(Context context) {
        super(context);
    }

    /* renamed from: a */
    public void mo6228a(View view, Uri uri) {
        this.f1414a = view;
        this.f1415b = uri;
        setOnPreparedListener(this);
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.setLooping(true);
        mediaPlayer.setOnInfoListener(new C0603c(this.f1414a));
        if (this.f1416c != null) {
            this.f1416c.mo6211a(mediaPlayer);
        }
    }

    public void pause() {
        this.f1414a.setVisibility(0);
        stopPlayback();
    }

    public void setFrameVideoViewListener(C0602b bVar) {
        this.f1416c = bVar;
    }

    public void start() {
        setVideoURI(this.f1415b);
        super.start();
    }
}
