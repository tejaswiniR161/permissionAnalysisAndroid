package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.support.p000v4.util.ArrayMap;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.zzg;
import java.io.IOException;
import java.security.KeyPair;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public class FirebaseInstanceId {
    private static Map<String, FirebaseInstanceId> afS = new ArrayMap();
    private static zze bho;
    private final FirebaseApp bhp;
    private final zzd bhq;
    private final String bhr = mo11730B();

    private FirebaseInstanceId(FirebaseApp firebaseApp, zzd zzd) {
        this.bhp = firebaseApp;
        this.bhq = zzd;
        if (this.bhr == null) {
            throw new IllegalStateException("IID failing to initialize, FirebaseApp is missing project ID");
        }
        FirebaseInstanceIdService.zza(this.bhp.getApplicationContext(), this);
    }

    public static FirebaseInstanceId getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    @Keep
    public static synchronized FirebaseInstanceId getInstance(@NonNull FirebaseApp firebaseApp) {
        FirebaseInstanceId firebaseInstanceId;
        synchronized (FirebaseInstanceId.class) {
            firebaseInstanceId = afS.get(firebaseApp.getOptions().getApplicationId());
            if (firebaseInstanceId == null) {
                zzd zzb = zzd.zzb(firebaseApp.getApplicationContext(), (Bundle) null);
                if (bho == null) {
                    bho = new zze(zzb.mo11758H());
                }
                firebaseInstanceId = new FirebaseInstanceId(firebaseApp, zzb);
                afS.put(firebaseApp.getOptions().getApplicationId(), firebaseInstanceId);
            }
        }
        return firebaseInstanceId;
    }

    static String zza(KeyPair keyPair) {
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(keyPair.getPublic().getEncoded());
            digest[0] = (byte) (((digest[0] & 15) + 112) & 255);
            return Base64.encodeToString(digest, 0, 8, 11);
        } catch (NoSuchAlgorithmException e) {
            Log.w("FirebaseInstanceId", "Unexpected error, device missing required alghorithms");
            return null;
        }
    }

    static void zza(Context context, zzg zzg) {
        zzg.zzbow();
        Intent intent = new Intent();
        intent.putExtra("CMD", "RST");
        context.sendBroadcast(FirebaseInstanceIdInternalReceiver.zzg(context, intent));
    }

    static int zzdg(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf).toString());
            return 0;
        }
    }

    static String zzdh(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            String valueOf = String.valueOf(e);
            Log.w("FirebaseInstanceId", new StringBuilder(String.valueOf(valueOf).length() + 38).append("Never happens: can't find own package ").append(valueOf).toString());
            return null;
        }
    }

    static void zzdi(Context context) {
        Intent intent = new Intent();
        intent.setPackage(context.getPackageName());
        intent.putExtra("CMD", "SYNC");
        context.sendBroadcast(FirebaseInstanceIdInternalReceiver.zzg(context, intent));
    }

    static String zzes(Context context) {
        return getInstance().bhp.getOptions().getApplicationId();
    }

    static String zzu(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: B */
    public String mo11730B() {
        String gcmSenderId = this.bhp.getOptions().getGcmSenderId();
        if (gcmSenderId != null) {
            return gcmSenderId;
        }
        String applicationId = this.bhp.getOptions().getApplicationId();
        if (!applicationId.startsWith("1:")) {
            return applicationId;
        }
        String[] split = applicationId.split(":");
        if (split.length < 2) {
            return null;
        }
        String str = split[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    /* renamed from: C */
    public zzg.zza mo11731C() {
        return this.bhq.mo11758H().zzq("", this.bhr, "*");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: D */
    public String mo11732D() throws IOException {
        return getToken(this.bhr, "*");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: E */
    public zze mo11733E() {
        return bho;
    }

    public void deleteInstanceId() throws IOException {
        this.bhq.zzb("*", "*", (Bundle) null);
        this.bhq.zzboq();
    }

    @WorkerThread
    public void deleteToken(String str, String str2) throws IOException {
        this.bhq.zzb(str, str2, (Bundle) null);
    }

    public long getCreationTime() {
        return this.bhq.getCreationTime();
    }

    public String getId() {
        return zza(this.bhq.zzbop());
    }

    @Nullable
    public String getToken() {
        zzg.zza C = mo11731C();
        if (C == null || C.zztz(zzd.afY)) {
            FirebaseInstanceIdService.zzet(this.bhp.getApplicationContext());
        }
        if (C != null) {
            return C.auj;
        }
        return null;
    }

    @WorkerThread
    public String getToken(String str, String str2) throws IOException {
        return this.bhq.getToken(str, str2, (Bundle) null);
    }

    public void zztr(String str) {
        bho.zztr(str);
        FirebaseInstanceIdService.zzet(this.bhp.getApplicationContext());
    }

    /* access modifiers changed from: package-private */
    public void zzts(String str) throws IOException {
        if (getToken() == null) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString("gcm.topic", valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        zzd zzd = this.bhq;
        String token = getToken();
        String valueOf3 = String.valueOf("/topics/");
        String valueOf4 = String.valueOf(str);
        zzd.getToken(token, valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), bundle);
    }

    /* access modifiers changed from: package-private */
    public void zztt(String str) throws IOException {
        if (getToken() == null) {
            throw new IOException("token not available");
        }
        Bundle bundle = new Bundle();
        String valueOf = String.valueOf("/topics/");
        String valueOf2 = String.valueOf(str);
        bundle.putString("gcm.topic", valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf));
        zzd zzd = this.bhq;
        String token = getToken();
        String valueOf3 = String.valueOf("/topics/");
        String valueOf4 = String.valueOf(str);
        zzd.zzb(token, valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), bundle);
    }
}
