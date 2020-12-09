package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzab;

public class zzanc {

    /* renamed from: fG */
    private String f1929fG;

    public zzanc(@Nullable String str) {
        this.f1929fG = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzanc)) {
            return false;
        }
        return zzab.equal(this.f1929fG, ((zzanc) obj).f1929fG);
    }

    @Nullable
    public String getToken() {
        return this.f1929fG;
    }

    public int hashCode() {
        return zzab.hashCode(this.f1929fG);
    }

    public String toString() {
        return zzab.zzx(this).zzg("token", this.f1929fG).toString();
    }
}
