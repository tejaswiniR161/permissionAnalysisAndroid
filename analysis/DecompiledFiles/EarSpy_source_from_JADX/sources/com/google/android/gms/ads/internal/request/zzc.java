package com.google.android.gms.ads.internal.request;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.request.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.util.zzi;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzkt;
import com.google.android.gms.internal.zzlm;

@zziy
public final class zzc {

    public interface zza {
        void zzb(AdResponseParcel adResponseParcel);
    }

    interface zzb {
        boolean zza(VersionInfoParcel versionInfoParcel);
    }

    public static zzkt zza(final Context context, VersionInfoParcel versionInfoParcel, zzlm<AdRequestInfoParcel> zzlm, zza zza2) {
        return zza(context, versionInfoParcel, zzlm, zza2, new zzb() {
            public boolean zza(VersionInfoParcel versionInfoParcel) {
                return versionInfoParcel.zzctu || (zzi.zzcm(context) && !zzdi.zzbbv.get().booleanValue());
            }
        });
    }

    static zzkt zza(Context context, VersionInfoParcel versionInfoParcel, zzlm<AdRequestInfoParcel> zzlm, zza zza2, zzb zzb2) {
        return zzb2.zza(versionInfoParcel) ? zza(context, zzlm, zza2) : zzb(context, versionInfoParcel, zzlm, zza2);
    }

    private static zzkt zza(Context context, zzlm<AdRequestInfoParcel> zzlm, zza zza2) {
        zzkn.zzdd("Fetching ad response from local ad request service.");
        zzd.zza zza3 = new zzd.zza(context, zzlm, zza2);
        Void voidR = (Void) zza3.zzqw();
        return zza3;
    }

    private static zzkt zzb(Context context, VersionInfoParcel versionInfoParcel, zzlm<AdRequestInfoParcel> zzlm, zza zza2) {
        zzkn.zzdd("Fetching ad response from remote ad request service.");
        if (zzm.zzjr().zzas(context)) {
            return new zzd.zzb(context, versionInfoParcel, zzlm, zza2);
        }
        zzkn.zzdf("Failed to connect to remote ad request service.");
        return null;
    }
}
