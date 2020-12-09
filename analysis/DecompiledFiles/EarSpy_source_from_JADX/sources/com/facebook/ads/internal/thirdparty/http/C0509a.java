package com.facebook.ads.internal.thirdparty.http;

import android.content.Context;
import android.os.Build;
import com.facebook.ads.AdError;
import com.facebook.ads.internal.C0473e;
import com.facebook.ads.internal.dto.C0472f;
import com.facebook.ads.internal.util.C0537g;
import com.facebook.ads.internal.util.C0541h;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* renamed from: com.facebook.ads.internal.thirdparty.http.a */
public class C0509a {

    /* renamed from: g */
    private static int[] f1193g = new int[20];

    /* renamed from: h */
    private static final String f1194h = C0509a.class.getSimpleName();

    /* renamed from: a */
    protected final C0525p f1195a;

    /* renamed from: b */
    protected final C0513d f1196b;

    /* renamed from: c */
    protected String f1197c;

    /* renamed from: d */
    protected C0526q f1198d;

    /* renamed from: e */
    protected int f1199e;

    /* renamed from: f */
    protected int f1200f;

    /* renamed from: i */
    private int f1201i;

    /* renamed from: j */
    private Map<String, String> f1202j;

    /* renamed from: k */
    private boolean f1203k;

    static {
        m1105c();
        if (Build.VERSION.SDK_INT > 8) {
            m1104a();
        }
    }

    public C0509a() {
        this("");
    }

    public C0509a(Context context) {
        this(context, (C0473e) null);
    }

    public C0509a(Context context, C0473e eVar) {
        this();
        mo6055a("user-agent", C0541h.m1217a(context, eVar) + " [" + "FBAN/AudienceNetworkForAndroid;" + "FBSN/" + "Android" + ";" + "FBSV/" + C0472f.f1064a + ";" + "FBAB/" + C0472f.f1067d + ";" + "FBAV/" + C0472f.f1069f + ";" + "FBBV/" + C0472f.f1070g + ";" + "FBLC/" + Locale.getDefault().toString() + "]");
        if (C0537g.m1209a()) {
            C0537g.m1213b();
        }
    }

    public C0509a(C0513d dVar, String str) {
        this(dVar, str, new C0515f() {
        });
    }

    public C0509a(C0513d dVar, String str, C0525p pVar) {
        this.f1197c = "";
        this.f1198d = new C0516g();
        this.f1199e = AdError.SERVER_ERROR_CODE;
        this.f1200f = 8000;
        this.f1201i = 3;
        this.f1202j = new TreeMap();
        this.f1197c = str;
        this.f1195a = pVar;
        this.f1196b = dVar;
    }

    public C0509a(String str) {
        this((C0513d) new C0514e(), str);
    }

    /* renamed from: a */
    public static void m1104a() {
        if (CookieHandler.getDefault() == null) {
            CookieHandler.setDefault(new CookieManager());
        }
    }

    /* renamed from: c */
    private static void m1105c() {
        if (Build.VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
        }
    }

