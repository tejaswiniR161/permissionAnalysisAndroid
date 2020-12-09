package com.google.android.gms.internal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

class zzarh implements Cloneable {
    private zzarf<?, ?> bqB;
    private List<zzarm> bqC = new ArrayList();
    private Object value;

    zzarh() {
    }

    private byte[] toByteArray() throws IOException {
        byte[] bArr = new byte[zzx()];
        zza(zzard.zzbe(bArr));
        return bArr;
    }

    /* renamed from: cS */
    public final zzarh clone() {
        int i = 0;
        zzarh zzarh = new zzarh();
        try {
            zzarh.bqB = this.bqB;
            if (this.bqC == null) {
                zzarh.bqC = null;
            } else {
                zzarh.bqC.addAll(this.bqC);
            }
            if (this.value != null) {
                if (this.value instanceof zzark) {
                    zzarh.value = (zzark) ((zzark) this.value).clone();
                } else if (this.value instanceof byte[]) {
                    zzarh.value = ((byte[]) this.value).clone();
                } else if (this.value instanceof byte[][]) {
                    byte[][] bArr = (byte[][]) this.value;
                    byte[][] bArr2 = new byte[bArr.length][];
                    zzarh.value = bArr2;
                    for (int i2 = 0; i2 < bArr.length; i2++) {
                        bArr2[i2] = (byte[]) bArr[i2].clone();
                    }
                } else if (this.value instanceof boolean[]) {
                    zzarh.value = ((boolean[]) this.value).clone();
                } else if (this.value instanceof int[]) {
                    zzarh.value = ((int[]) this.value).clone();
                } else if (this.value instanceof long[]) {
                    zzarh.value = ((long[]) this.value).clone();
                } else if (this.value instanceof float[]) {
                    zzarh.value = ((float[]) this.value).clone();
                } else if (this.value instanceof double[]) {
                    zzarh.value = ((double[]) this.value).clone();
                } else if (this.value instanceof zzark[]) {
                    zzark[] zzarkArr = (zzark[]) this.value;
                    zzark[] zzarkArr2 = new zzark[zzarkArr.length];
                    zzarh.value = zzarkArr2;
                    while (true) {
                        int i3 = i;
                        if (i3 >= zzarkArr.length) {
                            break;
                        }
                        zzarkArr2[i3] = (zzark) zzarkArr[i3].clone();
                        i = i3 + 1;
                    }
                }
            }
            return zzarh;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzarh)) {
            return false;
        }
        zzarh zzarh = (zzarh) obj;
        if (this.value == null || zzarh.value == null) {
            if (this.bqC != null && zzarh.bqC != null) {
                return this.bqC.equals(zzarh.bqC);
            }
            try {
                return Arrays.equals(toByteArray(), zzarh.toByteArray());
            } catch (IOException e) {
                throw new IllegalStateException(e);
            }
        } else if (this.bqB == zzarh.bqB) {
            return !this.bqB.bhd.isArray() ? this.value.equals(zzarh.value) : this.value instanceof byte[] ? Arrays.equals((byte[]) this.value, (byte[]) zzarh.value) : this.value instanceof int[] ? Arrays.equals((int[]) this.value, (int[]) zzarh.value) : this.value instanceof long[] ? Arrays.equals((long[]) this.value, (long[]) zzarh.value) : this.value instanceof float[] ? Arrays.equals((float[]) this.value, (float[]) zzarh.value) : this.value instanceof double[] ? Arrays.equals((double[]) this.value, (double[]) zzarh.value) : this.value instanceof boolean[] ? Arrays.equals((boolean[]) this.value, (boolean[]) zzarh.value) : Arrays.deepEquals((Object[]) this.value, (Object[]) zzarh.value);
        } else {
            return false;
        }
    }

    public int hashCode() {
        try {
            return Arrays.hashCode(toByteArray()) + 527;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public void zza(zzard zzard) throws IOException {
        if (this.value != null) {
            this.bqB.zza(this.value, zzard);
            return;
        }
        for (zzarm zza : this.bqC) {
            zza.zza(zzard);
        }
    }

    /* access modifiers changed from: package-private */
    public void zza(zzarm zzarm) {
        this.bqC.add(zzarm);
    }

    /* access modifiers changed from: package-private */
    public <T> T zzb(zzarf<?, T> zzarf) {
        if (this.value == null) {
            this.bqB = zzarf;
            this.value = zzarf.zzay(this.bqC);
            this.bqC = null;
        } else if (!this.bqB.equals(zzarf)) {
            throw new IllegalStateException("Tried to getExtension with a different Extension.");
        }
        return this.value;
    }

    /* access modifiers changed from: package-private */
    public int zzx() {
        int i = 0;
        if (this.value != null) {
            return this.bqB.zzcu(this.value);
        }
        Iterator<zzarm> it = this.bqC.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return i2;
            }
            i = it.next().zzx() + i2;
        }
    }
}
