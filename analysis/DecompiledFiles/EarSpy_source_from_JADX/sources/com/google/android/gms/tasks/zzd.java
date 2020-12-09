package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zzd<TResult> implements zzf<TResult> {
    private final Executor aBG;
    /* access modifiers changed from: private */
    public OnFailureListener aJB;
    /* access modifiers changed from: private */
    public final Object zzakd = new Object();

    public zzd(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.aBG = executor;
        this.aJB = onFailureListener;
    }

    public void cancel() {
        synchronized (this.zzakd) {
            this.aJB = null;
        }
    }

    public void onComplete(@NonNull final Task<TResult> task) {
        if (!task.isSuccessful()) {
            synchronized (this.zzakd) {
                if (this.aJB != null) {
                    this.aBG.execute(new Runnable() {
                        public void run() {
                            synchronized (zzd.this.zzakd) {
                                if (zzd.this.aJB != null) {
                                    zzd.this.aJB.onFailure(task.getException());
                                }
                            }
                        }
                    });
                }
            }
        }
    }
}