    /* renamed from: c */
    private void m1106c(HttpURLConnection httpURLConnection) {
        for (String next : this.f1202j.keySet()) {
            httpURLConnection.setRequestProperty(next, this.f1202j.get(next));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo6053a(int i) {
        return f1193g[i + 2] * AdError.NETWORK_ERROR_CODE;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo6054a(HttpURLConnection httpURLConnection, byte[] bArr) {
        OutputStream outputStream = null;
        try {
            outputStream = this.f1195a.mo6073a(httpURLConnection);
            if (outputStream != null) {
                this.f1195a.mo6075a(outputStream, bArr);
            }
            return httpURLConnection.getResponseCode();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (Exception e) {
                }
            }
        }
    }

    /* renamed from: a */
    public C0509a mo6055a(String str, String str2) {
        this.f1202j.put(str, str2);
        return this;
    }

    /* renamed from: a */
    public C0523n mo6056a(C0521l lVar) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        while (i < this.f1201i) {
            try {
                mo6070c(mo6053a(i));
                if (this.f1198d.mo6083a()) {
                    this.f1198d.mo6081a((i + 1) + "of" + this.f1201i + ", trying " + lVar.mo6092a());
                }
                currentTimeMillis = System.currentTimeMillis();
                C0523n a = mo6057a(lVar.mo6092a(), lVar.mo6093b(), lVar.mo6094c(), lVar.mo6095d());
                if (a != null) {
                    return a;
                }
                i++;
            } catch (C0522m e) {
                if (mo6064a((Throwable) e, currentTimeMillis) && i < this.f1201i - 1) {
                    continue;
                } else if (!this.f1195a.mo6077a(e) || i >= this.f1201i - 1) {
                    throw e;
                } else {
                    try {
                        Thread.sleep((long) this.f1199e);
                    } catch (InterruptedException e2) {
                        throw e;
                    }
                }
            }
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008d  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:58:0x00b1=Splitter:B:58:0x00b1, B:73:0x00d8=Splitter:B:73:0x00d8} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.ads.internal.thirdparty.http.C0523n mo6057a(java.lang.String r7, com.facebook.ads.internal.thirdparty.http.C0519j r8, java.lang.String r9, byte[] r10) {
        /*
            r6 = this;
            r1 = 0
            r4 = 0
            r0 = 0
            r6.f1203k = r0     // Catch:{ Exception -> 0x00e3, all -> 0x00de }
            java.net.HttpURLConnection r2 = r6.mo6060a((java.lang.String) r7)     // Catch:{ Exception -> 0x00e3, all -> 0x00de }
            r6.mo6063a((java.net.HttpURLConnection) r2, (com.facebook.ads.internal.thirdparty.http.C0519j) r8, (java.lang.String) r9)     // Catch:{ Exception -> 0x0051, all -> 0x00e1 }
            r6.m1106c((java.net.HttpURLConnection) r2)     // Catch:{ Exception -> 0x0051, all -> 0x00e1 }
            com.facebook.ads.internal.thirdparty.http.q r0 = r6.f1198d     // Catch:{ Exception -> 0x0051, all -> 0x00e1 }
            boolean r0 = r0.mo6083a()     // Catch:{ Exception -> 0x0051, all -> 0x00e1 }
            if (r0 == 0) goto L_0x001c
            com.facebook.ads.internal.thirdparty.http.q r0 = r6.f1198d     // Catch:{ Exception -> 0x0051, all -> 0x00e1 }
            r0.mo6082a(r2, r10)     // Catch:{ Exception -> 0x0051, all -> 0x00e1 }
        L_0x001c:
            r2.connect()     // Catch:{ Exception -> 0x0051, all -> 0x00e1 }
            r0 = 1
            r6.f1203k = r0     // Catch:{ Exception -> 0x0051, all -> 0x00e1 }
            boolean r0 = r2.getDoOutput()     // Catch:{ Exception -> 0x0051, all -> 0x00e1 }
            if (r0 == 0) goto L_0x002d
            if (r10 == 0) goto L_0x002d
            r6.mo6054a((java.net.HttpURLConnection) r2, (byte[]) r10)     // Catch:{ Exception -> 0x0051, all -> 0x00e1 }
        L_0x002d:
            boolean r0 = r2.getDoInput()     // Catch:{ Exception -> 0x0051, all -> 0x00e1 }
            if (r0 == 0) goto L_0x004a
            com.facebook.ads.internal.thirdparty.http.n r0 = r6.mo6059a((java.net.HttpURLConnection) r2)     // Catch:{ Exception -> 0x0051, all -> 0x00e1 }
        L_0x0037:
            com.facebook.ads.internal.thirdparty.http.q r1 = r6.f1198d
            boolean r1 = r1.mo6083a()
            if (r1 == 0) goto L_0x0044
            com.facebook.ads.internal.thirdparty.http.q r1 = r6.f1198d
            r1.mo6080a((com.facebook.ads.internal.thirdparty.http.C0523n) r0)
        L_0x0044:
            if (r2 == 0) goto L_0x0049
            r2.disconnect()
        L_0x0049:
            return r0
        L_0x004a:
            com.facebook.ads.internal.thirdparty.http.n r0 = new com.facebook.ads.internal.thirdparty.http.n     // Catch:{ Exception -> 0x0051, all -> 0x00e1 }
            r3 = 0
            r0.<init>(r2, r3)     // Catch:{ Exception -> 0x0051, all -> 0x00e1 }
            goto L_0x0037
        L_0x0051:
            r0 = move-exception
            r3 = r2
            r2 = r0
        L_0x0054:
            com.facebook.ads.internal.thirdparty.http.n r0 = r6.mo6067b((java.net.HttpURLConnection) r3)     // Catch:{ Exception -> 0x0091 }
            if (r0 == 0) goto L_0x0073
            int r1 = r0.mo6097a()     // Catch:{ all -> 0x0079 }
            if (r1 <= 0) goto L_0x0073
            com.facebook.ads.internal.thirdparty.http.q r1 = r6.f1198d
            boolean r1 = r1.mo6083a()
            if (r1 == 0) goto L_0x006d
            com.facebook.ads.internal.thirdparty.http.q r1 = r6.f1198d
            r1.mo6080a((com.facebook.ads.internal.thirdparty.http.C0523n) r0)
        L_0x006d:
            if (r3 == 0) goto L_0x0049
            r3.disconnect()
            goto L_0x0049
        L_0x0073:
            com.facebook.ads.internal.thirdparty.http.m r1 = new com.facebook.ads.internal.thirdparty.http.m     // Catch:{ all -> 0x0079 }
            r1.<init>(r2, r0)     // Catch:{ all -> 0x0079 }
            throw r1     // Catch:{ all -> 0x0079 }
        L_0x0079:
            r1 = move-exception
            r2 = r3
            r5 = r0
            r0 = r1
            r1 = r5
        L_0x007e:
            com.facebook.ads.internal.thirdparty.http.q r3 = r6.f1198d
            boolean r3 = r3.mo6083a()
            if (r3 == 0) goto L_0x008b
            com.facebook.ads.internal.thirdparty.http.q r3 = r6.f1198d
            r3.mo6080a((com.facebook.ads.internal.thirdparty.http.C0523n) r1)
        L_0x008b:
            if (r2 == 0) goto L_0x0090
            r2.disconnect()
        L_0x0090:
            throw r0
        L_0x0091:
            r0 = move-exception
            r2.printStackTrace()     // Catch:{ all -> 0x00ba }
            if (r1 == 0) goto L_0x00b1
            int r0 = r4.mo6097a()     // Catch:{ all -> 0x00b7 }
            if (r0 <= 0) goto L_0x00b1
            com.facebook.ads.internal.thirdparty.http.q r0 = r6.f1198d
            boolean r0 = r0.mo6083a()
            if (r0 == 0) goto L_0x00aa
            com.facebook.ads.internal.thirdparty.http.q r0 = r6.f1198d
            r0.mo6080a((com.facebook.ads.internal.thirdparty.http.C0523n) r1)
        L_0x00aa:
            if (r3 == 0) goto L_0x00af
            r3.disconnect()
        L_0x00af:
            r0 = r1
            goto L_0x0049
        L_0x00b1:
            com.facebook.ads.internal.thirdparty.http.m r0 = new com.facebook.ads.internal.thirdparty.http.m     // Catch:{ all -> 0x00b7 }
            r0.<init>(r2, r4)     // Catch:{ all -> 0x00b7 }
            throw r0     // Catch:{ all -> 0x00b7 }
        L_0x00b7:
            r0 = move-exception
            r2 = r3
            goto L_0x007e
        L_0x00ba:
            r0 = move-exception
            if (r1 == 0) goto L_0x00d8
            int r0 = r4.mo6097a()     // Catch:{ all -> 0x00b7 }
            if (r0 <= 0) goto L_0x00d8
            com.facebook.ads.internal.thirdparty.http.q r0 = r6.f1198d
            boolean r0 = r0.mo6083a()
            if (r0 == 0) goto L_0x00d0
            com.facebook.ads.internal.thirdparty.http.q r0 = r6.f1198d
            r0.mo6080a((com.facebook.ads.internal.thirdparty.http.C0523n) r1)
        L_0x00d0:
            if (r3 == 0) goto L_0x00d5
            r3.disconnect()
        L_0x00d5:
            r0 = r1
            goto L_0x0049
        L_0x00d8:
            com.facebook.ads.internal.thirdparty.http.m r0 = new com.facebook.ads.internal.thirdparty.http.m     // Catch:{ all -> 0x00b7 }
            r0.<init>(r2, r4)     // Catch:{ all -> 0x00b7 }
            throw r0     // Catch:{ all -> 0x00b7 }
        L_0x00de:
            r0 = move-exception
            r2 = r1
            goto L_0x007e
        L_0x00e1:
            r0 = move-exception
            goto L_0x007e
        L_0x00e3:
            r0 = move-exception
            r2 = r0
            r3 = r1
            goto L_0x0054
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.internal.thirdparty.http.C0509a.mo6057a(java.lang.String, com.facebook.ads.internal.thirdparty.http.j, java.lang.String, byte[]):com.facebook.ads.internal.thirdparty.http.n");
    }

    /* renamed from: a */
    public C0523n mo6058a(String str, C0524o oVar) {
        return mo6065b((C0521l) new C0518i(str, oVar));
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0523n mo6059a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        byte[] bArr = null;
        try {
            inputStream = this.f1195a.mo6079b(httpURLConnection);
            if (inputStream != null) {
                try {
                    bArr = this.f1195a.mo6078a(inputStream);
                } catch (Throwable th) {
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e) {
                        }
                    }
                    throw th;
                }
            }
            C0523n nVar = new C0523n(httpURLConnection, bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e2) {
                }
            }
            return nVar;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public HttpURLConnection mo6060a(String str) {
        String str2 = this.f1197c + str;
        try {
            new URL(str2);
            return this.f1195a.mo6074a(str2);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(str2 + " is not a valid URL", e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6061a(C0521l lVar, C0511b bVar) {
        this.f1196b.mo6072a(this, bVar).mo6071a(lVar);
    }

    /* renamed from: a */
    public void mo6062a(String str, C0524o oVar, C0511b bVar) {
        mo6061a((C0521l) new C0520k(str, oVar), bVar);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo6063a(HttpURLConnection httpURLConnection, C0519j jVar, String str) {
        httpURLConnection.setConnectTimeout(this.f1199e);
        httpURLConnection.setReadTimeout(this.f1200f);
        this.f1195a.mo6076a(httpURLConnection, jVar, str);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo6064a(Throwable th, long j) {
        long currentTimeMillis = (System.currentTimeMillis() - j) + 10;
        if (this.f1198d.mo6083a()) {
            this.f1198d.mo6081a("ELAPSED TIME = " + currentTimeMillis + ", CT = " + this.f1199e + ", RT = " + this.f1200f);
        }
        return this.f1203k ? currentTimeMillis >= ((long) this.f1200f) : currentTimeMillis >= ((long) this.f1199e);
    }

    /* renamed from: b */
    public C0523n mo6065b(C0521l lVar) {
        try {
            return mo6057a(lVar.mo6092a(), lVar.mo6093b(), lVar.mo6094c(), lVar.mo6095d());
        } catch (C0522m e) {
            this.f1195a.mo6077a(e);
            return null;
        } catch (Exception e2) {
            this.f1195a.mo6077a(new C0522m(e2, (C0523n) null));
            return null;
        }
    }

    /* renamed from: b */
    public C0523n mo6066b(String str, C0524o oVar) {
        return mo6065b((C0521l) new C0520k(str, oVar));
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0523n mo6067b(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        byte[] bArr = null;
        try {
            inputStream = httpURLConnection.getErrorStream();
            if (inputStream != null) {
                try {
                    bArr = this.f1195a.mo6078a(inputStream);
                } catch (Throwable th) {
                    th = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e) {
                        }
                    }
                    throw th;
                }
            }
            C0523n nVar = new C0523n(httpURLConnection, bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception e2) {
                }
            }
            return nVar;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
        }
    }

    /* renamed from: b */
    public C0524o mo6068b() {
        return new C0524o();
    }

    /* renamed from: b */
    public void mo6069b(int i) {
        if (i < 1 || i > 18) {
            throw new IllegalArgumentException("Maximum retries must be between 1 and 18");
        }
        this.f1201i = i;
    }

    /* renamed from: c */
    public void mo6070c(int i) {
        this.f1199e = i;
    }
}
