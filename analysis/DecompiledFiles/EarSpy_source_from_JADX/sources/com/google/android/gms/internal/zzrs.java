package com.google.android.gms.internal;

import android.os.Binder;

public abstract class zzrs<T> {
    private static String READ_PERMISSION = "com.google.android.providers.gsf.permission.READ_GSERVICES";

    /* renamed from: zB */
    private static zza f2209zB = null;

    /* renamed from: zC */
    private static int f2210zC = 0;
    private static final Object zzaok = new Object();

    /* renamed from: zD */
    private T f2211zD = null;
    protected final String zzbaf;
    protected final T zzbag;

    private interface zza {
        Long getLong(String str, Long l);

        String getString(String str, String str2);

        Boolean zza(String str, Boolean bool);

        Float zzb(String str, Float f);

        Integer zzb(String str, Integer num);
    }

    protected zzrs(String str, T t) {
        this.zzbaf = str;
        this.zzbag = t;
    }

    public static zzrs<Float> zza(String str, Float f) {
        return new zzrs<Float>(str, f) {
            /* access modifiers changed from: protected */
            /* renamed from: zzhk */
            public Float zzhg(String str) {
                return zzrs.zzasy().zzb(this.zzbaf, (Float) this.zzbag);
            }
        };
    }

    public static zzrs<Integer> zza(String str, Integer num) {
        return new zzrs<Integer>(str, num) {
            /* access modifiers changed from: protected */
            /* renamed from: zzhj */
            public Integer zzhg(String str) {
                return zzrs.zzasy().zzb(this.zzbaf, (Integer) this.zzbag);
            }
        };
    }

    public static zzrs<Long> zza(String str, Long l) {
        return new zzrs<Long>(str, l) {
            /* access modifiers changed from: protected */
            /* renamed from: zzhi */
            public Long zzhg(String str) {
                return zzrs.zzasy().getLong(this.zzbaf, (Long) this.zzbag);
            }
        };
    }

    public static zzrs<String> zzab(String str, String str2) {
        return new zzrs<String>(str, str2) {
            /* access modifiers changed from: protected */
            /* renamed from: zzhl */
            public String zzhg(String str) {
                return zzrs.zzasy().getString(this.zzbaf, (String) this.zzbag);
            }
        };
    }

    static /* synthetic */ zza zzasy() {
        return null;
    }

    public static zzrs<Boolean> zzm(String str, boolean z) {
        return new zzrs<Boolean>(str, Boolean.valueOf(z)) {
            /* access modifiers changed from: protected */
            /* renamed from: zzhh */
            public Boolean zzhg(String str) {
                return zzrs.zzasy().zza(this.zzbaf, (Boolean) this.zzbag);
            }
        };
    }

    public final T get() {
        long clearCallingIdentity;
        try {
            return zzhg(this.zzbaf);
        } catch (SecurityException e) {
            clearCallingIdentity = Binder.clearCallingIdentity();
            T zzhg = zzhg(this.zzbaf);
            Binder.restoreCallingIdentity(clearCallingIdentity);
            return zzhg;
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public abstract T zzhg(String str);
}
