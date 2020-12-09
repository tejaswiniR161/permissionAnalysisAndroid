package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzu;

@zziy
public class zzlc {
    private Object zzakd = new Object();
    private long zzcta;
    private long zzctb = Long.MIN_VALUE;

    public zzlc(long j) {
        this.zzcta = j;
    }

    public boolean tryAcquire() {
        boolean z;
        synchronized (this.zzakd) {
            long elapsedRealtime = zzu.zzgf().elapsedRealtime();
            if (this.zzctb + this.zzcta > elapsedRealtime) {
                z = false;
            } else {
                this.zzctb = elapsedRealtime;
                z = true;
            }
        }
        return z;
    }
}
