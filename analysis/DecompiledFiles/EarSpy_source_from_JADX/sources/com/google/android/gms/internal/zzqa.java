package com.google.android.gms.internal;

import android.support.annotation.NonNull;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzac;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class zzqa extends zzqd {

    /* renamed from: wq */
    private final SparseArray<zza> f1972wq = new SparseArray<>();

    private class zza implements GoogleApiClient.OnConnectionFailedListener {

        /* renamed from: wr */
        public final int f1973wr;

        /* renamed from: ws */
        public final GoogleApiClient f1974ws;

        /* renamed from: wt */
        public final GoogleApiClient.OnConnectionFailedListener f1975wt;

        public zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.f1973wr = i;
            this.f1974ws = googleApiClient;
            this.f1975wt = onConnectionFailedListener;
            googleApiClient.registerConnectionFailedListener(this);
        }

        public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.append(str).append("GoogleApiClient #").print(this.f1973wr);
            printWriter.println(":");
            this.f1974ws.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        }

        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            String valueOf = String.valueOf(connectionResult);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 27).append("beginFailureResolution for ").append(valueOf).toString());
            zzqa.this.zzb(connectionResult, this.f1973wr);
        }

        public void zzaql() {
            this.f1974ws.unregisterConnectionFailedListener(this);
            this.f1974ws.disconnect();
        }
    }

    private zzqa(zzrb zzrb) {
        super(zzrb);
        this.f2165yY.zza("AutoManageHelper", (zzra) this);
    }

    public static zzqa zza(zzqz zzqz) {
        zzrb zzc = zzc(zzqz);
        zzqa zzqa = (zzqa) zzc.zza("AutoManageHelper", zzqa.class);
        return zzqa != null ? zzqa : new zzqa(zzc);
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f1972wq.size()) {
                this.f1972wq.valueAt(i2).dump(str, fileDescriptor, printWriter, strArr);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void onStart() {
        super.onStart();
        boolean z = this.mStarted;
        String valueOf = String.valueOf(this.f1972wq);
        Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 14).append("onStart ").append(z).append(" ").append(valueOf).toString());
        if (!this.f1984wy) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f1972wq.size()) {
                    this.f1972wq.valueAt(i2).f1974ws.connect();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void onStop() {
        super.onStop();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f1972wq.size()) {
                this.f1972wq.valueAt(i2).f1974ws.disconnect();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void zza(int i, GoogleApiClient googleApiClient, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzac.zzb(googleApiClient, (Object) "GoogleApiClient instance cannot be null");
        zzac.zza(this.f1972wq.indexOfKey(i) < 0, (Object) new StringBuilder(54).append("Already managing a GoogleApiClient with id ").append(i).toString());
        Log.d("AutoManageHelper", new StringBuilder(54).append("starting AutoManage for client ").append(i).append(" ").append(this.mStarted).append(" ").append(this.f1984wy).toString());
        this.f1972wq.put(i, new zza(i, googleApiClient, onConnectionFailedListener));
        if (this.mStarted && !this.f1984wy) {
            String valueOf = String.valueOf(googleApiClient);
            Log.d("AutoManageHelper", new StringBuilder(String.valueOf(valueOf).length() + 11).append("connecting ").append(valueOf).toString());
            googleApiClient.connect();
        }
    }

    /* access modifiers changed from: protected */
    public void zza(ConnectionResult connectionResult, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        zza zza2 = this.f1972wq.get(i);
        if (zza2 != null) {
            zzfq(i);
            GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener = zza2.f1975wt;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(connectionResult);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zzaqk() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.f1972wq.size()) {
                this.f1972wq.valueAt(i2).f1974ws.connect();
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public void zzfq(int i) {
        zza zza2 = this.f1972wq.get(i);
        this.f1972wq.remove(i);
        if (zza2 != null) {
            zza2.zzaql();
        }
    }
}
