package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.facebook.ads.AdError;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.zzk;
import com.google.android.gms.ads.internal.request.zzl;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzfy;
import com.google.android.gms.internal.zzjl;
import com.google.android.gms.internal.zzlm;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public final class zzjb extends zzk.zza {
    private static final Object zzaok = new Object();
    private static zzjb zzcjk;
    private final Context mContext;
    private final zzja zzcjl;
    private final zzdb zzcjm;
    private final zzfy zzcjn;

    zzjb(Context context, zzdb zzdb, zzja zzja) {
        this.mContext = context;
        this.zzcjl = zzja;
        this.zzcjm = zzdb;
        this.zzcjn = new zzfy(context.getApplicationContext() != null ? context.getApplicationContext() : context, VersionInfoParcel.zzvg(), zzdb.zzkp(), new zzkw<zzfv>() {
            /* renamed from: zza */
            public void zzd(zzfv zzfv) {
                zzfv.zza("/log", zzeu.zzbmj);
            }
        }, new zzfy.zzb());
    }

    private static AdResponseParcel zza(Context context, zzfy zzfy, zzdb zzdb, zzja zzja, AdRequestInfoParcel adRequestInfoParcel) {
        Bundle bundle;
        zzlj zzlj;
        String string;
        zzkn.zzdd("Starting ad request from service using: AFMA_getAd");
        zzdi.initialize(context);
        zzlj<Bundle> zzqi = zzja.zzcji.zzqi();
        final zzdq zzdq = new zzdq(zzdi.zzbca.get().booleanValue(), "load_ad", adRequestInfoParcel.zzaqz.zzaxi);
        if (adRequestInfoParcel.versionCode > 10 && adRequestInfoParcel.zzcgm != -1) {
            zzdq.zza(zzdq.zzc(adRequestInfoParcel.zzcgm), "cts");
        }
        zzdo zzla = zzdq.zzla();
        final Bundle bundle2 = (adRequestInfoParcel.versionCode < 4 || adRequestInfoParcel.zzcgb == null) ? null : adRequestInfoParcel.zzcgb;
        if (!zzdi.zzbcj.get().booleanValue() || zzja.zzcja == null) {
            bundle = bundle2;
            zzlj = null;
        } else {
            if (bundle2 == null && zzdi.zzbck.get().booleanValue()) {
                zzkn.m1493v("contentInfo is not present, but we'll still launch the app index task");
                bundle2 = new Bundle();
            }
            if (bundle2 != null) {
                final zzja zzja2 = zzja;
                final Context context2 = context;
                final AdRequestInfoParcel adRequestInfoParcel2 = adRequestInfoParcel;
                bundle = bundle2;
                zzlj = zzkq.zza(new Callable<Void>() {
                    /* renamed from: zzdb */
                    public Void call() throws Exception {
                        zzja.this.zzcja.zza(context2, adRequestInfoParcel2.zzcfv.packageName, bundle2);
                        return null;
                    }
                });
            } else {
                bundle = bundle2;
                zzlj = null;
            }
        }
        zzlj zzlh = new zzlh(null);
        Bundle bundle3 = adRequestInfoParcel.zzcfu.extras;
        zzlj zza = (!adRequestInfoParcel.zzcgt || (bundle3 != null && bundle3.getString("_ad") != null)) ? zzlh : zzja.zzcjf.zza(adRequestInfoParcel.applicationInfo);
        zzjh zzy = zzu.zzgi().zzy(context);
        if (zzy.zzcmd == -1) {
            zzkn.zzdd("Device is offline.");
            return new AdResponseParcel(2);
        }
        String uuid = adRequestInfoParcel.versionCode >= 7 ? adRequestInfoParcel.zzcgj : UUID.randomUUID().toString();
        final zzjd zzjd = new zzjd(uuid, adRequestInfoParcel.applicationInfo.packageName);
        if (adRequestInfoParcel.zzcfu.extras != null && (string = adRequestInfoParcel.zzcfu.extras.getString("_ad")) != null) {
            return zzjc.zza(context, adRequestInfoParcel, string);
        }
        List<String> zza2 = zzja.zzcjd.zza(adRequestInfoParcel);
        String zzg = zzja.zzcjj.zzg(adRequestInfoParcel);
        zzjl.zza zzz = zzja.zzcjh.zzz(context);
        if (zzlj != null) {
            try {
                zzkn.m1493v("Waiting for app index fetching task.");
                zzlj.get(zzdi.zzbcl.get().longValue(), TimeUnit.MILLISECONDS);
                zzkn.m1493v("App index fetching task completed.");
            } catch (InterruptedException | ExecutionException e) {
                zzkn.zzd("Failed to fetch app index signal", e);
            } catch (TimeoutException e2) {
                zzkn.zzdd("Timed out waiting for app index fetching task");
            }
        }
        String zzcr = zzja.zzcjc.zzcr(adRequestInfoParcel.zzcfv.packageName);
        zzd(zzqi);
        JSONObject zza3 = zzjc.zza(context, new zziz().zzf(adRequestInfoParcel).zza(zzy).zza(zzz).zzc(zzc(zza)).zze(zzd(zzqi)).zzci(zzg).zzk(zza2).zzf(bundle).zzcj(zzcr).zzj(zzja.zzcjb.zzj(context)));
        if (zza3 == null) {
            return new AdResponseParcel(0);
        }
        if (adRequestInfoParcel.versionCode < 7) {
            try {
                zza3.put("request_id", uuid);
            } catch (JSONException e3) {
            }
        }
        try {
            zza3.put("prefetch_mode", "url");
        } catch (JSONException e4) {
            zzkn.zzd("Failed putting prefetch parameters to ad request.", e4);
        }
        final String jSONObject = zza3.toString();
        zzdq.zza(zzla, "arc");
        final zzdo zzla2 = zzdq.zzla();
        final zzfy zzfy2 = zzfy;
        zzkr.zzcrf.post(new Runnable() {
            public void run() {
                zzfy.zzc zzmy = zzfy.this.zzmy();
                zzjd.zzb(zzmy);
                zzdq.zza(zzla2, "rwc");
                final zzdo zzla = zzdq.zzla();
                zzmy.zza(new zzlm.zzc<zzfz>() {
                    /* renamed from: zzb */
                    public void zzd(zzfz zzfz) {
                        zzdq.zza(zzla, "jsf");
                        zzdq.zzlb();
                        zzfz.zza("/invalidRequest", zzjd.zzckc);
                        zzfz.zza("/loadAdURL", zzjd.zzckd);
                        zzfz.zza("/loadAd", zzjd.zzcke);
                        try {
                            zzfz.zzj("AFMA_getAd", jSONObject);
                        } catch (Exception e) {
                            zzkn.zzb("Error requesting an ad url", e);
                        }
                    }
                }, new zzlm.zza() {
                    public void run() {
                    }
                });
            }
        });
        try {
            zzjg zzjg = zzjd.zzse().get(10, TimeUnit.SECONDS);
            if (zzjg == null) {
                return new AdResponseParcel(0);
            }
            if (zzjg.getErrorCode() != -2) {
                AdResponseParcel adResponseParcel = new AdResponseParcel(zzjg.getErrorCode());
                final zzja zzja3 = zzja;
                final Context context3 = context;
                final AdRequestInfoParcel adRequestInfoParcel3 = adRequestInfoParcel;
                zzkr.zzcrf.post(new Runnable() {
                    public void run() {
                        zzja.this.zzcje.zza(r1, zzjd, r2.zzaqv);
                    }
                });
                return adResponseParcel;
            }
            if (zzdq.zzld() != null) {
                zzdq.zza(zzdq.zzld(), "rur");
            }
            AdResponseParcel adResponseParcel2 = null;
            if (!TextUtils.isEmpty(zzjg.zzsj())) {
                adResponseParcel2 = zzjc.zza(context, adRequestInfoParcel, zzjg.zzsj());
            }
            if (adResponseParcel2 == null && !TextUtils.isEmpty(zzjg.getUrl())) {
                adResponseParcel2 = zza(adRequestInfoParcel, context, adRequestInfoParcel.zzaqv.zzcs, zzjg.getUrl(), zzcr, zzjg, zzdq, zzja);
            }
            if (adResponseParcel2 == null) {
                adResponseParcel2 = new AdResponseParcel(0);
            }
            zzdq.zza(zzla, "tts");
            adResponseParcel2.zzchp = zzdq.zzlc();
            final zzja zzja4 = zzja;
            final Context context4 = context;
            final AdRequestInfoParcel adRequestInfoParcel4 = adRequestInfoParcel;
            zzkr.zzcrf.post(new Runnable() {
                public void run() {
                    zzja.this.zzcje.zza(r1, zzjd, r2.zzaqv);
                }
            });
            return adResponseParcel2;
        } catch (Exception e5) {
            return new AdResponseParcel(0);
        } finally {
            final zzja zzja5 = zzja;
            final Context context5 = context;
            final AdRequestInfoParcel adRequestInfoParcel5 = adRequestInfoParcel;
            zzkr.zzcrf.post(new Runnable() {
                public void run() {
                    zzja.this.zzcje.zza(context5, zzjd, adRequestInfoParcel5.zzaqv);
                }
            });
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01cd, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:?, code lost:
        return r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a9, code lost:
        r6 = r7.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        r4 = new java.io.InputStreamReader(r2.getInputStream());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r5 = com.google.android.gms.ads.internal.zzu.zzfz().zza(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        com.google.android.gms.common.util.zzo.zzb(r4);
        zza(r6, r12, r5, r9);
        r8.zzb(r6, r12, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00c8, code lost:
        if (r19 == null) goto L_0x00d7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ca, code lost:
        r19.zza(r3, "ufe");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00d7, code lost:
        r3 = r8.zzj(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        r2.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00de, code lost:
        if (r20 == null) goto L_0x00e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e0, code lost:
        r20.zzcjg.zzsm();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0127, code lost:
        r3 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0128, code lost:
        r4 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:?, code lost:
        com.google.android.gms.common.util.zzo.zzb(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x012c, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0149, code lost:
        com.google.android.gms.internal.zzkn.zzdf("No location header to follow redirect.");
        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        r2.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0157, code lost:
        if (r20 == null) goto L_0x0160;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0159, code lost:
        r20.zzcjg.zzsm();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x016c, code lost:
        com.google.android.gms.internal.zzkn.zzdf("Too many redirects.");
        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:?, code lost:
        r2.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x017a, code lost:
        if (r20 == null) goto L_0x0183;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x017c, code lost:
        r20.zzcjg.zzsm();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
        com.google.android.gms.internal.zzkn.zzdf(new java.lang.StringBuilder(46).append("Received error HTTP response code: ").append(r9).toString());
        r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel(0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:?, code lost:
        r2.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01a7, code lost:
        if (r20 == null) goto L_0x01b0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01a9, code lost:
        r20.zzcjg.zzsm();
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:59:0x0115=Splitter:B:59:0x0115, B:94:0x0186=Splitter:B:94:0x0186, B:70:0x0129=Splitter:B:70:0x0129} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.ads.internal.request.AdResponseParcel zza(com.google.android.gms.ads.internal.request.AdRequestInfoParcel r13, android.content.Context r14, java.lang.String r15, java.lang.String r16, java.lang.String r17, com.google.android.gms.internal.zzjg r18, com.google.android.gms.internal.zzdq r19, com.google.android.gms.internal.zzja r20) {
        /*
            if (r19 == 0) goto L_0x00e9
            com.google.android.gms.internal.zzdo r2 = r19.zzla()
            r3 = r2
        L_0x0007:
            com.google.android.gms.internal.zzje r8 = new com.google.android.gms.internal.zzje     // Catch:{ IOException -> 0x00f4 }
            r8.<init>(r13)     // Catch:{ IOException -> 0x00f4 }
            java.lang.String r4 = "AdRequestServiceImpl: Sending request: "
            java.lang.String r2 = java.lang.String.valueOf(r16)     // Catch:{ IOException -> 0x00f4 }
            int r5 = r2.length()     // Catch:{ IOException -> 0x00f4 }
            if (r5 == 0) goto L_0x00ed
            java.lang.String r2 = r4.concat(r2)     // Catch:{ IOException -> 0x00f4 }
        L_0x001c:
            com.google.android.gms.internal.zzkn.zzdd(r2)     // Catch:{ IOException -> 0x00f4 }
            java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x00f4 }
            r0 = r16
            r4.<init>(r0)     // Catch:{ IOException -> 0x00f4 }
            r2 = 0
            com.google.android.gms.common.util.zze r5 = com.google.android.gms.ads.internal.zzu.zzgf()     // Catch:{ IOException -> 0x00f4 }
            long r10 = r5.elapsedRealtime()     // Catch:{ IOException -> 0x00f4 }
            r6 = r2
            r7 = r4
        L_0x0031:
            if (r20 == 0) goto L_0x003a
            r0 = r20
            com.google.android.gms.internal.zzjk r2 = r0.zzcjg     // Catch:{ IOException -> 0x00f4 }
            r2.zzsl()     // Catch:{ IOException -> 0x00f4 }
        L_0x003a:
            java.net.URLConnection r2 = r7.openConnection()     // Catch:{ IOException -> 0x00f4 }
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00f4 }
            com.google.android.gms.internal.zzkr r4 = com.google.android.gms.ads.internal.zzu.zzfz()     // Catch:{ all -> 0x0119 }
            r5 = 0
            r4.zza((android.content.Context) r14, (java.lang.String) r15, (boolean) r5, (java.net.HttpURLConnection) r2)     // Catch:{ all -> 0x0119 }
            boolean r4 = android.text.TextUtils.isEmpty(r17)     // Catch:{ all -> 0x0119 }
            if (r4 != 0) goto L_0x005b
            boolean r4 = r18.zzsi()     // Catch:{ all -> 0x0119 }
            if (r4 == 0) goto L_0x005b
            java.lang.String r4 = "x-afma-drt-cookie"
            r0 = r17
            r2.addRequestProperty(r4, r0)     // Catch:{ all -> 0x0119 }
        L_0x005b:
            java.lang.String r4 = r13.zzcgu     // Catch:{ all -> 0x0119 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0119 }
            if (r5 != 0) goto L_0x006d
            java.lang.String r5 = "Sending webview cookie in ad request header."
            com.google.android.gms.internal.zzkn.zzdd(r5)     // Catch:{ all -> 0x0119 }
            java.lang.String r5 = "Cookie"
            r2.addRequestProperty(r5, r4)     // Catch:{ all -> 0x0119 }
        L_0x006d:
            if (r18 == 0) goto L_0x0099
            java.lang.String r4 = r18.zzsh()     // Catch:{ all -> 0x0119 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0119 }
            if (r4 != 0) goto L_0x0099
            r4 = 1
            r2.setDoOutput(r4)     // Catch:{ all -> 0x0119 }
            java.lang.String r4 = r18.zzsh()     // Catch:{ all -> 0x0119 }
            byte[] r9 = r4.getBytes()     // Catch:{ all -> 0x0119 }
            int r4 = r9.length     // Catch:{ all -> 0x0119 }
            r2.setFixedLengthStreamingMode(r4)     // Catch:{ all -> 0x0119 }
            r5 = 0
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0113 }
            java.io.OutputStream r12 = r2.getOutputStream()     // Catch:{ all -> 0x0113 }
            r4.<init>(r12)     // Catch:{ all -> 0x0113 }
            r4.write(r9)     // Catch:{ all -> 0x01d0 }
            com.google.android.gms.common.util.zzo.zzb(r4)     // Catch:{ all -> 0x0119 }
        L_0x0099:
            int r9 = r2.getResponseCode()     // Catch:{ all -> 0x0119 }
            java.util.Map r12 = r2.getHeaderFields()     // Catch:{ all -> 0x0119 }
            r4 = 200(0xc8, float:2.8E-43)
            if (r9 < r4) goto L_0x012d
            r4 = 300(0x12c, float:4.2E-43)
            if (r9 >= r4) goto L_0x012d
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x0119 }
            r5 = 0
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ all -> 0x0127 }
            java.io.InputStream r7 = r2.getInputStream()     // Catch:{ all -> 0x0127 }
            r4.<init>(r7)     // Catch:{ all -> 0x0127 }
            com.google.android.gms.internal.zzkr r5 = com.google.android.gms.ads.internal.zzu.zzfz()     // Catch:{ all -> 0x01cd }
            java.lang.String r5 = r5.zza((java.io.InputStreamReader) r4)     // Catch:{ all -> 0x01cd }
            com.google.android.gms.common.util.zzo.zzb(r4)     // Catch:{ all -> 0x0119 }
            zza(r6, r12, r5, r9)     // Catch:{ all -> 0x0119 }
            r8.zzb(r6, r12, r5)     // Catch:{ all -> 0x0119 }
            if (r19 == 0) goto L_0x00d7
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ all -> 0x0119 }
            r5 = 0
            java.lang.String r6 = "ufe"
            r4[r5] = r6     // Catch:{ all -> 0x0119 }
            r0 = r19
            r0.zza(r3, r4)     // Catch:{ all -> 0x0119 }
        L_0x00d7:
            com.google.android.gms.ads.internal.request.AdResponseParcel r3 = r8.zzj((long) r10)     // Catch:{ all -> 0x0119 }
            r2.disconnect()     // Catch:{ IOException -> 0x00f4 }
            if (r20 == 0) goto L_0x00e7
            r0 = r20
            com.google.android.gms.internal.zzjk r2 = r0.zzcjg     // Catch:{ IOException -> 0x00f4 }
            r2.zzsm()     // Catch:{ IOException -> 0x00f4 }
        L_0x00e7:
            r2 = r3
        L_0x00e8:
            return r2
        L_0x00e9:
            r2 = 0
            r3 = r2
            goto L_0x0007
        L_0x00ed:
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x00f4 }
            r2.<init>(r4)     // Catch:{ IOException -> 0x00f4 }
            goto L_0x001c
        L_0x00f4:
            r2 = move-exception
            java.lang.String r3 = "Error while connecting to ad server: "
            java.lang.String r2 = r2.getMessage()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r4 = r2.length()
            if (r4 == 0) goto L_0x01c6
            java.lang.String r2 = r3.concat(r2)
        L_0x0109:
            com.google.android.gms.internal.zzkn.zzdf(r2)
            com.google.android.gms.ads.internal.request.AdResponseParcel r2 = new com.google.android.gms.ads.internal.request.AdResponseParcel
            r3 = 2
            r2.<init>(r3)
            goto L_0x00e8
        L_0x0113:
            r3 = move-exception
            r4 = r5
        L_0x0115:
            com.google.android.gms.common.util.zzo.zzb(r4)     // Catch:{ all -> 0x0119 }
            throw r3     // Catch:{ all -> 0x0119 }
        L_0x0119:
            r3 = move-exception
            r2.disconnect()     // Catch:{ IOException -> 0x00f4 }
            if (r20 == 0) goto L_0x0126
            r0 = r20
            com.google.android.gms.internal.zzjk r2 = r0.zzcjg     // Catch:{ IOException -> 0x00f4 }
            r2.zzsm()     // Catch:{ IOException -> 0x00f4 }
        L_0x0126:
            throw r3     // Catch:{ IOException -> 0x00f4 }
        L_0x0127:
            r3 = move-exception
            r4 = r5
        L_0x0129:
            com.google.android.gms.common.util.zzo.zzb(r4)     // Catch:{ all -> 0x0119 }
            throw r3     // Catch:{ all -> 0x0119 }
        L_0x012d:
            java.lang.String r4 = r7.toString()     // Catch:{ all -> 0x0119 }
            r5 = 0
            zza(r4, r12, r5, r9)     // Catch:{ all -> 0x0119 }
            r4 = 300(0x12c, float:4.2E-43)
            if (r9 < r4) goto L_0x0186
            r4 = 400(0x190, float:5.6E-43)
            if (r9 >= r4) goto L_0x0186
            java.lang.String r4 = "Location"
            java.lang.String r4 = r2.getHeaderField(r4)     // Catch:{ all -> 0x0119 }
            boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x0119 }
            if (r5 == 0) goto L_0x0162
            java.lang.String r3 = "No location header to follow redirect."
            com.google.android.gms.internal.zzkn.zzdf(r3)     // Catch:{ all -> 0x0119 }
            com.google.android.gms.ads.internal.request.AdResponseParcel r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ all -> 0x0119 }
            r4 = 0
            r3.<init>(r4)     // Catch:{ all -> 0x0119 }
            r2.disconnect()     // Catch:{ IOException -> 0x00f4 }
            if (r20 == 0) goto L_0x0160
            r0 = r20
            com.google.android.gms.internal.zzjk r2 = r0.zzcjg     // Catch:{ IOException -> 0x00f4 }
            r2.zzsm()     // Catch:{ IOException -> 0x00f4 }
        L_0x0160:
            r2 = r3
            goto L_0x00e8
        L_0x0162:
            java.net.URL r5 = new java.net.URL     // Catch:{ all -> 0x0119 }
            r5.<init>(r4)     // Catch:{ all -> 0x0119 }
            int r4 = r6 + 1
            r6 = 5
            if (r4 <= r6) goto L_0x01b3
            java.lang.String r3 = "Too many redirects."
            com.google.android.gms.internal.zzkn.zzdf(r3)     // Catch:{ all -> 0x0119 }
            com.google.android.gms.ads.internal.request.AdResponseParcel r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ all -> 0x0119 }
            r4 = 0
            r3.<init>(r4)     // Catch:{ all -> 0x0119 }
            r2.disconnect()     // Catch:{ IOException -> 0x00f4 }
            if (r20 == 0) goto L_0x0183
            r0 = r20
            com.google.android.gms.internal.zzjk r2 = r0.zzcjg     // Catch:{ IOException -> 0x00f4 }
            r2.zzsm()     // Catch:{ IOException -> 0x00f4 }
        L_0x0183:
            r2 = r3
            goto L_0x00e8
        L_0x0186:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0119 }
            r4 = 46
            r3.<init>(r4)     // Catch:{ all -> 0x0119 }
            java.lang.String r4 = "Received error HTTP response code: "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x0119 }
            java.lang.StringBuilder r3 = r3.append(r9)     // Catch:{ all -> 0x0119 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0119 }
            com.google.android.gms.internal.zzkn.zzdf(r3)     // Catch:{ all -> 0x0119 }
            com.google.android.gms.ads.internal.request.AdResponseParcel r3 = new com.google.android.gms.ads.internal.request.AdResponseParcel     // Catch:{ all -> 0x0119 }
            r4 = 0
            r3.<init>(r4)     // Catch:{ all -> 0x0119 }
            r2.disconnect()     // Catch:{ IOException -> 0x00f4 }
            if (r20 == 0) goto L_0x01b0
            r0 = r20
            com.google.android.gms.internal.zzjk r2 = r0.zzcjg     // Catch:{ IOException -> 0x00f4 }
            r2.zzsm()     // Catch:{ IOException -> 0x00f4 }
        L_0x01b0:
            r2 = r3
            goto L_0x00e8
        L_0x01b3:
            r8.zzj((java.util.Map<java.lang.String, java.util.List<java.lang.String>>) r12)     // Catch:{ all -> 0x0119 }
            r2.disconnect()     // Catch:{ IOException -> 0x00f4 }
            if (r20 == 0) goto L_0x01c2
            r0 = r20
            com.google.android.gms.internal.zzjk r2 = r0.zzcjg     // Catch:{ IOException -> 0x00f4 }
            r2.zzsm()     // Catch:{ IOException -> 0x00f4 }
        L_0x01c2:
            r6 = r4
            r7 = r5
            goto L_0x0031
        L_0x01c6:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r3)
            goto L_0x0109
        L_0x01cd:
            r3 = move-exception
            goto L_0x0129
        L_0x01d0:
            r3 = move-exception
            goto L_0x0115
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzjb.zza(com.google.android.gms.ads.internal.request.AdRequestInfoParcel, android.content.Context, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.zzjg, com.google.android.gms.internal.zzdq, com.google.android.gms.internal.zzja):com.google.android.gms.ads.internal.request.AdResponseParcel");
    }

    public static zzjb zza(Context context, zzdb zzdb, zzja zzja) {
        zzjb zzjb;
        synchronized (zzaok) {
            if (zzcjk == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                zzcjk = new zzjb(context, zzdb, zzja);
            }
            zzjb = zzcjk;
        }
        return zzjb;
    }

    private static void zza(String str, Map<String, List<String>> map, String str2, int i) {
        if (zzkn.zzbf(2)) {
            zzkn.m1493v(new StringBuilder(String.valueOf(str).length() + 39).append("Http Response: {\n  URL:\n    ").append(str).append("\n  Headers:").toString());
            if (map != null) {
                for (String next : map.keySet()) {
                    zzkn.m1493v(new StringBuilder(String.valueOf(next).length() + 5).append("    ").append(next).append(":").toString());
                    for (String valueOf : map.get(next)) {
                        String valueOf2 = String.valueOf(valueOf);
                        zzkn.m1493v(valueOf2.length() != 0 ? "      ".concat(valueOf2) : new String("      "));
                    }
                }
            }
            zzkn.m1493v("  Body:");
            if (str2 != null) {
                for (int i2 = 0; i2 < Math.min(str2.length(), 100000); i2 += AdError.NETWORK_ERROR_CODE) {
                    zzkn.m1493v(str2.substring(i2, Math.min(str2.length(), i2 + AdError.NETWORK_ERROR_CODE)));
                }
            } else {
                zzkn.m1493v("    null");
            }
            zzkn.m1493v(new StringBuilder(34).append("  Response Code:\n    ").append(i).append("\n}").toString());
        }
    }

    private static Location zzc(zzlj<Location> zzlj) {
        try {
            return (Location) zzlj.get(zzdi.zzbgm.get().longValue(), TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            zzkn.zzd("Exception caught while getting location", e);
            return null;
        }
    }

    private static Bundle zzd(zzlj<Bundle> zzlj) {
        Bundle bundle = new Bundle();
        try {
            return (Bundle) zzlj.get(zzdi.zzbhd.get().longValue(), TimeUnit.MILLISECONDS);
        } catch (Exception e) {
            zzkn.zzd("Exception caught while getting parental controls.", e);
            return bundle;
        }
    }

    public void zza(final AdRequestInfoParcel adRequestInfoParcel, final zzl zzl) {
        zzu.zzgd().zzb(this.mContext, adRequestInfoParcel.zzaqv);
        zzkq.zza((Runnable) new Runnable() {
            public void run() {
                AdResponseParcel adResponseParcel;
                try {
                    adResponseParcel = zzjb.this.zzd(adRequestInfoParcel);
                } catch (Exception e) {
                    zzu.zzgd().zza((Throwable) e, "AdRequestServiceImpl.loadAdAsync");
                    zzkn.zzd("Could not fetch ad response due to an Exception.", e);
                    adResponseParcel = null;
                }
                if (adResponseParcel == null) {
                    adResponseParcel = new AdResponseParcel(0);
                }
                try {
                    zzl.zzb(adResponseParcel);
                } catch (RemoteException e2) {
                    zzkn.zzd("Fail to forward ad response.", e2);
                }
            }
        });
    }

    public AdResponseParcel zzd(AdRequestInfoParcel adRequestInfoParcel) {
        return zza(this.mContext, this.zzcjn, this.zzcjm, this.zzcjl, adRequestInfoParcel);
    }
}
