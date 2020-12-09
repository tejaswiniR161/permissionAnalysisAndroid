package com.google.android.gms.gass.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzarj;
import com.google.android.gms.internal.zzark;

public final class GassResponseParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GassResponseParcel> CREATOR = new zzd();
    private zzae.zza aeA = null;
    private byte[] aeB;
    public final int versionCode;

    GassResponseParcel(int i, byte[] bArr) {
        this.versionCode = i;
        this.aeB = bArr;
        zzayw();
    }

    private void zzayu() {
        if (!zzayv()) {
            try {
                this.aeA = zzae.zza.zzc(this.aeB);
                this.aeB = null;
            } catch (zzarj e) {
                throw new IllegalStateException(e);
            }
        }
        zzayw();
    }

    private boolean zzayv() {
        return this.aeA != null;
    }

    private void zzayw() {
        if (this.aeA == null && this.aeB != null) {
            return;
        }
        if (this.aeA != null && this.aeB == null) {
            return;
        }
        if (this.aeA != null && this.aeB != null) {
            throw new IllegalStateException("Invalid internal representation - full");
        } else if (this.aeA == null && this.aeB == null) {
            throw new IllegalStateException("Invalid internal representation - empty");
        } else {
            throw new IllegalStateException("Impossible");
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }

    public byte[] zzbnv() {
        return this.aeB != null ? this.aeB : zzark.zzf(this.aeA);
    }

    public zzae.zza zzbnw() {
        zzayu();
        return this.aeA;
    }
}
