package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.TextureView;
import android.view.View;
import com.android.vending.billing.util.IabHelper;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzkr;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@zziy
@TargetApi(14)
public class zzc extends zzi implements AudioManager.OnAudioFocusChangeListener, MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {
    private static final Map<Integer, String> zzbwi = new HashMap();
    private final zzx zzbwj;
    private final boolean zzbwk;
    private int zzbwl = 0;
    private int zzbwm = 0;
    private MediaPlayer zzbwn;
    private Uri zzbwo;
    private int zzbwp;
    private int zzbwq;
    private int zzbwr;
    private int zzbws;
    private int zzbwt;
    private float zzbwu = 1.0f;
    private boolean zzbwv;
    private boolean zzbww;
    private zzw zzbwx;
    private boolean zzbwy;
    private int zzbwz;
    /* access modifiers changed from: private */
    public zzh zzbxa;

    static {
        if (Build.VERSION.SDK_INT >= 17) {
            zzbwi.put(Integer.valueOf(IabHelper.IABHELPER_SEND_INTENT_FAILED), "MEDIA_ERROR_IO");
            zzbwi.put(Integer.valueOf(IabHelper.IABHELPER_MISSING_TOKEN), "MEDIA_ERROR_MALFORMED");
            zzbwi.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
            zzbwi.put(-110, "MEDIA_ERROR_TIMED_OUT");
            zzbwi.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        zzbwi.put(100, "MEDIA_ERROR_SERVER_DIED");
        zzbwi.put(1, "MEDIA_ERROR_UNKNOWN");
        zzbwi.put(1, "MEDIA_INFO_UNKNOWN");
        zzbwi.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        zzbwi.put(701, "MEDIA_INFO_BUFFERING_START");
        zzbwi.put(702, "MEDIA_INFO_BUFFERING_END");
        zzbwi.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        zzbwi.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        zzbwi.put(802, "MEDIA_INFO_METADATA_UPDATE");
        if (Build.VERSION.SDK_INT >= 19) {
            zzbwi.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
            zzbwi.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
        }
    }

    public zzc(Context context, boolean z, boolean z2, zzx zzx) {
        super(context);
        setSurfaceTextureListener(this);
        this.zzbwj = zzx;
        this.zzbwy = z;
        this.zzbwk = z2;
        this.zzbwj.zza((zzi) this);
    }

    private void zzaf(int i) {
        if (i == 3) {
            this.zzbwj.zzqf();
        } else if (this.zzbwl == 3) {
            this.zzbwj.zzqg();
        }
        this.zzbwl = i;
    }

    private void zzag(int i) {
        this.zzbwm = i;
    }

    private void zzb(float f) {
        if (this.zzbwn != null) {
            try {
                this.zzbwn.setVolume(f, f);
            } catch (IllegalStateException e) {
            }
        } else {
            zzkn.zzdf("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        }
    }

    private void zzoh() {
        SurfaceTexture surfaceTexture;
        zzkn.m1493v("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture2 = getSurfaceTexture();
        if (this.zzbwo != null && surfaceTexture2 != null) {
            zzz(false);
            try {
                this.zzbwn = zzu.zzgq().zzps();
                this.zzbwn.setOnBufferingUpdateListener(this);
                this.zzbwn.setOnCompletionListener(this);
                this.zzbwn.setOnErrorListener(this);
                this.zzbwn.setOnInfoListener(this);
                this.zzbwn.setOnPreparedListener(this);
                this.zzbwn.setOnVideoSizeChangedListener(this);
                this.zzbwr = 0;
                if (this.zzbwy) {
                    this.zzbwx = new zzw(getContext());
                    this.zzbwx.zza(surfaceTexture2, getWidth(), getHeight());
                    this.zzbwx.start();
                    surfaceTexture = this.zzbwx.zzpu();
                    if (surfaceTexture == null) {
                        this.zzbwx.zzpt();
                        this.zzbwx = null;
                    }
                    this.zzbwn.setDataSource(getContext(), this.zzbwo);
                    this.zzbwn.setSurface(zzu.zzgr().zza(surfaceTexture));
                    this.zzbwn.setAudioStreamType(3);
                    this.zzbwn.setScreenOnWhilePlaying(true);
                    this.zzbwn.prepareAsync();
                    zzaf(1);
                }
                surfaceTexture = surfaceTexture2;
                this.zzbwn.setDataSource(getContext(), this.zzbwo);
                this.zzbwn.setSurface(zzu.zzgr().zza(surfaceTexture));
                this.zzbwn.setAudioStreamType(3);
                this.zzbwn.setScreenOnWhilePlaying(true);
                this.zzbwn.prepareAsync();
                zzaf(1);
            } catch (IOException | IllegalArgumentException | IllegalStateException e) {
                String valueOf = String.valueOf(this.zzbwo);
                zzkn.zzd(new StringBuilder(String.valueOf(valueOf).length() + 36).append("Failed to initialize MediaPlayer at ").append(valueOf).toString(), e);
                onError(this.zzbwn, 1, 0);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x0034 A[LOOP:0: B:9:0x0034->B:14:0x004f, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzoi() {
        /*
            r8 = this;
            boolean r0 = r8.zzbwk
            if (r0 != 0) goto L_0x0005
        L_0x0004:
            return
        L_0x0005:
            boolean r0 = r8.zzol()
            if (r0 == 0) goto L_0x0004
            android.media.MediaPlayer r0 = r8.zzbwn
            int r0 = r0.getCurrentPosition()
            if (r0 <= 0) goto L_0x0004
            int r0 = r8.zzbwm
            r1 = 3
            if (r0 == r1) goto L_0x0004
            java.lang.String r0 = "AdMediaPlayerView nudging MediaPlayer"
            com.google.android.gms.internal.zzkn.m1493v(r0)
            r0 = 0
            r8.zzb(r0)
            android.media.MediaPlayer r0 = r8.zzbwn
            r0.start()
            android.media.MediaPlayer r0 = r8.zzbwn
            int r0 = r0.getCurrentPosition()
            com.google.android.gms.common.util.zze r1 = com.google.android.gms.ads.internal.zzu.zzgf()
            long r2 = r1.currentTimeMillis()
        L_0x0034:
            boolean r1 = r8.zzol()
            if (r1 == 0) goto L_0x0051
            android.media.MediaPlayer r1 = r8.zzbwn
            int r1 = r1.getCurrentPosition()
            if (r1 != r0) goto L_0x0051
            com.google.android.gms.common.util.zze r1 = com.google.android.gms.ads.internal.zzu.zzgf()
            long r4 = r1.currentTimeMillis()
            long r4 = r4 - r2
            r6 = 250(0xfa, double:1.235E-321)
            int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r1 <= 0) goto L_0x0034
        L_0x0051:
            android.media.MediaPlayer r0 = r8.zzbwn
            r0.pause()
            r8.zzoq()
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zzc.zzoi():void");
    }

    private void zzoj() {
        AudioManager zzor = zzor();
        if (zzor != null && !this.zzbww) {
            if (zzor.requestAudioFocus(this, 3, 2) == 1) {
                zzoo();
            } else {
                zzkn.zzdf("AdMediaPlayerView audio focus request failed");
            }
        }
    }

    private void zzok() {
        zzkn.m1493v("AdMediaPlayerView abandon audio focus");
        AudioManager zzor = zzor();
        if (zzor != null && this.zzbww) {
            if (zzor.abandonAudioFocus(this) == 1) {
                this.zzbww = false;
            } else {
                zzkn.zzdf("AdMediaPlayerView abandon audio focus failed");
            }
        }
    }

    private boolean zzol() {
        return (this.zzbwn == null || this.zzbwl == -1 || this.zzbwl == 0 || this.zzbwl == 1) ? false : true;
    }

    private void zzoo() {
        zzkn.m1493v("AdMediaPlayerView audio focus gained");
        this.zzbww = true;
        zzoq();
    }

    private void zzop() {
        zzkn.m1493v("AdMediaPlayerView audio focus lost");
        this.zzbww = false;
        zzoq();
    }

    private void zzoq() {
        if (this.zzbwv || !this.zzbww) {
            zzb(0.0f);
        } else {
            zzb(this.zzbwu);
        }
    }

    private AudioManager zzor() {
        return (AudioManager) getContext().getSystemService("audio");
    }

    private void zzz(boolean z) {
        zzkn.m1493v("AdMediaPlayerView release");
        if (this.zzbwx != null) {
            this.zzbwx.zzpt();
            this.zzbwx = null;
        }
        if (this.zzbwn != null) {
            this.zzbwn.reset();
            this.zzbwn.release();
            this.zzbwn = null;
            zzaf(0);
            if (z) {
                this.zzbwm = 0;
                zzag(0);
            }
            zzok();
        }
    }

    public int getCurrentPosition() {
        if (zzol()) {
            return this.zzbwn.getCurrentPosition();
        }
        return 0;
    }

    public int getDuration() {
        if (zzol()) {
            return this.zzbwn.getDuration();
        }
        return -1;
    }

    public int getVideoHeight() {
        if (this.zzbwn != null) {
            return this.zzbwn.getVideoHeight();
        }
        return 0;
    }

    public int getVideoWidth() {
        if (this.zzbwn != null) {
            return this.zzbwn.getVideoWidth();
        }
        return 0;
    }

    public void onAudioFocusChange(int i) {
        if (i > 0) {
            zzoo();
        } else if (i < 0) {
            zzop();
        }
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        this.zzbwr = i;
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        zzkn.m1493v("AdMediaPlayerView completion");
        zzaf(5);
        zzag(5);
        zzkr.zzcrf.post(new Runnable() {
            public void run() {
                if (zzc.this.zzbxa != null) {
                    zzc.this.zzbxa.zzpl();
                }
            }
        });
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        final String str = zzbwi.get(Integer.valueOf(i));
        final String str2 = zzbwi.get(Integer.valueOf(i2));
        zzkn.zzdf(new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length()).append("AdMediaPlayerView MediaPlayer error: ").append(str).append(":").append(str2).toString());
        zzaf(-1);
        zzag(-1);
        zzkr.zzcrf.post(new Runnable() {
            public void run() {
                if (zzc.this.zzbxa != null) {
                    zzc.this.zzbxa.zzl(str, str2);
                }
            }
        });
        return true;
    }

    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        String str = zzbwi.get(Integer.valueOf(i));
        String str2 = zzbwi.get(Integer.valueOf(i2));
        zzkn.m1493v(new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(str2).length()).append("AdMediaPlayerView MediaPlayer info: ").append(str).append(":").append(str2).toString());
        return true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(this.zzbwp, i);
        int defaultSize2 = getDefaultSize(this.zzbwq, i2);
        if (this.zzbwp > 0 && this.zzbwq > 0 && this.zzbwx == null) {
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            defaultSize2 = View.MeasureSpec.getSize(i2);
            if (mode == 1073741824 && mode2 == 1073741824) {
                if (this.zzbwp * defaultSize2 < this.zzbwq * size) {
                    defaultSize = (this.zzbwp * defaultSize2) / this.zzbwq;
                } else if (this.zzbwp * defaultSize2 > this.zzbwq * size) {
                    defaultSize2 = (this.zzbwq * size) / this.zzbwp;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode == 1073741824) {
                int i3 = (this.zzbwq * size) / this.zzbwp;
                if (mode2 != Integer.MIN_VALUE || i3 <= defaultSize2) {
                    defaultSize2 = i3;
                    defaultSize = size;
                } else {
                    defaultSize = size;
                }
            } else if (mode2 == 1073741824) {
                defaultSize = (this.zzbwp * defaultSize2) / this.zzbwq;
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize = size;
                }
            } else {
                int i4 = this.zzbwp;
                int i5 = this.zzbwq;
                if (mode2 != Integer.MIN_VALUE || i5 <= defaultSize2) {
                    defaultSize2 = i5;
                    defaultSize = i4;
                } else {
                    defaultSize = (this.zzbwp * defaultSize2) / this.zzbwq;
                }
                if (mode == Integer.MIN_VALUE && defaultSize > size) {
                    defaultSize2 = (this.zzbwq * size) / this.zzbwp;
                    defaultSize = size;
                }
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
        if (this.zzbwx != null) {
            this.zzbwx.zzg(defaultSize, defaultSize2);
        }
        if (Build.VERSION.SDK_INT == 16) {
            if ((this.zzbws > 0 && this.zzbws != defaultSize) || (this.zzbwt > 0 && this.zzbwt != defaultSize2)) {
                zzoi();
            }
            this.zzbws = defaultSize;
            this.zzbwt = defaultSize2;
        }
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        zzkn.m1493v("AdMediaPlayerView prepared");
        zzaf(2);
        this.zzbwj.zzpj();
        zzkr.zzcrf.post(new Runnable() {
            public void run() {
                if (zzc.this.zzbxa != null) {
                    zzc.this.zzbxa.zzpj();
                }
            }
        });
        this.zzbwp = mediaPlayer.getVideoWidth();
        this.zzbwq = mediaPlayer.getVideoHeight();
        if (this.zzbwz != 0) {
            seekTo(this.zzbwz);
        }
        zzoi();
        int i = this.zzbwp;
        zzkn.zzde(new StringBuilder(62).append("AdMediaPlayerView stream dimensions: ").append(i).append(" x ").append(this.zzbwq).toString());
        if (this.zzbwm == 3) {
            play();
        }
        zzoj();
        zzoq();
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        zzkn.m1493v("AdMediaPlayerView surface created");
        zzoh();
        zzkr.zzcrf.post(new Runnable() {
            public void run() {
                if (zzc.this.zzbxa != null) {
                    zzc.this.zzbxa.zzpi();
                }
            }
        });
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzkn.m1493v("AdMediaPlayerView surface destroyed");
        if (this.zzbwn != null && this.zzbwz == 0) {
            this.zzbwz = this.zzbwn.getCurrentPosition();
        }
        if (this.zzbwx != null) {
            this.zzbwx.zzpt();
        }
        zzkr.zzcrf.post(new Runnable() {
            public void run() {
                if (zzc.this.zzbxa != null) {
                    zzc.this.zzbxa.onPaused();
                    zzc.this.zzbxa.zzpm();
                }
            }
        });
        zzz(true);
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        boolean z = true;
        zzkn.m1493v("AdMediaPlayerView surface changed");
        boolean z2 = this.zzbwm == 3;
        if (!(this.zzbwp == i && this.zzbwq == i2)) {
            z = false;
        }
        if (this.zzbwn != null && z2 && z) {
            if (this.zzbwz != 0) {
                seekTo(this.zzbwz);
            }
            play();
        }
        if (this.zzbwx != null) {
            this.zzbwx.zzg(i, i2);
        }
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzbwj.zzb(this);
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        zzkn.m1493v(new StringBuilder(57).append("AdMediaPlayerView size changed: ").append(i).append(" x ").append(i2).toString());
        this.zzbwp = mediaPlayer.getVideoWidth();
        this.zzbwq = mediaPlayer.getVideoHeight();
        if (this.zzbwp != 0 && this.zzbwq != 0) {
            requestLayout();
        }
    }

    public void pause() {
        zzkn.m1493v("AdMediaPlayerView pause");
        if (zzol() && this.zzbwn.isPlaying()) {
            this.zzbwn.pause();
            zzaf(4);
            zzkr.zzcrf.post(new Runnable() {
                public void run() {
                    if (zzc.this.zzbxa != null) {
                        zzc.this.zzbxa.onPaused();
                    }
                }
            });
        }
        zzag(4);
    }

    public void play() {
        zzkn.m1493v("AdMediaPlayerView play");
        if (zzol()) {
            this.zzbwn.start();
            zzaf(3);
            zzkr.zzcrf.post(new Runnable() {
                public void run() {
                    if (zzc.this.zzbxa != null) {
                        zzc.this.zzbxa.zzpk();
                    }
                }
            });
        }
        zzag(3);
    }

    public void seekTo(int i) {
        zzkn.m1493v(new StringBuilder(34).append("AdMediaPlayerView seek ").append(i).toString());
        if (zzol()) {
            this.zzbwn.seekTo(i);
            this.zzbwz = 0;
            return;
        }
        this.zzbwz = i;
    }

    public void setVideoPath(String str) {
        setVideoURI(Uri.parse(str));
    }

    public void setVideoURI(Uri uri) {
        this.zzbwo = uri;
        this.zzbwz = 0;
        zzoh();
        requestLayout();
        invalidate();
    }

    public void stop() {
        zzkn.m1493v("AdMediaPlayerView stop");
        if (this.zzbwn != null) {
            this.zzbwn.stop();
            this.zzbwn.release();
            this.zzbwn = null;
            zzaf(0);
            zzag(0);
            zzok();
        }
        this.zzbwj.onStop();
    }

    public String toString() {
        String valueOf = String.valueOf(getClass().getName());
        String valueOf2 = String.valueOf(Integer.toHexString(hashCode()));
        return new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length()).append(valueOf).append("@").append(valueOf2).toString();
    }

    public void zza(float f) {
        this.zzbwu = f;
        zzoq();
    }

    public void zza(float f, float f2) {
        if (this.zzbwx != null) {
            this.zzbwx.zzb(f, f2);
        }
    }

    public void zza(zzh zzh) {
        this.zzbxa = zzh;
    }

    public String zzog() {
        String valueOf = String.valueOf(this.zzbwy ? " spherical" : "");
        return valueOf.length() != 0 ? "MediaPlayer".concat(valueOf) : new String("MediaPlayer");
    }

    public void zzom() {
        this.zzbwv = true;
        zzoq();
    }

    public void zzon() {
        this.zzbwv = false;
        zzoq();
    }
}
