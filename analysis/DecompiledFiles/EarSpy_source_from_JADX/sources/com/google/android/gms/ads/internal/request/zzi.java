package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;

public class zzi implements Parcelable.Creator<AutoClickProtectionConfigurationParcel> {
    static void zza(AutoClickProtectionConfigurationParcel autoClickProtectionConfigurationParcel, Parcel parcel, int i) {
        int zzcr = zzb.zzcr(parcel);
        zzb.zzc(parcel, 1, autoClickProtectionConfigurationParcel.versionCode);
        zzb.zza(parcel, 2, autoClickProtectionConfigurationParcel.zzchz);
        zzb.zzb(parcel, 3, autoClickProtectionConfigurationParcel.zzcia, false);
        zzb.zzaj(parcel, zzcr);
    }

    /* renamed from: zzas */
    public AutoClickProtectionConfigurationParcel[] newArray(int i) {
        return new AutoClickProtectionConfigurationParcel[i];
    }

    /* renamed from: zzo */
    public AutoClickProtectionConfigurationParcel createFromParcel(Parcel parcel) {
        boolean z = false;
        int zzcq = zza.zzcq(parcel);
        ArrayList<String> arrayList = null;
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
                    arrayList = zza.zzae(parcel, zzcp);
                    break;
                default:
                    zza.zzb(parcel, zzcp);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcq) {
            return new AutoClickProtectionConfigurationParcel(i, z, arrayList);
        }
        throw new zza.C1271zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcq).toString(), parcel);
    }
}
