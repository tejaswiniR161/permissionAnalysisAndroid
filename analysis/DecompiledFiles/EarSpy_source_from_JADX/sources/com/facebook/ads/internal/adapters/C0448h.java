package com.facebook.ads.internal.adapters;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.webkit.WebView;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.action.C0434a;
import com.facebook.ads.internal.action.C0435b;
import com.facebook.ads.internal.dto.C0469d;
import com.facebook.ads.internal.util.C0528b;
import com.facebook.ads.internal.util.C0531c;
import com.facebook.ads.internal.util.C0535f;
import com.facebook.ads.internal.util.C0541h;
import com.facebook.ads.internal.view.C0556a;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.adapters.h */
public class C0448h extends BannerAdapter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f918a = C0448h.class.getSimpleName();

    /* renamed from: b */
    private C0556a f919b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public C0457l f920c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public BannerAdapterListener f921d;

    /* renamed from: e */
    private Map<String, Object> f922e;

    /* renamed from: f */
    private C0453j f923f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Context f924g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public long f925h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public C0528b.C0529a f926i;

    /* renamed from: a */
    private void m858a(C0469d dVar) {
        this.f925h = 0;
        this.f926i = null;
        final C0456k a = C0456k.m910a((JSONObject) this.f922e.get("data"));
        if (C0535f.m1192a(this.f924g, (C0535f.C0536a) a)) {
            this.f921d.onBannerError(this, AdError.NO_FILL);
            return;
        }
        this.f919b = new C0556a(this.f924g, new C0556a.C0558a() {
            /* renamed from: a */
            public void mo5916a() {
                C0448h.this.f920c.mo5964c();
            }

            /* renamed from: a */
            public void mo5917a(int i) {
                if (i == 0 && C0448h.this.f925h > 0 && C0448h.this.f926i != null) {
                    C0531c.m1182a(C0528b.m1177a(C0448h.this.f925h, C0448h.this.f926i, a.mo5959i()));
                    long unused = C0448h.this.f925h = 0;
                    C0528b.C0529a unused2 = C0448h.this.f926i = null;
                }
            }

            /* renamed from: a */
            public void mo5918a(String str) {
                if (C0448h.this.f921d != null) {
                    C0448h.this.f921d.onBannerAdClicked(C0448h.this);
                }
                C0434a a = C0435b.m813a(C0448h.this.f924g, Uri.parse(str));
                if (a != null) {
                    try {
                        C0528b.C0529a unused = C0448h.this.f926i = a.mo5881a();
                        long unused2 = C0448h.this.f925h = System.currentTimeMillis();
                        a.mo5883b();
                    } catch (Exception e) {
                        Log.e(C0448h.f918a, "Error executing action", e);
                    }
                }
            }

            /* renamed from: b */
            public void mo5919b() {
                C0448h.this.onViewableImpression();
            }
        }, dVar.mo5990e());
        this.f919b.mo6142a(dVar.mo5991f(), dVar.mo5992g());
        this.f920c = new C0457l(this.f924g, this.f919b, new C0439b() {
            /* renamed from: d */
            public void mo5838d() {
                if (C0448h.this.f921d != null) {
                    C0448h.this.f921d.onBannerLoggingImpression(C0448h.this);
                }
            }
        });
        this.f920c.mo5963a(a);
        this.f919b.loadDataWithBaseURL(C0541h.m1215a(), a.mo5954d(), "text/html", "utf-8", (String) null);
        if (this.f921d != null) {
            this.f921d.onBannerAdLoaded(this, this.f919b);
        }
    }

    public void loadBannerAd(Context context, AdSize adSize, BannerAdapterListener bannerAdapterListener, Map<String, Object> map) {
        this.f924g = context;
        this.f921d = bannerAdapterListener;
        this.f922e = map;
        m858a((C0469d) map.get("definition"));
    }

    public void onDestroy() {
        if (this.f919b != null) {
            C0541h.m1219a((WebView) this.f919b);
            this.f919b.destroy();
            this.f919b = null;
        }
        if (this.f923f != null) {
            this.f923f.onDestroy();
            this.f923f = null;
        }
    }

    public void onViewableImpression() {
        if (this.f920c != null) {
            this.f920c.mo5905a();
        } else if (this.f923f != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("mil", false);
            this.f923f.mo5923a((Map<String, Object>) hashMap);
        }
    }
}
