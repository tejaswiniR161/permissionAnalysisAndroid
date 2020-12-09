package com.google.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAdView;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationBannerListener;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationNativeListener;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdListener;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzmh;
import java.util.Date;
import java.util.Set;

@zziy
public abstract class AbstractAdViewAdapter implements MediationBannerAdapter, MediationNativeAdapter, MediationRewardedVideoAdAdapter, zzmh {
    public static final String AD_UNIT_ID_PARAMETER = "pubid";
    protected AdView zzfz;
    protected InterstitialAd zzga;
    private AdLoader zzgb;
    private Context zzgc;
    /* access modifiers changed from: private */
    public InterstitialAd zzgd;
    /* access modifiers changed from: private */
    public MediationRewardedVideoAdListener zzge;
    final RewardedVideoAdListener zzgf = new RewardedVideoAdListener() {
        public void onRewarded(RewardItem rewardItem) {
            AbstractAdViewAdapter.this.zzge.onRewarded(AbstractAdViewAdapter.this, rewardItem);
        }

        public void onRewardedVideoAdClosed() {
            AbstractAdViewAdapter.this.zzge.onAdClosed(AbstractAdViewAdapter.this);
            InterstitialAd unused = AbstractAdViewAdapter.this.zzgd = null;
        }

        public void onRewardedVideoAdFailedToLoad(int i) {
            AbstractAdViewAdapter.this.zzge.onAdFailedToLoad(AbstractAdViewAdapter.this, i);
        }

        public void onRewardedVideoAdLeftApplication() {
            AbstractAdViewAdapter.this.zzge.onAdLeftApplication(AbstractAdViewAdapter.this);
        }

        public void onRewardedVideoAdLoaded() {
            AbstractAdViewAdapter.this.zzge.onAdLoaded(AbstractAdViewAdapter.this);
        }

        public void onRewardedVideoAdOpened() {
            AbstractAdViewAdapter.this.zzge.onAdOpened(AbstractAdViewAdapter.this);
        }

        public void onRewardedVideoStarted() {
            AbstractAdViewAdapter.this.zzge.onVideoStarted(AbstractAdViewAdapter.this);
        }
    };

    static class zza extends NativeAppInstallAdMapper {
        private final NativeAppInstallAd zzgh;

        public zza(NativeAppInstallAd nativeAppInstallAd) {
            this.zzgh = nativeAppInstallAd;
            setHeadline(nativeAppInstallAd.getHeadline().toString());
            setImages(nativeAppInstallAd.getImages());
            setBody(nativeAppInstallAd.getBody().toString());
            setIcon(nativeAppInstallAd.getIcon());
            setCallToAction(nativeAppInstallAd.getCallToAction().toString());
            if (nativeAppInstallAd.getStarRating() != null) {
                setStarRating(nativeAppInstallAd.getStarRating().doubleValue());
            }
            if (nativeAppInstallAd.getStore() != null) {
                setStore(nativeAppInstallAd.getStore().toString());
            }
            if (nativeAppInstallAd.getPrice() != null) {
                setPrice(nativeAppInstallAd.getPrice().toString());
            }
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
            zza(nativeAppInstallAd.getVideoController());
        }

