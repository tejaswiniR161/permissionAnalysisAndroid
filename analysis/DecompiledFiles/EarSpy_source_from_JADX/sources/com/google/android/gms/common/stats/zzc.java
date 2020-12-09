package com.google.android.gms.common.stats;

import com.google.android.gms.internal.zzrs;

public final class zzc {

    /* renamed from: Ef */
    public static zzrs<Integer> f1828Ef = zzrs.zza("gms:common:stats:max_num_of_events", (Integer) 100);

    /* renamed from: Eg */
    public static zzrs<Integer> f1829Eg = zzrs.zza("gms:common:stats:max_chunk_size", (Integer) 100);

    public static final class zza {

        /* renamed from: Eh */
        public static zzrs<Integer> f1830Eh = zzrs.zza("gms:common:stats:connections:level", Integer.valueOf(zzd.LOG_LEVEL_OFF));

        /* renamed from: Ei */
        public static zzrs<String> f1831Ei = zzrs.zzab("gms:common:stats:connections:ignored_calling_processes", "");

        /* renamed from: Ej */
        public static zzrs<String> f1832Ej = zzrs.zzab("gms:common:stats:connections:ignored_calling_services", "");

        /* renamed from: Ek */
        public static zzrs<String> f1833Ek = zzrs.zzab("gms:common:stats:connections:ignored_target_processes", "");

        /* renamed from: El */
        public static zzrs<String> f1834El = zzrs.zzab("gms:common:stats:connections:ignored_target_services", "com.google.android.gms.auth.GetToken");

        /* renamed from: Em */
        public static zzrs<Long> f1835Em = zzrs.zza("gms:common:stats:connections:time_out_duration", (Long) 600000L);
    }

    public static final class zzb {

        /* renamed from: Eh */
        public static zzrs<Integer> f1836Eh = zzrs.zza("gms:common:stats:wakeLocks:level", Integer.valueOf(zzd.LOG_LEVEL_OFF));

        /* renamed from: Em */
        public static zzrs<Long> f1837Em = zzrs.zza("gms:common:stats:wakelocks:time_out_duration", (Long) 600000L);
    }
}
