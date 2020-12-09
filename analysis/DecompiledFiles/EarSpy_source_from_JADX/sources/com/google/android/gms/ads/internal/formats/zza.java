package com.google.android.gms.ads.internal.formats;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.applovin.sdk.AppLovinErrorCodes;
import com.google.android.gms.internal.zziy;
import java.util.List;

@zziy
public class zza {
    private static final int zzbjc = Color.rgb(12, 174, 206);
    private static final int zzbjd = Color.rgb(AppLovinErrorCodes.NO_FILL, AppLovinErrorCodes.NO_FILL, AppLovinErrorCodes.NO_FILL);
    static final int zzbje = zzbjd;
    static final int zzbjf = zzbjc;
    private final int mBackgroundColor;
    private final int mTextColor;
    private final String zzbjg;
    private final List<Drawable> zzbjh;
    private final int zzbji;
    private final int zzbjj;
    private final int zzbjk;

    public zza(String str, List<Drawable> list, Integer num, Integer num2, Integer num3, int i, int i2) {
        this.zzbjg = str;
        this.zzbjh = list;
        this.mBackgroundColor = num != null ? num.intValue() : zzbje;
        this.mTextColor = num2 != null ? num2.intValue() : zzbjf;
        this.zzbji = num3 != null ? num3.intValue() : 12;
        this.zzbjj = i;
        this.zzbjk = i2;
    }

    public int getBackgroundColor() {
        return this.mBackgroundColor;
    }

    public String getText() {
        return this.zzbjg;
    }

    public int getTextColor() {
        return this.mTextColor;
    }

    public int getTextSize() {
        return this.zzbji;
    }

    public List<Drawable> zzlj() {
        return this.zzbjh;
    }

    public int zzlk() {
        return this.zzbjj;
    }

    public int zzll() {
        return this.zzbjk;
    }
}
