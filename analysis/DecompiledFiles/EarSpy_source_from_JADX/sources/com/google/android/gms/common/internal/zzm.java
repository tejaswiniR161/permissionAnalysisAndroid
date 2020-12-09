package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzm implements Handler.Callback {

    /* renamed from: Cs */
    private final zza f1738Cs;

    /* renamed from: Ct */
    private final ArrayList<GoogleApiClient.ConnectionCallbacks> f1739Ct = new ArrayList<>();

    /* renamed from: Cu */
    final ArrayList<GoogleApiClient.ConnectionCallbacks> f1740Cu = new ArrayList<>();

    /* renamed from: Cv */
    private final ArrayList<GoogleApiClient.OnConnectionFailedListener> f1741Cv = new ArrayList<>();

    /* renamed from: Cw */
    private volatile boolean f1742Cw = false;

    /* renamed from: Cx */
    private final AtomicInteger f1743Cx = new AtomicInteger(0);

    /* renamed from: Cy */
    private boolean f1744Cy = false;
    private final Handler mHandler;
    private final Object zzakd = new Object();

    public interface zza {
        boolean isConnected();

        Bundle zzaoe();
    }

    public zzm(Looper looper, zza zza2) {
        this.f1738Cs = zza2;
        this.mHandler = new Handler(looper, this);
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) message.obj;
            synchronized (this.zzakd) {
                if (this.f1742Cw && this.f1738Cs.isConnected() && this.f1739Ct.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(this.f1738Cs.zzaoe());
                }
            }
            return true;
        }
        Log.wtf("GmsClientEvents", new StringBuilder(45).append("Don't know how to handle message: ").append(message.what).toString(), new Exception());
        return false;
    }

    public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        boolean contains;
        zzac.zzy(connectionCallbacks);
        synchronized (this.zzakd) {
            contains = this.f1739Ct.contains(connectionCallbacks);
        }
        return contains;
    }

    public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        boolean contains;
        zzac.zzy(onConnectionFailedListener);
        synchronized (this.zzakd) {
            contains = this.f1741Cv.contains(onConnectionFailedListener);
        }
        return contains;
    }

    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        zzac.zzy(connectionCallbacks);
        synchronized (this.zzakd) {
            if (this.f1739Ct.contains(connectionCallbacks)) {
                String valueOf = String.valueOf(connectionCallbacks);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 62).append("registerConnectionCallbacks(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.f1739Ct.add(connectionCallbacks);
            }
        }
        if (this.f1738Cs.isConnected()) {
            this.mHandler.sendMessage(this.mHandler.obtainMessage(1, connectionCallbacks));
        }
    }

    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzac.zzy(onConnectionFailedListener);
        synchronized (this.zzakd) {
            if (this.f1741Cv.contains(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 67).append("registerConnectionFailedListener(): listener ").append(valueOf).append(" is already registered").toString());
            } else {
                this.f1741Cv.add(onConnectionFailedListener);
            }
        }
    }

    public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        zzac.zzy(connectionCallbacks);
        synchronized (this.zzakd) {
            if (!this.f1739Ct.remove(connectionCallbacks)) {
                String valueOf = String.valueOf(connectionCallbacks);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 52).append("unregisterConnectionCallbacks(): listener ").append(valueOf).append(" not found").toString());
            } else if (this.f1744Cy) {
                this.f1740Cu.add(connectionCallbacks);
            }
        }
    }

    public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        zzac.zzy(onConnectionFailedListener);
        synchronized (this.zzakd) {
            if (!this.f1741Cv.remove(onConnectionFailedListener)) {
                String valueOf = String.valueOf(onConnectionFailedListener);
                Log.w("GmsClientEvents", new StringBuilder(String.valueOf(valueOf).length() + 57).append("unregisterConnectionFailedListener(): listener ").append(valueOf).append(" not found").toString());
            }
        }
    }

    public void zzaut() {
        this.f1742Cw = false;
        this.f1743Cx.incrementAndGet();
    }

    public void zzauu() {
        this.f1742Cw = true;
    }

    public void zzgo(int i) {
        boolean z = false;
        if (Looper.myLooper() == this.mHandler.getLooper()) {
            z = true;
        }
        zzac.zza(z, (Object) "onUnintentionalDisconnection must only be called on the Handler thread");
        this.mHandler.removeMessages(1);
        synchronized (this.zzakd) {
            this.f1744Cy = true;
            ArrayList arrayList = new ArrayList(this.f1739Ct);
            int i2 = this.f1743Cx.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                if (!this.f1742Cw || this.f1743Cx.get() != i2) {
                    break;
                } else if (this.f1739Ct.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnectionSuspended(i);
                }
            }
            this.f1740Cu.clear();
            this.f1744Cy = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzn(com.google.android.gms.common.ConnectionResult r6) {
        /*
            r5 = this;
            r1 = 1
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Handler r2 = r5.mHandler
            android.os.Looper r2 = r2.getLooper()
            if (r0 != r2) goto L_0x0046
            r0 = r1
        L_0x000e:
            java.lang.String r2 = "onConnectionFailure must only be called on the Handler thread"
            com.google.android.gms.common.internal.zzac.zza((boolean) r0, (java.lang.Object) r2)
            android.os.Handler r0 = r5.mHandler
            r0.removeMessages(r1)
            java.lang.Object r1 = r5.zzakd
            monitor-enter(r1)
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ all -> 0x0054 }
            java.util.ArrayList<com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener> r2 = r5.f1741Cv     // Catch:{ all -> 0x0054 }
            r0.<init>(r2)     // Catch:{ all -> 0x0054 }
            java.util.concurrent.atomic.AtomicInteger r2 = r5.f1743Cx     // Catch:{ all -> 0x0054 }
            int r2 = r2.get()     // Catch:{ all -> 0x0054 }
            java.util.Iterator r3 = r0.iterator()     // Catch:{ all -> 0x0054 }
        L_0x002c:
            boolean r0 = r3.hasNext()     // Catch:{ all -> 0x0054 }
            if (r0 == 0) goto L_0x0057
            java.lang.Object r0 = r3.next()     // Catch:{ all -> 0x0054 }
            com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener r0 = (com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener) r0     // Catch:{ all -> 0x0054 }
            boolean r4 = r5.f1742Cw     // Catch:{ all -> 0x0054 }
            if (r4 == 0) goto L_0x0044
            java.util.concurrent.atomic.AtomicInteger r4 = r5.f1743Cx     // Catch:{ all -> 0x0054 }
            int r4 = r4.get()     // Catch:{ all -> 0x0054 }
            if (r4 == r2) goto L_0x0048
        L_0x0044:
            monitor-exit(r1)     // Catch:{ all -> 0x0054 }
        L_0x0045:
            return
        L_0x0046:
            r0 = 0
            goto L_0x000e
        L_0x0048:
            java.util.ArrayList<com.google.android.gms.common.api.GoogleApiClient$OnConnectionFailedListener> r4 = r5.f1741Cv     // Catch:{ all -> 0x0054 }
            boolean r4 = r4.contains(r0)     // Catch:{ all -> 0x0054 }
            if (r4 == 0) goto L_0x002c
            r0.onConnectionFailed(r6)     // Catch:{ all -> 0x0054 }
            goto L_0x002c
        L_0x0054:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0054 }
            throw r0
        L_0x0057:
            monitor-exit(r1)     // Catch:{ all -> 0x0054 }
            goto L_0x0045
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzm.zzn(com.google.android.gms.common.ConnectionResult):void");
    }

    public void zzp(Bundle bundle) {
        boolean z = true;
        zzac.zza(Looper.myLooper() == this.mHandler.getLooper(), (Object) "onConnectionSuccess must only be called on the Handler thread");
        synchronized (this.zzakd) {
            zzac.zzbr(!this.f1744Cy);
            this.mHandler.removeMessages(1);
            this.f1744Cy = true;
            if (this.f1740Cu.size() != 0) {
                z = false;
            }
            zzac.zzbr(z);
            ArrayList arrayList = new ArrayList(this.f1739Ct);
            int i = this.f1743Cx.get();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                GoogleApiClient.ConnectionCallbacks connectionCallbacks = (GoogleApiClient.ConnectionCallbacks) it.next();
                if (!this.f1742Cw || !this.f1738Cs.isConnected() || this.f1743Cx.get() != i) {
                    break;
                } else if (!this.f1740Cu.contains(connectionCallbacks)) {
                    connectionCallbacks.onConnected(bundle);
                }
            }
            this.f1740Cu.clear();
            this.f1744Cy = false;
        }
    }
}
