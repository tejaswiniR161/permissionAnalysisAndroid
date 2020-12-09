package com.google.android.gms.internal;

import android.app.Dialog;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.MainThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.internal.zzqv;

public abstract class zzqd extends zzra implements DialogInterface.OnCancelListener {
    protected boolean mStarted;

    /* renamed from: vP */
    protected final GoogleApiAvailability f1981vP;
    /* access modifiers changed from: private */

    /* renamed from: wA */
    public int f1982wA;

    /* renamed from: wB */
    private final Handler f1983wB;

    /* renamed from: wy */
    protected boolean f1984wy;
    /* access modifiers changed from: private */

    /* renamed from: wz */
    public ConnectionResult f1985wz;

    private class zza implements Runnable {
        private zza() {
        }

        @MainThread
        public void run() {
            if (zzqd.this.mStarted) {
                if (zzqd.this.f1985wz.hasResolution()) {
                    zzqd.this.f2165yY.startActivityForResult(GoogleApiActivity.zzb(zzqd.this.getActivity(), zzqd.this.f1985wz.getResolution(), zzqd.this.f1982wA, false), 1);
                } else if (zzqd.this.f1981vP.isUserResolvableError(zzqd.this.f1985wz.getErrorCode())) {
                    zzqd.this.f1981vP.zza(zzqd.this.getActivity(), zzqd.this.f2165yY, zzqd.this.f1985wz.getErrorCode(), 2, zzqd.this);
                } else if (zzqd.this.f1985wz.getErrorCode() == 18) {
                    final Dialog zza = zzqd.this.f1981vP.zza(zzqd.this.getActivity(), (DialogInterface.OnCancelListener) zzqd.this);
                    zzqd.this.f1981vP.zza(zzqd.this.getActivity().getApplicationContext(), (zzqv.zza) new zzqv.zza() {
                        public void zzaqp() {
                            zzqd.this.zzaqo();
                            if (zza.isShowing()) {
                                zza.dismiss();
                            }
                        }
                    });
                } else {
                    zzqd.this.zza(zzqd.this.f1985wz, zzqd.this.f1982wA);
                }
            }
        }
    }

    protected zzqd(zzrb zzrb) {
        this(zzrb, GoogleApiAvailability.getInstance());
    }

    zzqd(zzrb zzrb, GoogleApiAvailability googleApiAvailability) {
        super(zzrb);
        this.f1982wA = -1;
        this.f1983wB = new Handler(Looper.getMainLooper());
        this.f1981vP = googleApiAvailability;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onActivityResult(int r6, int r7, android.content.Intent r8) {
        /*
            r5 = this;
            r4 = 18
            r2 = 13
            r0 = 1
            r1 = 0
            switch(r6) {
                case 1: goto L_0x0027;
                case 2: goto L_0x0010;
                default: goto L_0x0009;
            }
        L_0x0009:
            r0 = r1
        L_0x000a:
            if (r0 == 0) goto L_0x003d
            r5.zzaqo()
        L_0x000f:
            return
        L_0x0010:
            com.google.android.gms.common.GoogleApiAvailability r2 = r5.f1981vP
            android.app.Activity r3 = r5.getActivity()
            int r2 = r2.isGooglePlayServicesAvailable(r3)
            if (r2 != 0) goto L_0x0047
        L_0x001c:
            com.google.android.gms.common.ConnectionResult r1 = r5.f1985wz
            int r1 = r1.getErrorCode()
            if (r1 != r4) goto L_0x000a
            if (r2 != r4) goto L_0x000a
            goto L_0x000f
        L_0x0027:
            r3 = -1
            if (r7 == r3) goto L_0x000a
            if (r7 != 0) goto L_0x0009
            if (r8 == 0) goto L_0x0045
            java.lang.String r0 = "<<ResolutionFailureErrorDetail>>"
            int r0 = r8.getIntExtra(r0, r2)
        L_0x0034:
            com.google.android.gms.common.ConnectionResult r2 = new com.google.android.gms.common.ConnectionResult
            r3 = 0
            r2.<init>(r0, r3)
            r5.f1985wz = r2
            goto L_0x0009
        L_0x003d:
            com.google.android.gms.common.ConnectionResult r0 = r5.f1985wz
            int r1 = r5.f1982wA
            r5.zza(r0, r1)
            goto L_0x000f
        L_0x0045:
            r0 = r2
            goto L_0x0034
        L_0x0047:
            r0 = r1
            goto L_0x001c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzqd.onActivityResult(int, int, android.content.Intent):void");
    }

    public void onCancel(DialogInterface dialogInterface) {
        zza(new ConnectionResult(13, (PendingIntent) null), this.f1982wA);
        zzaqo();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f1984wy = bundle.getBoolean("resolving_error", false);
            if (this.f1984wy) {
                this.f1982wA = bundle.getInt("failed_client_id", -1);
                this.f1985wz = new ConnectionResult(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution"));
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("resolving_error", this.f1984wy);
        if (this.f1984wy) {
            bundle.putInt("failed_client_id", this.f1982wA);
            bundle.putInt("failed_status", this.f1985wz.getErrorCode());
            bundle.putParcelable("failed_resolution", this.f1985wz.getResolution());
        }
    }

    public void onStart() {
        super.onStart();
        this.mStarted = true;
    }

    public void onStop() {
        super.onStop();
        this.mStarted = false;
    }

    /* access modifiers changed from: protected */
    public abstract void zza(ConnectionResult connectionResult, int i);

    /* access modifiers changed from: protected */
    public abstract void zzaqk();

    /* access modifiers changed from: protected */
    public void zzaqo() {
        this.f1982wA = -1;
        this.f1984wy = false;
        this.f1985wz = null;
        zzaqk();
    }

    public void zzb(ConnectionResult connectionResult, int i) {
        if (!this.f1984wy) {
            this.f1984wy = true;
            this.f1982wA = i;
            this.f1985wz = connectionResult;
            this.f1983wB.post(new zza());
        }
    }
}
