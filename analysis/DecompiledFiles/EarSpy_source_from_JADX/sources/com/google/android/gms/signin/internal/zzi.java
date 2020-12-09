package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzi implements Parcelable.Creator<SignInResponse> {
    static void zza(SignInResponse signInResponse, Parcel parcel, int i) {
        int zzcr = zzb.zzcr(parcel);
        zzb.zzc(parcel, 1, signInResponse.mVersionCode);
        zzb.zza(parcel, 2, (Parcelable) signInResponse.zzave(), i, false);
        zzb.zza(parcel, 3, (Parcelable) signInResponse.zzcdl(), i, false);
        zzb.zzaj(parcel, zzcr);
    }

    /* renamed from: zzaai */
    public SignInResponse[] newArray(int i) {
        return new SignInResponse[i];
    }

    /* renamed from: zzsn */
    public SignInResponse createFromParcel(Parcel parcel) {
        ResolveAccountResponse resolveAccountResponse;
        ConnectionResult connectionResult;
        int i;
        ResolveAccountResponse resolveAccountResponse2 = null;
        int zzcq = zza.zzcq(parcel);
        int i2 = 0;
        ConnectionResult connectionResult2 = null;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = zza.zzcp(parcel);
            switch (zza.zzgv(zzcp)) {
                case 1:
                    ResolveAccountResponse resolveAccountResponse3 = resolveAccountResponse2;
                    connectionResult = connectionResult2;
                    i = zza.zzg(parcel, zzcp);
                    resolveAccountResponse = resolveAccountResponse3;
                    break;
                case 2:
                    i = i2;
                    ConnectionResult connectionResult3 = (ConnectionResult) zza.zza(parcel, zzcp, ConnectionResult.CREATOR);
                    resolveAccountResponse = resolveAccountResponse2;
                    connectionResult = connectionResult3;
                    break;
                case 3:
                    resolveAccountResponse = (ResolveAccountResponse) zza.zza(parcel, zzcp, ResolveAccountResponse.CREATOR);
                    connectionResult = connectionResult2;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzcp);
                    resolveAccountResponse = resolveAccountResponse2;
                    connectionResult = connectionResult2;
                    i = i2;
                    break;
            }
            i2 = i;
            connectionResult2 = connectionResult;
            resolveAccountResponse2 = resolveAccountResponse;
        }
        if (parcel.dataPosition() == zzcq) {
            return new SignInResponse(i2, connectionResult2, resolveAccountResponse2);
        }
        throw new zza.C1271zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcq).toString(), parcel);
    }
}
