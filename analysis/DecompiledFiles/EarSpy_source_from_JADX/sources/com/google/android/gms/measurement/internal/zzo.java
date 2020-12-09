package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.measurement.internal.zzm;

public class zzo extends zze<zzm> {
    public zzo(Context context, Looper looper, zze.zzb zzb, zze.zzc zzc) {
        super(context, looper, 93, zzb, zzc, (String) null);
    }

    /* access modifiers changed from: protected */
    @NonNull
    public String zzix() {
        return "com.google.android.gms.measurement.START";
    }

    /* access modifiers changed from: protected */
    @NonNull
    public String zziy() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    /* renamed from: zzjm */
    public zzm zzh(IBinder iBinder) {
        return zzm.zza.zzjl(iBinder);
    }
}
