package com.facebook.ads.internal.util;

import java.util.Set;

/* renamed from: com.facebook.ads.internal.util.s */
public class C0554s {
    /* renamed from: a */
    public static String m1247a(Set<String> set, String str) {
        StringBuilder sb = new StringBuilder();
        for (String append : set) {
            sb.append(append);
            sb.append(str);
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
    }
}
