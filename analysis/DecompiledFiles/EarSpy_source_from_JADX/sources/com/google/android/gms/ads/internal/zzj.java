package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.p000v4.util.SimpleArrayMap;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzei;
import com.google.android.gms.internal.zzej;
import com.google.android.gms.internal.zzek;
import com.google.android.gms.internal.zzgq;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzkr;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

@zziy
public class zzj extends zzr.zza {
    private final Context mContext;
    /* access modifiers changed from: private */
    public final Object zzakd = new Object();
    private final zzd zzalo;
    private final zzgq zzals;
    /* access modifiers changed from: private */
    public final zzq zzamy;
    /* access modifiers changed from: private */
    @Nullable
    public final zzeh zzamz;
    /* access modifiers changed from: private */
    @Nullable
    public final zzei zzana;
    /* access modifiers changed from: private */
    public final SimpleArrayMap<String, zzek> zzanb;
    /* access modifiers changed from: private */
    public final SimpleArrayMap<String, zzej> zzanc;
    /* access modifiers changed from: private */
    public final NativeAdOptionsParcel zzand;
    private final List<String> zzane;
    /* access modifiers changed from: private */
    public final zzy zzanf;
    private final String zzang;
    private final VersionInfoParcel zzanh;
    /* access modifiers changed from: private */
    @Nullable
    public WeakReference<zzq> zzani;

    zzj(Context context, String str, zzgq zzgq, VersionInfoParcel versionInfoParcel, zzq zzq, zzeh zzeh, zzei zzei, SimpleArrayMap<String, zzek> simpleArrayMap, SimpleArrayMap<String, zzej> simpleArrayMap2, NativeAdOptionsParcel nativeAdOptionsParcel, zzy zzy, zzd zzd) {
        this.mContext = context;
        this.zzang = str;
        this.zzals = zzgq;
        this.zzanh = versionInfoParcel;
        this.zzamy = zzq;
        this.zzana = zzei;
        this.zzamz = zzeh;
        this.zzanb = simpleArrayMap;
        this.zzanc = simpleArrayMap2;
        this.zzand = nativeAdOptionsParcel;
        this.zzane = zzew();
        this.zzanf = zzy;
        this.zzalo = zzd;
    }

    /* access modifiers changed from: private */
    public List<String> zzew() {
        ArrayList arrayList = new ArrayList();
        if (this.zzana != null) {
            arrayList.add("1");
        }
        if (this.zzamz != null) {
            arrayList.add("2");
        }
        if (this.zzanb.size() > 0) {
            arrayList.add("3");
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return r0;
     */
    @android.support.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getMediationAdapterClassName() {
        /*
            r3 = this;
            r1 = 0
            java.lang.Object r2 = r3.zzakd
            monitor-enter(r2)
            java.lang.ref.WeakReference<com.google.android.gms.ads.internal.zzq> r0 = r3.zzani     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x001a
            java.lang.ref.WeakReference<com.google.android.gms.ads.internal.zzq> r0 = r3.zzani     // Catch:{ all -> 0x001d }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x001d }
            com.google.android.gms.ads.internal.zzq r0 = (com.google.android.gms.ads.internal.zzq) r0     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0018
            java.lang.String r0 = r0.getMediationAdapterClassName()     // Catch:{ all -> 0x001d }
        L_0x0016:
            monitor-exit(r2)     // Catch:{ all -> 0x001d }
        L_0x0017:
            return r0
        L_0x0018:
            r0 = r1
            goto L_0x0016
        L_0x001a:
            monitor-exit(r2)     // Catch:{ all -> 0x001d }
            r0 = r1
            goto L_0x0017
        L_0x001d:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzj.getMediationAdapterClassName():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isLoading() {
        /*
            r3 = this;
            r1 = 0
            java.lang.Object r2 = r3.zzakd
            monitor-enter(r2)
            java.lang.ref.WeakReference<com.google.android.gms.ads.internal.zzq> r0 = r3.zzani     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x001a
            java.lang.ref.WeakReference<com.google.android.gms.ads.internal.zzq> r0 = r3.zzani     // Catch:{ all -> 0x001d }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x001d }
            com.google.android.gms.ads.internal.zzq r0 = (com.google.android.gms.ads.internal.zzq) r0     // Catch:{ all -> 0x001d }
            if (r0 == 0) goto L_0x0018
            boolean r0 = r0.isLoading()     // Catch:{ all -> 0x001d }
        L_0x0016:
            monitor-exit(r2)     // Catch:{ all -> 0x001d }
        L_0x0017:
            return r0
        L_0x0018:
            r0 = r1
            goto L_0x0016
        L_0x001a:
            monitor-exit(r2)     // Catch:{ all -> 0x001d }
            r0 = r1
            goto L_0x0017
        L_0x001d:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001d }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.zzj.isLoading():boolean");
    }

    /* access modifiers changed from: protected */
    public void runOnUiThread(Runnable runnable) {
        zzkr.zzcrf.post(runnable);
    }

    /* access modifiers changed from: protected */
    public zzq zzex() {
        return new zzq(this.mContext, this.zzalo, AdSizeParcel.zzk(this.mContext), this.zzang, this.zzals, this.zzanh);
    }

    public void zzf(final AdRequestParcel adRequestParcel) {
        runOnUiThread(new Runnable() {
            public void run() {
                synchronized (zzj.this.zzakd) {
                    zzq zzex = zzj.this.zzex();
                    WeakReference unused = zzj.this.zzani = new WeakReference(zzex);
                    zzex.zzb(zzj.this.zzamz);
                    zzex.zzb(zzj.this.zzana);
                    zzex.zza((SimpleArrayMap<String, zzek>) zzj.this.zzanb);
                    zzex.zza(zzj.this.zzamy);
                    zzex.zzb((SimpleArrayMap<String, zzej>) zzj.this.zzanc);
                    zzex.zzb((List<String>) zzj.this.zzew());
                    zzex.zzb(zzj.this.zzand);
                    zzex.zza(zzj.this.zzanf);
                    zzex.zzb(adRequestParcel);
                }
            }
        });
    }
}
