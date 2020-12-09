package com.google.android.gms.internal;

import android.location.Location;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

@zziy
public final class zzgw implements MediationAdRequest {
    private final int zzawu;
    private final boolean zzaxg;
    private final int zzbty;
    private final Date zzgn;
    private final Set<String> zzgp;
    private final boolean zzgq;
    private final Location zzgr;

    public zzgw(@Nullable Date date, int i, @Nullable Set<String> set, @Nullable Location location, boolean z, int i2, boolean z2) {
        this.zzgn = date;
        this.zzawu = i;
        this.zzgp = set;
        this.zzgr = location;
        this.zzgq = z;
        this.zzbty = i2;
        this.zzaxg = z2;
    }

    public Date getBirthday() {
        return this.zzgn;
    }

    public int getGender() {
        return this.zzawu;
    }

    public Set<String> getKeywords() {
        return this.zzgp;
    }

    public Location getLocation() {
        return this.zzgr;
    }

    public boolean isDesignedForFamilies() {
        return this.zzaxg;
    }

    public boolean isTesting() {
        return this.zzgq;
    }

    public int taggedForChildDirectedTreatment() {
        return this.zzbty;
    }
}
