package com.facebook.ads.internal.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.facebook.ads.AdSettings;
import com.facebook.ads.internal.C0473e;
import java.lang.reflect.Constructor;

/* renamed from: com.facebook.ads.internal.util.h */
public class C0541h {

    /* renamed from: a */
    private static String f1261a = null;

    /* renamed from: a */
    public static String m1215a() {
        String urlPrefix = AdSettings.getUrlPrefix();
        if (C0553r.m1245a(urlPrefix)) {
            return "https://www.facebook.com/";
        }
        return String.format("https://www.%s.facebook.com", new Object[]{urlPrefix});
    }

    @TargetApi(17)
    /* renamed from: a */
    private static String m1216a(Context context) {
        return WebSettings.getDefaultUserAgent(context);
    }

    /* renamed from: a */
    public static String m1217a(Context context, C0473e eVar) {
        if (eVar == C0473e.NATIVE_250 || eVar == C0473e.NATIVE_UNKNOWN || eVar == null) {
            return System.getProperty("http.agent");
        }
        if (f1261a == null) {
            if (Build.VERSION.SDK_INT >= 17) {
                try {
                    f1261a = m1216a(context);
                    return f1261a;
                } catch (Exception e) {
                }
            }
            try {
                f1261a = m1218a(context, "android.webkit.WebSettings", "android.webkit.WebView");
            } catch (Exception e2) {
                try {
                    f1261a = m1218a(context, "android.webkit.WebSettingsClassic", "android.webkit.WebViewClassic");
                } catch (Exception e3) {
                    WebView webView = new WebView(context.getApplicationContext());
                    f1261a = webView.getSettings().getUserAgentString();
                    webView.destroy();
                }
            }
        }
        return f1261a;
    }

    /* renamed from: a */
    private static String m1218a(Context context, String str, String str2) {
        Class<?> cls = Class.forName(str);
        Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new Class[]{Context.class, Class.forName(str2)});
        declaredConstructor.setAccessible(true);
        try {
            return (String) cls.getMethod("getUserAgentString", new Class[0]).invoke(declaredConstructor.newInstance(new Object[]{context, null}), new Object[0]);
        } finally {
            declaredConstructor.setAccessible(false);
        }
    }

    /* renamed from: a */
    public static void m1219a(WebView webView) {
        webView.loadUrl("about:blank");
        webView.clearCache(true);
        if (Build.VERSION.SDK_INT > 11) {
            webView.onPause();
            return;
        }
        try {
            WebView.class.getMethod("onPause", new Class[0]).invoke(webView, new Object[0]);
        } catch (Exception e) {
        }
    }

    @TargetApi(21)
    /* renamed from: b */
    public static void m1220b(WebView webView) {
        WebSettings settings = webView.getSettings();
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(0);
            return;
        }
        try {
            WebSettings.class.getMethod("setMixedContentMode", new Class[0]).invoke(settings, new Object[]{0});
        } catch (Exception e) {
        }
    }
}
