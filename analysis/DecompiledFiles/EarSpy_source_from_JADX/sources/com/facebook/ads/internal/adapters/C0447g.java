package com.facebook.ads.internal.adapters;

import com.facebook.ads.internal.server.AdPlacementType;

/* renamed from: com.facebook.ads.internal.adapters.g */
public enum C0447g {
    ANBANNER(C0448h.class, C0446f.AN, AdPlacementType.BANNER),
    ANINTERSTITIAL(C0451i.class, C0446f.AN, AdPlacementType.INTERSTITIAL),
    ANNATIVE(C0453j.class, C0446f.AN, AdPlacementType.NATIVE);
    

    /* renamed from: d */
    public Class<?> f914d;

    /* renamed from: e */
    public String f915e;

    /* renamed from: f */
    public C0446f f916f;

    /* renamed from: g */
    public AdPlacementType f917g;

    private C0447g(Class<?> cls, C0446f fVar, AdPlacementType adPlacementType) {
        this.f914d = cls;
        this.f916f = fVar;
        this.f917g = adPlacementType;
    }
}
