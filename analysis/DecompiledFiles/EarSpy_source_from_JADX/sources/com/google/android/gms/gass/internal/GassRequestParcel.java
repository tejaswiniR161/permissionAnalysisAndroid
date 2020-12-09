package com.google.android.gms.gass.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class GassRequestParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GassRequestParcel> CREATOR = new zzc();
    public final String aez;
    public final String packageName;
    public final int versionCode;

    GassRequestParcel(int i, String str, String str2) {
        this.versionCode = i;
        this.packageName = str;
        this.aez = str2;
    }

    public GassRequestParcel(String str, String str2) {
        this(1, str, str2);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }
}
