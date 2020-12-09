package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.view.MotionEvent;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

public final class zzcc {
    private final zzcg zzakh;

    public zzcc(String str, Context context, boolean z) {
        this.zzakh = zzcf.zzb(str, context, z);
    }

    public void zza(MotionEvent motionEvent) throws RemoteException {
        this.zzakh.zzd(zze.zzac(motionEvent));
    }

    public Uri zzc(Uri uri, Context context) throws zzcd, RemoteException {
        zzd zza = this.zzakh.zza(zze.zzac(uri), zze.zzac(context));
        if (zza != null) {
            return (Uri) zze.zzae(zza);
        }
        throw new zzcd();
    }

    public Uri zzd(Uri uri, Context context) throws zzcd, RemoteException {
        zzd zzb = this.zzakh.zzb(zze.zzac(uri), zze.zzac(context));
        if (zzb != null) {
            return (Uri) zze.zzae(zzb);
        }
        throw new zzcd();
    }
}
