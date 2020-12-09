package com.facebook.ads;

public enum AdSize {
    BANNER_320_50(320, 50),
    INTERSTITIAL(0, 0),
    BANNER_HEIGHT_50(-1, 50),
    BANNER_HEIGHT_90(-1, 90),
    RECTANGLE_HEIGHT_250(-1, 250);
    

    /* renamed from: a */
    private final int f750a;

    /* renamed from: b */
    private final int f751b;

    private AdSize(int i, int i2) {
        this.f750a = i;
        this.f751b = i2;
    }

    /* renamed from: a */
    private static boolean m704a(AdSize adSize, int i, int i2) {
        return adSize != null && adSize.f750a == i && adSize.f751b == i2;
    }

    public static AdSize fromWidthAndHeight(int i, int i2) {
        for (AdSize adSize : (AdSize[]) AdSize.class.getEnumConstants()) {
            if (m704a(adSize, i, i2)) {
                return adSize;
            }
        }
        return null;
    }

    public int getHeight() {
        return this.f751b;
    }

    public int getWidth() {
        return this.f750a;
    }
}