        public void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.zzgh);
            }
        }
    }

    static class zzb extends NativeContentAdMapper {
        private final NativeContentAd zzgi;

        public zzb(NativeContentAd nativeContentAd) {
            this.zzgi = nativeContentAd;
            setHeadline(nativeContentAd.getHeadline().toString());
            setImages(nativeContentAd.getImages());
            setBody(nativeContentAd.getBody().toString());
            if (nativeContentAd.getLogo() != null) {
                setLogo(nativeContentAd.getLogo());
            }
            setCallToAction(nativeContentAd.getCallToAction().toString());
            setAdvertiser(nativeContentAd.getAdvertiser().toString());
            setOverrideImpressionRecording(true);
            setOverrideClickHandling(true);
        }

        public void trackView(View view) {
            if (view instanceof NativeAdView) {
                ((NativeAdView) view).setNativeAd(this.zzgi);
            }
        }
    }

    static final class zzc extends AdListener implements com.google.android.gms.ads.internal.client.zza {
        final AbstractAdViewAdapter zzgj;
        final MediationBannerListener zzgk;

        public zzc(AbstractAdViewAdapter abstractAdViewAdapter, MediationBannerListener mediationBannerListener) {
            this.zzgj = abstractAdViewAdapter;
            this.zzgk = mediationBannerListener;
        }

        public void onAdClicked() {
            this.zzgk.onAdClicked(this.zzgj);
        }

        public void onAdClosed() {
            this.zzgk.onAdClosed(this.zzgj);
        }

        public void onAdFailedToLoad(int i) {
            this.zzgk.onAdFailedToLoad(this.zzgj, i);
        }

        public void onAdLeftApplication() {
            this.zzgk.onAdLeftApplication(this.zzgj);
        }

        public void onAdLoaded() {
            this.zzgk.onAdLoaded(this.zzgj);
        }

        public void onAdOpened() {
            this.zzgk.onAdOpened(this.zzgj);
        }
    }

    static final class zzd extends AdListener implements com.google.android.gms.ads.internal.client.zza {
        final AbstractAdViewAdapter zzgj;
        final MediationInterstitialListener zzgl;

        public zzd(AbstractAdViewAdapter abstractAdViewAdapter, MediationInterstitialListener mediationInterstitialListener) {
            this.zzgj = abstractAdViewAdapter;
            this.zzgl = mediationInterstitialListener;
        }

        public void onAdClicked() {
            this.zzgl.onAdClicked(this.zzgj);
        }

        public void onAdClosed() {
            this.zzgl.onAdClosed(this.zzgj);
        }

        public void onAdFailedToLoad(int i) {
            this.zzgl.onAdFailedToLoad(this.zzgj, i);
        }

        public void onAdLeftApplication() {
            this.zzgl.onAdLeftApplication(this.zzgj);
        }

        public void onAdLoaded() {
            this.zzgl.onAdLoaded(this.zzgj);
        }

        public void onAdOpened() {
            this.zzgl.onAdOpened(this.zzgj);
        }
    }

    static final class zze extends AdListener implements NativeAppInstallAd.OnAppInstallAdLoadedListener, NativeContentAd.OnContentAdLoadedListener, com.google.android.gms.ads.internal.client.zza {
        final AbstractAdViewAdapter zzgj;
        final MediationNativeListener zzgm;

        public zze(AbstractAdViewAdapter abstractAdViewAdapter, MediationNativeListener mediationNativeListener) {
            this.zzgj = abstractAdViewAdapter;
            this.zzgm = mediationNativeListener;
        }

        public void onAdClicked() {
            this.zzgm.onAdClicked(this.zzgj);
        }

        public void onAdClosed() {
            this.zzgm.onAdClosed(this.zzgj);
        }

        public void onAdFailedToLoad(int i) {
            this.zzgm.onAdFailedToLoad(this.zzgj, i);
        }

        public void onAdLeftApplication() {
            this.zzgm.onAdLeftApplication(this.zzgj);
        }

        public void onAdLoaded() {
        }

        public void onAdOpened() {
            this.zzgm.onAdOpened(this.zzgj);
        }

        public void onAppInstallAdLoaded(NativeAppInstallAd nativeAppInstallAd) {
            this.zzgm.onAdLoaded(this.zzgj, new zza(nativeAppInstallAd));
        }

        public void onContentAdLoaded(NativeContentAd nativeContentAd) {
            this.zzgm.onAdLoaded(this.zzgj, new zzb(nativeContentAd));
        }
    }

    public String getAdUnitId(Bundle bundle) {
        return bundle.getString(AD_UNIT_ID_PARAMETER);
    }

    public View getBannerView() {
        return this.zzfz;
    }

    public Bundle getInterstitialAdapterInfo() {
        return new MediationAdapter.zza().zzbh(1).zzxg();
    }

    public void initialize(Context context, MediationAdRequest mediationAdRequest, String str, MediationRewardedVideoAdListener mediationRewardedVideoAdListener, Bundle bundle, Bundle bundle2) {
        this.zzgc = context.getApplicationContext();
        this.zzge = mediationRewardedVideoAdListener;
        this.zzge.onInitializationSucceeded(this);
    }

    public boolean isInitialized() {
        return this.zzge != null;
    }

    public void loadAd(MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        if (this.zzgc == null || this.zzge == null) {
            com.google.android.gms.ads.internal.util.client.zzb.m1352e("AdMobAdapter.loadAd called before initialize.");
            return;
        }
        this.zzgd = new InterstitialAd(this.zzgc);
        this.zzgd.zzd(true);
        this.zzgd.setAdUnitId(getAdUnitId(bundle));
        this.zzgd.setRewardedVideoAdListener(this.zzgf);
        this.zzgd.loadAd(zza(this.zzgc, mediationAdRequest, bundle2, bundle));
    }

    public void onDestroy() {
        if (this.zzfz != null) {
            this.zzfz.destroy();
            this.zzfz = null;
        }
        if (this.zzga != null) {
            this.zzga = null;
        }
        if (this.zzgb != null) {
            this.zzgb = null;
        }
        if (this.zzgd != null) {
            this.zzgd = null;
        }
    }

    public void onPause() {
        if (this.zzfz != null) {
            this.zzfz.pause();
        }
    }

    public void onResume() {
        if (this.zzfz != null) {
            this.zzfz.resume();
        }
    }

    public void requestBannerAd(Context context, MediationBannerListener mediationBannerListener, Bundle bundle, AdSize adSize, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzfz = new AdView(context);
        this.zzfz.setAdSize(new AdSize(adSize.getWidth(), adSize.getHeight()));
        this.zzfz.setAdUnitId(getAdUnitId(bundle));
        this.zzfz.setAdListener(new zzc(this, mediationBannerListener));
        this.zzfz.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzga = new InterstitialAd(context);
        this.zzga.setAdUnitId(getAdUnitId(bundle));
        this.zzga.setAdListener(new zzd(this, mediationInterstitialListener));
        this.zzga.loadAd(zza(context, mediationAdRequest, bundle2, bundle));
    }

    public void requestNativeAd(Context context, MediationNativeListener mediationNativeListener, Bundle bundle, NativeMediationAdRequest nativeMediationAdRequest, Bundle bundle2) {
        zze zze2 = new zze(this, mediationNativeListener);
        AdLoader.Builder withAdListener = zza(context, bundle.getString(AD_UNIT_ID_PARAMETER)).withAdListener(zze2);
        NativeAdOptions nativeAdOptions = nativeMediationAdRequest.getNativeAdOptions();
        if (nativeAdOptions != null) {
            withAdListener.withNativeAdOptions(nativeAdOptions);
        }
        if (nativeMediationAdRequest.isAppInstallAdRequested()) {
            withAdListener.forAppInstallAd(zze2);
        }
        if (nativeMediationAdRequest.isContentAdRequested()) {
            withAdListener.forContentAd(zze2);
        }
        this.zzgb = withAdListener.build();
        this.zzgb.loadAd(zza(context, nativeMediationAdRequest, bundle2, bundle));
    }

    public void showInterstitial() {
        this.zzga.show();
    }

    public void showVideo() {
        this.zzgd.show();
    }

    /* access modifiers changed from: protected */
    public abstract Bundle zza(Bundle bundle, Bundle bundle2);

    /* access modifiers changed from: package-private */
    public AdLoader.Builder zza(Context context, String str) {
        return new AdLoader.Builder(context, str);
    }

    /* access modifiers changed from: package-private */
    public AdRequest zza(Context context, MediationAdRequest mediationAdRequest, Bundle bundle, Bundle bundle2) {
        AdRequest.Builder builder = new AdRequest.Builder();
        Date birthday = mediationAdRequest.getBirthday();
        if (birthday != null) {
            builder.setBirthday(birthday);
        }
        int gender = mediationAdRequest.getGender();
        if (gender != 0) {
            builder.setGender(gender);
        }
        Set<String> keywords = mediationAdRequest.getKeywords();
        if (keywords != null) {
            for (String addKeyword : keywords) {
                builder.addKeyword(addKeyword);
            }
        }
        Location location = mediationAdRequest.getLocation();
        if (location != null) {
            builder.setLocation(location);
        }
        if (mediationAdRequest.isTesting()) {
            builder.addTestDevice(zzm.zzjr().zzar(context));
        }
        if (mediationAdRequest.taggedForChildDirectedTreatment() != -1) {
            builder.tagForChildDirectedTreatment(mediationAdRequest.taggedForChildDirectedTreatment() == 1);
        }
        builder.setIsDesignedForFamilies(mediationAdRequest.isDesignedForFamilies());
        builder.addNetworkExtrasBundle(AdMobAdapter.class, zza(bundle, bundle2));
        return builder.build();
    }
}
