package com.facebook.ads.internal;

import com.facebook.ads.AdError;
import com.facebook.ads.internal.util.C0553r;

/* renamed from: com.facebook.ads.internal.b */
public class C0462b {

    /* renamed from: a */
    private final AdErrorType f1008a;

    /* renamed from: b */
    private final String f1009b;

    public C0462b(AdErrorType adErrorType, String str) {
        str = C0553r.m1245a(str) ? adErrorType.getDefaultErrorMessage() : str;
        this.f1008a = adErrorType;
        this.f1009b = str;
    }

    /* renamed from: a */
    public AdErrorType mo5975a() {
        return this.f1008a;
    }

    /* renamed from: b */
    public AdError mo5976b() {
        return this.f1008a.mo5876a() ? new AdError(this.f1008a.getErrorCode(), this.f1009b) : new AdError(AdErrorType.UNKNOWN_ERROR.getErrorCode(), AdErrorType.UNKNOWN_ERROR.getDefaultErrorMessage());
    }
}
