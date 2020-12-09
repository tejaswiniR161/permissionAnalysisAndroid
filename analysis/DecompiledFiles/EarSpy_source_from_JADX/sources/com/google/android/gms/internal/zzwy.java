package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.signin.internal.zzg;

public final class zzwy {
    public static final Api<zzxa> API = new Api<>("SignIn.API", f2265fb, f2264fa);

    /* renamed from: Hp */
    public static final Api<zza> f2263Hp = new Api<>("SignIn.INTERNAL_API", azZ, azY);
    public static final Api.zzf<zzg> azY = new Api.zzf<>();
    static final Api.zza<zzg, zza> azZ = new Api.zza<zzg, zza>() {
        public zzg zza(Context context, Looper looper, zzh zzh, zza zza, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzg(context, looper, false, zzh, zza.zzccz(), connectionCallbacks, onConnectionFailedListener);
        }
    };

    /* renamed from: fa */
    public static final Api.zzf<zzg> f2264fa = new Api.zzf<>();

    /* renamed from: fb */
    public static final Api.zza<zzg, zzxa> f2265fb = new Api.zza<zzg, zzxa>() {
        public zzg zza(Context context, Looper looper, zzh zzh, zzxa zzxa, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzg(context, looper, true, zzh, zzxa == null ? zzxa.aAa : zzxa, connectionCallbacks, onConnectionFailedListener);
        }
    };

    /* renamed from: hd */
    public static final Scope f2266hd = new Scope(Scopes.PROFILE);

    /* renamed from: he */
    public static final Scope f2267he = new Scope("email");

    public static class zza implements Api.ApiOptions.HasOptions {
        public Bundle zzccz() {
            return null;
        }
    }
}
