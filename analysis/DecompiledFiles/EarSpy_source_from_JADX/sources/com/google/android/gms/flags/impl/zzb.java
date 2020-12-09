package com.google.android.gms.flags.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.internal.zzvb;
import java.util.concurrent.Callable;

public class zzb {

    /* renamed from: UF */
    private static SharedPreferences f1927UF = null;

    public static SharedPreferences zzn(final Context context) {
        SharedPreferences sharedPreferences;
        synchronized (SharedPreferences.class) {
            if (f1927UF == null) {
                f1927UF = (SharedPreferences) zzvb.zzb(new Callable<SharedPreferences>() {
                    /* renamed from: zzbhq */
                    public SharedPreferences call() {
                        return context.getSharedPreferences("google_sdk_flags", 1);
                    }
                });
            }
            sharedPreferences = f1927UF;
        }
        return sharedPreferences;
    }
}
