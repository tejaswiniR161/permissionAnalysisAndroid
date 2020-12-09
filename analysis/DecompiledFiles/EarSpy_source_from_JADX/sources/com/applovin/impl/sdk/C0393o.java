package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinErrorCodes;
import com.applovin.sdk.AppLovinLogger;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.applovin.impl.sdk.o */
class C0393o {

    /* renamed from: a */
    private final AppLovinSdkImpl f676a;

    /* renamed from: b */
    private final AppLovinLogger f677b;

    C0393o(AppLovinSdkImpl appLovinSdkImpl) {
        this.f676a = appLovinSdkImpl;
        this.f677b = appLovinSdkImpl.getLogger();
    }

    /* renamed from: a */
    private int m612a(Throwable th) {
        if (th instanceof SocketTimeoutException) {
            return AppLovinErrorCodes.FETCH_AD_TIMEOUT;
        }
        if (!(th instanceof IOException)) {
            return th instanceof JSONException ? -104 : -1;
        }
        String message = th.getMessage();
        return (message == null || !message.toLowerCase(Locale.ENGLISH).contains("authentication challenge")) ? -100 : 401;
    }

    /* renamed from: a */
    private HttpURLConnection m613a(String str, String str2, int i) {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setConnectTimeout(i < 0 ? ((Integer) this.f676a.mo5363a(C0343bw.f562t)).intValue() : i);
        if (i < 0) {
            i = ((Integer) this.f676a.mo5363a(C0343bw.f564v)).intValue();
        }
        httpURLConnection.setReadTimeout(i);
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setAllowUserInteraction(false);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setDoInput(true);
        return httpURLConnection;
    }

    /* renamed from: a */
    private static void m614a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: a */
    private void m615a(String str, int i, String str2, C0394p pVar) {
        this.f677b.mo5665d("ConnectionManager", i + " received from from \"" + str2 + "\": " + str);
        if (i < 200 || i >= 300) {
            this.f677b.mo5666e("ConnectionManager", i + " error received from \"" + str2 + "\"");
            pVar.mo5534a(i);
            return;
        }
        JSONObject jSONObject = new JSONObject();
        if (!(i == 204 || str == null || str.length() <= 2)) {
            jSONObject = new JSONObject(str);
        }
        pVar.mo5536a(jSONObject, i);
    }

    /* renamed from: a */
    private void m616a(String str, String str2, int i, long j) {
        this.f677b.mo5668i("ConnectionManager", "Successful " + str + " returned " + i + " in " + (((float) (System.currentTimeMillis() - j)) / 1000.0f) + " s" + " over " + C0395q.m627a(this.f676a) + " to \"" + str2 + "\"");
    }

    /* renamed from: a */
    private void m617a(String str, String str2, int i, long j, Throwable th) {
        this.f677b.mo5667e("ConnectionManager", "Failed " + str + " returned " + i + " in " + (((float) (System.currentTimeMillis() - j)) / 1000.0f) + " s" + " over " + C0395q.m627a(this.f676a) + " to \"" + str2 + "\"", th);
    }

