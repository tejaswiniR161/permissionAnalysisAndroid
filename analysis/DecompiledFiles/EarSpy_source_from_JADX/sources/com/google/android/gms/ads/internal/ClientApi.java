package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.Keep;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.client.zzu;
import com.google.android.gms.ads.internal.client.zzx;
import com.google.android.gms.ads.internal.client.zzz;
import com.google.android.gms.ads.internal.formats.zzl;
import com.google.android.gms.ads.internal.reward.client.zzb;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdz;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzgq;
import com.google.android.gms.internal.zzhp;
import com.google.android.gms.internal.zzhy;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzjq;

@Keep
@zziy
@DynamiteApi
public class ClientApi extends zzx.zza {
    public zzs createAdLoaderBuilder(zzd zzd, String str, zzgq zzgq, int i) {
        return new zzk((Context) zze.zzae(zzd), str, zzgq, new VersionInfoParcel(zzf.f1696BA, i, true), zzd.zzeq());
    }

    public zzhp createAdOverlay(zzd zzd) {
        return new com.google.android.gms.ads.internal.overlay.zzd((Activity) zze.zzae(zzd));
    }

    public zzu createBannerAdManager(zzd zzd, AdSizeParcel adSizeParcel, String str, zzgq zzgq, int i) throws RemoteException {
        return new zzf((Context) zze.zzae(zzd), adSizeParcel, str, zzgq, new VersionInfoParcel(zzf.f1696BA, i, true), zzd.zzeq());
    }

    public zzhy createInAppPurchaseManager(zzd zzd) {
        return new com.google.android.gms.ads.internal.purchase.zze((Activity) zze.zzae(zzd));
    }

    public zzu createInterstitialAdManager(zzd zzd, AdSizeParcel adSizeParcel, String str, zzgq zzgq, int i) throws RemoteException {
        Context context = (Context) zze.zzae(zzd);
        zzdi.initialize(context);
        VersionInfoParcel versionInfoParcel = new VersionInfoParcel(zzf.f1696BA, i, true);
        boolean equals = "reward_mb".equals(adSizeParcel.zzaxi);
        if ((!equals && zzdi.zzbdi.get().booleanValue()) || (equals && zzdi.zzbdj.get().booleanValue())) {
            return new zzft(context, str, zzgq, versionInfoParcel, zzd.zzeq());
        }
        return new zzl(context, adSizeParcel, str, zzgq, versionInfoParcel, zzd.zzeq());
    }

    public zzdz createNativeAdViewDelegate(zzd zzd, zzd zzd2) {
        return new zzl((FrameLayout) zze.zzae(zzd), (FrameLayout) zze.zzae(zzd2));
    }

    public zzb createRewardedVideoAd(zzd zzd, zzgq zzgq, int i) {
        return new zzjq((Context) zze.zzae(zzd), zzd.zzeq(), zzgq, new VersionInfoParcel(zzf.f1696BA, i, true));
    }

    public zzu createSearchAdManager(zzd zzd, AdSizeParcel adSizeParcel, String str, int i) throws RemoteException {
        return new zzt((Context) zze.zzae(zzd), adSizeParcel, str, new VersionInfoParcel(zzf.f1696BA, i, true));
    }

    @Nullable
    public zzz getMobileAdsSettingsManager(zzd zzd) {
        return null;
    }

    public zzz getMobileAdsSettingsManagerWithClientJarVersion(zzd zzd, int i) {
        return zzo.zza((Context) zze.zzae(zzd), new VersionInfoParcel(zzf.f1696BA, i, true));
    }
}
