package com.google.android.gms.internal;

import com.google.android.gms.internal.zzaps;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class zzapv<T> extends zzaot<T> {
    private final zzaot<T> bkU;
    private final zzaob bmQ;
    private final Type bmR;

    zzapv(zzaob zzaob, zzaot<T> zzaot, Type type) {
        this.bmQ = zzaob;
        this.bkU = zzaot;
        this.bmR = type;
    }

    private Type zzb(Type type, Object obj) {
        return obj != null ? (type == Object.class || (type instanceof TypeVariable) || (type instanceof Class)) ? obj.getClass() : type : type;
    }

    public void zza(zzaqa zzaqa, T t) throws IOException {
        zzaot<T> zzaot = this.bkU;
        Type zzb = zzb(this.bmR, t);
        if (zzb != this.bmR) {
            zzaot = this.bmQ.zza(zzapx.zzl(zzb));
            if ((zzaot instanceof zzaps.zza) && !(this.bkU instanceof zzaps.zza)) {
                zzaot = this.bkU;
            }
        }
        zzaot.zza(zzaqa, t);
    }

    public T zzb(zzapy zzapy) throws IOException {
        return this.bkU.zzb(zzapy);
    }
}
