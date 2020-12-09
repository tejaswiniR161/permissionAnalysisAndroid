package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.support.annotation.WorkerThread;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzard;
import com.google.android.gms.internal.zzvk;
import com.google.android.gms.internal.zzvm;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class zze extends zzaa {
    /* access modifiers changed from: private */
    public static final Map<String, String> aoa = new ArrayMap(17);
    /* access modifiers changed from: private */
    public static final Map<String, String> aob = new ArrayMap(1);
    /* access modifiers changed from: private */
    public static final Map<String, String> aoc = new ArrayMap(1);
    private final zzc aod = new zzc(getContext(), zzabs());
    /* access modifiers changed from: private */
    public final zzah aoe = new zzah(zzaan());

    public static class zza {
        long aof;
        long aog;
        long aoh;
        long aoi;
        long aoj;
    }

    interface zzb {
        boolean zza(long j, zzvm.zzb zzb);

        void zzb(zzvm.zze zze);
    }

    private class zzc extends SQLiteOpenHelper {
        zzc(Context context, String str) {
            super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        }

        @WorkerThread
        private void zza(SQLiteDatabase sQLiteDatabase, String str, String str2, String str3, Map<String, String> map) throws SQLiteException {
            if (!zza(sQLiteDatabase, str)) {
                sQLiteDatabase.execSQL(str2);
            }
            try {
                zza(sQLiteDatabase, str, str3, map);
            } catch (SQLiteException e) {
                zze.this.zzbvg().zzbwc().zzj("Failed to verify columns on table that was just created", str);
                throw e;
            }
        }

        @WorkerThread
        private void zza(SQLiteDatabase sQLiteDatabase, String str, String str2, Map<String, String> map) throws SQLiteException {
            Set<String> zzb = zzb(sQLiteDatabase, str);
            for (String str3 : str2.split(",")) {
                if (!zzb.remove(str3)) {
                    throw new SQLiteException(new StringBuilder(String.valueOf(str).length() + 35 + String.valueOf(str3).length()).append("Table ").append(str).append(" is missing required column: ").append(str3).toString());
                }
            }
            if (map != null) {
                for (Map.Entry next : map.entrySet()) {
                    if (!zzb.remove(next.getKey())) {
                        sQLiteDatabase.execSQL((String) next.getValue());
                    }
                }
            }
            if (!zzb.isEmpty()) {
                zze.this.zzbvg().zzbwe().zze("Table has extra columns. table, columns", str, TextUtils.join(", ", zzb));
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
        @android.support.annotation.WorkerThread
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean zza(android.database.sqlite.SQLiteDatabase r11, java.lang.String r12) {
            /*
                r10 = this;
                r8 = 0
                r9 = 0
                java.lang.String r1 = "SQLITE_MASTER"
                r0 = 1
                java.lang.String[] r2 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0026, all -> 0x003e }
                r0 = 0
                java.lang.String r3 = "name"
                r2[r0] = r3     // Catch:{ SQLiteException -> 0x0026, all -> 0x003e }
                java.lang.String r3 = "name=?"
                r0 = 1
                java.lang.String[] r4 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0026, all -> 0x003e }
                r0 = 0
                r4[r0] = r12     // Catch:{ SQLiteException -> 0x0026, all -> 0x003e }
                r5 = 0
                r6 = 0
                r7 = 0
                r0 = r11
                android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0026, all -> 0x003e }
                boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0048 }
                if (r1 == 0) goto L_0x0025
                r1.close()
            L_0x0025:
                return r0
            L_0x0026:
                r0 = move-exception
                r1 = r9
            L_0x0028:
                com.google.android.gms.measurement.internal.zze r2 = com.google.android.gms.measurement.internal.zze.this     // Catch:{ all -> 0x0045 }
                com.google.android.gms.measurement.internal.zzp r2 = r2.zzbvg()     // Catch:{ all -> 0x0045 }
                com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbwe()     // Catch:{ all -> 0x0045 }
                java.lang.String r3 = "Error querying for table"
                r2.zze(r3, r12, r0)     // Catch:{ all -> 0x0045 }
                if (r1 == 0) goto L_0x003c
                r1.close()
            L_0x003c:
                r0 = r8
                goto L_0x0025
            L_0x003e:
                r0 = move-exception
            L_0x003f:
                if (r9 == 0) goto L_0x0044
                r9.close()
            L_0x0044:
                throw r0
            L_0x0045:
                r0 = move-exception
                r9 = r1
                goto L_0x003f
            L_0x0048:
                r0 = move-exception
                goto L_0x0028
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzc.zza(android.database.sqlite.SQLiteDatabase, java.lang.String):boolean");
        }

        @WorkerThread
        private Set<String> zzb(SQLiteDatabase sQLiteDatabase, String str) {
            HashSet hashSet = new HashSet();
            Cursor rawQuery = sQLiteDatabase.rawQuery(new StringBuilder(String.valueOf(str).length() + 22).append("SELECT * FROM ").append(str).append(" LIMIT 0").toString(), (String[]) null);
            try {
                Collections.addAll(hashSet, rawQuery.getColumnNames());
                return hashSet;
            } finally {
                rawQuery.close();
            }
        }

        @WorkerThread
        public SQLiteDatabase getWritableDatabase() {
            if (!zze.this.aoe.zzz(zze.this.zzbvi().zzbtz())) {
                throw new SQLiteException("Database open failed");
            }
            try {
                return super.getWritableDatabase();
            } catch (SQLiteException e) {
                zze.this.aoe.start();
                zze.this.zzbvg().zzbwc().log("Opening the database failed, dropping and recreating it");
                String zzabs = zze.this.zzabs();
                if (!zze.this.getContext().getDatabasePath(zzabs).delete()) {
                    zze.this.zzbvg().zzbwc().zzj("Failed to delete corrupted db file", zzabs);
                }
                try {
                    SQLiteDatabase writableDatabase = super.getWritableDatabase();
                    zze.this.aoe.clear();
                    return writableDatabase;
                } catch (SQLiteException e2) {
                    zze.this.zzbvg().zzbwc().zzj("Failed to open freshly created database", e2);
                    throw e2;
                }
            }
        }

        @WorkerThread
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (Build.VERSION.SDK_INT >= 9) {
                File file = new File(sQLiteDatabase.getPath());
                if (!file.setReadable(false, false)) {
                    zze.this.zzbvg().zzbwe().log("Failed to turn off database read permission");
                }
                if (!file.setWritable(false, false)) {
                    zze.this.zzbvg().zzbwe().log("Failed to turn off database write permission");
                }
                if (!file.setReadable(true, true)) {
                    zze.this.zzbvg().zzbwe().log("Failed to turn on database read permission for owner");
                }
                if (!file.setWritable(true, true)) {
                    zze.this.zzbvg().zzbwe().log("Failed to turn on database write permission for owner");
                }
            }
        }

        @WorkerThread
        public void onOpen(SQLiteDatabase sQLiteDatabase) {
            if (Build.VERSION.SDK_INT < 15) {
                Cursor rawQuery = sQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", (String[]) null);
                try {
                    rawQuery.moveToFirst();
                } finally {
                    rawQuery.close();
                }
            }
            zza(sQLiteDatabase, "events", "CREATE TABLE IF NOT EXISTS events ( app_id TEXT NOT NULL, name TEXT NOT NULL, lifetime_count INTEGER NOT NULL, current_bundle_count INTEGER NOT NULL, last_fire_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,lifetime_count,current_bundle_count,last_fire_timestamp", (Map<String, String>) null);
            zza(sQLiteDatabase, "user_attributes", "CREATE TABLE IF NOT EXISTS user_attributes ( app_id TEXT NOT NULL, name TEXT NOT NULL, set_timestamp INTEGER NOT NULL, value BLOB NOT NULL, PRIMARY KEY (app_id, name)) ;", "app_id,name,set_timestamp,value", (Map<String, String>) null);
            zza(sQLiteDatabase, "apps", "CREATE TABLE IF NOT EXISTS apps ( app_id TEXT NOT NULL, app_instance_id TEXT, gmp_app_id TEXT, resettable_device_id_hash TEXT, last_bundle_index INTEGER NOT NULL, last_bundle_end_timestamp INTEGER NOT NULL, PRIMARY KEY (app_id)) ;", "app_id,app_instance_id,gmp_app_id,resettable_device_id_hash,last_bundle_index,last_bundle_end_timestamp", zze.aoa);
            zza(sQLiteDatabase, "queue", "CREATE TABLE IF NOT EXISTS queue ( app_id TEXT NOT NULL, bundle_end_timestamp INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,bundle_end_timestamp,data", zze.aoc);
            zza(sQLiteDatabase, "raw_events_metadata", "CREATE TABLE IF NOT EXISTS raw_events_metadata ( app_id TEXT NOT NULL, metadata_fingerprint INTEGER NOT NULL, metadata BLOB NOT NULL, PRIMARY KEY (app_id, metadata_fingerprint));", "app_id,metadata_fingerprint,metadata", (Map<String, String>) null);
            zza(sQLiteDatabase, "raw_events", "CREATE TABLE IF NOT EXISTS raw_events ( app_id TEXT NOT NULL, name TEXT NOT NULL, timestamp INTEGER NOT NULL, metadata_fingerprint INTEGER NOT NULL, data BLOB NOT NULL);", "app_id,name,timestamp,metadata_fingerprint,data", zze.aob);
            zza(sQLiteDatabase, "event_filters", "CREATE TABLE IF NOT EXISTS event_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, event_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, event_name, audience_id, filter_id));", "app_id,audience_id,filter_id,event_name,data", (Map<String, String>) null);
            zza(sQLiteDatabase, "property_filters", "CREATE TABLE IF NOT EXISTS property_filters ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, filter_id INTEGER NOT NULL, property_name TEXT NOT NULL, data BLOB NOT NULL, PRIMARY KEY (app_id, property_name, audience_id, filter_id));", "app_id,audience_id,filter_id,property_name,data", (Map<String, String>) null);
            zza(sQLiteDatabase, "audience_filter_values", "CREATE TABLE IF NOT EXISTS audience_filter_values ( app_id TEXT NOT NULL, audience_id INTEGER NOT NULL, current_results BLOB, PRIMARY KEY (app_id, audience_id));", "app_id,audience_id,current_results", (Map<String, String>) null);
            zza(sQLiteDatabase, "app2", "CREATE TABLE IF NOT EXISTS app2 ( app_id TEXT NOT NULL, first_open_count INTEGER NOT NULL, PRIMARY KEY (app_id));", "app_id,first_open_count", (Map<String, String>) null);
        }

        @WorkerThread
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }
    }

    static {
        aoa.put("app_version", "ALTER TABLE apps ADD COLUMN app_version TEXT;");
        aoa.put("app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;");
        aoa.put("gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;");
        aoa.put("dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;");
        aoa.put("measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;");
        aoa.put("last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;");
        aoa.put("day", "ALTER TABLE apps ADD COLUMN day INTEGER;");
        aoa.put("daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;");
        aoa.put("daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;");
        aoa.put("daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;");
        aoa.put("remote_config", "ALTER TABLE apps ADD COLUMN remote_config BLOB;");
        aoa.put("config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;");
        aoa.put("failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;");
        aoa.put("app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;");
        aoa.put("firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;");
        aoa.put("daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;");
        aoa.put("daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;");
        aob.put("realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;");
        aoc.put("has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;");
    }

    zze(zzx zzx) {
        super(zzx);
    }

    @WorkerThread
    @TargetApi(11)
    static int zza(Cursor cursor, int i) {
        if (Build.VERSION.SDK_INT >= 11) {
            return cursor.getType(i);
        }
        CursorWindow window = ((SQLiteCursor) cursor).getWindow();
        int position = cursor.getPosition();
        if (window.isNull(position, i)) {
            return 0;
        }
        if (window.isLong(position, i)) {
            return 1;
        }
        if (window.isFloat(position, i)) {
            return 2;
        }
        if (window.isString(position, i)) {
            return 3;
        }
        return window.isBlob(position, i) ? 4 : -1;
    }

    @WorkerThread
    private long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = getWritableDatabase().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                j = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
            } else if (rawQuery != null) {
                rawQuery.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzbvg().zzbwc().zze("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zza(java.lang.String r8, com.google.android.gms.internal.zzvk.zza r9) {
        /*
            r7 = this;
            r0 = 0
            r7.zzaax()
            r7.zzyl()
            com.google.android.gms.common.internal.zzac.zzhz(r8)
            com.google.android.gms.common.internal.zzac.zzy(r9)
            com.google.android.gms.internal.zzvk$zzb[] r1 = r9.asC
            com.google.android.gms.common.internal.zzac.zzy(r1)
            com.google.android.gms.internal.zzvk$zze[] r1 = r9.asB
            com.google.android.gms.common.internal.zzac.zzy(r1)
            java.lang.Integer r1 = r9.asA
            if (r1 != 0) goto L_0x0029
            com.google.android.gms.measurement.internal.zzp r0 = r7.zzbvg()
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzbwe()
            java.lang.String r1 = "Audience with no ID"
            r0.log(r1)
        L_0x0028:
            return
        L_0x0029:
            java.lang.Integer r1 = r9.asA
            int r3 = r1.intValue()
            com.google.android.gms.internal.zzvk$zzb[] r2 = r9.asC
            int r4 = r2.length
            r1 = r0
        L_0x0033:
            if (r1 >= r4) goto L_0x004e
            r5 = r2[r1]
            java.lang.Integer r5 = r5.asE
            if (r5 != 0) goto L_0x004b
            com.google.android.gms.measurement.internal.zzp r0 = r7.zzbvg()
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzbwe()
            java.lang.String r1 = "Event filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Integer r2 = r9.asA
            r0.zze(r1, r8, r2)
            goto L_0x0028
        L_0x004b:
            int r1 = r1 + 1
            goto L_0x0033
        L_0x004e:
            com.google.android.gms.internal.zzvk$zze[] r2 = r9.asB
            int r4 = r2.length
            r1 = r0
        L_0x0052:
            if (r1 >= r4) goto L_0x006d
            r5 = r2[r1]
            java.lang.Integer r5 = r5.asE
            if (r5 != 0) goto L_0x006a
            com.google.android.gms.measurement.internal.zzp r0 = r7.zzbvg()
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzbwe()
            java.lang.String r1 = "Property filter with no ID. Audience definition ignored. appId, audienceId"
            java.lang.Integer r2 = r9.asA
            r0.zze(r1, r8, r2)
            goto L_0x0028
        L_0x006a:
            int r1 = r1 + 1
            goto L_0x0052
        L_0x006d:
            r1 = 1
            com.google.android.gms.internal.zzvk$zzb[] r4 = r9.asC
            int r5 = r4.length
            r2 = r0
        L_0x0072:
            if (r2 >= r5) goto L_0x007d
            r6 = r4[r2]
            boolean r6 = r7.zza((java.lang.String) r8, (int) r3, (com.google.android.gms.internal.zzvk.zzb) r6)
            if (r6 != 0) goto L_0x0093
            r1 = r0
        L_0x007d:
            if (r1 == 0) goto L_0x0099
            com.google.android.gms.internal.zzvk$zze[] r4 = r9.asB
            int r5 = r4.length
            r2 = r0
        L_0x0083:
            if (r2 >= r5) goto L_0x0099
            r6 = r4[r2]
            boolean r6 = r7.zza((java.lang.String) r8, (int) r3, (com.google.android.gms.internal.zzvk.zze) r6)
            if (r6 != 0) goto L_0x0096
        L_0x008d:
            if (r0 != 0) goto L_0x0028
            r7.zzaa(r8, r3)
            goto L_0x0028
        L_0x0093:
            int r2 = r2 + 1
            goto L_0x0072
        L_0x0096:
            int r2 = r2 + 1
            goto L_0x0083
        L_0x0099:
            r0 = r1
            goto L_0x008d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zza(java.lang.String, com.google.android.gms.internal.zzvk$zza):void");
    }

    @WorkerThread
    private boolean zza(String str, int i, zzvk.zzb zzb2) {
        zzaax();
        zzyl();
        zzac.zzhz(str);
        zzac.zzy(zzb2);
        if (TextUtils.isEmpty(zzb2.asF)) {
            zzbvg().zzbwe().zze("Event filter had no event name. Audience definition ignored. audienceId, filterId", Integer.valueOf(i), String.valueOf(zzb2.asE));
            return false;
        }
        try {
            byte[] bArr = new byte[zzb2.mo9192db()];
            zzard zzbe = zzard.zzbe(bArr);
            zzb2.zza(zzbe);
            zzbe.mo9123cO();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zzb2.asE);
            contentValues.put("event_name", zzb2.asF);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("event_filters", (String) null, contentValues, 5) == -1) {
                    zzbvg().zzbwc().log("Failed to insert event filter (got -1)");
                }
                return true;
            } catch (SQLiteException e) {
                zzbvg().zzbwc().zzj("Error storing event filter", e);
                return false;
            }
        } catch (IOException e2) {
            zzbvg().zzbwc().zzj("Configuration loss. Failed to serialize event filter", e2);
            return false;
        }
    }

    @WorkerThread
    private boolean zza(String str, int i, zzvk.zze zze) {
        zzaax();
        zzyl();
        zzac.zzhz(str);
        zzac.zzy(zze);
        if (TextUtils.isEmpty(zze.asU)) {
            zzbvg().zzbwe().zze("Property filter had no property name. Audience definition ignored. audienceId, filterId", Integer.valueOf(i), String.valueOf(zze.asE));
            return false;
        }
        try {
            byte[] bArr = new byte[zze.mo9192db()];
            zzard zzbe = zzard.zzbe(bArr);
            zze.zza(zzbe);
            zzbe.mo9123cO();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("filter_id", zze.asE);
            contentValues.put("property_name", zze.asU);
            contentValues.put("data", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("property_filters", (String) null, contentValues, 5) != -1) {
                    return true;
                }
                zzbvg().zzbwc().log("Failed to insert property filter (got -1)");
                return false;
            } catch (SQLiteException e) {
                zzbvg().zzbwc().zzj("Error storing property filter", e);
                return false;
            }
        } catch (IOException e2) {
            zzbvg().zzbwc().zzj("Configuration loss. Failed to serialize property filter", e2);
            return false;
        }
    }

    @WorkerThread
    private long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = getWritableDatabase().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzbvg().zzbwc().zze("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private boolean zzbvr() {
        return getContext().getDatabasePath(zzabs()).exists();
    }

    @WorkerThread
    public void beginTransaction() {
        zzaax();
        getWritableDatabase().beginTransaction();
    }

    @WorkerThread
    public void endTransaction() {
        zzaax();
        getWritableDatabase().endTransaction();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public SQLiteDatabase getWritableDatabase() {
        zzyl();
        try {
            return this.aod.getWritableDatabase();
        } catch (SQLiteException e) {
            zzbvg().zzbwe().zzj("Error opening database", e);
            throw e;
        }
    }

    @WorkerThread
    public void setTransactionSuccessful() {
        zzaax();
        getWritableDatabase().setTransactionSuccessful();
    }

    public long zza(zzvm.zze zze) throws IOException {
        zzyl();
        zzaax();
        zzac.zzy(zze);
        zzac.zzhz(zze.zzck);
        try {
            byte[] bArr = new byte[zze.mo9192db()];
            zzard zzbe = zzard.zzbe(bArr);
            zze.zza(zzbe);
            zzbe.mo9123cO();
            long zzy = zzbvc().zzy(bArr);
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zze.zzck);
            contentValues.put("metadata_fingerprint", Long.valueOf(zzy));
            contentValues.put("metadata", bArr);
            try {
                getWritableDatabase().insertWithOnConflict("raw_events_metadata", (String) null, contentValues, 4);
                return zzy;
            } catch (SQLiteException e) {
                zzbvg().zzbwc().zzj("Error storing raw event metadata", e);
                throw e;
            }
        } catch (IOException e2) {
            zzbvg().zzbwc().zzj("Data loss. Failed to serialize event metadata", e2);
            throw e2;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x012d  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.measurement.internal.zze.zza zza(long r12, java.lang.String r14, boolean r15, boolean r16, boolean r17, boolean r18, boolean r19) {
        /*
            r11 = this;
            com.google.android.gms.common.internal.zzac.zzhz(r14)
            r11.zzyl()
            r11.zzaax()
            r0 = 1
            java.lang.String[] r10 = new java.lang.String[r0]
            r0 = 0
            r10[r0] = r14
            com.google.android.gms.measurement.internal.zze$zza r8 = new com.google.android.gms.measurement.internal.zze$zza
            r8.<init>()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r0 = r11.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0112, all -> 0x0129 }
            java.lang.String r1 = "apps"
            r2 = 6
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0112, all -> 0x0129 }
            r3 = 0
            java.lang.String r4 = "day"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0112, all -> 0x0129 }
            r3 = 1
            java.lang.String r4 = "daily_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0112, all -> 0x0129 }
            r3 = 2
            java.lang.String r4 = "daily_public_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0112, all -> 0x0129 }
            r3 = 3
            java.lang.String r4 = "daily_conversions_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0112, all -> 0x0129 }
            r3 = 4
            java.lang.String r4 = "daily_error_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0112, all -> 0x0129 }
            r3 = 5
            java.lang.String r4 = "daily_realtime_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0112, all -> 0x0129 }
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0112, all -> 0x0129 }
            r5 = 0
            r4[r5] = r14     // Catch:{ SQLiteException -> 0x0112, all -> 0x0129 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0112, all -> 0x0129 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0133 }
            if (r2 != 0) goto L_0x0065
            com.google.android.gms.measurement.internal.zzp r0 = r11.zzbvg()     // Catch:{ SQLiteException -> 0x0133 }
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzbwe()     // Catch:{ SQLiteException -> 0x0133 }
            java.lang.String r2 = "Not updating daily counts, app is not known"
            r0.zzj(r2, r14)     // Catch:{ SQLiteException -> 0x0133 }
            if (r1 == 0) goto L_0x0063
            r1.close()
        L_0x0063:
            r0 = r8
        L_0x0064:
            return r0
        L_0x0065:
            r2 = 0
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x0133 }
            int r2 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x0091
            r2 = 1
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x0133 }
            r8.aog = r2     // Catch:{ SQLiteException -> 0x0133 }
            r2 = 2
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x0133 }
            r8.aof = r2     // Catch:{ SQLiteException -> 0x0133 }
            r2 = 3
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x0133 }
            r8.aoh = r2     // Catch:{ SQLiteException -> 0x0133 }
            r2 = 4
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x0133 }
            r8.aoi = r2     // Catch:{ SQLiteException -> 0x0133 }
            r2 = 5
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x0133 }
            r8.aoj = r2     // Catch:{ SQLiteException -> 0x0133 }
        L_0x0091:
            if (r15 == 0) goto L_0x009a
            long r2 = r8.aog     // Catch:{ SQLiteException -> 0x0133 }
            r4 = 1
            long r2 = r2 + r4
            r8.aog = r2     // Catch:{ SQLiteException -> 0x0133 }
        L_0x009a:
            if (r16 == 0) goto L_0x00a3
            long r2 = r8.aof     // Catch:{ SQLiteException -> 0x0133 }
            r4 = 1
            long r2 = r2 + r4
            r8.aof = r2     // Catch:{ SQLiteException -> 0x0133 }
        L_0x00a3:
            if (r17 == 0) goto L_0x00ac
            long r2 = r8.aoh     // Catch:{ SQLiteException -> 0x0133 }
            r4 = 1
            long r2 = r2 + r4
            r8.aoh = r2     // Catch:{ SQLiteException -> 0x0133 }
        L_0x00ac:
            if (r18 == 0) goto L_0x00b5
            long r2 = r8.aoi     // Catch:{ SQLiteException -> 0x0133 }
            r4 = 1
            long r2 = r2 + r4
            r8.aoi = r2     // Catch:{ SQLiteException -> 0x0133 }
        L_0x00b5:
            if (r19 == 0) goto L_0x00be
            long r2 = r8.aoj     // Catch:{ SQLiteException -> 0x0133 }
            r4 = 1
            long r2 = r2 + r4
            r8.aoj = r2     // Catch:{ SQLiteException -> 0x0133 }
        L_0x00be:
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch:{ SQLiteException -> 0x0133 }
            r2.<init>()     // Catch:{ SQLiteException -> 0x0133 }
            java.lang.String r3 = "day"
            java.lang.Long r4 = java.lang.Long.valueOf(r12)     // Catch:{ SQLiteException -> 0x0133 }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x0133 }
            java.lang.String r3 = "daily_public_events_count"
            long r4 = r8.aof     // Catch:{ SQLiteException -> 0x0133 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x0133 }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x0133 }
            java.lang.String r3 = "daily_events_count"
            long r4 = r8.aog     // Catch:{ SQLiteException -> 0x0133 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x0133 }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x0133 }
            java.lang.String r3 = "daily_conversions_count"
            long r4 = r8.aoh     // Catch:{ SQLiteException -> 0x0133 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x0133 }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x0133 }
            java.lang.String r3 = "daily_error_events_count"
            long r4 = r8.aoi     // Catch:{ SQLiteException -> 0x0133 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x0133 }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x0133 }
            java.lang.String r3 = "daily_realtime_events_count"
            long r4 = r8.aoj     // Catch:{ SQLiteException -> 0x0133 }
            java.lang.Long r4 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x0133 }
            r2.put(r3, r4)     // Catch:{ SQLiteException -> 0x0133 }
            java.lang.String r3 = "apps"
            java.lang.String r4 = "app_id=?"
            r0.update(r3, r2, r4, r10)     // Catch:{ SQLiteException -> 0x0133 }
            if (r1 == 0) goto L_0x010f
            r1.close()
        L_0x010f:
            r0 = r8
            goto L_0x0064
        L_0x0112:
            r0 = move-exception
            r1 = r9
        L_0x0114:
            com.google.android.gms.measurement.internal.zzp r2 = r11.zzbvg()     // Catch:{ all -> 0x0131 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbwc()     // Catch:{ all -> 0x0131 }
            java.lang.String r3 = "Error updating daily counts"
            r2.zzj(r3, r0)     // Catch:{ all -> 0x0131 }
            if (r1 == 0) goto L_0x0126
            r1.close()
        L_0x0126:
            r0 = r8
            goto L_0x0064
        L_0x0129:
            r0 = move-exception
            r1 = r9
        L_0x012b:
            if (r1 == 0) goto L_0x0130
            r1.close()
        L_0x0130:
            throw r0
        L_0x0131:
            r0 = move-exception
            goto L_0x012b
        L_0x0133:
            r0 = move-exception
            goto L_0x0114
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zza(long, java.lang.String, boolean, boolean, boolean, boolean, boolean):com.google.android.gms.measurement.internal.zze$zza");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zza(ContentValues contentValues, String str, Object obj) {
        zzac.zzhz(str);
        zzac.zzy(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    @WorkerThread
    public void zza(zzvm.zze zze, boolean z) {
        zzyl();
        zzaax();
        zzac.zzy(zze);
        zzac.zzhz(zze.zzck);
        zzac.zzy(zze.atA);
        zzbvl();
        long currentTimeMillis = zzaan().currentTimeMillis();
        if (zze.atA.longValue() < currentTimeMillis - zzbvi().zzbue() || zze.atA.longValue() > zzbvi().zzbue() + currentTimeMillis) {
            zzbvg().zzbwe().zze("Storing bundle outside of the max uploading time span. now, timestamp", Long.valueOf(currentTimeMillis), zze.atA);
        }
        try {
            byte[] bArr = new byte[zze.mo9192db()];
            zzard zzbe = zzard.zzbe(bArr);
            zze.zza(zzbe);
            zzbe.mo9123cO();
            byte[] zzj = zzbvc().zzj(bArr);
            zzbvg().zzbwj().zzj("Saving bundle, size", Integer.valueOf(zzj.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zze.zzck);
            contentValues.put("bundle_end_timestamp", zze.atA);
            contentValues.put("data", zzj);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            try {
                if (getWritableDatabase().insert("queue", (String) null, contentValues) == -1) {
                    zzbvg().zzbwc().log("Failed to insert bundle (got -1)");
                }
            } catch (SQLiteException e) {
                zzbvg().zzbwc().zzj("Error storing bundle", e);
            }
        } catch (IOException e2) {
            zzbvg().zzbwc().zzj("Data loss. Failed to serialize bundle", e2);
        }
    }

    @WorkerThread
    public void zza(zza zza2) {
        zzac.zzy(zza2);
        zzyl();
        zzaax();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zza2.zzti());
        contentValues.put("app_instance_id", zza2.zzayn());
        contentValues.put("gmp_app_id", zza2.zzbsr());
        contentValues.put("resettable_device_id_hash", zza2.zzbss());
        contentValues.put("last_bundle_index", Long.valueOf(zza2.zzbtb()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zza2.zzbsu()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zza2.zzbsv()));
        contentValues.put("app_version", zza2.zzyt());
        contentValues.put("app_store", zza2.zzbsx());
        contentValues.put("gmp_version", Long.valueOf(zza2.zzbsy()));
        contentValues.put("dev_cert_hash", Long.valueOf(zza2.zzbsz()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zza2.zzbta()));
        contentValues.put("day", Long.valueOf(zza2.zzbtf()));
        contentValues.put("daily_public_events_count", Long.valueOf(zza2.zzbtg()));
        contentValues.put("daily_events_count", Long.valueOf(zza2.zzbth()));
        contentValues.put("daily_conversions_count", Long.valueOf(zza2.zzbti()));
        contentValues.put("config_fetched_time", Long.valueOf(zza2.zzbtc()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zza2.zzbtd()));
        contentValues.put("app_version_int", Long.valueOf(zza2.zzbsw()));
        contentValues.put("firebase_instance_id", zza2.zzbst());
        contentValues.put("daily_error_events_count", Long.valueOf(zza2.zzbtk()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zza2.zzbtj()));
        try {
            if (getWritableDatabase().insertWithOnConflict("apps", (String) null, contentValues, 5) == -1) {
                zzbvg().zzbwc().log("Failed to insert/update app (got -1)");
            }
        } catch (SQLiteException e) {
            zzbvg().zzbwc().zzj("Error storing app", e);
        }
    }

    public void zza(zzh zzh, long j, boolean z) {
        int i = 0;
        zzyl();
        zzaax();
        zzac.zzy(zzh);
        zzac.zzhz(zzh.zzcpe);
        zzvm.zzb zzb2 = new zzvm.zzb();
        zzb2.atq = Long.valueOf(zzh.aor);
        zzb2.ato = new zzvm.zzc[zzh.aos.size()];
        Iterator<String> it = zzh.aos.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            String next = it.next();
            zzvm.zzc zzc2 = new zzvm.zzc();
            zzb2.ato[i2] = zzc2;
            zzc2.name = next;
            zzbvc().zza(zzc2, zzh.aos.get(next));
            i2++;
        }
        try {
            byte[] bArr = new byte[zzb2.mo9192db()];
            zzard zzbe = zzard.zzbe(bArr);
            zzb2.zza(zzbe);
            zzbe.mo9123cO();
            zzbvg().zzbwj().zze("Saving event, name, data size", zzh.mName, Integer.valueOf(bArr.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzh.zzcpe);
            contentValues.put("name", zzh.mName);
            contentValues.put("timestamp", Long.valueOf(zzh.f2285tr));
            contentValues.put("metadata_fingerprint", Long.valueOf(j));
            contentValues.put("data", bArr);
            if (z) {
                i = 1;
            }
            contentValues.put("realtime", Integer.valueOf(i));
            try {
                if (getWritableDatabase().insert("raw_events", (String) null, contentValues) == -1) {
                    zzbvg().zzbwc().log("Failed to insert raw event (got -1)");
                }
            } catch (SQLiteException e) {
                zzbvg().zzbwc().zzj("Error storing raw event", e);
            }
        } catch (IOException e2) {
            zzbvg().zzbwc().zzj("Data loss. Failed to serialize event params/data", e2);
        }
    }

    @WorkerThread
    public void zza(zzi zzi) {
        zzac.zzy(zzi);
        zzyl();
        zzaax();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzi.zzcpe);
        contentValues.put("name", zzi.mName);
        contentValues.put("lifetime_count", Long.valueOf(zzi.aot));
        contentValues.put("current_bundle_count", Long.valueOf(zzi.aou));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzi.aov));
        try {
            if (getWritableDatabase().insertWithOnConflict("events", (String) null, contentValues, 5) == -1) {
                zzbvg().zzbwc().log("Failed to insert/update event aggregates (got -1)");
            }
        } catch (SQLiteException e) {
            zzbvg().zzbwc().zzj("Error storing event aggregates", e);
        }
    }

    /* access modifiers changed from: package-private */
    public void zza(String str, int i, zzvm.zzf zzf) {
        zzaax();
        zzyl();
        zzac.zzhz(str);
        zzac.zzy(zzf);
        try {
            byte[] bArr = new byte[zzf.mo9192db()];
            zzard zzbe = zzard.zzbe(bArr);
            zzf.zza(zzbe);
            zzbe.mo9123cO();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", Integer.valueOf(i));
            contentValues.put("current_results", bArr);
            try {
                if (getWritableDatabase().insertWithOnConflict("audience_filter_values", (String) null, contentValues, 5) == -1) {
                    zzbvg().zzbwc().log("Failed to insert filter results (got -1)");
                }
            } catch (SQLiteException e) {
                zzbvg().zzbwc().zzj("Error storing filter results", e);
            }
        } catch (IOException e2) {
            zzbvg().zzbwc().zzj("Configuration loss. Failed to serialize filter results", e2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:72:0x017a, code lost:
        r2 = e;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x017a A[ExcHandler: SQLiteException (e android.database.sqlite.SQLiteException), Splitter:B:1:0x000a] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0193  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zza(java.lang.String r15, long r16, com.google.android.gms.measurement.internal.zze.zzb r18) {
        /*
            r14 = this;
            r3 = 0
            com.google.android.gms.common.internal.zzac.zzy(r18)
            r14.zzyl()
            r14.zzaax()
            android.database.sqlite.SQLiteDatabase r2 = r14.getWritableDatabase()     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            boolean r4 = android.text.TextUtils.isEmpty(r15)     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            if (r4 == 0) goto L_0x0077
            java.lang.String r4 = "select app_id, metadata_fingerprint from raw_events where app_id in (select app_id from apps where config_fetched_time >= ?) order by rowid limit 1;"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            r6 = 0
            java.lang.String r7 = java.lang.String.valueOf(r16)     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            r5[r6] = r7     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            android.database.Cursor r3 = r2.rawQuery(r4, r5)     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            boolean r4 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x017a }
            if (r4 != 0) goto L_0x0030
            if (r3 == 0) goto L_0x002f
            r3.close()
        L_0x002f:
            return
        L_0x0030:
            r4 = 0
            java.lang.String r15 = r3.getString(r4)     // Catch:{ SQLiteException -> 0x017a }
            r4 = 1
            java.lang.String r4 = r3.getString(r4)     // Catch:{ SQLiteException -> 0x017a }
            r3.close()     // Catch:{ SQLiteException -> 0x017a }
            r12 = r4
            r11 = r3
        L_0x003f:
            java.lang.String r3 = "raw_events_metadata"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r5 = 0
            java.lang.String r6 = "metadata"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            java.lang.String r5 = "app_id=? and metadata_fingerprint=?"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r7 = 0
            r6[r7] = r15     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r7 = 1
            r6[r7] = r12     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid"
            java.lang.String r10 = "2"
            android.database.Cursor r11 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            boolean r3 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            if (r3 != 0) goto L_0x009a
            com.google.android.gms.measurement.internal.zzp r2 = r14.zzbvg()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbwc()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            java.lang.String r3 = "Raw event metadata record is missing"
            r2.log(r3)     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            if (r11 == 0) goto L_0x002f
            r11.close()
            goto L_0x002f
        L_0x0077:
            java.lang.String r4 = "select metadata_fingerprint from raw_events where app_id = ? order by rowid limit 1;"
            r5 = 1
            java.lang.String[] r5 = new java.lang.String[r5]     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            r6 = 0
            r5[r6] = r15     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            android.database.Cursor r3 = r2.rawQuery(r4, r5)     // Catch:{ SQLiteException -> 0x017a, all -> 0x018f }
            boolean r4 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x017a }
            if (r4 != 0) goto L_0x008f
            if (r3 == 0) goto L_0x002f
            r3.close()
            goto L_0x002f
        L_0x008f:
            r4 = 0
            java.lang.String r4 = r3.getString(r4)     // Catch:{ SQLiteException -> 0x017a }
            r3.close()     // Catch:{ SQLiteException -> 0x017a }
            r12 = r4
            r11 = r3
            goto L_0x003f
        L_0x009a:
            r3 = 0
            byte[] r3 = r11.getBlob(r3)     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            com.google.android.gms.internal.zzarc r3 = com.google.android.gms.internal.zzarc.zzbd(r3)     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            com.google.android.gms.internal.zzvm$zze r4 = new com.google.android.gms.internal.zzvm$zze     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r4.<init>()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            com.google.android.gms.internal.zzark r3 = r4.zzb(r3)     // Catch:{ IOException -> 0x0110 }
            com.google.android.gms.internal.zzvm$zze r3 = (com.google.android.gms.internal.zzvm.zze) r3     // Catch:{ IOException -> 0x0110 }
            boolean r3 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            if (r3 == 0) goto L_0x00c1
            com.google.android.gms.measurement.internal.zzp r3 = r14.zzbvg()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            com.google.android.gms.measurement.internal.zzp$zza r3 = r3.zzbwe()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            java.lang.String r5 = "Get multiple raw event metadata records, expected one"
            r3.log(r5)     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
        L_0x00c1:
            r11.close()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r0 = r18
            r0.zzb(r4)     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            java.lang.String r3 = "raw_events"
            r4 = 4
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r5 = 0
            java.lang.String r6 = "rowid"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r5 = 1
            java.lang.String r6 = "name"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r5 = 2
            java.lang.String r6 = "timestamp"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r5 = 3
            java.lang.String r6 = "data"
            r4[r5] = r6     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            java.lang.String r5 = "app_id=? and metadata_fingerprint=?"
            r6 = 2
            java.lang.String[] r6 = new java.lang.String[r6]     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r7 = 0
            r6[r7] = r15     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r7 = 1
            r6[r7] = r12     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            r7 = 0
            r8 = 0
            java.lang.String r9 = "rowid"
            r10 = 0
            android.database.Cursor r3 = r2.query(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            boolean r2 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x017a }
            if (r2 != 0) goto L_0x0125
            com.google.android.gms.measurement.internal.zzp r2 = r14.zzbvg()     // Catch:{ SQLiteException -> 0x017a }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbwe()     // Catch:{ SQLiteException -> 0x017a }
            java.lang.String r4 = "Raw event data disappeared while in transaction"
            r2.log(r4)     // Catch:{ SQLiteException -> 0x017a }
            if (r3 == 0) goto L_0x002f
            r3.close()
            goto L_0x002f
        L_0x0110:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzp r3 = r14.zzbvg()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            com.google.android.gms.measurement.internal.zzp$zza r3 = r3.zzbwc()     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            java.lang.String r4 = "Data loss. Failed to merge raw event metadata"
            r3.zze(r4, r15, r2)     // Catch:{ SQLiteException -> 0x019c, all -> 0x019a }
            if (r11 == 0) goto L_0x002f
            r11.close()
            goto L_0x002f
        L_0x0125:
            r2 = 0
            long r4 = r3.getLong(r2)     // Catch:{ SQLiteException -> 0x017a }
            r2 = 3
            byte[] r2 = r3.getBlob(r2)     // Catch:{ SQLiteException -> 0x017a }
            com.google.android.gms.internal.zzarc r2 = com.google.android.gms.internal.zzarc.zzbd(r2)     // Catch:{ SQLiteException -> 0x017a }
            com.google.android.gms.internal.zzvm$zzb r6 = new com.google.android.gms.internal.zzvm$zzb     // Catch:{ SQLiteException -> 0x017a }
            r6.<init>()     // Catch:{ SQLiteException -> 0x017a }
            com.google.android.gms.internal.zzark r2 = r6.zzb(r2)     // Catch:{ IOException -> 0x015f }
            com.google.android.gms.internal.zzvm$zzb r2 = (com.google.android.gms.internal.zzvm.zzb) r2     // Catch:{ IOException -> 0x015f }
            r2 = 1
            java.lang.String r2 = r3.getString(r2)     // Catch:{ SQLiteException -> 0x017a }
            r6.name = r2     // Catch:{ SQLiteException -> 0x017a }
            r2 = 2
            long r8 = r3.getLong(r2)     // Catch:{ SQLiteException -> 0x017a }
            java.lang.Long r2 = java.lang.Long.valueOf(r8)     // Catch:{ SQLiteException -> 0x017a }
            r6.atp = r2     // Catch:{ SQLiteException -> 0x017a }
            r0 = r18
            boolean r2 = r0.zza(r4, r6)     // Catch:{ SQLiteException -> 0x017a }
            if (r2 != 0) goto L_0x016d
            if (r3 == 0) goto L_0x002f
            r3.close()
            goto L_0x002f
        L_0x015f:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzp r4 = r14.zzbvg()     // Catch:{ SQLiteException -> 0x017a }
            com.google.android.gms.measurement.internal.zzp$zza r4 = r4.zzbwc()     // Catch:{ SQLiteException -> 0x017a }
            java.lang.String r5 = "Data loss. Failed to merge raw event"
            r4.zze(r5, r15, r2)     // Catch:{ SQLiteException -> 0x017a }
        L_0x016d:
            boolean r2 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x017a }
            if (r2 != 0) goto L_0x0125
            if (r3 == 0) goto L_0x002f
            r3.close()
            goto L_0x002f
        L_0x017a:
            r2 = move-exception
        L_0x017b:
            com.google.android.gms.measurement.internal.zzp r4 = r14.zzbvg()     // Catch:{ all -> 0x0197 }
            com.google.android.gms.measurement.internal.zzp$zza r4 = r4.zzbwc()     // Catch:{ all -> 0x0197 }
            java.lang.String r5 = "Data loss. Error selecting raw event"
            r4.zzj(r5, r2)     // Catch:{ all -> 0x0197 }
            if (r3 == 0) goto L_0x002f
            r3.close()
            goto L_0x002f
        L_0x018f:
            r2 = move-exception
            r11 = r3
        L_0x0191:
            if (r11 == 0) goto L_0x0196
            r11.close()
        L_0x0196:
            throw r2
        L_0x0197:
            r2 = move-exception
            r11 = r3
            goto L_0x0191
        L_0x019a:
            r2 = move-exception
            goto L_0x0191
        L_0x019c:
            r2 = move-exception
            r3 = r11
            goto L_0x017b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zza(java.lang.String, long, com.google.android.gms.measurement.internal.zze$zzb):void");
    }

    @WorkerThread
    public boolean zza(zzak zzak) {
        zzac.zzy(zzak);
        zzyl();
        zzaax();
        if (zzas(zzak.zzcpe, zzak.mName) == null) {
            if (zzal.zzmx(zzak.mName)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzak.zzcpe}) >= ((long) zzbvi().zzbtx())) {
                    return false;
                }
            } else {
                if (zzb("select count(1) from user_attributes where app_id=?", new String[]{zzak.zzcpe}) >= ((long) zzbvi().zzbty())) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzak.zzcpe);
        contentValues.put("name", zzak.mName);
        contentValues.put("set_timestamp", Long.valueOf(zzak.asy));
        zza(contentValues, FirebaseAnalytics.Param.VALUE, zzak.zzctv);
        try {
            if (getWritableDatabase().insertWithOnConflict("user_attributes", (String) null, contentValues, 5) == -1) {
                zzbvg().zzbwc().log("Failed to insert/update user property (got -1)");
            }
        } catch (SQLiteException e) {
            zzbvg().zzbwc().zzj("Error storing user property", e);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzaa(String str, int i) {
        zzaax();
        zzyl();
        zzac.zzhz(str);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("property_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
        writableDatabase.delete("event_filters", "app_id=? and audience_id=?", new String[]{str, String.valueOf(i)});
    }

    /* access modifiers changed from: package-private */
    public String zzabs() {
        if (!zzbvi().zzact()) {
            return zzbvi().zzadt();
        }
        if (zzbvi().zzacu()) {
            return zzbvi().zzadt();
        }
        zzbvg().zzbwf().log("Using secondary database");
        return zzbvi().zzadu();
    }

    public void zzaf(List<Long> list) {
        zzac.zzy(list);
        zzyl();
        zzaax();
        StringBuilder sb = new StringBuilder("rowid in (");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                break;
            }
            if (i2 != 0) {
                sb.append(",");
            }
            sb.append(list.get(i2).longValue());
            i = i2 + 1;
        }
        sb.append(")");
        int delete = getWritableDatabase().delete("raw_events", sb.toString(), (String[]) null);
        if (delete != list.size()) {
            zzbvg().zzbwc().zze("Deleted fewer rows from raw events table than expected", Integer.valueOf(delete), Integer.valueOf(list.size()));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x008c  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.measurement.internal.zzi zzaq(java.lang.String r13, java.lang.String r14) {
        /*
            r12 = this;
            r10 = 0
            com.google.android.gms.common.internal.zzac.zzhz(r13)
            com.google.android.gms.common.internal.zzac.zzhz(r14)
            r12.zzyl()
            r12.zzaax()
            android.database.sqlite.SQLiteDatabase r0 = r12.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            java.lang.String r1 = "events"
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            r3 = 0
            java.lang.String r4 = "lifetime_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            r3 = 1
            java.lang.String r4 = "current_bundle_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            r3 = 2
            java.lang.String r4 = "last_fire_timestamp"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            java.lang.String r3 = "app_id=? and name=?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            r5 = 0
            r4[r5] = r13     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            r5 = 1
            r4[r5] = r14     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r11 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0073, all -> 0x0089 }
            boolean r0 = r11.moveToFirst()     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            if (r0 != 0) goto L_0x0044
            if (r11 == 0) goto L_0x0042
            r11.close()
        L_0x0042:
            r1 = r10
        L_0x0043:
            return r1
        L_0x0044:
            r0 = 0
            long r4 = r11.getLong(r0)     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            r0 = 1
            long r6 = r11.getLong(r0)     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            r0 = 2
            long r8 = r11.getLong(r0)     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            com.google.android.gms.measurement.internal.zzi r1 = new com.google.android.gms.measurement.internal.zzi     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            r2 = r13
            r3 = r14
            r1.<init>(r2, r3, r4, r6, r8)     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            boolean r0 = r11.moveToNext()     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            if (r0 == 0) goto L_0x006d
            com.google.android.gms.measurement.internal.zzp r0 = r12.zzbvg()     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzbwc()     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
            java.lang.String r2 = "Got multiple records for event aggregates, expected one"
            r0.log(r2)     // Catch:{ SQLiteException -> 0x0096, all -> 0x0090 }
        L_0x006d:
            if (r11 == 0) goto L_0x0043
            r11.close()
            goto L_0x0043
        L_0x0073:
            r0 = move-exception
            r1 = r10
        L_0x0075:
            com.google.android.gms.measurement.internal.zzp r2 = r12.zzbvg()     // Catch:{ all -> 0x0093 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbwc()     // Catch:{ all -> 0x0093 }
            java.lang.String r3 = "Error querying events"
            r2.zzd(r3, r13, r14, r0)     // Catch:{ all -> 0x0093 }
            if (r1 == 0) goto L_0x0087
            r1.close()
        L_0x0087:
            r1 = r10
            goto L_0x0043
        L_0x0089:
            r0 = move-exception
        L_0x008a:
            if (r10 == 0) goto L_0x008f
            r10.close()
        L_0x008f:
            throw r0
        L_0x0090:
            r0 = move-exception
            r10 = r11
            goto L_0x008a
        L_0x0093:
            r0 = move-exception
            r10 = r1
            goto L_0x008a
        L_0x0096:
            r0 = move-exception
            r1 = r11
            goto L_0x0075
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzaq(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzi");
    }

    @WorkerThread
    public void zzar(String str, String str2) {
        zzac.zzhz(str);
        zzac.zzhz(str2);
        zzyl();
        zzaax();
        try {
            zzbvg().zzbwj().zzj("Deleted user attribute rows:", Integer.valueOf(getWritableDatabase().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2})));
        } catch (SQLiteException e) {
            zzbvg().zzbwc().zzd("Error deleting user attribute", str, str2, e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0082  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.measurement.internal.zzak zzas(java.lang.String r10, java.lang.String r11) {
        /*
            r9 = this;
            r8 = 0
            com.google.android.gms.common.internal.zzac.zzhz(r10)
            com.google.android.gms.common.internal.zzac.zzhz(r11)
            r9.zzyl()
            r9.zzaax()
            android.database.sqlite.SQLiteDatabase r0 = r9.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0069, all -> 0x007f }
            java.lang.String r1 = "user_attributes"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0069, all -> 0x007f }
            r3 = 0
            java.lang.String r4 = "set_timestamp"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0069, all -> 0x007f }
            r3 = 1
            java.lang.String r4 = "value"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0069, all -> 0x007f }
            java.lang.String r3 = "app_id=? and name=?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0069, all -> 0x007f }
            r5 = 0
            r4[r5] = r10     // Catch:{ SQLiteException -> 0x0069, all -> 0x007f }
            r5 = 1
            r4[r5] = r11     // Catch:{ SQLiteException -> 0x0069, all -> 0x007f }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r7 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0069, all -> 0x007f }
            boolean r0 = r7.moveToFirst()     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
            if (r0 != 0) goto L_0x003f
            if (r7 == 0) goto L_0x003d
            r7.close()
        L_0x003d:
            r1 = r8
        L_0x003e:
            return r1
        L_0x003f:
            r0 = 0
            long r4 = r7.getLong(r0)     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
            r0 = 1
            java.lang.Object r6 = r9.zzb((android.database.Cursor) r7, (int) r0)     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
            com.google.android.gms.measurement.internal.zzak r1 = new com.google.android.gms.measurement.internal.zzak     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
            r2 = r10
            r3 = r11
            r1.<init>(r2, r3, r4, r6)     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
            boolean r0 = r7.moveToNext()     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
            if (r0 == 0) goto L_0x0063
            com.google.android.gms.measurement.internal.zzp r0 = r9.zzbvg()     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzbwc()     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
            java.lang.String r2 = "Got multiple records for user property, expected one"
            r0.log(r2)     // Catch:{ SQLiteException -> 0x008c, all -> 0x0086 }
        L_0x0063:
            if (r7 == 0) goto L_0x003e
            r7.close()
            goto L_0x003e
        L_0x0069:
            r0 = move-exception
            r1 = r8
        L_0x006b:
            com.google.android.gms.measurement.internal.zzp r2 = r9.zzbvg()     // Catch:{ all -> 0x0089 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbwc()     // Catch:{ all -> 0x0089 }
            java.lang.String r3 = "Error querying user property"
            r2.zzd(r3, r10, r11, r0)     // Catch:{ all -> 0x0089 }
            if (r1 == 0) goto L_0x007d
            r1.close()
        L_0x007d:
            r1 = r8
            goto L_0x003e
        L_0x007f:
            r0 = move-exception
        L_0x0080:
            if (r8 == 0) goto L_0x0085
            r8.close()
        L_0x0085:
            throw r0
        L_0x0086:
            r0 = move-exception
            r8 = r7
            goto L_0x0080
        L_0x0089:
            r0 = move-exception
            r8 = r1
            goto L_0x0080
        L_0x008c:
            r0 = move-exception
            r1 = r7
            goto L_0x006b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzas(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzak");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.zzvk.zzb>> zzat(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            r9 = 0
            r10.zzaax()
            r10.zzyl()
            com.google.android.gms.common.internal.zzac.zzhz(r11)
            com.google.android.gms.common.internal.zzac.zzhz(r12)
            android.support.v4.util.ArrayMap r8 = new android.support.v4.util.ArrayMap
            r8.<init>()
            android.database.sqlite.SQLiteDatabase r0 = r10.getWritableDatabase()
            java.lang.String r1 = "event_filters"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r3 = 0
            java.lang.String r4 = "audience_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r3 = 1
            java.lang.String r4 = "data"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            java.lang.String r3 = "app_id=? AND event_name=?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r5 = 0
            r4[r5] = r11     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r5 = 1
            r4[r5] = r12     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0097 }
            if (r0 != 0) goto L_0x0047
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0097 }
            if (r1 == 0) goto L_0x0046
            r1.close()
        L_0x0046:
            return r0
        L_0x0047:
            r0 = 1
            byte[] r0 = r1.getBlob(r0)     // Catch:{ SQLiteException -> 0x0097 }
            com.google.android.gms.internal.zzarc r0 = com.google.android.gms.internal.zzarc.zzbd(r0)     // Catch:{ SQLiteException -> 0x0097 }
            com.google.android.gms.internal.zzvk$zzb r2 = new com.google.android.gms.internal.zzvk$zzb     // Catch:{ SQLiteException -> 0x0097 }
            r2.<init>()     // Catch:{ SQLiteException -> 0x0097 }
            com.google.android.gms.internal.zzark r0 = r2.zzb(r0)     // Catch:{ IOException -> 0x0088 }
            com.google.android.gms.internal.zzvk$zzb r0 = (com.google.android.gms.internal.zzvk.zzb) r0     // Catch:{ IOException -> 0x0088 }
            r0 = 0
            int r3 = r1.getInt(r0)     // Catch:{ SQLiteException -> 0x0097 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0097 }
            java.lang.Object r0 = r8.get(r0)     // Catch:{ SQLiteException -> 0x0097 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ SQLiteException -> 0x0097 }
            if (r0 != 0) goto L_0x0078
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0097 }
            r0.<init>()     // Catch:{ SQLiteException -> 0x0097 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0097 }
            r8.put(r3, r0)     // Catch:{ SQLiteException -> 0x0097 }
        L_0x0078:
            r0.add(r2)     // Catch:{ SQLiteException -> 0x0097 }
        L_0x007b:
            boolean r0 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0097 }
            if (r0 != 0) goto L_0x0047
            if (r1 == 0) goto L_0x0086
            r1.close()
        L_0x0086:
            r0 = r8
            goto L_0x0046
        L_0x0088:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzp r2 = r10.zzbvg()     // Catch:{ SQLiteException -> 0x0097 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbwc()     // Catch:{ SQLiteException -> 0x0097 }
            java.lang.String r3 = "Failed to merge filter"
            r2.zze(r3, r11, r0)     // Catch:{ SQLiteException -> 0x0097 }
            goto L_0x007b
        L_0x0097:
            r0 = move-exception
        L_0x0098:
            com.google.android.gms.measurement.internal.zzp r2 = r10.zzbvg()     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbwc()     // Catch:{ all -> 0x00b4 }
            java.lang.String r3 = "Database error querying filters"
            r2.zzj(r3, r0)     // Catch:{ all -> 0x00b4 }
            if (r1 == 0) goto L_0x00aa
            r1.close()
        L_0x00aa:
            r0 = r9
            goto L_0x0046
        L_0x00ac:
            r0 = move-exception
            r1 = r9
        L_0x00ae:
            if (r1 == 0) goto L_0x00b3
            r1.close()
        L_0x00b3:
            throw r0
        L_0x00b4:
            r0 = move-exception
            goto L_0x00ae
        L_0x00b6:
            r0 = move-exception
            r1 = r9
            goto L_0x0098
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzat(java.lang.String, java.lang.String):java.util.Map");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.Integer, java.util.List<com.google.android.gms.internal.zzvk.zze>> zzau(java.lang.String r11, java.lang.String r12) {
        /*
            r10 = this;
            r9 = 0
            r10.zzaax()
            r10.zzyl()
            com.google.android.gms.common.internal.zzac.zzhz(r11)
            com.google.android.gms.common.internal.zzac.zzhz(r12)
            android.support.v4.util.ArrayMap r8 = new android.support.v4.util.ArrayMap
            r8.<init>()
            android.database.sqlite.SQLiteDatabase r0 = r10.getWritableDatabase()
            java.lang.String r1 = "property_filters"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r3 = 0
            java.lang.String r4 = "audience_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r3 = 1
            java.lang.String r4 = "data"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            java.lang.String r3 = "app_id=? AND property_name=?"
            r4 = 2
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r5 = 0
            r4[r5] = r11     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r5 = 1
            r4[r5] = r12     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x00b6, all -> 0x00ac }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0097 }
            if (r0 != 0) goto L_0x0047
            java.util.Map r0 = java.util.Collections.emptyMap()     // Catch:{ SQLiteException -> 0x0097 }
            if (r1 == 0) goto L_0x0046
            r1.close()
        L_0x0046:
            return r0
        L_0x0047:
            r0 = 1
            byte[] r0 = r1.getBlob(r0)     // Catch:{ SQLiteException -> 0x0097 }
            com.google.android.gms.internal.zzarc r0 = com.google.android.gms.internal.zzarc.zzbd(r0)     // Catch:{ SQLiteException -> 0x0097 }
            com.google.android.gms.internal.zzvk$zze r2 = new com.google.android.gms.internal.zzvk$zze     // Catch:{ SQLiteException -> 0x0097 }
            r2.<init>()     // Catch:{ SQLiteException -> 0x0097 }
            com.google.android.gms.internal.zzark r0 = r2.zzb(r0)     // Catch:{ IOException -> 0x0088 }
            com.google.android.gms.internal.zzvk$zze r0 = (com.google.android.gms.internal.zzvk.zze) r0     // Catch:{ IOException -> 0x0088 }
            r0 = 0
            int r3 = r1.getInt(r0)     // Catch:{ SQLiteException -> 0x0097 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0097 }
            java.lang.Object r0 = r8.get(r0)     // Catch:{ SQLiteException -> 0x0097 }
            java.util.List r0 = (java.util.List) r0     // Catch:{ SQLiteException -> 0x0097 }
            if (r0 != 0) goto L_0x0078
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0097 }
            r0.<init>()     // Catch:{ SQLiteException -> 0x0097 }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x0097 }
            r8.put(r3, r0)     // Catch:{ SQLiteException -> 0x0097 }
        L_0x0078:
            r0.add(r2)     // Catch:{ SQLiteException -> 0x0097 }
        L_0x007b:
            boolean r0 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0097 }
            if (r0 != 0) goto L_0x0047
            if (r1 == 0) goto L_0x0086
            r1.close()
        L_0x0086:
            r0 = r8
            goto L_0x0046
        L_0x0088:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzp r2 = r10.zzbvg()     // Catch:{ SQLiteException -> 0x0097 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbwc()     // Catch:{ SQLiteException -> 0x0097 }
            java.lang.String r3 = "Failed to merge filter"
            r2.zze(r3, r11, r0)     // Catch:{ SQLiteException -> 0x0097 }
            goto L_0x007b
        L_0x0097:
            r0 = move-exception
        L_0x0098:
            com.google.android.gms.measurement.internal.zzp r2 = r10.zzbvg()     // Catch:{ all -> 0x00b4 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbwc()     // Catch:{ all -> 0x00b4 }
            java.lang.String r3 = "Database error querying filters"
            r2.zzj(r3, r0)     // Catch:{ all -> 0x00b4 }
            if (r1 == 0) goto L_0x00aa
            r1.close()
        L_0x00aa:
            r0 = r9
            goto L_0x0046
        L_0x00ac:
            r0 = move-exception
            r1 = r9
        L_0x00ae:
            if (r1 == 0) goto L_0x00b3
            r1.close()
        L_0x00b3:
            throw r0
        L_0x00b4:
            r0 = move-exception
            goto L_0x00ae
        L_0x00b6:
            r0 = move-exception
            r1 = r9
            goto L_0x0098
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzau(java.lang.String, java.lang.String):java.util.Map");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public Object zzb(Cursor cursor, int i) {
        int zza2 = zza(cursor, i);
        switch (zza2) {
            case 0:
                zzbvg().zzbwc().log("Loaded invalid null value from database");
                return null;
            case 1:
                return Long.valueOf(cursor.getLong(i));
            case 2:
                return Double.valueOf(cursor.getDouble(i));
            case 3:
                return cursor.getString(i);
            case 4:
                zzbvg().zzbwc().log("Loaded invalid blob type value, ignoring it");
                return null;
            default:
                zzbvg().zzbwc().zzj("Loaded invalid unknown value type, ignoring it", Integer.valueOf(zza2));
                return null;
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzb(String str, zzvk.zza[] zzaArr) {
        zzaax();
        zzyl();
        zzac.zzhz(str);
        zzac.zzy(zzaArr);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            zzmc(str);
            for (zzvk.zza zza2 : zzaArr) {
                zza(str, zza2);
            }
            ArrayList arrayList = new ArrayList();
            for (zzvk.zza zza3 : zzaArr) {
                arrayList.add(zza3.asA);
            }
            zzc(str, arrayList);
            writableDatabase.setTransactionSuccessful();
        } finally {
            writableDatabase.endTransaction();
        }
    }

    @WorkerThread
    public void zzbk(long j) {
        zzyl();
        zzaax();
        if (getWritableDatabase().delete("queue", "rowid=?", new String[]{String.valueOf(j)}) != 1) {
            zzbvg().zzbwc().log("Deleted fewer rows from queue than expected");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0059  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String zzbl(long r8) {
        /*
            r7 = this;
            r0 = 0
            r7.zzyl()
            r7.zzaax()
            android.database.sqlite.SQLiteDatabase r1 = r7.getWritableDatabase()     // Catch:{ SQLiteException -> 0x003f, all -> 0x0054 }
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x003f, all -> 0x0054 }
            r4 = 0
            java.lang.String r5 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x003f, all -> 0x0054 }
            r3[r4] = r5     // Catch:{ SQLiteException -> 0x003f, all -> 0x0054 }
            android.database.Cursor r2 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x003f, all -> 0x0054 }
            boolean r1 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x005f }
            if (r1 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.zzp r1 = r7.zzbvg()     // Catch:{ SQLiteException -> 0x005f }
            com.google.android.gms.measurement.internal.zzp$zza r1 = r1.zzbwj()     // Catch:{ SQLiteException -> 0x005f }
            java.lang.String r3 = "No expired configs for apps with pending events"
            r1.log(r3)     // Catch:{ SQLiteException -> 0x005f }
            if (r2 == 0) goto L_0x0033
            r2.close()
        L_0x0033:
            return r0
        L_0x0034:
            r1 = 0
            java.lang.String r0 = r2.getString(r1)     // Catch:{ SQLiteException -> 0x005f }
            if (r2 == 0) goto L_0x0033
            r2.close()
            goto L_0x0033
        L_0x003f:
            r1 = move-exception
            r2 = r0
        L_0x0041:
            com.google.android.gms.measurement.internal.zzp r3 = r7.zzbvg()     // Catch:{ all -> 0x005d }
            com.google.android.gms.measurement.internal.zzp$zza r3 = r3.zzbwc()     // Catch:{ all -> 0x005d }
            java.lang.String r4 = "Error selecting expired configs"
            r3.zzj(r4, r1)     // Catch:{ all -> 0x005d }
            if (r2 == 0) goto L_0x0033
            r2.close()
            goto L_0x0033
        L_0x0054:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x0057:
            if (r2 == 0) goto L_0x005c
            r2.close()
        L_0x005c:
            throw r0
        L_0x005d:
            r0 = move-exception
            goto L_0x0057
        L_0x005f:
            r1 = move-exception
            goto L_0x0041
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzbl(long):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003d  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String zzbvj() {
        /*
            r5 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r5.getWritableDatabase()
            java.lang.String r2 = "select app_id from queue where app_id not in (select app_id from apps where measurement_enabled=0) order by has_realtime desc, rowid asc limit 1;"
            r3 = 0
            android.database.Cursor r2 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x0023, all -> 0x0038 }
            boolean r1 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x0043 }
            if (r1 == 0) goto L_0x001d
            r1 = 0
            java.lang.String r0 = r2.getString(r1)     // Catch:{ SQLiteException -> 0x0043 }
            if (r2 == 0) goto L_0x001c
            r2.close()
        L_0x001c:
            return r0
        L_0x001d:
            if (r2 == 0) goto L_0x001c
            r2.close()
            goto L_0x001c
        L_0x0023:
            r1 = move-exception
            r2 = r0
        L_0x0025:
            com.google.android.gms.measurement.internal.zzp r3 = r5.zzbvg()     // Catch:{ all -> 0x0041 }
            com.google.android.gms.measurement.internal.zzp$zza r3 = r3.zzbwc()     // Catch:{ all -> 0x0041 }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zzj(r4, r1)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x001c
            r2.close()
            goto L_0x001c
        L_0x0038:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L_0x003b:
            if (r2 == 0) goto L_0x0040
            r2.close()
        L_0x0040:
            throw r0
        L_0x0041:
            r0 = move-exception
            goto L_0x003b
        L_0x0043:
            r1 = move-exception
            goto L_0x0025
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzbvj():java.lang.String");
    }

    public boolean zzbvk() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzbvl() {
        zzyl();
        zzaax();
        if (zzbvr()) {
            long j = zzbvh().apT.get();
            long elapsedRealtime = zzaan().elapsedRealtime();
            if (Math.abs(elapsedRealtime - j) > zzbvi().zzbuf()) {
                zzbvh().apT.set(elapsedRealtime);
                zzbvm();
            }
        }
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzbvm() {
        int delete;
        zzyl();
        zzaax();
        if (zzbvr() && (delete = getWritableDatabase().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzaan().currentTimeMillis()), String.valueOf(zzbvi().zzbue())})) > 0) {
            zzbvg().zzbwj().zzj("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
        }
    }

    @WorkerThread
    public long zzbvn() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    @WorkerThread
    public long zzbvo() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public boolean zzbvp() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public boolean zzbvq() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    /* access modifiers changed from: package-private */
    public boolean zzc(String str, List<Integer> list) {
        zzac.zzhz(str);
        zzaax();
        zzyl();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            long zzb2 = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int zzlt = zzbvi().zzlt(str);
            if (zzb2 <= ((long) zzlt)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    Integer num = list.get(i);
                    if (num == null || !(num instanceof Integer)) {
                        return false;
                    }
                    arrayList.add(Integer.toString(num.intValue()));
                }
            }
            String valueOf = String.valueOf(TextUtils.join(",", arrayList));
            String sb = new StringBuilder(String.valueOf(valueOf).length() + 2).append("(").append(valueOf).append(")").toString();
            return writableDatabase.delete("audience_filter_values", new StringBuilder(String.valueOf(sb).length() + 140).append("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ").append(sb).append(" order by rowid desc limit -1 offset ?)").toString(), new String[]{str, Integer.toString(zzlt)}) > 0;
        } catch (SQLiteException e) {
            zzbvg().zzbwc().zzj("Database error querying filters", e);
            return false;
        }
    }

    @WorkerThread
    public void zzd(String str, byte[] bArr) {
        zzac.zzhz(str);
        zzyl();
        zzaax();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        try {
            if (((long) getWritableDatabase().update("apps", contentValues, "app_id = ?", new String[]{str})) == 0) {
                zzbvg().zzbwc().log("Failed to update remote config (got 0)");
            }
        } catch (SQLiteException e) {
            zzbvg().zzbwc().zzj("Error storing remote config", e);
        }
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public void zzg(String str, long j) {
        zzac.zzhz(str);
        zzyl();
        zzaax();
        if (j <= 0) {
            zzbvg().zzbwc().log("Nonpositive first open count received, ignoring");
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("first_open_count", Long.valueOf(j));
        try {
            if (getWritableDatabase().insertWithOnConflict("app2", (String) null, contentValues, 5) == -1) {
                zzbvg().zzbwc().log("Failed to insert/replace first open count (got -1)");
            }
        } catch (SQLiteException e) {
            zzbvg().zzbwc().zzj("Error inserting/replacing first open count", e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x009e  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.google.android.gms.measurement.internal.zzak> zzly(java.lang.String r12) {
        /*
            r11 = this;
            r10 = 0
            com.google.android.gms.common.internal.zzac.zzhz(r12)
            r11.zzyl()
            r11.zzaax()
            java.util.ArrayList r9 = new java.util.ArrayList
            r9.<init>()
            android.database.sqlite.SQLiteDatabase r0 = r11.getWritableDatabase()     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            java.lang.String r1 = "user_attributes"
            r2 = 3
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            r3 = 0
            java.lang.String r4 = "name"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            r3 = 1
            java.lang.String r4 = "set_timestamp"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            r3 = 2
            java.lang.String r4 = "value"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            r5 = 0
            r4[r5] = r12     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            r5 = 0
            r6 = 0
            java.lang.String r7 = "rowid"
            com.google.android.gms.measurement.internal.zzd r8 = r11.zzbvi()     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            int r8 = r8.zzbty()     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            java.lang.String r8 = java.lang.String.valueOf(r8)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            android.database.Cursor r7 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x00a8, all -> 0x009b }
            boolean r0 = r7.moveToFirst()     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            if (r0 != 0) goto L_0x0050
            if (r7 == 0) goto L_0x004e
            r7.close()
        L_0x004e:
            r0 = r9
        L_0x004f:
            return r0
        L_0x0050:
            r0 = 0
            java.lang.String r3 = r7.getString(r0)     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            r0 = 1
            long r4 = r7.getLong(r0)     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            r0 = 2
            java.lang.Object r6 = r11.zzb((android.database.Cursor) r7, (int) r0)     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            if (r6 != 0) goto L_0x007b
            com.google.android.gms.measurement.internal.zzp r0 = r11.zzbvg()     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            com.google.android.gms.measurement.internal.zzp$zza r0 = r0.zzbwc()     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            java.lang.String r1 = "Read invalid user property value, ignoring it"
            r0.log(r1)     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
        L_0x006e:
            boolean r0 = r7.moveToNext()     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            if (r0 != 0) goto L_0x0050
            if (r7 == 0) goto L_0x0079
            r7.close()
        L_0x0079:
            r0 = r9
            goto L_0x004f
        L_0x007b:
            com.google.android.gms.measurement.internal.zzak r1 = new com.google.android.gms.measurement.internal.zzak     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            r2 = r12
            r1.<init>(r2, r3, r4, r6)     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            r9.add(r1)     // Catch:{ SQLiteException -> 0x0085, all -> 0x00a2 }
            goto L_0x006e
        L_0x0085:
            r0 = move-exception
            r1 = r7
        L_0x0087:
            com.google.android.gms.measurement.internal.zzp r2 = r11.zzbvg()     // Catch:{ all -> 0x00a5 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbwc()     // Catch:{ all -> 0x00a5 }
            java.lang.String r3 = "Error querying user properties"
            r2.zze(r3, r12, r0)     // Catch:{ all -> 0x00a5 }
            if (r1 == 0) goto L_0x0099
            r1.close()
        L_0x0099:
            r0 = r10
            goto L_0x004f
        L_0x009b:
            r0 = move-exception
        L_0x009c:
            if (r10 == 0) goto L_0x00a1
            r10.close()
        L_0x00a1:
            throw r0
        L_0x00a2:
            r0 = move-exception
            r10 = r7
            goto L_0x009c
        L_0x00a5:
            r0 = move-exception
            r10 = r1
            goto L_0x009c
        L_0x00a8:
            r0 = move-exception
            r1 = r10
            goto L_0x0087
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzly(java.lang.String):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x01ba  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.measurement.internal.zza zzlz(java.lang.String r12) {
        /*
            r11 = this;
            r10 = 0
            r9 = 1
            r8 = 0
            com.google.android.gms.common.internal.zzac.zzhz(r12)
            r11.zzyl()
            r11.zzaax()
            android.database.sqlite.SQLiteDatabase r0 = r11.getWritableDatabase()     // Catch:{ SQLiteException -> 0x019f, all -> 0x01b6 }
            java.lang.String r1 = "apps"
            r2 = 21
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x019f, all -> 0x01b6 }
            r3 = 0
            java.lang.String r4 = "app_instance_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x019f, all -> 0x01b6 }
            r3 = 1
            java.lang.String r4 = "gmp_app_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x019f, all -> 0x01b6 }
            r3 = 2
            java.lang.String r4 = "resettable_device_id_hash"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x019f, all -> 0x01b6 }
            r3 = 3
            java.lang.String r4 = "last_bundle_index"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x019f, all -> 0x01b6 }
            r3 = 4
            java.lang.String r4 = "last_bundle_start_timestamp"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x019f, all -> 0x01b6 }
            r3 = 5
            java.lang.String r4 = "last_bundle_end_timestamp"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x019f, all -> 0x01b6 }
            r3 = 6
            java.lang.String r4 = "app_version"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x019f, all -> 0x01b6 }
            r3 = 7
            java.lang.String r4 = "app_store"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x019f, all -> 0x01b6 }
            r3 = 8
            java.lang.String r4 = "gmp_version"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x019f, all -> 0x01b6 }
            r3 = 9
            java.lang.String r4 = "dev_cert_hash"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x019f, all -> 0x01b6 }
            r3 = 10
            java.lang.String r4 = "measurement_enabled"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x019f, all -> 0x01b6 }
            r3 = 11
            java.lang.String r4 = "day"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x019f, all -> 0x01b6 }
            r3 = 12
            java.lang.String r4 = "daily_public_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x019f, all -> 0x01b6 }
            r3 = 13
            java.lang.String r4 = "daily_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x019f, all -> 0x01b6 }
            r3 = 14
            java.lang.String r4 = "daily_conversions_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x019f, all -> 0x01b6 }
            r3 = 15
            java.lang.String r4 = "config_fetched_time"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x019f, all -> 0x01b6 }
            r3 = 16
            java.lang.String r4 = "failed_config_fetch_time"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x019f, all -> 0x01b6 }
            r3 = 17
            java.lang.String r4 = "app_version_int"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x019f, all -> 0x01b6 }
            r3 = 18
            java.lang.String r4 = "firebase_instance_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x019f, all -> 0x01b6 }
            r3 = 19
            java.lang.String r4 = "daily_error_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x019f, all -> 0x01b6 }
            r3 = 20
            java.lang.String r4 = "daily_realtime_events_count"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x019f, all -> 0x01b6 }
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x019f, all -> 0x01b6 }
            r5 = 0
            r4[r5] = r12     // Catch:{ SQLiteException -> 0x019f, all -> 0x01b6 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x019f, all -> 0x01b6 }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x01c0 }
            if (r0 != 0) goto L_0x00a8
            if (r1 == 0) goto L_0x00a6
            r1.close()
        L_0x00a6:
            r0 = r8
        L_0x00a7:
            return r0
        L_0x00a8:
            com.google.android.gms.measurement.internal.zza r0 = new com.google.android.gms.measurement.internal.zza     // Catch:{ SQLiteException -> 0x01c0 }
            com.google.android.gms.measurement.internal.zzx r2 = r11.anq     // Catch:{ SQLiteException -> 0x01c0 }
            r0.<init>(r2, r12)     // Catch:{ SQLiteException -> 0x01c0 }
            r2 = 0
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r0.zzlj(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r2 = 1
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r0.zzlk(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r2 = 2
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r0.zzll(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r2 = 3
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r0.zzbb(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r2 = 4
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r0.zzaw(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r2 = 5
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r0.zzax(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r2 = 6
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r0.setAppVersion(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r2 = 7
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r0.zzln(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r2 = 8
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r0.zzaz(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r2 = 9
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r0.zzba(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r2 = 10
            boolean r2 = r1.isNull(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            if (r2 == 0) goto L_0x018c
            r2 = r9
        L_0x010a:
            if (r2 == 0) goto L_0x0194
            r2 = r9
        L_0x010d:
            r0.setMeasurementEnabled(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r2 = 11
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r0.zzbe(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r2 = 12
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r0.zzbf(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r2 = 13
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r0.zzbg(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r2 = 14
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r0.zzbh(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r2 = 15
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r0.zzbc(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r2 = 16
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r0.zzbd(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r2 = 17
            boolean r2 = r1.isNull(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            if (r2 == 0) goto L_0x0197
            r2 = -2147483648(0xffffffff80000000, double:NaN)
        L_0x0151:
            r0.zzay(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r2 = 18
            java.lang.String r2 = r1.getString(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r0.zzlm(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r2 = 19
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r0.zzbj(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r2 = 20
            long r2 = r1.getLong(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r0.zzbi(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            r0.zzbsq()     // Catch:{ SQLiteException -> 0x01c0 }
            boolean r2 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x01c0 }
            if (r2 == 0) goto L_0x0185
            com.google.android.gms.measurement.internal.zzp r2 = r11.zzbvg()     // Catch:{ SQLiteException -> 0x01c0 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbwc()     // Catch:{ SQLiteException -> 0x01c0 }
            java.lang.String r3 = "Got multiple records for app, expected one"
            r2.log(r3)     // Catch:{ SQLiteException -> 0x01c0 }
        L_0x0185:
            if (r1 == 0) goto L_0x00a7
            r1.close()
            goto L_0x00a7
        L_0x018c:
            r2 = 10
            int r2 = r1.getInt(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            goto L_0x010a
        L_0x0194:
            r2 = r10
            goto L_0x010d
        L_0x0197:
            r2 = 17
            int r2 = r1.getInt(r2)     // Catch:{ SQLiteException -> 0x01c0 }
            long r2 = (long) r2
            goto L_0x0151
        L_0x019f:
            r0 = move-exception
            r1 = r8
        L_0x01a1:
            com.google.android.gms.measurement.internal.zzp r2 = r11.zzbvg()     // Catch:{ all -> 0x01be }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbwc()     // Catch:{ all -> 0x01be }
            java.lang.String r3 = "Error querying app"
            r2.zze(r3, r12, r0)     // Catch:{ all -> 0x01be }
            if (r1 == 0) goto L_0x01b3
            r1.close()
        L_0x01b3:
            r0 = r8
            goto L_0x00a7
        L_0x01b6:
            r0 = move-exception
            r1 = r8
        L_0x01b8:
            if (r1 == 0) goto L_0x01bd
            r1.close()
        L_0x01bd:
            throw r0
        L_0x01be:
            r0 = move-exception
            goto L_0x01b8
        L_0x01c0:
            r0 = move-exception
            goto L_0x01a1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzlz(java.lang.String):com.google.android.gms.measurement.internal.zza");
    }

    public long zzma(String str) {
        zzac.zzhz(str);
        zzyl();
        zzaax();
        try {
            return (long) getWritableDatabase().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(zzbvi().zzlx(str))});
        } catch (SQLiteException e) {
            zzbvg().zzbwc().zzj("Error deleting over the limit events", e);
            return 0;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x006c  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] zzmb(java.lang.String r10) {
        /*
            r9 = this;
            r8 = 0
            com.google.android.gms.common.internal.zzac.zzhz(r10)
            r9.zzyl()
            r9.zzaax()
            android.database.sqlite.SQLiteDatabase r0 = r9.getWritableDatabase()     // Catch:{ SQLiteException -> 0x0052, all -> 0x0068 }
            java.lang.String r1 = "apps"
            r2 = 1
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x0052, all -> 0x0068 }
            r3 = 0
            java.lang.String r4 = "remote_config"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x0052, all -> 0x0068 }
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x0052, all -> 0x0068 }
            r5 = 0
            r4[r5] = r10     // Catch:{ SQLiteException -> 0x0052, all -> 0x0068 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x0052, all -> 0x0068 }
            boolean r0 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0072 }
            if (r0 != 0) goto L_0x0034
            if (r1 == 0) goto L_0x0032
            r1.close()
        L_0x0032:
            r0 = r8
        L_0x0033:
            return r0
        L_0x0034:
            r0 = 0
            byte[] r0 = r1.getBlob(r0)     // Catch:{ SQLiteException -> 0x0072 }
            boolean r2 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x0072 }
            if (r2 == 0) goto L_0x004c
            com.google.android.gms.measurement.internal.zzp r2 = r9.zzbvg()     // Catch:{ SQLiteException -> 0x0072 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbwc()     // Catch:{ SQLiteException -> 0x0072 }
            java.lang.String r3 = "Got multiple records for app config, expected one"
            r2.log(r3)     // Catch:{ SQLiteException -> 0x0072 }
        L_0x004c:
            if (r1 == 0) goto L_0x0033
            r1.close()
            goto L_0x0033
        L_0x0052:
            r0 = move-exception
            r1 = r8
        L_0x0054:
            com.google.android.gms.measurement.internal.zzp r2 = r9.zzbvg()     // Catch:{ all -> 0x0070 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbwc()     // Catch:{ all -> 0x0070 }
            java.lang.String r3 = "Error querying remote config"
            r2.zze(r3, r10, r0)     // Catch:{ all -> 0x0070 }
            if (r1 == 0) goto L_0x0066
            r1.close()
        L_0x0066:
            r0 = r8
            goto L_0x0033
        L_0x0068:
            r0 = move-exception
            r1 = r8
        L_0x006a:
            if (r1 == 0) goto L_0x006f
            r1.close()
        L_0x006f:
            throw r0
        L_0x0070:
            r0 = move-exception
            goto L_0x006a
        L_0x0072:
            r0 = move-exception
            goto L_0x0054
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzmb(java.lang.String):byte[]");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzmc(String str) {
        zzaax();
        zzyl();
        zzac.zzhz(str);
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.delete("property_filters", "app_id=?", new String[]{str});
        writableDatabase.delete("event_filters", "app_id=?", new String[]{str});
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Map<java.lang.Integer, com.google.android.gms.internal.zzvm.zzf> zzmd(java.lang.String r10) {
        /*
            r9 = this;
            r8 = 0
            r9.zzaax()
            r9.zzyl()
            com.google.android.gms.common.internal.zzac.zzhz(r10)
            android.database.sqlite.SQLiteDatabase r0 = r9.getWritableDatabase()
            java.lang.String r1 = "audience_filter_values"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00a1, all -> 0x0094 }
            r3 = 0
            java.lang.String r4 = "audience_id"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00a1, all -> 0x0094 }
            r3 = 1
            java.lang.String r4 = "current_results"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00a1, all -> 0x0094 }
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00a1, all -> 0x0094 }
            r5 = 0
            r4[r5] = r10     // Catch:{ SQLiteException -> 0x00a1, all -> 0x0094 }
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5, r6, r7)     // Catch:{ SQLiteException -> 0x00a1, all -> 0x0094 }
            boolean r0 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            if (r0 != 0) goto L_0x0039
            if (r2 == 0) goto L_0x0037
            r2.close()
        L_0x0037:
            r0 = r8
        L_0x0038:
            return r0
        L_0x0039:
            android.support.v4.util.ArrayMap r1 = new android.support.v4.util.ArrayMap     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            r1.<init>()     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
        L_0x003e:
            r0 = 0
            int r3 = r2.getInt(r0)     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            r0 = 1
            byte[] r0 = r2.getBlob(r0)     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            com.google.android.gms.internal.zzarc r0 = com.google.android.gms.internal.zzarc.zzbd(r0)     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            com.google.android.gms.internal.zzvm$zzf r4 = new com.google.android.gms.internal.zzvm$zzf     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            r4.<init>()     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            com.google.android.gms.internal.zzark r0 = r4.zzb(r0)     // Catch:{ IOException -> 0x006b }
            com.google.android.gms.internal.zzvm$zzf r0 = (com.google.android.gms.internal.zzvm.zzf) r0     // Catch:{ IOException -> 0x006b }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            r1.put(r0, r4)     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
        L_0x005e:
            boolean r0 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            if (r0 != 0) goto L_0x003e
            if (r2 == 0) goto L_0x0069
            r2.close()
        L_0x0069:
            r0 = r1
            goto L_0x0038
        L_0x006b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzp r4 = r9.zzbvg()     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            com.google.android.gms.measurement.internal.zzp$zza r4 = r4.zzbwc()     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            java.lang.String r5 = "Failed to merge filter results. appId, audienceId, error"
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            r4.zzd(r5, r10, r3, r0)     // Catch:{ SQLiteException -> 0x007e, all -> 0x009c }
            goto L_0x005e
        L_0x007e:
            r0 = move-exception
            r1 = r2
        L_0x0080:
            com.google.android.gms.measurement.internal.zzp r2 = r9.zzbvg()     // Catch:{ all -> 0x009e }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbwc()     // Catch:{ all -> 0x009e }
            java.lang.String r3 = "Database error querying filter results"
            r2.zzj(r3, r0)     // Catch:{ all -> 0x009e }
            if (r1 == 0) goto L_0x0092
            r1.close()
        L_0x0092:
            r0 = r8
            goto L_0x0038
        L_0x0094:
            r0 = move-exception
            r2 = r8
        L_0x0096:
            if (r2 == 0) goto L_0x009b
            r2.close()
        L_0x009b:
            throw r0
        L_0x009c:
            r0 = move-exception
            goto L_0x0096
        L_0x009e:
            r0 = move-exception
            r2 = r1
            goto L_0x0096
        L_0x00a1:
            r0 = move-exception
            r1 = r8
            goto L_0x0080
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzmd(java.lang.String):java.util.Map");
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzme(String str) {
        zzaax();
        zzyl();
        zzac.zzhz(str);
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            String[] strArr = {str};
            int delete = writableDatabase.delete("audience_filter_values", "app_id=?", strArr) + writableDatabase.delete("events", "app_id=?", strArr) + 0 + writableDatabase.delete("user_attributes", "app_id=?", strArr) + writableDatabase.delete("apps", "app_id=?", strArr) + writableDatabase.delete("raw_events", "app_id=?", strArr) + writableDatabase.delete("raw_events_metadata", "app_id=?", strArr) + writableDatabase.delete("event_filters", "app_id=?", strArr) + writableDatabase.delete("property_filters", "app_id=?", strArr);
            if (delete > 0) {
                zzbvg().zzbwj().zze("Deleted application data. app, records", str, Integer.valueOf(delete));
            }
        } catch (SQLiteException e) {
            zzbvg().zzbwc().zze("Error deleting application data. appId, error", str, e);
        }
    }

    @WorkerThread
    public long zzmf(String str) {
        zzac.zzhz(str);
        zzyl();
        zzaax();
        SQLiteDatabase writableDatabase = getWritableDatabase();
        writableDatabase.beginTransaction();
        try {
            long zza2 = zza("select first_open_count from app2 where app_id=?", new String[]{str}, 0);
            zzg(str, 1 + zza2);
            writableDatabase.setTransactionSuccessful();
            return zza2;
        } finally {
            writableDatabase.endTransaction();
        }
    }

    public void zzmg(String str) {
        try {
            getWritableDatabase().execSQL("delete from raw_events_metadata where app_id=? and metadata_fingerprint not in (select distinct metadata_fingerprint from raw_events where app_id=?)", new String[]{str, str});
        } catch (SQLiteException e) {
            zzbvg().zzbwc().zzj("Failed to remove unused event metadata", e);
        }
    }

    public long zzmh(String str) {
        zzac.zzhz(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00de  */
    @android.support.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<android.util.Pair<com.google.android.gms.internal.zzvm.zze, java.lang.Long>> zzn(java.lang.String r12, int r13, int r14) {
        /*
            r11 = this;
            r10 = 0
            r1 = 1
            r9 = 0
            r11.zzyl()
            r11.zzaax()
            if (r13 <= 0) goto L_0x004e
            r0 = r1
        L_0x000c:
            com.google.android.gms.common.internal.zzac.zzbs(r0)
            if (r14 <= 0) goto L_0x0050
        L_0x0011:
            com.google.android.gms.common.internal.zzac.zzbs(r1)
            com.google.android.gms.common.internal.zzac.zzhz(r12)
            android.database.sqlite.SQLiteDatabase r0 = r11.getWritableDatabase()     // Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
            java.lang.String r1 = "queue"
            r2 = 2
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
            r3 = 0
            java.lang.String r4 = "rowid"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
            r3 = 1
            java.lang.String r4 = "data"
            r2[r3] = r4     // Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
            java.lang.String r3 = "app_id=?"
            r4 = 1
            java.lang.String[] r4 = new java.lang.String[r4]     // Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
            r5 = 0
            r4[r5] = r12     // Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
            r5 = 0
            r6 = 0
            java.lang.String r7 = "rowid"
            java.lang.String r8 = java.lang.String.valueOf(r13)     // Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
            android.database.Cursor r2 = r0.query(r1, r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x00e7, all -> 0x00da }
            boolean r0 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            if (r0 != 0) goto L_0x0052
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            if (r2 == 0) goto L_0x004d
            r2.close()
        L_0x004d:
            return r0
        L_0x004e:
            r0 = r9
            goto L_0x000c
        L_0x0050:
            r1 = r9
            goto L_0x0011
        L_0x0052:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            r1.<init>()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            r3 = r9
        L_0x0058:
            r0 = 0
            long r4 = r2.getLong(r0)     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            r0 = 1
            byte[] r0 = r2.getBlob(r0)     // Catch:{ IOException -> 0x007b }
            com.google.android.gms.measurement.internal.zzal r6 = r11.zzbvc()     // Catch:{ IOException -> 0x007b }
            byte[] r6 = r6.zzw(r0)     // Catch:{ IOException -> 0x007b }
            boolean r0 = r1.isEmpty()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            if (r0 != 0) goto L_0x0094
            int r0 = r6.length     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            int r0 = r0 + r3
            if (r0 <= r14) goto L_0x0094
        L_0x0074:
            if (r2 == 0) goto L_0x0079
            r2.close()
        L_0x0079:
            r0 = r1
            goto L_0x004d
        L_0x007b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzp r4 = r11.zzbvg()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            com.google.android.gms.measurement.internal.zzp$zza r4 = r4.zzbwc()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            java.lang.String r5 = "Failed to unzip queued bundle"
            r4.zze(r5, r12, r0)     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            r0 = r3
        L_0x008a:
            boolean r3 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            if (r3 == 0) goto L_0x0074
            if (r0 > r14) goto L_0x0074
            r3 = r0
            goto L_0x0058
        L_0x0094:
            com.google.android.gms.internal.zzarc r0 = com.google.android.gms.internal.zzarc.zzbd(r6)     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            com.google.android.gms.internal.zzvm$zze r7 = new com.google.android.gms.internal.zzvm$zze     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            r7.<init>()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            com.google.android.gms.internal.zzark r0 = r7.zzb(r0)     // Catch:{ IOException -> 0x00ca }
            com.google.android.gms.internal.zzvm$zze r0 = (com.google.android.gms.internal.zzvm.zze) r0     // Catch:{ IOException -> 0x00ca }
            int r0 = r6.length     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            int r0 = r0 + r3
            java.lang.Long r3 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            android.util.Pair r3 = android.util.Pair.create(r7, r3)     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            r1.add(r3)     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            goto L_0x008a
        L_0x00b1:
            r0 = move-exception
            r1 = r2
        L_0x00b3:
            com.google.android.gms.measurement.internal.zzp r2 = r11.zzbvg()     // Catch:{ all -> 0x00e4 }
            com.google.android.gms.measurement.internal.zzp$zza r2 = r2.zzbwc()     // Catch:{ all -> 0x00e4 }
            java.lang.String r3 = "Error querying bundles"
            r2.zze(r3, r12, r0)     // Catch:{ all -> 0x00e4 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x00e4 }
            if (r1 == 0) goto L_0x004d
            r1.close()
            goto L_0x004d
        L_0x00ca:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzp r4 = r11.zzbvg()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            com.google.android.gms.measurement.internal.zzp$zza r4 = r4.zzbwc()     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            java.lang.String r5 = "Failed to merge queued bundle"
            r4.zze(r5, r12, r0)     // Catch:{ SQLiteException -> 0x00b1, all -> 0x00e2 }
            r0 = r3
            goto L_0x008a
        L_0x00da:
            r0 = move-exception
            r2 = r10
        L_0x00dc:
            if (r2 == 0) goto L_0x00e1
            r2.close()
        L_0x00e1:
            throw r0
        L_0x00e2:
            r0 = move-exception
            goto L_0x00dc
        L_0x00e4:
            r0 = move-exception
            r2 = r1
            goto L_0x00dc
        L_0x00e7:
            r0 = move-exception
            r1 = r10
            goto L_0x00b3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zze.zzn(java.lang.String, int, int):java.util.List");
    }

    /* access modifiers changed from: protected */
    public void zzym() {
    }

    @WorkerThread
    public void zzz(String str, int i) {
        zzac.zzhz(str);
        zzyl();
        zzaax();
        try {
            getWritableDatabase().execSQL("delete from user_attributes where app_id=? and name in (select name from user_attributes where app_id=? and name like '_ltv_%' order by set_timestamp desc limit ?,10);", new String[]{str, str, String.valueOf(i)});
        } catch (SQLiteException e) {
            zzbvg().zzbwc().zze("Error pruning currencies", str, e);
        }
    }
}
