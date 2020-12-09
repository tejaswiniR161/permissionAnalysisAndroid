package com.facebook.ads.internal.util;

import java.security.MessageDigest;

/* renamed from: com.facebook.ads.internal.util.r */
public class C0553r {
    /* renamed from: a */
    public static boolean m1245a(String str) {
        return str == null || str.length() <= 0;
    }

    /* renamed from: b */
    public static String m1246b(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("utf-8"));
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(Integer.toString((b & 255) + 256, 16).substring(1));
            }
            return sb.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
