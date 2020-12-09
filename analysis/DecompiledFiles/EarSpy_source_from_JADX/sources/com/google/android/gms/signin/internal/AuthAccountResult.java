package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class AuthAccountResult extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<AuthAccountResult> CREATOR = new zza();
    private int aAf;
    private Intent aAg;
    final int mVersionCode;

    public AuthAccountResult() {
        this(0, (Intent) null);
    }

    AuthAccountResult(int i, int i2, Intent intent) {
        this.mVersionCode = i;
        this.aAf = i2;
        this.aAg = intent;
    }

    public AuthAccountResult(int i, Intent intent) {
        this(2, i, intent);
    }

    public Status getStatus() {
        return this.aAf == 0 ? Status.f1540vY : Status.f1544wc;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public int zzcdg() {
        return this.aAf;
    }

    public Intent zzcdh() {
        return this.aAg;
    }
}
