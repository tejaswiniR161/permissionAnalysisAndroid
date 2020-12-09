package com.applovin.impl.sdk;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.a */
class C0293a {

    /* renamed from: a */
    private static final Object f306a = new Object();

    /* renamed from: b */
    private static final Map f307b = new HashMap();

    /* renamed from: a */
    static Map m233a(AppLovinSdkImpl appLovinSdkImpl) {
        Map c;
        synchronized (f306a) {
            appLovinSdkImpl.getLogger().mo5665d("AdDataCache", "Reading cached device data...");
            c = m238c(appLovinSdkImpl);
        }
        return c;
    }

    /* renamed from: a */
    private static void m234a(String str, Map map) {
        String[] split = str.split("=");
        if (split.length == 2) {
            map.put(split[0], split[1]);
        }
    }

    /* renamed from: a */
    static void m235a(Map map, AppLovinSdkImpl appLovinSdkImpl) {
        m237b(map, appLovinSdkImpl);
    }

    /* renamed from: b */
    static void m236b(AppLovinSdkImpl appLovinSdkImpl) {
        synchronized (f306a) {
            appLovinSdkImpl.getLogger().mo5665d("AdDataCache", "Clearing old device data cache...");
            m235a((Map) new HashMap(0), appLovinSdkImpl);
        }
    }

    /* renamed from: b */
    private static void m237b(Map map, AppLovinSdkImpl appLovinSdkImpl) {
        if (map == null) {
            throw new IllegalArgumentException("No ad aata specified");
        } else if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else {
            try {
                synchronized (f307b) {
                    Map map2 = (Map) f307b.get("ad_data_cache");
                    if (map2 == null) {
                        map2 = new HashMap();
                    }
                    map2.clear();
                    map2.putAll(map);
                    f307b.put("ad_data_cache", map2);
                }
                SharedPreferences.Editor edit = appLovinSdkImpl.getSettingsManager().mo5544a().edit();
                edit.putString("ad_data_cache", C0382dh.m585a(map));
                edit.commit();
                appLovinSdkImpl.getLogger().mo5665d("AdDataCache", map.size() + " " + "ad_data_cache" + " entries saved in cache");
            } catch (Exception e) {
                appLovinSdkImpl.getLogger().mo5667e("AdDataCache", "Unable to save ad data entries", e);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x009f  */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.Map m238c(com.applovin.impl.sdk.AppLovinSdkImpl r7) {
        /*
            java.util.Map r1 = f307b
            monitor-enter(r1)
            java.util.Map r0 = f307b     // Catch:{ all -> 0x003f }
            java.lang.String r2 = "ad_data_cache"
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x003f }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x003f }
            monitor-exit(r1)     // Catch:{ all -> 0x003f }
            if (r0 != 0) goto L_0x00aa
            com.applovin.impl.sdk.bz r1 = r7.getSettingsManager()
            android.content.SharedPreferences r2 = r1.mo5544a()
            java.lang.String r1 = "ad_data_cache"
            java.lang.String r3 = ""
            java.lang.String r3 = r2.getString(r1, r3)
            if (r3 == 0) goto L_0x00aa
            int r1 = r3.length()
            if (r1 <= 0) goto L_0x00aa
            java.util.HashMap r1 = new java.util.HashMap     // Catch:{ Exception -> 0x00a5 }
            r1.<init>()     // Catch:{ Exception -> 0x00a5 }
            java.lang.String r0 = "&"
            java.lang.String[] r3 = r3.split(r0)     // Catch:{ Exception -> 0x0084 }
            int r4 = r3.length     // Catch:{ Exception -> 0x0084 }
            r0 = 0
        L_0x0035:
            if (r0 >= r4) goto L_0x0042
            r5 = r3[r0]     // Catch:{ Exception -> 0x0084 }
            m234a((java.lang.String) r5, (java.util.Map) r1)     // Catch:{ Exception -> 0x0084 }
            int r0 = r0 + 1
            goto L_0x0035
        L_0x003f:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x003f }
            throw r0
        L_0x0042:
            java.util.Map r3 = f307b     // Catch:{ Exception -> 0x0084 }
            monitor-enter(r3)     // Catch:{ Exception -> 0x0084 }
            java.util.Map r0 = f307b     // Catch:{ all -> 0x0081 }
            java.lang.String r4 = "ad_data_cache"
            r0.put(r4, r1)     // Catch:{ all -> 0x0081 }
            monitor-exit(r3)     // Catch:{ all -> 0x0081 }
            com.applovin.sdk.AppLovinLogger r0 = r7.getLogger()     // Catch:{ Exception -> 0x0084 }
            java.lang.String r3 = "AdDataCache"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0084 }
            r4.<init>()     // Catch:{ Exception -> 0x0084 }
            int r5 = r1.size()     // Catch:{ Exception -> 0x0084 }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ Exception -> 0x0084 }
            java.lang.String r5 = " "
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ Exception -> 0x0084 }
            java.lang.String r5 = "ad_data_cache"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ Exception -> 0x0084 }
            java.lang.String r5 = " entries loaded from cache"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ Exception -> 0x0084 }
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0084 }
            r0.mo5665d(r3, r4)     // Catch:{ Exception -> 0x0084 }
        L_0x0079:
            if (r1 == 0) goto L_0x009f
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>(r1)
        L_0x0080:
            return r0
        L_0x0081:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0081 }
            throw r0     // Catch:{ Exception -> 0x0084 }
        L_0x0084:
            r0 = move-exception
        L_0x0085:
            com.applovin.sdk.AppLovinLogger r3 = r7.getLogger()
            java.lang.String r4 = "AdDataCache"
            java.lang.String r5 = "Unable to load ad data"
            r3.mo5667e(r4, r5, r0)
            android.content.SharedPreferences$Editor r0 = r2.edit()
            java.lang.String r2 = "ad_data_cache"
            java.lang.String r3 = ""
            r0.putString(r2, r3)
            r0.commit()
            goto L_0x0079
        L_0x009f:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            goto L_0x0080
        L_0x00a5:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x0085
        L_0x00aa:
            r1 = r0
            goto L_0x0079
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C0293a.m238c(com.applovin.impl.sdk.AppLovinSdkImpl):java.util.Map");
    }
}
