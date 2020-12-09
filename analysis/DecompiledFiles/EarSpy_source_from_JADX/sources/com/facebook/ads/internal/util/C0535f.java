package com.facebook.ads.internal.util;

import android.content.Context;
import android.content.pm.PackageManager;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;

/* renamed from: com.facebook.ads.internal.util.f */
public class C0535f {

    /* renamed from: com.facebook.ads.internal.util.f$a */
    public interface C0536a {
        /* renamed from: a */
        C0534e mo5920a();

        /* renamed from: b */
        String mo5925b();

        /* renamed from: c */
        Collection<String> mo5927c();
    }

    /* renamed from: a */
    public static Collection<String> m1191a(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() == 0) {
            return null;
        }
        HashSet hashSet = new HashSet();
        for (int i = 0; i < jSONArray.length(); i++) {
            hashSet.add(jSONArray.optString(i));
        }
        return hashSet;
    }

    /* renamed from: a */
    public static boolean m1192a(Context context, C0536a aVar) {
        Collection<String> c;
        boolean z;
        C0534e a = aVar.mo5920a();
        if (a == null || a == C0534e.NONE || (c = aVar.mo5927c()) == null || c.isEmpty()) {
            return false;
        }
        Iterator<String> it = c.iterator();
        while (true) {
            if (it.hasNext()) {
                if (m1193a(context, it.next())) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        if (z != (a == C0534e.INSTALLED)) {
            return false;
        }
        String b = aVar.mo5925b();
        if (C0553r.m1245a(b)) {
            return true;
        }
        new C0550o().execute(new String[]{b});
        return false;
    }

    /* renamed from: a */
    public static boolean m1193a(Context context, String str) {
        if (C0553r.m1245a(str)) {
            return false;
        }
        try {
            context.getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
