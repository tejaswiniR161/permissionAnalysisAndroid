package com.google.android.gms.internal;

import com.google.android.gms.internal.zzvk;
import java.io.IOException;

public interface zzvl {

    public static final class zza extends zzark {
        private static volatile zza[] ata;
        public Boolean atb;
        public Boolean atc;
        public String name;

        public zza() {
            zzbyx();
        }

        public static zza[] zzbyw() {
            if (ata == null) {
                synchronized (zzari.bqD) {
                    if (ata == null) {
                        ata = new zza[0];
                    }
                }
            }
            return ata;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.name == null) {
                if (zza.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zza.name)) {
                return false;
            }
            if (this.atb == null) {
                if (zza.atb != null) {
                    return false;
                }
            } else if (!this.atb.equals(zza.atb)) {
                return false;
            }
            return this.atc == null ? zza.atc == null : this.atc.equals(zza.atc);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.atb == null ? 0 : this.atb.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.atc != null) {
                i = this.atc.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzard zzard) throws IOException {
            if (this.name != null) {
                zzard.zzr(1, this.name);
            }
            if (this.atb != null) {
                zzard.zzj(2, this.atb.booleanValue());
            }
            if (this.atc != null) {
                zzard.zzj(3, this.atc.booleanValue());
            }
            super.zza(zzard);
        }

