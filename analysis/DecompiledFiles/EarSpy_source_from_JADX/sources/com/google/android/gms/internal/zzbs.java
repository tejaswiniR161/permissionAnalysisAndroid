package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;
import java.lang.reflect.InvocationTargetException;

public class zzbs extends zzbv {
    private static final Object zzagd = new Object();
    private static volatile Long zzaiw = null;

    public zzbs(zzbb zzbb, String str, String str2, zzae.zza zza, int i, int i2) {
        super(zzbb, str, str2, zza, i, i2);
    }

    /* access modifiers changed from: protected */
    public void zzcy() throws IllegalAccessException, InvocationTargetException {
        if (zzaiw == null) {
            synchronized (zzagd) {
                if (zzaiw == null) {
                    zzaiw = (Long) this.zzaiz.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzair) {
            this.zzair.zzds = zzaiw;
        }
    }
}
