package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzaq implements Parcelable.Creator<VideoOptionsParcel> {
    static void zza(VideoOptionsParcel videoOptionsParcel, Parcel parcel, int i) {
        int zzcr = zzb.zzcr(parcel);
        zzb.zzc(parcel, 1, videoOptionsParcel.versionCode);
        zzb.zza(parcel, 2, videoOptionsParcel.zzbac);
        zzb.zzaj(parcel, zzcr);
    }

    /* renamed from: zzh */
    public VideoOptionsParcel createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzcq = zza.zzcq(parcel);
        int i = 0;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = zza.zzcp(parcel);
            switch (zza.zzgv(zzcp)) {
                case 1:
                    i = zza.zzg(parcel, zzcp);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzcp);
                    break;
                default:
                    zza.zzb(parcel, zzcp);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcq) {
            return new VideoOptionsParcel(i, z);
        }
        throw new zza.C1271zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcq).toString(), parcel);
    }

    /* renamed from: zzx */
    public VideoOptionsParcel[] newArray(int i) {
        return new VideoOptionsParcel[i];
    }
}
