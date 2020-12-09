package com.google.android.gms.internal;

import android.support.p000v4.media.TransportMediator;
import java.io.IOException;
import java.util.Arrays;

public interface zzarp {

    public static final class zza extends zzare<zza> implements Cloneable {
        public String[] bqP;
        public String[] bqQ;
        public int[] bqR;
        public long[] bqS;
        public long[] bqT;

        public zza() {
            mo9198dd();
        }

        /* renamed from: cP */
        public /* synthetic */ zzare mo9158cP() throws CloneNotSupportedException {
            return (zza) clone();
        }

        /* renamed from: cQ */
        public /* synthetic */ zzark mo9159cQ() throws CloneNotSupportedException {
            return (zza) clone();
        }

        /* renamed from: dd */
        public zza mo9198dd() {
            this.bqP = zzarn.bqK;
            this.bqQ = zzarn.bqK;
            this.bqR = zzarn.bqF;
            this.bqS = zzarn.bqG;
            this.bqT = zzarn.bqG;
            this.bqv = null;
            this.bqE = -1;
            return this;
        }

        /* renamed from: de */
        public zza clone() {
            try {
                zza zza = (zza) super.clone();
                if (this.bqP != null && this.bqP.length > 0) {
                    zza.bqP = (String[]) this.bqP.clone();
                }
                if (this.bqQ != null && this.bqQ.length > 0) {
                    zza.bqQ = (String[]) this.bqQ.clone();
                }
                if (this.bqR != null && this.bqR.length > 0) {
                    zza.bqR = (int[]) this.bqR.clone();
                }
                if (this.bqS != null && this.bqS.length > 0) {
                    zza.bqS = (long[]) this.bqS.clone();
                }
                if (this.bqT != null && this.bqT.length > 0) {
                    zza.bqT = (long[]) this.bqT.clone();
                }
                return zza;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (!zzari.equals((Object[]) this.bqP, (Object[]) zza.bqP) || !zzari.equals((Object[]) this.bqQ, (Object[]) zza.bqQ) || !zzari.equals(this.bqR, zza.bqR) || !zzari.equals(this.bqS, zza.bqS) || !zzari.equals(this.bqT, zza.bqT)) {
                return false;
            }
            return (this.bqv == null || this.bqv.isEmpty()) ? zza.bqv == null || zza.bqv.isEmpty() : this.bqv.equals(zza.bqv);
        }

        public int hashCode() {
            return ((this.bqv == null || this.bqv.isEmpty()) ? 0 : this.bqv.hashCode()) + ((((((((((((getClass().getName().hashCode() + 527) * 31) + zzari.hashCode((Object[]) this.bqP)) * 31) + zzari.hashCode((Object[]) this.bqQ)) * 31) + zzari.hashCode(this.bqR)) * 31) + zzari.hashCode(this.bqS)) * 31) + zzari.hashCode(this.bqT)) * 31);
        }

        public void zza(zzard zzard) throws IOException {
            if (this.bqP != null && this.bqP.length > 0) {
                for (String str : this.bqP) {
                    if (str != null) {
                        zzard.zzr(1, str);
                    }
                }
            }
            if (this.bqQ != null && this.bqQ.length > 0) {
                for (String str2 : this.bqQ) {
                    if (str2 != null) {
                        zzard.zzr(2, str2);
                    }
                }
            }
            if (this.bqR != null && this.bqR.length > 0) {
                for (int zzae : this.bqR) {
                    zzard.zzae(3, zzae);
                }
            }
            if (this.bqS != null && this.bqS.length > 0) {
                for (long zzb : this.bqS) {
                    zzard.zzb(4, zzb);
                }
            }
            if (this.bqT != null && this.bqT.length > 0) {
                for (long zzb2 : this.bqT) {
                    zzard.zzb(5, zzb2);
                }
            }
            super.zza(zzard);
        }

        /* renamed from: zzcm */
        public zza zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 10:
                        int zzc = zzarn.zzc(zzarc, 10);
                        int length = this.bqP == null ? 0 : this.bqP.length;
                        String[] strArr = new String[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.bqP, 0, strArr, 0, length);
                        }
                        while (length < strArr.length - 1) {
                            strArr[length] = zzarc.readString();
                            zzarc.mo9104cw();
                            length++;
                        }
                        strArr[length] = zzarc.readString();
                        this.bqP = strArr;
                        continue;
                    case 18:
                        int zzc2 = zzarn.zzc(zzarc, 18);
                        int length2 = this.bqQ == null ? 0 : this.bqQ.length;
                        String[] strArr2 = new String[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.bqQ, 0, strArr2, 0, length2);
                        }
                        while (length2 < strArr2.length - 1) {
                            strArr2[length2] = zzarc.readString();
                            zzarc.mo9104cw();
                            length2++;
                        }
                        strArr2[length2] = zzarc.readString();
                        this.bqQ = strArr2;
                        continue;
                    case 24:
                        int zzc3 = zzarn.zzc(zzarc, 24);
                        int length3 = this.bqR == null ? 0 : this.bqR.length;
                        int[] iArr = new int[(zzc3 + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.bqR, 0, iArr, 0, length3);
                        }
                        while (length3 < iArr.length - 1) {
                            iArr[length3] = zzarc.mo9092cA();
                            zzarc.mo9104cw();
                            length3++;
                        }
                        iArr[length3] = zzarc.mo9092cA();
                        this.bqR = iArr;
                        continue;
                    case 26:
                        int zzahc = zzarc.zzahc(zzarc.mo9097cF());
                        int position = zzarc.getPosition();
                        int i = 0;
                        while (zzarc.mo9101cK() > 0) {
                            zzarc.mo9092cA();
                            i++;
                        }
                        zzarc.zzahe(position);
                        int length4 = this.bqR == null ? 0 : this.bqR.length;
                        int[] iArr2 = new int[(i + length4)];
                        if (length4 != 0) {
                            System.arraycopy(this.bqR, 0, iArr2, 0, length4);
                        }
                        while (length4 < iArr2.length) {
                            iArr2[length4] = zzarc.mo9092cA();
                            length4++;
                        }
                        this.bqR = iArr2;
                        zzarc.zzahd(zzahc);
                        continue;
                    case 32:
                        int zzc4 = zzarn.zzc(zzarc, 32);
                        int length5 = this.bqS == null ? 0 : this.bqS.length;
                        long[] jArr = new long[(zzc4 + length5)];
                        if (length5 != 0) {
                            System.arraycopy(this.bqS, 0, jArr, 0, length5);
                        }
                        while (length5 < jArr.length - 1) {
                            jArr[length5] = zzarc.mo9107cz();
                            zzarc.mo9104cw();
                            length5++;
                        }
                        jArr[length5] = zzarc.mo9107cz();
                        this.bqS = jArr;
                        continue;
                    case 34:
                        int zzahc2 = zzarc.zzahc(zzarc.mo9097cF());
                        int position2 = zzarc.getPosition();
                        int i2 = 0;
                        while (zzarc.mo9101cK() > 0) {
                            zzarc.mo9107cz();
                            i2++;
                        }
                        zzarc.zzahe(position2);
                        int length6 = this.bqS == null ? 0 : this.bqS.length;
                        long[] jArr2 = new long[(i2 + length6)];
                        if (length6 != 0) {
                            System.arraycopy(this.bqS, 0, jArr2, 0, length6);
                        }
                        while (length6 < jArr2.length) {
                            jArr2[length6] = zzarc.mo9107cz();
                            length6++;
                        }
                        this.bqS = jArr2;
                        zzarc.zzahd(zzahc2);
                        continue;
                    case 40:
                        int zzc5 = zzarn.zzc(zzarc, 40);
                        int length7 = this.bqT == null ? 0 : this.bqT.length;
                        long[] jArr3 = new long[(zzc5 + length7)];
                        if (length7 != 0) {
                            System.arraycopy(this.bqT, 0, jArr3, 0, length7);
                        }
                        while (length7 < jArr3.length - 1) {
                            jArr3[length7] = zzarc.mo9107cz();
                            zzarc.mo9104cw();
                            length7++;
                        }
                        jArr3[length7] = zzarc.mo9107cz();
                        this.bqT = jArr3;
                        continue;
                    case 42:
                        int zzahc3 = zzarc.zzahc(zzarc.mo9097cF());
                        int position3 = zzarc.getPosition();
                        int i3 = 0;
                        while (zzarc.mo9101cK() > 0) {
                            zzarc.mo9107cz();
                            i3++;
                        }
                        zzarc.zzahe(position3);
                        int length8 = this.bqT == null ? 0 : this.bqT.length;
                        long[] jArr4 = new long[(i3 + length8)];
                        if (length8 != 0) {
                            System.arraycopy(this.bqT, 0, jArr4, 0, length8);
                        }
                        while (length8 < jArr4.length) {
                            jArr4[length8] = zzarc.mo9107cz();
                            length8++;
                        }
                        this.bqT = jArr4;
                        zzarc.zzahd(zzahc3);
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
            int i;
            int zzx = super.zzx();
            if (this.bqP == null || this.bqP.length <= 0) {
                i = zzx;
            } else {
                int i2 = 0;
                int i3 = 0;
                for (String str : this.bqP) {
                    if (str != null) {
                        i3++;
                        i2 += zzard.zzuy(str);
                    }
                }
                i = zzx + i2 + (i3 * 1);
            }
            if (this.bqQ != null && this.bqQ.length > 0) {
                int i4 = 0;
                int i5 = 0;
                for (String str2 : this.bqQ) {
                    if (str2 != null) {
                        i5++;
                        i4 += zzard.zzuy(str2);
                    }
                }
                i = i + i4 + (i5 * 1);
            }
            if (this.bqR != null && this.bqR.length > 0) {
                int i6 = 0;
                for (int zzahi : this.bqR) {
                    i6 += zzard.zzahi(zzahi);
                }
                i = i + i6 + (this.bqR.length * 1);
            }
            if (this.bqS != null && this.bqS.length > 0) {
                int i7 = 0;
                for (long zzdb : this.bqS) {
                    i7 += zzard.zzdb(zzdb);
                }
                i = i + i7 + (this.bqS.length * 1);
            }
            if (this.bqT == null || this.bqT.length <= 0) {
                return i;
            }
            int i8 = 0;
            for (long zzdb2 : this.bqT) {
                i8 += zzard.zzdb(zzdb2);
            }
            return i + i8 + (this.bqT.length * 1);
        }
    }

    public static final class zzb extends zzare<zzb> implements Cloneable {
        public int bqU;
        public String bqV;
        public String version;

        public zzb() {
            mo9203df();
        }

        /* renamed from: cP */
        public /* synthetic */ zzare mo9158cP() throws CloneNotSupportedException {
            return (zzb) clone();
        }

        /* renamed from: cQ */
        public /* synthetic */ zzark mo9159cQ() throws CloneNotSupportedException {
            return (zzb) clone();
        }

        /* renamed from: df */
        public zzb mo9203df() {
            this.bqU = 0;
            this.bqV = "";
            this.version = "";
            this.bqv = null;
            this.bqE = -1;
            return this;
        }

        /* renamed from: dg */
        public zzb clone() {
            try {
                return (zzb) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzb)) {
                return false;
            }
            zzb zzb = (zzb) obj;
            if (this.bqU != zzb.bqU) {
                return false;
            }
            if (this.bqV == null) {
                if (zzb.bqV != null) {
                    return false;
                }
            } else if (!this.bqV.equals(zzb.bqV)) {
                return false;
            }
            if (this.version == null) {
                if (zzb.version != null) {
                    return false;
                }
            } else if (!this.version.equals(zzb.version)) {
                return false;
            }
            return (this.bqv == null || this.bqv.isEmpty()) ? zzb.bqv == null || zzb.bqv.isEmpty() : this.bqv.equals(zzb.bqv);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.version == null ? 0 : this.version.hashCode()) + (((this.bqV == null ? 0 : this.bqV.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.bqU) * 31)) * 31)) * 31;
            if (this.bqv != null && !this.bqv.isEmpty()) {
                i = this.bqv.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzard zzard) throws IOException {
            if (this.bqU != 0) {
                zzard.zzae(1, this.bqU);
            }
            if (!this.bqV.equals("")) {
                zzard.zzr(2, this.bqV);
            }
            if (!this.version.equals("")) {
                zzard.zzr(3, this.version);
            }
            super.zza(zzard);
        }

        /* renamed from: zzcn */
        public zzb zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 8:
                        this.bqU = zzarc.mo9092cA();
                        continue;
                    case 18:
                        this.bqV = zzarc.readString();
                        continue;
                    case 26:
                        this.version = zzarc.readString();
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
            if (this.bqU != 0) {
                zzx += zzard.zzag(1, this.bqU);
            }
            if (!this.bqV.equals("")) {
                zzx += zzard.zzs(2, this.bqV);
            }
            return !this.version.equals("") ? zzx + zzard.zzs(3, this.version) : zzx;
        }
    }

    public static final class zzc extends zzare<zzc> implements Cloneable {
        public byte[] bqW;
        public String bqX;
        public byte[][] bqY;
        public boolean bqZ;

        public zzc() {
            mo9208dh();
        }

        /* renamed from: cP */
        public /* synthetic */ zzare mo9158cP() throws CloneNotSupportedException {
            return (zzc) clone();
        }

        /* renamed from: cQ */
        public /* synthetic */ zzark mo9159cQ() throws CloneNotSupportedException {
            return (zzc) clone();
        }

        /* renamed from: dh */
        public zzc mo9208dh() {
            this.bqW = zzarn.bqM;
            this.bqX = "";
            this.bqY = zzarn.bqL;
            this.bqZ = false;
            this.bqv = null;
            this.bqE = -1;
            return this;
        }

        /* renamed from: di */
        public zzc clone() {
            try {
                zzc zzc = (zzc) super.clone();
                if (this.bqY != null && this.bqY.length > 0) {
                    zzc.bqY = (byte[][]) this.bqY.clone();
                }
                return zzc;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzc)) {
                return false;
            }
            zzc zzc = (zzc) obj;
            if (!Arrays.equals(this.bqW, zzc.bqW)) {
                return false;
            }
            if (this.bqX == null) {
                if (zzc.bqX != null) {
                    return false;
                }
            } else if (!this.bqX.equals(zzc.bqX)) {
                return false;
            }
            if (!zzari.zza(this.bqY, zzc.bqY) || this.bqZ != zzc.bqZ) {
                return false;
            }
            return (this.bqv == null || this.bqv.isEmpty()) ? zzc.bqv == null || zzc.bqv.isEmpty() : this.bqv.equals(zzc.bqv);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.bqZ ? 1231 : 1237) + (((((this.bqX == null ? 0 : this.bqX.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.bqW)) * 31)) * 31) + zzari.zzb(this.bqY)) * 31)) * 31;
            if (this.bqv != null && !this.bqv.isEmpty()) {
                i = this.bqv.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzard zzard) throws IOException {
            if (!Arrays.equals(this.bqW, zzarn.bqM)) {
                zzard.zza(1, this.bqW);
            }
            if (this.bqY != null && this.bqY.length > 0) {
                for (byte[] bArr : this.bqY) {
                    if (bArr != null) {
                        zzard.zza(2, bArr);
                    }
                }
            }
            if (this.bqZ) {
                zzard.zzj(3, this.bqZ);
            }
            if (!this.bqX.equals("")) {
                zzard.zzr(4, this.bqX);
            }
            super.zza(zzard);
        }

        /* renamed from: zzco */
        public zzc zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 10:
                        this.bqW = zzarc.readBytes();
                        continue;
                    case 18:
                        int zzc = zzarn.zzc(zzarc, 18);
                        int length = this.bqY == null ? 0 : this.bqY.length;
                        byte[][] bArr = new byte[(zzc + length)][];
                        if (length != 0) {
                            System.arraycopy(this.bqY, 0, bArr, 0, length);
                        }
                        while (length < bArr.length - 1) {
                            bArr[length] = zzarc.readBytes();
                            zzarc.mo9104cw();
                            length++;
                        }
                        bArr[length] = zzarc.readBytes();
                        this.bqY = bArr;
                        continue;
                    case 24:
                        this.bqZ = zzarc.mo9094cC();
                        continue;
                    case 34:
                        this.bqX = zzarc.readString();
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
            if (!Arrays.equals(this.bqW, zzarn.bqM)) {
                zzx += zzard.zzb(1, this.bqW);
            }
            if (this.bqY != null && this.bqY.length > 0) {
                int i = 0;
                int i2 = 0;
                for (byte[] bArr : this.bqY) {
                    if (bArr != null) {
                        i2++;
                        i += zzard.zzbg(bArr);
                    }
                }
                zzx = zzx + i + (i2 * 1);
            }
            if (this.bqZ) {
                zzx += zzard.zzk(3, this.bqZ);
            }
            return !this.bqX.equals("") ? zzx + zzard.zzs(4, this.bqX) : zzx;
        }
    }

    public static final class zzd extends zzare<zzd> implements Cloneable {
        public boolean bak;
        public long bra;
        public long brb;
        public long brc;
        public int brd;
        public zze[] bre;
        public byte[] brf;
        public zzb brg;
        public byte[] brh;
        public String bri;
        public String brj;
        public zza brk;
        public String brl;
        public long brm;
        public zzc brn;
        public byte[] bro;
        public String brp;
        public int brq;
        public int[] brr;
        public long brs;
        public zzf brt;
        public String tag;
        public int zzajd;

        public zzd() {
            mo9213dj();
        }

        /* renamed from: cP */
        public /* synthetic */ zzare mo9158cP() throws CloneNotSupportedException {
            return (zzd) clone();
        }

        /* renamed from: cQ */
        public /* synthetic */ zzark mo9159cQ() throws CloneNotSupportedException {
            return (zzd) clone();
        }

        /* renamed from: dj */
        public zzd mo9213dj() {
            this.bra = 0;
            this.brb = 0;
            this.brc = 0;
            this.tag = "";
            this.brd = 0;
            this.zzajd = 0;
            this.bak = false;
            this.bre = zze.m1484dl();
            this.brf = zzarn.bqM;
            this.brg = null;
            this.brh = zzarn.bqM;
            this.bri = "";
            this.brj = "";
            this.brk = null;
            this.brl = "";
            this.brm = 180000;
            this.brn = null;
            this.bro = zzarn.bqM;
            this.brp = "";
            this.brq = 0;
            this.brr = zzarn.bqF;
            this.brs = 0;
            this.brt = null;
            this.bqv = null;
            this.bqE = -1;
            return this;
        }

        /* renamed from: dk */
        public zzd clone() {
            try {
                zzd zzd = (zzd) super.clone();
                if (this.bre != null && this.bre.length > 0) {
                    zzd.bre = new zze[this.bre.length];
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= this.bre.length) {
                            break;
                        }
                        if (this.bre[i2] != null) {
                            zzd.bre[i2] = (zze) this.bre[i2].clone();
                        }
                        i = i2 + 1;
                    }
                }
                if (this.brg != null) {
                    zzd.brg = (zzb) this.brg.clone();
                }
                if (this.brk != null) {
                    zzd.brk = (zza) this.brk.clone();
                }
                if (this.brn != null) {
                    zzd.brn = (zzc) this.brn.clone();
                }
                if (this.brr != null && this.brr.length > 0) {
                    zzd.brr = (int[]) this.brr.clone();
                }
                if (this.brt != null) {
                    zzd.brt = (zzf) this.brt.clone();
                }
                return zzd;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzd)) {
                return false;
            }
            zzd zzd = (zzd) obj;
            if (this.bra != zzd.bra || this.brb != zzd.brb || this.brc != zzd.brc) {
                return false;
            }
            if (this.tag == null) {
                if (zzd.tag != null) {
                    return false;
                }
            } else if (!this.tag.equals(zzd.tag)) {
                return false;
            }
            if (this.brd != zzd.brd || this.zzajd != zzd.zzajd || this.bak != zzd.bak || !zzari.equals((Object[]) this.bre, (Object[]) zzd.bre) || !Arrays.equals(this.brf, zzd.brf)) {
                return false;
            }
            if (this.brg == null) {
                if (zzd.brg != null) {
                    return false;
                }
            } else if (!this.brg.equals(zzd.brg)) {
                return false;
            }
            if (!Arrays.equals(this.brh, zzd.brh)) {
                return false;
            }
            if (this.bri == null) {
                if (zzd.bri != null) {
                    return false;
                }
            } else if (!this.bri.equals(zzd.bri)) {
                return false;
            }
            if (this.brj == null) {
                if (zzd.brj != null) {
                    return false;
                }
            } else if (!this.brj.equals(zzd.brj)) {
                return false;
            }
            if (this.brk == null) {
                if (zzd.brk != null) {
                    return false;
                }
            } else if (!this.brk.equals(zzd.brk)) {
                return false;
            }
            if (this.brl == null) {
                if (zzd.brl != null) {
                    return false;
                }
            } else if (!this.brl.equals(zzd.brl)) {
                return false;
            }
            if (this.brm != zzd.brm) {
                return false;
            }
            if (this.brn == null) {
                if (zzd.brn != null) {
                    return false;
                }
            } else if (!this.brn.equals(zzd.brn)) {
                return false;
            }
            if (!Arrays.equals(this.bro, zzd.bro)) {
                return false;
            }
            if (this.brp == null) {
                if (zzd.brp != null) {
                    return false;
                }
            } else if (!this.brp.equals(zzd.brp)) {
                return false;
            }
            if (this.brq != zzd.brq || !zzari.equals(this.brr, zzd.brr) || this.brs != zzd.brs) {
                return false;
            }
            if (this.brt == null) {
                if (zzd.brt != null) {
                    return false;
                }
            } else if (!this.brt.equals(zzd.brt)) {
                return false;
            }
            return (this.bqv == null || this.bqv.isEmpty()) ? zzd.bqv == null || zzd.bqv.isEmpty() : this.bqv.equals(zzd.bqv);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.brt == null ? 0 : this.brt.hashCode()) + (((((((((this.brp == null ? 0 : this.brp.hashCode()) + (((((this.brn == null ? 0 : this.brn.hashCode()) + (((((this.brl == null ? 0 : this.brl.hashCode()) + (((this.brk == null ? 0 : this.brk.hashCode()) + (((this.brj == null ? 0 : this.brj.hashCode()) + (((this.bri == null ? 0 : this.bri.hashCode()) + (((((this.brg == null ? 0 : this.brg.hashCode()) + (((((((this.bak ? 1231 : 1237) + (((((((this.tag == null ? 0 : this.tag.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.bra ^ (this.bra >>> 32)))) * 31) + ((int) (this.brb ^ (this.brb >>> 32)))) * 31) + ((int) (this.brc ^ (this.brc >>> 32)))) * 31)) * 31) + this.brd) * 31) + this.zzajd) * 31)) * 31) + zzari.hashCode((Object[]) this.bre)) * 31) + Arrays.hashCode(this.brf)) * 31)) * 31) + Arrays.hashCode(this.brh)) * 31)) * 31)) * 31)) * 31)) * 31) + ((int) (this.brm ^ (this.brm >>> 32)))) * 31)) * 31) + Arrays.hashCode(this.bro)) * 31)) * 31) + this.brq) * 31) + zzari.hashCode(this.brr)) * 31) + ((int) (this.brs ^ (this.brs >>> 32)))) * 31)) * 31;
            if (this.bqv != null && !this.bqv.isEmpty()) {
                i = this.bqv.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzard zzard) throws IOException {
            if (this.bra != 0) {
                zzard.zzb(1, this.bra);
            }
            if (!this.tag.equals("")) {
                zzard.zzr(2, this.tag);
            }
            if (this.bre != null && this.bre.length > 0) {
                for (zze zze : this.bre) {
                    if (zze != null) {
                        zzard.zza(3, (zzark) zze);
                    }
                }
            }
            if (!Arrays.equals(this.brf, zzarn.bqM)) {
                zzard.zza(4, this.brf);
            }
            if (!Arrays.equals(this.brh, zzarn.bqM)) {
                zzard.zza(6, this.brh);
            }
            if (this.brk != null) {
                zzard.zza(7, (zzark) this.brk);
            }
            if (!this.bri.equals("")) {
                zzard.zzr(8, this.bri);
            }
            if (this.brg != null) {
                zzard.zza(9, (zzark) this.brg);
            }
            if (this.bak) {
                zzard.zzj(10, this.bak);
            }
            if (this.brd != 0) {
                zzard.zzae(11, this.brd);
            }
            if (this.zzajd != 0) {
                zzard.zzae(12, this.zzajd);
            }
            if (!this.brj.equals("")) {
                zzard.zzr(13, this.brj);
            }
            if (!this.brl.equals("")) {
                zzard.zzr(14, this.brl);
            }
            if (this.brm != 180000) {
                zzard.zzd(15, this.brm);
            }
            if (this.brn != null) {
                zzard.zza(16, (zzark) this.brn);
            }
            if (this.brb != 0) {
                zzard.zzb(17, this.brb);
            }
            if (!Arrays.equals(this.bro, zzarn.bqM)) {
                zzard.zza(18, this.bro);
            }
            if (this.brq != 0) {
                zzard.zzae(19, this.brq);
            }
            if (this.brr != null && this.brr.length > 0) {
                for (int zzae : this.brr) {
                    zzard.zzae(20, zzae);
                }
            }
            if (this.brc != 0) {
                zzard.zzb(21, this.brc);
            }
            if (this.brs != 0) {
                zzard.zzb(22, this.brs);
            }
            if (this.brt != null) {
                zzard.zza(23, (zzark) this.brt);
            }
            if (!this.brp.equals("")) {
                zzard.zzr(24, this.brp);
            }
            super.zza(zzard);
        }

        /* renamed from: zzcp */
        public zzd zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 8:
                        this.bra = zzarc.mo9107cz();
                        continue;
                    case 18:
                        this.tag = zzarc.readString();
                        continue;
                    case 26:
                        int zzc = zzarn.zzc(zzarc, 26);
                        int length = this.bre == null ? 0 : this.bre.length;
                        zze[] zzeArr = new zze[(zzc + length)];
                        if (length != 0) {
                            System.arraycopy(this.bre, 0, zzeArr, 0, length);
                        }
                        while (length < zzeArr.length - 1) {
                            zzeArr[length] = new zze();
                            zzarc.zza(zzeArr[length]);
                            zzarc.mo9104cw();
                            length++;
                        }
                        zzeArr[length] = new zze();
                        zzarc.zza(zzeArr[length]);
                        this.bre = zzeArr;
                        continue;
                    case 34:
                        this.brf = zzarc.readBytes();
                        continue;
                    case 50:
                        this.brh = zzarc.readBytes();
                        continue;
                    case 58:
                        if (this.brk == null) {
                            this.brk = new zza();
                        }
                        zzarc.zza(this.brk);
                        continue;
                    case 66:
                        this.bri = zzarc.readString();
                        continue;
                    case 74:
                        if (this.brg == null) {
                            this.brg = new zzb();
                        }
                        zzarc.zza(this.brg);
                        continue;
                    case 80:
                        this.bak = zzarc.mo9094cC();
                        continue;
                    case 88:
                        this.brd = zzarc.mo9092cA();
                        continue;
                    case 96:
                        this.zzajd = zzarc.mo9092cA();
                        continue;
                    case 106:
                        this.brj = zzarc.readString();
                        continue;
                    case 114:
                        this.brl = zzarc.readString();
                        continue;
                    case 120:
                        this.brm = zzarc.mo9096cE();
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD:
                        if (this.brn == null) {
                            this.brn = new zzc();
                        }
                        zzarc.zza(this.brn);
                        continue;
                    case 136:
                        this.brb = zzarc.mo9107cz();
                        continue;
                    case 146:
                        this.bro = zzarc.readBytes();
                        continue;
                    case 152:
                        int cA = zzarc.mo9092cA();
                        switch (cA) {
                            case 0:
                            case 1:
                            case 2:
                                this.brq = cA;
                                break;
                            default:
                                continue;
                        }
                    case 160:
                        int zzc2 = zzarn.zzc(zzarc, 160);
                        int length2 = this.brr == null ? 0 : this.brr.length;
                        int[] iArr = new int[(zzc2 + length2)];
                        if (length2 != 0) {
                            System.arraycopy(this.brr, 0, iArr, 0, length2);
                        }
                        while (length2 < iArr.length - 1) {
                            iArr[length2] = zzarc.mo9092cA();
                            zzarc.mo9104cw();
                            length2++;
                        }
                        iArr[length2] = zzarc.mo9092cA();
                        this.brr = iArr;
                        continue;
                    case 162:
                        int zzahc = zzarc.zzahc(zzarc.mo9097cF());
                        int position = zzarc.getPosition();
                        int i = 0;
                        while (zzarc.mo9101cK() > 0) {
                            zzarc.mo9092cA();
                            i++;
                        }
                        zzarc.zzahe(position);
                        int length3 = this.brr == null ? 0 : this.brr.length;
                        int[] iArr2 = new int[(i + length3)];
                        if (length3 != 0) {
                            System.arraycopy(this.brr, 0, iArr2, 0, length3);
                        }
                        while (length3 < iArr2.length) {
                            iArr2[length3] = zzarc.mo9092cA();
                            length3++;
                        }
                        this.brr = iArr2;
                        zzarc.zzahd(zzahc);
                        continue;
                    case 168:
                        this.brc = zzarc.mo9107cz();
                        continue;
                    case 176:
                        this.brs = zzarc.mo9107cz();
                        continue;
                    case 186:
                        if (this.brt == null) {
                            this.brt = new zzf();
                        }
                        zzarc.zza(this.brt);
                        continue;
                    case 194:
                        this.brp = zzarc.readString();
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
            if (this.bra != 0) {
                zzx += zzard.zzf(1, this.bra);
            }
            if (!this.tag.equals("")) {
                zzx += zzard.zzs(2, this.tag);
            }
            if (this.bre != null && this.bre.length > 0) {
                int i = zzx;
                for (zze zze : this.bre) {
                    if (zze != null) {
                        i += zzard.zzc(3, (zzark) zze);
                    }
                }
                zzx = i;
            }
            if (!Arrays.equals(this.brf, zzarn.bqM)) {
                zzx += zzard.zzb(4, this.brf);
            }
            if (!Arrays.equals(this.brh, zzarn.bqM)) {
                zzx += zzard.zzb(6, this.brh);
            }
            if (this.brk != null) {
                zzx += zzard.zzc(7, (zzark) this.brk);
            }
            if (!this.bri.equals("")) {
                zzx += zzard.zzs(8, this.bri);
            }
            if (this.brg != null) {
                zzx += zzard.zzc(9, (zzark) this.brg);
            }
            if (this.bak) {
                zzx += zzard.zzk(10, this.bak);
            }
            if (this.brd != 0) {
                zzx += zzard.zzag(11, this.brd);
            }
            if (this.zzajd != 0) {
                zzx += zzard.zzag(12, this.zzajd);
            }
            if (!this.brj.equals("")) {
                zzx += zzard.zzs(13, this.brj);
            }
            if (!this.brl.equals("")) {
                zzx += zzard.zzs(14, this.brl);
            }
            if (this.brm != 180000) {
                zzx += zzard.zzh(15, this.brm);
            }
            if (this.brn != null) {
                zzx += zzard.zzc(16, (zzark) this.brn);
            }
            if (this.brb != 0) {
                zzx += zzard.zzf(17, this.brb);
            }
            if (!Arrays.equals(this.bro, zzarn.bqM)) {
                zzx += zzard.zzb(18, this.bro);
            }
            if (this.brq != 0) {
                zzx += zzard.zzag(19, this.brq);
            }
            if (this.brr != null && this.brr.length > 0) {
                int i2 = 0;
                for (int zzahi : this.brr) {
                    i2 += zzard.zzahi(zzahi);
                }
                zzx = zzx + i2 + (this.brr.length * 2);
            }
            if (this.brc != 0) {
                zzx += zzard.zzf(21, this.brc);
            }
            if (this.brs != 0) {
                zzx += zzard.zzf(22, this.brs);
            }
            if (this.brt != null) {
                zzx += zzard.zzc(23, (zzark) this.brt);
            }
            return !this.brp.equals("") ? zzx + zzard.zzs(24, this.brp) : zzx;
        }
    }

    public static final class zze extends zzare<zze> implements Cloneable {
        private static volatile zze[] bru;
        public String value;
        public String zzcb;

        public zze() {
            mo9218dm();
        }

        /* renamed from: dl */
        public static zze[] m1484dl() {
            if (bru == null) {
                synchronized (zzari.bqD) {
                    if (bru == null) {
                        bru = new zze[0];
                    }
                }
            }
            return bru;
        }

        /* renamed from: cP */
        public /* synthetic */ zzare mo9158cP() throws CloneNotSupportedException {
            return (zze) clone();
        }

        /* renamed from: cQ */
        public /* synthetic */ zzark mo9159cQ() throws CloneNotSupportedException {
            return (zze) clone();
        }

        /* renamed from: dm */
        public zze mo9218dm() {
            this.zzcb = "";
            this.value = "";
            this.bqv = null;
            this.bqE = -1;
            return this;
        }

        /* renamed from: dn */
        public zze clone() {
            try {
                return (zze) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zze)) {
                return false;
            }
            zze zze = (zze) obj;
            if (this.zzcb == null) {
                if (zze.zzcb != null) {
                    return false;
                }
            } else if (!this.zzcb.equals(zze.zzcb)) {
                return false;
            }
            if (this.value == null) {
                if (zze.value != null) {
                    return false;
                }
            } else if (!this.value.equals(zze.value)) {
                return false;
            }
            return (this.bqv == null || this.bqv.isEmpty()) ? zze.bqv == null || zze.bqv.isEmpty() : this.bqv.equals(zze.bqv);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.value == null ? 0 : this.value.hashCode()) + (((this.zzcb == null ? 0 : this.zzcb.hashCode()) + ((getClass().getName().hashCode() + 527) * 31)) * 31)) * 31;
            if (this.bqv != null && !this.bqv.isEmpty()) {
                i = this.bqv.hashCode();
            }
            return hashCode + i;
        }

        public void zza(zzard zzard) throws IOException {
            if (!this.zzcb.equals("")) {
                zzard.zzr(1, this.zzcb);
            }
            if (!this.value.equals("")) {
                zzard.zzr(2, this.value);
            }
            super.zza(zzard);
        }

        /* renamed from: zzcq */
        public zze zzb(zzarc zzarc) throws IOException {
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
            if (!this.zzcb.equals("")) {
                zzx += zzard.zzs(1, this.zzcb);
            }
            return !this.value.equals("") ? zzx + zzard.zzs(2, this.value) : zzx;
        }
    }

    public static final class zzf extends zzare<zzf> implements Cloneable {
        public int brv;

        public zzf() {
            mo9223do();
        }

        /* renamed from: cP */
        public /* synthetic */ zzare mo9158cP() throws CloneNotSupportedException {
            return (zzf) clone();
        }

        /* renamed from: cQ */
        public /* synthetic */ zzark mo9159cQ() throws CloneNotSupportedException {
            return (zzf) clone();
        }

        /* renamed from: do */
        public zzf mo9223do() {
            this.brv = -1;
            this.bqv = null;
            this.bqE = -1;
            return this;
        }

        /* renamed from: dp */
        public zzf clone() {
            try {
                return (zzf) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError(e);
            }
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof zzf)) {
                return false;
            }
            zzf zzf = (zzf) obj;
            if (this.brv == zzf.brv) {
                return (this.bqv == null || this.bqv.isEmpty()) ? zzf.bqv == null || zzf.bqv.isEmpty() : this.bqv.equals(zzf.bqv);
            }
            return false;
        }

        public int hashCode() {
            return ((this.bqv == null || this.bqv.isEmpty()) ? 0 : this.bqv.hashCode()) + ((((getClass().getName().hashCode() + 527) * 31) + this.brv) * 31);
        }

        public void zza(zzard zzard) throws IOException {
            if (this.brv != -1) {
                zzard.zzae(1, this.brv);
            }
            super.zza(zzard);
        }

        /* renamed from: zzcr */
        public zzf zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 8:
                        int cA = zzarc.mo9092cA();
                        switch (cA) {
                            case -1:
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 16:
                            case 17:
                                this.brv = cA;
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
            int zzx = super.zzx();
            return this.brv != -1 ? zzx + zzard.zzag(1, this.brv) : zzx;
        }
    }
}
