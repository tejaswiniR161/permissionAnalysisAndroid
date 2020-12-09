package com.google.android.gms.common.util;

import android.os.SystemClock;

public final class zzh implements zze {

    /* renamed from: EK */
    private static zzh f1852EK;

    public static synchronized zze zzaxj() {
        zzh zzh;
        synchronized (zzh.class) {
            if (f1852EK == null) {
                f1852EK = new zzh();
            }
            zzh = f1852EK;
        }
        return zzh;
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public long nanoTime() {
        return System.nanoTime();
    }
}
