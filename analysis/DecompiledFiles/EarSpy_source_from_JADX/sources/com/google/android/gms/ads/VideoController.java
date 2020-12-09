package com.google.android.gms.ads;

import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzab;
import com.google.android.gms.ads.internal.client.zzap;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zziy;

@zziy
public final class VideoController {
    private final Object zzakd = new Object();
    @Nullable
    private zzab zzake;
    @Nullable
    private VideoLifecycleCallbacks zzakf;

    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }
    }

    public float getAspectRatio() {
        float f = 0.0f;
        synchronized (this.zzakd) {
            if (this.zzake != null) {
                try {
                    f = this.zzake.getAspectRatio();
                } catch (RemoteException e) {
                    zzb.zzb("Unable to call getAspectRatio on video controller.", e);
                }
            }
        }
        return f;
    }

    @Nullable
    public VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.zzakd) {
            videoLifecycleCallbacks = this.zzakf;
        }
        return videoLifecycleCallbacks;
    }

    public boolean hasVideoContent() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.zzake != null;
        }
        return z;
    }

    public void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        zzac.zzb(videoLifecycleCallbacks, (Object) "VideoLifecycleCallbacks may not be null.");
        synchronized (this.zzakd) {
            this.zzakf = videoLifecycleCallbacks;
            if (this.zzake != null) {
                try {
                    this.zzake.zza(new zzap(videoLifecycleCallbacks));
                } catch (RemoteException e) {
                    zzb.zzb("Unable to call setVideoLifecycleCallbacks on video controller.", e);
                }
                return;
            }
            return;
        }
    }

    public void zza(zzab zzab) {
        synchronized (this.zzakd) {
            this.zzake = zzab;
            if (this.zzakf != null) {
                setVideoLifecycleCallbacks(this.zzakf);
            }
        }
    }

    public zzab zzdj() {
        zzab zzab;
        synchronized (this.zzakd) {
            zzab = this.zzake;
        }
        return zzab;
    }
}
