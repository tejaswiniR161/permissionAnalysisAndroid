package com.facebook.ads.internal.server;

import android.support.p000v4.p002os.EnvironmentCompat;
import com.facebook.ads.internal.util.C0553r;
import java.util.Locale;

public enum AdPlacementType {
    UNKNOWN(EnvironmentCompat.MEDIA_UNKNOWN),
    BANNER("banner"),
    INTERSTITIAL("interstitial"),
    NATIVE("native");
    

    /* renamed from: a */
    private String f1169a;

    private AdPlacementType(String str) {
        this.f1169a = str;
    }

    public static AdPlacementType fromString(String str) {
        if (C0553r.m1245a(str)) {
            return UNKNOWN;
        }
        try {
            return valueOf(str.toUpperCase(Locale.US));
        } catch (Exception e) {
            return UNKNOWN;
        }
    }

    public String toString() {
        return this.f1169a;
    }
}
