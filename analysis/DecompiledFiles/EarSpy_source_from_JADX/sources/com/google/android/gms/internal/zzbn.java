package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;
import java.lang.reflect.InvocationTargetException;

public class zzbn extends zzbv {
    private long zzait = -1;

    public zzbn(zzbb zzbb, String str, String str2, zzae.zza zza, int i, int i2) {
        super(zzbb, str, str2, zza, i, i2);
    }

    /* access modifiers changed from: protected */
    public void zzcy() throws IllegalAccessException, InvocationTargetException {
        this.zzair.zzdd = -1L;
        if (this.zzait == -1) {
            this.zzait = (long) ((Integer) this.zzaiz.invoke((Object) null, new Object[]{this.zzafz.getContext()})).intValue();
        }
        synchronized (this.zzair) {
            this.zzair.zzdd = Long.valueOf(this.zzait);
        }
    }
}
