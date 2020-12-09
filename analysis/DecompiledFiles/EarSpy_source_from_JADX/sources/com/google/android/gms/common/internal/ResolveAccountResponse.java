package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzr;

public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new zzae();

    /* renamed from: AW */
    IBinder f1643AW;

    /* renamed from: CX */
    private boolean f1644CX;
    final int mVersionCode;

    /* renamed from: vm */
    private ConnectionResult f1645vm;

    /* renamed from: xz */
    private boolean f1646xz;

    ResolveAccountResponse(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.mVersionCode = i;
        this.f1643AW = iBinder;
        this.f1645vm = connectionResult;
        this.f1646xz = z;
        this.f1644CX = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.f1645vm.equals(resolveAccountResponse.f1645vm) && zzavd().equals(resolveAccountResponse.zzavd());
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzae.zza(this, parcel, i);
    }

    public zzr zzavd() {
        return zzr.zza.zzdr(this.f1643AW);
    }

    public ConnectionResult zzave() {
        return this.f1645vm;
    }

    public boolean zzavf() {
        return this.f1646xz;
    }

    public boolean zzavg() {
        return this.f1644CX;
    }
}
