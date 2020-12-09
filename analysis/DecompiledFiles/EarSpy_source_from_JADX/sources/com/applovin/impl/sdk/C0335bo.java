package com.applovin.impl.sdk;

import java.util.Map;

/* renamed from: com.applovin.impl.sdk.bo */
class C0335bo {

    /* renamed from: a */
    final /* synthetic */ C0333bm f414a;

    /* renamed from: b */
    private int f415b;

    /* renamed from: c */
    private String f416c;

    /* renamed from: d */
    private Map f417d;

    C0335bo(C0333bm bmVar, String str, Map map) {
        this(bmVar, str, map, 0);
    }

    C0335bo(C0333bm bmVar, String str, Map map, int i) {
        this.f414a = bmVar;
        this.f415b = i;
        this.f416c = str + "&postback_ts=" + System.currentTimeMillis();
        this.f417d = map;
    }

    /* renamed from: a */
    public int mo5510a() {
        return this.f415b;
    }

    /* renamed from: a */
    public void mo5511a(int i) {
        this.f415b = i;
    }

    /* renamed from: b */
    public String mo5512b() {
        return this.f416c;
    }

    /* renamed from: c */
    public Map mo5513c() {
        return this.f417d;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0335bo boVar = (C0335bo) obj;
        if (this.f415b != boVar.f415b) {
            return false;
        }
        if (this.f416c != null) {
            if (!this.f416c.equals(boVar.f416c)) {
                return false;
            }
        } else if (boVar.f416c != null) {
            return false;
        }
        if (this.f417d == null ? boVar.f417d != null : !this.f417d.equals(boVar.f417d)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((this.f416c != null ? this.f416c.hashCode() : 0) + (this.f415b * 31)) * 31;
        if (this.f417d != null) {
            i = this.f417d.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "PostbackRequest{attemptNumber=" + this.f415b + ", targetUrl='" + this.f416c + '\'' + ", requestBody=" + this.f417d + '}';
    }
}
