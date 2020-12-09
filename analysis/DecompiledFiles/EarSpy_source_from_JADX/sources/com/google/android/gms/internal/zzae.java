package com.google.android.gms.internal;

import com.facebook.ads.AdError;
import java.io.IOException;

public interface zzae {

    public static final class zza extends zzare<zza> {
        public String zzcs = null;
        public String zzct = null;
        public Long zzcu = null;
        public Long zzcv = null;
        public Long zzcw = null;
        public Long zzcx = null;
        public Long zzcy = null;
        public Long zzcz = null;
        public Long zzda = null;
        public Long zzdb = null;
        public Long zzdc = null;
        public Long zzdd = null;
        public String zzde = null;
        public Long zzdf = null;
        public Long zzdg = null;
        public Long zzdh = null;
        public Long zzdi = null;
        public Long zzdj = null;
        public Long zzdk = null;
        public Long zzdl = null;
        public Long zzdm = null;
        public Long zzdn = null;
        public String zzdo = null;
        public String zzdp = null;
        public Long zzdq = null;
        public Long zzdr = null;
        public Long zzds = null;
        public String zzdt = null;
        public Long zzdu = null;
        public Long zzdv = null;
        public Long zzdw = null;
        public zzb zzdx;
        public Long zzdy = null;
        public Long zzdz = null;
        public Long zzea = null;
        public Long zzeb = null;
        public Long zzec = null;
        public Long zzed = null;
        public String zzee = null;
        public String zzef = null;
        public Integer zzeg = null;
        public Integer zzeh = null;
        public Long zzei = null;
        public Long zzej = null;
        public Long zzek = null;
        public Long zzel = null;
        public Long zzem = null;
        public Integer zzen = null;
        public C1289zza zzeo;
        public C1289zza[] zzep = C1289zza.zzy();
        public zzb zzeq;
        public Long zzer = null;
        public String zzes = null;
        public Integer zzet = null;
        public Boolean zzeu = null;
        public String zzev = null;
        public Long zzew = null;
        public zze zzex;

        /* renamed from: com.google.android.gms.internal.zzae$zza$zza  reason: collision with other inner class name */
        public static final class C1289zza extends zzare<C1289zza> {
            private static volatile C1289zza[] zzey;
            public Long zzdf = null;
            public Long zzdg = null;
            public Long zzez = null;
            public Long zzfa = null;
            public Long zzfb = null;
            public Long zzfc = null;
            public Integer zzfd = null;
            public Long zzfe = null;
            public Long zzff = null;
            public Long zzfg = null;
            public Integer zzfh = null;
            public Long zzfi = null;

            public C1289zza() {
                this.bqE = -1;
            }

            public static C1289zza[] zzy() {
                if (zzey == null) {
                    synchronized (zzari.bqD) {
                        if (zzey == null) {
                            zzey = new C1289zza[0];
                        }
                    }
                }
                return zzey;
            }

            public void zza(zzard zzard) throws IOException {
                if (this.zzdf != null) {
                    zzard.zzb(1, this.zzdf.longValue());
                }
                if (this.zzdg != null) {
                    zzard.zzb(2, this.zzdg.longValue());
                }
                if (this.zzez != null) {
                    zzard.zzb(3, this.zzez.longValue());
                }
                if (this.zzfa != null) {
                    zzard.zzb(4, this.zzfa.longValue());
                }
                if (this.zzfb != null) {
                    zzard.zzb(5, this.zzfb.longValue());
                }
                if (this.zzfc != null) {
                    zzard.zzb(6, this.zzfc.longValue());
                }
                if (this.zzfd != null) {
                    zzard.zzae(7, this.zzfd.intValue());
                }
                if (this.zzfe != null) {
                    zzard.zzb(8, this.zzfe.longValue());
                }
                if (this.zzff != null) {
                    zzard.zzb(9, this.zzff.longValue());
                }
                if (this.zzfg != null) {
                    zzard.zzb(10, this.zzfg.longValue());
                }
                if (this.zzfh != null) {
                    zzard.zzae(11, this.zzfh.intValue());
                }
                if (this.zzfi != null) {
                    zzard.zzb(12, this.zzfi.longValue());
                }
                super.zza(zzard);
            }

