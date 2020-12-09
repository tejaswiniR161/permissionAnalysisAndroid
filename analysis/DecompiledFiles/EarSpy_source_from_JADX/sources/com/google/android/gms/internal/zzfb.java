package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.common.util.zzf;
import java.util.Map;

@zziy
public class zzfb implements zzev {
    static final Map<String, Integer> zzbnn = zzf.zza("resize", 1, "playVideo", 2, "storePicture", 3, "createCalendarEvent", 4, "setOrientationProperties", 5, "closeResizedAd", 6);
    private final zze zzbnl;
    private final zzhh zzbnm;

    public zzfb(zze zze, zzhh zzhh) {
        this.zzbnl = zze;
        this.zzbnm = zzhh;
    }

    public void zza(zzlt zzlt, Map<String, String> map) {
        int intValue = zzbnn.get(map.get("a")).intValue();
        if (intValue == 5 || this.zzbnl == null || this.zzbnl.zzer()) {
            switch (intValue) {
                case 1:
                    this.zzbnm.execute(map);
                    return;
                case 3:
                    new zzhj(zzlt, map).execute();
                    return;
                case 4:
                    new zzhg(zzlt, map).execute();
                    return;
                case 5:
                    new zzhi(zzlt, map).execute();
                    return;
                case 6:
                    this.zzbnm.zzt(true);
                    return;
                default:
                    zzkn.zzde("Unknown MRAID command called.");
                    return;
            }
        } else {
            this.zzbnl.zzv((String) null);
        }
    }
}
