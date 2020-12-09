package com.applovin.impl.adview;

/* renamed from: com.applovin.impl.adview.ah */
class C0262ah implements Runnable {

    /* renamed from: a */
    final /* synthetic */ boolean f139a;

    /* renamed from: b */
    final /* synthetic */ boolean f140b;

    /* renamed from: c */
    final /* synthetic */ C0260af f141c;

    C0262ah(C0260af afVar, boolean z, boolean z2) {
        this.f141c = afVar;
        this.f139a = z;
        this.f140b = z2;
    }

    public void run() {
        if (!this.f139a || !this.f140b) {
            this.f141c.m124h();
        } else {
            this.f141c.m125i();
        }
    }
}
