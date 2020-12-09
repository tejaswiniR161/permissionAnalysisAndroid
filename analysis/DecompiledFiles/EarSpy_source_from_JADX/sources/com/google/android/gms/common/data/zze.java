package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.ads.AdError;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Parcelable.Creator<DataHolder> {
    static void zza(DataHolder dataHolder, Parcel parcel, int i) {
        int zzcr = zzb.zzcr(parcel);
        zzb.zza(parcel, 1, dataHolder.zzatf(), false);
        zzb.zza(parcel, 2, (T[]) dataHolder.zzatg(), i, false);
        zzb.zzc(parcel, 3, dataHolder.getStatusCode());
        zzb.zza(parcel, 4, dataHolder.zzasz(), false);
        zzb.zzc(parcel, AdError.NETWORK_ERROR_CODE, dataHolder.getVersionCode());
        zzb.zzaj(parcel, zzcr);
    }

    /* renamed from: zzcg */
    public DataHolder createFromParcel(Parcel parcel) {
        int i = 0;
        Bundle bundle = null;
        int zzcq = zza.zzcq(parcel);
        CursorWindow[] cursorWindowArr = null;
        String[] strArr = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = zza.zzcp(parcel);
            switch (zza.zzgv(zzcp)) {
                case 1:
                    strArr = zza.zzac(parcel, zzcp);
                    break;
                case 2:
                    cursorWindowArr = (CursorWindow[]) zza.zzb(parcel, zzcp, CursorWindow.CREATOR);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzcp);
                    break;
                case 4:
                    bundle = zza.zzs(parcel, zzcp);
                    break;
                case AdError.NETWORK_ERROR_CODE:
                    i2 = zza.zzg(parcel, zzcp);
                    break;
                default:
                    zza.zzb(parcel, zzcp);
                    break;
            }
        }
        if (parcel.dataPosition() != zzcq) {
            throw new zza.C1271zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcq).toString(), parcel);
        }
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i, bundle);
        dataHolder.zzate();
        return dataHolder;
    }

    /* renamed from: zzge */
    public DataHolder[] newArray(int i) {
        return new DataHolder[i];
    }
}
