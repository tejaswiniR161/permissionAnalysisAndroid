package com.google.android.gms.internal;

import android.support.p000v4.media.TransportMediator;
import java.io.IOException;

public interface zzvm {

    public static final class zza extends zzark {
        private static volatile zza[] atj;
        public Integer asA;
        public zzf atk;
        public zzf atl;
        public Boolean atm;

        public zza() {
            zzbzc();
        }

        public static zza[] zzbzb() {
            if (atj == null) {
                synchronized (zzari.bqD) {
                    if (atj == null) {
                        atj = new zza[0];
                    }
                }
            }
            return atj;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.asA == null) {
                if (zza.asA != null) {
                    return false;
                }
            } else if (!this.asA.equals(zza.asA)) {
                return false;
            }
            if (this.atk == null) {
                if (zza.atk != null) {
                    return false;
                }
            } else if (!this.atk.equals(zza.atk)) {
                return false;
            }
            if (this.atl == null) {
                if (zza.atl != null) {
                    return false;
                }
            } else if (!this.atl.equals(zza.atl)) {
                return false;
            }
            return this.atm == null ? zza.atm == null : this.atm.equals(zza.atm);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.atl == null ? 0 : this.atl.hashCode()) + (((this.atk == null ? 0 : this.atk.hashCode()) + (((this.asA == null ? 0 : this.asA.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (this.atm != null) {
                i = this.atm.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzard zzard) throws IOException {
            if (this.asA != null) {
                zzard.zzae(1, this.asA.intValue());
            }
            if (this.atk != null) {
                zzard.zza(2, (zzark) this.atk);
            }
            if (this.atl != null) {
                zzard.zza(3, (zzark) this.atl);
            }
            if (this.atm != null) {
                zzard.zzj(4, this.atm.booleanValue());
            }
            super.zza(zzard);
        }

        /* renamed from: zzam */
        public zza zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 8:
                        this.asA = Integer.valueOf(zzarc.mo9092cA());
                        continue;
                    case 18:
                        if (this.atk == null) {
                            this.atk = new zzf();
                        }
                        zzarc.zza(this.atk);
                        continue;
                    case 26:
                        if (this.atl == null) {
                            this.atl = new zzf();
                        }
                        zzarc.zza(this.atl);
                        continue;
                    case 32:
                        this.atm = Boolean.valueOf(zzarc.mo9094cC());
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

        public zza zzbzc() {
            this.asA = null;
            this.atk = null;
            this.atl = null;
            this.atm = null;
            this.bqE = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzx() {
            int zzx = super.zzx();
            if (this.asA != null) {
                zzx += zzard.zzag(1, this.asA.intValue());
            }
            if (this.atk != null) {
                zzx += zzard.zzc(2, (zzark) this.atk);
            }
            if (this.atl != null) {
                zzx += zzard.zzc(3, (zzark) this.atl);
            }
            return this.atm != null ? zzx + zzard.zzk(4, this.atm.booleanValue()) : zzx;
        }
    }

    public static final class zzb extends zzark {
        private static volatile zzb[] atn;
        public zzc[] ato;
        public Long atp;
        public Long atq;
        public Integer count;
        public String name;

        public zzb() {
            zzbze();
        }

        public static zzb[] zzbzd() {
            if (atn == null) {
                synchronized (zzari.bqD) {
                    if (atn == null) {
                        atn = new zzb[0];
                    }
                }
            }
            return atn;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) obj;
            if (!zzari.equals((Object[]) this.ato, (Object[]) zzb.ato)) {
                return false;
            }
            if (this.name == null) {
                if (zzb.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzb.name)) {
                return false;
            }
            if (this.atp == null) {
                if (zzb.atp != null) {
                    return false;
                }
            } else if (!this.atp.equals(zzb.atp)) {
                return false;
            }
            if (this.atq == null) {
                if (zzb.atq != null) {
                    return false;
                }
            } else if (!this.atq.equals(zzb.atq)) {
                return false;
            }
            return this.count == null ? zzb.count == null : this.count.equals(zzb.count);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.atq == null ? 0 : this.atq.hashCode()) + (((this.atp == null ? 0 : this.atp.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + zzari.hashCode((Object[]) this.ato)) * 31)) * 31)) * 31)) * 31;
            if (this.count != null) {
                i = this.count.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzard zzard) throws IOException {
            if (this.ato != null && this.ato.length > 0) {
                for (zzc zzc : this.ato) {
                    if (zzc != null) {
                        zzard.zza(1, (zzark) zzc);
                    }
                }
            }
            if (this.name != null) {
                zzard.zzr(2, this.name);
            }
            if (this.atp != null) {
                zzard.zzb(3, this.atp.longValue());
            }
            if (this.atq != null) {
                zzard.zzb(4, this.atq.longValue());
            }
            if (this.count != null) {
                zzard.zzae(5, this.count.intValue());
            }
            super.zza(zzard);
        }

        /* renamed from: zzan */
        public zzb zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzarn.zzc(zzarc, 10);
                        int length = this.ato == null ? 0 : this.ato.length;
                        zzc[] zzcArr = new zzc[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.ato, 0, zzcArr, 0, length);
                        }
                        while (length < zzcArr.length - 1) {
                            zzcArr[length] = new zzc();
                            zzarc.zza(zzcArr[length]);
                            zzarc.mo9104cw();
                            length++;
                        }
                        zzcArr[length] = new zzc();
                        zzarc.zza(zzcArr[length]);
                        this.ato = zzcArr;
                        continue;
                    case 18:
                        this.name = zzarc.readString();
                        continue;
                    case 24:
                        this.atp = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 32:
                        this.atq = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 40:
                        this.count = Integer.valueOf(zzarc.mo9092cA());
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

