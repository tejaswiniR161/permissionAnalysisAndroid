package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.zzc;
import com.google.android.gms.internal.zzqc;
import com.google.android.gms.internal.zzqy;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class zzqr implements zzqg, zzqy {
    private final Context mContext;

    /* renamed from: vQ */
    final Api.zza<? extends zzwz, zzxa> f2103vQ;

    /* renamed from: wV */
    final zzqp f2104wV;

    /* renamed from: xB */
    final zzh f2105xB;

    /* renamed from: xC */
    final Map<Api<?>, Integer> f2106xC;

    /* renamed from: xW */
    final Map<Api.zzc<?>, Api.zze> f2107xW;
    /* access modifiers changed from: private */

    /* renamed from: xf */
    public final Lock f2108xf;

    /* renamed from: xn */
    private final zzc f2109xn;

    /* renamed from: yj */
    private final Condition f2110yj;

    /* renamed from: yk */
    private final zzb f2111yk;

    /* renamed from: yl */
    final Map<Api.zzc<?>, ConnectionResult> f2112yl = new HashMap();
    /* access modifiers changed from: private */

    /* renamed from: ym */
    public volatile zzqq f2113ym;

    /* renamed from: yn */
    private ConnectionResult f2114yn = null;

    /* renamed from: yo */
    int f2115yo;

    /* renamed from: yp */
    final zzqy.zza f2116yp;

    static abstract class zza {

        /* renamed from: yq */
        private final zzqq f2117yq;

        protected zza(zzqq zzqq) {
            this.f2117yq = zzqq;
        }

        /* access modifiers changed from: protected */
        public abstract void zzari();

        public final void zzc(zzqr zzqr) {
            zzqr.f2108xf.lock();
            try {
                if (zzqr.f2113ym == this.f2117yq) {
                    zzari();
                    zzqr.f2108xf.unlock();
                }
            } finally {
                zzqr.f2108xf.unlock();
            }
        }
    }

    final class zzb extends Handler {
        zzb(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    ((zza) message.obj).zzc(zzqr.this);
                    return;
                case 2:
                    throw ((RuntimeException) message.obj);
                default:
                    Log.w("GACStateManager", new StringBuilder(31).append("Unknown message id: ").append(message.what).toString());
                    return;
            }
        }
    }

    public zzqr(Context context, zzqp zzqp, Lock lock, Looper looper, zzc zzc, Map<Api.zzc<?>, Api.zze> map, zzh zzh, Map<Api<?>, Integer> map2, Api.zza<? extends zzwz, zzxa> zza2, ArrayList<zzqf> arrayList, zzqy.zza zza3) {
        this.mContext = context;
        this.f2108xf = lock;
        this.f2109xn = zzc;
        this.f2107xW = map;
        this.f2105xB = zzh;
        this.f2106xC = map2;
        this.f2103vQ = zza2;
        this.f2104wV = zzqp;
        this.f2116yp = zza3;
        Iterator<zzqf> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().zza(this);
        }
        this.f2111yk = new zzb(looper);
        this.f2110yj = lock.newCondition();
        this.f2113ym = new zzqo(this);
    }

    public ConnectionResult blockingConnect() {
        connect();
        while (isConnecting()) {
            try {
                this.f2110yj.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, (PendingIntent) null);
            }
        }
        return isConnected() ? ConnectionResult.f1494uJ : this.f2114yn != null ? this.f2114yn : new ConnectionResult(13, (PendingIntent) null);
    }

    public ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        connect();
        long nanos = timeUnit.toNanos(j);
        while (isConnecting()) {
            if (nanos <= 0) {
                try {
                    disconnect();
                    return new ConnectionResult(14, (PendingIntent) null);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return new ConnectionResult(15, (PendingIntent) null);
                }
            } else {
                nanos = this.f2110yj.awaitNanos(nanos);
            }
        }
        return isConnected() ? ConnectionResult.f1494uJ : this.f2114yn != null ? this.f2114yn : new ConnectionResult(13, (PendingIntent) null);
    }

    public void connect() {
        this.f2113ym.connect();
    }

    public void disconnect() {
        if (this.f2113ym.disconnect()) {
            this.f2112yl.clear();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append(str).append("mState=").println(this.f2113ym);
        for (Api next : this.f2106xC.keySet()) {
            printWriter.append(str).append(next.getName()).println(":");
            this.f2107xW.get(next.zzapp()).dump(concat, fileDescriptor, printWriter, strArr);
        }
    }

    @Nullable
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        Api.zzc<?> zzapp = api.zzapp();
        if (this.f2107xW.containsKey(zzapp)) {
            if (this.f2107xW.get(zzapp).isConnected()) {
                return ConnectionResult.f1494uJ;
            }
            if (this.f2112yl.containsKey(zzapp)) {
                return this.f2112yl.get(zzapp);
            }
        }
        return null;
    }

    public boolean isConnected() {
        return this.f2113ym instanceof zzqm;
    }

    public boolean isConnecting() {
        return this.f2113ym instanceof zzqn;
    }

    public void onConnected(@Nullable Bundle bundle) {
        this.f2108xf.lock();
        try {
            this.f2113ym.onConnected(bundle);
        } finally {
            this.f2108xf.unlock();
        }
    }

    public void onConnectionSuspended(int i) {
        this.f2108xf.lock();
        try {
            this.f2113ym.onConnectionSuspended(i);
        } finally {
            this.f2108xf.unlock();
        }
    }

    public void zza(@NonNull ConnectionResult connectionResult, @NonNull Api<?> api, int i) {
        this.f2108xf.lock();
        try {
            this.f2113ym.zza(connectionResult, api, i);
        } finally {
            this.f2108xf.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public void zza(zza zza2) {
        this.f2111yk.sendMessage(this.f2111yk.obtainMessage(1, zza2));
    }

    /* access modifiers changed from: package-private */
    public void zza(RuntimeException runtimeException) {
        this.f2111yk.sendMessage(this.f2111yk.obtainMessage(2, runtimeException));
    }

    public boolean zza(zzrl zzrl) {
        return false;
    }

    public void zzaqb() {
    }

    public void zzaqy() {
        if (isConnected()) {
            ((zzqm) this.f2113ym).zzarh();
        }
    }

    /* access modifiers changed from: package-private */
    public void zzarw() {
        this.f2108xf.lock();
        try {
            this.f2113ym = new zzqn(this, this.f2105xB, this.f2106xC, this.f2109xn, this.f2103vQ, this.f2108xf, this.mContext);
            this.f2113ym.begin();
            this.f2110yj.signalAll();
        } finally {
            this.f2108xf.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public void zzarx() {
        this.f2108xf.lock();
        try {
            this.f2104wV.zzart();
            this.f2113ym = new zzqm(this);
            this.f2113ym.begin();
            this.f2110yj.signalAll();
        } finally {
            this.f2108xf.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public void zzary() {
        for (Api.zze disconnect : this.f2107xW.values()) {
            disconnect.disconnect();
        }
    }

    public <A extends Api.zzb, R extends Result, T extends zzqc.zza<R, A>> T zzc(@NonNull T t) {
        t.zzaqt();
        return this.f2113ym.zzc(t);
    }

    public <A extends Api.zzb, T extends zzqc.zza<? extends Result, A>> T zzd(@NonNull T t) {
        t.zzaqt();
        return this.f2113ym.zzd(t);
    }

    /* access modifiers changed from: package-private */
    public void zzi(ConnectionResult connectionResult) {
        this.f2108xf.lock();
        try {
            this.f2114yn = connectionResult;
            this.f2113ym = new zzqo(this);
            this.f2113ym.begin();
            this.f2110yj.signalAll();
        } finally {
            this.f2108xf.unlock();
        }
    }
}
