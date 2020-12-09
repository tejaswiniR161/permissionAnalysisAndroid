package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;

class zzah {
    private final zze zzapy;
    private long zzbtl;

    public zzah(zze zze) {
        zzac.zzy(zze);
        this.zzapy = zze;
    }

    public void clear() {
        this.zzbtl = 0;
    }

    public void start() {
        this.zzbtl = this.zzapy.elapsedRealtime();
    }

    public boolean zzz(long j) {
        return this.zzbtl == 0 || this.zzapy.elapsedRealtime() - this.zzbtl >= j;
    }
}
