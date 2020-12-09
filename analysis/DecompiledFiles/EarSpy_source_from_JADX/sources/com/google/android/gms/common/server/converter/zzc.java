package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.server.converter.StringToIntConverter;

public class zzc implements Parcelable.Creator<StringToIntConverter.Entry> {
    static void zza(StringToIntConverter.Entry entry, Parcel parcel, int i) {
        int zzcr = zzb.zzcr(parcel);
        zzb.zzc(parcel, 1, entry.versionCode);
        zzb.zza(parcel, 2, entry.f1773Dr, false);
        zzb.zzc(parcel, 3, entry.f1774Ds);
        zzb.zzaj(parcel, zzcr);
    }

    /* renamed from: zzcv */
    public StringToIntConverter.Entry createFromParcel(Parcel parcel) {
        int i = 0;
        int zzcq = zza.zzcq(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = zza.zzcp(parcel);
            switch (zza.zzgv(zzcp)) {
                case 1:
                    i2 = zza.zzg(parcel, zzcp);
                    break;
                case 2:
                    str = zza.zzq(parcel, zzcp);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzcp);
                    break;
                default:
                    zza.zzb(parcel, zzcp);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcq) {
            return new StringToIntConverter.Entry(i2, str, i);
        }
        throw new zza.C1271zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcq).toString(), parcel);
    }

    /* renamed from: zzha */
    public StringToIntConverter.Entry[] newArray(int i) {
        return new StringToIntConverter.Entry[i];
    }
}
