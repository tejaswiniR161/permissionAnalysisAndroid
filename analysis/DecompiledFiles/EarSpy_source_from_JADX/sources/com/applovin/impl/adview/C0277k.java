package com.applovin.impl.adview;

/* renamed from: com.applovin.impl.adview.k */
class C0277k implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdViewControllerImpl f169a;

    private C0277k(AdViewControllerImpl adViewControllerImpl) {
        this.f169a = adViewControllerImpl;
    }

    /* synthetic */ C0277k(AdViewControllerImpl adViewControllerImpl, C0254a aVar) {
        this(adViewControllerImpl);
    }

    public void run() {
        if (this.f169a.f96m != null) {
            AdViewControllerImpl.m103b(this.f169a.f91h, this.f169a.f96m.getSize());
            this.f169a.f91h.mo5274a(this.f169a.f96m);
        }
    }
}
