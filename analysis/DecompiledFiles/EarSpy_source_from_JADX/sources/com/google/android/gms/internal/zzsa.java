package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzqc;

abstract class zzsa<R extends Result> extends zzqc.zza<R, zzsb> {

    static abstract class zza extends zzsa<Status> {
        public zza(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* renamed from: zzb */
        public Status zzc(Status status) {
            return status;
        }
    }

    public zzsa(GoogleApiClient googleApiClient) {
        super((Api<?>) zzrx.API, googleApiClient);
    }
}
