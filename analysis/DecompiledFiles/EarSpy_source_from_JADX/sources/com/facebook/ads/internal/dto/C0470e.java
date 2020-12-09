package com.facebook.ads.internal.dto;

import android.content.Context;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.internal.C0463c;
import com.facebook.ads.internal.C0464d;
import com.facebook.ads.internal.C0473e;
import com.facebook.ads.internal.adapters.C0444e;
import com.facebook.ads.internal.server.AdPlacementType;
import com.facebook.ads.internal.util.AdInternalSettings;
import com.facebook.ads.internal.util.C0531c;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.dto.e */
public class C0470e {

    /* renamed from: a */
    protected String f1054a;

    /* renamed from: b */
    protected AdPlacementType f1055b;

    /* renamed from: c */
    protected C0466b f1056c;

    /* renamed from: d */
    public Context f1057d;

    /* renamed from: e */
    public C0473e f1058e;

    /* renamed from: f */
    public boolean f1059f;

    /* renamed from: g */
    private C0463c f1060g;

    /* renamed from: h */
    private int f1061h;

    /* renamed from: i */
    private AdSize f1062i;

    public C0470e(Context context, String str, AdSize adSize, C0473e eVar, C0463c cVar, int i, boolean z) {
        this.f1054a = str;
        this.f1062i = adSize;
        this.f1058e = eVar;
        this.f1056c = C0466b.m980a(eVar);
        this.f1060g = cVar;
        this.f1061h = i;
        this.f1059f = z;
        m993a(context);
    }

    /* renamed from: a */
    private void m993a(Context context) {
        this.f1057d = context;
        C0472f.m1002a(context);
        m996f();
    }

    /* renamed from: a */
    private void m994a(Map<String, String> map, String str, String str2) {
        if (AdInternalSettings.shouldUseLiveRailEndpoint()) {
            map.put("LR_" + str, str2);
        } else {
            map.put(str, str2);
        }
    }

    /* renamed from: b */
    private static Map<String, String> m995b(Context context) {
        HashMap hashMap = new HashMap();
        hashMap.put("VIEWABLE", "1");
        hashMap.put("SCHEMA", "json");
        hashMap.put("SDK", "android");
        hashMap.put("SDK_VERSION", "4.8.2");
        hashMap.put("LOCALE", Locale.getDefault().toString());
        float f = context.getResources().getDisplayMetrics().density;
        int i = context.getResources().getDisplayMetrics().widthPixels;
        int i2 = context.getResources().getDisplayMetrics().heightPixels;
        hashMap.put("DENSITY", String.valueOf(f));
        hashMap.put("SCREEN_WIDTH", String.valueOf((int) (((float) i) / f)));
        hashMap.put("SCREEN_HEIGHT", String.valueOf((int) (((float) i2) / f)));
        hashMap.put("IDFA", C0472f.f1078o);
        hashMap.put("IDFA_FLAG", C0472f.f1079p ? "0" : "1");
        hashMap.put("ATTRIBUTION_ID", C0472f.f1077n);
        hashMap.put("ID_SOURCE", C0472f.f1080q);
        hashMap.put("OS", "Android");
        hashMap.put("OSVERS", C0472f.f1064a);
        hashMap.put("BUNDLE", C0472f.f1067d);
        hashMap.put("APPNAME", C0472f.f1068e);
        hashMap.put("APPVERS", C0472f.f1069f);
        hashMap.put("APPBUILD", String.valueOf(C0472f.f1070g));
        hashMap.put("CARRIER", C0472f.f1072i);
        hashMap.put("MAKE", C0472f.f1065b);
        hashMap.put("MODEL", C0472f.f1066c);
        hashMap.put("COPPA", String.valueOf(AdSettings.isChildDirected()));
        hashMap.put("INSTALLER", C0472f.f1071h);
        hashMap.put("SDK_CAPABILITY", C0464d.m975b());
        return hashMap;
    }

    /* renamed from: f */
    private void m996f() {
        if (this.f1056c == null) {
            this.f1056c = C0466b.UNKNOWN;
        }
        switch (this.f1056c) {
            case INTERSTITIAL:
                this.f1055b = AdPlacementType.INTERSTITIAL;
                return;
            case BANNER:
                this.f1055b = AdPlacementType.BANNER;
                return;
            case NATIVE:
                this.f1055b = AdPlacementType.NATIVE;
                return;
            default:
                this.f1055b = AdPlacementType.UNKNOWN;
                return;
        }
    }

    /* renamed from: a */
    public String mo5993a() {
        return this.f1054a;
    }

    /* renamed from: b */
    public C0466b mo5994b() {
        return this.f1056c;
    }

    /* renamed from: c */
    public AdSize mo5995c() {
        return this.f1062i;
    }

    /* renamed from: d */
    public int mo5996d() {
        return this.f1061h;
    }

    /* renamed from: e */
    public Map<String, String> mo5997e() {
        HashMap hashMap = new HashMap();
        m994a(hashMap, "PLACEMENT_ID", this.f1054a);
        if (this.f1055b != AdPlacementType.UNKNOWN) {
            m994a(hashMap, "PLACEMENT_TYPE", this.f1055b.toString().toLowerCase());
        }
        for (Map.Entry next : m995b(this.f1057d).entrySet()) {
            m994a(hashMap, (String) next.getKey(), (String) next.getValue());
        }
        if (this.f1062i != null) {
            m994a(hashMap, "WIDTH", String.valueOf(this.f1062i.getWidth()));
            m994a(hashMap, "HEIGHT", String.valueOf(this.f1062i.getHeight()));
        }
        m994a(hashMap, "ADAPTERS", C0444e.m851a(this.f1055b));
        if (this.f1058e != null) {
            m994a(hashMap, "TEMPLATE_ID", String.valueOf(this.f1058e.mo5998a()));
        }
        if (this.f1060g != null) {
            m994a(hashMap, "REQUEST_TYPE", String.valueOf(this.f1060g.mo5977a()));
        }
        if (this.f1059f) {
            m994a(hashMap, "TEST_MODE", "1");
        }
        if (this.f1061h != 0) {
            m994a(hashMap, "NUM_ADS_REQUESTED", String.valueOf(this.f1061h));
        }
        m994a(hashMap, "CLIENT_EVENTS", C0531c.m1181a());
        return hashMap;
    }
}
