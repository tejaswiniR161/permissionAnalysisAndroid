package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class RecordConsentRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RecordConsentRequest> CREATOR = new zzf();
    private final Scope[] aAj;

    /* renamed from: ec */
    private final Account f2302ec;

    /* renamed from: hk */
    private final String f2303hk;
    final int mVersionCode;

    RecordConsentRequest(int i, Account account, Scope[] scopeArr, String str) {
        this.mVersionCode = i;
        this.f2302ec = account;
        this.aAj = scopeArr;
        this.f2303hk = str;
    }

    public Account getAccount() {
        return this.f2302ec;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.zza(this, parcel, i);
    }

    public String zzahn() {
        return this.f2303hk;
    }

    public Scope[] zzcdi() {
        return this.aAj;
    }
}
