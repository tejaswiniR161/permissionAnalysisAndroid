package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzcg;

public final class zzce extends zzcg.zza {
    private final zzat zzaki;
    private final zzau zzakj;
    private final zzar zzakk;
    private boolean zzakl = false;

    public zzce(String str, Context context, boolean z) {
        this.zzaki = zzat.zza(str, context, z);
        this.zzakj = new zzau(this.zzaki);
        this.zzakk = z ? null : zzar.zzd(context);
    }

    private zzd zza(zzd zzd, zzd zzd2, boolean z) {
        try {
            Uri uri = (Uri) zze.zzae(zzd);
            Context context = (Context) zze.zzae(zzd2);
            return zze.zzac(z ? this.zzakj.zza(uri, context) : this.zzakj.zzb(uri, context));
        } catch (zzav e) {
            return null;
        }
    }

    public zzd zza(zzd zzd, zzd zzd2) {
        return zza(zzd, zzd2, true);
    }

    public String zza(zzd zzd, String str) {
        return this.zzaki.zzb((Context) zze.zzae(zzd), str);
    }

    public boolean zza(zzd zzd) {
        return this.zzakj.zza((Uri) zze.zzae(zzd));
    }

    public zzd zzb(zzd zzd, zzd zzd2) {
        return zza(zzd, zzd2, false);
    }

    public void zzb(String str, String str2) {
        this.zzakj.zzb(str, str2);
    }

    public boolean zzb(zzd zzd) {
        return this.zzakj.zzc((Uri) zze.zzae(zzd));
    }

    public boolean zzb(String str, boolean z) {
        if (this.zzakk == null) {
            return false;
        }
        this.zzakk.zza(new AdvertisingIdClient.Info(str, z));
        this.zzakl = true;
        return true;
    }

    public String zzc(zzd zzd) {
        Context context = (Context) zze.zzae(zzd);
        String zzb = this.zzaki.zzb(context);
        if (this.zzakk == null || !this.zzakl) {
            return zzb;
        }
        String zza = this.zzakk.zza(zzb, this.zzakk.zzb(context));
        this.zzakl = false;
        return zza;
    }

    public void zzd(zzd zzd) {
        this.zzakj.zza((MotionEvent) zze.zzae(zzd));
    }

    public String zzdk() {
        return "ms";
    }

    public void zzm(String str) {
        this.zzakj.zzm(str);
    }
}
