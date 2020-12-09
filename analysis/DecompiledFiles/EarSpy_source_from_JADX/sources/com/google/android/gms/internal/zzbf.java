package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;
import java.lang.reflect.InvocationTargetException;

public class zzbf extends zzbv {
    private static final Object zzagd = new Object();
    private static volatile String zzaio = null;

    public zzbf(zzbb zzbb, String str, String str2, zzae.zza zza, int i, int i2) {
        super(zzbb, str, str2, zza, i, i2);
    }

    /* access modifiers changed from: protected */
    public void zzcy() throws IllegalAccessException, InvocationTargetException {
        this.zzair.zzdp = "E";
        if (zzaio == null) {
            synchronized (zzagd) {
                if (zzaio == null) {
                    zzaio = (String) this.zzaiz.invoke((Object) null, new Object[]{this.zzafz.getContext()});
                }
            }
        }
        synchronized (this.zzair) {
            this.zzair.zzdp = zzak.zza(zzaio.getBytes(), true);
        }
    }
}
