package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzu;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Map;

@zziy
public final class zzet implements zzev {
    private void zzb(zzlt zzlt, Map<String, String> map) {
        String str = map.get("label");
        String str2 = map.get("start_label");
        String str3 = map.get("timestamp");
        if (TextUtils.isEmpty(str)) {
            zzkn.zzdf("No label given for CSI tick.");
        } else if (TextUtils.isEmpty(str3)) {
            zzkn.zzdf("No timestamp given for CSI tick.");
        } else {
            try {
                long zzd = zzd(Long.parseLong(str3));
                if (TextUtils.isEmpty(str2)) {
                    str2 = "native:view_load";
                }
                zzlt.zzwa().zza(str, str2, zzd);
            } catch (NumberFormatException e) {
                zzkn.zzd("Malformed timestamp for CSI tick.", e);
            }
        }
    }

    private void zzc(zzlt zzlt, Map<String, String> map) {
        String str = map.get(FirebaseAnalytics.Param.VALUE);
        if (TextUtils.isEmpty(str)) {
            zzkn.zzdf("No value given for CSI experiment.");
            return;
        }
        zzdq zzkz = zzlt.zzwa().zzkz();
        if (zzkz == null) {
            zzkn.zzdf("No ticker for WebView, dropping experiment ID.");
        } else {
            zzkz.zzh("e", str);
        }
    }

    private long zzd(long j) {
        return (j - zzu.zzgf().currentTimeMillis()) + zzu.zzgf().elapsedRealtime();
    }

    private void zzd(zzlt zzlt, Map<String, String> map) {
        String str = map.get("name");
        String str2 = map.get(FirebaseAnalytics.Param.VALUE);
        if (TextUtils.isEmpty(str2)) {
            zzkn.zzdf("No value given for CSI extra.");
        } else if (TextUtils.isEmpty(str)) {
            zzkn.zzdf("No name given for CSI extra.");
        } else {
            zzdq zzkz = zzlt.zzwa().zzkz();
            if (zzkz == null) {
                zzkn.zzdf("No ticker for WebView, dropping extra parameter.");
            } else {
                zzkz.zzh(str, str2);
            }
        }
    }

    public void zza(zzlt zzlt, Map<String, String> map) {
        String str = map.get("action");
        if ("tick".equals(str)) {
            zzb(zzlt, map);
        } else if ("experiment".equals(str)) {
            zzc(zzlt, map);
        } else if ("extra".equals(str)) {
            zzd(zzlt, map);
        }
    }
}
