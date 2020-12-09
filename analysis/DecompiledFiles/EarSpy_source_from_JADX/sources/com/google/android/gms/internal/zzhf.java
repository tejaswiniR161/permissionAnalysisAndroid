package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.overlay.AdLauncherIntentInfoParcel;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.internal.zzdw;

@zziy
public class zzhf implements MediationInterstitialAdapter {
    private Uri mUri;
    /* access modifiers changed from: private */
    public Activity zzbul;
    /* access modifiers changed from: private */
    public zzdw zzbum;
    /* access modifiers changed from: private */
    public MediationInterstitialListener zzbun;

    public static boolean zzp(Context context) {
        return zzdw.zzo(context);
    }

    public void onDestroy() {
        zzb.zzdd("Destroying AdMobCustomTabsAdapter adapter.");
        try {
            this.zzbum.zzd(this.zzbul);
        } catch (Exception e) {
            zzb.zzb("Exception while unbinding from CustomTabsService.", e);
        }
    }

    public void onPause() {
        zzb.zzdd("Pausing AdMobCustomTabsAdapter adapter.");
    }

    public void onResume() {
        zzb.zzdd("Resuming AdMobCustomTabsAdapter adapter.");
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzbun = mediationInterstitialListener;
        if (this.zzbun == null) {
            zzb.zzdf("Listener not set for mediation. Returning.");
        } else if (!(context instanceof Activity)) {
            zzb.zzdf("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.zzbun.onAdFailedToLoad(this, 0);
        } else if (!zzp(context)) {
            zzb.zzdf("Default browser does not support custom tabs. Bailing out.");
            this.zzbun.onAdFailedToLoad(this, 0);
        } else {
            String string = bundle.getString("tab_url");
            if (TextUtils.isEmpty(string)) {
                zzb.zzdf("The tab_url retrieved from mediation metadata is empty. Bailing out.");
                this.zzbun.onAdFailedToLoad(this, 0);
                return;
            }
            this.zzbul = (Activity) context;
            this.mUri = Uri.parse(string);
            this.zzbum = new zzdw();
            this.zzbum.zza((zzdw.zza) new zzdw.zza() {
                public void zzlh() {
                    zzb.zzdd("Hinting CustomTabsService for the load of the new url.");
                }

                public void zzli() {
                    zzb.zzdd("Disconnecting from CustomTabs service.");
                }
            });
            this.zzbum.zze(this.zzbul);
            this.zzbun.onAdLoaded(this);
        }
    }

    public void showInterstitial() {
        CustomTabsIntent build = new CustomTabsIntent.Builder(this.zzbum.zzlf()).build();
        build.intent.setData(this.mUri);
        final AdOverlayInfoParcel adOverlayInfoParcel = new AdOverlayInfoParcel(new AdLauncherIntentInfoParcel(build.intent), (zza) null, new zzg() {
            public void onPause() {
                zzb.zzdd("AdMobCustomTabsAdapter overlay is paused.");
            }

            public void onResume() {
                zzb.zzdd("AdMobCustomTabsAdapter overlay is resumed.");
            }

            public void zzed() {
                zzb.zzdd("AdMobCustomTabsAdapter overlay is closed.");
                zzhf.this.zzbun.onAdClosed(zzhf.this);
                zzhf.this.zzbum.zzd(zzhf.this.zzbul);
            }

            public void zzee() {
                zzb.zzdd("Opening AdMobCustomTabsAdapter overlay.");
                zzhf.this.zzbun.onAdOpened(zzhf.this);
            }
        }, (zzp) null, new VersionInfoParcel(0, 0, false));
        zzkr.zzcrf.post(new Runnable() {
            public void run() {
                zzu.zzfx().zza(zzhf.this.zzbul, adOverlayInfoParcel);
            }
        });
        zzu.zzgd().zzag(false);
    }
}
