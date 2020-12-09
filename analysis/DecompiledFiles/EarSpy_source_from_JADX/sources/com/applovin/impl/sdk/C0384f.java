package com.applovin.impl.sdk;

/* renamed from: com.applovin.impl.sdk.f */
class C0384f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0383e f660a;

    C0384f(C0383e eVar) {
        this.f660a = eVar;
    }

    public void run() {
        if (!this.f660a.f655a.isForegroundClickInvalidated()) {
            this.f660a.f659e.m199a(this.f660a.f656b, this.f660a.f657c, this.f660a.f658d, this.f660a.f655a);
        }
    }
}
