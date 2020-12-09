package com.applovin.impl.sdk;

import android.content.Context;
import com.applovin.sdk.AppLovinLogger;

/* renamed from: com.applovin.impl.sdk.bv */
abstract class C0342bv implements Runnable {

    /* renamed from: e */
    final String f437e;

    /* renamed from: f */
    protected final AppLovinSdkImpl f438f;

    /* renamed from: g */
    final AppLovinLogger f439g;

    /* renamed from: h */
    final Context f440h;

    C0342bv(String str, AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f438f = appLovinSdkImpl;
        this.f437e = str == null ? getClass().getSimpleName() : str;
        this.f439g = appLovinSdkImpl.getLogger();
        this.f440h = appLovinSdkImpl.getApplicationContext();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo5537a() {
        return this.f437e;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5538b() {
    }
}
