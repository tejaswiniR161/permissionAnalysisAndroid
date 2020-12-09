package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzjt;
import com.google.android.gms.internal.zzke;

@zziy
public class zzjs extends zzkm implements zzju, zzjx {
    /* access modifiers changed from: private */
    public final Context mContext;
    private final Object zzakd;
    /* access modifiers changed from: private */
    public final String zzbst;
    private final zzke.zza zzcck;
    private int zzcdb = 3;
    private final zzjz zzcna;
    private final zzjx zzcnb;
    /* access modifiers changed from: private */
    public final String zzcnc;
    private final zzgg zzcnd;
    private final long zzcne;
    private int zzcnf = 0;
    private zzjt zzcng;

    public zzjs(Context context, String str, String str2, zzgg zzgg, zzke.zza zza, zzjz zzjz, zzjx zzjx, long j) {
        this.mContext = context;
        this.zzbst = str;
        this.zzcnc = str2;
        this.zzcnd = zzgg;
        this.zzcck = zza;
        this.zzcna = zzjz;
        this.zzakd = new Object();
        this.zzcnb = zzjx;
        this.zzcne = j;
    }

    /* access modifiers changed from: private */
    public void zza(AdRequestParcel adRequestParcel, zzgr zzgr) {
        this.zzcna.zzsw().zza((zzjx) this);
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzbst)) {
                zzgr.zza(adRequestParcel, this.zzcnc, this.zzcnd.zzbrl);
            } else {
                zzgr.zzc(adRequestParcel, this.zzcnc);
            }
        } catch (RemoteException e) {
            zzkn.zzd("Fail to load ad from adapter.", e);
            zza(this.zzbst, 0);
        }
    }

    private void zzk(long j) {
        while (true) {
            synchronized (this.zzakd) {
                if (this.zzcnf != 0) {
                    this.zzcng = new zzjt.zza().zzl(zzu.zzgf().elapsedRealtime() - j).zzaz(1 == this.zzcnf ? 6 : this.zzcdb).zzcn(this.zzbst).zzco(this.zzcnd.zzbro).zzss();
                    return;
                } else if (!zzf(j)) {
                    this.zzcng = new zzjt.zza().zzaz(this.zzcdb).zzl(zzu.zzgf().elapsedRealtime() - j).zzcn(this.zzbst).zzco(this.zzcnd.zzbro).zzss();
                    return;
                }
            }
        }
    }

    public void onStop() {
    }

    public void zza(String str, int i) {
        synchronized (this.zzakd) {
            this.zzcnf = 2;
            this.zzcdb = i;
            this.zzakd.notify();
        }
    }

    public void zzay(int i) {
        zza(this.zzbst, 0);
    }

    public void zzcm(String str) {
        synchronized (this.zzakd) {
            this.zzcnf = 1;
            this.zzakd.notify();
        }
    }

    /* access modifiers changed from: protected */
    public boolean zzf(long j) {
        long elapsedRealtime = this.zzcne - (zzu.zzgf().elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            this.zzcdb = 4;
            return false;
        }
        try {
            this.zzakd.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            this.zzcdb = 5;
            return false;
        }
    }

    public void zzfc() {
        if (this.zzcna != null && this.zzcna.zzsw() != null && this.zzcna.zzsv() != null) {
            final zzjw zzsw = this.zzcna.zzsw();
            zzsw.zza((zzjx) null);
            zzsw.zza((zzju) this);
            final AdRequestParcel adRequestParcel = this.zzcck.zzcix.zzcfu;
            final zzgr zzsv = this.zzcna.zzsv();
            try {
                if (zzsv.isInitialized()) {
                    zza.zzctj.post(new Runnable() {
                        public void run() {
                            zzjs.this.zza(adRequestParcel, zzsv);
                        }
                    });
                } else {
                    zza.zzctj.post(new Runnable() {
                        public void run() {
                            try {
                                zzsv.zza(zze.zzac(zzjs.this.mContext), adRequestParcel, (String) null, (com.google.android.gms.ads.internal.reward.mediation.client.zza) zzsw, zzjs.this.zzcnc);
                            } catch (RemoteException e) {
                                RemoteException remoteException = e;
                                String valueOf = String.valueOf(zzjs.this.zzbst);
                                zzkn.zzd(valueOf.length() != 0 ? "Fail to initialize adapter ".concat(valueOf) : new String("Fail to initialize adapter "), remoteException);
                                zzjs.this.zza(zzjs.this.zzbst, 0);
                            }
                        }
                    });
                }
            } catch (RemoteException e) {
                zzkn.zzd("Fail to check if adapter is initialized.", e);
                zza(this.zzbst, 0);
            }
            zzk(zzu.zzgf().elapsedRealtime());
            zzsw.zza((zzjx) null);
            zzsw.zza((zzju) null);
            if (this.zzcnf == 1) {
                this.zzcnb.zzcm(this.zzbst);
            } else {
                this.zzcnb.zza(this.zzbst, this.zzcdb);
            }
        }
    }

    public zzjt zzsp() {
        zzjt zzjt;
        synchronized (this.zzakd) {
            zzjt = this.zzcng;
        }
        return zzjt;
    }

    public zzgg zzsq() {
        return this.zzcnd;
    }

    public void zzsr() {
        zza(this.zzcck.zzcix.zzcfu, this.zzcna.zzsv());
    }
}
