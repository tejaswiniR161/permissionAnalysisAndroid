package com.google.android.gms.internal;

import android.os.SystemClock;
import com.google.android.gms.internal.zzb;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class zzv implements zzb {
    private final Map<String, zza> zzbw;
    private long zzbx;
    private final File zzby;
    private final int zzbz;

    static class zza {
        public String zza;
        public long zzb;
        public long zzc;
        public long zzca;
        public String zzcb;
        public long zzd;
        public long zze;
        public Map<String, String> zzf;

        private zza() {
        }

        public zza(String str, zzb.zza zza2) {
            this.zzcb = str;
            this.zzca = (long) zza2.data.length;
            this.zza = zza2.zza;
            this.zzb = zza2.zzb;
            this.zzc = zza2.zzc;
            this.zzd = zza2.zzd;
            this.zze = zza2.zze;
            this.zzf = zza2.zzf;
        }

        public static zza zzf(InputStream inputStream) throws IOException {
            zza zza2 = new zza();
            if (zzv.zzb(inputStream) != 538247942) {
                throw new IOException();
            }
            zza2.zzcb = zzv.zzd(inputStream);
            zza2.zza = zzv.zzd(inputStream);
            if (zza2.zza.equals("")) {
                zza2.zza = null;
            }
            zza2.zzb = zzv.zzc(inputStream);
            zza2.zzc = zzv.zzc(inputStream);
            zza2.zzd = zzv.zzc(inputStream);
            zza2.zze = zzv.zzc(inputStream);
            zza2.zzf = zzv.zze(inputStream);
            return zza2;
        }

        public boolean zza(OutputStream outputStream) {
            try {
                zzv.zza(outputStream, 538247942);
                zzv.zza(outputStream, this.zzcb);
                zzv.zza(outputStream, this.zza == null ? "" : this.zza);
                zzv.zza(outputStream, this.zzb);
                zzv.zza(outputStream, this.zzc);
                zzv.zza(outputStream, this.zzd);
                zzv.zza(outputStream, this.zze);
                zzv.zza(this.zzf, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException e) {
                zzs.zzb("%s", e.toString());
                return false;
            }
        }

        public zzb.zza zzb(byte[] bArr) {
            zzb.zza zza2 = new zzb.zza();
            zza2.data = bArr;
            zza2.zza = this.zza;
            zza2.zzb = this.zzb;
            zza2.zzc = this.zzc;
            zza2.zzd = this.zzd;
            zza2.zze = this.zze;
            zza2.zzf = this.zzf;
            return zza2;
        }
    }

    private static class zzb extends FilterInputStream {
        /* access modifiers changed from: private */
        public int zzcc;

        private zzb(InputStream inputStream) {
            super(inputStream);
            this.zzcc = 0;
        }

        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.zzcc++;
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.zzcc += read;
            }
            return read;
        }
    }

    public zzv(File file) {
        this(file, 5242880);
    }

    public zzv(File file, int i) {
        this.zzbw = new LinkedHashMap(16, 0.75f, true);
        this.zzbx = 0;
        this.zzby = file;
        this.zzbz = i;
    }

    private void removeEntry(String str) {
        zza zza2 = this.zzbw.get(str);
        if (zza2 != null) {
            this.zzbx -= zza2.zzca;
            this.zzbw.remove(str);
        }
    }

    private static int zza(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    static void zza(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    static void zza(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) (j >>> 0)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    static void zza(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        zza(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    private void zza(String str, zza zza2) {
        if (!this.zzbw.containsKey(str)) {
            this.zzbx += zza2.zzca;
        } else {
            this.zzbx = (zza2.zzca - this.zzbw.get(str).zzca) + this.zzbx;
        }
        this.zzbw.put(str, zza2);
    }

    static void zza(Map<String, String> map, OutputStream outputStream) throws IOException {
        if (map != null) {
            zza(outputStream, map.size());
            for (Map.Entry next : map.entrySet()) {
                zza(outputStream, (String) next.getKey());
                zza(outputStream, (String) next.getValue());
            }
            return;
        }
        zza(outputStream, 0);
    }

    private static byte[] zza(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException(new StringBuilder(50).append("Expected ").append(i).append(" bytes, read ").append(i2).append(" bytes").toString());
    }

    static int zzb(InputStream inputStream) throws IOException {
        return (zza(inputStream) << 0) | 0 | (zza(inputStream) << 8) | (zza(inputStream) << 16) | (zza(inputStream) << 24);
    }

    static long zzc(InputStream inputStream) throws IOException {
        return 0 | ((((long) zza(inputStream)) & 255) << 0) | ((((long) zza(inputStream)) & 255) << 8) | ((((long) zza(inputStream)) & 255) << 16) | ((((long) zza(inputStream)) & 255) << 24) | ((((long) zza(inputStream)) & 255) << 32) | ((((long) zza(inputStream)) & 255) << 40) | ((((long) zza(inputStream)) & 255) << 48) | ((((long) zza(inputStream)) & 255) << 56);
    }

    private void zzc(int i) {
        int i2;
        if (this.zzbx + ((long) i) >= ((long) this.zzbz)) {
            if (zzs.DEBUG) {
                zzs.zza("Pruning old cache entries.", new Object[0]);
            }
            long j = this.zzbx;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            Iterator<Map.Entry<String, zza>> it = this.zzbw.entrySet().iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i2 = i3;
                    break;
                }
                zza zza2 = (zza) it.next().getValue();
                if (zzf(zza2.zzcb).delete()) {
                    this.zzbx -= zza2.zzca;
                } else {
                    zzs.zzb("Could not delete cache entry for key=%s, filename=%s", zza2.zzcb, zze(zza2.zzcb));
                }
                it.remove();
                i2 = i3 + 1;
                if (((float) (this.zzbx + ((long) i))) < ((float) this.zzbz) * 0.9f) {
                    break;
                }
                i3 = i2;
            }
            if (zzs.DEBUG) {
                zzs.zza("pruned %d files, %d bytes, %d ms", Integer.valueOf(i2), Long.valueOf(this.zzbx - j), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime));
            }
        }
    }

    static String zzd(InputStream inputStream) throws IOException {
        return new String(zza(inputStream, (int) zzc(inputStream)), "UTF-8");
    }

    private String zze(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(String.valueOf(str.substring(0, length).hashCode()));
        String valueOf2 = String.valueOf(String.valueOf(str.substring(length).hashCode()));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    static Map<String, String> zze(InputStream inputStream) throws IOException {
        int zzb2 = zzb(inputStream);
        Map<String, String> emptyMap = zzb2 == 0 ? Collections.emptyMap() : new HashMap<>(zzb2);
        for (int i = 0; i < zzb2; i++) {
            emptyMap.put(zzd(inputStream).intern(), zzd(inputStream).intern());
        }
        return emptyMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005a A[SYNTHETIC, Splitter:B:28:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005f A[SYNTHETIC, Splitter:B:31:0x005f] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0068 A[SYNTHETIC, Splitter:B:36:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0052 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void initialize() {
        /*
            r9 = this;
            r0 = 0
            monitor-enter(r9)
            java.io.File r1 = r9.zzby     // Catch:{ all -> 0x006c }
            boolean r1 = r1.exists()     // Catch:{ all -> 0x006c }
            if (r1 != 0) goto L_0x0025
            java.io.File r0 = r9.zzby     // Catch:{ all -> 0x006c }
            boolean r0 = r0.mkdirs()     // Catch:{ all -> 0x006c }
            if (r0 != 0) goto L_0x0023
            java.lang.String r0 = "Unable to create cache dir %s"
            r1 = 1
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x006c }
            r2 = 0
            java.io.File r3 = r9.zzby     // Catch:{ all -> 0x006c }
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x006c }
            r1[r2] = r3     // Catch:{ all -> 0x006c }
            com.google.android.gms.internal.zzs.zzc(r0, r1)     // Catch:{ all -> 0x006c }
        L_0x0023:
            monitor-exit(r9)
            return
        L_0x0025:
            java.io.File r1 = r9.zzby     // Catch:{ all -> 0x006c }
            java.io.File[] r3 = r1.listFiles()     // Catch:{ all -> 0x006c }
            if (r3 == 0) goto L_0x0023
            int r4 = r3.length     // Catch:{ all -> 0x006c }
            r2 = r0
        L_0x002f:
            if (r2 >= r4) goto L_0x0023
            r5 = r3[r2]     // Catch:{ all -> 0x006c }
            r1 = 0
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0056, all -> 0x0065 }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0056, all -> 0x0065 }
            r6.<init>(r5)     // Catch:{ IOException -> 0x0056, all -> 0x0065 }
            r0.<init>(r6)     // Catch:{ IOException -> 0x0056, all -> 0x0065 }
            com.google.android.gms.internal.zzv$zza r1 = com.google.android.gms.internal.zzv.zza.zzf(r0)     // Catch:{ IOException -> 0x0078 }
            long r6 = r5.length()     // Catch:{ IOException -> 0x0078 }
            r1.zzca = r6     // Catch:{ IOException -> 0x0078 }
            java.lang.String r6 = r1.zzcb     // Catch:{ IOException -> 0x0078 }
            r9.zza((java.lang.String) r6, (com.google.android.gms.internal.zzv.zza) r1)     // Catch:{ IOException -> 0x0078 }
            if (r0 == 0) goto L_0x0052
            r0.close()     // Catch:{ IOException -> 0x006f }
        L_0x0052:
            int r0 = r2 + 1
            r2 = r0
            goto L_0x002f
        L_0x0056:
            r0 = move-exception
            r0 = r1
        L_0x0058:
            if (r5 == 0) goto L_0x005d
            r5.delete()     // Catch:{ all -> 0x0073 }
        L_0x005d:
            if (r0 == 0) goto L_0x0052
            r0.close()     // Catch:{ IOException -> 0x0063 }
            goto L_0x0052
        L_0x0063:
            r0 = move-exception
            goto L_0x0052
        L_0x0065:
            r0 = move-exception
        L_0x0066:
            if (r1 == 0) goto L_0x006b
            r1.close()     // Catch:{ IOException -> 0x0071 }
        L_0x006b:
            throw r0     // Catch:{ all -> 0x006c }
        L_0x006c:
            r0 = move-exception
            monitor-exit(r9)
            throw r0
        L_0x006f:
            r0 = move-exception
            goto L_0x0052
        L_0x0071:
            r1 = move-exception
            goto L_0x006b
        L_0x0073:
            r1 = move-exception
            r8 = r1
            r1 = r0
            r0 = r8
            goto L_0x0066
        L_0x0078:
            r1 = move-exception
            goto L_0x0058
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzv.initialize():void");
    }

    public synchronized void remove(String str) {
        boolean delete = zzf(str).delete();
        removeEntry(str);
        if (!delete) {
            zzs.zzb("Could not delete cache entry for key=%s, filename=%s", str, zze(str));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0066 A[SYNTHETIC, Splitter:B:33:0x0066] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.google.android.gms.internal.zzb.zza zza(java.lang.String r9) {
        /*
            r8 = this;
            r1 = 0
            monitor-enter(r8)
            java.util.Map<java.lang.String, com.google.android.gms.internal.zzv$zza> r0 = r8.zzbw     // Catch:{ all -> 0x006a }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ all -> 0x006a }
            com.google.android.gms.internal.zzv$zza r0 = (com.google.android.gms.internal.zzv.zza) r0     // Catch:{ all -> 0x006a }
            if (r0 != 0) goto L_0x000f
            r0 = r1
        L_0x000d:
            monitor-exit(r8)
            return r0
        L_0x000f:
            java.io.File r3 = r8.zzf(r9)     // Catch:{ all -> 0x006a }
            com.google.android.gms.internal.zzv$zzb r2 = new com.google.android.gms.internal.zzv$zzb     // Catch:{ IOException -> 0x003d, all -> 0x0062 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ IOException -> 0x003d, all -> 0x0062 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x003d, all -> 0x0062 }
            r5 = 0
            r2.<init>(r4)     // Catch:{ IOException -> 0x003d, all -> 0x0062 }
            com.google.android.gms.internal.zzv.zza.zzf(r2)     // Catch:{ IOException -> 0x0072 }
            long r4 = r3.length()     // Catch:{ IOException -> 0x0072 }
            int r6 = r2.zzcc     // Catch:{ IOException -> 0x0072 }
            long r6 = (long) r6     // Catch:{ IOException -> 0x0072 }
            long r4 = r4 - r6
            int r4 = (int) r4     // Catch:{ IOException -> 0x0072 }
            byte[] r4 = zza((java.io.InputStream) r2, (int) r4)     // Catch:{ IOException -> 0x0072 }
            com.google.android.gms.internal.zzb$zza r0 = r0.zzb(r4)     // Catch:{ IOException -> 0x0072 }
            if (r2 == 0) goto L_0x000d
            r2.close()     // Catch:{ IOException -> 0x003a }
            goto L_0x000d
        L_0x003a:
            r0 = move-exception
            r0 = r1
            goto L_0x000d
        L_0x003d:
            r0 = move-exception
            r2 = r1
        L_0x003f:
            java.lang.String r4 = "%s: %s"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0070 }
            r6 = 0
            java.lang.String r3 = r3.getAbsolutePath()     // Catch:{ all -> 0x0070 }
            r5[r6] = r3     // Catch:{ all -> 0x0070 }
            r3 = 1
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0070 }
            r5[r3] = r0     // Catch:{ all -> 0x0070 }
            com.google.android.gms.internal.zzs.zzb(r4, r5)     // Catch:{ all -> 0x0070 }
            r8.remove(r9)     // Catch:{ all -> 0x0070 }
            if (r2 == 0) goto L_0x005d
            r2.close()     // Catch:{ IOException -> 0x005f }
        L_0x005d:
            r0 = r1
            goto L_0x000d
        L_0x005f:
            r0 = move-exception
            r0 = r1
            goto L_0x000d
        L_0x0062:
            r0 = move-exception
            r2 = r1
        L_0x0064:
            if (r2 == 0) goto L_0x0069
            r2.close()     // Catch:{ IOException -> 0x006d }
        L_0x0069:
            throw r0     // Catch:{ all -> 0x006a }
        L_0x006a:
            r0 = move-exception
            monitor-exit(r8)
            throw r0
        L_0x006d:
            r0 = move-exception
            r0 = r1
            goto L_0x000d
        L_0x0070:
            r0 = move-exception
            goto L_0x0064
        L_0x0072:
            r0 = move-exception
            goto L_0x003f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzv.zza(java.lang.String):com.google.android.gms.internal.zzb$zza");
    }

    public synchronized void zza(String str, zzb.zza zza2) {
        zzc(zza2.data.length);
        File zzf = zzf(str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(zzf);
            zza zza3 = new zza(str, zza2);
            if (!zza3.zza(fileOutputStream)) {
                fileOutputStream.close();
                zzs.zzb("Failed to write header for %s", zzf.getAbsolutePath());
                throw new IOException();
            }
            fileOutputStream.write(zza2.data);
            fileOutputStream.close();
            zza(str, zza3);
        } catch (IOException e) {
            if (!zzf.delete()) {
                zzs.zzb("Could not clean up file %s", zzf.getAbsolutePath());
            }
        }
    }

    public File zzf(String str) {
        return new File(this.zzby, zze(str));
    }
}
