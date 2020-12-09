package com.google.android.gms.internal;

import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;

public abstract class zzqk implements Releasable, Result {

    /* renamed from: fp */
    protected final Status f2023fp;

    /* renamed from: xi */
    protected final DataHolder f2024xi;

    protected zzqk(DataHolder dataHolder, Status status) {
        this.f2023fp = status;
        this.f2024xi = dataHolder;
    }

    public Status getStatus() {
        return this.f2023fp;
    }

    public void release() {
        if (this.f2024xi != null) {
            this.f2024xi.close();
        }
    }
}
