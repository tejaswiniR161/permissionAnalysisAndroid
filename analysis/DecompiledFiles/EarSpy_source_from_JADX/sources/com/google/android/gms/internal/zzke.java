package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzi;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.request.AutoClickProtectionConfigurationParcel;
import com.google.android.gms.ads.internal.reward.mediation.client.RewardItemParcel;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

@zziy
public class zzke {
    public final int errorCode;
    public final int orientation;
    public final List<String> zzbsd;
    public final List<String> zzbse;
    @Nullable
    public final List<String> zzbsg;
    public final long zzbsj;
    @Nullable
    public final zzgg zzbte;
    @Nullable
    public final zzgr zzbtf;
    @Nullable
    public final String zzbtg;
    @Nullable
    public final zzgj zzbth;
    @Nullable
    public final zzlt zzbyh;
    public final AdRequestParcel zzcfu;
    public final String zzcfx;
    public final long zzchb;
    public final boolean zzchc;
    public final long zzchd;
    public final List<String> zzche;
    public final String zzchh;
    @Nullable
    public final RewardItemParcel zzchr;
    @Nullable
    public final List<String> zzcht;
    public final boolean zzchu;
    public final AutoClickProtectionConfigurationParcel zzchv;
    public final String zzchy;
    public final JSONObject zzcod;
    public boolean zzcoe;
    public final zzgh zzcof;
    @Nullable
    public final String zzcog;
    public final AdSizeParcel zzcoh;
    @Nullable
    public final List<String> zzcoi;
    public final long zzcoj;
    public final long zzcok;
    @Nullable
    public final zzi.zza zzcol;
    public boolean zzcom;
    public boolean zzcon;
    public boolean zzcoo;

    @zziy
    public static final class zza {
        public final int errorCode;
        @Nullable
        public final AdSizeParcel zzaqz;
        public final AdRequestInfoParcel zzcix;
        @Nullable
        public final JSONObject zzcod;
        public final zzgh zzcof;
        public final long zzcoj;
        public final long zzcok;
        public final AdResponseParcel zzcop;

        public zza(AdRequestInfoParcel adRequestInfoParcel, AdResponseParcel adResponseParcel, zzgh zzgh, AdSizeParcel adSizeParcel, int i, long j, long j2, JSONObject jSONObject) {
            this.zzcix = adRequestInfoParcel;
            this.zzcop = adResponseParcel;
            this.zzcof = zzgh;
            this.zzaqz = adSizeParcel;
            this.errorCode = i;
            this.zzcoj = j;
            this.zzcok = j2;
            this.zzcod = jSONObject;
        }
    }

    public zzke(AdRequestParcel adRequestParcel, @Nullable zzlt zzlt, List<String> list, int i, List<String> list2, List<String> list3, int i2, long j, String str, boolean z, @Nullable zzgg zzgg, @Nullable zzgr zzgr, @Nullable String str2, zzgh zzgh, @Nullable zzgj zzgj, long j2, AdSizeParcel adSizeParcel, long j3, long j4, long j5, String str3, JSONObject jSONObject, @Nullable zzi.zza zza2, RewardItemParcel rewardItemParcel, List<String> list4, List<String> list5, boolean z2, AutoClickProtectionConfigurationParcel autoClickProtectionConfigurationParcel, @Nullable String str4, List<String> list6, String str5) {
        this.zzcom = false;
        this.zzcon = false;
        this.zzcoo = false;
        this.zzcfu = adRequestParcel;
        this.zzbyh = zzlt;
        this.zzbsd = zzm(list);
        this.errorCode = i;
        this.zzbse = zzm(list2);
        this.zzche = zzm(list3);
        this.orientation = i2;
        this.zzbsj = j;
        this.zzcfx = str;
        this.zzchc = z;
        this.zzbte = zzgg;
        this.zzbtf = zzgr;
        this.zzbtg = str2;
        this.zzcof = zzgh;
        this.zzbth = zzgj;
        this.zzchd = j2;
        this.zzcoh = adSizeParcel;
        this.zzchb = j3;
        this.zzcoj = j4;
        this.zzcok = j5;
        this.zzchh = str3;
        this.zzcod = jSONObject;
        this.zzcol = zza2;
        this.zzchr = rewardItemParcel;
        this.zzcoi = zzm(list4);
        this.zzcht = zzm(list5);
        this.zzchu = z2;
        this.zzchv = autoClickProtectionConfigurationParcel;
        this.zzcog = str4;
        this.zzbsg = zzm(list6);
        this.zzchy = str5;
    }

    public zzke(zza zza2, @Nullable zzlt zzlt, @Nullable zzgg zzgg, @Nullable zzgr zzgr, @Nullable String str, @Nullable zzgj zzgj, @Nullable zzi.zza zza3, @Nullable String str2) {
        this(zza2.zzcix.zzcfu, zzlt, zza2.zzcop.zzbsd, zza2.errorCode, zza2.zzcop.zzbse, zza2.zzcop.zzche, zza2.zzcop.orientation, zza2.zzcop.zzbsj, zza2.zzcix.zzcfx, zza2.zzcop.zzchc, zzgg, zzgr, str, zza2.zzcof, zzgj, zza2.zzcop.zzchd, zza2.zzaqz, zza2.zzcop.zzchb, zza2.zzcoj, zza2.zzcok, zza2.zzcop.zzchh, zza2.zzcod, zza3, zza2.zzcop.zzchr, zza2.zzcop.zzchs, zza2.zzcop.zzchs, zza2.zzcop.zzchu, zza2.zzcop.zzchv, str2, zza2.zzcop.zzbsg, zza2.zzcop.zzchy);
    }

    @Nullable
    private static <T> List<T> zzm(@Nullable List<T> list) {
        if (list == null) {
            return null;
        }
        return Collections.unmodifiableList(list);
    }

    public boolean zzib() {
        if (this.zzbyh == null || this.zzbyh.zzvr() == null) {
            return false;
        }
        return this.zzbyh.zzvr().zzib();
    }
}
