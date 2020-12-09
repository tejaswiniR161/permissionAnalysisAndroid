package com.google.android.gms.ads.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzev;
import com.google.android.gms.internal.zzfy;
import com.google.android.gms.internal.zzfz;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzkg;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzkr;
import com.google.android.gms.internal.zzlm;
import com.google.android.gms.internal.zzlt;
import java.util.Map;
import org.json.JSONObject;

@zziy
public class zzg {
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public final Object zzakd = new Object();
    public final zzev zzamn = new zzev() {
        public void zza(zzlt zzlt, Map<String, String> map) {
            zzlt.zzb("/appSettingsFetched", (zzev) this);
            synchronized (zzg.this.zzakd) {
                if (map != null) {
                    if ("true".equalsIgnoreCase(map.get("isSuccessful"))) {
                        zzu.zzgd().zzd(zzg.this.mContext, map.get("appSettingsJson"));
                    }
                }
            }
        }
    };

    private static boolean zza(@Nullable zzkg zzkg) {
        if (zzkg == null) {
            return true;
        }
        return (((zzu.zzgf().currentTimeMillis() - zzkg.zztf()) > zzdi.zzbgs.get().longValue() ? 1 : ((zzu.zzgf().currentTimeMillis() - zzkg.zztf()) == zzdi.zzbgs.get().longValue() ? 0 : -1)) > 0) || !zzkg.zztg();
    }

    public void zza(Context context, VersionInfoParcel versionInfoParcel, boolean z, @Nullable zzkg zzkg, String str, @Nullable String str2) {
        if (zza(zzkg)) {
            if (context == null) {
                zzkn.zzdf("Context not provided to fetch application settings");
            } else if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
                this.mContext = context;
                final zzfy zzc = zzu.zzfz().zzc(context, versionInfoParcel);
                final String str3 = str;
                final String str4 = str2;
                final boolean z2 = z;
                final Context context2 = context;
                zzkr.zzcrf.post(new Runnable() {
                    public void run() {
                        zzc.zzmy().zza(new zzlm.zzc<zzfz>() {
                            /* renamed from: zzb */
                            public void zzd(zzfz zzfz) {
                                zzfz.zza("/appSettingsFetched", zzg.this.zzamn);
                                try {
                                    JSONObject jSONObject = new JSONObject();
                                    if (!TextUtils.isEmpty(str3)) {
                                        jSONObject.put("app_id", str3);
                                    } else if (!TextUtils.isEmpty(str4)) {
                                        jSONObject.put("ad_unit_id", str4);
                                    }
                                    jSONObject.put("is_init", z2);
                                    jSONObject.put("pn", context2.getPackageName());
                                    zzfz.zza("AFMA_fetchAppSettings", jSONObject);
                                } catch (Exception e) {
                                    zzfz.zzb("/appSettingsFetched", zzg.this.zzamn);
                                    zzkn.zzb("Error requesting application settings", e);
                                }
                            }
                        }, new zzlm.zzb());
                    }
                });
            } else {
                zzkn.zzdf("App settings could not be fetched. Required parameters missing");
            }
        }
    }
}
