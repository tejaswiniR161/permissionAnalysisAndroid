package com.google.android.gms.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.playlog.internal.PlayLoggerContext;

public class zzd implements Parcelable.Creator<LogEventParcelable> {
    static void zza(LogEventParcelable logEventParcelable, Parcel parcel, int i) {
        int zzcr = zzb.zzcr(parcel);
        zzb.zzc(parcel, 1, logEventParcelable.versionCode);
        zzb.zza(parcel, 2, (Parcelable) logEventParcelable.f1453uc, i, false);
        zzb.zza(parcel, 3, logEventParcelable.f1454ud, false);
        zzb.zza(parcel, 4, logEventParcelable.f1455ue, false);
        zzb.zza(parcel, 5, logEventParcelable.f1456uf, false);
        zzb.zza(parcel, 6, logEventParcelable.f1457ug, false);
        zzb.zza(parcel, 7, logEventParcelable.f1458uh, false);
        zzb.zza(parcel, 8, logEventParcelable.f1459ui);
        zzb.zzaj(parcel, zzcr);
    }

    /* renamed from: zzcb */
    public LogEventParcelable createFromParcel(Parcel parcel) {
        byte[][] bArr = null;
        int zzcq = zza.zzcq(parcel);
        int i = 0;
        boolean z = true;
        int[] iArr = null;
        String[] strArr = null;
        int[] iArr2 = null;
        byte[] bArr2 = null;
        PlayLoggerContext playLoggerContext = null;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = zza.zzcp(parcel);
            switch (zza.zzgv(zzcp)) {
                case 1:
                    i = zza.zzg(parcel, zzcp);
                    break;
                case 2:
                    playLoggerContext = (PlayLoggerContext) zza.zza(parcel, zzcp, PlayLoggerContext.CREATOR);
                    break;
                case 3:
                    bArr2 = zza.zzt(parcel, zzcp);
                    break;
                case 4:
                    iArr2 = zza.zzw(parcel, zzcp);
                    break;
                case 5:
                    strArr = zza.zzac(parcel, zzcp);
                    break;
                case 6:
                    iArr = zza.zzw(parcel, zzcp);
                    break;
                case 7:
                    bArr = zza.zzu(parcel, zzcp);
                    break;
                case 8:
                    z = zza.zzc(parcel, zzcp);
                    break;
                default:
                    zza.zzb(parcel, zzcp);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcq) {
            return new LogEventParcelable(i, playLoggerContext, bArr2, iArr2, strArr, iArr, bArr, z);
        }
        throw new zza.C1271zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcq).toString(), parcel);
    }

    /* renamed from: zzfj */
    public LogEventParcelable[] newArray(int i) {
        return new LogEventParcelable[i];
    }
}
