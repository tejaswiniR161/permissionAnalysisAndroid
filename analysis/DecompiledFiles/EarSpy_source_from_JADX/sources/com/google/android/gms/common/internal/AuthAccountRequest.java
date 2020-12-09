package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class AuthAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new zzd();

    /* renamed from: AW */
    final IBinder f1623AW;

    /* renamed from: AX */
    final Scope[] f1624AX;

    /* renamed from: AY */
    Integer f1625AY;

    /* renamed from: AZ */
    Integer f1626AZ;
    final int mVersionCode;

    AuthAccountRequest(int i, IBinder iBinder, Scope[] scopeArr, Integer num, Integer num2) {
        this.mVersionCode = i;
        this.f1623AW = iBinder;
        this.f1624AX = scopeArr;
        this.f1625AY = num;
        this.f1626AZ = num2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
