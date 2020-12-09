package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.MutableContextWrapper;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.formats.zzg;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.ads.internal.zzu;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
class zzlx extends WebView implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzlt {
    /* access modifiers changed from: private */
    public final Object zzakd = new Object();
    private final zzd zzalo;
    private final VersionInfoParcel zzanh;
    private AdSizeParcel zzapc;
    private zzlf zzasf;
    private final WindowManager zzasl;
    @Nullable
    private final zzau zzbkp;
    private int zzbvw = -1;
    private int zzbvx = -1;
    private int zzbvz = -1;
    private int zzbwa = -1;
    private String zzcaj = "";
    private zzdo zzcak;
    private Boolean zzcpv;
    private final zza zzcvp;
    private final zzs zzcvq;
    private zzlu zzcvr;
    private com.google.android.gms.ads.internal.overlay.zzd zzcvs;
    private boolean zzcvt;
    private boolean zzcvu;
    private boolean zzcvv;
    private boolean zzcvw;
    private int zzcvx;
    private boolean zzcvy = true;
    boolean zzcvz = false;
    private zzly zzcwa;
    private boolean zzcwb;
    private boolean zzcwc;
    private zzg zzcwd;
    private int zzcwe;
    /* access modifiers changed from: private */
    public int zzcwf;
    private zzdo zzcwg;
    private zzdo zzcwh;
    private zzdp zzcwi;
    private WeakReference<View.OnClickListener> zzcwj;
    private com.google.android.gms.ads.internal.overlay.zzd zzcwk;
    private Map<String, zzfj> zzcwl;

    @zziy
    public static class zza extends MutableContextWrapper {
        private Context zzask;
        private Activity zzctd;
        private Context zzcwn;

        public zza(Context context) {
            super(context);
            setBaseContext(context);
        }

        public Object getSystemService(String str) {
            return this.zzcwn.getSystemService(str);
        }

        public void setBaseContext(Context context) {
            this.zzask = context.getApplicationContext();
            this.zzctd = context instanceof Activity ? (Activity) context : null;
            this.zzcwn = context;
            super.setBaseContext(this.zzask);
        }

        public void startActivity(Intent intent) {
            if (this.zzctd != null) {
                this.zzctd.startActivity(intent);
                return;
            }
            intent.setFlags(268435456);
            this.zzask.startActivity(intent);
        }

        public Activity zzvn() {
            return this.zzctd;
        }

        public Context zzvo() {
            return this.zzcwn;
        }
    }

    protected zzlx(zza zza2, AdSizeParcel adSizeParcel, boolean z, boolean z2, @Nullable zzau zzau, VersionInfoParcel versionInfoParcel, zzdq zzdq, zzs zzs, zzd zzd) {
        super(zza2);
        this.zzcvp = zza2;
        this.zzapc = adSizeParcel;
        this.zzcvv = z;
        this.zzcvx = -1;
        this.zzbkp = zzau;
        this.zzanh = versionInfoParcel;
        this.zzcvq = zzs;
        this.zzalo = zzd;
        this.zzasl = (WindowManager) getContext().getSystemService("window");
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(true);
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        zzu.zzfz().zza((Context) zza2, versionInfoParcel.zzcs, settings);
        zzu.zzgb().zza(getContext(), settings);
        setDownloadListener(this);
        zzxa();
        if (com.google.android.gms.common.util.zzs.zzaxp()) {
            addJavascriptInterface(new zzlz(this), "googleAdsJsInterface");
        }
        if (com.google.android.gms.common.util.zzs.zzaxk()) {
            removeJavascriptInterface("accessibility");
            removeJavascriptInterface("accessibilityTraversal");
        }
        this.zzasf = new zzlf(this.zzcvp.zzvn(), this, this, (ViewTreeObserver.OnScrollChangedListener) null);
        zzd(zzdq);
    }

    private void zzao(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        zza("onAdVisibilityChanged", (Map<String, ?>) hashMap);
    }

    static zzlx zzb(Context context, AdSizeParcel adSizeParcel, boolean z, boolean z2, @Nullable zzau zzau, VersionInfoParcel versionInfoParcel, zzdq zzdq, zzs zzs, zzd zzd) {
        return new zzlx(new zza(context), adSizeParcel, z, z2, zzau, versionInfoParcel, zzdq, zzs, zzd);
    }

    private void zzd(zzdq zzdq) {
        zzxe();
        this.zzcwi = new zzdp(new zzdq(true, "make_wv", this.zzapc.zzaxi));
        this.zzcwi.zzkz().zzc(zzdq);
        this.zzcak = zzdm.zzb(this.zzcwi.zzkz());
        this.zzcwi.zza("native:view_create", this.zzcak);
        this.zzcwh = null;
        this.zzcwg = null;
    }

