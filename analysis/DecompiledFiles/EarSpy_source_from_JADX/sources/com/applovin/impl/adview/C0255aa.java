package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;

/* renamed from: com.applovin.impl.adview.aa */
class C0255aa implements AppLovinAdVideoPlaybackListener {

    /* renamed from: a */
    final /* synthetic */ C0260af f116a;

    /* renamed from: b */
    final /* synthetic */ C0290x f117b;

    C0255aa(C0290x xVar, C0260af afVar) {
        this.f117b = xVar;
        this.f116a = afVar;
    }

    public void videoPlaybackBegan(AppLovinAd appLovinAd) {
        AppLovinAdVideoPlaybackListener c = this.f116a.mo5233c();
        if (c != null) {
            c.videoPlaybackBegan(appLovinAd);
        }
    }

    public void videoPlaybackEnded(AppLovinAd appLovinAd, double d, boolean z) {
        AppLovinAdVideoPlaybackListener c = this.f116a.mo5233c();
        if (c != null) {
            c.videoPlaybackEnded(appLovinAd, d, z);
        }
    }
}
