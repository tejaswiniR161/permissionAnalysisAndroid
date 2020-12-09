package com.google.android.gms.internal;

import android.os.DeadObjectException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.internal.zzrd;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class zzrr<A extends Api.zzb> {
    public zzrd.zzb<?> zzasr() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract void zzc(A a, TaskCompletionSource<Void> taskCompletionSource) throws DeadObjectException;
}
