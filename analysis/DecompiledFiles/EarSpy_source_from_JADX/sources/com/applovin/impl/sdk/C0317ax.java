package com.applovin.impl.sdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.ax */
public class C0317ax {
    /* renamed from: a */
    private static Object m264a(Object obj) {
        if (obj == JSONObject.NULL) {
            return null;
        }
        return obj instanceof JSONObject ? m266a((JSONObject) obj) : obj instanceof JSONArray ? m265a((JSONArray) obj) : obj;
    }

    /* renamed from: a */
    public static List m265a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(m264a(jSONArray.get(i)));
        }
        return arrayList;
    }

    /* renamed from: a */
    public static Map m266a(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, m264a(jSONObject.get(next)).toString());
        }
        return hashMap;
    }

    /* renamed from: a */
    static JSONObject m267a(Map map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : map.entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        return jSONObject;
    }
}
