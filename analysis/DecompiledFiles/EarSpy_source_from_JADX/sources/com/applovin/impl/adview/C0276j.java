package com.applovin.impl.adview;

/* renamed from: com.applovin.impl.adview.j */
class C0276j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ AdViewControllerImpl f168a;

    private C0276j(AdViewControllerImpl adViewControllerImpl) {
        this.f168a = adViewControllerImpl;
    }

    /* synthetic */ C0276j(AdViewControllerImpl adViewControllerImpl, C0254a aVar) {
        this(adViewControllerImpl);
    }

    public void run() {
        try {
            this.f168a.f91h.loadDataWithBaseURL("/", "<html></html>", "text/html", (String) null, "");
        } catch (Exception e) {
        }
    }
}
