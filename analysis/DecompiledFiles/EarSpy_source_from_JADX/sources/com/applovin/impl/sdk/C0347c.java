package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;

/* renamed from: com.applovin.impl.sdk.c */
public class C0347c {

    /* renamed from: a */
    private AppLovinAdSize f577a;

    /* renamed from: b */
    private AppLovinAdType f578b;

    public C0347c(AppLovinAd appLovinAd) {
        this.f577a = appLovinAd.getSize();
        this.f578b = appLovinAd.getType();
    }

    public C0347c(AppLovinAdSize appLovinAdSize, AppLovinAdType appLovinAdType) {
        this.f577a = appLovinAdSize;
        this.f578b = appLovinAdType;
    }

    /* renamed from: a */
    public AppLovinAdSize mo5552a() {
        return this.f577a;
    }

    /* renamed from: b */
    public AppLovinAdType mo5553b() {
        return this.f578b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C0347c cVar = (C0347c) obj;
        if (this.f577a == null ? cVar.f577a == null : this.f577a.equals(cVar.f577a)) {
            if (this.f578b != null) {
                if (this.f578b.equals(cVar.f578b)) {
                    return true;
                }
            } else if (cVar.f578b == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = (this.f577a != null ? this.f577a.hashCode() : 0) * 31;
        if (this.f578b != null) {
            i = this.f578b.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "AdSpec{size=" + this.f577a + ", type=" + this.f578b + '}';
    }
}
