package com.google.android.gms.ads.internal.request;

import com.google.android.gms.ads.internal.request.zzc;
import com.google.android.gms.ads.internal.request.zzl;
import com.google.android.gms.internal.zziy;
import java.lang.ref.WeakReference;

@zziy
public final class zzg extends zzl.zza {
    private final WeakReference<zzc.zza> zzcha;

    public zzg(zzc.zza zza) {
        this.zzcha = new WeakReference<>(zza);
    }

    public void zzb(AdResponseParcel adResponseParcel) {
        zzc.zza zza = (zzc.zza) this.zzcha.get();
        if (zza != null) {
            zza.zzb(adResponseParcel);
        }
    }
}
