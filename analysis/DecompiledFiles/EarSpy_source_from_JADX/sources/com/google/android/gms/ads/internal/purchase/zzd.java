package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.SystemClock;
import com.applovin.sdk.AppLovinEventParameters;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzhw;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzkn;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@zziy
public class zzd extends zzhw.zza {
    private Context mContext;
    private String zzati;
    private String zzcbr;
    private ArrayList<String> zzcbs;

    public zzd(String str, ArrayList<String> arrayList, Context context, String str2) {
        this.zzcbr = str;
        this.zzcbs = arrayList;
        this.zzati = str2;
        this.mContext = context;
    }

    public String getProductId() {
        return this.zzcbr;
    }

    public void recordPlayBillingResolution(int i) {
        if (i == 0) {
            zzqq();
        }
        Map<String, String> zzqp = zzqp();
        zzqp.put("google_play_status", String.valueOf(i));
        zzqp.put(AppLovinEventParameters.PRODUCT_IDENTIFIER, this.zzcbr);
        zzqp.put("status", String.valueOf(zzak(i)));
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = this.zzcbs.iterator();
        while (it.hasNext()) {
            linkedList.add(zzu.zzfz().zzc(it.next(), zzqp));
        }
        zzu.zzfz().zza(this.mContext, this.zzati, (List<String>) linkedList);
    }

    public void recordResolution(int i) {
        if (i == 1) {
            zzqq();
        }
        Map<String, String> zzqp = zzqp();
        zzqp.put("status", String.valueOf(i));
        zzqp.put(AppLovinEventParameters.PRODUCT_IDENTIFIER, this.zzcbr);
        LinkedList linkedList = new LinkedList();
        Iterator<String> it = this.zzcbs.iterator();
        while (it.hasNext()) {
            linkedList.add(zzu.zzfz().zzc(it.next(), zzqp));
        }
        zzu.zzfz().zza(this.mContext, this.zzati, (List<String>) linkedList);
    }

    /* access modifiers changed from: protected */
    public int zzak(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        return i == 4 ? 3 : 0;
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> zzqp() {
        String packageName = this.mContext.getPackageName();
        String str = "";
        try {
            str = this.mContext.getPackageManager().getPackageInfo(packageName, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            zzkn.zzd("Error to retrieve app version", e);
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - zzu.zzgd().zztl().zzua();
        HashMap hashMap = new HashMap();
        hashMap.put("sessionid", zzu.zzgd().getSessionId());
        hashMap.put("appid", packageName);
        hashMap.put("osversion", String.valueOf(Build.VERSION.SDK_INT));
        hashMap.put("sdkversion", this.zzati);
        hashMap.put("appversion", str);
        hashMap.put("timestamp", String.valueOf(elapsedRealtime));
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public void zzqq() {
        try {
            this.mContext.getClassLoader().loadClass("com.google.ads.conversiontracking.IAPConversionReporter").getDeclaredMethod("reportWithProductId", new Class[]{Context.class, String.class, String.class, Boolean.TYPE}).invoke((Object) null, new Object[]{this.mContext, this.zzcbr, "", true});
        } catch (ClassNotFoundException e) {
            zzkn.zzdf("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (NoSuchMethodException e2) {
            zzkn.zzdf("Google Conversion Tracking SDK 1.2.0 or above is required to report a conversion.");
        } catch (Exception e3) {
            zzkn.zzd("Fail to report a conversion.", e3);
        }
    }
}
