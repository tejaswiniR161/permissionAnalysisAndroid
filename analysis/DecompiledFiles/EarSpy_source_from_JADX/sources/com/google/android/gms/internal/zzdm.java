package com.google.android.gms.internal;

import android.support.annotation.Nullable;

@zziy
public class zzdm {
    @Nullable
    public static zzdo zza(@Nullable zzdq zzdq, long j) {
        if (zzdq == null) {
            return null;
        }
        return zzdq.zzc(j);
    }

    public static boolean zza(@Nullable zzdq zzdq, @Nullable zzdo zzdo, long j, String... strArr) {
        if (zzdq == null || zzdo == null) {
            return false;
        }
        return zzdq.zza(zzdo, j, strArr);
    }

    public static boolean zza(@Nullable zzdq zzdq, @Nullable zzdo zzdo, String... strArr) {
        if (zzdq == null || zzdo == null) {
            return false;
        }
        return zzdq.zza(zzdo, strArr);
    }

    @Nullable
    public static zzdo zzb(@Nullable zzdq zzdq) {
        if (zzdq == null) {
            return null;
        }
        return zzdq.zzla();
    }
}
