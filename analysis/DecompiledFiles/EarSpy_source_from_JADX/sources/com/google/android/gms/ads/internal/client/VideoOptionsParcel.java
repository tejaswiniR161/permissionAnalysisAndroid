package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zziy;

@zziy
public class VideoOptionsParcel extends AbstractSafeParcelable {
    public static final zzaq CREATOR = new zzaq();
    public final int versionCode;
    public final boolean zzbac;

    public VideoOptionsParcel(int i, boolean z) {
        this.versionCode = i;
        this.zzbac = z;
    }

    public VideoOptionsParcel(VideoOptions videoOptions) {
        this(1, videoOptions.getStartMuted());
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaq.zza(this, parcel, i);
    }
}
