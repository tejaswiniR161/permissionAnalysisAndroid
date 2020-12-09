package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzu;

@zziy
public class zzfh extends zzkm {
    final zzlt zzbkr;
    final zzfj zzbns;
    private final String zzbnt;

    zzfh(zzlt zzlt, zzfj zzfj, String str) {
        this.zzbkr = zzlt;
        this.zzbns = zzfj;
        this.zzbnt = str;
        zzu.zzgw().zza(this);
    }

    public void onStop() {
        this.zzbns.abort();
    }

    public void zzfc() {
        try {
            this.zzbns.zzbc(this.zzbnt);
        } finally {
            zzkr.zzcrf.post(new Runnable() {
                public void run() {
                    zzu.zzgw().zzb(zzfh.this);
                }
            });
        }
    }
}
