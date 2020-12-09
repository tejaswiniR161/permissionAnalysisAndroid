package com.google.android.gms.ads.internal;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.internal.zzap;
import com.google.android.gms.internal.zzat;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzkq;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@zziy
class zzi implements zzap, Runnable {
    private zzv zzall;
    private final List<Object[]> zzamv = new Vector();
    private final AtomicReference<zzap> zzamw = new AtomicReference<>();
    CountDownLatch zzamx = new CountDownLatch(1);

    public zzi(zzv zzv) {
        this.zzall = zzv;
        if (zzm.zzjr().zzvf()) {
            zzkq.zza((Runnable) this);
        } else {
            run();
        }
    }

    private void zzev() {
        if (!this.zzamv.isEmpty()) {
            for (Object[] next : this.zzamv) {
                if (next.length == 1) {
                    this.zzamw.get().zza((MotionEvent) next[0]);
                } else if (next.length == 3) {
                    this.zzamw.get().zza(((Integer) next[0]).intValue(), ((Integer) next[1]).intValue(), ((Integer) next[2]).intValue());
                }
            }
            this.zzamv.clear();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000f, code lost:
        r0 = r2.getApplicationContext();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.content.Context zzh(android.content.Context r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.zzde<java.lang.Boolean> r0 = com.google.android.gms.internal.zzdi.zzbba
            java.lang.Object r0 = r0.get()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x000f
        L_0x000e:
            return r2
        L_0x000f:
            android.content.Context r0 = r2.getApplicationContext()
            if (r0 == 0) goto L_0x000e
            r2 = r0
            goto L_0x000e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzi.zzh(android.content.Context):android.content.Context");
    }

    public void run() {
        try {
            zza(zzd(this.zzall.zzaqv.zzcs, zzh(this.zzall.zzahn), !zzdi.zzbbs.get().booleanValue() || this.zzall.zzaqv.zzctu));
        } finally {
            this.zzamx.countDown();
            this.zzall = null;
        }
    }

    public String zza(Context context, String str, View view) {
        zzap zzap;
        if (!zzeu() || (zzap = this.zzamw.get()) == null) {
            return "";
        }
        zzev();
        return zzap.zza(zzh(context), str, view);
    }

    public void zza(int i, int i2, int i3) {
        zzap zzap = this.zzamw.get();
        if (zzap != null) {
            zzev();
            zzap.zza(i, i2, i3);
            return;
        }
        this.zzamv.add(new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public void zza(MotionEvent motionEvent) {
        zzap zzap = this.zzamw.get();
        if (zzap != null) {
            zzev();
            zzap.zza(motionEvent);
            return;
        }
        this.zzamv.add(new Object[]{motionEvent});
    }

    /* access modifiers changed from: protected */
    public void zza(zzap zzap) {
        this.zzamw.set(zzap);
    }

    public String zzb(Context context) {
        zzap zzap;
        if (!zzeu() || (zzap = this.zzamw.get()) == null) {
            return "";
        }
        zzev();
        return zzap.zzb(zzh(context));
    }

    /* access modifiers changed from: protected */
    public zzap zzd(String str, Context context, boolean z) {
        return zzat.zza(str, context, z);
    }

    /* access modifiers changed from: protected */
    public boolean zzeu() {
        try {
            this.zzamx.await();
            return true;
        } catch (InterruptedException e) {
            zzkn.zzd("Interrupted during GADSignals creation.", e);
            return false;
        }
    }
}
