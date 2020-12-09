package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

final class zzarm {
    final byte[] avk;
    final int tag;

    zzarm(int i, byte[] bArr) {
        this.tag = i;
        this.avk = bArr;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzarm)) {
            return false;
        }
        zzarm zzarm = (zzarm) obj;
        return this.tag == zzarm.tag && Arrays.equals(this.avk, zzarm.avk);
    }

    public int hashCode() {
        return ((this.tag + 527) * 31) + Arrays.hashCode(this.avk);
    }

    /* access modifiers changed from: package-private */
    public void zza(zzard zzard) throws IOException {
        zzard.zzahm(this.tag);
        zzard.zzbh(this.avk);
    }

    /* access modifiers changed from: package-private */
    public int zzx() {
        return zzard.zzahn(this.tag) + 0 + this.avk.length;
    }
}
