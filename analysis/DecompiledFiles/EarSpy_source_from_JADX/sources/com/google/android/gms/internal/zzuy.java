package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.flags.ModuleDescriptor;
import com.google.android.gms.internal.zzsu;
import com.google.android.gms.internal.zzuz;

public class zzuy {

    /* renamed from: Uv */
    private zzuz f2257Uv = null;
    private boolean zzaom = false;

    public void initialize(Context context) {
        synchronized (this) {
            if (!this.zzaom) {
                try {
                    this.f2257Uv = zzuz.zza.asInterface(zzsu.zza(context, zzsu.f2250Oy, ModuleDescriptor.MODULE_ID).zzjd("com.google.android.gms.flags.impl.FlagProviderImpl"));
                    this.f2257Uv.init(zze.zzac(context));
                    this.zzaom = true;
                } catch (RemoteException | zzsu.zza e) {
                    Log.w("FlagValueProvider", "Failed to initialize flags module.", e);
                }
                return;
            }
            return;
        }
    }

    public <T> T zzb(zzuw<T> zzuw) {
        synchronized (this) {
            if (this.zzaom) {
                return zzuw.zza(this.f2257Uv);
            }
            T zzkq = zzuw.zzkq();
            return zzkq;
        }
    }
}
