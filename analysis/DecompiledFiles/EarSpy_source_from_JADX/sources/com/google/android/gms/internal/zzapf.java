package com.google.android.gms.internal;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public final class zzapf<K, V> extends AbstractMap<K, V> implements Serializable {
    static final /* synthetic */ boolean $assertionsDisabled = (!zzapf.class.desiredAssertionStatus());
    private static final Comparator<Comparable> blR = new Comparator<Comparable>() {
        /* renamed from: zza */
        public int compare(Comparable comparable, Comparable comparable2) {
            return comparable.compareTo(comparable2);
        }
    };
    Comparator<? super K> aWP;
    zzd<K, V> blS;
    final zzd<K, V> blT;
    private zza blU;
    private zzb blV;
    int modCount;
    int size;

    class zza extends AbstractSet<Map.Entry<K, V>> {
        zza() {
        }

        public void clear() {
            zzapf.this.clear();
        }

        public boolean contains(Object obj) {
            return (obj instanceof Map.Entry) && zzapf.this.zzc((Map.Entry) obj) != null;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new zzc<Map.Entry<K, V>>() {
                {
                    zzapf zzapf = zzapf.this;
                }

                public Map.Entry<K, V> next() {
                    return mo8943bi();
                }
            };
        }

        public boolean remove(Object obj) {
            zzd zzc;
            if (!(obj instanceof Map.Entry) || (zzc = zzapf.this.zzc((Map.Entry) obj)) == null) {
                return false;
            }
            zzapf.this.zza(zzc, true);
            return true;
        }

        public int size() {
            return zzapf.this.size;
        }
    }

    final class zzb extends AbstractSet<K> {
        zzb() {
        }

        public void clear() {
            zzapf.this.clear();
        }

        public boolean contains(Object obj) {
            return zzapf.this.containsKey(obj);
        }

        public Iterator<K> iterator() {
            return new zzc<K>() {
                {
                    zzapf zzapf = zzapf.this;
                }

                public K next() {
                    return mo8943bi().aXd;
                }
            };
        }

        public boolean remove(Object obj) {
            return zzapf.this.zzcs(obj) != null;
        }

        public int size() {
            return zzapf.this.size;
        }
    }

    private abstract class zzc<T> implements Iterator<T> {
        zzd<K, V> blZ;
        zzd<K, V> bma;
        int bmb;

        private zzc() {
            this.blZ = zzapf.this.blT.blZ;
            this.bma = null;
            this.bmb = zzapf.this.modCount;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: bi */
        public final zzd<K, V> mo8943bi() {
            zzd<K, V> zzd = this.blZ;
            if (zzd == zzapf.this.blT) {
                throw new NoSuchElementException();
            } else if (zzapf.this.modCount != this.bmb) {
                throw new ConcurrentModificationException();
            } else {
                this.blZ = zzd.blZ;
                this.bma = zzd;
                return zzd;
            }
        }

        public final boolean hasNext() {
            return this.blZ != zzapf.this.blT;
        }

        public final void remove() {
            if (this.bma == null) {
                throw new IllegalStateException();
            }
            zzapf.this.zza(this.bma, true);
            this.bma = null;
            this.bmb = zzapf.this.modCount;
        }
    }

    static final class zzd<K, V> implements Map.Entry<K, V> {
        final K aXd;
        zzd<K, V> blZ;
        zzd<K, V> bmc;
        zzd<K, V> bmd;
        zzd<K, V> bme;
        zzd<K, V> bmf;
        int height;
        V value;

        zzd() {
            this.aXd = null;
            this.bmf = this;
            this.blZ = this;
        }

        zzd(zzd<K, V> zzd, K k, zzd<K, V> zzd2, zzd<K, V> zzd3) {
            this.bmc = zzd;
            this.aXd = k;
            this.height = 1;
            this.blZ = zzd2;
            this.bmf = zzd3;
            zzd3.blZ = this;
            zzd2.bmf = this;
        }

        /* renamed from: bj */
        public zzd<K, V> mo8946bj() {
            for (zzd<K, V> zzd = this.bmd; zzd != null; zzd = zzd.bmd) {
                this = zzd;
            }
            return this;
        }

        /* renamed from: bk */
        public zzd<K, V> mo8947bk() {
            for (zzd<K, V> zzd = this.bme; zzd != null; zzd = zzd.bme) {
                this = zzd;
            }
            return this;
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x001b A[ORIG_RETURN, RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r4) {
            /*
                r3 = this;
                r0 = 0
                boolean r1 = r4 instanceof java.util.Map.Entry
                if (r1 == 0) goto L_0x001c
                java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                K r1 = r3.aXd
                if (r1 != 0) goto L_0x001d
                java.lang.Object r1 = r4.getKey()
                if (r1 != 0) goto L_0x001c
            L_0x0011:
                V r1 = r3.value
                if (r1 != 0) goto L_0x002a
                java.lang.Object r1 = r4.getValue()
                if (r1 != 0) goto L_0x001c
            L_0x001b:
                r0 = 1
            L_0x001c:
                return r0
            L_0x001d:
                K r1 = r3.aXd
                java.lang.Object r2 = r4.getKey()
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x001c
                goto L_0x0011
            L_0x002a:
                V r1 = r3.value
                java.lang.Object r2 = r4.getValue()
                boolean r1 = r1.equals(r2)
                if (r1 == 0) goto L_0x001c
                goto L_0x001b
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzapf.zzd.equals(java.lang.Object):boolean");
        }

        public K getKey() {
            return this.aXd;
        }

        public V getValue() {
            return this.value;
        }

        public int hashCode() {
            int i = 0;
            int hashCode = this.aXd == null ? 0 : this.aXd.hashCode();
            if (this.value != null) {
                i = this.value.hashCode();
            }
            return hashCode ^ i;
        }

        public V setValue(V v) {
            V v2 = this.value;
            this.value = v;
            return v2;
        }

        public String toString() {
            String valueOf = String.valueOf(this.aXd);
            String valueOf2 = String.valueOf(this.value);
            return new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length()).append(valueOf).append("=").append(valueOf2).toString();
        }
    }

    public zzapf() {
        this(blR);
    }

    public zzapf(Comparator<? super K> comparator) {
        this.size = 0;
        this.modCount = 0;
        this.blT = new zzd<>();
        this.aWP = comparator == null ? blR : comparator;
    }

    private boolean equal(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private void zza(zzd<K, V> zzd2) {
        int i = 0;
        zzd<K, V> zzd3 = zzd2.bmd;
        zzd<K, V> zzd4 = zzd2.bme;
        zzd<K, V> zzd5 = zzd4.bmd;
        zzd<K, V> zzd6 = zzd4.bme;
        zzd2.bme = zzd5;
        if (zzd5 != null) {
            zzd5.bmc = zzd2;
        }
        zza(zzd2, zzd4);
        zzd4.bmd = zzd2;
        zzd2.bmc = zzd4;
        zzd2.height = Math.max(zzd3 != null ? zzd3.height : 0, zzd5 != null ? zzd5.height : 0) + 1;
        int i2 = zzd2.height;
        if (zzd6 != null) {
            i = zzd6.height;
        }
        zzd4.height = Math.max(i2, i) + 1;
    }

    private void zza(zzd<K, V> zzd2, zzd<K, V> zzd3) {
        zzd<K, V> zzd4 = zzd2.bmc;
        zzd2.bmc = null;
        if (zzd3 != null) {
            zzd3.bmc = zzd4;
        }
        if (zzd4 == null) {
            this.blS = zzd3;
        } else if (zzd4.bmd == zzd2) {
            zzd4.bmd = zzd3;
        } else if ($assertionsDisabled || zzd4.bme == zzd2) {
            zzd4.bme = zzd3;
        } else {
            throw new AssertionError();
        }
    }

    private void zzb(zzd<K, V> zzd2) {
        int i = 0;
        zzd<K, V> zzd3 = zzd2.bmd;
        zzd<K, V> zzd4 = zzd2.bme;
        zzd<K, V> zzd5 = zzd3.bmd;
        zzd<K, V> zzd6 = zzd3.bme;
        zzd2.bmd = zzd6;
        if (zzd6 != null) {
            zzd6.bmc = zzd2;
        }
        zza(zzd2, zzd3);
        zzd3.bme = zzd2;
        zzd2.bmc = zzd3;
        zzd2.height = Math.max(zzd4 != null ? zzd4.height : 0, zzd6 != null ? zzd6.height : 0) + 1;
        int i2 = zzd2.height;
        if (zzd5 != null) {
            i = zzd5.height;
        }
        zzd3.height = Math.max(i2, i) + 1;
    }

    private void zzb(zzd<K, V> zzd2, boolean z) {
        while (zzd2 != null) {
            zzd<K, V> zzd3 = zzd2.bmd;
            zzd<K, V> zzd4 = zzd2.bme;
            int i = zzd3 != null ? zzd3.height : 0;
            int i2 = zzd4 != null ? zzd4.height : 0;
            int i3 = i - i2;
            if (i3 == -2) {
                zzd<K, V> zzd5 = zzd4.bmd;
                zzd<K, V> zzd6 = zzd4.bme;
                int i4 = (zzd5 != null ? zzd5.height : 0) - (zzd6 != null ? zzd6.height : 0);
                if (i4 == -1 || (i4 == 0 && !z)) {
                    zza(zzd2);
                } else if ($assertionsDisabled || i4 == 1) {
                    zzb(zzd4);
                    zza(zzd2);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 2) {
                zzd<K, V> zzd7 = zzd3.bmd;
                zzd<K, V> zzd8 = zzd3.bme;
                int i5 = (zzd7 != null ? zzd7.height : 0) - (zzd8 != null ? zzd8.height : 0);
                if (i5 == 1 || (i5 == 0 && !z)) {
                    zzb(zzd2);
                } else if ($assertionsDisabled || i5 == -1) {
                    zza(zzd3);
                    zzb(zzd2);
                } else {
                    throw new AssertionError();
                }
                if (z) {
                    return;
                }
            } else if (i3 == 0) {
                zzd2.height = i + 1;
                if (z) {
                    return;
                }
            } else if ($assertionsDisabled || i3 == -1 || i3 == 1) {
                zzd2.height = Math.max(i, i2) + 1;
                if (!z) {
                    return;
                }
            } else {
                throw new AssertionError();
            }
            zzd2 = zzd2.bmc;
        }
    }

    public void clear() {
        this.blS = null;
        this.size = 0;
        this.modCount++;
        zzd<K, V> zzd2 = this.blT;
        zzd2.bmf = zzd2;
        zzd2.blZ = zzd2;
    }

    public boolean containsKey(Object obj) {
        return zzcr(obj) != null;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        zza zza2 = this.blU;
        if (zza2 != null) {
            return zza2;
        }
        zza zza3 = new zza();
        this.blU = zza3;
        return zza3;
    }

    public V get(Object obj) {
        zzd zzcr = zzcr(obj);
        if (zzcr != null) {
            return zzcr.value;
        }
        return null;
    }

    public Set<K> keySet() {
        zzb zzb2 = this.blV;
        if (zzb2 != null) {
            return zzb2;
        }
        zzb zzb3 = new zzb();
        this.blV = zzb3;
        return zzb3;
    }

    public V put(K k, V v) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        zzd zza2 = zza(k, true);
        V v2 = zza2.value;
        zza2.value = v;
        return v2;
    }

    public V remove(Object obj) {
        zzd zzcs = zzcs(obj);
        if (zzcs != null) {
            return zzcs.value;
        }
        return null;
    }

    public int size() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public zzd<K, V> zza(K k, boolean z) {
        zzd<K, V> zzd2;
        int i;
        zzd<K, V> zzd3;
        Comparator<? super K> comparator = this.aWP;
        zzd<K, V> zzd4 = this.blS;
        if (zzd4 != null) {
            Comparable comparable = comparator == blR ? (Comparable) k : null;
            while (true) {
                int compareTo = comparable != null ? comparable.compareTo(zzd4.aXd) : comparator.compare(k, zzd4.aXd);
                if (compareTo == 0) {
                    return zzd4;
                }
                zzd<K, V> zzd5 = compareTo < 0 ? zzd4.bmd : zzd4.bme;
                if (zzd5 == null) {
                    int i2 = compareTo;
                    zzd2 = zzd4;
                    i = i2;
                    break;
                }
                zzd4 = zzd5;
            }
        } else {
            zzd2 = zzd4;
            i = 0;
        }
        if (!z) {
            return null;
        }
        zzd<K, V> zzd6 = this.blT;
        if (zzd2 != null) {
            zzd3 = new zzd<>(zzd2, k, zzd6, zzd6.bmf);
            if (i < 0) {
                zzd2.bmd = zzd3;
            } else {
                zzd2.bme = zzd3;
            }
            zzb(zzd2, true);
        } else if (comparator != blR || (k instanceof Comparable)) {
            zzd3 = new zzd<>(zzd2, k, zzd6, zzd6.bmf);
            this.blS = zzd3;
        } else {
            throw new ClassCastException(String.valueOf(k.getClass().getName()).concat(" is not Comparable"));
        }
        this.size++;
        this.modCount++;
        return zzd3;
    }

    /* access modifiers changed from: package-private */
    public void zza(zzd<K, V> zzd2, boolean z) {
        int i;
        int i2 = 0;
        if (z) {
            zzd2.bmf.blZ = zzd2.blZ;
            zzd2.blZ.bmf = zzd2.bmf;
        }
        zzd<K, V> zzd3 = zzd2.bmd;
        zzd<K, V> zzd4 = zzd2.bme;
        zzd<K, V> zzd5 = zzd2.bmc;
        if (zzd3 == null || zzd4 == null) {
            if (zzd3 != null) {
                zza(zzd2, zzd3);
                zzd2.bmd = null;
            } else if (zzd4 != null) {
                zza(zzd2, zzd4);
                zzd2.bme = null;
            } else {
                zza(zzd2, (zzd<K, V>) null);
            }
            zzb(zzd5, false);
            this.size--;
            this.modCount++;
            return;
        }
        zzd<K, V> bk = zzd3.height > zzd4.height ? zzd3.mo8947bk() : zzd4.mo8946bj();
        zza(bk, false);
        zzd<K, V> zzd6 = zzd2.bmd;
        if (zzd6 != null) {
            i = zzd6.height;
            bk.bmd = zzd6;
            zzd6.bmc = bk;
            zzd2.bmd = null;
        } else {
            i = 0;
        }
        zzd<K, V> zzd7 = zzd2.bme;
        if (zzd7 != null) {
            i2 = zzd7.height;
            bk.bme = zzd7;
            zzd7.bmc = bk;
            zzd2.bme = null;
        }
        bk.height = Math.max(i, i2) + 1;
        zza(zzd2, bk);
    }

    /* access modifiers changed from: package-private */
    public zzd<K, V> zzc(Map.Entry<?, ?> entry) {
        zzd<K, V> zzcr = zzcr(entry.getKey());
        if (zzcr != null && equal(zzcr.value, entry.getValue())) {
            return zzcr;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public zzd<K, V> zzcr(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return zza(obj, false);
        } catch (ClassCastException e) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public zzd<K, V> zzcs(Object obj) {
        zzd<K, V> zzcr = zzcr(obj);
        if (zzcr != null) {
            zza(zzcr, true);
        }
        return zzcr;
    }
}
