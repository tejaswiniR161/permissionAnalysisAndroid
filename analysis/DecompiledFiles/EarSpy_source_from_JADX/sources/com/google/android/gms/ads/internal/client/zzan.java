package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.client.zzb;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.util.client.zza;

public class zzan extends zzb.zza {
    /* access modifiers changed from: private */
    public zzd zzazn;

    public void destroy() throws RemoteException {
    }

    public boolean isLoaded() throws RemoteException {
        return false;
    }

    public void pause() throws RemoteException {
    }

    public void resume() throws RemoteException {
    }

    public void setUserId(String str) throws RemoteException {
    }

    public void show() throws RemoteException {
    }

    public void zza(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel) throws RemoteException {
        com.google.android.gms.ads.internal.util.client.zzb.m1352e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zza.zzctj.post(new Runnable() {
            public void run() {
                if (zzan.this.zzazn != null) {
                    try {
                        zzan.this.zzazn.onRewardedVideoAdFailedToLoad(1);
                    } catch (RemoteException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not notify onRewardedVideoAdFailedToLoad event.", e);
                    }
                }
            }
        });
    }

    public void zza(zzd zzd) throws RemoteException {
        this.zzazn = zzd;
    }

    public void zzf(com.google.android.gms.dynamic.zzd zzd) throws RemoteException {
    }

    public void zzg(com.google.android.gms.dynamic.zzd zzd) throws RemoteException {
    }

    public void zzh(com.google.android.gms.dynamic.zzd zzd) throws RemoteException {
    }
}
