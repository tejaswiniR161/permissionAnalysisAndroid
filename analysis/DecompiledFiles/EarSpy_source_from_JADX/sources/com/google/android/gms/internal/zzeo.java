package com.google.android.gms.internal;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.internal.zzej;

@zziy
public class zzeo extends zzej.zza {
    private final NativeCustomTemplateAd.OnCustomClickListener zzbly;

    public zzeo(NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.zzbly = onCustomClickListener;
    }

    public void zza(zzef zzef, String str) {
        this.zzbly.onCustomClick(new zzeg(zzef), str);
    }
}
