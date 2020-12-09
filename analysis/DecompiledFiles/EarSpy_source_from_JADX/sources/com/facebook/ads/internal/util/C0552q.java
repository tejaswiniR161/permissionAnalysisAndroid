package com.facebook.ads.internal.util;

import android.graphics.Bitmap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.facebook.ads.internal.util.q */
public class C0552q {

    /* renamed from: a */
    static final int f1290a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b */
    static final ExecutorService f1291b = Executors.newFixedThreadPool(f1290a);

    /* renamed from: c */
    private static volatile boolean f1292c = true;

    /* renamed from: d */
    private final Bitmap f1293d;

    /* renamed from: e */
    private Bitmap f1294e;

    /* renamed from: f */
    private final C0543j f1295f = new C0548n();

    public C0552q(Bitmap bitmap) {
        this.f1293d = bitmap;
    }

    /* renamed from: a */
    public Bitmap mo6139a() {
        return this.f1294e;
    }

    /* renamed from: a */
    public Bitmap mo6140a(int i) {
        this.f1294e = this.f1295f.mo6127a(this.f1293d, (float) i);
        return this.f1294e;
    }
}
