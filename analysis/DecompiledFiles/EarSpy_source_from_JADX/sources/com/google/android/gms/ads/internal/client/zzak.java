package com.google.android.gms.ads.internal.client;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzdu;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzib;

public class zzak extends zzu.zza {
    /* access modifiers changed from: private */
    public zzq zzamy;

    public void destroy() {
    }

    public String getMediationAdapterClassName() {
        return null;
    }

    public boolean isLoading() {
        return false;
    }

    public boolean isReady() {
        return false;
    }

    public void pause() {
    }

    public void resume() {
    }

    public void setManualImpressionsEnabled(boolean z) {
    }

    public void setUserId(String str) {
    }

    public void showInterstitial() {
    }

    public void stopLoading() {
    }

    public void zza(AdSizeParcel adSizeParcel) {
    }

    public void zza(VideoOptionsParcel videoOptionsParcel) {
    }

    public void zza(zzp zzp) {
    }

    public void zza(zzq zzq) {
        this.zzamy = zzq;
    }

    public void zza(zzw zzw) {
    }

    public void zza(zzy zzy) {
    }

    public void zza(zzd zzd) {
    }

    public void zza(zzdu zzdu) {
    }

    public void zza(zzhx zzhx) {
    }

    public void zza(zzib zzib, String str) {
    }

    public boolean zzb(AdRequestParcel adRequestParcel) {
        zzb.m1352e("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zza.zzctj.post(new Runnable() {
            public void run() {
                if (zzak.this.zzamy != null) {
                    try {
                        zzak.this.zzamy.onAdFailedToLoad(1);
                    } catch (RemoteException e) {
                        zzb.zzd("Could not notify onAdFailedToLoad event.", e);
                    }
                }
            }
        });
        return false;
    }

    public com.google.android.gms.dynamic.zzd zzds() {
        return null;
    }

    public AdSizeParcel zzdt() {
        return null;
    }

    public void zzdv() {
    }

    public zzab zzdw() {
        return null;
    }
}
