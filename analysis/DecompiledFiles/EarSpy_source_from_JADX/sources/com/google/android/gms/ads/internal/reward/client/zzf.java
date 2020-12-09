package com.google.android.gms.ads.internal.reward.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.reward.client.zzb;
import com.google.android.gms.ads.internal.reward.client.zzc;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzgq;
import com.google.android.gms.internal.zziy;

@zziy
public class zzf extends zzg<zzc> {
    public zzf() {
        super("com.google.android.gms.ads.reward.RewardedVideoAdCreatorImpl");
    }

    public zzb zzb(Context context, zzgq zzgq) {
        try {
            return zzb.zza.zzbh(((zzc) zzcu(context)).zza(zze.zzac(context), zzgq, com.google.android.gms.common.internal.zzf.f1696BA));
        } catch (RemoteException | zzg.zza e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not get remote RewardedVideoAd.", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzbk */
    public zzc zzc(IBinder iBinder) {
        return zzc.zza.zzbi(iBinder);
    }
}
