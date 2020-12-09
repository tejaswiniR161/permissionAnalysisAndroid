package com.google.android.gms.ads.internal.reward.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Parcelable.Creator<RewardedVideoAdRequestParcel> {
    static void zza(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel, Parcel parcel, int i) {
        int zzcr = zzb.zzcr(parcel);
        zzb.zzc(parcel, 1, rewardedVideoAdRequestParcel.versionCode);
        zzb.zza(parcel, 2, (Parcelable) rewardedVideoAdRequestParcel.zzcfu, i, false);
        zzb.zza(parcel, 3, rewardedVideoAdRequestParcel.zzaqt, false);
        zzb.zzaj(parcel, zzcr);
    }

    /* renamed from: zzax */
    public RewardedVideoAdRequestParcel[] newArray(int i) {
        return new RewardedVideoAdRequestParcel[i];
    }

    /* renamed from: zzs */
    public RewardedVideoAdRequestParcel createFromParcel(Parcel parcel) {
        String zzq;
        AdRequestParcel adRequestParcel;
        int i;
        String str = null;
        int zzcq = zza.zzcq(parcel);
        int i2 = 0;
        AdRequestParcel adRequestParcel2 = null;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = zza.zzcp(parcel);
            switch (zza.zzgv(zzcp)) {
                case 1:
                    String str2 = str;
                    adRequestParcel = adRequestParcel2;
                    i = zza.zzg(parcel, zzcp);
                    zzq = str2;
                    break;
                case 2:
                    i = i2;
                    AdRequestParcel adRequestParcel3 = (AdRequestParcel) zza.zza(parcel, zzcp, AdRequestParcel.CREATOR);
                    zzq = str;
                    adRequestParcel = adRequestParcel3;
                    break;
                case 3:
                    zzq = zza.zzq(parcel, zzcp);
                    adRequestParcel = adRequestParcel2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzcp);
                    zzq = str;
                    adRequestParcel = adRequestParcel2;
                    i = i2;
                    break;
            }
            i2 = i;
            adRequestParcel2 = adRequestParcel;
            str = zzq;
        }
        if (parcel.dataPosition() == zzcq) {
            return new RewardedVideoAdRequestParcel(i2, adRequestParcel2, str);
        }
        throw new zza.C1271zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcq).toString(), parcel);
    }
}
