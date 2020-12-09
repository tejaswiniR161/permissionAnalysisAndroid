package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;
import java.lang.reflect.InvocationTargetException;

public class zzbo extends zzbv {
    private static final Object zzagd = new Object();
    private static volatile String zzct = null;

    public zzbo(zzbb zzbb, String str, String str2, zzae.zza zza, int i, int i2) {
        super(zzbb, str, str2, zza, i, i2);
    }

    /* access modifiers changed from: protected */
    public void zzcy() throws IllegalAccessException, InvocationTargetException {
        this.zzair.zzct = "E";
        if (zzct == null) {
            synchronized (zzagd) {
                if (zzct == null) {
                    zzct = (String) this.zzaiz.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzair) {
            this.zzair.zzct = zzct;
        }
    }
}
