package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@zziy
public final class zzkq {
    private static final ThreadPoolExecutor zzcqx = new ThreadPoolExecutor(10, 10, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), zzcu("Default"));
    private static final ThreadPoolExecutor zzcqy = new ThreadPoolExecutor(5, 5, 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), zzcu("Loader"));

    static {
        zzcqx.allowCoreThreadTimeOut(true);
        zzcqy.allowCoreThreadTimeOut(true);
    }

    public static zzlj<Void> zza(int i, final Runnable runnable) {
        return i == 1 ? zza((ExecutorService) zzcqy, new Callable<Void>() {
            /* renamed from: zzdb */
            public Void call() {
                runnable.run();
                return null;
            }
        }) : zza((ExecutorService) zzcqx, new Callable<Void>() {
            /* renamed from: zzdb */
            public Void call() {
                runnable.run();
                return null;
            }
        });
    }

    public static zzlj<Void> zza(Runnable runnable) {
        return zza(0, runnable);
    }

    public static <T> zzlj<T> zza(Callable<T> callable) {
        return zza((ExecutorService) zzcqx, callable);
    }

    public static <T> zzlj<T> zza(ExecutorService executorService, final Callable<T> callable) {
        final zzlg zzlg = new zzlg();
        try {
            final Future<?> submit = executorService.submit(new Runnable() {
                public void run() {
                    try {
                        Process.setThreadPriority(10);
                        zzlg.this.zzh(callable.call());
                    } catch (Exception e) {
                        zzu.zzgd().zza((Throwable) e, "AdThreadPool.submit");
                        zzlg.this.zze(e);
                    }
                }
            });
            zzlg.zzd(new Runnable() {
                public void run() {
                    if (zzlg.this.isCancelled()) {
                        submit.cancel(true);
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            zzkn.zzd("Thread execution is rejected.", e);
            zzlg.cancel(true);
        }
        return zzlg;
    }

    private static ThreadFactory zzcu(final String str) {
        return new ThreadFactory() {
            private final AtomicInteger zzcrd = new AtomicInteger(1);

            public Thread newThread(Runnable runnable) {
                String str = str;
                return new Thread(runnable, new StringBuilder(String.valueOf(str).length() + 23).append("AdWorker(").append(str).append(") #").append(this.zzcrd.getAndIncrement()).toString());
            }
        };
    }
}
