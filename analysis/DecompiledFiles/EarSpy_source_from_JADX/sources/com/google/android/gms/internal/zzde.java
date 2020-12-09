package com.google.android.gms.internal;

import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzu;

@zziy
public abstract class zzde<T> {
    private final int zzbae;
    private final String zzbaf;
    private final T zzbag;

    private zzde(int i, String str, T t) {
        this.zzbae = i;
        this.zzbaf = str;
        this.zzbag = t;
        zzu.zzgk().zza(this);
    }

    public static zzde<String> zza(int i, String str) {
        zzde<String> zza = zza(i, str, (String) null);
        zzu.zzgk().zzb(zza);
        return zza;
    }

    public static zzde<Integer> zza(int i, String str, int i2) {
        return new zzde<Integer>(i, str, Integer.valueOf(i2)) {
            /* renamed from: zzc */
            public Integer zza(SharedPreferences sharedPreferences) {
                return Integer.valueOf(sharedPreferences.getInt(getKey(), ((Integer) zzkq()).intValue()));
            }
        };
    }

    public static zzde<Long> zza(int i, String str, long j) {
        return new zzde<Long>(i, str, Long.valueOf(j)) {
            /* renamed from: zzd */
            public Long zza(SharedPreferences sharedPreferences) {
                return Long.valueOf(sharedPreferences.getLong(getKey(), ((Long) zzkq()).longValue()));
            }
        };
    }

    public static zzde<Boolean> zza(int i, String str, Boolean bool) {
        return new zzde<Boolean>(i, str, bool) {
            /* renamed from: zzb */
            public Boolean zza(SharedPreferences sharedPreferences) {
                return Boolean.valueOf(sharedPreferences.getBoolean(getKey(), ((Boolean) zzkq()).booleanValue()));
            }
        };
    }

    public static zzde<String> zza(int i, String str, String str2) {
        return new zzde<String>(i, str, str2) {
            /* renamed from: zze */
            public String zza(SharedPreferences sharedPreferences) {
                return sharedPreferences.getString(getKey(), (String) zzkq());
            }
        };
    }

    public static zzde<String> zzb(int i, String str) {
        zzde<String> zza = zza(i, str, (String) null);
        zzu.zzgk().zzc(zza);
        return zza;
    }

    public T get() {
        return zzu.zzgl().zzd(this);
    }

    public String getKey() {
        return this.zzbaf;
    }

    /* access modifiers changed from: protected */
    public abstract T zza(SharedPreferences sharedPreferences);

    public T zzkq() {
        return this.zzbag;
    }
}
