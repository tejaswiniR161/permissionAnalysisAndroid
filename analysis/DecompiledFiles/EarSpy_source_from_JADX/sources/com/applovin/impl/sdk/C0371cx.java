package com.applovin.impl.sdk;

import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.cx */
abstract class C0371cx extends C0342bv implements C0394p {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f632a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public long f633b;

    /* renamed from: c */
    private final C0394p f634c;

    /* renamed from: d */
    private C0345by f635d;

    C0371cx(String str, int i, AppLovinSdkImpl appLovinSdkImpl) {
        super(str, appLovinSdkImpl);
        this.f633b = -1;
        this.f635d = null;
        this.f632a = i;
        this.f634c = new C0372cy(this, appLovinSdkImpl, str);
    }

    C0371cx(String str, C0345by byVar, AppLovinSdkImpl appLovinSdkImpl) {
        this(str, ((Integer) appLovinSdkImpl.mo5363a(byVar)).intValue(), appLovinSdkImpl);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m549c() {
        if (this.f635d != null) {
            C0346bz settingsManager = this.f438f.getSettingsManager();
            settingsManager.mo5546a(this.f635d, this.f635d.mo5542c());
            settingsManager.mo5549b();
        }
    }

    /* renamed from: a */
    public void mo5534a(int i) {
    }

    /* renamed from: a */
    public void mo5647a(long j) {
        this.f633b = j;
    }

    /* renamed from: a */
    public void mo5648a(C0345by byVar) {
        this.f635d = byVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void mo5535a(C0393o oVar, C0394p pVar);

    /* renamed from: a */
    public void mo5536a(JSONObject jSONObject, int i) {
    }

    public void run() {
        mo5535a(this.f438f.getConnectionManager(), this.f634c);
    }
}
