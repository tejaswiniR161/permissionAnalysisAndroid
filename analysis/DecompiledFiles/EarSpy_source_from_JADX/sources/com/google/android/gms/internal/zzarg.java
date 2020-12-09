package com.google.android.gms.internal;

public final class zzarg implements Cloneable {
    private static final zzarh bqx = new zzarh();
    private zzarh[] bqA;
    private boolean bqy;
    private int[] bqz;
    private int mSize;

    zzarg() {
        this(10);
    }

    zzarg(int i) {
        this.bqy = false;
        int idealIntArraySize = idealIntArraySize(i);
        this.bqz = new int[idealIntArraySize];
        this.bqA = new zzarh[idealIntArraySize];
        this.mSize = 0;
    }

    private int idealByteArraySize(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            if (i <= (1 << i2) - 12) {
                return (1 << i2) - 12;
            }
        }
        return i;
    }

    private int idealIntArraySize(int i) {
        return idealByteArraySize(i * 4) / 4;
    }

    private boolean zza(int[] iArr, int[] iArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (iArr[i2] != iArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    private boolean zza(zzarh[] zzarhArr, zzarh[] zzarhArr2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (!zzarhArr[i2].equals(zzarhArr2[i2])) {
                return false;
            }
        }
        return true;
    }

    private int zzahs(int i) {
        int i2 = 0;
        int i3 = this.mSize - 1;
        while (i2 <= i3) {
            int i4 = (i2 + i3) >>> 1;
            int i5 = this.bqz[i4];
            if (i5 < i) {
                i2 = i4 + 1;
            } else if (i5 <= i) {
                return i4;
            } else {
                i3 = i4 - 1;
            }
        }
        return i2 ^ -1;
    }

    /* renamed from: cR */
    public final zzarg clone() {
        int size = size();
        zzarg zzarg = new zzarg(size);
        System.arraycopy(this.bqz, 0, zzarg.bqz, 0, size);
        for (int i = 0; i < size; i++) {
            if (this.bqA[i] != null) {
                zzarg.bqA[i] = (zzarh) this.bqA[i].clone();
            }
        }
        zzarg.mSize = size;
        return zzarg;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzarg)) {
            return false;
        }
        zzarg zzarg = (zzarg) obj;
        if (size() != zzarg.size()) {
            return false;
        }
        return zza(this.bqz, zzarg.bqz, this.mSize) && zza(this.bqA, zzarg.bqA, this.mSize);
    }

    public int hashCode() {
        int i = 17;
        for (int i2 = 0; i2 < this.mSize; i2++) {
            i = (((i * 31) + this.bqz[i2]) * 31) + this.bqA[i2].hashCode();
        }
        return i;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    /* access modifiers changed from: package-private */
    public int size() {
        return this.mSize;
    }

    /* access modifiers changed from: package-private */
    public void zza(int i, zzarh zzarh) {
        int zzahs = zzahs(i);
        if (zzahs >= 0) {
            this.bqA[zzahs] = zzarh;
            return;
        }
        int i2 = zzahs ^ -1;
        if (i2 >= this.mSize || this.bqA[i2] != bqx) {
            if (this.mSize >= this.bqz.length) {
                int idealIntArraySize = idealIntArraySize(this.mSize + 1);
                int[] iArr = new int[idealIntArraySize];
                zzarh[] zzarhArr = new zzarh[idealIntArraySize];
                System.arraycopy(this.bqz, 0, iArr, 0, this.bqz.length);
                System.arraycopy(this.bqA, 0, zzarhArr, 0, this.bqA.length);
                this.bqz = iArr;
                this.bqA = zzarhArr;
            }
            if (this.mSize - i2 != 0) {
                System.arraycopy(this.bqz, i2, this.bqz, i2 + 1, this.mSize - i2);
                System.arraycopy(this.bqA, i2, this.bqA, i2 + 1, this.mSize - i2);
            }
            this.bqz[i2] = i;
            this.bqA[i2] = zzarh;
            this.mSize++;
            return;
        }
        this.bqz[i2] = i;
        this.bqA[i2] = zzarh;
    }

    /* access modifiers changed from: package-private */
    public zzarh zzahq(int i) {
        int zzahs = zzahs(i);
        if (zzahs < 0 || this.bqA[zzahs] == bqx) {
            return null;
        }
        return this.bqA[zzahs];
    }

    /* access modifiers changed from: package-private */
    public zzarh zzahr(int i) {
        return this.bqA[i];
    }
}
