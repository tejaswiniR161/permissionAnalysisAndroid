package com.applovin.impl.adview;

import android.content.Context;
import android.graphics.Rect;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.applovin.impl.sdk.AppLovinAdImpl;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.adview.o */
class C0281o extends WebView {

    /* renamed from: a */
    private final AppLovinLogger f174a;

    /* renamed from: b */
    private AppLovinAd f175b = null;

    /* renamed from: c */
    private boolean f176c = false;

    C0281o(C0284r rVar, AppLovinSdk appLovinSdk, Context context) {
        super(context);
        this.f174a = appLovinSdk.getLogger();
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setSupportMultipleWindows(false);
        settings.setJavaScriptEnabled(true);
        setWebViewClient(rVar);
        setWebChromeClient(new C0280n(appLovinSdk));
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setScrollBarStyle(33554432);
        setOnTouchListener(new C0282p(this));
        setOnLongClickListener(new C0283q(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public AppLovinAd mo5273a() {
        return this.f175b;
    }

    /* renamed from: a */
    public void mo5274a(AppLovinAd appLovinAd) {
        if (!this.f176c) {
            this.f175b = appLovinAd;
            try {
                loadDataWithBaseURL("/", ((AppLovinAdImpl) appLovinAd).getHtmlSource(), "text/html", (String) null, "");
                this.f174a.mo5665d("AdWebView", "AppLovinAd rendered");
            } catch (Exception e) {
            }
        } else {
            this.f174a.userError("AdWebView", "Ad can not be loaded in a destroyed web view");
        }
    }

    public void destroy() {
        this.f176c = true;
        try {
            super.destroy();
            this.f174a.mo5665d("AdWebView", "Web view destroyed");
        } catch (Throwable th) {
            if (this.f174a != null) {
                this.f174a.mo5667e("AdWebView", "destroy() threw exception", th);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        try {
            super.onFocusChanged(z, i, rect);
        } catch (Exception e) {
            this.f174a.mo5667e("AdWebView", "onFocusChanged() threw exception", e);
        }
    }

    /* access modifiers changed from: protected */
    public void onScrollChanged(int i, int i2, int i3, int i4) {
    }

    public void onWindowFocusChanged(boolean z) {
        try {
            super.onWindowFocusChanged(z);
        } catch (Exception e) {
            this.f174a.mo5667e("AdWebView", "onWindowFocusChanged() threw exception", e);
        }
    }

    /* access modifiers changed from: protected */
    public void onWindowVisibilityChanged(int i) {
        try {
            super.onWindowVisibilityChanged(i);
        } catch (Exception e) {
            this.f174a.mo5667e("AdWebView", "onWindowVisibilityChanged() threw exception", e);
        }
    }

    public boolean requestFocus(int i, Rect rect) {
        try {
            return super.requestFocus(i, rect);
        } catch (Exception e) {
            this.f174a.mo5667e("AdWebView", "requestFocus() threw exception", e);
            return false;
        }
    }
}
