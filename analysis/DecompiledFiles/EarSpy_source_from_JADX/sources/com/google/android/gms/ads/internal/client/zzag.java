package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.reward.client.zzi;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzgp;
import com.google.android.gms.internal.zzgq;
import com.google.android.gms.internal.zziy;

@zziy
public class zzag {
    private static final Object zzaok = new Object();
    private static zzag zzazh;
    private zzz zzazi;
    private RewardedVideoAd zzazj;

    private zzag() {
    }

    public static zzag zzki() {
        zzag zzag;
        synchronized (zzaok) {
            if (zzazh == null) {
                zzazh = new zzag();
            }
            zzag = zzazh;
        }
        return zzag;
    }

    public RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        RewardedVideoAd rewardedVideoAd;
        synchronized (zzaok) {
            if (this.zzazj != null) {
                rewardedVideoAd = this.zzazj;
            } else {
                this.zzazj = new zzi(context, zzm.zzjs().zza(context, (zzgq) new zzgp()));
                rewardedVideoAd = this.zzazj;
            }
        }
        return rewardedVideoAd;
    }

    public void openDebugMenu(Context context, String str) {
        zzac.zza(this.zzazi != null, (Object) "MobileAds.initialize() must be called prior to opening debug menu.");
        try {
            this.zzazi.zzb(zze.zzac(context), str);
        } catch (RemoteException e) {
            zzb.zzb("Unable to open debug menu.", e);
        }
    }

    public void setAppMuted(boolean z) {
        zzac.zza(this.zzazi != null, (Object) "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.zzazi.setAppMuted(z);
        } catch (RemoteException e) {
            zzb.zzb("Unable to set app mute state.", e);
        }
    }

    public void setAppVolume(float f) {
        boolean z = true;
        zzac.zzb(0.0f <= f && f <= 1.0f, (Object) "The app volume must be a value between 0 and 1 inclusive.");
        if (this.zzazi == null) {
            z = false;
        }
        zzac.zza(z, (Object) "MobileAds.initialize() must be called prior to setting the app volume.");
        try {
            this.zzazi.setAppVolume(f);
        } catch (RemoteException e) {
            zzb.zzb("Unable to set app volume.", e);
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zza(android.content.Context r4, java.lang.String r5, com.google.android.gms.ads.internal.client.zzah r6) {
        /*
            r3 = this;
            java.lang.Object r1 = zzaok
            monitor-enter(r1)
            com.google.android.gms.ads.internal.client.zzz r0 = r3.zzazi     // Catch:{ all -> 0x0013 }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r1)     // Catch:{ all -> 0x0013 }
        L_0x0008:
            return
        L_0x0009:
            if (r4 != 0) goto L_0x0016
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x0013 }
            java.lang.String r2 = "Context cannot be null."
            r0.<init>(r2)     // Catch:{ all -> 0x0013 }
            throw r0     // Catch:{ all -> 0x0013 }
        L_0x0013:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0013 }
            throw r0
        L_0x0016:
            com.google.android.gms.ads.internal.client.zzl r0 = com.google.android.gms.ads.internal.client.zzm.zzjs()     // Catch:{ RemoteException -> 0x002e }
            com.google.android.gms.ads.internal.client.zzz r0 = r0.zzl(r4)     // Catch:{ RemoteException -> 0x002e }
            r3.zzazi = r0     // Catch:{ RemoteException -> 0x002e }
            com.google.android.gms.ads.internal.client.zzz r0 = r3.zzazi     // Catch:{ RemoteException -> 0x002e }
            r0.initialize()     // Catch:{ RemoteException -> 0x002e }
            if (r5 == 0) goto L_0x002c
            com.google.android.gms.ads.internal.client.zzz r0 = r3.zzazi     // Catch:{ RemoteException -> 0x002e }
            r0.zzw(r5)     // Catch:{ RemoteException -> 0x002e }
        L_0x002c:
            monitor-exit(r1)     // Catch:{ all -> 0x0013 }
            goto L_0x0008
        L_0x002e:
            r0 = move-exception
            java.lang.String r2 = "Fail to initialize or set applicationCode on mobile ads setting manager"
            com.google.android.gms.ads.internal.util.client.zzb.zzd(r2, r0)     // Catch:{ all -> 0x0013 }
            goto L_0x002c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.client.zzag.zza(android.content.Context, java.lang.String, com.google.android.gms.ads.internal.client.zzah):void");
    }
}
