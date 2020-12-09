package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

@zziy
class zzfg implements zzev {
    zzfg() {
    }

    private int zzg(Map<String, String> map) throws NullPointerException, NumberFormatException {
        int parseInt = Integer.parseInt(map.get("playbackState"));
        if (parseInt < 0 || 3 < parseInt) {
            return 0;
        }
        return parseInt;
    }

    public void zza(zzlt zzlt, Map<String, String> map) {
        zzly zzly;
        if (zzdi.zzbef.get().booleanValue()) {
            zzly zzwb = zzlt.zzwb();
            if (zzwb == null) {
                try {
                    zzly zzly2 = new zzly(zzlt, Float.parseFloat(map.get("duration")));
                    zzlt.zza(zzly2);
                    zzly = zzly2;
                } catch (NullPointerException | NumberFormatException e) {
                    zzkn.zzb("Unable to parse videoMeta message.", e);
                    zzu.zzgd().zza(e, "VideoMetaGmsgHandler.onGmsg");
                    return;
                }
            } else {
                zzly = zzwb;
            }
            boolean equals = "1".equals(map.get("muted"));
            float parseFloat = Float.parseFloat(map.get("currentTime"));
            int zzg = zzg(map);
            String str = map.get("aspectRatio");
            float parseFloat2 = TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
            if (zzkn.zzbf(3)) {
                zzkn.zzdd(new StringBuilder(String.valueOf(str).length() + 79).append("Video Meta GMSG: isMuted : ").append(equals).append(" , playbackState : ").append(zzg).append(" , aspectRatio : ").append(str).toString());
            }
            zzly.zza(parseFloat, zzg, equals, parseFloat2);
        }
    }
}
