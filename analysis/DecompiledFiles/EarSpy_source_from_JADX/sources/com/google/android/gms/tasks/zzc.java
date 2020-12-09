package com.google.android.gms.tasks;

import android.support.annotation.NonNull;
import java.util.concurrent.Executor;

class zzc<TResult> implements zzf<TResult> {
    private final Executor aBG;
    /* access modifiers changed from: private */
    public OnCompleteListener<TResult> aJz;
    /* access modifiers changed from: private */
    public final Object zzakd = new Object();

    public zzc(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.aBG = executor;
        this.aJz = onCompleteListener;
    }

    public void cancel() {
        synchronized (this.zzakd) {
            this.aJz = null;
        }
    }

    public void onComplete(@NonNull final Task<TResult> task) {
        synchronized (this.zzakd) {
            if (this.aJz != null) {
                this.aBG.execute(new Runnable() {
                    public void run() {
                        synchronized (zzc.this.zzakd) {
                            if (zzc.this.aJz != null) {
                                zzc.this.aJz.onComplete(task);
                            }
                        }
                    }
                });
            }
        }
    }
}
