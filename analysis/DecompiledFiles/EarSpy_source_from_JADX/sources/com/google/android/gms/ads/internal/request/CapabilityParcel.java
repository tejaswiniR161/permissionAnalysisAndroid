package com.google.android.gms.ads.internal.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zziy;

@zziy
public class CapabilityParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CapabilityParcel> CREATOR = new zzj();
    public final int versionCode;
    public final boolean zzcib;
    public final boolean zzcic;
    public final boolean zzcid;

    CapabilityParcel(int i, boolean z, boolean z2, boolean z3) {
        this.versionCode = i;
        this.zzcib = z;
        this.zzcic = z2;
        this.zzcid = z3;
    }

    public CapabilityParcel(boolean z, boolean z2, boolean z3) {
        this(2, z, z2, z3);
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("iap_supported", this.zzcib);
        bundle.putBoolean("default_iap_supported", this.zzcic);
        bundle.putBoolean("app_streaming_supported", this.zzcid);
        return bundle;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }
}
