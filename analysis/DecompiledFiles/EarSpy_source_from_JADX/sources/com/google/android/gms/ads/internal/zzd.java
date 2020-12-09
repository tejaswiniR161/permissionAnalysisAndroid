package com.google.android.gms.ads.internal;

import com.google.android.gms.ads.internal.overlay.zzj;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.safebrowsing.zza;
import com.google.android.gms.internal.zzes;
import com.google.android.gms.internal.zzfl;
import com.google.android.gms.internal.zziy;

@zziy
public class zzd {
    public final zzfl zzamc;
    public final zzj zzamd;
    public final zzm zzame;
    public final com.google.android.gms.ads.internal.safebrowsing.zzd zzamf;

    public zzd(zzfl zzfl, zzj zzj, zzm zzm, com.google.android.gms.ads.internal.safebrowsing.zzd zzd) {
        this.zzamc = zzfl;
        this.zzamd = zzj;
        this.zzame = zzm;
        this.zzamf = zzd;
    }

    public static zzd zzeq() {
        return new zzd(new zzes(), new zzn(), new zzt(), new zza());
    }
}
