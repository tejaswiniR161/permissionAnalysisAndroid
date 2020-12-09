package com.google.android.gms.internal;

import java.io.IOException;

public interface zzad {

    public static final class zza extends zzare<zza> {
        public String stackTrace = null;
        public String zzck = null;
        public Long zzcl = null;
        public String zzcm = null;
        public String zzcn = null;
        public Long zzco = null;
        public Long zzcp = null;
        public String zzcq = null;
        public Long zzcr = null;
        public String zzcs = null;

        public zza() {
            this.bqE = -1;
        }

        /* renamed from: zza */
        public zza zzb(zzarc zzarc) throws IOException {
            while (true) {
                int cw = zzarc.mo9104cw();
                switch (cw) {
                    case 0:
                        break;
                    case 10:
                        this.zzck = zzarc.readString();
                        continue;
                    case 16:
                        this.zzcl = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 26:
                        this.stackTrace = zzarc.readString();
                        continue;
                    case 34:
                        this.zzcm = zzarc.readString();
                        continue;
                    case 42:
                        this.zzcn = zzarc.readString();
                        continue;
                    case 48:
                        this.zzco = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 56:
                        this.zzcp = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 66:
                        this.zzcq = zzarc.readString();
                        continue;
                    case 72:
                        this.zzcr = Long.valueOf(zzarc.mo9107cz());
                        continue;
                    case 82:
                        this.zzcs = zzarc.readString();
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

        public void zza(zzard zzard) throws IOException {
            if (this.zzck != null) {
                zzard.zzr(1, this.zzck);
            }
            if (this.zzcl != null) {
                zzard.zzb(2, this.zzcl.longValue());
            }
            if (this.stackTrace != null) {
                zzard.zzr(3, this.stackTrace);
            }
            if (this.zzcm != null) {
                zzard.zzr(4, this.zzcm);
            }
            if (this.zzcn != null) {
                zzard.zzr(5, this.zzcn);
            }
            if (this.zzco != null) {
                zzard.zzb(6, this.zzco.longValue());
            }
            if (this.zzcp != null) {
                zzard.zzb(7, this.zzcp.longValue());
            }
            if (this.zzcq != null) {
                zzard.zzr(8, this.zzcq);
            }
            if (this.zzcr != null) {
                zzard.zzb(9, this.zzcr.longValue());
            }
            if (this.zzcs != null) {
                zzard.zzr(10, this.zzcs);
            }
            super.zza(zzard);
        }

        /* access modifiers changed from: protected */
        public int zzx() {
            int zzx = super.zzx();
            if (this.zzck != null) {
                zzx += zzard.zzs(1, this.zzck);
            }
            if (this.zzcl != null) {
                zzx += zzard.zzf(2, this.zzcl.longValue());
            }
            if (this.stackTrace != null) {
                zzx += zzard.zzs(3, this.stackTrace);
            }
            if (this.zzcm != null) {
                zzx += zzard.zzs(4, this.zzcm);
            }
            if (this.zzcn != null) {
                zzx += zzard.zzs(5, this.zzcn);
            }
            if (this.zzco != null) {
                zzx += zzard.zzf(6, this.zzco.longValue());
            }
            if (this.zzcp != null) {
                zzx += zzard.zzf(7, this.zzcp.longValue());
            }
            if (this.zzcq != null) {
                zzx += zzard.zzs(8, this.zzcq);
            }
            if (this.zzcr != null) {
                zzx += zzard.zzf(9, this.zzcr.longValue());
            }
            return this.zzcs != null ? zzx + zzard.zzs(10, this.zzcs) : zzx;
        }
    }
}