    private void zzww() {
        synchronized (this.zzakd) {
            this.zzcpv = zzu.zzgd().zztr();
            if (this.zzcpv == null) {
                try {
                    evaluateJavascript("(function(){})()", (ValueCallback<String>) null);
                    zzb((Boolean) true);
                } catch (IllegalStateException e) {
                    zzb((Boolean) false);
                }
            }
        }
    }

    private void zzwx() {
        zzdm.zza(this.zzcwi.zzkz(), this.zzcak, "aeh2");
    }

    private void zzwy() {
        zzdm.zza(this.zzcwi.zzkz(), this.zzcak, "aebb2");
    }

    private void zzxa() {
        synchronized (this.zzakd) {
            if (this.zzcvv || this.zzapc.zzaxj) {
                if (Build.VERSION.SDK_INT < 14) {
                    zzkn.zzdd("Disabling hardware acceleration on an overlay.");
                    zzxb();
                } else {
                    zzkn.zzdd("Enabling hardware acceleration on an overlay.");
                    zzxc();
                }
            } else if (Build.VERSION.SDK_INT < 18) {
                zzkn.zzdd("Disabling hardware acceleration on an AdView.");
                zzxb();
            } else {
                zzkn.zzdd("Enabling hardware acceleration on an AdView.");
                zzxc();
            }
        }
    }

    private void zzxb() {
        synchronized (this.zzakd) {
            if (!this.zzcvw) {
                zzu.zzgb().zzp(this);
            }
            this.zzcvw = true;
        }
    }

    private void zzxc() {
        synchronized (this.zzakd) {
            if (this.zzcvw) {
                zzu.zzgb().zzo(this);
            }
            this.zzcvw = false;
        }
    }

    private void zzxd() {
        synchronized (this.zzakd) {
            this.zzcwl = null;
        }
    }

    private void zzxe() {
        zzdq zzkz;
        if (this.zzcwi != null && (zzkz = this.zzcwi.zzkz()) != null && zzu.zzgd().zztm() != null) {
            zzu.zzgd().zztm().zza(zzkz);
        }
    }

