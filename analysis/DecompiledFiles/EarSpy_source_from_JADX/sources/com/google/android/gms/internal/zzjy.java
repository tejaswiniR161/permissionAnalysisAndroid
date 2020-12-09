package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.formats.zzi;
import com.google.android.gms.internal.zzjt;
import com.google.android.gms.internal.zzke;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Future;

@zziy
public class zzjy extends zzkm implements zzjx {
    private final Context mContext;
    private final Object zzakd;
    private final zzke.zza zzcck;
    private final long zzcne;
    private final ArrayList<Future> zzcnp;
    private final ArrayList<String> zzcnq;
    private final HashMap<String, zzjs> zzcnr;
    private final List<zzjt> zzcns;
    private final HashSet<String> zzcnt;
    /* access modifiers changed from: private */
    public final zzjr zzcnu;

    public zzjy(Context context, zzke.zza zza, zzjr zzjr) {
        this(context, zza, zzjr, zzdi.zzbda.get().longValue());
    }

    zzjy(Context context, zzke.zza zza, zzjr zzjr, long j) {
        this.zzcnp = new ArrayList<>();
        this.zzcnq = new ArrayList<>();
        this.zzcnr = new HashMap<>();
        this.zzcns = new ArrayList();
        this.zzcnt = new HashSet<>();
        this.zzakd = new Object();
        this.mContext = context;
        this.zzcck = zza;
        this.zzcnu = zzjr;
        this.zzcne = j;
    }

    private zzke zza(int i, @Nullable String str, @Nullable zzgg zzgg) {
        return new zzke(this.zzcck.zzcix.zzcfu, (zzlt) null, this.zzcck.zzcop.zzbsd, i, this.zzcck.zzcop.zzbse, this.zzcck.zzcop.zzche, this.zzcck.zzcop.orientation, this.zzcck.zzcop.zzbsj, this.zzcck.zzcix.zzcfx, this.zzcck.zzcop.zzchc, zzgg, (zzgr) null, str, this.zzcck.zzcof, (zzgj) null, this.zzcck.zzcop.zzchd, this.zzcck.zzaqz, this.zzcck.zzcop.zzchb, this.zzcck.zzcoj, this.zzcck.zzcop.zzchg, this.zzcck.zzcop.zzchh, this.zzcck.zzcod, (zzi.zza) null, this.zzcck.zzcop.zzchr, this.zzcck.zzcop.zzchs, this.zzcck.zzcop.zzcht, this.zzcck.zzcop.zzchu, this.zzcck.zzcop.zzchv, zzsu(), this.zzcck.zzcop.zzbsg, this.zzcck.zzcop.zzchy);
    }

    private zzke zza(String str, zzgg zzgg) {
        return zza(-2, str, zzgg);
    }

    private static String zza(zzjt zzjt) {
        String str = zzjt.zzbro;
        int zzao = zzao(zzjt.errorCode);
        return new StringBuilder(String.valueOf(str).length() + 33).append(str).append(".").append(zzao).append(".").append(zzjt.zzbtj).toString();
    }

    private void zza(String str, String str2, zzgg zzgg) {
        synchronized (this.zzakd) {
            zzjz zzcl = this.zzcnu.zzcl(str);
            if (zzcl == null || zzcl.zzsw() == null || zzcl.zzsv() == null) {
                this.zzcns.add(new zzjt.zza().zzco(zzgg.zzbro).zzcn(str).zzl(0).zzaz(7).zzss());
                return;
            }
            zzjs zza = zza(str, str2, zzgg, zzcl);
            this.zzcnp.add((Future) zza.zzqw());
            this.zzcnq.add(str);
            this.zzcnr.put(str, zza);
        }
    }

    private static int zzao(int i) {
        switch (i) {
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
                return 4;
            case 6:
                return 0;
            case 7:
                return 3;
            default:
                return 6;
        }
    }

    private zzke zzst() {
        return zza(3, (String) null, (zzgg) null);
    }

