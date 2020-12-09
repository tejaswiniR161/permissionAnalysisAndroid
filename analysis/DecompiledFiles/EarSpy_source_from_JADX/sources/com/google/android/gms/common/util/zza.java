package com.google.android.gms.common.util;

import android.support.p000v4.util.ArrayMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;

public class zza<E> extends AbstractSet<E> {

    /* renamed from: EJ */
    private final ArrayMap<E, E> f1851EJ;

    public zza() {
        this.f1851EJ = new ArrayMap<>();
    }

    public zza(int i) {
        this.f1851EJ = new ArrayMap<>(i);
    }

    public zza(Collection<E> collection) {
        this(collection.size());
        addAll(collection);
    }

    public boolean add(E e) {
        if (this.f1851EJ.containsKey(e)) {
            return false;
        }
        this.f1851EJ.put(e, e);
        return true;
    }

    public boolean addAll(Collection<? extends E> collection) {
        return collection instanceof zza ? zza((zza) collection) : super.addAll(collection);
    }

    public void clear() {
        this.f1851EJ.clear();
    }

    public boolean contains(Object obj) {
        return this.f1851EJ.containsKey(obj);
    }

    public Iterator<E> iterator() {
        return this.f1851EJ.keySet().iterator();
    }

    public boolean remove(Object obj) {
        if (!this.f1851EJ.containsKey(obj)) {
            return false;
        }
        this.f1851EJ.remove(obj);
        return true;
    }

    public int size() {
        return this.f1851EJ.size();
    }

    public boolean zza(zza<? extends E> zza) {
        int size = size();
        this.f1851EJ.putAll(zza.f1851EJ);
        return size() > size;
    }
}
