package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzdz;
import com.google.android.gms.internal.zzea;

@zziy
public class zzel extends zzg<zzea> {
    public zzel() {
        super("com.google.android.gms.ads.NativeAdViewDelegateCreatorImpl");
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzal */
    public zzea zzc(IBinder iBinder) {
        return zzea.zza.zzad(iBinder);
    }

    public zzdz zzb(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        try {
            return zzdz.zza.zzac(((zzea) zzcu(context)).zza(zze.zzac(context), zze.zzac(frameLayout), zze.zzac(frameLayout2), zzf.f1696BA));
        } catch (RemoteException | zzg.zza e) {
            zzb.zzd("Could not create remote NativeAdViewDelegate.", e);
            return null;
        }
    }
}
