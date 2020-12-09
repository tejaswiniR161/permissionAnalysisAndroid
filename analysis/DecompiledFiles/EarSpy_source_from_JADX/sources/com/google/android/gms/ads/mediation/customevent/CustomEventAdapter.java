package com.google.android.gms.ads.mediation.customevent;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter, MediationInterstitialAdapter, MediationNativeAdapter {
    CustomEventBanner zzcxi;
    CustomEventInterstitial zzcxj;
    CustomEventNative zzcxk;
    private View zzgs;

    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzcxl;
        private final MediationBannerListener zzgk;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzcxl = customEventAdapter;
            this.zzgk = mediationBannerListener;
        }

        public void onAdClicked() {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onAdClicked.");
            this.zzgk.onAdClicked(this.zzcxl);
        }

        public void onAdClosed() {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onAdClosed.");
            this.zzgk.onAdClosed(this.zzcxl);
        }

        public void onAdFailedToLoad(int i) {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onAdFailedToLoad.");
            this.zzgk.onAdFailedToLoad(this.zzcxl, i);
        }

        public void onAdLeftApplication() {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onAdLeftApplication.");
            this.zzgk.onAdLeftApplication(this.zzcxl);
        }

        public void onAdLoaded(View view) {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onAdLoaded.");
            this.zzcxl.zza(view);
            this.zzgk.onAdLoaded(this.zzcxl);
        }

        public void onAdOpened() {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onAdOpened.");
            this.zzgk.onAdOpened(this.zzcxl);
        }
    }

    class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzcxl;
        private final MediationInterstitialListener zzgl;

        public zzb(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzcxl = customEventAdapter;
            this.zzgl = mediationInterstitialListener;
        }

        public void onAdClicked() {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onAdClicked.");
            this.zzgl.onAdClicked(this.zzcxl);
        }

        public void onAdClosed() {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onAdClosed.");
            this.zzgl.onAdClosed(this.zzcxl);
        }

        public void onAdFailedToLoad(int i) {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onFailedToReceiveAd.");
            this.zzgl.onAdFailedToLoad(this.zzcxl, i);
        }

        public void onAdLeftApplication() {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onAdLeftApplication.");
            this.zzgl.onAdLeftApplication(this.zzcxl);
        }

        public void onAdLoaded() {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onReceivedAd.");
            this.zzgl.onAdLoaded(CustomEventAdapter.this);
        }

        public void onAdOpened() {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onAdOpened.");
            this.zzgl.onAdOpened(this.zzcxl);
        }
    }

    static class zzc implements CustomEventNativeListener {
        private final CustomEventAdapter zzcxl;
        private final MediationNativeListener zzgm;

        public zzc(CustomEventAdapter customEventAdapter, MediationNativeListener mediationNativeListener) {
            this.zzcxl = customEventAdapter;
            this.zzgm = mediationNativeListener;
        }

        public void onAdClicked() {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onAdClicked.");
            this.zzgm.onAdClicked(this.zzcxl);
        }

        public void onAdClosed() {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onAdClosed.");
            this.zzgm.onAdClosed(this.zzcxl);
        }

        public void onAdFailedToLoad(int i) {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onAdFailedToLoad.");
            this.zzgm.onAdFailedToLoad(this.zzcxl, i);
        }

        public void onAdImpression() {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onAdImpression.");
            this.zzgm.onAdImpression(this.zzcxl);
        }

        public void onAdLeftApplication() {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onAdLeftApplication.");
            this.zzgm.onAdLeftApplication(this.zzcxl);
        }

        public void onAdLoaded(NativeAdMapper nativeAdMapper) {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onAdLoaded.");
            this.zzgm.onAdLoaded(this.zzcxl, nativeAdMapper);
        }

        public void onAdOpened() {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onAdOpened.");
            this.zzgm.onAdOpened(this.zzcxl);
        }
    }

    /* access modifiers changed from: private */
    public void zza(View view) {
        this.zzgs = view;
    }

    private static <T> T zzj(String str) {
        try {
            return Class.forName(str).newInstance();
        } catch (Throwable th) {
            String valueOf = String.valueOf(th.getMessage());
            com.google.android.gms.ads.internal.util.client.zzb.zzdf(new StringBuilder(String.valueOf(str).length() + 46 + String.valueOf(valueOf).length()).append("Could not instantiate custom event adapter: ").append(str).append(". ").append(valueOf).toString());
            return null;
        }
    }

    public View getBannerView() {
        return this.zzgs;
    }

    public void onDestroy() {
        if (this.zzcxi != null) {
            this.zzcxi.onDestroy();
        }
        if (this.zzcxj != null) {
            this.zzcxj.onDestroy();
        }
        if (this.zzcxk != null) {
            this.zzcxk.onDestroy();
        }
    }

    public void onPause() {
        if (this.zzcxi != null) {
            this.zzcxi.onPause();
        }
        if (this.zzcxj != null) {
            this.zzcxj.onPause();
        }
        if (this.zzcxk != null) {
            this.zzcxk.onPause();
        }
    }

    public void onResume() {
        if (this.zzcxi != null) {
            this.zzcxi.onResume();
        }
        if (this.zzcxj != null) {
            this.zzcxj.onResume();
        }
        if (this.zzcxk != null) {
            this.zzcxk.onResume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzcxi = (CustomEventBanner) zzj(bundle.getString("class_name"));
        if (this.zzcxi == null) {
            mediationBannerListener.onAdFailedToLoad(this, 0);
        } else {
            this.zzcxi.requestBannerAd(context, new zza(this, mediationBannerListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), adSize, mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzcxj = (CustomEventInterstitial) zzj(bundle.getString("class_name"));
        if (this.zzcxj == null) {
            mediationInterstitialListener.onAdFailedToLoad(this, 0);
        } else {
            this.zzcxj.requestInterstitialAd(context, zza(mediationInterstitialListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), mediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        this.zzcxk = (CustomEventNative) zzj(bundle.getString("class_name"));
        if (this.zzcxk == null) {
            mediationNativeListener.onAdFailedToLoad(this, 0);
        } else {
            this.zzcxk.requestNativeAd(context, new zzc(this, mediationNativeListener), bundle.getString(MediationRewardedVideoAdAdapter.CUSTOM_EVENT_SERVER_PARAMETER_FIELD), nativeMediationAdRequest, bundle2 == null ? null : bundle2.getBundle(bundle.getString("class_name")));
        }
    }

    public void showInterstitial() {
        this.zzcxj.showInterstitial();
    }

    /* access modifiers changed from: package-private */
    public zzb zza(MediationInterstitialListener mediationInterstitialListener) {
        return new zzb(this, mediationInterstitialListener);
    }
}
