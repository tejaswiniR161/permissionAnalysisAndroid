package com.google.android.gms.internal;

import java.util.Map;

@zziy
public final class zzeq implements zzev {
    private final zzer zzbma;

    public zzeq(zzer zzer) {
        this.zzbma = zzer;
    }

    public void zza(zzlt zzlt, Map<String, String> map) {
        String str = map.get("name");
        if (str == null) {
            zzkn.zzdf("App event with no name parameter.");
        } else {
            this.zzbma.onAppEvent(str, map.get("info"));
        }
    }
}
