package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.zza;
import com.google.android.gms.ads.internal.request.zzc;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzau;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzgh;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkm;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzkq;
import com.google.android.gms.internal.zzkr;
import com.google.android.gms.internal.zzkt;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzln;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public class zzb extends zzkm implements zzc.zza {
    private final Context mContext;
    private final zzau zzbkp;
    zzgh zzbsv;
    private AdRequestInfoParcel zzbtk;
    AdResponseParcel zzccl;
    /* access modifiers changed from: private */
    public Runnable zzccm;
    /* access modifiers changed from: private */
    public final Object zzccn = new Object();
    private final zza.C1258zza zzcfh;
    /* access modifiers changed from: private */
    public final AdRequestInfoParcel.zza zzcfi;
    zzkt zzcfj;

    @zziy
    static final class zza extends Exception {
        private final int zzcdb;

        public zza(String str, int i) {
            super(str);
            this.zzcdb = i;
        }

        public int getErrorCode() {
            return this.zzcdb;
        }
    }

    public zzb(Context context, AdRequestInfoParcel.zza zza2, zzau zzau, zza.C1258zza zza3) {
        this.zzcfh = zza3;
        this.mContext = context;
        this.zzcfi = zza2;
        this.zzbkp = zzau;
    }

    /* access modifiers changed from: private */
    public void zzd(int i, String str) {
        if (i == 3 || i == -1) {
            zzkn.zzde(str);
        } else {
            zzkn.zzdf(str);
        }
        if (this.zzccl == null) {
            this.zzccl = new AdResponseParcel(i);
        } else {
            this.zzccl = new AdResponseParcel(i, this.zzccl.zzbsj);
        }
        this.zzcfh.zza(new zzke.zza(this.zzbtk != null ? this.zzbtk : new AdRequestInfoParcel(this.zzcfi, (String) null, -1), this.zzccl, this.zzbsv, (AdSizeParcel) null, i, -1, this.zzccl.zzchg, (JSONObject) null));
    }

    public void onStop() {
        synchronized (this.zzccn) {
            if (this.zzcfj != null) {
                this.zzcfj.cancel();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public zzkt zza(VersionInfoParcel versionInfoParcel, zzlm<AdRequestInfoParcel> zzlm) {
        return zzc.zza(this.mContext, versionInfoParcel, zzlm, this);
    }

    /* access modifiers changed from: protected */
    public AdSizeParcel zzb(AdRequestInfoParcel adRequestInfoParcel) throws zza {
        if (this.zzccl.zzaxm) {
            for (AdSizeParcel adSizeParcel : adRequestInfoParcel.zzaqz.zzaxk) {
                if (adSizeParcel.zzaxm) {
                    return new AdSizeParcel(adSizeParcel, adRequestInfoParcel.zzaqz.zzaxk);
                }
            }
        }
        if (this.zzccl.zzchf == null) {
            throw new zza("The ad response must specify one of the supported ad sizes.", 0);
        }
        String[] split = this.zzccl.zzchf.split("x");
        if (split.length != 2) {
            String valueOf = String.valueOf(this.zzccl.zzchf);
            throw new zza(valueOf.length() != 0 ? "Invalid ad size format from the ad response: ".concat(valueOf) : new String("Invalid ad size format from the ad response: "), 0);
        }
        try {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            for (AdSizeParcel adSizeParcel2 : adRequestInfoParcel.zzaqz.zzaxk) {
                float f = this.mContext.getResources().getDisplayMetrics().density;
                int i = adSizeParcel2.width == -1 ? (int) (((float) adSizeParcel2.widthPixels) / f) : adSizeParcel2.width;
                int i2 = adSizeParcel2.height == -2 ? (int) (((float) adSizeParcel2.heightPixels) / f) : adSizeParcel2.height;
                if (parseInt == i && parseInt2 == i2 && !adSizeParcel2.zzaxm) {
                    return new AdSizeParcel(adSizeParcel2, adRequestInfoParcel.zzaqz.zzaxk);
                }
            }
            String valueOf2 = String.valueOf(this.zzccl.zzchf);
            throw new zza(valueOf2.length() != 0 ? "The ad size from the ad response was not one of the requested sizes: ".concat(valueOf2) : new String("The ad size from the ad response was not one of the requested sizes: "), 0);
        } catch (NumberFormatException e) {
            String valueOf3 = String.valueOf(this.zzccl.zzchf);
            throw new zza(valueOf3.length() != 0 ? "Invalid ad size number from the ad response: ".concat(valueOf3) : new String("Invalid ad size number from the ad response: "), 0);
        }
    }

    public void zzb(@NonNull AdResponseParcel adResponseParcel) {
        JSONObject jSONObject;
        zzkn.zzdd("Received ad response.");
        this.zzccl = adResponseParcel;
        long elapsedRealtime = zzu.zzgf().elapsedRealtime();
        synchronized (this.zzccn) {
            this.zzcfj = null;
        }
        zzu.zzgd().zzd(this.mContext, this.zzccl.zzcgt);
        try {
            if (this.zzccl.errorCode == -2 || this.zzccl.errorCode == -3) {
                zzru();
                AdSizeParcel zzb = this.zzbtk.zzaqz.zzaxk != null ? zzb(this.zzbtk) : null;
                zzu.zzgd().zzaf(this.zzccl.zzchm);
                if (!TextUtils.isEmpty(this.zzccl.zzchk)) {
                    try {
                        jSONObject = new JSONObject(this.zzccl.zzchk);
                    } catch (Exception e) {
                        zzkn.zzb("Error parsing the JSON for Active View.", e);
                    }
                    this.zzcfh.zza(new zzke.zza(this.zzbtk, this.zzccl, this.zzbsv, zzb, -2, elapsedRealtime, this.zzccl.zzchg, jSONObject));
                    zzkr.zzcrf.removeCallbacks(this.zzccm);
                    return;
                }
                jSONObject = null;
                this.zzcfh.zza(new zzke.zza(this.zzbtk, this.zzccl, this.zzbsv, zzb, -2, elapsedRealtime, this.zzccl.zzchg, jSONObject));
                zzkr.zzcrf.removeCallbacks(this.zzccm);
                return;
            }
            throw new zza(new StringBuilder(66).append("There was a problem getting an ad response. ErrorCode: ").append(this.zzccl.errorCode).toString(), this.zzccl.errorCode);
        } catch (zza e2) {
            zzd(e2.getErrorCode(), e2.getMessage());
            zzkr.zzcrf.removeCallbacks(this.zzccm);
        }
    }

    public void zzfc() {
        zzkn.zzdd("AdLoaderBackgroundTask started.");
        this.zzccm = new Runnable() {
            public void run() {
                synchronized (zzb.this.zzccn) {
                    if (zzb.this.zzcfj != null) {
                        zzb.this.onStop();
                        zzb.this.zzd(2, "Timed out waiting for ad response.");
                    }
                }
            }
        };
        zzkr.zzcrf.postDelayed(this.zzccm, zzdi.zzbek.get().longValue());
        final zzln zzln = new zzln();
        long elapsedRealtime = zzu.zzgf().elapsedRealtime();
        zzkq.zza((Runnable) new Runnable() {
            public void run() {
                synchronized (zzb.this.zzccn) {
                    zzb.this.zzcfj = zzb.this.zza(zzb.this.zzcfi.zzaqv, zzln);
                    if (zzb.this.zzcfj == null) {
                        zzb.this.zzd(0, "Could not start the ad request service.");
                        zzkr.zzcrf.removeCallbacks(zzb.this.zzccm);
                    }
                }
            }
        });
        this.zzbtk = new AdRequestInfoParcel(this.zzcfi, this.zzbkp.zzaw().zzb(this.mContext), elapsedRealtime);
        zzln.zzg(this.zzbtk);
    }

    /* access modifiers changed from: protected */
    public void zzru() throws zza {
        if (this.zzccl.errorCode != -3) {
            if (TextUtils.isEmpty(this.zzccl.body)) {
                throw new zza("No fill from ad server.", 3);
            }
            zzu.zzgd().zzc(this.mContext, this.zzccl.zzcgc);
            if (this.zzccl.zzchc) {
                try {
                    this.zzbsv = new zzgh(this.zzccl.body);
                    zzu.zzgd().zzag(this.zzbsv.zzbsh);
                } catch (JSONException e) {
                    zzkn.zzb("Could not parse mediation config.", e);
                    String valueOf = String.valueOf(this.zzccl.body);
                    throw new zza(valueOf.length() != 0 ? "Could not parse mediation config: ".concat(valueOf) : new String("Could not parse mediation config: "), 0);
                }
            } else {
                zzu.zzgd().zzag(this.zzccl.zzbsh);
            }
            if (!TextUtils.isEmpty(this.zzccl.zzcgu) && zzdi.zzbhh.get().booleanValue()) {
                zzkn.zzdd("Received cookie from server. Setting webview cookie in CookieManager.");
                CookieManager zzao = zzu.zzgb().zzao(this.mContext);
                if (zzao != null) {
                    zzao.setCookie("googleads.g.doubleclick.net", this.zzccl.zzcgu);
                }
            }
        }
    }
}
