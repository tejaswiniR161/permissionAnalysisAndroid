package com.google.android.gms.ads.internal;

import android.os.Build;
import com.google.android.gms.ads.internal.overlay.zza;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.overlay.zzq;
import com.google.android.gms.ads.internal.overlay.zzr;
import com.google.android.gms.ads.internal.purchase.zzi;
import com.google.android.gms.common.util.zzh;
import com.google.android.gms.internal.zzct;
import com.google.android.gms.internal.zzdf;
import com.google.android.gms.internal.zzdg;
import com.google.android.gms.internal.zzdh;
import com.google.android.gms.internal.zzdl;
import com.google.android.gms.internal.zzfi;
import com.google.android.gms.internal.zzfq;
import com.google.android.gms.internal.zzgc;
import com.google.android.gms.internal.zzgm;
import com.google.android.gms.internal.zzil;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzji;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkr;
import com.google.android.gms.internal.zzks;
import com.google.android.gms.internal.zzkv;
import com.google.android.gms.internal.zzkz;
import com.google.android.gms.internal.zzla;
import com.google.android.gms.internal.zzll;
import com.google.android.gms.internal.zzlo;
import com.google.android.gms.internal.zzlv;

@zziy
public class zzu {
    private static final Object zzaok = new Object();
    private static zzu zzapn;
    private final zza zzapo = new zza();
    private final com.google.android.gms.ads.internal.request.zza zzapp = new com.google.android.gms.ads.internal.request.zza();
    private final zze zzapq = new zze();
    private final zzil zzapr = new zzil();
    private final zzkr zzaps = new zzkr();
    private final zzlv zzapt = new zzlv();
    private final zzks zzapu = zzks.zzbe(Build.VERSION.SDK_INT);
    private final zzct zzapv = new zzct();
    private final zzkh zzapw = new zzkh(this.zzaps);
    private final com.google.android.gms.ads.internal.cache.zza zzapx = new com.google.android.gms.ads.internal.cache.zza();
    private final com.google.android.gms.common.util.zze zzapy = new zzh();
    private final zzg zzapz = new zzg();
    private final zzdl zzaqa = new zzdl();
    private final zzkv zzaqb = new zzkv();
    private final zzji zzaqc = new zzji();
    private final zzdf zzaqd = new zzdf();
    private final zzdg zzaqe = new zzdg();
    private final zzdh zzaqf = new zzdh();
    private final zzll zzaqg = new zzll();
    private final zzi zzaqh = new zzi();
    private final zzfq zzaqi = new zzfq();
    private final zzgc zzaqj = new zzgc();
    private final zzkz zzaqk = new zzkz();
    private final zzq zzaql = new zzq();
    private final zzr zzaqm = new zzr();
    private final zzgm zzaqn = new zzgm();
    private final zzla zzaqo = new zzla();
    private final zzp zzaqp = new zzp();
    private final zzfi zzaqq = new zzfi();
    private final zzlo zzaqr = new zzlo();

    static {
        zza(new zzu());
    }

    protected zzu() {
    }

    protected static void zza(zzu zzu) {
        synchronized (zzaok) {
            zzapn = zzu;
        }
    }

    private static zzu zzfu() {
        zzu zzu;
        synchronized (zzaok) {
            zzu = zzapn;
        }
        return zzu;
    }

    public static com.google.android.gms.ads.internal.request.zza zzfv() {
        return zzfu().zzapp;
    }

    public static zza zzfw() {
        return zzfu().zzapo;
    }

    public static zze zzfx() {
        return zzfu().zzapq;
    }

    public static zzil zzfy() {
        return zzfu().zzapr;
    }

    public static zzkr zzfz() {
        return zzfu().zzaps;
    }

    public static zzlv zzga() {
        return zzfu().zzapt;
    }

    public static zzks zzgb() {
        return zzfu().zzapu;
    }

    public static zzct zzgc() {
        return zzfu().zzapv;
    }

    public static zzkh zzgd() {
        return zzfu().zzapw;
    }

    public static com.google.android.gms.ads.internal.cache.zza zzge() {
        return zzfu().zzapx;
    }

    public static com.google.android.gms.common.util.zze zzgf() {
        return zzfu().zzapy;
    }

    public static zzdl zzgg() {
        return zzfu().zzaqa;
    }

    public static zzkv zzgh() {
        return zzfu().zzaqb;
    }

    public static zzji zzgi() {
        return zzfu().zzaqc;
    }

    public static zzdg zzgj() {
        return zzfu().zzaqe;
    }

    public static zzdf zzgk() {
        return zzfu().zzaqd;
    }

    public static zzdh zzgl() {
        return zzfu().zzaqf;
    }

    public static zzll zzgm() {
        return zzfu().zzaqg;
    }

    public static zzi zzgn() {
        return zzfu().zzaqh;
    }

    public static zzfq zzgo() {
        return zzfu().zzaqi;
    }

    public static zzkz zzgp() {
        return zzfu().zzaqk;
    }

    public static zzq zzgq() {
        return zzfu().zzaql;
    }

    public static zzr zzgr() {
        return zzfu().zzaqm;
    }

    public static zzgm zzgs() {
        return zzfu().zzaqn;
    }

    public static zzp zzgt() {
        return zzfu().zzaqp;
    }

    public static zzla zzgu() {
        return zzfu().zzaqo;
    }

    public static zzg zzgv() {
        return zzfu().zzapz;
    }

    public static zzfi zzgw() {
        return zzfu().zzaqq;
    }

    public static zzlo zzgx() {
        return zzfu().zzaqr;
    }
}
