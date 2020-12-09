package com.facebook.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.Log;
import com.facebook.ads.internal.util.C0537g;
import com.facebook.ads.internal.util.C0553r;
import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

public class AdSettings {
    public static final boolean DEBUG = false;

    /* renamed from: a */
    static volatile boolean f742a = false;

    /* renamed from: b */
    private static final String f743b = AdSettings.class.getSimpleName();

    /* renamed from: c */
    private static final Collection<String> f744c = new HashSet();

    /* renamed from: d */
    private static final Collection<String> f745d = new HashSet();

    /* renamed from: e */
    private static String f746e = null;

    /* renamed from: f */
    private static boolean f747f = false;

    /* renamed from: g */
    private static String f748g = null;

    static {
        f745d.add("sdk");
        f745d.add("google_sdk");
        f745d.add("vbox86p");
        f745d.add("vbox86tp");
    }

    /* renamed from: a */
    private static void m703a(String str) {
        if (!f742a) {
            f742a = true;
            Log.d(f743b, "Test mode device hash: " + str);
            Log.d(f743b, "When testing your app with Facebook's ad units you must specify the device hashed ID to ensure the delivery of test ads, add the following code before loading an ad: AdSettings.addTestDevice(\"" + str + "\");");
        }
    }

    public static void addTestDevice(String str) {
        f744c.add(str);
    }

    public static void addTestDevices(Collection<String> collection) {
        f744c.addAll(collection);
    }

    public static void clearTestDevices() {
        f744c.clear();
    }

    public static String getUrlPrefix() {
        return f746e;
    }

    public static boolean isChildDirected() {
        return f747f;
    }

    public static boolean isTestMode(Context context) {
        if (f745d.contains(Build.PRODUCT)) {
            return true;
        }
        if (f748g == null) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("FBAdPrefs", 0);
            f748g = sharedPreferences.getString("deviceIdHash", (String) null);
            if (C0553r.m1245a(f748g)) {
                C0537g.C0540a a = C0537g.m1198a(context.getContentResolver());
                if (!C0553r.m1245a(a.f1259b)) {
                    f748g = C0553r.m1246b(a.f1259b);
                } else if (!C0553r.m1245a(a.f1258a)) {
                    f748g = C0553r.m1246b(a.f1258a);
                } else {
                    f748g = C0553r.m1246b(UUID.randomUUID().toString());
                }
                sharedPreferences.edit().putString("deviceIdHash", f748g).apply();
            }
        }
        if (f744c.contains(f748g)) {
            return true;
        }
        m703a(f748g);
        return false;
    }

    public static void setIsChildDirected(boolean z) {
        f747f = z;
    }

    public static void setUrlPrefix(String str) {
        f746e = str;
    }
}
