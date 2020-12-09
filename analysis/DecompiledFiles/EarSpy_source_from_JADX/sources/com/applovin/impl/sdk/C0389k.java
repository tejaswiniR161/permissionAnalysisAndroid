package com.applovin.impl.sdk;

import android.util.Log;
import com.applovin.sdk.AppLovinLogger;

/* renamed from: com.applovin.impl.sdk.k */
class C0389k implements AppLovinLogger {

    /* renamed from: a */
    private C0346bz f673a;

    /* renamed from: b */
    private C0390l f674b;

    C0389k() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5662a(C0346bz bzVar) {
        this.f673a = bzVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5663a(C0390l lVar) {
        this.f674b = lVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5664a() {
        if (this.f673a != null) {
            return ((Boolean) this.f673a.mo5545a(C0343bw.f552j)).booleanValue();
        }
        return false;
    }

    /* renamed from: d */
    public void mo5665d(String str, String str2) {
        if (mo5664a()) {
            Log.d(AppLovinLogger.SDK_TAG, "[" + str + "] " + str2);
        }
        if (this.f674b != null) {
            this.f674b.mo5673a("DEBUG  [" + str + "] " + str2);
        }
    }

    /* renamed from: e */
    public void mo5666e(String str, String str2) {
        mo5667e(str, str2, (Throwable) null);
    }

    /* renamed from: e */
    public void mo5667e(String str, String str2, Throwable th) {
        if (mo5664a()) {
            Log.e(AppLovinLogger.SDK_TAG, "[" + str + "] " + str2, th);
        }
        if (this.f674b != null) {
            this.f674b.mo5673a("ERROR  [" + str + "] " + str2 + (th != null ? ": " + th.getMessage() : ""));
        }
    }

    /* renamed from: i */
    public void mo5668i(String str, String str2) {
        if (mo5664a()) {
            Log.i(AppLovinLogger.SDK_TAG, "[" + str + "] " + str2);
        }
        if (this.f674b != null) {
            this.f674b.mo5673a("INFO  [" + str + "] " + str2);
        }
    }

    public void userError(String str, String str2) {
        userError(str, str2, (Throwable) null);
    }

    public void userError(String str, String str2, Throwable th) {
        Log.e(AppLovinLogger.SDK_TAG, "[" + str + "] " + str2, th);
        if (this.f674b != null) {
            this.f674b.mo5673a("USER  [" + str + "] " + str2 + (th != null ? ": " + th.getMessage() : ""));
        }
    }

    /* renamed from: w */
    public void mo5671w(String str, String str2) {
        mo5672w(str, str2, (Throwable) null);
    }

    /* renamed from: w */
    public void mo5672w(String str, String str2, Throwable th) {
        if (mo5664a()) {
            Log.w(AppLovinLogger.SDK_TAG, "[" + str + "] " + str2, th);
        }
        if (this.f674b != null) {
            this.f674b.mo5673a("WARN  [" + str + "] " + str2);
        }
    }
}
