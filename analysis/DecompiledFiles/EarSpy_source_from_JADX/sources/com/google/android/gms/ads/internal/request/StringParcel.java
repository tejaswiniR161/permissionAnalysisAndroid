package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zziy;

@zziy
public class StringParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<StringParcel> CREATOR = new zzo();
    final int mVersionCode;
    String zzbiw;

    StringParcel(int i, String str) {
        this.mVersionCode = i;
        this.zzbiw = str;
    }

    public StringParcel(String str) {
        this.mVersionCode = 1;
        this.zzbiw = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzo.zza(this, parcel, i);
    }

    public String zzsb() {
        return this.zzbiw;
    }
}
