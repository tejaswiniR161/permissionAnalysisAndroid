package com.applovin.impl.sdk;

import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.bt */
abstract class C0340bt extends C0342bv {
    protected C0340bt(String str, AppLovinSdkImpl appLovinSdkImpl) {
        super(str, appLovinSdkImpl);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5533a(String str, JSONObject jSONObject, C0394p pVar) {
        C0341bu buVar = new C0341bu(this, "Repeat" + this.f437e, C0343bw.f550h, this.f438f, str, jSONObject, pVar);
        buVar.mo5648a(C0343bw.f553k);
        buVar.run();
    }
}
