package com.facebook.ads.internal.dto;

import com.facebook.ads.internal.C0473e;

/* renamed from: com.facebook.ads.internal.dto.b */
public enum C0466b {
    UNKNOWN,
    BANNER,
    INTERSTITIAL,
    NATIVE;

    /* renamed from: a */
    public static C0466b m980a(C0473e eVar) {
        switch (eVar) {
            case NATIVE_UNKNOWN:
                return NATIVE;
            case WEBVIEW_BANNER_50:
            case WEBVIEW_BANNER_90:
            case WEBVIEW_BANNER_LEGACY:
            case WEBVIEW_BANNER_250:
                return BANNER;
            case WEBVIEW_INTERSTITIAL_HORIZONTAL:
            case WEBVIEW_INTERSTITIAL_VERTICAL:
            case WEBVIEW_INTERSTITIAL_TABLET:
            case WEBVIEW_INTERSTITIAL_UNKNOWN:
                return INTERSTITIAL;
            default:
                return UNKNOWN;
        }
    }
}
