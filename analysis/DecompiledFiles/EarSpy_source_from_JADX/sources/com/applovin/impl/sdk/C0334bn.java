package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinPostbackListener;

/* renamed from: com.applovin.impl.sdk.bn */
class C0334bn implements AppLovinPostbackListener {

    /* renamed from: a */
    final /* synthetic */ C0335bo f412a;

    /* renamed from: b */
    final /* synthetic */ C0333bm f413b;

    C0334bn(C0333bm bmVar, C0335bo boVar) {
        this.f413b = bmVar;
        this.f412a = boVar;
    }

    public void onPostbackFailure(String str, int i) {
        this.f413b.f407b.mo5668i("PersistentPostbackManager", "Failed to submit postback with errorCode " + i + ". Will retry later...  Postback: " + this.f412a);
        this.f413b.m345e(this.f412a);
    }

    public void onPostbackSuccess(String str) {
        this.f413b.m344d(this.f412a);
        this.f413b.f407b.mo5665d("PersistentPostbackManager", "Successfully submitted postback: " + this.f412a);
        this.f413b.mo5507b();
    }
}
