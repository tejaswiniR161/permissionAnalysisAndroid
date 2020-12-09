package com.facebook.ads.internal;

import android.text.TextUtils;
import com.facebook.ads.internal.util.AdInternalSettings;
import org.json.JSONArray;

/* renamed from: com.facebook.ads.internal.d */
public enum C0464d {
    APP_AD(0),
    LINK_AD(1),
    APP_AD_V2(2),
    LINK_AD_V2(3),
    APP_ENGAGEMENT_AD(4),
    AD_CHOICES(5),
    JS_TRIGGER(6),
    JS_TRIGGER_NO_AUTO_IMP_LOGGING(7),
    VIDEO_AD(8),
    INLINE_VIDEO_AD(9),
    BANNER_TO_INTERSTITIAL(10),
    NATIVE_CLOSE_BUTTON(11);
    

    /* renamed from: n */
    private static final C0464d[] f1026n = null;

    /* renamed from: o */
    private static final String f1027o = null;

    /* renamed from: p */
    private static final String f1028p = null;

    /* renamed from: m */
    private final int f1030m;

    static {
        int i;
        f1026n = new C0464d[]{LINK_AD_V2, APP_ENGAGEMENT_AD, AD_CHOICES, JS_TRIGGER_NO_AUTO_IMP_LOGGING, NATIVE_CLOSE_BUTTON};
        JSONArray jSONArray = new JSONArray();
        for (C0464d a : f1026n) {
            jSONArray.put(a.mo5978a());
        }
        f1027o = jSONArray.toString();
        f1028p = TextUtils.join(",", f1026n);
    }

    private C0464d(int i) {
        this.f1030m = i;
    }

    /* renamed from: b */
    public static String m975b() {
        return AdInternalSettings.shouldUseLiveRailEndpoint() ? f1028p : f1027o;
    }

    /* renamed from: c */
    public static String m976c() {
        return f1028p;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5978a() {
        return this.f1030m;
    }

    public String toString() {
        return String.valueOf(this.f1030m);
    }
}
