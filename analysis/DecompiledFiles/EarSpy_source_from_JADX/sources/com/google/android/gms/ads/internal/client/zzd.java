package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.client.zzt;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzgq;
import com.google.android.gms.internal.zziy;

@zziy
public final class zzd extends zzg<zzt> {
    public zzd() {
        super("com.google.android.gms.ads.AdLoaderBuilderCreatorImpl");
    }

    public zzs zza(Context context, String str, zzgq zzgq) {
        try {
            return zzs.zza.zzo(((zzt) zzcu(context)).zza(zze.zzac(context), str, zzgq, zzf.f1696BA));
        } catch (RemoteException e) {
            zzb.zzd("Could not create remote builder for AdLoader.", e);
        } catch (zzg.zza e2) {
            zzb.zzd("Could not create remote builder for AdLoader.", e2);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzj */
    public zzt zzc(IBinder iBinder) {
        return zzt.zza.zzp(iBinder);
    }
}
