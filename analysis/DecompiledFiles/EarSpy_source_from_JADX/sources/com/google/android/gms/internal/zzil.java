package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzke;

@zziy
public class zzil {

    public interface zza {
        void zzb(zzke zzke);
    }

    public zzkt zza(Context context, com.google.android.gms.ads.internal.zza zza2, zzke.zza zza3, zzau zzau, @Nullable zzlt zzlt, zzgq zzgq, zza zza4, zzdq zzdq) {
        AdResponseParcel adResponseParcel = zza3.zzcop;
        zzkt zzip = adResponseParcel.zzchc ? new zzip(context, zza3, zzgq, zza4, zzdq, zzlt) : (adResponseParcel.zzaxl || (zza2 instanceof zzq)) ? (!adResponseParcel.zzaxl || !(zza2 instanceof zzq)) ? new zzin(zza3, zza4) : new zziq(context, (zzq) zza2, zza3, zzau, zza4, zzdq) : adResponseParcel.zzchi ? new zzij(context, zza3, zzlt, zza4) : (!zzdi.zzbco.get().booleanValue() || !zzs.zzaxr() || zzs.zzaxt() || zzlt == null || !zzlt.zzdt().zzaxj) ? new zzim(context, zza3, zzlt, zza4) : new zzio(context, zza3, zzlt, zza4);
        String valueOf = String.valueOf(zzip.getClass().getName());
        zzkn.zzdd(valueOf.length() != 0 ? "AdRenderer: ".concat(valueOf) : new String("AdRenderer: "));
        zzip.zzqw();
        return zzip;
    }

    public zzkt zza(Context context, zzke.zza zza2, zzjr zzjr) {
        zzjy zzjy = new zzjy(context, zza2, zzjr);
        String valueOf = String.valueOf(zzjy.getClass().getName());
        zzkn.zzdd(valueOf.length() != 0 ? "AdRenderer: ".concat(valueOf) : new String("AdRenderer: "));
        zzjy.zzqw();
        return zzjy;
    }
}
