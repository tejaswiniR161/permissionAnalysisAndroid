package com.facebook.ads.internal.server;

import com.facebook.ads.internal.dto.C0468c;

/* renamed from: com.facebook.ads.internal.server.c */
public class C0504c {

    /* renamed from: a */
    private C0468c f1184a;

    /* renamed from: b */
    private C0505a f1185b;

    /* renamed from: com.facebook.ads.internal.server.c$a */
    public enum C0505a {
        UNKNOWN,
        ERROR,
        ADS
    }

    public C0504c(C0505a aVar, C0468c cVar) {
        this.f1185b = aVar;
        this.f1184a = cVar;
    }

    /* renamed from: a */
    public C0505a mo6045a() {
        return this.f1185b;
    }

    /* renamed from: b */
    public C0468c mo6046b() {
        return this.f1184a;
    }
}
