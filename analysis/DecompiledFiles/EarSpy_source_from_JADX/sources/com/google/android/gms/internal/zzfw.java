package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzd;
import com.google.android.gms.internal.zzfv;
import java.util.concurrent.Future;

@zziy
public class zzfw {

    private static class zza<JavascriptEngine> extends zzlg<JavascriptEngine> {
        JavascriptEngine zzbqb;

        private zza() {
        }
    }

    /* access modifiers changed from: private */
    public zzfv zza(Context context, VersionInfoParcel versionInfoParcel, final zza<zzfv> zza2, zzau zzau, zzd zzd) {
        JavascriptEngine zzfx = new zzfx(context, versionInfoParcel, zzau, zzd);
        zza2.zzbqb = zzfx;
        zzfx.zza(new zzfv.zza() {
            public void zzmx() {
                zza2.zzh((zzfv) zza2.zzbqb);
            }
        });
        return zzfx;
    }

    public Future<zzfv> zza(Context context, VersionInfoParcel versionInfoParcel, String str, zzau zzau, zzd zzd) {
        final zza zza2 = new zza();
        final Context context2 = context;
        final VersionInfoParcel versionInfoParcel2 = versionInfoParcel;
        final zzau zzau2 = zzau;
        final zzd zzd2 = zzd;
        final String str2 = str;
        zzkr.zzcrf.post(new Runnable() {
            public void run() {
                zzfw.this.zza(context2, versionInfoParcel2, (zza<zzfv>) zza2, zzau2, zzd2).zzbl(str2);
            }
        });
        return zza2;
    }
}
