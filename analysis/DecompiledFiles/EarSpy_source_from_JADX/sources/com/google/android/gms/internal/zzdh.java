package com.google.android.gms.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.zze;
import java.util.concurrent.Callable;

@zziy
public class zzdh {
    private final Object zzakd = new Object();
    private boolean zzaom = false;
    /* access modifiers changed from: private */
    @Nullable
    public SharedPreferences zzbak = null;

    public void initialize(Context context) {
        synchronized (this.zzakd) {
            if (!this.zzaom) {
                Context remoteContext = zze.getRemoteContext(context);
                if (remoteContext != null) {
                    this.zzbak = zzu.zzgj().zzn(remoteContext);
                    this.zzaom = true;
                }
            }
        }
    }

    public <T> T zzd(final zzde<T> zzde) {
        synchronized (this.zzakd) {
            if (this.zzaom) {
                return zzle.zzb(new Callable<T>() {
                    public T call() {
                        return zzde.zza(zzdh.this.zzbak);
                    }
                });
            }
            T zzkq = zzde.zzkq();
            return zzkq;
        }
    }
}
