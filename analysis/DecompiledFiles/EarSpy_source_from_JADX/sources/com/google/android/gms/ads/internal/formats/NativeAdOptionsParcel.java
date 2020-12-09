package com.google.android.gms.ads.internal.formats;

import android.os.Parcel;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zziy;

@zziy
public class NativeAdOptionsParcel extends AbstractSafeParcelable {
    public static final zzk CREATOR = new zzk();
    public final int versionCode;
    public final boolean zzblb;
    public final int zzblc;
    public final boolean zzbld;
    public final int zzble;
    @Nullable
    public final VideoOptionsParcel zzblf;

    public NativeAdOptionsParcel(int i, boolean z, int i2, boolean z2, int i3, VideoOptionsParcel videoOptionsParcel) {
        this.versionCode = i;
        this.zzblb = z;
        this.zzblc = i2;
        this.zzbld = z2;
        this.zzble = i3;
        this.zzblf = videoOptionsParcel;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public NativeAdOptionsParcel(NativeAdOptions nativeAdOptions) {
        this(3, nativeAdOptions.shouldReturnUrlsForImageAssets(), nativeAdOptions.getImageOrientation(), nativeAdOptions.shouldRequestMultipleImages(), nativeAdOptions.getAdChoicesPlacement(), nativeAdOptions.getVideoOptions() != null ? new VideoOptionsParcel(nativeAdOptions.getVideoOptions()) : null);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }
}
