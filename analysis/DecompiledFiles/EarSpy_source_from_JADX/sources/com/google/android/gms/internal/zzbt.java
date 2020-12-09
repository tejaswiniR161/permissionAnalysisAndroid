package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;
import java.lang.reflect.InvocationTargetException;

public class zzbt extends zzbv {
    public zzbt(zzbb zzbb, String str, String str2, zzae.zza zza, int i, int i2) {
        super(zzbb, str, str2, zza, i, i2);
    }

    /* access modifiers changed from: protected */
    public void zzcy() throws IllegalAccessException, InvocationTargetException {
        this.zzair.zzeg = 2;
        boolean booleanValue = ((Boolean) this.zzaiz.invoke((Object) null, new Object[]{this.zzafz.getApplicationContext()})).booleanValue();
        synchronized (this.zzair) {
            if (booleanValue) {
                this.zzair.zzeg = 1;
            } else {
                this.zzair.zzeg = 0;
            }
        }
    }
}
