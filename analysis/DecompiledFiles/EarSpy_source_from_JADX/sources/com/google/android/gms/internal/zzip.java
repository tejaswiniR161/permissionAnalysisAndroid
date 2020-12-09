package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.internal.formats.zzi;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.zzn;
import com.google.android.gms.internal.zzik;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zzke;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@zziy
public class zzip extends zzik {
    private final zzdq zzalg;
    private zzgq zzals;
    /* access modifiers changed from: private */
    public final zzlt zzbkr;
    private zzgh zzbsv;
    zzgf zzcdh;
    protected zzgl zzcdi;
    /* access modifiers changed from: private */
    public boolean zzcdj;

    zzip(Context context, zzke.zza zza, zzgq zzgq, zzil.zza zza2, zzdq zzdq, zzlt zzlt) {
        super(context, zza, zza2);
        this.zzals = zzgq;
        this.zzbsv = zza.zzcof;
        this.zzalg = zzdq;
        this.zzbkr = zzlt;
    }

    private static String zza(zzgl zzgl) {
        String str = zzgl.zzbte.zzbro;
        int zzao = zzao(zzgl.zzbtd);
        return new StringBuilder(String.valueOf(str).length() + 33).append(str).append(".").append(zzao).append(".").append(zzgl.zzbtj).toString();
    }

    private static int zzao(int i) {
        switch (i) {
            case -1:
                return 4;
            case 0:
                return 0;
            case 1:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 5;
            default:
                return 6;
        }
    }

