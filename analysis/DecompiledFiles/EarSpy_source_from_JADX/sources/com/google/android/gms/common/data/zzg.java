package com.google.android.gms.common.data;

import java.util.NoSuchElementException;

public class zzg<T> extends zzb<T> {

    /* renamed from: Ad */
    private T f1593Ad;

    public zzg(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException(new StringBuilder(46).append("Cannot advance the iterator beyond ").append(this.f1585zI).toString());
        }
        this.f1585zI++;
        if (this.f1585zI == 0) {
            this.f1593Ad = this.f1584zH.get(0);
            if (!(this.f1593Ad instanceof zzc)) {
                String valueOf = String.valueOf(this.f1593Ad.getClass());
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 44).append("DataBuffer reference of type ").append(valueOf).append(" is not movable").toString());
            }
        } else {
            ((zzc) this.f1593Ad).zzfz(this.f1585zI);
        }
        return this.f1593Ad;
    }
}
