package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import com.google.android.gms.ads.internal.request.zzc;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.internal.zzdb;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzja;
import com.google.android.gms.internal.zzjb;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzkt;
import com.google.android.gms.internal.zzlm;

@zziy
public abstract class zzd implements zzc.zza, zzkt<Void> {
    private final Object zzakd = new Object();
    private final zzlm<AdRequestInfoParcel> zzcfm;
    private final zzc.zza zzcfn;

    @zziy
    public static final class zza extends zzd {
        private final Context mContext;

        public zza(Context context, zzlm<AdRequestInfoParcel> zzlm, zzc.zza zza) {
            super(zzlm, zza);
            this.mContext = context;
        }

        public /* synthetic */ Object zzqw() {
            return zzd.super.zzqw();
        }

        public void zzrv() {
        }

        public zzk zzrw() {
            return zzjb.zza(this.mContext, new zzdb(zzdi.zzbao.get()), zzja.zzsc());
        }
    }

    @zziy
    public static class zzb extends zzd implements zze.zzb, zze.zzc {
        private Context mContext;
        private final Object zzakd = new Object();
        private VersionInfoParcel zzanh;
        private zzlm<AdRequestInfoParcel> zzcfm;
        private final zzc.zza zzcfn;
        protected zze zzcfq;
        private boolean zzcfr;

        public zzb(Context context, VersionInfoParcel versionInfoParcel, zzlm<AdRequestInfoParcel> zzlm, zzc.zza zza) {
            super(zzlm, zza);
            Looper mainLooper;
            this.mContext = context;
            this.zzanh = versionInfoParcel;
            this.zzcfm = zzlm;
            this.zzcfn = zza;
            if (zzdi.zzbbu.get().booleanValue()) {
                this.zzcfr = true;
                mainLooper = zzu.zzgp().zzuy();
            } else {
                mainLooper = context.getMainLooper();
            }
            this.zzcfq = new zze(context, mainLooper, this, this, this.zzanh.zzctt);
            connect();
        }

        /* access modifiers changed from: protected */
        public void connect() {
            this.zzcfq.zzatu();
        }

        public void onConnected(Bundle bundle) {
            Void voidR = (Void) zzqw();
        }

        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzkn.zzdd("Cannot connect to remote service, fallback to local instance.");
            zzrx().zzqw();
            Bundle bundle = new Bundle();
            bundle.putString("action", "gms_connection_failed_fallback_to_local");
            zzu.zzfz().zzb(this.mContext, this.zzanh.zzcs, "gmob-apps", bundle, true);
        }

        public void onConnectionSuspended(int i) {
            zzkn.zzdd("Disconnected from remote ad request service.");
        }

        public /* synthetic */ Object zzqw() {
            return zzd.super.zzqw();
        }

        public void zzrv() {
            synchronized (this.zzakd) {
                if (this.zzcfq.isConnected() || this.zzcfq.isConnecting()) {
                    this.zzcfq.disconnect();
                }
                Binder.flushPendingCommands();
                if (this.zzcfr) {
                    zzu.zzgp().zzuz();
                    this.zzcfr = false;
                }
            }
        }

        public zzk zzrw() {
            zzk zzk;
            synchronized (this.zzakd) {
                try {
                    zzk = this.zzcfq.zzry();
                } catch (DeadObjectException | IllegalStateException e) {
                    zzk = null;
                }
            }
            return zzk;
        }

        /* access modifiers changed from: package-private */
        public zzkt zzrx() {
            return new zza(this.mContext, this.zzcfm, this.zzcfn);
        }
    }

    public zzd(zzlm<AdRequestInfoParcel> zzlm, zzc.zza zza2) {
        this.zzcfm = zzlm;
        this.zzcfn = zza2;
    }

    public void cancel() {
        zzrv();
    }

    /* access modifiers changed from: package-private */
    public boolean zza(zzk zzk, AdRequestInfoParcel adRequestInfoParcel) {
        try {
            zzk.zza(adRequestInfoParcel, new zzg(this));
            return true;
        } catch (RemoteException e) {
            zzkn.zzd("Could not fetch ad response from ad request service.", e);
            zzu.zzgd().zza((Throwable) e, "AdRequestClientTask.getAdResponseFromService");
            this.zzcfn.zzb(new AdResponseParcel(0));
            return false;
        } catch (NullPointerException e2) {
            zzkn.zzd("Could not fetch ad response from ad request service due to an Exception.", e2);
            zzu.zzgd().zza((Throwable) e2, "AdRequestClientTask.getAdResponseFromService");
            this.zzcfn.zzb(new AdResponseParcel(0));
            return false;
        } catch (SecurityException e3) {
            zzkn.zzd("Could not fetch ad response from ad request service due to an Exception.", e3);
            zzu.zzgd().zza((Throwable) e3, "AdRequestClientTask.getAdResponseFromService");
            this.zzcfn.zzb(new AdResponseParcel(0));
            return false;
        } catch (Throwable th) {
            zzkn.zzd("Could not fetch ad response from ad request service due to an Exception.", th);
            zzu.zzgd().zza(th, "AdRequestClientTask.getAdResponseFromService");
            this.zzcfn.zzb(new AdResponseParcel(0));
            return false;
        }
    }

    public void zzb(AdResponseParcel adResponseParcel) {
        synchronized (this.zzakd) {
            this.zzcfn.zzb(adResponseParcel);
            zzrv();
        }
    }

    /* renamed from: zzqt */
    public Void zzqw() {
        final zzk zzrw = zzrw();
        if (zzrw == null) {
            this.zzcfn.zzb(new AdResponseParcel(0));
            zzrv();
        } else {
            this.zzcfm.zza(new zzlm.zzc<AdRequestInfoParcel>() {
                /* renamed from: zzc */
                public void zzd(AdRequestInfoParcel adRequestInfoParcel) {
                    if (!zzd.this.zza(zzrw, adRequestInfoParcel)) {
                        zzd.this.zzrv();
                    }
                }
            }, new zzlm.zza() {
                public void run() {
                    zzd.this.zzrv();
                }
            });
        }
        return null;
    }

    public abstract void zzrv();

    public abstract zzk zzrw();
}
