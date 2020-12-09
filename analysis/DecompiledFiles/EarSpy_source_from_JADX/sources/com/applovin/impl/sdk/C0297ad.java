package com.applovin.impl.sdk;

/* renamed from: com.applovin.impl.sdk.ad */
class C0297ad implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f313a;

    /* renamed from: b */
    final /* synthetic */ C0295ab f314b;

    C0297ad(C0295ab abVar, int i) {
        this.f314b = abVar;
        this.f313a = i;
    }

    public void run() {
        this.f314b.f310b.failedToReceiveAd(this.f313a);
    }
}
