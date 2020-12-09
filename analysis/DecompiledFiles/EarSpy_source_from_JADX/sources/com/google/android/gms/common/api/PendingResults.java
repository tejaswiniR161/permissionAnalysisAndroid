package com.google.android.gms.common.api;

import android.os.Looper;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzqe;
import com.google.android.gms.internal.zzrg;
import com.google.android.gms.internal.zzrm;

public final class PendingResults {

    private static final class zza<R extends Result> extends zzqe<R> {

        /* renamed from: vT */
        private final R f1536vT;

        public zza(R r) {
            super(Looper.getMainLooper());
            this.f1536vT = r;
        }

        /* access modifiers changed from: protected */
        public R zzc(Status status) {
            if (status.getStatusCode() == this.f1536vT.getStatus().getStatusCode()) {
                return this.f1536vT;
            }
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private static final class zzb<R extends Result> extends zzqe<R> {

        /* renamed from: vU */
        private final R f1537vU;

        public zzb(GoogleApiClient googleApiClient, R r) {
            super(googleApiClient);
            this.f1537vU = r;
        }

        /* access modifiers changed from: protected */
        public R zzc(Status status) {
            return this.f1537vU;
        }
    }

    private static final class zzc<R extends Result> extends zzqe<R> {
        public zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        /* access modifiers changed from: protected */
        public R zzc(Status status) {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    private PendingResults() {
    }

    public static PendingResult<Status> canceledPendingResult() {
        zzrm zzrm = new zzrm(Looper.getMainLooper());
        zzrm.cancel();
        return zzrm;
    }

    public static <R extends Result> PendingResult<R> canceledPendingResult(R r) {
        zzac.zzb(r, (Object) "Result must not be null");
        zzac.zzb(r.getStatus().getStatusCode() == 16, (Object) "Status code must be CommonStatusCodes.CANCELED");
        zza zza2 = new zza(r);
        zza2.cancel();
        return zza2;
    }

    public static <R extends Result> OptionalPendingResult<R> immediatePendingResult(R r) {
        zzac.zzb(r, (Object) "Result must not be null");
        zzc zzc2 = new zzc((GoogleApiClient) null);
        zzc2.zzc(r);
        return new zzrg(zzc2);
    }

    public static PendingResult<Status> immediatePendingResult(Status status) {
        zzac.zzb(status, (Object) "Result must not be null");
        zzrm zzrm = new zzrm(Looper.getMainLooper());
        zzrm.zzc(status);
        return zzrm;
    }

    public static <R extends Result> PendingResult<R> zza(R r, GoogleApiClient googleApiClient) {
        zzac.zzb(r, (Object) "Result must not be null");
        zzac.zzb(!r.getStatus().isSuccess(), (Object) "Status code must not be SUCCESS");
        zzb zzb2 = new zzb(googleApiClient, r);
        zzb2.zzc(r);
        return zzb2;
    }

    public static PendingResult<Status> zza(Status status, GoogleApiClient googleApiClient) {
        zzac.zzb(status, (Object) "Result must not be null");
        zzrm zzrm = new zzrm(googleApiClient);
        zzrm.zzc(status);
        return zzrm;
    }

    public static <R extends Result> OptionalPendingResult<R> zzb(R r, GoogleApiClient googleApiClient) {
        zzac.zzb(r, (Object) "Result must not be null");
        zzc zzc2 = new zzc(googleApiClient);
        zzc2.zzc(r);
        return new zzrg(zzc2);
    }
}
