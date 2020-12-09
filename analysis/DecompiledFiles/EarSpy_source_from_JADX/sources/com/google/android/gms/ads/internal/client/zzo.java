package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.internal.zziy;

@zziy
public class zzo extends AdListener {
    private final Object lock = new Object();
    private AdListener zzayi;

    public void onAdClosed() {
        synchronized (this.lock) {
            if (this.zzayi != null) {
                this.zzayi.onAdClosed();
            }
        }
    }

    public void onAdFailedToLoad(int i) {
        synchronized (this.lock) {
            if (this.zzayi != null) {
                this.zzayi.onAdFailedToLoad(i);
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.lock) {
            if (this.zzayi != null) {
                this.zzayi.onAdLeftApplication();
            }
        }
    }

    public void onAdLoaded() {
        synchronized (this.lock) {
            if (this.zzayi != null) {
                this.zzayi.onAdLoaded();
            }
        }
    }

    public void onAdOpened() {
        synchronized (this.lock) {
            if (this.zzayi != null) {
                this.zzayi.onAdOpened();
            }
        }
    }

    public void zza(AdListener adListener) {
        synchronized (this.lock) {
            this.zzayi = adListener;
        }
    }
}
