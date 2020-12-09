package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new Parcelable.Creator<BinderWrapper>() {
        /* renamed from: zzcj */
        public BinderWrapper createFromParcel(Parcel parcel) {
            return new BinderWrapper(parcel);
        }

        /* renamed from: zzgm */
        public BinderWrapper[] newArray(int i) {
            return new BinderWrapper[i];
        }
    };

    /* renamed from: Bz */
    private IBinder f1627Bz;

    public BinderWrapper() {
        this.f1627Bz = null;
    }

    public BinderWrapper(IBinder iBinder) {
        this.f1627Bz = null;
        this.f1627Bz = iBinder;
    }

    private BinderWrapper(Parcel parcel) {
        this.f1627Bz = null;
        this.f1627Bz = parcel.readStrongBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f1627Bz);
    }
}
