package com.google.android.gms.internal;

import java.io.IOException;

public abstract class zzark {
    protected volatile int bqE = -1;

    public static final <T extends zzark> T zza(T t, byte[] bArr) throws zzarj {
        return zzb(t, bArr, 0, bArr.length);
    }

    public static final void zza(zzark zzark, byte[] bArr, int i, int i2) {
        try {
            zzard zzc = zzard.zzc(bArr, i, i2);
            zzark.zza(zzc);
            zzc.mo9123cO();
        } catch (IOException e) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).", e);
        }
    }

    public static final <T extends zzark> T zzb(T t, byte[] bArr, int i, int i2) throws zzarj {
        try {
            zzarc zzb = zzarc.zzb(bArr, i, i2);
            t.zzb(zzb);
            zzb.zzagz(0);
            return t;
        } catch (zzarj e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public static final byte[] zzf(zzark zzark) {
        byte[] bArr = new byte[zzark.mo9192db()];
        zza(zzark, bArr, 0, bArr.length);
        return bArr;
    }

    /* renamed from: cQ */
    public zzark clone() throws CloneNotSupportedException {
        return (zzark) super.clone();
    }

    /* renamed from: da */
    public int mo9191da() {
        if (this.bqE < 0) {
            mo9192db();
        }
        return this.bqE;
    }

    /* renamed from: db */
    public int mo9192db() {
        int zzx = zzx();
        this.bqE = zzx;
        return zzx;
    }

    public String toString() {
        return zzarl.zzg(this);
    }

    public void zza(zzard zzard) throws IOException {
    }

    public abstract zzark zzb(zzarc zzarc) throws IOException;

    /* access modifiers changed from: protected */
    public int zzx() {
        return 0;
    }
}
