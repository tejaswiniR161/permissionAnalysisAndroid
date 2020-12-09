package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zzch;

public final class zzcf extends zzg<zzch> {
    private static final zzcf zzakm = new zzcf();

    private zzcf() {
        super("com.google.android.gms.ads.adshield.AdShieldCreatorImpl");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = zzakm.zzc(r1, r2, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.zzcg zzb(java.lang.String r1, android.content.Context r2, boolean r3) {
        /*
            com.google.android.gms.common.zzc r0 = com.google.android.gms.common.zzc.zzapd()
            int r0 = r0.isGooglePlayServicesAvailable(r2)
            if (r0 != 0) goto L_0x0012
            com.google.android.gms.internal.zzcf r0 = zzakm
            com.google.android.gms.internal.zzcg r0 = r0.zzc(r1, r2, r3)
            if (r0 != 0) goto L_0x0017
        L_0x0012:
            com.google.android.gms.internal.zzce r0 = new com.google.android.gms.internal.zzce
            r0.<init>(r1, r2, r3)
        L_0x0017:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzcf.zzb(java.lang.String, android.content.Context, boolean):com.google.android.gms.internal.zzcg");
    }

    private zzcg zzc(String str, Context context, boolean z) {
        IBinder zzb;
        zzd zzac = zze.zzac(context);
        if (z) {
            try {
                zzb = ((zzch) zzcu(context)).zza(str, zzac);
            } catch (RemoteException | zzg.zza e) {
                return null;
            }
        } else {
            zzb = ((zzch) zzcu(context)).zzb(str, zzac);
        }
        return zzcg.zza.zzd(zzb);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzb */
    public zzch zzc(IBinder iBinder) {
        return zzch.zza.zze(iBinder);
    }
}
