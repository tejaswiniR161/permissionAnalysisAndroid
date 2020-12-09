package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzac;

public class zzqf implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    /* renamed from: tv */
    public final Api<?> f2004tv;

    /* renamed from: wT */
    private final int f2005wT;

    /* renamed from: wU */
    private zzqg f2006wU;

    public zzqf(Api<?> api, int i) {
        this.f2004tv = api;
        this.f2005wT = i;
    }

    private void zzaqx() {
        zzac.zzb(this.f2006wU, (Object) "Callbacks must be attached to a ClientConnectionHelper instance before connecting the client.");
    }

    public void onConnected(@Nullable Bundle bundle) {
        zzaqx();
        this.f2006wU.onConnected(bundle);
    }

    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzaqx();
        this.f2006wU.zza(connectionResult, this.f2004tv, this.f2005wT);
    }

    public void onConnectionSuspended(int i) {
        zzaqx();
        this.f2006wU.onConnectionSuspended(i);
    }

    public void zza(zzqg zzqg) {
        this.f2006wU = zzqg;
    }
}
