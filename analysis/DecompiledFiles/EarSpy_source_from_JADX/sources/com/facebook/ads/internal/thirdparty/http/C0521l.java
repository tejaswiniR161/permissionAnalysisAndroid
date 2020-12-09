package com.facebook.ads.internal.thirdparty.http;

/* renamed from: com.facebook.ads.internal.thirdparty.http.l */
public abstract class C0521l {

    /* renamed from: a */
    protected String f1213a = "";

    /* renamed from: b */
    protected C0519j f1214b;

    /* renamed from: c */
    protected String f1215c;

    /* renamed from: d */
    protected byte[] f1216d;

    public C0521l(String str, C0524o oVar) {
        if (str != null) {
            this.f1213a = str;
        }
        if (oVar != null) {
            this.f1213a += "?" + oVar.mo6103a();
        }
    }

    /* renamed from: a */
    public String mo6092a() {
        return this.f1213a;
    }

    /* renamed from: b */
    public C0519j mo6093b() {
        return this.f1214b;
    }

    /* renamed from: c */
    public String mo6094c() {
        return this.f1215c;
    }

    /* renamed from: d */
    public byte[] mo6095d() {
        return this.f1216d;
    }
}
