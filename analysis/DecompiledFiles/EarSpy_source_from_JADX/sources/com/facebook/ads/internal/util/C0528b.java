package com.facebook.ads.internal.util;

import com.facebook.ads.internal.server.AdPlacementType;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.util.b */
public class C0528b {

    /* renamed from: a */
    public static String f1230a = null;

    /* renamed from: b */
    private String f1231b;

    /* renamed from: c */
    private Map<String, Object> f1232c;

    /* renamed from: d */
    private int f1233d;

    /* renamed from: e */
    private String f1234e;

    /* renamed from: com.facebook.ads.internal.util.b$a */
    public enum C0529a {
        OPEN_STORE(0),
        OPEN_LINK(1),
        XOUT(2),
        OPEN_URL(3),
        SHOW_INTERSTITIAL(4);
        

        /* renamed from: f */
        int f1241f;

        private C0529a(int i) {
            this.f1241f = i;
        }
    }

    /* renamed from: com.facebook.ads.internal.util.b$b */
    public enum C0530b {
        LOADING_AD(0);
        

        /* renamed from: b */
        int f1244b;

        private C0530b(int i) {
            this.f1244b = i;
        }
    }

    public C0528b(String str, Map<String, Object> map, int i, String str2) {
        this.f1231b = str;
        this.f1232c = map;
        this.f1233d = i;
        this.f1234e = str2;
    }

    /* renamed from: a */
    public static C0528b m1177a(long j, C0529a aVar, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        HashMap hashMap = new HashMap();
        hashMap.put("Time", String.valueOf(currentTimeMillis - j));
        hashMap.put("AdAction", String.valueOf(aVar.f1241f));
        return new C0528b("bounceback", hashMap, (int) (currentTimeMillis / 1000), str);
    }

    /* renamed from: a */
    public static C0528b m1178a(C0530b bVar, AdPlacementType adPlacementType, long j, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("LatencyType", String.valueOf(bVar.f1244b));
        hashMap.put("AdPlacementType", adPlacementType.toString());
        hashMap.put("Time", String.valueOf(j));
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (str == null) {
            str = f1230a;
        }
        return new C0528b("latency", hashMap, currentTimeMillis, str);
    }

    /* renamed from: a */
    public static C0528b m1179a(Throwable th, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("ex", th.getClass().getSimpleName());
        hashMap.put("ex_msg", th.getMessage());
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        if (str == null) {
            str = f1230a;
        }
        return new C0528b("error", hashMap, currentTimeMillis, str);
    }

    /* renamed from: a */
    public JSONObject mo6120a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", this.f1231b);
            jSONObject.put("data", new JSONObject(this.f1232c));
            jSONObject.put("time", this.f1233d);
            jSONObject.put("request_id", this.f1234e);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
