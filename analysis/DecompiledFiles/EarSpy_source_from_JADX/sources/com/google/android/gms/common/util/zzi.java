package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

public final class zzi {

    /* renamed from: EL */
    private static Boolean f1853EL;

    /* renamed from: EM */
    private static Boolean f1854EM;

    /* renamed from: EN */
    private static Boolean f1855EN;

    /* renamed from: EO */
    private static Boolean f1856EO;

    public static boolean zzb(Resources resources) {
        boolean z = false;
        if (resources == null) {
            return false;
        }
        if (f1853EL == null) {
            boolean z2 = (resources.getConfiguration().screenLayout & 15) > 3;
            if ((zzs.zzaxk() && z2) || zzc(resources)) {
                z = true;
            }
            f1853EL = Boolean.valueOf(z);
        }
        return f1853EL.booleanValue();
    }

    @TargetApi(13)
    private static boolean zzc(Resources resources) {
        if (f1854EM == null) {
            Configuration configuration = resources.getConfiguration();
            f1854EM = Boolean.valueOf(zzs.zzaxm() && (configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600);
        }
        return f1854EM.booleanValue();
    }

    @TargetApi(20)
    public static boolean zzcl(Context context) {
        if (f1855EN == null) {
            f1855EN = Boolean.valueOf(zzs.zzaxs() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return f1855EN.booleanValue();
    }

    @TargetApi(21)
    public static boolean zzcm(Context context) {
        if (f1856EO == null) {
            f1856EO = Boolean.valueOf(zzs.zzaxu() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f1856EO.booleanValue();
    }
}