    private String zzsu() {
        StringBuilder sb = new StringBuilder("");
        if (this.zzcns == null) {
            return sb.toString();
        }
        for (zzjt next : this.zzcns) {
            if (next != null && !TextUtils.isEmpty(next.zzbro)) {
                sb.append(String.valueOf(zza(next)).concat("_"));
            }
        }
        return sb.substring(0, Math.max(0, sb.length() - 1));
    }

    public void onStop() {
    }

    /* access modifiers changed from: protected */
    public zzjs zza(String str, String str2, zzgg zzgg, zzjz zzjz) {
        return new zzjs(this.mContext, str, str2, zzgg, this.zzcck, zzjz, this, this.zzcne);
    }

    public void zza(String str, int i) {
    }

    public void zzcm(String str) {
        synchronized (this.zzakd) {
            this.zzcnt.add(str);
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processExcHandler(RegionMaker.java:1043)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:975)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    public void zzfc() {
        /*
            r6 = this;
            com.google.android.gms.internal.zzke$zza r0 = r6.zzcck
            com.google.android.gms.internal.zzgh r0 = r0.zzcof
            java.util.List<com.google.android.gms.internal.zzgg> r0 = r0.zzbsb
            java.util.Iterator r2 = r0.iterator()
        L_0x000a:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0050
            java.lang.Object r0 = r2.next()
            com.google.android.gms.internal.zzgg r0 = (com.google.android.gms.internal.zzgg) r0
            java.lang.String r3 = r0.zzbrt
            java.util.List<java.lang.String> r1 = r0.zzbrn
            java.util.Iterator r4 = r1.iterator()
        L_0x001e:
            boolean r1 = r4.hasNext()
            if (r1 == 0) goto L_0x000a
            java.lang.Object r1 = r4.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r5 = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter"
            boolean r5 = r5.equals(r1)
            if (r5 != 0) goto L_0x003a
            java.lang.String r5 = "com.google.ads.mediation.customevent.CustomEventAdapter"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x0045
        L_0x003a:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0049 }
            r1.<init>(r3)     // Catch:{ JSONException -> 0x0049 }
            java.lang.String r5 = "class_name"
            java.lang.String r1 = r1.getString(r5)     // Catch:{ JSONException -> 0x0049 }
        L_0x0045:
            r6.zza((java.lang.String) r1, (java.lang.String) r3, (com.google.android.gms.internal.zzgg) r0)
            goto L_0x001e
        L_0x0049:
            r1 = move-exception
            java.lang.String r5 = "Unable to determine custom event class name, skipping..."
            com.google.android.gms.internal.zzkn.zzb(r5, r1)
            goto L_0x001e
        L_0x0050:
            r0 = 0
            r1 = r0
        L_0x0052:
            java.util.ArrayList<java.util.concurrent.Future> r0 = r6.zzcnp
            int r0 = r0.size()
            if (r1 >= r0) goto L_0x00f7
            java.util.ArrayList<java.util.concurrent.Future> r0 = r6.zzcnp     // Catch:{ InterruptedException -> 0x00ca, Exception -> 0x0109 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ InterruptedException -> 0x00ca, Exception -> 0x0109 }
            java.util.concurrent.Future r0 = (java.util.concurrent.Future) r0     // Catch:{ InterruptedException -> 0x00ca, Exception -> 0x0109 }
            r0.get()     // Catch:{ InterruptedException -> 0x00ca, Exception -> 0x0109 }
            java.lang.Object r2 = r6.zzakd
            monitor-enter(r2)
            java.util.ArrayList<java.lang.String> r0 = r6.zzcnq     // Catch:{ all -> 0x00c7 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x00c7 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x00c7 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x00c7 }
            if (r3 != 0) goto L_0x0089
            java.util.HashMap<java.lang.String, com.google.android.gms.internal.zzjs> r3 = r6.zzcnr     // Catch:{ all -> 0x00c7 }
            java.lang.Object r0 = r3.get(r0)     // Catch:{ all -> 0x00c7 }
            com.google.android.gms.internal.zzjs r0 = (com.google.android.gms.internal.zzjs) r0     // Catch:{ all -> 0x00c7 }
            if (r0 == 0) goto L_0x0089
            java.util.List<com.google.android.gms.internal.zzjt> r3 = r6.zzcns     // Catch:{ all -> 0x00c7 }
            com.google.android.gms.internal.zzjt r0 = r0.zzsp()     // Catch:{ all -> 0x00c7 }
            r3.add(r0)     // Catch:{ all -> 0x00c7 }
        L_0x0089:
            monitor-exit(r2)     // Catch:{ all -> 0x00c7 }
            java.lang.Object r2 = r6.zzakd
            monitor-enter(r2)
            java.util.HashSet<java.lang.String> r0 = r6.zzcnt     // Catch:{ all -> 0x016c }
            java.util.ArrayList<java.lang.String> r3 = r6.zzcnq     // Catch:{ all -> 0x016c }
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x016c }
            boolean r0 = r0.contains(r3)     // Catch:{ all -> 0x016c }
            if (r0 == 0) goto L_0x016a
            java.util.ArrayList<java.lang.String> r0 = r6.zzcnq     // Catch:{ all -> 0x016c }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x016c }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x016c }
            java.util.HashMap<java.lang.String, com.google.android.gms.internal.zzjs> r1 = r6.zzcnr     // Catch:{ all -> 0x016c }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x016c }
            if (r1 == 0) goto L_0x0167
            java.util.HashMap<java.lang.String, com.google.android.gms.internal.zzjs> r1 = r6.zzcnr     // Catch:{ all -> 0x016c }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x016c }
            com.google.android.gms.internal.zzjs r1 = (com.google.android.gms.internal.zzjs) r1     // Catch:{ all -> 0x016c }
            com.google.android.gms.internal.zzgg r1 = r1.zzsq()     // Catch:{ all -> 0x016c }
        L_0x00b7:
            com.google.android.gms.internal.zzke r0 = r6.zza((java.lang.String) r0, (com.google.android.gms.internal.zzgg) r1)     // Catch:{ all -> 0x016c }
            android.os.Handler r1 = com.google.android.gms.ads.internal.util.client.zza.zzctj     // Catch:{ all -> 0x016c }
            com.google.android.gms.internal.zzjy$1 r3 = new com.google.android.gms.internal.zzjy$1     // Catch:{ all -> 0x016c }
            r3.<init>(r0)     // Catch:{ all -> 0x016c }
            r1.post(r3)     // Catch:{ all -> 0x016c }
            monitor-exit(r2)     // Catch:{ all -> 0x016c }
        L_0x00c6:
            return
        L_0x00c7:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00c7 }
            throw r0
        L_0x00ca:
            r0 = move-exception
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x013c }
            r0.interrupt()     // Catch:{ all -> 0x013c }
            java.lang.Object r2 = r6.zzakd
            monitor-enter(r2)
            java.util.ArrayList<java.lang.String> r0 = r6.zzcnq     // Catch:{ all -> 0x0106 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0106 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0106 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0106 }
            if (r1 != 0) goto L_0x00f6
            java.util.HashMap<java.lang.String, com.google.android.gms.internal.zzjs> r1 = r6.zzcnr     // Catch:{ all -> 0x0106 }
            java.lang.Object r0 = r1.get(r0)     // Catch:{ all -> 0x0106 }
            com.google.android.gms.internal.zzjs r0 = (com.google.android.gms.internal.zzjs) r0     // Catch:{ all -> 0x0106 }
            if (r0 == 0) goto L_0x00f6
            java.util.List<com.google.android.gms.internal.zzjt> r1 = r6.zzcns     // Catch:{ all -> 0x0106 }
            com.google.android.gms.internal.zzjt r0 = r0.zzsp()     // Catch:{ all -> 0x0106 }
            r1.add(r0)     // Catch:{ all -> 0x0106 }
        L_0x00f6:
            monitor-exit(r2)     // Catch:{ all -> 0x0106 }
        L_0x00f7:
            com.google.android.gms.internal.zzke r0 = r6.zzst()
            android.os.Handler r1 = com.google.android.gms.ads.internal.util.client.zza.zzctj
            com.google.android.gms.internal.zzjy$2 r2 = new com.google.android.gms.internal.zzjy$2
            r2.<init>(r0)
            r1.post(r2)
            goto L_0x00c6
        L_0x0106:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0106 }
            throw r0
        L_0x0109:
            r0 = move-exception
            java.lang.String r2 = "Unable to resolve rewarded adapter."
            com.google.android.gms.internal.zzkn.zzd(r2, r0)     // Catch:{ all -> 0x013c }
            java.lang.Object r2 = r6.zzakd
            monitor-enter(r2)
            java.util.ArrayList<java.lang.String> r0 = r6.zzcnq     // Catch:{ all -> 0x0139 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0139 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0139 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0139 }
            if (r3 != 0) goto L_0x0133
            java.util.HashMap<java.lang.String, com.google.android.gms.internal.zzjs> r3 = r6.zzcnr     // Catch:{ all -> 0x0139 }
            java.lang.Object r0 = r3.get(r0)     // Catch:{ all -> 0x0139 }
            com.google.android.gms.internal.zzjs r0 = (com.google.android.gms.internal.zzjs) r0     // Catch:{ all -> 0x0139 }
            if (r0 == 0) goto L_0x0133
            java.util.List<com.google.android.gms.internal.zzjt> r3 = r6.zzcns     // Catch:{ all -> 0x0139 }
            com.google.android.gms.internal.zzjt r0 = r0.zzsp()     // Catch:{ all -> 0x0139 }
            r3.add(r0)     // Catch:{ all -> 0x0139 }
        L_0x0133:
            monitor-exit(r2)     // Catch:{ all -> 0x0139 }
        L_0x0134:
            int r0 = r1 + 1
            r1 = r0
            goto L_0x0052
        L_0x0139:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0139 }
            throw r0
        L_0x013c:
            r0 = move-exception
            r2 = r0
            java.lang.Object r3 = r6.zzakd
            monitor-enter(r3)
            java.util.ArrayList<java.lang.String> r0 = r6.zzcnq     // Catch:{ all -> 0x0164 }
            java.lang.Object r0 = r0.get(r1)     // Catch:{ all -> 0x0164 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0164 }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0164 }
            if (r1 != 0) goto L_0x0162
            java.util.HashMap<java.lang.String, com.google.android.gms.internal.zzjs> r1 = r6.zzcnr     // Catch:{ all -> 0x0164 }
            java.lang.Object r0 = r1.get(r0)     // Catch:{ all -> 0x0164 }
            com.google.android.gms.internal.zzjs r0 = (com.google.android.gms.internal.zzjs) r0     // Catch:{ all -> 0x0164 }
            if (r0 == 0) goto L_0x0162
            java.util.List<com.google.android.gms.internal.zzjt> r1 = r6.zzcns     // Catch:{ all -> 0x0164 }
            com.google.android.gms.internal.zzjt r0 = r0.zzsp()     // Catch:{ all -> 0x0164 }
            r1.add(r0)     // Catch:{ all -> 0x0164 }
        L_0x0162:
            monitor-exit(r3)     // Catch:{ all -> 0x0164 }
            throw r2
        L_0x0164:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0164 }
            throw r0
        L_0x0167:
            r1 = 0
            goto L_0x00b7
        L_0x016a:
            monitor-exit(r2)     // Catch:{ all -> 0x016c }
            goto L_0x0134
        L_0x016c:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x016c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzjy.zzfc():void");
    }
}
