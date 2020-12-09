package com.google.android.gms.internal;

import android.location.Location;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.Date;
import java.util.List;
import java.util.Set;

@zziy
public final class zzhb implements NativeMediationAdRequest {
    private final NativeAdOptionsParcel zzand;
    private final List<String> zzane;
    private final int zzawu;
    private final boolean zzaxg;
    private final int zzbty;
    private final Date zzgn;
    private final Set<String> zzgp;
    private final boolean zzgq;
    private final Location zzgr;

    public zzhb(@Nullable Date date, int i, @Nullable Set<String> set, @Nullable Location location, boolean z, int i2, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list, boolean z2) {
        this.zzgn = date;
        this.zzawu = i;
        this.zzgp = set;
        this.zzgr = location;
        this.zzgq = z;
        this.zzbty = i2;
        this.zzand = nativeAdOptionsParcel;
        this.zzane = list;
        this.zzaxg = z2;
    }

    public Date getBirthday() {
        return this.zzgn;
    }

    public int getGender() {
        return this.zzawu;
    }

    public Set<String> getKeywords() {
        return this.zzgp;
    }

    public Location getLocation() {
        return this.zzgr;
    }

    public NativeAdOptions getNativeAdOptions() {
        if (this.zzand == null) {
            return null;
        }
        NativeAdOptions.Builder requestMultipleImages = new NativeAdOptions.Builder().setReturnUrlsForImageAssets(this.zzand.zzblb).setImageOrientation(this.zzand.zzblc).setRequestMultipleImages(this.zzand.zzbld);
        if (this.zzand.versionCode >= 2) {
            requestMultipleImages.setAdChoicesPlacement(this.zzand.zzble);
        }
        if (this.zzand.versionCode >= 3 && this.zzand.zzblf != null) {
            requestMultipleImages.setVideoOptions(new VideoOptions.Builder().setStartMuted(this.zzand.zzblf.zzbac).build());
        }
        return requestMultipleImages.build();
    }

    public boolean isAppInstallAdRequested() {
        return this.zzane != null && this.zzane.contains("2");
    }

    public boolean isContentAdRequested() {
        return this.zzane != null && this.zzane.contains("1");
    }

    public boolean isDesignedForFamilies() {
        return this.zzaxg;
    }

    public boolean isTesting() {
        return this.zzgq;
    }

    public int taggedForChildDirectedTreatment() {
        return this.zzbty;
    }
}
