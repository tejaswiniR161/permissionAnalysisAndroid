package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.zza;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zziy;

@zziy
public class AdSizeParcel extends AbstractSafeParcelable {
    public static final zzi CREATOR = new zzi();
    public final int height;
    public final int heightPixels;
    public final int versionCode;
    public final int width;
    public final int widthPixels;
    public final String zzaxi;
    public final boolean zzaxj;
    public final AdSizeParcel[] zzaxk;
    public final boolean zzaxl;
    public final boolean zzaxm;
    public boolean zzaxn;

    public AdSizeParcel() {
        this(5, "interstitial_mb", 0, 0, true, 0, 0, (AdSizeParcel[]) null, false, false, false);
    }

    AdSizeParcel(int i, String str, int i2, int i3, boolean z, int i4, int i5, AdSizeParcel[] adSizeParcelArr, boolean z2, boolean z3, boolean z4) {
        this.versionCode = i;
        this.zzaxi = str;
        this.height = i2;
        this.heightPixels = i3;
        this.zzaxj = z;
        this.width = i4;
        this.widthPixels = i5;
        this.zzaxk = adSizeParcelArr;
        this.zzaxl = z2;
        this.zzaxm = z3;
        this.zzaxn = z4;
    }

    public AdSizeParcel(Context context, AdSize adSize) {
        this(context, new AdSize[]{adSize});
    }

    public AdSizeParcel(Context context, AdSize[] adSizeArr) {
        int i;
        AdSize adSize = adSizeArr[0];
        this.versionCode = 5;
        this.zzaxj = false;
        this.zzaxm = adSize.isFluid();
        if (this.zzaxm) {
            this.width = AdSize.BANNER.getWidth();
            this.height = AdSize.BANNER.getHeight();
        } else {
            this.width = adSize.getWidth();
            this.height = adSize.getHeight();
        }
        boolean z = this.width == -1;
        boolean z2 = this.height == -2;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        if (z) {
            if (!zzm.zzjr().zzat(context) || !zzm.zzjr().zzau(context)) {
                this.widthPixels = zza(displayMetrics);
            } else {
                this.widthPixels = zza(displayMetrics) - zzm.zzjr().zzav(context);
            }
            double d = (double) (((float) this.widthPixels) / displayMetrics.density);
            int i2 = (int) d;
            i = d - ((double) ((int) d)) >= 0.01d ? i2 + 1 : i2;
        } else {
            int i3 = this.width;
            this.widthPixels = zzm.zzjr().zza(displayMetrics, this.width);
            i = i3;
        }
        int zzc = z2 ? zzc(displayMetrics) : this.height;
        this.heightPixels = zzm.zzjr().zza(displayMetrics, zzc);
        if (z || z2) {
            this.zzaxi = new StringBuilder(26).append(i).append("x").append(zzc).append("_as").toString();
        } else if (this.zzaxm) {
            this.zzaxi = "320x50_mb";
        } else {
            this.zzaxi = adSize.toString();
        }
        if (adSizeArr.length > 1) {
            this.zzaxk = new AdSizeParcel[adSizeArr.length];
            for (int i4 = 0; i4 < adSizeArr.length; i4++) {
                this.zzaxk[i4] = new AdSizeParcel(context, adSizeArr[i4]);
            }
        } else {
            this.zzaxk = null;
        }
        this.zzaxl = false;
        this.zzaxn = false;
    }

    public AdSizeParcel(AdSizeParcel adSizeParcel, AdSizeParcel[] adSizeParcelArr) {
        this(5, adSizeParcel.zzaxi, adSizeParcel.height, adSizeParcel.heightPixels, adSizeParcel.zzaxj, adSizeParcel.width, adSizeParcel.widthPixels, adSizeParcelArr, adSizeParcel.zzaxl, adSizeParcel.zzaxm, adSizeParcel.zzaxn);
    }

    public static int zza(DisplayMetrics displayMetrics) {
        return displayMetrics.widthPixels;
    }

    public static int zzb(DisplayMetrics displayMetrics) {
        return (int) (((float) zzc(displayMetrics)) * displayMetrics.density);
    }

    private static int zzc(DisplayMetrics displayMetrics) {
        int i = (int) (((float) displayMetrics.heightPixels) / displayMetrics.density);
        if (i <= 400) {
            return 32;
        }
        return i <= 720 ? 50 : 90;
    }

    public static AdSizeParcel zzjc() {
        return new AdSizeParcel(5, "reward_mb", 0, 0, true, 0, 0, (AdSizeParcel[]) null, false, false, false);
    }

    public static AdSizeParcel zzk(Context context) {
        return new AdSizeParcel(5, "320x50_mb", 0, 0, false, 0, 0, (AdSizeParcel[]) null, true, false, false);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.zza(this, parcel, i);
    }

    public AdSize zzjd() {
        return zza.zza(this.width, this.height, this.zzaxi);
    }

    public void zzl(boolean z) {
        this.zzaxn = z;
    }
}
