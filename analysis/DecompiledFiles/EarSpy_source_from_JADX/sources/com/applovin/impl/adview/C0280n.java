package com.applovin.impl.adview;

import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;

/* renamed from: com.applovin.impl.adview.n */
class C0280n extends WebChromeClient {

    /* renamed from: a */
    private final AppLovinLogger f173a;

    public C0280n(AppLovinSdk appLovinSdk) {
        this.f173a = appLovinSdk.getLogger();
    }

    public void onConsoleMessage(String str, int i, String str2) {
        this.f173a.mo5671w("AdWebView", "console.log[" + i + "] :" + str);
    }

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        this.f173a.mo5665d("AdWebView", consoleMessage.sourceId() + ": " + consoleMessage.lineNumber() + ": " + consoleMessage.message());
        return true;
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        this.f173a.mo5671w("AdWebView", "Alert attempted: " + str2);
        return true;
    }

    public boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        this.f173a.mo5671w("AdWebView", "JS onBeforeUnload attempted: " + str2);
        return true;
    }

    public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        this.f173a.mo5671w("AdWebView", "JS confirm attempted: " + str2);
        return true;
    }
}
