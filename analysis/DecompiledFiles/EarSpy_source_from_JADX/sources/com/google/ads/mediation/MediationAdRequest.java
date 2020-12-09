package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
public class MediationAdRequest {
    private final Date zzgn;
    private final AdRequest.Gender zzgo;
    private final Set<String> zzgp;
    private final boolean zzgq;
    private final Location zzgr;

    public MediationAdRequest(Date date, AdRequest.Gender gender, Set<String> set, boolean z, Location location) {
        this.zzgn = date;
        this.zzgo = gender;
        this.zzgp = set;
        this.zzgq = z;
        this.zzgr = location;
    }

    public Integer getAgeInYears() {
        if (this.zzgn == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(this.zzgn);
        Integer valueOf = Integer.valueOf(instance2.get(1) - instance.get(1));
        return (instance2.get(2) < instance.get(2) || (instance2.get(2) == instance.get(2) && instance2.get(5) < instance.get(5))) ? Integer.valueOf(valueOf.intValue() - 1) : valueOf;
    }

    public Date getBirthday() {
        return this.zzgn;
    }

    public AdRequest.Gender getGender() {
        return this.zzgo;
    }

    public Set<String> getKeywords() {
        return this.zzgp;
    }

    public Location getLocation() {
        return this.zzgr;
    }

    public boolean isTesting() {
        return this.zzgq;
    }
}