            /* renamed from: zzd */
            public C1289zza zzb(zzarc zzarc) throws IOException {
                while (true) {
                    int cw = zzarc.mo9104cw();
                    switch (cw) {
                        case 0:
                            break;
                        case 8:
                            this.zzdf = Long.valueOf(zzarc.mo9107cz());
                            continue;
                        case 16:
                            this.zzdg = Long.valueOf(zzarc.mo9107cz());
                            continue;
                        case 24:
                            this.zzez = Long.valueOf(zzarc.mo9107cz());
                            continue;
                        case 32:
                            this.zzfa = Long.valueOf(zzarc.mo9107cz());
                            continue;
                        case 40:
                            this.zzfb = Long.valueOf(zzarc.mo9107cz());
                            continue;
                        case 48:
                            this.zzfc = Long.valueOf(zzarc.mo9107cz());
                            continue;
                        case 56:
                            int cA = zzarc.mo9092cA();
                            switch (cA) {
                                case 0:
                                case 1:
                                case 2:
                                case AdError.NETWORK_ERROR_CODE:
                                    this.zzfd = Integer.valueOf(cA);
                                    break;
                                default:
                                    continue;
                            }
                        case 64:
                            this.zzfe = Long.valueOf(zzarc.mo9107cz());
                            continue;
                        case 72:
                            this.zzff = Long.valueOf(zzarc.mo9107cz());
                            continue;
                        case 80:
                            this.zzfg = Long.valueOf(zzarc.mo9107cz());
                            continue;
                        case 88:
                            int cA2 = zzarc.mo9092cA();
                            switch (cA2) {
                                case 0:
                                case 1:
                                case 2:
                                case AdError.NETWORK_ERROR_CODE:
                                    this.zzfh = Integer.valueOf(cA2);
                                    break;
                                default:
                                    continue;
                            }
                        case 96:
                            this.zzfi = Long.valueOf(zzarc.mo9107cz());
                            continue;
                        default:
                            if (!super.zza(zzarc, cw)) {
                                break;
                            } else {
                                continue;
                            }
                    }
                }
                return this;
            }

            /* access modifiers changed from: protected */
            public int zzx() {
                int zzx = super.zzx();
                if (this.zzdf != null) {
                    zzx += zzard.zzf(1, this.zzdf.longValue());
                }
                if (this.zzdg != null) {
                    zzx += zzard.zzf(2, this.zzdg.longValue());
                }
                if (this.zzez != null) {
                    zzx += zzard.zzf(3, this.zzez.longValue());
                }
                if (this.zzfa != null) {
                    zzx += zzard.zzf(4, this.zzfa.longValue());
                }
                if (this.zzfb != null) {
                    zzx += zzard.zzf(5, this.zzfb.longValue());
                }
                if (this.zzfc != null) {
                    zzx += zzard.zzf(6, this.zzfc.longValue());
                }
                if (this.zzfd != null) {
                    zzx += zzard.zzag(7, this.zzfd.intValue());
                }
                if (this.zzfe != null) {
                    zzx += zzard.zzf(8, this.zzfe.longValue());
                }
                if (this.zzff != null) {
                    zzx += zzard.zzf(9, this.zzff.longValue());
                }
                if (this.zzfg != null) {
                    zzx += zzard.zzf(10, this.zzfg.longValue());
                }
                if (this.zzfh != null) {
                    zzx += zzard.zzag(11, this.zzfh.intValue());
                }
                return this.zzfi != null ? zzx + zzard.zzf(12, this.zzfi.longValue()) : zzx;
            }
        }

        public static final class zzb extends zzare<zzb> {
            public Long zzel = null;
            public Long zzem = null;
            public Long zzfj = null;

            public zzb() {
                this.bqE = -1;
            }

            public void zza(zzard zzard) throws IOException {
                if (this.zzel != null) {
                    zzard.zzb(1, this.zzel.longValue());
                }
                if (this.zzem != null) {
                    zzard.zzb(2, this.zzem.longValue());
                }
                if (this.zzfj != null) {
                    zzard.zzb(3, this.zzfj.longValue());
                }
                super.zza(zzard);
            }

            /* renamed from: zze */
            public zzb zzb(zzarc zzarc) throws IOException {
                while (true) {
                    int cw = zzarc.mo9104cw();
                    switch (cw) {
                        case 0:
                            break;
                        case 8:
                            this.zzel = Long.valueOf(zzarc.mo9107cz());
                            continue;
                        case 16:
                            this.zzem = Long.valueOf(zzarc.mo9107cz());
                            continue;
                        case 24:
                            this.zzfj = Long.valueOf(zzarc.mo9107cz());
                            continue;
                        default:
                            if (!super.zza(zzarc, cw)) {
                                break;
                            } else {
                                continue;
                            }
                    }
                }
                return this;
            }

