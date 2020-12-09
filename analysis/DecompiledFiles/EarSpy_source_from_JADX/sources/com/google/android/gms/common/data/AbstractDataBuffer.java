package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.Iterator;

public abstract class AbstractDataBuffer<T> implements DataBuffer<T> {

    /* renamed from: xi */
    protected final DataHolder f1563xi;

    protected AbstractDataBuffer(DataHolder dataHolder) {
        this.f1563xi = dataHolder;
        if (this.f1563xi != null) {
        }
    }

    @Deprecated
    public final void close() {
        release();
    }

    public abstract T get(int i);

    public int getCount() {
        if (this.f1563xi == null) {
            return 0;
        }
        return this.f1563xi.getCount();
    }

    @Deprecated
    public boolean isClosed() {
        return this.f1563xi == null || this.f1563xi.isClosed();
    }

    public Iterator<T> iterator() {
        return new zzb(this);
    }

    public void release() {
        if (this.f1563xi != null) {
            this.f1563xi.close();
        }
    }

    public Iterator<T> singleRefIterator() {
        return new zzg(this);
    }

    public Bundle zzasz() {
        return this.f1563xi.zzasz();
    }
}
