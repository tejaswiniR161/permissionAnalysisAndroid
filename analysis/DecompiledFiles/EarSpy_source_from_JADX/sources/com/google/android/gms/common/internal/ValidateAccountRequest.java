package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
public class ValidateAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ValidateAccountRequest> CREATOR = new zzak();

    /* renamed from: AW */
    final IBinder f1650AW;

    /* renamed from: AX */
    private final Scope[] f1651AX;

    /* renamed from: De */
    private final int f1652De;

    /* renamed from: Df */
    private final Bundle f1653Df;

    /* renamed from: Dg */
    private final String f1654Dg;
    final int mVersionCode;

    ValidateAccountRequest(int i, int i2, IBinder iBinder, Scope[] scopeArr, Bundle bundle, String str) {
        this.mVersionCode = i;
        this.f1652De = i2;
        this.f1650AW = iBinder;
        this.f1651AX = scopeArr;
        this.f1653Df = bundle;
        this.f1654Dg = str;
    }

    public String getCallingPackage() {
        return this.f1654Dg;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzak.zza(this, parcel, i);
    }

    public Scope[] zzavj() {
        return this.f1651AX;
    }

    public int zzavl() {
        return this.f1652De;
    }

    public Bundle zzavm() {
        return this.f1653Df;
    }
}
