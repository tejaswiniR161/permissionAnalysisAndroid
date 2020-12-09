package com.google.android.gms.ads.internal.util.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Parcelable.Creator<VersionInfoParcel> {
    static void zza(VersionInfoParcel versionInfoParcel, Parcel parcel, int i) {
        int zzcr = zzb.zzcr(parcel);
        zzb.zzc(parcel, 1, versionInfoParcel.versionCode);
        zzb.zza(parcel, 2, versionInfoParcel.zzcs, false);
        zzb.zzc(parcel, 3, versionInfoParcel.zzcts);
        zzb.zzc(parcel, 4, versionInfoParcel.zzctt);
        zzb.zza(parcel, 5, versionInfoParcel.zzctu);
        zzb.zzaj(parcel, zzcr);
    }

    /* renamed from: zzbg */
    public VersionInfoParcel[] newArray(int i) {
        return new VersionInfoParcel[i];
    }

    /* renamed from: zzv */
    public VersionInfoParcel createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzcq = zza.zzcq(parcel);
        String str = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = zza.zzcp(parcel);
            switch (zza.zzgv(zzcp)) {
                case 1:
                    i3 = zza.zzg(parcel, zzcp);
                    break;
                case 2:
                    str = zza.zzq(parcel, zzcp);
                    break;
                case 3:
                    i2 = zza.zzg(parcel, zzcp);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzcp);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzcp);
                    break;
                default:
                    zza.zzb(parcel, zzcp);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcq) {
            return new VersionInfoParcel(i3, str, i2, i, z);
        }
        throw new zza.C1271zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcq).toString(), parcel);
    }
}
