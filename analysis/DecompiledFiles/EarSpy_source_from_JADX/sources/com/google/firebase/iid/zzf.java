package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.ads.AdError;
import com.google.android.gms.iid.MessengerCompat;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class zzf {
    static String agj = null;
    static int agk = 0;
    static int agl = 0;
    static int agm = 0;
    PendingIntent aeT;
    Messenger aeX;
    Map<String, Object> agn = new HashMap();
    Messenger ago;
    MessengerCompat agp;
    long agq;
    long agr;
    int ags;
    int agt;
    long agu;
    Context zzahn;

    public zzf(Context context) {
        this.zzahn = context;
    }

    static String zza(KeyPair keyPair, String... strArr) {
        try {
            byte[] bytes = TextUtils.join("\n", strArr).getBytes("UTF-8");
            try {
                PrivateKey privateKey = keyPair.getPrivate();
                Signature instance = Signature.getInstance(privateKey instanceof RSAPrivateKey ? "SHA256withRSA" : "SHA256withECDSA");
                instance.initSign(privateKey);
                instance.update(bytes);
                return FirebaseInstanceId.zzu(instance.sign());
            } catch (GeneralSecurityException e) {
                Log.e("InstanceID/Rpc", "Unable to sign registration request", e);
                return null;
            }
        } catch (UnsupportedEncodingException e2) {
            Log.e("InstanceID/Rpc", "Unable to encode string", e2);
            return null;
        }
    }

    private void zzai(Object obj) {
        synchronized (getClass()) {
            for (String next : this.agn.keySet()) {
                Object obj2 = this.agn.get(next);
                this.agn.put(next, obj);
                zzh(obj2, obj);
            }
        }
    }

    private Intent zzb(Bundle bundle, KeyPair keyPair) throws IOException {
        Intent intent;
        ConditionVariable conditionVariable = new ConditionVariable();
        String zzbov = zzbov();
        synchronized (getClass()) {
            this.agn.put(zzbov, conditionVariable);
        }
        zza(bundle, keyPair, zzbov);
        conditionVariable.block(30000);
        synchronized (getClass()) {
            Object remove = this.agn.remove(zzbov);
            if (remove instanceof Intent) {
                intent = (Intent) remove;
            } else if (remove instanceof String) {
                throw new IOException((String) remove);
            } else {
                String valueOf = String.valueOf(remove);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 12).append("No response ").append(valueOf).toString());
                throw new IOException("TIMEOUT");
            }
        }
        return intent;
    }

    public static synchronized String zzbov() {
        String num;
        synchronized (zzf.class) {
            int i = agm;
            agm = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    public static String zzdj(Context context) {
        if (agj != null) {
            return agj;
        }
        agk = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        for (ResolveInfo next : packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0)) {
            if (packageManager.checkPermission("com.google.android.c2dm.permission.RECEIVE", next.serviceInfo.packageName) == 0) {
                try {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(next.serviceInfo.packageName, 0);
                    Log.w("InstanceID/Rpc", new StringBuilder(17).append("Found ").append(applicationInfo.uid).toString());
                    agl = applicationInfo.uid;
                    agj = next.serviceInfo.packageName;
                    return agj;
                } catch (PackageManager.NameNotFoundException e) {
                }
            } else {
                String valueOf = String.valueOf(next.serviceInfo.packageName);
                String valueOf2 = String.valueOf("com.google.android.c2dm.intent.REGISTER");
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 56 + String.valueOf(valueOf2).length()).append("Possible malicious package ").append(valueOf).append(" declares ").append(valueOf2).append(" without permission").toString());
            }
        }
        Log.w("InstanceID/Rpc", "Failed to resolve REGISTER intent, falling back");
        try {
            ApplicationInfo applicationInfo2 = packageManager.getApplicationInfo("com.google.android.gms", 0);
            agj = applicationInfo2.packageName;
            agl = applicationInfo2.uid;
            return agj;
        } catch (PackageManager.NameNotFoundException e2) {
            try {
                ApplicationInfo applicationInfo3 = packageManager.getApplicationInfo("com.google.android.gsf", 0);
                agj = applicationInfo3.packageName;
                agl = applicationInfo3.uid;
                return agj;
            } catch (PackageManager.NameNotFoundException e3) {
                Log.w("InstanceID/Rpc", "Both Google Play Services and legacy GSF package are missing");
                return null;
            }
        }
    }

    private static int zzdk(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(zzdj(context), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return -1;
        }
    }

    private void zzh(Object obj, Object obj2) {
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message obtain = Message.obtain();
            obtain.obj = obj2;
            try {
                messenger.send(obtain);
            } catch (RemoteException e) {
                String valueOf = String.valueOf(e);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 24).append("Failed to send response ").append(valueOf).toString());
            }
        }
    }

    private void zzi(String str, Object obj) {
        synchronized (getClass()) {
            Object obj2 = this.agn.get(str);
            this.agn.put(str, obj);
            zzh(obj2, obj);
        }
    }

    private void zzkp(String str) {
        if ("com.google.android.gsf".equals(agj)) {
            this.ags++;
            if (this.ags >= 3) {
                if (this.ags == 3) {
                    this.agt = new Random().nextInt(AdError.NETWORK_ERROR_CODE) + AdError.NETWORK_ERROR_CODE;
                }
                this.agt *= 2;
                this.agu = SystemClock.elapsedRealtime() + ((long) this.agt);
                Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(str).length() + 31).append("Backoff due to ").append(str).append(" for ").append(this.agt).toString());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Intent zza(Bundle bundle, KeyPair keyPair) throws IOException {
        Intent zzb = zzb(bundle, keyPair);
        return (zzb == null || !zzb.hasExtra("google.messenger")) ? zzb : zzb(bundle, keyPair);
    }

    public void zza(Bundle bundle, KeyPair keyPair, String str) throws IOException {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.agu == 0 || elapsedRealtime > this.agu) {
            zzbou();
            if (agj == null) {
                throw new IOException("MISSING_INSTANCEID_SERVICE");
            }
            this.agq = SystemClock.elapsedRealtime();
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(agj);
            bundle.putString("gmsv", Integer.toString(zzdk(this.zzahn)));
            bundle.putString("osv", Integer.toString(Build.VERSION.SDK_INT));
            bundle.putString("app_ver", Integer.toString(FirebaseInstanceId.zzdg(this.zzahn)));
            bundle.putString("app_ver_name", FirebaseInstanceId.zzdh(this.zzahn));
            bundle.putString("cliv", "fiid-9683000");
            bundle.putString("appid", FirebaseInstanceId.zza(keyPair));
            String zzes = FirebaseInstanceId.zzes(this.zzahn);
            if (zzes != null) {
                bundle.putString("gmp_app_id", zzes);
            }
            String zzu = FirebaseInstanceId.zzu(keyPair.getPublic().getEncoded());
            bundle.putString("pub2", zzu);
            bundle.putString("sig", zza(keyPair, this.zzahn.getPackageName(), zzu));
            intent.putExtras(bundle);
            zzs(intent);
            zzb(intent, str);
            return;
        }
        long j = this.agu - elapsedRealtime;
        Log.w("InstanceID/Rpc", new StringBuilder(78).append("Backoff mode, next request attempt: ").append(j).append(" interval: ").append(this.agt).toString());
        throw new IOException("RETRY_LATER");
    }

    /* access modifiers changed from: protected */
    public void zzb(Intent intent, String str) {
        this.agq = SystemClock.elapsedRealtime();
        intent.putExtra("kid", new StringBuilder(String.valueOf(str).length() + 5).append("|ID|").append(str).append("|").toString());
        intent.putExtra("X-kid", new StringBuilder(String.valueOf(str).length() + 5).append("|ID|").append(str).append("|").toString());
        boolean equals = "com.google.android.gsf".equals(agj);
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.d("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 8).append("Sending ").append(valueOf).toString());
        }
        if (equals) {
            this.zzahn.startService(intent);
            return;
        }
        intent.putExtra("google.messenger", this.aeX);
        if (!(this.ago == null && this.agp == null)) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            try {
                if (this.ago != null) {
                    this.ago.send(obtain);
                    return;
                } else {
                    this.agp.send(obtain);
                    return;
                }
            } catch (RemoteException e) {
                if (Log.isLoggable("InstanceID/Rpc", 3)) {
                    Log.d("InstanceID/Rpc", "Messenger failed, fallback to startService");
                }
            }
        }
        this.zzahn.startService(intent);
    }

    /* access modifiers changed from: package-private */
    public void zzbou() {
        if (this.aeX == null) {
            zzdj(this.zzahn);
            this.aeX = new Messenger(new Handler(Looper.getMainLooper()) {
                public void handleMessage(Message message) {
                    zzf.this.zze(message);
                }
            });
        }
    }

    public void zze(Message message) {
        if (message != null) {
            if (message.obj instanceof Intent) {
                Intent intent = (Intent) message.obj;
                intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
                if (intent.hasExtra("google.messenger")) {
                    Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
                    if (parcelableExtra instanceof MessengerCompat) {
                        this.agp = (MessengerCompat) parcelableExtra;
                    }
                    if (parcelableExtra instanceof Messenger) {
                        this.ago = (Messenger) parcelableExtra;
                    }
                }
                zzv((Intent) message.obj);
                return;
            }
            Log.w("InstanceID/Rpc", "Dropping invalid message");
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void zzs(Intent intent) {
        if (this.aeT == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.aeT = PendingIntent.getBroadcast(this.zzahn, 0, intent2, 0);
        }
        intent.putExtra("app", this.aeT);
    }

    /* access modifiers changed from: package-private */
    public String zzt(Intent intent) throws IOException {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("unregistered");
        }
        if (stringExtra != null) {
            return stringExtra;
        }
        String stringExtra2 = intent.getStringExtra("error");
        if (stringExtra2 != null) {
            throw new IOException(stringExtra2);
        }
        String valueOf = String.valueOf(intent.getExtras());
        Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 29).append("Unexpected response from GCM ").append(valueOf).toString(), new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    /* access modifiers changed from: package-private */
    public void zzu(Intent intent) {
        String str;
        String str2;
        String stringExtra = intent.getStringExtra("error");
        if (stringExtra == null) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.w("InstanceID/Rpc", new StringBuilder(String.valueOf(valueOf).length() + 49).append("Unexpected response, no error or registration id ").append(valueOf).toString());
            return;
        }
        if (Log.isLoggable("InstanceID/Rpc", 3)) {
            String valueOf2 = String.valueOf(stringExtra);
            Log.d("InstanceID/Rpc", valueOf2.length() != 0 ? "Received InstanceID error ".concat(valueOf2) : new String("Received InstanceID error "));
        }
        if (stringExtra.startsWith("|")) {
            String[] split = stringExtra.split("\\|");
            if (!"ID".equals(split[1])) {
                String valueOf3 = String.valueOf(stringExtra);
                Log.w("InstanceID/Rpc", valueOf3.length() != 0 ? "Unexpected structured response ".concat(valueOf3) : new String("Unexpected structured response "));
            }
            if (split.length > 2) {
                str = split[2];
                str2 = split[3];
                if (str2.startsWith(":")) {
                    str2 = str2.substring(1);
                }
            } else {
                str2 = "UNKNOWN";
                str = null;
            }
            intent.putExtra("error", str2);
        } else {
            str = null;
            str2 = stringExtra;
        }
        if (str == null) {
            zzai(str2);
        } else {
            zzi(str, str2);
        }
        long longExtra = intent.getLongExtra("Retry-After", 0);
        if (longExtra > 0) {
            this.agr = SystemClock.elapsedRealtime();
            this.agt = ((int) longExtra) * AdError.NETWORK_ERROR_CODE;
            this.agu = SystemClock.elapsedRealtime() + ((long) this.agt);
            Log.w("InstanceID/Rpc", new StringBuilder(52).append("Explicit request from server to backoff: ").append(this.agt).toString());
        } else if ("SERVICE_NOT_AVAILABLE".equals(str2) || "AUTHENTICATION_FAILED".equals(str2)) {
            zzkp(str2);
        }
    }

    /* access modifiers changed from: package-private */
    public void zzv(Intent intent) {
        String str;
        if (intent == null) {
            if (Log.isLoggable("InstanceID/Rpc", 3)) {
                Log.d("InstanceID/Rpc", "Unexpected response: null");
            }
        } else if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("registration_id");
            if (stringExtra == null) {
                stringExtra = intent.getStringExtra("unregistered");
            }
            if (stringExtra == null) {
                zzu(intent);
                return;
            }
            this.agq = SystemClock.elapsedRealtime();
            this.agu = 0;
            this.ags = 0;
            this.agt = 0;
            if (Log.isLoggable("InstanceID/Rpc", 3)) {
                String valueOf = String.valueOf(intent.getExtras());
                Log.d("InstanceID/Rpc", new StringBuilder(String.valueOf(stringExtra).length() + 16 + String.valueOf(valueOf).length()).append("AppIDResponse: ").append(stringExtra).append(" ").append(valueOf).toString());
            }
            if (stringExtra.startsWith("|")) {
                String[] split = stringExtra.split("\\|");
                if (!"ID".equals(split[1])) {
                    String valueOf2 = String.valueOf(stringExtra);
                    Log.w("InstanceID/Rpc", valueOf2.length() != 0 ? "Unexpected structured response ".concat(valueOf2) : new String("Unexpected structured response "));
                }
                String str2 = split[2];
                if (split.length > 4) {
                    if ("SYNC".equals(split[3])) {
                        FirebaseInstanceId.zzdi(this.zzahn);
                    } else if ("RST".equals(split[3])) {
                        FirebaseInstanceId.zza(this.zzahn, zzd.zzb(this.zzahn, (Bundle) null).mo11758H());
                        intent.removeExtra("registration_id");
                        zzi(str2, intent);
                        return;
                    }
                }
                String str3 = split[split.length - 1];
                if (str3.startsWith(":")) {
                    str3 = str3.substring(1);
                }
                intent.putExtra("registration_id", str3);
                str = str2;
            } else {
                str = null;
            }
            if (str == null) {
                zzai(intent);
            } else {
                zzi(str, intent);
            }
        } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
            String valueOf3 = String.valueOf(intent.getAction());
            Log.d("InstanceID/Rpc", valueOf3.length() != 0 ? "Unexpected response ".concat(valueOf3) : new String("Unexpected response "));
        }
    }
}
