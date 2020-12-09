package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdDisplayListener;

/* renamed from: com.applovin.impl.adview.y */
class C0291y implements AppLovinAdDisplayListener {

    /* renamed from: a */
    final /* synthetic */ C0260af f222a;

    /* renamed from: b */
    final /* synthetic */ C0290x f223b;

    C0291y(C0290x xVar, C0260af afVar) {
        this.f223b = xVar;
        this.f222a = afVar;
    }

    public void adDisplayed(AppLovinAd appLovinAd) {
        C0291y.super.show();
        if (!this.f223b.f220h) {
            AppLovinAdDisplayListener d = this.f222a.mo5234d();
            if (d != null) {
                d.adDisplayed(appLovinAd);
            }
            boolean unused = this.f223b.f220h = true;
        }
    }

    public void adHidden(AppLovinAd appLovinAd) {
        this.f223b.f213a.runOnUiThread(this.f223b.f218f);
        AppLovinAdDisplayListener d = this.f222a.mo5234d();
        if (!this.f223b.f221i && d != null) {
            d.adHidden(appLovinAd);
            boolean unused = this.f223b.f221i = true;
        }
        this.f222a.mo5231a(false);
    }
}
