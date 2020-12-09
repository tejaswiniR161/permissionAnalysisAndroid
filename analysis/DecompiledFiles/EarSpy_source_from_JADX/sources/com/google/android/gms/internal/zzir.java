package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.zze;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.zzfy;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzlm;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@zziy
public class zzir {
    private static final Object zzaok = new Object();
    private static final long zzcdo = TimeUnit.SECONDS.toMillis(60);
    private static boolean zzcdp = false;
    private static zzfy zzcdq = null;
    private final Context mContext;
    /* access modifiers changed from: private */
    public final zzq zzbkj;
    private final zzau zzbkp;
    private final zzke.zza zzcck;
    private zzfw zzcdr;
    private zzfy.zze zzcds;
    private zzfv zzcdt;
    private boolean zzcdu = false;

    public static abstract class zza {
        public abstract void zze(zzfz zzfz);

        public void zzro() {
        }
    }

    public zzir(Context context, zzke.zza zza2, zzq zzq, zzau zzau) {
        this.mContext = context;
        this.zzcck = zza2;
        this.zzbkj = zzq;
        this.zzbkp = zzau;
        this.zzcdu = zzdi.zzbfx.get().booleanValue();
    }

    public static String zza(zzke.zza zza2, String str) {
        String valueOf = String.valueOf(zza2.zzcop.zzbyj.indexOf("https") == 0 ? "https:" : "http:");
        String valueOf2 = String.valueOf(str);
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    private void zzrg() {
        synchronized (zzaok) {
            if (!zzcdp) {
                zzcdq = new zzfy(this.mContext.getApplicationContext() != null ? this.mContext.getApplicationContext() : this.mContext, this.zzcck.zzcix.zzaqv, zza(this.zzcck, zzdi.zzbfv.get()), new zzkw<zzfv>() {
                    /* renamed from: zza */
                    public void zzd(zzfv zzfv) {
                        zzfv.zza(zzir.this.zzbkj, zzir.this.zzbkj, zzir.this.zzbkj, zzir.this.zzbkj, false, (zzex) null, (zzez) null, (zze) null, (zzhn) null);
                    }
                }, new zzfy.zzb());
                zzcdp = true;
            }
        }
    }

    private void zzrh() {
        this.zzcds = new zzfy.zze(zzrm().zzc(this.zzbkp));
    }

    private void zzri() {
        this.zzcdr = new zzfw();
    }

    private void zzrj() throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
        this.zzcdt = zzrk().zza(this.mContext, this.zzcck.zzcix.zzaqv, zza(this.zzcck, zzdi.zzbfv.get()), this.zzbkp, this.zzbkj.zzdp()).get(zzcdo, TimeUnit.MILLISECONDS);
        this.zzcdt.zza(this.zzbkj, this.zzbkj, this.zzbkj, this.zzbkj, false, (zzex) null, (zzez) null, (zze) null, (zzhn) null);
    }

    public void zza(final zza zza2) {
        if (this.zzcdu) {
            zzfy.zze zzrn = zzrn();
            if (zzrn == null) {
                zzkn.zzdf("SharedJavascriptEngine not initialized");
            } else {
                zzrn.zza(new zzlm.zzc<zzfz>() {
                    /* renamed from: zzb */
                    public void zzd(zzfz zzfz) {
                        zza2.zze(zzfz);
                    }
                }, new zzlm.zza() {
                    public void run() {
                        zza2.zzro();
                    }
                });
            }
        } else {
            zzfv zzrl = zzrl();
            if (zzrl == null) {
                zzkn.zzdf("JavascriptEngine not initialized");
            } else {
                zza2.zze(zzrl);
            }
        }
    }

    public void zzre() {
        if (this.zzcdu) {
            zzrg();
        } else {
            zzri();
        }
    }

    public void zzrf() throws CancellationException, ExecutionException, InterruptedException, TimeoutException {
        if (this.zzcdu) {
            zzrh();
        } else {
            zzrj();
        }
    }

    /* access modifiers changed from: protected */
    public zzfw zzrk() {
        return this.zzcdr;
    }

    /* access modifiers changed from: protected */
    public zzfv zzrl() {
        return this.zzcdt;
    }

    /* access modifiers changed from: protected */
    public zzfy zzrm() {
        return zzcdq;
    }

    /* access modifiers changed from: protected */
    public zzfy.zze zzrn() {
        return this.zzcds;
    }
}
