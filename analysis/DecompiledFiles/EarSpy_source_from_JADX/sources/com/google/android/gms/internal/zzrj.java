package com.google.android.gms.internal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class zzrj {

    /* renamed from: ys */
    private static final ExecutorService f2180ys = new ThreadPoolExecutor(0, 4, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzsf("GAC_Transform"));

    public static ExecutorService zzarz() {
        return f2180ys;
    }
}
