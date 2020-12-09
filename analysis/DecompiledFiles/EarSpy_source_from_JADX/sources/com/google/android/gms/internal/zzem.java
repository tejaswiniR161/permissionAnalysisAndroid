package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.internal.zzeh;

@zziy
public class zzem extends zzeh.zza {
    private final NativeAppInstallAd.OnAppInstallAdLoadedListener zzblw;

    public zzem(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.zzblw = onAppInstallAdLoadedListener;
    }

    public void zza(zzeb zzeb) {
        this.zzblw.onAppInstallAdLoaded(zzb(zzeb));
    }

    /* access modifiers changed from: package-private */
    public zzec zzb(zzeb zzeb) {
        return new zzec(zzeb);
    }
}
