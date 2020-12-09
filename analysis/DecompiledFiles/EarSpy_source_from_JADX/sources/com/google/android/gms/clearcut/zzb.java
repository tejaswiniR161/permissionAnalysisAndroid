package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.util.Log;
import com.facebook.ads.AdError;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzarp;
import com.google.android.gms.internal.zzpr;
import com.google.android.gms.internal.zzps;
import com.google.android.gms.internal.zzpw;
import com.google.android.gms.playlog.internal.PlayLoggerContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TimeZone;

public final class zzb {
    public static final Api<Api.ApiOptions.NoOptions> API = new Api<>("ClearcutLogger.API", f1466fb, f1465fa);

    /* renamed from: fa */
    public static final Api.zzf<zzps> f1465fa = new Api.zzf<>();

    /* renamed from: fb */
    public static final Api.zza<zzps, Api.ApiOptions.NoOptions> f1466fb = new Api.zza<zzps, Api.ApiOptions.NoOptions>() {
        /* renamed from: zze */
        public zzps zza(Context context, Looper looper, zzh zzh, Api.ApiOptions.NoOptions noOptions, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
            return new zzps(context, looper, zzh, connectionCallbacks, onConnectionFailedListener);
        }
    };

    /* renamed from: tH */
    public static final zzc f1467tH = new zzpr();
    /* access modifiers changed from: private */

    /* renamed from: ed */
    public final String f1468ed;
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */

    /* renamed from: tI */
    public final int f1469tI;
    /* access modifiers changed from: private */

    /* renamed from: tJ */
    public String f1470tJ;
    /* access modifiers changed from: private */

    /* renamed from: tK */
    public int f1471tK;
    /* access modifiers changed from: private */

    /* renamed from: tL */
    public String f1472tL;
    /* access modifiers changed from: private */

    /* renamed from: tM */
    public String f1473tM;
    /* access modifiers changed from: private */

    /* renamed from: tN */
    public final boolean f1474tN;

    /* renamed from: tO */
    private int f1475tO;
    /* access modifiers changed from: private */

    /* renamed from: tP */
    public final zzc f1476tP;
    /* access modifiers changed from: private */

    /* renamed from: tQ */
    public final zza f1477tQ;
    /* access modifiers changed from: private */

    /* renamed from: tR */
    public zzd f1478tR;
    /* access modifiers changed from: private */

    /* renamed from: tS */
    public final C1269zzb f1479tS;
    /* access modifiers changed from: private */
    public final zze zzapy;

    public class zza {

        /* renamed from: tJ */
        private String f1480tJ;

        /* renamed from: tK */
        private int f1481tK;

        /* renamed from: tL */
        private String f1482tL;

        /* renamed from: tM */
        private String f1483tM;

        /* renamed from: tO */
        private int f1484tO;

        /* renamed from: tT */
        private final zzc f1485tT;

        /* renamed from: tU */
        private ArrayList<Integer> f1486tU;

        /* renamed from: tV */
        private ArrayList<String> f1487tV;

        /* renamed from: tW */
        private ArrayList<Integer> f1488tW;

        /* renamed from: tX */
        private ArrayList<byte[]> f1489tX;

        /* renamed from: tY */
        private boolean f1490tY;

        /* renamed from: tZ */
        private final zzarp.zzd f1491tZ;

        /* renamed from: ua */
        private boolean f1492ua;

        private zza(zzb zzb, byte[] bArr) {
            this(bArr, (zzc) null);
        }

        private zza(byte[] bArr, zzc zzc) {
            this.f1481tK = zzb.this.f1471tK;
            this.f1480tJ = zzb.this.f1470tJ;
            this.f1482tL = zzb.this.f1472tL;
            this.f1483tM = zzb.this.f1473tM;
            this.f1484tO = zzb.zze(zzb.this);
            this.f1486tU = null;
            this.f1487tV = null;
            this.f1488tW = null;
            this.f1489tX = null;
            this.f1490tY = true;
            this.f1491tZ = new zzarp.zzd();
            this.f1492ua = false;
            this.f1482tL = zzb.this.f1472tL;
            this.f1483tM = zzb.this.f1473tM;
            this.f1491tZ.bra = zzb.this.zzapy.currentTimeMillis();
            this.f1491tZ.brb = zzb.this.zzapy.elapsedRealtime();
            this.f1491tZ.brs = (long) zzb.this.f1477tQ.zzbl(zzb.this.mContext);
            this.f1491tZ.brm = zzb.this.f1478tR.zzag(this.f1491tZ.bra);
            if (bArr != null) {
                this.f1491tZ.brh = bArr;
            }
            this.f1485tT = zzc;
        }

