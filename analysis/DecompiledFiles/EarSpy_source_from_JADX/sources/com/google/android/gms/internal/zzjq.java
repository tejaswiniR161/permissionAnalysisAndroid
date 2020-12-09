package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.zzb;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.dynamic.zze;

@zziy
public class zzjq extends zzb.zza {
    private final Context mContext;
    private final Object zzakd;
    private final VersionInfoParcel zzanh;
    private final zzjr zzcmt;

    zzjq(Context context, VersionInfoParcel versionInfoParcel, zzjr zzjr) {
        this.zzakd = new Object();
        this.mContext = context;
        this.zzanh = versionInfoParcel;
        this.zzcmt = zzjr;
    }

    public zzjq(Context context, zzd zzd, zzgq zzgq, VersionInfoParcel versionInfoParcel) {
        this(context, versionInfoParcel, new zzjr(context, zzd, AdSizeParcel.zzjc(), zzgq, versionInfoParcel));
    }

    public void destroy() {
        zzh((com.google.android.gms.dynamic.zzd) null);
    }

    public boolean isLoaded() {
        boolean isLoaded;
        synchronized (this.zzakd) {
            isLoaded = this.zzcmt.isLoaded();
        }
        return isLoaded;
    }

    public void pause() {
        zzf((com.google.android.gms.dynamic.zzd) null);
    }

    public void resume() {
        zzg((com.google.android.gms.dynamic.zzd) null);
    }

    public void setUserId(String str) {
        zzkn.zzdf("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
    }

    public void show() {
        synchronized (this.zzakd) {
            this.zzcmt.zzsn();
        }
    }

    public void zza(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel) {
        synchronized (this.zzakd) {
            this.zzcmt.zza(rewardedVideoAdRequestParcel);
        }
    }

    public void zza(com.google.android.gms.ads.internal.reward.client.zzd zzd) {
        synchronized (this.zzakd) {
            this.zzcmt.zza(zzd);
        }
    }

    public void zzf(com.google.android.gms.dynamic.zzd zzd) {
        synchronized (this.zzakd) {
            this.zzcmt.pause();
        }
    }

    public void zzg(com.google.android.gms.dynamic.zzd zzd) {
        synchronized (this.zzakd) {
            Context context = zzd == null ? null : (Context) zze.zzae(zzd);
            if (context != null) {
                try {
                    this.zzcmt.onContextChanged(context);
                } catch (Exception e) {
                    zzkn.zzd("Unable to extract updated context.", e);
                }
            }
            this.zzcmt.resume();
        }
    }

    public void zzh(com.google.android.gms.dynamic.zzd zzd) {
        synchronized (this.zzakd) {
            this.zzcmt.destroy();
        }
    }
}
