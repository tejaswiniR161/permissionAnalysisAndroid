package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzy;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.dynamic.zzg;

public final class zzag extends zzg<zzy> {

    /* renamed from: Da */
    private static final zzag f1659Da = new zzag();

    private zzag() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View zzb(Context context, int i, int i2) throws zzg.zza {
        return f1659Da.zzc(context, i, i2);
    }

    private View zzc(Context context, int i, int i2) throws zzg.zza {
        try {
            SignInButtonConfig signInButtonConfig = new SignInButtonConfig(i, i2, (Scope[]) null);
            return (View) zze.zzae(((zzy) zzcu(context)).zza(zze.zzac(context), signInButtonConfig));
        } catch (Exception e) {
            throw new zzg.zza(new StringBuilder(64).append("Could not get button with size ").append(i).append(" and color ").append(i2).toString(), e);
        }
    }

    /* renamed from: zzdz */
    public zzy zzc(IBinder iBinder) {
        return zzy.zza.zzdy(iBinder);
    }
}