        public LogEventParcelable zzaox() {
            return new LogEventParcelable(new PlayLoggerContext(zzb.this.f1468ed, zzb.this.f1469tI, this.f1481tK, this.f1480tJ, this.f1482tL, this.f1483tM, zzb.this.f1474tN, this.f1484tO), this.f1491tZ, this.f1485tT, (zzc) null, zzb.zzb((ArrayList<Integer>) null), zzb.zzc((ArrayList<String>) null), zzb.zzb((ArrayList<Integer>) null), zzb.zzd((ArrayList<byte[]>) null), this.f1490tY);
        }

        public PendingResult<Status> zze(GoogleApiClient googleApiClient) {
            if (this.f1492ua) {
                throw new IllegalStateException("do not reuse LogEventBuilder");
            }
            this.f1492ua = true;
            PlayLoggerContext playLoggerContext = zzaox().f1453uc;
            return zzb.this.f1479tS.zzh(playLoggerContext.axz, playLoggerContext.axv) ? zzb.this.f1476tP.zza(googleApiClient, zzaox()) : PendingResults.immediatePendingResult(Status.f1540vY);
        }

        public zza zzfh(int i) {
            this.f1491tZ.brd = i;
            return this;
        }

        public zza zzfi(int i) {
            this.f1491tZ.zzajd = i;
            return this;
        }
    }

    /* renamed from: com.google.android.gms.clearcut.zzb$zzb  reason: collision with other inner class name */
    public interface C1269zzb {
        boolean zzh(String str, int i);
    }

    public interface zzc {
        byte[] zzaoy();
    }

    public static class zzd {
        public long zzag(long j) {
            return (long) (TimeZone.getDefault().getOffset(j) / AdError.NETWORK_ERROR_CODE);
        }
    }

    public zzb(Context context, int i, String str, String str2, String str3, boolean z, zzc zzc2, zze zze, zzd zzd2, zza zza2, C1269zzb zzb) {
        this.f1471tK = -1;
        this.f1475tO = 0;
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext == null ? context : applicationContext;
        this.f1468ed = context.getPackageName();
        this.f1469tI = zzbm(context);
        this.f1471tK = i;
        this.f1470tJ = str;
        this.f1472tL = str2;
        this.f1473tM = str3;
        this.f1474tN = z;
        this.f1476tP = zzc2;
        this.zzapy = zze;
        this.f1478tR = zzd2 == null ? new zzd() : zzd2;
        this.f1477tQ = zza2;
        this.f1475tO = 0;
        this.f1479tS = zzb;
        if (this.f1474tN) {
            zzac.zzb(this.f1472tL == null, (Object) "can't be anonymous with an upload account");
        }
    }

    public zzb(Context context, String str, String str2) {
        this(context, -1, str, str2, (String) null, false, f1467tH, com.google.android.gms.common.util.zzh.zzaxj(), (zzd) null, zza.f1464tG, new zzpw(context));
    }

    /* access modifiers changed from: private */
    public static int[] zzb(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        int i = 0;
        Iterator<Integer> it = arrayList.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return iArr;
            }
            i = i2 + 1;
            iArr[i2] = it.next().intValue();
        }
    }

    private int zzbm(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            Log.wtf("ClearcutLogger", "This can't happen.");
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public static String[] zzc(ArrayList<String> arrayList) {
        if (arrayList == null) {
            return null;
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* access modifiers changed from: private */
    public static byte[][] zzd(ArrayList<byte[]> arrayList) {
        if (arrayList == null) {
            return null;
        }
        return (byte[][]) arrayList.toArray(new byte[0][]);
    }

    static /* synthetic */ int zze(zzb zzb) {
        return 0;
    }

    public zza zzl(byte[] bArr) {
        return new zza(bArr);
    }
}
