package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzapc implements zzaou, Cloneable {
    public static final zzapc blF = new zzapc();
    private double blG = -1.0d;
    private int blH = 136;
    private boolean blI = true;
    private List<zzanx> blJ = Collections.emptyList();
    private List<zzanx> blK = Collections.emptyList();

    private boolean zza(zzaox zzaox) {
        return zzaox == null || zzaox.mo8882bf() <= this.blG;
    }

    private boolean zza(zzaox zzaox, zzaoy zzaoy) {
        return zza(zzaox) && zza(zzaoy);
    }

    private boolean zza(zzaoy zzaoy) {
        return zzaoy == null || zzaoy.mo8883bf() > this.blG;
    }

    private boolean zzm(Class<?> cls) {
        return !Enum.class.isAssignableFrom(cls) && (cls.isAnonymousClass() || cls.isLocalClass());
    }

    private boolean zzn(Class<?> cls) {
        return cls.isMemberClass() && !zzo(cls);
    }

    private boolean zzo(Class<?> cls) {
        return (cls.getModifiers() & 8) != 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: bh */
    public zzapc clone() {
        try {
            return (zzapc) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public <T> zzaot<T> zza(zzaob zzaob, zzapx<T> zzapx) {
        Class<? super T> by = zzapx.mo9067by();
        final boolean zza = zza((Class<?>) by, true);
        final boolean zza2 = zza((Class<?>) by, false);
        if (!zza && !zza2) {
            return null;
        }
        final zzaob zzaob2 = zzaob;
        final zzapx<T> zzapx2 = zzapx;
        return new zzaot<T>() {
            private zzaot<T> bkU;

            /* renamed from: bd */
            private zzaot<T> m1394bd() {
                zzaot<T> zzaot = this.bkU;
                if (zzaot != null) {
                    return zzaot;
                }
                zzaot<T> zza = zzaob2.zza((zzaou) zzapc.this, zzapx2);
                this.bkU = zza;
                return zza;
            }

            public void zza(zzaqa zzaqa, T t) throws IOException {
                if (zza) {
                    zzaqa.mo8990bx();
                } else {
                    m1394bd().zza(zzaqa, t);
                }
            }

            public T zzb(zzapy zzapy) throws IOException {
                if (!zza2) {
                    return m1394bd().zzb(zzapy);
                }
                zzapy.skipValue();
                return null;
            }
        };
    }

    public zzapc zza(zzanx zzanx, boolean z, boolean z2) {
        zzapc bh = clone();
        if (z) {
            bh.blJ = new ArrayList(this.blJ);
            bh.blJ.add(zzanx);
        }
        if (z2) {
            bh.blK = new ArrayList(this.blK);
            bh.blK.add(zzanx);
        }
        return bh;
    }

    public boolean zza(Class<?> cls, boolean z) {
        if (this.blG != -1.0d && !zza((zzaox) cls.getAnnotation(zzaox.class), (zzaoy) cls.getAnnotation(zzaoy.class))) {
            return true;
        }
        if (!this.blI && zzn(cls)) {
            return true;
        }
        if (zzm(cls)) {
            return true;
        }
        for (zzanx zzh : z ? this.blJ : this.blK) {
            if (zzh.zzh(cls)) {
                return true;
            }
        }
        return false;
    }

    public boolean zza(Field field, boolean z) {
        if ((this.blH & field.getModifiers()) != 0) {
            return true;
        }
        if (this.blG != -1.0d && !zza((zzaox) field.getAnnotation(zzaox.class), (zzaoy) field.getAnnotation(zzaoy.class))) {
            return true;
        }
        if (field.isSynthetic()) {
            return true;
        }
        if (!this.blI && zzn(field.getType())) {
            return true;
        }
        if (zzm(field.getType())) {
            return true;
        }
        List<zzanx> list = z ? this.blJ : this.blK;
        if (!list.isEmpty()) {
            zzany zzany = new zzany(field);
            for (zzanx zza : list) {
                if (zza.zza(zzany)) {
                    return true;
                }
            }
        }
        return false;
    }

    public zzapc zzg(int... iArr) {
        zzapc bh = clone();
        bh.blH = 0;
        for (int i : iArr) {
            bh.blH = i | bh.blH;
        }
        return bh;
    }
}
