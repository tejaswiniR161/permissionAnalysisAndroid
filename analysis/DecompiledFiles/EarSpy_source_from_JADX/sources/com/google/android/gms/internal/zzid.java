package com.google.android.gms.internal;

import android.app.Activity;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzhy;
import com.google.android.gms.internal.zzhz;

@zziy
public final class zzid extends zzg<zzhz> {
    public zzid() {
        super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzbc */
    public zzhz zzc(IBinder iBinder) {
        return zzhz.zza.zzaz(iBinder);
    }

    public zzhy zzg(Activity activity) {
        try {
            return zzhy.zza.zzay(((zzhz) zzcu(activity)).zzp(zze.zzac(activity)));
        } catch (RemoteException e) {
            zzb.zzd("Could not create remote InAppPurchaseManager.", e);
            return null;
        } catch (zzg.zza e2) {
            zzb.zzd("Could not create remote InAppPurchaseManager.", e2);
            return null;
        }
    }
}
