package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class zzf<T> extends AbstractDataBuffer<T> {

    /* renamed from: Ab */
    private boolean f1591Ab = false;

    /* renamed from: Ac */
    private ArrayList<Integer> f1592Ac;

    protected zzf(DataHolder dataHolder) {
        super(dataHolder);
    }

    private void zzati() {
        synchronized (this) {
            if (!this.f1591Ab) {
                int count = this.f1563xi.getCount();
                this.f1592Ac = new ArrayList<>();
                if (count > 0) {
                    this.f1592Ac.add(0);
                    String zzath = zzath();
                    String zzd = this.f1563xi.zzd(zzath, 0, this.f1563xi.zzgb(0));
                    int i = 1;
                    while (i < count) {
                        int zzgb = this.f1563xi.zzgb(i);
                        String zzd2 = this.f1563xi.zzd(zzath, i, zzgb);
                        if (zzd2 == null) {
                            throw new NullPointerException(new StringBuilder(String.valueOf(zzath).length() + 78).append("Missing value for markerColumn: ").append(zzath).append(", at row: ").append(i).append(", for window: ").append(zzgb).toString());
                        }
                        if (!zzd2.equals(zzd)) {
                            this.f1592Ac.add(Integer.valueOf(i));
                        } else {
                            zzd2 = zzd;
                        }
                        i++;
                        zzd = zzd2;
                    }
                }
                this.f1591Ab = true;
            }
        }
    }

    public final T get(int i) {
        zzati();
        return zzl(zzgf(i), zzgg(i));
    }

    public int getCount() {
        zzati();
        return this.f1592Ac.size();
    }

    /* access modifiers changed from: protected */
    public abstract String zzath();

    /* access modifiers changed from: protected */
    public String zzatj() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public int zzgf(int i) {
        if (i >= 0 && i < this.f1592Ac.size()) {
            return this.f1592Ac.get(i).intValue();
        }
        throw new IllegalArgumentException(new StringBuilder(53).append("Position ").append(i).append(" is out of bounds for this buffer").toString());
    }

    /* access modifiers changed from: protected */
    public int zzgg(int i) {
        if (i < 0 || i == this.f1592Ac.size()) {
            return 0;
        }
        int count = i == this.f1592Ac.size() + -1 ? this.f1563xi.getCount() - this.f1592Ac.get(i).intValue() : this.f1592Ac.get(i + 1).intValue() - this.f1592Ac.get(i).intValue();
        if (count != 1) {
            return count;
        }
        int zzgf = zzgf(i);
        int zzgb = this.f1563xi.zzgb(zzgf);
        String zzatj = zzatj();
        if (zzatj == null || this.f1563xi.zzd(zzatj, zzgf, zzgb) != null) {
            return count;
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public abstract T zzl(int i, int i2);
}
