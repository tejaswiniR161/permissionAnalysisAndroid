package com.google.android.gms.internal;

import com.google.android.gms.internal.zzae;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public abstract class zzbv implements Callable {
    protected final String TAG = getClass().getSimpleName();
    protected final String className;
    protected final zzbb zzafz;
    protected final zzae.zza zzair;
    protected final String zzaix;
    protected Method zzaiz;
    protected final int zzajd;
    protected final int zzaje;

    public zzbv(zzbb zzbb, String str, String str2, zzae.zza zza, int i, int i2) {
        this.zzafz = zzbb;
        this.className = str;
        this.zzaix = str2;
        this.zzair = zza;
        this.zzajd = i;
        this.zzaje = i2;
    }

    /* access modifiers changed from: protected */
    public abstract void zzcy() throws IllegalAccessException, InvocationTargetException;

    /* renamed from: zzdb */
    public Void call() throws Exception {
        try {
            long nanoTime = System.nanoTime();
            this.zzaiz = this.zzafz.zzc(this.className, this.zzaix);
            if (this.zzaiz != null) {
                zzcy();
                zzao zzco = this.zzafz.zzco();
                if (!(zzco == null || this.zzajd == Integer.MIN_VALUE)) {
                    zzco.zza(this.zzaje, this.zzajd, (System.nanoTime() - nanoTime) / 1000);
                }
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
        }
        return null;
    }
}
