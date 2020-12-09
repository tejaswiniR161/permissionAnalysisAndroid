package com.google.ads.mediation.customevent;

import android.app.Activity;
import android.view.View;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.customevent.CustomEventExtras;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class CustomEventAdapter implements MediationBannerAdapter<CustomEventExtras, CustomEventServerParameters>, MediationInterstitialAdapter<CustomEventExtras, CustomEventServerParameters> {
    private View zzgs;
    CustomEventBanner zzgt;
    CustomEventInterstitial zzgu;

    static final class zza implements CustomEventBannerListener {
        private final CustomEventAdapter zzgv;
        private final MediationBannerListener zzgw;

        public zza(CustomEventAdapter customEventAdapter, MediationBannerListener mediationBannerListener) {
            this.zzgv = customEventAdapter;
            this.zzgw = mediationBannerListener;
        }

        public void onClick() {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onFailedToReceiveAd.");
            this.zzgw.onClick(this.zzgv);
        }

        public void onDismissScreen() {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onFailedToReceiveAd.");
            this.zzgw.onDismissScreen(this.zzgv);
        }

        public void onFailedToReceiveAd() {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onFailedToReceiveAd.");
            this.zzgw.onFailedToReceiveAd(this.zzgv, AdRequest.ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onFailedToReceiveAd.");
            this.zzgw.onLeaveApplication(this.zzgv);
        }

        public void onPresentScreen() {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onFailedToReceiveAd.");
            this.zzgw.onPresentScreen(this.zzgv);
        }

        public void onReceivedAd(View view) {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onReceivedAd.");
            this.zzgv.zza(view);
            this.zzgw.onReceivedAd(this.zzgv);
        }
    }

    class zzb implements CustomEventInterstitialListener {
        private final CustomEventAdapter zzgv;
        private final MediationInterstitialListener zzgx;

        public zzb(CustomEventAdapter customEventAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzgv = customEventAdapter;
            this.zzgx = mediationInterstitialListener;
        }

        public void onDismissScreen() {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onDismissScreen.");
            this.zzgx.onDismissScreen(this.zzgv);
        }

        public void onFailedToReceiveAd() {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onFailedToReceiveAd.");
            this.zzgx.onFailedToReceiveAd(this.zzgv, AdRequest.ErrorCode.NO_FILL);
        }

        public void onLeaveApplication() {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onLeaveApplication.");
            this.zzgx.onLeaveApplication(this.zzgv);
        }

        public void onPresentScreen() {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onPresentScreen.");
            this.zzgx.onPresentScreen(this.zzgv);
        }

        public void onReceivedAd() {
            com.google.android.gms.ads.internal.util.client.zzb.zzdd("Custom event adapter called onReceivedAd.");
            this.zzgx.onReceivedAd(CustomEventAdapter.this);
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

    public void destroy() {
        if (this.zzgt != null) {
            this.zzgt.destroy();
        }
        if (this.zzgu != null) {
            this.zzgu.destroy();
        }
    }

    public Class<CustomEventExtras> getAdditionalParametersType() {
        return CustomEventExtras.class;
    }

    public View getBannerView() {
        return this.zzgs;
    }

    public Class<CustomEventServerParameters> getServerParametersType() {
        return CustomEventServerParameters.class;
    }

    public void requestBannerAd(MediationBannerListener mediationBannerListener, Activity activity, CustomEventServerParameters customEventServerParameters, AdSize adSize, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.zzgt = (CustomEventBanner) zzj(customEventServerParameters.className);
        if (this.zzgt == null) {
            mediationBannerListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        } else {
            this.zzgt.requestBannerAd(new zza(this, mediationBannerListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, adSize, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(customEventServerParameters.label));
        }
    }

    public void requestInterstitialAd(MediationInterstitialListener mediationInterstitialListener, Activity activity, CustomEventServerParameters customEventServerParameters, MediationAdRequest mediationAdRequest, CustomEventExtras customEventExtras) {
        this.zzgu = (CustomEventInterstitial) zzj(customEventServerParameters.className);
        if (this.zzgu == null) {
            mediationInterstitialListener.onFailedToReceiveAd(this, AdRequest.ErrorCode.INTERNAL_ERROR);
        } else {
            this.zzgu.requestInterstitialAd(zza(mediationInterstitialListener), activity, customEventServerParameters.label, customEventServerParameters.parameter, mediationAdRequest, customEventExtras == null ? null : customEventExtras.getExtra(customEventServerParameters.label));
        }
    }

    public void showInterstitial() {
        this.zzgu.showInterstitial();
    }

    /* access modifiers changed from: package-private */
    public zzb zza(MediationInterstitialListener mediationInterstitialListener) {
        return new zzb(this, mediationInterstitialListener);
    }
}
