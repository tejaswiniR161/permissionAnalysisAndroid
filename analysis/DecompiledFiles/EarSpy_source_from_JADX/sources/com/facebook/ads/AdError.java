package com.facebook.ads;

import com.facebook.ads.internal.util.C0553r;

public class AdError {
    public static final AdError INTERNAL_ERROR = new AdError(INTERNAL_ERROR_CODE, "Internal Error");
    public static final int INTERNAL_ERROR_CODE = 2001;
    public static final AdError LOAD_TOO_FREQUENTLY = new AdError(LOAD_TOO_FREQUENTLY_ERROR_CODE, "Ad was re-loaded too frequently");
    public static final int LOAD_TOO_FREQUENTLY_ERROR_CODE = 1002;
    @Deprecated
    public static final AdError MISSING_PROPERTIES = new AdError(2002, "Native ad failed to load due to missing properties");
    public static final AdError NETWORK_ERROR = new AdError(NETWORK_ERROR_CODE, "Network Error");
    public static final int NETWORK_ERROR_CODE = 1000;
    public static final AdError NO_FILL = new AdError(NO_FILL_ERROR_CODE, "No Fill");
    public static final int NO_FILL_ERROR_CODE = 1001;
    public static final AdError SERVER_ERROR = new AdError(SERVER_ERROR_CODE, "Server Error");
    public static final int SERVER_ERROR_CODE = 2000;

    /* renamed from: a */
    private final int f740a;

    /* renamed from: b */
    private final String f741b;

    public AdError(int i, String str) {
        str = C0553r.m1245a(str) ? "unknown error" : str;
        this.f740a = i;
        this.f741b = str;
    }

    public int getErrorCode() {
        return this.f740a;
    }

    public String getErrorMessage() {
        return this.f741b;
    }
}
