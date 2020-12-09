package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzlu;

@zziy
public class zzim extends zzih implements zzlu.zza {
    zzim(Context context, zzke.zza zza, zzlt zzlt, zzil.zza zza2) {
        super(context, zza, zzlt, zza2);
    }

    /* access modifiers changed from: protected */
    public void zzqu() {
        if (this.zzccl.errorCode == -2) {
            this.zzbkr.zzvr().zza((zzlu.zza) this);
            zzrb();
            zzkn.zzdd("Loading HTML in WebView.");
            this.zzbkr.loadDataWithBaseURL(zzu.zzfz().zzcv(this.zzccl.zzbyj), this.zzccl.body, "text/html", "UTF-8", (String) null);
        }
    }

    /* access modifiers changed from: protected */
    public void zzrb() {
    }
}
