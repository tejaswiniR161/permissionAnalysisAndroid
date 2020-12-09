package com.applovin.impl.adview;

import android.content.Context;
import android.net.Uri;
import android.view.ViewParent;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.sdk.AppLovinAdServiceImpl;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdService;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import java.util.List;

/* renamed from: com.applovin.impl.adview.r */
class C0284r extends WebViewClient {

    /* renamed from: a */
    private final AppLovinLogger f179a;

    /* renamed from: b */
    private final AdViewControllerImpl f180b;

    public C0284r(AdViewControllerImpl adViewControllerImpl, AppLovinSdk appLovinSdk) {
        this.f179a = appLovinSdk.getLogger();
        this.f180b = adViewControllerImpl;
    }

    /* renamed from: a */
    private void m153a(C0281o oVar, Uri uri) {
        AppLovinAd a = oVar.mo5273a();
        ViewParent parent = oVar.getParent();
        if (!(parent instanceof AppLovinAdView) || a == null) {
            this.f179a.mo5666e("AdWebViewClient", "Attempting to track click that is null or not an ApplovinAdView instance for clickedUri = " + uri);
        } else {
            this.f180b.mo5213a(a, (AppLovinAdView) parent, this.f180b, uri);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5283a(WebView webView, String str) {
        this.f179a.mo5665d("AdWebViewClient", "Processing click on ad URL \"" + str + "\"");
        if (str != null && (webView instanceof C0281o)) {
            Uri parse = Uri.parse(str);
            C0281o oVar = (C0281o) webView;
            String scheme = parse.getScheme();
            String host = parse.getHost();
            String path = parse.getPath();
            if (!AppLovinSdk.URI_SCHEME.equals(scheme) || !AppLovinSdk.URI_HOST.equals(host)) {
                m153a(oVar, parse);
            } else if (AppLovinAdService.URI_NEXT_AD.equals(path)) {
                mo5284a(oVar);
            } else if (AppLovinAdService.URI_CLOSE_AD.equals(path)) {
                mo5285b(oVar);
            } else if (AppLovinAdServiceImpl.URI_NO_OP.equals(path)) {
            } else {
                if (AppLovinAdServiceImpl.URI_TRACK_CLICK_IMMEDIATELY.equals(path)) {
                    m153a(oVar, Uri.parse(AppLovinAdServiceImpl.URI_TRACK_CLICK_IMMEDIATELY));
                } else if (path == null || !path.startsWith("/launch/")) {
                    this.f179a.mo5671w("AdWebViewClient", "Unknown URL: " + str);
                    this.f179a.mo5671w("AdWebViewClient", "Path: " + path);
                } else {
                    List<String> pathSegments = parse.getPathSegments();
                    if (pathSegments != null && pathSegments.size() > 1) {
                        String str2 = pathSegments.get(pathSegments.size() - 1);
                        try {
                            Context context = webView.getContext();
                            context.startActivity(context.getPackageManager().getLaunchIntentForPackage(str2));
                            m153a(oVar, (Uri) null);
                        } catch (Exception e) {
                            this.f179a.mo5667e("AdWebViewClient", "Threw Exception Trying to Launch App for Package: " + str2, e);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5284a(C0281o oVar) {
        ViewParent parent = oVar.getParent();
        if (parent instanceof AppLovinAdView) {
            ((AppLovinAdView) parent).loadNextAd();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5285b(C0281o oVar) {
        this.f180b.mo5210a();
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        this.f180b.onAdHtmlLoaded(webView);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        mo5283a(webView, str);
        return true;
    }
}
