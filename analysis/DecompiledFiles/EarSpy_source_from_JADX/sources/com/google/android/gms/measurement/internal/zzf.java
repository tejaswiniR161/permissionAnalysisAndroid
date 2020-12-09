package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.zzac;

abstract class zzf {

    /* renamed from: bY */
    private static volatile Handler f2283bY;
    /* access modifiers changed from: private */
    public final zzx anq;
    /* access modifiers changed from: private */
    public boolean aol = true;
    /* access modifiers changed from: private */

    /* renamed from: bZ */
    public volatile long f2284bZ;
    private final Runnable zzw = new Runnable() {
        public void run() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                zzf.this.anq.zzbvf().zzm(this);
                return;
            }
            boolean zzfl = zzf.this.zzfl();
            long unused = zzf.this.f2284bZ = 0;
            if (zzfl && zzf.this.aol) {
                zzf.this.run();
            }
        }
    };

    zzf(zzx zzx) {
        zzac.zzy(zzx);
        this.anq = zzx;
    }

    private Handler getHandler() {
        Handler handler;
        if (f2283bY != null) {
            return f2283bY;
        }
        synchronized (zzf.class) {
            if (f2283bY == null) {
                f2283bY = new Handler(this.anq.getContext().getMainLooper());
            }
            handler = f2283bY;
        }
        return handler;
    }

    public void cancel() {
        this.f2284bZ = 0;
        getHandler().removeCallbacks(this.zzw);
    }

    public abstract void run();

    public boolean zzfl() {
        return this.f2284bZ != 0;
    }

    public void zzx(long j) {
        cancel();
        if (j >= 0) {
            this.f2284bZ = this.anq.zzaan().currentTimeMillis();
            if (!getHandler().postDelayed(this.zzw, j)) {
                this.anq.zzbvg().zzbwc().zzj("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }
}
