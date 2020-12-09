package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzfy;
import com.google.android.gms.internal.zzlm;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public class zzcp extends zzcj {
    private zzfy.zzc zzatp;
    /* access modifiers changed from: private */
    public boolean zzatq;

    public zzcp(Context context, AdSizeParcel adSizeParcel, zzke zzke, VersionInfoParcel versionInfoParcel, zzcq zzcq, zzfy zzfy) {
        super(context, adSizeParcel, zzke, versionInfoParcel, zzcq);
        this.zzatp = zzfy.zzmy();
        try {
            final JSONObject zzd = zzd(zzcq.zzhw().zzhu());
            this.zzatp.zza(new zzlm.zzc<zzfz>() {
                /* renamed from: zzb */
                public void zzd(zzfz zzfz) {
                    zzcp.this.zza(zzd);
                }
            }, new zzlm.zza() {
                public void run() {
                }
            });
        } catch (JSONException e) {
        } catch (RuntimeException e2) {
            zzkn.zzb("Failure while processing active view data.", e2);
        }
        this.zzatp.zza(new zzlm.zzc<zzfz>() {
            /* renamed from: zzb */
            public void zzd(zzfz zzfz) {
                boolean unused = zzcp.this.zzatq = true;
                zzcp.this.zzc(zzfz);
                zzcp.this.zzhj();
                zzcp.this.zzk(3);
            }
        }, new zzlm.zza() {
            public void run() {
                zzcp.this.destroy();
            }
        });
        String valueOf = String.valueOf(this.zzasj.zzia());
        zzkn.zzdd(valueOf.length() != 0 ? "Tracking ad unit: ".concat(valueOf) : new String("Tracking ad unit: "));
    }

    /* access modifiers changed from: protected */
    public void destroy() {
        synchronized (this.zzakd) {
            super.destroy();
            this.zzatp.zza(new zzlm.zzc<zzfz>() {
                /* renamed from: zzb */
                public void zzd(zzfz zzfz) {
                    zzcp.this.zzd(zzfz);
                }
            }, new zzlm.zzb());
            this.zzatp.release();
        }
    }

    /* access modifiers changed from: protected */
    public void zzb(final JSONObject jSONObject) {
        this.zzatp.zza(new zzlm.zzc<zzfz>() {
            /* renamed from: zzb */
            public void zzd(zzfz zzfz) {
                zzfz.zza("AFMA_updateActiveView", jSONObject);
            }
        }, new zzlm.zzb());
    }

    /* access modifiers changed from: protected */
    public boolean zzhr() {
        return this.zzatq;
    }
}
