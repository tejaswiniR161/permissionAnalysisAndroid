package com.google.android.gms.internal;

import com.google.android.gms.internal.zzlm;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@zziy
public class zzln<T> implements zzlm<T> {
    private final Object zzakd = new Object();
    protected int zzbqm = 0;
    protected final BlockingQueue<zza> zzcuk = new LinkedBlockingQueue();
    protected T zzcul;

    class zza {
        public final zzlm.zzc<T> zzcum;
        public final zzlm.zza zzcun;

        public zza(zzlm.zzc<T> zzc, zzlm.zza zza) {
            this.zzcum = zzc;
            this.zzcun = zza;
        }
    }

    public int getStatus() {
        return this.zzbqm;
    }

    public void reject() {
        synchronized (this.zzakd) {
            if (this.zzbqm != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzbqm = -1;
            for (zza zza2 : this.zzcuk) {
                zza2.zzcun.run();
            }
            this.zzcuk.clear();
        }
    }

    public void zza(zzlm.zzc<T> zzc, zzlm.zza zza2) {
        synchronized (this.zzakd) {
            if (this.zzbqm == 1) {
                zzc.zzd(this.zzcul);
            } else if (this.zzbqm == -1) {
                zza2.run();
            } else if (this.zzbqm == 0) {
                this.zzcuk.add(new zza(zzc, zza2));
            }
        }
    }

    public void zzg(T t) {
        synchronized (this.zzakd) {
            if (this.zzbqm != 0) {
                throw new UnsupportedOperationException();
            }
            this.zzcul = t;
            this.zzbqm = 1;
            for (zza zza2 : this.zzcuk) {
                zza2.zzcum.zzd(t);
            }
            this.zzcuk.clear();
        }
    }
}
