package com.applovin.impl.sdk;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.cb */
class C0349cb {

    /* renamed from: a */
    private final AppLovinSdkImpl f580a;

    /* renamed from: b */
    private final Map f581b = new HashMap();

    C0349cb(AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f580a = appLovinSdkImpl;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5595a() {
        synchronized (this.f581b) {
            this.f581b.clear();
        }
        mo5603d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5596a(String str) {
        mo5597a(str, 1);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5597a(String str, long j) {
        synchronized (this.f581b) {
            Long l = (Long) this.f581b.get(str);
            if (l == null) {
                l = 0L;
            }
            this.f581b.put(str, Long.valueOf(l.longValue() + j));
        }
        mo5603d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public long mo5598b(String str) {
        long longValue;
        synchronized (this.f581b) {
            Long l = (Long) this.f581b.get(str);
            if (l == null) {
                l = 0L;
            }
            longValue = l.longValue();
        }
        return longValue;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public JSONObject mo5599b() {
        JSONObject jSONObject;
        synchronized (this.f581b) {
            jSONObject = new JSONObject();
            for (Map.Entry entry : this.f581b.entrySet()) {
                jSONObject.put((String) entry.getKey(), entry.getValue());
            }
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5600b(String str, long j) {
        synchronized (this.f581b) {
            this.f581b.put(str, Long.valueOf(j));
        }
        mo5603d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5601c() {
        try {
            JSONObject jSONObject = new JSONObject(this.f580a.getSettingsManager().mo5544a().getString("stats", "{}"));
            synchronized (this.f581b) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    try {
                        String next = keys.next();
                        this.f581b.put(next, Long.valueOf(jSONObject.getLong(next)));
                    } catch (JSONException e) {
                    }
                }
            }
        } catch (Throwable th) {
            this.f580a.getLogger().mo5667e("StatsManager", "Unable to load stats", th);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5602c(String str) {
        synchronized (this.f581b) {
            this.f581b.remove(str);
        }
        mo5603d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo5603d() {
        try {
            SharedPreferences.Editor edit = this.f580a.getSettingsManager().mo5544a().edit();
            edit.putString("stats", mo5599b().toString());
            edit.commit();
        } catch (JSONException e) {
            this.f580a.getLogger().mo5667e("StatsManager", "Unable to save stats", e);
        }
    }
}
