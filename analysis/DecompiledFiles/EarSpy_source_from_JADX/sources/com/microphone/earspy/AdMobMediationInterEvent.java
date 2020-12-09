package com.microphone.earspy;

import android.app.Activity;
import com.applovin.adview.AppLovinInterstitialAd;
import com.applovin.adview.AppLovinInterstitialAdDialog;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinSdk;
import com.google.ads.mediation.MediationAdRequest;
import com.google.ads.mediation.customevent.CustomEventInterstitial;
import com.google.ads.mediation.customevent.CustomEventInterstitialListener;

public class AdMobMediationInterEvent implements CustomEventInterstitial {
    /* access modifiers changed from: private */
    public AppLovinAd lastAd;
    private Activity mActivity;
    /* access modifiers changed from: private */
    public CustomEventInterstitialListener mListener;

    public void requestInterstitialAd(CustomEventInterstitialListener listener, Activity activity, String label, String serverParameter, MediationAdRequest request, Object unused) {
        this.mActivity = activity;
        this.mListener = listener;
        AppLovinSdk.getInstance(activity).getAdService().loadNextAd(AppLovinAdSize.INTERSTITIAL, new AppLovinAdLoadListener() {
            public void adReceived(AppLovinAd ad) {
                AppLovinAd unused = AdMobMediationInterEvent.this.lastAd = ad;
                AdMobMediationInterEvent.this.mListener.onReceivedAd();
            }

            public void failedToReceiveAd(int errorCode) {
                AdMobMediationInterEvent.this.mListener.onFailedToReceiveAd();
            }
        });
    }

    public void showInterstitial() {
        if (this.lastAd != null && this.mActivity != null && this.mListener != null) {
            AppLovinInterstitialAdDialog dialog = AppLovinInterstitialAd.create(AppLovinSdk.getInstance(this.mActivity), this.mActivity);
            dialog.setAdDisplayListener(new AppLovinAdDisplayListener() {
                public void adHidden(AppLovinAd ad) {
                    AdMobMediationInterEvent.this.mListener.onDismissScreen();
                }

                public void adDisplayed(AppLovinAd ad) {
                    AdMobMediationInterEvent.this.mListener.onPresentScreen();
                }
            });
            dialog.showAndRender(this.lastAd);
        }
    }

    public void destroy() {
        this.lastAd = null;
        this.mActivity = null;
        this.mListener = null;
    }
}
