package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.formats.zzi;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zzke;
import java.util.List;

@zziy
public class zzin extends zzkm {
    /* access modifiers changed from: private */
    public final zzil.zza zzccj;
    private final zzke.zza zzcck;
    private final AdResponseParcel zzccl = this.zzcck.zzcop;

    public zzin(zzke.zza zza, zzil.zza zza2) {
        this.zzcck = zza;
        this.zzccj = zza2;
    }

    private zzke zzan(int i) {
        return new zzke(this.zzcck.zzcix.zzcfu, (zzlt) null, (List<String>) null, i, (List<String>) null, (List<String>) null, this.zzccl.orientation, this.zzccl.zzbsj, this.zzcck.zzcix.zzcfx, false, (zzgg) null, (zzgr) null, (String) null, (zzgh) null, (zzgj) null, this.zzccl.zzchd, this.zzcck.zzaqz, this.zzccl.zzchb, this.zzcck.zzcoj, this.zzccl.zzchg, this.zzccl.zzchh, this.zzcck.zzcod, (zzi.zza) null, (RewardItemParcel) null, (List<String>) null, (List<String>) null, this.zzcck.zzcop.zzchu, this.zzcck.zzcop.zzchv, (String) null, (List<String>) null, (String) null);
    }

    public void onStop() {
    }

    public void zzfc() {
        final zzke zzan = zzan(0);
        zzkr.zzcrf.post(new Runnable() {
            public void run() {
                zzin.this.zzccj.zzb(zzan);
            }
        });
    }
}
