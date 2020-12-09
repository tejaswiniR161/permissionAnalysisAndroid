package com.applovin.adview;

import android.app.Activity;
import com.applovin.sdk.AppLovinSdk;

public interface InterstitialAdDialogCreator {
    AppLovinInterstitialAdDialog createInterstitialAdDialog(AppLovinSdk appLovinSdk, Activity activity);
}
