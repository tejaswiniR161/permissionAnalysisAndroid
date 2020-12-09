package com.facebook.ads.internal.dto;

import java.util.ArrayList;
import java.util.List;

/* renamed from: com.facebook.ads.internal.dto.c */
public class C0468c {

    /* renamed from: a */
    private List<C0465a> f1040a = new ArrayList();

    /* renamed from: b */
    private int f1041b = 0;

    /* renamed from: c */
    private C0469d f1042c;

    public C0468c(C0469d dVar) {
        this.f1042c = dVar;
    }

    /* renamed from: a */
    public C0469d mo5982a() {
        return this.f1042c;
    }

    /* renamed from: a */
    public void mo5983a(C0465a aVar) {
        this.f1040a.add(aVar);
    }

    /* renamed from: b */
    public int mo5984b() {
        return this.f1040a.size();
    }

    /* renamed from: c */
    public C0465a mo5985c() {
        if (this.f1041b >= this.f1040a.size()) {
            return null;
        }
        this.f1041b++;
        return this.f1040a.get(this.f1041b - 1);
    }
}