    public void destroy() {
        synchronized (this.zzakd) {
            zzxe();
            this.zzasf.zzvb();
            if (this.zzcvs != null) {
                this.zzcvs.close();
                this.zzcvs.onDestroy();
                this.zzcvs = null;
            }
            this.zzcvr.reset();
            if (!this.zzcvu) {
                zzu.zzgw().zze(this);
                zzxd();
                this.zzcvu = true;
                zzkn.m1493v("Initiating WebView self destruct sequence in 3...");
                this.zzcvr.zzwn();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    @android.annotation.TargetApi(19)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void evaluateJavascript(java.lang.String r3, android.webkit.ValueCallback<java.lang.String> r4) {
        /*
            r2 = this;
            java.lang.Object r1 = r2.zzakd
            monitor-enter(r1)
            boolean r0 = r2.isDestroyed()     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0016
            java.lang.String r0 = "The webview is destroyed. Ignoring action."
            com.google.android.gms.internal.zzkn.zzdf(r0)     // Catch:{ all -> 0x001b }
            if (r4 == 0) goto L_0x0014
            r0 = 0
            r4.onReceiveValue(r0)     // Catch:{ all -> 0x001b }
        L_0x0014:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
        L_0x0015:
            return
        L_0x0016:
            super.evaluateJavascript(r3, r4)     // Catch:{ all -> 0x001b }
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            goto L_0x0015
        L_0x001b:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzlx.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void");
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        synchronized (this.zzakd) {
            if (!this.zzcvu) {
                this.zzcvr.reset();
                zzu.zzgw().zze(this);
                zzxd();
            }
        }
        super.finalize();
    }

    public String getRequestId() {
        String str;
        synchronized (this.zzakd) {
            str = this.zzcaj;
        }
        return str;
    }

    public int getRequestedOrientation() {
        int i;
        synchronized (this.zzakd) {
            i = this.zzcvx;
        }
        return i;
    }

    public View getView() {
        return this;
    }

    public WebView getWebView() {
        return this;
    }

    public boolean isDestroyed() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.zzcvu;
        }
        return z;
    }

    public void loadData(String str, String str2, String str3) {
        synchronized (this.zzakd) {
            if (!isDestroyed()) {
                super.loadData(str, str2, str3);
            } else {
                zzkn.zzdf("The webview is destroyed. Ignoring action.");
            }
        }
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        synchronized (this.zzakd) {
            if (!isDestroyed()) {
                super.loadDataWithBaseURL(str, str2, str3, str4, str5);
            } else {
                zzkn.zzdf("The webview is destroyed. Ignoring action.");
            }
        }
    }

    public void loadUrl(String str) {
        synchronized (this.zzakd) {
            if (!isDestroyed()) {
                try {
                    super.loadUrl(str);
                } catch (Throwable th) {
                    String valueOf = String.valueOf(th);
                    zzkn.zzdf(new StringBuilder(String.valueOf(valueOf).length() + 24).append("Could not call loadUrl. ").append(valueOf).toString());
                }
            } else {
                zzkn.zzdf("The webview is destroyed. Ignoring action.");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        boolean z = true;
        synchronized (this.zzakd) {
            super.onAttachedToWindow();
            if (!isDestroyed()) {
                this.zzasf.onAttachedToWindow();
            }
            boolean z2 = this.zzcwb;
            if (zzvr() == null || !zzvr().zzwj()) {
                z = z2;
            } else if (!this.zzcwc) {
                ViewTreeObserver.OnGlobalLayoutListener zzwk = zzvr().zzwk();
                if (zzwk != null) {
                    zzu.zzgx().zza(getView(), zzwk);
                }
                ViewTreeObserver.OnScrollChangedListener zzwl = zzvr().zzwl();
                if (zzwl != null) {
                    zzu.zzgx().zza(getView(), zzwl);
                }
                this.zzcwc = true;
            }
            zzao(z);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        synchronized (this.zzakd) {
            if (!isDestroyed()) {
                this.zzasf.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
            if (this.zzcwc && zzvr() != null && zzvr().zzwj() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                ViewTreeObserver.OnGlobalLayoutListener zzwk = zzvr().zzwk();
                if (zzwk != null) {
                    zzu.zzgb().zza(getViewTreeObserver(), zzwk);
                }
                ViewTreeObserver.OnScrollChangedListener zzwl = zzvr().zzwl();
                if (zzwl != null) {
                    getViewTreeObserver().removeOnScrollChangedListener(zzwl);
                }
                this.zzcwc = false;
            }
        }
        zzao(false);
    }

    public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            zzu.zzfz().zzb(getContext(), intent);
        } catch (ActivityNotFoundException e) {
            zzkn.zzdd(new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length()).append("Couldn't find an Activity to view url/mimetype: ").append(str).append(" / ").append(str4).toString());
        }
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    public void onDraw(Canvas canvas) {
        if (!isDestroyed()) {
            if (Build.VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
                if (zzvr() != null && zzvr().zzwu() != null) {
                    zzvr().zzwu().zzes();
                }
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if (zzdi.zzbcx.get().booleanValue()) {
            float axisValue = motionEvent.getAxisValue(9);
            float axisValue2 = motionEvent.getAxisValue(10);
            if ((motionEvent.getActionMasked() == 8) && ((axisValue > 0.0f && !canScrollVertically(-1)) || ((axisValue < 0.0f && !canScrollVertically(1)) || ((axisValue2 > 0.0f && !canScrollHorizontally(-1)) || (axisValue2 < 0.0f && !canScrollHorizontally(1)))))) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public void onGlobalLayout() {
        boolean zzwv = zzwv();
        com.google.android.gms.ads.internal.overlay.zzd zzvp = zzvp();
        if (zzvp != null && zzwv) {
            zzvp.zzoy();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:68:?, code lost:
        return;
     */
    @android.annotation.SuppressLint({"DrawAllocation"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onMeasure(int r10, int r11) {
        /*
            r9 = this;
            r0 = 2147483647(0x7fffffff, float:NaN)
            r8 = 1073741824(0x40000000, float:2.0)
            r7 = 8
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            java.lang.Object r4 = r9.zzakd
            monitor-enter(r4)
            boolean r1 = r9.isDestroyed()     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x0019
            r0 = 0
            r1 = 0
            r9.setMeasuredDimension(r0, r1)     // Catch:{ all -> 0x002e }
            monitor-exit(r4)     // Catch:{ all -> 0x002e }
        L_0x0018:
            return
        L_0x0019:
            boolean r1 = r9.isInEditMode()     // Catch:{ all -> 0x002e }
            if (r1 != 0) goto L_0x0029
            boolean r1 = r9.zzcvv     // Catch:{ all -> 0x002e }
            if (r1 != 0) goto L_0x0029
            com.google.android.gms.ads.internal.client.AdSizeParcel r1 = r9.zzapc     // Catch:{ all -> 0x002e }
            boolean r1 = r1.zzaxl     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x0031
        L_0x0029:
            super.onMeasure(r10, r11)     // Catch:{ all -> 0x002e }
            monitor-exit(r4)     // Catch:{ all -> 0x002e }
            goto L_0x0018
        L_0x002e:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x002e }
            throw r0
        L_0x0031:
            com.google.android.gms.ads.internal.client.AdSizeParcel r1 = r9.zzapc     // Catch:{ all -> 0x002e }
            boolean r1 = r1.zzaxm     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x0082
            com.google.android.gms.internal.zzde<java.lang.Boolean> r0 = com.google.android.gms.internal.zzdi.zzbgf     // Catch:{ all -> 0x002e }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x002e }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x002e }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x004b
            boolean r0 = com.google.android.gms.common.util.zzs.zzaxp()     // Catch:{ all -> 0x002e }
            if (r0 != 0) goto L_0x0050
        L_0x004b:
            super.onMeasure(r10, r11)     // Catch:{ all -> 0x002e }
            monitor-exit(r4)     // Catch:{ all -> 0x002e }
            goto L_0x0018
        L_0x0050:
            java.lang.String r0 = "/contentHeight"
            com.google.android.gms.internal.zzev r1 = r9.zzwz()     // Catch:{ all -> 0x002e }
            r9.zza((java.lang.String) r0, (com.google.android.gms.internal.zzev) r1)     // Catch:{ all -> 0x002e }
            java.lang.String r0 = "(function() {  var height = -1;  if (document.body) { height = document.body.offsetHeight;}  else if (document.documentElement) {      height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  window.googleAdsJsInterface.notify(url);  })();"
            r9.zzdk(r0)     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.zzlx$zza r0 = r9.zzcvp     // Catch:{ all -> 0x002e }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ all -> 0x002e }
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()     // Catch:{ all -> 0x002e }
            float r0 = r0.density     // Catch:{ all -> 0x002e }
            int r1 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x002e }
            int r2 = r9.zzcwf     // Catch:{ all -> 0x002e }
            switch(r2) {
                case -1: goto L_0x007d;
                default: goto L_0x0073;
            }     // Catch:{ all -> 0x002e }
        L_0x0073:
            int r2 = r9.zzcwf     // Catch:{ all -> 0x002e }
            float r2 = (float) r2     // Catch:{ all -> 0x002e }
            float r0 = r0 * r2
            int r0 = (int) r0     // Catch:{ all -> 0x002e }
        L_0x0078:
            r9.setMeasuredDimension(r1, r0)     // Catch:{ all -> 0x002e }
            monitor-exit(r4)     // Catch:{ all -> 0x002e }
            goto L_0x0018
        L_0x007d:
            int r0 = android.view.View.MeasureSpec.getSize(r11)     // Catch:{ all -> 0x002e }
            goto L_0x0078
        L_0x0082:
            com.google.android.gms.ads.internal.client.AdSizeParcel r1 = r9.zzapc     // Catch:{ all -> 0x002e }
            boolean r1 = r1.zzaxj     // Catch:{ all -> 0x002e }
            if (r1 == 0) goto L_0x00a0
            android.util.DisplayMetrics r0 = new android.util.DisplayMetrics     // Catch:{ all -> 0x002e }
            r0.<init>()     // Catch:{ all -> 0x002e }
            android.view.WindowManager r1 = r9.zzasl     // Catch:{ all -> 0x002e }
            android.view.Display r1 = r1.getDefaultDisplay()     // Catch:{ all -> 0x002e }
            r1.getMetrics(r0)     // Catch:{ all -> 0x002e }
            int r1 = r0.widthPixels     // Catch:{ all -> 0x002e }
            int r0 = r0.heightPixels     // Catch:{ all -> 0x002e }
            r9.setMeasuredDimension(r1, r0)     // Catch:{ all -> 0x002e }
            monitor-exit(r4)     // Catch:{ all -> 0x002e }
            goto L_0x0018
        L_0x00a0:
            int r2 = android.view.View.MeasureSpec.getMode(r10)     // Catch:{ all -> 0x002e }
            int r3 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x002e }
            int r5 = android.view.View.MeasureSpec.getMode(r11)     // Catch:{ all -> 0x002e }
            int r1 = android.view.View.MeasureSpec.getSize(r11)     // Catch:{ all -> 0x002e }
            if (r2 == r6) goto L_0x00b4
            if (r2 != r8) goto L_0x014b
        L_0x00b4:
            r2 = r3
        L_0x00b5:
            if (r5 == r6) goto L_0x00b9
            if (r5 != r8) goto L_0x00ba
        L_0x00b9:
            r0 = r1
        L_0x00ba:
            com.google.android.gms.ads.internal.client.AdSizeParcel r5 = r9.zzapc     // Catch:{ all -> 0x002e }
            int r5 = r5.widthPixels     // Catch:{ all -> 0x002e }
            if (r5 > r2) goto L_0x00c6
            com.google.android.gms.ads.internal.client.AdSizeParcel r2 = r9.zzapc     // Catch:{ all -> 0x002e }
            int r2 = r2.heightPixels     // Catch:{ all -> 0x002e }
            if (r2 <= r0) goto L_0x0135
        L_0x00c6:
            com.google.android.gms.internal.zzlx$zza r0 = r9.zzcvp     // Catch:{ all -> 0x002e }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ all -> 0x002e }
            android.util.DisplayMetrics r0 = r0.getDisplayMetrics()     // Catch:{ all -> 0x002e }
            float r0 = r0.density     // Catch:{ all -> 0x002e }
            com.google.android.gms.ads.internal.client.AdSizeParcel r2 = r9.zzapc     // Catch:{ all -> 0x002e }
            int r2 = r2.widthPixels     // Catch:{ all -> 0x002e }
            float r2 = (float) r2     // Catch:{ all -> 0x002e }
            float r2 = r2 / r0
            int r2 = (int) r2     // Catch:{ all -> 0x002e }
            com.google.android.gms.ads.internal.client.AdSizeParcel r5 = r9.zzapc     // Catch:{ all -> 0x002e }
            int r5 = r5.heightPixels     // Catch:{ all -> 0x002e }
            float r5 = (float) r5     // Catch:{ all -> 0x002e }
            float r5 = r5 / r0
            int r5 = (int) r5     // Catch:{ all -> 0x002e }
            float r3 = (float) r3     // Catch:{ all -> 0x002e }
            float r3 = r3 / r0
            int r3 = (int) r3     // Catch:{ all -> 0x002e }
            float r1 = (float) r1     // Catch:{ all -> 0x002e }
            float r0 = r1 / r0
            int r0 = (int) r0     // Catch:{ all -> 0x002e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x002e }
            r6 = 103(0x67, float:1.44E-43)
            r1.<init>(r6)     // Catch:{ all -> 0x002e }
            java.lang.String r6 = "Not enough space to show ad. Needs "
            java.lang.StringBuilder r1 = r1.append(r6)     // Catch:{ all -> 0x002e }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x002e }
            java.lang.String r2 = "x"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x002e }
            java.lang.StringBuilder r1 = r1.append(r5)     // Catch:{ all -> 0x002e }
            java.lang.String r2 = " dp, but only has "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x002e }
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x002e }
            java.lang.String r2 = "x"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x002e }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ all -> 0x002e }
            java.lang.String r1 = " dp."
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch:{ all -> 0x002e }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x002e }
            com.google.android.gms.internal.zzkn.zzdf(r0)     // Catch:{ all -> 0x002e }
            int r0 = r9.getVisibility()     // Catch:{ all -> 0x002e }
            if (r0 == r7) goto L_0x012d
            r0 = 4
            r9.setVisibility(r0)     // Catch:{ all -> 0x002e }
        L_0x012d:
            r0 = 0
            r1 = 0
            r9.setMeasuredDimension(r0, r1)     // Catch:{ all -> 0x002e }
        L_0x0132:
            monitor-exit(r4)     // Catch:{ all -> 0x002e }
            goto L_0x0018
        L_0x0135:
            int r0 = r9.getVisibility()     // Catch:{ all -> 0x002e }
            if (r0 == r7) goto L_0x013f
            r0 = 0
            r9.setVisibility(r0)     // Catch:{ all -> 0x002e }
        L_0x013f:
            com.google.android.gms.ads.internal.client.AdSizeParcel r0 = r9.zzapc     // Catch:{ all -> 0x002e }
            int r0 = r0.widthPixels     // Catch:{ all -> 0x002e }
            com.google.android.gms.ads.internal.client.AdSizeParcel r1 = r9.zzapc     // Catch:{ all -> 0x002e }
            int r1 = r1.heightPixels     // Catch:{ all -> 0x002e }
            r9.setMeasuredDimension(r0, r1)     // Catch:{ all -> 0x002e }
            goto L_0x0132
        L_0x014b:
            r2 = r0
            goto L_0x00b5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzlx.onMeasure(int, int):void");
    }

    public void onPause() {
        if (!isDestroyed()) {
            try {
                if (com.google.android.gms.common.util.zzs.zzaxk()) {
                    super.onPause();
                }
            } catch (Exception e) {
                zzkn.zzb("Could not pause webview.", e);
            }
        }
    }

    public void onResume() {
        if (!isDestroyed()) {
            try {
                if (com.google.android.gms.common.util.zzs.zzaxk()) {
                    super.onResume();
                }
            } catch (Exception e) {
                zzkn.zzb("Could not resume webview.", e);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (zzvr().zzwj()) {
            synchronized (this.zzakd) {
                if (this.zzcwd != null) {
                    this.zzcwd.zzc(motionEvent);
                }
            }
        } else if (this.zzbkp != null) {
            this.zzbkp.zza(motionEvent);
        }
        if (isDestroyed()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setContext(Context context) {
        this.zzcvp.setBaseContext(context);
        this.zzasf.zzl(this.zzcvp.zzvn());
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzcwj = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    public void setRequestedOrientation(int i) {
        synchronized (this.zzakd) {
            this.zzcvx = i;
            if (this.zzcvs != null) {
                this.zzcvs.setRequestedOrientation(this.zzcvx);
            }
        }
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzlu) {
            this.zzcvr = (zzlu) webViewClient;
        }
    }

    public void stopLoading() {
        if (!isDestroyed()) {
            try {
                super.stopLoading();
            } catch (Exception e) {
                zzkn.zzb("Could not stop loading webview.", e);
            }
        }
    }

    public void zza(Context context, AdSizeParcel adSizeParcel, zzdq zzdq) {
        synchronized (this.zzakd) {
            this.zzasf.zzvb();
            setContext(context);
            this.zzcvs = null;
            this.zzapc = adSizeParcel;
            this.zzcvv = false;
            this.zzcvt = false;
            this.zzcaj = "";
            this.zzcvx = -1;
            zzu.zzgb().zzm(this);
            loadUrl("about:blank");
            this.zzcvr.reset();
            setOnTouchListener((View.OnTouchListener) null);
            setOnClickListener((View.OnClickListener) null);
            this.zzcvy = true;
            this.zzcvz = false;
            this.zzcwa = null;
            zzd(zzdq);
            this.zzcwb = false;
            this.zzcwe = 0;
            zzu.zzgw().zze(this);
            zzxd();
        }
    }

    public void zza(AdSizeParcel adSizeParcel) {
        synchronized (this.zzakd) {
            this.zzapc = adSizeParcel;
            requestLayout();
        }
    }

    public void zza(zzcj zzcj, boolean z) {
        synchronized (this.zzakd) {
            this.zzcwb = z;
        }
        zzao(z);
    }

    public void zza(zzly zzly) {
        synchronized (this.zzakd) {
            if (this.zzcwa != null) {
                zzkn.m1352e("Attempt to create multiple AdWebViewVideoControllers.");
            } else {
                this.zzcwa = zzly;
            }
        }
    }

    /* access modifiers changed from: protected */
    @TargetApi(19)
    public void zza(String str, ValueCallback<String> valueCallback) {
        synchronized (this.zzakd) {
            if (!isDestroyed()) {
                evaluateJavascript(str, valueCallback);
            } else {
                zzkn.zzdf("The webview is destroyed. Ignoring action.");
                if (valueCallback != null) {
                    valueCallback.onReceiveValue((Object) null);
                }
            }
        }
    }

    public void zza(String str, zzev zzev) {
        if (this.zzcvr != null) {
            this.zzcvr.zza(str, zzev);
        }
    }

    public void zza(String str, Map<String, ?> map) {
        try {
            zzb(str, zzu.zzfz().zzan(map));
        } catch (JSONException e) {
            zzkn.zzdf("Could not convert parameters to JSON.");
        }
    }

    public void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zzj(str, jSONObject.toString());
    }

    public void zzah(int i) {
        if (i == 0) {
            zzwy();
        }
        zzwx();
        if (this.zzcwi.zzkz() != null) {
            this.zzcwi.zzkz().zzh("close_type", String.valueOf(i));
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.zzanh.zzcs);
        zza("onhide", (Map<String, ?>) hashMap);
    }

    public void zzaj(boolean z) {
        synchronized (this.zzakd) {
            this.zzcvv = z;
            zzxa();
        }
    }

    public void zzak(boolean z) {
        synchronized (this.zzakd) {
            if (this.zzcvs != null) {
                this.zzcvs.zza(this.zzcvr.zzib(), z);
            } else {
                this.zzcvt = z;
            }
        }
    }

    public void zzal(boolean z) {
        synchronized (this.zzakd) {
            this.zzcvy = z;
        }
    }

    public void zzam(boolean z) {
        synchronized (this.zzakd) {
            this.zzcwe = (z ? 1 : -1) + this.zzcwe;
            if (this.zzcwe <= 0 && this.zzcvs != null) {
                this.zzcvs.zzpb();
            }
        }
    }

    public void zzb(zzg zzg) {
        synchronized (this.zzakd) {
            this.zzcwd = zzg;
        }
    }

    public void zzb(com.google.android.gms.ads.internal.overlay.zzd zzd) {
        synchronized (this.zzakd) {
            this.zzcvs = zzd;
        }
    }

    /* access modifiers changed from: package-private */
    public void zzb(Boolean bool) {
        synchronized (this.zzakd) {
            this.zzcpv = bool;
        }
        zzu.zzgd().zzb(bool);
    }

    public void zzb(String str, zzev zzev) {
        if (this.zzcvr != null) {
            this.zzcvr.zzb(str, zzev);
        }
    }

    public void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        zzkn.zzdd(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        zzdk(sb.toString());
    }

    public void zzc(com.google.android.gms.ads.internal.overlay.zzd zzd) {
        synchronized (this.zzakd) {
            this.zzcwk = zzd;
        }
    }

    public void zzdg(String str) {
        synchronized (this.zzakd) {
            try {
                super.loadUrl(str);
            } catch (Throwable th) {
                String valueOf = String.valueOf(th);
                zzkn.zzdf(new StringBuilder(String.valueOf(valueOf).length() + 24).append("Could not call loadUrl. ").append(valueOf).toString());
            }
        }
    }

    public void zzdh(String str) {
        synchronized (this.zzakd) {
            if (str == null) {
                str = "";
            }
            this.zzcaj = str;
        }
    }

    /* access modifiers changed from: protected */
    public void zzdj(String str) {
        synchronized (this.zzakd) {
            if (!isDestroyed()) {
                loadUrl(str);
            } else {
                zzkn.zzdf("The webview is destroyed. Ignoring action.");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzdk(String str) {
        if (com.google.android.gms.common.util.zzs.zzaxr()) {
            if (zztr() == null) {
                zzww();
            }
            if (zztr().booleanValue()) {
                zza(str, (ValueCallback<String>) null);
                return;
            }
            String valueOf = String.valueOf(str);
            zzdj(valueOf.length() != 0 ? "javascript:".concat(valueOf) : new String("javascript:"));
            return;
        }
        String valueOf2 = String.valueOf(str);
        zzdj(valueOf2.length() != 0 ? "javascript:".concat(valueOf2) : new String("javascript:"));
    }

    public zzd zzdp() {
        return this.zzalo;
    }

    public AdSizeParcel zzdt() {
        AdSizeParcel adSizeParcel;
        synchronized (this.zzakd) {
            adSizeParcel = this.zzapc;
        }
        return adSizeParcel;
    }

    public void zzel() {
        synchronized (this.zzakd) {
            this.zzcvz = true;
            if (this.zzcvq != null) {
                this.zzcvq.zzel();
            }
        }
    }

    public void zzem() {
        synchronized (this.zzakd) {
            this.zzcvz = false;
            if (this.zzcvq != null) {
                this.zzcvq.zzem();
            }
        }
    }

    public void zzj(String str, String str2) {
        zzdk(new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length()).append(str).append("(").append(str2).append(");").toString());
    }

    public void zzoz() {
        if (this.zzcwg == null) {
            zzdm.zza(this.zzcwi.zzkz(), this.zzcak, "aes2");
            this.zzcwg = zzdm.zzb(this.zzcwi.zzkz());
            this.zzcwi.zza("native:view_show", this.zzcwg);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzanh.zzcs);
        zza("onshow", (Map<String, ?>) hashMap);
    }

    public boolean zzpr() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.zzcvy;
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public Boolean zztr() {
        Boolean bool;
        synchronized (this.zzakd) {
            bool = this.zzcpv;
        }
        return bool;
    }

    public void zzvl() {
        zzwx();
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzanh.zzcs);
        zza("onhide", (Map<String, ?>) hashMap);
    }

    public void zzvm() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzu.zzfz().zzfg()));
        hashMap.put("app_volume", String.valueOf(zzu.zzfz().zzfe()));
        hashMap.put("device_volume", String.valueOf(zzu.zzfz().zzal(getContext())));
        zza("volume", (Map<String, ?>) hashMap);
    }

    public Activity zzvn() {
        return this.zzcvp.zzvn();
    }

    public Context zzvo() {
        return this.zzcvp.zzvo();
    }

    public com.google.android.gms.ads.internal.overlay.zzd zzvp() {
        com.google.android.gms.ads.internal.overlay.zzd zzd;
        synchronized (this.zzakd) {
            zzd = this.zzcvs;
        }
        return zzd;
    }

    public com.google.android.gms.ads.internal.overlay.zzd zzvq() {
        com.google.android.gms.ads.internal.overlay.zzd zzd;
        synchronized (this.zzakd) {
            zzd = this.zzcwk;
        }
        return zzd;
    }

    public zzlu zzvr() {
        return this.zzcvr;
    }

    public boolean zzvs() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.zzcvt;
        }
        return z;
    }

    public zzau zzvt() {
        return this.zzbkp;
    }

    public VersionInfoParcel zzvu() {
        return this.zzanh;
    }

    public boolean zzvv() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.zzcvv;
        }
        return z;
    }

