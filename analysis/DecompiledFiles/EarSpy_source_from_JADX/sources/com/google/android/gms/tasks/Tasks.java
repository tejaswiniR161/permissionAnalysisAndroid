package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzac;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Tasks {

    private static final class zza implements zzb {
        private final CountDownLatch zzamx;

        private zza() {
            this.zzamx = new CountDownLatch(1);
        }

        public void await() throws InterruptedException {
            this.zzamx.await();
        }

        public boolean await(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.zzamx.await(j, timeUnit);
        }

        public void onFailure(@NonNull Exception exc) {
            this.zzamx.countDown();
        }

        public void onSuccess(Object obj) {
            this.zzamx.countDown();
        }
    }

    interface zzb extends OnFailureListener, OnSuccessListener<Object> {
    }

    private static final class zzc implements zzb {
        private final zzh<Void> aJH;
        private Exception aJM;
        private final int aJO;
        private int aJP;
        private int aJQ;
        private final Object zzakd = new Object();

        public zzc(int i, zzh<Void> zzh) {
            this.aJO = i;
            this.aJH = zzh;
        }

        private void zzclk() {
            if (this.aJP + this.aJQ != this.aJO) {
                return;
            }
            if (this.aJM == null) {
                this.aJH.setResult(null);
                return;
            }
            zzh<Void> zzh = this.aJH;
            int i = this.aJQ;
            zzh.setException(new ExecutionException(new StringBuilder(54).append(i).append(" out of ").append(this.aJO).append(" underlying tasks failed").toString(), this.aJM));
        }

        public void onFailure(@NonNull Exception exc) {
            synchronized (this.zzakd) {
                this.aJQ++;
                this.aJM = exc;
                zzclk();
            }
        }

        public void onSuccess(Object obj) {
            synchronized (this.zzakd) {
                this.aJP++;
                zzclk();
            }
        }
    }

    private Tasks() {
    }

    public static <TResult> TResult await(@NonNull Task<TResult> task) throws ExecutionException, InterruptedException {
        zzac.zzavb();
        zzac.zzb(task, (Object) "Task must not be null");
        if (task.isComplete()) {
            return zzb(task);
        }
        zza zza2 = new zza();
        zza(task, zza2);
        zza2.await();
        return zzb(task);
    }

    public static <TResult> TResult await(@NonNull Task<TResult> task, long j, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        zzac.zzavb();
        zzac.zzb(task, (Object) "Task must not be null");
        zzac.zzb(timeUnit, (Object) "TimeUnit must not be null");
        if (task.isComplete()) {
            return zzb(task);
        }
        zza zza2 = new zza();
        zza(task, zza2);
        if (zza2.await(j, timeUnit)) {
            return zzb(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static <TResult> Task<TResult> call(@NonNull Callable<TResult> callable) {
        return call(TaskExecutors.MAIN_THREAD, callable);
    }

    public static <TResult> Task<TResult> call(@NonNull Executor executor, @NonNull final Callable<TResult> callable) {
        zzac.zzb(executor, (Object) "Executor must not be null");
        zzac.zzb(callable, (Object) "Callback must not be null");
        final zzh zzh = new zzh();
        executor.execute(new Runnable() {
            public void run() {
                try {
                    zzh.this.setResult(callable.call());
                } catch (Exception e) {
                    zzh.this.setException(e);
                }
            }
        });
        return zzh;
    }

    public static <TResult> Task<TResult> forException(@NonNull Exception exc) {
        zzh zzh = new zzh();
        zzh.setException(exc);
        return zzh;
    }

    public static <TResult> Task<TResult> forResult(TResult tresult) {
        zzh zzh = new zzh();
        zzh.setResult(tresult);
        return zzh;
    }

    public static Task<Void> whenAll(Collection<? extends Task<?>> collection) {
        if (collection.isEmpty()) {
            return forResult((Object) null);
        }
        for (Task task : collection) {
            if (task == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        zzh zzh = new zzh();
        zzc zzc2 = new zzc(collection.size(), zzh);
        for (Task zza2 : collection) {
            zza(zza2, zzc2);
        }
        return zzh;
    }

    public static Task<Void> whenAll(Task<?>... taskArr) {
        return taskArr.length == 0 ? forResult((Object) null) : whenAll((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }

    private static void zza(Task<?> task, zzb zzb2) {
        task.addOnSuccessListener(TaskExecutors.aJI, (OnSuccessListener<? super Object>) zzb2);
        task.addOnFailureListener(TaskExecutors.aJI, (OnFailureListener) zzb2);
    }

    private static <TResult> TResult zzb(Task<TResult> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        throw new ExecutionException(task.getException());
    }
}
