package com.google.android.gms.internal;

import android.text.TextUtils;
import com.applovin.sdk.AppLovinEventParameters;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import java.util.Map;

@zziy
public class zzfe implements zzev {
    private final zza zzbnq;

    public interface zza {
        void zzb(RewardItemParcel rewardItemParcel);

        void zzfb();
    }

    public zzfe(zza zza2) {
        this.zzbnq = zza2;
    }

    public static void zza(zzlt zzlt, zza zza2) {
        zzlt.zzvr().zza("/reward", (zzev) new zzfe(zza2));
    }

    private void zze(Map<String, String> map) {
        RewardItemParcel rewardItemParcel;
        try {
            int parseInt = Integer.parseInt(map.get(AppLovinEventParameters.REVENUE_AMOUNT));
            String str = map.get("type");
            if (!TextUtils.isEmpty(str)) {
                rewardItemParcel = new RewardItemParcel(str, parseInt);
                this.zzbnq.zzb(rewardItemParcel);
            }
        } catch (NumberFormatException e) {
            zzkn.zzd("Unable to parse reward amount.", e);
        }
        rewardItemParcel = null;
        this.zzbnq.zzb(rewardItemParcel);
    }

    private void zzf(Map<String, String> map) {
        this.zzbnq.zzfb();
    }

    public void zza(zzlt zzlt, Map<String, String> map) {
        String str = map.get("action");
        if ("grant".equals(str)) {
            zze(map);
        } else if ("video_start".equals(str)) {
            zzf(map);
        }
    }
}
