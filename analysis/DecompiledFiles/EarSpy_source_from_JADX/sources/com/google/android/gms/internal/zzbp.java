package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class zzbp extends zzbv {
    private List<Long> zzaiu = null;

    public zzbp(zzbb zzbb, String str, String str2, zzae.zza zza, int i, int i2) {
        super(zzbb, str, str2, zza, i, i2);
    }

    /* access modifiers changed from: protected */
    public void zzcy() throws IllegalAccessException, InvocationTargetException {
        this.zzair.zzdq = -1L;
        this.zzair.zzdr = -1L;
        if (this.zzaiu == null) {
            this.zzaiu = (List) this.zzaiz.invoke((Object) null, new Object[]{this.zzafz.getContext()});
        }
        if (this.zzaiu != null && this.zzaiu.size() == 2) {
            synchronized (this.zzair) {
                this.zzair.zzdq = Long.valueOf(this.zzaiu.get(0).longValue());
                this.zzair.zzdr = Long.valueOf(this.zzaiu.get(1).longValue());
            }
        }
    }
}
