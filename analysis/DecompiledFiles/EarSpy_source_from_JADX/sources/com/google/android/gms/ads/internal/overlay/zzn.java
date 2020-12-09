package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzdq;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzlt;

@zziy
public class zzn extends zzj {
    @Nullable
    public zzi zza(Context context, zzlt zzlt, int i, boolean z, zzdq zzdq) {
        if (!zzq(context)) {
            return null;
        }
        return new zzc(context, z, zzh(zzlt), new zzx(context, zzlt.zzvu(), zzlt.getRequestId(), zzdq, zzlt.zzvz()));
    }
}
