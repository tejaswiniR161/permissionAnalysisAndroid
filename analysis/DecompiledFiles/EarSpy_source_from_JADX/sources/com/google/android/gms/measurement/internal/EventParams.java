package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzac;
import java.util.Iterator;

public class EventParams extends AbstractSafeParcelable implements Iterable<String> {
    public static final zzj CREATOR = new zzj();
    /* access modifiers changed from: private */
    public final Bundle aow;
    public final int versionCode;

    EventParams(int i, Bundle bundle) {
        this.versionCode = i;
        this.aow = bundle;
    }

    EventParams(Bundle bundle) {
        zzac.zzy(bundle);
        this.aow = bundle;
        this.versionCode = 1;
    }

    /* access modifiers changed from: package-private */
    public Object get(String str) {
        return this.aow.get(str);
    }

    public Iterator<String> iterator() {
        return new Iterator<String>() {
            Iterator<String> aox = EventParams.this.aow.keySet().iterator();

            public boolean hasNext() {
                return this.aox.hasNext();
            }

            public String next() {
                return this.aox.next();
            }

            public void remove() {
                throw new UnsupportedOperationException("Remove not supported");
            }
        };
    }

    public int size() {
        return this.aow.size();
    }

    public String toString() {
        return this.aow.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzj.zza(this, parcel, i);
    }

    public Bundle zzbvz() {
        return new Bundle(this.aow);
    }
}
