package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.widget.FrameLayout;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.ads.internal.client.zzx;
import com.google.android.gms.ads.internal.reward.client.zzf;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdz;
import com.google.android.gms.internal.zzel;
import com.google.android.gms.internal.zzgq;
import com.google.android.gms.internal.zzho;
import com.google.android.gms.internal.zzhp;
import com.google.android.gms.internal.zzhy;
import com.google.android.gms.internal.zzid;
import com.google.android.gms.internal.zziy;

@zziy
public class zzl {
    private final Object zzakd = new Object();
    private zzx zzaxq;
    /* access modifiers changed from: private */
    public final zze zzaxr;
    /* access modifiers changed from: private */
    public final zzd zzaxs;
    /* access modifiers changed from: private */
    public final zzai zzaxt;
    /* access modifiers changed from: private */
    public final zzel zzaxu;
    /* access modifiers changed from: private */
    public final zzf zzaxv;
    /* access modifiers changed from: private */
    public final zzid zzaxw;
    /* access modifiers changed from: private */
    public final zzho zzaxx;

    @VisibleForTesting
    abstract class zza<T> {
        zza() {
        }

        /* access modifiers changed from: protected */
        @Nullable
        public abstract T zzb(zzx zzx) throws RemoteException;

        /* access modifiers changed from: protected */
        @Nullable
        public abstract T zzjh() throws RemoteException;

