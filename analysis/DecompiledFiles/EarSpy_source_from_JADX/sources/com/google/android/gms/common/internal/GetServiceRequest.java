package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.zzc;
import java.util.Collection;

public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzk();

    /* renamed from: Ci */
    final int f1632Ci;

    /* renamed from: Cj */
    int f1633Cj;

    /* renamed from: Ck */
    String f1634Ck;

    /* renamed from: Cl */
    IBinder f1635Cl;

    /* renamed from: Cm */
    Scope[] f1636Cm;

    /* renamed from: Cn */
    Bundle f1637Cn;

    /* renamed from: Co */
    Account f1638Co;

    /* renamed from: Cp */
    long f1639Cp;
    final int version;

    public GetServiceRequest(int i) {
        this.version = 3;
        this.f1633Cj = zzc.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.f1632Ci = i;
    }

    GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, long j) {
        this.version = i;
        this.f1632Ci = i2;
        this.f1633Cj = i3;
        this.f1634Ck = str;
        if (i < 2) {
            this.f1638Co = zzdq(iBinder);
        } else {
            this.f1635Cl = iBinder;
            this.f1638Co = account;
        }
        this.f1636Cm = scopeArr;
        this.f1637Cn = bundle;
        this.f1639Cp = j;
    }

    private Account zzdq(IBinder iBinder) {
        if (iBinder != null) {
            return zza.zza(zzr.zza.zzdr(iBinder));
        }
        return null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzk.zza(this, parcel, i);
    }

    public GetServiceRequest zzb(zzr zzr) {
        if (zzr != null) {
            this.f1635Cl = zzr.asBinder();
        }
        return this;
    }

    public GetServiceRequest zzd(Account account) {
        this.f1638Co = account;
        return this;
    }

    public GetServiceRequest zzf(Collection<Scope> collection) {
        this.f1636Cm = (Scope[]) collection.toArray(new Scope[collection.size()]);
        return this;
    }

    public GetServiceRequest zzht(String str) {
        this.f1634Ck = str;
        return this;
    }

    public GetServiceRequest zzo(Bundle bundle) {
        this.f1637Cn = bundle;
        return this;
    }
}
