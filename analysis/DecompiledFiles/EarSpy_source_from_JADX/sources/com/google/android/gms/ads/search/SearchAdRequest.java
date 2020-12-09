package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzad;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;

public final class SearchAdRequest {
    public static final int BORDER_TYPE_DASHED = 1;
    public static final int BORDER_TYPE_DOTTED = 2;
    public static final int BORDER_TYPE_NONE = 0;
    public static final int BORDER_TYPE_SOLID = 3;
    public static final int CALL_BUTTON_COLOR_DARK = 2;
    public static final int CALL_BUTTON_COLOR_LIGHT = 0;
    public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
    public static final String DEVICE_ID_EMULATOR = zzad.DEVICE_ID_EMULATOR;
    public static final int ERROR_CODE_INTERNAL_ERROR = 0;
    public static final int ERROR_CODE_INVALID_REQUEST = 1;
    public static final int ERROR_CODE_NETWORK_ERROR = 2;
    public static final int ERROR_CODE_NO_FILL = 3;
    private final int mBackgroundColor;
    private final zzad zzaju;
    private final String zzapl;
    private final int zzcxs;
    private final int zzcxt;
    private final int zzcxu;
    private final int zzcxv;
    private final int zzcxw;
    private final int zzcxx;
    private final int zzcxy;
    private final String zzcxz;
    private final int zzcya;
    private final String zzcyb;
    private final int zzcyc;
    private final int zzcyd;

    public static final class Builder {
        /* access modifiers changed from: private */
        public int mBackgroundColor;
        /* access modifiers changed from: private */
        public final zzad.zza zzajv = new zzad.zza();
        /* access modifiers changed from: private */
        public String zzapl;
        /* access modifiers changed from: private */
        public int zzcxs;
        /* access modifiers changed from: private */
        public int zzcxt;
        /* access modifiers changed from: private */
        public int zzcxu;
        /* access modifiers changed from: private */
        public int zzcxv;
        /* access modifiers changed from: private */
        public int zzcxw;
        /* access modifiers changed from: private */
        public int zzcxx = 0;
        /* access modifiers changed from: private */
        public int zzcxy;
        /* access modifiers changed from: private */
        public String zzcxz;
        /* access modifiers changed from: private */
        public int zzcya;
        /* access modifiers changed from: private */
        public String zzcyb;
        /* access modifiers changed from: private */
        public int zzcyc;
        /* access modifiers changed from: private */
        public int zzcyd;

        public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> cls, Bundle bundle) {
            this.zzajv.zzb(cls, bundle);
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

        public SearchAdRequest build() {
            return new SearchAdRequest(this);
        }

        public Builder setAnchorTextColor(int i) {
            this.zzcxs = i;
            return this;
        }

        public Builder setBackgroundColor(int i) {
            this.mBackgroundColor = i;
            this.zzcxt = Color.argb(0, 0, 0, 0);
            this.zzcxu = Color.argb(0, 0, 0, 0);
            return this;
        }

        public Builder setBackgroundGradient(int i, int i2) {
            this.mBackgroundColor = Color.argb(0, 0, 0, 0);
            this.zzcxt = i2;
            this.zzcxu = i;
            return this;
        }

        public Builder setBorderColor(int i) {
            this.zzcxv = i;
            return this;
        }

        public Builder setBorderThickness(int i) {
            this.zzcxw = i;
            return this;
        }

        public Builder setBorderType(int i) {
            this.zzcxx = i;
            return this;
        }

        public Builder setCallButtonColor(int i) {
            this.zzcxy = i;
            return this;
        }

        public Builder setCustomChannels(String str) {
            this.zzcxz = str;
            return this;
        }

        public Builder setDescriptionTextColor(int i) {
            this.zzcya = i;
            return this;
        }

        public Builder setFontFace(String str) {
            this.zzcyb = str;
            return this;
        }

        public Builder setHeaderTextColor(int i) {
            this.zzcyc = i;
            return this;
        }

        public Builder setHeaderTextSize(int i) {
            this.zzcyd = i;
            return this;
        }

        public Builder setLocation(Location location) {
            this.zzajv.zzb(location);
            return this;
        }

        public Builder setQuery(String str) {
            this.zzapl = str;
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

    private SearchAdRequest(Builder builder) {
        this.zzcxs = builder.zzcxs;
        this.mBackgroundColor = builder.mBackgroundColor;
        this.zzcxt = builder.zzcxt;
        this.zzcxu = builder.zzcxu;
        this.zzcxv = builder.zzcxv;
        this.zzcxw = builder.zzcxw;
        this.zzcxx = builder.zzcxx;
        this.zzcxy = builder.zzcxy;
        this.zzcxz = builder.zzcxz;
        this.zzcya = builder.zzcya;
        this.zzcyb = builder.zzcyb;
        this.zzcyc = builder.zzcyc;
        this.zzcyd = builder.zzcyd;
        this.zzapl = builder.zzapl;
        this.zzaju = new zzad(builder.zzajv, this);
    }

    public int getAnchorTextColor() {
        return this.zzcxs;
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public int getBackgroundGradientBottom() {
        return this.zzcxt;
    }

    public int getBackgroundGradientTop() {
        return this.zzcxu;
    }

    public int getBorderColor() {
        return this.zzcxv;
    }

    public int getBorderThickness() {
        return this.zzcxw;
    }

    public int getBorderType() {
        return this.zzcxx;
    }

    public int getCallButtonColor() {
        return this.zzcxy;
    }

    public String getCustomChannels() {
        return this.zzcxz;
    }

    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> cls) {
        return this.zzaju.getCustomEventExtrasBundle(cls);
    }

    public int getDescriptionTextColor() {
        return this.zzcya;
    }

    public String getFontFace() {
        return this.zzcyb;
    }

    public int getHeaderTextColor() {
        return this.zzcyc;
    }

    public int getHeaderTextSize() {
        return this.zzcyd;
    }

    public Location getLocation() {
        return this.zzaju.getLocation();
    }

    @Deprecated
    public <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return this.zzaju.getNetworkExtras(cls);
    }

    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> cls) {
        return this.zzaju.getNetworkExtrasBundle(cls);
    }

    public String getQuery() {
        return this.zzapl;
    }

    public boolean isTestDevice(Context context) {
        return this.zzaju.isTestDevice(context);
    }

    /* access modifiers changed from: package-private */
    public zzad zzdg() {
        return this.zzaju;
    }
}
