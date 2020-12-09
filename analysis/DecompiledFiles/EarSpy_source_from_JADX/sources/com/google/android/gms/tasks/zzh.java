package com.google.android.gms.tasks;

import android.app.Activity;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzra;
import com.google.android.gms.internal.zzrb;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

final class zzh<TResult> extends Task<TResult> {
    private final zzg<TResult> aJJ = new zzg<>();
    private boolean aJK;
    private TResult aJL;
    private Exception aJM;
    private final Object zzakd = new Object();

    private static class zza extends zzra {
        private final List<WeakReference<zzf<?>>> mListeners = new ArrayList();

        private zza(zzrb zzrb) {
            super(zzrb);
            this.f2165yY.zza("TaskOnStopCallback", (zzra) this);
        }

        public static zza zzv(Activity activity) {
            zzrb zzs = zzs(activity);
            zza zza = (zza) zzs.zza("TaskOnStopCallback", zza.class);
            return zza == null ? new zza(zzs) : zza;
        }

        @MainThread
        public void onStop() {
            synchronized (this.mListeners) {
                for (WeakReference<zzf<?>> weakReference : this.mListeners) {
                    zzf zzf = (zzf) weakReference.get();
                    if (zzf != null) {
                        zzf.cancel();
                    }
                }
                this.mListeners.clear();
            }
        }

        public <T> void zzb(zzf<T> zzf) {
            synchronized (this.mListeners) {
                this.mListeners.add(new WeakReference(zzf));
            }
        }
    }

    zzh() {
    }

    private void zzclh() {
        zzac.zza(this.aJK, (Object) "Task is not yet complete");
    }

    private void zzcli() {
        zzac.zza(!this.aJK, (Object) "Task is already complete");
    }

    private void zzclj() {
        synchronized (this.zzakd) {
            if (this.aJK) {
                this.aJJ.zza(this);
            }
        }
    }

    @NonNull
    public Task<TResult> addOnCompleteListener(@NonNull Activity activity, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        zzc zzc = new zzc(TaskExecutors.MAIN_THREAD, onCompleteListener);
        this.aJJ.zza(zzc);
        zza.zzv(activity).zzb(zzc);
        zzclj();
        return this;
    }

    @NonNull
    public Task<TResult> addOnCompleteListener(@NonNull OnCompleteListener<TResult> onCompleteListener) {
        return addOnCompleteListener(TaskExecutors.MAIN_THREAD, onCompleteListener);
    }

    @NonNull
    public Task<TResult> addOnCompleteListener(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.aJJ.zza(new zzc(executor, onCompleteListener));
        zzclj();
        return this;
    }

    @NonNull
    public Task<TResult> addOnFailureListener(@NonNull Activity activity, @NonNull OnFailureListener onFailureListener) {
        zzd zzd = new zzd(TaskExecutors.MAIN_THREAD, onFailureListener);
        this.aJJ.zza(zzd);
        zza.zzv(activity).zzb(zzd);
        zzclj();
        return this;
    }

    @NonNull
    public Task<TResult> addOnFailureListener(@NonNull OnFailureListener onFailureListener) {
        return addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
    }

    @NonNull
    public Task<TResult> addOnFailureListener(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.aJJ.zza(new zzd(executor, onFailureListener));
        zzclj();
        return this;
    }

    @NonNull
    public Task<TResult> addOnSuccessListener(@NonNull Activity activity, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        zze zze = new zze(TaskExecutors.MAIN_THREAD, onSuccessListener);
        this.aJJ.zza(zze);
        zza.zzv(activity).zzb(zze);
        zzclj();
        return this;
    }

    @NonNull
    public Task<TResult> addOnSuccessListener(@NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        return addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
    }

    @NonNull
    public Task<TResult> addOnSuccessListener(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.aJJ.zza(new zze(executor, onSuccessListener));
        zzclj();
        return this;
    }

    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(TaskExecutors.MAIN_THREAD, continuation);
    }

    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation) {
        zzh zzh = new zzh();
        this.aJJ.zza(new zza(executor, continuation, zzh));
        zzclj();
        return zzh;
    }

    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        return continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
    }

    @NonNull
    public <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Executor executor, @NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        zzh zzh = new zzh();
        this.aJJ.zza(new zzb(executor, continuation, zzh));
        zzclj();
        return zzh;
    }

    @Nullable
    public Exception getException() {
        Exception exc;
        synchronized (this.zzakd) {
            exc = this.aJM;
        }
        return exc;
    }

    public TResult getResult() {
        TResult tresult;
        synchronized (this.zzakd) {
            zzclh();
            if (this.aJM != null) {
                throw new RuntimeExecutionException(this.aJM);
            }
            tresult = this.aJL;
        }
        return tresult;
    }

    public <X extends Throwable> TResult getResult(@NonNull Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.zzakd) {
            zzclh();
            if (cls.isInstance(this.aJM)) {
                throw ((Throwable) cls.cast(this.aJM));
            } else if (this.aJM != null) {
                throw new RuntimeExecutionException(this.aJM);
            } else {
                tresult = this.aJL;
            }
        }
        return tresult;
    }

    public boolean isComplete() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.aJK;
        }
        return z;
    }

    public boolean isSuccessful() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.aJK && this.aJM == null;
        }
        return z;
    }

    public void setException(@NonNull Exception exc) {
        zzac.zzb(exc, (Object) "Exception must not be null");
        synchronized (this.zzakd) {
            zzcli();
            this.aJK = true;
            this.aJM = exc;
        }
        this.aJJ.zza(this);
    }

    public void setResult(TResult tresult) {
        synchronized (this.zzakd) {
            zzcli();
            this.aJK = true;
            this.aJL = tresult;
        }
        this.aJJ.zza(this);
    }
}
