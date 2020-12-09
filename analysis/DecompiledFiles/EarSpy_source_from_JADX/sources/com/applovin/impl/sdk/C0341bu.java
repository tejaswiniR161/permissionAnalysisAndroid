package com.applovin.impl.sdk;

import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.bu */
class C0341bu extends C0371cx {

    /* renamed from: a */
    final /* synthetic */ String f433a;

    /* renamed from: b */
    final /* synthetic */ JSONObject f434b;

    /* renamed from: c */
    final /* synthetic */ C0394p f435c;

    /* renamed from: d */
    final /* synthetic */ C0340bt f436d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0341bu(C0340bt btVar, String str, C0345by byVar, AppLovinSdkImpl appLovinSdkImpl, String str2, JSONObject jSONObject, C0394p pVar) {
        super(str, byVar, appLovinSdkImpl);
        this.f436d = btVar;
        this.f433a = str2;
        this.f434b = jSONObject;
        this.f435c = pVar;
    }

    /* renamed from: a */
    public void mo5534a(int i) {
        this.f435c.mo5534a(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5535a(C0393o oVar, C0394p pVar) {
        oVar.mo5689a(C0395q.m629a(C0395q.m630a(this.f433a, this.f438f)), this.f434b, pVar);
    }

    /* renamed from: a */
    public void mo5536a(JSONObject jSONObject, int i) {
        this.f435c.mo5536a(jSONObject, i);
    }
}
