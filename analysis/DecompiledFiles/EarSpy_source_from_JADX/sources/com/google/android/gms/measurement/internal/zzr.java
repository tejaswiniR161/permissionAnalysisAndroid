package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.MainThread;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.internal.zzac;

class zzr extends BroadcastReceiver {

    /* renamed from: dq */
    static final String f2293dq = zzr.class.getName();
    /* access modifiers changed from: private */
    public final zzx anq;

    /* renamed from: dr */
    private boolean f2294dr;

    /* renamed from: ds */
    private boolean f2295ds;

    zzr(zzx zzx) {
        zzac.zzy(zzx);
        this.anq = zzx;
    }

    private Context getContext() {
        return this.anq.getContext();
    }

    private zzp zzbvg() {
        return this.anq.zzbvg();
    }

    @WorkerThread
    public boolean isRegistered() {
        this.anq.zzyl();
        return this.f2294dr;
    }

    @MainThread
    public void onReceive(Context context, Intent intent) {
        this.anq.zzaax();
        String action = intent.getAction();
        zzbvg().zzbwj().zzj("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            final boolean zzafa = this.anq.zzbxa().zzafa();
            if (this.f2295ds != zzafa) {
                this.f2295ds = zzafa;
                this.anq.zzbvf().zzm(new Runnable() {
                    public void run() {
                        zzr.this.anq.zzav(zzafa);
                    }
                });
                return;
            }
            return;
        }
        zzbvg().zzbwe().zzj("NetworkBroadcastReceiver received unknown action", action);
    }

    @WorkerThread
    public void unregister() {
        this.anq.zzaax();
        this.anq.zzyl();
        if (isRegistered()) {
            zzbvg().zzbwj().log("Unregistering connectivity change receiver");
            this.f2294dr = false;
            this.f2295ds = false;
            try {
                getContext().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                zzbvg().zzbwc().zzj("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    @WorkerThread
    public void zzaex() {
        this.anq.zzaax();
        this.anq.zzyl();
        if (!this.f2294dr) {
            getContext().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f2295ds = this.anq.zzbxa().zzafa();
            zzbvg().zzbwj().zzj("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f2295ds));
            this.f2294dr = true;
        }
    }
}
