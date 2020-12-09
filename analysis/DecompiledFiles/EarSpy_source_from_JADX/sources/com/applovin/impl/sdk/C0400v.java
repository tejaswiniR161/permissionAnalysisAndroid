package com.applovin.impl.sdk;

/* renamed from: com.applovin.impl.sdk.v */
class C0400v implements C0357cj {

    /* renamed from: a */
    final /* synthetic */ C0339bs f699a;

    /* renamed from: b */
    final /* synthetic */ EventServiceImpl f700b;

    C0400v(EventServiceImpl eventServiceImpl, C0339bs bsVar) {
        this.f700b = eventServiceImpl;
        this.f699a = bsVar;
    }

    /* renamed from: a */
    public void mo5616a(C0397s sVar) {
        try {
            this.f700b.f284a.getPersistentPostbackManager().mo5506a(this.f700b.m227a(this.f699a, sVar).toString(), this.f699a.mo5528b());
        } catch (Exception e) {
            this.f700b.f284a.getLogger().mo5667e("EventServiceImpl", "Unable to track event due to failure to convert event parameters into JSONObject for event: " + this.f699a, e);
        }
    }
}
