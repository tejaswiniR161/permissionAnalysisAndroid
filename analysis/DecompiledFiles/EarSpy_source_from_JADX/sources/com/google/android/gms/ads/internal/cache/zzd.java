package com.google.android.gms.ads.internal.cache;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Parcelable.Creator<CacheOffering> {
    static void zza(CacheOffering cacheOffering, Parcel parcel, int i) {
        int zzcr = zzb.zzcr(parcel);
        zzb.zzc(parcel, 1, cacheOffering.version);
        zzb.zza(parcel, 2, cacheOffering.url, false);
        zzb.zza(parcel, 3, cacheOffering.zzavv);
        zzb.zza(parcel, 4, cacheOffering.zzavw, false);
        zzb.zza(parcel, 5, cacheOffering.zzavx, false);
        zzb.zza(parcel, 6, cacheOffering.zzavy, false);
        zzb.zza(parcel, 7, cacheOffering.zzavz, false);
        zzb.zza(parcel, 8, cacheOffering.zzawa);
        zzb.zzaj(parcel, zzcr);
    }

    /* renamed from: zzd */
    public CacheOffering createFromParcel(Parcel parcel) {
        boolean z = false;
        Bundle bundle = null;
        int zzcq = zza.zzcq(parcel);
        long j = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i = 0;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = zza.zzcp(parcel);
            switch (zza.zzgv(zzcp)) {
                case 1:
                    i = zza.zzg(parcel, zzcp);
                    break;
                case 2:
                    str4 = zza.zzq(parcel, zzcp);
                    break;
                case 3:
                    j = zza.zzi(parcel, zzcp);
                    break;
                case 4:
                    str3 = zza.zzq(parcel, zzcp);
                    break;
                case 5:
                    str2 = zza.zzq(parcel, zzcp);
                    break;
                case 6:
                    str = zza.zzq(parcel, zzcp);
                    break;
                case 7:
                    bundle = zza.zzs(parcel, zzcp);
                    break;
                case 8:
                    z = zza.zzc(parcel, zzcp);
                    break;
                default:
                    zza.zzb(parcel, zzcp);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcq) {
            return new CacheOffering(i, str4, j, str3, str2, str, bundle, z);
        }
        throw new zza.C1271zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcq).toString(), parcel);
    }

    /* renamed from: zzs */
    public CacheOffering[] newArray(int i) {
        return new CacheOffering[i];
    }
}
