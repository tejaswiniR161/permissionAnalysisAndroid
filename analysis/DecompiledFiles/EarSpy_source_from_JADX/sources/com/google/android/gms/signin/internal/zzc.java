package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzc implements Parcelable.Creator<CheckServerAuthResult> {
    static void zza(CheckServerAuthResult checkServerAuthResult, Parcel parcel, int i) {
        int zzcr = zzb.zzcr(parcel);
        zzb.zzc(parcel, 1, checkServerAuthResult.mVersionCode);
        zzb.zza(parcel, 2, checkServerAuthResult.aAh);
        zzb.zzc(parcel, 3, checkServerAuthResult.aAi, false);
        zzb.zzaj(parcel, zzcr);
    }

    /* renamed from: zzaae */
    public CheckServerAuthResult[] newArray(int i) {
        return new CheckServerAuthResult[i];
    }

    /* renamed from: zzsk */
    public CheckServerAuthResult createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzcq = zza.zzcq(parcel);
        ArrayList<Scope> arrayList = null;
        int i = 0;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = zza.zzcp(parcel);
            switch (zza.zzgv(zzcp)) {
                case 1:
                    i = zza.zzg(parcel, zzcp);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzcp);
                    break;
                case 3:
                    arrayList = zza.zzc(parcel, zzcp, Scope.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzcp);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcq) {
            return new CheckServerAuthResult(i, z, arrayList);
        }
        throw new zza.C1271zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcq).toString(), parcel);
    }
}
