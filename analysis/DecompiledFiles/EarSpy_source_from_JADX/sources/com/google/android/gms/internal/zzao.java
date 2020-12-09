package com.google.android.gms.internal;

import com.google.android.gms.clearcut.zzb;
import com.google.android.gms.internal.zzad;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class zzao {
    protected static volatile zzb zzaga = null;
    private static volatile Random zzagc = null;
    private static final Object zzagd = new Object();
    private zzbb zzafz;
    protected boolean zzagb = false;

    public zzao(zzbb zzbb) {
        this.zzafz = zzbb;
        zzdi.initialize(zzbb.getContext());
        this.zzagb = zzdi.zzbem.get().booleanValue();
        if (this.zzagb && zzaga == null) {
            synchronized (zzagd) {
                if (zzaga == null) {
                    zzaga = new zzb(zzbb.getContext(), "ADSHIELD", (String) null);
                }
            }
        }
    }

    private static Random zzav() {
        if (zzagc == null) {
            synchronized (zzagd) {
                if (zzagc == null) {
                    zzagc = new Random();
                }
            }
        }
        return zzagc;
    }

    public void zza(int i, int i2, long j) throws IOException {
        try {
            if (this.zzagb && zzaga != null && this.zzafz.zzcn()) {
                zzad.zza zza = new zzad.zza();
                zza.zzck = this.zzafz.getContext().getPackageName();
                zza.zzcl = Long.valueOf(j);
                zzb.zza zzl = zzaga.zzl(zzark.zzf(zza));
                zzl.zzfi(i2);
                zzl.zzfh(i);
                zzl.zze(this.zzafz.zzcl());
            }
        } catch (Exception e) {
        }
    }

    public int zzau() {
        try {
            return ThreadLocalRandom.current().nextInt();
        } catch (NoClassDefFoundError e) {
            return zzav().nextInt();
        } catch (RuntimeException e2) {
            return zzav().nextInt();
        }
    }
}
