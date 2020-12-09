package com.facebook.ads.internal.util;

import com.facebook.ads.internal.dto.C0466b;
import com.facebook.ads.internal.dto.C0470e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.facebook.ads.internal.util.d */
public class C0532d {

    /* renamed from: a */
    private static Map<String, Long> f1246a = new ConcurrentHashMap();

    /* renamed from: b */
    private static Map<String, Long> f1247b = new ConcurrentHashMap();

    /* renamed from: c */
    private static Map<String, String> f1248c = new ConcurrentHashMap();

    /* renamed from: a */
    private static long m1183a(String str, C0466b bVar) {
        if (f1246a.containsKey(str)) {
            return f1246a.get(str).longValue();
        }
        switch (bVar) {
            case BANNER:
                return 15000;
            default:
                return -1000;
        }
    }

    /* renamed from: a */
    public static void m1184a(long j, C0470e eVar) {
        f1246a.put(m1189d(eVar), Long.valueOf(j));
    }

    /* renamed from: a */
    public static void m1185a(String str, C0470e eVar) {
        f1248c.put(m1189d(eVar), str);
    }

    /* renamed from: a */
    public static boolean m1186a(C0470e eVar) {
        String d = m1189d(eVar);
        if (!f1247b.containsKey(d)) {
            return false;
        }
        return System.currentTimeMillis() - f1247b.get(d).longValue() < m1183a(d, eVar.mo5994b());
    }

    /* renamed from: b */
    public static void m1187b(C0470e eVar) {
        f1247b.put(m1189d(eVar), Long.valueOf(System.currentTimeMillis()));
    }

    /* renamed from: c */
    public static String m1188c(C0470e eVar) {
        return f1248c.get(m1189d(eVar));
    }

    /* renamed from: d */
    private static String m1189d(C0470e eVar) {
        int i = 0;
        Object[] objArr = new Object[6];
        objArr[0] = eVar.mo5993a();
        objArr[1] = eVar.mo5994b();
        objArr[2] = eVar.f1058e;
        objArr[3] = Integer.valueOf(eVar.mo5995c() == null ? 0 : eVar.mo5995c().getHeight());
        if (eVar.mo5995c() != null) {
            i = eVar.mo5995c().getWidth();
        }
        objArr[4] = Integer.valueOf(i);
        objArr[5] = Integer.valueOf(eVar.mo5996d());
        return String.format("%s:%s:%s:%d:%d:%d", objArr);
    }
}
