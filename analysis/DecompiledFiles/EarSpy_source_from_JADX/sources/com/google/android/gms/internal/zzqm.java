package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzai;
import com.google.android.gms.internal.zzqc;
import com.google.android.gms.internal.zzqr;

public class zzqm implements zzqq {
    /* access modifiers changed from: private */

    /* renamed from: xk */
    public final zzqr f2026xk;

    /* renamed from: xl */
    private boolean f2027xl = false;

    public zzqm(zzqr zzqr) {
        this.f2026xk = zzqr;
    }

    private <A extends Api.zzb> void zzf(zzqc.zza<? extends Result, A> zza) throws DeadObjectException {
        this.f2026xk.f2104wV.f2089yc.zzb((zzqe<? extends Result>) zza);
        A zzb = this.f2026xk.f2104wV.zzb((Api.zzc<?>) zza.zzapp());
        if (zzb.isConnected() || !this.f2026xk.f2112yl.containsKey(zza.zzapp())) {
            if (zzb instanceof zzai) {
                zzb = ((zzai) zzb).zzavk();
            }
            zza.zzb(zzb);
            return;
        }
        zza.zzz(new Status(17));
    }

    public void begin() {
    }

    public void connect() {
        if (this.f2027xl) {
            this.f2027xl = false;
            this.f2026xk.zza((zzqr.zza) new zzqr.zza(this) {
                public void zzari() {
                    zzqm.this.f2026xk.f2116yp.zzn((Bundle) null);
                }
            });
        }
    }

    public boolean disconnect() {
        if (this.f2027xl) {
            return false;
        }
        if (this.f2026xk.f2104wV.zzaru()) {
            this.f2027xl = true;
            for (zzrp zzasu : this.f2026xk.f2104wV.f2088yb) {
                zzasu.zzasu();
            }
            return false;
        }
        this.f2026xk.zzi((ConnectionResult) null);
        return true;
    }

    public void onConnected(Bundle bundle) {
    }

    public void onConnectionSuspended(int i) {
        this.f2026xk.zzi((ConnectionResult) null);
        this.f2026xk.f2116yp.zzc(i, this.f2027xl);
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    /* access modifiers changed from: package-private */
    public void zzarh() {
        if (this.f2027xl) {
            this.f2027xl = false;
            this.f2026xk.f2104wV.f2089yc.release();
            disconnect();
        }
    }

    public <A extends Api.zzb, R extends Result, T extends zzqc.zza<R, A>> T zzc(T t) {
        return zzd(t);
    }

    public <A extends Api.zzb, T extends zzqc.zza<? extends Result, A>> T zzd(T t) {
        try {
            zzf(t);
        } catch (DeadObjectException e) {
            this.f2026xk.zza((zzqr.zza) new zzqr.zza(this) {
                public void zzari() {
                    zzqm.this.onConnectionSuspended(1);
                }
            });
        }
        return t;
    }
}
