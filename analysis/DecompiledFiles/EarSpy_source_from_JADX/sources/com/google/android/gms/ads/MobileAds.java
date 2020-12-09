package com.google.android.gms.ads;

import android.content.Context;
import android.support.annotation.RequiresPermission;
import com.google.android.gms.ads.internal.client.zzag;
import com.google.android.gms.ads.internal.client.zzah;
import com.google.android.gms.ads.reward.RewardedVideoAd;

public class MobileAds {

    public static final class Settings {
        private final zzah zzakc = new zzah();

        @Deprecated
        public String getTrackingId() {
            return this.zzakc.getTrackingId();
        }

        @Deprecated
        public boolean isGoogleAnalyticsEnabled() {
            return this.zzakc.isGoogleAnalyticsEnabled();
        }

        @Deprecated
        public Settings setGoogleAnalyticsEnabled(boolean z) {
            this.zzakc.zzq(z);
            return this;
        }

        @Deprecated
        public Settings setTrackingId(String str) {
            this.zzakc.zzar(str);
            return this;
        }

        /* access modifiers changed from: package-private */
        public zzah zzdi() {
            return this.zzakc;
        }
    }

    private MobileAds() {
    }

    public static RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        return zzag.zzki().getRewardedVideoAdInstance(context);
    }

    @Deprecated
    public static void initialize(Context context) {
        initialize(context, (String) null, (Settings) null);
    }

    @RequiresPermission("android.permission.INTERNET")
    public static void initialize(Context context, String str) {
        initialize(context, str, (Settings) null);
    }

    @RequiresPermission("android.permission.INTERNET")
    @Deprecated
    public static void initialize(Context context, String str, Settings settings) {
        zzag.zzki().zza(context, str, settings == null ? null : settings.zzdi());
    }

    public static void openDebugMenu(Context context, String str) {
        zzag.zzki().openDebugMenu(context, str);
    }

    public static void setAppMuted(boolean z) {
        zzag.zzki().setAppMuted(z);
    }

    public static void setAppVolume(float f) {
        zzag.zzki().setAppVolume(f);
    }
}
