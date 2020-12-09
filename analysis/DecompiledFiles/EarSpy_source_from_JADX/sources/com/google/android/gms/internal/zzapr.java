package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;

public final class zzapr extends zzaot<Object> {
    public static final zzaou bmp = new zzaou() {
        public <T> zzaot<T> zza(zzaob zzaob, zzapx<T> zzapx) {
            if (zzapx.mo9067by() == Object.class) {
                return new zzapr(zzaob);
            }
            return null;
        }
    };
    private final zzaob bll;

    private zzapr(zzaob zzaob) {
        this.bll = zzaob;
    }

    public void zza(zzaqa zzaqa, Object obj) throws IOException {
        if (obj == null) {
            zzaqa.mo8990bx();
            return;
        }
        zzaot<?> zzk = this.bll.zzk(obj.getClass());
        if (zzk instanceof zzapr) {
            zzaqa.mo8988bv();
            zzaqa.mo8989bw();
            return;
        }
        zzk.zza(zzaqa, obj);
    }

    public Object zzb(zzapy zzapy) throws IOException {
        switch (zzapy.mo8968bn()) {
            case BEGIN_ARRAY:
                ArrayList arrayList = new ArrayList();
                zzapy.beginArray();
                while (zzapy.hasNext()) {
                    arrayList.add(zzb(zzapy));
                }
                zzapy.endArray();
                return arrayList;
            case BEGIN_OBJECT:
                zzapf zzapf = new zzapf();
                zzapy.beginObject();
                while (zzapy.hasNext()) {
                    zzapf.put(zzapy.nextName(), zzb(zzapy));
                }
                zzapy.endObject();
                return zzapf;
            case STRING:
                return zzapy.nextString();
            case NUMBER:
                return Double.valueOf(zzapy.nextDouble());
            case BOOLEAN:
                return Boolean.valueOf(zzapy.nextBoolean());
            case NULL:
                zzapy.nextNull();
                return null;
            default:
                throw new IllegalStateException();
        }
    }
}
