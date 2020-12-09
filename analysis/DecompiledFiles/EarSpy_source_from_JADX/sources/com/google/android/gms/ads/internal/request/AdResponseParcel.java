package com.google.android.gms.ads.internal.request;

import android.os.Parcel;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import com.google.android.gms.ads.internal.safebrowsing.SafeBrowsingConfigParcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zziy;
import java.util.Collections;
import java.util.List;

@zziy
public final class AdResponseParcel extends AbstractSafeParcelable {
    public static final zzh CREATOR = new zzh();
    public String body;
    public final int errorCode;
    public final int orientation;
    public final int versionCode;
    public final boolean zzaxl;
    public final boolean zzaxm;
    public final boolean zzaxn;
    public final List<String> zzbsd;
    public final List<String> zzbse;
    public final List<String> zzbsg;
    public final boolean zzbsh;
    public final long zzbsj;
    private AdRequestInfoParcel zzbtk;
    public final String zzbyj;
    public final boolean zzcgc;
    public final boolean zzcgt;
    @Nullable
    public String zzcgu;
    public final long zzchb;
    public final boolean zzchc;
    public final long zzchd;
    public final List<String> zzche;
    public final String zzchf;
    public final long zzchg;
    public final String zzchh;
    public final boolean zzchi;
    public final String zzchj;
    public final String zzchk;
    public final boolean zzchl;
    public final boolean zzchm;
    public final boolean zzchn;
    public LargeParcelTeleporter zzcho;
    public String zzchp;
    public final String zzchq;
    @Nullable
    public final RewardItemParcel zzchr;
    @Nullable
    public final List<String> zzchs;
    @Nullable
    public final List<String> zzcht;
    public final boolean zzchu;
    @Nullable
    public final AutoClickProtectionConfigurationParcel zzchv;
    @Nullable
    public final String zzchw;
    @Nullable
    public final SafeBrowsingConfigParcel zzchx;
    @Nullable
    public final String zzchy;

    public AdResponseParcel(int i) {
        this(18, (String) null, (String) null, (List<String>) null, i, (List<String>) null, -1, false, -1, (List<String>) null, -1, -1, (String) null, -1, (String) null, false, (String) null, (String) null, false, false, false, true, false, (LargeParcelTeleporter) null, (String) null, (String) null, false, false, (RewardItemParcel) null, (List<String>) null, (List<String>) null, false, (AutoClickProtectionConfigurationParcel) null, false, (String) null, (List<String>) null, false, (String) null, (SafeBrowsingConfigParcel) null, (String) null);
    }

    public AdResponseParcel(int i, long j) {
        this(18, (String) null, (String) null, (List<String>) null, i, (List<String>) null, -1, false, -1, (List<String>) null, j, -1, (String) null, -1, (String) null, false, (String) null, (String) null, false, false, false, true, false, (LargeParcelTeleporter) null, (String) null, (String) null, false, false, (RewardItemParcel) null, (List<String>) null, (List<String>) null, false, (AutoClickProtectionConfigurationParcel) null, false, (String) null, (List<String>) null, false, (String) null, (SafeBrowsingConfigParcel) null, (String) null);
    }

    AdResponseParcel(int i, String str, String str2, List<String> list, int i2, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i3, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, LargeParcelTeleporter largeParcelTeleporter, String str7, String str8, boolean z8, boolean z9, RewardItemParcel rewardItemParcel, List<String> list4, List<String> list5, boolean z10, AutoClickProtectionConfigurationParcel autoClickProtectionConfigurationParcel, boolean z11, String str9, List<String> list6, boolean z12, String str10, SafeBrowsingConfigParcel safeBrowsingConfigParcel, String str11) {
        StringParcel stringParcel;
        this.versionCode = i;
        this.zzbyj = str;
        this.body = str2;
        this.zzbsd = list != null ? Collections.unmodifiableList(list) : null;
        this.errorCode = i2;
        this.zzbse = list2 != null ? Collections.unmodifiableList(list2) : null;
        this.zzchb = j;
        this.zzchc = z;
        this.zzchd = j2;
        this.zzche = list3 != null ? Collections.unmodifiableList(list3) : null;
        this.zzbsj = j3;
        this.orientation = i3;
        this.zzchf = str3;
        this.zzchg = j4;
        this.zzchh = str4;
        this.zzchi = z2;
        this.zzchj = str5;
        this.zzchk = str6;
        this.zzchl = z3;
        this.zzaxl = z4;
        this.zzcgc = z5;
        this.zzchm = z6;
        this.zzchn = z7;
        this.zzcho = largeParcelTeleporter;
        this.zzchp = str7;
        this.zzchq = str8;
        if (this.body == null && this.zzcho != null && (stringParcel = (StringParcel) this.zzcho.zza(StringParcel.CREATOR)) != null && !TextUtils.isEmpty(stringParcel.zzsb())) {
            this.body = stringParcel.zzsb();
        }
        this.zzaxm = z8;
        this.zzaxn = z9;
        this.zzchr = rewardItemParcel;
        this.zzchs = list4;
        this.zzcht = list5;
        this.zzchu = z10;
        this.zzchv = autoClickProtectionConfigurationParcel;
        this.zzcgt = z11;
        this.zzcgu = str9;
        this.zzbsg = list6;
        this.zzbsh = z12;
        this.zzchw = str10;
        this.zzchx = safeBrowsingConfigParcel;
        this.zzchy = str11;
    }

    public AdResponseParcel(AdRequestInfoParcel adRequestInfoParcel, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, String str5, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str6, boolean z7, boolean z8, RewardItemParcel rewardItemParcel, List<String> list4, List<String> list5, boolean z9, AutoClickProtectionConfigurationParcel autoClickProtectionConfigurationParcel, boolean z10, String str7, List<String> list6, boolean z11, String str8, SafeBrowsingConfigParcel safeBrowsingConfigParcel, String str9) {
        this(18, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, false, (String) null, str5, z2, z3, z4, z5, z6, (LargeParcelTeleporter) null, (String) null, str6, z7, z8, rewardItemParcel, list4, list5, z9, autoClickProtectionConfigurationParcel, z10, str7, list6, z11, str8, safeBrowsingConfigParcel, str9);
        this.zzbtk = adRequestInfoParcel;
    }

    public AdResponseParcel(AdRequestInfoParcel adRequestInfoParcel, String str, String str2, List<String> list, List<String> list2, long j, boolean z, long j2, List<String> list3, long j3, int i, String str3, long j4, String str4, boolean z2, String str5, String str6, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, String str7, boolean z8, boolean z9, RewardItemParcel rewardItemParcel, List<String> list4, List<String> list5, boolean z10, AutoClickProtectionConfigurationParcel autoClickProtectionConfigurationParcel, boolean z11, String str8, List<String> list6, boolean z12, String str9, SafeBrowsingConfigParcel safeBrowsingConfigParcel, String str10) {
        this(18, str, str2, list, -2, list2, j, z, j2, list3, j3, i, str3, j4, str4, z2, str5, str6, z3, z4, z5, z6, z7, (LargeParcelTeleporter) null, (String) null, str7, z8, z9, rewardItemParcel, list4, list5, z10, autoClickProtectionConfigurationParcel, z11, str8, list6, z12, str9, safeBrowsingConfigParcel, str10);
        this.zzbtk = adRequestInfoParcel;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.zzbtk != null && this.zzbtk.versionCode >= 9 && !TextUtils.isEmpty(this.body)) {
            this.zzcho = new LargeParcelTeleporter(new StringParcel(this.body));
            this.body = null;
        }
        zzh.zza(this, parcel, i);
    }
}
