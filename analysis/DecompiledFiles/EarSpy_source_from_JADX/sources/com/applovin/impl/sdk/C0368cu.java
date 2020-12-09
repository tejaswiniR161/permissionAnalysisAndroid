package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinSdkSettings;

/* renamed from: com.applovin.impl.sdk.cu */
class C0368cu implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C0364cq f620a;

    /* renamed from: b */
    private final String f621b;

    /* renamed from: c */
    private final C0342bv f622c;

    /* renamed from: d */
    private final C0365cr f623d;

    C0368cu(C0364cq cqVar, C0342bv bvVar, C0365cr crVar) {
        this.f620a = cqVar;
        this.f621b = bvVar.mo5537a();
        this.f622c = bvVar;
        this.f623d = crVar;
    }

    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            C0392n.m607a();
            if (this.f620a.f608a.mo5369e()) {
                this.f620a.f609b.mo5668i(this.f621b, "Task re-scheduled...");
                this.f620a.mo5637a(this.f622c, this.f623d, 2000);
            } else if (this.f620a.f608a.isEnabled()) {
                this.f620a.f609b.mo5668i(this.f621b, "Task started execution...");
                this.f622c.run();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                if (this.f622c instanceof C0381dg) {
                    C0381dg dgVar = (C0381dg) this.f622c;
                    C0376db.m561a().mo5652a(dgVar.mo5629e(), currentTimeMillis2, C0395q.m627a(this.f620a.f608a), dgVar.mo5630f());
                }
                this.f620a.f609b.mo5668i(this.f621b, "Task executed successfully in " + currentTimeMillis2 + "ms.");
                C0349cb b = this.f620a.f608a.mo5366b();
                b.mo5596a(this.f621b + "_count");
                b.mo5597a(this.f621b + "_time", currentTimeMillis2);
            } else {
                if (this.f620a.f608a.mo5370f()) {
                    this.f620a.f608a.mo5364a((AppLovinSdkSettings) null);
                } else {
                    this.f620a.f609b.mo5671w(this.f621b, "Task not executed, SDK is disabled");
                }
                this.f622c.mo5538b();
            }
        } catch (Throwable th) {
            this.f620a.f609b.mo5667e(this.f621b, "Task failed execution in " + (System.currentTimeMillis() - currentTimeMillis) + "ms.", th);
        }
    }
}
