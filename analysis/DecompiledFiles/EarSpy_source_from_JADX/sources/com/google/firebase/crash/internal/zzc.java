package com.google.firebase.crash.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Parcelable.Creator<FirebaseCrashOptions> {
    static void zza(FirebaseCrashOptions firebaseCrashOptions, Parcel parcel, int i) {
        int zzcr = zzb.zzcr(parcel);
        zzb.zzc(parcel, 1, firebaseCrashOptions.mVersionCode);
        zzb.zza(parcel, 2, firebaseCrashOptions.zzcqo(), false);
        zzb.zza(parcel, 3, firebaseCrashOptions.getApiKey(), false);
        zzb.zzaj(parcel, zzcr);
    }

    /* renamed from: zzaga */
    public FirebaseCrashOptions[] newArray(int i) {
        return new FirebaseCrashOptions[i];
    }

    /* renamed from: zzwy */
    public FirebaseCrashOptions createFromParcel(Parcel parcel) {
        String str = null;
        int zzcq = zza.zzcq(parcel);
        int i = 0;
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
                    str = zza.zzq(parcel, zzcp);
                    break;
                default:
                    zza.zzb(parcel, zzcp);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcq) {
            return new FirebaseCrashOptions(i, str2, str);
        }
        throw new zza.C1271zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcq).toString(), parcel);
    }
}
