package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.reward.client.zzf;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzho;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zziy;

@zziy
public class zzm {
    private static final Object zzaok = new Object();
    private static zzm zzayd;
    private final zza zzaye = new zza();
    private final zzl zzayf = new zzl(new zze(), new zzd(), new zzai(), new zzel(), new zzf(), new zzid(), new zzho());

    static {
        zza(new zzm());
    }

    protected zzm() {
    }

    protected static void zza(zzm zzm) {
        synchronized (zzaok) {
            zzayd = zzm;
        }
    }

    private static zzm zzjq() {
        zzm zzm;
        synchronized (zzaok) {
            zzm = zzayd;
        }
        return zzm;
    }

    public static zza zzjr() {
        return zzjq().zzaye;
    }

    public static zzl zzjs() {
        return zzjq().zzayf;
    }
}
