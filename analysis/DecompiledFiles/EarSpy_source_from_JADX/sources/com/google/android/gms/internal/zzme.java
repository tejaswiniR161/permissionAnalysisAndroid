package com.google.android.gms.internal;

import android.text.TextUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.common.internal.zzab;
import java.net.URI;
import java.net.URISyntaxException;

@zziy
public class zzme extends WebViewClient {
    private final zzlt zzbkr;
    private final zzii zzccz;
    private final String zzcxd;
    private boolean zzcxe = false;

    public zzme(zzii zzii, zzlt zzlt, String str) {
        this.zzcxd = zzdn(str);
        this.zzbkr = zzlt;
        this.zzccz = zzii;
    }

    private String zzdn(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return str.endsWith("/") ? str.substring(0, str.length() - 1) : str;
        } catch (IndexOutOfBoundsException e) {
            zzkn.m1352e(e.getMessage());
            return str;
        }
    }

    public void onLoadResource(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzkn.zzdd(valueOf.length() != 0 ? "JavascriptAdWebViewClient::onLoadResource: ".concat(valueOf) : new String("JavascriptAdWebViewClient::onLoadResource: "));
        if (!zzdm(str)) {
            this.zzbkr.zzvr().onLoadResource(this.zzbkr.getWebView(), str);
        }
    }

    public void onPageFinished(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzkn.zzdd(valueOf.length() != 0 ? "JavascriptAdWebViewClient::onPageFinished: ".concat(valueOf) : new String("JavascriptAdWebViewClient::onPageFinished: "));
        if (!this.zzcxe) {
            this.zzccz.zzqx();
            this.zzcxe = true;
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzkn.zzdd(valueOf.length() != 0 ? "JavascriptAdWebViewClient::shouldOverrideUrlLoading: ".concat(valueOf) : new String("JavascriptAdWebViewClient::shouldOverrideUrlLoading: "));
        if (!zzdm(str)) {
            return this.zzbkr.zzvr().shouldOverrideUrlLoading(this.zzbkr.getWebView(), str);
        }
        zzkn.zzdd("shouldOverrideUrlLoading: received passback url");
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean zzdm(String str) {
        String zzdn = zzdn(str);
        if (TextUtils.isEmpty(zzdn)) {
            return false;
        }
        try {
            URI uri = new URI(zzdn);
            if ("passback".equals(uri.getScheme())) {
                zzkn.zzdd("Passback received");
                this.zzccz.zzqy();
                return true;
            } else if (TextUtils.isEmpty(this.zzcxd)) {
                return false;
            } else {
                URI uri2 = new URI(this.zzcxd);
                String host = uri2.getHost();
                String host2 = uri.getHost();
                String path = uri2.getPath();
                String path2 = uri.getPath();
                if (!zzab.equal(host, host2) || !zzab.equal(path, path2)) {
                    return false;
                }
                zzkn.zzdd("Passback received");
                this.zzccz.zzqy();
                return true;
            }
        } catch (URISyntaxException e) {
            zzkn.m1352e(e.getMessage());
            return false;
        }
    }
}
