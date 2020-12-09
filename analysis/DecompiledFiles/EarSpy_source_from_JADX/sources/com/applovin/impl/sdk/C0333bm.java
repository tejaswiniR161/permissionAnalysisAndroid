package com.applovin.impl.sdk;

import android.content.SharedPreferences;
import com.applovin.sdk.AppLovinLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.bm */
public class C0333bm {

    /* renamed from: a */
    private final AppLovinSdkImpl f406a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final AppLovinLogger f407b;

    /* renamed from: c */
    private ArrayList f408c;

    /* renamed from: d */
    private ArrayList f409d;

    /* renamed from: e */
    private final Object f410e;

    /* renamed from: f */
    private final SharedPreferences f411f;

    C0333bm(AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f406a = appLovinSdkImpl;
        this.f407b = appLovinSdkImpl.getLogger();
        this.f411f = appLovinSdkImpl.getApplicationContext().getSharedPreferences("com.applovin.sdk.impl.postbackQueue.domain", 0);
        this.f410e = new Object();
        this.f408c = m341c();
        this.f409d = new ArrayList();
    }

    /* renamed from: a */
    private C0335bo m335a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new C0335bo(this, jSONObject.getString("targetUrl"), C0317ax.m266a(jSONObject.getJSONObject("requestBody")), jSONObject.getInt("attemptNumber"));
        } catch (Exception e) {
            this.f407b.mo5672w("PersistentPostbackManager", "Unable to inflate postback request from JSON.", e);
            return null;
        }
    }

    /* renamed from: a */
    private void m338a(C0335bo boVar) {
        synchronized (this.f410e) {
            m340b(boVar);
            m342c(boVar);
        }
    }

    /* renamed from: b */
    private void m340b(C0335bo boVar) {
        synchronized (this.f410e) {
            if (this.f408c.size() < ((Integer) this.f406a.mo5363a(C0343bw.f532bl)).intValue()) {
                this.f408c.add(boVar);
                m343d();
                this.f407b.mo5665d("PersistentPostbackManager", "Enqueued postback: " + boVar);
            } else {
                this.f407b.mo5671w("PersistentPostbackManager", "Persistent queue has reached maximum size; postback retried in memory only." + boVar);
            }
        }
    }

    /* renamed from: c */
    private ArrayList m341c() {
        if (C0392n.m610b()) {
            Set<String> stringSet = this.f411f.getStringSet("com.applovin.sdk.impl.postbackQueue.key", new LinkedHashSet(0));
            ArrayList arrayList = new ArrayList(Math.max(1, stringSet.size()));
            int intValue = ((Integer) this.f406a.mo5363a(C0343bw.f533bm)).intValue();
            this.f407b.mo5665d("PersistentPostbackManager", "Deserializing " + stringSet.size() + " postback(s).");
            for (String next : stringSet) {
                C0335bo a = m335a(next);
                if (a == null) {
                    this.f407b.mo5666e("PersistentPostbackManager", "Unable to deserialize postback json: " + next);
                } else if (a.mo5510a() > intValue) {
                    arrayList.add(a);
                } else {
                    this.f407b.mo5665d("PersistentPostbackManager", "Skipping deserialization because maximum attempt count exceeded for postback: " + a);
                }
            }
            this.f407b.mo5665d("PersistentPostbackManager", "Successfully loaded postback queue with " + arrayList.size() + " postback(s).");
            return arrayList;
        }
        this.f407b.mo5665d("PersistentPostbackManager", "Loading new postback queue due to old Android version...");
        return new ArrayList();
    }

    /* renamed from: c */
    private void m342c(C0335bo boVar) {
        this.f407b.mo5665d("PersistentPostbackManager", "Preparing to submit postback..." + boVar);
        synchronized (this.f410e) {
            boVar.mo5511a(boVar.mo5510a() + 1);
            m343d();
        }
        int intValue = ((Integer) this.f406a.mo5363a(C0343bw.f533bm)).intValue();
        if (boVar.mo5510a() > intValue) {
            this.f407b.mo5671w("PersistentPostbackManager", "Exceeded maximum persisted attempt count of " + intValue + ". Dequeuing postback: " + boVar);
            m344d(boVar);
            return;
        }
        this.f406a.getPostbackService().dispatchPostbackAsync(boVar.mo5512b(), boVar.mo5513c(), new C0334bn(this, boVar));
    }

    /* renamed from: d */
    private void m343d() {
        if (C0392n.m610b()) {
            LinkedHashSet linkedHashSet = new LinkedHashSet(this.f408c.size());
            Iterator it = this.f408c.iterator();
            while (it.hasNext()) {
                String f = m346f((C0335bo) it.next());
                if (f != null) {
                    linkedHashSet.add(f);
                }
            }
            this.f411f.edit().putStringSet("com.applovin.sdk.impl.postbackQueue.key", linkedHashSet).commit();
            this.f407b.mo5665d("PersistentPostbackManager", "Wrote updated postback queue to disk.");
            return;
        }
        this.f407b.mo5665d("PersistentPostbackManager", "Skipping writing postback queue to disk due to old Android version...");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m344d(C0335bo boVar) {
        synchronized (this.f410e) {
            this.f408c.remove(boVar);
            m343d();
        }
        this.f407b.mo5665d("PersistentPostbackManager", "Dequeued successfully transmitted postback: " + boVar);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m345e(C0335bo boVar) {
        synchronized (this.f410e) {
            this.f409d.add(boVar);
        }
    }

    /* renamed from: f */
    private String m346f(C0335bo boVar) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("attemptNumber", boVar.mo5510a()).put("targetUrl", boVar.mo5512b()).put("requestBody", new JSONObject(boVar.mo5513c()));
            return jSONObject.toString();
        } catch (Exception e) {
            this.f407b.mo5672w("PersistentPostbackManager", "Unable to serialize postback request to JSON.", e);
            return null;
        }
    }

    /* renamed from: a */
    public void mo5505a() {
        synchronized (this.f410e) {
            Iterator it = this.f408c.iterator();
            while (it.hasNext()) {
                m342c((C0335bo) it.next());
            }
        }
    }

    /* renamed from: a */
    public void mo5506a(String str, Map map) {
        m338a(new C0335bo(this, str, map));
    }

    /* renamed from: b */
    public void mo5507b() {
        synchronized (this.f410e) {
            Iterator it = this.f409d.iterator();
            while (it.hasNext()) {
                m342c((C0335bo) it.next());
            }
            this.f409d.clear();
        }
    }
}
