package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.overlay.zzg;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.safebrowsing.zzc;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzfv;
import com.google.android.gms.internal.zzlu;
import org.json.JSONObject;

@zziy
public class zzfx implements zzfv {
    /* access modifiers changed from: private */
    public final zzlt zzbkr;

    public zzfx(Context context, VersionInfoParcel versionInfoParcel, @Nullable zzau zzau, zzd zzd) {
        this.zzbkr = zzu.zzga().zza(context, new AdSizeParcel(), false, false, zzau, versionInfoParcel, (zzdq) null, (zzs) null, zzd);
        this.zzbkr.getWebView().setWillNotDraw(true);
    }

    private void runOnUiThread(Runnable runnable) {
        if (zzm.zzjr().zzvf()) {
            runnable.run();
        } else {
            zzkr.zzcrf.post(runnable);
        }
    }

    public void destroy() {
        this.zzbkr.destroy();
    }

    public void zza(zza zza, zzg zzg, zzer zzer, zzp zzp, boolean z, zzex zzex, zzez zzez, zze zze, zzhn zzhn) {
        this.zzbkr.zzvr().zza(zza, zzg, zzer, zzp, z, zzex, zzez, new zze(this.zzbkr.getContext(), false), zzhn, (zzc) null);
    }

    public void zza(final zzfv.zza zza) {
        this.zzbkr.zzvr().zza((zzlu.zza) new zzlu.zza() {
            public void zza(zzlt zzlt, boolean z) {
                zza.zzmx();
            }
        });
    }

    public void zza(String str, zzev zzev) {
        this.zzbkr.zzvr().zza(str, zzev);
    }

    public void zza(final String str, final JSONObject jSONObject) {
        runOnUiThread(new Runnable() {
            public void run() {
                zzfx.this.zzbkr.zza(str, jSONObject);
            }
        });
    }

    public void zzb(String str, zzev zzev) {
        this.zzbkr.zzvr().zzb(str, zzev);
    }

    public void zzb(String str, JSONObject jSONObject) {
        this.zzbkr.zzb(str, jSONObject);
    }

    public void zzbk(String str) {
        final String format = String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[]{str});
        runOnUiThread(new Runnable() {
            public void run() {
                zzfx.this.zzbkr.loadData(format, "text/html", "UTF-8");
            }
        });
    }

    public void zzbl(final String str) {
        runOnUiThread(new Runnable() {
            public void run() {
                zzfx.this.zzbkr.loadUrl(str);
            }
        });
    }

    public void zzbm(final String str) {
        runOnUiThread(new Runnable() {
            public void run() {
                zzfx.this.zzbkr.loadData(str, "text/html", "UTF-8");
            }
        });
    }

    public void zzj(final String str, final String str2) {
        runOnUiThread(new Runnable() {
            public void run() {
                zzfx.this.zzbkr.zzj(str, str2);
            }
        });
    }

    public zzga zzmw() {
        return new zzgb(this);
    }
}
