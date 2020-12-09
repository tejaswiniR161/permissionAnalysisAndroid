package com.google.android.gms.ads.internal.overlay;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.InterstitialAdParameterParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzf implements Parcelable.Creator<AdOverlayInfoParcel> {
    static void zza(AdOverlayInfoParcel adOverlayInfoParcel, Parcel parcel, int i) {
        int zzcr = zzb.zzcr(parcel);
        zzb.zzc(parcel, 1, adOverlayInfoParcel.versionCode);
        zzb.zza(parcel, 2, (Parcelable) adOverlayInfoParcel.zzbye, i, false);
        zzb.zza(parcel, 3, adOverlayInfoParcel.zzpc(), false);
        zzb.zza(parcel, 4, adOverlayInfoParcel.zzpd(), false);
        zzb.zza(parcel, 5, adOverlayInfoParcel.zzpe(), false);
        zzb.zza(parcel, 6, adOverlayInfoParcel.zzpf(), false);
        zzb.zza(parcel, 7, adOverlayInfoParcel.zzbyj, false);
        zzb.zza(parcel, 8, adOverlayInfoParcel.zzbyk);
        zzb.zza(parcel, 9, adOverlayInfoParcel.zzbyl, false);
        zzb.zza(parcel, 10, adOverlayInfoParcel.zzph(), false);
        zzb.zzc(parcel, 11, adOverlayInfoParcel.orientation);
        zzb.zzc(parcel, 12, adOverlayInfoParcel.zzbyn);
        zzb.zza(parcel, 13, adOverlayInfoParcel.url, false);
        zzb.zza(parcel, 14, (Parcelable) adOverlayInfoParcel.zzaqv, i, false);
        zzb.zza(parcel, 15, adOverlayInfoParcel.zzpg(), false);
        zzb.zza(parcel, 16, adOverlayInfoParcel.zzbyp, false);
        zzb.zza(parcel, 17, (Parcelable) adOverlayInfoParcel.zzbyq, i, false);
        zzb.zzaj(parcel, zzcr);
    }

    /* renamed from: zzai */
    public AdOverlayInfoParcel[] newArray(int i) {
        return new AdOverlayInfoParcel[i];
    }

    /* renamed from: zzk */
    public AdOverlayInfoParcel createFromParcel(Parcel parcel) {
        int zzcq = zza.zzcq(parcel);
        int i = 0;
        AdLauncherIntentInfoParcel adLauncherIntentInfoParcel = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        IBinder iBinder3 = null;
        IBinder iBinder4 = null;
        String str = null;
        boolean z = false;
        String str2 = null;
        IBinder iBinder5 = null;
        int i2 = 0;
        int i3 = 0;
        String str3 = null;
        VersionInfoParcel versionInfoParcel = null;
        IBinder iBinder6 = null;
        String str4 = null;
        InterstitialAdParameterParcel interstitialAdParameterParcel = null;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = zza.zzcp(parcel);
            switch (zza.zzgv(zzcp)) {
                case 1:
                    i = zza.zzg(parcel, zzcp);
                    break;
                case 2:
                    adLauncherIntentInfoParcel = (AdLauncherIntentInfoParcel) zza.zza(parcel, zzcp, AdLauncherIntentInfoParcel.CREATOR);
                    break;
                case 3:
                    iBinder = zza.zzr(parcel, zzcp);
                    break;
                case 4:
                    iBinder2 = zza.zzr(parcel, zzcp);
                    break;
                case 5:
                    iBinder3 = zza.zzr(parcel, zzcp);
                    break;
                case 6:
                    iBinder4 = zza.zzr(parcel, zzcp);
                    break;
                case 7:
                    str = zza.zzq(parcel, zzcp);
                    break;
                case 8:
                    z = zza.zzc(parcel, zzcp);
                    break;
                case 9:
                    str2 = zza.zzq(parcel, zzcp);
                    break;
                case 10:
                    iBinder5 = zza.zzr(parcel, zzcp);
                    break;
                case 11:
                    i2 = zza.zzg(parcel, zzcp);
                    break;
                case 12:
                    i3 = zza.zzg(parcel, zzcp);
                    break;
                case 13:
                    str3 = zza.zzq(parcel, zzcp);
                    break;
                case 14:
                    versionInfoParcel = (VersionInfoParcel) zza.zza(parcel, zzcp, VersionInfoParcel.CREATOR);
                    break;
                case 15:
                    iBinder6 = zza.zzr(parcel, zzcp);
                    break;
                case 16:
                    str4 = zza.zzq(parcel, zzcp);
                    break;
                case 17:
                    interstitialAdParameterParcel = (InterstitialAdParameterParcel) zza.zza(parcel, zzcp, InterstitialAdParameterParcel.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzcp);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcq) {
            return new AdOverlayInfoParcel(i, adLauncherIntentInfoParcel, iBinder, iBinder2, iBinder3, iBinder4, str, z, str2, iBinder5, i2, i3, str3, versionInfoParcel, iBinder6, str4, interstitialAdParameterParcel);
        }
        throw new zza.C1271zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcq).toString(), parcel);
    }
}
