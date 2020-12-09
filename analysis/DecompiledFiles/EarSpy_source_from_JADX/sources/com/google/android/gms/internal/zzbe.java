package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;
import java.lang.reflect.InvocationTargetException;

public class zzbe extends zzbv {
    public zzbe(zzbb zzbb, String str, String str2, zzae.zza zza, int i, int i2) {
        super(zzbb, str, str2, zza, i, i2);
    }

    /* access modifiers changed from: protected */
    public void zzcy() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.zzair) {
            this.zzair.zzcu = -1L;
            this.zzair.zzcu = (Long) this.zzaiz.invoke((Object) null, new Object[]{this.zzafz.getContext()});
        }
    }
}
