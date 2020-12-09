package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.p000v4.p002os.EnvironmentCompat;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzac;

public class PlaceReport extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<PlaceReport> CREATOR = new zzi();

    /* renamed from: I */
    private final String f2274I;
    private final String aiY;
    private final String mTag;
    final int mVersionCode;

    PlaceReport(int i, String str, String str2, String str3) {
        this.mVersionCode = i;
        this.aiY = str;
        this.mTag = str2;
        this.f2274I = str3;
    }

    public static PlaceReport create(String str, String str2) {
        return zzj(str, str2, EnvironmentCompat.MEDIA_UNKNOWN);
    }

    public static PlaceReport zzj(String str, String str2, String str3) {
        zzac.zzy(str);
        zzac.zzhz(str2);
        zzac.zzhz(str3);
        zzac.zzb(zzla(str3), (Object) "Invalid source");
        return new PlaceReport(1, str, str2, str3);
    }

    private static boolean zzla(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1436706272:
                if (str.equals("inferredGeofencing")) {
                    c = 2;
                    break;
                }
                break;
            case -1194968642:
                if (str.equals("userReported")) {
                    c = 1;
                    break;
                }
                break;
            case -284840886:
                if (str.equals(EnvironmentCompat.MEDIA_UNKNOWN)) {
                    c = 0;
                    break;
                }
                break;
            case -262743844:
                if (str.equals("inferredReverseGeocoding")) {
                    c = 4;
                    break;
                }
                break;
            case 1164924125:
                if (str.equals("inferredSnappedToRoad")) {
                    c = 5;
                    break;
                }
                break;
            case 1287171955:
                if (str.equals("inferredRadioSignals")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                return true;
            default:
                return false;
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return zzab.equal(this.aiY, placeReport.aiY) && zzab.equal(this.mTag, placeReport.mTag) && zzab.equal(this.f2274I, placeReport.f2274I);
    }

    public String getPlaceId() {
        return this.aiY;
    }

    public String getSource() {
        return this.f2274I;
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return zzab.hashCode(this.aiY, this.mTag, this.f2274I);
    }

    public String toString() {
        zzab.zza zzx = zzab.zzx(this);
        zzx.zzg("placeId", this.aiY);
        zzx.zzg("tag", this.mTag);
        if (!EnvironmentCompat.MEDIA_UNKNOWN.equals(this.f2274I)) {
            zzx.zzg("source", this.f2274I);
        }
        return zzx.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }
}
