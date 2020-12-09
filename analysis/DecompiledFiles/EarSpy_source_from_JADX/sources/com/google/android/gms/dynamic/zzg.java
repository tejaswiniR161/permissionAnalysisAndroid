package com.google.android.gms.dynamic;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.zze;

public abstract class zzg<T> {

    /* renamed from: Ot */
    private final String f1912Ot;

    /* renamed from: Ou */
    private T f1913Ou;

    public static class zza extends Exception {
        public zza(String str) {
            super(str);
        }

        public zza(String str, Throwable th) {
            super(str, th);
        }
    }

    protected zzg(String str) {
        this.f1912Ot = str;
    }

    /* access modifiers changed from: protected */
    public abstract T zzc(IBinder iBinder);

    /* access modifiers changed from: protected */
    public final T zzcu(Context context) throws zza {
        if (this.f1913Ou == null) {
            zzac.zzy(context);
            Context remoteContext = zze.getRemoteContext(context);
            if (remoteContext == null) {
                throw new zza("Could not get remote context.");
            }
            try {
                this.f1913Ou = zzc((IBinder) remoteContext.getClassLoader().loadClass(this.f1912Ot).newInstance());
            } catch (ClassNotFoundException e) {
                throw new zza("Could not load creator class.", e);
            } catch (InstantiationException e2) {
                throw new zza("Could not instantiate creator.", e2);
            } catch (IllegalAccessException e3) {
                throw new zza("Could not access creator.", e3);
            }
        }
        return this.f1913Ou;
    }
}
