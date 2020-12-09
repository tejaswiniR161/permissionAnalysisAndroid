package com.applovin.impl.sdk;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.cd */
class C0351cd extends C0342bv {
    C0351cd(AppLovinSdkImpl appLovinSdkImpl) {
        super("SubmitData", appLovinSdkImpl);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5605a(JSONObject jSONObject) {
        try {
            JSONObject a = C0395q.m631a(jSONObject);
            C0346bz settingsManager = this.f438f.getSettingsManager();
            settingsManager.mo5546a(C0343bw.f545c, a.getString("device_id"));
            settingsManager.mo5546a(C0343bw.f547e, a.getString("device_token"));
            settingsManager.mo5546a(C0343bw.f546d, a.getString("publisher_id"));
            settingsManager.mo5549b();
            C0395q.m633a(a, this.f438f);
            if (a.has("adserver_parameters")) {
                settingsManager.mo5546a(C0343bw.f567y, a.getJSONObject("adserver_parameters").toString());
            }
        } catch (JSONException e) {
            this.f439g.mo5667e(this.f437e, "Unable to parse API response", e);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5606b(JSONObject jSONObject) {
        C0396r dataCollector = this.f438f.getDataCollector();
        C0398t b = dataCollector.mo5692b();
        C0399u a = dataCollector.mo5690a();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("model", a.f691a);
        jSONObject2.put("os", a.f692b);
        jSONObject2.put("brand", a.f693c);
        jSONObject2.put("sdk_version", a.f695e);
        jSONObject2.put("revision", a.f694d);
        jSONObject2.put("country_code", a.f696f);
        jSONObject2.put("carrier", a.f697g);
        jSONObject2.put("type", "android");
        C0397s c = dataCollector.mo5693c();
        String str = c.f686b;
        boolean z = c.f685a;
        if ((!z || ((Boolean) this.f438f.getSettingsManager().mo5545a(C0343bw.f525be)).booleanValue()) && AppLovinSdkUtils.isValidString(str)) {
            jSONObject2.put("idfa", str);
        }
        jSONObject2.put("dnt", z);
        Locale locale = a.f698h;
        if (locale != null) {
            jSONObject2.put("locale", locale.toString());
        }
        jSONObject.put("device_info", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("package_name", b.f689c);
        jSONObject3.put("app_name", b.f687a);
        jSONObject3.put("app_version", b.f688b);
        jSONObject3.put("installed_at", b.f690d);
        jSONObject3.put("applovin_sdk_version", AppLovinSdk.VERSION);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f440h);
        String string = defaultSharedPreferences.getString("com.applovin.sdk.impl.isFirstRun", (String) null);
        if (AppLovinSdkUtils.isValidString(string)) {
            jSONObject3.put("first_install", string);
            if (string.equalsIgnoreCase(Boolean.toString(true))) {
                defaultSharedPreferences.edit().putString("com.applovin.sdk.impl.isFirstRun", Boolean.toString(false)).apply();
            }
        }
        String str2 = (String) this.f438f.mo5363a(C0343bw.f446F);
        if (str2 != null && str2.length() > 0) {
            jSONObject3.put("plugin_version", str2);
        }
        jSONObject.put("app_info", jSONObject3);
        if (((Boolean) this.f438f.mo5363a(C0343bw.f454N)).booleanValue()) {
            Map a2 = ((C0391m) this.f438f.getTargetingData()).mo5674a();
            if (a2 != null && !a2.isEmpty()) {
                jSONObject.put("targeting", C0317ax.m267a(a2));
            }
            jSONObject.put("stats", this.f438f.mo5366b().mo5599b());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5607c(JSONObject jSONObject) {
        C0352ce ceVar = new C0352ce(this, "Repeat" + this.f437e, C0343bw.f549g, this.f438f, jSONObject);
        ceVar.mo5648a(C0343bw.f553k);
        ceVar.run();
    }

    public void run() {
        try {
            this.f439g.mo5668i(this.f437e, "Submitting user data...");
            JSONObject jSONObject = new JSONObject();
            mo5606b(jSONObject);
            mo5607c(jSONObject);
        } catch (JSONException e) {
            this.f439g.mo5667e(this.f437e, "Unable to build JSON message with collected data", e);
        }
    }
}
