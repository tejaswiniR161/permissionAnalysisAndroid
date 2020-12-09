package com.google.android.gms.internal;

import android.content.Context;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zzke;

@zziy
public abstract class zzik extends zzkm {
    protected final Context mContext;
    protected final Object zzakd = new Object();
    protected final zzil.zza zzccj;
    protected final zzke.zza zzcck;
    protected AdResponseParcel zzccl;
    protected final Object zzccn = new Object();

    protected static final class zza extends Exception {
        private final int zzcdb;

        public zza(String str, int i) {
            super(str);
            this.zzcdb = i;
        }

        public int getErrorCode() {
            return this.zzcdb;
        }
    }

    protected zzik(Context context, zzke.zza zza2, zzil.zza zza3) {
        super(true);
        this.mContext = context;
        this.zzcck = zza2;
        this.zzccl = zza2.zzcop;
        this.zzccj = zza3;
    }

    public void onStop() {
    }

    /* access modifiers changed from: protected */
    public abstract zzke zzam(int i);

    public void zzfc() {
        synchronized (this.zzakd) {
            zzkn.zzdd("AdRendererBackgroundTask started.");
            int i = this.zzcck.errorCode;
            try {
                zzh(SystemClock.elapsedRealtime());
            } catch (zza e) {
                int errorCode = e.getErrorCode();
                if (errorCode == 3 || errorCode == -1) {
                    zzkn.zzde(e.getMessage());
                } else {
                    zzkn.zzdf(e.getMessage());
                }
                if (this.zzccl == null) {
                    this.zzccl = new AdResponseParcel(errorCode);
                } else {
                    this.zzccl = new AdResponseParcel(errorCode, this.zzccl.zzbsj);
                }
                zzkr.zzcrf.post(new Runnable() {
                    public void run() {
                        zzik.this.onStop();
                    }
                });
                i = errorCode;
            }
            final zzke zzam = zzam(i);
            zzkr.zzcrf.post(new Runnable() {
                public void run() {
                    synchronized (zzik.this.zzakd) {
                        zzik.this.zzn(zzam);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zzh(long j) throws zza;

    /* access modifiers changed from: protected */
    public void zzn(zzke zzke) {
        this.zzccj.zzb(zzke);
    }
}
