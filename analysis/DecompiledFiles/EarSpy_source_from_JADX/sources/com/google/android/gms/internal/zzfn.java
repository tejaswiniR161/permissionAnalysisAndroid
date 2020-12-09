package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzl;

@zziy
public class zzfn {
    private final Context mContext;
    private final zzd zzalo;
    private final zzgq zzals;
    private final VersionInfoParcel zzanh;

    zzfn(Context context, zzgq zzgq, VersionInfoParcel versionInfoParcel, zzd zzd) {
        this.mContext = context;
        this.zzals = zzgq;
        this.zzanh = versionInfoParcel;
        this.zzalo = zzd;
    }

    public Context getApplicationContext() {
        return this.mContext.getApplicationContext();
    }

    public zzl zzbf(String str) {
        return new zzl(this.mContext, new AdSizeParcel(), str, this.zzals, this.zzanh, this.zzalo);
    }

    public zzl zzbg(String str) {
        return new zzl(this.mContext.getApplicationContext(), new AdSizeParcel(), str, this.zzals, this.zzanh, this.zzalo);
    }

    public zzfn zzml() {
        return new zzfn(getApplicationContext(), this.zzals, this.zzanh, this.zzalo);
    }
}
