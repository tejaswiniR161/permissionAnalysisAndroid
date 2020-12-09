package com.facebook.ads.internal.util;

import android.support.annotation.NonNull;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.facebook.ads.internal.util.p */
public class C0551p implements ThreadFactory {

    /* renamed from: a */
    protected final AtomicLong f1288a = new AtomicLong();

    /* renamed from: b */
    private int f1289b = Thread.currentThread().getPriority();

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo6137a() {
        return String.format(Locale.ENGLISH, "com.facebook.ads thread-%d %tF %<tT", new Object[]{Long.valueOf(this.f1288a.incrementAndGet()), Long.valueOf(System.currentTimeMillis())});
    }

    public Thread newThread(@NonNull Runnable runnable) {
        Thread thread = new Thread((ThreadGroup) null, runnable, mo6137a(), 0);
        thread.setPriority(this.f1289b);
        return thread;
    }
}
