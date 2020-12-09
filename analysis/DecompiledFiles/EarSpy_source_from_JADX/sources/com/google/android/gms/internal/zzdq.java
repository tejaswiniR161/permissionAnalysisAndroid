package com.google.android.gms.internal;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzu;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@zziy
public class zzdq {
    private final Object zzakd = new Object();
    boolean zzbhy;
    private final List<zzdo> zzbip = new LinkedList();
    private final Map<String, String> zzbiq = new LinkedHashMap();
    private String zzbir;
    private zzdo zzbis;
    @Nullable
    private zzdq zzbit;

    public zzdq(boolean z, String str, String str2) {
        this.zzbhy = z;
        this.zzbiq.put("action", str);
        this.zzbiq.put("ad_format", str2);
    }

    public boolean zza(zzdo zzdo, long j, String... strArr) {
        synchronized (this.zzakd) {
            for (String zzdo2 : strArr) {
                this.zzbip.add(new zzdo(j, zzdo2, zzdo));
            }
        }
        return true;
    }

    public boolean zza(@Nullable zzdo zzdo, String... strArr) {
        if (!this.zzbhy || zzdo == null) {
            return false;
        }
        return zza(zzdo, zzu.zzgf().elapsedRealtime(), strArr);
    }

    public void zzav(String str) {
        if (this.zzbhy) {
            synchronized (this.zzakd) {
                this.zzbir = str;
            }
        }
    }

    @Nullable
    public zzdo zzc(long j) {
        if (!this.zzbhy) {
            return null;
        }
        return new zzdo(j, (String) null, (zzdo) null);
    }

    public void zzc(@Nullable zzdq zzdq) {
        synchronized (this.zzakd) {
            this.zzbit = zzdq;
        }
    }

    public void zzh(String str, String str2) {
        zzdk zztm;
        if (this.zzbhy && !TextUtils.isEmpty(str2) && (zztm = zzu.zzgd().zztm()) != null) {
            synchronized (this.zzakd) {
                zztm.zzat(str).zza(this.zzbiq, str, str2);
            }
        }
    }

    public zzdo zzla() {
        return zzc(zzu.zzgf().elapsedRealtime());
    }

    public void zzlb() {
        synchronized (this.zzakd) {
            this.zzbis = zzla();
        }
    }

    public String zzlc() {
        String sb;
        StringBuilder sb2 = new StringBuilder();
        synchronized (this.zzakd) {
            for (zzdo next : this.zzbip) {
                long time = next.getTime();
                String zzkx = next.zzkx();
                zzdo zzky = next.zzky();
                if (zzky != null && time > 0) {
                    sb2.append(zzkx).append('.').append(time - zzky.getTime()).append(',');
                }
            }
            this.zzbip.clear();
            if (!TextUtils.isEmpty(this.zzbir)) {
                sb2.append(this.zzbir);
            } else if (sb2.length() > 0) {
                sb2.setLength(sb2.length() - 1);
            }
            sb = sb2.toString();
        }
        return sb;
    }

    public zzdo zzld() {
        zzdo zzdo;
        synchronized (this.zzakd) {
            zzdo = this.zzbis;
        }
        return zzdo;
    }

    /* access modifiers changed from: package-private */
    public Map<String, String> zzm() {
        Map<String, String> zza;
        synchronized (this.zzakd) {
            zzdk zztm = zzu.zzgd().zztm();
            zza = (zztm == null || this.zzbit == null) ? this.zzbiq : zztm.zza(this.zzbiq, this.zzbit.zzm());
        }
        return zza;
    }
}
