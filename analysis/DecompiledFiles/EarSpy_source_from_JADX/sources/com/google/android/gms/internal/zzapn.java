package com.google.android.gms.internal;

public final class zzapn implements zzaou {
    private final zzapb bkM;

    public zzapn(zzapb zzapb) {
        this.bkM = zzapb;
    }

    static zzaot<?> zza(zzapb zzapb, zzaob zzaob, zzapx<?> zzapx, zzaov zzaov) {
        Class<?> value = zzaov.value();
        if (zzaot.class.isAssignableFrom(value)) {
            return (zzaot) zzapb.zzb(zzapx.zzr(value)).mo8901bg();
        }
        if (zzaou.class.isAssignableFrom(value)) {
            return ((zzaou) zzapb.zzb(zzapx.zzr(value)).mo8901bg()).zza(zzaob, zzapx);
        }
        throw new IllegalArgumentException("@JsonAdapter value must be TypeAdapter or TypeAdapterFactory reference.");
    }

    public <T> zzaot<T> zza(zzaob zzaob, zzapx<T> zzapx) {
        zzaov zzaov = (zzaov) zzapx.mo9067by().getAnnotation(zzaov.class);
        if (zzaov == null) {
            return null;
        }
        return zza(this.bkM, zzaob, zzapx, zzaov);
    }
}
