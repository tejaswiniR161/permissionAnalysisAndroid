package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zzb<TResult, TContinuationResult> implements OnFailureListener, OnSuccessListener<TContinuationResult>, zzf<TResult> {
    private final Executor aBG;
    /* access modifiers changed from: private */
    public final Continuation<TResult, Task<TContinuationResult>> aJu;
    /* access modifiers changed from: private */
    public final zzh<TContinuationResult> aJv;

    public zzb(@NonNull Executor executor, @NonNull Continuation<TResult, Task<TContinuationResult>> continuation, @NonNull zzh<TContinuationResult> zzh) {
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
                    Task task = (Task) zzb.this.aJu.then(task);
                    if (task == null) {
                        zzb.this.onFailure(new NullPointerException("Continuation returned null"));
                        return;
                    }
                    task.addOnSuccessListener(TaskExecutors.aJI, zzb.this);
                    task.addOnFailureListener(TaskExecutors.aJI, (OnFailureListener) zzb.this);
                } catch (RuntimeExecutionException e) {
                    if (e.getCause() instanceof Exception) {
                        zzb.this.aJv.setException((Exception) e.getCause());
                    } else {
                        zzb.this.aJv.setException(e);
                    }
                } catch (Exception e2) {
                    zzb.this.aJv.setException(e2);
                }
            }
        });
    }

    public void onFailure(@NonNull Exception exc) {
        this.aJv.setException(exc);
    }

    public void onSuccess(TContinuationResult tcontinuationresult) {
        this.aJv.setResult(tcontinuationresult);
    }
}
