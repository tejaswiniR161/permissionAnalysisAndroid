package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.zzd;
import com.google.android.gms.internal.zzsi;

public class zzf {

    /* renamed from: vf */
    private static zzf f1893vf;
    private final Context mContext;

    private zzf(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private boolean zzb(PackageInfo packageInfo, boolean z) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return false;
        }
        zzd.zzb zzb = new zzd.zzb(packageInfo.signatures[0].toByteArray());
        for (zzt equals : z ? zzd.zzapf() : zzd.zzapg()) {
            if (zzb.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public static zzf zzbz(Context context) {
        zzac.zzy(context);
        synchronized (zzf.class) {
            if (f1893vf == null) {
                zzd.zzbr(context);
                f1893vf = new zzf(context);
            }
        }
        return f1893vf;
    }

    /* access modifiers changed from: package-private */
    public zzd.zza zza(PackageInfo packageInfo, zzd.zza... zzaArr) {
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zzd.zzb zzb = new zzd.zzb(packageInfo.signatures[0].toByteArray());
        for (int i = 0; i < zzaArr.length; i++) {
            if (zzaArr[i].equals(zzb)) {
                return zzaArr[i];
            }
        }
        return null;
    }

    public boolean zza(PackageInfo packageInfo, boolean z) {
        zzd.zza zza;
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            if (z) {
                zza = zza(packageInfo, zzd.C1281zzd.f1884uW);
            } else {
                zza = zza(packageInfo, zzd.C1281zzd.f1884uW[0]);
            }
            if (zza != null) {
                return true;
            }
        }
        return false;
    }

    public boolean zza(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zze.zzbv(this.mContext)) {
            return zzb(packageInfo, true);
        }
        boolean zzb = zzb(packageInfo, false);
        if (zzb || !zzb(packageInfo, true)) {
            return zzb;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return zzb;
    }

    public boolean zzb(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zza(packageInfo, false)) {
            return true;
        }
        if (!zza(packageInfo, true)) {
            return false;
        }
        if (zze.zzbv(this.mContext)) {
            return true;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return false;
    }

    public boolean zzb(PackageManager packageManager, String str) {
        try {
            return zza(packageManager, zzsi.zzcr(this.mContext).getPackageInfo(str, 64));
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
