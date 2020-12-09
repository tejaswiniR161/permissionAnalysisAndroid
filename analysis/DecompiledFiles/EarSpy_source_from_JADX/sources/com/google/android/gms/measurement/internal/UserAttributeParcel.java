package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzac;

public class UserAttributeParcel extends AbstractSafeParcelable {
    public static final zzaj CREATOR = new zzaj();

    /* renamed from: Dr */
    public final String f2275Dr;
    public final String aoA;
    public final long asu;
    public final Long asv;
    public final Float asw;
    public final Double asx;
    public final String name;
    public final int versionCode;

    UserAttributeParcel(int i, String str, long j, Long l, Float f, String str2, String str3, Double d) {
        Double d2 = null;
        this.versionCode = i;
        this.name = str;
        this.asu = j;
        this.asv = l;
        this.asw = null;
        if (i == 1) {
            this.asx = f != null ? Double.valueOf(f.doubleValue()) : d2;
        } else {
            this.asx = d;
        }
        this.f2275Dr = str2;
        this.aoA = str3;
    }

    UserAttributeParcel(zzak zzak) {
        this(zzak.mName, zzak.asy, zzak.zzctv, zzak.zzcpe);
    }

    UserAttributeParcel(String str, long j, Object obj, String str2) {
        zzac.zzhz(str);
        this.versionCode = 2;
        this.name = str;
        this.asu = j;
        this.aoA = str2;
        if (obj == null) {
            this.asv = null;
            this.asw = null;
            this.asx = null;
            this.f2275Dr = null;
        } else if (obj instanceof Long) {
            this.asv = (Long) obj;
            this.asw = null;
            this.asx = null;
            this.f2275Dr = null;
        } else if (obj instanceof String) {
            this.asv = null;
            this.asw = null;
            this.asx = null;
            this.f2275Dr = (String) obj;
        } else if (obj instanceof Double) {
            this.asv = null;
            this.asw = null;
            this.asx = (Double) obj;
            this.f2275Dr = null;
        } else {
            throw new IllegalArgumentException("User attribute given of un-supported type");
        }
    }

    public Object getValue() {
        if (this.asv != null) {
            return this.asv;
        }
        if (this.asx != null) {
            return this.asx;
        }
        if (this.f2275Dr != null) {
            return this.f2275Dr;
        }
        return null;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaj.zza(this, parcel, i);
    }
}
