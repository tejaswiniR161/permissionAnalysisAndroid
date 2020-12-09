package com.google.android.gms.ads.internal.reward.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.internal.client.zzh;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zziy;

@zziy
public class zzi implements RewardedVideoAd {
    private final Context mContext;
    private final Object zzakd = new Object();
    private final zzb zzcmz;
    private RewardedVideoAdListener zzgf;

    public zzi(Context context, zzb zzb) {
        this.zzcmz = zzb;
        this.mContext = context;
    }

    public void destroy() {
        destroy((Context) null);
    }

    public void destroy(Context context) {
        synchronized (this.zzakd) {
            if (this.zzcmz != null) {
                try {
                    this.zzcmz.zzh(zze.zzac(context));
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward destroy to RewardedVideoAd", e);
                }
                return;
            }
            return;
        }
    }

    public RewardedVideoAdListener getRewardedVideoAdListener() {
        RewardedVideoAdListener rewardedVideoAdListener;
        synchronized (this.zzakd) {
            rewardedVideoAdListener = this.zzgf;
        }
        return rewardedVideoAdListener;
    }

    public String getUserId() {
        zzb.zzdf("RewardedVideoAd.getUserId() is deprecated. Please do not call this method.");
        return null;
    }

    public boolean isLoaded() {
        boolean z = false;
        synchronized (this.zzakd) {
            if (this.zzcmz != null) {
                try {
                    z = this.zzcmz.isLoaded();
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward isLoaded to RewardedVideoAd", e);
                }
            }
        }
        return z;
    }

    public void loadAd(String str, AdRequest adRequest) {
        synchronized (this.zzakd) {
            if (this.zzcmz != null) {
                try {
                    this.zzcmz.zza(zzh.zzjb().zza(this.mContext, adRequest.zzdg(), str));
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward loadAd to RewardedVideoAd", e);
                }
                return;
            }
            return;
        }
    }

    public void pause() {
        pause((Context) null);
    }

    public void pause(Context context) {
        synchronized (this.zzakd) {
            if (this.zzcmz != null) {
                try {
                    this.zzcmz.zzf(zze.zzac(context));
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward pause to RewardedVideoAd", e);
                }
                return;
            }
            return;
        }
    }

    public void resume() {
        resume((Context) null);
    }

    public void resume(Context context) {
        synchronized (this.zzakd) {
            if (this.zzcmz != null) {
                try {
                    this.zzcmz.zzg(zze.zzac(context));
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward resume to RewardedVideoAd", e);
                }
                return;
            }
            return;
        }
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        synchronized (this.zzakd) {
            this.zzgf = rewardedVideoAdListener;
            if (this.zzcmz != null) {
                try {
                    this.zzcmz.zza((zzd) new zzg(rewardedVideoAdListener));
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward setRewardedVideoAdListener to RewardedVideoAd", e);
                }
            }
        }
    }

    public void setUserId(String str) {
        zzb.zzdf("RewardedVideoAd.setUserId() is deprecated. Please do not call this method.");
    }

    public void show() {
        synchronized (this.zzakd) {
            if (this.zzcmz != null) {
                try {
                    this.zzcmz.show();
                } catch (RemoteException e) {
                    zzb.zzd("Could not forward show to RewardedVideoAd", e);
                }
                return;
            }
            return;
        }
    }
}
