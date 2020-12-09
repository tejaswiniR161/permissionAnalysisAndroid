package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;
import java.lang.reflect.InvocationTargetException;

public class zzbr extends zzbv {
    public zzbr(zzbb zzbb, String str, String str2, zzae.zza zza, int i, int i2) {
        super(zzbb, str, str2, zza, i, i2);
    }

    /* access modifiers changed from: protected */
    public void zzcy() throws IllegalAccessException, InvocationTargetException {
        synchronized (this.zzair) {
            zzba zzba = new zzba((String) this.zzaiz.invoke((Object) null, new Object[0]));
            this.zzair.zzei = zzba.zzahl;
            this.zzair.zzej = zzba.zzahm;
        }
    }
}
