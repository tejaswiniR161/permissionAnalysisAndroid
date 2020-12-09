package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.tasks.TaskCompletionSource;

public abstract class zzro<A extends Api.zzb, TResult> {
    /* access modifiers changed from: protected */
    public abstract void zzb(A a, TaskCompletionSource<TResult> taskCompletionSource) throws RemoteException;
}
