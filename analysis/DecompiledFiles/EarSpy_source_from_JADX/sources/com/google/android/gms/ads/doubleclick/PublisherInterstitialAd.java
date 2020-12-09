package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.internal.client.zzaf;

public final class PublisherInterstitialAd {
    private final zzaf zzakb;

    public PublisherInterstitialAd(Context context) {
        this.zzakb = new zzaf(context, this);
    }

    public AdListener getAdListener() {
        return this.zzakb.getAdListener();
    }

    public String getAdUnitId() {
        return this.zzakb.getAdUnitId();
    }

    public AppEventListener getAppEventListener() {
        return this.zzakb.getAppEventListener();
    }

    public String getMediationAdapterClassName() {
        return this.zzakb.getMediationAdapterClassName();
    }

    public OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzakb.getOnCustomRenderedAdLoadedListener();
    }

    public boolean isLoaded() {
        return this.zzakb.isLoaded();
    }

    public boolean isLoading() {
        return this.zzakb.isLoading();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzakb.zza(publisherAdRequest.zzdg());
    }

    public void setAdListener(AdListener adListener) {
        this.zzakb.setAdListener(adListener);
    }

    public void setAdUnitId(String str) {
        this.zzakb.setAdUnitId(str);
    }

    public void setAppEventListener(AppEventListener appEventListener) {
        this.zzakb.setAppEventListener(appEventListener);
    }

    public void setCorrelator(Correlator correlator) {
        this.zzakb.setCorrelator(correlator);
    }

    public void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzakb.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    public void show() {
        this.zzakb.show();
    }
}
