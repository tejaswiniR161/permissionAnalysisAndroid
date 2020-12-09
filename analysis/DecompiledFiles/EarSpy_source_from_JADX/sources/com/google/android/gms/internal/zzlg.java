package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zziy
public class zzlg<T> implements zzlj<T> {
    private final Object zzakd = new Object();
    private boolean zzbto;
    private T zzctv;
    private Throwable zzctw;
    private boolean zzctx;
    private final zzlk zzcty = new zzlk();

    private boolean zzvh() {
        return this.zzctw != null || this.zzctx;
    }

    public boolean cancel(boolean z) {
        if (!z) {
            return false;
        }
        synchronized (this.zzakd) {
            if (zzvh()) {
                return false;
            }
            this.zzbto = true;
            this.zzctx = true;
            this.zzakd.notifyAll();
            this.zzcty.zzvi();
            return true;
        }
    }

    public T get() throws CancellationException, ExecutionException, InterruptedException {
        T t;
        synchronized (this.zzakd) {
            if (!zzvh()) {
                try {
                    this.zzakd.wait();
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (this.zzctw != null) {
                throw new ExecutionException(this.zzctw);
            } else if (this.zzbto) {
                throw new CancellationException("CallbackFuture was cancelled.");
            } else {
                t = this.zzctv;
            }
        }
        return t;
    }

    public T get(long j, TimeUnit timeUnit) throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
        T t;
        synchronized (this.zzakd) {
            if (!zzvh()) {
                try {
                    long millis = timeUnit.toMillis(j);
                    if (millis != 0) {
                        this.zzakd.wait(millis);
                    }
                } catch (InterruptedException e) {
                    throw e;
                }
            }
            if (this.zzctw != null) {
                throw new ExecutionException(this.zzctw);
            } else if (!this.zzctx) {
                throw new TimeoutException("CallbackFuture timed out.");
            } else if (this.zzbto) {
                throw new CancellationException("CallbackFuture was cancelled.");
            } else {
                t = this.zzctv;
            }
        }
        return t;
    }

    public boolean isCancelled() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.zzbto;
        }
        return z;
    }

    public boolean isDone() {
        boolean zzvh;
        synchronized (this.zzakd) {
            zzvh = zzvh();
        }
        return zzvh;
    }

    public void zzc(Runnable runnable) {
        this.zzcty.zzc(runnable);
    }

    public void zzd(Runnable runnable) {
        this.zzcty.zzd(runnable);
    }

    public void zze(Throwable th) {
        synchronized (this.zzakd) {
            if (!this.zzbto) {
                if (zzvh()) {
                    zzu.zzgd().zza((Throwable) new IllegalStateException("Provided CallbackFuture with multiple values."), "CallbackFuture.provideException");
                    return;
                }
                this.zzctw = th;
                this.zzakd.notifyAll();
                this.zzcty.zzvi();
            }
        }
    }

    public void zzh(@Nullable T t) {
        synchronized (this.zzakd) {
            if (!this.zzbto) {
                if (zzvh()) {
                    zzu.zzgd().zza((Throwable) new IllegalStateException("Provided CallbackFuture with multiple values."), "CallbackFuture.provideValue");
                    return;
                }
                this.zzctx = true;
                this.zzctv = t;
                this.zzakd.notifyAll();
                this.zzcty.zzvi();
            }
        }
    }
}
