package com.google.firebase.crash.internal.config.flag;

import android.content.Context;
import android.support.annotation.Keep;
import com.google.android.gms.internal.zzuw;
import com.google.android.gms.internal.zzux;
import com.google.android.gms.internal.zzva;
import java.util.concurrent.TimeUnit;

@Keep
public final class Flags {
    public static final zzuw<Boolean> aVh = zzuw.zzb(0, "crash:enabled", (Boolean) true);
    public static final zzuw<String> aVi = zzuw.zzc(0, "crash:gateway_url", "https://mobilecrashreporting.googleapis.com/v1/crashes:batchCreate?key=");
    public static final zzuw<Integer> aVj = zzuw.zzb(0, "crash:log_buffer_capacity", 100);
    public static final zzuw<Integer> aVk = zzuw.zzb(0, "crash:log_buffer_max_total_size", 32768);
    public static final zzuw<Integer> aVl = zzuw.zzb(0, "crash:crash_backlog_capacity", 5);
    public static final zzuw<Long> aVm = zzuw.zzb(0, "crash:crash_backlog_max_age", 604800000);
    public static final zzuw<Long> aVn = zzuw.zzb(0, "crash:starting_backoff", TimeUnit.SECONDS.toMillis(1));
    public static final zzuw<Long> aVo = zzuw.zzb(0, "crash:backoff_limit", TimeUnit.MINUTES.toMillis(60));
    public static final zzuw<Integer> aVp = zzuw.zzb(0, "crash:retry_num_attempts", 12);
    public static final zzuw<Integer> aVq = zzuw.zzb(0, "crash:batch_size", 5);
    public static final zzuw<Long> aVr = zzuw.zzb(0, "crash:batch_throttle", TimeUnit.MINUTES.toMillis(5));
    public static final zzuw<Integer> aVs = zzuw.zzb(0, "crash:frame_depth", 60);

    private Flags() {
    }

    public static final void initialize(Context context) {
        zzva.zzbhm();
        zzux.initialize(context);
    }
}
