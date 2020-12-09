package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.formats.zzi;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzcj;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

@zziy
public class zzcm implements zzcn {
    private final Object zzakd = new Object();
    private final VersionInfoParcel zzanh;
    private final Context zzask;
    private final WeakHashMap<zzke, zzcj> zzatl = new WeakHashMap<>();
    private final ArrayList<zzcj> zzatm = new ArrayList<>();
    private final zzfy zzatn;

    public zzcm(Context context, VersionInfoParcel versionInfoParcel, zzfy zzfy) {
        this.zzask = context.getApplicationContext();
        this.zzanh = versionInfoParcel;
        this.zzatn = zzfy;
    }

    public zzcj zza(AdSizeParcel adSizeParcel, zzke zzke) {
        return zza(adSizeParcel, zzke, zzke.zzbyh.getView());
    }

    public zzcj zza(AdSizeParcel adSizeParcel, zzke zzke, View view) {
        return zza(adSizeParcel, zzke, (zzcq) new zzcj.zzd(view, zzke), (zzfz) null);
    }

    public zzcj zza(AdSizeParcel adSizeParcel, zzke zzke, View view, zzfz zzfz) {
        return zza(adSizeParcel, zzke, (zzcq) new zzcj.zzd(view, zzke), zzfz);
    }

    public zzcj zza(AdSizeParcel adSizeParcel, zzke zzke, zzi zzi) {
        return zza(adSizeParcel, zzke, (zzcq) new zzcj.zza(zzi), (zzfz) null);
    }

    public zzcj zza(AdSizeParcel adSizeParcel, zzke zzke, zzcq zzcq, @Nullable zzfz zzfz) {
        zzcj zzcp;
        synchronized (this.zzakd) {
            if (zzi(zzke)) {
                zzcp = this.zzatl.get(zzke);
            } else {
                if (zzfz != null) {
                    zzcp = new zzco(this.zzask, adSizeParcel, zzke, this.zzanh, zzcq, zzfz);
                } else {
                    zzcp = new zzcp(this.zzask, adSizeParcel, zzke, this.zzanh, zzcq, this.zzatn);
                }
                zzcp.zza((zzcn) this);
                this.zzatl.put(zzke, zzcp);
                this.zzatm.add(zzcp);
            }
        }
        return zzcp;
    }

    public void zza(zzcj zzcj) {
        synchronized (this.zzakd) {
            if (!zzcj.zzhn()) {
                this.zzatm.remove(zzcj);
                Iterator<Map.Entry<zzke, zzcj>> it = this.zzatl.entrySet().iterator();
                while (it.hasNext()) {
                    if (it.next().getValue() == zzcj) {
                        it.remove();
                    }
                }
            }
        }
    }

    public boolean zzi(zzke zzke) {
        boolean z;
        synchronized (this.zzakd) {
            zzcj zzcj = this.zzatl.get(zzke);
            z = zzcj != null && zzcj.zzhn();
        }
        return z;
    }

    public void zzj(zzke zzke) {
        synchronized (this.zzakd) {
            zzcj zzcj = this.zzatl.get(zzke);
            if (zzcj != null) {
                zzcj.zzhl();
            }
        }
    }

    public void zzk(zzke zzke) {
        synchronized (this.zzakd) {
            zzcj zzcj = this.zzatl.get(zzke);
            if (zzcj != null) {
                zzcj.stop();
            }
        }
    }

    public void zzl(zzke zzke) {
        synchronized (this.zzakd) {
            zzcj zzcj = this.zzatl.get(zzke);
            if (zzcj != null) {
                zzcj.pause();
            }
        }
    }

    public void zzm(zzke zzke) {
        synchronized (this.zzakd) {
            zzcj zzcj = this.zzatl.get(zzke);
            if (zzcj != null) {
                zzcj.resume();
            }
        }
    }
}
