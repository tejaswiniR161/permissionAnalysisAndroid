package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.ads.internal.zzu;

@zziy
public class zzlv {
    public zzlt zza(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, @Nullable zzau zzau, VersionInfoParcel versionInfoParcel) {
        return zza(context, adSizeParcel, z, z2, zzau, versionInfoParcel, (zzdq) null, (zzs) null, (zzd) null);
    }

    public zzlt zza(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, @Nullable zzau zzau, VersionInfoParcel versionInfoParcel, zzdq zzdq, zzs zzs, zzd zzd) {
        zzlw zzlw = new zzlw(zzlx.zzb(context, adSizeParcel, z, z2, zzau, versionInfoParcel, zzdq, zzs, zzd));
        zzlw.setWebViewClient(zzu.zzgb().zzb((zzlt) zzlw, z2));
        zzlw.setWebChromeClient(zzu.zzgb().zzn(zzlw));
        return zzlw;
    }
}
