package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.internal.zzk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.internal.zzwz;
import com.google.android.gms.internal.zzxa;
import com.google.android.gms.signin.internal.zze;

public class zzg extends zzl<zze> implements zzwz {

    /* renamed from: Ca */
    private Integer f2305Ca;
    private final boolean aAk;
    private final Bundle aAl;

    /* renamed from: xB */
    private final zzh f2306xB;

    public zzg(Context context, Looper looper, boolean z, zzh zzh, Bundle bundle, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 44, zzh, connectionCallbacks, onConnectionFailedListener);
        this.aAk = z;
        this.f2306xB = zzh;
        this.aAl = bundle;
        this.f2305Ca = zzh.zzaun();
    }

    public zzg(Context context, Looper looper, boolean z, zzh zzh, zzxa zzxa, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, z, zzh, zza(zzh), connectionCallbacks, onConnectionFailedListener);
    }

    public static Bundle zza(zzh zzh) {
        zzxa zzaum = zzh.zzaum();
        Integer zzaun = zzh.zzaun();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", zzh.getAccount());
        if (zzaun != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", zzaun.intValue());
        }
        if (zzaum != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", zzaum.zzcdb());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", zzaum.zzahk());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", zzaum.zzahn());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", zzaum.zzahm());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", zzaum.zzaho());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", zzaum.zzcdc());
            if (zzaum.zzcdd() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", zzaum.zzcdd().longValue());
            }
            if (zzaum.zzcde() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", zzaum.zzcde().longValue());
            }
        }
        return bundle;
    }

    private ResolveAccountRequest zzcdj() {
        Account zzatv = this.f2306xB.zzatv();
        GoogleSignInAccount googleSignInAccount = null;
        if ("<<default account>>".equals(zzatv.name)) {
            googleSignInAccount = zzk.zzbd(getContext()).zzaic();
        }
        return new ResolveAccountRequest(zzatv, this.f2305Ca.intValue(), googleSignInAccount);
    }

    public void connect() {
        zza((zze.zzf) new zze.zzi());
    }

    public void zza(zzr zzr, boolean z) {
        try {
            ((zze) zzatx()).zza(zzr, this.f2305Ca.intValue(), z);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    public void zza(zzd zzd) {
        zzac.zzb(zzd, (Object) "Expecting a valid ISignInCallbacks");
        try {
            ((zze) zzatx()).zza(new SignInRequest(zzcdj()), zzd);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                zzd.zzb(new SignInResponse(8));
            } catch (RemoteException e2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public Bundle zzagl() {
        if (!getContext().getPackageName().equals(this.f2306xB.zzauj())) {
            this.aAl.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f2306xB.zzauj());
        }
        return this.aAl;
    }

    public boolean zzahd() {
        return this.aAk;
    }

    public void zzcda() {
        try {
            ((zze) zzatx()).zzaaf(this.f2305Ca.intValue());
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    /* access modifiers changed from: protected */
    public String zzix() {
        return "com.google.android.gms.signin.service.START";
    }

    /* access modifiers changed from: protected */
    public String zziy() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzlc */
    public zze zzh(IBinder iBinder) {
        return zze.zza.zzlb(iBinder);
    }
}
