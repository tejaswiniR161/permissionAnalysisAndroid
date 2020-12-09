package com.applovin.impl.sdk;

import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.applovin.impl.sdk.br */
class C0338br {

    /* renamed from: a */
    private final int f426a;

    /* renamed from: b */
    private final Queue f427b;

    /* renamed from: c */
    private final Object f428c;

    C0338br(int i) {
        this.f426a = i > 10 ? 10 : i;
        this.f427b = new LinkedList();
        this.f428c = new Object();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5521a() {
        int size;
        synchronized (this.f428c) {
            size = this.f427b.size();
        }
        return size;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5522a(C0318ay ayVar) {
        synchronized (this.f428c) {
            if (!mo5524c()) {
                this.f427b.offer(ayVar);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo5523b() {
        return this.f426a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo5524c() {
        boolean z;
        synchronized (this.f428c) {
            z = mo5521a() >= this.f426a;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo5525d() {
        boolean z;
        synchronized (this.f428c) {
            z = mo5521a() == 0;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public C0318ay mo5526e() {
        C0318ay ayVar;
        try {
            synchronized (this.f428c) {
                ayVar = !mo5525d() ? (C0318ay) this.f427b.poll() : null;
            }
            return ayVar;
        } catch (Exception e) {
            return null;
        }
    }
}
