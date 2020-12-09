package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Parcelable.Creator<Configuration> {
    static void zza(Configuration configuration, Parcel parcel, int i) {
        int zzcr = zzb.zzcr(parcel);
        zzb.zzc(parcel, 1, configuration.mVersionCode);
        zzb.zzc(parcel, 2, configuration.axl);
        zzb.zza(parcel, 3, (T[]) configuration.axm, i, false);
        zzb.zza(parcel, 4, configuration.axn, false);
        zzb.zzaj(parcel, zzcr);
    }

    /* renamed from: zzrq */
    public Configuration createFromParcel(Parcel parcel) {
        String[] zzac;
        Flag[] flagArr;
        int i;
        int i2;
        String[] strArr = null;
        int i3 = 0;
        int zzcq = com.google.android.gms.common.internal.safeparcel.zza.zzcq(parcel);
        Flag[] flagArr2 = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = com.google.android.gms.common.internal.safeparcel.zza.zzcp(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzgv(zzcp)) {
                case 1:
                    String[] strArr2 = strArr;
                    flagArr = flagArr2;
                    i = i3;
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzcp);
                    zzac = strArr2;
                    break;
                case 2:
                    i2 = i4;
                    Flag[] flagArr3 = flagArr2;
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzcp);
                    zzac = strArr;
                    flagArr = flagArr3;
                    break;
                case 3:
                    i = i3;
                    i2 = i4;
                    String[] strArr3 = strArr;
                    flagArr = (Flag[]) com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzcp, Flag.CREATOR);
                    zzac = strArr3;
                    break;
                case 4:
                    zzac = com.google.android.gms.common.internal.safeparcel.zza.zzac(parcel, zzcp);
                    flagArr = flagArr2;
                    i = i3;
                    i2 = i4;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzcp);
                    zzac = strArr;
                    flagArr = flagArr2;
                    i = i3;
                    i2 = i4;
                    break;
            }
            i4 = i2;
            i3 = i;
            flagArr2 = flagArr;
            strArr = zzac;
        }
        if (parcel.dataPosition() == zzcq) {
            return new Configuration(i4, i3, flagArr2, strArr);
        }
        throw new zza.C1271zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcq).toString(), parcel);
    }

    /* renamed from: zzzi */
    public Configuration[] newArray(int i) {
        return new Configuration[i];
    }
}
