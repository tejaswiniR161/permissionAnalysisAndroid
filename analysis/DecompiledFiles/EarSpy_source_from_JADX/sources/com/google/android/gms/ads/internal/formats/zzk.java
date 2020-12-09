package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk implements Parcelable.Creator<NativeAdOptionsParcel> {
    static void zza(NativeAdOptionsParcel nativeAdOptionsParcel, Parcel parcel, int i) {
        int zzcr = zzb.zzcr(parcel);
        zzb.zzc(parcel, 1, nativeAdOptionsParcel.versionCode);
        zzb.zza(parcel, 2, nativeAdOptionsParcel.zzblb);
        zzb.zzc(parcel, 3, nativeAdOptionsParcel.zzblc);
        zzb.zza(parcel, 4, nativeAdOptionsParcel.zzbld);
        zzb.zzc(parcel, 5, nativeAdOptionsParcel.zzble);
        zzb.zza(parcel, 6, (Parcelable) nativeAdOptionsParcel.zzblf, i, false);
        zzb.zzaj(parcel, zzcr);
    }

    /* renamed from: zzi */
    public NativeAdOptionsParcel createFromParcel(Parcel parcel) {
        int i = 0;
        int zzcq = zza.zzcq(parcel);
        VideoOptionsParcel videoOptionsParcel = null;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = zza.zzcp(parcel);
            switch (zza.zzgv(zzcp)) {
                case 1:
                    i3 = zza.zzg(parcel, zzcp);
                    break;
                case 2:
                    z2 = zza.zzc(parcel, zzcp);
                    break;
                case 3:
                    i2 = zza.zzg(parcel, zzcp);
                    break;
                case 4:
                    z = zza.zzc(parcel, zzcp);
                    break;
                case 5:
                    i = zza.zzg(parcel, zzcp);
                    break;
                case 6:
                    videoOptionsParcel = (VideoOptionsParcel) zza.zza(parcel, zzcp, VideoOptionsParcel.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzcp);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcq) {
            return new NativeAdOptionsParcel(i3, z2, i2, z, i, videoOptionsParcel);
        }
        throw new zza.C1271zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcq).toString(), parcel);
    }

    /* renamed from: zzy */
    public NativeAdOptionsParcel[] newArray(int i) {
        return new NativeAdOptionsParcel[i];
    }
}
