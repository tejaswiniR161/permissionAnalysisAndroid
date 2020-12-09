package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzai;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.internal.zzpy;
import com.google.android.gms.internal.zzqc;
import com.google.android.gms.internal.zzrd;
import com.google.android.gms.internal.zzrq;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class zzqt implements Handler.Callback {

    /* renamed from: yu */
    private static zzqt f2120yu;
    /* access modifiers changed from: private */
    public static final Object zzaok = new Object();
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final Handler mHandler;
    /* access modifiers changed from: private */

    /* renamed from: vP */
    public final GoogleApiAvailability f2121vP;
    /* access modifiers changed from: private */

    /* renamed from: xS */
    public long f2122xS;
    /* access modifiers changed from: private */

    /* renamed from: xT */
    public long f2123xT;
    /* access modifiers changed from: private */

    /* renamed from: yA */
    public final Set<zzpz<?>> f2124yA;

    /* renamed from: yB */
    private final ReferenceQueue<com.google.android.gms.common.api.zzd<?>> f2125yB;
    /* access modifiers changed from: private */

    /* renamed from: yC */
    public final SparseArray<zza> f2126yC;

    /* renamed from: yD */
    private zzb f2127yD;
    /* access modifiers changed from: private */

    /* renamed from: yt */
    public long f2128yt;
    /* access modifiers changed from: private */

    /* renamed from: yv */
    public int f2129yv;

    /* renamed from: yw */
    private final AtomicInteger f2130yw;

    /* renamed from: yx */
    private final SparseArray<zzc<?>> f2131yx;
    /* access modifiers changed from: private */

    /* renamed from: yy */
    public final Map<zzpz<?>, zzc<?>> f2132yy;

    /* renamed from: yz */
    private zzqi f2133yz;

    private final class zza extends PhantomReference<com.google.android.gms.common.api.zzd<?>> {
        /* access modifiers changed from: private */

        /* renamed from: wf */
        public final int f2134wf;

        public zza(com.google.android.gms.common.api.zzd zzd, int i, ReferenceQueue<com.google.android.gms.common.api.zzd<?>> referenceQueue) {
            super(zzd, referenceQueue);
            this.f2134wf = i;
        }

        public void zzasd() {
            zzqt.this.mHandler.sendMessage(zzqt.this.mHandler.obtainMessage(2, this.f2134wf, 2));
        }
    }

    private static final class zzb extends Thread {

        /* renamed from: yB */
        private final ReferenceQueue<com.google.android.gms.common.api.zzd<?>> f2136yB;

        /* renamed from: yC */
        private final SparseArray<zza> f2137yC;
        /* access modifiers changed from: private */

        /* renamed from: yF */
        public final AtomicBoolean f2138yF = new AtomicBoolean();

        public zzb(ReferenceQueue<com.google.android.gms.common.api.zzd<?>> referenceQueue, SparseArray<zza> sparseArray) {
            super("GoogleApiCleanup");
            this.f2136yB = referenceQueue;
            this.f2137yC = sparseArray;
        }

        public void run() {
            this.f2138yF.set(true);
            Process.setThreadPriority(10);
            while (this.f2138yF.get()) {
                try {
                    zza zza = (zza) this.f2136yB.remove();
                    this.f2137yC.remove(zza.f2134wf);
                    zza.zzasd();
                } catch (InterruptedException e) {
                    return;
                } finally {
                    this.f2138yF.set(false);
                }
            }
        }
    }

    private class zzc<O extends Api.ApiOptions> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zzqg {

        /* renamed from: vC */
        private final Api.zze f2139vC;

        /* renamed from: vx */
        private final zzpz<O> f2140vx;

        /* renamed from: wg */
        private final SparseArray<Map<zzrd.zzb<?>, zzri>> f2141wg = new SparseArray<>();

        /* renamed from: xR */
        private boolean f2142xR;
        /* access modifiers changed from: private */

        /* renamed from: yG */
        public final Queue<zzpy> f2144yG = new LinkedList();

        /* renamed from: yH */
        private final Api.zzb f2145yH;

        /* renamed from: yI */
        private final SparseArray<zzrq> f2146yI = new SparseArray<>();

        /* renamed from: yJ */
        private final Set<zzqb> f2147yJ = new HashSet();

        /* renamed from: yK */
        private ConnectionResult f2148yK = null;

        @WorkerThread
        public zzc(com.google.android.gms.common.api.zzd<O> zzd) {
            this.f2139vC = zzd.zza(zzqt.this.mHandler.getLooper(), this, this);
            if (this.f2139vC instanceof zzai) {
                this.f2145yH = ((zzai) this.f2139vC).zzavk();
            } else {
                this.f2145yH = this.f2139vC;
            }
            this.f2140vx = zzd.zzapx();
        }

        /* access modifiers changed from: private */
        @WorkerThread
        public void connect() {
            if (!this.f2139vC.isConnected() && !this.f2139vC.isConnecting()) {
                if (this.f2139vC.zzapr() && zzqt.this.f2129yv != 0) {
                    int unused = zzqt.this.f2129yv = zzqt.this.f2121vP.isGooglePlayServicesAvailable(zzqt.this.mContext);
                    if (zzqt.this.f2129yv != 0) {
                        onConnectionFailed(new ConnectionResult(zzqt.this.f2129yv, (PendingIntent) null));
                        return;
                    }
                }
                this.f2139vC.zza(new zzd(this.f2139vC, this.f2140vx));
            }
        }

        /* access modifiers changed from: private */
        @WorkerThread
        public void resume() {
            if (this.f2142xR) {
                connect();
            }
        }

        /* access modifiers changed from: private */
        @WorkerThread
        public void zzab(Status status) {
            for (zzpy zzx : this.f2144yG) {
                zzx.zzx(status);
            }
            this.f2144yG.clear();
        }

        /* access modifiers changed from: private */
        @WorkerThread
        public void zzarr() {
            if (this.f2142xR) {
                zzash();
                zzab(zzqt.this.f2121vP.isGooglePlayServicesAvailable(zzqt.this.mContext) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
                this.f2139vC.disconnect();
            }
        }

        @WorkerThread
        private void zzash() {
            if (this.f2142xR) {
                zzqt.this.mHandler.removeMessages(10, this.f2140vx);
                zzqt.this.mHandler.removeMessages(9, this.f2140vx);
                this.f2142xR = false;
            }
        }

        private void zzasi() {
            zzqt.this.mHandler.removeMessages(11, this.f2140vx);
            zzqt.this.mHandler.sendMessageDelayed(zzqt.this.mHandler.obtainMessage(11, this.f2140vx), zzqt.this.f2128yt);
        }

        /* access modifiers changed from: private */
        public void zzasj() {
            if (this.f2139vC.isConnected() && this.f2141wg.size() == 0) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= this.f2146yI.size()) {
                        this.f2139vC.disconnect();
                        return;
                    } else if (this.f2146yI.get(this.f2146yI.keyAt(i2)).zzasx()) {
                        zzasi();
                        return;
                    } else {
                        i = i2 + 1;
                    }
                }
            }
        }

        @WorkerThread
        private void zzc(zzpy zzpy) {
            zzpy.zza(this.f2146yI);
            try {
                zzpy.zzb(this.f2145yH);
            } catch (DeadObjectException e) {
                this.f2139vC.disconnect();
                onConnectionSuspended(1);
            }
        }

        @WorkerThread
        private void zzj(ConnectionResult connectionResult) {
            for (zzqb zza : this.f2147yJ) {
                zza.zza(this.f2140vx, connectionResult);
            }
            this.f2147yJ.clear();
        }

        /* access modifiers changed from: package-private */
        public boolean isConnected() {
            return this.f2139vC.isConnected();
        }

        @WorkerThread
        public void onConnected(@Nullable Bundle bundle) {
            zzasf();
            zzj(ConnectionResult.f1494uJ);
            zzash();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f2141wg.size()) {
                    for (zzri zzri : this.f2141wg.get(this.f2141wg.keyAt(i2)).values()) {
                        try {
                            zzri.f2178wj.zza(this.f2145yH, new TaskCompletionSource());
                        } catch (DeadObjectException e) {
                            this.f2139vC.disconnect();
                            onConnectionSuspended(1);
                        }
                    }
                    i = i2 + 1;
                } else {
                    zzase();
                    zzasi();
                    return;
                }
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x004e, code lost:
            if (r5.f2143yE.zzc(r6, r0) != false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
            if (r6.getErrorCode() != 18) goto L_0x005b;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0058, code lost:
            r5.f2142xR = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x005d, code lost:
            if (r5.f2142xR == false) goto L_0x007d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x005f, code lost:
            com.google.android.gms.internal.zzqt.zza(r5.f2143yE).sendMessageDelayed(android.os.Message.obtain(com.google.android.gms.internal.zzqt.zza(r5.f2143yE), 9, r5.f2140vx), com.google.android.gms.internal.zzqt.zzb(r5.f2143yE));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x007d, code lost:
            r2 = java.lang.String.valueOf(r5.f2140vx.zzaqj());
            zzab(new com.google.android.gms.common.api.Status(17, new java.lang.StringBuilder(java.lang.String.valueOf(r2).length() + 38).append("API: ").append(r2).append(" is not available on this device.").toString()));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
            return;
         */
        @android.support.annotation.WorkerThread
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onConnectionFailed(@android.support.annotation.NonNull com.google.android.gms.common.ConnectionResult r6) {
            /*
                r5 = this;
                r5.zzasf()
                com.google.android.gms.internal.zzqt r0 = com.google.android.gms.internal.zzqt.this
                r1 = -1
                int unused = r0.f2129yv = r1
                r5.zzj(r6)
                android.util.SparseArray<com.google.android.gms.internal.zzrq> r0 = r5.f2146yI
                r1 = 0
                int r0 = r0.keyAt(r1)
                java.util.Queue<com.google.android.gms.internal.zzpy> r1 = r5.f2144yG
                boolean r1 = r1.isEmpty()
                if (r1 == 0) goto L_0x001e
                r5.f2148yK = r6
            L_0x001d:
                return
            L_0x001e:
                java.lang.Object r1 = com.google.android.gms.internal.zzqt.zzaok
                monitor-enter(r1)
                com.google.android.gms.internal.zzqt r2 = com.google.android.gms.internal.zzqt.this     // Catch:{ all -> 0x0044 }
                com.google.android.gms.internal.zzqi r2 = com.google.android.gms.internal.zzqt.zzd(r2)     // Catch:{ all -> 0x0044 }
                if (r2 == 0) goto L_0x0047
                com.google.android.gms.internal.zzqt r2 = com.google.android.gms.internal.zzqt.this     // Catch:{ all -> 0x0044 }
                java.util.Set r2 = r2.f2124yA     // Catch:{ all -> 0x0044 }
                com.google.android.gms.internal.zzpz<O> r3 = r5.f2140vx     // Catch:{ all -> 0x0044 }
                boolean r2 = r2.contains(r3)     // Catch:{ all -> 0x0044 }
                if (r2 == 0) goto L_0x0047
                com.google.android.gms.internal.zzqt r2 = com.google.android.gms.internal.zzqt.this     // Catch:{ all -> 0x0044 }
                com.google.android.gms.internal.zzqi r2 = com.google.android.gms.internal.zzqt.zzd(r2)     // Catch:{ all -> 0x0044 }
                r2.zzb(r6, r0)     // Catch:{ all -> 0x0044 }
                monitor-exit(r1)     // Catch:{ all -> 0x0044 }
                goto L_0x001d
            L_0x0044:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0044 }
                throw r0
            L_0x0047:
                monitor-exit(r1)     // Catch:{ all -> 0x0044 }
                com.google.android.gms.internal.zzqt r1 = com.google.android.gms.internal.zzqt.this
                boolean r0 = r1.zzc(r6, r0)
                if (r0 != 0) goto L_0x001d
                int r0 = r6.getErrorCode()
                r1 = 18
                if (r0 != r1) goto L_0x005b
                r0 = 1
                r5.f2142xR = r0
            L_0x005b:
                boolean r0 = r5.f2142xR
                if (r0 == 0) goto L_0x007d
                com.google.android.gms.internal.zzqt r0 = com.google.android.gms.internal.zzqt.this
                android.os.Handler r0 = r0.mHandler
                com.google.android.gms.internal.zzqt r1 = com.google.android.gms.internal.zzqt.this
                android.os.Handler r1 = r1.mHandler
                r2 = 9
                com.google.android.gms.internal.zzpz<O> r3 = r5.f2140vx
                android.os.Message r1 = android.os.Message.obtain(r1, r2, r3)
                com.google.android.gms.internal.zzqt r2 = com.google.android.gms.internal.zzqt.this
                long r2 = r2.f2123xT
                r0.sendMessageDelayed(r1, r2)
                goto L_0x001d
            L_0x007d:
                com.google.android.gms.common.api.Status r0 = new com.google.android.gms.common.api.Status
                r1 = 17
                com.google.android.gms.internal.zzpz<O> r2 = r5.f2140vx
                java.lang.String r2 = r2.zzaqj()
                java.lang.String r2 = java.lang.String.valueOf(r2)
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                java.lang.String r4 = java.lang.String.valueOf(r2)
                int r4 = r4.length()
                int r4 = r4 + 38
                r3.<init>(r4)
                java.lang.String r4 = "API: "
                java.lang.StringBuilder r3 = r3.append(r4)
                java.lang.StringBuilder r2 = r3.append(r2)
                java.lang.String r3 = " is not available on this device."
                java.lang.StringBuilder r2 = r2.append(r3)
                java.lang.String r2 = r2.toString()
                r0.<init>(r1, r2)
                r5.zzab(r0)
                goto L_0x001d
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzqt.zzc.onConnectionFailed(com.google.android.gms.common.ConnectionResult):void");
        }

        @WorkerThread
        public void onConnectionSuspended(int i) {
            zzasf();
            this.f2142xR = true;
            zzqt.this.mHandler.sendMessageDelayed(Message.obtain(zzqt.this.mHandler, 9, this.f2140vx), zzqt.this.f2123xT);
            zzqt.this.mHandler.sendMessageDelayed(Message.obtain(zzqt.this.mHandler, 10, this.f2140vx), zzqt.this.f2122xS);
            int unused = zzqt.this.f2129yv = -1;
        }

        public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
            onConnectionFailed(connectionResult);
        }

        @WorkerThread
        public void zzase() {
            while (this.f2139vC.isConnected() && !this.f2144yG.isEmpty()) {
                zzc(this.f2144yG.remove());
            }
        }

        @WorkerThread
        public void zzasf() {
            this.f2148yK = null;
        }

        /* access modifiers changed from: package-private */
        public ConnectionResult zzasg() {
            return this.f2148yK;
        }

        @WorkerThread
        public void zzb(int i, @NonNull zzrd.zzb<?> zzb, @NonNull TaskCompletionSource<Void> taskCompletionSource) {
            Map map = this.f2141wg.get(i);
            if (map == null || map.get(zzb) == null) {
                taskCompletionSource.setException(new com.google.android.gms.common.api.zza(Status.f1542wa));
                Log.wtf("GoogleApiManager", "Received call to unregister a listener without a matching registration call.", new Exception());
                return;
            }
            zzb((zzpy) new zzpy.zze(i, ((zzri) map.get(zzb)).f2179wk, taskCompletionSource, this.f2141wg));
        }

        @WorkerThread
        public void zzb(int i, @NonNull zzri zzri, @NonNull TaskCompletionSource<Void> taskCompletionSource) {
            zzb((zzpy) new zzpy.zzc(i, zzri, taskCompletionSource, this.f2141wg));
        }

        @WorkerThread
        public void zzb(zzpy zzpy) {
            if (this.f2139vC.isConnected()) {
                zzc(zzpy);
                zzasi();
                return;
            }
            this.f2144yG.add(zzpy);
            if (this.f2148yK == null || !this.f2148yK.hasResolution()) {
                connect();
            } else {
                onConnectionFailed(this.f2148yK);
            }
        }

        @WorkerThread
        public void zzb(zzqb zzqb) {
            this.f2147yJ.add(zzqb);
        }

        @WorkerThread
        public void zzf(int i, boolean z) {
            Iterator it = this.f2144yG.iterator();
            while (it.hasNext()) {
                zzpy zzpy = (zzpy) it.next();
                if (zzpy.f1958wf == i && zzpy.f1957lN != 1 && zzpy.cancel()) {
                    it.remove();
                }
            }
            this.f2146yI.get(i).release();
            this.f2141wg.delete(i);
            if (!z) {
                this.f2146yI.remove(i);
                zzqt.this.f2126yC.remove(i);
                if (this.f2146yI.size() == 0 && this.f2144yG.isEmpty()) {
                    zzash();
                    this.f2139vC.disconnect();
                    zzqt.this.f2132yy.remove(this.f2140vx);
                    synchronized (zzqt.zzaok) {
                        zzqt.this.f2124yA.remove(this.f2140vx);
                    }
                }
            }
        }

        @WorkerThread
        public void zzfw(int i) {
            this.f2146yI.put(i, new zzrq(this.f2139vC));
        }

        @WorkerThread
        public void zzfx(final int i) {
            this.f2146yI.get(i).zza((zzrq.zzc) new zzrq.zzc() {
                public void zzask() {
                    if (zzc.this.f2144yG.isEmpty()) {
                        zzc.this.zzf(i, false);
                    }
                }
            });
        }
    }

    private class zzd implements zze.zzf {

        /* renamed from: vC */
        private final Api.zze f2151vC;

        /* renamed from: vx */
        private final zzpz<?> f2152vx;

        public zzd(Api.zze zze, zzpz<?> zzpz) {
            this.f2151vC = zze;
            this.f2152vx = zzpz;
        }

        @WorkerThread
        public void zzh(@NonNull ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                this.f2151vC.zza((zzr) null, Collections.emptySet());
            } else {
                ((zzc) zzqt.this.f2132yy.get(this.f2152vx)).onConnectionFailed(connectionResult);
            }
        }
    }

    private zzqt(Context context) {
        this(context, GoogleApiAvailability.getInstance());
    }

    private zzqt(Context context, GoogleApiAvailability googleApiAvailability) {
        this.f2123xT = 5000;
        this.f2122xS = 120000;
        this.f2128yt = 10000;
        this.f2129yv = -1;
        this.f2130yw = new AtomicInteger(1);
        this.f2131yx = new SparseArray<>();
        this.f2132yy = new ConcurrentHashMap(5, 0.75f, 1);
        this.f2133yz = null;
        this.f2124yA = new com.google.android.gms.common.util.zza();
        this.f2125yB = new ReferenceQueue<>();
        this.f2126yC = new SparseArray<>();
        this.mContext = context;
        HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
        handlerThread.start();
        this.mHandler = new Handler(handlerThread.getLooper(), this);
        this.f2121vP = googleApiAvailability;
    }

    private int zza(com.google.android.gms.common.api.zzd<?> zzd2) {
        int andIncrement = this.f2130yw.getAndIncrement();
        this.mHandler.sendMessage(this.mHandler.obtainMessage(6, andIncrement, 0, zzd2));
        return andIncrement;
    }

    public static Pair<zzqt, Integer> zza(Context context, com.google.android.gms.common.api.zzd<?> zzd2) {
        Pair<zzqt, Integer> create;
        synchronized (zzaok) {
            if (f2120yu == null) {
                f2120yu = new zzqt(context.getApplicationContext());
            }
            create = Pair.create(f2120yu, Integer.valueOf(f2120yu.zza(zzd2)));
        }
        return create;
    }

    @WorkerThread
    private void zza(int i, zzrd.zzb<?> zzb2, TaskCompletionSource<Void> taskCompletionSource) {
        this.f2131yx.get(i).zzb(i, zzb2, taskCompletionSource);
    }

    @WorkerThread
    private void zza(int i, zzri zzri, TaskCompletionSource<Void> taskCompletionSource) {
        this.f2131yx.get(i).zzb(i, zzri, taskCompletionSource);
    }

    @WorkerThread
    private void zza(com.google.android.gms.common.api.zzd<?> zzd2, int i) {
        zzpz<?> zzapx = zzd2.zzapx();
        if (!this.f2132yy.containsKey(zzapx)) {
            this.f2132yy.put(zzapx, new zzc(zzd2));
        }
        zzc zzc2 = this.f2132yy.get(zzapx);
        zzc2.zzfw(i);
        this.f2131yx.put(i, zzc2);
        zzc2.connect();
        this.f2126yC.put(i, new zza(zzd2, i, this.f2125yB));
        if (this.f2127yD == null || !this.f2127yD.f2138yF.get()) {
            this.f2127yD = new zzb(this.f2125yB, this.f2126yC);
            this.f2127yD.start();
        }
    }

    @WorkerThread
    private void zza(zzpy zzpy) {
        this.f2131yx.get(zzpy.f1958wf).zzb(zzpy);
    }

    public static zzqt zzasa() {
        zzqt zzqt;
        synchronized (zzaok) {
            zzqt = f2120yu;
        }
        return zzqt;
    }

    @WorkerThread
    private void zzasb() {
        for (zzc next : this.f2132yy.values()) {
            next.zzasf();
            next.connect();
        }
    }

    static /* synthetic */ zzqi zzd(zzqt zzqt) {
        return null;
    }

    @WorkerThread
    private void zze(int i, boolean z) {
        zzc zzc2 = this.f2131yx.get(i);
        if (zzc2 != null) {
            if (!z) {
                this.f2131yx.delete(i);
            }
            zzc2.zzf(i, z);
            return;
        }
        Log.wtf("GoogleApiManager", new StringBuilder(52).append("onRelease received for unknown instance: ").append(i).toString(), new Exception());
    }

    @WorkerThread
    private void zzfv(int i) {
        zzc zzc2 = this.f2131yx.get(i);
        if (zzc2 != null) {
            this.f2131yx.delete(i);
            zzc2.zzfx(i);
            return;
        }
        Log.wtf("GoogleApiManager", new StringBuilder(64).append("onCleanupLeakInternal received for unknown instance: ").append(i).toString(), new Exception());
    }

    @WorkerThread
    public boolean handleMessage(Message message) {
        boolean z = false;
        switch (message.what) {
            case 1:
                zza((zzqb) message.obj);
                break;
            case 2:
                zzfv(message.arg1);
                break;
            case 3:
                zzasb();
                break;
            case 4:
                zza((zzpy) message.obj);
                break;
            case 5:
                if (this.f2131yx.get(message.arg1) != null) {
                    this.f2131yx.get(message.arg1).zzab(new Status(17, "Error resolution was canceled by the user."));
                    break;
                }
                break;
            case 6:
                zza((com.google.android.gms.common.api.zzd<?>) (com.google.android.gms.common.api.zzd) message.obj, message.arg1);
                break;
            case 7:
                Pair pair = (Pair) message.obj;
                zza(message.arg1, (zzri) pair.first, (TaskCompletionSource<Void>) (TaskCompletionSource) pair.second);
                break;
            case 8:
                int i = message.arg1;
                if (message.arg2 == 1) {
                    z = true;
                }
                zze(i, z);
                break;
            case 9:
                if (this.f2132yy.containsKey(message.obj)) {
                    this.f2132yy.get(message.obj).resume();
                    break;
                }
                break;
            case 10:
                if (this.f2132yy.containsKey(message.obj)) {
                    this.f2132yy.get(message.obj).zzarr();
                    break;
                }
                break;
            case 11:
                if (this.f2132yy.containsKey(message.obj)) {
                    this.f2132yy.get(message.obj).zzasj();
                    break;
                }
                break;
            case 12:
                Pair pair2 = (Pair) message.obj;
                zza(message.arg1, (zzrd.zzb<?>) (zzrd.zzb) pair2.first, (TaskCompletionSource<Void>) (TaskCompletionSource) pair2.second);
                break;
            default:
                Log.w("GoogleApiManager", new StringBuilder(31).append("Unknown message id: ").append(message.what).toString());
                return false;
        }
        return true;
    }

    public void zza(ConnectionResult connectionResult, int i) {
        if (!zzc(connectionResult, i)) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(5, i, 0));
        }
    }

    public <O extends Api.ApiOptions> void zza(com.google.android.gms.common.api.zzd<O> zzd2, int i, zzqc.zza<? extends Result, Api.zzb> zza2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, new zzpy.zzb(zzd2.getInstanceId(), i, zza2)));
    }

    public <O extends Api.ApiOptions, TResult> void zza(com.google.android.gms.common.api.zzd<O> zzd2, int i, zzro<Api.zzb, TResult> zzro, TaskCompletionSource<TResult> taskCompletionSource) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, new zzpy.zzd(zzd2.getInstanceId(), i, zzro, taskCompletionSource)));
    }

    @WorkerThread
    public void zza(zzqb zzqb) {
        for (zzpz next : zzqb.zzaqm()) {
            zzc zzc2 = this.f2132yy.get(next);
            if (zzc2 == null) {
                zzqb.cancel();
                return;
            } else if (zzc2.isConnected()) {
                zzqb.zza(next, ConnectionResult.f1494uJ);
            } else if (zzc2.zzasg() != null) {
                zzqb.zza(next, zzc2.zzasg());
            } else {
                zzc2.zzb(zzqb);
            }
        }
    }

    public void zza(zzqi zzqi) {
        synchronized (zzaok) {
            if (zzqi == null) {
                this.f2133yz = null;
                this.f2124yA.clear();
            }
        }
    }

    public void zzaqk() {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3));
    }

    /* access modifiers changed from: package-private */
    public boolean zzc(ConnectionResult connectionResult, int i) {
        if (!connectionResult.hasResolution() && !this.f2121vP.isUserResolvableError(connectionResult.getErrorCode())) {
            return false;
        }
        this.f2121vP.zza(this.mContext, connectionResult, i);
        return true;
    }

    public void zzd(int i, boolean z) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(8, i, z ? 1 : 2));
    }
}
