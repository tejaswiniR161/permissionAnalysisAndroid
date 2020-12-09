package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

@zziy
public class zzdp {
    @Nullable
    private final zzdq zzalg;
    private final Map<String, zzdo> zzbio = new HashMap();

    public zzdp(@Nullable zzdq zzdq) {
        this.zzalg = zzdq;
    }

    public void zza(String str, zzdo zzdo) {
        this.zzbio.put(str, zzdo);
    }

    public void zza(String str, String str2, long j) {
        zzdm.zza(this.zzalg, this.zzbio.get(str2), j, str);
        this.zzbio.put(str, zzdm.zza(this.zzalg, j));
    }

    @Nullable
    public zzdq zzkz() {
        return this.zzalg;
    }
}
