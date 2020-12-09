package com.applovin.impl.adview;

/* renamed from: com.applovin.impl.adview.aj */
class C0264aj implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f144a;

    /* renamed from: b */
    final /* synthetic */ C0260af f145b;

    C0264aj(C0260af afVar, int i) {
        this.f145b = afVar;
        this.f144a = i;
    }

    public void run() {
        if (this.f145b.f131g != null) {
            this.f145b.f131g.failedToReceiveAd(this.f144a);
        }
    }
}
