package com.applovin.impl.sdk;

import android.net.Uri;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.adview.AdViewControllerImpl;
import com.applovin.sdk.AppLovinPostbackListener;

/* renamed from: com.applovin.impl.sdk.e */
class C0383e implements AppLovinPostbackListener {

    /* renamed from: a */
    final /* synthetic */ AdViewControllerImpl f655a;

    /* renamed from: b */
    final /* synthetic */ Uri f656b;

    /* renamed from: c */
    final /* synthetic */ AppLovinAdImpl f657c;

    /* renamed from: d */
    final /* synthetic */ AppLovinAdView f658d;

    /* renamed from: e */
    final /* synthetic */ AppLovinAdServiceImpl f659e;

    C0383e(AppLovinAdServiceImpl appLovinAdServiceImpl, AdViewControllerImpl adViewControllerImpl, Uri uri, AppLovinAdImpl appLovinAdImpl, AppLovinAdView appLovinAdView) {
        this.f659e = appLovinAdServiceImpl;
        this.f655a = adViewControllerImpl;
        this.f656b = uri;
        this.f657c = appLovinAdImpl;
        this.f658d = appLovinAdView;
    }

    public void onPostbackFailure(String str, int i) {
        this.f659e.f259c.post(new C0385g(this));
    }

    public void onPostbackSuccess(String str) {
        this.f659e.f259c.post(new C0384f(this));
    }
}
