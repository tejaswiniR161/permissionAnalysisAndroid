package com.google.android.gms.ads.internal.client;

import android.location.Location;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zziy;
import java.util.List;

@zziy
public final class AdRequestParcel extends AbstractSafeParcelable {
    public static final zzg CREATOR = new zzg();
    public final Bundle extras;
    public final int versionCode;
    public final long zzawd;
    public final int zzawe;
    public final List<String> zzawf;
    public final boolean zzawg;
    public final int zzawh;
    public final boolean zzawi;
    public final String zzawj;
    public final SearchAdRequestParcel zzawk;
    public final Location zzawl;
    public final String zzawm;
    public final Bundle zzawn;
    public final Bundle zzawo;
    public final List<String> zzawp;
    public final String zzawq;
    public final String zzawr;
    public final boolean zzaws;

    public AdRequestParcel(int i, long j, Bundle bundle, int i2, List<String> list, boolean z, int i3, boolean z2, String str, SearchAdRequestParcel searchAdRequestParcel, Location location, String str2, Bundle bundle2, Bundle bundle3, List<String> list2, String str3, String str4, boolean z3) {
        this.versionCode = i;
        this.zzawd = j;
        this.extras = bundle == null ? new Bundle() : bundle;
        this.zzawe = i2;
        this.zzawf = list;
        this.zzawg = z;
        this.zzawh = i3;
        this.zzawi = z2;
        this.zzawj = str;
        this.zzawk = searchAdRequestParcel;
        this.zzawl = location;
        this.zzawm = str2;
        this.zzawn = bundle2 == null ? new Bundle() : bundle2;
        this.zzawo = bundle3;
        this.zzawp = list2;
        this.zzawq = str3;
        this.zzawr = str4;
        this.zzaws = z3;
    }

    public static void zzj(AdRequestParcel adRequestParcel) {
        adRequestParcel.zzawn.putBundle("com.google.ads.mediation.admob.AdMobAdapter", adRequestParcel.extras);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AdRequestParcel)) {
            return false;
        }
        AdRequestParcel adRequestParcel = (AdRequestParcel) obj;
        return this.versionCode == adRequestParcel.versionCode && this.zzawd == adRequestParcel.zzawd && zzab.equal(this.extras, adRequestParcel.extras) && this.zzawe == adRequestParcel.zzawe && zzab.equal(this.zzawf, adRequestParcel.zzawf) && this.zzawg == adRequestParcel.zzawg && this.zzawh == adRequestParcel.zzawh && this.zzawi == adRequestParcel.zzawi && zzab.equal(this.zzawj, adRequestParcel.zzawj) && zzab.equal(this.zzawk, adRequestParcel.zzawk) && zzab.equal(this.zzawl, adRequestParcel.zzawl) && zzab.equal(this.zzawm, adRequestParcel.zzawm) && zzab.equal(this.zzawn, adRequestParcel.zzawn) && zzab.equal(this.zzawo, adRequestParcel.zzawo) && zzab.equal(this.zzawp, adRequestParcel.zzawp) && zzab.equal(this.zzawq, adRequestParcel.zzawq) && zzab.equal(this.zzawr, adRequestParcel.zzawr) && this.zzaws == adRequestParcel.zzaws;
    }

    public int hashCode() {
        return zzab.hashCode(Integer.valueOf(this.versionCode), Long.valueOf(this.zzawd), this.extras, Integer.valueOf(this.zzawe), this.zzawf, Boolean.valueOf(this.zzawg), Integer.valueOf(this.zzawh), Boolean.valueOf(this.zzawi), this.zzawj, this.zzawk, this.zzawl, this.zzawm, this.zzawn, this.zzawo, this.zzawp, this.zzawq, this.zzawr, Boolean.valueOf(this.zzaws));
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.zza(this, parcel, i);
    }
}
