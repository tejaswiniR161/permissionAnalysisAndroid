package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzac;

public class PlayLoggerContext extends AbstractSafeParcelable {
    public static final zza CREATOR = new zza();
    public final boolean axA;
    public final int axB;
    public final int axu;
    public final int axv;
    public final String axw;
    public final String axx;
    public final boolean axy;
    public final String axz;
    public final String packageName;
    public final int versionCode;

    public PlayLoggerContext(int i, String str, int i2, int i3, String str2, String str3, boolean z, String str4, boolean z2, int i4) {
        this.versionCode = i;
        this.packageName = str;
        this.axu = i2;
        this.axv = i3;
        this.axw = str2;
        this.axx = str3;
        this.axy = z;
        this.axz = str4;
        this.axA = z2;
        this.axB = i4;
    }

    public PlayLoggerContext(String str, int i, int i2, String str2, String str3, String str4, boolean z, int i3) {
        this.versionCode = 1;
        this.packageName = (String) zzac.zzy(str);
        this.axu = i;
        this.axv = i2;
        this.axz = str2;
        this.axw = str3;
        this.axx = str4;
        this.axy = !z;
        this.axA = z;
        this.axB = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayLoggerContext)) {
            return false;
        }
        PlayLoggerContext playLoggerContext = (PlayLoggerContext) obj;
        return this.versionCode == playLoggerContext.versionCode && this.packageName.equals(playLoggerContext.packageName) && this.axu == playLoggerContext.axu && this.axv == playLoggerContext.axv && zzab.equal(this.axz, playLoggerContext.axz) && zzab.equal(this.axw, playLoggerContext.axw) && zzab.equal(this.axx, playLoggerContext.axx) && this.axy == playLoggerContext.axy && this.axA == playLoggerContext.axA && this.axB == playLoggerContext.axB;
    }

    public int hashCode() {
        return zzab.hashCode(Integer.valueOf(this.versionCode), this.packageName, Integer.valueOf(this.axu), Integer.valueOf(this.axv), this.axz, this.axw, this.axx, Boolean.valueOf(this.axy), Boolean.valueOf(this.axA), Integer.valueOf(this.axB));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PlayLoggerContext[");
        sb.append("versionCode=").append(this.versionCode).append(',');
        sb.append("package=").append(this.packageName).append(',');
        sb.append("packageVersionCode=").append(this.axu).append(',');
        sb.append("logSource=").append(this.axv).append(',');
        sb.append("logSourceName=").append(this.axz).append(',');
        sb.append("uploadAccount=").append(this.axw).append(',');
        sb.append("loggingId=").append(this.axx).append(',');
        sb.append("logAndroidId=").append(this.axy).append(',');
        sb.append("isAnonymous=").append(this.axA).append(',');
        sb.append("qosTier=").append(this.axB);
        sb.append("]");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
