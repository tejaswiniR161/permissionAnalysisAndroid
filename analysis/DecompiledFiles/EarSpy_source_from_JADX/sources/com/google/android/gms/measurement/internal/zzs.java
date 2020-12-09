package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzvk;
import java.math.BigDecimal;

class zzs {
    final int apJ;
    BigDecimal apK;
    BigDecimal apL;
    BigDecimal apM;
    final boolean apN;

    public zzs(zzvk.zzd zzd) {
        zzac.zzy(zzd);
        boolean z = true;
        if (zzd.asO == null || zzd.asO.intValue() == 0) {
            z = false;
        } else if (zzd.asO.intValue() != 4) {
            if (zzd.asQ == null) {
                z = false;
            }
        } else if (zzd.asR == null || zzd.asS == null) {
            z = false;
        }
        if (z) {
            this.apJ = zzd.asO.intValue();
            if (zzd.asO.intValue() == 4) {
                z = (!zzal.zznj(zzd.asR) || !zzal.zznj(zzd.asS)) ? false : z;
                try {
                    this.apL = new BigDecimal(zzd.asR);
                    this.apM = new BigDecimal(zzd.asS);
                } catch (NumberFormatException e) {
                    z = false;
                }
            } else {
                z = !zzal.zznj(zzd.asQ) ? false : z;
                try {
                    this.apK = new BigDecimal(zzd.asQ);
                } catch (NumberFormatException e2) {
                    z = false;
                }
            }
        } else {
            this.apJ = 0;
        }
        this.apN = z;
    }

    private Boolean zza(BigDecimal bigDecimal) {
        boolean z = true;
        if (!this.apN) {
            return null;
        }
        if (bigDecimal == null) {
            return null;
        }
        switch (this.apJ) {
            case 1:
                if (bigDecimal.compareTo(this.apK) != -1) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 2:
                if (bigDecimal.compareTo(this.apK) != 1) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 3:
                if (bigDecimal.compareTo(this.apK) != 0) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 4:
                if (bigDecimal.compareTo(this.apL) == -1 || bigDecimal.compareTo(this.apM) == 1) {
                    z = false;
                }
                return Boolean.valueOf(z);
            default:
                return null;
        }
    }

    public Boolean zzbn(long j) {
        try {
            return zza(new BigDecimal(j));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Boolean zzj(double d) {
        boolean z = true;
        if (!this.apN) {
            return null;
        }
        try {
            BigDecimal bigDecimal = new BigDecimal(d);
            switch (this.apJ) {
                case 1:
                    if (bigDecimal.compareTo(this.apK) != -1) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                case 2:
                    if (bigDecimal.compareTo(this.apK) != 1) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                case 3:
                    if (!(bigDecimal.compareTo(this.apK.subtract(new BigDecimal(Math.ulp(d)).multiply(new BigDecimal(2)))) == 1 && bigDecimal.compareTo(this.apK.add(new BigDecimal(Math.ulp(d)).multiply(new BigDecimal(2)))) == -1)) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                case 4:
                    if (bigDecimal.compareTo(this.apL) == -1 || bigDecimal.compareTo(this.apM) == 1) {
                        z = false;
                    }
                    return Boolean.valueOf(z);
                default:
                    return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Boolean zzmk(String str) {
        if (!zzal.zznj(str)) {
            return null;
        }
        try {
            return zza(new BigDecimal(str));
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
