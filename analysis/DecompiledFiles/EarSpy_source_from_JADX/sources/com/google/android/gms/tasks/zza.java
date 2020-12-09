package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zza<TResult, TContinuationResult> implements zzf<TResult> {
    private final Executor aBG;
    /* access modifiers changed from: private */
    public final Continuation<TResult, TContinuationResult> aJu;
    /* access modifiers changed from: private */
    public final zzh<TContinuationResult> aJv;

    public zza(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation, @NonNull zzh<TContinuationResult> zzh) {
        this.aBG = executor;
        this.aJu = continuation;
        this.aJv = zzh;
    }

    public void cancel() {
        throw new UnsupportedOperationException();
    }

    public void onComplete(@NonNull final Task<TResult> task) {
        this.aBG.execute(new Runnable() {
            public void run() {
                try {
                    zza.this.aJv.setResult(zza.this.aJu.then(task));
                } catch (RuntimeExecutionException e) {
                    if (e.getCause() instanceof Exception) {
                        zza.this.aJv.setException((Exception) e.getCause());
                    } else {
                        zza.this.aJv.setException(e);
                    }
                } catch (Exception e2) {
                    zza.this.aJv.setException(e2);
                }
            }
        });
    }
}
