package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.internal.zzdu;

@zziy
public final class zzdv extends zzdu.zza {
    private final OnCustomRenderedAdLoadedListener zzayz;

    public zzdv(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzayz = onCustomRenderedAdLoadedListener;
    }

    public void zza(zzdt zzdt) {
        this.zzayz.onCustomRenderedAdLoaded(new zzds(zzdt));
    }
}
