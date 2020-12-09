package com.applovin.impl.sdk;

import android.content.Context;
import android.net.Uri;
import com.applovin.sdk.AppLovinLogger;
import com.applovin.sdk.AppLovinSdk;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* renamed from: com.applovin.impl.sdk.y */
public class C0403y {

    /* renamed from: a */
    private final AppLovinLogger f701a;

    /* renamed from: b */
    private final AppLovinSdkImpl f702b;

    /* renamed from: c */
    private final String f703c = "FileManager";

    /* renamed from: d */
    private final Object f704d;

    C0403y(AppLovinSdk appLovinSdk) {
        this.f702b = (AppLovinSdkImpl) appLovinSdk;
        this.f701a = appLovinSdk.getLogger();
        this.f704d = new Object();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public long mo5694a(long j) {
        return j / 1048576;
    }

    /* renamed from: a */
    public File mo5695a(String str, Context context, boolean z) {
        File file;
        if (!C0382dh.isValidString(str)) {
            this.f702b.getLogger().mo5665d("FileManager", "Nothing to look up, skipping...");
            return null;
        }
        this.f701a.mo5665d("FileManager", "Looking up cached resource: " + str);
        if (!mo5700a(context) && !z) {
            return null;
        }
        if (str.contains("icon")) {
            str = str.replace("/", "_").replace(".", "_");
        }
        synchronized (this.f704d) {
            File b = mo5706b(context);
            file = new File(b, str);
            try {
                b.mkdirs();
            } catch (Exception e) {
                return null;
            }
        }
        return file;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo5696a(Context context, String str) {
        return mo5697a(context, str, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo5697a(Context context, String str, boolean z) {
        if (str == null || str.equals("")) {
            this.f702b.getLogger().mo5665d("FileManager", "Nothing to cache, skipping...");
            return "";
        }
        this.f702b.getLogger().mo5665d("FileManager", "Starting caching of resource " + str);
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        File a = mo5695a(lastPathSegment, context, false);
        if (a != null && a.exists()) {
            return z ? Uri.fromFile(a).toString() : lastPathSegment;
        }
        if (mo5703a(a, str)) {
            return z ? Uri.fromFile(a).toString() : lastPathSegment;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5698a(long j, Context context) {
        long c = (long) mo5708c();
        if (c == -1) {
            this.f701a.mo5665d("FileManager", "Cache has no maximum size set; skipping drop...");
        } else if (mo5694a(j) > c) {
            this.f701a.mo5665d("FileManager", "Cache has exceeded maximum size; dropping...");
            mo5712f(context);
            this.f702b.mo5366b().mo5596a("cache_drop_count");
        } else {
            this.f701a.mo5665d("FileManager", "Cache is present but under size limit; not dropping...");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5699a() {
        return ((Boolean) this.f702b.mo5363a(C0343bw.f468aA)).booleanValue();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo5700a(Context context) {
        if (C0392n.m609a("android.permission.WRITE_EXTERNAL_STORAGE", context)) {
            return true;
        }
        return C0392n.m611c() && !((Boolean) this.f702b.mo5363a(C0343bw.f542bv)).booleanValue();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0040 A[SYNTHETIC, Splitter:B:18:0x0040] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004c A[SYNTHETIC, Splitter:B:26:0x004c] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:10:0x0031=Splitter:B:10:0x0031, B:28:0x004f=Splitter:B:28:0x004f} */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo5701a(java.io.ByteArrayOutputStream r8, java.io.File r9) {
        /*
            r7 = this;
            com.applovin.sdk.AppLovinLogger r0 = r7.f701a
            java.lang.String r1 = "FileManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Writing resource to filesystem: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r3 = r9.getName()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.mo5665d(r1, r2)
            r2 = 0
            r3 = 0
            java.lang.Object r4 = r7.f704d
            monitor-enter(r4)
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0033, all -> 0x0048 }
            r1.<init>(r9)     // Catch:{ IOException -> 0x0033, all -> 0x0048 }
            r8.writeTo(r1)     // Catch:{ IOException -> 0x0059 }
            r0 = 1
            if (r1 == 0) goto L_0x0031
            r1.close()     // Catch:{ Exception -> 0x0053 }
        L_0x0031:
            monitor-exit(r4)     // Catch:{ all -> 0x0050 }
            return r0
        L_0x0033:
            r0 = move-exception
            r1 = r2
        L_0x0035:
            com.applovin.sdk.AppLovinLogger r2 = r7.f701a     // Catch:{ all -> 0x0057 }
            java.lang.String r5 = "FileManager"
            java.lang.String r6 = "Unable to write data to file"
            r2.mo5667e(r5, r6, r0)     // Catch:{ all -> 0x0057 }
            if (r1 == 0) goto L_0x0043
            r1.close()     // Catch:{ Exception -> 0x0045 }
        L_0x0043:
            r0 = r3
            goto L_0x0031
        L_0x0045:
            r0 = move-exception
            r0 = r3
            goto L_0x0031
        L_0x0048:
            r0 = move-exception
            r1 = r2
        L_0x004a:
            if (r1 == 0) goto L_0x004f
            r1.close()     // Catch:{ Exception -> 0x0055 }
        L_0x004f:
            throw r0     // Catch:{ all -> 0x0050 }
        L_0x0050:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0050 }
            throw r0
        L_0x0053:
            r1 = move-exception
            goto L_0x0031
        L_0x0055:
            r1 = move-exception
            goto L_0x004f
        L_0x0057:
            r0 = move-exception
            goto L_0x004a
        L_0x0059:
            r0 = move-exception
            goto L_0x0035
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C0403y.mo5701a(java.io.ByteArrayOutputStream, java.io.File):boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5702a(File file) {
        boolean z;
        this.f701a.mo5665d("FileManager", "Removing file " + file.getName() + " from filesystem...");
        synchronized (this.f704d) {
            try {
                z = file.delete();
            } catch (Exception e) {
                this.f701a.mo5667e("FileManager", "Failed to remove file " + file.getName() + " from filesystem!", e);
                z = false;
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0186 A[SYNTHETIC, Splitter:B:77:0x0186] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x018b A[SYNTHETIC, Splitter:B:80:0x018b] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0190 A[SYNTHETIC, Splitter:B:83:0x0190] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x019b A[SYNTHETIC, Splitter:B:89:0x019b] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01a0 A[SYNTHETIC, Splitter:B:92:0x01a0] */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01a5 A[SYNTHETIC, Splitter:B:95:0x01a5] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo5703a(java.io.File r11, java.lang.String r12) {
        /*
            r10 = this;
            r4 = 0
            r3 = 1
            r2 = 0
            com.applovin.sdk.AppLovinLogger r0 = r10.f701a
            java.lang.String r1 = "FileManager"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Starting caching of "
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.StringBuilder r5 = r5.append(r12)
            java.lang.String r6 = " into "
            java.lang.StringBuilder r5 = r5.append(r6)
            java.io.File r6 = r11.getAbsoluteFile()
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r5 = r5.toString()
            r0.mo5665d(r1, r5)
            com.applovin.impl.sdk.AppLovinSdkImpl r0 = r10.f702b
            com.applovin.impl.sdk.by r1 = com.applovin.impl.sdk.C0343bw.f531bk
            java.lang.Object r0 = r0.mo5363a((com.applovin.impl.sdk.C0345by) r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0058
            java.lang.String r0 = "https://"
            boolean r0 = r12.contains(r0)
            if (r0 != 0) goto L_0x0058
            com.applovin.impl.sdk.AppLovinSdkImpl r0 = r10.f702b
            com.applovin.sdk.AppLovinLogger r0 = r0.getLogger()
            java.lang.String r1 = "FileManager"
            java.lang.String r5 = "Plaintext HTTP operation requested; upgrading to HTTPS due to universal SSL setting..."
            r0.mo5671w(r1, r5)
            java.lang.String r0 = "http://"
            java.lang.String r1 = "https://"
            java.lang.String r12 = r12.replace(r0, r1)
        L_0x0058:
            r6 = 0
            java.io.ByteArrayOutputStream r5 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0153, all -> 0x0196 }
            r5.<init>()     // Catch:{ IOException -> 0x0153, all -> 0x0196 }
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x01e5, all -> 0x01da }
            r0.<init>(r12)     // Catch:{ IOException -> 0x01e5, all -> 0x01da }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ IOException -> 0x01e5, all -> 0x01da }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IOException -> 0x01e5, all -> 0x01da }
            com.applovin.impl.sdk.AppLovinSdkImpl r1 = r10.f702b     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            com.applovin.impl.sdk.by r7 = com.applovin.impl.sdk.C0343bw.f562t     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            java.lang.Object r1 = r1.mo5363a((com.applovin.impl.sdk.C0345by) r7)     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            int r1 = r1.intValue()     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            r0.setConnectTimeout(r1)     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            com.applovin.impl.sdk.AppLovinSdkImpl r1 = r10.f702b     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            com.applovin.impl.sdk.by r7 = com.applovin.impl.sdk.C0343bw.f564v     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            java.lang.Object r1 = r1.mo5363a((com.applovin.impl.sdk.C0345by) r7)     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            int r1 = r1.intValue()     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            r0.setReadTimeout(r1)     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            r1 = 1
            r0.setDefaultUseCaches(r1)     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            r1 = 1
            r0.setUseCaches(r1)     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            r1 = 0
            r0.setAllowUserInteraction(r1)     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            r1 = 1
            r0.setInstanceFollowRedirects(r1)     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            int r1 = r0.getResponseCode()     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            r7 = 200(0xc8, float:2.8E-43)
            if (r1 < r7) goto L_0x00a7
            r7 = 300(0x12c, float:4.2E-43)
            if (r1 < r7) goto L_0x00b8
        L_0x00a7:
            if (r4 == 0) goto L_0x00ac
            r6.close()     // Catch:{ Exception -> 0x01a9 }
        L_0x00ac:
            if (r5 == 0) goto L_0x00b1
            r5.close()     // Catch:{ Exception -> 0x01ac }
        L_0x00b1:
            if (r0 == 0) goto L_0x00b6
            r0.disconnect()     // Catch:{ Exception -> 0x01af }
        L_0x00b6:
            r0 = r2
        L_0x00b7:
            return r0
        L_0x00b8:
            java.io.InputStream r4 = r0.getInputStream()     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
        L_0x00c0:
            r6 = 0
            int r7 = r1.length     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            int r6 = r4.read(r1, r6, r7)     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            if (r6 < 0) goto L_0x00e2
            r7 = 0
            r5.write(r1, r7, r6)     // Catch:{ Exception -> 0x00cd }
            goto L_0x00c0
        L_0x00cd:
            r1 = move-exception
            r5.close()     // Catch:{ Exception -> 0x01b2 }
        L_0x00d1:
            if (r4 == 0) goto L_0x00d6
            r4.close()     // Catch:{ Exception -> 0x01b5 }
        L_0x00d6:
            if (r5 == 0) goto L_0x00db
            r5.close()     // Catch:{ Exception -> 0x01b8 }
        L_0x00db:
            if (r0 == 0) goto L_0x00e0
            r0.disconnect()     // Catch:{ Exception -> 0x01bb }
        L_0x00e0:
            r0 = r2
            goto L_0x00b7
        L_0x00e2:
            boolean r1 = r10.mo5701a((java.io.ByteArrayOutputStream) r5, (java.io.File) r11)     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            if (r1 != 0) goto L_0x0127
            com.applovin.sdk.AppLovinLogger r1 = r10.f701a     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            java.lang.String r3 = "FileManager"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            r6.<init>()     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            java.lang.String r7 = "Failed to cache \""
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            java.lang.StringBuilder r6 = r6.append(r12)     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            java.lang.String r7 = "\" into \""
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            java.lang.String r7 = r11.getAbsolutePath()     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            java.lang.String r7 = "\""
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            r1.mo5666e(r3, r6)     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            if (r4 == 0) goto L_0x011b
            r4.close()     // Catch:{ Exception -> 0x01be }
        L_0x011b:
            if (r5 == 0) goto L_0x0120
            r5.close()     // Catch:{ Exception -> 0x01c1 }
        L_0x0120:
            if (r0 == 0) goto L_0x0125
            r0.disconnect()     // Catch:{ Exception -> 0x01c4 }
        L_0x0125:
            r0 = r2
            goto L_0x00b7
        L_0x0127:
            com.applovin.sdk.AppLovinLogger r1 = r10.f701a     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            java.lang.String r6 = "FileManager"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            r7.<init>()     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            java.lang.String r8 = "Caching completed for "
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            java.lang.StringBuilder r7 = r7.append(r11)     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            java.lang.String r7 = r7.toString()     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            r1.mo5665d(r6, r7)     // Catch:{ IOException -> 0x01ea, all -> 0x01dd }
            if (r4 == 0) goto L_0x0146
            r4.close()     // Catch:{ Exception -> 0x01c7 }
        L_0x0146:
            if (r5 == 0) goto L_0x014b
            r5.close()     // Catch:{ Exception -> 0x01ca }
        L_0x014b:
            if (r0 == 0) goto L_0x0150
            r0.disconnect()     // Catch:{ Exception -> 0x01cc }
        L_0x0150:
            r0 = r3
            goto L_0x00b7
        L_0x0153:
            r0 = move-exception
            r1 = r4
            r3 = r4
        L_0x0156:
            com.applovin.sdk.AppLovinLogger r5 = r10.f701a     // Catch:{ all -> 0x01e2 }
            java.lang.String r6 = "FileManager"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e2 }
            r7.<init>()     // Catch:{ all -> 0x01e2 }
            java.lang.String r8 = "Failed to cache \""
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x01e2 }
            java.lang.StringBuilder r7 = r7.append(r12)     // Catch:{ all -> 0x01e2 }
            java.lang.String r8 = "\" into \""
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x01e2 }
            java.lang.String r8 = r11.getAbsolutePath()     // Catch:{ all -> 0x01e2 }
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x01e2 }
            java.lang.String r8 = "\""
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ all -> 0x01e2 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x01e2 }
            r5.mo5667e(r6, r7, r0)     // Catch:{ all -> 0x01e2 }
            if (r4 == 0) goto L_0x0189
            r4.close()     // Catch:{ Exception -> 0x01ce }
        L_0x0189:
            if (r3 == 0) goto L_0x018e
            r3.close()     // Catch:{ Exception -> 0x01d0 }
        L_0x018e:
            if (r1 == 0) goto L_0x0193
            r1.disconnect()     // Catch:{ Exception -> 0x01d2 }
        L_0x0193:
            r0 = r2
            goto L_0x00b7
        L_0x0196:
            r0 = move-exception
            r1 = r4
            r5 = r4
        L_0x0199:
            if (r4 == 0) goto L_0x019e
            r4.close()     // Catch:{ Exception -> 0x01d4 }
        L_0x019e:
            if (r5 == 0) goto L_0x01a3
            r5.close()     // Catch:{ Exception -> 0x01d6 }
        L_0x01a3:
            if (r1 == 0) goto L_0x01a8
            r1.disconnect()     // Catch:{ Exception -> 0x01d8 }
        L_0x01a8:
            throw r0
        L_0x01a9:
            r1 = move-exception
            goto L_0x00ac
        L_0x01ac:
            r1 = move-exception
            goto L_0x00b1
        L_0x01af:
            r0 = move-exception
            goto L_0x00b6
        L_0x01b2:
            r1 = move-exception
            goto L_0x00d1
        L_0x01b5:
            r1 = move-exception
            goto L_0x00d6
        L_0x01b8:
            r1 = move-exception
            goto L_0x00db
        L_0x01bb:
            r0 = move-exception
            goto L_0x00e0
        L_0x01be:
            r1 = move-exception
            goto L_0x011b
        L_0x01c1:
            r1 = move-exception
            goto L_0x0120
        L_0x01c4:
            r0 = move-exception
            goto L_0x0125
        L_0x01c7:
            r1 = move-exception
            goto L_0x0146
        L_0x01ca:
            r1 = move-exception
            goto L_0x014b
        L_0x01cc:
            r0 = move-exception
            goto L_0x0150
        L_0x01ce:
            r0 = move-exception
            goto L_0x0189
        L_0x01d0:
            r0 = move-exception
            goto L_0x018e
        L_0x01d2:
            r0 = move-exception
            goto L_0x0193
        L_0x01d4:
            r2 = move-exception
            goto L_0x019e
        L_0x01d6:
            r2 = move-exception
            goto L_0x01a3
        L_0x01d8:
            r1 = move-exception
            goto L_0x01a8
        L_0x01da:
            r0 = move-exception
            r1 = r4
            goto L_0x0199
        L_0x01dd:
            r1 = move-exception
            r9 = r1
            r1 = r0
            r0 = r9
            goto L_0x0199
        L_0x01e2:
            r0 = move-exception
            r5 = r3
            goto L_0x0199
        L_0x01e5:
            r0 = move-exception
            r1 = r4
            r3 = r5
            goto L_0x0156
        L_0x01ea:
            r1 = move-exception
            r3 = r5
            r9 = r0
            r0 = r1
            r1 = r9
            goto L_0x0156
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C0403y.mo5703a(java.io.File, java.lang.String):boolean");
    }

    /* renamed from: a */
    public boolean mo5704a(String str, Context context) {
        boolean b;
        synchronized (this.f704d) {
            b = mo5707b(str, context, false);
        }
        return b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public long mo5705b() {
        long longValue = ((Long) this.f702b.mo5363a(C0343bw.f469aB)).longValue();
        if (longValue < 0 || !mo5699a()) {
            return -1;
        }
        return longValue;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public File mo5706b(Context context) {
        return mo5700a(context) ? new File(context.getExternalFilesDir((String) null), "al") : new File(context.getCacheDir(), "al");
    }

    /* renamed from: b */
    public boolean mo5707b(String str, Context context, boolean z) {
        boolean z2;
        synchronized (this.f704d) {
            File a = mo5695a(str, context, z);
            z2 = a != null && a.exists() && !a.isDirectory();
        }
        return z2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo5708c() {
        int intValue = ((Integer) this.f702b.mo5363a(C0343bw.f470aC)).intValue();
        if (intValue < 0 || !mo5699a()) {
            return -1;
        }
        return intValue;
    }

    /* renamed from: c */
    public List mo5709c(Context context) {
        List asList;
        File b = mo5706b(context);
        if (!b.isDirectory()) {
            return new ArrayList(0);
        }
        synchronized (this.f704d) {
            asList = Arrays.asList(b.listFiles());
        }
        return asList;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo5710d(android.content.Context r5) {
        /*
            r4 = this;
            boolean r0 = r4.mo5699a()     // Catch:{ Exception -> 0x0030 }
            if (r0 == 0) goto L_0x0017
            com.applovin.impl.sdk.AppLovinSdkImpl r0 = r4.f702b     // Catch:{ Exception -> 0x0030 }
            boolean r0 = r0.isEnabled()     // Catch:{ Exception -> 0x0030 }
            if (r0 == 0) goto L_0x0018
            com.applovin.sdk.AppLovinLogger r0 = r4.f701a     // Catch:{ Exception -> 0x0030 }
            java.lang.String r1 = "FileManager"
            java.lang.String r2 = "Cannot empty file cache after SDK has completed initialization and ad loads are in progress!"
            r0.mo5666e(r1, r2)     // Catch:{ Exception -> 0x0030 }
        L_0x0017:
            return
        L_0x0018:
            com.applovin.sdk.AppLovinLogger r0 = r4.f701a     // Catch:{ Exception -> 0x0030 }
            java.lang.String r1 = "FileManager"
            java.lang.String r2 = "Compacting cache..."
            r0.mo5665d(r1, r2)     // Catch:{ Exception -> 0x0030 }
            java.lang.Object r1 = r4.f704d     // Catch:{ Exception -> 0x0030 }
            monitor-enter(r1)     // Catch:{ Exception -> 0x0030 }
            long r2 = r4.mo5711e(r5)     // Catch:{ all -> 0x002d }
            r4.mo5698a((long) r2, (android.content.Context) r5)     // Catch:{ all -> 0x002d }
            monitor-exit(r1)     // Catch:{ all -> 0x002d }
            goto L_0x0017
        L_0x002d:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x002d }
            throw r0     // Catch:{ Exception -> 0x0030 }
        L_0x0030:
            r0 = move-exception
            com.applovin.sdk.AppLovinLogger r1 = r4.f701a
            java.lang.String r2 = "FileManager"
            java.lang.String r3 = "Caught exception while compacting cache!"
            r1.mo5667e(r2, r3, r0)
            com.applovin.impl.sdk.AppLovinSdkImpl r0 = r4.f702b
            com.applovin.impl.sdk.bz r0 = r0.getSettingsManager()
            com.applovin.impl.sdk.by r1 = com.applovin.impl.sdk.C0343bw.f468aA
            r2 = 0
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r0.mo5546a(r1, r2)
            com.applovin.impl.sdk.AppLovinSdkImpl r0 = r4.f702b
            com.applovin.impl.sdk.bz r0 = r0.getSettingsManager()
            r0.mo5549b()
            goto L_0x0017
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.C0403y.mo5710d(android.content.Context):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public long mo5711e(Context context) {
        long j = 0;
        long b = mo5705b();
        boolean z = b != -1;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        synchronized (this.f704d) {
            for (File file : mo5709c(context)) {
                boolean z2 = false;
                if (z && seconds - TimeUnit.MILLISECONDS.toSeconds(file.lastModified()) > b) {
                    this.f701a.mo5665d("FileManager", "File " + file.getName() + " has expired, removing...");
                    mo5702a(file);
                    z2 = true;
                }
                if (z2) {
                    this.f702b.mo5366b().mo5596a("cached_files_expired");
                } else {
                    j += file.length();
                }
            }
        }
        return j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo5712f(Context context) {
        synchronized (this.f704d) {
            for (File a : mo5709c(context)) {
                mo5702a(a);
            }
        }
    }
}