        /* access modifiers changed from: protected */
        @Nullable
        public final T zzjo() {
            zzx zza = zzl.this.zzjf();
            if (zza == null) {
                zzb.zzdf("ClientApi class cannot be loaded.");
                return null;
            }
            try {
                return zzb(zza);
            } catch (RemoteException e) {
                zzb.zzd("Cannot invoke local loader using ClientApi class", e);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        @Nullable
        public final T zzjp() {
            try {
                return zzjh();
            } catch (RemoteException e) {
                zzb.zzd("Cannot invoke remote loader", e);
                return null;
            }
        }
    }

    public zzl(zze zze, zzd zzd, zzai zzai, zzel zzel, zzf zzf, zzid zzid, zzho zzho) {
        this.zzaxr = zze;
        this.zzaxs = zzd;
        this.zzaxt = zzai;
        this.zzaxu = zzel;
        this.zzaxv = zzf;
        this.zzaxw = zzid;
        this.zzaxx = zzho;
    }

    private static boolean zza(Activity activity, String str) {
        Intent intent = activity.getIntent();
        if (intent.hasExtra(str)) {
            return intent.getBooleanExtra(str, false);
        }
        zzb.m1352e("useClientJar flag not found in activity intent extras.");
        return false;
    }

    /* access modifiers changed from: private */
    public void zzc(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzm.zzjr().zza(context, (String) null, "gmob-apps", bundle, true);
    }

    @Nullable
    private static zzx zzje() {
        try {
            Object newInstance = zzl.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").newInstance();
            if (newInstance instanceof IBinder) {
                return zzx.zza.asInterface((IBinder) newInstance);
            }
            zzb.zzdf("ClientApi class is not an instance of IBinder");
            return null;
        } catch (Exception e) {
            zzb.zzd("Failed to instantiate ClientApi class.", e);
            return null;
        }
    }

    /* access modifiers changed from: private */
    @Nullable
    public zzx zzjf() {
        zzx zzx;
        synchronized (this.zzakd) {
            if (this.zzaxq == null) {
                this.zzaxq = zzje();
            }
            zzx = this.zzaxq;
        }
        return zzx;
    }

    public zzu zza(final Context context, final AdSizeParcel adSizeParcel, final String str) {
        return (zzu) zza(context, false, new zza<zzu>() {
            /* renamed from: zza */
            public zzu zzb(zzx zzx) throws RemoteException {
                return zzx.createSearchAdManager(zze.zzac(context), adSizeParcel, str, com.google.android.gms.common.internal.zzf.f1696BA);
            }

            /* renamed from: zzjg */
            public zzu zzjh() {
                zzu zza = zzl.this.zzaxr.zza(context, adSizeParcel, str, (zzgq) null, 3);
                if (zza != null) {
                    return zza;
                }
                zzl.this.zzc(context, "search");
                return new zzak();
            }
        });
    }

    public zzu zza(Context context, AdSizeParcel adSizeParcel, String str, zzgq zzgq) {
        final Context context2 = context;
        final AdSizeParcel adSizeParcel2 = adSizeParcel;
        final String str2 = str;
        final zzgq zzgq2 = zzgq;
        return (zzu) zza(context, false, new zza<zzu>() {
            /* renamed from: zza */
            public zzu zzb(zzx zzx) throws RemoteException {
                return zzx.createBannerAdManager(zze.zzac(context2), adSizeParcel2, str2, zzgq2, com.google.android.gms.common.internal.zzf.f1696BA);
            }

            /* renamed from: zzjg */
            public zzu zzjh() {
                zzu zza = zzl.this.zzaxr.zza(context2, adSizeParcel2, str2, zzgq2, 1);
                if (zza != null) {
                    return zza;
                }
                zzl.this.zzc(context2, "banner");
                return new zzak();
            }
        });
    }

    public com.google.android.gms.ads.internal.reward.client.zzb zza(final Context context, final zzgq zzgq) {
        return (com.google.android.gms.ads.internal.reward.client.zzb) zza(context, false, new zza<com.google.android.gms.ads.internal.reward.client.zzb>() {
            /* renamed from: zzf */
            public com.google.android.gms.ads.internal.reward.client.zzb zzb(zzx zzx) throws RemoteException {
                return zzx.createRewardedVideoAd(zze.zzac(context), zzgq, com.google.android.gms.common.internal.zzf.f1696BA);
            }

            /* renamed from: zzjl */
            public com.google.android.gms.ads.internal.reward.client.zzb zzjh() {
                com.google.android.gms.ads.internal.reward.client.zzb zzb = zzl.this.zzaxv.zzb(context, zzgq);
                if (zzb != null) {
                    return zzb;
                }
                zzl.this.zzc(context, "rewarded_video");
                return new zzan();
            }
        });
    }

    public zzdz zza(final Context context, final FrameLayout frameLayout, final FrameLayout frameLayout2) {
        return (zzdz) zza(context, false, new zza<zzdz>() {
            /* renamed from: zze */
            public zzdz zzb(zzx zzx) throws RemoteException {
                return zzx.createNativeAdViewDelegate(zze.zzac(frameLayout), zze.zzac(frameLayout2));
            }

            /* renamed from: zzjk */
            public zzdz zzjh() {
                zzdz zzb = zzl.this.zzaxu.zzb(context, frameLayout, frameLayout2);
                if (zzb != null) {
                    return zzb;
                }
                zzl.this.zzc(context, "native_ad_view_delegate");
                return new zzam();
            }
        });
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public <T> T zza(Context context, boolean z, zza<T> zza2) {
        if (!z && !zzm.zzjr().zzas(context)) {
            zzb.zzdd("Google Play Services is not available");
            z = true;
        }
        if (z) {
            T zzjo = zza2.zzjo();
            return zzjo == null ? zza2.zzjp() : zzjo;
        }
        T zzjp = zza2.zzjp();
        return zzjp == null ? zza2.zzjo() : zzjp;
    }

    public zzs zzb(final Context context, final String str, final zzgq zzgq) {
        return (zzs) zza(context, false, new zza<zzs>() {
            /* renamed from: zzc */
            public zzs zzb(zzx zzx) throws RemoteException {
                return zzx.createAdLoaderBuilder(zze.zzac(context), str, zzgq, com.google.android.gms.common.internal.zzf.f1696BA);
            }

            /* renamed from: zzji */
            public zzs zzjh() {
                zzs zza = zzl.this.zzaxs.zza(context, str, zzgq);
                if (zza != null) {
                    return zza;
                }
                zzl.this.zzc(context, "native_ad");
                return new zzaj();
            }
        });
    }

    public zzu zzb(Context context, AdSizeParcel adSizeParcel, String str, zzgq zzgq) {
        final Context context2 = context;
        final AdSizeParcel adSizeParcel2 = adSizeParcel;
        final String str2 = str;
        final zzgq zzgq2 = zzgq;
        return (zzu) zza(context, false, new zza<zzu>() {
            /* renamed from: zza */
            public zzu zzb(zzx zzx) throws RemoteException {
                return zzx.createInterstitialAdManager(zze.zzac(context2), adSizeParcel2, str2, zzgq2, com.google.android.gms.common.internal.zzf.f1696BA);
            }

            /* renamed from: zzjg */
            public zzu zzjh() {
                zzu zza = zzl.this.zzaxr.zza(context2, adSizeParcel2, str2, zzgq2, 2);
                if (zza != null) {
                    return zza;
                }
                zzl.this.zzc(context2, "interstitial");
                return new zzak();
            }
        });
    }

    @Nullable
    public zzhy zzb(final Activity activity) {
        return (zzhy) zza((Context) activity, zza(activity, "com.google.android.gms.ads.internal.purchase.useClientJar"), new zza<zzhy>() {
            /* renamed from: zzg */
            public zzhy zzb(zzx zzx) throws RemoteException {
                return zzx.createInAppPurchaseManager(zze.zzac(activity));
            }

            /* renamed from: zzjm */
            public zzhy zzjh() {
                zzhy zzg = zzl.this.zzaxw.zzg(activity);
                if (zzg != null) {
                    return zzg;
                }
                zzl.this.zzc(activity, AppLovinEventTypes.USER_COMPLETED_IN_APP_PURCHASE);
                return null;
            }
        });
    }

    @Nullable
    public zzhp zzc(final Activity activity) {
        return (zzhp) zza((Context) activity, zza(activity, "com.google.android.gms.ads.internal.overlay.useClientJar"), new zza<zzhp>() {
            /* renamed from: zzh */
            public zzhp zzb(zzx zzx) throws RemoteException {
                return zzx.createAdOverlay(zze.zzac(activity));
            }

            /* renamed from: zzjn */
            public zzhp zzjh() {
                zzhp zzf = zzl.this.zzaxx.zzf(activity);
                if (zzf != null) {
                    return zzf;
                }
                zzl.this.zzc(activity, "ad_overlay");
                return null;
            }
        });
    }

    public zzz zzl(final Context context) {
        return (zzz) zza(context, false, new zza<zzz>() {
            /* renamed from: zzd */
            public zzz zzb(zzx zzx) throws RemoteException {
                return zzx.getMobileAdsSettingsManagerWithClientJarVersion(zze.zzac(context), com.google.android.gms.common.internal.zzf.f1696BA);
            }

            /* renamed from: zzjj */
            public zzz zzjh() {
                zzz zzm = zzl.this.zzaxt.zzm(context);
                if (zzm != null) {
                    return zzm;
                }
                zzl.this.zzc(context, "mobile_ads_settings");
                return new zzal();
            }
        });
    }
}
