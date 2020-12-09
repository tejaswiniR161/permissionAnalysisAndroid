package com.facebook.ads.internal.util;

import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.C0473e;
import com.facebook.ads.internal.thirdparty.http.C0509a;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.util.g */
public class C0537g {

    /* renamed from: a */
    private static final Uri f1254a = Uri.parse("content://com.facebook.katana.provider.AttributionIdProvider");

    /* renamed from: b */
    private static final String f1255b = C0537g.class.getSimpleName();

    /* renamed from: c */
    private static boolean f1256c = false;

    /* renamed from: com.facebook.ads.internal.util.g$a */
    public static class C0540a {

        /* renamed from: a */
        public String f1258a;

        /* renamed from: b */
        public String f1259b;

        /* renamed from: c */
        public boolean f1260c;

        public C0540a(String str, String str2, boolean z) {
            this.f1258a = str;
            this.f1259b = str2;
            this.f1260c = z;
        }
    }

    /* renamed from: a */
    public static C0473e m1197a(AdSize adSize) {
        switch (adSize) {
            case INTERSTITIAL:
                return C0473e.WEBVIEW_INTERSTITIAL_UNKNOWN;
            case RECTANGLE_HEIGHT_250:
                return C0473e.WEBVIEW_BANNER_250;
            case BANNER_HEIGHT_90:
                return C0473e.WEBVIEW_BANNER_90;
            case BANNER_HEIGHT_50:
                return C0473e.WEBVIEW_BANNER_50;
            default:
                return C0473e.WEBVIEW_BANNER_LEGACY;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0078  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.ads.internal.util.C0537g.C0540a m1198a(android.content.ContentResolver r7) {
        /*
            r6 = 0
            r0 = 3
            java.lang.String[] r2 = new java.lang.String[r0]     // Catch:{ Exception -> 0x0064, all -> 0x0074 }
            r0 = 0
            java.lang.String r1 = "aid"
            r2[r0] = r1     // Catch:{ Exception -> 0x0064, all -> 0x0074 }
            r0 = 1
            java.lang.String r1 = "androidid"
            r2[r0] = r1     // Catch:{ Exception -> 0x0064, all -> 0x0074 }
            r0 = 2
            java.lang.String r1 = "limit_tracking"
            r2[r0] = r1     // Catch:{ Exception -> 0x0064, all -> 0x0074 }
            android.net.Uri r1 = f1254a     // Catch:{ Exception -> 0x0064, all -> 0x0074 }
            r3 = 0
            r4 = 0
            r5 = 0
            r0 = r7
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5)     // Catch:{ Exception -> 0x0064, all -> 0x0074 }
            if (r1 == 0) goto L_0x0025
            boolean r0 = r1.moveToFirst()     // Catch:{ Exception -> 0x007e }
            if (r0 != 0) goto L_0x0033
        L_0x0025:
            com.facebook.ads.internal.util.g$a r0 = new com.facebook.ads.internal.util.g$a     // Catch:{ Exception -> 0x007e }
            r2 = 0
            r3 = 0
            r4 = 0
            r0.<init>(r2, r3, r4)     // Catch:{ Exception -> 0x007e }
            if (r1 == 0) goto L_0x0032
            r1.close()
        L_0x0032:
            return r0
        L_0x0033:
            java.lang.String r0 = "aid"
            int r0 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x007e }
            java.lang.String r2 = r1.getString(r0)     // Catch:{ Exception -> 0x007e }
            java.lang.String r0 = "androidid"
            int r0 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x007e }
            java.lang.String r3 = r1.getString(r0)     // Catch:{ Exception -> 0x007e }
            java.lang.String r0 = "limit_tracking"
            int r0 = r1.getColumnIndex(r0)     // Catch:{ Exception -> 0x007e }
            java.lang.String r0 = r1.getString(r0)     // Catch:{ Exception -> 0x007e }
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)     // Catch:{ Exception -> 0x007e }
            com.facebook.ads.internal.util.g$a r0 = new com.facebook.ads.internal.util.g$a     // Catch:{ Exception -> 0x007e }
            boolean r4 = r4.booleanValue()     // Catch:{ Exception -> 0x007e }
            r0.<init>(r2, r3, r4)     // Catch:{ Exception -> 0x007e }
            if (r1 == 0) goto L_0x0032
            r1.close()
            goto L_0x0032
        L_0x0064:
            r0 = move-exception
            r1 = r6
        L_0x0066:
            com.facebook.ads.internal.util.g$a r0 = new com.facebook.ads.internal.util.g$a     // Catch:{ all -> 0x007c }
            r2 = 0
            r3 = 0
            r4 = 0
            r0.<init>(r2, r3, r4)     // Catch:{ all -> 0x007c }
            if (r1 == 0) goto L_0x0032
            r1.close()
            goto L_0x0032
        L_0x0074:
            r0 = move-exception
            r1 = r6
        L_0x0076:
            if (r1 == 0) goto L_0x007b
            r1.close()
        L_0x007b:
            throw r0
        L_0x007c:
            r0 = move-exception
            goto L_0x0076
        L_0x007e:
            r0 = move-exception
            goto L_0x0066
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.util.C0537g.m1198a(android.content.ContentResolver):com.facebook.ads.internal.util.g$a");
    }

    /* renamed from: a */
    public static Object m1199a(Object obj, Method method, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (Exception e) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m1200a(InputStream inputStream) {
        StringWriter stringWriter = new StringWriter();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        char[] cArr = new char[4096];
        while (true) {
            int read = inputStreamReader.read(cArr);
            if (read != -1) {
                stringWriter.write(cArr, 0, read);
            } else {
                String stringWriter2 = stringWriter.toString();
                stringWriter.close();
                inputStreamReader.close();
                return stringWriter2;
            }
        }
    }

    /* renamed from: a */
    public static String m1201a(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : map.entrySet()) {
            try {
                jSONObject.put((String) next.getKey(), next.getValue());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    public static String m1202a(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            String a = m1200a((InputStream) gZIPInputStream);
            gZIPInputStream.close();
            byteArrayInputStream.close();
            return a;
        } catch (Exception e) {
            C0531c.m1182a(C0528b.m1179a(e, "Error decompressing data"));
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public static Method m1203a(Class<?> cls, String str, Class<?>... clsArr) {
        try {
            return cls.getMethod(str, clsArr);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    /* renamed from: a */
    public static Method m1204a(String str, String str2, Class<?>... clsArr) {
        try {
            return m1203a(Class.forName(str), str2, clsArr);
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    /* renamed from: a */
    public static void m1205a(Context context, Uri uri) {
        Intent intent = new Intent("android.intent.action.VIEW", uri);
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.addFlags(268435456);
        intent.putExtra("com.android.browser.application_id", context.getPackageName());
        intent.putExtra("create_new_tab", false);
        context.startActivity(intent);
    }

    /* renamed from: a */
    public static void m1206a(Context context, String str) {
        if (AdSettings.isTestMode(context)) {
            Log.d("FBAudienceNetworkLog", str + " (displayed for test ads only)");
        }
    }

    /* renamed from: a */
    public static void m1207a(DisplayMetrics displayMetrics, View view, AdSize adSize) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(((int) (((float) displayMetrics.widthPixels) / displayMetrics.density)) >= adSize.getWidth() ? displayMetrics.widthPixels : (int) Math.ceil((double) (((float) adSize.getWidth()) * displayMetrics.density)), (int) Math.ceil((double) (((float) adSize.getHeight()) * displayMetrics.density)));
        layoutParams.addRule(14, -1);
        view.setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    public static void m1208a(View view, boolean z, String str) {
    }

    /* renamed from: a */
    public static boolean m1209a() {
        String urlPrefix = AdSettings.getUrlPrefix();
        return !C0553r.m1245a(urlPrefix) && urlPrefix.endsWith(".sb");
    }

    /* renamed from: a */
    public static boolean m1210a(Context context) {
        try {
            if (!((PowerManager) context.getSystemService("power")).isScreenOn()) {
                return false;
            }
            return !((KeyguardManager) context.getSystemService("keyguard")).inKeyguardRestrictedInputMode();
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    public static boolean m1211a(Context context, View view, int i) {
        if (view == null) {
            m1208a(view, false, "adView is null.");
            return false;
        } else if (view.getParent() == null) {
            m1208a(view, false, "adView has no parent.");
            return false;
        } else if (view.getVisibility() != 0) {
            m1208a(view, false, "adView is not set to VISIBLE.");
            return false;
        } else if (Build.VERSION.SDK_INT < 11 || view.getAlpha() >= 0.9f) {
            int width = view.getWidth();
            int height = view.getHeight();
            int[] iArr = new int[2];
            try {
                view.getLocationOnScreen(iArr);
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                if (iArr[0] < 0 || displayMetrics.widthPixels - iArr[0] < width) {
                    m1208a(view, false, "adView is not fully on screen horizontally.");
                    return false;
                }
                int i2 = (int) ((((double) height) * (100.0d - ((double) i))) / 100.0d);
                if (iArr[1] < 0 && Math.abs(iArr[1]) > i2) {
                    m1208a(view, false, "adView is not visible from the top.");
                    return false;
                } else if ((height + iArr[1]) - displayMetrics.heightPixels > i2) {
                    m1208a(view, false, "adView is not visible from the bottom.");
                    return false;
                } else {
                    m1208a(view, true, "adView is visible.");
                    return m1210a(context);
                }
            } catch (NullPointerException e) {
                m1208a(view, false, "Cannot get location on screen.");
                return false;
            }
        } else {
            m1208a(view, false, "adView is too transparent.");
            return false;
        }
    }

    /* renamed from: a */
    public static byte[] m1212a(String str) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(str.length());
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(str.getBytes());
            gZIPOutputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e) {
            C0531c.m1182a(C0528b.m1179a(e, "Error compressing data"));
            e.printStackTrace();
            return new byte[0];
        }
    }

    /* renamed from: b */
    public static void m1213b() {
        if (!f1256c) {
            try {
                TrustManager[] trustManagerArr = {new X509TrustManager() {
                    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
                    }

                    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
                    }

                    public X509Certificate[] getAcceptedIssuers() {
                        return null;
                    }
                }};
                SSLContext instance = SSLContext.getInstance("SSL");
                instance.init((KeyManager[]) null, trustManagerArr, new SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(instance.getSocketFactory());
                Log.d(f1255b, "Sandbox SSL validation disabled.");
            } catch (Exception e) {
                Log.e(f1255b, "Failed to disable sandbox SSL validation: " + e);
            }
        } else {
            Log.d(f1255b, "Sandbox SSL validation already disabled, ignoring...");
        }
    }

    /* renamed from: c */
    public static C0509a m1214c() {
        C0509a aVar = new C0509a();
        aVar.mo6070c(30000);
        aVar.mo6069b(3);
        if (m1209a()) {
            m1213b();
        }
        return aVar;
    }
}
