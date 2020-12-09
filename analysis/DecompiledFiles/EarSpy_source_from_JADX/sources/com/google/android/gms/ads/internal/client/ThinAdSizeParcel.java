package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.internal.zziy;

@zziy
public class ThinAdSizeParcel extends AdSizeParcel {
    public ThinAdSizeParcel(AdSizeParcel adSizeParcel) {
        super(adSizeParcel.versionCode, adSizeParcel.zzaxi, adSizeParcel.height, adSizeParcel.heightPixels, adSizeParcel.zzaxj, adSizeParcel.width, adSizeParcel.widthPixels, adSizeParcel.zzaxk, adSizeParcel.zzaxl, adSizeParcel.zzaxm, adSizeParcel.zzaxn);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int zzcr = zzb.zzcr(parcel);
        zzb.zzc(parcel, 1, this.versionCode);
        zzb.zza(parcel, 2, this.zzaxi, false);
        zzb.zzc(parcel, 3, this.height);
        zzb.zzc(parcel, 6, this.width);
        zzb.zzaj(parcel, zzcr);
    }
}
