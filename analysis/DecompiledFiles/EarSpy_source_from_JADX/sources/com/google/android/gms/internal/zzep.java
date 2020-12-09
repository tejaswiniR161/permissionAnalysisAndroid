package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.internal.zzek;

@zziy
public class zzep extends zzek.zza {
    private final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zzblz;

    public zzep(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener) {
        this.zzblz = onCustomTemplateAdLoadedListener;
    }

    public void zza(zzef zzef) {
        this.zzblz.onCustomTemplateAdLoaded(new zzeg(zzef));
    }
}
