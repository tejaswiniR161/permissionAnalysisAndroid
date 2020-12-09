package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.p000v4.media.TransportMediator;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.ViewTreeObserver;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.cache.CacheEntryParcel;
import com.google.android.gms.ads.internal.cache.CacheOffering;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.zzu;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@zziy
public class zzlu extends WebViewClient {
    private static final String[] zzcus = {"UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS"};
    private static final String[] zzcut = {"NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID"};
    private final Object zzakd;
    private boolean zzatj;
    private com.google.android.gms.ads.internal.client.zza zzawb;
    protected zzlt zzbkr;
    private zzer zzbma;
    private zzez zzbnj;
    private com.google.android.gms.ads.internal.zze zzbnl;
    private zzhh zzbnm;
    private zzex zzbno;
    private zzhn zzbve;
    private zza zzcct;
    private final HashMap<String, List<zzev>> zzcuu;
    private zzg zzcuv;
    private zzb zzcuw;
    /* access modifiers changed from: private */
    public zzc zzcux;
    private boolean zzcuy;
    private boolean zzcuz;
    private ViewTreeObserver.OnGlobalLayoutListener zzcva;
    private ViewTreeObserver.OnScrollChangedListener zzcvb;
    private boolean zzcvc;
    private zzp zzcvd;
    private final zzhl zzcve;
    private zze zzcvf;
    @Nullable
    protected com.google.android.gms.ads.internal.safebrowsing.zzc zzcvg;
    private boolean zzcvh;
    private boolean zzcvi;
    private boolean zzcvj;
    private int zzcvk;

    public interface zza {
        void zza(zzlt zzlt, boolean z);
    }

    public interface zzb {
        void zzk(zzlt zzlt);
    }

    public interface zzc {
        void zzet();
    }

    private static class zzd implements zzg {
        private zzg zzcuv;
        private zzlt zzcvm;

        public zzd(zzlt zzlt, zzg zzg) {
            this.zzcvm = zzlt;
            this.zzcuv = zzg;
        }

        public void onPause() {
        }

        public void onResume() {
        }

        public void zzed() {
            this.zzcuv.zzed();
            this.zzcvm.zzvl();
        }

        public void zzee() {
            this.zzcuv.zzee();
            this.zzcvm.zzoz();
        }
    }

    public interface zze {
        void zzes();
    }

    public zzlu(zzlt zzlt, boolean z) {
        this(zzlt, z, new zzhl(zzlt, zzlt.zzvo(), new zzda(zzlt.getContext())), (zzhh) null);
    }

    zzlu(zzlt zzlt, boolean z, zzhl zzhl, zzhh zzhh) {
        this.zzcuu = new HashMap<>();
        this.zzakd = new Object();
        this.zzcuy = false;
        this.zzbkr = zzlt;
        this.zzatj = z;
        this.zzcve = zzhl;
        this.zzbnm = zzhh;
    }

    private void zzb(Context context, String str, String str2, String str3) {
        if (zzdi.zzbdz.get().booleanValue()) {
            Bundle bundle = new Bundle();
            bundle.putString("err", str);
            bundle.putString("code", str2);
            bundle.putString("host", zzdi(str3));
            zzu.zzfz().zza(context, this.zzbkr.zzvu().zzcs, "gmob-apps", bundle, true);
        }
    }

    private String zzdi(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri parse = Uri.parse(str);
        return parse.getHost() != null ? parse.getHost() : "";
    }

    private static boolean zzi(Uri uri) {
        String scheme = uri.getScheme();
        return "http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme);
    }

