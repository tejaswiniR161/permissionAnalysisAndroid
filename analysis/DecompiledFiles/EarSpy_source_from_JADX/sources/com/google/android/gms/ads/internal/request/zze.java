package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.ads.internal.request.zzk;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.internal.zziy;

@zziy
public class zze extends com.google.android.gms.common.internal.zze<zzk> {
    final int zzcfs;

    public zze(Context context, Looper looper, zze.zzb zzb, zze.zzc zzc, int i) {
        super(context, looper, 8, zzb, zzc, (String) null);
        this.zzcfs = i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzbd */
    public zzk zzh(IBinder iBinder) {
        return zzk.zza.zzbe(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzix() {
        return "com.google.android.gms.ads.service.START";
    }

    /* access modifiers changed from: protected */
    public String zziy() {
        return "com.google.android.gms.ads.internal.request.IAdRequestService";
    }

    public zzk zzry() throws DeadObjectException {
        return (zzk) super.zzatx();
    }
}
