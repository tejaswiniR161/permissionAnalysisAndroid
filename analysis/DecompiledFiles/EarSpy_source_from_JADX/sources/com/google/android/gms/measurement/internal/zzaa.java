package com.google.android.gms.measurement.internal;

abstract class zzaa extends zzz {

    /* renamed from: aJ */
    private boolean f2278aJ;

    zzaa(zzx zzx) {
        super(zzx);
        this.anq.zzb(this);
    }

    public final void initialize() {
        if (this.f2278aJ) {
            throw new IllegalStateException("Can't initialize twice");
        }
        zzym();
        this.anq.zzbxo();
        this.f2278aJ = true;
    }

    /* access modifiers changed from: package-private */
    public boolean isInitialized() {
        return this.f2278aJ;
    }

    /* access modifiers changed from: protected */
    public void zzaax() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzbxt() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract void zzym();
}
