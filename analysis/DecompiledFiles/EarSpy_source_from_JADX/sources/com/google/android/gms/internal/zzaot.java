package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzaot<T> {
    public abstract void zza(zzaqa zzaqa, T t) throws IOException;

    public abstract T zzb(zzapy zzapy) throws IOException;

    public final zzaoh zzco(T t) {
        try {
            zzapp zzapp = new zzapp();
            zza(zzapp, t);
            return zzapp.mo8985br();
        } catch (IOException e) {
            throw new zzaoi((Throwable) e);
        }
    }
}
