package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzk implements Parcelable.Creator<GetServiceRequest> {
    static void zza(GetServiceRequest getServiceRequest, Parcel parcel, int i) {
        int zzcr = zzb.zzcr(parcel);
        zzb.zzc(parcel, 1, getServiceRequest.version);
        zzb.zzc(parcel, 2, getServiceRequest.f1632Ci);
        zzb.zzc(parcel, 3, getServiceRequest.f1633Cj);
        zzb.zza(parcel, 4, getServiceRequest.f1634Ck, false);
        zzb.zza(parcel, 5, getServiceRequest.f1635Cl, false);
        zzb.zza(parcel, 6, (T[]) getServiceRequest.f1636Cm, i, false);
        zzb.zza(parcel, 7, getServiceRequest.f1637Cn, false);
        zzb.zza(parcel, 8, (Parcelable) getServiceRequest.f1638Co, i, false);
        zzb.zza(parcel, 9, getServiceRequest.f1639Cp);
        zzb.zzaj(parcel, zzcr);
    }

    /* renamed from: zzck */
    public GetServiceRequest createFromParcel(Parcel parcel) {
        int i = 0;
        Account account = null;
        int zzcq = zza.zzcq(parcel);
        long j = 0;
        Bundle bundle = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        String str = null;
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
                    str = zza.zzq(parcel, zzcp);
                    break;
                case 5:
                    iBinder = zza.zzr(parcel, zzcp);
                    break;
                case 6:
                    scopeArr = (Scope[]) zza.zzb(parcel, zzcp, Scope.CREATOR);
                    break;
                case 7:
                    bundle = zza.zzs(parcel, zzcp);
                    break;
                case 8:
                    account = (Account) zza.zza(parcel, zzcp, Account.CREATOR);
                    break;
                case 9:
                    j = zza.zzi(parcel, zzcp);
                    break;
                default:
                    zza.zzb(parcel, zzcp);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcq) {
            return new GetServiceRequest(i3, i2, i, str, iBinder, scopeArr, bundle, account, j);
        }
        throw new zza.C1271zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcq).toString(), parcel);
    }

    /* renamed from: zzgn */
    public GetServiceRequest[] newArray(int i) {
        return new GetServiceRequest[i];
    }
}
