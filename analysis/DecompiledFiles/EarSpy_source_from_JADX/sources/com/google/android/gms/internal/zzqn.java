package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.BinderThread;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.internal.zzqc;
import com.google.android.gms.internal.zzqr;
import com.google.android.gms.signin.internal.SignInResponse;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public class zzqn implements zzqq {
    /* access modifiers changed from: private */
    public final Context mContext;

    /* renamed from: vQ */
    private final Api.zza<? extends zzwz, zzxa> f2030vQ;

    /* renamed from: xA */
    private boolean f2031xA;

    /* renamed from: xB */
    private final zzh f2032xB;

    /* renamed from: xC */
    private final Map<Api<?>, Integer> f2033xC;

    /* renamed from: xD */
    private ArrayList<Future<?>> f2034xD = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: xf */
    public final Lock f2035xf;
    /* access modifiers changed from: private */

    /* renamed from: xk */
    public final zzqr f2036xk;
    /* access modifiers changed from: private */

    /* renamed from: xn */
    public final com.google.android.gms.common.zzc f2037xn;

    /* renamed from: xo */
    private ConnectionResult f2038xo;

    /* renamed from: xp */
    private int f2039xp;

    /* renamed from: xq */
    private int f2040xq = 0;

    /* renamed from: xr */
    private int f2041xr;

    /* renamed from: xs */
    private final Bundle f2042xs = new Bundle();

    /* renamed from: xt */
    private final Set<Api.zzc> f2043xt = new HashSet();
    /* access modifiers changed from: private */

    /* renamed from: xu */
    public zzwz f2044xu;

    /* renamed from: xv */
    private int f2045xv;
    /* access modifiers changed from: private */

    /* renamed from: xw */
    public boolean f2046xw;

    /* renamed from: xx */
    private boolean f2047xx;
    /* access modifiers changed from: private */

    /* renamed from: xy */
    public zzr f2048xy;

    /* renamed from: xz */
    private boolean f2049xz;

    private static class zza implements zze.zzf {

        /* renamed from: tv */
        private final Api<?> f2051tv;
        /* access modifiers changed from: private */

        /* renamed from: wT */
        public final int f2052wT;

        /* renamed from: xF */
        private final WeakReference<zzqn> f2053xF;

        public zza(zzqn zzqn, Api<?> api, int i) {
            this.f2053xF = new WeakReference<>(zzqn);
            this.f2051tv = api;
            this.f2052wT = i;
        }

        public void zzh(@NonNull ConnectionResult connectionResult) {
            boolean z = false;
            zzqn zzqn = (zzqn) this.f2053xF.get();
            if (zzqn != null) {
                if (Looper.myLooper() == zzqn.f2036xk.f2104wV.getLooper()) {
                    z = true;
                }
                zzac.zza(z, (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
                zzqn.f2035xf.lock();
                try {
                    if (zzqn.zzfr(0)) {
                        if (!connectionResult.isSuccess()) {
                            zzqn.zzb(connectionResult, this.f2051tv, this.f2052wT);
                        }
                        if (zzqn.zzarj()) {
                            zzqn.zzark();
                        }
                        zzqn.f2035xf.unlock();
                    }
                } finally {
                    zzqn.f2035xf.unlock();
                }
            }
        }
    }

    private class zzb extends zzf {

        /* renamed from: xG */
        private final Map<Api.zze, zza> f2055xG;

        public zzb(Map<Api.zze, zza> map) {
            super();
            this.f2055xG = map;
        }

        @WorkerThread
        public void zzari() {
            boolean z;
            boolean z2;
            boolean z3;
            boolean z4 = true;
            int i = 0;
            Iterator<Api.zze> it = this.f2055xG.keySet().iterator();
            boolean z5 = true;
            boolean z6 = false;
            while (true) {
                if (!it.hasNext()) {
                    z4 = z6;
                    z = false;
                    break;
                }
                Api.zze next = it.next();
                if (!next.zzapr()) {
                    z3 = false;
                    z2 = z6;
                } else if (this.f2055xG.get(next).f2052wT == 0) {
                    z = true;
                    break;
                } else {
                    z3 = z5;
                    z2 = true;
                }
                z6 = z2;
                z5 = z3;
            }
            if (z4) {
                i = zzqn.this.f2037xn.isGooglePlayServicesAvailable(zzqn.this.mContext);
            }
            if (i == 0 || (!z && !z5)) {
                if (zzqn.this.f2046xw) {
                    zzqn.this.f2044xu.connect();
                }
                for (Api.zze next2 : this.f2055xG.keySet()) {
                    final zze.zzf zzf = this.f2055xG.get(next2);
                    if (!next2.zzapr() || i == 0) {
                        next2.zza(zzf);
                    } else {
                        zzqn.this.f2036xk.zza((zzqr.zza) new zzqr.zza(zzqn.this) {
                            public void zzari() {
                                zzf.zzh(new ConnectionResult(16, (PendingIntent) null));
                            }
                        });
                    }
                }
                return;
            }
            final ConnectionResult connectionResult = new ConnectionResult(i, (PendingIntent) null);
            zzqn.this.f2036xk.zza((zzqr.zza) new zzqr.zza(zzqn.this) {
                public void zzari() {
                    zzqn.this.zzg(connectionResult);
                }
            });
        }
    }

    private class zzc extends zzf {

        /* renamed from: xK */
        private final ArrayList<Api.zze> f2061xK;

        public zzc(ArrayList<Api.zze> arrayList) {
            super();
            this.f2061xK = arrayList;
        }

        @WorkerThread
        public void zzari() {
            zzqn.this.f2036xk.f2104wV.f2083xX = zzqn.this.zzarp();
            Iterator<Api.zze> it = this.f2061xK.iterator();
            while (it.hasNext()) {
                it.next().zza(zzqn.this.f2048xy, zzqn.this.f2036xk.f2104wV.f2083xX);
            }
        }
    }

    private static class zzd extends com.google.android.gms.signin.internal.zzb {

        /* renamed from: xF */
        private final WeakReference<zzqn> f2062xF;

        zzd(zzqn zzqn) {
            this.f2062xF = new WeakReference<>(zzqn);
        }

        @BinderThread
        public void zzb(final SignInResponse signInResponse) {
            final zzqn zzqn = (zzqn) this.f2062xF.get();
            if (zzqn != null) {
                zzqn.f2036xk.zza((zzqr.zza) new zzqr.zza(zzqn) {
                    public void zzari() {
                        zzqn.zza(signInResponse);
                    }
                });
            }
        }
    }

    private class zze implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        private zze() {
        }

        public void onConnected(Bundle bundle) {
            zzqn.this.f2044xu.zza(new zzd(zzqn.this));
        }

        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzqn.this.f2035xf.lock();
            try {
                if (zzqn.this.zzf(connectionResult)) {
                    zzqn.this.zzarn();
                    zzqn.this.zzark();
                } else {
                    zzqn.this.zzg(connectionResult);
                }
            } finally {
                zzqn.this.f2035xf.unlock();
            }
        }

        public void onConnectionSuspended(int i) {
        }
    }

    private abstract class zzf implements Runnable {
        private zzf() {
        }

        @WorkerThread
        public void run() {
            zzqn.this.f2035xf.lock();
            try {
                if (!Thread.interrupted()) {
                    zzari();
                    zzqn.this.f2035xf.unlock();
                }
            } catch (RuntimeException e) {
                zzqn.this.f2036xk.zza(e);
            } finally {
                zzqn.this.f2035xf.unlock();
            }
        }

        /* access modifiers changed from: protected */
        @WorkerThread
        public abstract void zzari();
    }

    public zzqn(zzqr zzqr, zzh zzh, Map<Api<?>, Integer> map, com.google.android.gms.common.zzc zzc2, Api.zza<? extends zzwz, zzxa> zza2, Lock lock, Context context) {
        this.f2036xk = zzqr;
        this.f2032xB = zzh;
        this.f2033xC = map;
        this.f2037xn = zzc2;
        this.f2030vQ = zza2;
        this.f2035xf = lock;
        this.mContext = context;
    }

    /* access modifiers changed from: private */
    public void zza(SignInResponse signInResponse) {
        if (zzfr(0)) {
            ConnectionResult zzave = signInResponse.zzave();
            if (zzave.isSuccess()) {
                ResolveAccountResponse zzcdl = signInResponse.zzcdl();
                ConnectionResult zzave2 = zzcdl.zzave();
                if (!zzave2.isSuccess()) {
                    String valueOf = String.valueOf(zzave2);
                    Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(valueOf).toString(), new Exception());
                    zzg(zzave2);
                    return;
                }
                this.f2047xx = true;
                this.f2048xy = zzcdl.zzavd();
                this.f2049xz = zzcdl.zzavf();
                this.f2031xA = zzcdl.zzavg();
                zzark();
            } else if (zzf(zzave)) {
                zzarn();
                zzark();
            } else {
                zzg(zzave);
            }
        }
    }

    private boolean zza(int i, int i2, ConnectionResult connectionResult) {
        if (i2 != 1 || zze(connectionResult)) {
            return this.f2038xo == null || i < this.f2039xp;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean zzarj() {
        this.f2041xr--;
        if (this.f2041xr > 0) {
            return false;
        }
        if (this.f2041xr < 0) {
            Log.w("GoogleApiClientConnecting", this.f2036xk.f2104wV.zzarv());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            zzg(new ConnectionResult(8, (PendingIntent) null));
            return false;
        } else if (this.f2038xo == null) {
            return true;
        } else {
            this.f2036xk.f2115yo = this.f2039xp;
            zzg(this.f2038xo);
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void zzark() {
        if (this.f2041xr == 0) {
            if (!this.f2046xw || this.f2047xx) {
                zzarl();
            }
        }
    }

    private void zzarl() {
        ArrayList arrayList = new ArrayList();
        this.f2040xq = 1;
        this.f2041xr = this.f2036xk.f2107xW.size();
        for (Api.zzc next : this.f2036xk.f2107xW.keySet()) {
            if (!this.f2036xk.f2112yl.containsKey(next)) {
                arrayList.add(this.f2036xk.f2107xW.get(next));
            } else if (zzarj()) {
                zzarm();
            }
        }
        if (!arrayList.isEmpty()) {
            this.f2034xD.add(zzqs.zzarz().submit(new zzc(arrayList)));
        }
    }

    private void zzarm() {
        this.f2036xk.zzarx();
        zzqs.zzarz().execute(new Runnable() {
            public void run() {
                zzqn.this.f2037xn.zzbq(zzqn.this.mContext);
            }
        });
        if (this.f2044xu != null) {
            if (this.f2049xz) {
                this.f2044xu.zza(this.f2048xy, this.f2031xA);
            }
            zzbq(false);
        }
        for (Api.zzc<?> zzc2 : this.f2036xk.f2112yl.keySet()) {
            this.f2036xk.f2107xW.get(zzc2).disconnect();
        }
        this.f2036xk.f2116yp.zzn(this.f2042xs.isEmpty() ? null : this.f2042xs);
    }

    /* access modifiers changed from: private */
    public void zzarn() {
        this.f2046xw = false;
        this.f2036xk.f2104wV.f2083xX = Collections.emptySet();
        for (Api.zzc next : this.f2043xt) {
            if (!this.f2036xk.f2112yl.containsKey(next)) {
                this.f2036xk.f2112yl.put(next, new ConnectionResult(17, (PendingIntent) null));
            }
        }
    }

    private void zzaro() {
        Iterator<Future<?>> it = this.f2034xD.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
        this.f2034xD.clear();
    }

    /* access modifiers changed from: private */
    public Set<Scope> zzarp() {
        if (this.f2032xB == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.f2032xB.zzaug());
        Map<Api<?>, zzh.zza> zzaui = this.f2032xB.zzaui();
        for (Api next : zzaui.keySet()) {
            if (!this.f2036xk.f2112yl.containsKey(next.zzapp())) {
                hashSet.addAll(zzaui.get(next).f1730hm);
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: private */
    public void zzb(ConnectionResult connectionResult, Api<?> api, int i) {
        if (i != 2) {
            int priority = api.zzapm().getPriority();
            if (zza(priority, i, connectionResult)) {
                this.f2038xo = connectionResult;
                this.f2039xp = priority;
            }
        }
        this.f2036xk.f2112yl.put(api.zzapp(), connectionResult);
    }

    private void zzbq(boolean z) {
        if (this.f2044xu != null) {
            if (this.f2044xu.isConnected() && z) {
                this.f2044xu.zzcda();
            }
            this.f2044xu.disconnect();
            this.f2048xy = null;
        }
    }

    private boolean zze(ConnectionResult connectionResult) {
        return connectionResult.hasResolution() || this.f2037xn.zzfl(connectionResult.getErrorCode()) != null;
    }

    /* access modifiers changed from: private */
    public boolean zzf(ConnectionResult connectionResult) {
        if (this.f2045xv != 2) {
            return this.f2045xv == 1 && !connectionResult.hasResolution();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public boolean zzfr(int i) {
        if (this.f2040xq == i) {
            return true;
        }
        Log.w("GoogleApiClientConnecting", this.f2036xk.f2104wV.zzarv());
        String valueOf = String.valueOf(this);
        Log.w("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 23).append("Unexpected callback in ").append(valueOf).toString());
        Log.w("GoogleApiClientConnecting", new StringBuilder(33).append("mRemainingConnections=").append(this.f2041xr).toString());
        String valueOf2 = String.valueOf(zzfs(this.f2040xq));
        String valueOf3 = String.valueOf(zzfs(i));
        Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf2).length() + 70 + String.valueOf(valueOf3).length()).append("GoogleApiClient connecting is in step ").append(valueOf2).append(" but received callback for step ").append(valueOf3).toString(), new Exception());
        zzg(new ConnectionResult(8, (PendingIntent) null));
        return false;
    }

    private String zzfs(int i) {
        switch (i) {
            case 0:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case 1:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    /* access modifiers changed from: private */
    public void zzg(ConnectionResult connectionResult) {
        zzaro();
        zzbq(!connectionResult.hasResolution());
        this.f2036xk.zzi(connectionResult);
        this.f2036xk.f2116yp.zzd(connectionResult);
    }

    public void begin() {
        this.f2036xk.f2112yl.clear();
        this.f2046xw = false;
        this.f2038xo = null;
        this.f2040xq = 0;
        this.f2045xv = 2;
        this.f2047xx = false;
        this.f2049xz = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (Api next : this.f2033xC.keySet()) {
            Api.zze zze2 = this.f2036xk.f2107xW.get(next.zzapp());
            int intValue = this.f2033xC.get(next).intValue();
            boolean z2 = (next.zzapm().getPriority() == 1) | z;
            if (zze2.zzahd()) {
                this.f2046xw = true;
                if (intValue < this.f2045xv) {
                    this.f2045xv = intValue;
                }
                if (intValue != 0) {
                    this.f2043xt.add(next.zzapp());
                }
            }
            hashMap.put(zze2, new zza(this, next, intValue));
            z = z2;
        }
        if (z) {
            this.f2046xw = false;
        }
        if (this.f2046xw) {
            this.f2032xB.zzc(Integer.valueOf(this.f2036xk.f2104wV.getSessionId()));
            zze zze3 = new zze();
            this.f2044xu = (zzwz) this.f2030vQ.zza(this.mContext, this.f2036xk.f2104wV.getLooper(), this.f2032xB, this.f2032xB.zzaum(), zze3, zze3);
        }
        this.f2041xr = this.f2036xk.f2107xW.size();
        this.f2034xD.add(zzqs.zzarz().submit(new zzb(hashMap)));
    }

    public void connect() {
    }

    public boolean disconnect() {
        zzaro();
        zzbq(true);
        this.f2036xk.zzi((ConnectionResult) null);
        return true;
    }

    public void onConnected(Bundle bundle) {
        if (zzfr(1)) {
            if (bundle != null) {
                this.f2042xs.putAll(bundle);
            }
            if (zzarj()) {
                zzarm();
            }
        }
    }

    public void onConnectionSuspended(int i) {
        zzg(new ConnectionResult(8, (PendingIntent) null));
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
        if (zzfr(1)) {
            zzb(connectionResult, api, i);
            if (zzarj()) {
                zzarm();
            }
        }
    }

    public <A extends Api.zzb, R extends Result, T extends zzqc.zza<R, A>> T zzc(T t) {
        this.f2036xk.f2104wV.f2076xQ.add(t);
        return t;
    }

    public <A extends Api.zzb, T extends zzqc.zza<? extends Result, A>> T zzd(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
