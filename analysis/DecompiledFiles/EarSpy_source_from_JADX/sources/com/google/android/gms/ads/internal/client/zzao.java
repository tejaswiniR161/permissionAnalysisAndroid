package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzao implements Parcelable.Creator<SearchAdRequestParcel> {
    static void zza(SearchAdRequestParcel searchAdRequestParcel, Parcel parcel, int i) {
        int zzcr = zzb.zzcr(parcel);
        zzb.zzc(parcel, 1, searchAdRequestParcel.versionCode);
        zzb.zzc(parcel, 2, searchAdRequestParcel.zzazp);
        zzb.zzc(parcel, 3, searchAdRequestParcel.backgroundColor);
        zzb.zzc(parcel, 4, searchAdRequestParcel.zzazq);
        zzb.zzc(parcel, 5, searchAdRequestParcel.zzazr);
        zzb.zzc(parcel, 6, searchAdRequestParcel.zzazs);
        zzb.zzc(parcel, 7, searchAdRequestParcel.zzazt);
        zzb.zzc(parcel, 8, searchAdRequestParcel.zzazu);
        zzb.zzc(parcel, 9, searchAdRequestParcel.zzazv);
        zzb.zza(parcel, 10, searchAdRequestParcel.zzazw, false);
        zzb.zzc(parcel, 11, searchAdRequestParcel.zzazx);
        zzb.zza(parcel, 12, searchAdRequestParcel.zzazy, false);
        zzb.zzc(parcel, 13, searchAdRequestParcel.zzazz);
        zzb.zzc(parcel, 14, searchAdRequestParcel.zzbaa);
        zzb.zza(parcel, 15, searchAdRequestParcel.zzbab, false);
        zzb.zzaj(parcel, zzcr);
    }

    /* renamed from: zzg */
    public SearchAdRequestParcel createFromParcel(Parcel parcel) {
        int zzcq = zza.zzcq(parcel);
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        String str = null;
        int i10 = 0;
        String str2 = null;
        int i11 = 0;
        int i12 = 0;
        String str3 = null;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = zza.zzcp(parcel);
            switch (zza.zzgv(zzcp)) {
                case 1:
                    i = zza.zzg(parcel, zzcp);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzcp);
                    break;
                case 3:
                    i3 = zza.zzg(parcel, zzcp);
                    break;
                case 4:
                    i4 = zza.zzg(parcel, zzcp);
                    break;
                case 5:
                    i5 = zza.zzg(parcel, zzcp);
                    break;
                case 6:
                    i6 = zza.zzg(parcel, zzcp);
                    break;
                case 7:
                    i7 = zza.zzg(parcel, zzcp);
                    break;
                case 8:
                    i8 = zza.zzg(parcel, zzcp);
                    break;
                case 9:
                    i9 = zza.zzg(parcel, zzcp);
                    break;
                case 10:
                    str = zza.zzq(parcel, zzcp);
                    break;
                case 11:
                    i10 = zza.zzg(parcel, zzcp);
                    break;
                case 12:
                    str2 = zza.zzq(parcel, zzcp);
                    break;
                case 13:
                    i11 = zza.zzg(parcel, zzcp);
                    break;
                case 14:
                    i12 = zza.zzg(parcel, zzcp);
                    break;
                case 15:
                    str3 = zza.zzq(parcel, zzcp);
                    break;
                default:
                    zza.zzb(parcel, zzcp);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcq) {
            return new SearchAdRequestParcel(i, i2, i3, i4, i5, i6, i7, i8, i9, str, i10, str2, i11, i12, str3);
        }
        throw new zza.C1271zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcq).toString(), parcel);
    }

    /* renamed from: zzw */
    public SearchAdRequestParcel[] newArray(int i) {
        return new SearchAdRequestParcel[i];
    }
}
