package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

@zziy
public class zzhi {
    private final zzlt zzbkr;
    private final boolean zzbvj;
    private final String zzbvk;

    public zzhi(zzlt zzlt, Map<String, String> map) {
        this.zzbkr = zzlt;
        this.zzbvk = map.get("forceOrientation");
        if (map.containsKey("allowOrientationChange")) {
            this.zzbvj = Boolean.parseBoolean(map.get("allowOrientationChange"));
        } else {
            this.zzbvj = true;
        }
    }

    public void execute() {
        if (this.zzbkr == null) {
            zzkn.zzdf("AdWebView is null");
        } else {
            this.zzbkr.setRequestedOrientation("portrait".equalsIgnoreCase(this.zzbvk) ? zzu.zzgb().zzun() : "landscape".equalsIgnoreCase(this.zzbvk) ? zzu.zzgb().zzum() : this.zzbvj ? -1 : zzu.zzgb().zzuo());
        }
    }
}
