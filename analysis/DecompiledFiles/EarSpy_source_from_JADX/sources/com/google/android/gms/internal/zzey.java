package com.google.android.gms.internal;

import java.util.Map;

@zziy
public class zzey implements zzev {
    private final zzez zzbnj;

    public zzey(zzez zzez) {
        this.zzbnj = zzez;
    }

    public void zza(zzlt zzlt, Map<String, String> map) {
        float f;
        boolean equals = "1".equals(map.get("transparentBackground"));
        boolean equals2 = "1".equals(map.get("blur"));
        try {
            if (map.get("blurRadius") != null) {
                f = Float.parseFloat(map.get("blurRadius"));
                this.zzbnj.zzg(equals);
                this.zzbnj.zza(equals2, f);
            }
        } catch (NumberFormatException e) {
            zzkn.zzb("Fail to parse float", e);
        }
        f = 0.0f;
        this.zzbnj.zzg(equals);
        this.zzbnj.zza(equals2, f);
    }
}
