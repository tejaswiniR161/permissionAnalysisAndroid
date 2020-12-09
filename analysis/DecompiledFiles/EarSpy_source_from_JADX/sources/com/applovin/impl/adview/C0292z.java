package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;

/* renamed from: com.applovin.impl.adview.z */
class C0292z implements AppLovinAdClickListener {

    /* renamed from: a */
    final /* synthetic */ C0260af f224a;

    /* renamed from: b */
    final /* synthetic */ C0290x f225b;

    C0292z(C0290x xVar, C0260af afVar) {
        this.f225b = xVar;
        this.f224a = afVar;
    }

    public void adClicked(AppLovinAd appLovinAd) {
        AppLovinAdClickListener e = this.f224a.mo5235e();
        if (e != null) {
            e.adClicked(appLovinAd);
        }
    }
}
