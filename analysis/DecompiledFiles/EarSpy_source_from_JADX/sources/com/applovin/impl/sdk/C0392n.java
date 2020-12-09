package com.applovin.impl.sdk;

import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.os.Build;
import android.os.StrictMode;
import android.view.Display;
import android.view.WindowManager;

/* renamed from: com.applovin.impl.sdk.n */
public class C0392n {
    /* renamed from: a */
    public static Point m606a(Context context) {
        Point point = new Point();
        point.x = 480;
        point.y = 320;
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 13) {
                defaultDisplay.getSize(point);
            } else {
                point.x = defaultDisplay.getWidth();
                point.y = defaultDisplay.getHeight();
            }
        } catch (Throwable th) {
        }
        return point;
    }

    /* renamed from: a */
    static void m607a() {
        try {
            if (Build.VERSION.SDK_INT >= 9) {
                StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
            }
        } catch (Throwable th) {
        }
    }

    /* renamed from: a */
    public static boolean m608a(Class cls, Context context) {
        return context.getPackageManager().resolveActivity(new Intent(context, cls), 0) != null;
    }

    /* renamed from: a */
    public static boolean m609a(String str, Context context) {
        return context.checkCallingOrSelfPermission(str) == 0;
    }

    /* renamed from: b */
    public static boolean m610b() {
        return Build.VERSION.SDK_INT >= 15;
    }

    /* renamed from: c */
    public static boolean m611c() {
        return Build.VERSION.SDK_INT >= 19;
    }
}
