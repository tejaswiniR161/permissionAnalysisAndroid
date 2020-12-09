package com.facebook.ads.internal.dto;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.facebook.ads.internal.C0474f;
import com.facebook.ads.internal.util.C0528b;
import com.facebook.ads.internal.util.C0531c;
import com.facebook.ads.internal.util.C0537g;

/* renamed from: com.facebook.ads.internal.dto.f */
public class C0472f {

    /* renamed from: a */
    public static final String f1064a = Build.VERSION.RELEASE;

    /* renamed from: b */
    public static String f1065b = "";

    /* renamed from: c */
    public static String f1066c = "";

    /* renamed from: d */
    public static String f1067d = "";

    /* renamed from: e */
    public static String f1068e = "";

    /* renamed from: f */
    public static String f1069f = "";

    /* renamed from: g */
    public static int f1070g = 0;

    /* renamed from: h */
    public static String f1071h = "";

    /* renamed from: i */
    public static String f1072i = "";

    /* renamed from: j */
    public static int f1073j = 0;

    /* renamed from: k */
    public static String f1074k = "";

    /* renamed from: l */
    public static int f1075l = 0;

    /* renamed from: m */
    public static String f1076m = "";

    /* renamed from: n */
    public static String f1077n = "";

    /* renamed from: o */
    public static String f1078o = "";

    /* renamed from: p */
    public static boolean f1079p = false;

    /* renamed from: q */
    public static String f1080q = "";

    /* renamed from: r */
    private static boolean f1081r = false;

    /* renamed from: a */
    public static synchronized void m1002a(Context context) {
        synchronized (C0472f.class) {
            if (!f1081r) {
                f1081r = true;
                m1004c(context);
            }
            m1005d(context);
        }
    }

    /* renamed from: b */
    public static void m1003b(Context context) {
        C0537g.C0540a aVar;
        C0474f fVar;
        if (f1081r) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("SDKIDFA", 0);
                if (sharedPreferences.contains("attributionId")) {
                    f1077n = sharedPreferences.getString("attributionId", "");
                }
                if (sharedPreferences.contains("advertisingId")) {
                    f1078o = sharedPreferences.getString("advertisingId", "");
                    f1079p = sharedPreferences.getBoolean("limitAdTracking", f1079p);
                    f1080q = C0474f.C0478c.SHARED_PREFS.name();
                }
                try {
                    aVar = C0537g.m1198a(context.getContentResolver());
                } catch (Exception e) {
                    C0531c.m1182a(C0528b.m1179a(e, "Error retrieving attribution id from fb4a"));
                    aVar = null;
                }
                if (aVar != null) {
                    String str = aVar.f1258a;
                    if (str != null) {
                        f1077n = str;
                    }
                }
                try {
                    fVar = C0474f.m1008a(context, aVar);
                } catch (Exception e2) {
                    C0531c.m1182a(C0528b.m1179a(e2, "Error retrieving advertising id from Google Play Services"));
                    fVar = null;
                }
                if (fVar != null) {
                    String a = fVar.mo6001a();
                    Boolean valueOf = Boolean.valueOf(fVar.mo6002b());
                    if (a != null) {
                        f1078o = a;
                        f1079p = valueOf.booleanValue();
                        f1080q = fVar.mo6003c().name();
                    }
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("attributionId", f1077n);
                edit.putString("advertisingId", f1078o);
                edit.putBoolean("limitAdTracking", f1079p);
                edit.apply();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    private static void m1004c(Context context) {
        String networkOperatorName;
        String installerPackageName;
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            f1067d = packageInfo.packageName;
            f1069f = packageInfo.versionName;
            f1070g = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
        }
        try {
            if (f1067d != null && f1067d.length() >= 0 && (installerPackageName = packageManager.getInstallerPackageName(f1067d)) != null && installerPackageName.length() > 0) {
                f1071h = installerPackageName;
            }
        } catch (Exception e2) {
        }
        try {
            CharSequence applicationLabel = packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
            if (applicationLabel != null && applicationLabel.length() > 0) {
                f1068e = applicationLabel.toString();
            }
        } catch (PackageManager.NameNotFoundException e3) {
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (!(telephonyManager == null || (networkOperatorName = telephonyManager.getNetworkOperatorName()) == null || networkOperatorName.length() <= 0)) {
            f1072i = networkOperatorName;
        }
        String str = Build.MANUFACTURER;
        if (str != null && str.length() > 0) {
            f1065b = str;
        }
        String str2 = Build.MODEL;
        if (str2 != null && str2.length() > 0) {
            f1066c = Build.MODEL;
        }
    }

    /* renamed from: d */
    private static void m1005d(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
                f1073j = activeNetworkInfo.getType();
                f1074k = activeNetworkInfo.getTypeName();
                f1075l = activeNetworkInfo.getSubtype();
                f1076m = activeNetworkInfo.getSubtypeName();
            }
        } catch (Exception e) {
        }
    }
}
