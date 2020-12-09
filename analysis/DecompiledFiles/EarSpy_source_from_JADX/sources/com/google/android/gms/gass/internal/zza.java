package com.google.android.gms.gass.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.HandlerThread;
import com.facebook.ads.AdError;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.internal.zzae;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class zza {

    /* renamed from: com.google.android.gms.gass.internal.zza$zza  reason: collision with other inner class name */
    static class C1286zza implements zze.zzb, zze.zzc {
        protected zzb aev;
        private final String aew;
        private final LinkedBlockingQueue<zzae.zza> aex;
        private final HandlerThread aey = new HandlerThread("GassClient");
        private final String packageName;

        public C1286zza(Context context, String str, String str2) {
            this.packageName = str;
            this.aew = str2;
            this.aey.start();
            this.aev = new zzb(context, this.aey.getLooper(), this, this);
            this.aex = new LinkedBlockingQueue<>();
            connect();
        }

        /* access modifiers changed from: protected */
        public void connect() {
            this.aev.zzatu();
        }

        public void onConnected(Bundle bundle) {
            zze zzbnt = zzbnt();
            if (zzbnt != null) {
                try {
                    this.aex.put(zzbnt.zza(new GassRequestParcel(this.packageName, this.aew)).zzbnw());
                } catch (Throwable th) {
                } finally {
                    zzrv();
                    this.aey.quit();
                }
            }
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            try {
                this.aex.put(new zzae.zza());
            } catch (InterruptedException e) {
            }
        }

        public void onConnectionSuspended(int i) {
            try {
                this.aex.put(new zzae.zza());
            } catch (InterruptedException e) {
            }
        }

        /* access modifiers changed from: protected */
        public zze zzbnt() {
            try {
                return this.aev.zzbnu();
            } catch (DeadObjectException | IllegalStateException e) {
                return null;
            }
        }

        public zzae.zza zzcp() {
            return zzth(AdError.SERVER_ERROR_CODE);
        }

        public void zzrv() {
            if (this.aev == null) {
                return;
            }
            if (this.aev.isConnected() || this.aev.isConnecting()) {
                this.aev.disconnect();
            }
        }

        public zzae.zza zzth(int i) {
            zzae.zza zza;
            try {
                zza = this.aex.poll((long) i, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                zza = null;
            }
            return zza == null ? new zzae.zza() : zza;
        }
    }

    public static zzae.zza zzi(Context context, String str, String str2) {
        return new C1286zza(context, str, str2).zzcp();
    }
}
