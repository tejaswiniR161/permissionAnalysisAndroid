package com.facebook.ads.internal.adapters;

import android.content.Intent;
import android.os.Bundle;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.util.C0534e;
import com.facebook.ads.internal.util.C0535f;
import com.facebook.ads.internal.util.C0537g;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.k */
public class C0456k implements C0535f.C0536a {

    /* renamed from: a */
    private final String f986a;

    /* renamed from: b */
    private final String f987b;

    /* renamed from: c */
    private final String f988c;

    /* renamed from: d */
    private final C0534e f989d;

    /* renamed from: e */
    private final String f990e;

    /* renamed from: f */
    private final Collection<String> f991f;

    /* renamed from: g */
    private final Map<String, String> f992g;

    /* renamed from: h */
    private final String f993h;

    /* renamed from: i */
    private final int f994i;

    /* renamed from: j */
    private final int f995j;

    private C0456k(String str, String str2, String str3, C0534e eVar, String str4, Collection<String> collection, Map<String, String> map, String str5, int i, int i2) {
        this.f986a = str;
        this.f987b = str2;
        this.f988c = str3;
        this.f989d = eVar;
        this.f990e = str4;
        this.f991f = collection;
        this.f992g = map;
        this.f993h = str5;
        this.f994i = i;
        this.f995j = i2;
    }

    /* renamed from: a */
    public static C0456k m909a(Bundle bundle) {
        return new C0456k(bundle.getString("markup"), (String) null, bundle.getString("native_impression_report_url"), C0534e.NONE, "", (Collection<String>) null, (Map<String, String>) null, bundle.getString("request_id"), bundle.getInt("viewability_check_initial_delay"), bundle.getInt("viewability_check_interval"));
    }

    /* renamed from: a */
    public static C0456k m910a(JSONObject jSONObject) {
        JSONArray jSONArray;
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("markup");
        String optString2 = jSONObject.optString("activation_command");
        String optString3 = jSONObject.optString("native_impression_report_url");
        String optString4 = jSONObject.optString("request_id");
        C0534e a = C0534e.m1190a(jSONObject.optString("invalidation_behavior"));
        String optString5 = jSONObject.optString("invalidation_report_url");
        try {
            jSONArray = new JSONArray(jSONObject.optString("detection_strings"));
        } catch (JSONException e) {
            e.printStackTrace();
            jSONArray = null;
        }
        Collection<String> a2 = C0535f.m1191a(jSONArray);
        JSONObject optJSONObject = jSONObject.optJSONObject("metadata");
        HashMap hashMap = new HashMap();
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, optJSONObject.optString(next));
            }
        }
        int i = 0;
        int i2 = AdError.NETWORK_ERROR_CODE;
        if (hashMap.containsKey("viewability_check_initial_delay")) {
            i = Integer.parseInt((String) hashMap.get("viewability_check_initial_delay"));
        }
        if (hashMap.containsKey("viewability_check_interval")) {
            i2 = Integer.parseInt((String) hashMap.get("viewability_check_interval"));
        }
        return new C0456k(optString, optString2, optString3, a, optString5, a2, hashMap, optString4, i, i2);
    }

    /* renamed from: b */
    public static C0456k m911b(Intent intent) {
        return new C0456k(C0537g.m1202a(intent.getByteArrayExtra("markup")), intent.getStringExtra("activation_command"), intent.getStringExtra("native_impression_report_url"), C0534e.NONE, "", (Collection<String>) null, (Map<String, String>) null, intent.getStringExtra("request_id"), intent.getIntExtra("viewability_check_initial_delay", 0), intent.getIntExtra("viewability_check_interval", AdError.NETWORK_ERROR_CODE));
    }

    /* renamed from: a */
    public C0534e mo5920a() {
        return this.f989d;
    }

    /* renamed from: a */
    public void mo5953a(Intent intent) {
        intent.putExtra("markup", C0537g.m1212a(this.f986a));
        intent.putExtra("activation_command", this.f987b);
        intent.putExtra("native_impression_report_url", this.f988c);
        intent.putExtra("request_id", this.f993h);
        intent.putExtra("viewability_check_initial_delay", this.f994i);
        intent.putExtra("viewability_check_interval", this.f995j);
    }

    /* renamed from: b */
    public String mo5925b() {
        return this.f990e;
    }

    /* renamed from: c */
    public Collection<String> mo5927c() {
        return this.f991f;
    }

    /* renamed from: d */
    public String mo5954d() {
        return this.f986a;
    }

    /* renamed from: e */
    public String mo5955e() {
        return this.f987b;
    }

    /* renamed from: f */
    public String mo5956f() {
        return this.f988c;
    }

    /* renamed from: g */
    public String mo5957g() {
        return "facebookAd.sendImpression();";
    }

    /* renamed from: h */
    public Map<String, String> mo5958h() {
        return this.f992g;
    }

    /* renamed from: i */
    public String mo5959i() {
        return this.f993h;
    }

    /* renamed from: j */
    public int mo5960j() {
        return this.f994i;
    }

    /* renamed from: k */
    public int mo5961k() {
        return this.f995j;
    }

    /* renamed from: l */
    public Bundle mo5962l() {
        Bundle bundle = new Bundle();
        bundle.putString("markup", this.f986a);
        bundle.putString("native_impression_report_url", this.f988c);
        bundle.putString("request_id", this.f993h);
        bundle.putInt("viewability_check_initial_delay", this.f994i);
        bundle.putInt("viewability_check_interval", this.f995j);
        return bundle;
    }
}
