package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.internal.zzsd;

public class zzsb extends zzl<zzsd> {
    public zzsb(Context context, Looper looper, zzh zzh, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 39, zzh, connectionCallbacks, onConnectionFailedListener);
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzea */
    public zzsd zzh(IBinder iBinder) {
        return zzsd.zza.zzec(iBinder);
    }

    public String zzix() {
        return "com.google.android.gms.common.service.START";
    }

    /* access modifiers changed from: protected */
    public String zziy() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }
}
