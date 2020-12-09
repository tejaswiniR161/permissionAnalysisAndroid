package com.google.android.gms.ads.internal.safebrowsing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Parcelable.Creator<SafeBrowsingConfigParcel> {
    static void zza(SafeBrowsingConfigParcel safeBrowsingConfigParcel, Parcel parcel, int i) {
        int zzcr = com.google.android.gms.common.internal.safeparcel.zzb.zzcr(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, safeBrowsingConfigParcel.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, safeBrowsingConfigParcel.zzcnz, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, safeBrowsingConfigParcel.zzcoa, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, safeBrowsingConfigParcel.zzcob);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, safeBrowsingConfigParcel.zzcoc);
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, zzcr);
    }

    /* renamed from: zzbb */
    public SafeBrowsingConfigParcel[] newArray(int i) {
        return new SafeBrowsingConfigParcel[i];
    }

    /* renamed from: zzu */
    public SafeBrowsingConfigParcel createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzcq = zza.zzcq(parcel);
        boolean z2 = false;
        String str2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = zza.zzcp(parcel);
            switch (zza.zzgv(zzcp)) {
                case 1:
                    i = zza.zzg(parcel, zzcp);
                    break;
                case 2:
                    str2 = zza.zzq(parcel, zzcp);
                    break;
                case 3:
                    str = zza.zzq(parcel, zzcp);
                    break;
                case 4:
                    z2 = zza.zzc(parcel, zzcp);
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
            return new SafeBrowsingConfigParcel(i, str2, str, z2, z);
        }
        throw new zza.C1271zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcq).toString(), parcel);
    }
}
