package com.facebook.ads.internal.view.video.support;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;

@TargetApi(14)
/* renamed from: com.facebook.ads.internal.view.video.support.d */
public class C0604d extends TextureView implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnPreparedListener, TextureView.SurfaceTextureListener, C0605e {

    /* renamed from: i */
    private static final String f1402i = C0604d.class.getSimpleName();

    /* renamed from: a */
    private View f1403a;

    /* renamed from: b */
    private Uri f1404b;

    /* renamed from: c */
    private C0602b f1405c;

    /* renamed from: d */
    private Surface f1406d;

    /* renamed from: e */
    private MediaPlayer f1407e;

    /* renamed from: f */
    private boolean f1408f;

    /* renamed from: g */
    private boolean f1409g;

    /* renamed from: h */
    private int f1410h;

    public C0604d(Context context) {
        super(context);
    }

    /* renamed from: a */
    public void mo6228a(View view, Uri uri) {
        this.f1403a = view;
        this.f1404b = uri;
        setSurfaceTextureListener(this);
    }

    public int getCurrentPosition() {
        if (this.f1407e != null) {
            return this.f1407e.getCurrentPosition();
        }
        return 0;
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        if (this.f1405c != null) {
            this.f1405c.mo6211a(mediaPlayer);
        }
        if (this.f1409g) {
            mediaPlayer.start();
            this.f1409g = false;
        }
        if (this.f1410h > 0) {
            if (this.f1410h >= this.f1407e.getDuration()) {
                this.f1410h = 0;
            }
            this.f1407e.seekTo(this.f1410h);
            this.f1410h = 0;
        }
        this.f1408f = true;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        this.f1406d = new Surface(surfaceTexture);
        if (this.f1407e != null) {
            this.f1407e.setSurface(this.f1406d);
            return;
        }
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(getContext(), this.f1404b);
            mediaPlayer.setSurface(this.f1406d);
            mediaPlayer.setOnPreparedListener(this);
            mediaPlayer.setOnInfoListener(new C0603c(this.f1403a));
            mediaPlayer.setOnBufferingUpdateListener(this);
            mediaPlayer.setLooping(false);
            mediaPlayer.prepareAsync();
            this.f1407e = mediaPlayer;
        } catch (Exception e) {
            mediaPlayer.release();
            Log.e(f1402i, "Cannot prepare media player with SurfaceTexture: " + e);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        pause();
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void pause() {
        if (this.f1407e != null) {
            this.f1410h = this.f1407e.getCurrentPosition();
            this.f1407e.stop();
            this.f1407e.reset();
            this.f1407e.release();
        }
        this.f1407e = null;
        this.f1408f = false;
        this.f1409g = false;
    }

    public void setFrameVideoViewListener(C0602b bVar) {
        this.f1405c = bVar;
    }

    public void start() {
        if (this.f1408f) {
            this.f1407e.start();
        } else {
            this.f1409g = true;
        }
        if (isAvailable()) {
            onSurfaceTextureAvailable(getSurfaceTexture(), 0, 0);
        }
    }
}
