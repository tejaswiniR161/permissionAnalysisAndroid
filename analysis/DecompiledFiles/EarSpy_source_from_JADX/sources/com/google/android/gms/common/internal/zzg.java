package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class zzg {

    /* renamed from: BB */
    public static final zzg f1697BB = zza((CharSequence) "\t\n\u000b\f\r     　 ᠎ ").zza(zza(8192, 8202));

    /* renamed from: BC */
    public static final zzg f1698BC = zza((CharSequence) "\t\n\u000b\f\r     　").zza(zza(8192, 8198)).zza(zza(8200, 8202));

    /* renamed from: BD */
    public static final zzg f1699BD = zza(0, 127);

    /* renamed from: BE */
    public static final zzg f1700BE;

    /* renamed from: BF */
    public static final zzg f1701BF = zza(9, 13).zza(zza(28, ' ')).zza(zzc(5760)).zza(zzc(6158)).zza(zza(8192, 8198)).zza(zza(8200, 8203)).zza(zza(8232, 8233)).zza(zzc(8287)).zza(zzc(12288));

    /* renamed from: BG */
    public static final zzg f1702BG = new zzg() {
        public boolean zzd(char c) {
            return Character.isDigit(c);
        }
    };

    /* renamed from: BH */
    public static final zzg f1703BH = new zzg() {
        public boolean zzd(char c) {
            return Character.isLetter(c);
        }
    };

    /* renamed from: BI */
    public static final zzg f1704BI = new zzg() {
        public boolean zzd(char c) {
            return Character.isLetterOrDigit(c);
        }
    };

    /* renamed from: BJ */
    public static final zzg f1705BJ = new zzg() {
        public boolean zzd(char c) {
            return Character.isUpperCase(c);
        }
    };

    /* renamed from: BK */
    public static final zzg f1706BK = new zzg() {
        public boolean zzd(char c) {
            return Character.isLowerCase(c);
        }
    };

    /* renamed from: BL */
    public static final zzg f1707BL = zza(0, 31).zza(zza(127, 159));

    /* renamed from: BM */
    public static final zzg f1708BM = zza(0, ' ').zza(zza(127, 160)).zza(zzc(173)).zza(zza(1536, 1539)).zza(zza((CharSequence) "۝܏ ឴឵᠎")).zza(zza(8192, 8207)).zza(zza(8232, 8239)).zza(zza(8287, 8292)).zza(zza(8298, 8303)).zza(zzc(12288)).zza(zza(55296, 63743)).zza(zza((CharSequence) "﻿￹￺￻"));

    /* renamed from: BN */
    public static final zzg f1709BN = zza(0, 1273).zza(zzc(1470)).zza(zza(1488, 1514)).zza(zzc(1523)).zza(zzc(1524)).zza(zza(1536, 1791)).zza(zza(1872, 1919)).zza(zza(3584, 3711)).zza(zza(7680, 8367)).zza(zza(8448, 8506)).zza(zza(64336, 65023)).zza(zza(65136, 65279)).zza(zza(65377, 65500));

    /* renamed from: BO */
    public static final zzg f1710BO = new zzg() {
        public zzg zza(zzg zzg) {
            zzac.zzy(zzg);
            return this;
        }

        public boolean zzb(CharSequence charSequence) {
            zzac.zzy(charSequence);
            return true;
        }

        public boolean zzd(char c) {
            return true;
        }
    };

    /* renamed from: BP */
    public static final zzg f1711BP = new zzg() {
        public zzg zza(zzg zzg) {
            return (zzg) zzac.zzy(zzg);
        }

        public boolean zzb(CharSequence charSequence) {
            return charSequence.length() == 0;
        }

        public boolean zzd(char c) {
            return false;
        }
    };

    private static class zza extends zzg {

        /* renamed from: BW */
        List<zzg> f1718BW;

        zza(List<zzg> list) {
            this.f1718BW = list;
        }

        public zzg zza(zzg zzg) {
            ArrayList arrayList = new ArrayList(this.f1718BW);
            arrayList.add((zzg) zzac.zzy(zzg));
            return new zza(arrayList);
        }

        public boolean zzd(char c) {
            for (zzg zzd : this.f1718BW) {
                if (zzd.zzd(c)) {
                    return true;
                }
            }
            return false;
        }
    }

    static {
        zzg zza2 = zza('0', '9');
        zzg zzg = zza2;
        for (char c : "٠۰߀०০੦૦୦௦౦೦൦๐໐༠၀႐០᠐᥆᧐᭐᮰᱀᱐꘠꣐꤀꩐０".toCharArray()) {
            zzg = zzg.zza(zza(c, (char) (c + 9)));
        }
        f1700BE = zzg;
    }

    public static zzg zza(final char c, final char c2) {
        zzac.zzbs(c2 >= c);
        return new zzg() {
            public boolean zzd(char c) {
                return c <= c && c <= c2;
            }
        };
    }

    public static zzg zza(CharSequence charSequence) {
        switch (charSequence.length()) {
            case 0:
                return f1711BP;
            case 1:
                return zzc(charSequence.charAt(0));
            case 2:
                final char charAt = charSequence.charAt(0);
                final char charAt2 = charSequence.charAt(1);
                return new zzg() {
                    public boolean zzd(char c) {
                        return c == charAt || c == charAt2;
                    }
                };
            default:
                final char[] charArray = charSequence.toString().toCharArray();
                Arrays.sort(charArray);
                return new zzg() {
                    public boolean zzd(char c) {
                        return Arrays.binarySearch(charArray, c) >= 0;
                    }
                };
        }
    }

    public static zzg zzc(final char c) {
        return new zzg() {
            public zzg zza(zzg zzg) {
                return zzg.zzd(c) ? zzg : zzg.super.zza(zzg);
            }

            public boolean zzd(char c) {
                return c == c;
            }
        };
    }

    public zzg zza(zzg zzg) {
        return new zza(Arrays.asList(new zzg[]{this, (zzg) zzac.zzy(zzg)}));
    }

    public boolean zzb(CharSequence charSequence) {
        for (int length = charSequence.length() - 1; length >= 0; length--) {
            if (!zzd(charSequence.charAt(length))) {
                return false;
            }
        }
        return true;
    }

    public abstract boolean zzd(char c);
}
