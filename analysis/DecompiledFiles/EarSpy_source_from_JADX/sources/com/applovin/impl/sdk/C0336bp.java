package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinPostbackListener;

/* renamed from: com.applovin.impl.sdk.bp */
class C0336bp implements AppLovinPostbackListener {

    /* renamed from: a */
    final /* synthetic */ AppLovinPostbackListener f418a;

    /* renamed from: b */
    final /* synthetic */ PostbackServiceImpl f419b;

    C0336bp(PostbackServiceImpl postbackServiceImpl, AppLovinPostbackListener appLovinPostbackListener) {
        this.f419b = postbackServiceImpl;
        this.f418a = appLovinPostbackListener;
    }

    public void onPostbackFailure(String str, int i) {
        this.f419b.f305a.getLogger().mo5666e("PostbackService", "Failed to dispatch postback to URL " + str + ": " + i);
        if (this.f418a != null) {
            this.f418a.onPostbackFailure(str, i);
        }
    }

    public void onPostbackSuccess(String str) {
        this.f419b.f305a.getLogger().mo5665d("PostbackService", "Successfully dispatched postback to URL " + str);
        if (this.f418a != null) {
            this.f418a.onPostbackSuccess(str);
        }
    }
}
