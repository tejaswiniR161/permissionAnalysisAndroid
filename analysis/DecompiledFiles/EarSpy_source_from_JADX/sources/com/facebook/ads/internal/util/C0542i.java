package com.facebook.ads.internal.util;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.util.i */
public class C0542i {

    /* renamed from: a */
    private final String f1262a;

    /* renamed from: b */
    private final String f1263b;

    /* renamed from: c */
    private final String f1264c;

    /* renamed from: d */
    private final List<String> f1265d;

    /* renamed from: e */
    private final String f1266e;

    /* renamed from: f */
    private final String f1267f;

    private C0542i(String str, String str2, String str3, List<String> list, String str4, String str5) {
        this.f1262a = str;
        this.f1263b = str2;
        this.f1264c = str3;
        this.f1265d = list;
        this.f1266e = str4;
        this.f1267f = str5;
    }

    /* renamed from: a */
    public static C0542i m1221a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("package");
        String optString2 = jSONObject.optString("appsite");
        String optString3 = jSONObject.optString("appsite_url");
        JSONArray optJSONArray = jSONObject.optJSONArray("key_hashes");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                arrayList.add(optJSONArray.optString(i));
            }
        }
        return new C0542i(optString, optString2, optString3, arrayList, jSONObject.optString("market_uri"), jSONObject.optString("fallback_url"));
    }

    /* renamed from: a */
    public String mo6124a() {
        return this.f1262a;
    }

    /* renamed from: b */
    public String mo6125b() {
        return this.f1263b;
    }

    /* renamed from: c */
    public String mo6126c() {
        return this.f1264c;
    }
}
