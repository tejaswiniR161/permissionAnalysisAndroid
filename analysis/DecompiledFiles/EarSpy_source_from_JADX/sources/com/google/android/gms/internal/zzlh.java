package com.google.android.gms.internal;

import java.util.concurrent.TimeUnit;

@zziy
public class zzlh<T> implements zzlj<T> {
    private final T zzctv;
    private final zzlk zzcty = new zzlk();

    public zzlh(T t) {
        this.zzctv = t;
        this.zzcty.zzvi();
    }

    public boolean cancel(boolean z) {
        return false;
    }

    public T get() {
        return this.zzctv;
    }

    public T get(long j, TimeUnit timeUnit) {
        return this.zzctv;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean isDone() {
        return true;
    }

    public void zzc(Runnable runnable) {
        this.zzcty.zzc(runnable);
    }
}
