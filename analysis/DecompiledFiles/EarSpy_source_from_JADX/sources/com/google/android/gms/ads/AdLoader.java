package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.internal.client.zzad;
import com.google.android.gms.ads.internal.client.zzc;
import com.google.android.gms.ads.internal.client.zzh;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzei;
import com.google.android.gms.internal.zzem;
import com.google.android.gms.internal.zzen;
import com.google.android.gms.internal.zzeo;
import com.google.android.gms.internal.zzep;
import com.google.android.gms.internal.zzgp;

public class AdLoader {
    private final Context mContext;
    private final zzh zzajr;
    private final zzr zzajs;

    public static class Builder {
        private final Context mContext;
        private final zzs zzajt;

        Builder(Context context, zzs zzs) {
            this.mContext = context;
            this.zzajt = zzs;
        }

        public Builder(Context context, String str) {
            this((Context) zzac.zzb(context, (Object) "context cannot be null"), zzm.zzjs().zzb(context, str, new zzgp()));
        }

        public AdLoader build() {
            try {
                return new AdLoader(this.mContext, this.zzajt.zzey());
            } catch (RemoteException e) {
                zzb.zzb("Failed to build AdLoader.", e);
                return null;
            }
        }

        public Builder forAppInstallAd(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
            try {
                this.zzajt.zza((zzeh) new zzem(onAppInstallAdLoadedListener));
            } catch (RemoteException e) {
                zzb.zzd("Failed to add app install ad listener", e);
            }
            return this;
        }

        public Builder forContentAd(NativeContentAd.OnContentAdLoadedListener onContentAdLoadedListener) {
            try {
                this.zzajt.zza((zzei) new zzen(onContentAdLoadedListener));
            } catch (RemoteException e) {
                zzb.zzd("Failed to add content ad listener", e);
            }
            return this;
        }

        public Builder forCustomTemplateAd(String str, NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
            try {
                this.zzajt.zza(str, new zzep(onCustomTemplateAdLoadedListener), onCustomClickListener == null ? null : new zzeo(onCustomClickListener));
            } catch (RemoteException e) {
                zzb.zzd("Failed to add custom template ad listener", e);
            }
            return this;
        }

        public Builder withAdListener(AdListener adListener) {
            try {
                this.zzajt.zzb((zzq) new zzc(adListener));
            } catch (RemoteException e) {
                zzb.zzd("Failed to set AdListener.", e);
            }
            return this;
        }

        public Builder withCorrelator(@NonNull Correlator correlator) {
            zzac.zzy(correlator);
            try {
                this.zzajt.zzb((zzy) correlator.zzdh());
            } catch (RemoteException e) {
                zzb.zzd("Failed to set correlator.", e);
            }
            return this;
        }

        public Builder withNativeAdOptions(NativeAdOptions nativeAdOptions) {
            try {
                this.zzajt.zza(new NativeAdOptionsParcel(nativeAdOptions));
            } catch (RemoteException e) {
                zzb.zzd("Failed to specify native ad options", e);
            }
            return this;
        }
    }

    AdLoader(Context context, zzr zzr) {
        this(context, zzr, zzh.zzjb());
    }

    AdLoader(Context context, zzr zzr, zzh zzh) {
        this.mContext = context;
        this.zzajs = zzr;
        this.zzajr = zzh;
    }

    private void zza(zzad zzad) {
        try {
            this.zzajs.zzf(this.zzajr.zza(this.mContext, zzad));
        } catch (RemoteException e) {
            zzb.zzb("Failed to load ad.", e);
        }
    }

    public String getMediationAdapterClassName() {
        try {
            return this.zzajs.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzb.zzd("Failed to get the mediation adapter class name.", e);
            return null;
        }
    }

    public boolean isLoading() {
        try {
            return this.zzajs.isLoading();
        } catch (RemoteException e) {
            zzb.zzd("Failed to check if ad is loading.", e);
            return false;
        }
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(AdRequest adRequest) {
        zza(adRequest.zzdg());
    }

    public void loadAd(PublisherAdRequest publisherAdRequest) {
        zza(publisherAdRequest.zzdg());
    }
}
