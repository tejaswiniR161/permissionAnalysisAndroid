package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.bl */
public class C0332bl {

    /* renamed from: d */
    private static C0332bl f402d;

    /* renamed from: a */
    private final Map f403a = new HashMap(1);

    /* renamed from: b */
    private final Map f404b = new HashMap(1);

    /* renamed from: c */
    private final Object f405c = new Object();

    private C0332bl() {
    }

    /* renamed from: a */
    public static synchronized C0332bl m330a() {
        C0332bl blVar;
        synchronized (C0332bl.class) {
            if (f402d == null) {
                f402d = new C0332bl();
            }
            blVar = f402d;
        }
        return blVar;
    }

    /* renamed from: a */
    public Map mo5501a(AppLovinAd appLovinAd) {
        Map map;
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        synchronized (this.f405c) {
            map = (Map) this.f404b.remove(appLovinAdImpl);
        }
        return map;
    }

    /* renamed from: a */
    public void mo5502a(AppLovinAd appLovinAd, String str) {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        synchronized (this.f405c) {
            this.f403a.put(appLovinAdImpl, str);
        }
    }

    /* renamed from: a */
    public void mo5503a(AppLovinAd appLovinAd, Map map) {
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        synchronized (this.f405c) {
            this.f404b.put(appLovinAdImpl, map);
        }
    }

    /* renamed from: b */
    public String mo5504b(AppLovinAd appLovinAd) {
        String str;
        AppLovinAdImpl appLovinAdImpl = (AppLovinAdImpl) appLovinAd;
        synchronized (this.f405c) {
            str = (String) this.f403a.remove(appLovinAdImpl);
        }
        return str;
    }
}
