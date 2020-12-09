package com.google.android.gms.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.google.android.gms.common.internal.zzac;

@zziy
public class zzkz {
    private Handler mHandler = null;
    /* access modifiers changed from: private */
    public final Object zzakd = new Object();
    private HandlerThread zzcsu = null;
    /* access modifiers changed from: private */
    public int zzcsv = 0;

    public Looper zzuy() {
        Looper looper;
        synchronized (this.zzakd) {
            if (this.zzcsv != 0) {
                zzac.zzb(this.zzcsu, (Object) "Invalid state: mHandlerThread should already been initialized.");
            } else if (this.zzcsu == null) {
                zzkn.m1493v("Starting the looper thread.");
                this.zzcsu = new HandlerThread("LooperProvider");
                this.zzcsu.start();
                this.mHandler = new Handler(this.zzcsu.getLooper());
                zzkn.m1493v("Looper thread started.");
            } else {
                zzkn.m1493v("Resuming the looper thread");
                this.zzakd.notifyAll();
            }
            this.zzcsv++;
            looper = this.zzcsu.getLooper();
        }
        return looper;
    }

    public void zzuz() {
        synchronized (this.zzakd) {
            zzac.zzb(this.zzcsv > 0, (Object) "Invalid state: release() called more times than expected.");
            int i = this.zzcsv - 1;
            this.zzcsv = i;
            if (i == 0) {
                this.mHandler.post(new Runnable() {
                    public void run() {
                        synchronized (zzkz.this.zzakd) {
                            zzkn.m1493v("Suspending the looper thread");
                            while (zzkz.this.zzcsv == 0) {
                                try {
                                    zzkz.this.zzakd.wait();
                                    zzkn.m1493v("Looper thread resumed");
                                } catch (InterruptedException e) {
                                    zzkn.m1493v("Looper thread interrupted.");
                                }
                            }
                        }
                    }
                });
            }
        }
    }
}