            /* access modifiers changed from: protected */
            public int zzx() {
                int zzx = super.zzx();
                if (this.zzel != null) {
                    zzx += zzard.zzf(1, this.zzel.longValue());
                }
                if (this.zzem != null) {
                    zzx += zzard.zzf(2, this.zzem.longValue());
                }
                return this.zzfj != null ? zzx + zzard.zzf(3, this.zzfj.longValue()) : zzx;
            }
        }

        public zza() {
            this.bqE = -1;
        }

        public static zza zzc(byte[] bArr) throws zzarj {
            return (zza) zzark.zza(new zza(), bArr);
        }

        public void zza(zzard zzard) throws IOException {
            if (this.zzct != null) {
                zzard.zzr(1, this.zzct);
            }
            if (this.zzcs != null) {
                zzard.zzr(2, this.zzcs);
            }
            if (this.zzcu != null) {
                zzard.zzb(3, this.zzcu.longValue());
            }
            if (this.zzcv != null) {
                zzard.zzb(4, this.zzcv.longValue());
            }
            if (this.zzcw != null) {
                zzard.zzb(5, this.zzcw.longValue());
            }
            if (this.zzcx != null) {
                zzard.zzb(6, this.zzcx.longValue());
            }
            if (this.zzcy != null) {
                zzard.zzb(7, this.zzcy.longValue());
            }
            if (this.zzcz != null) {
                zzard.zzb(8, this.zzcz.longValue());
            }
            if (this.zzda != null) {
                zzard.zzb(9, this.zzda.longValue());
            }
            if (this.zzdb != null) {
                zzard.zzb(10, this.zzdb.longValue());
            }
            if (this.zzdc != null) {
                zzard.zzb(11, this.zzdc.longValue());
            }
            if (this.zzdd != null) {
                zzard.zzb(12, this.zzdd.longValue());
            }
            if (this.zzde != null) {
                zzard.zzr(13, this.zzde);
            }
            if (this.zzdf != null) {
                zzard.zzb(14, this.zzdf.longValue());
            }
            if (this.zzdg != null) {
                zzard.zzb(15, this.zzdg.longValue());
            }
            if (this.zzdh != null) {
                zzard.zzb(16, this.zzdh.longValue());
            }
            if (this.zzdi != null) {
                zzard.zzb(17, this.zzdi.longValue());
            }
            if (this.zzdj != null) {
                zzard.zzb(18, this.zzdj.longValue());
            }
            if (this.zzdk != null) {
                zzard.zzb(19, this.zzdk.longValue());
            }
            if (this.zzdl != null) {
                zzard.zzb(20, this.zzdl.longValue());
            }
            if (this.zzer != null) {
                zzard.zzb(21, this.zzer.longValue());
            }
            if (this.zzdm != null) {
                zzard.zzb(22, this.zzdm.longValue());
            }
            if (this.zzdn != null) {
                zzard.zzb(23, this.zzdn.longValue());
            }
            if (this.zzes != null) {
                zzard.zzr(24, this.zzes);
            }
            if (this.zzew != null) {
                zzard.zzb(25, this.zzew.longValue());
            }
            if (this.zzet != null) {
                zzard.zzae(26, this.zzet.intValue());
            }
            if (this.zzdo != null) {
                zzard.zzr(27, this.zzdo);
            }
            if (this.zzeu != null) {
                zzard.zzj(28, this.zzeu.booleanValue());
            }
            if (this.zzdp != null) {
                zzard.zzr(29, this.zzdp);
            }
            if (this.zzev != null) {
                zzard.zzr(30, this.zzev);
            }
            if (this.zzdq != null) {
                zzard.zzb(31, this.zzdq.longValue());
            }
            if (this.zzdr != null) {
                zzard.zzb(32, this.zzdr.longValue());
            }
            if (this.zzds != null) {
                zzard.zzb(33, this.zzds.longValue());
            }
            if (this.zzdt != null) {
                zzard.zzr(34, this.zzdt);
            }
            if (this.zzdu != null) {
                zzard.zzb(35, this.zzdu.longValue());
            }
            if (this.zzdv != null) {
                zzard.zzb(36, this.zzdv.longValue());
            }
            if (this.zzdw != null) {
                zzard.zzb(37, this.zzdw.longValue());
            }
            if (this.zzdx != null) {
                zzard.zza(38, (zzark) this.zzdx);
            }
            if (this.zzdy != null) {
                zzard.zzb(39, this.zzdy.longValue());
            }
            if (this.zzdz != null) {
                zzard.zzb(40, this.zzdz.longValue());
            }
            if (this.zzea != null) {
                zzard.zzb(41, this.zzea.longValue());
            }
            if (this.zzeb != null) {
                zzard.zzb(42, this.zzeb.longValue());
            }
            if (this.zzep != null && this.zzep.length > 0) {
                for (C1289zza zza : this.zzep) {
                    if (zza != null) {
                        zzard.zza(43, (zzark) zza);
                    }
                }
            }
            if (this.zzec != null) {
                zzard.zzb(44, this.zzec.longValue());
            }
            if (this.zzed != null) {
                zzard.zzb(45, this.zzed.longValue());
            }
            if (this.zzee != null) {
                zzard.zzr(46, this.zzee);
            }
            if (this.zzef != null) {
                zzard.zzr(47, this.zzef);
            }
            if (this.zzeg != null) {
                zzard.zzae(48, this.zzeg.intValue());
            }
            if (this.zzeh != null) {
                zzard.zzae(49, this.zzeh.intValue());
            }
            if (this.zzeo != null) {
                zzard.zza(50, (zzark) this.zzeo);
            }
            if (this.zzei != null) {
                zzard.zzb(51, this.zzei.longValue());
            }
            if (this.zzej != null) {
                zzard.zzb(52, this.zzej.longValue());
            }
            if (this.zzek != null) {
                zzard.zzb(53, this.zzek.longValue());
            }
            if (this.zzel != null) {
                zzard.zzb(54, this.zzel.longValue());
            }
            if (this.zzem != null) {
                zzard.zzb(55, this.zzem.longValue());
            }
            if (this.zzen != null) {
                zzard.zzae(56, this.zzen.intValue());
            }
            if (this.zzeq != null) {
                zzard.zza(57, (zzark) this.zzeq);
            }
            if (this.zzex != null) {
                zzard.zza(201, (zzark) this.zzex);
            }
            super.zza(zzard);
        }

