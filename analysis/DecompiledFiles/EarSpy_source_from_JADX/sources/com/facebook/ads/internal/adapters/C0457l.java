package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.util.Log;
import com.facebook.ads.internal.util.C0550o;
import com.facebook.ads.internal.util.C0553r;
import com.facebook.ads.internal.view.C0572d;
import java.util.Collections;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.adapters.l */
public class C0457l extends C0438a {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final String f996b = C0457l.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final C0572d f997c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C0456k f998d;

    /* renamed from: e */
    private boolean f999e;

    public C0457l(Context context, C0572d dVar, C0439b bVar) {
        super(context, bVar);
        this.f997c = dVar;
    }

    /* renamed from: a */
    private void m926a(Map<String, String> map) {
        if (this.f998d != null) {
            String f = this.f998d.mo5956f();
            if (!C0553r.m1245a(f)) {
                new C0550o(map).execute(new String[]{f});
            }
        }
    }

    /* renamed from: a */
    public void mo5963a(C0456k kVar) {
        this.f998d = kVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo5906b() {
        if (this.f998d != null) {
            if (this.f997c != null && !C0553r.m1245a(this.f998d.mo5957g())) {
                if (this.f997c.mo6161b()) {
                    Log.w(f996b, "Webview already destroyed, cannot send impression");
                } else {
                    this.f997c.loadUrl("javascript:" + this.f998d.mo5957g());
                }
            }
            m926a((Map<String, String>) Collections.singletonMap("evt", "native_imp"));
        }
    }

    /* renamed from: c */
    public synchronized void mo5964c() {
        if (!this.f999e && this.f998d != null) {
            this.f999e = true;
            if (this.f997c != null && !C0553r.m1245a(this.f998d.mo5955e())) {
                this.f997c.post(new Runnable() {
                    public void run() {
                        if (C0457l.this.f997c.mo6161b()) {
                            Log.w(C0457l.f996b, "Webview already destroyed, cannot activate");
                        } else {
                            C0457l.this.f997c.loadUrl("javascript:" + C0457l.this.f998d.mo5955e());
                        }
                    }
                });
            }
        }
    }

    /* renamed from: d */
    public void mo5965d() {
        m926a((Map<String, String>) Collections.singletonMap("evt", "interstitial_displayed"));
    }
}
