package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zziy;

@zziy
public final class SearchAdRequestParcel extends AbstractSafeParcelable {
    public static final zzao CREATOR = new zzao();
    public final int backgroundColor;
    public final int versionCode;
    public final int zzazp;
    public final int zzazq;
    public final int zzazr;
    public final int zzazs;
    public final int zzazt;
    public final int zzazu;
    public final int zzazv;
    public final String zzazw;
    public final int zzazx;
    public final String zzazy;
    public final int zzazz;
    public final int zzbaa;
    public final String zzbab;

    SearchAdRequestParcel(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, String str, int i10, String str2, int i11, int i12, String str3) {
        this.versionCode = i;
        this.zzazp = i2;
        this.backgroundColor = i3;
        this.zzazq = i4;
        this.zzazr = i5;
        this.zzazs = i6;
        this.zzazt = i7;
        this.zzazu = i8;
        this.zzazv = i9;
        this.zzazw = str;
        this.zzazx = i10;
        this.zzazy = str2;
        this.zzazz = i11;
        this.zzbaa = i12;
        this.zzbab = str3;
    }

    public SearchAdRequestParcel(SearchAdRequest searchAdRequest) {
        this.versionCode = 1;
        this.zzazp = searchAdRequest.getAnchorTextColor();
        this.backgroundColor = searchAdRequest.getBackgroundColor();
        this.zzazq = searchAdRequest.getBackgroundGradientBottom();
        this.zzazr = searchAdRequest.getBackgroundGradientTop();
        this.zzazs = searchAdRequest.getBorderColor();
        this.zzazt = searchAdRequest.getBorderThickness();
        this.zzazu = searchAdRequest.getBorderType();
        this.zzazv = searchAdRequest.getCallButtonColor();
        this.zzazw = searchAdRequest.getCustomChannels();
        this.zzazx = searchAdRequest.getDescriptionTextColor();
        this.zzazy = searchAdRequest.getFontFace();
        this.zzazz = searchAdRequest.getHeaderTextColor();
        this.zzbaa = searchAdRequest.getHeaderTextSize();
        this.zzbab = searchAdRequest.getQuery();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzao.zza(this, parcel, i);
    }
}
