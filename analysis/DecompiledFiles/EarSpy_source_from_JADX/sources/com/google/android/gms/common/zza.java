package com.google.android.gms.common;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.zzac;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zza implements ServiceConnection {

    /* renamed from: uH */
    boolean f1873uH = false;

    /* renamed from: uI */
    private final BlockingQueue<IBinder> f1874uI = new LinkedBlockingQueue();

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f1874uI.add(iBinder);
    }

    public void onServiceDisconnected(ComponentName componentName) {
    }

    public IBinder zza(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        zzac.zzhr("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f1873uH) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f1873uH = true;
        IBinder poll = this.f1874uI.poll(j, timeUnit);
        if (poll != null) {
            return poll;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    public IBinder zzapc() throws InterruptedException {
        zzac.zzhr("BlockingServiceConnection.getService() called on main thread");
        if (this.f1873uH) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f1873uH = true;
        return this.f1874uI.take();
    }
}
