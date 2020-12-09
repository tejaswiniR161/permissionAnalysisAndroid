package com.applovin.impl.sdk;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.p000v4.p002os.EnvironmentCompat;
import java.io.InputStream;
import java.util.Scanner;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.q */
class C0395q {

    /* renamed from: a */
    private static final int[] f678a = {7, 4, 2, 1, 11};

    /* renamed from: b */
    private static final int[] f679b = {5, 6, 10, 3, 9, 8, 14};

    /* renamed from: c */
    private static final int[] f680c = {15, 12, 13};

    /* renamed from: d */
    private static final String f681d = C0395q.class.getSimpleName();

    C0395q() {
    }

    /* renamed from: a */
    private static NetworkInfo m626a(Context context) {
        ConnectivityManager connectivityManager;
        if (!C0396r.m637a("android.permission.ACCESS_NETWORK_STATE", context) || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    /* renamed from: a */
    static String m627a(AppLovinSdkImpl appLovinSdkImpl) {
        NetworkInfo a = m626a(appLovinSdkImpl.getApplicationContext());
        if (a == null) {
            return EnvironmentCompat.MEDIA_UNKNOWN;
        }
        int type = a.getType();
        int subtype = a.getSubtype();
        String str = type == 1 ? "wifi" : type == 0 ? m634a(subtype, f678a) ? "2g" : m634a(subtype, f679b) ? "3g" : m634a(subtype, f680c) ? "4g" : "mobile" : EnvironmentCompat.MEDIA_UNKNOWN;
        appLovinSdkImpl.getLogger().mo5665d(f681d, "Network " + type + "/" + subtype + " resolved to " + str);
        return str;
    }

    /* renamed from: a */
    static String m628a(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        Scanner scanner = new Scanner(inputStream, "UTF-8");
        StringBuilder sb = new StringBuilder();
        while (scanner.hasNextLine()) {
            sb.append(scanner.nextLine());
        }
        return sb.toString();
    }

    /* renamed from: a */
    static String m629a(String str) {
        return str.startsWith("https://") ? str : str.replace("http://", "https://");
    }

    /* renamed from: a */
    static String m630a(String str, AppLovinSdkImpl appLovinSdkImpl) {
        if (str == null) {
            throw new IllegalArgumentException("No endpoint specified");
        } else if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else {
            String str2 = (String) appLovinSdkImpl.mo5363a(C0343bw.f547e);
            StringBuilder sb = new StringBuilder();
            sb.append((String) appLovinSdkImpl.mo5363a(C0343bw.f553k));
            sb.append(str);
            if (str2 == null || str2.length() <= 0) {
                sb.append("?api_key=");
                sb.append(appLovinSdkImpl.getSdkKey());
            } else {
                sb.append("?device_token=");
                sb.append(str2);
            }
            return sb.toString();
        }
    }

    /* renamed from: a */
    static JSONObject m631a(JSONObject jSONObject) {
        return (JSONObject) jSONObject.getJSONArray("results").get(0);
    }

    /* renamed from: a */
    static void m632a(int i, AppLovinSdkImpl appLovinSdkImpl) {
        C0346bz settingsManager = appLovinSdkImpl.getSettingsManager();
        if (i == 401) {
            settingsManager.mo5546a(C0343bw.f545c, "");
            settingsManager.mo5546a(C0343bw.f547e, "");
            settingsManager.mo5546a(C0343bw.f555m, 0L);
            settingsManager.mo5549b();
        } else if (i == 418) {
            settingsManager.mo5546a(C0343bw.f467a, true);
            settingsManager.mo5549b();
        } else if (i >= 400 && i < 500) {
            appLovinSdkImpl.mo5371g();
        } else if (i == -1) {
            appLovinSdkImpl.mo5371g();
        }
    }

    /* renamed from: a */
    static void m633a(JSONObject jSONObject, AppLovinSdkImpl appLovinSdkImpl) {
        if (jSONObject == null) {
            throw new IllegalArgumentException("No response specified");
        } else if (appLovinSdkImpl == null) {
            throw new IllegalArgumentException("No sdk specified");
        } else {
            try {
                if (jSONObject.has("settings")) {
                    C0346bz settingsManager = appLovinSdkImpl.getSettingsManager();
                    if (!jSONObject.isNull("settings")) {
                        settingsManager.mo5548a(jSONObject.getJSONObject("settings"));
                        settingsManager.mo5549b();
                        appLovinSdkImpl.getLogger().mo5665d(f681d, "New settings processed");
                    }
                }
            } catch (JSONException e) {
                appLovinSdkImpl.getLogger().mo5667e(f681d, "Unable to parse settings out of API response", e);
            }
        }
    }

    /* renamed from: a */
    private static boolean m634a(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    static String m635b(String str, AppLovinSdkImpl appLovinSdkImpl) {
        if (str == null) {
            throw new IllegalArgumentException("No endpoint specified");
        } else if (appLovinSdkImpl != null) {
            return ((String) appLovinSdkImpl.mo5363a(C0343bw.f554l)) + str;
        } else {
            throw new IllegalArgumentException("No sdk specified");
        }
    }

    /* renamed from: b */
    static void m636b(int i, AppLovinSdkImpl appLovinSdkImpl) {
        if (i == 418) {
            C0346bz settingsManager = appLovinSdkImpl.getSettingsManager();
            settingsManager.mo5546a(C0343bw.f467a, true);
            settingsManager.mo5549b();
        }
    }
}
