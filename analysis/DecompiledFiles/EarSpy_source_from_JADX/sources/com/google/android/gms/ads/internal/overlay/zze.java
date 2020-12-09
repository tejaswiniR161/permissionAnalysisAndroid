package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.AdActivity;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zziy;

@zziy
public class zze {
    public void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel) {
        zza(context, adOverlayInfoParcel, true);
    }

    public void zza(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.zzbyn == 4 && adOverlayInfoParcel.zzbyg == null) {
            if (adOverlayInfoParcel.zzbyf != null) {
                adOverlayInfoParcel.zzbyf.onAdClicked();
            }
            zzu.zzfw().zza(context, adOverlayInfoParcel.zzbye, adOverlayInfoParcel.zzbym);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, AdActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.zzaqv.zzctu);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        AdOverlayInfoParcel.zza(intent, adOverlayInfoParcel);
        if (!zzs.zzaxt()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        zzu.zzfz().zzb(context, intent);
    }
}
