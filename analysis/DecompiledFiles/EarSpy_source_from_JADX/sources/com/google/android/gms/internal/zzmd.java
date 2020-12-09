package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.annotation.Nullable;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.zzu;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zziy
@TargetApi(11)
public class zzmd extends zzlu {
    public zzmd(zzlt zzlt, boolean z) {
        super(zzlt, z);
    }

    /* access modifiers changed from: protected */
    public WebResourceResponse zza(WebView webView, String str, @Nullable Map<String, String> map) {
        if (!(webView instanceof zzlt)) {
            zzkn.zzdf("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzlt zzlt = (zzlt) webView;
        if (this.zzcvg != null) {
            this.zzcvg.zzb(str, map);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            return super.shouldInterceptRequest(webView, str);
        }
        if (zzlt.zzvr() != null) {
            zzlt.zzvr().zzov();
        }
        try {
            return zzf(zzlt.getContext(), zzlt.zzvu().zzcs, zzlt.zzdt().zzaxj ? zzdi.zzbbz.get() : zzlt.zzvv() ? zzdi.zzbby.get() : zzdi.zzbbx.get());
        } catch (IOException | InterruptedException | ExecutionException | TimeoutException e) {
            String valueOf = String.valueOf(e.getMessage());
            zzkn.zzdf(valueOf.length() != 0 ? "Could not fetch MRAID JS. ".concat(valueOf) : new String("Could not fetch MRAID JS. "));
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public WebResourceResponse zzf(Context context, String str, String str2) throws IOException, ExecutionException, InterruptedException, TimeoutException {
        HashMap hashMap = new HashMap();
        hashMap.put("User-Agent", zzu.zzfz().zzg(context, str));
        hashMap.put("Cache-Control", "max-stale=3600");
        String str3 = (String) new zzky(context).zzd(str2, hashMap).get(60, TimeUnit.SECONDS);
        if (str3 == null) {
            return null;
        }
        return new WebResourceResponse("application/javascript", "UTF-8", new ByteArrayInputStream(str3.getBytes("UTF-8")));
    }
}
