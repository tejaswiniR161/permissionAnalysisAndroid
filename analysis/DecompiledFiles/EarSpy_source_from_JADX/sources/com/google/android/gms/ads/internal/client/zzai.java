package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzaa;
import com.google.android.gms.ads.internal.client.zzz;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zziy;

@zziy
public class zzai extends zzg<zzaa> {
    public zzai() {
        super("com.google.android.gms.ads.MobileAdsSettingManagerCreatorImpl");
    }

    public zzz zzm(Context context) {
        try {
            return zzz.zza.zzu(((zzaa) zzcu(context)).zza(zze.zzac(context), zzf.f1696BA));
        } catch (RemoteException e) {
            zzb.zzd("Could not get remote MobileAdsSettingManager.", e);
            return null;
        } catch (zzg.zza e2) {
            zzb.zzd("Could not get remote MobileAdsSettingManager.", e2);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzy */
    public zzaa zzc(IBinder iBinder) {
        return zzaa.zza.zzv(iBinder);
    }
}
