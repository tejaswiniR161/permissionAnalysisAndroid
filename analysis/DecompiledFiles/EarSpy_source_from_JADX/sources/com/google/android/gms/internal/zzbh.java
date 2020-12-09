package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;
import java.lang.reflect.InvocationTargetException;

public class zzbh extends zzbv {
    public zzbh(zzbb zzbb, String str, String str2, zzae.zza zza, int i, int i2) {
        super(zzbb, str, str2, zza, i, i2);
    }

    /* access modifiers changed from: protected */
    public void zzcy() throws IllegalAccessException, InvocationTargetException {
        this.zzair.zzcw = -1L;
        this.zzair.zzcx = -1L;
        int[] iArr = (int[]) this.zzaiz.invoke((Object) null, new Object[]{this.zzafz.getContext()});
        synchronized (this.zzair) {
            this.zzair.zzcw = Long.valueOf((long) iArr[0]);
            this.zzair.zzcx = Long.valueOf((long) iArr[1]);
        }
    }
}
