package com.applovin.impl.sdk;

import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.cl */
class C0359cl extends C0371cx {

    /* renamed from: a */
    final /* synthetic */ C0358ck f596a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0359cl(C0358ck ckVar, String str, int i, AppLovinSdkImpl appLovinSdkImpl) {
        super(str, i, appLovinSdkImpl);
        this.f596a = ckVar;
    }

    /* renamed from: a */
    public void mo5534a(int i) {
        this.f596a.f592c.onPostbackFailure(this.f596a.f590a, i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5535a(C0393o oVar, C0394p pVar) {
        int intValue = this.f596a.f595j < 0 ? ((Integer) this.f438f.mo5363a(C0343bw.f473aF)).intValue() : this.f596a.f595j;
        if (this.f596a.f591b == null) {
            oVar.mo5687a(this.f596a.f590a, intValue, false, pVar);
        } else {
            oVar.mo5686a(this.f596a.f590a, intValue, new JSONObject(this.f596a.f591b), false, pVar);
        }
    }

    /* renamed from: a */
    public void mo5536a(JSONObject jSONObject, int i) {
        this.f596a.f592c.onPostbackSuccess(this.f596a.f590a);
    }
}
