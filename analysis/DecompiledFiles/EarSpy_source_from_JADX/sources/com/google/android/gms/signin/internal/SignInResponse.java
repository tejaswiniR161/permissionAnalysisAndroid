package com.google.android.gms.signin.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SignInResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInResponse> CREATOR = new zzi();
    private final ResolveAccountResponse aAn;
    final int mVersionCode;

    /* renamed from: vm */
    private final ConnectionResult f2304vm;

    public SignInResponse(int i) {
        this(new ConnectionResult(i, (PendingIntent) null), (ResolveAccountResponse) null);
    }

    SignInResponse(int i, ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this.mVersionCode = i;
        this.f2304vm = connectionResult;
        this.aAn = resolveAccountResponse;
    }

    public SignInResponse(ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, resolveAccountResponse);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    public ConnectionResult zzave() {
        return this.f2304vm;
    }

    public ResolveAccountResponse zzcdl() {
        return this.aAn;
    }
}
