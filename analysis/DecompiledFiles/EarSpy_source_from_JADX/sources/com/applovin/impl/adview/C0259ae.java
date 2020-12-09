package com.applovin.impl.adview;

/* renamed from: com.applovin.impl.adview.ae */
class C0259ae implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0290x f123a;

    private C0259ae(C0290x xVar) {
        this.f123a = xVar;
    }

    /* synthetic */ C0259ae(C0290x xVar, C0291y yVar) {
        this(xVar);
    }

    public void run() {
        try {
            this.f123a.dismiss();
        } catch (Throwable th) {
            if (this.f123a.f215c != null) {
                this.f123a.f215c.mo5667e("InterstitialAdDialog", "dismiss() threw exception", th);
            }
        }
    }
}
