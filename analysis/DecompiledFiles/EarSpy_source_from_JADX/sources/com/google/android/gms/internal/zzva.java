package com.google.android.gms.internal;

public final class zzva {

    /* renamed from: Uw */
    private static zzva f2258Uw;

    /* renamed from: Ux */
    private final zzux f2259Ux = new zzux();

    /* renamed from: Uy */
    private final zzuy f2260Uy = new zzuy();

    static {
        zza(new zzva());
    }

    private zzva() {
    }

    protected static void zza(zzva zzva) {
        synchronized (zzva.class) {
            f2258Uw = zzva;
        }
    }

    private static zzva zzbhl() {
        zzva zzva;
        synchronized (zzva.class) {
            zzva = f2258Uw;
        }
        return zzva;
    }

    public static zzux zzbhm() {
        return zzbhl().f2259Ux;
    }

    public static zzuy zzbhn() {
        return zzbhl().f2260Uy;
    }
}
