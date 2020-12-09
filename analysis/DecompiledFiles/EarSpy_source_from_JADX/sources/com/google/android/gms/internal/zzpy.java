package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.os.DeadObjectException;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.p000v4.util.ArrayMap;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzqc;
import com.google.android.gms.internal.zzrd;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.FirebaseException;
import java.util.Map;

public abstract class zzpy {

    /* renamed from: lN */
    public final int f1957lN;

    /* renamed from: wf */
    public final int f1958wf;

    private static abstract class zza extends zzpy {

        /* renamed from: wg */
        protected final SparseArray<Map<zzrd.zzb<?>, zzri>> f1959wg;

        /* renamed from: wh */
        protected final TaskCompletionSource<Void> f1960wh;

        public zza(int i, int i2, TaskCompletionSource<Void> taskCompletionSource, SparseArray<Map<zzrd.zzb<?>, zzri>> sparseArray) {
            super(i, i2);
            this.f1959wg = sparseArray;
            this.f1960wh = taskCompletionSource;
        }

        private void zza(RemoteException remoteException) {
            zzx(new Status(8, remoteException.getLocalizedMessage(), (PendingIntent) null));
        }

        public boolean cancel() {
            this.f1960wh.setException(new com.google.android.gms.common.api.zza(Status.f1544wc));
            return true;
        }

        public void zza(SparseArray<zzrq> sparseArray) {
        }

        /* access modifiers changed from: protected */
        public abstract void zza(Api.zzb zzb) throws RemoteException;

        public final void zzb(Api.zzb zzb) throws DeadObjectException {
            try {
                zza(zzb);
            } catch (DeadObjectException e) {
                zza((RemoteException) e);
                throw e;
            } catch (RemoteException e2) {
                zza(e2);
            }
        }

        public void zzx(@NonNull Status status) {
            this.f1960wh.setException(new com.google.android.gms.common.api.zza(status));
        }
    }

    public static class zzb<A extends zzqc.zza<? extends Result, Api.zzb>> extends zzpy {

        /* renamed from: wi */
        protected final A f1961wi;

        public zzb(int i, int i2, A a) {
            super(i, i2);
            this.f1961wi = a;
        }

        public boolean cancel() {
            return this.f1961wi.zzaqq();
        }

        public void zza(SparseArray<zzrq> sparseArray) {
            zzrq zzrq = sparseArray.get(this.f1958wf);
            if (zzrq != null) {
                zzrq.zzb((zzqe<? extends Result>) this.f1961wi);
            }
        }

        public void zzb(Api.zzb zzb) throws DeadObjectException {
            this.f1961wi.zzb(zzb);
        }

        public void zzx(@NonNull Status status) {
            this.f1961wi.zzz(status);
        }
    }

    public static final class zzc extends zza {

        /* renamed from: wj */
        public final zzrh<Api.zzb> f1962wj;

        /* renamed from: wk */
        public final zzrr<Api.zzb> f1963wk;

        public zzc(int i, zzri zzri, TaskCompletionSource<Void> taskCompletionSource, SparseArray<Map<zzrd.zzb<?>, zzri>> sparseArray) {
            super(i, 3, taskCompletionSource, sparseArray);
            this.f1962wj = zzri.f2178wj;
            this.f1963wk = zzri.f2179wk;
        }

        public /* bridge */ /* synthetic */ boolean cancel() {
            return super.cancel();
        }

        public /* bridge */ /* synthetic */ void zza(SparseArray sparseArray) {
            super.zza((SparseArray<zzrq>) sparseArray);
        }

        public void zza(Api.zzb zzb) throws DeadObjectException {
            this.f1962wj.zza(zzb, this.f1960wh);
            Map map = (Map) this.f1959wg.get(this.f1958wf);
            if (map == null) {
                map = new ArrayMap(1);
                this.f1959wg.put(this.f1958wf, map);
            }
            String valueOf = String.valueOf(this.f1962wj.zzasr());
            Log.d("reg", new StringBuilder(String.valueOf(valueOf).length() + 12).append("registered: ").append(valueOf).toString());
            if (this.f1962wj.zzasr() != null) {
                map.put(this.f1962wj.zzasr(), new zzri(this.f1962wj, this.f1963wk));
            }
        }

        public /* bridge */ /* synthetic */ void zzx(@NonNull Status status) {
            super.zzx(status);
        }
    }

    public static final class zzd<TResult> extends zzpy {

        /* renamed from: wm */
        private static final Status f1964wm = new Status(8, "Connection to Google Play services was lost while executing the API call.");

        /* renamed from: wh */
        private final TaskCompletionSource<TResult> f1965wh;

        /* renamed from: wl */
        private final zzro<Api.zzb, TResult> f1966wl;

        public zzd(int i, int i2, zzro<Api.zzb, TResult> zzro, TaskCompletionSource<TResult> taskCompletionSource) {
            super(i, i2);
            this.f1965wh = taskCompletionSource;
            this.f1966wl = zzro;
        }

        public void zzb(Api.zzb zzb) throws DeadObjectException {
            try {
                this.f1966wl.zzb(zzb, this.f1965wh);
            } catch (DeadObjectException e) {
                zzx(f1964wm);
                throw e;
            } catch (RemoteException e2) {
                zzx(f1964wm);
            }
        }

        public void zzx(@NonNull Status status) {
            if (status.getStatusCode() == 8) {
                this.f1965wh.setException(new FirebaseException(status.getStatusMessage()));
            } else {
                this.f1965wh.setException(new FirebaseApiNotAvailableException(status.getStatusMessage()));
            }
        }
    }

    public static final class zze extends zza {

        /* renamed from: wn */
        public final zzrr<Api.zzb> f1967wn;

        public zze(int i, zzrr<Api.zzb> zzrr, TaskCompletionSource<Void> taskCompletionSource, SparseArray<Map<zzrd.zzb<?>, zzri>> sparseArray) {
            super(i, 4, taskCompletionSource, sparseArray);
            this.f1967wn = zzrr;
        }

        public /* bridge */ /* synthetic */ boolean cancel() {
            return super.cancel();
        }

        public /* bridge */ /* synthetic */ void zza(SparseArray sparseArray) {
            super.zza((SparseArray<zzrq>) sparseArray);
        }

        public void zza(Api.zzb zzb) throws DeadObjectException {
            Map map = (Map) this.f1959wg.get(this.f1958wf);
            if (map == null || this.f1967wn.zzasr() == null) {
                Log.wtf("UnregisterListenerTask", "Received call to unregister a listener without a matching registration call.", new Exception());
                this.f1960wh.setException(new com.google.android.gms.common.api.zza(Status.f1542wa));
                return;
            }
            map.remove(this.f1967wn.zzasr());
            this.f1967wn.zzc(zzb, this.f1960wh);
        }

        public /* bridge */ /* synthetic */ void zzx(@NonNull Status status) {
            super.zzx(status);
        }
    }

    public zzpy(int i, int i2) {
        this.f1958wf = i;
        this.f1957lN = i2;
    }

    public boolean cancel() {
        return true;
    }

    public void zza(SparseArray<zzrq> sparseArray) {
    }

    public abstract void zzb(Api.zzb zzb2) throws DeadObjectException;

    public abstract void zzx(@NonNull Status status);
}
