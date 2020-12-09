package com.google.android.gms.ads;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzaf;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public final class InterstitialAd {
    private final zzaf zzakb;

    public InterstitialAd(Context context) {
        this.zzakb = new zzaf(context);
    }

    public AdListener getAdListener() {
        return this.zzakb.getAdListener();
    }

    public String getAdUnitId() {
        return this.zzakb.getAdUnitId();
    }

    public InAppPurchaseListener getInAppPurchaseListener() {
        return this.zzakb.getInAppPurchaseListener();
    }

    public String getMediationAdapterClassName() {
        return this.zzakb.getMediationAdapterClassName();
    }

    public boolean isLoaded() {
        return this.zzakb.isLoaded();
    }

    public boolean isLoading() {
        return this.zzakb.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        this.zzakb.zza(adRequest.zzdg());
    }

    public void setAdListener(AdListener adListener) {
        this.zzakb.setAdListener(adListener);
        if (adListener != null && (adListener instanceof zza)) {
            this.zzakb.zza((zza) adListener);
        } else if (adListener == null) {
            this.zzakb.zza((zza) null);
        }
    }

    public void setAdUnitId(String str) {
        this.zzakb.setAdUnitId(str);
    }

    public void setInAppPurchaseListener(InAppPurchaseListener inAppPurchaseListener) {
        this.zzakb.setInAppPurchaseListener(inAppPurchaseListener);
    }

    public void setPlayStorePurchaseParams(PlayStorePurchaseListener playStorePurchaseListener, String str) {
        this.zzakb.setPlayStorePurchaseParams(playStorePurchaseListener, str);
    }

    public void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzakb.setRewardedVideoAdListener(rewardedVideoAdListener);
    }

    public void show() {
        this.zzakb.show();
    }

    public void zzd(boolean z) {
        this.zzakb.zzd(z);
    }
}
