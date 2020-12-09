package com.google.android.gms.internal;

import android.content.Context;

public class zzsi {

    /* renamed from: Fj */
    private static zzsi f2243Fj = new zzsi();

    /* renamed from: Fi */
    private zzsh f2244Fi = null;

    public static zzsh zzcr(Context context) {
        return f2243Fj.zzcq(context);
    }

    public synchronized zzsh zzcq(Context context) {
        if (this.f2244Fi == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f2244Fi = new zzsh(context);
        }
        return this.f2244Fi;
    }
}
