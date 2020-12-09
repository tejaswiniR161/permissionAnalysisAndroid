package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;
import java.lang.reflect.InvocationTargetException;

public class zzbq extends zzbv {
    private final StackTraceElement[] zzaiv;

    public zzbq(zzbb zzbb, String str, String str2, zzae.zza zza, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzbb, str, str2, zza, i, i2);
        this.zzaiv = stackTraceElementArr;
    }

    /* access modifiers changed from: protected */
    public void zzcy() throws IllegalAccessException, InvocationTargetException {
        if (this.zzaiv != null) {
            zzaz zzaz = new zzaz((String) this.zzaiz.invoke((Object) null, new Object[]{this.zzaiv}));
            synchronized (this.zzair) {
                this.zzair.zzed = zzaz.zzahi;
                if (zzaz.zzahj.booleanValue()) {
                    this.zzair.zzen = Integer.valueOf(zzaz.zzahk.booleanValue() ? 0 : 1);
                }
            }
        }
    }
}
