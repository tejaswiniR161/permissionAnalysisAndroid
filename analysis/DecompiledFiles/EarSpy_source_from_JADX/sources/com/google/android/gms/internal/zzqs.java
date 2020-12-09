package com.google.android.gms.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class zzqs {

    /* renamed from: ys */
    private static final ExecutorService f2119ys = Executors.newFixedThreadPool(2, new zzsf("GAC_Executor"));

    public static ExecutorService zzarz() {
        return f2119ys;
    }
}
