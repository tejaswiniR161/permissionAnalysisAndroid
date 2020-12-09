package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzab;
import java.util.ArrayList;
import java.util.List;

@zziy
public class zzkx {
    private final String[] zzcrz;
    private final double[] zzcsa;
    private final double[] zzcsb;
    private final int[] zzcsc;
    private int zzcsd;

    public static class zza {
        public final int count;
        public final String name;
        public final double zzcse;
        public final double zzcsf;
        public final double zzcsg;

        public zza(String str, double d, double d2, double d3, int i) {
            this.name = str;
            this.zzcsf = d;
            this.zzcse = d2;
            this.zzcsg = d3;
            this.count = i;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            return zzab.equal(this.name, zza.name) && this.zzcse == zza.zzcse && this.zzcsf == zza.zzcsf && this.count == zza.count && Double.compare(this.zzcsg, zza.zzcsg) == 0;
        }

        public int hashCode() {
            return zzab.hashCode(this.name, Double.valueOf(this.zzcse), Double.valueOf(this.zzcsf), Double.valueOf(this.zzcsg), Integer.valueOf(this.count));
        }

        public String toString() {
            return zzab.zzx(this).zzg("name", this.name).zzg("minBound", Double.valueOf(this.zzcsf)).zzg("maxBound", Double.valueOf(this.zzcse)).zzg("percent", Double.valueOf(this.zzcsg)).zzg("count", Integer.valueOf(this.count)).toString();
        }
    }

    public static class zzb {
        /* access modifiers changed from: private */
        public final List<String> zzcsh = new ArrayList();
        /* access modifiers changed from: private */
        public final List<Double> zzcsi = new ArrayList();
        /* access modifiers changed from: private */
        public final List<Double> zzcsj = new ArrayList();

        public zzb zza(String str, double d, double d2) {
            int i;
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.zzcsh.size()) {
                    break;
                }
                double doubleValue = this.zzcsj.get(i).doubleValue();
                double doubleValue2 = this.zzcsi.get(i).doubleValue();
                if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                    break;
                }
                i2 = i + 1;
            }
            this.zzcsh.add(i, str);
            this.zzcsj.add(i, Double.valueOf(d));
            this.zzcsi.add(i, Double.valueOf(d2));
            return this;
        }

        public zzkx zzuw() {
            return new zzkx(this);
        }
    }

    private zzkx(zzb zzb2) {
        int size = zzb2.zzcsi.size();
        this.zzcrz = (String[]) zzb2.zzcsh.toArray(new String[size]);
        this.zzcsa = zzn(zzb2.zzcsi);
        this.zzcsb = zzn(zzb2.zzcsj);
        this.zzcsc = new int[size];
        this.zzcsd = 0;
    }

    private double[] zzn(List<Double> list) {
        double[] dArr = new double[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= dArr.length) {
                return dArr;
            }
            dArr[i2] = list.get(i2).doubleValue();
            i = i2 + 1;
        }
    }

    public List<zza> getBuckets() {
        ArrayList arrayList = new ArrayList(this.zzcrz.length);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.zzcrz.length) {
                return arrayList;
            }
            arrayList.add(new zza(this.zzcrz[i2], this.zzcsb[i2], this.zzcsa[i2], ((double) this.zzcsc[i2]) / ((double) this.zzcsd), this.zzcsc[i2]));
            i = i2 + 1;
        }
    }

    public void zza(double d) {
        this.zzcsd++;
        int i = 0;
        while (i < this.zzcsb.length) {
            if (this.zzcsb[i] <= d && d < this.zzcsa[i]) {
                int[] iArr = this.zzcsc;
                iArr[i] = iArr[i] + 1;
            }
            if (d >= this.zzcsb[i]) {
                i++;
            } else {
                return;
            }
        }
    }
}
