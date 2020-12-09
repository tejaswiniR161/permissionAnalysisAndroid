package com.google.android.gms.internal;

import java.io.IOException;

final class zzaos<T> extends zzaot<T> {
    private zzaot<T> bkU;
    private final zzaop<T> blj;
    private final zzaog<T> blk;
    private final zzaob bll;
    private final zzapx<T> blm;
    private final zzaou bln;

    private static class zza implements zzaou {
        private final zzaop<?> blj;
        private final zzaog<?> blk;
        private final zzapx<?> blo;
        private final boolean blp;
        private final Class<?> blq;

        private zza(Object obj, zzapx<?> zzapx, boolean z, Class<?> cls) {
            this.blj = obj instanceof zzaop ? (zzaop) obj : null;
            this.blk = obj instanceof zzaog ? (zzaog) obj : null;
            zzaoz.zzbs((this.blj == null && this.blk == null) ? false : true);
            this.blo = zzapx;
            this.blp = z;
            this.blq = cls;
        }

        public <T> zzaot<T> zza(zzaob zzaob, zzapx<T> zzapx) {
            if (this.blo != null ? this.blo.equals(zzapx) || (this.blp && this.blo.mo9068bz() == zzapx.mo9067by()) : this.blq.isAssignableFrom(zzapx.mo9067by())) {
                return new zzaos(this.blj, this.blk, zzaob, zzapx, this);
            }
            return null;
        }
    }

    private zzaos(zzaop<T> zzaop, zzaog<T> zzaog, zzaob zzaob, zzapx<T> zzapx, zzaou zzaou) {
        this.blj = zzaop;
        this.blk = zzaog;
        this.bll = zzaob;
        this.blm = zzapx;
        this.bln = zzaou;
    }

    /* renamed from: bd */
    private zzaot<T> m1377bd() {
        zzaot<T> zzaot = this.bkU;
        if (zzaot != null) {
            return zzaot;
        }
        zzaot<T> zza2 = this.bll.zza(this.bln, this.blm);
        this.bkU = zza2;
        return zza2;
    }

    public static zzaou zza(zzapx<?> zzapx, Object obj) {
        return new zza(obj, zzapx, false, (Class) null);
    }

    public static zzaou zzb(zzapx<?> zzapx, Object obj) {
        return new zza(obj, zzapx, zzapx.mo9068bz() == zzapx.mo9067by(), (Class) null);
    }

    public void zza(zzaqa zzaqa, T t) throws IOException {
        if (this.blj == null) {
            m1377bd().zza(zzaqa, t);
        } else if (t == null) {
            zzaqa.mo8990bx();
        } else {
            zzapi.zzb(this.blj.zza(t, this.blm.mo9068bz(), this.bll.bkS), zzaqa);
        }
    }

    public T zzb(zzapy zzapy) throws IOException {
        if (this.blk == null) {
            return m1377bd().zzb(zzapy);
        }
        zzaoh zzh = zzapi.zzh(zzapy);
        if (zzh.mo8851aV()) {
            return null;
        }
        try {
            return this.blk.zzb(zzh, this.blm.mo9068bz(), this.bll.bkR);
        } catch (zzaol e) {
            throw e;
        } catch (Exception e2) {
            throw new zzaol((Throwable) e2);
        }
    }
}
