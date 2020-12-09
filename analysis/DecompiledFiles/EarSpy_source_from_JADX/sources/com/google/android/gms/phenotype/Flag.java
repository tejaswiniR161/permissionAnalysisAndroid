package com.google.android.gms.phenotype;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;

public class Flag extends AbstractSafeParcelable implements Comparable<Flag> {
    public static final Parcelable.Creator<Flag> CREATOR = new zzb();
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final zza axt = new zza();

    /* renamed from: Dr */
    final String f2301Dr;
    final double afA;
    final boolean afy;
    final long axp;
    final byte[] axq;
    public final int axr;
    public final int axs;
    final int mVersionCode;
    public final String name;

    public static class zza implements Comparator<Flag> {
        /* renamed from: zza */
        public int compare(Flag flag, Flag flag2) {
            return flag.axs == flag2.axs ? flag.name.compareTo(flag2.name) : flag.axs - flag2.axs;
        }
    }

    Flag(int i, String str, long j, boolean z, double d, String str2, byte[] bArr, int i2, int i3) {
        this.mVersionCode = i;
        this.name = str;
        this.axp = j;
        this.afy = z;
        this.afA = d;
        this.f2301Dr = str2;
        this.axq = bArr;
        this.axr = i2;
        this.axs = i3;
    }

    private static int compare(byte b, byte b2) {
        return b - b2;
    }

    private static int compare(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    private static int compare(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    private static int compare(String str, String str2) {
        if (str == str2) {
            return 0;
        }
        if (str == null) {
            return -1;
        }
        if (str2 == null) {
            return 1;
        }
        return str.compareTo(str2);
    }

    private static int compare(boolean z, boolean z2) {
        if (z == z2) {
            return 0;
        }
        return z ? 1 : -1;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Flag)) {
            return false;
        }
        Flag flag = (Flag) obj;
        if (this.mVersionCode != flag.mVersionCode || !zzab.equal(this.name, flag.name) || this.axr != flag.axr || this.axs != flag.axs) {
            return false;
        }
        switch (this.axr) {
            case 1:
                return this.axp == flag.axp;
            case 2:
                return this.afy == flag.afy;
            case 3:
                return this.afA == flag.afA;
            case 4:
                return zzab.equal(this.f2301Dr, flag.f2301Dr);
            case 5:
                return Arrays.equals(this.axq, flag.axq);
            default:
                throw new AssertionError(new StringBuilder(31).append("Invalid enum value: ").append(this.axr).toString());
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Flag(");
        sb.append(this.mVersionCode);
        sb.append(", ");
        sb.append(this.name);
        sb.append(", ");
        switch (this.axr) {
            case 1:
                sb.append(this.axp);
                break;
            case 2:
                sb.append(this.afy);
                break;
            case 3:
                sb.append(this.afA);
                break;
            case 4:
                sb.append("'");
                sb.append(this.f2301Dr);
                sb.append("'");
                break;
            case 5:
                if (this.axq != null) {
                    sb.append("'");
                    sb.append(new String(this.axq, UTF_8));
                    sb.append("'");
                    break;
                } else {
                    sb.append("null");
                    break;
                }
            default:
                throw new AssertionError(new StringBuilder(31).append("Invalid enum value: ").append(this.axr).toString());
        }
        sb.append(", ");
        sb.append(this.axr);
        sb.append(", ");
        sb.append(this.axs);
        sb.append(")");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    /* renamed from: zza */
    public int compareTo(Flag flag) {
        int compareTo = this.name.compareTo(flag.name);
        if (compareTo != 0) {
            return compareTo;
        }
        int compare = compare(this.axr, flag.axr);
        if (compare != 0) {
            return compare;
        }
        switch (this.axr) {
            case 1:
                return compare(this.axp, flag.axp);
            case 2:
                return compare(this.afy, flag.afy);
            case 3:
                return Double.compare(this.afA, flag.afA);
            case 4:
                return compare(this.f2301Dr, flag.f2301Dr);
            case 5:
                if (this.axq == flag.axq) {
                    return 0;
                }
                if (this.axq == null) {
                    return -1;
                }
                if (flag.axq == null) {
                    return 1;
                }
                for (int i = 0; i < Math.min(this.axq.length, flag.axq.length); i++) {
                    int compare2 = compare(this.axq[i], flag.axq[i]);
                    if (compare2 != 0) {
                        return compare2;
                    }
                }
                return compare(this.axq.length, flag.axq.length);
            default:
                throw new AssertionError(new StringBuilder(31).append("Invalid enum value: ").append(this.axr).toString());
        }
    }
}
