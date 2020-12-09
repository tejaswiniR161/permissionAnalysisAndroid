package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

public class zzai<T extends IInterface> extends zzl<T> {

    /* renamed from: Db */
    private final Api.zzg<T> f1660Db;

    public zzai(Context context, Looper looper, int i, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, zzh zzh, Api.zzg<T> zzg) {
        super(context, looper, i, zzh, connectionCallbacks, onConnectionFailedListener);
        this.f1660Db = zzg;
    }

    public Api.zzg<T> zzavk() {
        return this.f1660Db;
    }

    /* access modifiers changed from: protected */
    public void zzc(int i, T t) {
        this.f1660Db.zza(i, t);
    }

    /* access modifiers changed from: protected */
    public T zzh(IBinder iBinder) {
        return this.f1660Db.zzh(iBinder);
    }

    /* access modifiers changed from: protected */
    public String zzix() {
        return this.f1660Db.zzix();
    }

    /* access modifiers changed from: protected */
    public String zziy() {
        return this.f1660Db.zziy();
    }
}