    /* renamed from: a */
    private static void m618a(HttpURLConnection httpURLConnection) {
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5685a(String str, int i, C0394p pVar) {
        mo5688a(str, "GET", i, (JSONObject) null, true, pVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5686a(String str, int i, JSONObject jSONObject, boolean z, C0394p pVar) {
        mo5688a(str, "POST", i, jSONObject, z, pVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5687a(String str, int i, boolean z, C0394p pVar) {
        mo5688a(str, "GET", i, (JSONObject) null, z, pVar);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0175 A[SYNTHETIC, Splitter:B:49:0x0175] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo5688a(java.lang.String r14, java.lang.String r15, int r16, org.json.JSONObject r17, boolean r18, com.applovin.impl.sdk.C0394p r19) {
        /*
            r13 = this;
            if (r14 != 0) goto L_0x000a
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "No endpoint specified"
            r2.<init>(r3)
            throw r2
        L_0x000a:
            if (r15 != 0) goto L_0x0014
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "No method specified"
            r2.<init>(r3)
            throw r2
        L_0x0014:
            if (r19 != 0) goto L_0x001e
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "No callback specified"
            r2.<init>(r3)
            throw r2
        L_0x001e:
            java.lang.String r2 = r14.toLowerCase()
            java.lang.String r3 = "http"
            boolean r2 = r2.startsWith(r3)
            if (r2 != 0) goto L_0x0052
            com.applovin.sdk.AppLovinLogger r2 = r13.f677b
            java.lang.String r3 = "ConnectionManager"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Requested postback submission to non HTTP endpoint "
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.StringBuilder r4 = r4.append(r14)
            java.lang.String r5 = "; skipping..."
            java.lang.StringBuilder r4 = r4.append(r5)
            java.lang.String r4 = r4.toString()
            r2.userError(r3, r4)
            r2 = -900(0xfffffffffffffc7c, float:NaN)
            r0 = r19
            r0.mo5534a(r2)
        L_0x0051:
            return
        L_0x0052:
            com.applovin.impl.sdk.AppLovinSdkImpl r2 = r13.f676a
            com.applovin.impl.sdk.by r3 = com.applovin.impl.sdk.C0343bw.f531bk
            java.lang.Object r2 = r2.mo5363a((com.applovin.impl.sdk.C0345by) r3)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0199
            java.lang.String r2 = "https://"
            boolean r2 = r14.contains(r2)
            if (r2 != 0) goto L_0x0199
            com.applovin.impl.sdk.AppLovinSdkImpl r2 = r13.f676a
            com.applovin.sdk.AppLovinLogger r2 = r2.getLogger()
            java.lang.String r3 = "ConnectionManager"
            java.lang.String r4 = "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting..."
            r2.mo5671w(r3, r4)
            java.lang.String r2 = "http://"
            java.lang.String r3 = "https://"
            java.lang.String r14 = r14.replace(r2, r3)
            r4 = r14
        L_0x0080:
            long r6 = java.lang.System.currentTimeMillis()
            r2 = 0
            r9 = 0
            r5 = -1
            com.applovin.sdk.AppLovinLogger r3 = r13.f677b     // Catch:{ Throwable -> 0x0192, all -> 0x018c }
            java.lang.String r8 = "ConnectionManager"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0192, all -> 0x018c }
            r10.<init>()     // Catch:{ Throwable -> 0x0192, all -> 0x018c }
            java.lang.String r11 = "Sending "
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ Throwable -> 0x0192, all -> 0x018c }
            java.lang.StringBuilder r10 = r10.append(r15)     // Catch:{ Throwable -> 0x0192, all -> 0x018c }
            java.lang.String r11 = " request to \""
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ Throwable -> 0x0192, all -> 0x018c }
            java.lang.StringBuilder r10 = r10.append(r4)     // Catch:{ Throwable -> 0x0192, all -> 0x018c }
            java.lang.String r11 = "\"..."
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ Throwable -> 0x0192, all -> 0x018c }
            java.lang.String r10 = r10.toString()     // Catch:{ Throwable -> 0x0192, all -> 0x018c }
            r3.mo5668i(r8, r10)     // Catch:{ Throwable -> 0x0192, all -> 0x018c }
            r0 = r16
            java.net.HttpURLConnection r10 = r13.m613a((java.lang.String) r4, (java.lang.String) r15, (int) r0)     // Catch:{ Throwable -> 0x0192, all -> 0x018c }
            if (r17 == 0) goto L_0x0110
            java.lang.String r2 = r17.toString()     // Catch:{ Throwable -> 0x0195 }
            com.applovin.sdk.AppLovinLogger r3 = r13.f677b     // Catch:{ Throwable -> 0x0195 }
            java.lang.String r8 = "ConnectionManager"
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ Throwable -> 0x0195 }
            r11.<init>()     // Catch:{ Throwable -> 0x0195 }
            java.lang.String r12 = "Request to \""
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ Throwable -> 0x0195 }
            java.lang.StringBuilder r11 = r11.append(r4)     // Catch:{ Throwable -> 0x0195 }
            java.lang.String r12 = "\" is "
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch:{ Throwable -> 0x0195 }
            java.lang.StringBuilder r11 = r11.append(r2)     // Catch:{ Throwable -> 0x0195 }
            java.lang.String r11 = r11.toString()     // Catch:{ Throwable -> 0x0195 }
            r3.mo5665d(r8, r11)     // Catch:{ Throwable -> 0x0195 }
            java.lang.String r3 = "Content-Type"
            java.lang.String r8 = "application/json; charset=utf-8"
            r10.setRequestProperty(r3, r8)     // Catch:{ Throwable -> 0x0195 }
            r3 = 1
            r10.setDoOutput(r3)     // Catch:{ Throwable -> 0x0195 }
            java.lang.String r3 = "UTF-8"
            java.nio.charset.Charset r3 = java.nio.charset.Charset.forName(r3)     // Catch:{ Throwable -> 0x0195 }
            byte[] r3 = r2.getBytes(r3)     // Catch:{ Throwable -> 0x0195 }
            int r3 = r3.length     // Catch:{ Throwable -> 0x0195 }
            r10.setFixedLengthStreamingMode(r3)     // Catch:{ Throwable -> 0x0195 }
            java.io.PrintWriter r3 = new java.io.PrintWriter     // Catch:{ Throwable -> 0x0195 }
            java.io.OutputStreamWriter r8 = new java.io.OutputStreamWriter     // Catch:{ Throwable -> 0x0195 }
            java.io.OutputStream r11 = r10.getOutputStream()     // Catch:{ Throwable -> 0x0195 }
            java.lang.String r12 = "UTF8"
            r8.<init>(r11, r12)     // Catch:{ Throwable -> 0x0195 }
            r3.<init>(r8)     // Catch:{ Throwable -> 0x0195 }
            r3.print(r2)     // Catch:{ Throwable -> 0x0195 }
            r3.close()     // Catch:{ Throwable -> 0x0195 }
        L_0x0110:
            int r5 = r10.getResponseCode()     // Catch:{ MalformedURLException -> 0x014f }
            if (r5 <= 0) goto L_0x0142
            r2 = r13
            r3 = r15
            r2.m616a((java.lang.String) r3, (java.lang.String) r4, (int) r5, (long) r6)     // Catch:{ MalformedURLException -> 0x014f }
            if (r18 == 0) goto L_0x0136
            java.io.InputStream r2 = r10.getInputStream()     // Catch:{ MalformedURLException -> 0x014f }
            java.lang.String r3 = com.applovin.impl.sdk.C0395q.m628a((java.io.InputStream) r2)     // Catch:{ MalformedURLException -> 0x0197 }
            int r8 = r10.getResponseCode()     // Catch:{ MalformedURLException -> 0x0197 }
            r0 = r19
            r13.m615a((java.lang.String) r3, (int) r8, (java.lang.String) r4, (com.applovin.impl.sdk.C0394p) r0)     // Catch:{ MalformedURLException -> 0x0197 }
        L_0x012e:
            m614a((java.io.InputStream) r2)
            m618a((java.net.HttpURLConnection) r10)
            goto L_0x0051
        L_0x0136:
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ MalformedURLException -> 0x014f }
            r2.<init>()     // Catch:{ MalformedURLException -> 0x014f }
            r0 = r19
            r0.mo5536a(r2, r5)     // Catch:{ MalformedURLException -> 0x014f }
            r2 = r9
            goto L_0x012e
        L_0x0142:
            r8 = 0
            r2 = r13
            r3 = r15
            r2.m617a((java.lang.String) r3, (java.lang.String) r4, (int) r5, (long) r6, (java.lang.Throwable) r8)     // Catch:{ MalformedURLException -> 0x014f }
            r0 = r19
            r0.mo5534a(r5)     // Catch:{ MalformedURLException -> 0x014f }
            r2 = r9
            goto L_0x012e
        L_0x014f:
            r2 = move-exception
            r2 = r9
        L_0x0151:
            if (r18 == 0) goto L_0x0175
            r3 = -901(0xfffffffffffffc7b, float:NaN)
            r0 = r19
            r0.mo5534a(r3)     // Catch:{ Throwable -> 0x015b, all -> 0x0182 }
            goto L_0x012e
        L_0x015b:
            r8 = move-exception
            r9 = r2
        L_0x015d:
            if (r5 != 0) goto L_0x0163
            int r5 = r13.m612a((java.lang.Throwable) r8)     // Catch:{ all -> 0x0190 }
        L_0x0163:
            r2 = r13
            r3 = r15
            r2.m617a((java.lang.String) r3, (java.lang.String) r4, (int) r5, (long) r6, (java.lang.Throwable) r8)     // Catch:{ all -> 0x0190 }
            r0 = r19
            r0.mo5534a(r5)     // Catch:{ all -> 0x0190 }
            m614a((java.io.InputStream) r9)
            m618a((java.net.HttpURLConnection) r10)
            goto L_0x0051
        L_0x0175:
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Throwable -> 0x015b, all -> 0x0182 }
            r3.<init>()     // Catch:{ Throwable -> 0x015b, all -> 0x0182 }
            r8 = -901(0xfffffffffffffc7b, float:NaN)
            r0 = r19
            r0.mo5536a(r3, r8)     // Catch:{ Throwable -> 0x015b, all -> 0x0182 }
            goto L_0x012e
        L_0x0182:
            r3 = move-exception
            r9 = r2
            r2 = r3
        L_0x0185:
            m614a((java.io.InputStream) r9)
            m618a((java.net.HttpURLConnection) r10)
            throw r2
        L_0x018c:
            r3 = move-exception
            r10 = r2
            r2 = r3
            goto L_0x0185
        L_0x0190:
            r2 = move-exception
            goto L_0x0185
        L_0x0192:
            r8 = move-exception
            r10 = r2
            goto L_0x015d
        L_0x0195:
            r8 = move-exception
            goto L_0x015d
        L_0x0197:
            r3 = move-exception
            goto L_0x0151
        L_0x0199:
            r4 = r14
            goto L_0x0080
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C0393o.mo5688a(java.lang.String, java.lang.String, int, org.json.JSONObject, boolean, com.applovin.impl.sdk.p):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5689a(String str, JSONObject jSONObject, C0394p pVar) {
        mo5688a(str, "POST", -1, jSONObject, true, pVar);
    }
}
