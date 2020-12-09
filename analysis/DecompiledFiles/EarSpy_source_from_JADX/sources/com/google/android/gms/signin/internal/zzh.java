package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Parcelable.Creator<SignInRequest> {
    static void zza(SignInRequest signInRequest, Parcel parcel, int i) {
        int zzcr = zzb.zzcr(parcel);
        zzb.zzc(parcel, 1, signInRequest.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) signInRequest.zzcdk(), i, false);
        zzb.zzaj(parcel, zzcr);
    }

    /* renamed from: zzaah */
    public SignInRequest[] newArray(int i) {
        return new SignInRequest[i];
    }

    /* renamed from: zzsm */
    public SignInRequest createFromParcel(Parcel parcel) {
        int zzcq = zza.zzcq(parcel);
        int i = 0;
        ResolveAccountRequest resolveAccountRequest = null;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = zza.zzcp(parcel);
            switch (zza.zzgv(zzcp)) {
                case 1:
                    i = zza.zzg(parcel, zzcp);
                    break;
                case 2:
                    resolveAccountRequest = (ResolveAccountRequest) zza.zza(parcel, zzcp, ResolveAccountRequest.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzcp);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcq) {
            return new SignInRequest(i, resolveAccountRequest);
        }
        throw new zza.C1271zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcq).toString(), parcel);
    }
}
