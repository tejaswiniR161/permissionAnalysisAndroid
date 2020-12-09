package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.p000v4.util.SimpleArrayMap;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzr;
import com.google.android.gms.ads.internal.client.zzs;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzei;
import com.google.android.gms.internal.zzej;
import com.google.android.gms.internal.zzek;
import com.google.android.gms.internal.zzgq;
import com.google.android.gms.internal.zziy;

@zziy
public class zzk extends zzs.zza {
    private final Context mContext;
    private final zzd zzalo;
    private final zzgq zzals;
    private zzq zzamy;
    private NativeAdOptionsParcel zzand;
    private zzy zzanf;
    private final String zzang;
    private final VersionInfoParcel zzanh;
    private zzeh zzanl;
    private zzei zzanm;
    private SimpleArrayMap<String, zzej> zzann = new SimpleArrayMap<>();
    private SimpleArrayMap<String, zzek> zzano = new SimpleArrayMap<>();

    public zzk(Context context, String str, zzgq zzgq, VersionInfoParcel versionInfoParcel, zzd zzd) {
        this.mContext = context;
        this.zzang = str;
        this.zzals = zzgq;
        this.zzanh = versionInfoParcel;
        this.zzalo = zzd;
    }

    public void zza(NativeAdOptionsParcel nativeAdOptionsParcel) {
        this.zzand = nativeAdOptionsParcel;
    }

    public void zza(zzeh zzeh) {
        this.zzanl = zzeh;
    }

    public void zza(zzei zzei) {
        this.zzanm = zzei;
    }

    public void zza(String str, zzek zzek, zzej zzej) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Custom template ID for native custom template ad is empty. Please provide a valid template id.");
        }
        this.zzano.put(str, zzek);
        this.zzann.put(str, zzej);
    }

    public void zzb(zzq zzq) {
        this.zzamy = zzq;
    }

    public void zzb(zzy zzy) {
        this.zzanf = zzy;
    }

    public zzr zzey() {
        return new zzj(this.mContext, this.zzang, this.zzals, this.zzanh, this.zzamy, this.zzanl, this.zzanm, this.zzano, this.zzann, this.zzand, this.zzanf, this.zzalo);
    }
}
