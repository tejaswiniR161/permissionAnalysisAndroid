package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzac;
import java.lang.ref.WeakReference;

public class zzrp<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    /* access modifiers changed from: private */

    /* renamed from: wG */
    public final Object f2187wG = new Object();
    /* access modifiers changed from: private */

    /* renamed from: wI */
    public final WeakReference<GoogleApiClient> f2188wI;
    /* access modifiers changed from: private */

    /* renamed from: zk */
    public ResultTransform<? super R, ? extends Result> f2189zk = null;
    /* access modifiers changed from: private */

    /* renamed from: zl */
    public zzrp<? extends Result> f2190zl = null;

    /* renamed from: zm */
    private volatile ResultCallbacks<? super R> f2191zm = null;

    /* renamed from: zn */
    private PendingResult<R> f2192zn = null;

    /* renamed from: zo */
    private Status f2193zo = null;
    /* access modifiers changed from: private */

    /* renamed from: zp */
    public final zza f2194zp;

    /* renamed from: zq */
    private boolean f2195zq = false;

    private final class zza extends Handler {
        public zza(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    PendingResult pendingResult = (PendingResult) message.obj;
                    synchronized (zzrp.this.f2187wG) {
                        if (pendingResult == null) {
                            zzrp.this.f2190zl.zzac(new Status(13, "Transform returned null"));
                        } else if (pendingResult instanceof zzrk) {
                            zzrp.this.f2190zl.zzac(((zzrk) pendingResult).getStatus());
                        } else {
                            zzrp.this.f2190zl.zza(pendingResult);
                        }
                    }
                    return;
                case 1:
                    RuntimeException runtimeException = (RuntimeException) message.obj;
                    String valueOf = String.valueOf(runtimeException.getMessage());
                    Log.e("TransformedResultImpl", valueOf.length() != 0 ? "Runtime exception on the transformation worker thread: ".concat(valueOf) : new String("Runtime exception on the transformation worker thread: "));
                    throw runtimeException;
                default:
                    Log.e("TransformedResultImpl", new StringBuilder(70).append("TransformationResultHandler received unknown message type: ").append(message.what).toString());
                    return;
            }
        }
    }

    public zzrp(WeakReference<GoogleApiClient> weakReference) {
        zzac.zzb(weakReference, (Object) "GoogleApiClient reference must not be null");
        this.f2188wI = weakReference;
        GoogleApiClient googleApiClient = (GoogleApiClient) this.f2188wI.get();
        this.f2194zp = new zza(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
    }

    /* access modifiers changed from: private */
    public void zzac(Status status) {
        synchronized (this.f2187wG) {
            this.f2193zo = status;
            zzad(this.f2193zo);
        }
    }

    private void zzad(Status status) {
        synchronized (this.f2187wG) {
            if (this.f2189zk != null) {
                Status onFailure = this.f2189zk.onFailure(status);
                zzac.zzb(onFailure, (Object) "onFailure must not return null");
                this.f2190zl.zzac(onFailure);
            } else if (zzasv()) {
                this.f2191zm.onFailure(status);
            }
        }
    }

    private void zzast() {
        if (this.f2189zk != null || this.f2191zm != null) {
            GoogleApiClient googleApiClient = (GoogleApiClient) this.f2188wI.get();
            if (!(this.f2195zq || this.f2189zk == null || googleApiClient == null)) {
                googleApiClient.zza(this);
                this.f2195zq = true;
            }
            if (this.f2193zo != null) {
                zzad(this.f2193zo);
            } else if (this.f2192zn != null) {
                this.f2192zn.setResultCallback(this);
            }
        }
    }

    private boolean zzasv() {
        return (this.f2191zm == null || ((GoogleApiClient) this.f2188wI.get()) == null) ? false : true;
    }

    /* access modifiers changed from: private */
    public void zze(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(result);
                Log.w("TransformedResultImpl", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    public void andFinally(@NonNull ResultCallbacks<? super R> resultCallbacks) {
        boolean z = true;
        synchronized (this.f2187wG) {
            zzac.zza(this.f2191zm == null, (Object) "Cannot call andFinally() twice.");
            if (this.f2189zk != null) {
                z = false;
            }
            zzac.zza(z, (Object) "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f2191zm = resultCallbacks;
            zzast();
        }
    }

    public void onResult(final R r) {
        synchronized (this.f2187wG) {
            if (!r.getStatus().isSuccess()) {
                zzac(r.getStatus());
                zze((Result) r);
            } else if (this.f2189zk != null) {
                zzrj.zzarz().submit(new Runnable() {
                    @WorkerThread
                    public void run() {
                        try {
                            zzqe.f1989wF.set(true);
                            zzrp.this.f2194zp.sendMessage(zzrp.this.f2194zp.obtainMessage(0, zzrp.this.f2189zk.onSuccess(r)));
                            zzqe.f1989wF.set(false);
                            zzrp.this.zze(r);
                            GoogleApiClient googleApiClient = (GoogleApiClient) zzrp.this.f2188wI.get();
                            if (googleApiClient != null) {
                                googleApiClient.zzb(zzrp.this);
                            }
                        } catch (RuntimeException e) {
                            zzrp.this.f2194zp.sendMessage(zzrp.this.f2194zp.obtainMessage(1, e));
                            zzqe.f1989wF.set(false);
                            zzrp.this.zze(r);
                            GoogleApiClient googleApiClient2 = (GoogleApiClient) zzrp.this.f2188wI.get();
                            if (googleApiClient2 != null) {
                                googleApiClient2.zzb(zzrp.this);
                            }
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            zzqe.f1989wF.set(false);
                            zzrp.this.zze(r);
                            GoogleApiClient googleApiClient3 = (GoogleApiClient) zzrp.this.f2188wI.get();
                            if (googleApiClient3 != null) {
                                googleApiClient3.zzb(zzrp.this);
                            }
                            throw th2;
                        }
                    }
                });
            } else if (zzasv()) {
                this.f2191zm.onSuccess(r);
            }
        }
    }

    @NonNull
    public <S extends Result> TransformedResult<S> then(@NonNull ResultTransform<? super R, ? extends S> resultTransform) {
        zzrp<? extends Result> zzrp;
        boolean z = true;
        synchronized (this.f2187wG) {
            zzac.zza(this.f2189zk == null, (Object) "Cannot call then() twice.");
            if (this.f2191zm != null) {
                z = false;
            }
            zzac.zza(z, (Object) "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f2189zk = resultTransform;
            zzrp = new zzrp<>(this.f2188wI);
            this.f2190zl = zzrp;
            zzast();
        }
        return zzrp;
    }

    public void zza(PendingResult<?> pendingResult) {
        synchronized (this.f2187wG) {
            this.f2192zn = pendingResult;
            zzast();
        }
    }

    /* access modifiers changed from: package-private */
    public void zzasu() {
        this.f2191zm = null;
    }
}
