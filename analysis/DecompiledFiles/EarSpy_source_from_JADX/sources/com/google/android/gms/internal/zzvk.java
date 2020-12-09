package com.google.android.gms.internal;

import java.io.IOException;

public interface zzvk {

    public static final class zza extends zzark {
        private static volatile zza[] asz;
        public Integer asA;
        public zze[] asB;
        public zzb[] asC;

        public zza() {
            zzbyn();
        }

        public static zza[] zzbym() {
            if (asz == null) {
                synchronized (zzari.bqD) {
                    if (asz == null) {
                        asz = new zza[0];
                    }
                }
            }
            return asz;
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
            if (!zzari.equals((Object[]) this.asB, (Object[]) zza.asB)) {
                return false;
            }
            return zzari.equals((Object[]) this.asC, (Object[]) zza.asC);
        }

        public int hashCode() {
            return (((((this.asA == null ? 0 : this.asA.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31) + zzari.hashCode((Object[]) this.asB)) * 31) + zzari.hashCode((Object[]) this.asC);
        }

        public void zza(zzard zzard) throws IOException {
            if (this.asA != null) {
                zzard.zzae(1, this.asA.intValue());
            }
            if (this.asB != null && this.asB.length > 0) {
                for (zze zze : this.asB) {
                    if (zze != null) {
                        zzard.zza(2, (zzark) zze);
                    }
                }
            }
            if (this.asC != null && this.asC.length > 0) {
                for (zzb zzb : this.asC) {
                    if (zzb != null) {
                        zzard.zza(3, (zzark) zzb);
                    }
                }
            }
            super.zza(zzard);
        }

        /* renamed from: zzad */
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
                        int zzc = zzarn.zzc(zzarc, 18);
                        int length = this.asB == null ? 0 : this.asB.length;
                        zze[] zzeArr = new zze[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.asB, 0, zzeArr, 0, length);
                        }
                        while (length < zzeArr.length - 1) {
                            zzeArr[length] = new zze();
                            zzarc.zza(zzeArr[length]);
                            zzarc.mo9104cw();
                            length++;
                        }
                        zzeArr[length] = new zze();
                        zzarc.zza(zzeArr[length]);
                        this.asB = zzeArr;
                        continue;
                    case 26:
                        int zzc2 = zzarn.zzc(zzarc, 26);
                        int length2 = this.asC == null ? 0 : this.asC.length;
                        zzb[] zzbArr = new zzb[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.asC, 0, zzbArr, 0, length2);
                        }
                        while (length2 < zzbArr.length - 1) {
                            zzbArr[length2] = new zzb();
                            zzarc.zza(zzbArr[length2]);
                            zzarc.mo9104cw();
                            length2++;
                        }
                        zzbArr[length2] = new zzb();
                        zzarc.zza(zzbArr[length2]);
                        this.asC = zzbArr;
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

        public zza zzbyn() {
            this.asA = null;
            this.asB = zze.zzbyt();
            this.asC = zzb.zzbyo();
            this.bqE = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzx() {
            int zzx = super.zzx();
            if (this.asA != null) {
                zzx += zzard.zzag(1, this.asA.intValue());
            }
            if (this.asB != null && this.asB.length > 0) {
                int i = zzx;
                for (zze zze : this.asB) {
                    if (zze != null) {
                        i += zzard.zzc(2, (zzark) zze);
                    }
                }
                zzx = i;
            }
            if (this.asC != null && this.asC.length > 0) {
                for (zzb zzb : this.asC) {
                    if (zzb != null) {
                        zzx += zzard.zzc(3, (zzark) zzb);
                    }
                }
            }
            return zzx;
        }
    }

    public static final class zzb extends zzark {
        private static volatile zzb[] asD;
        public Integer asE;
        public String asF;
        public zzc[] asG;
        public Boolean asH;
        public zzd asI;

        public zzb() {
            zzbyp();
        }

