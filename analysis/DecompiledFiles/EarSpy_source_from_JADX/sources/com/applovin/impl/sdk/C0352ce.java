package com.applovin.impl.sdk;

import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ce */
class C0352ce extends C0371cx {

    /* renamed from: a */
    final /* synthetic */ JSONObject f583a;

    /* renamed from: b */
    final /* synthetic */ C0351cd f584b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0352ce(C0351cd cdVar, String str, C0345by byVar, AppLovinSdkImpl appLovinSdkImpl, JSONObject jSONObject) {
        super(str, byVar, appLovinSdkImpl);
        this.f584b = cdVar;
        this.f583a = jSONObject;
    }

    /* renamed from: a */
    public void mo5534a(int i) {
        C0395q.m632a(i, this.f438f);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5535a(C0393o oVar, C0394p pVar) {
        oVar.mo5689a(C0395q.m630a("device", this.f438f), this.f583a, pVar);
    }

    /* renamed from: a */
    public void mo5536a(JSONObject jSONObject, int i) {
        this.f584b.mo5605a(jSONObject);
    }
}
