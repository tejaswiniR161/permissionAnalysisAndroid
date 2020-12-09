package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;
import java.lang.reflect.InvocationTargetException;

public class zzbj extends zzbv {
    private long startTime;

    public zzbj(zzbb zzbb, String str, String str2, zzae.zza zza, long j, int i, int i2) {
        super(zzbb, str, str2, zza, i, i2);
        this.startTime = j;
    }

    /* access modifiers changed from: protected */
    public void zzcy() throws IllegalAccessException, InvocationTargetException {
        long longValue = ((Long) this.zzaiz.invoke((Object) null, new Object[0])).longValue();
        synchronized (this.zzair) {
            this.zzair.zzew = Long.valueOf(longValue);
            if (this.startTime != 0) {
                this.zzair.zzdi = Long.valueOf(longValue - this.startTime);
                this.zzair.zzdn = Long.valueOf(this.startTime);
            }
        }
    }
}
