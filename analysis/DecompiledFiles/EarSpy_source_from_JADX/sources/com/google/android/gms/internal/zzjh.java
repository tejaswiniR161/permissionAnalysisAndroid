package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.zzi;
import java.util.Locale;

@zziy
public final class zzjh {
    public final int zzcge;
    public final int zzcgf;
    public final float zzcgg;
    public final int zzclr;
    public final boolean zzcls;
    public final boolean zzclt;
    public final String zzclu;
    public final String zzclv;
    public final boolean zzclw;
    public final boolean zzclx;
    public final boolean zzcly;
    public final boolean zzclz;
    public final String zzcma;
    public final String zzcmb;
    public final int zzcmc;
    public final int zzcmd;
    public final int zzcme;
    public final int zzcmf;
    public final int zzcmg;
    public final int zzcmh;
    public final double zzcmi;
    public final boolean zzcmj;
    public final boolean zzcmk;
    public final int zzcml;
    public final String zzcmm;
    public final boolean zzcmn;

    public static final class zza {
        private int zzcge;
        private int zzcgf;
        private float zzcgg;
        private int zzclr;
        private boolean zzcls;
        private boolean zzclt;
        private String zzclu;
        private String zzclv;
        private boolean zzclw;
        private boolean zzclx;
        private boolean zzcly;
        private boolean zzclz;
        private String zzcma;
        private String zzcmb;
        private int zzcmc;
        private int zzcmd;
        private int zzcme;
        private int zzcmf;
        private int zzcmg;
        private int zzcmh;
        private double zzcmi;
        private boolean zzcmj;
        private boolean zzcmk;
        private int zzcml;
        private String zzcmm;
        private boolean zzcmn;

        public zza(Context context) {
            DisplayMetrics displayMetrics;
            boolean z = true;
            PackageManager packageManager = context.getPackageManager();
            zzv(context);
            zza(context, packageManager);
            zzw(context);
            Locale locale = Locale.getDefault();
            this.zzcls = zza(packageManager, "geo:0,0?q=donuts") != null;
            this.zzclt = zza(packageManager, "http://www.google.com") == null ? false : z;
            this.zzclv = locale.getCountry();
            this.zzclw = zzm.zzjr().zzve();
            this.zzclx = zzi.zzcm(context);
            this.zzcma = locale.getLanguage();
            this.zzcmb = zza(packageManager);
            Resources resources = context.getResources();
            if (resources != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
                this.zzcgg = displayMetrics.density;
                this.zzcge = displayMetrics.widthPixels;
                this.zzcgf = displayMetrics.heightPixels;
            }
        }

        public zza(Context context, zzjh zzjh) {
            PackageManager packageManager = context.getPackageManager();
            zzv(context);
            zza(context, packageManager);
            zzw(context);
            zzx(context);
            this.zzcls = zzjh.zzcls;
            this.zzclt = zzjh.zzclt;
            this.zzclv = zzjh.zzclv;
            this.zzclw = zzjh.zzclw;
            this.zzclx = zzjh.zzclx;
            this.zzcma = zzjh.zzcma;
            this.zzcmb = zzjh.zzcmb;
            this.zzcgg = zzjh.zzcgg;
            this.zzcge = zzjh.zzcge;
            this.zzcgf = zzjh.zzcgf;
        }

        private static ResolveInfo zza(PackageManager packageManager, String str) {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        }

        private static String zza(PackageManager packageManager) {
            ActivityInfo activityInfo;
            ResolveInfo zza = zza(packageManager, "market://details?id=com.google.android.gms.ads");
            if (zza == null || (activityInfo = zza.activityInfo) == null) {
                return null;
            }
            try {
                PackageInfo packageInfo = packageManager.getPackageInfo(activityInfo.packageName, 0);
                if (packageInfo == null) {
                    return null;
                }
                int i = packageInfo.versionCode;
                String valueOf = String.valueOf(activityInfo.packageName);
                return new StringBuilder(String.valueOf(valueOf).length() + 12).append(i).append(".").append(valueOf).toString();
            } catch (PackageManager.NameNotFoundException e) {
                return null;
            }
        }

