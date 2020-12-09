package com.google.android.gms.ads.internal.reward.mediation.client;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zziy;

@zziy
public class zzb implements MediationRewardedVideoAdListener {
    private final zza zzcnx;

    public zzb(zza zza) {
        this.zzcnx = zza;
    }

    public void onAdClicked(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzac.zzhq("onAdClicked must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzdd("Adapter called onAdClicked.");
        try {
            this.zzcnx.zzv(zze.zzac(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdClicked.", e);
        }
    }

    public void onAdClosed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzac.zzhq("onAdClosed must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzdd("Adapter called onAdClosed.");
        try {
            this.zzcnx.zzu(zze.zzac(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onAdFailedToLoad(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        zzac.zzhq("onAdFailedToLoad must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzdd("Adapter called onAdFailedToLoad.");
        try {
            this.zzcnx.zzc(zze.zzac(mediationRewardedVideoAdAdapter), i);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdLeftApplication(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzac.zzhq("onAdLeftApplication must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzdd("Adapter called onAdLeftApplication.");
        try {
            this.zzcnx.zzw(zze.zzac(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLoaded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzac.zzhq("onAdLoaded must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzdd("Adapter called onAdLoaded.");
        try {
            this.zzcnx.zzr(zze.zzac(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdLoaded.", e);
        }
    }

    public void onAdOpened(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzac.zzhq("onAdOpened must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzdd("Adapter called onAdOpened.");
        try {
            this.zzcnx.zzs(zze.zzac(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onAdOpened.", e);
        }
    }

    public void onInitializationFailed(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, int i) {
        zzac.zzhq("onInitializationFailed must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzdd("Adapter called onInitializationFailed.");
        try {
            this.zzcnx.zzb(zze.zzac(mediationRewardedVideoAdAdapter), i);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onInitializationFailed.", e);
        }
    }

    public void onInitializationSucceeded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzac.zzhq("onInitializationSucceeded must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzdd("Adapter called onInitializationSucceeded.");
        try {
            this.zzcnx.zzq(zze.zzac(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onInitializationSucceeded.", e);
        }
    }

    public void onRewarded(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter, RewardItem rewardItem) {
        zzac.zzhq("onRewarded must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzdd("Adapter called onRewarded.");
        if (rewardItem != null) {
            try {
                this.zzcnx.zza(zze.zzac(mediationRewardedVideoAdAdapter), new RewardItemParcel(rewardItem));
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onRewarded.", e);
            }
        } else {
            this.zzcnx.zza(zze.zzac(mediationRewardedVideoAdAdapter), new RewardItemParcel(mediationRewardedVideoAdAdapter.getClass().getName(), 1));
        }
    }

    public void onVideoStarted(MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter) {
        zzac.zzhq("onVideoStarted must be called on the main UI thread.");
        com.google.android.gms.ads.internal.util.client.zzb.zzdd("Adapter called onVideoStarted.");
        try {
            this.zzcnx.zzt(zze.zzac(mediationRewardedVideoAdAdapter));
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.zzd("Could not call onVideoStarted.", e);
        }
    }
}
