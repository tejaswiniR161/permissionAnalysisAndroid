package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzhp;
import com.google.android.gms.internal.zzhq;

@zziy
public final class zzho extends zzg<zzhq> {
    public zzho() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzas */
    public zzhq zzc(IBinder iBinder) {
        return zzhq.zza.zzau(iBinder);
    }

    public zzhp zzf(Activity activity) {
        try {
            return zzhp.zza.zzat(((zzhq) zzcu(activity)).zzo(zze.zzac(activity)));
        } catch (RemoteException e) {
            zzb.zzd("Could not create remote AdOverlay.", e);
            return null;
        } catch (zzg.zza e2) {
            zzb.zzd("Could not create remote AdOverlay.", e2);
            return null;
        }
    }
}
