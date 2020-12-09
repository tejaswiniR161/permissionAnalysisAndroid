package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;

@zziy
public final class zzhd<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    /* access modifiers changed from: private */
    public final zzgs zzbub;

    public zzhd(zzgs zzgs) {
        this.zzbub = zzgs;
    }

    public void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzdd("Adapter called onClick.");
        if (!zzm.zzjr().zzvf()) {
            zzb.zzdf("onClick must be called on the main UI thread.");
            zza.zzctj.post(new Runnable() {
                public void run() {
                    try {
                        zzhd.this.zzbub.onAdClicked();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdClicked.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzbub.onAdClicked();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClicked.", e);
        }
    }

    public void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzdd("Adapter called onDismissScreen.");
        if (!zzm.zzjr().zzvf()) {
            zzb.zzdf("onDismissScreen must be called on the main UI thread.");
            zza.zzctj.post(new Runnable() {
                public void run() {
                    try {
                        zzhd.this.zzbub.onAdClosed();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdClosed.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzbub.onAdClosed();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzdd("Adapter called onDismissScreen.");
        if (!zzm.zzjr().zzvf()) {
            zzb.zzdf("onDismissScreen must be called on the main UI thread.");
            zza.zzctj.post(new Runnable() {
                public void run() {
                    try {
                        zzhd.this.zzbub.onAdClosed();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdClosed.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzbub.onAdClosed();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdClosed.", e);
        }
    }

    public void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, final AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        zzb.zzdd(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error. ").append(valueOf).toString());
        if (!zzm.zzjr().zzvf()) {
            zzb.zzdf("onFailedToReceiveAd must be called on the main UI thread.");
            zza.zzctj.post(new Runnable() {
                public void run() {
                    try {
                        zzhd.this.zzbub.onAdFailedToLoad(zzhe.zza(errorCode));
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdFailedToLoad.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzbub.onAdFailedToLoad(zzhe.zza(errorCode));
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, final AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        zzb.zzdd(new StringBuilder(String.valueOf(valueOf).length() + 47).append("Adapter called onFailedToReceiveAd with error ").append(valueOf).append(".").toString());
        if (!zzm.zzjr().zzvf()) {
            zzb.zzdf("onFailedToReceiveAd must be called on the main UI thread.");
            zza.zzctj.post(new Runnable() {
                public void run() {
                    try {
                        zzhd.this.zzbub.onAdFailedToLoad(zzhe.zza(errorCode));
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdFailedToLoad.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzbub.onAdFailedToLoad(zzhe.zza(errorCode));
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdFailedToLoad.", e);
        }
    }

    public void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzdd("Adapter called onLeaveApplication.");
        if (!zzm.zzjr().zzvf()) {
            zzb.zzdf("onLeaveApplication must be called on the main UI thread.");
            zza.zzctj.post(new Runnable() {
                public void run() {
                    try {
                        zzhd.this.zzbub.onAdLeftApplication();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdLeftApplication.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzbub.onAdLeftApplication();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzdd("Adapter called onLeaveApplication.");
        if (!zzm.zzjr().zzvf()) {
            zzb.zzdf("onLeaveApplication must be called on the main UI thread.");
            zza.zzctj.post(new Runnable() {
                public void run() {
                    try {
                        zzhd.this.zzbub.onAdLeftApplication();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdLeftApplication.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzbub.onAdLeftApplication();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLeftApplication.", e);
        }
    }

    public void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzdd("Adapter called onPresentScreen.");
        if (!zzm.zzjr().zzvf()) {
            zzb.zzdf("onPresentScreen must be called on the main UI thread.");
            zza.zzctj.post(new Runnable() {
                public void run() {
                    try {
                        zzhd.this.zzbub.onAdOpened();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdOpened.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzbub.onAdOpened();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdOpened.", e);
        }
    }

    public void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzdd("Adapter called onPresentScreen.");
        if (!zzm.zzjr().zzvf()) {
            zzb.zzdf("onPresentScreen must be called on the main UI thread.");
            zza.zzctj.post(new Runnable() {
                public void run() {
                    try {
                        zzhd.this.zzbub.onAdOpened();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdOpened.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzbub.onAdOpened();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdOpened.", e);
        }
    }

    public void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzb.zzdd("Adapter called onReceivedAd.");
        if (!zzm.zzjr().zzvf()) {
            zzb.zzdf("onReceivedAd must be called on the main UI thread.");
            zza.zzctj.post(new Runnable() {
                public void run() {
                    try {
                        zzhd.this.zzbub.onAdLoaded();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdLoaded.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzbub.onAdLoaded();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLoaded.", e);
        }
    }

    public void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzb.zzdd("Adapter called onReceivedAd.");
        if (!zzm.zzjr().zzvf()) {
            zzb.zzdf("onReceivedAd must be called on the main UI thread.");
            zza.zzctj.post(new Runnable() {
                public void run() {
                    try {
                        zzhd.this.zzbub.onAdLoaded();
                    } catch (RemoteException e) {
                        zzb.zzd("Could not call onAdLoaded.", e);
                    }
                }
            });
            return;
        }
        try {
            this.zzbub.onAdLoaded();
        } catch (RemoteException e) {
            zzb.zzd("Could not call onAdLoaded.", e);
        }
    }
}
