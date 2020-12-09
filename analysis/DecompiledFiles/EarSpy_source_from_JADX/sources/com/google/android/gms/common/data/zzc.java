package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzac;

public abstract class zzc {

    /* renamed from: xi */
    protected final DataHolder f1586xi;

    /* renamed from: zK */
    protected int f1587zK;

    /* renamed from: zL */
    private int f1588zL;

    public zzc(DataHolder dataHolder, int i) {
        this.f1586xi = (DataHolder) zzac.zzy(dataHolder);
        zzfz(i);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof zzc)) {
            return false;
        }
        zzc zzc = (zzc) obj;
        return zzab.equal(Integer.valueOf(zzc.f1587zK), Integer.valueOf(this.f1587zK)) && zzab.equal(Integer.valueOf(zzc.f1588zL), Integer.valueOf(this.f1588zL)) && zzc.f1586xi == this.f1586xi;
    }

    /* access modifiers changed from: protected */
    public boolean getBoolean(String str) {
        return this.f1586xi.zze(str, this.f1587zK, this.f1588zL);
    }

    /* access modifiers changed from: protected */
    public byte[] getByteArray(String str) {
        return this.f1586xi.zzg(str, this.f1587zK, this.f1588zL);
    }

    /* access modifiers changed from: protected */
    public float getFloat(String str) {
        return this.f1586xi.zzf(str, this.f1587zK, this.f1588zL);
    }

    /* access modifiers changed from: protected */
    public int getInteger(String str) {
        return this.f1586xi.zzc(str, this.f1587zK, this.f1588zL);
    }

    /* access modifiers changed from: protected */
    public long getLong(String str) {
        return this.f1586xi.zzb(str, this.f1587zK, this.f1588zL);
    }

    /* access modifiers changed from: protected */
    public String getString(String str) {
        return this.f1586xi.zzd(str, this.f1587zK, this.f1588zL);
    }

    public int hashCode() {
        return zzab.hashCode(Integer.valueOf(this.f1587zK), Integer.valueOf(this.f1588zL), this.f1586xi);
    }

    public boolean isDataValid() {
        return !this.f1586xi.isClosed();
    }

    /* access modifiers changed from: protected */
    public void zza(String str, CharArrayBuffer charArrayBuffer) {
        this.f1586xi.zza(str, this.f1587zK, this.f1588zL, charArrayBuffer);
    }

    /* access modifiers changed from: protected */
    public int zzatc() {
        return this.f1587zK;
    }

    /* access modifiers changed from: protected */
    public void zzfz(int i) {
        zzac.zzbr(i >= 0 && i < this.f1586xi.getCount());
        this.f1587zK = i;
        this.f1588zL = this.f1586xi.zzgb(this.f1587zK);
    }

    public boolean zzhm(String str) {
        return this.f1586xi.zzhm(str);
    }

    /* access modifiers changed from: protected */
    public Uri zzhn(String str) {
        return this.f1586xi.zzh(str, this.f1587zK, this.f1588zL);
    }

    /* access modifiers changed from: protected */
    public boolean zzho(String str) {
        return this.f1586xi.zzi(str, this.f1587zK, this.f1588zL);
    }
}
