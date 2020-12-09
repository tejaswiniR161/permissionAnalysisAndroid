package com.google.android.gms.internal;

import com.google.android.gms.internal.zzb;

public class zzm<T> {
    public final T result;
    public final zzb.zza zzbf;
    public final zzr zzbg;
    public boolean zzbh;

    public interface zza {
        void zze(zzr zzr);
    }

    public interface zzb<T> {
        void zzb(T t);
    }

    private zzm(zzr zzr) {
        this.zzbh = false;
        this.result = null;
        this.zzbf = null;
        this.zzbg = zzr;
    }

    private zzm(T t, zzb.zza zza2) {
        this.zzbh = false;
        this.result = t;
        this.zzbf = zza2;
        this.zzbg = null;
    }

    public static <T> zzm<T> zza(T t, zzb.zza zza2) {
        return new zzm<>(t, zza2);
    }

    public static <T> zzm<T> zzd(zzr zzr) {
        return new zzm<>(zzr);
    }

    public boolean isSuccess() {
        return this.zzbg == null;
    }
}
