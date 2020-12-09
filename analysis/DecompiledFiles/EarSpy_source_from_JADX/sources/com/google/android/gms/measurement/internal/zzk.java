package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk implements Parcelable.Creator<EventParcel> {
    static void zza(EventParcel eventParcel, Parcel parcel, int i) {
        int zzcr = zzb.zzcr(parcel);
        zzb.zzc(parcel, 1, eventParcel.versionCode);
        zzb.zza(parcel, 2, eventParcel.name, false);
        zzb.zza(parcel, 3, (Parcelable) eventParcel.aoz, i, false);
        zzb.zza(parcel, 4, eventParcel.aoA, false);
        zzb.zza(parcel, 5, eventParcel.aoB);
        zzb.zzaj(parcel, zzcr);
    }

    /* renamed from: zzpg */
    public EventParcel createFromParcel(Parcel parcel) {
        String str = null;
        int zzcq = zza.zzcq(parcel);
        int i = 0;
        long j = 0;
        EventParams eventParams = null;
        String str2 = null;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = zza.zzcp(parcel);
            switch (zza.zzgv(zzcp)) {
                case 1:
                    i = zza.zzg(parcel, zzcp);
                    break;
                case 2:
                    str2 = zza.zzq(parcel, zzcp);
                    break;
                case 3:
                    eventParams = (EventParams) zza.zza(parcel, zzcp, EventParams.CREATOR);
                    break;
                case 4:
                    str = zza.zzq(parcel, zzcp);
                    break;
                case 5:
                    j = zza.zzi(parcel, zzcp);
                    break;
                default:
                    zza.zzb(parcel, zzcp);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcq) {
            return new EventParcel(i, str2, eventParams, str, j);
        }
        throw new zza.C1271zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcq).toString(), parcel);
    }

    /* renamed from: zzwm */
    public EventParcel[] newArray(int i) {
        return new EventParcel[i];
    }
}
