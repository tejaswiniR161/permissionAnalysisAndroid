package com.facebook.ads.internal.util;

import java.util.Locale;

/* renamed from: com.facebook.ads.internal.util.e */
public enum C0534e {
    NONE,
    INSTALLED,
    NOT_INSTALLED;

    /* renamed from: a */
    public static C0534e m1190a(String str) {
        if (C0553r.m1245a(str)) {
            return NONE;
        }
        try {
            return valueOf(str.toUpperCase(Locale.US));
        } catch (IllegalArgumentException e) {
            return NONE;
        }
    }
}
