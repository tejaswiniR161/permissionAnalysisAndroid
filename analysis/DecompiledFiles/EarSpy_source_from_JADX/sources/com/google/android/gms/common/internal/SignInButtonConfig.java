package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SignInButtonConfig extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInButtonConfig> CREATOR = new zzaf();
    @Deprecated

    /* renamed from: AX */
    private final Scope[] f1647AX;

    /* renamed from: CY */
    private final int f1648CY;

    /* renamed from: CZ */
    private final int f1649CZ;
    final int mVersionCode;

    SignInButtonConfig(int i, int i2, int i3, Scope[] scopeArr) {
        this.mVersionCode = i;
        this.f1648CY = i2;
        this.f1649CZ = i3;
        this.f1647AX = scopeArr;
    }

    public SignInButtonConfig(int i, int i2, Scope[] scopeArr) {
        this(1, i, i2, (Scope[]) null);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaf.zza(this, parcel, i);
    }

    public int zzavh() {
        return this.f1648CY;
    }

    public int zzavi() {
        return this.f1649CZ;
    }

    @Deprecated
    public Scope[] zzavj() {
        return this.f1647AX;
    }
}
