package com.facebook.ads.internal.thirdparty.http;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* renamed from: com.facebook.ads.internal.thirdparty.http.o */
public class C0524o implements Map<String, String> {

    /* renamed from: a */
    private Map<String, String> f1222a = new HashMap();

    /* renamed from: a */
    public C0524o mo6102a(Map<? extends String, ? extends String> map) {
        putAll(map);
        return this;
    }

    /* renamed from: a */
    public String mo6103a() {
        StringBuilder sb = new StringBuilder();
        for (String next : this.f1222a.keySet()) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append(next);
            String str = this.f1222a.get(next);
            if (str != null) {
                sb.append("=");
                try {
                    sb.append(URLEncoder.encode(str, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: a */
    public String get(Object obj) {
        return this.f1222a.get(obj);
    }

    /* renamed from: a */
    public String put(String str, String str2) {
        return this.f1222a.put(str, str2);
    }

    /* renamed from: b */
    public String remove(Object obj) {
        return this.f1222a.remove(obj);
    }

    /* renamed from: b */
    public byte[] mo6107b() {
        try {
            return mo6103a().getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void clear() {
        this.f1222a.clear();
    }

    public boolean containsKey(Object obj) {
        return this.f1222a.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.f1222a.containsValue(obj);
    }

    public Set<Map.Entry<String, String>> entrySet() {
        return this.f1222a.entrySet();
    }

    public boolean isEmpty() {
        return this.f1222a.isEmpty();
    }

    public Set<String> keySet() {
        return this.f1222a.keySet();
    }

    public void putAll(Map<? extends String, ? extends String> map) {
        this.f1222a.putAll(map);
    }

    public int size() {
        return this.f1222a.size();
    }

    public Collection<String> values() {
        return this.f1222a.values();
    }
}
