package com.applovin.sdk;

public interface AppLovinAd {
    long getAdIdNumber();

    AppLovinAdSize getSize();

    AppLovinAdType getType();

    boolean isVideoAd();
}
