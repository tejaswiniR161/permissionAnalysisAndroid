package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zzf;
import com.google.android.gms.internal.zzqc;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class zzrq {

    /* renamed from: zt */
    private static final zzqe<?>[] f2199zt = new zzqe[0];

    /* renamed from: vC */
    private final Api.zze f2200vC;

    /* renamed from: xW */
    private final Map<Api.zzc<?>, Api.zze> f2201xW;

    /* renamed from: zu */
    final Set<zzqe<?>> f2202zu;

    /* renamed from: zv */
    private final zzb f2203zv;
    /* access modifiers changed from: private */

    /* renamed from: zw */
    public zzc f2204zw;

    private static class zza implements IBinder.DeathRecipient, zzb {

        /* renamed from: zA */
        private final WeakReference<IBinder> f2206zA;

        /* renamed from: zy */
        private final WeakReference<zzqe<?>> f2207zy;

        /* renamed from: zz */
        private final WeakReference<zzf> f2208zz;

        private zza(zzqe<?> zzqe, zzf zzf, IBinder iBinder) {
            this.f2208zz = new WeakReference<>(zzf);
            this.f2207zy = new WeakReference<>(zzqe);
            this.f2206zA = new WeakReference<>(iBinder);
        }

        private void zzasd() {
            zzqe zzqe = (zzqe) this.f2207zy.get();
            zzf zzf = (zzf) this.f2208zz.get();
            if (!(zzf == null || zzqe == null)) {
                zzf.remove(zzqe.zzaqf().intValue());
            }
            IBinder iBinder = (IBinder) this.f2206zA.get();
            if (iBinder != null) {
                iBinder.unlinkToDeath(this, 0);
            }
        }

        public void binderDied() {
            zzasd();
        }

        public void zzc(zzqe<?> zzqe) {
            zzasd();
        }
    }

    interface zzb {
        void zzc(zzqe<?> zzqe);
    }

    interface zzc {
        void zzask();
    }

    public zzrq(Api.zze zze) {
        this.f2202zu = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
        this.f2203zv = new zzb() {
            public void zzc(zzqe<?> zzqe) {
                zzrq.this.f2202zu.remove(zzqe);
                if (!(zzqe.zzaqf() == null || zzrq.zza(zzrq.this) == null)) {
                    zzrq.zza(zzrq.this).remove(zzqe.zzaqf().intValue());
                }
                if (zzrq.this.f2204zw != null && zzrq.this.f2202zu.isEmpty()) {
                    zzrq.this.f2204zw.zzask();
                }
            }
        };
        this.f2204zw = null;
        this.f2201xW = null;
        this.f2200vC = zze;
    }

    public zzrq(Map<Api.zzc<?>, Api.zze> map) {
        this.f2202zu = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
        this.f2203zv = new zzb() {
            public void zzc(zzqe<?> zzqe) {
                zzrq.this.f2202zu.remove(zzqe);
                if (!(zzqe.zzaqf() == null || zzrq.zza(zzrq.this) == null)) {
                    zzrq.zza(zzrq.this).remove(zzqe.zzaqf().intValue());
                }
                if (zzrq.this.f2204zw != null && zzrq.this.f2202zu.isEmpty()) {
                    zzrq.this.f2204zw.zzask();
                }
            }
        };
        this.f2204zw = null;
        this.f2201xW = map;
        this.f2200vC = null;
    }

    static /* synthetic */ zzf zza(zzrq zzrq) {
        return null;
    }

    private static void zza(zzqe<?> zzqe, zzf zzf, IBinder iBinder) {
        if (zzqe.isReady()) {
            zzqe.zza((zzb) new zza(zzqe, zzf, iBinder));
        } else if (iBinder == null || !iBinder.isBinderAlive()) {
            zzqe.zza((zzb) null);
            zzqe.cancel();
            zzf.remove(zzqe.zzaqf().intValue());
        } else {
            zza zza2 = new zza(zzqe, zzf, iBinder);
            zzqe.zza((zzb) zza2);
            try {
                iBinder.linkToDeath(zza2, 0);
            } catch (RemoteException e) {
                zzqe.cancel();
                zzf.remove(zzqe.zzaqf().intValue());
            }
        }
    }

    public void dump(PrintWriter printWriter) {
        printWriter.append(" mUnconsumedApiCalls.size()=").println(this.f2202zu.size());
    }

    public void release() {
        IBinder iBinder;
        for (zzqe zzqe : (zzqe[]) this.f2202zu.toArray(f2199zt)) {
            zzqe.zza((zzb) null);
            if (zzqe.zzaqf() != null) {
                zzqe.zzaqs();
                if (this.f2200vC != null) {
                    iBinder = this.f2200vC.zzaps();
                } else if (this.f2201xW != null) {
                    iBinder = this.f2201xW.get(((zzqc.zza) zzqe).zzapp()).zzaps();
                } else {
                    Log.wtf("UnconsumedApiCalls", "Could not get service broker binder", new Exception());
                    iBinder = null;
                }
                zza(zzqe, (zzf) null, iBinder);
                this.f2202zu.remove(zzqe);
            } else if (zzqe.zzaqq()) {
                this.f2202zu.remove(zzqe);
            }
        }
    }

    public void zza(zzc zzc2) {
        if (this.f2202zu.isEmpty()) {
            zzc2.zzask();
        }
        this.f2204zw = zzc2;
    }

    public void zzasw() {
        for (zzqe zzaa : (zzqe[]) this.f2202zu.toArray(f2199zt)) {
            zzaa.zzaa(new Status(8, "The connection to Google Play services was lost"));
        }
    }

    public boolean zzasx() {
        for (zzqe isReady : (zzqe[]) this.f2202zu.toArray(f2199zt)) {
            if (!isReady.isReady()) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void zzb(zzqe<? extends Result> zzqe) {
        this.f2202zu.add(zzqe);
        zzqe.zza(this.f2203zv);
    }
}
