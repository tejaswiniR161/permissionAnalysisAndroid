package com.facebook.ads.internal.view;

import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.support.annotation.NonNull;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.action.C0434a;
import com.facebook.ads.internal.action.C0435b;
import com.facebook.ads.internal.adapters.C0439b;
import com.facebook.ads.internal.adapters.C0441d;
import com.facebook.ads.internal.adapters.C0456k;
import com.facebook.ads.internal.adapters.C0457l;
import com.facebook.ads.internal.ssp.ANAdRenderer;
import com.facebook.ads.internal.util.C0527a;
import com.facebook.ads.internal.util.C0528b;
import com.facebook.ads.internal.util.C0531c;
import com.facebook.ads.internal.util.C0537g;
import com.facebook.ads.internal.util.C0541h;

/* renamed from: com.facebook.ads.internal.view.c */
public class C0563c extends C0572d {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f1308a = C0563c.class.getSimpleName();

    /* renamed from: b */
    private final C0456k f1309b;

    /* renamed from: c */
    private final int f1310c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final ANAdRenderer.Listener f1311d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public C0457l f1312e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public C0441d f1313f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public long f1314g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C0528b.C0529a f1315h;

    /* renamed from: com.facebook.ads.internal.view.c$a */
    private class C0566a extends WebViewClient {
        private C0566a() {
        }

        public void onReceivedSslError(WebView webView, @NonNull SslErrorHandler sslErrorHandler, SslError sslError) {
            if (C0537g.m1209a()) {
                sslErrorHandler.proceed();
            } else {
                sslErrorHandler.cancel();
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Uri parse = Uri.parse(str);
            if (!"fbad".equals(parse.getScheme()) || !"close".equals(parse.getAuthority())) {
                C0563c.this.f1311d.onAdClick();
                C0434a a = C0435b.m813a(C0563c.this.getContext(), parse);
                if (a != null) {
                    try {
                        C0528b.C0529a unused = C0563c.this.f1315h = a.mo5881a();
                        long unused2 = C0563c.this.f1314g = System.currentTimeMillis();
                        a.mo5883b();
                    } catch (Exception e) {
                        Log.e(C0563c.f1308a, "Error executing action", e);
                    }
                }
            } else {
                C0563c.this.f1311d.onAdClose();
            }
            return true;
        }
    }

    /* renamed from: com.facebook.ads.internal.view.c$b */
    private class C0567b {

        /* renamed from: b */
        private final String f1320b;

        private C0567b() {
            this.f1320b = C0567b.class.getSimpleName();
        }

        @JavascriptInterface
        public void alert(String str) {
            Log.e(this.f1320b, str);
        }

        @JavascriptInterface
        public String getAnalogInfo() {
            return C0537g.m1201a(C0527a.m1175a());
        }

        @JavascriptInterface
        public void onPageInitialized() {
            if (!C0563c.this.mo6161b()) {
                C0563c.this.m1270d();
                if (C0563c.this.f1313f != null) {
                    C0563c.this.f1313f.mo5910a();
                }
            }
        }
    }

    public C0563c(Context context, C0456k kVar, int i, ANAdRenderer.Listener listener) {
        super(context);
        if (kVar == null || listener == null) {
            throw new IllegalArgumentException();
        }
        this.f1309b = kVar;
        this.f1310c = i;
        this.f1311d = listener;
        m1267c();
    }

    /* renamed from: c */
    private void m1267c() {
        setWebViewClient(new C0566a());
        getSettings().setJavaScriptEnabled(true);
        getSettings().setSupportZoom(false);
        C0541h.m1220b(this);
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        addJavascriptInterface(new C0567b(), "AdControl");
        this.f1312e = new C0457l(getContext(), this, new C0439b() {
            /* renamed from: d */
            public void mo5838d() {
                C0563c.this.f1311d.onAdImpression();
            }
        });
        this.f1312e.mo5963a(this.f1309b);
        this.f1313f = new C0441d(getContext(), this, this.f1310c, new C0441d.C0442a() {
            /* renamed from: a */
            public void mo5822a() {
                C0563c.this.f1312e.mo5905a();
            }
        });
        this.f1313f.mo5911a(this.f1309b.mo5960j());
        this.f1313f.mo5913b(this.f1309b.mo5961k());
        this.f1313f.mo5910a();
        loadDataWithBaseURL(C0541h.m1215a(), this.f1309b.mo5954d(), "text/html", "utf-8", (String) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m1270d() {
        this.f1312e.mo5964c();
    }

    public void destroy() {
        if (this.f1313f != null) {
            this.f1313f.mo5912b();
            this.f1313f = null;
        }
        C0541h.m1219a((WebView) this);
        super.destroy();
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            if (this.f1314g > 0 && this.f1315h != null) {
                C0531c.m1182a(C0528b.m1177a(this.f1314g, this.f1315h, this.f1309b.mo5959i()));
                this.f1314g = 0;
                this.f1315h = null;
            }
            if (this.f1313f != null) {
                this.f1313f.mo5910a();
            }
        } else if (i == 8 && this.f1313f != null) {
            this.f1313f.mo5912b();
        }
    }
}
