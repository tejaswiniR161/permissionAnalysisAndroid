package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.firebase.iid.zzg;
import java.io.IOException;
import java.security.KeyPair;
import java.util.HashMap;
import java.util.Map;

public class zzd {
    static Map<String, zzd> afS = new HashMap();
    static String afY;
    private static zzg bhA;
    private static zzf bhB;
    KeyPair afV;
    String afW = "";
    Context mContext;

    protected zzd(Context context, String str, Bundle bundle) {
        this.mContext = context.getApplicationContext();
        this.afW = str;
    }

    public static synchronized zzd zzb(Context context, Bundle bundle) {
        zzd zzd;
        synchronized (zzd.class) {
            String string = bundle == null ? "" : bundle.getString("subtype");
            String str = string == null ? "" : string;
            Context applicationContext = context.getApplicationContext();
            if (bhA == null) {
                bhA = new zzg(applicationContext);
                bhB = new zzf(applicationContext);
            }
            afY = Integer.toString(FirebaseInstanceId.zzdg(applicationContext));
            zzd = afS.get(str);
            if (zzd == null) {
                zzd = new zzd(applicationContext, str, bundle);
                afS.put(str, zzd);
            }
        }
        return zzd;
    }

    /* renamed from: H */
    public zzg mo11758H() {
        return bhA;
    }

    /* renamed from: I */
    public zzf mo11759I() {
        return bhB;
    }

    public long getCreationTime() {
        return bhA.zztw(this.afW);
    }

    public String getToken(String str, String str2, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        if (bundle == null) {
            bundle = new Bundle();
        }
        boolean z = true;
        if (bundle.getString("ttl") != null || "jwt".equals(bundle.getString("type"))) {
            z = false;
        } else {
            zzg.zza zzq = bhA.zzq(this.afW, str, str2);
            if (zzq != null && !zzq.zztz(afY)) {
                return zzq.auj;
            }
        }
        String zzc = zzc(str, str2, bundle);
        if (zzc == null || !z) {
            return zzc;
        }
        bhA.zza(this.afW, str, str2, zzc, afY);
        return zzc;
    }

    public void zzb(String str, String str2, Bundle bundle) throws IOException {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        }
        bhA.zzi(this.afW, str, str2);
        if (bundle == null) {
            bundle = new Bundle();
        }
        bundle.putString("sender", str);
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("subscription", str);
        bundle.putString("delete", "1");
        bundle.putString("X-delete", "1");
        bundle.putString("subtype", "".equals(this.afW) ? str : this.afW);
        if (!"".equals(this.afW)) {
            str = this.afW;
        }
        bundle.putString("X-subtype", str);
        bhB.zzt(bhB.zza(bundle, zzbop()));
    }

    /* access modifiers changed from: package-private */
    public KeyPair zzbop() {
        if (this.afV == null) {
            this.afV = bhA.zzks(this.afW);
        }
        if (this.afV == null) {
            this.afV = bhA.zztx(this.afW);
        }
        return this.afV;
    }

    public void zzboq() {
        bhA.zzkt(this.afW);
        this.afV = null;
    }

    public String zzc(String str, String str2, Bundle bundle) throws IOException {
        if (str2 != null) {
            bundle.putString("scope", str2);
        }
        bundle.putString("sender", str);
        String str3 = "".equals(this.afW) ? str : this.afW;
        if (!bundle.containsKey("legacy.register")) {
            bundle.putString("subscription", str);
            bundle.putString("subtype", str3);
            bundle.putString("X-subscription", str);
            bundle.putString("X-subtype", str3);
        }
        return bhB.zzt(bhB.zza(bundle, zzbop()));
    }
}
