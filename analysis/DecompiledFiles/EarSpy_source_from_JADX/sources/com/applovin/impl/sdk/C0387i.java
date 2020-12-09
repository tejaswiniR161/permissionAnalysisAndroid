package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import java.util.Collection;
import java.util.HashSet;

/* renamed from: com.applovin.impl.sdk.i */
class C0387i {

    /* renamed from: a */
    final AppLovinAdSize f664a;

    /* renamed from: b */
    final Object f665b;

    /* renamed from: c */
    AppLovinAd f666c;

    /* renamed from: d */
    long f667d;

    /* renamed from: e */
    boolean f668e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final Collection f669f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public final Collection f670g;

    private C0387i(AppLovinAdSize appLovinAdSize) {
        this.f669f = new HashSet();
        this.f670g = new HashSet();
        this.f664a = appLovinAdSize;
        this.f665b = new Object();
        this.f666c = null;
        this.f667d = 0;
        this.f668e = false;
    }

    /* synthetic */ C0387i(AppLovinAdSize appLovinAdSize, C0383e eVar) {
        this(appLovinAdSize);
    }
}
