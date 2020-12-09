package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;
import java.util.concurrent.Callable;

public class zzbl implements Callable {
    private final zzbb zzafz;
    private final zzae.zza zzair;

    public zzbl(zzbb zzbb, zzae.zza zza) {
        this.zzafz = zzbb;
        this.zzair = zza;
    }

    /* renamed from: zzdb */
    public Void call() throws Exception {
        if (this.zzafz.zzcq() != null) {
            this.zzafz.zzcq().get();
        }
        zzae.zza zzcp = this.zzafz.zzcp();
        if (zzcp == null) {
            return null;
        }
        try {
            synchronized (this.zzair) {
                zzark.zza(this.zzair, zzark.zzf(zzcp));
            }
            return null;
        } catch (zzarj e) {
            return null;
        }
    }
}
