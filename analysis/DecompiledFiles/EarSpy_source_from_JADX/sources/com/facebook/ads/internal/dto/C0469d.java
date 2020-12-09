package com.facebook.ads.internal.dto;

import com.facebook.ads.AdError;
import com.facebook.ads.internal.server.AdPlacementType;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.facebook.ads.internal.dto.d */
public class C0469d {

    /* renamed from: k */
    private static final AdPlacementType f1043k = AdPlacementType.UNKNOWN;

    /* renamed from: a */
    protected AdPlacementType f1044a = f1043k;

    /* renamed from: b */
    protected int f1045b = 1;

    /* renamed from: c */
    protected int f1046c;

    /* renamed from: d */
    protected int f1047d = 0;

    /* renamed from: e */
    protected int f1048e = 20;

    /* renamed from: f */
    protected int f1049f = 0;

    /* renamed from: g */
    protected int f1050g = AdError.NETWORK_ERROR_CODE;

    /* renamed from: h */
    protected boolean f1051h = false;

    /* renamed from: i */
    public int f1052i = -1;

    /* renamed from: j */
    public int f1053j = -1;

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private C0469d(java.util.Map<java.lang.String, java.lang.String> r8) {
        /*
            r7 = this;
            r4 = 1
            r3 = -1
            r2 = 0
            r7.<init>()
            com.facebook.ads.internal.server.AdPlacementType r0 = f1043k
            r7.f1044a = r0
            r7.f1045b = r4
            r7.f1047d = r2
            r0 = 20
            r7.f1048e = r0
            r7.f1049f = r2
            r0 = 1000(0x3e8, float:1.401E-42)
            r7.f1050g = r0
            r7.f1051h = r2
            r7.f1052i = r3
            r7.f1053j = r3
            java.util.Set r0 = r8.entrySet()
            java.util.Iterator r5 = r0.iterator()
        L_0x0026:
            boolean r0 = r5.hasNext()
            if (r0 == 0) goto L_0x0139
            java.lang.Object r0 = r5.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            int r6 = r1.hashCode()
            switch(r6) {
                case -1561601017: goto L_0x0079;
                case -856794442: goto L_0x00ac;
                case -553208868: goto L_0x0083;
                case 3575610: goto L_0x0051;
                case 664421755: goto L_0x0065;
                case 700812481: goto L_0x005b;
                case 1085444827: goto L_0x006f;
                case 1183549815: goto L_0x00a1;
                case 1503616961: goto L_0x0097;
                case 2002133996: goto L_0x008d;
                default: goto L_0x003f;
            }
        L_0x003f:
            r1 = r3
        L_0x0040:
            switch(r1) {
                case 0: goto L_0x0044;
                case 1: goto L_0x00b7;
                case 2: goto L_0x00c5;
                case 3: goto L_0x00d3;
                case 4: goto L_0x00e1;
                case 5: goto L_0x00ef;
                case 6: goto L_0x0101;
                case 7: goto L_0x010f;
                case 8: goto L_0x011d;
                case 9: goto L_0x012b;
                default: goto L_0x0043;
            }
        L_0x0043:
            goto L_0x0026
        L_0x0044:
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            com.facebook.ads.internal.server.AdPlacementType r0 = com.facebook.ads.internal.server.AdPlacementType.fromString(r0)
            r7.f1044a = r0
            goto L_0x0026
        L_0x0051:
            java.lang.String r6 = "type"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x003f
            r1 = r2
            goto L_0x0040
        L_0x005b:
            java.lang.String r6 = "min_viewability_percentage"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x003f
            r1 = r4
            goto L_0x0040
        L_0x0065:
            java.lang.String r6 = "min_viewability_duration"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x003f
            r1 = 2
            goto L_0x0040
        L_0x006f:
            java.lang.String r6 = "refresh"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x003f
            r1 = 3
            goto L_0x0040
        L_0x0079:
            java.lang.String r6 = "refresh_threshold"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x003f
            r1 = 4
            goto L_0x0040
        L_0x0083:
            java.lang.String r6 = "cacheable"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x003f
            r1 = 5
            goto L_0x0040
        L_0x008d:
            java.lang.String r6 = "placement_width"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x003f
            r1 = 6
            goto L_0x0040
        L_0x0097:
            java.lang.String r6 = "placement_height"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x003f
            r1 = 7
            goto L_0x0040
        L_0x00a1:
            java.lang.String r6 = "viewability_check_initial_delay"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x003f
            r1 = 8
            goto L_0x0040
        L_0x00ac:
            java.lang.String r6 = "viewability_check_interval"
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L_0x003f
            r1 = 9
            goto L_0x0040
        L_0x00b7:
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            int r0 = java.lang.Integer.parseInt(r0)
            r7.f1045b = r0
            goto L_0x0026
        L_0x00c5:
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            int r0 = java.lang.Integer.parseInt(r0)
            r7.f1046c = r0
            goto L_0x0026
        L_0x00d3:
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            int r0 = java.lang.Integer.parseInt(r0)
            r7.f1047d = r0
            goto L_0x0026
        L_0x00e1:
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            int r0 = java.lang.Integer.parseInt(r0)
            r7.f1048e = r0
            goto L_0x0026
        L_0x00ef:
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r0 = r0.booleanValue()
            r7.f1051h = r0
            goto L_0x0026
        L_0x0101:
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            int r0 = java.lang.Integer.parseInt(r0)
            r7.f1052i = r0
            goto L_0x0026
        L_0x010f:
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            int r0 = java.lang.Integer.parseInt(r0)
            r7.f1053j = r0
            goto L_0x0026
        L_0x011d:
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            int r0 = java.lang.Integer.parseInt(r0)
            r7.f1049f = r0
            goto L_0x0026
        L_0x012b:
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            int r0 = java.lang.Integer.parseInt(r0)
            r7.f1050g = r0
            goto L_0x0026
        L_0x0139:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.dto.C0469d.<init>(java.util.Map):void");
    }

    /* renamed from: a */
    public static C0469d m985a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> keys = jSONObject.keys();
        HashMap hashMap = new HashMap();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, String.valueOf(jSONObject.opt(next)));
        }
        return new C0469d(hashMap);
    }

    /* renamed from: a */
    public AdPlacementType mo5986a() {
        return this.f1044a;
    }

    /* renamed from: b */
    public long mo5987b() {
        return (long) (this.f1047d * AdError.NETWORK_ERROR_CODE);
    }

    /* renamed from: c */
    public long mo5988c() {
        return (long) (this.f1048e * AdError.NETWORK_ERROR_CODE);
    }

    /* renamed from: d */
    public boolean mo5989d() {
        return this.f1051h;
    }

    /* renamed from: e */
    public int mo5990e() {
        return this.f1045b;
    }

    /* renamed from: f */
    public int mo5991f() {
        return this.f1049f;
    }

    /* renamed from: g */
    public int mo5992g() {
        return this.f1050g;
    }
}
