package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zze<TResult> implements zzf<TResult> {
    private final Executor aBG;
    /* access modifiers changed from: private */
    public OnSuccessListener<? super TResult> aJD;
    /* access modifiers changed from: private */
    public final Object zzakd = new Object();

    public zze(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.aBG = executor;
        this.aJD = onSuccessListener;
    }

    public void cancel() {
        synchronized (this.zzakd) {
            this.aJD = null;
        }
    }

    public void onComplete(@NonNull final Task<TResult> task) {
        if (task.isSuccessful()) {
            synchronized (this.zzakd) {
                if (this.aJD != null) {
                    this.aBG.execute(new Runnable() {
                        public void run() {
                            synchronized (zze.this.zzakd) {
                                if (zze.this.aJD != null) {
                                    zze.this.aJD.onSuccess(task.getResult());
                                }
                            }
                        }
                    });
                }
            }
        }
    }
}
