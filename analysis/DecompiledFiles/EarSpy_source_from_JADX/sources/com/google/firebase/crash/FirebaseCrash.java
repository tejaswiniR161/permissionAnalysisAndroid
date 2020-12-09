package com.google.firebase.crash;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.Keep;
import android.util.Log;
import com.google.android.gms.dynamic.zze;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crash.internal.FirebaseCrashOptions;
import com.google.firebase.crash.internal.config.flag.Flags;
import com.google.firebase.crash.internal.zza;
import com.google.firebase.crash.internal.zzb;
import com.google.firebase.crash.internal.zzd;
import com.google.firebase.crash.internal.zzg;
import com.google.firebase.crash.internal.zzh;
import com.google.firebase.iid.zzc;

public class FirebaseCrash {
    private static final String LOG_TAG = FirebaseCrash.class.getSimpleName();
    private static volatile FirebaseCrash aVa;
    private zzd aUY;
    private zza aUZ;
    private boolean aol;

    FirebaseCrash(FirebaseApp firebaseApp, boolean z) {
        this.aol = z;
        Context applicationContext = firebaseApp.getApplicationContext();
        if (applicationContext == null) {
            Log.w(LOG_TAG, "Application context is missing, disabling api");
            this.aol = false;
        }
        if (this.aol) {
            try {
                FirebaseCrashOptions firebaseCrashOptions = new FirebaseCrashOptions(firebaseApp.getOptions().getApplicationId(), firebaseApp.getOptions().getApiKey());
                zzg.zzcqp().zzbr(applicationContext);
                this.aUY = zzg.zzcqp().zzcqq();
                this.aUY.zza(zze.zzac(applicationContext), firebaseCrashOptions);
                this.aUZ = new zza(applicationContext);
                zzcqm();
                String str = LOG_TAG;
                String valueOf = String.valueOf(zzg.zzcqp().toString());
                Log.i(str, valueOf.length() != 0 ? "FirebaseCrash reporting initialized ".concat(valueOf) : new String("FirebaseCrash reporting initialized "));
            } catch (Exception e) {
                Log.e(LOG_TAG, "Failed to initialize crash reporting", e);
                this.aol = false;
            }
        } else {
            Log.i(LOG_TAG, "Crash reporting is disabled");
        }
    }

    @Keep
    public static FirebaseCrash getInstance(FirebaseApp firebaseApp) {
        Flags.initialize(firebaseApp.getApplicationContext());
        FirebaseCrash firebaseCrash = new FirebaseCrash(firebaseApp, Flags.aVh.get().booleanValue());
        synchronized (FirebaseCrash.class) {
            if (aVa == null) {
                aVa = firebaseCrash;
            }
        }
        return firebaseCrash;
    }

    private boolean isEnabled() {
        return this.aol;
    }

    public static boolean isSingletonInitialized() {
        return aVa != null;
    }

    public static void log(String str) {
        try {
            zzcqj().zzrz(str);
        } catch (zzb e) {
            Log.v(LOG_TAG, e.getMessage());
        }
    }

    public static void logcat(int i, String str, String str2) {
        try {
            zzcqj().zze(i, str, str2);
        } catch (zzb e) {
            Log.v(LOG_TAG, e.getMessage());
        }
    }

    public static void report(Throwable th) {
        try {
            zzcqj().zzh(th);
        } catch (zzb e) {
            Log.v(LOG_TAG, e.getMessage());
        }
    }

    public static FirebaseCrash zzcqj() {
        if (aVa == null) {
            synchronized (FirebaseCrash.class) {
                if (aVa == null) {
                    aVa = getInstance(FirebaseApp.getInstance());
                }
            }
        }
        return aVa;
    }

    private zzd zzcqk() {
        return this.aUY;
    }

    private static boolean zzcql() {
        return Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId();
    }

    private void zzcqm() {
        if (!zzcql()) {
            throw new RuntimeException("FirebaseCrash reporting may only be initialized on the main thread (preferably in your app's Application.onCreate)");
        }
        Thread.setDefaultUncaughtExceptionHandler(new zzh(Thread.getDefaultUncaughtExceptionHandler(), this));
    }

    private String zzcqn() {
        return zzc.m1500A().getId();
    }

    public void zze(int i, String str, String str2) throws zzb {
        if (str2 != null) {
            if (str == null) {
                str = "";
            }
            Log.println(i, str, str2);
            zzrz(str2);
        }
    }

    public void zzh(Throwable th) throws zzb {
        if (!isEnabled()) {
            throw new zzb("Firebase Crash Reporting is disabled.");
        }
        zzd zzcqk = zzcqk();
        if (zzcqk != null && th != null) {
            this.aUZ.zza(false, System.currentTimeMillis());
            try {
                zzcqk.zzsa(zzcqn());
                zzcqk.zzan(zze.zzac(th));
            } catch (RemoteException e) {
                Log.e(LOG_TAG, "report remoting failed", e);
            }
        }
    }

    public void zzi(Throwable th) throws zzb {
        if (!isEnabled()) {
            throw new zzb("Firebase Crash Reporting is disabled.");
        }
        zzd zzcqk = zzcqk();
        if (zzcqk != null && th != null) {
            try {
                this.aUZ.zza(true, System.currentTimeMillis());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                zzcqk.zzsa(zzcqn());
                zzcqk.zzao(zze.zzac(th));
            } catch (RemoteException e2) {
                Log.e(LOG_TAG, "report remoting failed", e2);
            }
        }
    }

    public void zzrz(String str) throws zzb {
        if (!isEnabled()) {
            throw new zzb("Firebase Crash Reporting is disabled.");
        }
        zzd zzcqk = zzcqk();
        if (zzcqk != null && str != null) {
            try {
                zzcqk.log(str);
            } catch (RemoteException e) {
                Log.e(LOG_TAG, "log remoting failed", e);
            }
        }
    }
}
