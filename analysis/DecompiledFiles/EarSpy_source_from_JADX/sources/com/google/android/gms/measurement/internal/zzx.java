package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Size;
import android.support.annotation.WorkerThread;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzard;
import com.google.android.gms.internal.zzvl;
import com.google.android.gms.internal.zzvm;
import com.google.android.gms.measurement.AppMeasurement;
import com.google.android.gms.measurement.internal.zze;
import com.google.android.gms.measurement.internal.zzp;
import com.google.android.gms.measurement.internal.zzq;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class zzx {
    private static volatile zzx aqP;

    /* renamed from: aJ */
    private final boolean f2300aJ;
    private final zzd aqQ;
    private final zzt aqR;
    private final zzp aqS;
    private final zzw aqT;
    private final zzaf aqU;
    private final zzv aqV;
    private final AppMeasurement aqW;
    private final FirebaseAnalytics aqX;
    private final zzal aqY;
    private final zze aqZ;
    private final zzq ara;
    private final zzad arb;
    private final zzg arc;
    private final zzac ard;
    private final zzn are;
    private final zzr arf;
    private final zzai arg;
    private final zzc arh;
    private boolean ari;
    private Boolean arj;
    private FileLock ark;
    private FileChannel arl;
    private List<Long> arm;
    private int arn;
    private int aro;
    private final Context mContext;
    private final zze zzapy;

    private class zza implements zze.zzb {
        zzvm.zze arq;
        List<Long> arr;
        long ars;
        List<zzvm.zzb> zzamv;

        private zza() {
        }

        private long zza(zzvm.zzb zzb) {
            return ((zzb.atp.longValue() / 1000) / 60) / 60;
        }

        /* access modifiers changed from: package-private */
        public boolean isEmpty() {
            return this.zzamv == null || this.zzamv.isEmpty();
        }

        public boolean zza(long j, zzvm.zzb zzb) {
            zzac.zzy(zzb);
            if (this.zzamv == null) {
                this.zzamv = new ArrayList();
            }
            if (this.arr == null) {
                this.arr = new ArrayList();
            }
            if (this.zzamv.size() > 0 && zza(this.zzamv.get(0)) != zza(zzb)) {
                return false;
            }
            long db = this.ars + ((long) zzb.mo9192db());
            if (db >= ((long) zzx.this.zzbvi().zzbuh())) {
                return false;
            }
            this.ars = db;
            this.zzamv.add(zzb);
            this.arr.add(Long.valueOf(j));
            return this.zzamv.size() < zzx.this.zzbvi().zzbui();
        }

        public void zzb(zzvm.zze zze) {
            zzac.zzy(zze);
            this.arq = zze;
        }
    }

    zzx(zzab zzab) {
        zzac.zzy(zzab);
        this.mContext = zzab.mContext;
        this.zzapy = zzab.zzm(this);
        this.aqQ = zzab.zza(this);
        zzt zzb = zzab.zzb(this);
        zzb.initialize();
        this.aqR = zzb;
        zzp zzc = zzab.zzc(this);
        zzc.initialize();
        this.aqS = zzc;
        zzbvg().zzbwh().zzj("App measurement is starting up, version", Long.valueOf(zzbvi().zzbsy()));
        zzbvg().zzbwh().log("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        zzbvg().zzbwi().log("Debug-level message logging enabled");
        zzbvg().zzbwi().zzj("AppMeasurement singleton hash", Integer.valueOf(System.identityHashCode(this)));
        this.aqY = zzab.zzj(this);
        zzg zzo = zzab.zzo(this);
        zzo.initialize();
        this.arc = zzo;
        zzn zzp = zzab.zzp(this);
        zzp.initialize();
        this.are = zzp;
        String zzti = zzp.zzti();
        if (zzbvc().zzni(zzti)) {
            zzbvg().zzbwh().log("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop firebase.analytics.debug-mode .none.");
        } else {
            zzp.zza zzbwh = zzbvg().zzbwh();
            String valueOf = String.valueOf(zzti);
            zzbwh.log(valueOf.length() != 0 ? "To enable faster debug mode event logging run:\n  adb shell setprop firebase.analytics.debug-mode ".concat(valueOf) : new String("To enable faster debug mode event logging run:\n  adb shell setprop firebase.analytics.debug-mode "));
        }
        zze zzk = zzab.zzk(this);
        zzk.initialize();
        this.aqZ = zzk;
        zzc zzs = zzab.zzs(this);
        zzs.initialize();
        this.arh = zzs;
        zzq zzl = zzab.zzl(this);
        zzl.initialize();
        this.ara = zzl;
        zzad zzn = zzab.zzn(this);
        zzn.initialize();
        this.arb = zzn;
        zzac zzi = zzab.zzi(this);
        zzi.initialize();
        this.ard = zzi;
        zzai zzr = zzab.zzr(this);
        zzr.initialize();
        this.arg = zzr;
        this.arf = zzab.zzq(this);
        this.aqW = zzab.zzh(this);
        this.aqX = zzab.zzg(this);
        zzaf zze = zzab.zze(this);
        zze.initialize();
        this.aqU = zze;
        zzv zzf = zzab.zzf(this);
        zzf.initialize();
        this.aqV = zzf;
        zzw zzd = zzab.zzd(this);
        zzd.initialize();
        this.aqT = zzd;
        if (this.arn != this.aro) {
            zzbvg().zzbwc().zze("Not all components initialized", Integer.valueOf(this.arn), Integer.valueOf(this.aro));
        }
        this.f2300aJ = true;
        if (!this.aqQ.zzact() && !zzbxg()) {
            if (!(this.mContext.getApplicationContext() instanceof Application)) {
                zzbvg().zzbwe().log("Application context is not an Application");
            } else if (Build.VERSION.SDK_INT >= 14) {
                zzbux().zzbxv();
            } else {
                zzbvg().zzbwi().log("Not tracking deep linking pre-ICS");
            }
        }
        this.aqT.zzm(new Runnable() {
            public void run() {
                zzx.this.start();
            }
        });
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: private */
    @WorkerThread
    public void zza(int i, Throwable th, byte[] bArr) {
        boolean z = false;
        zzyl();
        zzaax();
        if (bArr == null) {
            bArr = new byte[0];
        }
        List<Long> list = this.arm;
        this.arm = null;
        if ((i == 200 || i == 204) && th == null) {
            zzbvh().apQ.set(zzaan().currentTimeMillis());
            zzbvh().apR.set(0);
            zzbxm();
            zzbvg().zzbwj().zze("Successful upload. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
            zzbvb().beginTransaction();
            try {
                for (Long longValue : list) {
                    zzbvb().zzbk(longValue.longValue());
                }
                zzbvb().setTransactionSuccessful();
                zzbvb().endTransaction();
                if (!zzbxa().zzafa() || !zzbxl()) {
                    zzbxm();
                } else {
                    zzbxk();
                }
            } catch (Throwable th2) {
                zzbvb().endTransaction();
                throw th2;
            }
        } else {
            zzbvg().zzbwj().zze("Network upload failed. Will retry later. code, error", Integer.valueOf(i), th);
            zzbvh().apR.set(zzaan().currentTimeMillis());
            if (i == 503 || i == 429) {
                z = true;
            }
            if (z) {
                zzbvh().apS.set(zzaan().currentTimeMillis());
            }
            zzbxm();
        }
    }

    private void zza(zzaa zzaa) {
        if (zzaa == null) {
            throw new IllegalStateException("Component not created");
        } else if (!zzaa.isInitialized()) {
            throw new IllegalStateException("Component not initialized");
        }
    }

    private void zza(zzz zzz) {
        if (zzz == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private boolean zza(zzh zzh) {
        if (zzh.aos == null) {
            return false;
        }
        Iterator<String> it = zzh.aos.iterator();
        while (it.hasNext()) {
            if ("_r".equals(it.next())) {
                return true;
            }
        }
        return zzbvd().zzay(zzh.zzcpe, zzh.mName) && zzbvb().zza(zzbxh(), zzh.zzcpe, false, false, false, false, false).aoj < ((long) zzbvi().zzlq(zzh.zzcpe));
    }

    private zzvm.zza[] zza(String str, zzvm.zzg[] zzgArr, zzvm.zzb[] zzbArr) {
        zzac.zzhz(str);
        return zzbuw().zza(str, zzbArr, zzgArr);
    }

    private void zzag(List<Long> list) {
        zzac.zzbs(!list.isEmpty());
        if (this.arm != null) {
            zzbvg().zzbwc().log("Set uploading progress before finishing the previous upload");
        } else {
            this.arm = new ArrayList(list);
        }
    }

    @WorkerThread
    private boolean zzbxj() {
        zzyl();
        return this.arm != null;
    }

    private boolean zzbxl() {
        zzyl();
        zzaax();
        return zzbvb().zzbvp() || !TextUtils.isEmpty(zzbvb().zzbvj());
    }

    @WorkerThread
    private void zzbxm() {
        zzyl();
        zzaax();
        if (zzbxq()) {
            if (!zzbwv() || !zzbxl()) {
                zzbxb().unregister();
                zzbxc().cancel();
                return;
            }
            long zzbxn = zzbxn();
            if (zzbxn == 0) {
                zzbxb().unregister();
                zzbxc().cancel();
            } else if (!zzbxa().zzafa()) {
                zzbxb().zzaex();
                zzbxc().cancel();
            } else {
                long j = zzbvh().apS.get();
                long zzbul = zzbvi().zzbul();
                if (!zzbvc().zzg(j, zzbul)) {
                    zzbxn = Math.max(zzbxn, j + zzbul);
                }
                zzbxb().unregister();
                long currentTimeMillis = zzbxn - zzaan().currentTimeMillis();
                if (currentTimeMillis <= 0) {
                    currentTimeMillis = zzbvi().zzbuo();
                }
                zzbvg().zzbwj().zzj("Upload scheduled in approximately ms", Long.valueOf(currentTimeMillis));
                zzbxc().zzx(currentTimeMillis);
            }
        }
    }

    private long zzbxn() {
        long currentTimeMillis = zzaan().currentTimeMillis();
        long zzbur = zzbvi().zzbur();
        boolean z = zzbvb().zzbvq() || zzbvb().zzbvk();
        long zzbun = z ? zzbvi().zzbun() : zzbvi().zzbum();
        long j = zzbvh().apQ.get();
        long j2 = zzbvh().apR.get();
        long max = Math.max(zzbvb().zzbvn(), zzbvb().zzbvo());
        if (max == 0) {
            return 0;
        }
        long abs = currentTimeMillis - Math.abs(max - currentTimeMillis);
        long abs2 = currentTimeMillis - Math.abs(j2 - currentTimeMillis);
        long max2 = Math.max(currentTimeMillis - Math.abs(j - currentTimeMillis), abs2);
        long j3 = abs + zzbur;
        if (z && max2 > 0) {
            j3 = Math.min(abs, max2) + zzbun;
        }
        if (!zzbvc().zzg(max2, zzbun)) {
            j3 = max2 + zzbun;
        }
        if (abs2 == 0 || abs2 < abs) {
            return j3;
        }
        for (int i = 0; i < zzbvi().zzbut(); i++) {
            j3 += ((long) (1 << i)) * zzbvi().zzbus();
            if (j3 > abs2) {
                return j3;
            }
        }
        return 0;
    }

    public static zzx zzdt(Context context) {
        zzac.zzy(context);
        zzac.zzy(context.getApplicationContext());
        if (aqP == null) {
            synchronized (zzx.class) {
                if (aqP == null) {
                    aqP = new zzab(context).zzbxu();
                }
            }
        }
        return aqP;
    }

    @WorkerThread
    private void zze(AppMetadata appMetadata) {
        boolean z = true;
        zzyl();
        zzaax();
        zzac.zzy(appMetadata);
        zzac.zzhz(appMetadata.packageName);
        zza zzlz = zzbvb().zzlz(appMetadata.packageName);
        String zzmm = zzbvh().zzmm(appMetadata.packageName);
        boolean z2 = false;
        if (zzlz == null) {
            zza zza2 = new zza(this, appMetadata.packageName);
            zza2.zzlj(zzbvh().zzbwm());
            zza2.zzll(zzmm);
            zzlz = zza2;
            z2 = true;
        } else if (!zzmm.equals(zzlz.zzbss())) {
            zzlz.zzll(zzmm);
            zzlz.zzlj(zzbvh().zzbwm());
            z2 = true;
        }
        if (!TextUtils.isEmpty(appMetadata.anQ) && !appMetadata.anQ.equals(zzlz.zzbsr())) {
            zzlz.zzlk(appMetadata.anQ);
            z2 = true;
        }
        if (!TextUtils.isEmpty(appMetadata.anY) && !appMetadata.anY.equals(zzlz.zzbst())) {
            zzlz.zzlm(appMetadata.anY);
            z2 = true;
        }
        if (!(appMetadata.anS == 0 || appMetadata.anS == zzlz.zzbsy())) {
            zzlz.zzaz(appMetadata.anS);
            z2 = true;
        }
        if (!TextUtils.isEmpty(appMetadata.afY) && !appMetadata.afY.equals(zzlz.zzyt())) {
            zzlz.setAppVersion(appMetadata.afY);
            z2 = true;
        }
        if (appMetadata.anX != zzlz.zzbsw()) {
            zzlz.zzay(appMetadata.anX);
            z2 = true;
        }
        if (!TextUtils.isEmpty(appMetadata.anR) && !appMetadata.anR.equals(zzlz.zzbsx())) {
            zzlz.zzln(appMetadata.anR);
            z2 = true;
        }
        if (appMetadata.anT != zzlz.zzbsz()) {
            zzlz.zzba(appMetadata.anT);
            z2 = true;
        }
        if (appMetadata.anV != zzlz.zzbta()) {
            zzlz.setMeasurementEnabled(appMetadata.anV);
        } else {
            z = z2;
        }
        if (z) {
            zzbvb().zza(zzlz);
        }
    }

    /* JADX INFO: finally extract failed */
    private boolean zzj(String str, long j) {
        boolean z;
        int i;
        boolean z2;
        int i2;
        boolean z3;
        boolean z4;
        zzbvb().beginTransaction();
        try {
            zza zza2 = new zza();
            zzbvb().zza(str, j, (zze.zzb) zza2);
            if (!zza2.isEmpty()) {
                boolean z5 = false;
                zzvm.zze zze = zza2.arq;
                zze.atw = new zzvm.zzb[zza2.zzamv.size()];
                int i3 = 0;
                int i4 = 0;
                while (i4 < zza2.zzamv.size()) {
                    if (zzbvd().zzax(zza2.arq.zzck, zza2.zzamv.get(i4).name)) {
                        zzbvg().zzbwe().zzj("Dropping blacklisted raw event", zza2.zzamv.get(i4).name);
                        zzbvc().zza(11, "_ev", zza2.zzamv.get(i4).name, 0);
                        i = i3;
                        z2 = z5;
                    } else {
                        if (zzbvd().zzay(zza2.arq.zzck, zza2.zzamv.get(i4).name)) {
                            boolean z6 = false;
                            boolean z7 = false;
                            if (zza2.zzamv.get(i4).ato == null) {
                                zza2.zzamv.get(i4).ato = new zzvm.zzc[0];
                            }
                            zzvm.zzc[] zzcArr = zza2.zzamv.get(i4).ato;
                            int length = zzcArr.length;
                            int i5 = 0;
                            while (i5 < length) {
                                zzvm.zzc zzc = zzcArr[i5];
                                if ("_c".equals(zzc.name)) {
                                    zzc.ats = 1L;
                                    z6 = true;
                                    z4 = z7;
                                } else if ("_r".equals(zzc.name)) {
                                    zzc.ats = 1L;
                                    z4 = true;
                                } else {
                                    z4 = z7;
                                }
                                i5++;
                                z7 = z4;
                            }
                            if (!z6) {
                                zzbvg().zzbwj().zzj("Marking event as conversion", zza2.zzamv.get(i4).name);
                                zzvm.zzc[] zzcArr2 = (zzvm.zzc[]) Arrays.copyOf(zza2.zzamv.get(i4).ato, zza2.zzamv.get(i4).ato.length + 1);
                                zzvm.zzc zzc2 = new zzvm.zzc();
                                zzc2.name = "_c";
                                zzc2.ats = 1L;
                                zzcArr2[zzcArr2.length - 1] = zzc2;
                                zza2.zzamv.get(i4).ato = zzcArr2;
                            }
                            if (!z7) {
                                zzbvg().zzbwj().zzj("Marking event as real-time", zza2.zzamv.get(i4).name);
                                zzvm.zzc[] zzcArr3 = (zzvm.zzc[]) Arrays.copyOf(zza2.zzamv.get(i4).ato, zza2.zzamv.get(i4).ato.length + 1);
                                zzvm.zzc zzc3 = new zzvm.zzc();
                                zzc3.name = "_r";
                                zzc3.ats = 1L;
                                zzcArr3[zzcArr3.length - 1] = zzc3;
                                zza2.zzamv.get(i4).ato = zzcArr3;
                            }
                            boolean zzmx = zzal.zzmx(zza2.zzamv.get(i4).name);
                            if (zzbvb().zza(zzbxh(), zza2.arq.zzck, false, false, false, false, true).aoj > ((long) zzbvi().zzlq(zza2.arq.zzck))) {
                                zzvm.zzb zzb = zza2.zzamv.get(i4);
                                int i6 = 0;
                                while (true) {
                                    if (i6 >= zzb.ato.length) {
                                        break;
                                    } else if ("_r".equals(zzb.ato[i6].name)) {
                                        zzvm.zzc[] zzcArr4 = new zzvm.zzc[(zzb.ato.length - 1)];
                                        if (i6 > 0) {
                                            System.arraycopy(zzb.ato, 0, zzcArr4, 0, i6);
                                        }
                                        if (i6 < zzcArr4.length) {
                                            System.arraycopy(zzb.ato, i6 + 1, zzcArr4, i6, zzcArr4.length - i6);
                                        }
                                        zzb.ato = zzcArr4;
                                    } else {
                                        i6++;
                                    }
                                }
                            } else {
                                z5 = true;
                            }
                            if (zzmx && zzbvb().zza(zzbxh(), zza2.arq.zzck, false, false, true, false, false).aoh > ((long) zzbvi().zzlp(zza2.arq.zzck))) {
                                zzbvg().zzbwe().log("Too many conversions. Not logging as conversion.");
                                zzvm.zzb zzb2 = zza2.zzamv.get(i4);
                                boolean z8 = false;
                                zzvm.zzc zzc4 = null;
                                zzvm.zzc[] zzcArr5 = zzb2.ato;
                                int length2 = zzcArr5.length;
                                int i7 = 0;
                                while (i7 < length2) {
                                    zzvm.zzc zzc5 = zzcArr5[i7];
                                    if ("_c".equals(zzc5.name)) {
                                        z3 = z8;
                                    } else if ("_err".equals(zzc5.name)) {
                                        zzvm.zzc zzc6 = zzc4;
                                        z3 = true;
                                        zzc5 = zzc6;
                                    } else {
                                        zzc5 = zzc4;
                                        z3 = z8;
                                    }
                                    i7++;
                                    z8 = z3;
                                    zzc4 = zzc5;
                                }
                                if (z8 && zzc4 != null) {
                                    zzvm.zzc[] zzcArr6 = new zzvm.zzc[(zzb2.ato.length - 1)];
                                    int i8 = 0;
                                    zzvm.zzc[] zzcArr7 = zzb2.ato;
                                    int length3 = zzcArr7.length;
                                    int i9 = 0;
                                    while (i9 < length3) {
                                        zzvm.zzc zzc7 = zzcArr7[i9];
                                        if (zzc7 != zzc4) {
                                            i2 = i8 + 1;
                                            zzcArr6[i8] = zzc7;
                                        } else {
                                            i2 = i8;
                                        }
                                        i9++;
                                        i8 = i2;
                                    }
                                    zzb2.ato = zzcArr6;
                                    z = z5;
                                    zze.atw[i3] = zza2.zzamv.get(i4);
                                    i = i3 + 1;
                                    z2 = z;
                                } else if (zzc4 != null) {
                                    zzc4.name = "_err";
                                    zzc4.ats = 10L;
                                    z = z5;
                                    zze.atw[i3] = zza2.zzamv.get(i4);
                                    i = i3 + 1;
                                    z2 = z;
                                } else {
                                    zzbvg().zzbwc().log("Did not find conversion parameter. Error not tracked");
                                }
                            }
                        }
                        z = z5;
                        zze.atw[i3] = zza2.zzamv.get(i4);
                        i = i3 + 1;
                        z2 = z;
                    }
                    i4++;
                    i3 = i;
                    z5 = z2;
                }
                if (i3 < zza2.zzamv.size()) {
                    zze.atw = (zzvm.zzb[]) Arrays.copyOf(zze.atw, i3);
                }
                zze.atP = zza(zza2.arq.zzck, zza2.arq.atx, zze.atw);
                zze.atz = zze.atw[0].atp;
                zze.atA = zze.atw[0].atp;
                for (int i10 = 1; i10 < zze.atw.length; i10++) {
                    zzvm.zzb zzb3 = zze.atw[i10];
                    if (zzb3.atp.longValue() < zze.atz.longValue()) {
                        zze.atz = zzb3.atp;
                    }
                    if (zzb3.atp.longValue() > zze.atA.longValue()) {
                        zze.atA = zzb3.atp;
                    }
                }
                String str2 = zza2.arq.zzck;
                zza zzlz = zzbvb().zzlz(str2);
                if (zzlz == null) {
                    zzbvg().zzbwc().log("Bundling raw events w/o app info");
                } else {
                    long zzbsv = zzlz.zzbsv();
                    zze.atC = zzbsv != 0 ? Long.valueOf(zzbsv) : null;
                    long zzbsu = zzlz.zzbsu();
                    if (zzbsu != 0) {
                        zzbsv = zzbsu;
                    }
                    zze.atB = zzbsv != 0 ? Long.valueOf(zzbsv) : null;
                    zzlz.zzbte();
                    zze.atN = Integer.valueOf((int) zzlz.zzbtb());
                    zzlz.zzaw(zze.atz.longValue());
                    zzlz.zzax(zze.atA.longValue());
                    zzbvb().zza(zzlz);
                }
                zze.anU = zzbvg().zzbwk();
                zzbvb().zza(zze, z5);
                zzbvb().zzaf(zza2.arr);
                zzbvb().zzmg(str2);
                zzbvb().setTransactionSuccessful();
                zzbvb().endTransaction();
                return true;
            }
            zzbvb().setTransactionSuccessful();
            zzbvb().endTransaction();
            return false;
        } catch (Throwable th) {
            zzbvb().endTransaction();
            throw th;
        }
    }

    public Context getContext() {
        return this.mContext;
    }

    @WorkerThread
    public boolean isEnabled() {
        boolean z = false;
        zzyl();
        zzaax();
        if (zzbvi().zzbuc()) {
            return false;
        }
        Boolean zzbud = zzbvi().zzbud();
        if (zzbud != null) {
            z = zzbud.booleanValue();
        } else if (!zzbvi().zzasm()) {
            z = true;
        }
        return zzbvh().zzcg(z);
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public void start() {
        zzyl();
        if (!zzbxg() || (this.aqT.isInitialized() && !this.aqT.zzbxt())) {
            zzbvb().zzbvl();
            if (zzbvh().apQ.get() == 0) {
                zzbvh().apQ.set(zzaan().currentTimeMillis());
            }
            if (zzbwv()) {
                if (!zzbvi().zzact() && !TextUtils.isEmpty(zzbuy().zzbsr())) {
                    String zzbwp = zzbvh().zzbwp();
                    if (zzbwp == null) {
                        zzbvh().zzmn(zzbuy().zzbsr());
                    } else if (!zzbwp.equals(zzbuy().zzbsr())) {
                        zzbvg().zzbwh().log("Rechecking which service to use due to a GMP App Id change");
                        zzbvh().zzbwr();
                        this.arb.disconnect();
                        this.arb.zzabz();
                        zzbvh().zzmn(zzbuy().zzbsr());
                    }
                }
                if (!zzbvi().zzact() && !zzbxg() && !TextUtils.isEmpty(zzbuy().zzbsr())) {
                    zzbux().zzbxw();
                }
            } else if (isEnabled()) {
                if (!zzbvc().zzew("android.permission.INTERNET")) {
                    zzbvg().zzbwc().log("App is missing INTERNET permission");
                }
                if (!zzbvc().zzew("android.permission.ACCESS_NETWORK_STATE")) {
                    zzbvg().zzbwc().log("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!zzbvi().zzact()) {
                    if (!zzu.zzh(getContext(), false)) {
                        zzbvg().zzbwc().log("AppMeasurementReceiver not registered/enabled");
                    }
                    if (!zzae.zzi(getContext(), false)) {
                        zzbvg().zzbwc().log("AppMeasurementService not registered/enabled");
                    }
                }
                if (!zzbxg()) {
                    zzbvg().zzbwc().log("Uploading is not possible. App measurement disabled");
                }
            }
            zzbxm();
            return;
        }
        zzbvg().zzbwc().log("Scheduler shutting down before Scion.start() called");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public int zza(FileChannel fileChannel) {
        zzyl();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzbvg().zzbwc().log("Bad chanel to read from");
            return 0;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        try {
            fileChannel.position(0);
            int read = fileChannel.read(allocate);
            if (read == 4) {
                allocate.flip();
                return allocate.getInt();
            } else if (read == -1) {
                return 0;
            } else {
                zzbvg().zzbwe().zzj("Unexpected data length. Bytes read", Integer.valueOf(read));
                return 0;
            }
        } catch (IOException e) {
            zzbvg().zzbwc().zzj("Failed to read from channel", e);
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zza(AppMetadata appMetadata, long j) {
        zza zzlz = zzbvb().zzlz(appMetadata.packageName);
        if (!(zzlz == null || zzlz.zzbsr() == null || zzlz.zzbsr().equals(appMetadata.anQ))) {
            zzbvg().zzbwe().log("New GMP App Id passed in. Removing cached database data.");
            zzbvb().zzme(zzlz.zzti());
            zzlz = null;
        }
        if (zzlz != null && zzlz.zzyt() != null && !zzlz.zzyt().equals(appMetadata.afY)) {
            Bundle bundle = new Bundle();
            bundle.putString("_pv", zzlz.zzyt());
            zzb(new EventParcel("_au", new EventParams(bundle), "auto", j), appMetadata);
        }
    }

    /* access modifiers changed from: package-private */
    public void zza(zzh zzh, AppMetadata appMetadata) {
        zzyl();
        zzaax();
        zzac.zzy(zzh);
        zzac.zzy(appMetadata);
        zzac.zzhz(zzh.zzcpe);
        zzac.zzbs(zzh.zzcpe.equals(appMetadata.packageName));
        zzvm.zze zze = new zzvm.zze();
        zze.atv = 1;
        zze.atD = "android";
        zze.zzck = appMetadata.packageName;
        zze.anR = appMetadata.anR;
        zze.afY = appMetadata.afY;
        zze.atQ = Integer.valueOf((int) appMetadata.anX);
        zze.atH = Long.valueOf(appMetadata.anS);
        zze.anQ = appMetadata.anQ;
        zze.atM = appMetadata.anT == 0 ? null : Long.valueOf(appMetadata.anT);
        Pair<String, Boolean> zzml = zzbvh().zzml(appMetadata.packageName);
        if (zzml != null && !TextUtils.isEmpty((CharSequence) zzml.first)) {
            zze.atJ = (String) zzml.first;
            zze.atK = (Boolean) zzml.second;
        } else if (!zzbuz().zzds(this.mContext)) {
            String string = Settings.Secure.getString(this.mContext.getContentResolver(), "android_id");
            if (string == null) {
                zzbvg().zzbwe().log("null secure ID");
                string = "null";
            } else if (string.isEmpty()) {
                zzbvg().zzbwe().log("empty secure ID");
            }
            zze.atT = string;
        }
        zze.atE = zzbuz().zzuj();
        zze.zzct = zzbuz().zzbvv();
        zze.atG = Integer.valueOf((int) zzbuz().zzbvw());
        zze.atF = zzbuz().zzbvx();
        zze.atI = null;
        zze.aty = null;
        zze.atz = null;
        zze.atA = null;
        zza zzlz = zzbvb().zzlz(appMetadata.packageName);
        if (zzlz == null) {
            zzlz = new zza(this, appMetadata.packageName);
            zzlz.zzlj(zzbvh().zzbwm());
            zzlz.zzlm(appMetadata.anY);
            zzlz.zzlk(appMetadata.anQ);
            zzlz.zzll(zzbvh().zzmm(appMetadata.packageName));
            zzlz.zzbb(0);
            zzlz.zzaw(0);
            zzlz.zzax(0);
            zzlz.setAppVersion(appMetadata.afY);
            zzlz.zzay(appMetadata.anX);
            zzlz.zzln(appMetadata.anR);
            zzlz.zzaz(appMetadata.anS);
            zzlz.zzba(appMetadata.anT);
            zzlz.setMeasurementEnabled(appMetadata.anV);
            zzbvb().zza(zzlz);
        }
        zze.atL = zzlz.zzayn();
        zze.anY = zzlz.zzbst();
        List<zzak> zzly = zzbvb().zzly(appMetadata.packageName);
        zze.atx = new zzvm.zzg[zzly.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < zzly.size()) {
                zzvm.zzg zzg = new zzvm.zzg();
                zze.atx[i2] = zzg;
                zzg.name = zzly.get(i2).mName;
                zzg.atX = Long.valueOf(zzly.get(i2).asy);
                zzbvc().zza(zzg, zzly.get(i2).zzctv);
                i = i2 + 1;
            } else {
                try {
                    zzbvb().zza(zzh, zzbvb().zza(zze), zza(zzh));
                    return;
                } catch (IOException e) {
                    zzbvg().zzbwc().zzj("Data loss. Failed to insert raw event metadata", e);
                    return;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public boolean zza(int i, FileChannel fileChannel) {
        zzyl();
        if (fileChannel == null || !fileChannel.isOpen()) {
            zzbvg().zzbwc().log("Bad chanel to read from");
            return false;
        }
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt(i);
        allocate.flip();
        try {
            fileChannel.truncate(0);
            fileChannel.write(allocate);
            fileChannel.force(true);
            if (fileChannel.size() == 4) {
                return true;
            }
            zzbvg().zzbwc().zzj("Error writing to channel. Bytes written", Long.valueOf(fileChannel.size()));
            return true;
        } catch (IOException e) {
            zzbvg().zzbwc().zzj("Failed to write to channel", e);
            return false;
        }
    }

    @WorkerThread
    public byte[] zza(@NonNull EventParcel eventParcel, @Size(min = 1) String str) {
        long j;
        zzaax();
        zzyl();
        zzbxi();
        zzac.zzy(eventParcel);
        zzac.zzhz(str);
        zzvm.zzd zzd = new zzvm.zzd();
        zzbvb().beginTransaction();
        try {
            zza zzlz = zzbvb().zzlz(str);
            if (zzlz == null) {
                zzbvg().zzbwi().zzj("Log and bundle not available. package_name", str);
                return new byte[0];
            } else if (!zzlz.zzbta()) {
                zzbvg().zzbwi().zzj("Log and bundle disabled. package_name", str);
                byte[] bArr = new byte[0];
                zzbvb().endTransaction();
                return bArr;
            } else {
                zzvm.zze zze = new zzvm.zze();
                zzd.att = new zzvm.zze[]{zze};
                zze.atv = 1;
                zze.atD = "android";
                zze.zzck = zzlz.zzti();
                zze.anR = zzlz.zzbsx();
                zze.afY = zzlz.zzyt();
                zze.atQ = Integer.valueOf((int) zzlz.zzbsw());
                zze.atH = Long.valueOf(zzlz.zzbsy());
                zze.anQ = zzlz.zzbsr();
                zze.atM = Long.valueOf(zzlz.zzbsz());
                Pair<String, Boolean> zzml = zzbvh().zzml(zzlz.zzti());
                if (zzml != null && !TextUtils.isEmpty((CharSequence) zzml.first)) {
                    zze.atJ = (String) zzml.first;
                    zze.atK = (Boolean) zzml.second;
                }
                zze.atE = zzbuz().zzuj();
                zze.zzct = zzbuz().zzbvv();
                zze.atG = Integer.valueOf((int) zzbuz().zzbvw());
                zze.atF = zzbuz().zzbvx();
                zze.atL = zzlz.zzayn();
                zze.anY = zzlz.zzbst();
                List<zzak> zzly = zzbvb().zzly(zzlz.zzti());
                zze.atx = new zzvm.zzg[zzly.size()];
                for (int i = 0; i < zzly.size(); i++) {
                    zzvm.zzg zzg = new zzvm.zzg();
                    zze.atx[i] = zzg;
                    zzg.name = zzly.get(i).mName;
                    zzg.atX = Long.valueOf(zzly.get(i).asy);
                    zzbvc().zza(zzg, zzly.get(i).zzctv);
                }
                Bundle zzbvz = eventParcel.aoz.zzbvz();
                if ("_iap".equals(eventParcel.name)) {
                    zzbvz.putLong("_c", 1);
                    zzbvg().zzbwi().log("Marking in-app purchase as real-time");
                    zzbvz.putLong("_r", 1);
                }
                zzbvz.putString("_o", eventParcel.aoA);
                if (zzbvc().zzni(zze.zzck)) {
                    zzbvc().zza(zzbvz, "_dbg", (Object) 1L);
                    zzbvc().zza(zzbvz, "_r", (Object) 1L);
                }
                zzi zzaq = zzbvb().zzaq(str, eventParcel.name);
                if (zzaq == null) {
                    zzbvb().zza(new zzi(str, eventParcel.name, 1, 0, eventParcel.aoB));
                    j = 0;
                } else {
                    j = zzaq.aov;
                    zzbvb().zza(zzaq.zzbm(eventParcel.aoB).zzbvy());
                }
                zzh zzh = new zzh(this, eventParcel.aoA, str, eventParcel.name, eventParcel.aoB, j, zzbvz);
                zzvm.zzb zzb = new zzvm.zzb();
                zze.atw = new zzvm.zzb[]{zzb};
                zzb.atp = Long.valueOf(zzh.f2285tr);
                zzb.name = zzh.mName;
                zzb.atq = Long.valueOf(zzh.aor);
                zzb.ato = new zzvm.zzc[zzh.aos.size()];
                Iterator<String> it = zzh.aos.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    String next = it.next();
                    zzvm.zzc zzc = new zzvm.zzc();
                    zzb.ato[i2] = zzc;
                    zzc.name = next;
                    zzbvc().zza(zzc, zzh.aos.get(next));
                    i2++;
                }
                zze.atP = zza(zzlz.zzti(), zze.atx, zze.atw);
                zze.atz = zzb.atp;
                zze.atA = zzb.atp;
                long zzbsv = zzlz.zzbsv();
                zze.atC = zzbsv != 0 ? Long.valueOf(zzbsv) : null;
                long zzbsu = zzlz.zzbsu();
                if (zzbsu != 0) {
                    zzbsv = zzbsu;
                }
                zze.atB = zzbsv != 0 ? Long.valueOf(zzbsv) : null;
                zzlz.zzbte();
                zze.atN = Integer.valueOf((int) zzlz.zzbtb());
                zze.atI = Long.valueOf(zzbvi().zzbsy());
                zze.aty = Long.valueOf(zzaan().currentTimeMillis());
                zze.atO = Boolean.TRUE;
                zzlz.zzaw(zze.atz.longValue());
                zzlz.zzax(zze.atA.longValue());
                zzbvb().zza(zzlz);
                zzbvb().setTransactionSuccessful();
                zzbvb().endTransaction();
                try {
                    byte[] bArr2 = new byte[zzd.mo9192db()];
                    zzard zzbe = zzard.zzbe(bArr2);
                    zzd.zza(zzbe);
                    zzbe.mo9123cO();
                    return zzbvc().zzj(bArr2);
                } catch (IOException e) {
                    zzbvg().zzbwc().zzj("Data loss. Failed to bundle and serialize", e);
                    return null;
                }
            }
        } finally {
            zzbvb().endTransaction();
        }
    }

    /* access modifiers changed from: package-private */
    public void zzaam() {
        if (zzbvi().zzact()) {
            throw new IllegalStateException("Unexpected call on package side");
        }
    }

    public com.google.android.gms.common.util.zze zzaan() {
        return this.zzapy;
    }

    /* access modifiers changed from: package-private */
    public void zzaax() {
        if (!this.f2300aJ) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
    }

    public void zzav(boolean z) {
        zzbxm();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzb(AppMetadata appMetadata, long j) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        zzyl();
        zzaax();
        Bundle bundle = new Bundle();
        bundle.putLong("_c", 1);
        bundle.putLong("_r", 1);
        bundle.putLong("_uwa", 0);
        bundle.putLong("_pfo", 0);
        bundle.putLong("_sys", 0);
        bundle.putLong("_sysu", 0);
        PackageManager packageManager = getContext().getPackageManager();
        if (packageManager == null) {
            zzbvg().zzbwc().log("PackageManager is null, first open report might be inaccurate");
        } else {
            try {
                packageInfo = packageManager.getPackageInfo(appMetadata.packageName, 0);
            } catch (PackageManager.NameNotFoundException e) {
                zzbvg().zzbwc().zzj("Package info is null, first open report might be inaccurate", e);
                packageInfo = null;
            }
            if (!(packageInfo == null || packageInfo.firstInstallTime == 0 || packageInfo.firstInstallTime == packageInfo.lastUpdateTime)) {
                bundle.putLong("_uwa", 1);
            }
            try {
                applicationInfo = packageManager.getApplicationInfo(appMetadata.packageName, 0);
            } catch (PackageManager.NameNotFoundException e2) {
                zzbvg().zzbwc().zzj("Application info is null, first open report might be inaccurate", e2);
                applicationInfo = null;
            }
            if (applicationInfo != null) {
                if ((applicationInfo.flags & 1) != 0) {
                    bundle.putLong("_sys", 1);
                }
                if ((applicationInfo.flags & 128) != 0) {
                    bundle.putLong("_sysu", 1);
                }
            }
        }
        long zzmf = zzbvb().zzmf(appMetadata.packageName);
        if (zzmf != 0) {
            bundle.putLong("_pfo", zzmf);
        }
        zzb(new EventParcel("_f", new EventParams(bundle), "auto", j), appMetadata);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:49:0x01d5=Splitter:B:49:0x01d5, B:78:0x02bc=Splitter:B:78:0x02bc} */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzb(com.google.android.gms.measurement.internal.EventParcel r19, com.google.android.gms.measurement.internal.AppMetadata r20) {
        /*
            r18 = this;
            long r16 = java.lang.System.nanoTime()
            r18.zzyl()
            r18.zzaax()
            r0 = r20
            java.lang.String r4 = r0.packageName
            com.google.android.gms.common.internal.zzac.zzhz(r4)
            r0 = r20
            java.lang.String r2 = r0.anQ
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L_0x001c
        L_0x001b:
            return
        L_0x001c:
            r0 = r20
            boolean r2 = r0.anV
            if (r2 != 0) goto L_0x002a
            r0 = r18
            r1 = r20
            r0.zze(r1)
            goto L_0x001b
        L_0x002a:
            com.google.android.gms.measurement.internal.zzv r2 = r18.zzbvd()
            r0 = r19
            java.lang.String r3 = r0.name
            boolean r2 = r2.zzax(r4, r3)
            if (r2 == 0) goto L_0x005a
            com.google.android.gms.measurement.internal.zzp r2 = r18.zzbvg()
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbwe()
            java.lang.String r3 = "Dropping blacklisted event"
            r0 = r19
            java.lang.String r4 = r0.name
            r2.zzj(r3, r4)
            com.google.android.gms.measurement.internal.zzal r2 = r18.zzbvc()
            r3 = 11
            java.lang.String r4 = "_ev"
            r0 = r19
            java.lang.String r5 = r0.name
            r6 = 0
            r2.zza((int) r3, (java.lang.String) r4, (java.lang.String) r5, (int) r6)
            goto L_0x001b
        L_0x005a:
            com.google.android.gms.measurement.internal.zzp r2 = r18.zzbvg()
            r3 = 2
            boolean r2 = r2.zzbf(r3)
            if (r2 == 0) goto L_0x0074
            com.google.android.gms.measurement.internal.zzp r2 = r18.zzbvg()
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbwj()
            java.lang.String r3 = "Logging event"
            r0 = r19
            r2.zzj(r3, r0)
        L_0x0074:
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbvb()
            r2.beginTransaction()
            r0 = r19
            com.google.android.gms.measurement.internal.EventParams r2 = r0.aoz     // Catch:{ all -> 0x0206 }
            android.os.Bundle r14 = r2.zzbvz()     // Catch:{ all -> 0x0206 }
            r0 = r18
            r1 = r20
            r0.zze(r1)     // Catch:{ all -> 0x0206 }
            java.lang.String r2 = "_iap"
            r0 = r19
            java.lang.String r3 = r0.name     // Catch:{ all -> 0x0206 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0206 }
            if (r2 != 0) goto L_0x00a2
            java.lang.String r2 = "ecommerce_purchase"
            r0 = r19
            java.lang.String r3 = r0.name     // Catch:{ all -> 0x0206 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0206 }
            if (r2 == 0) goto L_0x0165
        L_0x00a2:
            java.lang.String r2 = "currency"
            java.lang.String r5 = r14.getString(r2)     // Catch:{ all -> 0x0206 }
            java.lang.String r2 = "ecommerce_purchase"
            r0 = r19
            java.lang.String r3 = r0.name     // Catch:{ all -> 0x0206 }
            boolean r2 = r2.equals(r3)     // Catch:{ all -> 0x0206 }
            if (r2 == 0) goto L_0x01f6
            java.lang.String r2 = "value"
            double r2 = r14.getDouble(r2)     // Catch:{ all -> 0x0206 }
            r6 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r2 = r2 * r6
            r6 = 0
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 != 0) goto L_0x00d3
            java.lang.String r2 = "value"
            long r2 = r14.getLong(r2)     // Catch:{ all -> 0x0206 }
            double r2 = (double) r2     // Catch:{ all -> 0x0206 }
            r6 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r2 = r2 * r6
        L_0x00d3:
            r6 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 > 0) goto L_0x01d5
            r6 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r6 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r6 < 0) goto L_0x01d5
            long r2 = java.lang.Math.round(r2)     // Catch:{ all -> 0x0206 }
            r8 = r2
        L_0x00e4:
            boolean r2 = android.text.TextUtils.isEmpty(r5)     // Catch:{ all -> 0x0206 }
            if (r2 != 0) goto L_0x0165
            java.util.Locale r2 = java.util.Locale.US     // Catch:{ all -> 0x0206 }
            java.lang.String r2 = r5.toUpperCase(r2)     // Catch:{ all -> 0x0206 }
            java.lang.String r3 = "[A-Z]{3}"
            boolean r3 = r2.matches(r3)     // Catch:{ all -> 0x0206 }
            if (r3 == 0) goto L_0x0165
            java.lang.String r3 = "_ltv_"
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0206 }
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x0206 }
            int r5 = r2.length()     // Catch:{ all -> 0x0206 }
            if (r5 == 0) goto L_0x01ff
            java.lang.String r5 = r3.concat(r2)     // Catch:{ all -> 0x0206 }
        L_0x010c:
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbvb()     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zzak r2 = r2.zzas(r4, r5)     // Catch:{ all -> 0x0206 }
            if (r2 == 0) goto L_0x011c
            java.lang.Object r3 = r2.zzctv     // Catch:{ all -> 0x0206 }
            boolean r3 = r3 instanceof java.lang.Long     // Catch:{ all -> 0x0206 }
            if (r3 != 0) goto L_0x020f
        L_0x011c:
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbvb()     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zzd r3 = r18.zzbvi()     // Catch:{ all -> 0x0206 }
            int r3 = r3.zzls(r4)     // Catch:{ all -> 0x0206 }
            int r3 = r3 + -1
            r2.zzz(r4, r3)     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zzak r3 = new com.google.android.gms.measurement.internal.zzak     // Catch:{ all -> 0x0206 }
            com.google.android.gms.common.util.zze r2 = r18.zzaan()     // Catch:{ all -> 0x0206 }
            long r6 = r2.currentTimeMillis()     // Catch:{ all -> 0x0206 }
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0206 }
            r3.<init>(r4, r5, r6, r8)     // Catch:{ all -> 0x0206 }
        L_0x013e:
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbvb()     // Catch:{ all -> 0x0206 }
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzak) r3)     // Catch:{ all -> 0x0206 }
            if (r2 != 0) goto L_0x0165
            com.google.android.gms.measurement.internal.zzp r2 = r18.zzbvg()     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbwc()     // Catch:{ all -> 0x0206 }
            java.lang.String r5 = "Too many unique user properties are set. Ignoring user property."
            java.lang.String r6 = r3.mName     // Catch:{ all -> 0x0206 }
            java.lang.Object r3 = r3.zzctv     // Catch:{ all -> 0x0206 }
            r2.zze(r5, r6, r3)     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zzal r2 = r18.zzbvc()     // Catch:{ all -> 0x0206 }
            r3 = 9
            r5 = 0
            r6 = 0
            r7 = 0
            r2.zza((int) r3, (java.lang.String) r5, (java.lang.String) r6, (int) r7)     // Catch:{ all -> 0x0206 }
        L_0x0165:
            r0 = r19
            java.lang.String r2 = r0.name     // Catch:{ all -> 0x0206 }
            boolean r10 = com.google.android.gms.measurement.internal.zzal.zzmx(r2)     // Catch:{ all -> 0x0206 }
            java.lang.String r2 = "_err"
            r0 = r19
            java.lang.String r3 = r0.name     // Catch:{ all -> 0x0206 }
            boolean r12 = r2.equals(r3)     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zze r5 = r18.zzbvb()     // Catch:{ all -> 0x0206 }
            long r6 = r18.zzbxh()     // Catch:{ all -> 0x0206 }
            r9 = 1
            r11 = 0
            r13 = 0
            r8 = r4
            com.google.android.gms.measurement.internal.zze$zza r2 = r5.zza(r6, r8, r9, r10, r11, r12, r13)     // Catch:{ all -> 0x0206 }
            long r6 = r2.aog     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zzd r3 = r18.zzbvi()     // Catch:{ all -> 0x0206 }
            long r8 = r3.zzbtv()     // Catch:{ all -> 0x0206 }
            long r6 = r6 - r8
            r8 = 0
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 <= 0) goto L_0x022b
            r4 = 1000(0x3e8, double:4.94E-321)
            long r4 = r6 % r4
            r6 = 1
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x01b5
            com.google.android.gms.measurement.internal.zzp r3 = r18.zzbvg()     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zzp$zza r3 = r3.zzbwc()     // Catch:{ all -> 0x0206 }
            java.lang.String r4 = "Data loss. Too many events logged. count"
            long r6 = r2.aog     // Catch:{ all -> 0x0206 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0206 }
            r3.zzj(r4, r2)     // Catch:{ all -> 0x0206 }
        L_0x01b5:
            com.google.android.gms.measurement.internal.zzal r2 = r18.zzbvc()     // Catch:{ all -> 0x0206 }
            r3 = 16
            java.lang.String r4 = "_ev"
            r0 = r19
            java.lang.String r5 = r0.name     // Catch:{ all -> 0x0206 }
            r6 = 0
            r2.zza((int) r3, (java.lang.String) r4, (java.lang.String) r5, (int) r6)     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbvb()     // Catch:{ all -> 0x0206 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbvb()
            r2.endTransaction()
            goto L_0x001b
        L_0x01d5:
            com.google.android.gms.measurement.internal.zzp r4 = r18.zzbvg()     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zzp$zza r4 = r4.zzbwe()     // Catch:{ all -> 0x0206 }
            java.lang.String r5 = "Data lost. Currency value is too big"
            java.lang.Double r2 = java.lang.Double.valueOf(r2)     // Catch:{ all -> 0x0206 }
            r4.zzj(r5, r2)     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbvb()     // Catch:{ all -> 0x0206 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbvb()
            r2.endTransaction()
            goto L_0x001b
        L_0x01f6:
            java.lang.String r2 = "value"
            long r2 = r14.getLong(r2)     // Catch:{ all -> 0x0206 }
            r8 = r2
            goto L_0x00e4
        L_0x01ff:
            java.lang.String r5 = new java.lang.String     // Catch:{ all -> 0x0206 }
            r5.<init>(r3)     // Catch:{ all -> 0x0206 }
            goto L_0x010c
        L_0x0206:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zze r3 = r18.zzbvb()
            r3.endTransaction()
            throw r2
        L_0x020f:
            java.lang.Object r2 = r2.zzctv     // Catch:{ all -> 0x0206 }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ all -> 0x0206 }
            long r10 = r2.longValue()     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zzak r3 = new com.google.android.gms.measurement.internal.zzak     // Catch:{ all -> 0x0206 }
            com.google.android.gms.common.util.zze r2 = r18.zzaan()     // Catch:{ all -> 0x0206 }
            long r6 = r2.currentTimeMillis()     // Catch:{ all -> 0x0206 }
            long r8 = r8 + r10
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0206 }
            r3.<init>(r4, r5, r6, r8)     // Catch:{ all -> 0x0206 }
            goto L_0x013e
        L_0x022b:
            if (r10 == 0) goto L_0x027b
            long r6 = r2.aof     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zzd r3 = r18.zzbvi()     // Catch:{ all -> 0x0206 }
            long r8 = r3.zzbtw()     // Catch:{ all -> 0x0206 }
            long r6 = r6 - r8
            r8 = 0
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 <= 0) goto L_0x027b
            r4 = 1000(0x3e8, double:4.94E-321)
            long r4 = r6 % r4
            r6 = 1
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x025b
            com.google.android.gms.measurement.internal.zzp r3 = r18.zzbvg()     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zzp$zza r3 = r3.zzbwc()     // Catch:{ all -> 0x0206 }
            java.lang.String r4 = "Data loss. Too many public events logged. count"
            long r6 = r2.aof     // Catch:{ all -> 0x0206 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0206 }
            r3.zzj(r4, r2)     // Catch:{ all -> 0x0206 }
        L_0x025b:
            com.google.android.gms.measurement.internal.zzal r2 = r18.zzbvc()     // Catch:{ all -> 0x0206 }
            r3 = 16
            java.lang.String r4 = "_ev"
            r0 = r19
            java.lang.String r5 = r0.name     // Catch:{ all -> 0x0206 }
            r6 = 0
            r2.zza((int) r3, (java.lang.String) r4, (java.lang.String) r5, (int) r6)     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbvb()     // Catch:{ all -> 0x0206 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbvb()
            r2.endTransaction()
            goto L_0x001b
        L_0x027b:
            if (r12 == 0) goto L_0x02bc
            long r6 = r2.aoi     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zzd r3 = r18.zzbvi()     // Catch:{ all -> 0x0206 }
            r0 = r20
            java.lang.String r5 = r0.packageName     // Catch:{ all -> 0x0206 }
            int r3 = r3.zzlo(r5)     // Catch:{ all -> 0x0206 }
            long r8 = (long) r3     // Catch:{ all -> 0x0206 }
            long r6 = r6 - r8
            r8 = 0
            int r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r3 <= 0) goto L_0x02bc
            r4 = 1
            int r3 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x02ac
            com.google.android.gms.measurement.internal.zzp r3 = r18.zzbvg()     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zzp$zza r3 = r3.zzbwc()     // Catch:{ all -> 0x0206 }
            java.lang.String r4 = "Too many error events logged. count"
            long r6 = r2.aoi     // Catch:{ all -> 0x0206 }
            java.lang.Long r2 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0206 }
            r3.zzj(r4, r2)     // Catch:{ all -> 0x0206 }
        L_0x02ac:
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbvb()     // Catch:{ all -> 0x0206 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbvb()
            r2.endTransaction()
            goto L_0x001b
        L_0x02bc:
            com.google.android.gms.measurement.internal.zzal r2 = r18.zzbvc()     // Catch:{ all -> 0x0206 }
            java.lang.String r3 = "_o"
            r0 = r19
            java.lang.String r5 = r0.aoA     // Catch:{ all -> 0x0206 }
            r2.zza((android.os.Bundle) r14, (java.lang.String) r3, (java.lang.Object) r5)     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zzal r2 = r18.zzbvc()     // Catch:{ all -> 0x0206 }
            boolean r2 = r2.zzni(r4)     // Catch:{ all -> 0x0206 }
            if (r2 == 0) goto L_0x02f1
            com.google.android.gms.measurement.internal.zzal r2 = r18.zzbvc()     // Catch:{ all -> 0x0206 }
            java.lang.String r3 = "_dbg"
            r6 = 1
            java.lang.Long r5 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0206 }
            r2.zza((android.os.Bundle) r14, (java.lang.String) r3, (java.lang.Object) r5)     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zzal r2 = r18.zzbvc()     // Catch:{ all -> 0x0206 }
            java.lang.String r3 = "_r"
            r6 = 1
            java.lang.Long r5 = java.lang.Long.valueOf(r6)     // Catch:{ all -> 0x0206 }
            r2.zza((android.os.Bundle) r14, (java.lang.String) r3, (java.lang.Object) r5)     // Catch:{ all -> 0x0206 }
        L_0x02f1:
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbvb()     // Catch:{ all -> 0x0206 }
            long r2 = r2.zzma(r4)     // Catch:{ all -> 0x0206 }
            r6 = 0
            int r5 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x0310
            com.google.android.gms.measurement.internal.zzp r5 = r18.zzbvg()     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zzp$zza r5 = r5.zzbwe()     // Catch:{ all -> 0x0206 }
            java.lang.String r6 = "Data lost. Too many events stored on disk, deleted"
            java.lang.Long r2 = java.lang.Long.valueOf(r2)     // Catch:{ all -> 0x0206 }
            r5.zzj(r6, r2)     // Catch:{ all -> 0x0206 }
        L_0x0310:
            com.google.android.gms.measurement.internal.zzh r5 = new com.google.android.gms.measurement.internal.zzh     // Catch:{ all -> 0x0206 }
            r0 = r19
            java.lang.String r7 = r0.aoA     // Catch:{ all -> 0x0206 }
            r0 = r19
            java.lang.String r9 = r0.name     // Catch:{ all -> 0x0206 }
            r0 = r19
            long r10 = r0.aoB     // Catch:{ all -> 0x0206 }
            r12 = 0
            r6 = r18
            r8 = r4
            r5.<init>((com.google.android.gms.measurement.internal.zzx) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (long) r10, (long) r12, (android.os.Bundle) r14)     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbvb()     // Catch:{ all -> 0x0206 }
            java.lang.String r3 = r5.mName     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zzi r2 = r2.zzaq(r4, r3)     // Catch:{ all -> 0x0206 }
            if (r2 != 0) goto L_0x03dd
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbvb()     // Catch:{ all -> 0x0206 }
            long r2 = r2.zzmh(r4)     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zzd r6 = r18.zzbvi()     // Catch:{ all -> 0x0206 }
            int r6 = r6.zzbtu()     // Catch:{ all -> 0x0206 }
            long r6 = (long) r6     // Catch:{ all -> 0x0206 }
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 < 0) goto L_0x0377
            com.google.android.gms.measurement.internal.zzp r2 = r18.zzbvg()     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbwc()     // Catch:{ all -> 0x0206 }
            java.lang.String r3 = "Too many event names used, ignoring event. name, supported count"
            java.lang.String r4 = r5.mName     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zzd r5 = r18.zzbvi()     // Catch:{ all -> 0x0206 }
            int r5 = r5.zzbtu()     // Catch:{ all -> 0x0206 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0206 }
            r2.zze(r3, r4, r5)     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zzal r2 = r18.zzbvc()     // Catch:{ all -> 0x0206 }
            r3 = 8
            r4 = 0
            r5 = 0
            r6 = 0
            r2.zza((int) r3, (java.lang.String) r4, (java.lang.String) r5, (int) r6)     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbvb()
            r2.endTransaction()
            goto L_0x001b
        L_0x0377:
            com.google.android.gms.measurement.internal.zzi r7 = new com.google.android.gms.measurement.internal.zzi     // Catch:{ all -> 0x0206 }
            java.lang.String r9 = r5.mName     // Catch:{ all -> 0x0206 }
            r10 = 0
            r12 = 0
            long r14 = r5.f2285tr     // Catch:{ all -> 0x0206 }
            r8 = r4
            r7.<init>(r8, r9, r10, r12, r14)     // Catch:{ all -> 0x0206 }
        L_0x0385:
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbvb()     // Catch:{ all -> 0x0206 }
            r2.zza((com.google.android.gms.measurement.internal.zzi) r7)     // Catch:{ all -> 0x0206 }
            r0 = r18
            r1 = r20
            r0.zza((com.google.android.gms.measurement.internal.zzh) r5, (com.google.android.gms.measurement.internal.AppMetadata) r1)     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbvb()     // Catch:{ all -> 0x0206 }
            r2.setTransactionSuccessful()     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zzp r2 = r18.zzbvg()     // Catch:{ all -> 0x0206 }
            r3 = 2
            boolean r2 = r2.zzbf(r3)     // Catch:{ all -> 0x0206 }
            if (r2 == 0) goto L_0x03b2
            com.google.android.gms.measurement.internal.zzp r2 = r18.zzbvg()     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbwj()     // Catch:{ all -> 0x0206 }
            java.lang.String r3 = "Event recorded"
            r2.zzj(r3, r5)     // Catch:{ all -> 0x0206 }
        L_0x03b2:
            com.google.android.gms.measurement.internal.zze r2 = r18.zzbvb()
            r2.endTransaction()
            r18.zzbxm()
            com.google.android.gms.measurement.internal.zzp r2 = r18.zzbvg()
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbwj()
            java.lang.String r3 = "Background event processing time, ms"
            long r4 = java.lang.System.nanoTime()
            long r4 = r4 - r16
            r6 = 500000(0x7a120, double:2.47033E-318)
            long r4 = r4 + r6
            r6 = 1000000(0xf4240, double:4.940656E-318)
            long r4 = r4 / r6
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r2.zzj(r3, r4)
            goto L_0x001b
        L_0x03dd:
            long r6 = r2.aov     // Catch:{ all -> 0x0206 }
            r0 = r18
            com.google.android.gms.measurement.internal.zzh r5 = r5.zza((com.google.android.gms.measurement.internal.zzx) r0, (long) r6)     // Catch:{ all -> 0x0206 }
            long r6 = r5.f2285tr     // Catch:{ all -> 0x0206 }
            com.google.android.gms.measurement.internal.zzi r7 = r2.zzbm(r6)     // Catch:{ all -> 0x0206 }
            goto L_0x0385
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzx.zzb(com.google.android.gms.measurement.internal.EventParcel, com.google.android.gms.measurement.internal.AppMetadata):void");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzb(EventParcel eventParcel, String str) {
        zza zzlz = zzbvb().zzlz(str);
        if (zzlz == null || TextUtils.isEmpty(zzlz.zzyt())) {
            zzbvg().zzbwi().zzj("No app data available; dropping event", str);
            return;
        }
        try {
            String str2 = getContext().getPackageManager().getPackageInfo(str, 0).versionName;
            if (zzlz.zzyt() != null && !zzlz.zzyt().equals(str2)) {
                zzbvg().zzbwe().zzj("App version does not match; dropping event", str);
                return;
            }
        } catch (PackageManager.NameNotFoundException e) {
            if (!"_ui".equals(eventParcel.name)) {
                zzbvg().zzbwe().zzj("Could not find package", str);
            }
        }
        EventParcel eventParcel2 = eventParcel;
        zzb(eventParcel2, new AppMetadata(str, zzlz.zzbsr(), zzlz.zzyt(), zzlz.zzbsw(), zzlz.zzbsx(), zzlz.zzbsy(), zzlz.zzbsz(), (String) null, zzlz.zzbta(), false, zzlz.zzbst()));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzb(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        int i = 0;
        zzyl();
        zzaax();
        if (!TextUtils.isEmpty(appMetadata.anQ)) {
            if (!appMetadata.anV) {
                zze(appMetadata);
                return;
            }
            int zznb = zzbvc().zznb(userAttributeParcel.name);
            if (zznb != 0) {
                String zza2 = zzbvc().zza(userAttributeParcel.name, zzbvi().zzbto(), true);
                if (userAttributeParcel.name != null) {
                    i = userAttributeParcel.name.length();
                }
                zzbvc().zza(zznb, "_ev", zza2, i);
                return;
            }
            int zzm = zzbvc().zzm(userAttributeParcel.name, userAttributeParcel.getValue());
            if (zzm != 0) {
                String zza3 = zzbvc().zza(userAttributeParcel.name, zzbvi().zzbto(), true);
                Object value = userAttributeParcel.getValue();
                if (value != null && ((value instanceof String) || (value instanceof CharSequence))) {
                    i = String.valueOf(value).length();
                }
                zzbvc().zza(zzm, "_ev", zza3, i);
                return;
            }
            Object zzn = zzbvc().zzn(userAttributeParcel.name, userAttributeParcel.getValue());
            if (zzn != null) {
                zzak zzak = new zzak(appMetadata.packageName, userAttributeParcel.name, userAttributeParcel.asu, zzn);
                zzbvg().zzbwi().zze("Setting user property", zzak.mName, zzn);
                zzbvb().beginTransaction();
                try {
                    zze(appMetadata);
                    boolean zza4 = zzbvb().zza(zzak);
                    zzbvb().setTransactionSuccessful();
                    if (zza4) {
                        zzbvg().zzbwi().zze("User property set", zzak.mName, zzak.zzctv);
                    } else {
                        zzbvg().zzbwc().zze("Too many unique user properties are set. Ignoring user property.", zzak.mName, zzak.zzctv);
                        zzbvc().zza(9, (String) null, (String) null, 0);
                    }
                } finally {
                    zzbvb().endTransaction();
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void zzb(zzaa zzaa) {
        this.arn++;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzb(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        boolean z = false;
        zzyl();
        zzaax();
        zzac.zzhz(str);
        if (bArr == null) {
            bArr = new byte[0];
        }
        zzbvb().beginTransaction();
        try {
            zza zzlz = zzbvb().zzlz(str);
            boolean z2 = (i == 200 || i == 204 || i == 304) && th == null;
            if (zzlz == null) {
                zzbvg().zzbwe().zzj("App does not exist in onConfigFetched", str);
            } else if (z2 || i == 404) {
                List list = map != null ? map.get("Last-Modified") : null;
                String str2 = (list == null || list.size() <= 0) ? null : (String) list.get(0);
                if (i == 404 || i == 304) {
                    if (zzbvd().zzmp(str) == null && !zzbvd().zzb(str, (byte[]) null, (String) null)) {
                        zzbvb().endTransaction();
                        return;
                    }
                } else if (!zzbvd().zzb(str, bArr, str2)) {
                    zzbvb().endTransaction();
                    return;
                }
                zzlz.zzbc(zzaan().currentTimeMillis());
                zzbvb().zza(zzlz);
                if (i == 404) {
                    zzbvg().zzbwe().log("Config not found. Using empty config");
                } else {
                    zzbvg().zzbwj().zze("Successfully fetched config. Got network response. code, size", Integer.valueOf(i), Integer.valueOf(bArr.length));
                }
                if (!zzbxa().zzafa() || !zzbxl()) {
                    zzbxm();
                } else {
                    zzbxk();
                }
            } else {
                zzlz.zzbd(zzaan().currentTimeMillis());
                zzbvb().zza(zzlz);
                zzbvg().zzbwj().zze("Fetching config failed. code, error", Integer.valueOf(i), th);
                zzbvd().zzmr(str);
                zzbvh().apR.set(zzaan().currentTimeMillis());
                if (i == 503 || i == 429) {
                    z = true;
                }
                if (z) {
                    zzbvh().apS.set(zzaan().currentTimeMillis());
                }
                zzbxm();
            }
            zzbvb().setTransactionSuccessful();
        } finally {
            zzbvb().endTransaction();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzbo(long j) {
        return zzj((String) null, j);
    }

    public zzc zzbuw() {
        zza((zzaa) this.arh);
        return this.arh;
    }

    public zzac zzbux() {
        zza((zzaa) this.ard);
        return this.ard;
    }

    public zzn zzbuy() {
        zza((zzaa) this.are);
        return this.are;
    }

    public zzg zzbuz() {
        zza((zzaa) this.arc);
        return this.arc;
    }

    public zzad zzbva() {
        zza((zzaa) this.arb);
        return this.arb;
    }

    public zze zzbvb() {
        zza((zzaa) this.aqZ);
        return this.aqZ;
    }

    public zzal zzbvc() {
        zza((zzz) this.aqY);
        return this.aqY;
    }

    public zzv zzbvd() {
        zza((zzaa) this.aqV);
        return this.aqV;
    }

    public zzaf zzbve() {
        zza((zzaa) this.aqU);
        return this.aqU;
    }

    public zzw zzbvf() {
        zza((zzaa) this.aqT);
        return this.aqT;
    }

    public zzp zzbvg() {
        zza((zzaa) this.aqS);
        return this.aqS;
    }

    public zzt zzbvh() {
        zza((zzz) this.aqR);
        return this.aqR;
    }

    public zzd zzbvi() {
        return this.aqQ;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public boolean zzbwv() {
        boolean z = true;
        zzaax();
        zzyl();
        if (this.arj == null) {
            if (zzbvi().zzact()) {
                this.arj = true;
                return true;
            }
            if (!zzbvc().zzew("android.permission.INTERNET") || !zzbvc().zzew("android.permission.ACCESS_NETWORK_STATE") || !zzu.zzh(getContext(), false) || !zzae.zzi(getContext(), false)) {
                z = false;
            }
            this.arj = Boolean.valueOf(z);
            if (this.arj.booleanValue()) {
                this.arj = Boolean.valueOf(zzbvc().zzne(zzbuy().zzbsr()));
            }
        }
        return this.arj.booleanValue();
    }

    public zzp zzbww() {
        if (this.aqS == null || !this.aqS.isInitialized()) {
            return null;
        }
        return this.aqS;
    }

    /* access modifiers changed from: package-private */
    public zzw zzbwx() {
        return this.aqT;
    }

    public AppMeasurement zzbwy() {
        return this.aqW;
    }

    public FirebaseAnalytics zzbwz() {
        return this.aqX;
    }

    public zzq zzbxa() {
        zza((zzaa) this.ara);
        return this.ara;
    }

    public zzr zzbxb() {
        if (this.arf != null) {
            return this.arf;
        }
        throw new IllegalStateException("Network broadcast receiver not created");
    }

    public zzai zzbxc() {
        zza((zzaa) this.arg);
        return this.arg;
    }

    /* access modifiers changed from: package-private */
    public FileChannel zzbxd() {
        return this.arl;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzbxe() {
        zzyl();
        zzaax();
        if (zzbxq() && zzbxf()) {
            zzu(zza(zzbxd()), zzbuy().zzbwa());
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public boolean zzbxf() {
        zzyl();
        try {
            this.arl = new RandomAccessFile(new File(getContext().getFilesDir(), this.aqZ.zzabs()), "rw").getChannel();
            this.ark = this.arl.tryLock();
            if (this.ark != null) {
                zzbvg().zzbwj().log("Storage concurrent access okay");
                return true;
            }
            zzbvg().zzbwc().log("Storage concurrent data access panic");
            return false;
        } catch (FileNotFoundException e) {
            zzbvg().zzbwc().zzj("Failed to acquire storage lock", e);
        } catch (IOException e2) {
            zzbvg().zzbwc().zzj("Failed to access storage lock file", e2);
        }
    }

    public boolean zzbxg() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public long zzbxh() {
        return ((((zzaan().currentTimeMillis() + zzbvh().zzbwn()) / 1000) / 60) / 60) / 24;
    }

    /* access modifiers changed from: package-private */
    public void zzbxi() {
        if (!zzbvi().zzact()) {
            throw new IllegalStateException("Unexpected call on client side");
        }
    }

    @WorkerThread
    public void zzbxk() {
        zza zzlz;
        String str;
        List<Pair<zzvm.zze, Long>> list;
        ArrayMap arrayMap = null;
        zzyl();
        zzaax();
        if (!zzbvi().zzact()) {
            Boolean zzbwq = zzbvh().zzbwq();
            if (zzbwq == null) {
                zzbvg().zzbwe().log("Upload data called on the client side before use of service was decided");
                return;
            } else if (zzbwq.booleanValue()) {
                zzbvg().zzbwc().log("Upload called in the client side when service should be used");
                return;
            }
        }
        if (zzbxj()) {
            zzbvg().zzbwe().log("Uploading requested multiple times");
        } else if (!zzbxa().zzafa()) {
            zzbvg().zzbwe().log("Network not connected, ignoring upload request");
            zzbxm();
        } else {
            long currentTimeMillis = zzaan().currentTimeMillis();
            zzbo(currentTimeMillis - zzbvi().zzbuk());
            long j = zzbvh().apQ.get();
            if (j != 0) {
                zzbvg().zzbwi().zzj("Uploading events. Elapsed time since last upload attempt (ms)", Long.valueOf(Math.abs(currentTimeMillis - j)));
            }
            String zzbvj = zzbvb().zzbvj();
            if (!TextUtils.isEmpty(zzbvj)) {
                List<Pair<zzvm.zze, Long>> zzn = zzbvb().zzn(zzbvj, zzbvi().zzlv(zzbvj), zzbvi().zzlw(zzbvj));
                if (!zzn.isEmpty()) {
                    Iterator<Pair<zzvm.zze, Long>> it = zzn.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            str = null;
                            break;
                        }
                        zzvm.zze zze = (zzvm.zze) it.next().first;
                        if (!TextUtils.isEmpty(zze.atJ)) {
                            str = zze.atJ;
                            break;
                        }
                    }
                    if (str != null) {
                        int i = 0;
                        while (true) {
                            if (i >= zzn.size()) {
                                break;
                            }
                            zzvm.zze zze2 = (zzvm.zze) zzn.get(i).first;
                            if (!TextUtils.isEmpty(zze2.atJ) && !zze2.atJ.equals(str)) {
                                list = zzn.subList(0, i);
                                break;
                            }
                            i++;
                        }
                    }
                    list = zzn;
                    zzvm.zzd zzd = new zzvm.zzd();
                    zzd.att = new zzvm.zze[list.size()];
                    ArrayList arrayList = new ArrayList(list.size());
                    for (int i2 = 0; i2 < zzd.att.length; i2++) {
                        zzd.att[i2] = (zzvm.zze) list.get(i2).first;
                        arrayList.add((Long) list.get(i2).second);
                        zzd.att[i2].atI = Long.valueOf(zzbvi().zzbsy());
                        zzd.att[i2].aty = Long.valueOf(currentTimeMillis);
                        zzd.att[i2].atO = Boolean.valueOf(zzbvi().zzact());
                    }
                    String zzb = zzbvg().zzbf(2) ? zzal.zzb(zzd) : null;
                    byte[] zza2 = zzbvc().zza(zzd);
                    String zzbuj = zzbvi().zzbuj();
                    try {
                        URL url = new URL(zzbuj);
                        zzag(arrayList);
                        zzbvh().apR.set(currentTimeMillis);
                        String str2 = "?";
                        if (zzd.att.length > 0) {
                            str2 = zzd.att[0].zzck;
                        }
                        zzbvg().zzbwj().zzd("Uploading data. app, uncompressed size, data", str2, Integer.valueOf(zza2.length), zzb);
                        zzbxa().zza(zzbvj, url, zza2, (Map<String, String>) null, new zzq.zza() {
                            public void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
                                zzx.this.zza(i, th, bArr);
                            }
                        });
                    } catch (MalformedURLException e) {
                        zzbvg().zzbwc().zzj("Failed to parse upload URL. Not uploading", zzbuj);
                    }
                }
            } else {
                String zzbl = zzbvb().zzbl(currentTimeMillis - zzbvi().zzbuk());
                if (!TextUtils.isEmpty(zzbl) && (zzlz = zzbvb().zzlz(zzbl)) != null) {
                    String zzap = zzbvi().zzap(zzlz.zzbsr(), zzlz.zzayn());
                    try {
                        URL url2 = new URL(zzap);
                        zzbvg().zzbwj().zzj("Fetching remote configuration", zzlz.zzti());
                        zzvl.zzb zzmp = zzbvd().zzmp(zzlz.zzti());
                        String zzmq = zzbvd().zzmq(zzlz.zzti());
                        if (zzmp != null && !TextUtils.isEmpty(zzmq)) {
                            arrayMap = new ArrayMap();
                            arrayMap.put("If-Modified-Since", zzmq);
                        }
                        zzbxa().zza(zzbl, url2, arrayMap, new zzq.zza() {
                            public void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
                                zzx.this.zzb(str, i, th, bArr, map);
                            }
                        });
                    } catch (MalformedURLException e2) {
                        zzbvg().zzbwc().zzj("Failed to parse config URL. Not fetching", zzap);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void zzbxo() {
        this.aro++;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzbxp() {
        zzyl();
        zzaax();
        if (!this.ari) {
            zzbvg().zzbwh().log("This instance being marked as an uploader");
            zzbxe();
        }
        this.ari = true;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public boolean zzbxq() {
        zzyl();
        zzaax();
        return this.ari || zzbxg();
    }

    /* access modifiers changed from: package-private */
    public void zzc(AppMetadata appMetadata) {
        zzyl();
        zzaax();
        zzac.zzhz(appMetadata.packageName);
        zze(appMetadata);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzc(AppMetadata appMetadata, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("_et", 1);
        zzb(new EventParcel("_e", new EventParams(bundle), "auto", j), appMetadata);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzc(UserAttributeParcel userAttributeParcel, AppMetadata appMetadata) {
        zzyl();
        zzaax();
        if (!TextUtils.isEmpty(appMetadata.anQ)) {
            if (!appMetadata.anV) {
                zze(appMetadata);
                return;
            }
            zzbvg().zzbwi().zzj("Removing user property", userAttributeParcel.name);
            zzbvb().beginTransaction();
            try {
                zze(appMetadata);
                zzbvb().zzar(appMetadata.packageName, userAttributeParcel.name);
                zzbvb().setTransactionSuccessful();
                zzbvg().zzbwi().zzj("User property removed", userAttributeParcel.name);
            } finally {
                zzbvb().endTransaction();
            }
        }
    }

    @WorkerThread
    public void zzd(AppMetadata appMetadata) {
        zzyl();
        zzaax();
        zzac.zzy(appMetadata);
        zzac.zzhz(appMetadata.packageName);
        if (!TextUtils.isEmpty(appMetadata.anQ)) {
            if (!appMetadata.anV) {
                zze(appMetadata);
                return;
            }
            long currentTimeMillis = zzaan().currentTimeMillis();
            zzbvb().beginTransaction();
            try {
                zza(appMetadata, currentTimeMillis);
                zze(appMetadata);
                if (zzbvb().zzaq(appMetadata.packageName, "_f") == null) {
                    zzb(new UserAttributeParcel("_fot", currentTimeMillis, Long.valueOf((1 + (currentTimeMillis / 3600000)) * 3600000), "auto"), appMetadata);
                    zzb(appMetadata, currentTimeMillis);
                    zzc(appMetadata, currentTimeMillis);
                } else if (appMetadata.anW) {
                    zzd(appMetadata, currentTimeMillis);
                }
                zzbvb().setTransactionSuccessful();
            } finally {
                zzbvb().endTransaction();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzd(AppMetadata appMetadata, long j) {
        zzb(new EventParcel("_cd", new EventParams(new Bundle()), "auto", j), appMetadata);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public boolean zzu(int i, int i2) {
        zzyl();
        if (i > i2) {
            zzbvg().zzbwc().zze("Panic: can't downgrade version. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
            return false;
        }
        if (i < i2) {
            if (zza(i2, zzbxd())) {
                zzbvg().zzbwj().zze("Storage version upgraded. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
            } else {
                zzbvg().zzbwc().zze("Storage version upgrade failed. Previous, current version", Integer.valueOf(i), Integer.valueOf(i2));
                return false;
            }
        }
        return true;
    }

    @WorkerThread
    public void zzyl() {
        zzbvf().zzyl();
    }
}
