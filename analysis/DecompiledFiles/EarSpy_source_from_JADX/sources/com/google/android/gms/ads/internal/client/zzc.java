package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.internal.zziy;

@zziy
public final class zzc extends zzq.zza {
    private final AdListener zzawc;

    public zzc(AdListener adListener) {
        this.zzawc = adListener;
    }

    public void onAdClosed() {
        this.zzawc.onAdClosed();
    }

    public void onAdFailedToLoad(int i) {
        this.zzawc.onAdFailedToLoad(i);
    }

    public void onAdLeftApplication() {
        this.zzawc.onAdLeftApplication();
    }

    public void onAdLoaded() {
        this.zzawc.onAdLoaded();
    }

    public void onAdOpened() {
        this.zzawc.onAdOpened();
    }
}
