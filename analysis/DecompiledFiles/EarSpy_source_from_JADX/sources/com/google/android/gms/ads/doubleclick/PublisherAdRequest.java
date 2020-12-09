package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzad;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzz;
import java.util.Date;
import java.util.List;
import java.util.Set;

public final class PublisherAdRequest {
    public static final String DEVICE_ID_EMULATOR = zzad.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    public static final int GENDER_FEMALE = 2;
    public static final int GENDER_MALE = 1;
    public static final int GENDER_UNKNOWN = 0;
    private final zzad zzaju;

    public static final class Builder {
        /* access modifiers changed from: private */
        public final zzad.zza zzajv = new zzad.zza();

        public Builder addCategoryExclusion(String str) {
            this.zzajv.zzao(str);
            return this;
        }

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.zzajv.zzb(cls, bundle);
            return this;
        }

        public Builder addCustomTargeting(String str, String str2) {
            this.zzajv.zzf(str, str2);
            return this;
        }

        public Builder addCustomTargeting(String str, List<String> list) {
            if (list != null) {
                this.zzajv.zzf(str, zzz.zzhy(",").zza(list));
            }
            return this;
        }

        public Builder addKeyword(String str) {
            this.zzajv.zzai(str);
            return this;
        }

        public Builder addNetworkExtras(NetworkExtras networkExtras) {
            this.zzajv.zza(networkExtras);
            return this;
        }

        public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> cls, Bundle bundle) {
            this.zzajv.zza(cls, bundle);
            return this;
        }

        public Builder addTestDevice(String str) {
            this.zzajv.zzaj(str);
            return this;
        }

        public PublisherAdRequest build() {
            return new PublisherAdRequest(this);
        }

        public Builder setBirthday(Date date) {
            this.zzajv.zza(date);
            return this;
        }

        public Builder setContentUrl(String str) {
            zzac.zzb(str, (Object) "Content URL must be non-null.");
            zzac.zzh(str, "Content URL must be non-empty.");
            zzac.zzb(str.length() <= 512, "Content URL must not exceed %d in length.  Provided length was %d.", 512, Integer.valueOf(str.length()));
            this.zzajv.zzal(str);
            return this;
        }

        public Builder setGender(int i) {
            this.zzajv.zzv(i);
            return this;
        }

        public Builder setIsDesignedForFamilies(boolean z) {
            this.zzajv.zzp(z);
            return this;
        }

        public Builder setLocation(Location location) {
            this.zzajv.zzb(location);
            return this;
        }

        @Deprecated
        public Builder setManualImpressionsEnabled(boolean z) {
            this.zzajv.setManualImpressionsEnabled(z);
            return this;
        }

        public Builder setPublisherProvidedId(String str) {
            this.zzajv.zzam(str);
            return this;
        }

        public Builder setRequestAgent(String str) {
            this.zzajv.zzan(str);
            return this;
        }

        public Builder tagForChildDirectedTreatment(boolean z) {
            this.zzajv.zzo(z);
            return this;
        }
    }

    private PublisherAdRequest(Builder builder) {
        this.zzaju = new zzad(builder.zzajv);
    }

    public static void updateCorrelator() {
    }

    public Date getBirthday() {
        return this.zzaju.getBirthday();
    }

    public String getContentUrl() {
        return this.zzaju.getContentUrl();
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.zzaju.getCustomEventExtrasBundle(cls);
    }

    public Bundle getCustomTargeting() {
        return this.zzaju.getCustomTargeting();
    }

    public int getGender() {
        return this.zzaju.getGender();
    }

    public Set<String> getKeywords() {
        return this.zzaju.getKeywords();
    }

    public Location getLocation() {
        return this.zzaju.getLocation();
    }

    public boolean getManualImpressionsEnabled() {
        return this.zzaju.getManualImpressionsEnabled();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return this.zzaju.getNetworkExtras(cls);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.zzaju.getNetworkExtrasBundle(cls);
    }

    public String getPublisherProvidedId() {
        return this.zzaju.getPublisherProvidedId();
    }

    public boolean isTestDevice(Context context) {
        return this.zzaju.isTestDevice(context);
    }

    public zzad zzdg() {
        return this.zzaju;
    }
}
