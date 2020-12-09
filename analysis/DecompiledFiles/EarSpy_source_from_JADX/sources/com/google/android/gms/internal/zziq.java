package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.formats.zzi;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zzke;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zziy
public class zziq extends zzkm {
    private final Object zzakd;
    /* access modifiers changed from: private */
    public final zzil.zza zzccj;
    private final zzke.zza zzcck;
    private final AdResponseParcel zzccl;
    private final zzis zzcdl;
    private Future<zzke> zzcdm;

    public zziq(Context context, zzq zzq, zzke.zza zza, zzau zzau, zzil.zza zza2, zzdq zzdq) {
        this(zza, zza2, new zzis(context, zzq, new zzky(context), zzau, zza, zzdq));
    }

    zziq(zzke.zza zza, zzil.zza zza2, zzis zzis) {
        this.zzakd = new Object();
        this.zzcck = zza;
        this.zzccl = zza.zzcop;
        this.zzccj = zza2;
        this.zzcdl = zzis;
    }

    private zzke zzan(int i) {
        return new zzke(this.zzcck.zzcix.zzcfu, (zzlt) null, (List<String>) null, i, (List<String>) null, (List<String>) null, this.zzccl.orientation, this.zzccl.zzbsj, this.zzcck.zzcix.zzcfx, false, (zzgg) null, (zzgr) null, (String) null, (zzgh) null, (zzgj) null, this.zzccl.zzchd, this.zzcck.zzaqz, this.zzccl.zzchb, this.zzcck.zzcoj, this.zzccl.zzchg, this.zzccl.zzchh, this.zzcck.zzcod, (zzi.zza) null, (RewardItemParcel) null, (List<String>) null, (List<String>) null, this.zzcck.zzcop.zzchu, this.zzcck.zzcop.zzchv, (String) null, (List<String>) null, this.zzccl.zzchy);
    }

    public void onStop() {
        synchronized (this.zzakd) {
            if (this.zzcdm != null) {
                this.zzcdm.cancel(true);
            }
        }
    }

    public void zzfc() {
        final zzke zzke;
        int i;
        try {
            synchronized (this.zzakd) {
                this.zzcdm = zzkq.zza(this.zzcdl);
            }
            zzke = this.zzcdm.get(60000, TimeUnit.MILLISECONDS);
            i = -2;
        } catch (TimeoutException e) {
            zzkn.zzdf("Timed out waiting for native ad.");
            this.zzcdm.cancel(true);
            i = 2;
            zzke = null;
        } catch (ExecutionException e2) {
            zzke = null;
            i = 0;
        } catch (InterruptedException e3) {
            zzke = null;
            i = 0;
        } catch (CancellationException e4) {
            zzke = null;
            i = 0;
        }
        if (zzke == null) {
            zzke = zzan(i);
        }
        zzkr.zzcrf.post(new Runnable() {
            public void run() {
                zziq.this.zzccj.zzb(zzke);
            }
        });
    }
}
