package com.google.android.gms.ads.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zziy;

@zziy
public final class InterstitialAdParameterParcel extends AbstractSafeParcelable {
    public static final zzm CREATOR = new zzm();
    public final int versionCode;
    public final boolean zzanx;
    public final boolean zzany;
    public final String zzanz;
    public final boolean zzaoa;
    public final float zzaob;
    public final int zzaoc;

    InterstitialAdParameterParcel(int i, boolean z, boolean z2, String str, boolean z3, float f, int i2) {
        this.versionCode = i;
        this.zzanx = z;
        this.zzany = z2;
        this.zzanz = str;
        this.zzaoa = z3;
        this.zzaob = f;
        this.zzaoc = i2;
    }

    public InterstitialAdParameterParcel(boolean z, boolean z2, boolean z3, float f, int i) {
        this(3, z, z2, (String) null, z3, f, i);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzm.zza(this, parcel, i);
    }
}
