package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.internal.zzei;

@zziy
public class zzen extends zzei.zza {
    private final NativeContentAd.OnContentAdLoadedListener zzblx;

    public zzen(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
        this.zzblx = onContentAdLoadedListener;
    }

    public void zza(zzed zzed) {
        this.zzblx.onContentAdLoaded(zzb(zzed));
    }

    /* access modifiers changed from: package-private */
    public zzee zzb(zzed zzed) {
        return new zzee(zzed);
    }
}
