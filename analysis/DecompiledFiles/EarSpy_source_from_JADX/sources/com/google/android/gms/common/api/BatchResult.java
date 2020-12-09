package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzac;
import java.util.concurrent.TimeUnit;

public final class BatchResult implements Result {

    /* renamed from: fp */
    private final Status f1514fp;

    /* renamed from: vr */
    private final PendingResult<?>[] f1515vr;

    BatchResult(Status status, PendingResult<?>[] pendingResultArr) {
        this.f1514fp = status;
        this.f1515vr = pendingResultArr;
    }

    public Status getStatus() {
        return this.f1514fp;
    }

    public <R extends Result> R take(BatchResultToken<R> batchResultToken) {
        zzac.zzb(batchResultToken.mId < this.f1515vr.length, (Object) "The result token does not belong to this batch");
        return this.f1515vr[batchResultToken.mId].await(0, TimeUnit.MILLISECONDS);
    }
}
