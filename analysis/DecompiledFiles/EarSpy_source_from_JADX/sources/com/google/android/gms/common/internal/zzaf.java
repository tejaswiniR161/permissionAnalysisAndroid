package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzaf implements Parcelable.Creator<SignInButtonConfig> {
    static void zza(SignInButtonConfig signInButtonConfig, Parcel parcel, int i) {
        int zzcr = zzb.zzcr(parcel);
        zzb.zzc(parcel, 1, signInButtonConfig.mVersionCode);
        zzb.zzc(parcel, 2, signInButtonConfig.zzavh());
        zzb.zzc(parcel, 3, signInButtonConfig.zzavi());
        zzb.zza(parcel, 4, (T[]) signInButtonConfig.zzavj(), i, false);
        zzb.zzaj(parcel, zzcr);
    }

    /* renamed from: zzcn */
    public SignInButtonConfig createFromParcel(Parcel parcel) {
        int i = 0;
        int zzcq = zza.zzcq(parcel);
        Scope[] scopeArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = zza.zzcp(parcel);
            switch (zza.zzgv(zzcp)) {
                case 1:
                    i3 = zza.zzg(parcel, zzcp);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzcp);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzcp);
                    break;
                case 4:
                    scopeArr = (Scope[]) zza.zzb(parcel, zzcp, Scope.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzcp);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcq) {
            return new SignInButtonConfig(i3, i2, i, scopeArr);
        }
        throw new zza.C1271zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcq).toString(), parcel);
    }

    /* renamed from: zzgt */
    public SignInButtonConfig[] newArray(int i) {
        return new SignInButtonConfig[i];
    }
}
