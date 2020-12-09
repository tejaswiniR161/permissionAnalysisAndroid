package com.facebook.ads.internal.adapters;

import java.util.Locale;

/* renamed from: com.facebook.ads.internal.adapters.f */
public enum C0446f {
    UNKNOWN,
    AN;

    /* renamed from: a */
    public static C0446f m853a(String str) {
        if (str == null) {
            return UNKNOWN;
        }
        try {
            return (C0446f) Enum.valueOf(C0446f.class, str.toUpperCase(Locale.getDefault()));
        } catch (Exception e) {
            return UNKNOWN;
        }
    }
}