        /* renamed from: zzaj */
        public zza zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzarc.readString();
                        continue;
                    case 16:
                        this.atb = Boolean.valueOf(zzarc.mo9094cC());
                        continue;
                    case 24:
                        this.atc = Boolean.valueOf(zzarc.mo9094cC());
                        continue;
                    default:
                        if (!zzarn.zzb(zzarc, cw)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public zza zzbyx() {
            this.name = null;
            this.atb = null;
            this.atc = null;
            this.bqE = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzx() {
            int zzx = super.zzx();
            if (this.name != null) {
                zzx += zzard.zzs(1, this.name);
            }
            if (this.atb != null) {
                zzx += zzard.zzk(2, this.atb.booleanValue());
            }
            return this.atc != null ? zzx + zzard.zzk(3, this.atc.booleanValue()) : zzx;
        }
    }

    public static final class zzb extends zzark {
        public String anQ;
        public Long atd;
        public Integer ate;
        public zzc[] atf;
        public zza[] atg;
        public zzvk.zza[] ath;

        public zzb() {
            zzbyy();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) obj;
            if (this.atd == null) {
                if (zzb.atd != null) {
                    return false;
                }
            } else if (!this.atd.equals(zzb.atd)) {
                return false;
            }
            if (this.anQ == null) {
                if (zzb.anQ != null) {
                    return false;
                }
            } else if (!this.anQ.equals(zzb.anQ)) {
                return false;
            }
            if (this.ate == null) {
                if (zzb.ate != null) {
                    return false;
                }
            } else if (!this.ate.equals(zzb.ate)) {
                return false;
            }
            if (!zzari.equals((Object[]) this.atf, (Object[]) zzb.atf)) {
                return false;
            }
            if (!zzari.equals((Object[]) this.atg, (Object[]) zzb.atg)) {
                return false;
            }
            return zzari.equals((Object[]) this.ath, (Object[]) zzb.ath);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.anQ == null ? 0 : this.anQ.hashCode()) + (((this.atd == null ? 0 : this.atd.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.ate != null) {
                i = this.ate.hashCode();
            }
            return ((((((hashCode + i) * 31) + zzari.hashCode((Object[]) this.atf)) * 31) + zzari.hashCode((Object[]) this.atg)) * 31) + zzari.hashCode((Object[]) this.ath);
        }

        public void zza(zzard zzard) throws IOException {
            if (this.atd != null) {
                zzard.zzb(1, this.atd.longValue());
            }
            if (this.anQ != null) {
                zzard.zzr(2, this.anQ);
            }
            if (this.ate != null) {
                zzard.zzae(3, this.ate.intValue());
            }
            if (this.atf != null && this.atf.length > 0) {
                for (zzc zzc : this.atf) {
                    if (zzc != null) {
                        zzard.zza(4, (zzark) zzc);
                    }
                }
            }
            if (this.atg != null && this.atg.length > 0) {
                for (zza zza : this.atg) {
                    if (zza != null) {
                        zzard.zza(5, (zzark) zza);
                    }
                }
            }
            if (this.ath != null && this.ath.length > 0) {
                for (zzvk.zza zza2 : this.ath) {
                    if (zza2 != null) {
                        zzard.zza(6, (zzark) zza2);
                    }
                }
            }
            super.zza(zzard);
        }

        /* renamed from: zzak */
        public zzb zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 8:
                        this.atd = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 18:
                        this.anQ = zzarc.readString();
                        continue;
                    case 24:
                        this.ate = Integer.valueOf(zzarc.mo9092cA());
                        continue;
                    case 34:
                        int zzc = zzarn.zzc(zzarc, 34);
                        int length = this.atf == null ? 0 : this.atf.length;
                        zzc[] zzcArr = new zzc[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.atf, 0, zzcArr, 0, length);
                        }
                        while (length < zzcArr.length - 1) {
                            zzcArr[length] = new zzc();
                            zzarc.zza(zzcArr[length]);
                            zzarc.mo9104cw();
                            length++;
                        }
                        zzcArr[length] = new zzc();
                        zzarc.zza(zzcArr[length]);
                        this.atf = zzcArr;
                        continue;
                    case 42:
                        int zzc2 = zzarn.zzc(zzarc, 42);
                        int length2 = this.atg == null ? 0 : this.atg.length;
                        zza[] zzaArr = new zza[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.atg, 0, zzaArr, 0, length2);
                        }
                        while (length2 < zzaArr.length - 1) {
                            zzaArr[length2] = new zza();
                            zzarc.zza(zzaArr[length2]);
                            zzarc.mo9104cw();
                            length2++;
                        }
                        zzaArr[length2] = new zza();
                        zzarc.zza(zzaArr[length2]);
                        this.atg = zzaArr;
                        continue;
                    case 50:
                        int zzc3 = zzarn.zzc(zzarc, 50);
                        int length3 = this.ath == null ? 0 : this.ath.length;
                        zzvk.zza[] zzaArr2 = new zzvk.zza[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.ath, 0, zzaArr2, 0, length3);
                        }
                        while (length3 < zzaArr2.length - 1) {
                            zzaArr2[length3] = new zzvk.zza();
                            zzarc.zza(zzaArr2[length3]);
                            zzarc.mo9104cw();
                            length3++;
                        }
                        zzaArr2[length3] = new zzvk.zza();
                        zzarc.zza(zzaArr2[length3]);
                        this.ath = zzaArr2;
                        continue;
                    default:
                        if (!zzarn.zzb(zzarc, cw)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public zzb zzbyy() {
            this.atd = null;
            this.anQ = null;
            this.ate = null;
            this.atf = zzc.zzbyz();
            this.atg = zza.zzbyw();
            this.ath = zzvk.zza.zzbym();
            this.bqE = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzx() {
            int zzx = super.zzx();
            if (this.atd != null) {
                zzx += zzard.zzf(1, this.atd.longValue());
            }
            if (this.anQ != null) {
                zzx += zzard.zzs(2, this.anQ);
            }
            if (this.ate != null) {
                zzx += zzard.zzag(3, this.ate.intValue());
            }
            if (this.atf != null && this.atf.length > 0) {
                int i = zzx;
                for (zzc zzc : this.atf) {
                    if (zzc != null) {
                        i += zzard.zzc(4, (zzark) zzc);
                    }
                }
                zzx = i;
            }
            if (this.atg != null && this.atg.length > 0) {
                int i2 = zzx;
                for (zza zza : this.atg) {
                    if (zza != null) {
                        i2 += zzard.zzc(5, (zzark) zza);
                    }
                }
                zzx = i2;
            }
            if (this.ath != null && this.ath.length > 0) {
                for (zzvk.zza zza2 : this.ath) {
                    if (zza2 != null) {
                        zzx += zzard.zzc(6, (zzark) zza2);
                    }
                }
            }
            return zzx;
        }
    }

    public static final class zzc extends zzark {
        private static volatile zzc[] ati;
        public String value;
        public String zzcb;

        public zzc() {
            zzbza();
        }

        public static zzc[] zzbyz() {
            if (ati == null) {
                synchronized (zzari.bqD) {
                    if (ati == null) {
                        ati = new zzc[0];
                    }
                }
            }
            return ati;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) obj;
            if (this.zzcb == null) {
                if (zzc.zzcb != null) {
                    return false;
                }
            } else if (!this.zzcb.equals(zzc.zzcb)) {
                return false;
            }
            return this.value == null ? zzc.value == null : this.value.equals(zzc.value);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.zzcb == null ? 0 : this.zzcb.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31;
            if (this.value != null) {
                i = this.value.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzard zzard) throws IOException {
            if (this.zzcb != null) {
                zzard.zzr(1, this.zzcb);
            }
            if (this.value != null) {
                zzard.zzr(2, this.value);
            }
            super.zza(zzard);
        }

        /* renamed from: zzal */
        public zzc zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 10:
                        this.zzcb = zzarc.readString();
                        continue;
                    case 18:
                        this.value = zzarc.readString();
                        continue;
                    default:
                        if (!zzarn.zzb(zzarc, cw)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        public zzc zzbza() {
            this.zzcb = null;
            this.value = null;
            this.bqE = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzx() {
            int zzx = super.zzx();
            if (this.zzcb != null) {
                zzx += zzard.zzs(1, this.zzcb);
            }
            return this.value != null ? zzx + zzard.zzs(2, this.value) : zzx;
        }
    }
}
