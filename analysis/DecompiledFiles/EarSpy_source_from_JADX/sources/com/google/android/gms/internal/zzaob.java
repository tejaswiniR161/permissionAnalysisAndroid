package com.google.android.gms.internal;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzaob {
    private final ThreadLocal<Map<zzapx<?>, zza<?>>> bkJ;
    private final Map<zzapx<?>, zzaot<?>> bkK;
    private final List<zzaou> bkL;
    private final zzapb bkM;
    private final boolean bkN;
    private final boolean bkO;
    private final boolean bkP;
    private final boolean bkQ;
    final zzaof bkR;
    final zzaoo bkS;

    static class zza<T> extends zzaot<T> {
        private zzaot<T> bkU;

        zza() {
        }

        public void zza(zzaot<T> zzaot) {
            if (this.bkU != null) {
                throw new AssertionError();
            }
            this.bkU = zzaot;
        }

        public void zza(zzaqa zzaqa, T t) throws IOException {
            if (this.bkU == null) {
                throw new IllegalStateException();
            }
            this.bkU.zza(zzaqa, t);
        }

        public T zzb(zzapy zzapy) throws IOException {
            if (this.bkU != null) {
                return this.bkU.zzb(zzapy);
            }
            throw new IllegalStateException();
        }
    }

    public zzaob() {
        this(zzapc.blF, zzanz.IDENTITY, Collections.emptyMap(), false, false, false, true, false, false, zzaor.DEFAULT, Collections.emptyList());
    }

    zzaob(zzapc zzapc, zzaoa zzaoa, Map<Type, zzaod<?>> map, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, zzaor zzaor, List<zzaou> list) {
        this.bkJ = new ThreadLocal<>();
        this.bkK = Collections.synchronizedMap(new HashMap());
        this.bkR = new zzaof() {
        };
        this.bkS = new zzaoo() {
        };
        this.bkM = new zzapb(map);
        this.bkN = z;
        this.bkP = z3;
        this.bkO = z4;
        this.bkQ = z5;
        ArrayList arrayList = new ArrayList();
        arrayList.add(zzapw.bnI);
        arrayList.add(zzapr.bmp);
        arrayList.add(zzapc);
        arrayList.addAll(list);
        arrayList.add(zzapw.bnp);
        arrayList.add(zzapw.bne);
        arrayList.add(zzapw.bmY);
        arrayList.add(zzapw.bna);
        arrayList.add(zzapw.bnc);
        arrayList.add(zzapw.zza(Long.TYPE, Long.class, zza(zzaor)));
        arrayList.add(zzapw.zza(Double.TYPE, Double.class, zzdd(z6)));
        arrayList.add(zzapw.zza(Float.TYPE, Float.class, zzde(z6)));
        arrayList.add(zzapw.bnj);
        arrayList.add(zzapw.bnl);
        arrayList.add(zzapw.bnr);
        arrayList.add(zzapw.bnt);
        arrayList.add(zzapw.zza(BigDecimal.class, zzapw.bnn));
        arrayList.add(zzapw.zza(BigInteger.class, zzapw.bno));
        arrayList.add(zzapw.bnv);
        arrayList.add(zzapw.bnx);
        arrayList.add(zzapw.bnB);
        arrayList.add(zzapw.bnG);
        arrayList.add(zzapw.bnz);
        arrayList.add(zzapw.bmV);
        arrayList.add(zzapm.bmp);
        arrayList.add(zzapw.bnE);
        arrayList.add(zzapu.bmp);
        arrayList.add(zzapt.bmp);
        arrayList.add(zzapw.bnC);
        arrayList.add(zzapk.bmp);
        arrayList.add(zzapw.bmT);
        arrayList.add(new zzapl(this.bkM));
        arrayList.add(new zzapq(this.bkM, z2));
        arrayList.add(new zzapn(this.bkM));
        arrayList.add(zzapw.bnJ);
        arrayList.add(new zzaps(this.bkM, zzaoa, zzapc));
        this.bkL = Collections.unmodifiableList(arrayList);
    }

    private zzaot<Number> zza(zzaor zzaor) {
        return zzaor == zzaor.DEFAULT ? zzapw.bnf : new zzaot<Number>() {
            public void zza(zzaqa zzaqa, Number number) throws IOException {
                if (number == null) {
                    zzaqa.mo8990bx();
                } else {
                    zzaqa.zzut(number.toString());
                }
            }

            /* renamed from: zzg */
            public Number zzb(zzapy zzapy) throws IOException {
                if (zzapy.mo8968bn() != zzapz.NULL) {
                    return Long.valueOf(zzapy.nextLong());
                }
                zzapy.nextNull();
                return null;
            }
        };
    }

    private static void zza(Object obj, zzapy zzapy) {
        if (obj != null) {
            try {
                if (zzapy.mo8968bn() != zzapz.END_DOCUMENT) {
                    throw new zzaoi("JSON document was not fully consumed.");
                }
            } catch (zzaqb e) {
                throw new zzaoq((Throwable) e);
            } catch (IOException e2) {
                throw new zzaoi((Throwable) e2);
            }
        }
    }

    private zzaot<Number> zzdd(boolean z) {
        return z ? zzapw.bnh : new zzaot<Number>() {
            public void zza(zzaqa zzaqa, Number number) throws IOException {
                if (number == null) {
                    zzaqa.mo8990bx();
                    return;
                }
                zzaob.this.zzn(number.doubleValue());
                zzaqa.zza(number);
            }

            /* renamed from: zze */
            public Double zzb(zzapy zzapy) throws IOException {
                if (zzapy.mo8968bn() != zzapz.NULL) {
                    return Double.valueOf(zzapy.nextDouble());
                }
                zzapy.nextNull();
                return null;
            }
        };
    }

    private zzaot<Number> zzde(boolean z) {
        return z ? zzapw.bng : new zzaot<Number>() {
            public void zza(zzaqa zzaqa, Number number) throws IOException {
                if (number == null) {
                    zzaqa.mo8990bx();
                    return;
                }
                zzaob.this.zzn((double) number.floatValue());
                zzaqa.zza(number);
            }

            /* renamed from: zzf */
            public Float zzb(zzapy zzapy) throws IOException {
                if (zzapy.mo8968bn() != zzapz.NULL) {
                    return Float.valueOf((float) zzapy.nextDouble());
                }
                zzapy.nextNull();
                return null;
            }
        };
    }

    /* access modifiers changed from: private */
    public void zzn(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw new IllegalArgumentException(new StringBuilder(168).append(d).append(" is not a valid double value as per JSON specification. To override this").append(" behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.").toString());
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.bkN + "factories:" + this.bkL + ",instanceCreators:" + this.bkM + "}";
    }

    public <T> zzaot<T> zza(zzaou zzaou, zzapx<T> zzapx) {
        boolean z = false;
        if (!this.bkL.contains(zzaou)) {
            z = true;
        }
        boolean z2 = z;
        for (zzaou next : this.bkL) {
            if (z2) {
                zzaot<T> zza2 = next.zza(this, zzapx);
                if (zza2 != null) {
                    return zza2;
                }
            } else if (next == zzaou) {
                z2 = true;
            }
        }
        String valueOf = String.valueOf(zzapx);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 22).append("GSON cannot serialize ").append(valueOf).toString());
    }

    public <T> zzaot<T> zza(zzapx<T> zzapx) {
        HashMap hashMap;
        zzaot<T> zzaot = this.bkK.get(zzapx);
        if (zzaot == null) {
            Map map = this.bkJ.get();
            boolean z = false;
            if (map == null) {
                HashMap hashMap2 = new HashMap();
                this.bkJ.set(hashMap2);
                hashMap = hashMap2;
                z = true;
            } else {
                hashMap = map;
            }
            zzaot = (zza) hashMap.get(zzapx);
            if (zzaot == null) {
                try {
                    zza zza2 = new zza();
                    hashMap.put(zzapx, zza2);
                    for (zzaou zza3 : this.bkL) {
                        zzaot = zza3.zza(this, zzapx);
                        if (zzaot != null) {
                            zza2.zza(zzaot);
                            this.bkK.put(zzapx, zzaot);
                            hashMap.remove(zzapx);
                            if (z) {
                                this.bkJ.remove();
                            }
                        }
                    }
                    String valueOf = String.valueOf(zzapx);
                    throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 19).append("GSON cannot handle ").append(valueOf).toString());
                } catch (Throwable th) {
                    hashMap.remove(zzapx);
                    if (z) {
                        this.bkJ.remove();
                    }
                    throw th;
                }
            }
        }
        return zzaot;
    }

    public zzaqa zza(Writer writer) throws IOException {
        if (this.bkP) {
            writer.write(")]}'\n");
        }
        zzaqa zzaqa = new zzaqa(writer);
        if (this.bkQ) {
            zzaqa.setIndent("  ");
        }
        zzaqa.zzdi(this.bkN);
        return zzaqa;
    }

    public <T> T zza(zzaoh zzaoh, Class<T> cls) throws zzaoq {
        return zzaph.zzp(cls).cast(zza(zzaoh, (Type) cls));
    }

    public <T> T zza(zzaoh zzaoh, Type type) throws zzaoq {
        if (zzaoh == null) {
            return null;
        }
        return zza((zzapy) new zzapo(zzaoh), type);
    }

    public <T> T zza(zzapy zzapy, Type type) throws zzaoi, zzaoq {
        boolean z = true;
        boolean isLenient = zzapy.isLenient();
        zzapy.setLenient(true);
        try {
            zzapy.mo8968bn();
            z = false;
            T zzb = zza(zzapx.zzl(type)).zzb(zzapy);
            zzapy.setLenient(isLenient);
            return zzb;
        } catch (EOFException e) {
            if (z) {
                zzapy.setLenient(isLenient);
                return null;
            }
            throw new zzaoq((Throwable) e);
        } catch (IllegalStateException e2) {
            throw new zzaoq((Throwable) e2);
        } catch (IOException e3) {
            throw new zzaoq((Throwable) e3);
        } catch (Throwable th) {
            zzapy.setLenient(isLenient);
            throw th;
        }
    }

    public <T> T zza(Reader reader, Type type) throws zzaoi, zzaoq {
        zzapy zzapy = new zzapy(reader);
        T zza2 = zza(zzapy, type);
        zza((Object) zza2, zzapy);
        return zza2;
    }

    public <T> T zza(String str, Type type) throws zzaoq {
        if (str == null) {
            return null;
        }
        return zza((Reader) new StringReader(str), type);
    }

    public void zza(zzaoh zzaoh, zzaqa zzaqa) throws zzaoi {
        boolean isLenient = zzaqa.isLenient();
        zzaqa.setLenient(true);
        boolean bJ = zzaqa.mo9080bJ();
        zzaqa.zzdh(this.bkO);
        boolean bK = zzaqa.mo9081bK();
        zzaqa.zzdi(this.bkN);
        try {
            zzapi.zzb(zzaoh, zzaqa);
            zzaqa.setLenient(isLenient);
            zzaqa.zzdh(bJ);
            zzaqa.zzdi(bK);
        } catch (IOException e) {
            throw new zzaoi((Throwable) e);
        } catch (Throwable th) {
            zzaqa.setLenient(isLenient);
            zzaqa.zzdh(bJ);
            zzaqa.zzdi(bK);
            throw th;
        }
    }

    public void zza(zzaoh zzaoh, Appendable appendable) throws zzaoi {
        try {
            zza(zzaoh, zza(zzapi.zza(appendable)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void zza(Object obj, Type type, zzaqa zzaqa) throws zzaoi {
        zzaot<?> zza2 = zza(zzapx.zzl(type));
        boolean isLenient = zzaqa.isLenient();
        zzaqa.setLenient(true);
        boolean bJ = zzaqa.mo9080bJ();
        zzaqa.zzdh(this.bkO);
        boolean bK = zzaqa.mo9081bK();
        zzaqa.zzdi(this.bkN);
        try {
            zza2.zza(zzaqa, obj);
            zzaqa.setLenient(isLenient);
            zzaqa.zzdh(bJ);
            zzaqa.zzdi(bK);
        } catch (IOException e) {
            throw new zzaoi((Throwable) e);
        } catch (Throwable th) {
            zzaqa.setLenient(isLenient);
            zzaqa.zzdh(bJ);
            zzaqa.zzdi(bK);
            throw th;
        }
    }

    public void zza(Object obj, Type type, Appendable appendable) throws zzaoi {
        try {
            zza(obj, type, zza(zzapi.zza(appendable)));
        } catch (IOException e) {
            throw new zzaoi((Throwable) e);
        }
    }

    public String zzb(zzaoh zzaoh) {
        StringWriter stringWriter = new StringWriter();
        zza(zzaoh, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    public String zzc(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        zza(obj, type, (Appendable) stringWriter);
        return stringWriter.toString();
    }

    public String zzcl(Object obj) {
        return obj == null ? zzb(zzaoj.bld) : zzc(obj, obj.getClass());
    }

    public <T> T zzf(String str, Class<T> cls) throws zzaoq {
        return zzaph.zzp(cls).cast(zza(str, (Type) cls));
    }

    public <T> zzaot<T> zzk(Class<T> cls) {
        return zza(zzapx.zzr(cls));
    }
}
