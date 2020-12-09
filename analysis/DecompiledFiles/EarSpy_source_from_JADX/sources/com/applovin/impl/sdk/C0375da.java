package com.applovin.impl.sdk;

import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.da */
class C0375da implements C0394p {

    /* renamed from: a */
    final /* synthetic */ C0373cz f640a;

    C0375da(C0373cz czVar) {
        this.f640a = czVar;
    }

    /* renamed from: a */
    public void mo5534a(int i) {
        this.f640a.f439g.mo5665d("TaskReportReward", "Failed to report reward for ad: " + this.f640a.f639a.getAdIdNumber() + " - error code: " + i);
    }

    /* renamed from: a */
    public void mo5536a(JSONObject jSONObject, int i) {
        this.f640a.f439g.mo5665d("TaskReportReward", "Reported reward successfully for ad: " + this.f640a.f639a.getAdIdNumber());
    }
}
