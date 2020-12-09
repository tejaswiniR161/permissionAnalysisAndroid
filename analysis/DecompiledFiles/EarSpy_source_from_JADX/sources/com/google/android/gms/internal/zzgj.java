package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.internal.zzgl;
import com.google.android.gms.internal.zzgs;

@zziy
public final class zzgj extends zzgs.zza {
    private final Object zzakd = new Object();
    private zzgl.zza zzbsr;
    private zzgi zzbss;

    public void onAdClicked() {
        synchronized (this.zzakd) {
            if (this.zzbss != null) {
                this.zzbss.zzef();
            }
        }
    }

    public void onAdClosed() {
        synchronized (this.zzakd) {
            if (this.zzbss != null) {
                this.zzbss.zzeg();
            }
        }
    }

    public void onAdFailedToLoad(int i) {
        synchronized (this.zzakd) {
            if (this.zzbsr != null) {
                this.zzbsr.zzaa(i == 3 ? 1 : 2);
                this.zzbsr = null;
            }
        }
    }

    public void onAdImpression() {
        synchronized (this.zzakd) {
            if (this.zzbss != null) {
                this.zzbss.zzek();
            }
        }
    }

    public void onAdLeftApplication() {
        synchronized (this.zzakd) {
            if (this.zzbss != null) {
                this.zzbss.zzeh();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onAdLoaded() {
        /*
            r3 = this;
            java.lang.Object r1 = r3.zzakd
            monitor-enter(r1)
            com.google.android.gms.internal.zzgl$zza r0 = r3.zzbsr     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0012
            com.google.android.gms.internal.zzgl$zza r0 = r3.zzbsr     // Catch:{ all -> 0x001d }
            r2 = 0
            r0.zzaa(r2)     // Catch:{ all -> 0x001d }
            r0 = 0
            r3.zzbsr = r0     // Catch:{ all -> 0x001d }
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
        L_0x0011:
            return
        L_0x0012:
            com.google.android.gms.internal.zzgi r0 = r3.zzbss     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x001b
            com.google.android.gms.internal.zzgi r0 = r3.zzbss     // Catch:{ all -> 0x001d }
            r0.zzej()     // Catch:{ all -> 0x001d }
        L_0x001b:
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            goto L_0x0011
        L_0x001d:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgj.onAdLoaded():void");
    }

    public void onAdOpened() {
        synchronized (this.zzakd) {
            if (this.zzbss != null) {
                this.zzbss.zzei();
            }
        }
    }

    public void zza(@Nullable zzgi zzgi) {
        synchronized (this.zzakd) {
            this.zzbss = zzgi;
        }
    }

    public void zza(zzgl.zza zza) {
        synchronized (this.zzakd) {
            this.zzbsr = zza;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zza(com.google.android.gms.internal.zzgt r4) {
        /*
            r3 = this;
            java.lang.Object r1 = r3.zzakd
            monitor-enter(r1)
            com.google.android.gms.internal.zzgl$zza r0 = r3.zzbsr     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0012
            com.google.android.gms.internal.zzgl$zza r0 = r3.zzbsr     // Catch:{ all -> 0x001d }
            r2 = 0
            r0.zza(r2, r4)     // Catch:{ all -> 0x001d }
            r0 = 0
            r3.zzbsr = r0     // Catch:{ all -> 0x001d }
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
        L_0x0011:
            return
        L_0x0012:
            com.google.android.gms.internal.zzgi r0 = r3.zzbss     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x001b
            com.google.android.gms.internal.zzgi r0 = r3.zzbss     // Catch:{ all -> 0x001d }
            r0.zzej()     // Catch:{ all -> 0x001d }
        L_0x001b:
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            goto L_0x0011
        L_0x001d:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgj.zza(com.google.android.gms.internal.zzgt):void");
    }
}
