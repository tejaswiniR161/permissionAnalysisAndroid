package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzv;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzgq;
import com.google.android.gms.internal.zziy;

@zziy
public class zze extends zzg<zzv> {
    public zze() {
        super("com.google.android.gms.ads.AdManagerCreatorImpl");
    }

    public zzu zza(Context context, AdSizeParcel adSizeParcel, String str, zzgq zzgq, int i) {
        try {
            return zzu.zza.zzq(((zzv) zzcu(context)).zza(com.google.android.gms.dynamic.zze.zzac(context), adSizeParcel, str, zzgq, zzf.f1696BA, i));
        } catch (RemoteException | zzg.zza e) {
            zzb.zza("Could not create remote AdManager.", e);
            return null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzk */
    public zzv zzc(IBinder iBinder) {
        return zzv.zza.zzr(iBinder);
    }
}
