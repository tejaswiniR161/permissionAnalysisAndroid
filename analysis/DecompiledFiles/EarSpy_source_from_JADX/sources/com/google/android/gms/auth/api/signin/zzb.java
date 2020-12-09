package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import java.util.ArrayList;

public class zzb implements Parcelable.Creator<GoogleSignInOptions> {
    static void zza(GoogleSignInOptions googleSignInOptions, Parcel parcel, int i) {
        int zzcr = com.google.android.gms.common.internal.safeparcel.zzb.zzcr(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, googleSignInOptions.versionCode);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, googleSignInOptions.zzahj(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, (Parcelable) googleSignInOptions.getAccount(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, googleSignInOptions.zzahk());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 5, googleSignInOptions.zzahl());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 6, googleSignInOptions.zzahm());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, googleSignInOptions.zzahn(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, googleSignInOptions.zzaho(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, zzcr);
    }

    /* renamed from: zzaw */
    public GoogleSignInOptions createFromParcel(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzcq = zza.zzcq(parcel);
        String str2 = null;
        boolean z2 = false;
        boolean z3 = false;
        Account account = null;
        ArrayList<Scope> arrayList = null;
        int i = 0;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = zza.zzcp(parcel);
            switch (zza.zzgv(zzcp)) {
                case 1:
                    i = zza.zzg(parcel, zzcp);
                    break;
                case 2:
                    arrayList = zza.zzc(parcel, zzcp, Scope.CREATOR);
                    break;
                case 3:
                    account = (Account) zza.zza(parcel, zzcp, Account.CREATOR);
                    break;
                case 4:
                    z3 = zza.zzc(parcel, zzcp);
                    break;
                case 5:
                    z2 = zza.zzc(parcel, zzcp);
                    break;
                case 6:
                    z = zza.zzc(parcel, zzcp);
                    break;
                case 7:
                    str2 = zza.zzq(parcel, zzcp);
                    break;
                case 8:
                    str = zza.zzq(parcel, zzcp);
                    break;
                default:
                    zza.zzb(parcel, zzcp);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcq) {
            return new GoogleSignInOptions(i, arrayList, account, z3, z2, z, str2, str);
        }
        throw new zza.C1271zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcq).toString(), parcel);
    }

    /* renamed from: zzdh */
    public GoogleSignInOptions[] newArray(int i) {
        return new GoogleSignInOptions[i];
    }
}
