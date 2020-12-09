package com.applovin.impl.sdk;

import android.util.Log;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.cy */
class C0372cy implements C0394p {

    /* renamed from: a */
    final /* synthetic */ AppLovinSdkImpl f636a;

    /* renamed from: b */
    final /* synthetic */ String f637b;

    /* renamed from: c */
    final /* synthetic */ C0371cx f638c;

    C0372cy(C0371cx cxVar, AppLovinSdkImpl appLovinSdkImpl, String str) {
        this.f638c = cxVar;
        this.f636a = appLovinSdkImpl;
        this.f637b = str;
    }

    /* renamed from: a */
    public void mo5534a(int i) {
        boolean z = true;
        boolean z2 = i < 200 || i >= 500;
        if (i == -103) {
            z = false;
        }
        if (!z2 || !z || this.f638c.f632a <= 0) {
            this.f638c.mo5534a(i);
            return;
        }
        long longValue = this.f638c.f633b < 0 ? ((Long) this.f636a.mo5363a(C0343bw.f556n)).longValue() : this.f638c.f633b;
        Log.w(this.f637b, "Unable to send request due to server failure (code " + i + "). " + this.f638c.f632a + " attempts left, retrying in " + (((double) longValue) / 1000.0d) + " seconds...");
        int unused = this.f638c.f632a = this.f638c.f632a - 1;
        if (this.f638c.f632a == 0) {
            this.f638c.m549c();
        }
        this.f636a.mo5362a().mo5637a((C0342bv) this.f638c, C0365cr.BACKGROUND, longValue);
    }

    /* renamed from: a */
    public void mo5536a(JSONObject jSONObject, int i) {
        int unused = this.f638c.f632a = 0;
        this.f638c.mo5536a(jSONObject, i);
    }
}
