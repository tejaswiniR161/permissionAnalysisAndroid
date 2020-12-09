package com.facebook.ads.internal.thirdparty.http;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.thirdparty.http.g */
public class C0516g implements C0526q {
    /* renamed from: a */
    private void m1137a(Map<String, List<String>> map) {
        if (map != null) {
            for (String next : map.keySet()) {
                for (String str : map.get(next)) {
                    mo6081a(next + ":" + str);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo6080a(C0523n nVar) {
        if (nVar != null) {
            mo6081a("=== HTTP Response ===");
            mo6081a("Receive url: " + nVar.mo6098b());
            mo6081a("Status: " + nVar.mo6097a());
            m1137a(nVar.mo6099c());
            mo6081a("Content:\n" + nVar.mo6101e());
        }
    }

    /* renamed from: a */
    public void mo6081a(String str) {
        System.out.println(str);
    }

    /* renamed from: a */
    public void mo6082a(HttpURLConnection httpURLConnection, Object obj) {
        mo6081a("=== HTTP Request ===");
        mo6081a(httpURLConnection.getRequestMethod() + " " + httpURLConnection.getURL().toString());
        if (obj instanceof String) {
            mo6081a("Content: " + ((String) obj));
        }
        m1137a((Map<String, List<String>>) httpURLConnection.getRequestProperties());
    }

    /* renamed from: a */
    public boolean mo6083a() {
        return false;
    }
}
