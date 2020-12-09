package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

@zziy
class zzfr {
    private final Object[] mParams;

    zzfr(AdRequestParcel adRequestParcel, String str, int i) {
        this.mParams = zza(adRequestParcel, str, i);
    }

    private static Object[] zza(AdRequestParcel adRequestParcel, String str, int i) {
        HashSet hashSet = new HashSet(Arrays.asList(zzdi.zzbdk.get().split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(adRequestParcel.zzawd));
        }
        if (hashSet.contains("extras")) {
            arrayList.add(zzc(adRequestParcel.extras));
        }
        if (hashSet.contains("gender")) {
            arrayList.add(Integer.valueOf(adRequestParcel.zzawe));
        }
        if (hashSet.contains("keywords")) {
            if (adRequestParcel.zzawf != null) {
                arrayList.add(adRequestParcel.zzawf.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(adRequestParcel.zzawg));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(adRequestParcel.zzawh));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(adRequestParcel.zzawi));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(adRequestParcel.zzawj);
        }
        if (hashSet.contains(FirebaseAnalytics.Param.LOCATION)) {
            if (adRequestParcel.zzawl != null) {
                arrayList.add(adRequestParcel.zzawl.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(adRequestParcel.zzawm);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(zzc(adRequestParcel.zzawn));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(zzc(adRequestParcel.zzawo));
        }
        if (hashSet.contains("categoryExclusions")) {
            if (adRequestParcel.zzawp != null) {
                arrayList.add(adRequestParcel.zzawp.toString());
            } else {
                arrayList.add((Object) null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(adRequestParcel.zzawq);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(adRequestParcel.zzawr);
        }
        return arrayList.toArray();
    }

    private static String zzc(@Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj = bundle.get((String) it.next());
            sb.append(obj == null ? "null" : obj instanceof Bundle ? zzc((Bundle) obj) : obj.toString());
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzfr)) {
            return false;
        }
        return Arrays.equals(this.mParams, ((zzfr) obj).mParams);
    }

    public int hashCode() {
        return Arrays.hashCode(this.mParams);
    }

    public String toString() {
        String valueOf = String.valueOf(Arrays.toString(this.mParams));
        return new StringBuilder(String.valueOf(valueOf).length() + 24).append("[InterstitialAdPoolKey ").append(valueOf).append("]").toString();
    }
}
