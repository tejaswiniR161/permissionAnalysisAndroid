package com.google.android.gms.ads.internal.overlay;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.TextureView;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdm;
import com.google.android.gms.internal.zzdo;
import com.google.android.gms.internal.zzdq;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzkx;
import java.util.concurrent.TimeUnit;

@zziy
public class zzx {
    private final Context mContext;
    private final VersionInfoParcel zzaop;
    private final String zzcaj;
    @Nullable
    private final zzdo zzcak;
    @Nullable
    private final zzdq zzcal;
    private final zzkx zzcam = new zzkx.zzb().zza("min_1", Double.MIN_VALUE, 1.0d).zza("1_5", 1.0d, 5.0d).zza("5_10", 5.0d, 10.0d).zza("10_20", 10.0d, 20.0d).zza("20_30", 20.0d, 30.0d).zza("30_max", 30.0d, Double.MAX_VALUE).zzuw();
    private final long[] zzcan;
    private final String[] zzcao;
    private boolean zzcap = false;
    private boolean zzcaq = false;
    private boolean zzcar = false;
    private boolean zzcas = false;
    private boolean zzcat;
    private zzi zzcau;
    private boolean zzcav;
    private boolean zzcaw;
    private long zzcax = -1;

    public zzx(Context context, VersionInfoParcel versionInfoParcel, String str, @Nullable zzdq zzdq, @Nullable zzdo zzdo) {
        this.mContext = context;
        this.zzaop = versionInfoParcel;
        this.zzcaj = str;
        this.zzcal = zzdq;
        this.zzcak = zzdo;
        String str2 = zzdi.zzbbm.get();
        if (str2 == null) {
            this.zzcao = new String[0];
            this.zzcan = new long[0];
            return;
        }
        String[] split = TextUtils.split(str2, ",");
        this.zzcao = new String[split.length];
        this.zzcan = new long[split.length];
        for (int i = 0; i < split.length; i++) {
            try {
                this.zzcan[i] = Long.parseLong(split[i]);
            } catch (NumberFormatException e) {
                zzkn.zzd("Unable to parse frame hash target time number.", e);
                this.zzcan[i] = -1;
            }
        }
    }

    private void zzc(zzi zzi) {
        long longValue = zzdi.zzbbn.get().longValue();
        long currentPosition = (long) zzi.getCurrentPosition();
        for (int i = 0; i < this.zzcao.length; i++) {
            if (this.zzcao[i] == null && longValue > Math.abs(currentPosition - this.zzcan[i])) {
                this.zzcao[i] = zza((TextureView) zzi);
                return;
            }
        }
    }

    private void zzqe() {
        if (this.zzcar && !this.zzcas) {
            zzdm.zza(this.zzcal, this.zzcak, "vff2");
            this.zzcas = true;
        }
        long nanoTime = zzu.zzgf().nanoTime();
        if (this.zzcat && this.zzcaw && this.zzcax != -1) {
            this.zzcam.zza(((double) TimeUnit.SECONDS.toNanos(1)) / ((double) (nanoTime - this.zzcax)));
        }
        this.zzcaw = this.zzcat;
        this.zzcax = nanoTime;
    }

    public void onStop() {
        if (zzdi.zzbbl.get().booleanValue() && !this.zzcav) {
            Bundle bundle = new Bundle();
            bundle.putString("type", "native-player-metrics");
            bundle.putString("request", this.zzcaj);
            bundle.putString("player", this.zzcau.zzog());
            for (zzkx.zza next : this.zzcam.getBuckets()) {
                String valueOf = String.valueOf("fps_c_");
                String valueOf2 = String.valueOf(next.name);
                bundle.putString(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf), Integer.toString(next.count));
                String valueOf3 = String.valueOf("fps_p_");
                String valueOf4 = String.valueOf(next.name);
                bundle.putString(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3), Double.toString(next.zzcsg));
            }
            for (int i = 0; i < this.zzcan.length; i++) {
                String str = this.zzcao[i];
                if (str != null) {
                    String valueOf5 = String.valueOf("fh_");
                    String valueOf6 = String.valueOf(Long.valueOf(this.zzcan[i]));
                    bundle.putString(new StringBuilder(String.valueOf(valueOf5).length() + 0 + String.valueOf(valueOf6).length()).append(valueOf5).append(valueOf6).toString(), str);
                }
            }
            zzu.zzfz().zza(this.mContext, this.zzaop.zzcs, "gmob-apps", bundle, true);
            this.zzcav = true;
        }
    }

    /* access modifiers changed from: package-private */
    @TargetApi(14)
    public String zza(TextureView textureView) {
        long j;
        Bitmap bitmap = textureView.getBitmap(8, 8);
        long j2 = 0;
        long j3 = 63;
        int i = 0;
        while (i < 8) {
            int i2 = 0;
            long j4 = j2;
            while (true) {
                j = j3;
                int i3 = i2;
                if (i3 >= 8) {
                    break;
                }
                int pixel = bitmap.getPixel(i3, i);
                j4 |= (Color.green(pixel) + (Color.blue(pixel) + Color.red(pixel)) > 128 ? 1 : 0) << ((int) j);
                i2 = i3 + 1;
                j3 = j - 1;
            }
            i++;
            j3 = j;
            j2 = j4;
        }
        return String.format("%016X", new Object[]{Long.valueOf(j2)});
    }

    public void zza(zzi zzi) {
        zzdm.zza(this.zzcal, this.zzcak, "vpc2");
        this.zzcap = true;
        if (this.zzcal != null) {
            this.zzcal.zzh("vpn", zzi.zzog());
        }
        this.zzcau = zzi;
    }

    public void zzb(zzi zzi) {
        zzqe();
        zzc(zzi);
    }

    public void zzpj() {
        if (this.zzcap && !this.zzcaq) {
            zzdm.zza(this.zzcal, this.zzcak, "vfr2");
            this.zzcaq = true;
        }
    }

    public void zzqf() {
        this.zzcat = true;
        if (this.zzcaq && !this.zzcar) {
            zzdm.zza(this.zzcal, this.zzcak, "vfp2");
            this.zzcar = true;
        }
    }

    public void zzqg() {
        this.zzcat = false;
    }
}
