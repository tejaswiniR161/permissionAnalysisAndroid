package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.de */
class C0379de extends C0340bt {

    /* renamed from: a */
    private final AppLovinAdImpl f648a;

    /* renamed from: b */
    private final AppLovinAdRewardListener f649b;

    /* renamed from: c */
    private final Object f650c = new Object();

    /* renamed from: d */
    private volatile boolean f651d = false;

    public C0379de(AppLovinSdkImpl appLovinSdkImpl, AppLovinAd appLovinAd, AppLovinAdRewardListener appLovinAdRewardListener) {
        super("TaskValidateReward", appLovinSdkImpl);
        this.f648a = (AppLovinAdImpl) appLovinAd;
        this.f649b = appLovinAdRewardListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m567a(int i) {
        if (!mo5657c()) {
            String str = "network_timeout";
            if (i < 400 || i > 500) {
                this.f649b.validationRequestFailed(this.f648a, i);
            } else {
                this.f649b.userRewardRejected(this.f648a, new HashMap(0));
                str = "rejected";
            }
            C0332bl.m330a().mo5502a((AppLovinAd) this.f648a, str);
        }
    }

    /* renamed from: a */
    private void m570a(String str, Map map) {
        if (!mo5657c()) {
            C0332bl a = C0332bl.m330a();
            a.mo5502a((AppLovinAd) this.f648a, str);
            a.mo5503a((AppLovinAd) this.f648a, map);
            if (str.equals("accepted")) {
                this.f649b.userRewardVerified(this.f648a, map);
            } else if (str.equals("quota_exceeded")) {
                this.f649b.userOverQuota(this.f648a, map);
            } else if (str.equals("rejected")) {
                this.f649b.userRewardRejected(this.f648a, map);
            } else {
                this.f649b.validationRequestFailed(this.f648a, AppLovinErrorCodes.INCENTIVIZED_UNKNOWN_SERVER_ERROR);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m571a(JSONObject jSONObject) {
        Map hashMap;
        String str;
        if (!mo5657c()) {
            try {
                JSONObject a = C0395q.m631a(jSONObject);
                C0395q.m633a(a, this.f438f);
                try {
                    hashMap = C0317ax.m266a((JSONObject) a.get("params"));
                } catch (Throwable th) {
                    hashMap = new HashMap(0);
                }
                try {
                    str = a.getString("result");
                } catch (Throwable th2) {
                    str = "network_timeout";
                }
                m570a(str, hashMap);
            } catch (JSONException e) {
                this.f439g.mo5667e(this.f437e, "Unable to parse API response", e);
            }
        }
    }

    /* renamed from: a */
    public void mo5656a(boolean z) {
        synchronized (this.f650c) {
            this.f651d = z;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo5657c() {
        boolean z;
        synchronized (this.f650c) {
            z = this.f651d;
        }
        return z;
    }

    public void run() {
        String b = C0404z.m668b();
        String clCode = this.f648a.getClCode();
        HashMap hashMap = new HashMap(2);
        if (AppLovinSdkUtils.isValidString(clCode)) {
            hashMap.put("clcode", clCode);
        } else {
            hashMap.put("clcode", "NO_CLCODE");
        }
        if (b != null) {
            hashMap.put("user_id", b);
        }
        mo5533a("vr", new JSONObject(hashMap), new C0380df(this));
    }
}
