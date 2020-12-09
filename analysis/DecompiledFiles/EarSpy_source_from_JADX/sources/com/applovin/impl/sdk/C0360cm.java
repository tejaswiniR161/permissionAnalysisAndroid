package com.applovin.impl.sdk;

import android.graphics.Point;
import com.applovin.adview.AppLovinInterstitialActivity;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.cm */
class C0360cm extends C0342bv implements C0381dg {

    /* renamed from: a */
    private final AppLovinAdSize f597a;

    /* renamed from: b */
    private final AppLovinAdType f598b;

    /* renamed from: c */
    private final AppLovinAdLoadListener f599c;

    /* renamed from: d */
    private boolean f600d = false;

    C0360cm(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType, AppLovinAdLoadListener appLovinAdLoadListener, AppLovinSdkImpl appLovinSdkImpl) {
        super("FetchNextAd", appLovinSdkImpl);
        this.f597a = appLovinAdSize;
        this.f598b = appLovinAdType;
        this.f599c = appLovinAdLoadListener;
    }

    /* renamed from: a */
    private void m484a(C0349cb cbVar) {
        if (System.currentTimeMillis() - cbVar.mo5598b("ad_session_start") > ((long) ((Integer) this.f438f.mo5363a(C0343bw.f566x)).intValue()) * 60000) {
            cbVar.mo5600b("ad_session_start", System.currentTimeMillis());
            cbVar.mo5602c("ad_imp_session");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m487b(int i) {
        this.f439g.mo5666e(this.f437e, "Unable to fetch " + this.f597a + " ad: server returned " + i);
        try {
            mo5622a(i);
        } catch (Throwable th) {
            this.f439g.userError(this.f437e, "Unable process a failure to recieve an ad", th);
        }
        C0395q.m636b(i, this.f438f);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m488b(JSONObject jSONObject) {
        this.f438f.mo5362a().mo5636a(mo5621a(jSONObject), C0365cr.MAIN);
        C0395q.m633a(jSONObject, this.f438f);
    }

    /* renamed from: d */
    private void m489d(Map map) {
        map.put("api_did", this.f438f.mo5363a(C0343bw.f545c));
        map.put("sdk_key", this.f438f.getSdkKey());
        map.put("sdk_version", AppLovinSdk.VERSION);
        String str = (String) this.f438f.mo5363a(C0343bw.f446F);
        if (str != null && str.length() > 0) {
            map.put("plugin_version", str);
        }
        map.put("accept", m492g());
        map.put("v1", Boolean.toString(C0392n.m609a("android.permission.WRITE_EXTERNAL_STORAGE", this.f440h)));
        map.put("v2", Boolean.toString(C0392n.m608a(AppLovinInterstitialActivity.class, this.f440h)));
        map.put("preloading", String.valueOf(this.f600d));
        map.put("size", this.f597a.getLabel());
        map.put("format", "json");
        map.put("ia", Long.toString(this.f438f.getDataCollector().mo5692b().f690d));
    }

    /* renamed from: e */
    private void m490e(Map map) {
        if (((Boolean) this.f438f.mo5363a(C0343bw.f454N)).booleanValue()) {
            C0349cb b = this.f438f.mo5366b();
            map.put("li", String.valueOf(b.mo5598b("ad_imp")));
            map.put("si", String.valueOf(b.mo5598b("ad_imp_session")));
        }
    }

    /* renamed from: f */
    private void m491f(Map map) {
        Map a;
        if (((Boolean) this.f438f.mo5363a(C0343bw.f454N)).booleanValue() && (a = ((C0391m) this.f438f.getTargetingData()).mo5674a()) != null && !a.isEmpty()) {
            map.putAll(a);
        }
    }

    /* renamed from: g */
    private String m492g() {
        return (!C0392n.m610b() || !C0392n.m608a(AppLovinInterstitialActivity.class, this.f440h)) ? "custom_size,launch_app" : "custom_size,launch_app" + ",video";
    }

    /* renamed from: g */
    private void m493g(Map map) {
        Map a = C0293a.m233a(this.f438f);
        if (a.isEmpty()) {
            try {
                m494h(a);
                C0293a.m235a(a, this.f438f);
            } catch (Exception e) {
                this.f439g.mo5667e(this.f437e, "Unable to populate device information", e);
            }
        }
        map.putAll(a);
        map.put("network", C0395q.m627a(this.f438f));
        m496j(map);
        map.put("vz", C0382dh.m583a(this.f438f.getApplicationContext().getPackageName(), this.f438f));
    }

    /* renamed from: h */
    private void m494h(Map map) {
        C0399u a = this.f438f.getDataCollector().mo5690a();
        map.put("brand", C0382dh.m590c(a.f693c));
        map.put("carrier", C0382dh.m590c(a.f697g));
        map.put("locale", a.f698h.toString());
        map.put("model", C0382dh.m590c(a.f691a));
        map.put("os", C0382dh.m590c(a.f692b));
        map.put("platform", "android");
        map.put("revision", C0382dh.m590c(a.f694d));
        m495i(map);
    }

    /* renamed from: i */
    private void m495i(Map map) {
        Point a = C0392n.m606a(this.f438f.getApplicationContext());
        map.put("dx", Integer.toString(a.x));
        map.put("dy", Integer.toString(a.y));
    }

    /* renamed from: j */
    private void m496j(Map map) {
        C0397s c = this.f438f.getDataCollector().mo5693c();
        String str = c.f686b;
        boolean z = c.f685a;
        if ((!z || ((Boolean) this.f438f.getSettingsManager().mo5545a(C0343bw.f525be)).booleanValue()) && AppLovinSdkUtils.isValidString(str)) {
            map.put("idfa", str);
        }
        map.put("dnt", Boolean.toString(z));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0342bv mo5621a(JSONObject jSONObject) {
        return new C0369cv(jSONObject, this.f599c, this.f438f);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5622a(int i) {
        if (this.f599c == null) {
            return;
        }
        if (this.f599c instanceof C0401w) {
            ((C0401w) this.f599c).mo5462a(new C0347c(this.f597a, this.f598b), i);
        } else {
            this.f599c.failedToReceiveAd(i);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo5623a(Map map) {
        m491f(map);
        m493g(map);
        m490e(map);
        m489d(map);
        mo5625b(map);
        mo5627c(map);
    }

    /* renamed from: a */
    public void mo5624a(boolean z) {
        this.f600d = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5538b() {
        super.mo5538b();
        m487b(-410);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5625b(Map map) {
        if (this.f598b != null) {
            map.put("require", this.f598b.getLabel());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo5626c() {
        HashMap hashMap = new HashMap();
        mo5623a((Map) hashMap);
        return mo5628d() + "?" + C0382dh.m585a((Map) hashMap);
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo5627c(Map map) {
        C0378dd a = C0376db.m561a().mo5651a("tFNA");
        if (a != null) {
            map.put("etf", Long.toString(a.mo5654b()));
            map.put("ntf", a.mo5653a());
        }
        C0378dd a2 = C0376db.m561a().mo5651a("tRA");
        if (a2 != null) {
            map.put("etr", Long.toString(a2.mo5654b()));
            map.put("ntr", a2.mo5653a());
            map.put("fvr", a2.mo5655c() ? "1" : "0");
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public String mo5628d() {
        return C0395q.m635b("2.0/ad", this.f438f);
    }

    /* renamed from: e */
    public String mo5629e() {
        return "tFNA";
    }

    /* renamed from: f */
    public boolean mo5630f() {
        return false;
    }

    public void run() {
        if (this.f600d) {
            this.f439g.mo5665d(this.f437e, "Preloading next ad...");
        } else {
            this.f439g.mo5665d(this.f437e, "Fetching next ad...");
        }
        C0349cb b = this.f438f.mo5366b();
        b.mo5596a("ad_req");
        m484a(b);
        try {
            C0361cn cnVar = new C0361cn(this, "RepeatFetchNextAd", C0343bw.f551i, this.f438f);
            cnVar.mo5648a(C0343bw.f554l);
            cnVar.run();
        } catch (Throwable th) {
            this.f439g.mo5667e(this.f437e, "Unable to fetch " + this.f597a + " ad", th);
            m487b(0);
        }
    }
}
