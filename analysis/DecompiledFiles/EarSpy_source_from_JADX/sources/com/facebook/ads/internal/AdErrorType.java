package com.facebook.ads.internal;

import com.facebook.ads.AdError;

public enum AdErrorType {
    UNKNOWN_ERROR(-1, "unknown error", false),
    NETWORK_ERROR(AdError.NETWORK_ERROR_CODE, "Network Error", true),
    NO_FILL(AdError.NO_FILL_ERROR_CODE, "No Fill", true),
    LOAD_TOO_FREQUENTLY(AdError.LOAD_TOO_FREQUENTLY_ERROR_CODE, "Ad was re-loaded too frequently", true),
    DISABLED_APP(1005, "App is disabled from making ad requests", true),
    SERVER_ERROR(AdError.SERVER_ERROR_CODE, "Server Error", true),
    INTERNAL_ERROR(AdError.INTERNAL_ERROR_CODE, "Internal Error", true),
    START_BEFORE_INIT(2004, "initAd must be called before startAd", true),
    AD_REQUEST_FAILED(1111, "Facebook Ads SDK request for ads failed", false),
    AD_REQUEST_TIMEOUT(1112, "Facebook Ads SDK request for ads timed out", false),
    PARSER_FAILURE(1201, "Failed to parse Facebook Ads SDK delivery response", false),
    UNKNOWN_RESPONSE(1202, "Unknown Facebook Ads SDK delivery response type", false),
    ERROR_MESSAGE(1203, "Facebook Ads SDK delivery response Error message", true),
    NO_AD_PLACEMENT(1302, "Facebook Ads SDK returned no ad placements", false);
    

    /* renamed from: a */
    private final int f878a;

    /* renamed from: b */
    private final String f879b;

    /* renamed from: c */
    private final boolean f880c;

    private AdErrorType(int i, String str, boolean z) {
        this.f878a = i;
        this.f879b = str;
        this.f880c = z;
    }

    public static AdErrorType adErrorTypeFromCode(int i) {
        return adErrorTypeFromCode(i, UNKNOWN_ERROR);
    }

    public static AdErrorType adErrorTypeFromCode(int i, AdErrorType adErrorType) {
        for (AdErrorType adErrorType2 : values()) {
            if (adErrorType2.getErrorCode() == i) {
                return adErrorType2;
            }
        }
        return adErrorType;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5876a() {
        return this.f880c;
    }

    public AdError getAdError(String str) {
        return new C0462b(this, str).mo5976b();
    }

    public C0462b getAdErrorWrapper(String str) {
        return new C0462b(this, str);
    }

    public String getDefaultErrorMessage() {
        return this.f879b;
    }

    public int getErrorCode() {
        return this.f878a;
    }
}
