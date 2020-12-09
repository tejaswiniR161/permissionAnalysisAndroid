package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.zza;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzew;
import com.google.android.gms.internal.zzfa;
import com.google.android.gms.internal.zzfv;
import com.google.android.gms.internal.zzfy;
import com.google.android.gms.internal.zzfz;
import com.google.android.gms.internal.zzgh;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzjc;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkm;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzkw;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzlt;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public class zzn extends zzkm {
    private static final Object zzaok = new Object();
    /* access modifiers changed from: private */
    public static zzfy zzcdq = null;
    static final long zzcik = TimeUnit.SECONDS.toMillis(10);
    static boolean zzcil = false;
    private static zzew zzcim = null;
    /* access modifiers changed from: private */
    public static zzfa zzcin = null;
    private static zzev zzcio = null;
    private final Context mContext;
    private final Object zzccn = new Object();
    /* access modifiers changed from: private */
    public final zza.C1258zza zzcfh;
    private final AdRequestInfoParcel.zza zzcfi;
    /* access modifiers changed from: private */
    public zzfy.zzc zzcip;

    public static class zza implements zzkw<zzfv> {
        /* renamed from: zza */
        public void zzd(zzfv zzfv) {
            zzn.zzc(zzfv);
        }
    }

    public static class zzb implements zzkw<zzfv> {
        /* renamed from: zza */
        public void zzd(zzfv zzfv) {
            zzn.zzb(zzfv);
        }
    }

    public static class zzc implements zzev {
        public void zza(zzlt zzlt, Map<String, String> map) {
            String str = map.get("request_id");
            String valueOf = String.valueOf(map.get("errors"));
            zzkn.zzdf(valueOf.length() != 0 ? "Invalid request: ".concat(valueOf) : new String("Invalid request: "));
            zzn.zzcin.zzba(str);
        }
    }

    public zzn(Context context, AdRequestInfoParcel.zza zza2, zza.C1258zza zza3) {
        super(true);
        this.zzcfh = zza3;
        this.mContext = context;
        this.zzcfi = zza2;
        synchronized (zzaok) {
            if (!zzcil) {
                zzcin = new zzfa();
                zzcim = new zzew(context.getApplicationContext(), zza2.zzaqv);
                zzcio = new zzc();
                zzcdq = new zzfy(this.mContext.getApplicationContext(), this.zzcfi.zzaqv, zzdi.zzbao.get(), new zzb(), new zza());
                zzcil = true;
            }
        }
    }

    private JSONObject zza(AdRequestInfoParcel adRequestInfoParcel, String str) {
        JSONObject zza2;
        AdvertisingIdClient.Info info;
        Bundle bundle = adRequestInfoParcel.zzcfu.extras.getBundle("sdk_less_server_data");
        if (bundle == null || (zza2 = zzjc.zza(this.mContext, new zziz().zzf(adRequestInfoParcel).zza(zzu.zzgi().zzy(this.mContext)))) == null) {
            return null;
        }
        try {
            info = AdvertisingIdClient.getAdvertisingIdInfo(this.mContext);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e) {
            zzkn.zzd("Cannot get advertising id info", e);
            info = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("request_id", str);
        hashMap.put("request_param", zza2);
        hashMap.put("data", bundle);
        if (info != null) {
            hashMap.put("adid", info.getId());
            hashMap.put("lat", Integer.valueOf(info.isLimitAdTrackingEnabled() ? 1 : 0));
        }
        try {
            return zzu.zzfz().zzan((Map<String, ?>) hashMap);
        } catch (JSONException e2) {
            return null;
        }
    }

    protected static void zzb(zzfv zzfv) {
        zzfv.zza("/loadAd", (zzev) zzcin);
        zzfv.zza("/fetchHttpRequest", (zzev) zzcim);
        zzfv.zza("/invalidRequest", zzcio);
    }

    protected static void zzc(zzfv zzfv) {
        zzfv.zzb("/loadAd", (zzev) zzcin);
        zzfv.zzb("/fetchHttpRequest", (zzev) zzcim);
        zzfv.zzb("/invalidRequest", zzcio);
    }

    private AdResponseParcel zze(AdRequestInfoParcel adRequestInfoParcel) {
        final String zzuh = zzu.zzfz().zzuh();
        final JSONObject zza2 = zza(adRequestInfoParcel, zzuh);
        if (zza2 == null) {
            return new AdResponseParcel(0);
        }
        long elapsedRealtime = zzu.zzgf().elapsedRealtime();
        Future<JSONObject> zzaz = zzcin.zzaz(zzuh);
        com.google.android.gms.ads.internal.util.client.zza.zzctj.post(new Runnable() {
            public void run() {
                zzfy.zzc unused = zzn.this.zzcip = zzn.zzcdq.zzmy();
                zzn.this.zzcip.zza(new zzlm.zzc<zzfz>() {
                    /* renamed from: zzb */
                    public void zzd(zzfz zzfz) {
                        try {
                            zzfz.zza("AFMA_getAdapterLessMediationAd", zza2);
                        } catch (Exception e) {
                            zzkn.zzb("Error requesting an ad url", e);
                            zzn.zzcin.zzba(zzuh);
                        }
                    }
                }, new zzlm.zza() {
                    public void run() {
                        zzn.zzcin.zzba(zzuh);
                    }
                });
            }
        });
        try {
            JSONObject jSONObject = zzaz.get(zzcik - (zzu.zzgf().elapsedRealtime() - elapsedRealtime), TimeUnit.MILLISECONDS);
            if (jSONObject == null) {
                return new AdResponseParcel(-1);
            }
            AdResponseParcel zza3 = zzjc.zza(this.mContext, adRequestInfoParcel, jSONObject.toString());
            return (zza3.errorCode == -3 || !TextUtils.isEmpty(zza3.body)) ? zza3 : new AdResponseParcel(3);
        } catch (InterruptedException | CancellationException e) {
            return new AdResponseParcel(-1);
        } catch (TimeoutException e2) {
            return new AdResponseParcel(2);
        } catch (ExecutionException e3) {
            return new AdResponseParcel(0);
        }
    }

    public void onStop() {
        synchronized (this.zzccn) {
            com.google.android.gms.ads.internal.util.client.zza.zzctj.post(new Runnable() {
                public void run() {
                    if (zzn.this.zzcip != null) {
                        zzn.this.zzcip.release();
                        zzfy.zzc unused = zzn.this.zzcip = null;
                    }
                }
            });
        }
    }

    public void zzfc() {
        zzkn.zzdd("SdkLessAdLoaderBackgroundTask started.");
        AdRequestInfoParcel adRequestInfoParcel = new AdRequestInfoParcel(this.zzcfi, (String) null, -1);
        AdResponseParcel zze = zze(adRequestInfoParcel);
        final zzke.zza zza2 = new zzke.zza(adRequestInfoParcel, zze, (zzgh) null, (AdSizeParcel) null, zze.errorCode, zzu.zzgf().elapsedRealtime(), zze.zzchg, (JSONObject) null);
        com.google.android.gms.ads.internal.util.client.zza.zzctj.post(new Runnable() {
            public void run() {
                zzn.this.zzcfh.zza(zza2);
                if (zzn.this.zzcip != null) {
                    zzn.this.zzcip.release();
                    zzfy.zzc unused = zzn.this.zzcip = null;
                }
            }
        });
    }
}
