package com.facebook.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.internal.util.c */
public class C0531c {

    /* renamed from: a */
    private static final List<C0528b> f1245a = new ArrayList();

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
        if (r2.hasNext() == false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        r1.put(((com.facebook.ads.internal.util.C0528b) r2.next()).mo6120a());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return r1.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        r1 = new org.json.JSONArray();
        r2 = r0.iterator();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m1181a() {
        /*
            java.util.List<com.facebook.ads.internal.util.b> r1 = f1245a
            monitor-enter(r1)
            java.util.List<com.facebook.ads.internal.util.b> r0 = f1245a     // Catch:{ all -> 0x0039 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0039 }
            if (r0 == 0) goto L_0x000f
            java.lang.String r0 = ""
            monitor-exit(r1)     // Catch:{ all -> 0x0039 }
        L_0x000e:
            return r0
        L_0x000f:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0039 }
            java.util.List<com.facebook.ads.internal.util.b> r2 = f1245a     // Catch:{ all -> 0x0039 }
            r0.<init>(r2)     // Catch:{ all -> 0x0039 }
            java.util.List<com.facebook.ads.internal.util.b> r2 = f1245a     // Catch:{ all -> 0x0039 }
            r2.clear()     // Catch:{ all -> 0x0039 }
            monitor-exit(r1)     // Catch:{ all -> 0x0039 }
            org.json.JSONArray r1 = new org.json.JSONArray
            r1.<init>()
            java.util.Iterator r2 = r0.iterator()
        L_0x0025:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x003c
            java.lang.Object r0 = r2.next()
            com.facebook.ads.internal.util.b r0 = (com.facebook.ads.internal.util.C0528b) r0
            org.json.JSONObject r0 = r0.mo6120a()
            r1.put(r0)
            goto L_0x0025
        L_0x0039:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0039 }
            throw r0
        L_0x003c:
            java.lang.String r0 = r1.toString()
            goto L_0x000e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.util.C0531c.m1181a():java.lang.String");
    }

    /* renamed from: a */
    public static void m1182a(C0528b bVar) {
        synchronized (f1245a) {
            f1245a.add(bVar);
        }
    }
}
