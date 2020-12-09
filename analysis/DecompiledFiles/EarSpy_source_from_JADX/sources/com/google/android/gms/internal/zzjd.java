package com.google.android.gms.internal;

import com.google.android.gms.internal.zzfy;
import java.util.Map;
import java.util.concurrent.Future;

@zziy
public final class zzjd {
    /* access modifiers changed from: private */
    public final Object zzakd = new Object();
    /* access modifiers changed from: private */
    public String zzcaj;
    /* access modifiers changed from: private */
    public String zzcjz;
    /* access modifiers changed from: private */
    public zzlg<zzjg> zzcka = new zzlg<>();
    zzfy.zzc zzckb;
    public final zzev zzckc = new zzev() {
        public void zza(zzlt zzlt, Map<String, String> map) {
            synchronized (zzjd.this.zzakd) {
                if (!zzjd.this.zzcka.isDone()) {
                    if (zzjd.this.zzcaj.equals(map.get("request_id"))) {
                        zzjg zzjg = new zzjg(1, map);
                        String valueOf = String.valueOf(zzjg.getType());
                        String valueOf2 = String.valueOf(zzjg.zzsg());
                        zzkn.zzdf(new StringBuilder(String.valueOf(valueOf).length() + 24 + String.valueOf(valueOf2).length()).append("Invalid ").append(valueOf).append(" request error: ").append(valueOf2).toString());
                        zzjd.this.zzcka.zzh(zzjg);
                    }
                }
            }
        }
    };
    public final zzev zzckd = new zzev() {
        public void zza(zzlt zzlt, Map<String, String> map) {
            synchronized (zzjd.this.zzakd) {
                if (!zzjd.this.zzcka.isDone()) {
                    zzjg zzjg = new zzjg(-2, map);
                    if (zzjd.this.zzcaj.equals(zzjg.getRequestId())) {
                        String url = zzjg.getUrl();
                        if (url == null) {
                            zzkn.zzdf("URL missing in loadAdUrl GMSG.");
                            return;
                        }
                        if (url.contains("%40mediation_adapters%40")) {
                            String replaceAll = url.replaceAll("%40mediation_adapters%40", zzkl.zza(zzlt.getContext(), map.get("check_adapters"), zzjd.this.zzcjz));
                            zzjg.setUrl(replaceAll);
                            String valueOf = String.valueOf(replaceAll);
                            zzkn.m1493v(valueOf.length() != 0 ? "Ad request URL modified to ".concat(valueOf) : new String("Ad request URL modified to "));
                        }
                        zzjd.this.zzcka.zzh(zzjg);
                    }
                }
            }
        }
    };
    public final zzev zzcke = new zzev() {
        public void zza(zzlt zzlt, Map<String, String> map) {
            synchronized (zzjd.this.zzakd) {
                if (!zzjd.this.zzcka.isDone()) {
                    zzjg zzjg = new zzjg(-2, map);
                    if (zzjd.this.zzcaj.equals(zzjg.getRequestId())) {
                        zzjg.zzsj();
                        zzjd.this.zzcka.zzh(zzjg);
                    }
                }
            }
        }
    };

    public zzjd(String str, String str2) {
        this.zzcjz = str2;
        this.zzcaj = str;
    }

    public void zzb(zzfy.zzc zzc) {
        this.zzckb = zzc;
    }

    public zzfy.zzc zzsd() {
        return this.zzckb;
    }

    public Future<zzjg> zzse() {
        return this.zzcka;
    }

    public void zzsf() {
    }
}
