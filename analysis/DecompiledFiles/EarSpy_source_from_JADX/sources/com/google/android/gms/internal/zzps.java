package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.clearcut.LogEventParcelable;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.internal.zzpv;

public class zzps extends zzl<zzpv> {
    public zzps(Context context, Looper looper, zzh zzh, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 40, zzh, connectionCallbacks, onConnectionFailedListener);
    }

    public void zza(zzpu zzpu, LogEventParcelable logEventParcelable) throws RemoteException {
        ((zzpv) zzatx()).zza(zzpu, logEventParcelable);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzdm */
    public zzpv zzh(IBinder iBinder) {
        return zzpv.zza.zzdo(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzix() {
        return "com.google.android.gms.clearcut.service.START";
    }

    /* access modifiers changed from: protected */
    public String zziy() {
        return "com.google.android.gms.clearcut.internal.IClearcutLoggerService";
    }
}
