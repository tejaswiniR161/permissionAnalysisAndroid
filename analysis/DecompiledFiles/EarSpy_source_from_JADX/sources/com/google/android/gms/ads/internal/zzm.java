package com.google.android.gms.ads.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm implements Parcelable.Creator<InterstitialAdParameterParcel> {
    static void zza(InterstitialAdParameterParcel interstitialAdParameterParcel, Parcel parcel, int i) {
        int zzcr = zzb.zzcr(parcel);
        zzb.zzc(parcel, 1, interstitialAdParameterParcel.versionCode);
        zzb.zza(parcel, 2, interstitialAdParameterParcel.zzanx);
        zzb.zza(parcel, 3, interstitialAdParameterParcel.zzany);
        zzb.zza(parcel, 4, interstitialAdParameterParcel.zzanz, false);
        zzb.zza(parcel, 5, interstitialAdParameterParcel.zzaoa);
        zzb.zza(parcel, 6, interstitialAdParameterParcel.zzaob);
        zzb.zzc(parcel, 7, interstitialAdParameterParcel.zzaoc);
        zzb.zzaj(parcel, zzcr);
    }

    /* renamed from: zzb */
    public InterstitialAdParameterParcel createFromParcel(Parcel parcel) {
        int i = 0;
        int zzcq = zza.zzcq(parcel);
        String str = null;
        float f = 0.0f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        int i2 = 0;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = zza.zzcp(parcel);
            switch (zza.zzgv(zzcp)) {
                case 1:
                    i2 = zza.zzg(parcel, zzcp);
                    break;
                case 2:
                    z3 = zza.zzc(parcel, zzcp);
                    break;
                case 3:
                    z2 = zza.zzc(parcel, zzcp);
                    break;
                case 4:
                    str = zza.zzq(parcel, zzcp);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzcp);
                    break;
                case 6:
                    f = zza.zzl(parcel, zzcp);
                    break;
                case 7:
                    i = zza.zzg(parcel, zzcp);
                    break;
                default:
                    zza.zzb(parcel, zzcp);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcq) {
            return new InterstitialAdParameterParcel(i2, z3, z2, str, z, f, i);
        }
        throw new zza.C1271zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcq).toString(), parcel);
    }

    /* renamed from: zzi */
    public InterstitialAdParameterParcel[] newArray(int i) {
        return new InterstitialAdParameterParcel[i];
    }
}
