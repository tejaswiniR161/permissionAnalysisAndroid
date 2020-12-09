package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.util.Map;

@zziy
@TargetApi(11)
public class zzmb extends zzmd {
    public zzmb(zzlt zzlt, boolean z) {
        super(zzlt, z);
    }

    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zza(webView, str, (Map<String, String>) null);
    }
}
