package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;

public class zzw extends zzaa {
    /* access modifiers changed from: private */
    public static final AtomicLong aqI = new AtomicLong(Long.MIN_VALUE);
    /* access modifiers changed from: private */
    public zzd aqA;
    private final PriorityBlockingQueue<FutureTask<?>> aqB = new PriorityBlockingQueue<>();
    private final BlockingQueue<FutureTask<?>> aqC = new LinkedBlockingQueue();
    private final Thread.UncaughtExceptionHandler aqD = new zzb("Thread death: Uncaught exception on worker thread");
    private final Thread.UncaughtExceptionHandler aqE = new zzb("Thread death: Uncaught exception on network thread");
    /* access modifiers changed from: private */
    public final Object aqF = new Object();
    /* access modifiers changed from: private */
    public final Semaphore aqG = new Semaphore(2);
    /* access modifiers changed from: private */
    public volatile boolean aqH;
    /* access modifiers changed from: private */
    public zzd aqz;

    static class zza extends RuntimeException {
    }

    private final class zzb implements Thread.UncaughtExceptionHandler {
        private final String aqJ;

        public zzb(String str) {
            zzac.zzy(str);
            this.aqJ = str;
        }

        public synchronized void uncaughtException(Thread thread, Throwable th) {
            zzw.this.zzbvg().zzbwc().zzj(this.aqJ, th);
        }
    }

    private final class zzc<V> extends FutureTask<V> implements Comparable<zzc> {
        private final String aqJ;
        private final long aqL = zzw.aqI.getAndIncrement();
        private final boolean aqM;

        zzc(Runnable runnable, boolean z, String str) {
            super(runnable, (Object) null);
            zzac.zzy(str);
            this.aqJ = str;
            this.aqM = z;
            if (this.aqL == Long.MAX_VALUE) {
                zzw.this.zzbvg().zzbwc().log("Tasks index overflow");
            }
        }

        zzc(Callable<V> callable, boolean z, String str) {
            super(callable);
            zzac.zzy(str);
            this.aqJ = str;
            this.aqM = z;
            if (this.aqL == Long.MAX_VALUE) {
                zzw.this.zzbvg().zzbwc().log("Tasks index overflow");
            }
        }

        /* access modifiers changed from: protected */
        public void setException(Throwable th) {
            zzw.this.zzbvg().zzbwc().zzj(this.aqJ, th);
            if (th instanceof zza) {
                Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
            }
            super.setException(th);
        }

        /* renamed from: zzb */
        public int compareTo(@NonNull zzc zzc) {
            if (this.aqM != zzc.aqM) {
                return this.aqM ? -1 : 1;
            }
            if (this.aqL < zzc.aqL) {
                return -1;
            }
            if (this.aqL > zzc.aqL) {
                return 1;
            }
            zzw.this.zzbvg().zzbwd().zzj("Two tasks share the same index. index", Long.valueOf(this.aqL));
            return 0;
        }
    }

    private final class zzd extends Thread {
        private final Object aqN = new Object();
        private final BlockingQueue<FutureTask<?>> aqO;

        public zzd(String str, BlockingQueue<FutureTask<?>> blockingQueue) {
            zzac.zzy(str);
            zzac.zzy(blockingQueue);
            this.aqO = blockingQueue;
            setName(str);
        }

