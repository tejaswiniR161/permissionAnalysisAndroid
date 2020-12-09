package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.cz */
class C0373cz extends C0340bt {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final AppLovinAdImpl f639a;

    public C0373cz(AppLovinSdkImpl appLovinSdkImpl, AppLovinAd appLovinAd) {
        super("TaskReportReward", appLovinSdkImpl);
        this.f639a = (AppLovinAdImpl) appLovinAd;
    }

    public void run() {
        String b = C0404z.m668b();
        String clCode = this.f639a.getClCode();
        HashMap hashMap = new HashMap(2);
        if (AppLovinSdkUtils.isValidString(clCode)) {
            hashMap.put("clcode", clCode);
        } else {
            hashMap.put("clcode", "NO_CLCODE");
        }
        if (b != null) {
            hashMap.put("user_id", b);
        }
        C0332bl a = C0332bl.m330a();
        String b2 = a.mo5504b(this.f639a);
        if (b2 != null) {
            hashMap.put("result", b2);
            Map a2 = a.mo5501a(this.f639a);
            if (a2 != null) {
                hashMap.put("params", a2);
            }
            mo5533a("cr", new JSONObject(hashMap), new C0375da(this));
            return;
        }
        this.f439g.mo5665d("TaskReportReward", "No reward result was found for ad: " + this.f639a);
    }
}
