package com.facebook.ads.internal.adapters;

import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.util.C0554s;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.facebook.ads.internal.adapters.e */
public class C0444e {

    /* renamed from: a */
    private static final Set<C0447g> f904a = new HashSet();

    /* renamed from: b */
    private static final Map<AdPlacementType, String> f905b = new ConcurrentHashMap();

    static {
        Class<BannerAdapter> cls;
        for (C0447g gVar : C0447g.values()) {
            switch (gVar.f917g) {
                case BANNER:
                    cls = BannerAdapter.class;
                    break;
                case INTERSTITIAL:
                    cls = InterstitialAdapter.class;
                    break;
                case NATIVE:
                    cls = C0460n.class;
                    break;
                default:
                    cls = null;
                    break;
            }
            if (cls != null) {
                Class<?> cls2 = gVar.f914d;
                if (cls2 == null) {
                    try {
                        cls2 = Class.forName(gVar.f915e);
                    } catch (ClassNotFoundException e) {
                    }
                }
                if (cls2 != null && cls.isAssignableFrom(cls2)) {
                    f904a.add(gVar);
                }
            }
        }
    }

    /* renamed from: a */
    public static AdAdapter m849a(C0446f fVar, AdPlacementType adPlacementType) {
        try {
            C0447g b = m852b(fVar, adPlacementType);
            if (b != null && f904a.contains(b)) {
                Class<?> cls = b.f914d;
                if (cls == null) {
                    cls = Class.forName(b.f915e);
                }
                return (AdAdapter) cls.newInstance();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* renamed from: a */
    public static AdAdapter m850a(String str, AdPlacementType adPlacementType) {
        return m849a(C0446f.m853a(str), adPlacementType);
    }

    /* renamed from: a */
    public static String m851a(AdPlacementType adPlacementType) {
        if (f905b.containsKey(adPlacementType)) {
            return f905b.get(adPlacementType);
        }
        HashSet hashSet = new HashSet();
        for (C0447g next : f904a) {
            if (next.f917g == adPlacementType) {
                hashSet.add(next.f916f.toString());
            }
        }
        String a = C0554s.m1247a(hashSet, ",");
        f905b.put(adPlacementType, a);
        return a;
    }

    /* renamed from: b */
    private static C0447g m852b(C0446f fVar, AdPlacementType adPlacementType) {
        for (C0447g next : f904a) {
            if (next.f916f == fVar && next.f917g == adPlacementType) {
                return next;
            }
        }
        return null;
    }
}
