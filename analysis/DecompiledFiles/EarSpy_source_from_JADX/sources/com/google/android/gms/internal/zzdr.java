package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.ads.internal.zzh;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdt;

@zziy
public final class zzdr extends zzdt.zza {
    private final zzh zzbiu;
    @Nullable
    private final String zzbiv;
    private final String zzbiw;

    public zzdr(zzh zzh, @Nullable String str, String str2) {
        this.zzbiu = zzh;
        this.zzbiv = str;
        this.zzbiw = str2;
    }

    public String getContent() {
        return this.zzbiw;
    }

    public void recordClick() {
        this.zzbiu.zzen();
    }

    public void recordImpression() {
        this.zzbiu.zzeo();
    }

    public void zzi(@Nullable zzd zzd) {
        if (zzd != null) {
            this.zzbiu.zzc((View) zze.zzae(zzd));
        }
    }

    public String zzle() {
        return this.zzbiv;
    }
}
