package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.zzac;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Locale;

class zzt extends zzaa {
    static final Pair<String, Long> apO = new Pair<>("", 0L);
    public final zzc apP = new zzc("health_monitor", zzbvi().zzadz());
    public final zzb apQ = new zzb("last_upload", 0);
    public final zzb apR = new zzb("last_upload_attempt", 0);
    public final zzb apS = new zzb("backoff", 0);
    public final zzb apT = new zzb("last_delete_stale", 0);
    public final zzb apU = new zzb("midnight_offset", 0);
    private String apV;
    private boolean apW;
    private long apX;
    private SecureRandom apY;
    public final zzb apZ = new zzb("time_before_start", 10000);
    public final zzb aqa = new zzb("session_timeout", 1800000);
    public final zza aqb = new zza("start_new_session", true);
    public final zzb aqc = new zzb("last_pause_time", 0);
    public final zzb aqd = new zzb("time_active", 0);
    public boolean aqe;
    /* access modifiers changed from: private */

    /* renamed from: dy */
    public SharedPreferences f2296dy;

    public final class zza {
        private final boolean aqf;
        private boolean aqg;

        /* renamed from: vu */
        private boolean f2297vu;
        private final String zzbaf;

        public zza(String str, boolean z) {
            zzac.zzhz(str);
            this.zzbaf = str;
            this.aqf = z;
        }

        @WorkerThread
        private void zzbwt() {
            if (!this.aqg) {
                this.aqg = true;
                this.f2297vu = zzt.this.f2296dy.getBoolean(this.zzbaf, this.aqf);
            }
        }

        @WorkerThread
        public boolean get() {
            zzbwt();
            return this.f2297vu;
        }

        @WorkerThread
        public void set(boolean z) {
            SharedPreferences.Editor edit = zzt.this.f2296dy.edit();
            edit.putBoolean(this.zzbaf, z);
            edit.apply();
            this.f2297vu = z;
        }
    }

    public final class zzb {

        /* renamed from: X */
        private long f2298X;
        private boolean aqg;
        private final long aqi;
        private final String zzbaf;

        public zzb(String str, long j) {
            zzac.zzhz(str);
            this.zzbaf = str;
            this.aqi = j;
        }

        @WorkerThread
        private void zzbwt() {
            if (!this.aqg) {
                this.aqg = true;
                this.f2298X = zzt.this.f2296dy.getLong(this.zzbaf, this.aqi);
            }
        }

        @WorkerThread
        public long get() {
            zzbwt();
            return this.f2298X;
        }

        @WorkerThread
        public void set(long j) {
            SharedPreferences.Editor edit = zzt.this.f2296dy.edit();
            edit.putLong(this.zzbaf, j);
            edit.apply();
            this.f2298X = j;
        }
    }

    public final class zzc {
        final String aqj;
        private final String aqk;
        private final String aql;

        /* renamed from: dC */
        private final long f2299dC;

        private zzc(String str, long j) {
            zzac.zzhz(str);
            zzac.zzbs(j > 0);
            this.aqj = String.valueOf(str).concat(":start");
            this.aqk = String.valueOf(str).concat(":count");
            this.aql = String.valueOf(str).concat(":value");
            this.f2299dC = j;
        }

        @WorkerThread
        private void zzafk() {
            zzt.this.zzyl();
            long currentTimeMillis = zzt.this.zzaan().currentTimeMillis();
            SharedPreferences.Editor edit = zzt.this.f2296dy.edit();
            edit.remove(this.aqk);
            edit.remove(this.aql);
            edit.putLong(this.aqj, currentTimeMillis);
            edit.apply();
        }

        @WorkerThread
        private long zzafl() {
            zzt.this.zzyl();
            long zzafn = zzafn();
            if (zzafn != 0) {
                return Math.abs(zzafn - zzt.this.zzaan().currentTimeMillis());
            }
            zzafk();
            return 0;
        }

        @WorkerThread
        private long zzafn() {
            return zzt.this.zzbwo().getLong(this.aqj, 0);
        }

        @WorkerThread
        public Pair<String, Long> zzafm() {
            zzt.this.zzyl();
            long zzafl = zzafl();
            if (zzafl < this.f2299dC) {
                return null;
            }
            if (zzafl > this.f2299dC * 2) {
                zzafk();
                return null;
            }
            String string = zzt.this.zzbwo().getString(this.aql, (String) null);
            long j = zzt.this.zzbwo().getLong(this.aqk, 0);
            zzafk();
            return (string == null || j <= 0) ? zzt.apO : new Pair<>(string, Long.valueOf(j));
        }

        @WorkerThread
        public void zzfd(String str) {
            zzi(str, 1);
        }

