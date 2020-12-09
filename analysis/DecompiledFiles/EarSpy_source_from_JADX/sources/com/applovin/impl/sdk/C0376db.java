package com.applovin.impl.sdk;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.applovin.impl.sdk.db */
public class C0376db {

    /* renamed from: a */
    private static final C0376db f641a = new C0376db();

    /* renamed from: b */
    private final Object f642b = new Object();

    /* renamed from: c */
    private final Map f643c = new HashMap(2);

    private C0376db() {
    }

    /* renamed from: a */
    static C0376db m561a() {
        return f641a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0378dd mo5651a(String str) {
        C0378dd ddVar;
        synchronized (this.f642b) {
            ddVar = (C0378dd) this.f643c.remove(str);
        }
        return ddVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5652a(String str, long j, String str2, boolean z) {
        C0378dd ddVar = new C0378dd(this, str2, j, z);
        synchronized (this.f642b) {
            this.f643c.put(str, ddVar);
        }
    }
}
