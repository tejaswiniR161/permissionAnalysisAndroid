package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.zzc;
import java.util.Map;
import java.util.concurrent.Future;

@zziy
public class zzfk implements zzev {
    public void zza(zzlt zzlt, Map<String, String> map) {
        int i;
        zzfi zzgw = zzu.zzgw();
        if (!map.containsKey("abort")) {
            String str = map.get("src");
            if (str == null) {
                zzkn.zzdf("Precache video action is missing the src parameter.");
                return;
            }
            try {
                i = Integer.parseInt(map.get("player"));
            } catch (NumberFormatException e) {
                i = 0;
            }
            String str2 = map.containsKey("mimetype") ? map.get("mimetype") : "";
            if (zzgw.zzf(zzlt)) {
                zzkn.zzdf("Precache task already running.");
                return;
            }
            zzc.zzu(zzlt.zzdp());
            Future future = (Future) new zzfh(zzlt, zzlt.zzdp().zzamc.zza(zzlt, i, str2), str).zzqw();
        } else if (!zzgw.zze(zzlt)) {
            zzkn.zzdf("Precache abort but no preload task running.");
        }
    }
}
