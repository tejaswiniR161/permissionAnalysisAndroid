package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzgl;
import com.google.android.gms.internal.zzgt;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public class zzgk implements zzgl.zza {
    private final Context mContext;
    /* access modifiers changed from: private */
    public final Object zzakd = new Object();
    private final zzgq zzals;
    private final NativeAdOptionsParcel zzand;
    private final List<String> zzane;
    private final VersionInfoParcel zzanh;
    private AdRequestParcel zzaow;
    private final AdSizeParcel zzapc;
    private final boolean zzatk;
    private final boolean zzazd;
    /* access modifiers changed from: private */
    public final String zzbst;
    private final long zzbsu;
    private final zzgh zzbsv;
    private final zzgg zzbsw;
    /* access modifiers changed from: private */
    public zzgr zzbsx;
    /* access modifiers changed from: private */
    public int zzbsy = -2;
    private zzgt zzbsz;

    public zzgk(Context context, String str, zzgq zzgq, zzgh zzgh, zzgg zzgg, AdRequestParcel adRequestParcel, AdSizeParcel adSizeParcel, VersionInfoParcel versionInfoParcel, boolean z, boolean z2, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) {
        this.mContext = context;
        this.zzals = zzgq;
        this.zzbsw = zzgg;
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            this.zzbst = zznf();
        } else {
            this.zzbst = str;
        }
        this.zzbsv = zzgh;
        this.zzbsu = zzgh.zzbsc != -1 ? zzgh.zzbsc : 10000;
        this.zzaow = adRequestParcel;
        this.zzapc = adSizeParcel;
        this.zzanh = versionInfoParcel;
        this.zzatk = z;
        this.zzazd = z2;
        this.zzand = nativeAdOptionsParcel;
        this.zzane = list;
    }

    private long zza(long j, long j2, long j3, long j4) {
        while (this.zzbsy == -2) {
            zzb(j, j2, j3, j4);
        }
        return zzu.zzgf().elapsedRealtime() - j;
    }

    /* access modifiers changed from: private */
    public void zza(zzgj zzgj) {
        String zzbn = zzbn(this.zzbsw.zzbrt);
        try {
            if (this.zzanh.zzctt < 4100000) {
                if (this.zzapc.zzaxj) {
                    this.zzbsx.zza(zze.zzac(this.mContext), this.zzaow, zzbn, zzgj);
                } else {
                    this.zzbsx.zza(zze.zzac(this.mContext), this.zzapc, this.zzaow, zzbn, (zzgs) zzgj);
                }
            } else if (this.zzatk) {
                this.zzbsx.zza(zze.zzac(this.mContext), this.zzaow, zzbn, this.zzbsw.zzbrl, zzgj, this.zzand, this.zzane);
            } else if (this.zzapc.zzaxj) {
                this.zzbsx.zza(zze.zzac(this.mContext), this.zzaow, zzbn, this.zzbsw.zzbrl, (zzgs) zzgj);
            } else if (!this.zzazd) {
                this.zzbsx.zza(zze.zzac(this.mContext), this.zzapc, this.zzaow, zzbn, this.zzbsw.zzbrl, zzgj);
            } else if (this.zzbsw.zzbrw != null) {
                this.zzbsx.zza(zze.zzac(this.mContext), this.zzaow, zzbn, this.zzbsw.zzbrl, zzgj, new NativeAdOptionsParcel(zzbo(this.zzbsw.zzbsa)), this.zzbsw.zzbrz);
            } else {
                this.zzbsx.zza(zze.zzac(this.mContext), this.zzapc, this.zzaow, zzbn, this.zzbsw.zzbrl, zzgj);
            }
        } catch (RemoteException e) {
            zzkn.zzd("Could not request ad from mediation adapter.", e);
            zzaa(5);
        }
    }

    /* access modifiers changed from: private */
    public boolean zzab(int i) {
        try {
            Bundle zznp = this.zzatk ? this.zzbsx.zznp() : this.zzapc.zzaxj ? this.zzbsx.getInterstitialAdapterInfo() : this.zzbsx.zzno();
            if (zznp == null) {
                return false;
            }
            return (zznp.getInt("capabilities", 0) & i) == i;
        } catch (RemoteException e) {
            zzkn.zzdf("Could not get adapter info. Returning false");
            return false;
        }
    }

    private static zzgt zzac(final int i) {
        return new zzgt.zza() {
            public int zznk() throws RemoteException {
                return i;
            }
        };
    }

    private void zzb(long j, long j2, long j3, long j4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j5 = j2 - (elapsedRealtime - j);
        long j6 = j4 - (elapsedRealtime - j3);
        if (j5 <= 0 || j6 <= 0) {
            zzkn.zzde("Timed out waiting for adapter.");
            this.zzbsy = 3;
            return;
        }
        try {
            this.zzakd.wait(Math.min(j5, j6));
        } catch (InterruptedException e) {
            this.zzbsy = -1;
        }
    }

    private String zzbn(String str) {
        if (str == null || !zzni() || zzab(2)) {
            return str;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            jSONObject.remove("cpm_floor_cents");
            return jSONObject.toString();
        } catch (JSONException e) {
            zzkn.zzdf("Could not remove field. Returning the original value");
            return str;
        }
    }

    private static NativeAdOptions zzbo(String str) {
        NativeAdOptions.Builder builder = new NativeAdOptions.Builder();
        if (str == null) {
            return builder.build();
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            builder.setRequestMultipleImages(jSONObject.optBoolean("multiple_images", false));
            builder.setReturnUrlsForImageAssets(jSONObject.optBoolean("only_urls", false));
            builder.setImageOrientation(zzbp(jSONObject.optString("native_image_orientation", "any")));
        } catch (JSONException e) {
            zzkn.zzd("Exception occurred when creating native ad options", e);
        }
        return builder.build();
    }

    private static int zzbp(String str) {
        if ("landscape".equals(str)) {
            return 2;
        }
        return "portrait".equals(str) ? 1 : 0;
    }

    private String zznf() {
        try {
            return (TextUtils.isEmpty(this.zzbsw.zzbrp) || !this.zzals.zzbr(this.zzbsw.zzbrp)) ? "com.google.ads.mediation.customevent.CustomEventAdapter" : "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter";
        } catch (RemoteException e) {
            zzkn.zzdf("Fail to determine the custom event's version, assuming the old one.");
        }
        return "com.google.ads.mediation.customevent.CustomEventAdapter";
    }

    private zzgt zzng() {
        if (this.zzbsy != 0 || !zzni()) {
            return null;
        }
        try {
            if (!(!zzab(4) || this.zzbsz == null || this.zzbsz.zznk() == 0)) {
                return this.zzbsz;
            }
        } catch (RemoteException e) {
            zzkn.zzdf("Could not get cpm value from MediationResponseMetadata");
        }
        return zzac(zznj());
    }

    /* access modifiers changed from: private */
    public zzgr zznh() {
        String valueOf = String.valueOf(this.zzbst);
        zzkn.zzde(valueOf.length() != 0 ? "Instantiating mediation adapter: ".concat(valueOf) : new String("Instantiating mediation adapter: "));
        if (!this.zzatk) {
            if (zzdi.zzbei.get().booleanValue() && "com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzbst)) {
                return zza((MediationAdapter) new AdMobAdapter());
            }
            if (zzdi.zzbej.get().booleanValue() && "com.google.ads.mediation.AdUrlAdapter".equals(this.zzbst)) {
                return zza((MediationAdapter) new AdUrlAdapter());
            }
            if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(this.zzbst)) {
                return new zzgx(new zzhf());
            }
        }
        try {
            return this.zzals.zzbq(this.zzbst);
        } catch (RemoteException e) {
            RemoteException remoteException = e;
            String valueOf2 = String.valueOf(this.zzbst);
            zzkn.zza(valueOf2.length() != 0 ? "Could not instantiate mediation adapter: ".concat(valueOf2) : new String("Could not instantiate mediation adapter: "), remoteException);
            return null;
        }
    }

    /* access modifiers changed from: private */
    public boolean zzni() {
        return this.zzbsv.zzbsm != -1;
    }

    private int zznj() {
        if (this.zzbsw.zzbrt == null) {
            return 0;
        }
        try {
            JSONObject jSONObject = new JSONObject(this.zzbsw.zzbrt);
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzbst)) {
                return jSONObject.optInt("cpm_cents", 0);
            }
            int optInt = zzab(2) ? jSONObject.optInt("cpm_floor_cents", 0) : 0;
            return optInt == 0 ? jSONObject.optInt("penalized_average_cpm_cents", 0) : optInt;
        } catch (JSONException e) {
            zzkn.zzdf("Could not convert to json. Returning 0");
            return 0;
        }
    }

    public void cancel() {
        synchronized (this.zzakd) {
            try {
                if (this.zzbsx != null) {
                    this.zzbsx.destroy();
                }
            } catch (RemoteException e) {
                zzkn.zzd("Could not destroy mediation adapter.", e);
            }
            this.zzbsy = -1;
            this.zzakd.notify();
        }
    }

    public zzgl zza(long j, long j2) {
        zzgl zzgl;
        synchronized (this.zzakd) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            final zzgj zzgj = new zzgj();
            zzkr.zzcrf.post(new Runnable() {
                public void run() {
                    synchronized (zzgk.this.zzakd) {
                        if (zzgk.this.zzbsy == -2) {
                            zzgr unused = zzgk.this.zzbsx = zzgk.this.zznh();
                            if (zzgk.this.zzbsx == null) {
                                zzgk.this.zzaa(4);
                            } else if (!zzgk.this.zzni() || zzgk.this.zzab(1)) {
                                zzgj.zza((zzgl.zza) zzgk.this);
                                zzgk.this.zza(zzgj);
                            } else {
                                String zzf = zzgk.this.zzbst;
                                zzkn.zzdf(new StringBuilder(String.valueOf(zzf).length() + 56).append("Ignoring adapter ").append(zzf).append(" as delayed impression is not supported").toString());
                                zzgk.this.zzaa(2);
                            }
                        }
                    }
                }
            });
            zzgj zzgj2 = zzgj;
            zzgl = new zzgl(this.zzbsw, this.zzbsx, this.zzbst, zzgj2, this.zzbsy, zzng(), zza(elapsedRealtime, this.zzbsu, j, j2));
        }
        return zzgl;
    }

    /* access modifiers changed from: protected */
    public zzgr zza(MediationAdapter mediationAdapter) {
        return new zzgx(mediationAdapter);
    }

    public void zza(int i, zzgt zzgt) {
        synchronized (this.zzakd) {
            this.zzbsy = i;
            this.zzbsz = zzgt;
            this.zzakd.notify();
        }
    }

    public void zzaa(int i) {
        synchronized (this.zzakd) {
            this.zzbsy = i;
            this.zzakd.notify();
        }
    }
}
