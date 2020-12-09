package com.facebook.ads.internal.view;

import android.content.Context;
import android.net.http.SslError;
import android.support.annotation.NonNull;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.ads.internal.adapters.C0441d;
import com.facebook.ads.internal.util.C0527a;
import com.facebook.ads.internal.util.C0537g;
import com.facebook.ads.internal.util.C0541h;

/* renamed from: com.facebook.ads.internal.view.a */
public class C0556a extends C0572d {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final C0558a f1297a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public C0441d f1298b;

    /* renamed from: com.facebook.ads.internal.view.a$a */
    public interface C0558a {
        /* renamed from: a */
        void mo5916a();

        /* renamed from: a */
        void mo5917a(int i);

        /* renamed from: a */
        void mo5918a(String str);

        /* renamed from: b */
        void mo5919b();
    }

    /* renamed from: com.facebook.ads.internal.view.a$b */
    private class C0559b extends WebViewClient {
        private C0559b() {
        }

        public void onReceivedSslError(WebView webView, @NonNull SslErrorHandler sslErrorHandler, SslError sslError) {
            if (C0537g.m1209a()) {
                sslErrorHandler.proceed();
            } else {
                sslErrorHandler.cancel();
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            C0556a.this.f1297a.mo5918a(str);
            return true;
        }
    }

    /* renamed from: com.facebook.ads.internal.view.a$c */
    public class C0560c {

        /* renamed from: b */
        private final String f1303b = C0560c.class.getSimpleName();

        public C0560c() {
        }

        @JavascriptInterface
        public void alert(String str) {
            Log.e(this.f1303b, str);
        }

        @JavascriptInterface
        public String getAnalogInfo() {
            return C0537g.m1201a(C0527a.m1175a());
        }

        @JavascriptInterface
        public void onPageInitialized() {
            if (!C0556a.this.mo6161b()) {
                C0556a.this.f1297a.mo5916a();
                if (C0556a.this.f1298b != null) {
                    C0556a.this.f1298b.mo5910a();
                }
            }
        }
    }

    public C0556a(Context context, final C0558a aVar, int i) {
        super(context);
        this.f1297a = aVar;
        setWebViewClient(new C0559b());
        getSettings().setJavaScriptEnabled(true);
        getSettings().setSupportZoom(false);
        C0541h.m1220b(this);
        setHorizontalScrollBarEnabled(false);
        setHorizontalScrollbarOverlay(false);
        setVerticalScrollBarEnabled(false);
        setVerticalScrollbarOverlay(false);
        addJavascriptInterface(new C0560c(), "AdControl");
        this.f1298b = new C0441d(getContext(), this, i, new C0441d.C0442a() {
            /* renamed from: a */
            public void mo5822a() {
                aVar.mo5919b();
            }
        });
    }

    /* renamed from: a */
    public void mo6142a(int i, int i2) {
        this.f1298b.mo5911a(i);
        this.f1298b.mo5913b(i2);
    }

    public void destroy() {
        if (this.f1298b != null) {
            this.f1298b.mo5912b();
            this.f1298b = null;
        }
        C0541h.m1219a((WebView) this);
        super.destroy();
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.f1297a != null) {
            this.f1297a.mo5917a(i);
        }
        if (i == 0) {
            if (this.f1298b != null) {
                this.f1298b.mo5910a();
            }
        } else if (i == 8 && this.f1298b != null) {
            this.f1298b.mo5912b();
        }
    }
}
