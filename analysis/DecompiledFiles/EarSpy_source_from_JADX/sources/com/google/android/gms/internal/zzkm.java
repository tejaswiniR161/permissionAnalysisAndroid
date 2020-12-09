package com.google.android.gms.internal;

import java.util.concurrent.Future;

@zziy
public abstract class zzkm implements zzkt<Future> {
    /* access modifiers changed from: private */
    public volatile Thread zzcql;
    private boolean zzcqm;
    private final Runnable zzw;

    public zzkm() {
        this.zzw = new Runnable() {
            public final void run() {
                Thread unused = zzkm.this.zzcql = Thread.currentThread();
                zzkm.this.zzfc();
            }
        };
        this.zzcqm = false;
    }

    public zzkm(boolean z) {
        this.zzw = new Runnable() {
            public final void run() {
                Thread unused = zzkm.this.zzcql = Thread.currentThread();
                zzkm.this.zzfc();
            }
        };
        this.zzcqm = z;
    }

    public final void cancel() {
        onStop();
        if (this.zzcql != null) {
            this.zzcql.interrupt();
        }
    }

    public abstract void onStop();

    public abstract void zzfc();

    /* renamed from: zzuc */
    public final Future zzqw() {
        return this.zzcqm ? zzkq.zza(1, this.zzw) : zzkq.zza(this.zzw);
    }
}
