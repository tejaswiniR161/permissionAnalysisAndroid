package com.google.android.gms.ads.internal.reward.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.internal.zziy;

@zziy
public class zze implements RewardItem {
    private final zza zzcmy;

    public zze(zza zza) {
        this.zzcmy = zza;
    }

    public int getAmount() {
        if (this.zzcmy == null) {
            return 0;
        }
        try {
            return this.zzcmy.getAmount();
        } catch (RemoteException e) {
            zzb.zzd("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }

    public String getType() {
        if (this.zzcmy == null) {
            return null;
        }
        try {
            return this.zzcmy.getType();
        } catch (RemoteException e) {
            zzb.zzd("Could not forward getType to RewardItem", e);
            return null;
        }
    }
}