        @TargetApi(16)
        private void zza(Context context, PackageManager packageManager) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            this.zzclu = telephonyManager.getNetworkOperator();
            this.zzcme = telephonyManager.getNetworkType();
            this.zzcmf = telephonyManager.getPhoneType();
            this.zzcmd = -2;
            this.zzcmk = false;
            this.zzcml = -1;
            if (zzu.zzfz().zza(packageManager, context.getPackageName(), "android.permission.ACCESS_NETWORK_STATE")) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    this.zzcmd = activeNetworkInfo.getType();
                    this.zzcml = activeNetworkInfo.getDetailedState().ordinal();
                } else {
                    this.zzcmd = -1;
                }
                if (Build.VERSION.SDK_INT >= 16) {
                    this.zzcmk = connectivityManager.isActiveNetworkMetered();
                }
            }
        }

        private void zzv(Context context) {
            AudioManager zzak = zzu.zzfz().zzak(context);
            if (zzak != null) {
                try {
                    this.zzclr = zzak.getMode();
                    this.zzcly = zzak.isMusicActive();
                    this.zzclz = zzak.isSpeakerphoneOn();
                    this.zzcmc = zzak.getStreamVolume(3);
                    this.zzcmg = zzak.getRingerMode();
                    this.zzcmh = zzak.getStreamVolume(2);
                    return;
                } catch (Throwable th) {
                    zzu.zzgd().zza(th, "DeviceInfo.gatherAudioInfo");
                }
            }
            this.zzclr = -2;
            this.zzcly = false;
            this.zzclz = false;
            this.zzcmc = 0;
            this.zzcmg = 0;
            this.zzcmh = 0;
        }

        private void zzw(Context context) {
            boolean z = false;
            Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                int intExtra = registerReceiver.getIntExtra("status", -1);
                this.zzcmi = (double) (((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
                if (intExtra == 2 || intExtra == 5) {
                    z = true;
                }
                this.zzcmj = z;
                return;
            }
            this.zzcmi = -1.0d;
            this.zzcmj = false;
        }

        private void zzx(Context context) {
            this.zzcmm = Build.FINGERPRINT;
            this.zzcmn = zzdw.zzo(context);
        }

        public zzjh zzsk() {
            return new zzjh(this.zzclr, this.zzcls, this.zzclt, this.zzclu, this.zzclv, this.zzclw, this.zzclx, this.zzcly, this.zzclz, this.zzcma, this.zzcmb, this.zzcmc, this.zzcmd, this.zzcme, this.zzcmf, this.zzcmg, this.zzcmh, this.zzcgg, this.zzcge, this.zzcgf, this.zzcmi, this.zzcmj, this.zzcmk, this.zzcml, this.zzcmm, this.zzcmn);
        }
    }

    zzjh(int i, boolean z, boolean z2, String str, String str2, boolean z3, boolean z4, boolean z5, boolean z6, String str3, String str4, int i2, int i3, int i4, int i5, int i6, int i7, float f, int i8, int i9, double d, boolean z7, boolean z8, int i10, String str5, boolean z9) {
        this.zzclr = i;
        this.zzcls = z;
        this.zzclt = z2;
        this.zzclu = str;
        this.zzclv = str2;
        this.zzclw = z3;
        this.zzclx = z4;
        this.zzcly = z5;
        this.zzclz = z6;
        this.zzcma = str3;
        this.zzcmb = str4;
        this.zzcmc = i2;
        this.zzcmd = i3;
        this.zzcme = i4;
        this.zzcmf = i5;
        this.zzcmg = i6;
        this.zzcmh = i7;
        this.zzcgg = f;
        this.zzcge = i8;
        this.zzcgf = i9;
        this.zzcmi = d;
        this.zzcmj = z7;
        this.zzcmk = z8;
        this.zzcml = i10;
        this.zzcmm = str5;
        this.zzcmn = z9;
    }
}
