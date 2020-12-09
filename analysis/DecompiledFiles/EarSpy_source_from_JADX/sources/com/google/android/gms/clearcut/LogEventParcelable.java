package com.google.android.gms.clearcut;

import android.os.Parcel;
import com.google.android.gms.clearcut.zzb;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzarp;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.Arrays;

public class LogEventParcelable extends AbstractSafeParcelable {
    public static final zzd CREATOR = new zzd();

    /* renamed from: uc */
    public PlayLoggerContext f1453uc;

    /* renamed from: ud */
    public byte[] f1454ud;

    /* renamed from: ue */
    public int[] f1455ue;

    /* renamed from: uf */
    public String[] f1456uf;

    /* renamed from: ug */
    public int[] f1457ug;

    /* renamed from: uh */
    public byte[][] f1458uh;

    /* renamed from: ui */
    public boolean f1459ui;

    /* renamed from: uj */
    public final zzarp.zzd f1460uj;

    /* renamed from: uk */
    public final zzb.zzc f1461uk;

    /* renamed from: ul */
    public final zzb.zzc f1462ul;
    public final int versionCode;

    LogEventParcelable(int i, PlayLoggerContext playLoggerContext, byte[] bArr, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr2, boolean z) {
        this.versionCode = i;
        this.f1453uc = playLoggerContext;
        this.f1454ud = bArr;
        this.f1455ue = iArr;
        this.f1456uf = strArr;
        this.f1460uj = null;
        this.f1461uk = null;
        this.f1462ul = null;
        this.f1457ug = iArr2;
        this.f1458uh = bArr2;
        this.f1459ui = z;
    }

    public LogEventParcelable(PlayLoggerContext playLoggerContext, zzarp.zzd zzd, zzb.zzc zzc, zzb.zzc zzc2, int[] iArr, String[] strArr, int[] iArr2, byte[][] bArr, boolean z) {
        this.versionCode = 1;
        this.f1453uc = playLoggerContext;
        this.f1460uj = zzd;
        this.f1461uk = zzc;
        this.f1462ul = zzc2;
        this.f1455ue = iArr;
        this.f1456uf = strArr;
        this.f1457ug = iArr2;
        this.f1458uh = bArr;
        this.f1459ui = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogEventParcelable)) {
            return false;
        }
        LogEventParcelable logEventParcelable = (LogEventParcelable) obj;
        return this.versionCode == logEventParcelable.versionCode && zzab.equal(this.f1453uc, logEventParcelable.f1453uc) && Arrays.equals(this.f1454ud, logEventParcelable.f1454ud) && Arrays.equals(this.f1455ue, logEventParcelable.f1455ue) && Arrays.equals(this.f1456uf, logEventParcelable.f1456uf) && zzab.equal(this.f1460uj, logEventParcelable.f1460uj) && zzab.equal(this.f1461uk, logEventParcelable.f1461uk) && zzab.equal(this.f1462ul, logEventParcelable.f1462ul) && Arrays.equals(this.f1457ug, logEventParcelable.f1457ug) && Arrays.deepEquals(this.f1458uh, logEventParcelable.f1458uh) && this.f1459ui == logEventParcelable.f1459ui;
    }

    public int hashCode() {
        return zzab.hashCode(Integer.valueOf(this.versionCode), this.f1453uc, this.f1454ud, this.f1455ue, this.f1456uf, this.f1460uj, this.f1461uk, this.f1462ul, this.f1457ug, this.f1458uh, Boolean.valueOf(this.f1459ui));
    }

    public String toString() {
        return "LogEventParcelable[" + this.versionCode + ", " + this.f1453uc + ", " + "LogEventBytes: " + (this.f1454ud == null ? null : new String(this.f1454ud)) + ", " + "TestCodes: " + Arrays.toString(this.f1455ue) + ", " + "MendelPackages: " + Arrays.toString(this.f1456uf) + ", " + "LogEvent: " + this.f1460uj + ", " + "ExtensionProducer: " + this.f1461uk + ", " + "VeProducer: " + this.f1462ul + ", " + "ExperimentIDs: " + Arrays.toString(this.f1457ug) + ", " + "ExperimentTokens: " + Arrays.toString(this.f1458uh) + ", " + "AddPhenotypeExperimentTokens: " + this.f1459ui + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
