package com.google.android.gms.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import android.util.Base64;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzfs;
import com.google.android.gms.internal.zzjh;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Pattern;

@zziy
public class zzfq {
    private final Map<zzfr, zzfs> zzbpe = new HashMap();
    private final LinkedList<zzfr> zzbpf = new LinkedList<>();
    @Nullable
    private zzfn zzbpg;

    private static void zza(String str, zzfr zzfr) {
        if (zzkn.zzbf(2)) {
            zzkn.m1493v(String.format(str, new Object[]{zzfr}));
        }
    }

    private String[] zzbh(String str) {
        try {
            String[] split = str.split("\u0000");
            for (int i = 0; i < split.length; i++) {
                split[i] = new String(Base64.decode(split[i], 0), "UTF-8");
            }
            return split;
        } catch (UnsupportedEncodingException e) {
            return new String[0];
        }
    }

    private boolean zzbi(String str) {
        try {
            return Pattern.matches(zzdi.zzbdp.get(), str);
        } catch (RuntimeException e) {
            zzu.zzgd().zza((Throwable) e, "InterstitialAdPool.isExcludedAdUnit");
            return false;
        }
    }

    private static void zzc(Bundle bundle, String str) {
        String[] split = str.split("/", 2);
        if (split.length != 0) {
            String str2 = split[0];
            if (split.length == 1) {
                bundle.remove(str2);
                return;
            }
            Bundle bundle2 = bundle.getBundle(str2);
            if (bundle2 != null) {
                zzc(bundle2, split[1]);
            }
        }
    }

    @Nullable
    static Bundle zzk(AdRequestParcel adRequestParcel) {
        Bundle bundle = adRequestParcel.zzawn;
        if (bundle == null) {
            return null;
        }
        return bundle.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
    }

