package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;
import java.lang.reflect.InvocationTargetException;

public class zzbi extends zzbv {
    private static final Object zzagd = new Object();
    private static volatile Long zzec = null;

    public zzbi(zzbb zzbb, String str, String str2, zzae.zza zza, int i, int i2) {
        super(zzbb, str, str2, zza, i, i2);
    }

    /* access modifiers changed from: protected */
    public void zzcy() throws IllegalAccessException, InvocationTargetException {
        if (zzec == null) {
            synchronized (zzagd) {
                if (zzec == null) {
                    zzec = (Long) this.zzaiz.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzair) {
            this.zzair.zzec = zzec;
        }
    }
}
