package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.TextureView;
import com.google.android.gms.internal.zziy;

@zziy
@TargetApi(14)
public abstract class zzi extends TextureView {
    public zzi(Context context) {
        super(context);
    }

    public abstract int getCurrentPosition();

    public abstract int getDuration();

    public abstract int getVideoHeight();

    public abstract int getVideoWidth();

    public abstract void pause();

    public abstract void play();

    public abstract void seekTo(int i);

    public abstract void setVideoPath(String str);

    public abstract void stop();

    public abstract void zza(float f);

    public abstract void zza(float f, float f2);

    public abstract void zza(zzh zzh);

    public abstract String zzog();

    public abstract void zzom();

    public abstract void zzon();
}
