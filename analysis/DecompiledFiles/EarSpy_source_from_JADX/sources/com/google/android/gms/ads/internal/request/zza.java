package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.internal.zzau;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkm;
import java.util.concurrent.Future;

@zziy
public class zza {

    /* renamed from: com.google.android.gms.ads.internal.request.zza$zza  reason: collision with other inner class name */
    public interface C1258zza {
        void zza(zzke.zza zza);
    }

    public zzkm zza(Context context, AdRequestInfoParcel.zza zza, zzau zzau, C1258zza zza2) {
        zzkm zzn = zza.zzcfu.extras.getBundle("sdk_less_server_data") != null ? new zzn(context, zza, zza2) : new zzb(context, zza, zzau, zza2);
        Future future = (Future) zzn.zzqw();
        return zzn;
    }
}
