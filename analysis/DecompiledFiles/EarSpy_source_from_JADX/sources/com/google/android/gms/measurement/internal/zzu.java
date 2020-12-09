package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.MainThread;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.measurement.AppMeasurement;

public final class zzu {
    static Boolean aqm;
    static Boolean aqn;
    private final zza aqo;

    public interface zza {
        void doStartService(Context context, Intent intent);
    }

    public zzu(zza zza2) {
        zzac.zzy(zza2);
        this.aqo = zza2;
    }

    public static boolean zzh(Context context, boolean z) {
        zzac.zzy(context);
        if (aqm != null && !z) {
            return aqm.booleanValue();
        }
        if (aqn != null && z) {
            return aqn.booleanValue();
        }
        boolean zza2 = zzal.zza(context, z ? "com.google.android.gms.measurement.PackageMeasurementReceiver" : "com.google.android.gms.measurement.AppMeasurementReceiver", false);
        if (z) {
            aqn = Boolean.valueOf(zza2);
            return zza2;
        }
        aqm = Boolean.valueOf(zza2);
        return zza2;
    }

    @MainThread
    public void onReceive(Context context, Intent intent) {
        final zzx zzdt = zzx.zzdt(context);
        final zzp zzbvg = zzdt.zzbvg();
        if (intent == null) {
            zzbvg.zzbwe().log("Receiver called with null intent");
            return;
        }
        boolean zzact = zzdt.zzbvi().zzact();
        String action = intent.getAction();
        if (zzact) {
            zzbvg.zzbwj().zzj("Device receiver got", action);
        } else {
            zzbvg.zzbwj().zzj("Local receiver got", action);
        }
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zzae.zzi(context, zzact && !zzdt.zzbxg());
            Intent className = new Intent().setClassName(context, (!zzact || zzdt.zzbxg()) ? "com.google.android.gms.measurement.AppMeasurementService" : "com.google.android.gms.measurement.PackageMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            this.aqo.doStartService(context, className);
        } else if (!zzact && "com.android.vending.INSTALL_REFERRER".equals(action)) {
            String stringExtra = intent.getStringExtra("referrer");
            if (stringExtra == null) {
                zzbvg.zzbwj().log("Install referrer extras are null");
                return;
            }
            final Bundle zzt = zzdt.zzbvc().zzt(Uri.parse(stringExtra));
            if (zzt == null) {
                zzbvg.zzbwj().log("No campaign defined in install referrer broadcast");
                return;
            }
            final long longExtra = 1000 * intent.getLongExtra("referrer_timestamp_seconds", 0);
            if (longExtra == 0) {
                zzbvg.zzbwe().log("Install referrer is missing timestamp");
            }
            final Context context2 = context;
            zzdt.zzbvf().zzm(new Runnable() {
                public void run() {
                    zzak zzas = zzdt.zzbvb().zzas(zzdt.zzbuy().zzti(), "_fot");
                    long longValue = (zzas == null || !(zzas.zzctv instanceof Long)) ? 0 : ((Long) zzas.zzctv).longValue();
                    long j = longExtra;
                    long j2 = (longValue <= 0 || (j < longValue && j > 0)) ? j : longValue - 1;
                    if (j2 > 0) {
                        zzt.putLong("click_timestamp", j2);
                    }
                    AppMeasurement.getInstance(context2).zze("auto", "_cmp", zzt);
                    zzbvg.zzbwj().log("Install campaign recorded");
                }
            });
        }
    }
}
