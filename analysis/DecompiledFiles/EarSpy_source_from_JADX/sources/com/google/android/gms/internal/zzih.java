package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.formats.zzi;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzlu;
import java.util.concurrent.atomic.AtomicBoolean;

@zziy
public abstract class zzih implements zzkt<Void>, zzlu.zza {
    protected final Context mContext;
    protected final zzlt zzbkr;
    protected final zzil.zza zzccj;
    protected final zzke.zza zzcck;
    protected AdResponseParcel zzccl;
    private Runnable zzccm;
    protected final Object zzccn = new Object();
    /* access modifiers changed from: private */
    public AtomicBoolean zzcco = new AtomicBoolean(true);

    protected zzih(Context context, zzke.zza zza, zzlt zzlt, zzil.zza zza2) {
        this.mContext = context;
        this.zzcck = zza;
        this.zzccl = this.zzcck.zzcop;
        this.zzbkr = zzlt;
        this.zzccj = zza2;
    }

    private zzke zzam(int i) {
        AdRequestInfoParcel adRequestInfoParcel = this.zzcck.zzcix;
        return new zzke(adRequestInfoParcel.zzcfu, this.zzbkr, this.zzccl.zzbsd, i, this.zzccl.zzbse, this.zzccl.zzche, this.zzccl.orientation, this.zzccl.zzbsj, adRequestInfoParcel.zzcfx, this.zzccl.zzchc, (zzgg) null, (zzgr) null, (String) null, (zzgh) null, (zzgj) null, this.zzccl.zzchd, this.zzcck.zzaqz, this.zzccl.zzchb, this.zzcck.zzcoj, this.zzccl.zzchg, this.zzccl.zzchh, this.zzcck.zzcod, (zzi.zza) null, this.zzccl.zzchr, this.zzccl.zzchs, this.zzccl.zzcht, this.zzccl.zzchu, this.zzccl.zzchv, (String) null, this.zzccl.zzbsg, this.zzccl.zzchy);
    }

    public void cancel() {
        if (this.zzcco.getAndSet(false)) {
            this.zzbkr.stopLoading();
            zzu.zzgb().zzl(this.zzbkr);
            zzal(-1);
            zzkr.zzcrf.removeCallbacks(this.zzccm);
        }
    }

    public void zza(zzlt zzlt, boolean z) {
        int i = 0;
        zzkn.zzdd("WebView finished loading.");
        if (this.zzcco.getAndSet(false)) {
            if (z) {
                i = zzqv();
            }
            zzal(i);
            zzkr.zzcrf.removeCallbacks(this.zzccm);
        }
    }

    /* access modifiers changed from: protected */
    public void zzal(int i) {
        if (i != -2) {
            this.zzccl = new AdResponseParcel(i, this.zzccl.zzbsj);
        }
        this.zzbkr.zzvm();
        this.zzccj.zzb(zzam(i));
    }

    /* renamed from: zzqt */
    public final Void zzqw() {
        zzac.zzhq("Webview render task needs to be called on UI thread.");
        this.zzccm = new Runnable() {
            public void run() {
                if (zzih.this.zzcco.get()) {
                    zzkn.m1352e("Timed out waiting for WebView to finish loading.");
                    zzih.this.cancel();
                }
            }
        };
        zzkr.zzcrf.postDelayed(this.zzccm, zzdi.zzbel.get().longValue());
        zzqu();
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract void zzqu();

    /* access modifiers changed from: protected */
    public int zzqv() {
        return -2;
    }
}
