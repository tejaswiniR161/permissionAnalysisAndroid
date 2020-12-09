package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.reward.client.zza;
import com.google.android.gms.common.internal.zzab;

@zziy
public class zzjp extends zza.C1261zza {
    private final String zzcln;
    private final int zzcms;

    public zzjp(String str, int i) {
        this.zzcln = str;
        this.zzcms = i;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof zzjp)) {
            return false;
        }
        zzjp zzjp = (zzjp) obj;
        return zzab.equal(getType(), zzjp.getType()) && zzab.equal(Integer.valueOf(getAmount()), Integer.valueOf(zzjp.getAmount()));
    }

    public int getAmount() {
        return this.zzcms;
    }

    public String getType() {
        return this.zzcln;
    }
}
