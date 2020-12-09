package com.google.android.gms.ads.internal.cache;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.internal.zzct;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzkr;

@zziy
public class zza {
    @Nullable
    private Context mContext;
    /* access modifiers changed from: private */
    public final Object zzakd = new Object();
    private final Runnable zzavq = new Runnable() {
        public void run() {
            zza.this.disconnect();
        }
    };
    /* access modifiers changed from: private */
    @Nullable
    public zzc zzavr;
    /* access modifiers changed from: private */
    @Nullable
    public zzf zzavs;

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect() {
        /*
            r3 = this;
            java.lang.Object r1 = r3.zzakd
            monitor-enter(r1)
            android.content.Context r0 = r3.mContext     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x000b
            com.google.android.gms.ads.internal.cache.zzc r0 = r3.zzavr     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x000d
        L_0x000b:
            monitor-exit(r1)     // Catch:{ all -> 0x0024 }
        L_0x000c:
            return
        L_0x000d:
            com.google.android.gms.ads.internal.cache.zza$3 r0 = new com.google.android.gms.ads.internal.cache.zza$3     // Catch:{ all -> 0x0024 }
            r0.<init>()     // Catch:{ all -> 0x0024 }
            com.google.android.gms.ads.internal.cache.zza$4 r2 = new com.google.android.gms.ads.internal.cache.zza$4     // Catch:{ all -> 0x0024 }
            r2.<init>()     // Catch:{ all -> 0x0024 }
            com.google.android.gms.ads.internal.cache.zzc r0 = r3.zza((com.google.android.gms.common.internal.zze.zzb) r0, (com.google.android.gms.common.internal.zze.zzc) r2)     // Catch:{ all -> 0x0024 }
            r3.zzavr = r0     // Catch:{ all -> 0x0024 }
            com.google.android.gms.ads.internal.cache.zzc r0 = r3.zzavr     // Catch:{ all -> 0x0024 }
            r0.zzatu()     // Catch:{ all -> 0x0024 }
            monitor-exit(r1)     // Catch:{ all -> 0x0024 }
            goto L_0x000c
        L_0x0024:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0024 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.cache.zza.connect():void");
    }

    /* access modifiers changed from: private */
    public void disconnect() {
        synchronized (this.zzakd) {
            if (this.zzavr != null) {
                if (this.zzavr.isConnected() || this.zzavr.isConnecting()) {
                    this.zzavr.disconnect();
                }
                this.zzavr = null;
                this.zzavs = null;
                Binder.flushPendingCommands();
                zzu.zzgp().zzuz();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initialize(android.content.Context r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0003
        L_0x0002:
            return
        L_0x0003:
            java.lang.Object r1 = r2.zzakd
            monitor-enter(r1)
            android.content.Context r0 = r2.mContext     // Catch:{ all -> 0x000c }
            if (r0 == 0) goto L_0x000f
            monitor-exit(r1)     // Catch:{ all -> 0x000c }
            goto L_0x0002
        L_0x000c:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x000c }
            throw r0
        L_0x000f:
            android.content.Context r0 = r3.getApplicationContext()     // Catch:{ all -> 0x000c }
            r2.mContext = r0     // Catch:{ all -> 0x000c }
            com.google.android.gms.internal.zzde<java.lang.Boolean> r0 = com.google.android.gms.internal.zzdi.zzbhl     // Catch:{ all -> 0x000c }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x000c }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x000c }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x000c }
            if (r0 == 0) goto L_0x0028
            r2.connect()     // Catch:{ all -> 0x000c }
        L_0x0026:
            monitor-exit(r1)     // Catch:{ all -> 0x000c }
            goto L_0x0002
        L_0x0028:
            com.google.android.gms.internal.zzde<java.lang.Boolean> r0 = com.google.android.gms.internal.zzdi.zzbhk     // Catch:{ all -> 0x000c }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x000c }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x000c }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x000c }
            if (r0 == 0) goto L_0x0026
            com.google.android.gms.ads.internal.cache.zza$2 r0 = new com.google.android.gms.ads.internal.cache.zza$2     // Catch:{ all -> 0x000c }
            r0.<init>()     // Catch:{ all -> 0x000c }
            r2.zza((com.google.android.gms.internal.zzct.zzb) r0)     // Catch:{ all -> 0x000c }
            goto L_0x0026
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.cache.zza.initialize(android.content.Context):void");
    }

    public CacheEntryParcel zza(CacheOffering cacheOffering) {
        CacheEntryParcel cacheEntryParcel;
        synchronized (this.zzakd) {
            if (this.zzavs == null) {
                cacheEntryParcel = new CacheEntryParcel();
            } else {
                try {
                    cacheEntryParcel = this.zzavs.zza(cacheOffering);
                } catch (RemoteException e) {
                    zzkn.zzb("Unable to call into cache service.", e);
                    cacheEntryParcel = new CacheEntryParcel();
                }
            }
        }
        return cacheEntryParcel;
    }

    /* access modifiers changed from: protected */
    public zzc zza(zze.zzb zzb, zze.zzc zzc) {
        return new zzc(this.mContext, zzu.zzgp().zzuy(), zzb, zzc);
    }

    /* access modifiers changed from: protected */
    public void zza(zzct.zzb zzb) {
        zzu.zzgc().zza(zzb);
    }

    public void zzit() {
        if (zzdi.zzbhm.get().booleanValue()) {
            synchronized (this.zzakd) {
                connect();
                zzu.zzfz();
                zzkr.zzcrf.removeCallbacks(this.zzavq);
                zzu.zzfz();
                zzkr.zzcrf.postDelayed(this.zzavq, zzdi.zzbhn.get().longValue());
            }
        }
    }
}
