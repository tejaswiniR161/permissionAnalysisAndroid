package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.common.internal.zzac;

@zziy
public final class zzgy implements MediationBannerListener, MediationInterstitialListener, MediationNativeListener {
    private final zzgs zzbub;
    private NativeAdMapper zzbuc;

    public zzgy(zzgs zzgs) {
        this.zzbub = zzgs;
    }

    public void onAdClicked(MediationBannerAdapter mediationBannerAdapter) {
        zzac.zzhq("onAdClicked must be called on the main UI thread.");
        zzb.zzdd("Adapter called onAdClicked.");
        try {
            this.zzbub.onAdClicked();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClicked.", e);
        }
    }

    public void onAdClicked(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzac.zzhq("onAdClicked must be called on the main UI thread.");
        zzb.zzdd("Adapter called onAdClicked.");
        try {
            this.zzbub.onAdClicked();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClicked.", e);
        }
    }

    public void onAdClicked(MediationNativeAdapter mediationNativeAdapter) {
        zzac.zzhq("onAdClicked must be called on the main UI thread.");
        NativeAdMapper zznq = zznq();
        if (zznq == null) {
            zzb.zzdf("Could not call onAdClicked since NativeAdMapper is null.");
        } else if (!zznq.getOverrideClickHandling()) {
            zzb.zzdd("Could not call onAdClicked since setOverrideClickHandling is not set to true");
        } else {
            zzb.zzdd("Adapter called onAdClicked.");
            try {
                this.zzbub.onAdClicked();
            } catch (RemoteException e) {
                zzb.zzd("Could not call onAdClicked.", e);
            }
        }
    }

    public void onAdClosed(MediationBannerAdapter mediationBannerAdapter) {
        zzac.zzhq("onAdClosed must be called on the main UI thread.");
        zzb.zzdd("Adapter called onAdClosed.");
        try {
            this.zzbub.onAdClosed();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onAdClosed(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzac.zzhq("onAdClosed must be called on the main UI thread.");
        zzb.zzdd("Adapter called onAdClosed.");
        try {
            this.zzbub.onAdClosed();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onAdClosed(MediationNativeAdapter mediationNativeAdapter) {
        zzac.zzhq("onAdClosed must be called on the main UI thread.");
        zzb.zzdd("Adapter called onAdClosed.");
        try {
            this.zzbub.onAdClosed();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onAdFailedToLoad(MediationBannerAdapter mediationBannerAdapter, int i) {
        zzac.zzhq("onAdFailedToLoad must be called on the main UI thread.");
        zzb.zzdd(new StringBuilder(55).append("Adapter called onAdFailedToLoad with error. ").append(i).toString());
        try {
            this.zzbub.onAdFailedToLoad(i);
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdFailedToLoad(MediationInterstitialAdapter mediationInterstitialAdapter, int i) {
        zzac.zzhq("onAdFailedToLoad must be called on the main UI thread.");
        zzb.zzdd(new StringBuilder(55).append("Adapter called onAdFailedToLoad with error ").append(i).append(".").toString());
        try {
            this.zzbub.onAdFailedToLoad(i);
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdFailedToLoad(MediationNativeAdapter mediationNativeAdapter, int i) {
        zzac.zzhq("onAdFailedToLoad must be called on the main UI thread.");
        zzb.zzdd(new StringBuilder(55).append("Adapter called onAdFailedToLoad with error ").append(i).append(".").toString());
        try {
            this.zzbub.onAdFailedToLoad(i);
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onAdImpression(MediationNativeAdapter mediationNativeAdapter) {
        zzac.zzhq("onAdImpression must be called on the main UI thread.");
        NativeAdMapper zznq = zznq();
        if (zznq == null) {
            zzb.zzdf("Could not call onAdImpression since NativeAdMapper is null. ");
        } else if (!zznq.getOverrideImpressionRecording()) {
            zzb.zzdd("Could not call onAdImpression since setOverrideImpressionRecording is not set to true");
        } else {
            zzb.zzdd("Adapter called onAdImpression.");
            try {
                this.zzbub.onAdImpression();
            } catch (RemoteException e) {
                zzb.zzd("Could not call onAdImpression.", e);
            }
        }
    }

    public void onAdLeftApplication(MediationBannerAdapter mediationBannerAdapter) {
        zzac.zzhq("onAdLeftApplication must be called on the main UI thread.");
        zzb.zzdd("Adapter called onAdLeftApplication.");
        try {
            this.zzbub.onAdLeftApplication();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLeftApplication(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzac.zzhq("onAdLeftApplication must be called on the main UI thread.");
        zzb.zzdd("Adapter called onAdLeftApplication.");
        try {
            this.zzbub.onAdLeftApplication();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLeftApplication(MediationNativeAdapter mediationNativeAdapter) {
        zzac.zzhq("onAdLeftApplication must be called on the main UI thread.");
        zzb.zzdd("Adapter called onAdLeftApplication.");
        try {
            this.zzbub.onAdLeftApplication();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onAdLoaded(MediationBannerAdapter mediationBannerAdapter) {
        zzac.zzhq("onAdLoaded must be called on the main UI thread.");
        zzb.zzdd("Adapter called onAdLoaded.");
        try {
            this.zzbub.onAdLoaded();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLoaded.", e);
        }
    }

    public void onAdLoaded(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzac.zzhq("onAdLoaded must be called on the main UI thread.");
        zzb.zzdd("Adapter called onAdLoaded.");
        try {
            this.zzbub.onAdLoaded();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLoaded.", e);
        }
    }

    public void onAdLoaded(MediationNativeAdapter mediationNativeAdapter, NativeAdMapper nativeAdMapper) {
        zzac.zzhq("onAdLoaded must be called on the main UI thread.");
        zzb.zzdd("Adapter called onAdLoaded.");
        this.zzbuc = nativeAdMapper;
        try {
            this.zzbub.onAdLoaded();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLoaded.", e);
        }
    }

    public void onAdOpened(MediationBannerAdapter mediationBannerAdapter) {
        zzac.zzhq("onAdOpened must be called on the main UI thread.");
        zzb.zzdd("Adapter called onAdOpened.");
        try {
            this.zzbub.onAdOpened();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdOpened.", e);
        }
    }

    public void onAdOpened(MediationInterstitialAdapter mediationInterstitialAdapter) {
        zzac.zzhq("onAdOpened must be called on the main UI thread.");
        zzb.zzdd("Adapter called onAdOpened.");
        try {
            this.zzbub.onAdOpened();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdOpened.", e);
        }
    }

    public void onAdOpened(MediationNativeAdapter mediationNativeAdapter) {
        zzac.zzhq("onAdOpened must be called on the main UI thread.");
        zzb.zzdd("Adapter called onAdOpened.");
        try {
            this.zzbub.onAdOpened();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdOpened.", e);
        }
    }

    public NativeAdMapper zznq() {
        return this.zzbuc;
    }
}