    private static String zzg(List<zzgl> list) {
        if (list == null) {
            return "".toString();
        }
        String str = "";
        for (zzgl next : list) {
            if (!(next == null || next.zzbte == null || TextUtils.isEmpty(next.zzbte.zzbro))) {
                String valueOf = String.valueOf(str);
                String valueOf2 = String.valueOf(zza(next));
                str = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length()).append(valueOf).append(valueOf2).append("_").toString();
            }
        }
        return str.substring(0, Math.max(0, str.length() - 1));
    }

    private void zzrd() throws zzik.zza {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        zzkr.zzcrf.post(new Runnable() {
            public void run() {
                synchronized (zzip.this.zzccn) {
                    boolean unused = zzip.this.zzcdj = zzn.zza(zzip.this.zzbkr, zzip.this.zzcdi, countDownLatch);
                }
            }
        });
        try {
            countDownLatch.await(10, TimeUnit.SECONDS);
            synchronized (this.zzccn) {
                if (!this.zzcdj) {
                    throw new zzik.zza("View could not be prepared", 0);
                } else if (this.zzbkr.isDestroyed()) {
                    throw new zzik.zza("Assets not loaded, web view is destroyed", 0);
                }
            }
        } catch (InterruptedException e) {
            String valueOf = String.valueOf(e);
            throw new zzik.zza(new StringBuilder(String.valueOf(valueOf).length() + 38).append("Interrupted while waiting for latch : ").append(valueOf).toString(), 0);
        }
    }

    public void onStop() {
        synchronized (this.zzccn) {
            super.onStop();
            if (this.zzcdh != null) {
                this.zzcdh.cancel();
            }
        }
    }

    /* access modifiers changed from: protected */
    public zzke zzam(int i) {
        AdRequestInfoParcel adRequestInfoParcel = this.zzcck.zzcix;
        return new zzke(adRequestInfoParcel.zzcfu, this.zzbkr, this.zzccl.zzbsd, i, this.zzccl.zzbse, this.zzccl.zzche, this.zzccl.orientation, this.zzccl.zzbsj, adRequestInfoParcel.zzcfx, this.zzccl.zzchc, this.zzcdi != null ? this.zzcdi.zzbte : null, this.zzcdi != null ? this.zzcdi.zzbtf : null, this.zzcdi != null ? this.zzcdi.zzbtg : AdMobAdapter.class.getName(), this.zzbsv, this.zzcdi != null ? this.zzcdi.zzbth : null, this.zzccl.zzchd, this.zzcck.zzaqz, this.zzccl.zzchb, this.zzcck.zzcoj, this.zzccl.zzchg, this.zzccl.zzchh, this.zzcck.zzcod, (zzi.zza) null, this.zzccl.zzchr, this.zzccl.zzchs, this.zzccl.zzcht, this.zzbsv != null ? this.zzbsv.zzbso : false, this.zzccl.zzchv, this.zzcdh != null ? zzg(this.zzcdh.zzne()) : null, this.zzccl.zzbsg, this.zzccl.zzchy);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        r0 = r0.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzh(long r6) throws com.google.android.gms.internal.zzik.zza {
        /*
            r5 = this;
            r1 = 0
            java.lang.Object r2 = r5.zzccn
            monitor-enter(r2)
            com.google.android.gms.internal.zzgf r0 = r5.zzi(r6)     // Catch:{ all -> 0x004a }
            r5.zzcdh = r0     // Catch:{ all -> 0x004a }
            monitor-exit(r2)     // Catch:{ all -> 0x004a }
            java.util.ArrayList r2 = new java.util.ArrayList
            com.google.android.gms.internal.zzgh r0 = r5.zzbsv
            java.util.List<com.google.android.gms.internal.zzgg> r0 = r0.zzbsb
            r2.<init>(r0)
            com.google.android.gms.internal.zzke$zza r0 = r5.zzcck
            com.google.android.gms.ads.internal.request.AdRequestInfoParcel r0 = r0.zzcix
            com.google.android.gms.ads.internal.client.AdRequestParcel r0 = r0.zzcfu
            android.os.Bundle r0 = r0.zzawn
            java.lang.String r3 = "com.google.ads.mediation.admob.AdMobAdapter"
            if (r0 == 0) goto L_0x0096
            android.os.Bundle r0 = r0.getBundle(r3)
            if (r0 == 0) goto L_0x0096
            java.lang.String r4 = "_skipMediation"
            boolean r0 = r0.getBoolean(r4)
        L_0x002c:
            if (r0 == 0) goto L_0x004d
            java.util.ListIterator r4 = r2.listIterator()
        L_0x0032:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x004d
            java.lang.Object r0 = r4.next()
            com.google.android.gms.internal.zzgg r0 = (com.google.android.gms.internal.zzgg) r0
            java.util.List<java.lang.String> r0 = r0.zzbrn
            boolean r0 = r0.contains(r3)
            if (r0 != 0) goto L_0x0032
            r4.remove()
            goto L_0x0032
        L_0x004a:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x004a }
            throw r0
        L_0x004d:
            com.google.android.gms.internal.zzgf r0 = r5.zzcdh
            com.google.android.gms.internal.zzgl r0 = r0.zzd(r2)
            r5.zzcdi = r0
            com.google.android.gms.internal.zzgl r0 = r5.zzcdi
            int r0 = r0.zzbtd
            switch(r0) {
                case 0: goto L_0x0084;
                case 1: goto L_0x007b;
                default: goto L_0x005c;
            }
        L_0x005c:
            com.google.android.gms.internal.zzik$zza r0 = new com.google.android.gms.internal.zzik$zza
            com.google.android.gms.internal.zzgl r2 = r5.zzcdi
            int r2 = r2.zzbtd
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r4 = 40
            r3.<init>(r4)
            java.lang.String r4 = "Unexpected mediation result: "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r2 = r2.toString()
            r0.<init>(r2, r1)
            throw r0
        L_0x007b:
            com.google.android.gms.internal.zzik$zza r0 = new com.google.android.gms.internal.zzik$zza
            java.lang.String r1 = "No fill from any mediation ad networks."
            r2 = 3
            r0.<init>(r1, r2)
            throw r0
        L_0x0084:
            com.google.android.gms.internal.zzgl r0 = r5.zzcdi
            com.google.android.gms.internal.zzgg r0 = r0.zzbte
            if (r0 == 0) goto L_0x0095
            com.google.android.gms.internal.zzgl r0 = r5.zzcdi
            com.google.android.gms.internal.zzgg r0 = r0.zzbte
            java.lang.String r0 = r0.zzbrw
            if (r0 == 0) goto L_0x0095
            r5.zzrd()
        L_0x0095:
            return
        L_0x0096:
            r0 = r1
            goto L_0x002c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzip.zzh(long):void");
    }

    /* access modifiers changed from: package-private */
    public zzgf zzi(long j) {
        if (this.zzbsv.zzbsm != -1) {
            return new zzgn(this.mContext, this.zzcck.zzcix, this.zzals, this.zzbsv, this.zzccl.zzaxl, this.zzccl.zzaxn, j, zzdi.zzbel.get().longValue(), 2);
        }
        return new zzgo(this.mContext, this.zzcck.zzcix, this.zzals, this.zzbsv, this.zzccl.zzaxl, this.zzccl.zzaxn, j, zzdi.zzbel.get().longValue(), this.zzalg);
    }
}
