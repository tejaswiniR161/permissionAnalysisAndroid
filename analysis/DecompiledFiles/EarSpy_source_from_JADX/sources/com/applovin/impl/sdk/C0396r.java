package com.applovin.impl.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.applovin.sdk.AppLovinLogger;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;

/* renamed from: com.applovin.impl.sdk.r */
class C0396r {

    /* renamed from: a */
    private final AppLovinSdkImpl f682a;

    /* renamed from: b */
    private final Context f683b;

    /* renamed from: c */
    private final AppLovinLogger f684c;

    C0396r(AppLovinSdkImpl appLovinSdkImpl) {
        if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        }
        this.f682a = appLovinSdkImpl;
        this.f684c = appLovinSdkImpl.getLogger();
        this.f683b = appLovinSdkImpl.getApplicationContext();
    }

    /* renamed from: a */
    static boolean m637a(String str, Context context) {
        if (str == null) {
            throw new IllegalArgumentException("No permission name specified");
        } else if (context != null) {
            return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
        } else {
            throw new IllegalArgumentException("No context specified");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0399u mo5690a() {
        TelephonyManager telephonyManager;
        C0399u uVar = new C0399u();
        uVar.f698h = Locale.getDefault();
        uVar.f691a = Build.MODEL;
        uVar.f692b = Build.VERSION.RELEASE;
        uVar.f693c = Build.MANUFACTURER;
        uVar.f695e = Build.VERSION.SDK_INT;
        uVar.f694d = Build.DEVICE;
        if (mo5691a("android.permission.READ_PHONE_STATE") && (telephonyManager = (TelephonyManager) this.f683b.getSystemService("phone")) != null) {
            uVar.f696f = telephonyManager.getSimCountryIso().toUpperCase(Locale.ENGLISH);
            String networkOperatorName = telephonyManager.getNetworkOperatorName();
            try {
                uVar.f697g = URLEncoder.encode(networkOperatorName, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                uVar.f697g = networkOperatorName;
            }
        }
        return uVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5691a(String str) {
        return m637a(str, this.f683b);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0398t mo5692b() {
        ApplicationInfo applicationInfo = this.f683b.getApplicationInfo();
        long lastModified = new File(applicationInfo.sourceDir).lastModified();
        PackageManager packageManager = this.f683b.getPackageManager();
        PackageInfo packageInfo = null;
        try {
            packageInfo = packageManager.getPackageInfo(this.f683b.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
        }
        C0398t tVar = new C0398t();
        tVar.f689c = applicationInfo.packageName;
        tVar.f690d = lastModified;
        tVar.f687a = String.valueOf(packageManager.getApplicationLabel(applicationInfo));
        tVar.f688b = packageInfo != null ? packageInfo.versionName : "";
        return tVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public C0397s mo5693c() {
        Object invoke;
        try {
            Class<?> cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            if (!(cls == null || (invoke = cls.getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke((Object) null, new Object[]{this.f683b})) == null)) {
                Class<?> cls2 = invoke.getClass();
                Object invoke2 = cls2.getMethod("isLimitAdTrackingEnabled", (Class[]) null).invoke(invoke, (Object[]) null);
                Object invoke3 = cls2.getMethod("getId", (Class[]) null).invoke(invoke, (Object[]) null);
                C0397s sVar = new C0397s();
                String str = (String) invoke3;
                String str2 = str == null ? "" : str;
                sVar.f685a = ((Boolean) invoke2).booleanValue();
                sVar.f686b = str2;
                return sVar;
            }
        } catch (ClassNotFoundException e) {
            this.f684c.userError("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", e);
        } catch (Throwable th) {
            this.f684c.mo5667e("DataCollector", "Could not collect Google Advertising ID - this will negatively impact your eCPMs! Please integrate the Google Play Services SDK into your application. More info can be found online at http://developer.android.com/google/play-services/setup.html. If you're sure you've integrated the SDK and are still seeing this message, you may need to add a ProGuard exception: -keep public class com.google.android.gms.** { public protected *; }", th);
        }
        C0397s sVar2 = new C0397s();
        sVar2.f686b = "";
        sVar2.f685a = false;
        return sVar2;
    }
}
