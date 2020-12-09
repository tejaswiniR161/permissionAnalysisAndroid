package com.facebook.ads.internal.util;

import java.lang.ref.WeakReference;

/* renamed from: com.facebook.ads.internal.util.t */
public abstract class C0555t<T> implements Runnable {

    /* renamed from: a */
    private final WeakReference<T> f1296a;

    public C0555t(T t) {
        this.f1296a = new WeakReference<>(t);
    }

    /* renamed from: a */
    public T mo6141a() {
        return this.f1296a.get();
    }
}
