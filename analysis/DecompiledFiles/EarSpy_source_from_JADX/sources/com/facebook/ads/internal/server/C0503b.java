package com.facebook.ads.internal.server;

import com.facebook.ads.internal.dto.C0465a;
import com.facebook.ads.internal.dto.C0468c;
import com.facebook.ads.internal.dto.C0469d;
import com.facebook.ads.internal.server.C0504c;
import com.facebook.ads.internal.util.C0553r;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.server.b */
public class C0503b {

    /* renamed from: a */
    private static C0503b f1183a = new C0503b();

    /* renamed from: a */
    public static synchronized C0503b m1095a() {
        C0503b bVar;
        synchronized (C0503b.class) {
            bVar = f1183a;
        }
        return bVar;
    }

    /* renamed from: a */
    private C0506d m1096a(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject.getJSONArray("placements").getJSONObject(0);
        C0469d a = C0469d.m985a(jSONObject2.getJSONObject("definition"));
        C0468c cVar = new C0468c(a);
        AdPlacementType a2 = a.mo5986a();
        if (jSONObject2.has("ads")) {
            JSONArray jSONArray = jSONObject2.getJSONArray("ads");
            for (int i = 0; i < jSONArray.length(); i++) {
                C0465a aVar = new C0465a(a2);
                JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                aVar.mo5980a(jSONObject3.getString("adapter"));
                JSONObject jSONObject4 = jSONObject3.getJSONObject("data");
                JSONArray optJSONArray = jSONObject3.optJSONArray("trackers");
                if (optJSONArray != null) {
                    jSONObject4.put("trackers", optJSONArray);
                }
                aVar.mo5981a(jSONObject4);
                cVar.mo5983a(aVar);
            }
        }
        return new C0506d(cVar);
    }

    /* renamed from: b */
    private C0507e m1097b(JSONObject jSONObject) {
        try {
            return new C0507e(jSONObject.optString("message", ""), jSONObject.optInt("code", 0), new C0468c(C0469d.m985a(jSONObject.getJSONArray("placements").getJSONObject(0).getJSONObject("definition"))));
        } catch (JSONException e) {
            return m1098c(jSONObject);
        }
    }

    /* renamed from: c */
    private C0507e m1098c(JSONObject jSONObject) {
        return new C0507e(jSONObject.optString("message", ""), jSONObject.optInt("code", 0), (C0468c) null);
    }

    /* renamed from: a */
    public C0504c mo6044a(String str) {
        if (!C0553r.m1245a(str)) {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("type");
            char c = 65535;
            switch (optString.hashCode()) {
                case 96432:
                    if (optString.equals("ads")) {
                        c = 0;
                        break;
                    }
                    break;
                case 96784904:
                    if (optString.equals("error")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return m1096a(jSONObject);
                case 1:
                    return m1097b(jSONObject);
                default:
                    JSONObject optJSONObject = jSONObject.optJSONObject("error");
                    if (optJSONObject != null) {
                        return m1098c(optJSONObject);
                    }
                    break;
            }
        }
        return new C0504c(C0504c.C0505a.UNKNOWN, (C0468c) null);
    }
}
