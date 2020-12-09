package com.google.android.gms.internal;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zziy
public class zzhv implements zzht {
    private final Context mContext;
    final Set<WebView> zzcba = Collections.synchronizedSet(new HashSet());

    public zzhv(Context context) {
        this.mContext = context;
    }

    public void zza(String str, final String str2, final String str3) {
        zzkn.zzdd("Fetching assets for the given html");
        zzkr.zzcrf.post(new Runnable() {
            public void run() {
                final WebView zzqj = zzhv.this.zzqj();
                zzqj.setWebViewClient(new WebViewClient() {
                    public void onPageFinished(WebView webView, String str) {
                        zzkn.zzdd("Loading assets have finished");
                        zzhv.this.zzcba.remove(zzqj);
                    }

                    public void onReceivedError(WebView webView, int i, String str, String str2) {
                        zzkn.zzdf("Loading assets have failed.");
                        zzhv.this.zzcba.remove(zzqj);
                    }
                });
                zzhv.this.zzcba.add(zzqj);
                zzqj.loadDataWithBaseURL(str2, str3, "text/html", "UTF-8", (String) null);
                zzkn.zzdd("Fetching assets finished.");
            }
        });
    }

    public WebView zzqj() {
        WebView webView = new WebView(this.mContext);
        webView.getSettings().setJavaScriptEnabled(true);
        return webView;
    }
}
