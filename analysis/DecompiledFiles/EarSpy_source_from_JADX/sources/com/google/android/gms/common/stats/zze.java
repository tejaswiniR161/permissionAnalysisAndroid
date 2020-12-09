package com.google.android.gms.common.stats;

import android.os.SystemClock;
import android.support.p000v4.util.SimpleArrayMap;
import android.util.Log;

public class zze {

    /* renamed from: Ev */
    private final long f1846Ev;

    /* renamed from: Ew */
    private final int f1847Ew;

    /* renamed from: Ex */
    private final SimpleArrayMap<String, Long> f1848Ex;

    public zze() {
        this.f1846Ev = 60000;
        this.f1847Ew = 10;
        this.f1848Ex = new SimpleArrayMap<>(10);
    }

    public zze(int i, long j) {
        this.f1846Ev = j;
        this.f1847Ew = i;
        this.f1848Ex = new SimpleArrayMap<>();
    }

    private void zze(long j, long j2) {
        for (int size = this.f1848Ex.size() - 1; size >= 0; size--) {
            if (j2 - this.f1848Ex.valueAt(size).longValue() > j) {
                this.f1848Ex.removeAt(size);
            }
        }
    }

    public Long zzif(String str) {
        Long put;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.f1846Ev;
        synchronized (this) {
            while (this.f1848Ex.size() >= this.f1847Ew) {
                zze(j, elapsedRealtime);
                j /= 2;
                Log.w("ConnectionTracker", new StringBuilder(94).append("The max capacity ").append(this.f1847Ew).append(" is not enough. Current durationThreshold is: ").append(j).toString());
            }
            put = this.f1848Ex.put(str, Long.valueOf(elapsedRealtime));
        }
        return put;
    }

    public boolean zzig(String str) {
        boolean z;
        synchronized (this) {
            z = this.f1848Ex.remove(str) != null;
        }
        return z;
    }
}
