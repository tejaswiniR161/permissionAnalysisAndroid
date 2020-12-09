package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Debug;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.stats.zzc;
import com.google.android.gms.common.util.zzd;
import com.google.android.gms.common.util.zzt;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class zzb {

    /* renamed from: Cz */
    private static final Object f1819Cz = new Object();

    /* renamed from: DX */
    private static zzb f1820DX;

    /* renamed from: Ed */
    private static Integer f1821Ed;

    /* renamed from: DY */
    private final List<String> f1822DY;

    /* renamed from: DZ */
    private final List<String> f1823DZ;

    /* renamed from: Ea */
    private final List<String> f1824Ea;

    /* renamed from: Eb */
    private final List<String> f1825Eb;

    /* renamed from: Ec */
    private zze f1826Ec;

    /* renamed from: Ee */
    private zze f1827Ee;

    private zzb() {
        if (getLogLevel() == zzd.LOG_LEVEL_OFF) {
            this.f1822DY = Collections.EMPTY_LIST;
            this.f1823DZ = Collections.EMPTY_LIST;
            this.f1824Ea = Collections.EMPTY_LIST;
            this.f1825Eb = Collections.EMPTY_LIST;
            return;
        }
        String str = zzc.zza.f1831Ei.get();
        this.f1822DY = str == null ? Collections.EMPTY_LIST : Arrays.asList(str.split(","));
        String str2 = zzc.zza.f1832Ej.get();
        this.f1823DZ = str2 == null ? Collections.EMPTY_LIST : Arrays.asList(str2.split(","));
        String str3 = zzc.zza.f1833Ek.get();
        this.f1824Ea = str3 == null ? Collections.EMPTY_LIST : Arrays.asList(str3.split(","));
        String str4 = zzc.zza.f1834El.get();
        this.f1825Eb = str4 == null ? Collections.EMPTY_LIST : Arrays.asList(str4.split(","));
        this.f1826Ec = new zze(1024, zzc.zza.f1835Em.get().longValue());
        this.f1827Ee = new zze(1024, zzc.zza.f1835Em.get().longValue());
    }

    private static int getLogLevel() {
        if (f1821Ed == null) {
            try {
                f1821Ed = Integer.valueOf(zzd.zzact() ? zzc.zza.f1830Eh.get().intValue() : zzd.LOG_LEVEL_OFF);
            } catch (SecurityException e) {
                f1821Ed = Integer.valueOf(zzd.LOG_LEVEL_OFF);
            }
        }
        return f1821Ed.intValue();
    }

    private static String zza(StackTraceElement[] stackTraceElementArr, int i) {
        if (i + 4 >= stackTraceElementArr.length) {
            return "<bottom of call stack>";
        }
        StackTraceElement stackTraceElement = stackTraceElementArr[i + 4];
        String valueOf = String.valueOf(stackTraceElement.getClassName());
        String valueOf2 = String.valueOf(stackTraceElement.getMethodName());
        return new StringBuilder(String.valueOf(valueOf).length() + 13 + String.valueOf(valueOf2).length()).append(valueOf).append(".").append(valueOf2).append(":").append(stackTraceElement.getLineNumber()).toString();
    }

    private void zza(Context context, String str, int i, String str2, String str3, String str4, String str5) {
        ConnectionEvent connectionEvent;
        long currentTimeMillis = System.currentTimeMillis();
        String str6 = null;
        if (!((getLogLevel() & zzd.f1842Er) == 0 || i == 13)) {
            str6 = zzm(3, 5);
        }
        long j = 0;
        if ((getLogLevel() & zzd.f1844Et) != 0) {
            j = Debug.getNativeHeapAllocatedSize();
        }
        if (i == 1 || i == 4 || i == 14) {
            connectionEvent = new ConnectionEvent(currentTimeMillis, i, (String) null, (String) null, (String) null, (String) null, str6, str, SystemClock.elapsedRealtime(), j);
        } else {
            connectionEvent = new ConnectionEvent(currentTimeMillis, i, str2, str3, str4, str5, str6, str, SystemClock.elapsedRealtime(), j);
        }
        context.startService(new Intent().setComponent(zzd.f1838En).putExtra("com.google.android.gms.common.stats.EXTRA_LOG_EVENT", connectionEvent));
    }

    private void zza(Context context, String str, String str2, Intent intent, int i) {
        String str3;
        String str4;
        String str5 = null;
        if (zzawv() && this.f1826Ec != null) {
            if (i != 4 && i != 1) {
                ServiceInfo zzd = zzd(context, intent);
                if (zzd == null) {
                    Log.w("ConnectionTracker", String.format("Client %s made an invalid request %s", new Object[]{str2, intent.toUri(0)}));
                    return;
                }
                str4 = zzd.processName;
                str3 = zzd.name;
                str5 = zzt.zzaxx();
                if (zzb(str5, str2, str4, str3)) {
                    this.f1826Ec.zzif(str);
                } else {
                    return;
                }
            } else if (this.f1826Ec.zzig(str)) {
                str3 = null;
                str4 = null;
            } else {
                return;
            }
            zza(context, str, i, str5, str2, str4, str3);
        }
    }

    public static zzb zzawu() {
        synchronized (f1819Cz) {
            if (f1820DX == null) {
                f1820DX = new zzb();
            }
        }
        return f1820DX;
    }

    private boolean zzawv() {
        return false;
    }

    private String zzb(ServiceConnection serviceConnection) {
        return String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(serviceConnection)));
    }

    private boolean zzb(String str, String str2, String str3, String str4) {
        return !this.f1822DY.contains(str) && !this.f1823DZ.contains(str2) && !this.f1824Ea.contains(str3) && !this.f1825Eb.contains(str4) && (!str3.equals(str) || (getLogLevel() & zzd.f1843Es) == 0);
    }

    private boolean zzc(Context context, Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            return false;
        }
        return zzd.zzx(context, component.getPackageName());
    }

    private static ServiceInfo zzd(Context context, Intent intent) {
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 128);
        if (queryIntentServices == null || queryIntentServices.size() == 0) {
            Log.w("ConnectionTracker", String.format("There are no handler of this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), zzm(3, 20)}));
            return null;
        } else if (queryIntentServices.size() <= 1) {
            return queryIntentServices.get(0).serviceInfo;
        } else {
            Log.w("ConnectionTracker", String.format("Multiple handlers found for this intent: %s\n Stack trace: %s", new Object[]{intent.toUri(0), zzm(3, 20)}));
            for (ResolveInfo resolveInfo : queryIntentServices) {
                Log.w("ConnectionTracker", resolveInfo.serviceInfo.name);
            }
            return null;
        }
    }

    private static String zzm(int i, int i2) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i2 + i;
        while (i < i3) {
            stringBuffer.append(zza(stackTrace, i)).append(" ");
            i++;
        }
        return stringBuffer.toString();
    }

    @SuppressLint({"UntrackedBindService"})
    public void zza(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
        zza(context, zzb(serviceConnection), (String) null, (Intent) null, 1);
    }

    public void zza(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
        zza(context, zzb(serviceConnection), str, intent, 3);
    }

    public boolean zza(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return zza(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @SuppressLint({"UntrackedBindService"})
    public boolean zza(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        if (zzc(context, intent)) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        boolean bindService = context.bindService(intent, serviceConnection, i);
        if (bindService) {
            zza(context, zzb(serviceConnection), str, intent, 2);
        }
        return bindService;
    }

    public void zzb(Context context, ServiceConnection serviceConnection) {
        zza(context, zzb(serviceConnection), (String) null, (Intent) null, 4);
    }
}
