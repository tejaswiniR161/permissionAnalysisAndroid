package com.google.firebase.crash.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FirebaseCrashOptions implements SafeParcelable {
    public static final Parcelable.Creator<FirebaseCrashOptions> CREATOR = new zzc();
    private String aVc;
    public final int mVersionCode;

    /* renamed from: yQ */
    private String f2317yQ;

    FirebaseCrashOptions(int i, String str, String str2) {
        this.mVersionCode = i;
        this.aVc = str;
        this.f2317yQ = str2;
    }

    public FirebaseCrashOptions(String str, String str2) {
        this.mVersionCode = 1;
        this.aVc = str;
        this.f2317yQ = str2;
    }

    public int describeContents() {
        return 0;
    }

    public String getApiKey() {
        return this.f2317yQ;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.zza(this, parcel, i);
    }

    public String zzcqo() {
        return this.aVc;
    }
}
