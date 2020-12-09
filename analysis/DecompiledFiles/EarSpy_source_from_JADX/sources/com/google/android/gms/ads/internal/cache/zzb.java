package com.google.android.gms.ads.internal.cache;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Parcelable.Creator<CacheEntryParcel> {
    static void zza(CacheEntryParcel cacheEntryParcel, Parcel parcel, int i) {
        int zzcr = com.google.android.gms.common.internal.safeparcel.zzb.zzcr(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, cacheEntryParcel.version);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, (Parcelable) cacheEntryParcel.zziw(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, zzcr);
    }

    /* renamed from: zzc */
    public CacheEntryParcel createFromParcel(Parcel parcel) {
        int zzcq = zza.zzcq(parcel);
        int i = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = zza.zzcp(parcel);
            switch (zza.zzgv(zzcp)) {
                case 1:
                    i = zza.zzg(parcel, zzcp);
                    break;
                case 2:
                    parcelFileDescriptor = (ParcelFileDescriptor) zza.zza(parcel, zzcp, ParcelFileDescriptor.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzcp);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcq) {
            return new CacheEntryParcel(i, parcelFileDescriptor);
        }
        throw new zza.C1271zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcq).toString(), parcel);
    }

    /* renamed from: zzr */
    public CacheEntryParcel[] newArray(int i) {
        return new CacheEntryParcel[i];
    }
}
