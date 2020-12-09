package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzvk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

class zzag {
    final boolean apN;
    final int asn;
    final boolean aso;
    final String asp;
    final List<String> asq;
    final String asr;

    public zzag(zzvk.zzf zzf) {
        boolean z;
        boolean z2 = false;
        zzac.zzy(zzf);
        if (zzf.asW == null || zzf.asW.intValue() == 0) {
            z = false;
        } else {
            if (zzf.asW.intValue() == 6) {
                if (zzf.asZ == null || zzf.asZ.length == 0) {
                    z = false;
                }
            } else if (zzf.asX == null) {
                z = false;
            }
            z = true;
        }
        if (z) {
            this.asn = zzf.asW.intValue();
            if (zzf.asY != null && zzf.asY.booleanValue()) {
                z2 = true;
            }
            this.aso = z2;
            if (this.aso || this.asn == 1 || this.asn == 6) {
                this.asp = zzf.asX;
            } else {
                this.asp = zzf.asX.toUpperCase(Locale.ENGLISH);
            }
            this.asq = zzf.asZ == null ? null : zza(zzf.asZ, this.aso);
            if (this.asn == 1) {
                this.asr = this.asp;
            } else {
                this.asr = null;
            }
        } else {
            this.asn = 0;
            this.aso = false;
            this.asp = null;
            this.asq = null;
            this.asr = null;
        }
        this.apN = z;
    }

    private List<String> zza(String[] strArr, boolean z) {
        if (z) {
            return Arrays.asList(strArr);
        }
        ArrayList arrayList = new ArrayList();
        for (String upperCase : strArr) {
            arrayList.add(upperCase.toUpperCase(Locale.ENGLISH));
        }
        return arrayList;
    }

    public Boolean zzmw(String str) {
        if (!this.apN || str == null) {
            return null;
        }
        if (!this.aso && this.asn != 1) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (this.asn) {
            case 1:
                return Boolean.valueOf(Pattern.compile(this.asr, this.aso ? 0 : 66).matcher(str).matches());
            case 2:
                return Boolean.valueOf(str.startsWith(this.asp));
            case 3:
                return Boolean.valueOf(str.endsWith(this.asp));
            case 4:
                return Boolean.valueOf(str.contains(this.asp));
            case 5:
                return Boolean.valueOf(str.equals(this.asp));
            case 6:
                return Boolean.valueOf(this.asq.contains(str));
            default:
                return null;
        }
    }
}
