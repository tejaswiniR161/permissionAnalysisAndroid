package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.p000v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.zzk;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.internal.zzm;
import com.google.android.gms.internal.zzqc;
import com.google.android.gms.internal.zzqv;
import com.google.android.gms.internal.zzqy;
import com.google.android.gms.internal.zzrq;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zzqp extends GoogleApiClient implements zzqy.zza {
    /* access modifiers changed from: private */
    public final Context mContext;

    /* renamed from: vN */
    private final int f2069vN;

    /* renamed from: vP */
    private final GoogleApiAvailability f2070vP;

    /* renamed from: vQ */
    final Api.zza<? extends zzwz, zzxa> f2071vQ;

    /* renamed from: xB */
    final zzh f2072xB;

    /* renamed from: xC */
    final Map<Api<?>, Integer> f2073xC;

    /* renamed from: xO */
    private final zzm f2074xO;

    /* renamed from: xP */
    private zzqy f2075xP = null;

    /* renamed from: xQ */
    final Queue<zzqc.zza<?, ?>> f2076xQ = new LinkedList();

    /* renamed from: xR */
    private volatile boolean f2077xR;

    /* renamed from: xS */
    private long f2078xS = 120000;

    /* renamed from: xT */
    private long f2079xT = 5000;

    /* renamed from: xU */
    private final zza f2080xU;

    /* renamed from: xV */
    zzqv f2081xV;

    /* renamed from: xW */
    final Map<Api.zzc<?>, Api.zze> f2082xW;

    /* renamed from: xX */
    Set<Scope> f2083xX = new HashSet();

    /* renamed from: xY */
    private final zzre f2084xY = new zzre();

    /* renamed from: xZ */
    private final ArrayList<zzqf> f2085xZ;

    /* renamed from: xf */
    private final Lock f2086xf;

    /* renamed from: ya */
    private Integer f2087ya = null;

    /* renamed from: yb */
    Set<zzrp> f2088yb = null;

    /* renamed from: yc */
    final zzrq f2089yc;

    /* renamed from: yd */
    private final zzm.zza f2090yd = new zzm.zza() {
        public boolean isConnected() {
            return zzqp.this.isConnected();
        }

        public Bundle zzaoe() {
            return null;
        }
    };
    private final Looper zzajn;

    final class zza extends Handler {
        zza(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    zzqp.this.zzarr();
                    return;
                case 2:
                    zzqp.this.resume();
                    return;
                default:
                    Log.w("GoogleApiClientImpl", new StringBuilder(31).append("Unknown message id: ").append(message.what).toString());
                    return;
            }
        }
    }

    static class zzb extends zzqv.zza {

        /* renamed from: yi */
        private WeakReference<zzqp> f2102yi;

        zzb(zzqp zzqp) {
            this.f2102yi = new WeakReference<>(zzqp);
        }

        public void zzaqp() {
            zzqp zzqp = (zzqp) this.f2102yi.get();
            if (zzqp != null) {
                zzqp.resume();
            }
        }
    }

    public zzqp(Context context, Lock lock, Looper looper, zzh zzh, GoogleApiAvailability googleApiAvailability, Api.zza<? extends zzwz, zzxa> zza2, Map<Api<?>, Integer> map, List<GoogleApiClient.ConnectionCallbacks> list, List<GoogleApiClient.OnConnectionFailedListener> list2, Map<Api.zzc<?>, Api.zze> map2, int i, int i2, ArrayList<zzqf> arrayList) {
        this.mContext = context;
        this.f2086xf = lock;
        this.f2074xO = new zzm(looper, this.f2090yd);
        this.zzajn = looper;
        this.f2080xU = new zza(looper);
        this.f2070vP = googleApiAvailability;
        this.f2069vN = i;
        if (this.f2069vN >= 0) {
            this.f2087ya = Integer.valueOf(i2);
        }
        this.f2073xC = map;
        this.f2082xW = map2;
        this.f2085xZ = arrayList;
        this.f2089yc = new zzrq(this.f2082xW);
        for (GoogleApiClient.ConnectionCallbacks registerConnectionCallbacks : list) {
            this.f2074xO.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (GoogleApiClient.OnConnectionFailedListener registerConnectionFailedListener : list2) {
            this.f2074xO.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        this.f2072xB = zzh;
        this.f2071vQ = zza2;
    }

    /* access modifiers changed from: private */
    public void resume() {
        this.f2086xf.lock();
        try {
            if (isResuming()) {
                zzarq();
            }
        } finally {
            this.f2086xf.unlock();
        }
    }

    public static int zza(Iterable<Api.zze> iterable, boolean z) {
        boolean z2 = false;
        boolean z3 = false;
        for (Api.zze next : iterable) {
            if (next.zzahd()) {
                z3 = true;
            }
            z2 = next.zzahs() ? true : z2;
        }
        if (z3) {
            return (!z2 || !z) ? 1 : 2;
        }
        return 3;
    }

    /* access modifiers changed from: private */
    public void zza(final GoogleApiClient googleApiClient, final zzrm zzrm, final boolean z) {
        zzrx.f2232Dh.zzg(googleApiClient).setResultCallback(new ResultCallback<Status>() {
            /* renamed from: zzp */
            public void onResult(@NonNull Status status) {
                zzk.zzbd(zzqp.this.mContext).zzaie();
                if (status.isSuccess() && zzqp.this.isConnected()) {
                    zzqp.this.reconnect();
                }
                zzrm.zzc(status);
                if (z) {
                    googleApiClient.disconnect();
                }
            }
        });
    }

    private void zzarq() {
        this.f2074xO.zzauu();
        this.f2075xP.connect();
    }

    /* access modifiers changed from: private */
    public void zzarr() {
        this.f2086xf.lock();
        try {
            if (zzart()) {
                zzarq();
            }
        } finally {
            this.f2086xf.unlock();
        }
    }

    private void zzb(@NonNull zzqz zzqz) {
        if (this.f2069vN >= 0) {
            zzqa.zza(zzqz).zzfq(this.f2069vN);
            return;
        }
        throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
    }

    private void zzft(int i) {
        if (this.f2087ya == null) {
            this.f2087ya = Integer.valueOf(i);
        } else if (this.f2087ya.intValue() != i) {
            String valueOf = String.valueOf(zzfu(i));
            String valueOf2 = String.valueOf(zzfu(this.f2087ya.intValue()));
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 51 + String.valueOf(valueOf2).length()).append("Cannot use sign-in mode: ").append(valueOf).append(". Mode was already set to ").append(valueOf2).toString());
        }
        if (this.f2075xP == null) {
            boolean z = false;
            boolean z2 = false;
            for (Api.zze next : this.f2082xW.values()) {
                if (next.zzahd()) {
                    z2 = true;
                }
                z = next.zzahs() ? true : z;
            }
            switch (this.f2087ya.intValue()) {
                case 1:
                    if (!z2) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    } else if (z) {
                        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    }
                    break;
                case 2:
                    if (z2) {
                        this.f2075xP = zzqh.zza(this.mContext, this, this.f2086xf, this.zzajn, this.f2070vP, this.f2082xW, this.f2072xB, this.f2073xC, this.f2071vQ, this.f2085xZ);
                        return;
                    }
                    break;
            }
            this.f2075xP = new zzqr(this.mContext, this, this.f2086xf, this.zzajn, this.f2070vP, this.f2082xW, this.f2072xB, this.f2073xC, this.f2071vQ, this.f2085xZ, this);
        }
    }

    static String zzfu(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    public ConnectionResult blockingConnect() {
        boolean z = true;
        zzac.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        this.f2086xf.lock();
        try {
            if (this.f2069vN >= 0) {
                if (this.f2087ya == null) {
                    z = false;
                }
                zzac.zza(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f2087ya == null) {
                this.f2087ya = Integer.valueOf(zza(this.f2082xW.values(), false));
            } else if (this.f2087ya.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzft(this.f2087ya.intValue());
            this.f2074xO.zzauu();
            return this.f2075xP.blockingConnect();
        } finally {
            this.f2086xf.unlock();
        }
    }

    public ConnectionResult blockingConnect(long j, @NonNull TimeUnit timeUnit) {
        boolean z = false;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            z = true;
        }
        zzac.zza(z, (Object) "blockingConnect must not be called on the UI thread");
        zzac.zzb(timeUnit, (Object) "TimeUnit must not be null");
        this.f2086xf.lock();
        try {
            if (this.f2087ya == null) {
                this.f2087ya = Integer.valueOf(zza(this.f2082xW.values(), false));
            } else if (this.f2087ya.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            zzft(this.f2087ya.intValue());
            this.f2074xO.zzauu();
            return this.f2075xP.blockingConnect(j, timeUnit);
        } finally {
            this.f2086xf.unlock();
        }
    }

    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        zzac.zza(isConnected(), (Object) "GoogleApiClient is not connected yet.");
        zzac.zza(this.f2087ya.intValue() != 2, (Object) "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        final zzrm zzrm = new zzrm((GoogleApiClient) this);
        if (this.f2082xW.containsKey(zzrx.f2233fa)) {
            zza(this, zzrm, false);
        } else {
            final AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient build = new GoogleApiClient.Builder(this.mContext).addApi(zzrx.API).addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                public void onConnected(Bundle bundle) {
                    zzqp.this.zza((GoogleApiClient) atomicReference.get(), zzrm, true);
                }

                public void onConnectionSuspended(int i) {
                }
            }).addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() {
                public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                    zzrm.zzc(new Status(8));
                }
            }).setHandler(this.f2080xU).build();
            atomicReference.set(build);
            build.connect();
        }
        return zzrm;
    }

    public void connect() {
        boolean z = false;
        this.f2086xf.lock();
        try {
            if (this.f2069vN >= 0) {
                if (this.f2087ya != null) {
                    z = true;
                }
                zzac.zza(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f2087ya == null) {
                this.f2087ya = Integer.valueOf(zza(this.f2082xW.values(), false));
            } else if (this.f2087ya.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            connect(this.f2087ya.intValue());
        } finally {
            this.f2086xf.unlock();
        }
    }

    public void connect(int i) {
        boolean z = true;
        this.f2086xf.lock();
        if (!(i == 3 || i == 1 || i == 2)) {
            z = false;
        }
        try {
            zzac.zzb(z, (Object) new StringBuilder(33).append("Illegal sign-in mode: ").append(i).toString());
            zzft(i);
            zzarq();
        } finally {
            this.f2086xf.unlock();
        }
    }

    public void disconnect() {
        this.f2086xf.lock();
        try {
            this.f2089yc.release();
            if (this.f2075xP != null) {
                this.f2075xP.disconnect();
            }
            this.f2084xY.release();
            for (zzqc.zza zza2 : this.f2076xQ) {
                zza2.zza((zzrq.zzb) null);
                zza2.cancel();
            }
            this.f2076xQ.clear();
            if (this.f2075xP != null) {
                zzart();
                this.f2074xO.zzaut();
                this.f2086xf.unlock();
            }
        } finally {
            this.f2086xf.unlock();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.mContext);
        printWriter.append(str).append("mResuming=").print(this.f2077xR);
        printWriter.append(" mWorkQueue.size()=").print(this.f2076xQ.size());
        this.f2089yc.dump(printWriter);
        if (this.f2075xP != null) {
            this.f2075xP.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    @NonNull
    public ConnectionResult getConnectionResult(@NonNull Api<?> api) {
        this.f2086xf.lock();
        try {
            if (!isConnected() && !isResuming()) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            } else if (this.f2082xW.containsKey(api.zzapp())) {
                ConnectionResult connectionResult = this.f2075xP.getConnectionResult(api);
                if (connectionResult != null) {
                    this.f2086xf.unlock();
                } else if (isResuming()) {
                    connectionResult = ConnectionResult.f1494uJ;
                } else {
                    Log.w("GoogleApiClientImpl", zzarv());
                    Log.wtf("GoogleApiClientImpl", String.valueOf(api.getName()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
                    connectionResult = new ConnectionResult(8, (PendingIntent) null);
                    this.f2086xf.unlock();
                }
                return connectionResult;
            } else {
                throw new IllegalArgumentException(String.valueOf(api.getName()).concat(" was never registered with GoogleApiClient"));
            }
        } finally {
            this.f2086xf.unlock();
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    public Looper getLooper() {
        return this.zzajn;
    }

    public int getSessionId() {
        return System.identityHashCode(this);
    }

    public boolean hasConnectedApi(@NonNull Api<?> api) {
        Api.zze zze = this.f2082xW.get(api.zzapp());
        return zze != null && zze.isConnected();
    }

    public boolean isConnected() {
        return this.f2075xP != null && this.f2075xP.isConnected();
    }

    public boolean isConnecting() {
        return this.f2075xP != null && this.f2075xP.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        return this.f2074xO.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    public boolean isConnectionFailedListenerRegistered(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.f2074xO.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    /* access modifiers changed from: package-private */
    public boolean isResuming() {
        return this.f2077xR;
    }

    public void reconnect() {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f2074xO.registerConnectionCallbacks(connectionCallbacks);
    }

    public void registerConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f2074xO.registerConnectionFailedListener(onConnectionFailedListener);
    }

    public void stopAutoManage(@NonNull FragmentActivity fragmentActivity) {
        zzb(new zzqz(fragmentActivity));
    }

    public void unregisterConnectionCallbacks(@NonNull GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.f2074xO.unregisterConnectionCallbacks(connectionCallbacks);
    }

    public void unregisterConnectionFailedListener(@NonNull GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.f2074xO.unregisterConnectionFailedListener(onConnectionFailedListener);
    }

    @NonNull
    public <C extends Api.zze> C zza(@NonNull Api.zzc<C> zzc) {
        C c = (Api.zze) this.f2082xW.get(zzc);
        zzac.zzb(c, (Object) "Appropriate Api was not requested.");
        return c;
    }

    public void zza(zzrp zzrp) {
        this.f2086xf.lock();
        try {
            if (this.f2088yb == null) {
                this.f2088yb = new HashSet();
            }
            this.f2088yb.add(zzrp);
        } finally {
            this.f2086xf.unlock();
        }
    }

    public boolean zza(@NonNull Api<?> api) {
        return this.f2082xW.containsKey(api.zzapp());
    }

    public boolean zza(zzrl zzrl) {
        return this.f2075xP != null && this.f2075xP.zza(zzrl);
    }

    public void zzaqb() {
        if (this.f2075xP != null) {
            this.f2075xP.zzaqb();
        }
    }

    /* access modifiers changed from: package-private */
    public void zzars() {
        if (!isResuming()) {
            this.f2077xR = true;
            if (this.f2081xV == null) {
                this.f2081xV = this.f2070vP.zza(this.mContext.getApplicationContext(), (zzqv.zza) new zzb(this));
            }
            this.f2080xU.sendMessageDelayed(this.f2080xU.obtainMessage(1), this.f2078xS);
            this.f2080xU.sendMessageDelayed(this.f2080xU.obtainMessage(2), this.f2079xT);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzart() {
        if (!isResuming()) {
            return false;
        }
        this.f2077xR = false;
        this.f2080xU.removeMessages(2);
        this.f2080xU.removeMessages(1);
        if (this.f2081xV != null) {
            this.f2081xV.unregister();
            this.f2081xV = null;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean zzaru() {
        boolean z = false;
        this.f2086xf.lock();
        try {
            if (this.f2088yb != null) {
                if (!this.f2088yb.isEmpty()) {
                    z = true;
                }
                this.f2086xf.unlock();
            }
            return z;
        } finally {
            this.f2086xf.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public String zzarv() {
        StringWriter stringWriter = new StringWriter();
        dump("", (FileDescriptor) null, new PrintWriter(stringWriter), (String[]) null);
        return stringWriter.toString();
    }

    /* access modifiers changed from: package-private */
    public <C extends Api.zze> C zzb(Api.zzc<?> zzc) {
        C c = (Api.zze) this.f2082xW.get(zzc);
        zzac.zzb(c, (Object) "Appropriate Api was not requested.");
        return c;
    }

    public void zzb(zzrp zzrp) {
        this.f2086xf.lock();
        try {
            if (this.f2088yb == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.f2088yb.remove(zzrp)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!zzaru()) {
                this.f2075xP.zzaqy();
            }
        } finally {
            this.f2086xf.unlock();
        }
    }

    public <A extends Api.zzb, R extends Result, T extends zzqc.zza<R, A>> T zzc(@NonNull T t) {
        zzac.zzb(t.zzapp() != null, (Object) "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.f2082xW.containsKey(t.zzapp());
        String name = t.zzaqn() != null ? t.zzaqn().getName() : "the API";
        zzac.zzb(containsKey, (Object) new StringBuilder(String.valueOf(name).length() + 65).append("GoogleApiClient is not configured to use ").append(name).append(" required for this call.").toString());
        this.f2086xf.lock();
        try {
            if (this.f2075xP == null) {
                this.f2076xQ.add(t);
            } else {
                t = this.f2075xP.zzc(t);
                this.f2086xf.unlock();
            }
            return t;
        } finally {
            this.f2086xf.unlock();
        }
    }

    public void zzc(int i, boolean z) {
        if (i == 1 && !z) {
            zzars();
        }
        this.f2089yc.zzasw();
        this.f2074xO.zzgo(i);
        this.f2074xO.zzaut();
        if (i == 2) {
            zzarq();
        }
    }

    public <A extends Api.zzb, T extends zzqc.zza<? extends Result, A>> T zzd(@NonNull T t) {
        zzac.zzb(t.zzapp() != null, (Object) "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.f2082xW.containsKey(t.zzapp());
        String name = t.zzaqn() != null ? t.zzaqn().getName() : "the API";
        zzac.zzb(containsKey, (Object) new StringBuilder(String.valueOf(name).length() + 65).append("GoogleApiClient is not configured to use ").append(name).append(" required for this call.").toString());
        this.f2086xf.lock();
        try {
            if (this.f2075xP == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (isResuming()) {
                this.f2076xQ.add(t);
                while (!this.f2076xQ.isEmpty()) {
                    zzqc.zza remove = this.f2076xQ.remove();
                    this.f2089yc.zzb((zzqe<? extends Result>) remove);
                    remove.zzz(Status.f1542wa);
                }
            } else {
                t = this.f2075xP.zzd(t);
                this.f2086xf.unlock();
            }
            return t;
        } finally {
            this.f2086xf.unlock();
        }
    }

    public void zzd(ConnectionResult connectionResult) {
        if (!this.f2070vP.zzd(this.mContext, connectionResult.getErrorCode())) {
            zzart();
        }
        if (!isResuming()) {
            this.f2074xO.zzn(connectionResult);
            this.f2074xO.zzaut();
        }
    }

    public void zzn(Bundle bundle) {
        while (!this.f2076xQ.isEmpty()) {
            zzd(this.f2076xQ.remove());
        }
        this.f2074xO.zzp(bundle);
    }

    public <L> zzrd<L> zzs(@NonNull L l) {
        this.f2086xf.lock();
        try {
            return this.f2084xY.zzb(l, this.zzajn);
        } finally {
            this.f2086xf.unlock();
        }
    }
}
