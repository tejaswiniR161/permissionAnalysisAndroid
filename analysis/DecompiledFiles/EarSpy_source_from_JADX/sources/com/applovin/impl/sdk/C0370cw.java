package com.applovin.impl.sdk;

import com.applovin.nativeAds.AppLovinNativeAdLoadListener;
import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.cw */
class C0370cw extends C0342bv {

    /* renamed from: a */
    private final AppLovinNativeAdLoadListener f630a;

    /* renamed from: b */
    private final JSONObject f631b;

    C0370cw(JSONObject jSONObject, AppLovinSdkImpl appLovinSdkImpl, AppLovinNativeAdLoadListener appLovinNativeAdLoadListener) {
        super("TaskRenderWidget", appLovinSdkImpl);
        this.f630a = appLovinNativeAdLoadListener;
        this.f631b = jSONObject;
    }

    /* renamed from: a */
    private String m540a(Map map, String str) {
        String str2 = (String) map.get("simp_url");
        if (AppLovinSdkUtils.isValidString(str2)) {
            return str2.replace("{CLCODE}", str);
        }
        throw new IllegalArgumentException("No impression URL available");
    }

    /* renamed from: a */
    private String m541a(Map map, String str, String str2) {
        String str3 = (String) map.get("click_url");
        if (!AppLovinSdkUtils.isValidString(str3)) {
            throw new IllegalArgumentException("No impression URL available");
        }
        if (str2 == null) {
            str2 = "";
        }
        return str3.replace("{CLCODE}", str).replace("{EVENT_ID}", str2);
    }

    /* renamed from: a */
    private void m542a(JSONObject jSONObject) {
        List<Map> a = C0317ax.m265a(jSONObject.getJSONArray("native_ads"));
        Map a2 = C0317ax.m266a(jSONObject.getJSONObject("native_settings"));
        ArrayList arrayList = new ArrayList(a.size());
        for (Map map : a) {
            String str = (String) map.get("clcode");
            NativeAdImpl a3 = new C0321ba().mo5482e((String) map.get("title")).mo5483f((String) map.get("description")).mo5484g((String) map.get("caption")).mo5493p((String) map.get("cta")).mo5478a((String) map.get("icon_url")).mo5479b((String) map.get("image_url")).mo5481d((String) map.get("video_url")).mo5480c((String) map.get("star_rating_url")).mo5485h((String) map.get("icon_url")).mo5486i((String) map.get("image_url")).mo5487j((String) map.get("video_url")).mo5475a(Float.parseFloat((String) map.get("star_rating"))).mo5492o(str).mo5488k(m540a(a2, str)).mo5489l(m541a(a2, str, (String) map.get("event_id"))).mo5490m(m543b(a2, str)).mo5491n(m544c(a2, str)).mo5476a(Long.parseLong((String) map.get("ad_id"))).mo5477a(this.f438f).mo5474a();
            arrayList.add(a3);
            this.f438f.getLogger().mo5665d("TaskRenderWidget", "Prepared slot: " + a3.getAdId());
        }
        if (this.f630a != null) {
            this.f630a.onNativeAdsLoaded(arrayList);
        }
    }

    /* renamed from: b */
    private String m543b(Map map, String str) {
        String str2 = (String) map.get("video_start_url");
        if (str2 != null) {
            return str2.replace("{CLCODE}", str);
        }
        return null;
    }

    /* renamed from: c */
    private String m544c(Map map, String str) {
        String str2 = (String) map.get("video_end_url");
        if (str2 != null) {
            return str2.replace("{CLCODE}", str);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5645a(int i) {
        try {
            if (this.f630a != null) {
                this.f630a.onNativeAdsFailedToLoad(i);
            }
        } catch (Exception e) {
            this.f438f.getLogger().mo5667e("TaskRenderWidget", "Unable to notify listener about failure.", e);
        }
    }

    public void run() {
        try {
            if (this.f631b == null || this.f631b.length() == 0) {
                mo5645a((int) AppLovinErrorCodes.UNABLE_TO_PREPARE_NATIVE_AD);
            } else {
                m542a(this.f631b);
            }
        } catch (Exception e) {
            this.f438f.getLogger().mo5667e("TaskRenderWidget", "Unable to render widget.", e);
            mo5645a((int) AppLovinErrorCodes.UNABLE_TO_PRECACHE_RESOURCES);
        }
    }
}
