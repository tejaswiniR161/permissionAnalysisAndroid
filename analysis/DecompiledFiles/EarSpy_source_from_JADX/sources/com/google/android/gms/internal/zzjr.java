package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzi;
import com.google.android.gms.ads.internal.reward.client.RewardedVideoAdRequestParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzke;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public class zzjr extends zzb implements zzjv {
    private static final zzgp zzcmu = new zzgp();
    private final Map<String, zzjz> zzcmv = new HashMap();
    private boolean zzcmw;

    public zzjr(Context context, zzd zzd, AdSizeParcel adSizeParcel, zzgq zzgq, VersionInfoParcel versionInfoParcel) {
        super(context, adSizeParcel, (String) null, zzgq, versionInfoParcel, zzd);
    }

    private zzke.zza zzd(zzke.zza zza) {
        zzkn.m1493v("Creating mediation ad response for non-mediated rewarded ad.");
        try {
            String jSONObject = zzjc.zzc(zza.zzcop).toString();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, zza.zzcix.zzaqt);
            return new zzke.zza(zza.zzcix, zza.zzcop, new zzgh(Arrays.asList(new zzgg[]{new zzgg(jSONObject, (String) null, Arrays.asList(new String[]{"com.google.ads.mediation.admob.AdMobAdapter"}), (String) null, (String) null, Collections.emptyList(), Collections.emptyList(), jSONObject2.toString(), (String) null, Collections.emptyList(), Collections.emptyList(), (String) null, (String) null, (String) null, (List<String>) null, (String) null, Collections.emptyList())}), -1, Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), false, "", -1, 0, 1, (String) null, 0, -1, -1, false), zza.zzaqz, zza.errorCode, zza.zzcoj, zza.zzcok, zza.zzcod);
        } catch (JSONException e) {
            zzkn.zzb("Unable to generate ad state for non-mediated rewarded video.", e);
            return zze(zza);
        }
    }

    private zzke.zza zze(zzke.zza zza) {
        return new zzke.zza(zza.zzcix, zza.zzcop, (zzgh) null, zza.zzaqz, 0, zza.zzcoj, zza.zzcok, zza.zzcod);
    }

    public void destroy() {
        zzac.zzhq("destroy must be called on the main UI thread.");
        for (String next : this.zzcmv.keySet()) {
            try {
                zzjz zzjz = this.zzcmv.get(next);
                if (!(zzjz == null || zzjz.zzsv() == null)) {
                    zzjz.zzsv().destroy();
                }
            } catch (RemoteException e) {
                String valueOf = String.valueOf(next);
                zzkn.zzdf(valueOf.length() != 0 ? "Fail to destroy adapter: ".concat(valueOf) : new String("Fail to destroy adapter: "));
            }
        }
    }

    public boolean isLoaded() {
        zzac.zzhq("isLoaded must be called on the main UI thread.");
        return this.zzall.zzaqx == null && this.zzall.zzaqy == null && this.zzall.zzara != null && !this.zzcmw;
    }

    public void onContextChanged(@NonNull Context context) {
        for (zzjz zzsv : this.zzcmv.values()) {
            try {
                zzsv.zzsv().zzj(zze.zzac(context));
            } catch (RemoteException e) {
                zzkn.zzb("Unable to call Adapter.onContextChanged.", e);
            }
        }
    }

    public void onRewardedVideoAdClosed() {
        zzdx();
    }

    public void onRewardedVideoAdLeftApplication() {
        zzdy();
    }

    public void onRewardedVideoAdOpened() {
        zza(this.zzall.zzara, false);
        zzdz();
    }

    public void onRewardedVideoStarted() {
        if (!(this.zzall.zzara == null || this.zzall.zzara.zzbte == null)) {
            zzu.zzgs().zza(this.zzall.zzahn, this.zzall.zzaqv.zzcs, this.zzall.zzara, this.zzall.zzaqt, false, this.zzall.zzara.zzbte.zzbru);
        }
        zzeb();
    }

    public void pause() {
        zzac.zzhq("pause must be called on the main UI thread.");
        for (String next : this.zzcmv.keySet()) {
            try {
                zzjz zzjz = this.zzcmv.get(next);
                if (!(zzjz == null || zzjz.zzsv() == null)) {
                    zzjz.zzsv().pause();
                }
            } catch (RemoteException e) {
                String valueOf = String.valueOf(next);
                zzkn.zzdf(valueOf.length() != 0 ? "Fail to pause adapter: ".concat(valueOf) : new String("Fail to pause adapter: "));
            }
        }
    }

    public void resume() {
        zzac.zzhq("resume must be called on the main UI thread.");
        for (String next : this.zzcmv.keySet()) {
            try {
                zzjz zzjz = this.zzcmv.get(next);
                if (!(zzjz == null || zzjz.zzsv() == null)) {
                    zzjz.zzsv().resume();
                }
            } catch (RemoteException e) {
                String valueOf = String.valueOf(next);
                zzkn.zzdf(valueOf.length() != 0 ? "Fail to resume adapter: ".concat(valueOf) : new String("Fail to resume adapter: "));
            }
        }
    }

    public void zza(RewardedVideoAdRequestParcel rewardedVideoAdRequestParcel) {
        zzac.zzhq("loadAd must be called on the main UI thread.");
        if (TextUtils.isEmpty(rewardedVideoAdRequestParcel.zzaqt)) {
            zzkn.zzdf("Invalid ad unit id. Aborting.");
            zzkr.zzcrf.post(new Runnable() {
                public void run() {
                    zzjr.this.zzh(1);
                }
            });
            return;
        }
        this.zzcmw = false;
        this.zzall.zzaqt = rewardedVideoAdRequestParcel.zzaqt;
        super.zzb(rewardedVideoAdRequestParcel.zzcfu);
    }

    public void zza(final zzke.zza zza, zzdq zzdq) {
        if (zza.errorCode != -2) {
            zzkr.zzcrf.post(new Runnable() {
                public void run() {
                    zzjr.this.zzb(new zzke(zza, (zzlt) null, (zzgg) null, (zzgr) null, (String) null, (zzgj) null, (zzi.zza) null, (String) null));
                }
            });
            return;
        }
        this.zzall.zzarb = zza;
        if (zza.zzcof == null) {
            this.zzall.zzarb = zzd(zza);
        }
        this.zzall.zzarv = 0;
        this.zzall.zzaqy = zzu.zzfy().zza(this.zzall.zzahn, this.zzall.zzarb, this);
    }

    /* access modifiers changed from: protected */
    public boolean zza(AdRequestParcel adRequestParcel, zzke zzke, boolean z) {
        return false;
    }

    public boolean zza(zzke zzke, zzke zzke2) {
        return true;
    }

    public void zzc(@Nullable RewardItemParcel rewardItemParcel) {
        if (!(this.zzall.zzara == null || this.zzall.zzara.zzbte == null)) {
            zzu.zzgs().zza(this.zzall.zzahn, this.zzall.zzaqv.zzcs, this.zzall.zzara, this.zzall.zzaqt, false, this.zzall.zzara.zzbte.zzbrv);
        }
        if (!(this.zzall.zzara == null || this.zzall.zzara.zzcof == null || TextUtils.isEmpty(this.zzall.zzara.zzcof.zzbsk))) {
            rewardItemParcel = new RewardItemParcel(this.zzall.zzara.zzcof.zzbsk, this.zzall.zzara.zzcof.zzbsl);
        }
        zza(rewardItemParcel);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f  */
    @android.support.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzjz zzcl(java.lang.String r6) {
        /*
            r5 = this;
            java.util.Map<java.lang.String, com.google.android.gms.internal.zzjz> r0 = r5.zzcmv
            java.lang.Object r0 = r0.get(r6)
            com.google.android.gms.internal.zzjz r0 = (com.google.android.gms.internal.zzjz) r0
            if (r0 != 0) goto L_0x0026
            com.google.android.gms.internal.zzgq r1 = r5.zzals     // Catch:{ Exception -> 0x0027 }
            java.lang.String r2 = "com.google.ads.mediation.admob.AdMobAdapter"
            boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x0027 }
            if (r2 == 0) goto L_0x0048
            com.google.android.gms.internal.zzgp r1 = zzcmu     // Catch:{ Exception -> 0x0027 }
            r2 = r1
        L_0x0017:
            com.google.android.gms.internal.zzjz r1 = new com.google.android.gms.internal.zzjz     // Catch:{ Exception -> 0x0027 }
            com.google.android.gms.internal.zzgr r2 = r2.zzbq(r6)     // Catch:{ Exception -> 0x0027 }
            r1.<init>(r2, r5)     // Catch:{ Exception -> 0x0027 }
            java.util.Map<java.lang.String, com.google.android.gms.internal.zzjz> r0 = r5.zzcmv     // Catch:{ Exception -> 0x0045 }
            r0.put(r6, r1)     // Catch:{ Exception -> 0x0045 }
            r0 = r1
        L_0x0026:
            return r0
        L_0x0027:
            r1 = move-exception
            r2 = r1
            r1 = r0
        L_0x002a:
            java.lang.String r3 = "Fail to instantiate adapter "
            java.lang.String r0 = java.lang.String.valueOf(r6)
            int r4 = r0.length()
            if (r4 == 0) goto L_0x003f
            java.lang.String r0 = r3.concat(r0)
        L_0x003a:
            com.google.android.gms.internal.zzkn.zzd(r0, r2)
            r0 = r1
            goto L_0x0026
        L_0x003f:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3)
            goto L_0x003a
        L_0x0045:
            r0 = move-exception
            r2 = r0
            goto L_0x002a
        L_0x0048:
            r2 = r1
            goto L_0x0017
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzjr.zzcl(java.lang.String):com.google.android.gms.internal.zzjz");
    }

    public void zzsn() {
        zzac.zzhq("showAd must be called on the main UI thread.");
        if (!isLoaded()) {
            zzkn.zzdf("The reward video has not loaded.");
            return;
        }
        this.zzcmw = true;
        zzjz zzcl = zzcl(this.zzall.zzara.zzbtg);
        if (zzcl != null && zzcl.zzsv() != null) {
            try {
                zzcl.zzsv().showVideo();
            } catch (RemoteException e) {
                zzkn.zzd("Could not call showVideo.", e);
            }
        }
    }

    public void zzso() {
        onAdClicked();
    }
}
