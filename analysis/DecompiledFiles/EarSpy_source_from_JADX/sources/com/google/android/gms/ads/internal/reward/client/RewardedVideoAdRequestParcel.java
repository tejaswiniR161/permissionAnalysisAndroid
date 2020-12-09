package com.google.android.gms.ads.internal.reward.client;

import android.os.Parcel;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zziy;

@zziy
public final class RewardedVideoAdRequestParcel extends AbstractSafeParcelable {
    public static final zzh CREATOR = new zzh();
    public final int versionCode;
    public final String zzaqt;
    public final AdRequestParcel zzcfu;

    public RewardedVideoAdRequestParcel(int i, AdRequestParcel adRequestParcel, String str) {
        this.versionCode = i;
        this.zzcfu = adRequestParcel;
        this.zzaqt = str;
    }

    public RewardedVideoAdRequestParcel(AdRequestParcel adRequestParcel, String str) {
        this(1, adRequestParcel, str);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.zza(this, parcel, i);
    }
}