    private void zzws() {
        if (this.zzcuw != null) {
            this.zzcuw.zzk(this.zzbkr);
            this.zzcuw = null;
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzkn.m1493v(valueOf.length() != 0 ? "Loading resource: ".concat(valueOf) : new String("Loading resource: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzj(parse);
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.zzakd) {
            if (this.zzcvh) {
                zzkn.m1493v("Blank page loaded, 1...");
                this.zzbkr.zzvw();
                return;
            }
            this.zzcvi = true;
            zzws();
            zzwt();
        }
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        zzb(this.zzbkr.getContext(), "http_err", (i >= 0 || (-i) + -1 >= zzcus.length) ? String.valueOf(i) : zzcus[(-i) - 1], str2);
        super.onReceivedError(webView, i, str, str2);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError != null) {
            int primaryError = sslError.getPrimaryError();
            zzb(this.zzbkr.getContext(), "ssl_err", (primaryError < 0 || primaryError >= zzcut.length) ? String.valueOf(primaryError) : zzcut[primaryError], zzu.zzgb().zza(sslError));
        }
        super.onReceivedSslError(webView, sslErrorHandler, sslError);
    }

    public final void reset() {
        if (this.zzcvg != null) {
            this.zzcvg.zzsy();
            this.zzcvg = null;
        }
        synchronized (this.zzakd) {
            this.zzcuu.clear();
            this.zzawb = null;
            this.zzcuv = null;
            this.zzcct = null;
            this.zzcuw = null;
            this.zzbma = null;
            this.zzcuy = false;
            this.zzatj = false;
            this.zzcuz = false;
            this.zzcvc = false;
            this.zzbno = null;
            this.zzcvd = null;
            this.zzcux = null;
            if (this.zzbnm != null) {
                this.zzbnm.zzt(true);
                this.zzbnm = null;
            }
        }
    }

    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        CacheEntryParcel zza2;
        try {
            CacheOffering zzag = CacheOffering.zzag(str);
            if (zzag == null || (zza2 = zzu.zzge().zza(zzag)) == null || !zza2.zziu()) {
                return null;
            }
            return new WebResourceResponse("", "", zza2.zziv());
        } catch (Throwable th) {
            return null;
        }
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case TransportMediator.KEYCODE_MEDIA_PLAY:
            case TransportMediator.KEYCODE_MEDIA_PAUSE:
            case 128:
            case 129:
            case TransportMediator.KEYCODE_MEDIA_RECORD:
            case 222:
                return true;
            default:
                return false;
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Uri uri;
        String valueOf = String.valueOf(str);
        zzkn.m1493v(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzj(parse);
        } else if (this.zzcuy && webView == this.zzbkr.getWebView() && zzi(parse)) {
            if (this.zzawb != null && zzdi.zzbcq.get().booleanValue()) {
                this.zzawb.onAdClicked();
                if (this.zzcvg != null) {
                    this.zzcvg.zzcq(str);
                }
                this.zzawb = null;
            }
            return super.shouldOverrideUrlLoading(webView, str);
        } else if (!this.zzbkr.getWebView().willNotDraw()) {
            try {
                zzau zzvt = this.zzbkr.zzvt();
                if (zzvt != null && zzvt.zzc(parse)) {
                    parse = zzvt.zza(parse, this.zzbkr.getContext(), this.zzbkr.getView());
                }
                uri = parse;
            } catch (zzav e) {
                String valueOf2 = String.valueOf(str);
                zzkn.zzdf(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
                uri = parse;
            }
            if (this.zzbnl == null || this.zzbnl.zzer()) {
                zza(new AdLauncherIntentInfoParcel("android.intent.action.VIEW", uri.toString(), (String) null, (String) null, (String) null, (String) null, (String) null));
            } else {
                this.zzbnl.zzv(str);
            }
        } else {
            String valueOf3 = String.valueOf(str);
            zzkn.zzdf(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
        }
        return true;
    }

    public void zza(int i, int i2, boolean z) {
        this.zzcve.zze(i, i2);
        if (this.zzbnm != null) {
            this.zzbnm.zza(i, i2, z);
        }
    }

    public final void zza(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        synchronized (this.zzakd) {
            this.zzcuz = true;
            this.zzbkr.zzwd();
            this.zzcva = onGlobalLayoutListener;
            this.zzcvb = onScrollChangedListener;
        }
    }

    public void zza(com.google.android.gms.ads.internal.client.zza zza2, zzg zzg, zzer zzer, zzp zzp, boolean z, zzex zzex, @Nullable zzez zzez, com.google.android.gms.ads.internal.zze zze2, zzhn zzhn, @Nullable com.google.android.gms.ads.internal.safebrowsing.zzc zzc2) {
        if (zze2 == null) {
            zze2 = new com.google.android.gms.ads.internal.zze(this.zzbkr.getContext());
        }
        this.zzbnm = new zzhh(this.zzbkr, zzhn);
        this.zzcvg = zzc2;
        zza("/appEvent", (zzev) new zzeq(zzer));
        zza("/backButton", zzeu.zzbmm);
        zza("/refresh", zzeu.zzbmn);
        zza("/canOpenURLs", zzeu.zzbmc);
        zza("/canOpenIntents", zzeu.zzbmd);
        zza("/click", zzeu.zzbme);
        zza("/close", zzeu.zzbmf);
        zza("/customClose", zzeu.zzbmh);
        zza("/instrument", zzeu.zzbmr);
        zza("/delayPageLoaded", zzeu.zzbmt);
        zza("/delayPageClosed", zzeu.zzbmu);
        zza("/getLocationInfo", zzeu.zzbmv);
        zza("/httpTrack", zzeu.zzbmi);
        zza("/log", zzeu.zzbmj);
        zza("/mraid", (zzev) new zzfb(zze2, this.zzbnm));
        zza("/mraidLoaded", (zzev) this.zzcve);
        zza("/open", (zzev) new zzfc(zzex, zze2, this.zzbnm));
        zza("/precache", zzeu.zzbmq);
        zza("/touch", zzeu.zzbml);
        zza("/video", zzeu.zzbmo);
        zza("/videoMeta", zzeu.zzbmp);
        zza("/appStreaming", zzeu.zzbmg);
        if (zzez != null) {
            zza("/setInterstitialProperties", (zzev) new zzey(zzez));
        }
        this.zzawb = zza2;
        this.zzcuv = zzg;
        this.zzbma = zzer;
        this.zzbno = zzex;
        this.zzcvd = zzp;
        this.zzbnl = zze2;
        this.zzbve = zzhn;
        this.zzbnj = zzez;
        zzan(z);
    }

    public final void zza(AdLauncherIntentInfoParcel adLauncherIntentInfoParcel) {
        zzg zzg = null;
        boolean zzvv = this.zzbkr.zzvv();
        com.google.android.gms.ads.internal.client.zza zza2 = (!zzvv || this.zzbkr.zzdt().zzaxj) ? this.zzawb : null;
        if (!zzvv) {
            zzg = this.zzcuv;
        }
        zza(new AdOverlayInfoParcel(adLauncherIntentInfoParcel, zza2, zzg, this.zzcvd, this.zzbkr.zzvu()));
    }

    public void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z = false;
        boolean zznu = this.zzbnm != null ? this.zzbnm.zznu() : false;
        com.google.android.gms.ads.internal.overlay.zze zzfx = zzu.zzfx();
        Context context = this.zzbkr.getContext();
        if (!zznu) {
            z = true;
        }
        zzfx.zza(context, adOverlayInfoParcel, z);
        if (this.zzcvg != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null && adOverlayInfoParcel.zzbye != null) {
                str = adOverlayInfoParcel.zzbye.url;
            }
            this.zzcvg.zzcq(str);
        }
    }

