package com.applovin.impl.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;
import com.applovin.sdk.AppLovinAdSize;
import com.applovin.sdk.AppLovinAdType;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinSdkUtils;

/* renamed from: com.applovin.impl.sdk.cp */
class C0363cp implements Runnable {

    /* renamed from: a */
    private final AppLovinSdkImpl f604a;

    /* renamed from: b */
    private final AppLovinLogger f605b;

    /* renamed from: c */
    private final Context f606c;

    /* renamed from: d */
    private final AppLovinSdkSettings f607d;

    C0363cp(AppLovinSdkImpl appLovinSdkImpl, AppLovinSdkSettings appLovinSdkSettings) {
        this.f604a = appLovinSdkImpl;
        this.f606c = appLovinSdkImpl.getApplicationContext();
        this.f607d = appLovinSdkSettings;
        this.f605b = appLovinSdkImpl.getLogger();
    }

    /* renamed from: c */
    private void m517c() {
        String str = (String) this.f604a.mo5363a(C0343bw.f450J);
        if (str.length() > 0) {
            for (String fromString : str.split(",")) {
                this.f604a.mo5367c().mo5469d(new C0347c(AppLovinAdSize.fromString(fromString), AppLovinAdType.REGULAR));
            }
        }
        if (((Boolean) this.f604a.mo5363a(C0343bw.f451K)).booleanValue()) {
            this.f604a.mo5367c().mo5469d(new C0347c(AppLovinAdSize.INTERSTITIAL, AppLovinAdType.INCENTIVIZED));
        }
        if (((Boolean) this.f604a.mo5363a(C0343bw.f480aM)).booleanValue()) {
            this.f604a.mo5368d().mo5469d(NativeAdImpl.SPEC_NATIVE);
        }
    }

    /* renamed from: d */
    private void m518d() {
        String str;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f606c);
        try {
            if (defaultSharedPreferences.getInt("com.applovin.sdk.impl.lastKnownVersionCode", 0) < 614) {
                Log.i("TaskInitializeSdk", "SDK has been updated since last run. Continuing...");
                this.f604a.getSettingsManager().mo5551d();
                this.f604a.getSettingsManager().mo5549b();
            } else {
                Log.d("TaskInitializeSdk", "SDK has not been updated since last run. Continuing...");
            }
        } catch (Exception e) {
            this.f604a.getLogger().mo5667e("TaskInitializeSdk", "Unable to check for SDK update", e);
        } finally {
            str = "com.applovin.sdk.impl.lastKnownVersionCode";
            defaultSharedPreferences.edit().putInt(str, AppLovinSdk.VERSION_CODE).apply();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5632a() {
        if (C0396r.m637a("android.permission.INTERNET", this.f606c)) {
            return true;
        }
        this.f605b.userError("TaskInitializeSdk", "Unable to enable AppLovin SDK: no android.permission.INTERNET");
        return false;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5633b() {
        this.f604a.mo5362a().mo5637a((C0342bv) new C0351cd(this.f604a), C0365cr.MAIN, 500);
    }

    public void run() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f605b.mo5665d("TaskInitializeSdk", "Initializing AppLovin SDK 6.1.4...");
        try {
            if (mo5632a()) {
                m518d();
                C0346bz settingsManager = this.f604a.getSettingsManager();
                settingsManager.mo5550c();
                if (((Boolean) settingsManager.mo5545a(C0343bw.f520b)).booleanValue()) {
                    settingsManager.mo5547a(this.f607d);
                    settingsManager.mo5549b();
                }
                C0349cb b = this.f604a.mo5366b();
                b.mo5601c();
                b.mo5602c("ad_imp_session");
                C0293a.m236b(this.f604a);
                this.f604a.getFileManager().mo5710d(this.f606c);
                m517c();
                mo5633b();
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f606c);
                if (!AppLovinSdkUtils.isValidString(defaultSharedPreferences.getString("com.applovin.sdk.impl.isFirstRun", (String) null))) {
                    defaultSharedPreferences.edit().putString("com.applovin.sdk.impl.isFirstRun", Boolean.toString(true)).commit();
                }
                this.f604a.getPersistentPostbackManager().mo5505a();
                this.f604a.getEventService().trackEvent("landing");
                this.f604a.mo5365a(true);
            } else {
                this.f604a.mo5365a(false);
            }
            this.f605b.mo5665d("TaskInitializeSdk", "AppLovin SDK 6.1.4 initialization " + (this.f604a.isEnabled() ? "succeeded" : "failed") + " in " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
        } catch (Throwable th) {
            Throwable th2 = th;
            this.f605b.mo5665d("TaskInitializeSdk", "AppLovin SDK 6.1.4 initialization " + (this.f604a.isEnabled() ? "succeeded" : "failed") + " in " + (System.currentTimeMillis() - currentTimeMillis) + "ms");
            throw th2;
        }
    }
}
