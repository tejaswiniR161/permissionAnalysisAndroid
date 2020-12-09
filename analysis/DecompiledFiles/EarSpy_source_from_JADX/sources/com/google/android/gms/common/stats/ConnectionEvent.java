package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;

public final class ConnectionEvent extends StatsEvent {
    public static final Parcelable.Creator<ConnectionEvent> CREATOR = new zza();

    /* renamed from: DM */
    private final long f1795DM;

    /* renamed from: DN */
    private int f1796DN;

    /* renamed from: DO */
    private final String f1797DO;

    /* renamed from: DP */
    private final String f1798DP;

    /* renamed from: DQ */
    private final String f1799DQ;

    /* renamed from: DR */
    private final String f1800DR;

    /* renamed from: DS */
    private final String f1801DS;

    /* renamed from: DT */
    private final String f1802DT;

    /* renamed from: DU */
    private final long f1803DU;

    /* renamed from: DV */
    private final long f1804DV;

    /* renamed from: DW */
    private long f1805DW;
    final int mVersionCode;

    ConnectionEvent(int i, long j, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this.mVersionCode = i;
        this.f1795DM = j;
        this.f1796DN = i2;
        this.f1797DO = str;
        this.f1798DP = str2;
        this.f1799DQ = str3;
        this.f1800DR = str4;
        this.f1805DW = -1;
        this.f1801DS = str5;
        this.f1802DT = str6;
        this.f1803DU = j2;
        this.f1804DV = j3;
    }

    public ConnectionEvent(long j, int i, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this(1, j, i, str, str2, str3, str4, str5, str6, j2, j3);
    }

    public int getEventType() {
        return this.f1796DN;
    }

    public long getTimeMillis() {
        return this.f1795DM;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }

    public String zzawk() {
        return this.f1797DO;
    }

    public String zzawl() {
        return this.f1798DP;
    }

    public String zzawm() {
        return this.f1799DQ;
    }

    public String zzawn() {
        return this.f1800DR;
    }

    public String zzawo() {
        return this.f1801DS;
    }

    public String zzawp() {
        return this.f1802DT;
    }

    public long zzawq() {
        return this.f1805DW;
    }

    public long zzawr() {
        return this.f1804DV;
    }

    public long zzaws() {
        return this.f1803DU;
    }

    public String zzawt() {
        String valueOf = String.valueOf("\t");
        String valueOf2 = String.valueOf(zzawk());
        String valueOf3 = String.valueOf(zzawl());
        String valueOf4 = String.valueOf("\t");
        String valueOf5 = String.valueOf(zzawm());
        String valueOf6 = String.valueOf(zzawn());
        String valueOf7 = String.valueOf("\t");
        String str = this.f1801DS == null ? "" : this.f1801DS;
        String valueOf8 = String.valueOf("\t");
        return new StringBuilder(String.valueOf(valueOf).length() + 22 + String.valueOf(valueOf2).length() + String.valueOf(valueOf3).length() + String.valueOf(valueOf4).length() + String.valueOf(valueOf5).length() + String.valueOf(valueOf6).length() + String.valueOf(valueOf7).length() + String.valueOf(str).length() + String.valueOf(valueOf8).length()).append(valueOf).append(valueOf2).append("/").append(valueOf3).append(valueOf4).append(valueOf5).append("/").append(valueOf6).append(valueOf7).append(str).append(valueOf8).append(zzawr()).toString();
    }
}
