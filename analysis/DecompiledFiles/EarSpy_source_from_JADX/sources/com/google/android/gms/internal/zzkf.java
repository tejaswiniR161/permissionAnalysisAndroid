package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.zzu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@zziy
public class zzkf {
    private final Object zzakd;
    private final zzkh zzapw;
    private boolean zzcko;
    private final LinkedList<zza> zzcoq;
    private final String zzcor;
    private final String zzcos;
    private long zzcot;
    private long zzcou;
    private long zzcov;
    private long zzcow;
    private long zzcox;
    private long zzcoy;

    @zziy
    private static final class zza {
        private long zzcoz = -1;
        private long zzcpa = -1;

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putLong("topen", this.zzcoz);
            bundle.putLong("tclose", this.zzcpa);
            return bundle;
        }

        public long zztc() {
            return this.zzcpa;
        }

        public void zztd() {
            this.zzcpa = SystemClock.elapsedRealtime();
        }

        public void zzte() {
            this.zzcoz = SystemClock.elapsedRealtime();
        }
    }

    public zzkf(zzkh zzkh, String str, String str2) {
        this.zzakd = new Object();
        this.zzcot = -1;
        this.zzcou = -1;
        this.zzcko = false;
        this.zzcov = -1;
        this.zzcow = 0;
        this.zzcox = -1;
        this.zzcoy = -1;
        this.zzapw = zzkh;
        this.zzcor = str;
        this.zzcos = str2;
        this.zzcoq = new LinkedList<>();
    }

    public zzkf(String str, String str2) {
        this(zzu.zzgd(), str, str2);
    }

    public Bundle toBundle() {
        Bundle bundle;
        synchronized (this.zzakd) {
            bundle = new Bundle();
            bundle.putString("seq_num", this.zzcor);
            bundle.putString("slotid", this.zzcos);
            bundle.putBoolean("ismediation", this.zzcko);
            bundle.putLong("treq", this.zzcox);
            bundle.putLong("tresponse", this.zzcoy);
            bundle.putLong("timp", this.zzcou);
            bundle.putLong("tload", this.zzcov);
            bundle.putLong("pcc", this.zzcow);
            bundle.putLong("tfetch", this.zzcot);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.zzcoq.iterator();
            while (it.hasNext()) {
                arrayList.add(((zza) it.next()).toBundle());
            }
            bundle.putParcelableArrayList("tclick", arrayList);
        }
        return bundle;
    }

    public void zzad(boolean z) {
        synchronized (this.zzakd) {
            if (this.zzcoy != -1) {
                this.zzcov = SystemClock.elapsedRealtime();
                if (!z) {
                    this.zzcou = this.zzcov;
                    this.zzapw.zza(this);
                }
            }
        }
    }

    public void zzae(boolean z) {
        synchronized (this.zzakd) {
            if (this.zzcoy != -1) {
                this.zzcko = z;
                this.zzapw.zza(this);
            }
        }
    }

    public void zzm(long j) {
        synchronized (this.zzakd) {
            this.zzcoy = j;
            if (this.zzcoy != -1) {
                this.zzapw.zza(this);
            }
        }
    }

    public void zzn(long j) {
        synchronized (this.zzakd) {
            if (this.zzcoy != -1) {
                this.zzcot = j;
                this.zzapw.zza(this);
            }
        }
    }

    public void zzsz() {
        synchronized (this.zzakd) {
            if (this.zzcoy != -1 && this.zzcou == -1) {
                this.zzcou = SystemClock.elapsedRealtime();
                this.zzapw.zza(this);
            }
            this.zzapw.zztl().zzsz();
        }
    }

    public void zzt(AdRequestParcel adRequestParcel) {
        synchronized (this.zzakd) {
            this.zzcox = SystemClock.elapsedRealtime();
            this.zzapw.zztl().zzb(adRequestParcel, this.zzcox);
        }
    }

    public void zzta() {
        synchronized (this.zzakd) {
            if (this.zzcoy != -1) {
                zza zza2 = new zza();
                zza2.zzte();
                this.zzcoq.add(zza2);
                this.zzcow++;
                this.zzapw.zztl().zzta();
                this.zzapw.zza(this);
            }
        }
    }

    public void zztb() {
        synchronized (this.zzakd) {
            if (this.zzcoy != -1 && !this.zzcoq.isEmpty()) {
                zza last = this.zzcoq.getLast();
                if (last.zztc() == -1) {
                    last.zztd();
                    this.zzapw.zza(this);
                }
            }
        }
    }
}
