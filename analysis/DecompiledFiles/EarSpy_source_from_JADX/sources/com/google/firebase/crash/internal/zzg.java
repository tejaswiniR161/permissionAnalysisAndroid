package com.google.firebase.crash.internal;

import android.content.Context;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzsu;
import com.google.firebase.crash.internal.zzd;
import com.google.firebase.crash.internal.zze;
import com.google.firebase.crash.internal.zzf;

public class zzg {
    private static zzg aVe;
    private zzsu aVd;

    public static class zza extends Exception {
        private zza(Throwable th) {
            super(th);
        }
    }

    private zzg() {
    }

    public static zzg zzcqp() {
        zzg zzg;
        synchronized (zzg.class) {
            if (aVe != null) {
                zzg = aVe;
            } else {
                aVe = new zzg();
                zzg = aVe;
            }
        }
        return zzg;
    }

    public void zzbr(Context context) throws zza {
        synchronized (zzg.class) {
            if (this.aVd == null) {
                try {
                    this.aVd = zzsu.zza(context, zzsu.f2245OA, "com.google.android.gms.crash");
                } catch (zzsu.zza e) {
                    throw new zza(e);
                }
            }
        }
    }

    public zzd zzcqq() throws zza {
        zzac.zzy(this.aVd);
        try {
            return zzd.zza.zzmi(this.aVd.zzjd("com.google.firebase.crash.internal.api.FirebaseCrashApiImpl"));
        } catch (zzsu.zza e) {
            throw new zza(e);
        }
    }

    public zze zzcqr() throws zza {
        zzac.zzy(this.aVd);
        try {
            return zze.zza.zzmj(this.aVd.zzjd("com.google.firebase.crash.internal.service.FirebaseCrashReceiverServiceImpl"));
        } catch (zzsu.zza e) {
            throw new zza(e);
        }
    }

    public zzf zzcqs() throws zza {
        zzac.zzy(this.aVd);
        try {
            return zzf.zza.zzmk(this.aVd.zzjd("com.google.firebase.crash.internal.service.FirebaseCrashSenderServiceImpl"));
        } catch (zzsu.zza e) {
            throw new zza(e);
        }
    }
}
