package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class zzaps implements zzaou {
    private final zzapb bkM;
    private final zzapc bkV;
    private final zzaoa bkX;

    public static final class zza<T> extends zzaot<T> {
        private final Map<String, zzb> bmM;
        private final zzapg<T> bmt;

        private zza(zzapg<T> zzapg, Map<String, zzb> map) {
            this.bmt = zzapg;
            this.bmM = map;
        }

        public void zza(zzaqa zzaqa, T t) throws IOException {
            if (t == null) {
                zzaqa.mo8990bx();
                return;
            }
            zzaqa.mo8988bv();
            try {
                for (zzb next : this.bmM.values()) {
                    if (next.zzct(t)) {
                        zzaqa.zzus(next.name);
                        next.zza(zzaqa, (Object) t);
                    }
                }
                zzaqa.mo8989bw();
            } catch (IllegalAccessException e) {
                throw new AssertionError();
            }
        }

        public T zzb(zzapy zzapy) throws IOException {
            if (zzapy.mo8968bn() == zzapz.NULL) {
                zzapy.nextNull();
                return null;
            }
            T bg = this.bmt.mo8901bg();
            try {
                zzapy.beginObject();
                while (zzapy.hasNext()) {
                    zzb zzb = this.bmM.get(zzapy.nextName());
                    if (zzb == null || !zzb.bmO) {
                        zzapy.skipValue();
                    } else {
                        zzb.zza(zzapy, (Object) bg);
                    }
                }
                zzapy.endObject();
                return bg;
            } catch (IllegalStateException e) {
                throw new zzaoq((Throwable) e);
            } catch (IllegalAccessException e2) {
                throw new AssertionError(e2);
            }
        }
    }

    static abstract class zzb {
        final boolean bmN;
        final boolean bmO;
        final String name;

        protected zzb(String str, boolean z, boolean z2) {
            this.name = str;
            this.bmN = z;
            this.bmO = z2;
        }

        /* access modifiers changed from: package-private */
        public abstract void zza(zzapy zzapy, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: package-private */
        public abstract void zza(zzaqa zzaqa, Object obj) throws IOException, IllegalAccessException;

        /* access modifiers changed from: package-private */
        public abstract boolean zzct(Object obj) throws IOException, IllegalAccessException;
    }

    public zzaps(zzapb zzapb, zzaoa zzaoa, zzapc zzapc) {
        this.bkM = zzapb;
        this.bkX = zzaoa;
        this.bkV = zzapc;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = com.google.android.gms.internal.zzapn.zza(r2.bkM, r3, r5, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.zzaot<?> zza(com.google.android.gms.internal.zzaob r3, java.lang.reflect.Field r4, com.google.android.gms.internal.zzapx<?> r5) {
        /*
            r2 = this;
            java.lang.Class<com.google.android.gms.internal.zzaov> r0 = com.google.android.gms.internal.zzaov.class
            java.lang.annotation.Annotation r0 = r4.getAnnotation(r0)
            com.google.android.gms.internal.zzaov r0 = (com.google.android.gms.internal.zzaov) r0
            if (r0 == 0) goto L_0x0013
            com.google.android.gms.internal.zzapb r1 = r2.bkM
            com.google.android.gms.internal.zzaot r0 = com.google.android.gms.internal.zzapn.zza(r1, r3, r5, r0)
            if (r0 == 0) goto L_0x0013
        L_0x0012:
            return r0
        L_0x0013:
            com.google.android.gms.internal.zzaot r0 = r3.zza(r5)
            goto L_0x0012
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaps.zza(com.google.android.gms.internal.zzaob, java.lang.reflect.Field, com.google.android.gms.internal.zzapx):com.google.android.gms.internal.zzaot");
    }

    private zzb zza(zzaob zzaob, Field field, String str, zzapx<?> zzapx, boolean z, boolean z2) {
        final boolean zzk = zzaph.zzk(zzapx.mo9067by());
        final zzaob zzaob2 = zzaob;
        final Field field2 = field;
        final zzapx<?> zzapx2 = zzapx;
        return new zzb(str, z, z2) {
            final zzaot<?> bmG = zzaps.this.zza(zzaob2, field2, (zzapx<?>) zzapx2);

            /* access modifiers changed from: package-private */
            public void zza(zzapy zzapy, Object obj) throws IOException, IllegalAccessException {
                Object zzb = this.bmG.zzb(zzapy);
                if (zzb != null || !zzk) {
                    field2.set(obj, zzb);
                }
            }

            /* access modifiers changed from: package-private */
            public void zza(zzaqa zzaqa, Object obj) throws IOException, IllegalAccessException {
                new zzapv(zzaob2, this.bmG, zzapx2.mo9068bz()).zza(zzaqa, field2.get(obj));
            }

            public boolean zzct(Object obj) throws IOException, IllegalAccessException {
                return this.bmN && field2.get(obj) != obj;
            }
        };
    }

    static List<String> zza(zzaoa zzaoa, Field field) {
        zzaow zzaow = (zzaow) field.getAnnotation(zzaow.class);
        LinkedList linkedList = new LinkedList();
        if (zzaow == null) {
            linkedList.add(zzaoa.zzc(field));
        } else {
            linkedList.add(zzaow.value());
            for (String add : zzaow.mo8880be()) {
                linkedList.add(add);
            }
        }
        return linkedList;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: java.lang.Class<java.lang.Object>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v2, resolved type: com.google.android.gms.internal.zzapx<?>} */
    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class, for r20v0, types: [java.lang.Class<?>, java.lang.Class] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.Map<java.lang.String, com.google.android.gms.internal.zzaps.zzb> zza(com.google.android.gms.internal.zzaob r18, com.google.android.gms.internal.zzapx<?> r19, java.lang.Class r20) {
        /*
            r17 = this;
            java.util.LinkedHashMap r10 = new java.util.LinkedHashMap
            r10.<init>()
            boolean r1 = r20.isInterface()
            if (r1 == 0) goto L_0x000d
            r1 = r10
        L_0x000c:
            return r1
        L_0x000d:
            java.lang.reflect.Type r12 = r19.mo9068bz()
        L_0x0011:
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            r0 = r20
            if (r0 == r1) goto L_0x00cd
            java.lang.reflect.Field[] r13 = r20.getDeclaredFields()
            int r14 = r13.length
            r1 = 0
            r11 = r1
        L_0x001e:
            if (r11 >= r14) goto L_0x00b5
            r3 = r13[r11]
            r1 = 1
            r0 = r17
            boolean r6 = r0.zza((java.lang.reflect.Field) r3, (boolean) r1)
            r1 = 0
            r0 = r17
            boolean r7 = r0.zza((java.lang.reflect.Field) r3, (boolean) r1)
            if (r6 != 0) goto L_0x0038
            if (r7 != 0) goto L_0x0038
        L_0x0034:
            int r1 = r11 + 1
            r11 = r1
            goto L_0x001e
        L_0x0038:
            r1 = 1
            r3.setAccessible(r1)
            java.lang.reflect.Type r1 = r19.mo9068bz()
            java.lang.reflect.Type r2 = r3.getGenericType()
            r0 = r20
            java.lang.reflect.Type r15 = com.google.android.gms.internal.zzapa.zza((java.lang.reflect.Type) r1, (java.lang.Class<?>) r0, (java.lang.reflect.Type) r2)
            r0 = r17
            java.util.List r16 = r0.zzd(r3)
            r8 = 0
            r1 = 0
            r9 = r1
        L_0x0053:
            int r1 = r16.size()
            if (r9 >= r1) goto L_0x007d
            r0 = r16
            java.lang.Object r4 = r0.get(r9)
            java.lang.String r4 = (java.lang.String) r4
            if (r9 == 0) goto L_0x0064
            r6 = 0
        L_0x0064:
            com.google.android.gms.internal.zzapx r5 = com.google.android.gms.internal.zzapx.zzl(r15)
            r1 = r17
            r2 = r18
            com.google.android.gms.internal.zzaps$zzb r1 = r1.zza(r2, r3, r4, r5, r6, r7)
            java.lang.Object r1 = r10.put(r4, r1)
            com.google.android.gms.internal.zzaps$zzb r1 = (com.google.android.gms.internal.zzaps.zzb) r1
            if (r8 != 0) goto L_0x00d0
        L_0x0078:
            int r2 = r9 + 1
            r9 = r2
            r8 = r1
            goto L_0x0053
        L_0x007d:
            if (r8 == 0) goto L_0x0034
            java.lang.IllegalArgumentException r1 = new java.lang.IllegalArgumentException
            java.lang.String r2 = java.lang.String.valueOf(r12)
            java.lang.String r3 = r8.name
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = java.lang.String.valueOf(r2)
            int r5 = r5.length()
            int r5 = r5 + 37
            java.lang.String r6 = java.lang.String.valueOf(r3)
            int r6 = r6.length()
            int r5 = r5 + r6
            r4.<init>(r5)
            java.lang.StringBuilder r2 = r4.append(r2)
            java.lang.String r4 = " declares multiple JSON fields named "
            java.lang.StringBuilder r2 = r2.append(r4)
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        L_0x00b5:
            java.lang.reflect.Type r1 = r19.mo9068bz()
            java.lang.reflect.Type r2 = r20.getGenericSuperclass()
            r0 = r20
            java.lang.reflect.Type r1 = com.google.android.gms.internal.zzapa.zza((java.lang.reflect.Type) r1, (java.lang.Class<?>) r0, (java.lang.reflect.Type) r2)
            com.google.android.gms.internal.zzapx r19 = com.google.android.gms.internal.zzapx.zzl(r1)
            java.lang.Class r20 = r19.mo9067by()
            goto L_0x0011
        L_0x00cd:
            r1 = r10
            goto L_0x000c
        L_0x00d0:
            r1 = r8
            goto L_0x0078
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzaps.zza(com.google.android.gms.internal.zzaob, com.google.android.gms.internal.zzapx, java.lang.Class):java.util.Map");
    }

    static boolean zza(Field field, boolean z, zzapc zzapc) {
        return !zzapc.zza(field.getType(), z) && !zzapc.zza(field, z);
    }

    private List<String> zzd(Field field) {
        return zza(this.bkX, field);
    }

    public <T> zzaot<T> zza(zzaob zzaob, zzapx<T> zzapx) {
        Class<? super T> by = zzapx.mo9067by();
        if (!Object.class.isAssignableFrom(by)) {
            return null;
        }
        return new zza(this.bkM.zzb(zzapx), zza(zzaob, (zzapx<?>) zzapx, (Class<?>) by));
    }

    public boolean zza(Field field, boolean z) {
        return zza(field, z, this.bkV);
    }
}