    public void zza(zza zza2) {
        this.zzcct = zza2;
    }

    public void zza(zzb zzb2) {
        this.zzcuw = zzb2;
    }

    public void zza(zzc zzc2) {
        this.zzcux = zzc2;
    }

    public void zza(zze zze2) {
        this.zzcvf = zze2;
    }

    public void zza(String str, zzev zzev) {
        synchronized (this.zzakd) {
            List list = this.zzcuu.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.zzcuu.put(str, list);
            }
            list.add(zzev);
        }
    }

    public final void zza(boolean z, int i) {
        zza(new AdOverlayInfoParcel((!this.zzbkr.zzvv() || this.zzbkr.zzdt().zzaxj) ? this.zzawb : null, this.zzcuv, this.zzcvd, this.zzbkr, z, i, this.zzbkr.zzvu()));
    }

    public final void zza(boolean z, int i, String str) {
        zzd zzd2 = null;
        boolean zzvv = this.zzbkr.zzvv();
        com.google.android.gms.ads.internal.client.zza zza2 = (!zzvv || this.zzbkr.zzdt().zzaxj) ? this.zzawb : null;
        if (!zzvv) {
            zzd2 = new zzd(this.zzbkr, this.zzcuv);
        }
        zza(new AdOverlayInfoParcel(zza2, zzd2, this.zzbma, this.zzcvd, this.zzbkr, z, i, str, this.zzbkr.zzvu(), this.zzbno));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zzvv = this.zzbkr.zzvv();
        zza(new AdOverlayInfoParcel((!zzvv || this.zzbkr.zzdt().zzaxj) ? this.zzawb : null, zzvv ? null : new zzd(this.zzbkr, this.zzcuv), this.zzbma, this.zzcvd, this.zzbkr, z, i, str, str2, this.zzbkr.zzvu(), this.zzbno));
    }

    public void zzan(boolean z) {
        this.zzcuy = z;
    }

    public void zzb(String str, zzev zzev) {
        synchronized (this.zzakd) {
            List list = this.zzcuu.get(str);
            if (list != null) {
                list.remove(zzev);
            }
        }
    }

    public void zzd(int i, int i2) {
        if (this.zzbnm != null) {
            this.zzbnm.zzd(i, i2);
        }
    }

    public boolean zzib() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.zzatj;
        }
        return z;
    }

    public void zzj(Uri uri) {
        String path = uri.getPath();
        List<zzev> list = this.zzcuu.get(path);
        if (list != null) {
            Map<String, String> zzg = zzu.zzfz().zzg(uri);
            if (zzkn.zzbf(2)) {
                String valueOf = String.valueOf(path);
                zzkn.m1493v(valueOf.length() != 0 ? "Received GMSG: ".concat(valueOf) : new String("Received GMSG: "));
                for (String next : zzg.keySet()) {
                    String str = zzg.get(next);
                    zzkn.m1493v(new StringBuilder(String.valueOf(next).length() + 4 + String.valueOf(str).length()).append("  ").append(next).append(": ").append(str).toString());
                }
            }
            for (zzev zza2 : list) {
                zza2.zza(this.zzbkr, zzg);
            }
            return;
        }
        String valueOf2 = String.valueOf(uri);
        zzkn.m1493v(new StringBuilder(String.valueOf(valueOf2).length() + 32).append("No GMSG handler found for GMSG: ").append(valueOf2).toString());
    }

    public void zzo(zzlt zzlt) {
        this.zzbkr = zzlt;
    }

    public final void zzov() {
        synchronized (this.zzakd) {
            this.zzcuy = false;
            this.zzatj = true;
            zzu.zzfz().runOnUiThread(new Runnable() {
                public void run() {
                    zzlu.this.zzbkr.zzwd();
                    com.google.android.gms.ads.internal.overlay.zzd zzvp = zzlu.this.zzbkr.zzvp();
                    if (zzvp != null) {
                        zzvp.zzov();
                    }
                    if (zzlu.this.zzcux != null) {
                        zzlu.this.zzcux.zzet();
                        zzc unused = zzlu.this.zzcux = null;
                    }
                }
            });
        }
    }

    public com.google.android.gms.ads.internal.zze zzwi() {
        return this.zzbnl;
    }

    public boolean zzwj() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.zzcuz;
        }
        return z;
    }

    public ViewTreeObserver.OnGlobalLayoutListener zzwk() {
        ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
        synchronized (this.zzakd) {
            onGlobalLayoutListener = this.zzcva;
        }
        return onGlobalLayoutListener;
    }

    public ViewTreeObserver.OnScrollChangedListener zzwl() {
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener;
        synchronized (this.zzakd) {
            onScrollChangedListener = this.zzcvb;
        }
        return onScrollChangedListener;
    }

    public boolean zzwm() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.zzcvc;
        }
        return z;
    }

    public void zzwn() {
        synchronized (this.zzakd) {
            zzkn.m1493v("Loading blank page in WebView, 2...");
            this.zzcvh = true;
            this.zzbkr.zzdg("about:blank");
        }
    }

    public void zzwo() {
        if (this.zzcvg != null) {
            zzkr.zzcrf.post(new Runnable() {
                public void run() {
                    if (zzlu.this.zzcvg != null) {
                        zzlu.this.zzcvg.zzj(zzlu.this.zzbkr.getView());
                    }
                }
            });
        }
    }

    public void zzwp() {
        synchronized (this.zzakd) {
            this.zzcvc = true;
        }
        this.zzcvk++;
        zzwt();
    }

    public void zzwq() {
        this.zzcvk--;
        zzwt();
    }

    public void zzwr() {
        this.zzcvj = true;
        zzwt();
    }

    public final void zzwt() {
        if (this.zzcct != null && ((this.zzcvi && this.zzcvk <= 0) || this.zzcvj)) {
            this.zzcct.zza(this.zzbkr, !this.zzcvj);
            this.zzcct = null;
        }
        this.zzbkr.zzwe();
    }

    public zze zzwu() {
        return this.zzcvf;
    }
}
