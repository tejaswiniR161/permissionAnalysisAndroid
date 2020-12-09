package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.util.client.zza;
import java.util.ArrayList;
import java.util.List;

@zziy
class zzlk {
    private final Object zzcug = new Object();
    private final List<Runnable> zzcuh = new ArrayList();
    private final List<Runnable> zzcui = new ArrayList();
    private boolean zzcuj = false;

    private void zze(Runnable runnable) {
        zzkq.zza(runnable);
    }

    private void zzf(Runnable runnable) {
        zza.zzctj.post(runnable);
    }

    public void zzc(Runnable runnable) {
        synchronized (this.zzcug) {
            if (this.zzcuj) {
                zze(runnable);
            } else {
                this.zzcuh.add(runnable);
            }
        }
    }

    public void zzd(Runnable runnable) {
        synchronized (this.zzcug) {
            if (this.zzcuj) {
                zzf(runnable);
            } else {
                this.zzcui.add(runnable);
            }
        }
    }

    public void zzvi() {
        synchronized (this.zzcug) {
            if (!this.zzcuj) {
                for (Runnable zze : this.zzcuh) {
                    zze(zze);
                }
                for (Runnable zzf : this.zzcui) {
                    zzf(zzf);
                }
                this.zzcuh.clear();
                this.zzcui.clear();
                this.zzcuj = true;
            }
        }
    }
}
