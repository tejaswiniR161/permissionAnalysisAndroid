package com.google.android.gms.internal;

import com.google.android.gms.internal.zzare;
import java.io.IOException;

public abstract class zzare<M extends zzare<M>> extends zzark {
    protected zzarg bqv;

    /* renamed from: cP */
    public M clone() throws CloneNotSupportedException {
        M m = (zzare) super.clone();
        zzari.zza(this, (zzare) m);
        return m;
    }

    /* renamed from: cQ */
    public /* synthetic */ zzark mo9159cQ() throws CloneNotSupportedException {
        return (zzare) clone();
    }

    public final <T> T zza(zzarf<M, T> zzarf) {
        zzarh zzahq;
        if (this.bqv == null || (zzahq = this.bqv.zzahq(zzarn.zzahu(zzarf.tag))) == null) {
            return null;
        }
        return zzahq.zzb(zzarf);
    }

    public void zza(zzard zzard) throws IOException {
        if (this.bqv != null) {
            for (int i = 0; i < this.bqv.size(); i++) {
                this.bqv.zzahr(i).zza(zzard);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzarc zzarc, int i) throws IOException {
        int position = zzarc.getPosition();
        if (!zzarc.zzaha(i)) {
            return false;
        }
        int zzahu = zzarn.zzahu(i);
        zzarm zzarm = new zzarm(i, zzarc.zzad(position, zzarc.getPosition() - position));
        zzarh zzarh = null;
        if (this.bqv == null) {
            this.bqv = new zzarg();
        } else {
            zzarh = this.bqv.zzahq(zzahu);
        }
        if (zzarh == null) {
            zzarh = new zzarh();
            this.bqv.zza(zzahu, zzarh);
        }
        zzarh.zza(zzarm);
        return true;
    }

    /* access modifiers changed from: protected */
    public int zzx() {
        if (this.bqv == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.bqv.size(); i2++) {
            i += this.bqv.zzahr(i2).zzx();
        }
        return i;
    }
}
