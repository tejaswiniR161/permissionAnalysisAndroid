package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public final class zzapk<E> extends zzaot<Object> {
    public static final zzaou bmp = new zzaou() {
        public <T> zzaot<T> zza(zzaob zzaob, zzapx<T> zzapx) {
            Type bz = zzapx.mo9068bz();
            if (!(bz instanceof GenericArrayType) && (!(bz instanceof Class) || !((Class) bz).isArray())) {
                return null;
            }
            Type zzh = zzapa.zzh(bz);
            return new zzapk(zzaob, zzaob.zza(zzapx.zzl(zzh)), zzapa.zzf(zzh));
        }
    };
    private final Class<E> bmq;
    private final zzaot<E> bmr;

    public zzapk(zzaob zzaob, zzaot<E> zzaot, Class<E> cls) {
        this.bmr = new zzapv(zzaob, zzaot, cls);
        this.bmq = cls;
    }

    public void zza(zzaqa zzaqa, Object obj) throws IOException {
        if (obj == null) {
            zzaqa.mo8990bx();
            return;
        }
        zzaqa.mo8986bt();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.bmr.zza(zzaqa, Array.get(obj, i));
        }
        zzaqa.mo8987bu();
    }

    public Object zzb(zzapy zzapy) throws IOException {
        if (zzapy.mo8968bn() == zzapz.NULL) {
            zzapy.nextNull();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        zzapy.beginArray();
        while (zzapy.hasNext()) {
            arrayList.add(this.bmr.zzb(zzapy));
        }
        zzapy.endArray();
        Object newInstance = Array.newInstance(this.bmq, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }
}
