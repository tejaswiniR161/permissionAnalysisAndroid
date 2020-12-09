package com.facebook.ads.internal.adapters;

import android.content.Context;
import com.facebook.ads.internal.util.C0537g;

/* renamed from: com.facebook.ads.internal.adapters.a */
public abstract class C0438a {

    /* renamed from: a */
    protected final C0439b f887a;

    /* renamed from: b */
    private final Context f888b;

    /* renamed from: c */
    private boolean f889c;

    public C0438a(Context context, C0439b bVar) {
        this.f888b = context;
        this.f887a = bVar;
    }

    /* renamed from: a */
    public final void mo5905a() {
        if (!this.f889c) {
            if (this.f887a != null) {
                this.f887a.mo5838d();
            }
            mo5906b();
            this.f889c = true;
            C0537g.m1206a(this.f888b, "Impression logged");
            if (this.f887a != null) {
                this.f887a.mo5839e();
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo5906b();
}
