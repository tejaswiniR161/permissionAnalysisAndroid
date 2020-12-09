package com.applovin.impl.sdk;

import java.util.Map;

/* renamed from: com.applovin.impl.sdk.bs */
public class C0339bs {

    /* renamed from: a */
    private final String f429a;

    /* renamed from: b */
    private final Map f430b;

    /* renamed from: c */
    private final long f431c;

    /* renamed from: d */
    private final String f432d;

    public C0339bs(String str, Map map, long j, String str2) {
        this.f429a = str;
        this.f430b = map;
        this.f431c = j;
        this.f432d = str2;
    }

    /* renamed from: a */
    public String mo5527a() {
        return this.f429a;
    }

    /* renamed from: b */
    public Map mo5528b() {
        return this.f430b;
    }

    /* renamed from: c */
    public long mo5529c() {
        return this.f431c;
    }

    public boolean equals(Object obj) {
        boolean z = true;
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0339bs bsVar = (C0339bs) obj;
        if (this.f431c != bsVar.f431c) {
            return false;
        }
        if (this.f429a != null) {
            if (!this.f429a.equals(bsVar.f429a)) {
                return false;
            }
        } else if (bsVar.f429a != null) {
            return false;
        }
        if (this.f430b != null) {
            if (!this.f430b.equals(bsVar.f430b)) {
                return false;
            }
        } else if (bsVar.f430b != null) {
            return false;
        }
        if (this.f432d == null ? bsVar.f432d != null : !this.f432d.equals(bsVar.f432d)) {
            z = false;
        }
        return z;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((this.f430b != null ? this.f430b.hashCode() : 0) + ((this.f429a != null ? this.f429a.hashCode() : 0) * 31)) * 31) + ((int) (this.f431c ^ (this.f431c >>> 32)))) * 31;
        if (this.f432d != null) {
            i = this.f432d.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "SdkEvent{eventType='" + this.f429a + '\'' + ", parameters=" + this.f430b + ", creationTsMillis=" + this.f431c + ", uniqueIdentifier='" + this.f432d + '\'' + '}';
    }
}