        /* renamed from: zzc */
        public zza zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 10:
                        this.zzct = zzarc.readString();
                        continue;
                    case 18:
                        this.zzcs = zzarc.readString();
                        continue;
                    case 24:
                        this.zzcu = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 32:
                        this.zzcv = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 40:
                        this.zzcw = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 48:
                        this.zzcx = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 56:
                        this.zzcy = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 64:
                        this.zzcz = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 72:
                        this.zzda = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 80:
                        this.zzdb = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 88:
                        this.zzdc = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 96:
                        this.zzdd = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 106:
                        this.zzde = zzarc.readString();
                        continue;
                    case 112:
                        this.zzdf = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 120:
                        this.zzdg = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 128:
                        this.zzdh = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 136:
                        this.zzdi = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 144:
                        this.zzdj = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 152:
                        this.zzdk = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 160:
                        this.zzdl = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 168:
                        this.zzer = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 176:
                        this.zzdm = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 184:
                        this.zzdn = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 194:
                        this.zzes = zzarc.readString();
                        continue;
                    case 200:
                        this.zzew = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 208:
                        int cA = zzarc.mo9092cA();
                        switch (cA) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                this.zzet = Integer.valueOf(cA);
                                break;
                            default:
                                continue;
                        }
                    case 218:
                        this.zzdo = zzarc.readString();
                        continue;
                    case 224:
                        this.zzeu = Boolean.valueOf(zzarc.mo9094cC());
                        continue;
                    case 234:
                        this.zzdp = zzarc.readString();
                        continue;
                    case 242:
                        this.zzev = zzarc.readString();
                        continue;
                    case 248:
                        this.zzdq = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 256:
                        this.zzdr = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 264:
                        this.zzds = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 274:
                        this.zzdt = zzarc.readString();
                        continue;
                    case 280:
                        this.zzdu = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 288:
                        this.zzdv = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 296:
                        this.zzdw = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 306:
                        if (this.zzdx == null) {
                            this.zzdx = new zzb();
                        }
                        zzarc.zza(this.zzdx);
                        continue;
                    case 312:
                        this.zzdy = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 320:
                        this.zzdz = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 328:
                        this.zzea = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 336:
                        this.zzeb = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 346:
                        int zzc = zzarn.zzc(zzarc, 346);
                        int length = this.zzep == null ? 0 : this.zzep.length;
                        C1289zza[] zzaArr = new C1289zza[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzep, 0, zzaArr, 0, length);
                        }
                        while (length < zzaArr.length - 1) {
                            zzaArr[length] = new C1289zza();
                            zzarc.zza(zzaArr[length]);
                            zzarc.mo9104cw();
                            length++;
                        }
                        zzaArr[length] = new C1289zza();
                        zzarc.zza(zzaArr[length]);
                        this.zzep = zzaArr;
                        continue;
                    case 352:
                        this.zzec = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 360:
                        this.zzed = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 370:
                        this.zzee = zzarc.readString();
                        continue;
                    case 378:
                        this.zzef = zzarc.readString();
                        continue;
                    case 384:
                        int cA2 = zzarc.mo9092cA();
                        switch (cA2) {
                            case 0:
                            case 1:
                            case 2:
                            case AdError.NETWORK_ERROR_CODE:
                                this.zzeg = Integer.valueOf(cA2);
                                break;
                            default:
                                continue;
                        }
                    case 392:
                        int cA3 = zzarc.mo9092cA();
                        switch (cA3) {
                            case 0:
                            case 1:
                            case 2:
                            case AdError.NETWORK_ERROR_CODE:
                                this.zzeh = Integer.valueOf(cA3);
                                break;
                            default:
                                continue;
                        }
                    case 402:
                        if (this.zzeo == null) {
                            this.zzeo = new C1289zza();
                        }
                        zzarc.zza(this.zzeo);
                        continue;
                    case 408:
                        this.zzei = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 416:
                        this.zzej = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 424:
                        this.zzek = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 432:
                        this.zzel = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 440:
                        this.zzem = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 448:
                        int cA4 = zzarc.mo9092cA();
                        switch (cA4) {
                            case 0:
                            case 1:
                            case 2:
                            case AdError.NETWORK_ERROR_CODE:
                                this.zzen = Integer.valueOf(cA4);
                                break;
                            default:
                                continue;
                        }
                    case 458:
                        if (this.zzeq == null) {
                            this.zzeq = new zzb();
                        }
                        zzarc.zza(this.zzeq);
                        continue;
                    case 1610:
                        if (this.zzex == null) {
                            this.zzex = new zze();
                        }
                        zzarc.zza(this.zzex);
                        continue;
                    default:
                        if (!super.zza(zzarc, cw)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzx() {
            int zzx = super.zzx();
            if (this.zzct != null) {
                zzx += zzard.zzs(1, this.zzct);
            }
            if (this.zzcs != null) {
                zzx += zzard.zzs(2, this.zzcs);
            }
            if (this.zzcu != null) {
                zzx += zzard.zzf(3, this.zzcu.longValue());
            }
            if (this.zzcv != null) {
                zzx += zzard.zzf(4, this.zzcv.longValue());
            }
            if (this.zzcw != null) {
                zzx += zzard.zzf(5, this.zzcw.longValue());
            }
            if (this.zzcx != null) {
                zzx += zzard.zzf(6, this.zzcx.longValue());
            }
            if (this.zzcy != null) {
                zzx += zzard.zzf(7, this.zzcy.longValue());
            }
            if (this.zzcz != null) {
                zzx += zzard.zzf(8, this.zzcz.longValue());
            }
            if (this.zzda != null) {
                zzx += zzard.zzf(9, this.zzda.longValue());
            }
            if (this.zzdb != null) {
                zzx += zzard.zzf(10, this.zzdb.longValue());
            }
            if (this.zzdc != null) {
                zzx += zzard.zzf(11, this.zzdc.longValue());
            }
            if (this.zzdd != null) {
                zzx += zzard.zzf(12, this.zzdd.longValue());
            }
            if (this.zzde != null) {
                zzx += zzard.zzs(13, this.zzde);
            }
            if (this.zzdf != null) {
                zzx += zzard.zzf(14, this.zzdf.longValue());
            }
            if (this.zzdg != null) {
                zzx += zzard.zzf(15, this.zzdg.longValue());
            }
            if (this.zzdh != null) {
                zzx += zzard.zzf(16, this.zzdh.longValue());
            }
            if (this.zzdi != null) {
                zzx += zzard.zzf(17, this.zzdi.longValue());
            }
            if (this.zzdj != null) {
                zzx += zzard.zzf(18, this.zzdj.longValue());
            }
            if (this.zzdk != null) {
                zzx += zzard.zzf(19, this.zzdk.longValue());
            }
            if (this.zzdl != null) {
                zzx += zzard.zzf(20, this.zzdl.longValue());
            }
            if (this.zzer != null) {
                zzx += zzard.zzf(21, this.zzer.longValue());
            }
            if (this.zzdm != null) {
                zzx += zzard.zzf(22, this.zzdm.longValue());
            }
            if (this.zzdn != null) {
                zzx += zzard.zzf(23, this.zzdn.longValue());
            }
            if (this.zzes != null) {
                zzx += zzard.zzs(24, this.zzes);
            }
            if (this.zzew != null) {
                zzx += zzard.zzf(25, this.zzew.longValue());
            }
            if (this.zzet != null) {
                zzx += zzard.zzag(26, this.zzet.intValue());
            }
            if (this.zzdo != null) {
                zzx += zzard.zzs(27, this.zzdo);
            }
            if (this.zzeu != null) {
                zzx += zzard.zzk(28, this.zzeu.booleanValue());
            }
            if (this.zzdp != null) {
                zzx += zzard.zzs(29, this.zzdp);
            }
            if (this.zzev != null) {
                zzx += zzard.zzs(30, this.zzev);
            }
            if (this.zzdq != null) {
                zzx += zzard.zzf(31, this.zzdq.longValue());
            }
            if (this.zzdr != null) {
                zzx += zzard.zzf(32, this.zzdr.longValue());
            }
            if (this.zzds != null) {
                zzx += zzard.zzf(33, this.zzds.longValue());
            }
            if (this.zzdt != null) {
                zzx += zzard.zzs(34, this.zzdt);
            }
            if (this.zzdu != null) {
                zzx += zzard.zzf(35, this.zzdu.longValue());
            }
            if (this.zzdv != null) {
                zzx += zzard.zzf(36, this.zzdv.longValue());
            }
            if (this.zzdw != null) {
                zzx += zzard.zzf(37, this.zzdw.longValue());
            }
            if (this.zzdx != null) {
                zzx += zzard.zzc(38, (zzark) this.zzdx);
            }
            if (this.zzdy != null) {
                zzx += zzard.zzf(39, this.zzdy.longValue());
            }
            if (this.zzdz != null) {
                zzx += zzard.zzf(40, this.zzdz.longValue());
            }
            if (this.zzea != null) {
                zzx += zzard.zzf(41, this.zzea.longValue());
            }
            if (this.zzeb != null) {
                zzx += zzard.zzf(42, this.zzeb.longValue());
            }
            if (this.zzep != null && this.zzep.length > 0) {
                int i = zzx;
                for (C1289zza zza : this.zzep) {
                    if (zza != null) {
                        i += zzard.zzc(43, (zzark) zza);
                    }
                }
                zzx = i;
            }
            if (this.zzec != null) {
                zzx += zzard.zzf(44, this.zzec.longValue());
            }
            if (this.zzed != null) {
                zzx += zzard.zzf(45, this.zzed.longValue());
            }
            if (this.zzee != null) {
                zzx += zzard.zzs(46, this.zzee);
            }
            if (this.zzef != null) {
                zzx += zzard.zzs(47, this.zzef);
            }
            if (this.zzeg != null) {
                zzx += zzard.zzag(48, this.zzeg.intValue());
            }
            if (this.zzeh != null) {
                zzx += zzard.zzag(49, this.zzeh.intValue());
            }
            if (this.zzeo != null) {
                zzx += zzard.zzc(50, (zzark) this.zzeo);
            }
            if (this.zzei != null) {
                zzx += zzard.zzf(51, this.zzei.longValue());
            }
            if (this.zzej != null) {
                zzx += zzard.zzf(52, this.zzej.longValue());
            }
            if (this.zzek != null) {
                zzx += zzard.zzf(53, this.zzek.longValue());
            }
            if (this.zzel != null) {
                zzx += zzard.zzf(54, this.zzel.longValue());
            }
            if (this.zzem != null) {
                zzx += zzard.zzf(55, this.zzem.longValue());
            }
            if (this.zzen != null) {
                zzx += zzard.zzag(56, this.zzen.intValue());
            }
            if (this.zzeq != null) {
                zzx += zzard.zzc(57, (zzark) this.zzeq);
            }
            return this.zzex != null ? zzx + zzard.zzc(201, (zzark) this.zzex) : zzx;
        }
    }

    public static final class zzb extends zzare<zzb> {
        public Long zzfk = null;
        public Integer zzfl = null;
        public Boolean zzfm = null;
        public int[] zzfn = zzarn.bqF;
        public Long zzfo = null;

        public zzb() {
            this.bqE = -1;
        }

        public void zza(zzard zzard) throws IOException {
            if (this.zzfk != null) {
                zzard.zzb(1, this.zzfk.longValue());
            }
            if (this.zzfl != null) {
                zzard.zzae(2, this.zzfl.intValue());
            }
            if (this.zzfm != null) {
                zzard.zzj(3, this.zzfm.booleanValue());
            }
            if (this.zzfn != null && this.zzfn.length > 0) {
                for (int zzae : this.zzfn) {
                    zzard.zzae(4, zzae);
                }
            }
            if (this.zzfo != null) {
                zzard.zza(5, this.zzfo.longValue());
            }
            super.zza(zzard);
        }

        /* renamed from: zzf */
        public zzb zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 8:
                        this.zzfk = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 16:
                        this.zzfl = Integer.valueOf(zzarc.mo9092cA());
                        continue;
                    case 24:
                        this.zzfm = Boolean.valueOf(zzarc.mo9094cC());
                        continue;
                    case 32:
                        int zzc = zzarn.zzc(zzarc, 32);
                        int length = this.zzfn == null ? 0 : this.zzfn.length;
                        int[] iArr = new int[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.zzfn, 0, iArr, 0, length);
                        }
                        while (length < iArr.length - 1) {
                            iArr[length] = zzarc.mo9092cA();
                            zzarc.mo9104cw();
                            length++;
                        }
                        iArr[length] = zzarc.mo9092cA();
                        this.zzfn = iArr;
                        continue;
                    case 34:
                        int zzahc = zzarc.zzahc(zzarc.mo9097cF());
                        int position = zzarc.getPosition();
                        int i = 0;
                        while (zzarc.mo9101cK() > 0) {
                            zzarc.mo9092cA();
                            i++;
                        }
                        zzarc.zzahe(position);
                        int length2 = this.zzfn == null ? 0 : this.zzfn.length;
                        int[] iArr2 = new int[(i + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.zzfn, 0, iArr2, 0, length2);
                        }
                        while (length2 < iArr2.length) {
                            iArr2[length2] = zzarc.mo9092cA();
                            length2++;
                        }
                        this.zzfn = iArr2;
                        zzarc.zzahd(zzahc);
                        continue;
                    case 40:
                        this.zzfo = Long.valueOf(zzarc.mo9106cy());
                        continue;
                    default:
                        if (!super.zza(zzarc, cw)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzx() {
            int zzx = super.zzx();
            if (this.zzfk != null) {
                zzx += zzard.zzf(1, this.zzfk.longValue());
            }
            if (this.zzfl != null) {
                zzx += zzard.zzag(2, this.zzfl.intValue());
            }
            if (this.zzfm != null) {
                zzx += zzard.zzk(3, this.zzfm.booleanValue());
            }
            if (this.zzfn != null && this.zzfn.length > 0) {
                int i = 0;
                for (int zzahi : this.zzfn) {
                    i += zzard.zzahi(zzahi);
                }
                zzx = zzx + i + (this.zzfn.length * 1);
            }
            return this.zzfo != null ? zzx + zzard.zze(5, this.zzfo.longValue()) : zzx;
        }
    }

    public static final class zzc extends zzare<zzc> {
        public byte[] zzfp = null;
        public byte[] zzfq = null;

        public zzc() {
            this.bqE = -1;
        }

        public void zza(zzard zzard) throws IOException {
            if (this.zzfp != null) {
                zzard.zza(1, this.zzfp);
            }
            if (this.zzfq != null) {
                zzard.zza(2, this.zzfq);
            }
            super.zza(zzard);
        }

        /* renamed from: zzg */
        public zzc zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 10:
                        this.zzfp = zzarc.readBytes();
                        continue;
                    case 18:
                        this.zzfq = zzarc.readBytes();
                        continue;
                    default:
                        if (!super.zza(zzarc, cw)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzx() {
            int zzx = super.zzx();
            if (this.zzfp != null) {
                zzx += zzard.zzb(1, this.zzfp);
            }
            return this.zzfq != null ? zzx + zzard.zzb(2, this.zzfq) : zzx;
        }
    }

    public static final class zzd extends zzare<zzd> {
        public byte[] data = null;
        public byte[] zzfr = null;
        public byte[] zzfs = null;
        public byte[] zzft = null;

        public zzd() {
            this.bqE = -1;
        }

        public static zzd zzd(byte[] bArr) throws zzarj {
            return (zzd) zzark.zza(new zzd(), bArr);
        }

        public void zza(zzard zzard) throws IOException {
            if (this.data != null) {
                zzard.zza(1, this.data);
            }
            if (this.zzfr != null) {
                zzard.zza(2, this.zzfr);
            }
            if (this.zzfs != null) {
                zzard.zza(3, this.zzfs);
            }
            if (this.zzft != null) {
                zzard.zza(4, this.zzft);
            }
            super.zza(zzard);
        }

        /* renamed from: zzh */
        public zzd zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 10:
                        this.data = zzarc.readBytes();
                        continue;
                    case 18:
                        this.zzfr = zzarc.readBytes();
                        continue;
                    case 26:
                        this.zzfs = zzarc.readBytes();
                        continue;
                    case 34:
                        this.zzft = zzarc.readBytes();
                        continue;
                    default:
                        if (!super.zza(zzarc, cw)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzx() {
            int zzx = super.zzx();
            if (this.data != null) {
                zzx += zzard.zzb(1, this.data);
            }
            if (this.zzfr != null) {
                zzx += zzard.zzb(2, this.zzfr);
            }
            if (this.zzfs != null) {
                zzx += zzard.zzb(3, this.zzfs);
            }
            return this.zzft != null ? zzx + zzard.zzb(4, this.zzft) : zzx;
        }
    }

    public static final class zze extends zzare<zze> {
        public Long zzfk = null;
        public String zzfu = null;
        public byte[] zzfv = null;

        public zze() {
            this.bqE = -1;
        }

        public void zza(zzard zzard) throws IOException {
            if (this.zzfk != null) {
                zzard.zzb(1, this.zzfk.longValue());
            }
            if (this.zzfu != null) {
                zzard.zzr(3, this.zzfu);
            }
            if (this.zzfv != null) {
                zzard.zza(4, this.zzfv);
            }
            super.zza(zzard);
        }

        /* renamed from: zzi */
        public zze zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 8:
                        this.zzfk = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 26:
                        this.zzfu = zzarc.readString();
                        continue;
                    case 34:
                        this.zzfv = zzarc.readBytes();
                        continue;
                    default:
                        if (!super.zza(zzarc, cw)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzx() {
            int zzx = super.zzx();
            if (this.zzfk != null) {
                zzx += zzard.zzf(1, this.zzfk.longValue());
            }
            if (this.zzfu != null) {
                zzx += zzard.zzs(3, this.zzfu);
            }
            return this.zzfv != null ? zzx + zzard.zzb(4, this.zzfv) : zzx;
        }
    }

    public static final class zzf extends zzare<zzf> {
        public byte[] zzfr = null;
        public byte[][] zzfw = zzarn.bqL;
        public Integer zzfx = null;
        public Integer zzfy = null;

        public zzf() {
            this.bqE = -1;
        }

        public void zza(zzard zzard) throws IOException {
            if (this.zzfw != null && this.zzfw.length > 0) {
                for (byte[] bArr : this.zzfw) {
                    if (bArr != null) {
                        zzard.zza(1, bArr);
                    }
                }
            }
            if (this.zzfr != null) {
                zzard.zza(2, this.zzfr);
            }
            if (this.zzfx != null) {
                zzard.zzae(3, this.zzfx.intValue());
            }
            if (this.zzfy != null) {
                zzard.zzae(4, this.zzfy.intValue());
            }
            super.zza(zzard);
        }

        /* renamed from: zzj */
        public zzf zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzarn.zzc(zzarc, 10);
                        int length = this.zzfw == null ? 0 : this.zzfw.length;
                        byte[][] bArr = new byte[(zzc + length)][];
                        if (length != 0) {
                            System.arraycopy(this.zzfw, 0, bArr, 0, length);
                        }
                        while (length < bArr.length - 1) {
                            bArr[length] = zzarc.readBytes();
                            zzarc.mo9104cw();
                            length++;
                        }
                        bArr[length] = zzarc.readBytes();
                        this.zzfw = bArr;
                        continue;
                    case 18:
                        this.zzfr = zzarc.readBytes();
                        continue;
                    case 24:
                        int cA = zzarc.mo9092cA();
                        switch (cA) {
                            case 0:
                            case 1:
                                this.zzfx = Integer.valueOf(cA);
                                break;
                            default:
                                continue;
                        }
                    case 32:
                        int cA2 = zzarc.mo9092cA();
                        switch (cA2) {
                            case 0:
                            case 1:
                                this.zzfy = Integer.valueOf(cA2);
                                break;
                            default:
                                continue;
                        }
                    default:
                        if (!super.zza(zzarc, cw)) {
                            break;
                        } else {
                            continue;
                        }
                }
            }
            return this;
        }

        /* access modifiers changed from: protected */
        public int zzx() {
            int i;
            int zzx = super.zzx();
            if (this.zzfw == null || this.zzfw.length <= 0) {
                i = zzx;
            } else {
                int i2 = 0;
                int i3 = 0;
                for (byte[] bArr : this.zzfw) {
                    if (bArr != null) {
                        i3++;
                        i2 += zzard.zzbg(bArr);
                    }
                }
                i = zzx + i2 + (i3 * 1);
            }
            if (this.zzfr != null) {
                i += zzard.zzb(2, this.zzfr);
            }
            if (this.zzfx != null) {
                i += zzard.zzag(3, this.zzfx.intValue());
            }
            return this.zzfy != null ? i + zzard.zzag(4, this.zzfy.intValue()) : i;
        }
    }
}
