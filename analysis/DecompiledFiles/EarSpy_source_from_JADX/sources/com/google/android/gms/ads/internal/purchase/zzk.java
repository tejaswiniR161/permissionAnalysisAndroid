package com.google.android.gms.ads.internal.purchase;

import android.content.Intent;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzkn;

@zziy
public class zzk {
    private final String zzazb;

    public zzk(String str) {
        this.zzazb = str;
    }

    public boolean zza(String str, int i, Intent intent) {
        if (str == null || intent == null) {
            return false;
        }
        String zze = zzu.zzgn().zze(intent);
        String zzf = zzu.zzgn().zzf(intent);
        if (zze == null || zzf == null) {
            return false;
        }
        if (!str.equals(zzu.zzgn().zzcc(zze))) {
            zzkn.zzdf("Developer payload not match.");
            return false;
        } else if (this.zzazb == null || zzl.zzc(this.zzazb, zze, zzf)) {
            return true;
        } else {
            zzkn.zzdf("Fail to verify signature.");
            return false;
        }
    }

    public String zzqs() {
        return zzu.zzfz().zzui();
    }
}
