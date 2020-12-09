package com.google.android.gms.ads.formats;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.internal.zziy;

@zziy
public final class NativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;
    public static final int ORIENTATION_ANY = 0;
    public static final int ORIENTATION_LANDSCAPE = 2;
    public static final int ORIENTATION_PORTRAIT = 1;
    private final boolean zzakn;
    private final int zzako;
    private final boolean zzakp;
    private final int zzakq;
    private final VideoOptions zzakr;

    public @interface AdChoicesPlacement {
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public boolean zzakn = false;
        /* access modifiers changed from: private */
        public int zzako = 0;
        /* access modifiers changed from: private */
        public boolean zzakp = false;
        /* access modifiers changed from: private */
        public int zzakq = 1;
        /* access modifiers changed from: private */
        public VideoOptions zzakr;

        public NativeAdOptions build() {
            return new NativeAdOptions(this);
        }

        public Builder setAdChoicesPlacement(@AdChoicesPlacement int i) {
            this.zzakq = i;
            return this;
        }

        public Builder setImageOrientation(int i) {
            this.zzako = i;
            return this;
        }

        public Builder setRequestMultipleImages(boolean z) {
            this.zzakp = z;
            return this;
        }

        public Builder setReturnUrlsForImageAssets(boolean z) {
            this.zzakn = z;
            return this;
        }

        public Builder setVideoOptions(VideoOptions videoOptions) {
            this.zzakr = videoOptions;
            return this;
        }
    }

    private NativeAdOptions(Builder builder) {
        this.zzakn = builder.zzakn;
        this.zzako = builder.zzako;
        this.zzakp = builder.zzakp;
        this.zzakq = builder.zzakq;
        this.zzakr = builder.zzakr;
    }

    public int getAdChoicesPlacement() {
        return this.zzakq;
    }

    public int getImageOrientation() {
        return this.zzako;
    }

    @Nullable
    public VideoOptions getVideoOptions() {
        return this.zzakr;
    }

    public boolean shouldRequestMultipleImages() {
        return this.zzakp;
    }

    public boolean shouldReturnUrlsForImageAssets() {
        return this.zzakn;
    }
}
