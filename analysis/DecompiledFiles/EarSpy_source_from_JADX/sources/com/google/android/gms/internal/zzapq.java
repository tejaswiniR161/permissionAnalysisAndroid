package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public final class zzapq implements zzaou {
    private final zzapb bkM;
    /* access modifiers changed from: private */
    public final boolean bmB;

    private final class zza<K, V> extends zzaot<Map<K, V>> {
        private final zzaot<K> bmC;
        private final zzaot<V> bmD;
        private final zzapg<? extends Map<K, V>> bmt;

        public zza(zzaob zzaob, Type type, zzaot<K> zzaot, Type type2, zzaot<V> zzaot2, zzapg<? extends Map<K, V>> zzapg) {
            this.bmC = new zzapv(zzaob, zzaot, type);
            this.bmD = new zzapv(zzaob, zzaot2, type2);
            this.bmt = zzapg;
        }

        private String zze(zzaoh zzaoh) {
            if (zzaoh.mo8850aU()) {
                zzaon aY = zzaoh.mo8854aY();
                if (aY.mo8872bb()) {
                    return String.valueOf(aY.mo8836aQ());
                }
                if (aY.mo8871ba()) {
                    return Boolean.toString(aY.getAsBoolean());
                }
                if (aY.mo8873bc()) {
                    return aY.mo8837aR();
                }
                throw new AssertionError();
            } else if (zzaoh.mo8851aV()) {
                return "null";
            } else {
                throw new AssertionError();
            }
        }

        public void zza(zzaqa zzaqa, Map<K, V> map) throws IOException {
            int i = 0;
            if (map == null) {
                zzaqa.mo8990bx();
            } else if (!zzapq.this.bmB) {
                zzaqa.mo8988bv();
                for (Map.Entry next : map.entrySet()) {
                    zzaqa.zzus(String.valueOf(next.getKey()));
                    this.bmD.zza(zzaqa, next.getValue());
                }
                zzaqa.mo8989bw();
            } else {
                ArrayList arrayList = new ArrayList(map.size());
                ArrayList arrayList2 = new ArrayList(map.size());
                boolean z = false;
                for (Map.Entry next2 : map.entrySet()) {
                    zzaoh zzco = this.bmC.zzco(next2.getKey());
                    arrayList.add(zzco);
                    arrayList2.add(next2.getValue());
                    z = (zzco.mo8848aS() || zzco.mo8849aT()) | z;
                }
                if (z) {
                    zzaqa.mo8986bt();
                    while (i < arrayList.size()) {
                        zzaqa.mo8986bt();
                        zzapi.zzb((zzaoh) arrayList.get(i), zzaqa);
                        this.bmD.zza(zzaqa, arrayList2.get(i));
                        zzaqa.mo8987bu();
                        i++;
                    }
                    zzaqa.mo8987bu();
                    return;
                }
                zzaqa.mo8988bv();
                while (i < arrayList.size()) {
                    zzaqa.zzus(zze((zzaoh) arrayList.get(i)));
                    this.bmD.zza(zzaqa, arrayList2.get(i));
                    i++;
                }
                zzaqa.mo8989bw();
            }
        }

        /* renamed from: zzl */
        public Map<K, V> zzb(zzapy zzapy) throws IOException {
            zzapz bn = zzapy.mo8968bn();
            if (bn == zzapz.NULL) {
                zzapy.nextNull();
                return null;
            }
            Map<K, V> map = (Map) this.bmt.mo8901bg();
            if (bn == zzapz.BEGIN_ARRAY) {
                zzapy.beginArray();
                while (zzapy.hasNext()) {
                    zzapy.beginArray();
                    K zzb = this.bmC.zzb(zzapy);
                    if (map.put(zzb, this.bmD.zzb(zzapy)) != null) {
                        String valueOf = String.valueOf(zzb);
                        throw new zzaoq(new StringBuilder(String.valueOf(valueOf).length() + 15).append("duplicate key: ").append(valueOf).toString());
                    }
                    zzapy.endArray();
                }
                zzapy.endArray();
                return map;
            }
            zzapy.beginObject();
            while (zzapy.hasNext()) {
                zzapd.blQ.zzi(zzapy);
                K zzb2 = this.bmC.zzb(zzapy);
                if (map.put(zzb2, this.bmD.zzb(zzapy)) != null) {
                    String valueOf2 = String.valueOf(zzb2);
                    throw new zzaoq(new StringBuilder(String.valueOf(valueOf2).length() + 15).append("duplicate key: ").append(valueOf2).toString());
                }
            }
            zzapy.endObject();
            return map;
        }
    }

    public zzapq(zzapb zzapb, boolean z) {
        this.bkM = zzapb;
        this.bmB = z;
    }

    private zzaot<?> zza(zzaob zzaob, Type type) {
        return (type == Boolean.TYPE || type == Boolean.class) ? zzapw.bmX : zzaob.zza(zzapx.zzl(type));
    }

    public <T> zzaot<T> zza(zzaob zzaob, zzapx<T> zzapx) {
        Type bz = zzapx.mo9068bz();
        if (!Map.class.isAssignableFrom(zzapx.mo9067by())) {
            return null;
        }
        Type[] zzb = zzapa.zzb(bz, zzapa.zzf(bz));
        zzaot<?> zza2 = zza(zzaob, zzb[0]);
        zzaot<?> zza3 = zzaob.zza(zzapx.zzl(zzb[1]));
        zzapg<T> zzb2 = this.bkM.zzb(zzapx);
        return new zza(zzaob, zzb[0], zza2, zzb[1], zza3, zzb2);
    }
}
