package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.zzac;
import java.util.Iterator;
import java.util.LinkedList;

@zziy
class zzfs {
    /* access modifiers changed from: private */
    public final String zzang;
    private final LinkedList<zza> zzbph = new LinkedList<>();
    /* access modifiers changed from: private */
    public AdRequestParcel zzbpi;
    private final int zzbpj;
    private boolean zzbpk;

    class zza {
        zzl zzbpl;
        @Nullable
        AdRequestParcel zzbpm;
        zzfo zzbpn;
        long zzbpo;
        boolean zzbpp;
        boolean zzbpq;

        zza(zzfn zzfn) {
            this.zzbpl = zzfn.zzbg(zzfs.this.zzang);
            this.zzbpn = new zzfo();
            this.zzbpn.zzc(this.zzbpl);
        }

        zza(zzfs zzfs, zzfn zzfn, AdRequestParcel adRequestParcel) {
            this(zzfn);
            this.zzbpm = adRequestParcel;
        }

        /* access modifiers changed from: package-private */
        public void zzmt() {
            if (!this.zzbpp) {
                this.zzbpq = this.zzbpl.zzb(zzfq.zzl(this.zzbpm != null ? this.zzbpm : zzfs.this.zzbpi));
                this.zzbpp = true;
                this.zzbpo = zzu.zzgf().currentTimeMillis();
            }
        }
    }

    zzfs(AdRequestParcel adRequestParcel, String str, int i) {
        zzac.zzy(adRequestParcel);
        zzac.zzy(str);
        this.zzbpi = adRequestParcel;
        this.zzang = str;
        this.zzbpj = i;
    }

    /* access modifiers changed from: package-private */
    public String getAdUnitId() {
        return this.zzang;
    }

    /* access modifiers changed from: package-private */
    public int getNetworkType() {
        return this.zzbpj;
    }

    /* access modifiers changed from: package-private */
    public int size() {
        return this.zzbph.size();
    }

    /* access modifiers changed from: package-private */
    public void zza(zzfn zzfn, AdRequestParcel adRequestParcel) {
        this.zzbph.add(new zza(this, zzfn, adRequestParcel));
    }

    /* access modifiers changed from: package-private */
    public void zzb(zzfn zzfn) {
        zza zza2 = new zza(zzfn);
        this.zzbph.add(zza2);
        zza2.zzmt();
    }

    /* access modifiers changed from: package-private */
    public AdRequestParcel zzmo() {
        return this.zzbpi;
    }

    /* access modifiers changed from: package-private */
    public int zzmp() {
        int i = 0;
        Iterator it = this.zzbph.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = ((zza) it.next()).zzbpp ? i2 + 1 : i2;
        }
    }

    /* access modifiers changed from: package-private */
    public void zzmq() {
        Iterator it = this.zzbph.iterator();
        while (it.hasNext()) {
            ((zza) it.next()).zzmt();
        }
    }

    /* access modifiers changed from: package-private */
    public void zzmr() {
        this.zzbpk = true;
    }

    /* access modifiers changed from: package-private */
    public boolean zzms() {
        return this.zzbpk;
    }

    /* access modifiers changed from: package-private */
    public zza zzp(@Nullable AdRequestParcel adRequestParcel) {
        if (adRequestParcel != null) {
            this.zzbpi = adRequestParcel;
        }
        return this.zzbph.remove();
    }
}
