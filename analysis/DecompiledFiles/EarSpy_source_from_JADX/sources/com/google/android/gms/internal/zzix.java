package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@zziy
public class zzix implements Thread.UncaughtExceptionHandler {
    private Context mContext;
    private VersionInfoParcel zzaop;
    @Nullable
    private Thread.UncaughtExceptionHandler zzcff;
    @Nullable
    private Thread.UncaughtExceptionHandler zzcfg;

    public zzix(Context context, VersionInfoParcel versionInfoParcel, @Nullable Thread.UncaughtExceptionHandler uncaughtExceptionHandler, @Nullable Thread.UncaughtExceptionHandler uncaughtExceptionHandler2) {
        this.zzcff = uncaughtExceptionHandler;
        this.zzcfg = uncaughtExceptionHandler2;
        this.mContext = context;
        this.zzaop = versionInfoParcel;
    }

    public static zzix zza(Context context, Thread thread, VersionInfoParcel versionInfoParcel) {
        if (context == null || thread == null || versionInfoParcel == null) {
            return null;
        }
        if (!zzu(context)) {
            return null;
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = thread.getUncaughtExceptionHandler();
        zzix zzix = new zzix(context, versionInfoParcel, uncaughtExceptionHandler, Thread.getDefaultUncaughtExceptionHandler());
        if (uncaughtExceptionHandler != null && (uncaughtExceptionHandler instanceof zzix)) {
            return (zzix) uncaughtExceptionHandler;
        }
        try {
            thread.setUncaughtExceptionHandler(zzix);
            return zzix;
        } catch (SecurityException e) {
            zzkn.zzc("Fail to set UncaughtExceptionHandler.", e);
            return null;
        }
    }

    private Throwable zzd(Throwable th) {
        Throwable th2;
        if (zzdi.zzbau.get().booleanValue()) {
            return th;
        }
        LinkedList linkedList = new LinkedList();
        while (th != null) {
            linkedList.push(th);
            th = th.getCause();
        }
        Throwable th3 = null;
        while (!linkedList.isEmpty()) {
            Throwable th4 = (Throwable) linkedList.pop();
            StackTraceElement[] stackTrace = th4.getStackTrace();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new StackTraceElement(th4.getClass().getName(), "<filtered>", "<filtered>", 1));
            boolean z = false;
            for (StackTraceElement stackTraceElement : stackTrace) {
                if (zzcg(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                    z = true;
                } else if (zzch(stackTraceElement.getClassName())) {
                    arrayList.add(stackTraceElement);
                } else {
                    arrayList.add(new StackTraceElement("<filtered>", "<filtered>", "<filtered>", 1));
                }
            }
            if (z) {
                th2 = th3 == null ? new Throwable(th4.getMessage()) : new Throwable(th4.getMessage(), th3);
                th2.setStackTrace((StackTraceElement[]) arrayList.toArray(new StackTraceElement[0]));
            } else {
                th2 = th3;
            }
            th3 = th2;
        }
        return th3;
    }

    private static boolean zzu(Context context) {
        return zzdi.zzbat.get().booleanValue();
    }

    public void uncaughtException(Thread thread, Throwable th) {
        if (zzb(th)) {
            if (Looper.getMainLooper().getThread() != thread) {
                zza(th, "AdMobExceptionReporter.uncaughtException");
                return;
            }
            zzc(th);
        }
        if (this.zzcff != null) {
            this.zzcff.uncaughtException(thread, th);
        } else if (this.zzcfg != null) {
            this.zzcfg.uncaughtException(thread, th);
        }
    }

    /* access modifiers changed from: package-private */
    public String zza(Class cls, Throwable th, String str) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT)).appendQueryParameter("device", zzu.zzfz().zzuj()).appendQueryParameter("js", this.zzaop.zzcs).appendQueryParameter("appid", this.mContext.getApplicationContext().getPackageName()).appendQueryParameter("exceptiontype", cls.getName()).appendQueryParameter("stacktrace", stringWriter.toString()).appendQueryParameter("eids", TextUtils.join(",", zzdi.zzkr())).appendQueryParameter("exceptionkey", str).appendQueryParameter("cl", "134102376").appendQueryParameter("rc", "dev").toString();
    }

    public void zza(Throwable th, String str) {
        Throwable zzd;
        if (zzu(this.mContext) && (zzd = zzd(th)) != null) {
            Class<?> cls = th.getClass();
            ArrayList arrayList = new ArrayList();
            arrayList.add(zza((Class) cls, zzd, str));
            zzu.zzfz().zza((List<String>) arrayList, zzu.zzgd().zztp());
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzb(Throwable th) {
        boolean z = true;
        if (th == null) {
            return false;
        }
        boolean z2 = false;
        boolean z3 = false;
        while (th != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                if (zzcg(stackTraceElement.getClassName())) {
                    z3 = true;
                }
                if (getClass().getName().equals(stackTraceElement.getClassName())) {
                    z2 = true;
                }
            }
            th = th.getCause();
        }
        if (!z3 || z2) {
            z = false;
        }
        return z;
    }

    public void zzc(Throwable th) {
        zza(th, "");
    }

    /* access modifiers changed from: protected */
    public boolean zzcg(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith(zzdi.zzbav.get())) {
            return true;
        }
        try {
            return Class.forName(str).isAnnotationPresent(zziy.class);
        } catch (Exception e) {
            Exception exc = e;
            String valueOf = String.valueOf(str);
            zzkn.zza(valueOf.length() != 0 ? "Fail to check class type for class ".concat(valueOf) : new String("Fail to check class type for class "), exc);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzch(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("android.") || str.startsWith("java.");
    }
}
