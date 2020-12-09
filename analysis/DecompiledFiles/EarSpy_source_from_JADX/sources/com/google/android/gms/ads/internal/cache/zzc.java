package com.google.android.gms.ads.internal.cache;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.ads.internal.cache.zzf;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.internal.zziy;

@zziy
public class zzc extends zze<zzf> {
    zzc(Context context, Looper looper, zze.zzb zzb, zze.zzc zzc) {
        super(context, looper, 123, zzb, zzc, (String) null);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzg */
    public zzf zzh(IBinder iBinder) {
        return zzf.zza.zzi(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzix() {
        return "com.google.android.gms.ads.service.CACHE";
    }

    /* access modifiers changed from: protected */
    public String zziy() {
        return "com.google.android.gms.ads.internal.cache.ICacheService";
    }

    public zzf zziz() throws DeadObjectException {
        return (zzf) super.zzatx();
    }
}