        public zzb zzbze() {
            this.ato = zzc.zzbzf();
            this.name = null;
            this.atp = null;
            this.atq = null;
            this.count = null;
            this.bqE = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzx() {
            int zzx = super.zzx();
            if (this.ato != null && this.ato.length > 0) {
                for (zzc zzc : this.ato) {
                    if (zzc != null) {
                        zzx += zzard.zzc(1, (zzark) zzc);
                    }
                }
            }
            if (this.name != null) {
                zzx += zzard.zzs(2, this.name);
            }
            if (this.atp != null) {
                zzx += zzard.zzf(3, this.atp.longValue());
            }
            if (this.atq != null) {
                zzx += zzard.zzf(4, this.atq.longValue());
            }
            return this.count != null ? zzx + zzard.zzag(5, this.count.intValue()) : zzx;
        }
    }

    public static final class zzc extends zzark {
        private static volatile zzc[] atr;

        /* renamed from: Dr */
        public String f2261Dr;
        public Float asw;
        public Double asx;
        public Long ats;
        public String name;

        public zzc() {
            zzbzg();
        }

        public static zzc[] zzbzf() {
            if (atr == null) {
                synchronized (zzari.bqD) {
                    if (atr == null) {
                        atr = new zzc[0];
                    }
                }
            }
            return atr;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) obj;
            if (this.name == null) {
                if (zzc.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzc.name)) {
                return false;
            }
            if (this.f2261Dr == null) {
                if (zzc.f2261Dr != null) {
                    return false;
                }
            } else if (!this.f2261Dr.equals(zzc.f2261Dr)) {
                return false;
            }
            if (this.ats == null) {
                if (zzc.ats != null) {
                    return false;
                }
            } else if (!this.ats.equals(zzc.ats)) {
                return false;
            }
            if (this.asw == null) {
                if (zzc.asw != null) {
                    return false;
                }
            } else if (!this.asw.equals(zzc.asw)) {
                return false;
            }
            return this.asx == null ? zzc.asx == null : this.asx.equals(zzc.asx);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.asw == null ? 0 : this.asw.hashCode()) + (((this.ats == null ? 0 : this.ats.hashCode()) + (((this.f2261Dr == null ? 0 : this.f2261Dr.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.asx != null) {
                i = this.asx.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzard zzard) throws IOException {
            if (this.name != null) {
                zzard.zzr(1, this.name);
            }
            if (this.f2261Dr != null) {
                zzard.zzr(2, this.f2261Dr);
            }
            if (this.ats != null) {
                zzard.zzb(3, this.ats.longValue());
            }
            if (this.asw != null) {
                zzard.zzc(4, this.asw.floatValue());
            }
            if (this.asx != null) {
                zzard.zza(5, this.asx.doubleValue());
            }
            super.zza(zzard);
        }

        /* renamed from: zzao */
        public zzc zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 10:
                        this.name = zzarc.readString();
                        continue;
                    case 18:
                        this.f2261Dr = zzarc.readString();
                        continue;
                    case 24:
                        this.ats = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 37:
                        this.asw = Float.valueOf(zzarc.readFloat());
                        continue;
                    case 41:
                        this.asx = Double.valueOf(zzarc.readDouble());
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

        public zzc zzbzg() {
            this.name = null;
            this.f2261Dr = null;
            this.ats = null;
            this.asw = null;
            this.asx = null;
            this.bqE = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzx() {
            int zzx = super.zzx();
            if (this.name != null) {
                zzx += zzard.zzs(1, this.name);
            }
            if (this.f2261Dr != null) {
                zzx += zzard.zzs(2, this.f2261Dr);
            }
            if (this.ats != null) {
                zzx += zzard.zzf(3, this.ats.longValue());
            }
            if (this.asw != null) {
                zzx += zzard.zzd(4, this.asw.floatValue());
            }
            return this.asx != null ? zzx + zzard.zzb(5, this.asx.doubleValue()) : zzx;
        }
    }

    public static final class zzd extends zzark {
        public zze[] att;

        public zzd() {
            zzbzh();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            return zzari.equals((Object[]) this.att, (Object[]) ((zzd) obj).att);
        }

        public int hashCode() {
            return ((getClass().getName().hashCode() + 527) * 31) + zzari.hashCode((Object[]) this.att);
        }

        public void zza(zzard zzard) throws IOException {
            if (this.att != null && this.att.length > 0) {
                for (zze zze : this.att) {
                    if (zze != null) {
                        zzard.zza(1, (zzark) zze);
                    }
                }
            }
            super.zza(zzard);
        }

        /* renamed from: zzap */
        public zzd zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzarn.zzc(zzarc, 10);
                        int length = this.att == null ? 0 : this.att.length;
                        zze[] zzeArr = new zze[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.att, 0, zzeArr, 0, length);
                        }
                        while (length < zzeArr.length - 1) {
                            zzeArr[length] = new zze();
                            zzarc.zza(zzeArr[length]);
                            zzarc.mo9104cw();
                            length++;
                        }
                        zzeArr[length] = new zze();
                        zzarc.zza(zzeArr[length]);
                        this.att = zzeArr;
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

        public zzd zzbzh() {
            this.att = zze.zzbzi();
            this.bqE = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzx() {
            int zzx = super.zzx();
            if (this.att != null && this.att.length > 0) {
                for (zze zze : this.att) {
                    if (zze != null) {
                        zzx += zzard.zzc(1, (zzark) zze);
                    }
                }
            }
            return zzx;
        }
    }

    public static final class zze extends zzark {
        private static volatile zze[] atu;
        public String afY;
        public String anQ;
        public String anR;
        public String anU;
        public String anY;
        public Long atA;
        public Long atB;
        public Long atC;
        public String atD;
        public String atE;
        public String atF;
        public Integer atG;
        public Long atH;
        public Long atI;
        public String atJ;
        public Boolean atK;
        public String atL;
        public Long atM;
        public Integer atN;
        public Boolean atO;
        public zza[] atP;
        public Integer atQ;
        public Integer atR;
        public Integer atS;
        public String atT;
        public Integer atv;
        public zzb[] atw;
        public zzg[] atx;
        public Long aty;
        public Long atz;
        public String zzck;
        public String zzct;

        public zze() {
            zzbzj();
        }

        public static zze[] zzbzi() {
            if (atu == null) {
                synchronized (zzari.bqD) {
                    if (atu == null) {
                        atu = new zze[0];
                    }
                }
            }
            return atu;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zze = (zze) obj;
            if (this.atv == null) {
                if (zze.atv != null) {
                    return false;
                }
            } else if (!this.atv.equals(zze.atv)) {
                return false;
            }
            if (!zzari.equals((Object[]) this.atw, (Object[]) zze.atw)) {
                return false;
            }
            if (!zzari.equals((Object[]) this.atx, (Object[]) zze.atx)) {
                return false;
            }
            if (this.aty == null) {
                if (zze.aty != null) {
                    return false;
                }
            } else if (!this.aty.equals(zze.aty)) {
                return false;
            }
            if (this.atz == null) {
                if (zze.atz != null) {
                    return false;
                }
            } else if (!this.atz.equals(zze.atz)) {
                return false;
            }
            if (this.atA == null) {
                if (zze.atA != null) {
                    return false;
                }
            } else if (!this.atA.equals(zze.atA)) {
                return false;
            }
            if (this.atB == null) {
                if (zze.atB != null) {
                    return false;
                }
            } else if (!this.atB.equals(zze.atB)) {
                return false;
            }
            if (this.atC == null) {
                if (zze.atC != null) {
                    return false;
                }
            } else if (!this.atC.equals(zze.atC)) {
                return false;
            }
            if (this.atD == null) {
                if (zze.atD != null) {
                    return false;
                }
            } else if (!this.atD.equals(zze.atD)) {
                return false;
            }
            if (this.zzct == null) {
                if (zze.zzct != null) {
                    return false;
                }
            } else if (!this.zzct.equals(zze.zzct)) {
                return false;
            }
            if (this.atE == null) {
                if (zze.atE != null) {
                    return false;
                }
            } else if (!this.atE.equals(zze.atE)) {
                return false;
            }
            if (this.atF == null) {
                if (zze.atF != null) {
                    return false;
                }
            } else if (!this.atF.equals(zze.atF)) {
                return false;
            }
            if (this.atG == null) {
                if (zze.atG != null) {
                    return false;
                }
            } else if (!this.atG.equals(zze.atG)) {
                return false;
            }
            if (this.anR == null) {
                if (zze.anR != null) {
                    return false;
                }
            } else if (!this.anR.equals(zze.anR)) {
                return false;
            }
            if (this.zzck == null) {
                if (zze.zzck != null) {
                    return false;
                }
            } else if (!this.zzck.equals(zze.zzck)) {
                return false;
            }
            if (this.afY == null) {
                if (zze.afY != null) {
                    return false;
                }
            } else if (!this.afY.equals(zze.afY)) {
                return false;
            }
            if (this.atH == null) {
                if (zze.atH != null) {
                    return false;
                }
            } else if (!this.atH.equals(zze.atH)) {
                return false;
            }
            if (this.atI == null) {
                if (zze.atI != null) {
                    return false;
                }
            } else if (!this.atI.equals(zze.atI)) {
                return false;
            }
            if (this.atJ == null) {
                if (zze.atJ != null) {
                    return false;
                }
            } else if (!this.atJ.equals(zze.atJ)) {
                return false;
            }
            if (this.atK == null) {
                if (zze.atK != null) {
                    return false;
                }
            } else if (!this.atK.equals(zze.atK)) {
                return false;
            }
            if (this.atL == null) {
                if (zze.atL != null) {
                    return false;
                }
            } else if (!this.atL.equals(zze.atL)) {
                return false;
            }
            if (this.atM == null) {
                if (zze.atM != null) {
                    return false;
                }
            } else if (!this.atM.equals(zze.atM)) {
                return false;
            }
            if (this.atN == null) {
                if (zze.atN != null) {
                    return false;
                }
            } else if (!this.atN.equals(zze.atN)) {
                return false;
            }
            if (this.anU == null) {
                if (zze.anU != null) {
                    return false;
                }
            } else if (!this.anU.equals(zze.anU)) {
                return false;
            }
            if (this.anQ == null) {
                if (zze.anQ != null) {
                    return false;
                }
            } else if (!this.anQ.equals(zze.anQ)) {
                return false;
            }
            if (this.atO == null) {
                if (zze.atO != null) {
                    return false;
                }
            } else if (!this.atO.equals(zze.atO)) {
                return false;
            }
            if (!zzari.equals((Object[]) this.atP, (Object[]) zze.atP)) {
                return false;
            }
            if (this.anY == null) {
                if (zze.anY != null) {
                    return false;
                }
            } else if (!this.anY.equals(zze.anY)) {
                return false;
            }
            if (this.atQ == null) {
                if (zze.atQ != null) {
                    return false;
                }
            } else if (!this.atQ.equals(zze.atQ)) {
                return false;
            }
            if (this.atR == null) {
                if (zze.atR != null) {
                    return false;
                }
            } else if (!this.atR.equals(zze.atR)) {
                return false;
            }
            if (this.atS == null) {
                if (zze.atS != null) {
                    return false;
                }
            } else if (!this.atS.equals(zze.atS)) {
                return false;
            }
            return this.atT == null ? zze.atT == null : this.atT.equals(zze.atT);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.atS == null ? 0 : this.atS.hashCode()) + (((this.atR == null ? 0 : this.atR.hashCode()) + (((this.atQ == null ? 0 : this.atQ.hashCode()) + (((this.anY == null ? 0 : this.anY.hashCode()) + (((((this.atO == null ? 0 : this.atO.hashCode()) + (((this.anQ == null ? 0 : this.anQ.hashCode()) + (((this.anU == null ? 0 : this.anU.hashCode()) + (((this.atN == null ? 0 : this.atN.hashCode()) + (((this.atM == null ? 0 : this.atM.hashCode()) + (((this.atL == null ? 0 : this.atL.hashCode()) + (((this.atK == null ? 0 : this.atK.hashCode()) + (((this.atJ == null ? 0 : this.atJ.hashCode()) + (((this.atI == null ? 0 : this.atI.hashCode()) + (((this.atH == null ? 0 : this.atH.hashCode()) + (((this.afY == null ? 0 : this.afY.hashCode()) + (((this.zzck == null ? 0 : this.zzck.hashCode()) + (((this.anR == null ? 0 : this.anR.hashCode()) + (((this.atG == null ? 0 : this.atG.hashCode()) + (((this.atF == null ? 0 : this.atF.hashCode()) + (((this.atE == null ? 0 : this.atE.hashCode()) + (((this.zzct == null ? 0 : this.zzct.hashCode()) + (((this.atD == null ? 0 : this.atD.hashCode()) + (((this.atC == null ? 0 : this.atC.hashCode()) + (((this.atB == null ? 0 : this.atB.hashCode()) + (((this.atA == null ? 0 : this.atA.hashCode()) + (((this.atz == null ? 0 : this.atz.hashCode()) + (((this.aty == null ? 0 : this.aty.hashCode()) + (((((((this.atv == null ? 0 : this.atv.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzari.hashCode((Object[]) this.atw)) * 31) + zzari.hashCode((Object[]) this.atx)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31) + zzari.hashCode((Object[]) this.atP)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.atT != null) {
                i = this.atT.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzard zzard) throws IOException {
            if (this.atv != null) {
                zzard.zzae(1, this.atv.intValue());
            }
            if (this.atw != null && this.atw.length > 0) {
                for (zzb zzb : this.atw) {
                    if (zzb != null) {
                        zzard.zza(2, (zzark) zzb);
                    }
                }
            }
            if (this.atx != null && this.atx.length > 0) {
                for (zzg zzg : this.atx) {
                    if (zzg != null) {
                        zzard.zza(3, (zzark) zzg);
                    }
                }
            }
            if (this.aty != null) {
                zzard.zzb(4, this.aty.longValue());
            }
            if (this.atz != null) {
                zzard.zzb(5, this.atz.longValue());
            }
            if (this.atA != null) {
                zzard.zzb(6, this.atA.longValue());
            }
            if (this.atC != null) {
                zzard.zzb(7, this.atC.longValue());
            }
            if (this.atD != null) {
                zzard.zzr(8, this.atD);
            }
            if (this.zzct != null) {
                zzard.zzr(9, this.zzct);
            }
            if (this.atE != null) {
                zzard.zzr(10, this.atE);
            }
            if (this.atF != null) {
                zzard.zzr(11, this.atF);
            }
            if (this.atG != null) {
                zzard.zzae(12, this.atG.intValue());
            }
            if (this.anR != null) {
                zzard.zzr(13, this.anR);
            }
            if (this.zzck != null) {
                zzard.zzr(14, this.zzck);
            }
            if (this.afY != null) {
                zzard.zzr(16, this.afY);
            }
            if (this.atH != null) {
                zzard.zzb(17, this.atH.longValue());
            }
            if (this.atI != null) {
                zzard.zzb(18, this.atI.longValue());
            }
            if (this.atJ != null) {
                zzard.zzr(19, this.atJ);
            }
            if (this.atK != null) {
                zzard.zzj(20, this.atK.booleanValue());
            }
            if (this.atL != null) {
                zzard.zzr(21, this.atL);
            }
            if (this.atM != null) {
                zzard.zzb(22, this.atM.longValue());
            }
            if (this.atN != null) {
                zzard.zzae(23, this.atN.intValue());
            }
            if (this.anU != null) {
                zzard.zzr(24, this.anU);
            }
            if (this.anQ != null) {
                zzard.zzr(25, this.anQ);
            }
            if (this.atB != null) {
                zzard.zzb(26, this.atB.longValue());
            }
            if (this.atO != null) {
                zzard.zzj(28, this.atO.booleanValue());
            }
            if (this.atP != null && this.atP.length > 0) {
                for (zza zza : this.atP) {
                    if (zza != null) {
                        zzard.zza(29, (zzark) zza);
                    }
                }
            }
            if (this.anY != null) {
                zzard.zzr(30, this.anY);
            }
            if (this.atQ != null) {
                zzard.zzae(31, this.atQ.intValue());
            }
            if (this.atR != null) {
                zzard.zzae(32, this.atR.intValue());
            }
            if (this.atS != null) {
                zzard.zzae(33, this.atS.intValue());
            }
            if (this.atT != null) {
                zzard.zzr(34, this.atT);
            }
            super.zza(zzard);
        }

        /* renamed from: zzaq */
        public zze zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 8:
                        this.atv = Integer.valueOf(zzarc.mo9092cA());
                        continue;
                    case 18:
                        int zzc = zzarn.zzc(zzarc, 18);
                        int length = this.atw == null ? 0 : this.atw.length;
                        zzb[] zzbArr = new zzb[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.atw, 0, zzbArr, 0, length);
                        }
                        while (length < zzbArr.length - 1) {
                            zzbArr[length] = new zzb();
                            zzarc.zza(zzbArr[length]);
                            zzarc.mo9104cw();
                            length++;
                        }
                        zzbArr[length] = new zzb();
                        zzarc.zza(zzbArr[length]);
                        this.atw = zzbArr;
                        continue;
                    case 26:
                        int zzc2 = zzarn.zzc(zzarc, 26);
                        int length2 = this.atx == null ? 0 : this.atx.length;
                        zzg[] zzgArr = new zzg[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.atx, 0, zzgArr, 0, length2);
                        }
                        while (length2 < zzgArr.length - 1) {
                            zzgArr[length2] = new zzg();
                            zzarc.zza(zzgArr[length2]);
                            zzarc.mo9104cw();
                            length2++;
                        }
                        zzgArr[length2] = new zzg();
                        zzarc.zza(zzgArr[length2]);
                        this.atx = zzgArr;
                        continue;
                    case 32:
                        this.aty = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 40:
                        this.atz = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 48:
                        this.atA = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 56:
                        this.atC = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 66:
                        this.atD = zzarc.readString();
                        continue;
                    case 74:
                        this.zzct = zzarc.readString();
                        continue;
                    case 82:
                        this.atE = zzarc.readString();
                        continue;
                    case 90:
                        this.atF = zzarc.readString();
                        continue;
                    case 96:
                        this.atG = Integer.valueOf(zzarc.mo9092cA());
                        continue;
                    case 106:
                        this.anR = zzarc.readString();
                        continue;
                    case 114:
                        this.zzck = zzarc.readString();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD:
                        this.afY = zzarc.readString();
                        continue;
                    case 136:
                        this.atH = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 144:
                        this.atI = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 154:
                        this.atJ = zzarc.readString();
                        continue;
                    case 160:
                        this.atK = Boolean.valueOf(zzarc.mo9094cC());
                        continue;
                    case 170:
                        this.atL = zzarc.readString();
                        continue;
                    case 176:
                        this.atM = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 184:
                        this.atN = Integer.valueOf(zzarc.mo9092cA());
                        continue;
                    case 194:
                        this.anU = zzarc.readString();
                        continue;
                    case 202:
                        this.anQ = zzarc.readString();
                        continue;
                    case 208:
                        this.atB = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 224:
                        this.atO = Boolean.valueOf(zzarc.mo9094cC());
                        continue;
                    case 234:
                        int zzc3 = zzarn.zzc(zzarc, 234);
                        int length3 = this.atP == null ? 0 : this.atP.length;
                        zza[] zzaArr = new zza[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.atP, 0, zzaArr, 0, length3);
                        }
                        while (length3 < zzaArr.length - 1) {
                            zzaArr[length3] = new zza();
                            zzarc.zza(zzaArr[length3]);
                            zzarc.mo9104cw();
                            length3++;
                        }
                        zzaArr[length3] = new zza();
                        zzarc.zza(zzaArr[length3]);
                        this.atP = zzaArr;
                        continue;
                    case 242:
                        this.anY = zzarc.readString();
                        continue;
                    case 248:
                        this.atQ = Integer.valueOf(zzarc.mo9092cA());
                        continue;
                    case 256:
                        this.atR = Integer.valueOf(zzarc.mo9092cA());
                        continue;
                    case 264:
                        this.atS = Integer.valueOf(zzarc.mo9092cA());
                        continue;
                    case 274:
                        this.atT = zzarc.readString();
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

        public zze zzbzj() {
            this.atv = null;
            this.atw = zzb.zzbzd();
            this.atx = zzg.zzbzl();
            this.aty = null;
            this.atz = null;
            this.atA = null;
            this.atB = null;
            this.atC = null;
            this.atD = null;
            this.zzct = null;
            this.atE = null;
            this.atF = null;
            this.atG = null;
            this.anR = null;
            this.zzck = null;
            this.afY = null;
            this.atH = null;
            this.atI = null;
            this.atJ = null;
            this.atK = null;
            this.atL = null;
            this.atM = null;
            this.atN = null;
            this.anU = null;
            this.anQ = null;
            this.atO = null;
            this.atP = zza.zzbzb();
            this.anY = null;
            this.atQ = null;
            this.atR = null;
            this.atS = null;
            this.atT = null;
            this.bqE = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzx() {
            int zzx = super.zzx();
            if (this.atv != null) {
                zzx += zzard.zzag(1, this.atv.intValue());
            }
            if (this.atw != null && this.atw.length > 0) {
                int i = zzx;
                for (zzb zzb : this.atw) {
                    if (zzb != null) {
                        i += zzard.zzc(2, (zzark) zzb);
                    }
                }
                zzx = i;
            }
            if (this.atx != null && this.atx.length > 0) {
                int i2 = zzx;
                for (zzg zzg : this.atx) {
                    if (zzg != null) {
                        i2 += zzard.zzc(3, (zzark) zzg);
                    }
                }
                zzx = i2;
            }
            if (this.aty != null) {
                zzx += zzard.zzf(4, this.aty.longValue());
            }
            if (this.atz != null) {
                zzx += zzard.zzf(5, this.atz.longValue());
            }
            if (this.atA != null) {
                zzx += zzard.zzf(6, this.atA.longValue());
            }
            if (this.atC != null) {
                zzx += zzard.zzf(7, this.atC.longValue());
            }
            if (this.atD != null) {
                zzx += zzard.zzs(8, this.atD);
            }
            if (this.zzct != null) {
                zzx += zzard.zzs(9, this.zzct);
            }
            if (this.atE != null) {
                zzx += zzard.zzs(10, this.atE);
            }
            if (this.atF != null) {
                zzx += zzard.zzs(11, this.atF);
            }
            if (this.atG != null) {
                zzx += zzard.zzag(12, this.atG.intValue());
            }
            if (this.anR != null) {
                zzx += zzard.zzs(13, this.anR);
            }
            if (this.zzck != null) {
                zzx += zzard.zzs(14, this.zzck);
            }
            if (this.afY != null) {
                zzx += zzard.zzs(16, this.afY);
            }
            if (this.atH != null) {
                zzx += zzard.zzf(17, this.atH.longValue());
            }
            if (this.atI != null) {
                zzx += zzard.zzf(18, this.atI.longValue());
            }
            if (this.atJ != null) {
                zzx += zzard.zzs(19, this.atJ);
            }
            if (this.atK != null) {
                zzx += zzard.zzk(20, this.atK.booleanValue());
            }
            if (this.atL != null) {
                zzx += zzard.zzs(21, this.atL);
            }
            if (this.atM != null) {
                zzx += zzard.zzf(22, this.atM.longValue());
            }
            if (this.atN != null) {
                zzx += zzard.zzag(23, this.atN.intValue());
            }
            if (this.anU != null) {
                zzx += zzard.zzs(24, this.anU);
            }
            if (this.anQ != null) {
                zzx += zzard.zzs(25, this.anQ);
            }
            if (this.atB != null) {
                zzx += zzard.zzf(26, this.atB.longValue());
            }
            if (this.atO != null) {
                zzx += zzard.zzk(28, this.atO.booleanValue());
            }
            if (this.atP != null && this.atP.length > 0) {
                for (zza zza : this.atP) {
                    if (zza != null) {
                        zzx += zzard.zzc(29, (zzark) zza);
                    }
                }
            }
            if (this.anY != null) {
                zzx += zzard.zzs(30, this.anY);
            }
            if (this.atQ != null) {
                zzx += zzard.zzag(31, this.atQ.intValue());
            }
            if (this.atR != null) {
                zzx += zzard.zzag(32, this.atR.intValue());
            }
            if (this.atS != null) {
                zzx += zzard.zzag(33, this.atS.intValue());
            }
            return this.atT != null ? zzx + zzard.zzs(34, this.atT) : zzx;
        }
    }

    public static final class zzf extends zzark {
        public long[] atU;
        public long[] atV;

        public zzf() {
            zzbzk();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf zzf = (zzf) obj;
            if (!zzari.equals(this.atU, zzf.atU)) {
                return false;
            }
            return zzari.equals(this.atV, zzf.atV);
        }

        public int hashCode() {
            return ((((getClass().getName().hashCode() + 527) * 31) + zzari.hashCode(this.atU)) * 31) + zzari.hashCode(this.atV);
        }

        public void zza(zzard zzard) throws IOException {
            if (this.atU != null && this.atU.length > 0) {
                for (long zza : this.atU) {
                    zzard.zza(1, zza);
                }
            }
            if (this.atV != null && this.atV.length > 0) {
                for (long zza2 : this.atV) {
                    zzard.zza(2, zza2);
                }
            }
            super.zza(zzard);
        }

        /* renamed from: zzar */
        public zzf zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 8:
                        int zzc = zzarn.zzc(zzarc, 8);
                        int length = this.atU == null ? 0 : this.atU.length;
                        long[] jArr = new long[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.atU, 0, jArr, 0, length);
                        }
                        while (length < jArr.length - 1) {
                            jArr[length] = zzarc.mo9106cy();
                            zzarc.mo9104cw();
                            length++;
                        }
                        jArr[length] = zzarc.mo9106cy();
                        this.atU = jArr;
                        continue;
                    case 10:
                        int zzahc = zzarc.zzahc(zzarc.mo9097cF());
                        int position = zzarc.getPosition();
                        int i = 0;
                        while (zzarc.mo9101cK() > 0) {
                            zzarc.mo9106cy();
                            i++;
                        }
                        zzarc.zzahe(position);
                        int length2 = this.atU == null ? 0 : this.atU.length;
                        long[] jArr2 = new long[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.atU, 0, jArr2, 0, length2);
                        }
                        while (length2 < jArr2.length) {
                            jArr2[length2] = zzarc.mo9106cy();
                            length2++;
                        }
                        this.atU = jArr2;
                        zzarc.zzahd(zzahc);
                        continue;
                    case 16:
                        int zzc2 = zzarn.zzc(zzarc, 16);
                        int length3 = this.atV == null ? 0 : this.atV.length;
                        long[] jArr3 = new long[(zzc2 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.atV, 0, jArr3, 0, length3);
                        }
                        while (length3 < jArr3.length - 1) {
                            jArr3[length3] = zzarc.mo9106cy();
                            zzarc.mo9104cw();
                            length3++;
                        }
                        jArr3[length3] = zzarc.mo9106cy();
                        this.atV = jArr3;
                        continue;
                    case 18:
                        int zzahc2 = zzarc.zzahc(zzarc.mo9097cF());
                        int position2 = zzarc.getPosition();
                        int i2 = 0;
                        while (zzarc.mo9101cK() > 0) {
                            zzarc.mo9106cy();
                            i2++;
                        }
                        zzarc.zzahe(position2);
                        int length4 = this.atV == null ? 0 : this.atV.length;
                        long[] jArr4 = new long[(i2 + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.atV, 0, jArr4, 0, length4);
                        }
                        while (length4 < jArr4.length) {
                            jArr4[length4] = zzarc.mo9106cy();
                            length4++;
                        }
                        this.atV = jArr4;
                        zzarc.zzahd(zzahc2);
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

        public zzf zzbzk() {
            this.atU = zzarn.bqG;
            this.atV = zzarn.bqG;
            this.bqE = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzx() {
            int i;
            int zzx = super.zzx();
            if (this.atU == null || this.atU.length <= 0) {
                i = zzx;
            } else {
                int i2 = 0;
                for (long zzda : this.atU) {
                    i2 += zzard.zzda(zzda);
                }
                i = zzx + i2 + (this.atU.length * 1);
            }
            if (this.atV == null || this.atV.length <= 0) {
                return i;
            }
            int i3 = 0;
            for (long zzda2 : this.atV) {
                i3 += zzard.zzda(zzda2);
            }
            return i + i3 + (this.atV.length * 1);
        }
    }

    public static final class zzg extends zzark {
        private static volatile zzg[] atW;

        /* renamed from: Dr */
        public String f2262Dr;
        public Float asw;
        public Double asx;
        public Long atX;
        public Long ats;
        public String name;

        public zzg() {
            zzbzm();
        }

        public static zzg[] zzbzl() {
            if (atW == null) {
                synchronized (zzari.bqD) {
                    if (atW == null) {
                        atW = new zzg[0];
                    }
                }
            }
            return atW;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzg)) {
                return false;
            }
            zzg zzg = (zzg) obj;
            if (this.atX == null) {
                if (zzg.atX != null) {
                    return false;
                }
            } else if (!this.atX.equals(zzg.atX)) {
                return false;
            }
            if (this.name == null) {
                if (zzg.name != null) {
                    return false;
                }
            } else if (!this.name.equals(zzg.name)) {
                return false;
            }
            if (this.f2262Dr == null) {
                if (zzg.f2262Dr != null) {
                    return false;
                }
            } else if (!this.f2262Dr.equals(zzg.f2262Dr)) {
                return false;
            }
            if (this.ats == null) {
                if (zzg.ats != null) {
                    return false;
                }
            } else if (!this.ats.equals(zzg.ats)) {
                return false;
            }
            if (this.asw == null) {
                if (zzg.asw != null) {
                    return false;
                }
            } else if (!this.asw.equals(zzg.asw)) {
                return false;
            }
            return this.asx == null ? zzg.asx == null : this.asx.equals(zzg.asx);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.asw == null ? 0 : this.asw.hashCode()) + (((this.ats == null ? 0 : this.ats.hashCode()) + (((this.f2262Dr == null ? 0 : this.f2262Dr.hashCode()) + (((this.name == null ? 0 : this.name.hashCode()) + (((this.atX == null ? 0 : this.atX.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.asx != null) {
                i = this.asx.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzard zzard) throws IOException {
            if (this.atX != null) {
                zzard.zzb(1, this.atX.longValue());
            }
            if (this.name != null) {
                zzard.zzr(2, this.name);
            }
            if (this.f2262Dr != null) {
                zzard.zzr(3, this.f2262Dr);
            }
            if (this.ats != null) {
                zzard.zzb(4, this.ats.longValue());
            }
            if (this.asw != null) {
                zzard.zzc(5, this.asw.floatValue());
            }
            if (this.asx != null) {
                zzard.zza(6, this.asx.doubleValue());
            }
            super.zza(zzard);
        }

        /* renamed from: zzas */
        public zzg zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 8:
                        this.atX = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 18:
                        this.name = zzarc.readString();
                        continue;
                    case 26:
                        this.f2262Dr = zzarc.readString();
                        continue;
                    case 32:
                        this.ats = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 45:
                        this.asw = Float.valueOf(zzarc.readFloat());
                        continue;
                    case 49:
                        this.asx = Double.valueOf(zzarc.readDouble());
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

        public zzg zzbzm() {
            this.atX = null;
            this.name = null;
            this.f2262Dr = null;
            this.ats = null;
            this.asw = null;
            this.asx = null;
            this.bqE = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzx() {
            int zzx = super.zzx();
            if (this.atX != null) {
                zzx += zzard.zzf(1, this.atX.longValue());
            }
            if (this.name != null) {
                zzx += zzard.zzs(2, this.name);
            }
            if (this.f2262Dr != null) {
                zzx += zzard.zzs(3, this.f2262Dr);
            }
            if (this.ats != null) {
                zzx += zzard.zzf(4, this.ats.longValue());
            }
            if (this.asw != null) {
                zzx += zzard.zzd(5, this.asw.floatValue());
            }
            return this.asx != null ? zzx + zzard.zzb(6, this.asx.doubleValue()) : zzx;
        }
    }
}
