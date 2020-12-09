package com.facebook.ads.internal.util;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.facebook.ads.internal.util.a */
public class C0527a {

    /* renamed from: a */
    private static SensorManager f1223a = null;

    /* renamed from: b */
    private static Sensor f1224b = null;

    /* renamed from: c */
    private static Sensor f1225c = null;

    /* renamed from: d */
    private static volatile float[] f1226d;

    /* renamed from: e */
    private static volatile float[] f1227e;

    /* renamed from: f */
    private static Map<String, Object> f1228f = new ConcurrentHashMap();

    /* renamed from: g */
    private static String[] f1229g = {"x", "y", "z"};

    /* renamed from: a */
    public static Map<String, Object> m1175a() {
        HashMap hashMap = new HashMap();
        hashMap.putAll(f1228f);
        m1176a(hashMap);
        return hashMap;
    }

    /* renamed from: a */
    private static void m1176a(Map<String, Object> map) {
        float[] fArr = f1226d;
        float[] fArr2 = f1227e;
        if (fArr != null) {
            int min = Math.min(f1229g.length, fArr.length);
            for (int i = 0; i < min; i++) {
                map.put("accelerometer_" + f1229g[i], Float.valueOf(fArr[i]));
            }
        }
        if (fArr2 != null) {
            int min2 = Math.min(f1229g.length, fArr2.length);
            for (int i2 = 0; i2 < min2; i2++) {
                map.put("rotation_" + f1229g[i2], Float.valueOf(fArr2[i2]));
            }
        }
    }
}
