package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzqc;
import com.google.android.gms.internal.zzsa;

public final class zzrz implements zzry {

    private static class zza extends zzrw {

        /* renamed from: Dj */
        private final zzqc.zzb<Status> f2236Dj;

        public zza(zzqc.zzb<Status> zzb) {
            this.f2236Dj = zzb;
        }

        public void zzgw(int i) throws RemoteException {
            this.f2236Dj.setResult(new Status(i));
        }
    }

    public PendingResult<Status> zzg(GoogleApiClient googleApiClient) {
        return googleApiClient.zzd(new zzsa.zza(googleApiClient) {
            /* access modifiers changed from: protected */
            public void zza(zzsb zzsb) throws RemoteException {
                ((zzsd) zzsb.zzatx()).zza(new zza(this));
            }
        });
    }
}
