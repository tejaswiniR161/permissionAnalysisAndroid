package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzac;

public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new zzg();
    final int mVersionCode;

    /* renamed from: vX */
    private final String f1539vX;

    Scope(int i, String str) {
        zzac.zzh(str, "scopeUri must not be null or empty");
        this.mVersionCode = i;
        this.f1539vX = str;
    }

    public Scope(String str) {
        this(1, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f1539vX.equals(((Scope) obj).f1539vX);
    }

    public int hashCode() {
        return this.f1539vX.hashCode();
    }

    public String toString() {
        return this.f1539vX;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }

    public String zzaqg() {
        return this.f1539vX;
    }
}
