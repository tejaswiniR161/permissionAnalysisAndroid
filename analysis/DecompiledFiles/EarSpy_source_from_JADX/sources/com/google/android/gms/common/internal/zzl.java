package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzm;
import java.util.Set;

public abstract class zzl<T extends IInterface> extends zze<T> implements Api.zze, zzm.zza {

    /* renamed from: ec */
    private final Account f1733ec;

    /* renamed from: hm */
    private final Set<Scope> f1734hm;

    /* renamed from: xB */
    private final zzh f1735xB;

    protected zzl(Context context, Looper looper, int i, zzh zzh, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, zzn.zzcf(context), GoogleApiAvailability.getInstance(), i, zzh, (GoogleApiClient.ConnectionCallbacks) zzac.zzy(connectionCallbacks), (GoogleApiClient.OnConnectionFailedListener) zzac.zzy(onConnectionFailedListener));
    }

    protected zzl(Context context, Looper looper, zzn zzn, GoogleApiAvailability googleApiAvailability, int i, zzh zzh, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, zzn, googleApiAvailability, i, zza(connectionCallbacks), zza(onConnectionFailedListener), zzh.zzauk());
        this.f1735xB = zzh;
        this.f1733ec = zzh.getAccount();
        this.f1734hm = zzb(zzh.zzauh());
    }

    @Nullable
    private static zze.zzb zza(final GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        if (connectionCallbacks == null) {
            return null;
        }
        return new zze.zzb() {
            public void onConnected(@Nullable Bundle bundle) {
                GoogleApiClient.ConnectionCallbacks.this.onConnected(bundle);
            }

            public void onConnectionSuspended(int i) {
                GoogleApiClient.ConnectionCallbacks.this.onConnectionSuspended(i);
            }
        };
    }

    @Nullable
    private static zze.zzc zza(final GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        if (onConnectionFailedListener == null) {
            return null;
        }
        return new zze.zzc() {
            public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                GoogleApiClient.OnConnectionFailedListener.this.onConnectionFailed(connectionResult);
            }
        };
    }

    private Set<Scope> zzb(@NonNull Set<Scope> set) {
        Set<Scope> zzc = zzc(set);
        for (Scope contains : zzc) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return zzc;
    }

    public final Account getAccount() {
        return this.f1733ec;
    }

    /* access modifiers changed from: protected */
    public final Set<Scope> zzatz() {
        return this.f1734hm;
    }

    /* access modifiers changed from: protected */
    public final zzh zzaus() {
        return this.f1735xB;
    }

    /* access modifiers changed from: protected */
    @NonNull
    public Set<Scope> zzc(@NonNull Set<Scope> set) {
        return set;
    }
}
