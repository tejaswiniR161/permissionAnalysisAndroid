package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import java.util.ArrayList;
import java.util.List;

@zziy
public class zzgo implements zzgf {
    private final Context mContext;
    private final Object zzakd = new Object();
    private final zzdq zzalg;
    private final zzgq zzals;
    private final boolean zzatk;
    private final boolean zzazd;
    private final zzgh zzbsv;
    private final AdRequestInfoParcel zzbtk;
    private final long zzbtl;
    private final long zzbtm;
    private boolean zzbto = false;
    private List<zzgl> zzbtq = new ArrayList();
    private zzgk zzbtu;

    public zzgo(Context context, AdRequestInfoParcel adRequestInfoParcel, zzgq zzgq, zzgh zzgh, boolean z, boolean z2, long j, long j2, zzdq zzdq) {
        this.mContext = context;
        this.zzbtk = adRequestInfoParcel;
        this.zzals = zzgq;
        this.zzbsv = zzgh;
        this.zzatk = z;
        this.zzazd = z2;
        this.zzbtl = j;
        this.zzbtm = j2;
        this.zzalg = zzdq;
    }

    public void cancel() {
        synchronized (this.zzakd) {
            this.zzbto = true;
            if (this.zzbtu != null) {
                this.zzbtu.cancel();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00a8, code lost:
        r2 = r21.zzbtu.zza(r21.zzbtl, r21.zzbtm);
        r21.zzbtq.add(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x00c1, code lost:
        if (r2.zzbtd != 0) goto L_0x010d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00c3, code lost:
        com.google.android.gms.internal.zzkn.zzdd("Adapter succeeded.");
        r21.zzalg.zzh("mediation_network_succeed", r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d5, code lost:
        if (r15.isEmpty() != false) goto L_0x00e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00d7, code lost:
        r21.zzalg.zzh("mediation_networks_fail", android.text.TextUtils.join(",", r15));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00e6, code lost:
        r21.zzalg.zza(r19, "mls");
        r21.zzalg.zza(r16, "ttm");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x010d, code lost:
        r15.add(r4);
        r21.zzalg.zza(r19, "mlf");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0123, code lost:
        if (r2.zzbtf == null) goto L_0x003d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0125, code lost:
        com.google.android.gms.internal.zzkr.zzcrf.post(new com.google.android.gms.internal.zzgo.C09281(r21));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzgl zzd(java.util.List<com.google.android.gms.internal.zzgg> r22) {
        /*
            r21 = this;
            java.lang.String r2 = "Starting mediation."
            com.google.android.gms.internal.zzkn.zzdd(r2)
            java.util.ArrayList r15 = new java.util.ArrayList
            r15.<init>()
            r0 = r21
            com.google.android.gms.internal.zzdq r2 = r0.zzalg
            com.google.android.gms.internal.zzdo r16 = r2.zzla()
            java.util.Iterator r17 = r22.iterator()
        L_0x0016:
            boolean r2 = r17.hasNext()
            if (r2 == 0) goto L_0x0133
            java.lang.Object r7 = r17.next()
            com.google.android.gms.internal.zzgg r7 = (com.google.android.gms.internal.zzgg) r7
            java.lang.String r3 = "Trying mediation network: "
            java.lang.String r2 = r7.zzbrm
            java.lang.String r2 = java.lang.String.valueOf(r2)
            int r4 = r2.length()
            if (r4 == 0) goto L_0x0066
            java.lang.String r2 = r3.concat(r2)
        L_0x0034:
            com.google.android.gms.internal.zzkn.zzde(r2)
            java.util.List<java.lang.String> r2 = r7.zzbrn
            java.util.Iterator r18 = r2.iterator()
        L_0x003d:
            boolean r2 = r18.hasNext()
            if (r2 == 0) goto L_0x0016
            java.lang.Object r4 = r18.next()
            java.lang.String r4 = (java.lang.String) r4
            r0 = r21
            com.google.android.gms.internal.zzdq r2 = r0.zzalg
            com.google.android.gms.internal.zzdo r19 = r2.zzla()
            r0 = r21
            java.lang.Object r0 = r0.zzakd
            r20 = r0
            monitor-enter(r20)
            r0 = r21
            boolean r2 = r0.zzbto     // Catch:{ all -> 0x010a }
            if (r2 == 0) goto L_0x006c
            com.google.android.gms.internal.zzgl r2 = new com.google.android.gms.internal.zzgl     // Catch:{ all -> 0x010a }
            r3 = -1
            r2.<init>(r3)     // Catch:{ all -> 0x010a }
            monitor-exit(r20)     // Catch:{ all -> 0x010a }
        L_0x0065:
            return r2
        L_0x0066:
            java.lang.String r2 = new java.lang.String
            r2.<init>(r3)
            goto L_0x0034
        L_0x006c:
            com.google.android.gms.internal.zzgk r2 = new com.google.android.gms.internal.zzgk     // Catch:{ all -> 0x010a }
            r0 = r21
            android.content.Context r3 = r0.mContext     // Catch:{ all -> 0x010a }
            r0 = r21
            com.google.android.gms.internal.zzgq r5 = r0.zzals     // Catch:{ all -> 0x010a }
            r0 = r21
            com.google.android.gms.internal.zzgh r6 = r0.zzbsv     // Catch:{ all -> 0x010a }
            r0 = r21
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r8 = r0.zzbtk     // Catch:{ all -> 0x010a }
            com.google.android.gms.ads.internal.client.AdRequestParcel r8 = r8.zzcfu     // Catch:{ all -> 0x010a }
            r0 = r21
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r9 = r0.zzbtk     // Catch:{ all -> 0x010a }
            com.google.android.gms.ads.internal.client.AdSizeParcel r9 = r9.zzaqz     // Catch:{ all -> 0x010a }
            r0 = r21
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r10 = r0.zzbtk     // Catch:{ all -> 0x010a }
            com.google.android.gms.ads.internal.util.client.VersionInfoParcel r10 = r10.zzaqv     // Catch:{ all -> 0x010a }
            r0 = r21
            boolean r11 = r0.zzatk     // Catch:{ all -> 0x010a }
            r0 = r21
            boolean r12 = r0.zzazd     // Catch:{ all -> 0x010a }
            r0 = r21
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r13 = r0.zzbtk     // Catch:{ all -> 0x010a }
            com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel r13 = r13.zzarn     // Catch:{ all -> 0x010a }
            r0 = r21
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r14 = r0.zzbtk     // Catch:{ all -> 0x010a }
            java.util.List<java.lang.String> r14 = r14.zzarr     // Catch:{ all -> 0x010a }
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)     // Catch:{ all -> 0x010a }
            r0 = r21
            r0.zzbtu = r2     // Catch:{ all -> 0x010a }
            monitor-exit(r20)     // Catch:{ all -> 0x010a }
            r0 = r21
            com.google.android.gms.internal.zzgk r2 = r0.zzbtu
            r0 = r21
            long r8 = r0.zzbtl
            r0 = r21
            long r10 = r0.zzbtm
            com.google.android.gms.internal.zzgl r2 = r2.zza((long) r8, (long) r10)
            r0 = r21
            java.util.List<com.google.android.gms.internal.zzgl> r3 = r0.zzbtq
            r3.add(r2)
            int r3 = r2.zzbtd
            if (r3 != 0) goto L_0x010d
            java.lang.String r3 = "Adapter succeeded."
            com.google.android.gms.internal.zzkn.zzdd(r3)
            r0 = r21
            com.google.android.gms.internal.zzdq r3 = r0.zzalg
            java.lang.String r5 = "mediation_network_succeed"
            r3.zzh(r5, r4)
            boolean r3 = r15.isEmpty()
            if (r3 != 0) goto L_0x00e6
            r0 = r21
            com.google.android.gms.internal.zzdq r3 = r0.zzalg
            java.lang.String r4 = "mediation_networks_fail"
            java.lang.String r5 = ","
            java.lang.String r5 = android.text.TextUtils.join(r5, r15)
            r3.zzh(r4, r5)
        L_0x00e6:
            r0 = r21
            com.google.android.gms.internal.zzdq r3 = r0.zzalg
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]
            r5 = 0
            java.lang.String r6 = "mls"
            r4[r5] = r6
            r0 = r19
            r3.zza(r0, r4)
            r0 = r21
            com.google.android.gms.internal.zzdq r3 = r0.zzalg
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]
            r5 = 0
            java.lang.String r6 = "ttm"
            r4[r5] = r6
            r0 = r16
            r3.zza(r0, r4)
            goto L_0x0065
        L_0x010a:
            r2 = move-exception
            monitor-exit(r20)     // Catch:{ all -> 0x010a }
            throw r2
        L_0x010d:
            r15.add(r4)
            r0 = r21
            com.google.android.gms.internal.zzdq r3 = r0.zzalg
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]
            r5 = 0
            java.lang.String r6 = "mlf"
            r4[r5] = r6
            r0 = r19
            r3.zza(r0, r4)
            com.google.android.gms.internal.zzgr r3 = r2.zzbtf
            if (r3 == 0) goto L_0x003d
            android.os.Handler r3 = com.google.android.gms.internal.zzkr.zzcrf
            com.google.android.gms.internal.zzgo$1 r4 = new com.google.android.gms.internal.zzgo$1
            r0 = r21
            r4.<init>(r2)
            r3.post(r4)
            goto L_0x003d
        L_0x0133:
            boolean r2 = r15.isEmpty()
            if (r2 != 0) goto L_0x0148
            r0 = r21
            com.google.android.gms.internal.zzdq r2 = r0.zzalg
            java.lang.String r3 = "mediation_networks_fail"
            java.lang.String r4 = ","
            java.lang.String r4 = android.text.TextUtils.join(r4, r15)
            r2.zzh(r3, r4)
        L_0x0148:
            com.google.android.gms.internal.zzgl r2 = new com.google.android.gms.internal.zzgl
            r3 = 1
            r2.<init>(r3)
            goto L_0x0065
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgo.zzd(java.util.List):com.google.android.gms.internal.zzgl");
    }

    public List<zzgl> zzne() {
        return this.zzbtq;
    }
}