        public static zzb[] zzbyo() {
            if (asD == null) {
                synchronized (zzari.bqD) {
                    if (asD == null) {
                        asD = new zzb[0];
                    }
                }
            }
            return asD;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) obj;
            if (this.asE == null) {
                if (zzb.asE != null) {
                    return false;
                }
            } else if (!this.asE.equals(zzb.asE)) {
                return false;
            }
            if (this.asF == null) {
                if (zzb.asF != null) {
                    return false;
                }
            } else if (!this.asF.equals(zzb.asF)) {
                return false;
            }
            if (!zzari.equals((Object[]) this.asG, (Object[]) zzb.asG)) {
                return false;
            }
            if (this.asH == null) {
                if (zzb.asH != null) {
                    return false;
                }
            } else if (!this.asH.equals(zzb.asH)) {
                return false;
            }
            return this.asI == null ? zzb.asI == null : this.asI.equals(zzb.asI);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.asH == null ? 0 : this.asH.hashCode()) + (((((this.asF == null ? 0 : this.asF.hashCode()) + (((this.asE == null ? 0 : this.asE.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31) + zzari.hashCode((Object[]) this.asG)) * 31)) * 31;
            if (this.asI != null) {
                i = this.asI.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzard zzard) throws IOException {
            if (this.asE != null) {
                zzard.zzae(1, this.asE.intValue());
            }
            if (this.asF != null) {
                zzard.zzr(2, this.asF);
            }
            if (this.asG != null && this.asG.length > 0) {
                for (zzc zzc : this.asG) {
                    if (zzc != null) {
                        zzard.zza(3, (zzark) zzc);
                    }
                }
            }
            if (this.asH != null) {
                zzard.zzj(4, this.asH.booleanValue());
            }
            if (this.asI != null) {
                zzard.zza(5, (zzark) this.asI);
            }
            super.zza(zzard);
        }

        /* renamed from: zzae */
        public zzb zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 8:
                        this.asE = Integer.valueOf(zzarc.mo9092cA());
                        continue;
                    case 18:
                        this.asF = zzarc.readString();
                        continue;
                    case 26:
                        int zzc = zzarn.zzc(zzarc, 26);
                        int length = this.asG == null ? 0 : this.asG.length;
                        zzc[] zzcArr = new zzc[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.asG, 0, zzcArr, 0, length);
                        }
                        while (length < zzcArr.length - 1) {
                            zzcArr[length] = new zzc();
                            zzarc.zza(zzcArr[length]);
                            zzarc.mo9104cw();
                            length++;
                        }
                        zzcArr[length] = new zzc();
                        zzarc.zza(zzcArr[length]);
                        this.asG = zzcArr;
                        continue;
                    case 32:
                        this.asH = Boolean.valueOf(zzarc.mo9094cC());
                        continue;
                    case 42:
                        if (this.asI == null) {
                            this.asI = new zzd();
                        }
                        zzarc.zza(this.asI);
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

        public zzb zzbyp() {
            this.asE = null;
            this.asF = null;
            this.asG = zzc.zzbyq();
            this.asH = null;
            this.asI = null;
            this.bqE = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzx() {
            int zzx = super.zzx();
            if (this.asE != null) {
                zzx += zzard.zzag(1, this.asE.intValue());
            }
            if (this.asF != null) {
                zzx += zzard.zzs(2, this.asF);
            }
            if (this.asG != null && this.asG.length > 0) {
                int i = zzx;
                for (zzc zzc : this.asG) {
                    if (zzc != null) {
                        i += zzard.zzc(3, (zzark) zzc);
                    }
                }
                zzx = i;
            }
            if (this.asH != null) {
                zzx += zzard.zzk(4, this.asH.booleanValue());
            }
            return this.asI != null ? zzx + zzard.zzc(5, (zzark) this.asI) : zzx;
        }
    }

    public static final class zzc extends zzark {
        private static volatile zzc[] asJ;
        public zzf asK;
        public zzd asL;
        public Boolean asM;
        public String asN;

        public zzc() {
            zzbyr();
        }

        public static zzc[] zzbyq() {
            if (asJ == null) {
                synchronized (zzari.bqD) {
                    if (asJ == null) {
                        asJ = new zzc[0];
                    }
                }
            }
            return asJ;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) obj;
            if (this.asK == null) {
                if (zzc.asK != null) {
                    return false;
                }
            } else if (!this.asK.equals(zzc.asK)) {
                return false;
            }
            if (this.asL == null) {
                if (zzc.asL != null) {
                    return false;
                }
            } else if (!this.asL.equals(zzc.asL)) {
                return false;
            }
            if (this.asM == null) {
                if (zzc.asM != null) {
                    return false;
                }
            } else if (!this.asM.equals(zzc.asM)) {
                return false;
            }
            return this.asN == null ? zzc.asN == null : this.asN.equals(zzc.asN);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.asM == null ? 0 : this.asM.hashCode()) + (((this.asL == null ? 0 : this.asL.hashCode()) + (((this.asK == null ? 0 : this.asK.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31;
            if (this.asN != null) {
                i = this.asN.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzard zzard) throws IOException {
            if (this.asK != null) {
                zzard.zza(1, (zzark) this.asK);
            }
            if (this.asL != null) {
                zzard.zza(2, (zzark) this.asL);
            }
            if (this.asM != null) {
                zzard.zzj(3, this.asM.booleanValue());
            }
            if (this.asN != null) {
                zzard.zzr(4, this.asN);
            }
            super.zza(zzard);
        }

        /* renamed from: zzaf */
        public zzc zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 10:
                        if (this.asK == null) {
                            this.asK = new zzf();
                        }
                        zzarc.zza(this.asK);
                        continue;
                    case 18:
                        if (this.asL == null) {
                            this.asL = new zzd();
                        }
                        zzarc.zza(this.asL);
                        continue;
                    case 24:
                        this.asM = Boolean.valueOf(zzarc.mo9094cC());
                        continue;
                    case 34:
                        this.asN = zzarc.readString();
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

        public zzc zzbyr() {
            this.asK = null;
            this.asL = null;
            this.asM = null;
            this.asN = null;
            this.bqE = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzx() {
            int zzx = super.zzx();
            if (this.asK != null) {
                zzx += zzard.zzc(1, (zzark) this.asK);
            }
            if (this.asL != null) {
                zzx += zzard.zzc(2, (zzark) this.asL);
            }
            if (this.asM != null) {
                zzx += zzard.zzk(3, this.asM.booleanValue());
            }
            return this.asN != null ? zzx + zzard.zzs(4, this.asN) : zzx;
        }
    }

    public static final class zzd extends zzark {
        public Integer asO;
        public Boolean asP;
        public String asQ;
        public String asR;
        public String asS;

        public zzd() {
            zzbys();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd zzd = (zzd) obj;
            if (this.asO == null) {
                if (zzd.asO != null) {
                    return false;
                }
            } else if (!this.asO.equals(zzd.asO)) {
                return false;
            }
            if (this.asP == null) {
                if (zzd.asP != null) {
                    return false;
                }
            } else if (!this.asP.equals(zzd.asP)) {
                return false;
            }
            if (this.asQ == null) {
                if (zzd.asQ != null) {
                    return false;
                }
            } else if (!this.asQ.equals(zzd.asQ)) {
                return false;
            }
            if (this.asR == null) {
                if (zzd.asR != null) {
                    return false;
                }
            } else if (!this.asR.equals(zzd.asR)) {
                return false;
            }
            return this.asS == null ? zzd.asS == null : this.asS.equals(zzd.asS);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.asR == null ? 0 : this.asR.hashCode()) + (((this.asQ == null ? 0 : this.asQ.hashCode()) + (((this.asP == null ? 0 : this.asP.hashCode()) + (((this.asO == null ? 0 : this.asO.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.asS != null) {
                i = this.asS.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzard zzard) throws IOException {
            if (this.asO != null) {
                zzard.zzae(1, this.asO.intValue());
            }
            if (this.asP != null) {
                zzard.zzj(2, this.asP.booleanValue());
            }
            if (this.asQ != null) {
                zzard.zzr(3, this.asQ);
            }
            if (this.asR != null) {
                zzard.zzr(4, this.asR);
            }
            if (this.asS != null) {
                zzard.zzr(5, this.asS);
            }
            super.zza(zzard);
        }

        /* renamed from: zzag */
        public zzd zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 8:
                        int cA = zzarc.mo9092cA();
                        switch (cA) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                                this.asO = Integer.valueOf(cA);
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        this.asP = Boolean.valueOf(zzarc.mo9094cC());
                        continue;
                    case 26:
                        this.asQ = zzarc.readString();
                        continue;
                    case 34:
                        this.asR = zzarc.readString();
                        continue;
                    case 42:
                        this.asS = zzarc.readString();
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

        public zzd zzbys() {
            this.asP = null;
            this.asQ = null;
            this.asR = null;
            this.asS = null;
            this.bqE = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzx() {
            int zzx = super.zzx();
            if (this.asO != null) {
                zzx += zzard.zzag(1, this.asO.intValue());
            }
            if (this.asP != null) {
                zzx += zzard.zzk(2, this.asP.booleanValue());
            }
            if (this.asQ != null) {
                zzx += zzard.zzs(3, this.asQ);
            }
            if (this.asR != null) {
                zzx += zzard.zzs(4, this.asR);
            }
            return this.asS != null ? zzx + zzard.zzs(5, this.asS) : zzx;
        }
    }

    public static final class zze extends zzark {
        private static volatile zze[] asT;
        public Integer asE;
        public String asU;
        public zzc asV;

        public zze() {
            zzbyu();
        }

        public static zze[] zzbyt() {
            if (asT == null) {
                synchronized (zzari.bqD) {
                    if (asT == null) {
                        asT = new zze[0];
                    }
                }
            }
            return asT;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zze = (zze) obj;
            if (this.asE == null) {
                if (zze.asE != null) {
                    return false;
                }
            } else if (!this.asE.equals(zze.asE)) {
                return false;
            }
            if (this.asU == null) {
                if (zze.asU != null) {
                    return false;
                }
            } else if (!this.asU.equals(zze.asU)) {
                return false;
            }
            return this.asV == null ? zze.asV == null : this.asV.equals(zze.asV);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.asU == null ? 0 : this.asU.hashCode()) + (((this.asE == null ? 0 : this.asE.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.asV != null) {
                i = this.asV.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzard zzard) throws IOException {
            if (this.asE != null) {
                zzard.zzae(1, this.asE.intValue());
            }
            if (this.asU != null) {
                zzard.zzr(2, this.asU);
            }
            if (this.asV != null) {
                zzard.zza(3, (zzark) this.asV);
            }
            super.zza(zzard);
        }

        /* renamed from: zzah */
        public zze zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 8:
                        this.asE = Integer.valueOf(zzarc.mo9092cA());
                        continue;
                    case 18:
                        this.asU = zzarc.readString();
                        continue;
                    case 26:
                        if (this.asV == null) {
                            this.asV = new zzc();
                        }
                        zzarc.zza(this.asV);
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

        public zze zzbyu() {
            this.asE = null;
            this.asU = null;
            this.asV = null;
            this.bqE = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzx() {
            int zzx = super.zzx();
            if (this.asE != null) {
                zzx += zzard.zzag(1, this.asE.intValue());
            }
            if (this.asU != null) {
                zzx += zzard.zzs(2, this.asU);
            }
            return this.asV != null ? zzx + zzard.zzc(3, (zzark) this.asV) : zzx;
        }
    }

    public static final class zzf extends zzark {
        public Integer asW;
        public String asX;
        public Boolean asY;
        public String[] asZ;

        public zzf() {
            zzbyv();
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf zzf = (zzf) obj;
            if (this.asW == null) {
                if (zzf.asW != null) {
                    return false;
                }
            } else if (!this.asW.equals(zzf.asW)) {
                return false;
            }
            if (this.asX == null) {
                if (zzf.asX != null) {
                    return false;
                }
            } else if (!this.asX.equals(zzf.asX)) {
                return false;
            }
            if (this.asY == null) {
                if (zzf.asY != null) {
                    return false;
                }
            } else if (!this.asY.equals(zzf.asY)) {
                return false;
            }
            return zzari.equals((Object[]) this.asZ, (Object[]) zzf.asZ);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.asX == null ? 0 : this.asX.hashCode()) + (((this.asW == null ? 0 : this.asW.intValue()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.asY != null) {
                i = this.asY.hashCode();
            }
            return ((hashCode + i) * 31) + zzari.hashCode((Object[]) this.asZ);
        }

        public void zza(zzard zzard) throws IOException {
            if (this.asW != null) {
                zzard.zzae(1, this.asW.intValue());
            }
            if (this.asX != null) {
                zzard.zzr(2, this.asX);
            }
            if (this.asY != null) {
                zzard.zzj(3, this.asY.booleanValue());
            }
            if (this.asZ != null && this.asZ.length > 0) {
                for (String str : this.asZ) {
                    if (str != null) {
                        zzard.zzr(4, str);
                    }
                }
            }
            super.zza(zzard);
        }

        /* renamed from: zzai */
        public zzf zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 8:
                        int cA = zzarc.mo9092cA();
                        switch (cA) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                this.asW = Integer.valueOf(cA);
                                break;
                            default:
                                continue;
                        }
                    case 18:
                        this.asX = zzarc.readString();
                        continue;
                    case 24:
                        this.asY = Boolean.valueOf(zzarc.mo9094cC());
                        continue;
                    case 34:
                        int zzc = zzarn.zzc(zzarc, 34);
                        int length = this.asZ == null ? 0 : this.asZ.length;
                        String[] strArr = new String[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.asZ, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = zzarc.readString();
                            zzarc.mo9104cw();
                            length++;
                        }
                        strArr[length] = zzarc.readString();
                        this.asZ = strArr;
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

        public zzf zzbyv() {
            this.asX = null;
            this.asY = null;
            this.asZ = zzarn.bqK;
            this.bqE = -1;
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzx() {
            int zzx = super.zzx();
            if (this.asW != null) {
                zzx += zzard.zzag(1, this.asW.intValue());
            }
            if (this.asX != null) {
                zzx += zzard.zzs(2, this.asX);
            }
            if (this.asY != null) {
                zzx += zzard.zzk(3, this.asY.booleanValue());
            }
            if (this.asZ == null || this.asZ.length <= 0) {
                return zzx;
            }
            int i = 0;
            int i2 = 0;
            for (String str : this.asZ) {
                if (str != null) {
                    i2++;
                    i += zzard.zzuy(str);
                }
            }
            return zzx + i + (i2 * 1);
        }
    }
}
