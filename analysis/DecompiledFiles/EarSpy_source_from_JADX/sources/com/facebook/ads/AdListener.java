package com.facebook.ads;

public interface AdListener {
    void onAdClicked(C0405Ad ad);

    void onAdLoaded(C0405Ad ad);

    void onError(C0405Ad ad, AdError adError);
}
