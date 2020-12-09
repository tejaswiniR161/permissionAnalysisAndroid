package com.google.android.gms.gass.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.gass.internal.zze;

public class zzb extends zze<zze> {
    public zzb(Context context, Looper looper, zze.zzb zzb, zze.zzc zzc) {
        super(context, looper, 116, zzb, zzc, (String) null);
    }

    public zze zzbnu() throws DeadObjectException {
        return (zze) super.zzatx();
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzgq */
    public zze zzh(IBinder iBinder) {
        return zze.zza.zzgr(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzix() {
        return "com.google.android.gms.gass.START";
    }

    /* access modifiers changed from: protected */
    public String zziy() {
        return "com.google.android.gms.gass.internal.IGassService";
    }
}
