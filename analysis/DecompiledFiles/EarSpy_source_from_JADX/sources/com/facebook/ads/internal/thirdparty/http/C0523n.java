package com.facebook.ads.internal.thirdparty.http;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;

/* renamed from: com.facebook.ads.internal.thirdparty.http.n */
public class C0523n {

    /* renamed from: a */
    private int f1218a;

    /* renamed from: b */
    private String f1219b;

    /* renamed from: c */
    private Map<String, List<String>> f1220c;

    /* renamed from: d */
    private byte[] f1221d;

    public C0523n(HttpURLConnection httpURLConnection, byte[] bArr) {
        try {
            this.f1218a = httpURLConnection.getResponseCode();
            this.f1219b = httpURLConnection.getURL().toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f1220c = httpURLConnection.getHeaderFields();
        this.f1221d = bArr;
    }

    /* renamed from: a */
    public int mo6097a() {
        return this.f1218a;
    }

    /* renamed from: b */
    public String mo6098b() {
        return this.f1219b;
    }

    /* renamed from: c */
    public Map<String, List<String>> mo6099c() {
        return this.f1220c;
    }

    /* renamed from: d */
    public byte[] mo6100d() {
        return this.f1221d;
    }

    /* renamed from: e */
    public String mo6101e() {
        if (this.f1221d != null) {
            return new String(this.f1221d);
        }
        return null;
    }
}