    static AdRequestParcel zzl(AdRequestParcel adRequestParcel) {
        AdRequestParcel zzo = zzo(adRequestParcel);
        Bundle zzk = zzk(zzo);
        if (zzk == null) {
            zzk = new Bundle();
            zzo.zzawn.putBundle("com.google.ads.mediation.admob.AdMobAdapter", zzk);
        }
        zzk.putBoolean("_skipMediation", true);
        return zzo;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r1 = r1.getBundle("com.google.ads.mediation.admob.AdMobAdapter");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean zzm(com.google.android.gms.ads.internal.client.AdRequestParcel r3) {
        /*
            r0 = 0
            android.os.Bundle r1 = r3.zzawn
            if (r1 != 0) goto L_0x0006
        L_0x0005:
            return r0
        L_0x0006:
            java.lang.String r2 = "com.google.ads.mediation.admob.AdMobAdapter"
            android.os.Bundle r1 = r1.getBundle(r2)
            if (r1 == 0) goto L_0x0005
            java.lang.String r2 = "_skipMediation"
            boolean r1 = r1.containsKey(r2)
            if (r1 == 0) goto L_0x0005
            r0 = 1
            goto L_0x0005
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfq.zzm(com.google.android.gms.ads.internal.client.AdRequestParcel):boolean");
    }

    private String zzmn() {
        try {
            StringBuilder sb = new StringBuilder();
            Iterator it = this.zzbpf.iterator();
            while (it.hasNext()) {
                sb.append(Base64.encodeToString(((zzfr) it.next()).toString().getBytes("UTF-8"), 0));
                if (it.hasNext()) {
                    sb.append("\u0000");
                }
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    private static AdRequestParcel zzn(AdRequestParcel adRequestParcel) {
        AdRequestParcel zzo = zzo(adRequestParcel);
        for (String zzc : zzdi.zzbdl.get().split(",")) {
            zzc(zzo.zzawn, zzc);
        }
        return zzo;
    }

    static AdRequestParcel zzo(AdRequestParcel adRequestParcel) {
        Parcel obtain = Parcel.obtain();
        adRequestParcel.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        AdRequestParcel adRequestParcel2 = (AdRequestParcel) AdRequestParcel.CREATOR.createFromParcel(obtain);
        obtain.recycle();
        AdRequestParcel.zzj(adRequestParcel2);
        return adRequestParcel2;
    }

    /* access modifiers changed from: package-private */
    public void flush() {
        while (this.zzbpf.size() > 0) {
            zzfr remove = this.zzbpf.remove();
            zzfs zzfs = this.zzbpe.get(remove);
            zza("Flushing interstitial queue for %s.", remove);
            while (zzfs.size() > 0) {
                zzfs.zzp((AdRequestParcel) null).zzbpl.zzfa();
            }
            this.zzbpe.remove(remove);
        }
    }

    /* access modifiers changed from: package-private */
    public void restore() {
        if (this.zzbpg != null) {
            SharedPreferences sharedPreferences = this.zzbpg.getApplicationContext().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0);
            flush();
            try {
                HashMap hashMap = new HashMap();
                for (Map.Entry next : sharedPreferences.getAll().entrySet()) {
                    if (!((String) next.getKey()).equals("PoolKeys")) {
                        zzfu zzbj = zzfu.zzbj((String) next.getValue());
                        zzfr zzfr = new zzfr(zzbj.zzaow, zzbj.zzang, zzbj.zzbpj);
                        if (!this.zzbpe.containsKey(zzfr)) {
                            this.zzbpe.put(zzfr, new zzfs(zzbj.zzaow, zzbj.zzang, zzbj.zzbpj));
                            hashMap.put(zzfr.toString(), zzfr);
                            zza("Restored interstitial queue for %s.", zzfr);
                        }
                    }
                }
                for (String str : zzbh(sharedPreferences.getString("PoolKeys", ""))) {
                    zzfr zzfr2 = (zzfr) hashMap.get(str);
                    if (this.zzbpe.containsKey(zzfr2)) {
                        this.zzbpf.add(zzfr2);
                    }
                }
            } catch (Throwable th) {
                zzu.zzgd().zza(th, "InterstitialAdPool.restore");
                zzkn.zzd("Malformed preferences value for InterstitialAdPool.", th);
                this.zzbpe.clear();
                this.zzbpf.clear();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void save() {
        if (this.zzbpg != null) {
            SharedPreferences.Editor edit = this.zzbpg.getApplicationContext().getSharedPreferences("com.google.android.gms.ads.internal.interstitial.InterstitialAdPool", 0).edit();
            edit.clear();
            for (Map.Entry next : this.zzbpe.entrySet()) {
                zzfr zzfr = (zzfr) next.getKey();
                zzfs zzfs = (zzfs) next.getValue();
                if (zzfs.zzms()) {
                    edit.putString(zzfr.toString(), new zzfu(zzfs).zzmv());
                    zza("Saved interstitial queue for %s.", zzfr);
                }
            }
            edit.putString("PoolKeys", zzmn());
            edit.apply();
        }
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public zzfs.zza zza(AdRequestParcel adRequestParcel, String str) {
        zzfs zzfs;
        if (zzbi(str)) {
            return null;
        }
        int i = new zzjh.zza(this.zzbpg.getApplicationContext()).zzsk().zzcmd;
        AdRequestParcel zzn = zzn(adRequestParcel);
        zzfr zzfr = new zzfr(zzn, str, i);
        zzfs zzfs2 = this.zzbpe.get(zzfr);
        if (zzfs2 == null) {
            zza("Interstitial pool created at %s.", zzfr);
            zzfs zzfs3 = new zzfs(zzn, str, i);
            this.zzbpe.put(zzfr, zzfs3);
            zzfs = zzfs3;
        } else {
            zzfs = zzfs2;
        }
        this.zzbpf.remove(zzfr);
        this.zzbpf.add(zzfr);
        zzfs.zzmr();
        while (this.zzbpf.size() > zzdi.zzbdm.get().intValue()) {
            zzfr remove = this.zzbpf.remove();
            zzfs zzfs4 = this.zzbpe.get(remove);
            zza("Evicting interstitial queue for %s.", remove);
            while (zzfs4.size() > 0) {
                zzfs4.zzp((AdRequestParcel) null).zzbpl.zzfa();
            }
            this.zzbpe.remove(remove);
        }
        while (zzfs.size() > 0) {
            zzfs.zza zzp = zzfs.zzp(zzn);
            if (!zzp.zzbpp || zzu.zzgf().currentTimeMillis() - zzp.zzbpo <= 1000 * ((long) zzdi.zzbdo.get().intValue())) {
                String str2 = zzp.zzbpm != null ? " (inline) " : " ";
                zza(new StringBuilder(String.valueOf(str2).length() + 34).append("Pooled interstitial").append(str2).append("returned at %s.").toString(), zzfr);
                return zzp;
            }
            zza("Expired interstitial at %s.", zzfr);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public void zza(zzfn zzfn) {
        if (this.zzbpg == null) {
            this.zzbpg = zzfn.zzml();
            restore();
        }
    }

    /* access modifiers changed from: package-private */
    public void zzb(AdRequestParcel adRequestParcel, String str) {
        if (this.zzbpg != null) {
            int i = new zzjh.zza(this.zzbpg.getApplicationContext()).zzsk().zzcmd;
            AdRequestParcel zzn = zzn(adRequestParcel);
            zzfr zzfr = new zzfr(zzn, str, i);
            zzfs zzfs = this.zzbpe.get(zzfr);
            if (zzfs == null) {
                zza("Interstitial pool created at %s.", zzfr);
                zzfs = new zzfs(zzn, str, i);
                this.zzbpe.put(zzfr, zzfs);
            }
            zzfs.zza(this.zzbpg, adRequestParcel);
            zzfs.zzmr();
            zza("Inline entry added to the queue at %s.", zzfr);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002e, code lost:
        r2 = r0.size();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzmm() {
        /*
            r9 = this;
            r8 = 2
            com.google.android.gms.internal.zzfn r0 = r9.zzbpg
            if (r0 != 0) goto L_0x0006
        L_0x0005:
            return
        L_0x0006:
            java.util.Map<com.google.android.gms.internal.zzfr, com.google.android.gms.internal.zzfs> r0 = r9.zzbpe
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r3 = r0.iterator()
        L_0x0010:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x0076
            java.lang.Object r0 = r3.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            com.google.android.gms.internal.zzfr r1 = (com.google.android.gms.internal.zzfr) r1
            java.lang.Object r0 = r0.getValue()
            com.google.android.gms.internal.zzfs r0 = (com.google.android.gms.internal.zzfs) r0
            boolean r2 = com.google.android.gms.internal.zzkn.zzbf(r8)
            if (r2 == 0) goto L_0x0056
            int r2 = r0.size()
            int r4 = r0.zzmp()
            if (r4 >= r2) goto L_0x0056
            java.lang.String r5 = "Loading %s/%s pooled interstitials for %s."
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r7 = 0
            int r4 = r2 - r4
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r6[r7] = r4
            r4 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6[r4] = r2
            r6[r8] = r1
            java.lang.String r2 = java.lang.String.format(r5, r6)
            com.google.android.gms.internal.zzkn.m1493v(r2)
        L_0x0056:
            r0.zzmq()
        L_0x0059:
            int r4 = r0.size()
            com.google.android.gms.internal.zzde<java.lang.Integer> r2 = com.google.android.gms.internal.zzdi.zzbdn
            java.lang.Object r2 = r2.get()
            java.lang.Integer r2 = (java.lang.Integer) r2
            int r2 = r2.intValue()
            if (r4 >= r2) goto L_0x0010
            java.lang.String r2 = "Pooling and loading one new interstitial for %s."
            zza((java.lang.String) r2, (com.google.android.gms.internal.zzfr) r1)
            com.google.android.gms.internal.zzfn r2 = r9.zzbpg
            r0.zzb((com.google.android.gms.internal.zzfn) r2)
            goto L_0x0059
        L_0x0076:
            r9.save()
            goto L_0x0005
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfq.zzmm():void");
    }
}
