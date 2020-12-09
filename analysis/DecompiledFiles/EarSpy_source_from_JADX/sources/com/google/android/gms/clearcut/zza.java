package com.google.android.gms.clearcut;

import android.content.Context;

public class zza {

    /* renamed from: tF */
    private static int f1463tF = -1;

    /* renamed from: tG */
    public static final zza f1464tG = new zza();

    protected zza() {
    }

    public int zzbl(Context context) {
        if (f1463tF < 0) {
            f1463tF = context.getSharedPreferences("bootCount", 0).getInt("bootCount", 1);
        }
        return f1463tF;
    }
}
