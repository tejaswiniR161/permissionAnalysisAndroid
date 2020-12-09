package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzu;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

@zziy
public class zzdk {
    final Context mContext;
    final String zzati;
    String zzbhz;
    BlockingQueue<zzdq> zzbib;
    ExecutorService zzbic;
    LinkedHashMap<String, String> zzbid = new LinkedHashMap<>();
    Map<String, zzdn> zzbie = new HashMap();
    private AtomicBoolean zzbif;
    private File zzbig;

    public zzdk(Context context, String str, String str2, Map<String, String> map) {
        File externalStorageDirectory;
        this.mContext = context;
        this.zzati = str;
        this.zzbhz = str2;
        this.zzbif = new AtomicBoolean(false);
        this.zzbif.set(zzdi.zzbcc.get().booleanValue());
        if (this.zzbif.get() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null) {
            this.zzbig = new File(externalStorageDirectory, "sdk_csi_data.txt");
        }
        for (Map.Entry next : map.entrySet()) {
            this.zzbid.put((String) next.getKey(), (String) next.getValue());
        }
        this.zzbib = new ArrayBlockingQueue(30);
        this.zzbic = Executors.newSingleThreadExecutor();
        this.zzbic.execute(new Runnable() {
            public void run() {
                zzdk.this.zzkw();
            }
        });
        this.zzbie.put("action", zzdn.zzbij);
        this.zzbie.put("ad_format", zzdn.zzbij);
        this.zzbie.put("e", zzdn.zzbik);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x002b A[SYNTHETIC, Splitter:B:17:0x002b] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003a A[SYNTHETIC, Splitter:B:24:0x003a] */
    /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zzc(@android.support.annotation.Nullable java.io.File r4, java.lang.String r5) {
        /*
            r3 = this;
            if (r4 == 0) goto L_0x0045
            r2 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0022, all -> 0x0036 }
            r0 = 1
            r1.<init>(r4, r0)     // Catch:{ IOException -> 0x0022, all -> 0x0036 }
            byte[] r0 = r5.getBytes()     // Catch:{ IOException -> 0x004d }
            r1.write(r0)     // Catch:{ IOException -> 0x004d }
            r0 = 10
            r1.write(r0)     // Catch:{ IOException -> 0x004d }
            if (r1 == 0) goto L_0x001a
            r1.close()     // Catch:{ IOException -> 0x001b }
        L_0x001a:
            return
        L_0x001b:
            r0 = move-exception
            java.lang.String r1 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.internal.zzkn.zzd(r1, r0)
            goto L_0x001a
        L_0x0022:
            r0 = move-exception
            r1 = r2
        L_0x0024:
            java.lang.String r2 = "CsiReporter: Cannot write to file: sdk_csi_data.txt."
            com.google.android.gms.internal.zzkn.zzd(r2, r0)     // Catch:{ all -> 0x004b }
            if (r1 == 0) goto L_0x001a
            r1.close()     // Catch:{ IOException -> 0x002f }
            goto L_0x001a
        L_0x002f:
            r0 = move-exception
            java.lang.String r1 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.internal.zzkn.zzd(r1, r0)
            goto L_0x001a
        L_0x0036:
            r0 = move-exception
            r1 = r2
        L_0x0038:
            if (r1 == 0) goto L_0x003d
            r1.close()     // Catch:{ IOException -> 0x003e }
        L_0x003d:
            throw r0
        L_0x003e:
            r1 = move-exception
            java.lang.String r2 = "CsiReporter: Cannot close file: sdk_csi_data.txt."
            com.google.android.gms.internal.zzkn.zzd(r2, r1)
            goto L_0x003d
        L_0x0045:
            java.lang.String r0 = "CsiReporter: File doesn't exists. Cannot write CSI data to file."
            com.google.android.gms.internal.zzkn.zzdf(r0)
            goto L_0x001a
        L_0x004b:
            r0 = move-exception
            goto L_0x0038
        L_0x004d:
            r0 = move-exception
            goto L_0x0024
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzdk.zzc(java.io.File, java.lang.String):void");
    }

    private void zzc(Map<String, String> map, String str) {
        String zza = zza(this.zzbhz, map, str);
        if (this.zzbif.get()) {
            zzc(this.zzbig, zza);
        } else {
            zzu.zzfz().zzc(this.mContext, this.zzati, zza);
        }
    }

    /* access modifiers changed from: private */
    public void zzkw() {
        while (true) {
            try {
                zzdq take = this.zzbib.take();
                String zzlc = take.zzlc();
                if (!TextUtils.isEmpty(zzlc)) {
                    zzc(zza(this.zzbid, take.zzm()), zzlc);
                }
            } catch (InterruptedException e) {
                zzkn.zzd("CsiReporter:reporter interrupted", e);
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String zza(String str, Map<String, String> map, @NonNull String str2) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry next : map.entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        StringBuilder sb = new StringBuilder(buildUpon.build().toString());
        sb.append("&").append("it").append("=").append(str2);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> zza(Map<String, String> map, @Nullable Map<String, String> map2) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        if (map2 == null) {
            return linkedHashMap;
        }
        for (Map.Entry next : map2.entrySet()) {
            String str = (String) next.getKey();
            String str2 = (String) linkedHashMap.get(str);
            linkedHashMap.put(str, zzat(str).zzg(str2, (String) next.getValue()));
        }
        return linkedHashMap;
    }

    public boolean zza(zzdq zzdq) {
        return this.zzbib.offer(zzdq);
    }

    public zzdn zzat(String str) {
        zzdn zzdn = this.zzbie.get(str);
        return zzdn != null ? zzdn : zzdn.zzbii;
    }

    public void zzc(@Nullable List<String> list) {
        if (list != null && !list.isEmpty()) {
            this.zzbid.put("e", TextUtils.join(",", list));
        }
    }
}
