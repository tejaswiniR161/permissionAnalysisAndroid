package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzm;

public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
    public static final AdSize FLUID = new AdSize(-3, -4, "fluid");
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    public static final int FULL_WIDTH = -1;
    public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
    public static final AdSize SEARCH = new AdSize(-3, 0, "search_v2");
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
    private final int zzajw;
    private final int zzajx;
    private final String zzajy;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AdSize(int r7, int r8) {
        /*
            r6 = this;
            r0 = -1
            if (r7 != r0) goto L_0x004c
            java.lang.String r0 = "FULL"
            r1 = r0
        L_0x0006:
            r0 = -2
            if (r8 != r0) goto L_0x0052
            java.lang.String r0 = "AUTO"
        L_0x000b:
            java.lang.String r2 = "_as"
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            java.lang.String r4 = java.lang.String.valueOf(r1)
            int r4 = r4.length()
            int r4 = r4 + 1
            java.lang.String r5 = java.lang.String.valueOf(r0)
            int r5 = r5.length()
            int r4 = r4 + r5
            java.lang.String r5 = java.lang.String.valueOf(r2)
            int r5 = r5.length()
            int r4 = r4 + r5
            r3.<init>(r4)
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r3 = "x"
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.StringBuilder r0 = r0.append(r2)
            java.lang.String r0 = r0.toString()
            r6.<init>(r7, r8, r0)
            return
        L_0x004c:
            java.lang.String r0 = java.lang.String.valueOf(r7)
            r1 = r0
            goto L_0x0006
        L_0x0052:
            java.lang.String r0 = java.lang.String.valueOf(r8)
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.AdSize.<init>(int, int):void");
    }

    AdSize(int i, int i2, String str) {
        if (i < 0 && i != -1 && i != -3) {
            throw new IllegalArgumentException(new StringBuilder(37).append("Invalid width for AdSize: ").append(i).toString());
        } else if (i2 >= 0 || i2 == -2 || i2 == -4) {
            this.zzajw = i;
            this.zzajx = i2;
            this.zzajy = str;
        } else {
            throw new IllegalArgumentException(new StringBuilder(38).append("Invalid height for AdSize: ").append(i2).toString());
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        return this.zzajw == adSize.zzajw && this.zzajx == adSize.zzajx && this.zzajy.equals(adSize.zzajy);
    }

    public int getHeight() {
        return this.zzajx;
    }

    public int getHeightInPixels(Context context) {
        switch (this.zzajx) {
            case -4:
            case -3:
                return -1;
            case -2:
                return AdSizeParcel.zzb(context.getResources().getDisplayMetrics());
            default:
                return zzm.zzjr().zzb(context, this.zzajx);
        }
    }

    public int getWidth() {
        return this.zzajw;
    }

    public int getWidthInPixels(Context context) {
        switch (this.zzajw) {
            case -4:
            case -3:
                return -1;
            case -1:
                return AdSizeParcel.zza(context.getResources().getDisplayMetrics());
            default:
                return zzm.zzjr().zzb(context, this.zzajw);
        }
    }

    public int hashCode() {
        return this.zzajy.hashCode();
    }

    public boolean isAutoHeight() {
        return this.zzajx == -2;
    }

    public boolean isFluid() {
        return this.zzajw == -3 && this.zzajx == -4;
    }

    public boolean isFullWidth() {
        return this.zzajw == -1;
    }

    public String toString() {
        return this.zzajy;
    }
}
