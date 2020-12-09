package com.google.android.gms.internal;

@zziy
public class zzjt {
    public final int errorCode;
    public final String zzbro;
    public final long zzbtj;
    public final String zzcnk;

    public static final class zza {
        /* access modifiers changed from: private */
        public String zzbst;
        /* access modifiers changed from: private */
        public int zzcdb;
        /* access modifiers changed from: private */
        public String zzcnl;
        /* access modifiers changed from: private */
        public long zzcnm;

        public zza zzaz(int i) {
            this.zzcdb = i;
            return this;
        }

        public zza zzcn(String str) {
            this.zzbst = str;
            return this;
        }

        public zza zzco(String str) {
            this.zzcnl = str;
            return this;
        }

        public zza zzl(long j) {
            this.zzcnm = j;
            return this;
        }

        public zzjt zzss() {
            return new zzjt(this);
        }
    }

    private zzjt(zza zza2) {
        this.zzcnk = zza2.zzbst;
        this.zzbro = zza2.zzcnl;
        this.errorCode = zza2.zzcdb;
        this.zzbtj = zza2.zzcnm;
    }
}
