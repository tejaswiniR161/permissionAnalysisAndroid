package com.applovin.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ImageView;
import com.applovin.impl.sdk.C0382dh;
import java.io.File;

public class AppLovinSdkUtils {
    public static final String TAG = "AppLovinSdkUtils";

    /* renamed from: a */
    private static boolean m690a(Context context) {
        Bundle e = m694e(context);
        return e != null && e.getBoolean("applovin.sdk.verbose_logging", false);
    }

    /* renamed from: b */
    private static long m691b(Context context) {
        Bundle e = m694e(context);
        if (e != null) {
            return (long) e.getInt("applovin.sdk.ad_refresh_seconds", -100);
        }
        return -100;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getString("applovin.sdk.auto_preload_ad_sizes");
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m692c(android.content.Context r2) {
        /*
            android.os.Bundle r0 = m694e(r2)
            if (r0 == 0) goto L_0x000f
            java.lang.String r1 = "applovin.sdk.auto_preload_ad_sizes"
            java.lang.String r0 = r0.getString(r1)
            if (r0 == 0) goto L_0x000f
        L_0x000e:
            return r0
        L_0x000f:
            java.lang.String r0 = "BANNER,INTER"
            goto L_0x000e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.sdk.AppLovinSdkUtils.m692c(android.content.Context):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r0 = r0.getString("applovin.sdk.auto_preload_ad_types");
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m693d(android.content.Context r2) {
        /*
            android.os.Bundle r0 = m694e(r2)
            if (r0 == 0) goto L_0x000f
            java.lang.String r1 = "applovin.sdk.auto_preload_ad_types"
            java.lang.String r0 = r0.getString(r1)
            if (r0 == 0) goto L_0x000f
        L_0x000e:
            return r0
        L_0x000f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            com.applovin.sdk.AppLovinAdType r1 = com.applovin.sdk.AppLovinAdType.REGULAR
            java.lang.String r1 = r1.getLabel()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = ","
            java.lang.StringBuilder r0 = r0.append(r1)
            com.applovin.sdk.AppLovinAdType r1 = com.applovin.sdk.AppLovinAdType.INCENTIVIZED
            java.lang.String r1 = r1.getLabel()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x000e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.sdk.AppLovinSdkUtils.m693d(android.content.Context):java.lang.String");
    }

    public static int dpToPx(Context context, int i) {
        return (int) TypedValue.applyDimension(1, (float) i, context.getResources().getDisplayMetrics());
    }

    /* renamed from: e */
    private static Bundle m694e(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(AppLovinLogger.SDK_TAG, "Unable to retrieve application metadata", e);
            return null;
        }
    }

    public static boolean isValidString(String str) {
        return str != null && str.length() > 1;
    }

    public static void openUri(Context context, Uri uri, AppLovinSdk appLovinSdk) {
        try {
            context.startActivity(new Intent("android.intent.action.VIEW", uri));
        } catch (Throwable th) {
            appLovinSdk.getLogger().mo5667e(TAG, "Unable to open \"" + uri + "\".", th);
        }
    }

    public static void openUrl(Context context, String str, AppLovinSdk appLovinSdk) {
        openUri(context, Uri.parse(str), appLovinSdk);
    }

    public static void recycleImageView(ImageView imageView) {
        Drawable drawable;
        if (imageView != null && (drawable = imageView.getDrawable()) != null && (drawable instanceof BitmapDrawable)) {
            ((BitmapDrawable) drawable).getBitmap().recycle();
        }
    }

    public static String retrieveSdkKey(Context context) {
        Bundle e = m694e(context);
        if (e == null) {
            return null;
        }
        String string = e.getString("applovin.sdk.key");
        return string != null ? string : "";
    }

    public static AppLovinSdkSettings retrieveUserSettings(Context context) {
        AppLovinSdkSettings appLovinSdkSettings = new AppLovinSdkSettings();
        appLovinSdkSettings.setVerboseLogging(m690a(context));
        appLovinSdkSettings.setBannerAdRefreshSeconds(m691b(context));
        appLovinSdkSettings.setAutoPreloadSizes(m692c(context));
        appLovinSdkSettings.setAutoPreloadTypes(m693d(context));
        return appLovinSdkSettings;
    }

    public static void safePopulateImageView(Context context, ImageView imageView, int i, int i2) {
        recycleImageView(imageView);
        Bitmap a = C0382dh.m579a(context, i, i2);
        if (a != null) {
            imageView.setImageBitmap(a);
        }
    }

    public static void safePopulateImageView(ImageView imageView, Uri uri, int i) {
        recycleImageView(imageView);
        Bitmap a = C0382dh.m580a(new File(uri.getPath()), i);
        if (a != null) {
            imageView.setImageBitmap(a);
        }
    }
}
