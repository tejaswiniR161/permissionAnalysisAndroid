package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.zza;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zziy
public class zzjw extends zza.C1266zza {
    private volatile zzjx zzcnb;
    private volatile zzju zzcnn;
    private volatile zzjv zzcno;

    public zzjw(zzjv zzjv) {
        this.zzcno = zzjv;
    }

    public void zza(zzd zzd, RewardItemParcel rewardItemParcel) {
        if (this.zzcno != null) {
            this.zzcno.zzc(rewardItemParcel);
        }
    }

    public void zza(zzju zzju) {
        this.zzcnn = zzju;
    }

    public void zza(zzjx zzjx) {
        this.zzcnb = zzjx;
    }

    public void zzb(zzd zzd, int i) {
        if (this.zzcnn != null) {
            this.zzcnn.zzay(i);
        }
    }

    public void zzc(zzd zzd, int i) {
        if (this.zzcnb != null) {
            this.zzcnb.zza(zze.zzae(zzd).getClass().getName(), i);
        }
    }

    public void zzq(zzd zzd) {
        if (this.zzcnn != null) {
            this.zzcnn.zzsr();
        }
    }

    public void zzr(zzd zzd) {
        if (this.zzcnb != null) {
            this.zzcnb.zzcm(zze.zzae(zzd).getClass().getName());
        }
    }

    public void zzs(zzd zzd) {
        if (this.zzcno != null) {
            this.zzcno.onRewardedVideoAdOpened();
        }
    }

    public void zzt(zzd zzd) {
        if (this.zzcno != null) {
            this.zzcno.onRewardedVideoStarted();
        }
    }

    public void zzu(zzd zzd) {
        if (this.zzcno != null) {
            this.zzcno.onRewardedVideoAdClosed();
        }
    }

    public void zzv(zzd zzd) {
        if (this.zzcno != null) {
            this.zzcno.zzso();
        }
    }

    public void zzw(zzd zzd) {
        if (this.zzcno != null) {
            this.zzcno.onRewardedVideoAdLeftApplication();
        }
    }
}
