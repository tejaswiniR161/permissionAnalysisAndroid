package com.applovin.impl.sdk;

import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.cn */
class C0361cn extends C0371cx {

    /* renamed from: a */
    final /* synthetic */ C0360cm f601a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0361cn(C0360cm cmVar, String str, C0345by byVar, AppLovinSdkImpl appLovinSdkImpl) {
        super(str, byVar, appLovinSdkImpl);
        this.f601a = cmVar;
    }

    /* renamed from: a */
    public void mo5534a(int i) {
        this.f601a.m487b(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5535a(C0393o oVar, C0394p pVar) {
        oVar.mo5685a(this.f601a.mo5626c(), ((Integer) this.f438f.mo5363a(C0343bw.f563u)).intValue(), pVar);
    }

    /* renamed from: a */
    public void mo5536a(JSONObject jSONObject, int i) {
        if (i == 200) {
            this.f601a.m488b(jSONObject);
        } else {
            this.f601a.m487b(i);
        }
    }
}
