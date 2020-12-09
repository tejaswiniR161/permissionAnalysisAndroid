package com.google.ads.mediation.facebook;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdView;
import com.facebook.ads.C0405Ad;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.InterstitialAdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;

public final class FacebookAdapter implements MediationInterstitialAdapter, MediationBannerAdapter {
    private static final String PLACEMENT_PARAMETER = "pubid";
    private static final String TAG = "FacebookAdapter";
    private AdView mAdView;
    /* access modifiers changed from: private */
    public MediationBannerListener mBannerListener;
    private InterstitialAd mInterstitialAd;
    /* access modifiers changed from: private */
    public MediationInterstitialListener mInterstitialListener;
    private RelativeLayout mWrappedAdView;

    public void onDestroy() {
        if (this.mAdView != null) {
            this.mAdView.destroy();
        }
        if (this.mInterstitialAd != null) {
            this.mInterstitialAd.destroy();
        }
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public View getBannerView() {
        return this.mWrappedAdView;
    }

    public void requestBannerAd(Context context, MediationBannerListener listener, Bundle serverParameters, AdSize adSize, MediationAdRequest adRequest, Bundle mediationExtras) {
        if (context != null && serverParameters != null && adSize != null) {
            this.mBannerListener = listener;
            String placementId = serverParameters.getString("pubid");
            if (placementId == null) {
                Log.w(TAG, "Fail to request banner Ad, placementId is null");
                this.mBannerListener.onAdFailedToLoad(this, 0);
                return;
            }
            com.facebook.ads.AdSize facebookAdSize = getAdSize(context, adSize);
            if (facebookAdSize == null) {
                Log.w(TAG, "The input ad size " + adSize.toString() + " is not supported at this moment.");
                this.mBannerListener.onAdFailedToLoad(this, 3);
                return;
            }
            this.mAdView = new AdView(context, placementId, facebookAdSize);
            this.mAdView.setAdListener(new BannerListener(this, (BannerListener) null));
            buildAdRequest(adRequest);
            RelativeLayout.LayoutParams wrappedLayoutParams = new RelativeLayout.LayoutParams(adSize.getWidthInPixels(context), adSize.getHeightInPixels(context));
            this.mWrappedAdView = new RelativeLayout(context);
            this.mWrappedAdView.setLayoutParams(wrappedLayoutParams);
            this.mWrappedAdView.addView(this.mAdView);
            this.mAdView.loadAd();
        }
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener listener, Bundle serverParameters, MediationAdRequest adRequest, Bundle mediationExtras) {
        if (context != null && serverParameters != null) {
            this.mInterstitialListener = listener;
            String placementId = serverParameters.getString("pubid");
            if (placementId == null) {
                Log.w(TAG, "Fail to request interstitial Ad, placementId is null");
                this.mInterstitialListener.onAdFailedToLoad(this, 0);
                return;
            }
            this.mInterstitialAd = new InterstitialAd(context, placementId);
            this.mInterstitialAd.setAdListener(new InterstitialListener(this, (InterstitialListener) null));
            buildAdRequest(adRequest);
            this.mInterstitialAd.loadAd();
        }
    }

    public void showInterstitial() {
        if (this.mInterstitialAd.isAdLoaded()) {
            this.mInterstitialAd.show();
        }
    }

    /* access modifiers changed from: private */
    public int convertErrorCode(AdError adError) {
        int errorCode;
        if (adError == null || (errorCode = adError.getErrorCode()) == 2001 || errorCode == 2000) {
            return 0;
        }
        if (errorCode == 1000) {
            return 2;
        }
        if (errorCode == 1002) {
            return 1;
        }
        return 3;
    }

    private void buildAdRequest(MediationAdRequest adRequest) {
        boolean z = true;
        if (adRequest != null) {
            if (adRequest.taggedForChildDirectedTreatment() != 1) {
                z = false;
            }
            AdSettings.setIsChildDirected(z);
        }
    }

    private class BannerListener implements AdListener {
        private BannerListener() {
        }

        /* synthetic */ BannerListener(FacebookAdapter facebookAdapter, BannerListener bannerListener) {
            this();
        }

        public void onAdClicked(C0405Ad ad) {
            FacebookAdapter.this.mBannerListener.onAdClicked(FacebookAdapter.this);
            FacebookAdapter.this.mBannerListener.onAdOpened(FacebookAdapter.this);
        }

        public void onAdLoaded(C0405Ad ad) {
            FacebookAdapter.this.mBannerListener.onAdLoaded(FacebookAdapter.this);
        }

        public void onError(C0405Ad ad, AdError adError) {
            String errorMessage = adError.getErrorMessage();
            if (!TextUtils.isEmpty(errorMessage)) {
                Log.w(FacebookAdapter.TAG, errorMessage);
            }
            FacebookAdapter.this.mBannerListener.onAdFailedToLoad(FacebookAdapter.this, FacebookAdapter.this.convertErrorCode(adError));
        }
    }

    private class InterstitialListener implements InterstitialAdListener {
        private InterstitialListener() {
        }

        /* synthetic */ InterstitialListener(FacebookAdapter facebookAdapter, InterstitialListener interstitialListener) {
            this();
        }

        public void onAdClicked(C0405Ad ad) {
        }

        public void onAdLoaded(C0405Ad ad) {
            FacebookAdapter.this.mInterstitialListener.onAdLoaded(FacebookAdapter.this);
        }

        public void onError(C0405Ad ad, AdError adError) {
            String errorMessage = adError.getErrorMessage();
            if (!TextUtils.isEmpty(errorMessage)) {
                Log.w(FacebookAdapter.TAG, errorMessage);
            }
            FacebookAdapter.this.mInterstitialListener.onAdFailedToLoad(FacebookAdapter.this, FacebookAdapter.this.convertErrorCode(adError));
        }

        public void onInterstitialDismissed(C0405Ad ad) {
            FacebookAdapter.this.mInterstitialListener.onAdClosed(FacebookAdapter.this);
        }

        public void onInterstitialDisplayed(C0405Ad ad) {
            FacebookAdapter.this.mInterstitialListener.onAdOpened(FacebookAdapter.this);
        }
    }

    private com.facebook.ads.AdSize getAdSize(Context context, AdSize adSize) {
        if (adSize.getWidth() == com.facebook.ads.AdSize.BANNER_320_50.getWidth() && adSize.getHeight() == com.facebook.ads.AdSize.BANNER_320_50.getHeight()) {
            return com.facebook.ads.AdSize.BANNER_320_50;
        }
        int heightInDip = pixelToDip(adSize.getHeightInPixels(context));
        if (heightInDip == com.facebook.ads.AdSize.BANNER_HEIGHT_50.getHeight()) {
            return com.facebook.ads.AdSize.BANNER_HEIGHT_50;
        }
        if (heightInDip == com.facebook.ads.AdSize.BANNER_HEIGHT_90.getHeight()) {
            return com.facebook.ads.AdSize.BANNER_HEIGHT_90;
        }
        if (heightInDip == com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250.getHeight()) {
            return com.facebook.ads.AdSize.RECTANGLE_HEIGHT_250;
        }
        return null;
    }

    private int pixelToDip(int pixel) {
        return Math.round(((float) pixel) / Resources.getSystem().getDisplayMetrics().density);
    }
}
