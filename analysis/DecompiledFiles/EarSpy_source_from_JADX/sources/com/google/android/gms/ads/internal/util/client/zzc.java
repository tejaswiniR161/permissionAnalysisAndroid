package com.google.android.gms.ads.internal.util.client;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.internal.zziy;

@zziy
public class zzc implements zza.C1268zza {
    @Nullable
    private final String zzbnw;

    public zzc() {
        this((String) null);
    }

    public zzc(@Nullable String str) {
        this.zzbnw = str;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzcy(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r1 = "Pinging URL: "
            java.lang.String r0 = java.lang.String.valueOf(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0068, IOException -> 0x00aa, RuntimeException -> 0x00e8 }
            int r2 = r0.length()     // Catch:{ IndexOutOfBoundsException -> 0x0068, IOException -> 0x00aa, RuntimeException -> 0x00e8 }
            if (r2 == 0) goto L_0x0062
            java.lang.String r0 = r1.concat(r0)     // Catch:{ IndexOutOfBoundsException -> 0x0068, IOException -> 0x00aa, RuntimeException -> 0x00e8 }
        L_0x0010:
            com.google.android.gms.ads.internal.util.client.zzb.zzdd(r0)     // Catch:{ IndexOutOfBoundsException -> 0x0068, IOException -> 0x00aa, RuntimeException -> 0x00e8 }
            java.net.URL r0 = new java.net.URL     // Catch:{ IndexOutOfBoundsException -> 0x0068, IOException -> 0x00aa, RuntimeException -> 0x00e8 }
            r0.<init>(r5)     // Catch:{ IndexOutOfBoundsException -> 0x0068, IOException -> 0x00aa, RuntimeException -> 0x00e8 }
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ IndexOutOfBoundsException -> 0x0068, IOException -> 0x00aa, RuntimeException -> 0x00e8 }
            java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IndexOutOfBoundsException -> 0x0068, IOException -> 0x00aa, RuntimeException -> 0x00e8 }
            com.google.android.gms.ads.internal.util.client.zza r1 = com.google.android.gms.ads.internal.client.zzm.zzjr()     // Catch:{ all -> 0x00a5 }
            r2 = 1
            java.lang.String r3 = r4.zzbnw     // Catch:{ all -> 0x00a5 }
            r1.zza((boolean) r2, (java.net.HttpURLConnection) r0, (java.lang.String) r3)     // Catch:{ all -> 0x00a5 }
            int r1 = r0.getResponseCode()     // Catch:{ all -> 0x00a5 }
            r2 = 200(0xc8, float:2.8E-43)
            if (r1 < r2) goto L_0x0034
            r2 = 300(0x12c, float:4.2E-43)
            if (r1 < r2) goto L_0x005e
        L_0x0034:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a5 }
            java.lang.String r3 = java.lang.String.valueOf(r5)     // Catch:{ all -> 0x00a5 }
            int r3 = r3.length()     // Catch:{ all -> 0x00a5 }
            int r3 = r3 + 65
            r2.<init>(r3)     // Catch:{ all -> 0x00a5 }
            java.lang.String r3 = "Received non-success response code "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x00a5 }
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ all -> 0x00a5 }
            java.lang.String r2 = " from pinging URL: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x00a5 }
            java.lang.StringBuilder r1 = r1.append(r5)     // Catch:{ all -> 0x00a5 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00a5 }
            com.google.android.gms.ads.internal.util.client.zzb.zzdf(r1)     // Catch:{ all -> 0x00a5 }
        L_0x005e:
            r0.disconnect()     // Catch:{ IndexOutOfBoundsException -> 0x0068, IOException -> 0x00aa, RuntimeException -> 0x00e8 }
        L_0x0061:
            return
        L_0x0062:
            java.lang.String r0 = new java.lang.String     // Catch:{ IndexOutOfBoundsException -> 0x0068, IOException -> 0x00aa, RuntimeException -> 0x00e8 }
            r0.<init>(r1)     // Catch:{ IndexOutOfBoundsException -> 0x0068, IOException -> 0x00aa, RuntimeException -> 0x00e8 }
            goto L_0x0010
        L_0x0068:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = java.lang.String.valueOf(r5)
            int r2 = r2.length()
            int r2 = r2 + 32
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            int r2 = r2 + r3
            r1.<init>(r2)
            java.lang.String r2 = "Error while parsing ping URL: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.String r2 = ". "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.ads.internal.util.client.zzb.zzdf(r0)
            goto L_0x0061
        L_0x00a5:
            r1 = move-exception
            r0.disconnect()     // Catch:{ IndexOutOfBoundsException -> 0x0068, IOException -> 0x00aa, RuntimeException -> 0x00e8 }
            throw r1     // Catch:{ IndexOutOfBoundsException -> 0x0068, IOException -> 0x00aa, RuntimeException -> 0x00e8 }
        L_0x00aa:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = java.lang.String.valueOf(r5)
            int r2 = r2.length()
            int r2 = r2 + 27
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            int r2 = r2 + r3
            r1.<init>(r2)
            java.lang.String r2 = "Error while pinging URL: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.String r2 = ". "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.ads.internal.util.client.zzb.zzdf(r0)
            goto L_0x0061
        L_0x00e8:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = java.lang.String.valueOf(r5)
            int r2 = r2.length()
            int r2 = r2 + 27
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            int r2 = r2 + r3
            r1.<init>(r2)
            java.lang.String r2 = "Error while pinging URL: "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.String r2 = ". "
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.ads.internal.util.client.zzb.zzdf(r0)
            goto L_0x0061
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.client.zzc.zzcy(java.lang.String):void");
    }
}
