package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.safebrowsing.SafeBrowsingConfigParcel;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzh implements Parcelable.Creator<AdResponseParcel> {
    static void zza(AdResponseParcel adResponseParcel, Parcel parcel, int i) {
        int zzcr = zzb.zzcr(parcel);
        zzb.zzc(parcel, 1, adResponseParcel.versionCode);
        zzb.zza(parcel, 2, adResponseParcel.zzbyj, false);
        zzb.zza(parcel, 3, adResponseParcel.body, false);
        zzb.zzb(parcel, 4, adResponseParcel.zzbsd, false);
        zzb.zzc(parcel, 5, adResponseParcel.errorCode);
        zzb.zzb(parcel, 6, adResponseParcel.zzbse, false);
        zzb.zza(parcel, 7, adResponseParcel.zzchb);
        zzb.zza(parcel, 8, adResponseParcel.zzchc);
        zzb.zza(parcel, 9, adResponseParcel.zzchd);
        zzb.zzb(parcel, 10, adResponseParcel.zzche, false);
        zzb.zza(parcel, 11, adResponseParcel.zzbsj);
        zzb.zzc(parcel, 12, adResponseParcel.orientation);
        zzb.zza(parcel, 13, adResponseParcel.zzchf, false);
        zzb.zza(parcel, 14, adResponseParcel.zzchg);
        zzb.zza(parcel, 15, adResponseParcel.zzchh, false);
        zzb.zza(parcel, 18, adResponseParcel.zzchi);
        zzb.zza(parcel, 19, adResponseParcel.zzchj, false);
        zzb.zza(parcel, 21, adResponseParcel.zzchk, false);
        zzb.zza(parcel, 22, adResponseParcel.zzchl);
        zzb.zza(parcel, 23, adResponseParcel.zzaxl);
        zzb.zza(parcel, 24, adResponseParcel.zzcgc);
        zzb.zza(parcel, 25, adResponseParcel.zzchm);
        zzb.zza(parcel, 26, adResponseParcel.zzchn);
        zzb.zza(parcel, 28, (Parcelable) adResponseParcel.zzcho, i, false);
        zzb.zza(parcel, 29, adResponseParcel.zzchp, false);
        zzb.zza(parcel, 30, adResponseParcel.zzchq, false);
        zzb.zza(parcel, 31, adResponseParcel.zzaxm);
        zzb.zza(parcel, 32, adResponseParcel.zzaxn);
        zzb.zza(parcel, 33, (Parcelable) adResponseParcel.zzchr, i, false);
        zzb.zzb(parcel, 34, adResponseParcel.zzchs, false);
        zzb.zzb(parcel, 35, adResponseParcel.zzcht, false);
        zzb.zza(parcel, 36, adResponseParcel.zzchu);
        zzb.zza(parcel, 37, (Parcelable) adResponseParcel.zzchv, i, false);
        zzb.zza(parcel, 38, adResponseParcel.zzcgt);
        zzb.zza(parcel, 39, adResponseParcel.zzcgu, false);
        zzb.zzb(parcel, 40, adResponseParcel.zzbsg, false);
        zzb.zza(parcel, 42, adResponseParcel.zzbsh);
        zzb.zza(parcel, 43, adResponseParcel.zzchw, false);
        zzb.zza(parcel, 44, (Parcelable) adResponseParcel.zzchx, i, false);
        zzb.zza(parcel, 45, adResponseParcel.zzchy, false);
        zzb.zzaj(parcel, zzcr);
    }

    /* renamed from: zzar */
    public AdResponseParcel[] newArray(int i) {
        return new AdResponseParcel[i];
    }

    /* renamed from: zzn */
    public AdResponseParcel createFromParcel(Parcel parcel) {
        int zzcq = zza.zzcq(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        ArrayList<String> arrayList = null;
        int i2 = 0;
        ArrayList<String> arrayList2 = null;
        long j = 0;
        boolean z = false;
        long j2 = 0;
        ArrayList<String> arrayList3 = null;
        long j3 = 0;
        int i3 = 0;
        String str3 = null;
        long j4 = 0;
        String str4 = null;
        boolean z2 = false;
        String str5 = null;
        String str6 = null;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        LargeParcelTeleporter largeParcelTeleporter = null;
        String str7 = null;
        String str8 = null;
        boolean z8 = false;
        boolean z9 = false;
        RewardItemParcel rewardItemParcel = null;
        ArrayList<String> arrayList4 = null;
        ArrayList<String> arrayList5 = null;
        boolean z10 = false;
        AutoClickProtectionConfigurationParcel autoClickProtectionConfigurationParcel = null;
        boolean z11 = false;
        String str9 = null;
        ArrayList<String> arrayList6 = null;
        boolean z12 = false;
        String str10 = null;
        SafeBrowsingConfigParcel safeBrowsingConfigParcel = null;
        String str11 = null;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = zza.zzcp(parcel);
            switch (zza.zzgv(zzcp)) {
                case 1:
                    i = zza.zzg(parcel, zzcp);
                    break;
                case 2:
                    str = zza.zzq(parcel, zzcp);
                    break;
                case 3:
                    str2 = zza.zzq(parcel, zzcp);
                    break;
                case 4:
                    arrayList = zza.zzae(parcel, zzcp);
                    break;
                case 5:
                    i2 = zza.zzg(parcel, zzcp);
                    break;
                case 6:
                    arrayList2 = zza.zzae(parcel, zzcp);
                    break;
                case 7:
                    j = zza.zzi(parcel, zzcp);
                    break;
                case 8:
                    z = zza.zzc(parcel, zzcp);
                    break;
                case 9:
                    j2 = zza.zzi(parcel, zzcp);
                    break;
                case 10:
                    arrayList3 = zza.zzae(parcel, zzcp);
                    break;
                case 11:
                    j3 = zza.zzi(parcel, zzcp);
                    break;
                case 12:
                    i3 = zza.zzg(parcel, zzcp);
                    break;
                case 13:
                    str3 = zza.zzq(parcel, zzcp);
                    break;
                case 14:
                    j4 = zza.zzi(parcel, zzcp);
                    break;
                case 15:
                    str4 = zza.zzq(parcel, zzcp);
                    break;
                case 18:
                    z2 = zza.zzc(parcel, zzcp);
                    break;
                case 19:
                    str5 = zza.zzq(parcel, zzcp);
                    break;
                case 21:
                    str6 = zza.zzq(parcel, zzcp);
                    break;
                case 22:
                    z3 = zza.zzc(parcel, zzcp);
                    break;
                case 23:
                    z4 = zza.zzc(parcel, zzcp);
                    break;
                case 24:
                    z5 = zza.zzc(parcel, zzcp);
                    break;
                case 25:
                    z6 = zza.zzc(parcel, zzcp);
                    break;
                case 26:
                    z7 = zza.zzc(parcel, zzcp);
                    break;
                case 28:
                    largeParcelTeleporter = (LargeParcelTeleporter) zza.zza(parcel, zzcp, LargeParcelTeleporter.CREATOR);
                    break;
                case 29:
                    str7 = zza.zzq(parcel, zzcp);
                    break;
                case 30:
                    str8 = zza.zzq(parcel, zzcp);
                    break;
                case 31:
                    z8 = zza.zzc(parcel, zzcp);
                    break;
                case 32:
                    z9 = zza.zzc(parcel, zzcp);
                    break;
                case 33:
                    rewardItemParcel = (RewardItemParcel) zza.zza(parcel, zzcp, RewardItemParcel.CREATOR);
                    break;
                case 34:
                    arrayList4 = zza.zzae(parcel, zzcp);
                    break;
                case 35:
                    arrayList5 = zza.zzae(parcel, zzcp);
                    break;
                case 36:
                    z10 = zza.zzc(parcel, zzcp);
                    break;
                case 37:
                    autoClickProtectionConfigurationParcel = (AutoClickProtectionConfigurationParcel) zza.zza(parcel, zzcp, AutoClickProtectionConfigurationParcel.CREATOR);
                    break;
                case 38:
                    z11 = zza.zzc(parcel, zzcp);
                    break;
                case 39:
                    str9 = zza.zzq(parcel, zzcp);
                    break;
                case 40:
                    arrayList6 = zza.zzae(parcel, zzcp);
                    break;
                case 42:
                    z12 = zza.zzc(parcel, zzcp);
                    break;
                case 43:
                    str10 = zza.zzq(parcel, zzcp);
                    break;
                case 44:
                    safeBrowsingConfigParcel = (SafeBrowsingConfigParcel) zza.zza(parcel, zzcp, SafeBrowsingConfigParcel.CREATOR);
                    break;
                case 45:
                    str11 = zza.zzq(parcel, zzcp);
                    break;
                default:
                    zza.zzb(parcel, zzcp);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcq) {
            return new AdResponseParcel(i, str, str2, arrayList, i2, arrayList2, j, z, j2, arrayList3, j3, i3, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, largeParcelTeleporter, str7, str8, z8, z9, rewardItemParcel, arrayList4, arrayList5, z10, autoClickProtectionConfigurationParcel, z11, str9, arrayList6, z12, str10, safeBrowsingConfigParcel, str11);
        }
        throw new zza.C1271zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcq).toString(), parcel);
    }
}
