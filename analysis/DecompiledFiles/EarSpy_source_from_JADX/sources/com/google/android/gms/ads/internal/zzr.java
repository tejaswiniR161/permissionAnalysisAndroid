package com.google.android.gms.ads.internal;

import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzkr;
import java.lang.ref.WeakReference;

@zziy
public class zzr {
    private final zza zzaov;
    /* access modifiers changed from: private */
    @Nullable
    public AdRequestParcel zzaow;
    /* access modifiers changed from: private */
    public boolean zzaox;
    private boolean zzaoy;
    private long zzaoz;
    private final Runnable zzw;

    public static class zza {
        private final Handler mHandler;

        public zza(Handler handler) {
            this.mHandler = handler;
        }

        public boolean postDelayed(Runnable runnable, long j) {
            return this.mHandler.postDelayed(runnable, j);
        }

        public void removeCallbacks(Runnable runnable) {
            this.mHandler.removeCallbacks(runnable);
        }
    }

    public zzr(zza zza2) {
        this(zza2, new zza(zzkr.zzcrf));
    }

    zzr(zza zza2, zza zza3) {
        this.zzaox = false;
        this.zzaoy = false;
        this.zzaoz = 0;
        this.zzaov = zza3;
        final WeakReference weakReference = new WeakReference(zza2);
        this.zzw = new Runnable() {
            public void run() {
                boolean unused = zzr.this.zzaox = false;
                zza zza = (zza) weakReference.get();
                if (zza != null) {
                    zza.zzd(zzr.this.zzaow);
                }
            }
        };
    }

    public void cancel() {
        this.zzaox = false;
        this.zzaov.removeCallbacks(this.zzw);
    }

    public void pause() {
        this.zzaoy = true;
        if (this.zzaox) {
            this.zzaov.removeCallbacks(this.zzw);
        }
    }

    public void resume() {
        this.zzaoy = false;
        if (this.zzaox) {
            this.zzaox = false;
            zza(this.zzaow, this.zzaoz);
        }
    }

    public void zza(AdRequestParcel adRequestParcel, long j) {
        if (this.zzaox) {
            zzkn.zzdf("An ad refresh is already scheduled.");
            return;
        }
        this.zzaow = adRequestParcel;
        this.zzaox = true;
        this.zzaoz = j;
        if (!this.zzaoy) {
            zzkn.zzde(new StringBuilder(65).append("Scheduling ad refresh ").append(j).append(" milliseconds from now.").toString());
            this.zzaov.postDelayed(this.zzw, j);
        }
    }

    public boolean zzfl() {
        return this.zzaox;
    }

    public void zzg(AdRequestParcel adRequestParcel) {
        this.zzaow = adRequestParcel;
    }

    public void zzh(AdRequestParcel adRequestParcel) {
        zza(adRequestParcel, 60000);
    }
}
