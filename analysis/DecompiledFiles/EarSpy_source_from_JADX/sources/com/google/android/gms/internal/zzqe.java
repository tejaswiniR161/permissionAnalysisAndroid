package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzs;
import com.google.android.gms.internal.zzrq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zzqe<R extends Result> extends PendingResult<R> {

    /* renamed from: wF */
    static final ThreadLocal<Boolean> f1989wF = new ThreadLocal<Boolean>() {
        /* access modifiers changed from: protected */
        /* renamed from: zzaqv */
        public Boolean initialValue() {
            return false;
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: vU */
    public R f1990vU;

    /* renamed from: wG */
    private final Object f1991wG;

    /* renamed from: wH */
    protected final zza<R> f1992wH;

    /* renamed from: wI */
    protected final WeakReference<GoogleApiClient> f1993wI;

    /* renamed from: wJ */
    private final ArrayList<PendingResult.zza> f1994wJ;

    /* renamed from: wK */
    private ResultCallback<? super R> f1995wK;

    /* renamed from: wL */
    private final AtomicReference<zzrq.zzb> f1996wL;

    /* renamed from: wM */
    private zzb f1997wM;

    /* renamed from: wN */
    private volatile boolean f1998wN;

    /* renamed from: wO */
    private boolean f1999wO;

    /* renamed from: wP */
    private zzs f2000wP;

    /* renamed from: wQ */
    private volatile zzrp<R> f2001wQ;

    /* renamed from: wR */
    private boolean f2002wR;
    private boolean zzak;
    private final CountDownLatch zzamx;

    public static class zza<R extends Result> extends Handler {
        public zza() {
            this(Looper.getMainLooper());
        }

        public zza(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    zzb((ResultCallback) pair.first, (Result) pair.second);
                    return;
                case 2:
                    ((zzqe) message.obj).zzaa(Status.f1543wb);
                    return;
                default:
                    Log.wtf("BasePendingResult", new StringBuilder(45).append("Don't know how to handle message: ").append(message.what).toString(), new Exception());
                    return;
            }
        }

        public void zza(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void zza(zzqe<R> zzqe, long j) {
            sendMessageDelayed(obtainMessage(2, zzqe), j);
        }

        public void zzaqw() {
            removeMessages(2);
        }

        /* access modifiers changed from: protected */
        public void zzb(ResultCallback<? super R> resultCallback, R r) {
            try {
                resultCallback.onResult(r);
            } catch (RuntimeException e) {
                zzqe.zze(r);
                throw e;
            }
        }
    }

    private final class zzb {
        private zzb() {
        }

        /* access modifiers changed from: protected */
        public void finalize() throws Throwable {
            zzqe.zze(zzqe.this.f1990vU);
            super.finalize();
        }
    }

    @Deprecated
    zzqe() {
        this.f1991wG = new Object();
        this.zzamx = new CountDownLatch(1);
        this.f1994wJ = new ArrayList<>();
        this.f1996wL = new AtomicReference<>();
        this.f2002wR = false;
        this.f1992wH = new zza<>(Looper.getMainLooper());
        this.f1993wI = new WeakReference<>((Object) null);
    }

    @Deprecated
    protected zzqe(Looper looper) {
        this.f1991wG = new Object();
        this.zzamx = new CountDownLatch(1);
        this.f1994wJ = new ArrayList<>();
        this.f1996wL = new AtomicReference<>();
        this.f2002wR = false;
        this.f1992wH = new zza<>(looper);
        this.f1993wI = new WeakReference<>((Object) null);
    }

    protected zzqe(GoogleApiClient googleApiClient) {
        this.f1991wG = new Object();
        this.zzamx = new CountDownLatch(1);
        this.f1994wJ = new ArrayList<>();
        this.f1996wL = new AtomicReference<>();
        this.f2002wR = false;
        this.f1992wH = new zza<>(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.f1993wI = new WeakReference<>(googleApiClient);
    }

    private R get() {
        R r;
        boolean z = true;
        synchronized (this.f1991wG) {
            if (this.f1998wN) {
                z = false;
            }
            zzac.zza(z, (Object) "Result has already been consumed.");
            zzac.zza(isReady(), (Object) "Result is not ready.");
            r = this.f1990vU;
            this.f1990vU = null;
            this.f1995wK = null;
            this.f1998wN = true;
        }
        zzaqr();
        return r;
    }

    private void zzaqr() {
        zzrq.zzb andSet = this.f1996wL.getAndSet((Object) null);
        if (andSet != null) {
            andSet.zzc(this);
        }
    }

    private void zzd(R r) {
        this.f1990vU = r;
        this.f2000wP = null;
        this.zzamx.countDown();
        Status status = this.f1990vU.getStatus();
        if (this.zzak) {
            this.f1995wK = null;
        } else if (this.f1995wK != null) {
            this.f1992wH.zzaqw();
            this.f1992wH.zza(this.f1995wK, get());
        } else if (this.f1990vU instanceof Releasable) {
            this.f1997wM = new zzb();
        }
        Iterator<PendingResult.zza> it = this.f1994wJ.iterator();
        while (it.hasNext()) {
            it.next().zzv(status);
        }
        this.f1994wJ.clear();
    }

    public static void zze(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                Log.w("BasePendingResult", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    public final R await() {
        boolean z = true;
        zzac.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "await must not be called on the UI thread");
        zzac.zza(!this.f1998wN, (Object) "Result has already been consumed");
        if (this.f2001wQ != null) {
            z = false;
        }
        zzac.zza(z, (Object) "Cannot await if then() has been called.");
        try {
            this.zzamx.await();
        } catch (InterruptedException e) {
            zzaa(Status.f1541vZ);
        }
        zzac.zza(isReady(), (Object) "Result is not ready.");
        return get();
    }

    public final R await(long j, TimeUnit timeUnit) {
        boolean z = true;
        zzac.zza(j <= 0 || Looper.myLooper() != Looper.getMainLooper(), (Object) "await must not be called on the UI thread when time is greater than zero.");
        zzac.zza(!this.f1998wN, (Object) "Result has already been consumed.");
        if (this.f2001wQ != null) {
            z = false;
        }
        zzac.zza(z, (Object) "Cannot await if then() has been called.");
        try {
            if (!this.zzamx.await(j, timeUnit)) {
                zzaa(Status.f1543wb);
            }
        } catch (InterruptedException e) {
            zzaa(Status.f1541vZ);
        }
        zzac.zza(isReady(), (Object) "Result is not ready.");
        return get();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancel() {
        /*
            r2 = this;
            java.lang.Object r1 = r2.f1991wG
            monitor-enter(r1)
            boolean r0 = r2.zzak     // Catch:{ all -> 0x0029 }
            if (r0 != 0) goto L_0x000b
            boolean r0 = r2.f1998wN     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x000d
        L_0x000b:
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
        L_0x000c:
            return
        L_0x000d:
            com.google.android.gms.common.internal.zzs r0 = r2.f2000wP     // Catch:{ all -> 0x0029 }
            if (r0 == 0) goto L_0x0016
            com.google.android.gms.common.internal.zzs r0 = r2.f2000wP     // Catch:{ RemoteException -> 0x002c }
            r0.cancel()     // Catch:{ RemoteException -> 0x002c }
        L_0x0016:
            R r0 = r2.f1990vU     // Catch:{ all -> 0x0029 }
            zze(r0)     // Catch:{ all -> 0x0029 }
            r0 = 1
            r2.zzak = r0     // Catch:{ all -> 0x0029 }
            com.google.android.gms.common.api.Status r0 = com.google.android.gms.common.api.Status.f1544wc     // Catch:{ all -> 0x0029 }
            com.google.android.gms.common.api.Result r0 = r2.zzc((com.google.android.gms.common.api.Status) r0)     // Catch:{ all -> 0x0029 }
            r2.zzd(r0)     // Catch:{ all -> 0x0029 }
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            goto L_0x000c
        L_0x0029:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            throw r0
        L_0x002c:
            r0 = move-exception
            goto L_0x0016
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzqe.cancel():void");
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.f1991wG) {
            z = this.zzak;
        }
        return z;
    }

    public final boolean isReady() {
        return this.zzamx.getCount() == 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<? super R> r6) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            java.lang.Object r3 = r5.f1991wG
            monitor-enter(r3)
            if (r6 != 0) goto L_0x000c
            r0 = 0
            r5.f1995wK = r0     // Catch:{ all -> 0x0027 }
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
        L_0x000b:
            return
        L_0x000c:
            boolean r2 = r5.f1998wN     // Catch:{ all -> 0x0027 }
            if (r2 != 0) goto L_0x002a
            r2 = r0
        L_0x0011:
            java.lang.String r4 = "Result has already been consumed."
            com.google.android.gms.common.internal.zzac.zza((boolean) r2, (java.lang.Object) r4)     // Catch:{ all -> 0x0027 }
            com.google.android.gms.internal.zzrp<R> r2 = r5.f2001wQ     // Catch:{ all -> 0x0027 }
            if (r2 != 0) goto L_0x002c
        L_0x001a:
            java.lang.String r1 = "Cannot set callbacks if then() has been called."
            com.google.android.gms.common.internal.zzac.zza((boolean) r0, (java.lang.Object) r1)     // Catch:{ all -> 0x0027 }
            boolean r0 = r5.isCanceled()     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x002e
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
            goto L_0x000b
        L_0x0027:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
            throw r0
        L_0x002a:
            r2 = r1
            goto L_0x0011
        L_0x002c:
            r0 = r1
            goto L_0x001a
        L_0x002e:
            boolean r0 = r5.isReady()     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x003f
            com.google.android.gms.internal.zzqe$zza<R> r0 = r5.f1992wH     // Catch:{ all -> 0x0027 }
            com.google.android.gms.common.api.Result r1 = r5.get()     // Catch:{ all -> 0x0027 }
            r0.zza(r6, r1)     // Catch:{ all -> 0x0027 }
        L_0x003d:
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
            goto L_0x000b
        L_0x003f:
            r5.f1995wK = r6     // Catch:{ all -> 0x0027 }
            goto L_0x003d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzqe.setResultCallback(com.google.android.gms.common.api.ResultCallback):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<? super R> r7, long r8, java.util.concurrent.TimeUnit r10) {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            java.lang.Object r3 = r6.f1991wG
            monitor-enter(r3)
            if (r7 != 0) goto L_0x000c
            r0 = 0
            r6.f1995wK = r0     // Catch:{ all -> 0x0027 }
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
        L_0x000b:
            return
        L_0x000c:
            boolean r2 = r6.f1998wN     // Catch:{ all -> 0x0027 }
            if (r2 != 0) goto L_0x002a
            r2 = r0
        L_0x0011:
            java.lang.String r4 = "Result has already been consumed."
            com.google.android.gms.common.internal.zzac.zza((boolean) r2, (java.lang.Object) r4)     // Catch:{ all -> 0x0027 }
            com.google.android.gms.internal.zzrp<R> r2 = r6.f2001wQ     // Catch:{ all -> 0x0027 }
            if (r2 != 0) goto L_0x002c
        L_0x001a:
            java.lang.String r1 = "Cannot set callbacks if then() has been called."
            com.google.android.gms.common.internal.zzac.zza((boolean) r0, (java.lang.Object) r1)     // Catch:{ all -> 0x0027 }
            boolean r0 = r6.isCanceled()     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x002e
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
            goto L_0x000b
        L_0x0027:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
            throw r0
        L_0x002a:
            r2 = r1
            goto L_0x0011
        L_0x002c:
            r0 = r1
            goto L_0x001a
        L_0x002e:
            boolean r0 = r6.isReady()     // Catch:{ all -> 0x0027 }
            if (r0 == 0) goto L_0x003f
            com.google.android.gms.internal.zzqe$zza<R> r0 = r6.f1992wH     // Catch:{ all -> 0x0027 }
            com.google.android.gms.common.api.Result r1 = r6.get()     // Catch:{ all -> 0x0027 }
            r0.zza(r7, r1)     // Catch:{ all -> 0x0027 }
        L_0x003d:
            monitor-exit(r3)     // Catch:{ all -> 0x0027 }
            goto L_0x000b
        L_0x003f:
            r6.f1995wK = r7     // Catch:{ all -> 0x0027 }
            com.google.android.gms.internal.zzqe$zza<R> r0 = r6.f1992wH     // Catch:{ all -> 0x0027 }
            long r4 = r10.toMillis(r8)     // Catch:{ all -> 0x0027 }
            r0.zza(r6, (long) r4)     // Catch:{ all -> 0x0027 }
            goto L_0x003d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzqe.setResultCallback(com.google.android.gms.common.api.ResultCallback, long, java.util.concurrent.TimeUnit):void");
    }

    public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult<S> then;
        boolean z = true;
        zzac.zza(!this.f1998wN, (Object) "Result has already been consumed.");
        synchronized (this.f1991wG) {
            zzac.zza(this.f2001wQ == null, (Object) "Cannot call then() twice.");
            if (this.f1995wK != null) {
                z = false;
            }
            zzac.zza(z, (Object) "Cannot call then() if callbacks are set.");
            this.f2002wR = true;
            this.f2001wQ = new zzrp<>(this.f1993wI);
            then = this.f2001wQ.then(resultTransform);
            if (isReady()) {
                this.f1992wH.zza(this.f2001wQ, get());
            } else {
                this.f1995wK = this.f2001wQ;
            }
        }
        return then;
    }

    public final void zza(PendingResult.zza zza2) {
        boolean z = true;
        zzac.zza(!this.f1998wN, (Object) "Result has already been consumed.");
        if (zza2 == null) {
            z = false;
        }
        zzac.zzb(z, (Object) "Callback cannot be null.");
        synchronized (this.f1991wG) {
            if (isReady()) {
                zza2.zzv(this.f1990vU.getStatus());
            } else {
                this.f1994wJ.add(zza2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(zzs zzs) {
        synchronized (this.f1991wG) {
            this.f2000wP = zzs;
        }
    }

    public void zza(zzrq.zzb zzb2) {
        this.f1996wL.set(zzb2);
    }

    public final void zzaa(Status status) {
        synchronized (this.f1991wG) {
            if (!isReady()) {
                zzc(zzc(status));
                this.f1999wO = true;
            }
        }
    }

    public Integer zzaqf() {
        return null;
    }

    public boolean zzaqq() {
        boolean isCanceled;
        synchronized (this.f1991wG) {
            if (((GoogleApiClient) this.f1993wI.get()) == null || !this.f2002wR) {
                cancel();
            }
            isCanceled = isCanceled();
        }
        return isCanceled;
    }

    public void zzaqs() {
        setResultCallback((ResultCallback) null);
    }

    public void zzaqt() {
        this.f2002wR = this.f2002wR || f1989wF.get().booleanValue();
    }

    /* access modifiers changed from: package-private */
    public boolean zzaqu() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract R zzc(Status status);

    public final void zzc(R r) {
        boolean z = true;
        synchronized (this.f1991wG) {
            if (this.f1999wO || this.zzak || (isReady() && zzaqu())) {
                zze(r);
                return;
            }
            zzac.zza(!isReady(), (Object) "Results have already been set");
            if (this.f1998wN) {
                z = false;
            }
            zzac.zza(z, (Object) "Result has already been consumed");
            zzd(r);
        }
    }
}