        private void zza(InterruptedException interruptedException) {
            zzw.this.zzbvg().zzbwe().zzj(String.valueOf(getName()).concat(" was interrupted"), interruptedException);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:39:0x0078, code lost:
            r1 = com.google.android.gms.measurement.internal.zzw.zzc(r4.aqK);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:40:0x007e, code lost:
            monitor-enter(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
            com.google.android.gms.measurement.internal.zzw.zza(r4.aqK).release();
            com.google.android.gms.measurement.internal.zzw.zzc(r4.aqK).notifyAll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0097, code lost:
            if (r4 != com.google.android.gms.measurement.internal.zzw.zzd(r4.aqK)) goto L_0x00a9;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0099, code lost:
            com.google.android.gms.measurement.internal.zzw.zza(r4.aqK, (com.google.android.gms.measurement.internal.zzw.zzd) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:45:0x009f, code lost:
            monitor-exit(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a0, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:56:0x00af, code lost:
            if (r4 != com.google.android.gms.measurement.internal.zzw.zze(r4.aqK)) goto L_0x00bb;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x00b1, code lost:
            com.google.android.gms.measurement.internal.zzw.zzb(r4.aqK, (com.google.android.gms.measurement.internal.zzw.zzd) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:62:?, code lost:
            r4.aqK.zzbvg().zzbwc().log("Current scheduler thread is neither worker nor network");
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r4 = this;
                r0 = 0
                r1 = r0
            L_0x0002:
                if (r1 != 0) goto L_0x0015
                com.google.android.gms.measurement.internal.zzw r0 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ InterruptedException -> 0x0010 }
                java.util.concurrent.Semaphore r0 = r0.aqG     // Catch:{ InterruptedException -> 0x0010 }
                r0.acquire()     // Catch:{ InterruptedException -> 0x0010 }
                r0 = 1
                r1 = r0
                goto L_0x0002
            L_0x0010:
                r0 = move-exception
                r4.zza(r0)
                goto L_0x0002
            L_0x0015:
                java.util.concurrent.BlockingQueue<java.util.concurrent.FutureTask<?>> r0 = r4.aqO     // Catch:{ all -> 0x0023 }
                java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x0023 }
                java.util.concurrent.FutureTask r0 = (java.util.concurrent.FutureTask) r0     // Catch:{ all -> 0x0023 }
                if (r0 == 0) goto L_0x004d
                r0.run()     // Catch:{ all -> 0x0023 }
                goto L_0x0015
            L_0x0023:
                r0 = move-exception
                com.google.android.gms.measurement.internal.zzw r1 = com.google.android.gms.measurement.internal.zzw.this
                java.lang.Object r1 = r1.aqF
                monitor-enter(r1)
                com.google.android.gms.measurement.internal.zzw r2 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00e1 }
                java.util.concurrent.Semaphore r2 = r2.aqG     // Catch:{ all -> 0x00e1 }
                r2.release()     // Catch:{ all -> 0x00e1 }
                com.google.android.gms.measurement.internal.zzw r2 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00e1 }
                java.lang.Object r2 = r2.aqF     // Catch:{ all -> 0x00e1 }
                r2.notifyAll()     // Catch:{ all -> 0x00e1 }
                com.google.android.gms.measurement.internal.zzw r2 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00e1 }
                com.google.android.gms.measurement.internal.zzw$zzd r2 = r2.aqz     // Catch:{ all -> 0x00e1 }
                if (r4 != r2) goto L_0x00d1
                com.google.android.gms.measurement.internal.zzw r2 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00e1 }
                r3 = 0
                com.google.android.gms.measurement.internal.zzw.zzd unused = r2.aqz = r3     // Catch:{ all -> 0x00e1 }
            L_0x004b:
                monitor-exit(r1)     // Catch:{ all -> 0x00e1 }
                throw r0
            L_0x004d:
                java.lang.Object r1 = r4.aqN     // Catch:{ all -> 0x0023 }
                monitor-enter(r1)     // Catch:{ all -> 0x0023 }
                java.util.concurrent.BlockingQueue<java.util.concurrent.FutureTask<?>> r0 = r4.aqO     // Catch:{ all -> 0x00a6 }
                java.lang.Object r0 = r0.peek()     // Catch:{ all -> 0x00a6 }
                if (r0 != 0) goto L_0x0067
                com.google.android.gms.measurement.internal.zzw r0 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00a6 }
                boolean r0 = r0.aqH     // Catch:{ all -> 0x00a6 }
                if (r0 != 0) goto L_0x0067
                java.lang.Object r0 = r4.aqN     // Catch:{ InterruptedException -> 0x00a1 }
                r2 = 30000(0x7530, double:1.4822E-319)
                r0.wait(r2)     // Catch:{ InterruptedException -> 0x00a1 }
            L_0x0067:
                monitor-exit(r1)     // Catch:{ all -> 0x00a6 }
                com.google.android.gms.measurement.internal.zzw r0 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x0023 }
                java.lang.Object r1 = r0.aqF     // Catch:{ all -> 0x0023 }
                monitor-enter(r1)     // Catch:{ all -> 0x0023 }
                java.util.concurrent.BlockingQueue<java.util.concurrent.FutureTask<?>> r0 = r4.aqO     // Catch:{ all -> 0x00ce }
                java.lang.Object r0 = r0.peek()     // Catch:{ all -> 0x00ce }
                if (r0 != 0) goto L_0x00cb
                monitor-exit(r1)     // Catch:{ all -> 0x00ce }
                com.google.android.gms.measurement.internal.zzw r0 = com.google.android.gms.measurement.internal.zzw.this
                java.lang.Object r1 = r0.aqF
                monitor-enter(r1)
                com.google.android.gms.measurement.internal.zzw r0 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00b8 }
                java.util.concurrent.Semaphore r0 = r0.aqG     // Catch:{ all -> 0x00b8 }
                r0.release()     // Catch:{ all -> 0x00b8 }
                com.google.android.gms.measurement.internal.zzw r0 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00b8 }
                java.lang.Object r0 = r0.aqF     // Catch:{ all -> 0x00b8 }
                r0.notifyAll()     // Catch:{ all -> 0x00b8 }
                com.google.android.gms.measurement.internal.zzw r0 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00b8 }
                com.google.android.gms.measurement.internal.zzw$zzd r0 = r0.aqz     // Catch:{ all -> 0x00b8 }
                if (r4 != r0) goto L_0x00a9
                com.google.android.gms.measurement.internal.zzw r0 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00b8 }
                r2 = 0
                com.google.android.gms.measurement.internal.zzw.zzd unused = r0.aqz = r2     // Catch:{ all -> 0x00b8 }
            L_0x009f:
                monitor-exit(r1)     // Catch:{ all -> 0x00b8 }
                return
            L_0x00a1:
                r0 = move-exception
                r4.zza(r0)     // Catch:{ all -> 0x00a6 }
                goto L_0x0067
            L_0x00a6:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00a6 }
                throw r0     // Catch:{ all -> 0x0023 }
            L_0x00a9:
                com.google.android.gms.measurement.internal.zzw r0 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00b8 }
                com.google.android.gms.measurement.internal.zzw$zzd r0 = r0.aqA     // Catch:{ all -> 0x00b8 }
                if (r4 != r0) goto L_0x00bb
                com.google.android.gms.measurement.internal.zzw r0 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00b8 }
                r2 = 0
                com.google.android.gms.measurement.internal.zzw.zzd unused = r0.aqA = r2     // Catch:{ all -> 0x00b8 }
                goto L_0x009f
            L_0x00b8:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00b8 }
                throw r0
            L_0x00bb:
                com.google.android.gms.measurement.internal.zzw r0 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00b8 }
                com.google.android.gms.measurement.internal.zzp r0 = r0.zzbvg()     // Catch:{ all -> 0x00b8 }
                com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzbwc()     // Catch:{ all -> 0x00b8 }
                java.lang.String r2 = "Current scheduler thread is neither worker nor network"
                r0.log(r2)     // Catch:{ all -> 0x00b8 }
                goto L_0x009f
            L_0x00cb:
                monitor-exit(r1)     // Catch:{ all -> 0x00ce }
                goto L_0x0015
            L_0x00ce:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00ce }
                throw r0     // Catch:{ all -> 0x0023 }
            L_0x00d1:
                com.google.android.gms.measurement.internal.zzw r2 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00e1 }
                com.google.android.gms.measurement.internal.zzw$zzd r2 = r2.aqA     // Catch:{ all -> 0x00e1 }
                if (r4 != r2) goto L_0x00e4
                com.google.android.gms.measurement.internal.zzw r2 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00e1 }
                r3 = 0
                com.google.android.gms.measurement.internal.zzw.zzd unused = r2.aqA = r3     // Catch:{ all -> 0x00e1 }
                goto L_0x004b
            L_0x00e1:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x00e1 }
                throw r0
            L_0x00e4:
                com.google.android.gms.measurement.internal.zzw r2 = com.google.android.gms.measurement.internal.zzw.this     // Catch:{ all -> 0x00e1 }
                com.google.android.gms.measurement.internal.zzp r2 = r2.zzbvg()     // Catch:{ all -> 0x00e1 }
                com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbwc()     // Catch:{ all -> 0x00e1 }
                java.lang.String r3 = "Current scheduler thread is neither worker nor network"
                r2.log(r3)     // Catch:{ all -> 0x00e1 }
                goto L_0x004b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzw.zzd.run():void");
        }

        public void zzoi() {
            synchronized (this.aqN) {
                this.aqN.notifyAll();
            }
        }
    }

    zzw(zzx zzx) {
        super(zzx);
    }

    private void zza(zzc<?> zzc2) {
        synchronized (this.aqF) {
            this.aqB.add(zzc2);
            if (this.aqz == null) {
                this.aqz = new zzd("Measurement Worker", this.aqB);
                this.aqz.setUncaughtExceptionHandler(this.aqD);
                this.aqz.start();
            } else {
                this.aqz.zzoi();
            }
        }
    }

    private void zza(FutureTask<?> futureTask) {
        synchronized (this.aqF) {
            this.aqC.add(futureTask);
            if (this.aqA == null) {
                this.aqA = new zzd("Measurement Network", this.aqC);
                this.aqA.setUncaughtExceptionHandler(this.aqE);
                this.aqA.start();
            } else {
                this.aqA.zzoi();
            }
        }
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public /* bridge */ /* synthetic */ void zzaam() {
        super.zzaam();
    }

    public /* bridge */ /* synthetic */ zze zzaan() {
        return super.zzaan();
    }

    public void zzbuv() {
        if (Thread.currentThread() != this.aqA) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    public /* bridge */ /* synthetic */ zzc zzbuw() {
        return super.zzbuw();
    }

    public /* bridge */ /* synthetic */ zzac zzbux() {
        return super.zzbux();
    }

    public /* bridge */ /* synthetic */ zzn zzbuy() {
        return super.zzbuy();
    }

    public /* bridge */ /* synthetic */ zzg zzbuz() {
        return super.zzbuz();
    }

    public /* bridge */ /* synthetic */ zzad zzbva() {
        return super.zzbva();
    }

    public /* bridge */ /* synthetic */ zze zzbvb() {
        return super.zzbvb();
    }

    public /* bridge */ /* synthetic */ zzal zzbvc() {
        return super.zzbvc();
    }

    public /* bridge */ /* synthetic */ zzv zzbvd() {
        return super.zzbvd();
    }

    public /* bridge */ /* synthetic */ zzaf zzbve() {
        return super.zzbve();
    }

    public /* bridge */ /* synthetic */ zzw zzbvf() {
        return super.zzbvf();
    }

    public /* bridge */ /* synthetic */ zzp zzbvg() {
        return super.zzbvg();
    }

    public /* bridge */ /* synthetic */ zzt zzbvh() {
        return super.zzbvh();
    }

    public /* bridge */ /* synthetic */ zzd zzbvi() {
        return super.zzbvi();
    }

    public <V> Future<V> zzd(Callable<V> callable) throws IllegalStateException {
        zzaax();
        zzac.zzy(callable);
        zzc zzc2 = new zzc(callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.aqz) {
            zzc2.run();
        } else {
            zza((zzc<?>) zzc2);
        }
        return zzc2;
    }

    public <V> Future<V> zze(Callable<V> callable) throws IllegalStateException {
        zzaax();
        zzac.zzy(callable);
        zzc zzc2 = new zzc(callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.aqz) {
            zzc2.run();
        } else {
            zza((zzc<?>) zzc2);
        }
        return zzc2;
    }

    public void zzm(Runnable runnable) throws IllegalStateException {
        zzaax();
        zzac.zzy(runnable);
        zza((zzc<?>) new zzc(runnable, false, "Task exception on worker thread"));
    }

    public void zzn(Runnable runnable) throws IllegalStateException {
        zzaax();
        zzac.zzy(runnable);
        zza((FutureTask<?>) new zzc(runnable, false, "Task exception on network thread"));
    }

    public void zzyl() {
        if (Thread.currentThread() != this.aqz) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    /* access modifiers changed from: protected */
    public void zzym() {
    }
}
