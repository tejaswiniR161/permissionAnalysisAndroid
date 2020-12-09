package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzac;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class zzb<T> implements Iterator<T> {

    /* renamed from: zH */
    protected final DataBuffer<T> f1584zH;

    /* renamed from: zI */
    protected int f1585zI = -1;

    public zzb(DataBuffer<T> dataBuffer) {
        this.f1584zH = (DataBuffer) zzac.zzy(dataBuffer);
    }

    public boolean hasNext() {
        return this.f1585zI < this.f1584zH.getCount() + -1;
    }

    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException(new StringBuilder(46).append("Cannot advance the iterator beyond ").append(this.f1585zI).toString());
        }
        DataBuffer<T> dataBuffer = this.f1584zH;
        int i = this.f1585zI + 1;
        this.f1585zI = i;
        return dataBuffer.get(i);
    }

    public void remove() {
        throw new UnsupportedOperationException("Cannot remove elements from a DataBufferIterator");
    }
}
