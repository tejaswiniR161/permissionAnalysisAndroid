package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzac;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class zzsf implements ThreadFactory {

    /* renamed from: Ff */
    private final String f2240Ff;

    /* renamed from: Fg */
    private final AtomicInteger f2241Fg;

    /* renamed from: Fh */
    private final ThreadFactory f2242Fh;
    private final int mPriority;

    public zzsf(String str) {
        this(str, 0);
    }

    public zzsf(String str, int i) {
        this.f2241Fg = new AtomicInteger();
        this.f2242Fh = Executors.defaultThreadFactory();
        this.f2240Ff = (String) zzac.zzb(str, (Object) "Name must not be null");
        this.mPriority = i;
    }

    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f2242Fh.newThread(new zzsg(runnable, this.mPriority));
        String str = this.f2240Ff;
        newThread.setName(new StringBuilder(String.valueOf(str).length() + 13).append(str).append("[").append(this.f2241Fg.getAndIncrement()).append("]").toString());
        return newThread;
    }
}
