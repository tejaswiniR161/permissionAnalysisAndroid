package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.clearcut.zzb;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.zzc;
import com.google.android.gms.gass.internal.zza;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzaw;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzbb {
    private static final String TAG = zzbb.class.getSimpleName();
    protected static final Object zzaia = new Object();
    private static zzc zzaic = null;
    private volatile boolean zzagr = false;
    protected Context zzahn;
    protected Context zzaho;
    private ExecutorService zzahp;
    private DexClassLoader zzahq;
    private zzaw zzahr;
    private byte[] zzahs;
    private volatile AdvertisingIdClient zzaht = null;
    private Future zzahu = null;
    private volatile zzae.zza zzahv = null;
    private Future zzahw = null;
    private zzao zzahx;
    private GoogleApiClient zzahy = null;
    protected boolean zzahz = false;
    protected boolean zzaib = false;
    protected boolean zzaid = false;
    private Map<Pair<String, String>, zzbu> zzaie;

    private zzbb(Context context) {
        this.zzahn = context;
        this.zzaho = context.getApplicationContext();
        this.zzaie = new HashMap();
    }

    public static zzbb zza(Context context, String str, String str2, boolean z) {
        zzbb zzbb = new zzbb(context);
        try {
            if (zzbb.zzc(str, str2, z)) {
                return zzbb;
            }
            return null;
        } catch (zzay e) {
        }
    }

    @NonNull
    private File zza(String str, File file, String str2) throws zzaw.zza, IOException {
        File file2 = new File(String.format("%s/%s.jar", new Object[]{file, str2}));
        if (!file2.exists()) {
            byte[] zzc = this.zzahr.zzc(this.zzahs, str);
            file2.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            fileOutputStream.write(zzc, 0, zzc.length);
            fileOutputStream.close();
        }
        return file2;
    }

    private void zza(File file) {
        if (!file.exists()) {
            Log.d(TAG, String.format("File %s not found. No need for deletion", new Object[]{file.getAbsolutePath()}));
            return;
        }
        file.delete();
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: type inference failed for: r1v15 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00a2 A[SYNTHETIC, Splitter:B:30:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00a7 A[SYNTHETIC, Splitter:B:33:0x00a7] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b3 A[SYNTHETIC, Splitter:B:39:0x00b3] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b8 A[SYNTHETIC, Splitter:B:42:0x00b8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zza(java.io.File r12, java.lang.String r13) {
        /*
            r11 = this;
            r1 = 0
            r7 = 2
            r6 = 1
            r5 = 0
            java.io.File r3 = new java.io.File
            java.lang.String r0 = "%s/%s.tmp"
            java.lang.Object[] r2 = new java.lang.Object[r7]
            r2[r5] = r12
            r2[r6] = r13
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r3.<init>(r0)
            boolean r0 = r3.exists()
            if (r0 == 0) goto L_0x001c
        L_0x001b:
            return
        L_0x001c:
            java.io.File r4 = new java.io.File
            java.lang.String r0 = "%s/%s.dex"
            java.lang.Object[] r2 = new java.lang.Object[r7]
            r2[r5] = r12
            r2[r6] = r13
            java.lang.String r0 = java.lang.String.format(r0, r2)
            r4.<init>(r0)
            boolean r0 = r4.exists()
            if (r0 == 0) goto L_0x001b
            long r6 = r4.length()
            r8 = 0
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x001b
            int r0 = (int) r6
            byte[] r0 = new byte[r0]
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00db, NoSuchAlgorithmException -> 0x009e, zza -> 0x00e5, all -> 0x00af }
            r2.<init>(r4)     // Catch:{ IOException -> 0x00db, NoSuchAlgorithmException -> 0x009e, zza -> 0x00e5, all -> 0x00af }
            int r5 = r2.read(r0)     // Catch:{ IOException -> 0x00de, NoSuchAlgorithmException -> 0x00d4, zza -> 0x00e8, all -> 0x00cd }
            if (r5 > 0) goto L_0x0054
            if (r2 == 0) goto L_0x0050
            r2.close()     // Catch:{ IOException -> 0x00bf }
        L_0x0050:
            r11.zza(r4)
            goto L_0x001b
        L_0x0054:
            com.google.android.gms.internal.zzae$zzd r5 = new com.google.android.gms.internal.zzae$zzd     // Catch:{ IOException -> 0x00de, NoSuchAlgorithmException -> 0x00d4, zza -> 0x00e8, all -> 0x00cd }
            r5.<init>()     // Catch:{ IOException -> 0x00de, NoSuchAlgorithmException -> 0x00d4, zza -> 0x00e8, all -> 0x00cd }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ IOException -> 0x00de, NoSuchAlgorithmException -> 0x00d4, zza -> 0x00e8, all -> 0x00cd }
            byte[] r6 = r6.getBytes()     // Catch:{ IOException -> 0x00de, NoSuchAlgorithmException -> 0x00d4, zza -> 0x00e8, all -> 0x00cd }
            r5.zzft = r6     // Catch:{ IOException -> 0x00de, NoSuchAlgorithmException -> 0x00d4, zza -> 0x00e8, all -> 0x00cd }
            byte[] r6 = r13.getBytes()     // Catch:{ IOException -> 0x00de, NoSuchAlgorithmException -> 0x00d4, zza -> 0x00e8, all -> 0x00cd }
            r5.zzfs = r6     // Catch:{ IOException -> 0x00de, NoSuchAlgorithmException -> 0x00d4, zza -> 0x00e8, all -> 0x00cd }
            com.google.android.gms.internal.zzaw r6 = r11.zzahr     // Catch:{ IOException -> 0x00de, NoSuchAlgorithmException -> 0x00d4, zza -> 0x00e8, all -> 0x00cd }
            byte[] r7 = r11.zzahs     // Catch:{ IOException -> 0x00de, NoSuchAlgorithmException -> 0x00d4, zza -> 0x00e8, all -> 0x00cd }
            java.lang.String r0 = r6.zzd(r7, r0)     // Catch:{ IOException -> 0x00de, NoSuchAlgorithmException -> 0x00d4, zza -> 0x00e8, all -> 0x00cd }
            byte[] r0 = r0.getBytes()     // Catch:{ IOException -> 0x00de, NoSuchAlgorithmException -> 0x00d4, zza -> 0x00e8, all -> 0x00cd }
            r5.data = r0     // Catch:{ IOException -> 0x00de, NoSuchAlgorithmException -> 0x00d4, zza -> 0x00e8, all -> 0x00cd }
            byte[] r0 = com.google.android.gms.internal.zzam.zzg(r0)     // Catch:{ IOException -> 0x00de, NoSuchAlgorithmException -> 0x00d4, zza -> 0x00e8, all -> 0x00cd }
            r5.zzfr = r0     // Catch:{ IOException -> 0x00de, NoSuchAlgorithmException -> 0x00d4, zza -> 0x00e8, all -> 0x00cd }
            r3.createNewFile()     // Catch:{ IOException -> 0x00de, NoSuchAlgorithmException -> 0x00d4, zza -> 0x00e8, all -> 0x00cd }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00de, NoSuchAlgorithmException -> 0x00d4, zza -> 0x00e8, all -> 0x00cd }
            r0.<init>(r3)     // Catch:{ IOException -> 0x00de, NoSuchAlgorithmException -> 0x00d4, zza -> 0x00e8, all -> 0x00cd }
            byte[] r1 = com.google.android.gms.internal.zzark.zzf(r5)     // Catch:{ IOException -> 0x00e2, NoSuchAlgorithmException -> 0x00d8, zza -> 0x00ec, all -> 0x00cf }
            r3 = 0
            int r5 = r1.length     // Catch:{ IOException -> 0x00e2, NoSuchAlgorithmException -> 0x00d8, zza -> 0x00ec, all -> 0x00cf }
            r0.write(r1, r3, r5)     // Catch:{ IOException -> 0x00e2, NoSuchAlgorithmException -> 0x00d8, zza -> 0x00ec, all -> 0x00cf }
            r0.close()     // Catch:{ IOException -> 0x00e2, NoSuchAlgorithmException -> 0x00d8, zza -> 0x00ec, all -> 0x00cf }
            if (r2 == 0) goto L_0x0094
            r2.close()     // Catch:{ IOException -> 0x00c1 }
        L_0x0094:
            if (r0 == 0) goto L_0x0099
            r0.close()     // Catch:{ IOException -> 0x00c3 }
        L_0x0099:
            r11.zza(r4)
            goto L_0x001b
        L_0x009e:
            r0 = move-exception
            r0 = r1
        L_0x00a0:
            if (r1 == 0) goto L_0x00a5
            r1.close()     // Catch:{ IOException -> 0x00c5 }
        L_0x00a5:
            if (r0 == 0) goto L_0x00aa
            r0.close()     // Catch:{ IOException -> 0x00c7 }
        L_0x00aa:
            r11.zza(r4)
            goto L_0x001b
        L_0x00af:
            r0 = move-exception
            r2 = r1
        L_0x00b1:
            if (r2 == 0) goto L_0x00b6
            r2.close()     // Catch:{ IOException -> 0x00c9 }
        L_0x00b6:
            if (r1 == 0) goto L_0x00bb
            r1.close()     // Catch:{ IOException -> 0x00cb }
        L_0x00bb:
            r11.zza(r4)
            throw r0
        L_0x00bf:
            r0 = move-exception
            goto L_0x0050
        L_0x00c1:
            r1 = move-exception
            goto L_0x0094
        L_0x00c3:
            r0 = move-exception
            goto L_0x0099
        L_0x00c5:
            r1 = move-exception
            goto L_0x00a5
        L_0x00c7:
            r0 = move-exception
            goto L_0x00aa
        L_0x00c9:
            r2 = move-exception
            goto L_0x00b6
        L_0x00cb:
            r1 = move-exception
            goto L_0x00bb
        L_0x00cd:
            r0 = move-exception
            goto L_0x00b1
        L_0x00cf:
            r1 = move-exception
            r10 = r1
            r1 = r0
            r0 = r10
            goto L_0x00b1
        L_0x00d4:
            r0 = move-exception
            r0 = r1
            r1 = r2
            goto L_0x00a0
        L_0x00d8:
            r1 = move-exception
            r1 = r2
            goto L_0x00a0
        L_0x00db:
            r0 = move-exception
            r0 = r1
            goto L_0x00a0
        L_0x00de:
            r0 = move-exception
            r0 = r1
            r1 = r2
            goto L_0x00a0
        L_0x00e2:
            r1 = move-exception
            r1 = r2
            goto L_0x00a0
        L_0x00e5:
            r0 = move-exception
            r0 = r1
            goto L_0x00a0
        L_0x00e8:
            r0 = move-exception
            r0 = r1
            r1 = r2
            goto L_0x00a0
        L_0x00ec:
            r1 = move-exception
            r1 = r2
            goto L_0x00a0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbb.zza(java.io.File, java.lang.String):void");
    }

    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r1v3, types: [java.io.FileInputStream] */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ca A[SYNTHETIC, Splitter:B:46:0x00ca] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cf A[SYNTHETIC, Splitter:B:49:0x00cf] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00d9 A[SYNTHETIC, Splitter:B:55:0x00d9] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00de A[SYNTHETIC, Splitter:B:58:0x00de] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean zzb(java.io.File r11, java.lang.String r12) {
        /*
            r10 = this;
            r1 = 0
            r6 = 2
            r0 = 1
            r2 = 0
            java.io.File r3 = new java.io.File
            java.lang.String r4 = "%s/%s.tmp"
            java.lang.Object[] r5 = new java.lang.Object[r6]
            r5[r2] = r11
            r5[r0] = r12
            java.lang.String r4 = java.lang.String.format(r4, r5)
            r3.<init>(r4)
            boolean r4 = r3.exists()
            if (r4 != 0) goto L_0x001d
            r0 = r2
        L_0x001c:
            return r0
        L_0x001d:
            java.io.File r5 = new java.io.File
            java.lang.String r4 = "%s/%s.dex"
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r2] = r11
            r6[r0] = r12
            java.lang.String r4 = java.lang.String.format(r4, r6)
            r5.<init>(r4)
            boolean r4 = r5.exists()
            if (r4 == 0) goto L_0x0036
            r0 = r2
            goto L_0x001c
        L_0x0036:
            long r6 = r3.length()     // Catch:{ IOException -> 0x00fe, NoSuchAlgorithmException -> 0x00c6, zza -> 0x0109, all -> 0x00d5 }
            r8 = 0
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 > 0) goto L_0x0045
            r10.zza(r3)     // Catch:{ IOException -> 0x00fe, NoSuchAlgorithmException -> 0x00c6, zza -> 0x0109, all -> 0x00d5 }
            r0 = r2
            goto L_0x001c
        L_0x0045:
            int r4 = (int) r6     // Catch:{ IOException -> 0x00fe, NoSuchAlgorithmException -> 0x00c6, zza -> 0x0109, all -> 0x00d5 }
            byte[] r6 = new byte[r4]     // Catch:{ IOException -> 0x00fe, NoSuchAlgorithmException -> 0x00c6, zza -> 0x0109, all -> 0x00d5 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ IOException -> 0x00fe, NoSuchAlgorithmException -> 0x00c6, zza -> 0x0109, all -> 0x00d5 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x00fe, NoSuchAlgorithmException -> 0x00c6, zza -> 0x0109, all -> 0x00d5 }
            int r7 = r4.read(r6)     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            if (r7 > 0) goto L_0x0064
            java.lang.String r0 = TAG     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            java.lang.String r5 = "Cannot read the cache data."
            android.util.Log.d(r0, r5)     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            r10.zza(r3)     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            if (r4 == 0) goto L_0x0062
            r4.close()     // Catch:{ IOException -> 0x00e2 }
        L_0x0062:
            r0 = r2
            goto L_0x001c
        L_0x0064:
            com.google.android.gms.internal.zzae$zzd r6 = com.google.android.gms.internal.zzae.zzd.zzd(r6)     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            java.lang.String r7 = new java.lang.String     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            byte[] r8 = r6.zzfs     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            r7.<init>(r8)     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            boolean r7 = r12.equals(r7)     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            if (r7 == 0) goto L_0x0091
            byte[] r7 = r6.zzfr     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            byte[] r8 = r6.data     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            byte[] r8 = com.google.android.gms.internal.zzam.zzg(r8)     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            boolean r7 = java.util.Arrays.equals(r7, r8)     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            if (r7 == 0) goto L_0x0091
            byte[] r7 = r6.zzft     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            java.lang.String r8 = android.os.Build.VERSION.SDK     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            byte[] r8 = r8.getBytes()     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            boolean r7 = java.util.Arrays.equals(r7, r8)     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            if (r7 != 0) goto L_0x009b
        L_0x0091:
            r10.zza(r3)     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            if (r4 == 0) goto L_0x0099
            r4.close()     // Catch:{ IOException -> 0x00e5 }
        L_0x0099:
            r0 = r2
            goto L_0x001c
        L_0x009b:
            com.google.android.gms.internal.zzaw r3 = r10.zzahr     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            byte[] r7 = r10.zzahs     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            java.lang.String r8 = new java.lang.String     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            byte[] r6 = r6.data     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            r8.<init>(r6)     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            byte[] r6 = r3.zzc(r7, r8)     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            r5.createNewFile()     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            r3.<init>(r5)     // Catch:{ IOException -> 0x0101, NoSuchAlgorithmException -> 0x00f6, zza -> 0x010c, all -> 0x00f1 }
            r1 = 0
            int r5 = r6.length     // Catch:{ IOException -> 0x0105, NoSuchAlgorithmException -> 0x00fa, zza -> 0x0110, all -> 0x00f3 }
            r3.write(r6, r1, r5)     // Catch:{ IOException -> 0x0105, NoSuchAlgorithmException -> 0x00fa, zza -> 0x0110, all -> 0x00f3 }
            if (r4 == 0) goto L_0x00bc
            r4.close()     // Catch:{ IOException -> 0x00e7 }
        L_0x00bc:
            if (r3 == 0) goto L_0x001c
            r3.close()     // Catch:{ IOException -> 0x00c3 }
            goto L_0x001c
        L_0x00c3:
            r1 = move-exception
            goto L_0x001c
        L_0x00c6:
            r0 = move-exception
            r0 = r1
        L_0x00c8:
            if (r1 == 0) goto L_0x00cd
            r1.close()     // Catch:{ IOException -> 0x00e9 }
        L_0x00cd:
            if (r0 == 0) goto L_0x00d2
            r0.close()     // Catch:{ IOException -> 0x00eb }
        L_0x00d2:
            r0 = r2
            goto L_0x001c
        L_0x00d5:
            r0 = move-exception
            r4 = r1
        L_0x00d7:
            if (r4 == 0) goto L_0x00dc
            r4.close()     // Catch:{ IOException -> 0x00ed }
        L_0x00dc:
            if (r1 == 0) goto L_0x00e1
            r1.close()     // Catch:{ IOException -> 0x00ef }
        L_0x00e1:
            throw r0
        L_0x00e2:
            r0 = move-exception
            goto L_0x0062
        L_0x00e5:
            r0 = move-exception
            goto L_0x0099
        L_0x00e7:
            r1 = move-exception
            goto L_0x00bc
        L_0x00e9:
            r1 = move-exception
            goto L_0x00cd
        L_0x00eb:
            r0 = move-exception
            goto L_0x00d2
        L_0x00ed:
            r2 = move-exception
            goto L_0x00dc
        L_0x00ef:
            r1 = move-exception
            goto L_0x00e1
        L_0x00f1:
            r0 = move-exception
            goto L_0x00d7
        L_0x00f3:
            r0 = move-exception
            r1 = r3
            goto L_0x00d7
        L_0x00f6:
            r0 = move-exception
            r0 = r1
            r1 = r4
            goto L_0x00c8
        L_0x00fa:
            r0 = move-exception
            r0 = r3
            r1 = r4
            goto L_0x00c8
        L_0x00fe:
            r0 = move-exception
            r0 = r1
            goto L_0x00c8
        L_0x0101:
            r0 = move-exception
            r0 = r1
            r1 = r4
            goto L_0x00c8
        L_0x0105:
            r0 = move-exception
            r0 = r3
            r1 = r4
            goto L_0x00c8
        L_0x0109:
            r0 = move-exception
            r0 = r1
            goto L_0x00c8
        L_0x010c:
            r0 = move-exception
            r0 = r1
            r1 = r4
            goto L_0x00c8
        L_0x0110:
            r0 = move-exception
            r0 = r3
            r1 = r4
            goto L_0x00c8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbb.zzb(java.io.File, java.lang.String):boolean");
    }

    private void zzc(boolean z) {
        this.zzagr = z;
        if (z) {
            this.zzahu = this.zzahp.submit(new Runnable() {
                public void run() {
                    zzbb.this.zzcr();
                }
            });
        }
    }

    private boolean zzc(String str, String str2, boolean z) throws zzay {
        this.zzahp = Executors.newCachedThreadPool();
        zzc(z);
        zzcu();
        zzcs();
        this.zzahr = new zzaw((SecureRandom) null);
        try {
            this.zzahs = this.zzahr.zzn(str);
            boolean zzo = zzo(str2);
            this.zzahx = new zzao(this);
            return zzo;
        } catch (zzaw.zza e) {
            throw new zzay(e);
        }
    }

    /* access modifiers changed from: private */
    public void zzcr() {
        try {
            if (this.zzaht == null && this.zzaho != null) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zzaho);
                advertisingIdClient.start();
                this.zzaht = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException e) {
            this.zzaht = null;
        }
    }

    /* access modifiers changed from: private */
    public void zzct() {
        if (this.zzaib) {
            try {
                this.zzahv = zza.zzi(this.zzahn, this.zzahn.getPackageName(), Integer.toString(this.zzahn.getPackageManager().getPackageInfo(this.zzahn.getPackageName(), 0).versionCode));
            } catch (PackageManager.NameNotFoundException e) {
            }
        }
    }

    private void zzcu() {
        boolean z = true;
        zzaic = zzc.zzapd();
        this.zzahz = zzaic.zzbo(this.zzahn) > 0;
        if (zzaic.isGooglePlayServicesAvailable(this.zzahn) != 0) {
            z = false;
        }
        this.zzaib = z;
        if (this.zzahn.getApplicationContext() != null) {
            this.zzahy = new GoogleApiClient.Builder(this.zzahn).addApi(zzb.API).build();
        }
        zzdi.initialize(this.zzahn);
    }

    private boolean zzo(String str) throws zzay {
        File file;
        String zzax;
        File zza;
        try {
            File cacheDir = this.zzahn.getCacheDir();
            if (cacheDir == null && (cacheDir = this.zzahn.getDir("dex", 0)) == null) {
                throw new zzay();
            }
            file = cacheDir;
            zzax = zzax.zzax();
            zza = zza(str, file, zzax);
            zzb(file, zzax);
            this.zzahq = new DexClassLoader(zza.getAbsolutePath(), file.getAbsolutePath(), (String) null, this.zzahn.getClassLoader());
            zza(zza);
            zza(file, zzax);
            zzp(String.format("%s/%s.dex", new Object[]{file, zzax}));
            return true;
        } catch (FileNotFoundException e) {
            throw new zzay(e);
        } catch (IOException e2) {
            throw new zzay(e2);
        } catch (zzaw.zza e3) {
            throw new zzay(e3);
        } catch (NullPointerException e4) {
            throw new zzay(e4);
        } catch (Throwable th) {
            zza(zza);
            zza(file, zzax);
            zzp(String.format("%s/%s.dex", new Object[]{file, zzax}));
            throw th;
        }
    }

    private void zzp(String str) {
        zza(new File(str));
    }

    public Context getApplicationContext() {
        return this.zzaho;
    }

    public Context getContext() {
        return this.zzahn;
    }

    public boolean zza(String str, String str2, List<Class> list) {
        if (this.zzaie.containsKey(new Pair(str, str2))) {
            return false;
        }
        this.zzaie.put(new Pair(str, str2), new zzbu(this, str, str2, list));
        return true;
    }

    public int zzau() {
        zzao zzco = zzco();
        if (zzco != null) {
            return zzco.zzau();
        }
        return Integer.MIN_VALUE;
    }

    public Method zzc(String str, String str2) {
        zzbu zzbu = this.zzaie.get(new Pair(str, str2));
        if (zzbu == null) {
            return null;
        }
        return zzbu.zzdd();
    }

    public ExecutorService zzch() {
        return this.zzahp;
    }

    public DexClassLoader zzci() {
        return this.zzahq;
    }

    public zzaw zzcj() {
        return this.zzahr;
    }

    public byte[] zzck() {
        return this.zzahs;
    }

    public GoogleApiClient zzcl() {
        return this.zzahy;
    }

    public boolean zzcm() {
        return this.zzahz;
    }

    public boolean zzcn() {
        return this.zzaid;
    }

    public zzao zzco() {
        return this.zzahx;
    }

    public zzae.zza zzcp() {
        return this.zzahv;
    }

    public Future zzcq() {
        return this.zzahw;
    }

    /* access modifiers changed from: package-private */
    public void zzcs() {
        if (zzdi.zzbfh.get().booleanValue()) {
            this.zzahw = this.zzahp.submit(new Runnable() {
                public void run() {
                    zzbb.this.zzct();
                }
            });
        }
    }

    public AdvertisingIdClient zzcv() {
        if (!this.zzagr) {
            return null;
        }
        if (this.zzaht != null) {
            return this.zzaht;
        }
        if (this.zzahu != null) {
            try {
                this.zzahu.get(2000, TimeUnit.MILLISECONDS);
                this.zzahu = null;
            } catch (InterruptedException | ExecutionException e) {
            } catch (TimeoutException e2) {
                this.zzahu.cancel(true);
            }
        }
        return this.zzaht;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzcw() {
        /*
            r2 = this;
            java.lang.Object r1 = zzaia
            monitor-enter(r1)
            boolean r0 = r2.zzaid     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
        L_0x0008:
            return
        L_0x0009:
            boolean r0 = r2.zzaib     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x001e
            com.google.android.gms.common.api.GoogleApiClient r0 = r2.zzahy     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x001e
            com.google.android.gms.common.api.GoogleApiClient r0 = r2.zzahy     // Catch:{ all -> 0x001b }
            r0.connect()     // Catch:{ all -> 0x001b }
            r0 = 1
            r2.zzaid = r0     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            goto L_0x0008
        L_0x001b:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001b }
            throw r0
        L_0x001e:
            r0 = 0
            r2.zzaid = r0     // Catch:{ all -> 0x001b }
            goto L_0x0019
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzbb.zzcw():void");
    }

    public void zzcx() {
        synchronized (zzaia) {
            if (this.zzaid && this.zzahy != null) {
                this.zzahy.disconnect();
                this.zzaid = false;
            }
        }
    }
}
