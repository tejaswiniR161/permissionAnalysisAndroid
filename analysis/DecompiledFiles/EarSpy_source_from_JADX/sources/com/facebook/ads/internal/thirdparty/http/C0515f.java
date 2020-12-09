package com.facebook.ads.internal.thirdparty.http;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* renamed from: com.facebook.ads.internal.thirdparty.http.f */
public abstract class C0515f implements C0525p {

    /* renamed from: a */
    private final C0526q f1204a;

    public C0515f() {
        this(new C0516g());
    }

    public C0515f(C0526q qVar) {
        this.f1204a = qVar;
    }

    /* renamed from: a */
    public OutputStream mo6073a(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getOutputStream();
    }

    /* renamed from: a */
    public HttpURLConnection mo6074a(String str) {
        return (HttpURLConnection) new URL(str).openConnection();
    }

    /* renamed from: a */
    public void mo6075a(OutputStream outputStream, byte[] bArr) {
        outputStream.write(bArr);
    }

    /* renamed from: a */
    public void mo6076a(HttpURLConnection httpURLConnection, C0519j jVar, String str) {
        httpURLConnection.setRequestMethod(jVar.mo6091c());
        httpURLConnection.setDoOutput(jVar.mo6090b());
        httpURLConnection.setDoInput(jVar.mo6089a());
        if (str != null) {
            httpURLConnection.setRequestProperty("Content-Type", str);
        }
        httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
    }

    /* renamed from: a */
    public boolean mo6077a(C0522m mVar) {
        C0523n a = mVar.mo6096a();
        if (this.f1204a.mo6083a()) {
            this.f1204a.mo6081a("BasicRequestHandler.onError got");
            mVar.printStackTrace();
        }
        return a != null && a.mo6097a() > 0;
    }

    /* renamed from: a */
    public byte[] mo6078a(InputStream inputStream) {
        byte[] bArr = new byte[16384];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.flush();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* renamed from: b */
    public InputStream mo6079b(HttpURLConnection httpURLConnection) {
        return httpURLConnection.getInputStream();
    }
}
