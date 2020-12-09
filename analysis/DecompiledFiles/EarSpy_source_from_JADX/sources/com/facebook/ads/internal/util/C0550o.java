package com.facebook.ads.internal.util;

import android.os.AsyncTask;
import android.util.Log;
import com.facebook.ads.internal.thirdparty.http.C0509a;
import com.facebook.ads.internal.thirdparty.http.C0524o;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: com.facebook.ads.internal.util.o */
public class C0550o extends AsyncTask<String, Void, Void> {

    /* renamed from: a */
    private static final String f1284a = C0550o.class.getSimpleName();

    /* renamed from: b */
    private static final Set<String> f1285b = new HashSet();

    /* renamed from: c */
    private Map<String, String> f1286c;

    /* renamed from: d */
    private Map<String, String> f1287d;

    static {
        f1285b.add("#");
        f1285b.add("null");
    }

    public C0550o() {
        this((Map<String, String>) null, (Map<String, String>) null);
    }

    public C0550o(Map<String, String> map) {
        this(map, (Map<String, String>) null);
    }

    public C0550o(Map<String, String> map, Map<String, String> map2) {
        this.f1286c = map;
        this.f1287d = map2;
    }

    /* renamed from: a */
    private String m1238a(String str, String str2, String str3) {
        if (C0553r.m1245a(str) || C0553r.m1245a(str2) || C0553r.m1245a(str3)) {
            return str;
        }
        return str + (str.contains("?") ? "&" : "?") + str2 + "=" + URLEncoder.encode(str3);
    }

    /* renamed from: a */
    private boolean m1239a(String str) {
        C0509a c = C0537g.m1214c();
        try {
            if (this.f1287d == null || this.f1287d.size() == 0) {
                return c.mo6058a(str, (C0524o) null).mo6097a() == 200;
            }
            C0524o oVar = new C0524o();
            oVar.mo6102a((Map<? extends String, ? extends String>) this.f1287d);
            return c.mo6066b(str, oVar).mo6097a() == 200;
        } catch (Exception e) {
            Log.e(f1284a, "Error opening url: " + str, e);
            return false;
        }
    }

    /* renamed from: b */
    private String m1240b(String str) {
        try {
            return m1238a(str, "analog", C0537g.m1201a(C0527a.m1175a()));
        } catch (Exception e) {
            return str;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Void doInBackground(String... strArr) {
        String str;
        String str2 = strArr[0];
        if (!C0553r.m1245a(str2) && !f1285b.contains(str2)) {
            String b = m1240b(str2);
            if (this.f1286c != null && !this.f1286c.isEmpty()) {
                Iterator<Map.Entry<String, String>> it = this.f1286c.entrySet().iterator();
                while (true) {
                    str = b;
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry next = it.next();
                    b = m1238a(str, (String) next.getKey(), (String) next.getValue());
                }
                b = str;
            }
            int i = 1;
            while (true) {
                int i2 = i + 1;
                if (i > 2 || m1239a(b)) {
                    break;
                }
                i = i2;
            }
        }
        return null;
    }
}
