package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.facebook.ads.AdError;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.zzs;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
@TargetApi(14)
public class zzcu extends Thread {
    private boolean mStarted = false;
    private final Object zzakd;
    private final int zzatu;
    private final int zzatw;
    private boolean zzauq = false;
    private final zzcs zzaur;
    private final zzix zzaus;
    private final int zzaut;
    private final int zzauu;
    private final int zzauv;
    private boolean zzbl = false;

    @zziy
    class zza {
        final int zzavd;
        final int zzave;

        zza(int i, int i2) {
            this.zzavd = i;
            this.zzave = i2;
        }
    }

    public zzcu(zzcs zzcs, zzix zzix) {
        this.zzaur = zzcs;
        this.zzaus = zzix;
        this.zzakd = new Object();
        this.zzatu = zzdi.zzbce.get().intValue();
        this.zzauu = zzdi.zzbcf.get().intValue();
        this.zzatw = zzdi.zzbcg.get().intValue();
        this.zzauv = zzdi.zzbch.get().intValue();
        this.zzaut = zzdi.zzbci.get().intValue();
        setName("ContentFetchTask");
    }

    public void run() {
        while (true) {
            try {
                if (zzin()) {
                    Activity activity = zzu.zzgc().getActivity();
                    if (activity == null) {
                        zzkn.zzdd("ContentFetchThread: no activity. Sleeping.");
                        zzip();
                    } else {
                        zza(activity);
                    }
                } else {
                    zzkn.zzdd("ContentFetchTask: sleeping");
                    zzip();
                }
                Thread.sleep((long) (this.zzaut * AdError.NETWORK_ERROR_CODE));
            } catch (Throwable th) {
                zzkn.zzb("Error in ContentFetchTask", th);
                this.zzaus.zza(th, "ContentFetchTask.run");
            }
            synchronized (this.zzakd) {
                while (this.zzauq) {
                    try {
                        zzkn.zzdd("ContentFetchTask: waiting");
                        this.zzakd.wait();
                    } catch (InterruptedException e) {
                    }
                }
            }
        }
    }

    public void wakeup() {
        synchronized (this.zzakd) {
            this.zzauq = false;
            this.zzakd.notifyAll();
            zzkn.zzdd("ContentFetchThread: wakeup");
        }
    }

    /* access modifiers changed from: package-private */
    public zza zza(@Nullable View view, zzcr zzcr) {
        if (view == null) {
            return new zza(0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zza(0, 0);
            }
            zzcr.zze(text.toString(), globalVisibleRect);
            return new zza(1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzlt)) {
            zzcr.zzii();
            return zza((WebView) view, zzcr, globalVisibleRect) ? new zza(0, 1) : new zza(0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new zza(0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                zza zza2 = zza(viewGroup.getChildAt(i3), zzcr);
                i2 += zza2.zzavd;
                i += zza2.zzave;
            }
            return new zza(i2, i);
        }
    }

    /* access modifiers changed from: package-private */
    public void zza(@Nullable Activity activity) {
        if (activity != null) {
            View view = null;
            try {
                if (!(activity.getWindow() == null || activity.getWindow().getDecorView() == null)) {
                    view = activity.getWindow().getDecorView().findViewById(16908290);
                }
            } catch (Throwable th) {
                zzkn.zzdd("Failed getting root view of activity. Content not extracted.");
            }
            if (view != null) {
                zze(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void zza(zzcr zzcr, WebView webView, String str, boolean z) {
        zzcr.zzih();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (!TextUtils.isEmpty(webView.getTitle())) {
                    String valueOf = String.valueOf(webView.getTitle());
                    zzcr.zzd(new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(optString).length()).append(valueOf).append("\n").append(optString).toString(), z);
                } else {
                    zzcr.zzd(optString, z);
                }
            }
            if (zzcr.zzid()) {
                this.zzaur.zzb(zzcr);
            }
        } catch (JSONException e) {
            zzkn.zzdd("Json string may be malformed.");
        } catch (Throwable th) {
            zzkn.zza("Failed to get webview content.", th);
            this.zzaus.zza(th, "ContentFetchTask.processWebViewContent");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zza(ActivityManager.RunningAppProcessInfo runningAppProcessInfo) {
        return runningAppProcessInfo.importance == 100;
    }

    /* access modifiers changed from: package-private */
    @TargetApi(19)
    public boolean zza(final WebView webView, final zzcr zzcr, final boolean z) {
        if (!zzs.zzaxr()) {
            return false;
        }
        zzcr.zzii();
        webView.post(new Runnable() {
            ValueCallback<String> zzauy = new ValueCallback<String>() {
                /* renamed from: zzab */
                public void onReceiveValue(String str) {
                    zzcu.this.zza(zzcr, webView, str, z);
                }
            };

            public void run() {
                if (webView.getSettings().getJavaScriptEnabled()) {
                    try {
                        webView.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzauy);
                    } catch (Throwable th) {
                        this.zzauy.onReceiveValue("");
                    }
                }
            }
        });
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean zze(@Nullable final View view) {
        if (view == null) {
            return false;
        }
        view.post(new Runnable() {
            public void run() {
                zzcu.this.zzf(view);
            }
        });
        return true;
    }

    /* access modifiers changed from: package-private */
    public void zzf(View view) {
        try {
            zzcr zzcr = new zzcr(this.zzatu, this.zzauu, this.zzatw, this.zzauv);
            zza zza2 = zza(view, zzcr);
            zzcr.zzij();
            if (zza2.zzavd != 0 || zza2.zzave != 0) {
                if (zza2.zzave != 0 || zzcr.zzik() != 0) {
                    if (zza2.zzave != 0 || !this.zzaur.zza(zzcr)) {
                        this.zzaur.zzc(zzcr);
                    }
                }
            }
        } catch (Exception e) {
            zzkn.zzb("Exception in fetchContentOnUIThread", e);
            this.zzaus.zza(e, "ContentFetchTask.fetchContent");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzi(Context context) {
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return false;
        }
        return powerManager.isScreenOn();
    }

    public void zzim() {
        synchronized (this.zzakd) {
            if (this.mStarted) {
                zzkn.zzdd("Content hash thread already started, quiting...");
                return;
            }
            this.mStarted = true;
            start();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzin() {
        try {
            Context context = zzu.zzgc().getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null || keyguardManager == null) {
                return false;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (Process.myPid() == next.pid) {
                    if (zza(next) && !keyguardManager.inKeyguardRestrictedInputMode() && zzi(context)) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public zzcr zzio() {
        return this.zzaur.zzil();
    }

    public void zzip() {
        synchronized (this.zzakd) {
            this.zzauq = true;
            zzkn.zzdd(new StringBuilder(42).append("ContentFetchThread: paused, mPause = ").append(this.zzauq).toString());
        }
    }

    public boolean zziq() {
        return this.zzauq;
    }
}