        @WorkerThread
        public void zzi(String str, long j) {
            zzt.this.zzyl();
            if (zzafn() == 0) {
                zzafk();
            }
            if (str == null) {
                str = "";
            }
            long j2 = zzt.this.f2296dy.getLong(this.aqk, 0);
            if (j2 <= 0) {
                SharedPreferences.Editor edit = zzt.this.f2296dy.edit();
                edit.putString(this.aql, str);
                edit.putLong(this.aqk, j);
                edit.apply();
                return;
            }
            boolean z = (zzt.this.zzbwl().nextLong() & Long.MAX_VALUE) < (Long.MAX_VALUE / (j2 + j)) * j;
            SharedPreferences.Editor edit2 = zzt.this.f2296dy.edit();
            if (z) {
                edit2.putString(this.aql, str);
            }
            edit2.putLong(this.aqk, j2 + j);
            edit2.apply();
        }
    }

    zzt(zzx zzx) {
        super(zzx);
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public SecureRandom zzbwl() {
        zzyl();
        if (this.apY == null) {
            this.apY = new SecureRandom();
        }
        return this.apY;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public SharedPreferences zzbwo() {
        zzyl();
        zzaax();
        return this.f2296dy;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void setMeasurementEnabled(boolean z) {
        zzyl();
        zzbvg().zzbwj().zzj("Setting measurementEnabled", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzbwo().edit();
        edit.putBoolean("measurement_enabled", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public String zzbst() {
        zzyl();
        try {
            return com.google.firebase.iid.zzc.m1500A().getId();
        } catch (IllegalStateException e) {
            zzbvg().zzbwe().log("Failed to retrieve Firebase Instance Id");
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public String zzbwm() {
        byte[] bArr = new byte[16];
        zzbwl().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public long zzbwn() {
        zzaax();
        zzyl();
        long j = this.apU.get();
        if (j != 0) {
            return j;
        }
        long nextInt = (long) (zzbwl().nextInt(86400000) + 1);
        this.apU.set(nextInt);
        return nextInt;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public String zzbwp() {
        zzyl();
        return zzbwo().getString("gmp_app_id", (String) null);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public Boolean zzbwq() {
        zzyl();
        if (!zzbwo().contains("use_service")) {
            return null;
        }
        return Boolean.valueOf(zzbwo().getBoolean("use_service", false));
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzbwr() {
        boolean z = true;
        zzyl();
        zzbvg().zzbwj().log("Clearing collection preferences.");
        boolean contains = zzbwo().contains("measurement_enabled");
        if (contains) {
            z = zzcg(true);
        }
        SharedPreferences.Editor edit = zzbwo().edit();
        edit.clear();
        edit.apply();
        if (contains) {
            setMeasurementEnabled(z);
        }
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public String zzbws() {
        zzyl();
        String string = zzbwo().getString("previous_os_version", (String) null);
        String zzbvv = zzbuz().zzbvv();
        if (!TextUtils.isEmpty(zzbvv) && !zzbvv.equals(string)) {
            SharedPreferences.Editor edit = zzbwo().edit();
            edit.putString("previous_os_version", zzbvv);
            edit.apply();
        }
        return string;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzcf(boolean z) {
        zzyl();
        zzbvg().zzbwj().zzj("Setting useService", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzbwo().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public boolean zzcg(boolean z) {
        zzyl();
        return zzbwo().getBoolean("measurement_enabled", z);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @NonNull
    public Pair<String, Boolean> zzml(String str) {
        zzyl();
        long elapsedRealtime = zzaan().elapsedRealtime();
        if (this.apV != null && elapsedRealtime < this.apX) {
            return new Pair<>(this.apV, Boolean.valueOf(this.apW));
        }
        this.apX = elapsedRealtime + zzbvi().zzlr(str);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(getContext());
            this.apV = advertisingIdInfo.getId();
            if (this.apV == null) {
                this.apV = "";
            }
            this.apW = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Throwable th) {
            zzbvg().zzbwi().zzj("Unable to get advertising id", th);
            this.apV = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.apV, Boolean.valueOf(this.apW));
    }

    /* access modifiers changed from: package-private */
    public String zzmm(String str) {
        String str2 = (String) zzml(str).first;
        MessageDigest zzfi = zzal.zzfi("MD5");
        if (zzfi == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzfi.digest(str2.getBytes()))});
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzmn(String str) {
        zzyl();
        SharedPreferences.Editor edit = zzbwo().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: protected */
    public void zzym() {
        this.f2296dy = getContext().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.aqe = this.f2296dy.getBoolean("has_been_opened", false);
        if (!this.aqe) {
            SharedPreferences.Editor edit = this.f2296dy.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
    }
}
