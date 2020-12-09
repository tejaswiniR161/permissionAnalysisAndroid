package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Parcelable.Creator<AdSizeParcel> {
    static void zza(AdSizeParcel adSizeParcel, Parcel parcel, int i) {
        int zzcr = zzb.zzcr(parcel);
        zzb.zzc(parcel, 1, adSizeParcel.versionCode);
        zzb.zza(parcel, 2, adSizeParcel.zzaxi, false);
        zzb.zzc(parcel, 3, adSizeParcel.height);
        zzb.zzc(parcel, 4, adSizeParcel.heightPixels);
        zzb.zza(parcel, 5, adSizeParcel.zzaxj);
        zzb.zzc(parcel, 6, adSizeParcel.width);
        zzb.zzc(parcel, 7, adSizeParcel.widthPixels);
        zzb.zza(parcel, 8, (T[]) adSizeParcel.zzaxk, i, false);
        zzb.zza(parcel, 9, adSizeParcel.zzaxl);
        zzb.zza(parcel, 10, adSizeParcel.zzaxm);
        zzb.zza(parcel, 11, adSizeParcel.zzaxn);
        zzb.zzaj(parcel, zzcr);
    }

    /* renamed from: zzf */
    public AdSizeParcel createFromParcel(Parcel parcel) {
        AdSizeParcel[] adSizeParcelArr = null;
        boolean z = false;
        int zzcq = zza.zzcq(parcel);
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        int i2 = 0;
        boolean z4 = false;
        int i3 = 0;
        int i4 = 0;
        String str = null;
        int i5 = 0;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = zza.zzcp(parcel);
            switch (zza.zzgv(zzcp)) {
                case 1:
                    i5 = zza.zzg(parcel, zzcp);
                    break;
                case 2:
                    str = zza.zzq(parcel, zzcp);
                    break;
                case 3:
                    i4 = zza.zzg(parcel, zzcp);
                    break;
                case 4:
                    i3 = zza.zzg(parcel, zzcp);
                    break;
                case 5:
                    z4 = zza.zzc(parcel, zzcp);
                    break;
                case 6:
                    i2 = zza.zzg(parcel, zzcp);
                    break;
                case 7:
                    i = zza.zzg(parcel, zzcp);
                    break;
                case 8:
                    adSizeParcelArr = (AdSizeParcel[]) zza.zzb(parcel, zzcp, AdSizeParcel.CREATOR);
                    break;
                case 9:
                    z3 = zza.zzc(parcel, zzcp);
                    break;
                case 10:
                    z2 = zza.zzc(parcel, zzcp);
                    break;
                case 11:
                    z = zza.zzc(parcel, zzcp);
                    break;
                default:
                    zza.zzb(parcel, zzcp);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcq) {
            return new AdSizeParcel(i5, str, i4, i3, z4, i2, i, adSizeParcelArr, z3, z2, z);
        }
        throw new zza.C1271zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcq).toString(), parcel);
    }

    /* renamed from: zzu */
    public AdSizeParcel[] newArray(int i) {
        return new AdSizeParcel[i];
    }
}
