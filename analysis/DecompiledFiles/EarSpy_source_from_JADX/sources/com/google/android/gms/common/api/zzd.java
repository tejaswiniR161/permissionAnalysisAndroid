package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Pair;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzai;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.internal.zzpz;
import com.google.android.gms.internal.zzqc;
import com.google.android.gms.internal.zzqt;
import com.google.android.gms.internal.zzqu;
import com.google.android.gms.internal.zzre;
import com.google.android.gms.internal.zzro;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class zzd<O extends Api.ApiOptions> {
    private final Context mContext;
    private final int mId;

    /* renamed from: tv */
    private final Api<O> f1553tv;

    /* renamed from: vA */
    private final AtomicBoolean f1554vA;

    /* renamed from: vB */
    private final AtomicInteger f1555vB;

    /* renamed from: vC */
    private Api.zze f1556vC;

    /* renamed from: vv */
    private final zzre f1557vv;

    /* renamed from: vw */
    private final O f1558vw;

    /* renamed from: vx */
    private final zzpz<O> f1559vx;

    /* renamed from: vy */
    private final zzqt f1560vy;

    /* renamed from: vz */
    private final GoogleApiClient f1561vz;
    private final Looper zzajn;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzd(@NonNull Context context, Api<O> api, O o) {
        this(context, api, o, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
    }

    public zzd(@NonNull Context context, Api<O> api, O o, Looper looper) {
        this.f1554vA = new AtomicBoolean(false);
        this.f1555vB = new AtomicInteger(0);
        zzac.zzb(context, (Object) "Null context is not permitted.");
        zzac.zzb(api, (Object) "Api must not be null.");
        zzac.zzb(looper, (Object) "Looper must not be null.");
        this.mContext = context.getApplicationContext();
        this.f1553tv = api;
        this.f1558vw = o;
        this.zzajn = looper;
        this.f1557vv = new zzre();
        this.f1559vx = zzpz.zza(this.f1553tv, this.f1558vw);
        this.f1561vz = new zzqu(this);
        Pair<zzqt, Integer> zza = zzqt.zza(this.mContext, (zzd<?>) this);
        this.f1560vy = (zzqt) zza.first;
        this.mId = ((Integer) zza.second).intValue();
    }

    private <A extends Api.zzb, T extends zzqc.zza<? extends Result, A>> T zza(int i, @NonNull T t) {
        t.zzaqt();
        this.f1560vy.zza(this, i, (zzqc.zza<? extends Result, Api.zzb>) t);
        return t;
    }

    private <TResult, A extends Api.zzb> Task<TResult> zza(int i, @NonNull zzro<A, TResult> zzro) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f1560vy.zza(this, i, zzro, taskCompletionSource);
        return taskCompletionSource.getTask();
    }

    public int getInstanceId() {
        return this.mId;
    }

    public Looper getLooper() {
        return this.zzajn;
    }

    public void release() {
        boolean z = true;
        if (!this.f1554vA.getAndSet(true)) {
            this.f1557vv.release();
            zzqt zzqt = this.f1560vy;
            int i = this.mId;
            if (this.f1555vB.get() <= 0) {
                z = false;
            }
            zzqt.zzd(i, z);
        }
    }

    @WorkerThread
    public Api.zze zza(Looper looper, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        if (!zzapw()) {
            if (this.f1553tv.zzapq()) {
                Api.zzh zzapo = this.f1553tv.zzapo();
                this.f1556vC = new zzai(this.mContext, looper, zzapo.zzapt(), connectionCallbacks, onConnectionFailedListener, zzh.zzcd(this.mContext), zzapo.zzr(this.f1558vw));
            } else {
                this.f1556vC = this.f1553tv.zzapn().zza(this.mContext, looper, zzh.zzcd(this.mContext), this.f1558vw, connectionCallbacks, onConnectionFailedListener);
            }
        }
        return this.f1556vC;
    }

    public <A extends Api.zzb, T extends zzqc.zza<? extends Result, A>> T zza(@NonNull T t) {
        return zza(0, t);
    }

    public <TResult, A extends Api.zzb> Task<TResult> zza(zzro<A, TResult> zzro) {
        return zza(0, zzro);
    }

    public void zzapu() {
        this.f1555vB.incrementAndGet();
    }

    public void zzapv() {
        if (this.f1555vB.decrementAndGet() == 0 && this.f1554vA.get()) {
            this.f1560vy.zzd(this.mId, false);
        }
    }

    public boolean zzapw() {
        return this.f1556vC != null;
    }

    public zzpz<O> zzapx() {
        return this.f1559vx;
    }

    public GoogleApiClient zzapy() {
        return this.f1561vz;
    }

    public <A extends Api.zzb, T extends zzqc.zza<? extends Result, A>> T zzb(@NonNull T t) {
        return zza(1, t);
    }

    public <TResult, A extends Api.zzb> Task<TResult> zzb(zzro<A, TResult> zzro) {
        return zza(1, zzro);
    }
}
