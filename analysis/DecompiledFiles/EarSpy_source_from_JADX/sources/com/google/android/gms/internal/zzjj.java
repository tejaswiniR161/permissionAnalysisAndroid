package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

@zziy
public abstract class zzjj {
    public abstract void zza(Context context, zzjd zzjd, VersionInfoParcel versionInfoParcel);

    /* access modifiers changed from: protected */
    public void zze(zzjd zzjd) {
        zzjd.zzsf();
        if (zzjd.zzsd() != null) {
            zzjd.zzsd().release();
        }
    }
}
