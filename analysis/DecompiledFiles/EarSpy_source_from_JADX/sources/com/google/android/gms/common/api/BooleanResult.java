package com.google.android.gms.common.api;

import com.google.android.gms.common.internal.zzac;

public class BooleanResult implements Result {

    /* renamed from: fp */
    private final Status f1516fp;

    /* renamed from: vu */
    private final boolean f1517vu;

    public BooleanResult(Status status, boolean z) {
        this.f1516fp = (Status) zzac.zzb(status, (Object) "Status must not be null");
        this.f1517vu = z;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BooleanResult)) {
            return false;
        }
        BooleanResult booleanResult = (BooleanResult) obj;
        return this.f1516fp.equals(booleanResult.f1516fp) && this.f1517vu == booleanResult.f1517vu;
    }

    public Status getStatus() {
        return this.f1516fp;
    }

    public boolean getValue() {
        return this.f1517vu;
    }

    public final int hashCode() {
        return (this.f1517vu ? 1 : 0) + ((this.f1516fp.hashCode() + 527) * 31);
    }
}