    public void zzvw() {
        synchronized (this.zzakd) {
            zzkn.m1493v("Destroying WebView!");
            zzkr.zzcrf.post(new Runnable() {
                public void run() {
                    zzlx.super.destroy();
                }
            });
        }
    }

    public boolean zzvx() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.zzcvz;
        }
        return z;
    }

    public zzls zzvy() {
        return null;
    }

    public zzdo zzvz() {
        return this.zzcak;
    }

    public zzdp zzwa() {
        return this.zzcwi;
    }

    public zzly zzwb() {
        zzly zzly;
        synchronized (this.zzakd) {
            zzly = this.zzcwa;
        }
        return zzly;
    }

    public boolean zzwc() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.zzcwe > 0;
        }
        return z;
    }

    public void zzwd() {
        this.zzasf.zzva();
    }

    public void zzwe() {
        if (this.zzcwh == null) {
            this.zzcwh = zzdm.zzb(this.zzcwi.zzkz());
            this.zzcwi.zza("native:view_load", this.zzcwh);
        }
    }

    public View.OnClickListener zzwf() {
        return (View.OnClickListener) this.zzcwj.get();
    }

    public zzg zzwg() {
        zzg zzg;
        synchronized (this.zzakd) {
            zzg = this.zzcwd;
        }
        return zzg;
    }

    public void zzwh() {
        setBackgroundColor(0);
    }

    public boolean zzwv() {
        int i;
        int i2;
        if (!zzvr().zzib() && !zzvr().zzwj()) {
            return false;
        }
        DisplayMetrics zza2 = zzu.zzfz().zza(this.zzasl);
        int zzb = zzm.zzjr().zzb(zza2, zza2.widthPixels);
        int zzb2 = zzm.zzjr().zzb(zza2, zza2.heightPixels);
        Activity zzvn = zzvn();
        if (zzvn == null || zzvn.getWindow() == null) {
            i = zzb2;
            i2 = zzb;
        } else {
            int[] zzh = zzu.zzfz().zzh(zzvn);
            i2 = zzm.zzjr().zzb(zza2, zzh[0]);
            i = zzm.zzjr().zzb(zza2, zzh[1]);
        }
        if (this.zzbvw == zzb && this.zzbvx == zzb2 && this.zzbvz == i2 && this.zzbwa == i) {
            return false;
        }
        boolean z = (this.zzbvw == zzb && this.zzbvx == zzb2) ? false : true;
        this.zzbvw = zzb;
        this.zzbvx = zzb2;
        this.zzbvz = i2;
        this.zzbwa = i;
        new zzhm(this).zza(zzb, zzb2, i2, i, zza2.density, this.zzasl.getDefaultDisplay().getRotation());
        return z;
    }

    /* access modifiers changed from: package-private */
    public zzev zzwz() {
        return new zzev() {
            public void zza(zzlt zzlt, Map<String, String> map) {
                if (map != null) {
                    String str = map.get("height");
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            int parseInt = Integer.parseInt(str);
                            synchronized (zzlx.this.zzakd) {
                                if (zzlx.this.zzcwf != parseInt) {
                                    int unused = zzlx.this.zzcwf = parseInt;
                                    zzlx.this.requestLayout();
                                }
                            }
                        } catch (Exception e) {
                            zzkn.zzd("Exception occurred while getting webview content height", e);
                        }
                    }
                }
            }
        };
    }
}
