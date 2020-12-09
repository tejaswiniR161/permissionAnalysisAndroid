package com.google.android.gms.internal;

import android.content.Context;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.ads.internal.zzs;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzlu;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;

@zziy
public class zzit {
    private final Context mContext;
    private final Object zzakd = new Object();
    private final zzdq zzalg;
    private int zzary = -1;
    private int zzarz = -1;
    private zzlc zzasa;
    /* access modifiers changed from: private */
    public final zzq zzbkj;
    private final zzau zzbkp;
    /* access modifiers changed from: private */
    public final zzke.zza zzcck;
    private ViewTreeObserver.OnGlobalLayoutListener zzcew;
    private ViewTreeObserver.OnScrollChangedListener zzcex;

    public zzit(Context context, zzau zzau, zzke.zza zza, zzdq zzdq, zzq zzq) {
        this.mContext = context;
        this.zzbkp = zzau;
        this.zzcck = zza;
        this.zzalg = zzdq;
        this.zzbkj = zzq;
        this.zzasa = new zzlc(200);
    }

    /* access modifiers changed from: private */
    public ViewTreeObserver.OnGlobalLayoutListener zza(final WeakReference<zzlt> weakReference) {
        if (this.zzcew == null) {
            this.zzcew = new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    zzit.this.zza((WeakReference<zzlt>) weakReference, false);
                }
            };
        }
        return this.zzcew;
    }

    /* access modifiers changed from: private */
    public void zza(WeakReference<zzlt> weakReference, boolean z) {
        zzlt zzlt;
        if (weakReference != null && (zzlt = (zzlt) weakReference.get()) != null && zzlt.getView() != null) {
            if (!z || this.zzasa.tryAcquire()) {
                int[] iArr = new int[2];
                zzlt.getView().getLocationOnScreen(iArr);
                int zzc = zzm.zzjr().zzc(this.mContext, iArr[0]);
                int zzc2 = zzm.zzjr().zzc(this.mContext, iArr[1]);
                synchronized (this.zzakd) {
                    if (!(this.zzary == zzc && this.zzarz == zzc2)) {
                        this.zzary = zzc;
                        this.zzarz = zzc2;
                        zzlt.zzvr().zza(this.zzary, this.zzarz, !z);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public ViewTreeObserver.OnScrollChangedListener zzb(final WeakReference<zzlt> weakReference) {
        if (this.zzcex == null) {
            this.zzcex = new ViewTreeObserver.OnScrollChangedListener() {
                public void onScrollChanged() {
                    zzit.this.zza((WeakReference<zzlt>) weakReference, true);
                }
            };
        }
        return this.zzcex;
    }

    /* access modifiers changed from: private */
    public void zzj(zzlt zzlt) {
        zzlu zzvr = zzlt.zzvr();
        zzvr.zza("/video", zzeu.zzbmo);
        zzvr.zza("/videoMeta", zzeu.zzbmp);
        zzvr.zza("/precache", zzeu.zzbmq);
        zzvr.zza("/delayPageLoaded", zzeu.zzbmt);
        zzvr.zza("/instrument", zzeu.zzbmr);
        zzvr.zza("/log", zzeu.zzbmj);
        zzvr.zza("/videoClicked", zzeu.zzbmk);
        zzvr.zza("/trackActiveViewUnit", (zzev) new zzev() {
            public void zza(zzlt zzlt, Map<String, String> map) {
                zzit.this.zzbkj.zzfh();
            }
        });
    }

    public zzlj<zzlt> zzh(final JSONObject jSONObject) {
        final zzlg zzlg = new zzlg();
        zzu.zzfz().runOnUiThread(new Runnable() {
            public void run() {
                try {
                    final zzlt zzrt = zzit.this.zzrt();
                    zzit.this.zzbkj.zzc(zzrt);
                    WeakReference weakReference = new WeakReference(zzrt);
                    zzrt.zzvr().zza(zzit.this.zza((WeakReference<zzlt>) weakReference), zzit.this.zzb((WeakReference<zzlt>) weakReference));
                    zzit.this.zzj(zzrt);
                    zzrt.zzvr().zza((zzlu.zzb) new zzlu.zzb() {
                        public void zzk(zzlt zzlt) {
                            zzrt.zza("google.afma.nativeAds.renderVideo", jSONObject);
                        }
                    });
                    zzrt.zzvr().zza((zzlu.zza) new zzlu.zza() {
                        public void zza(zzlt zzlt, boolean z) {
                            zzit.this.zzbkj.zzfk();
                            zzlg.zzh(zzlt);
                        }
                    });
                    zzrt.loadUrl(zzir.zza(zzit.this.zzcck, zzdi.zzbfw.get()));
                } catch (Exception e) {
                    zzkn.zzd("Exception occurred while getting video view", e);
                    zzlg.zzh(null);
                }
            }
        });
        return zzlg;
    }

    /* access modifiers changed from: package-private */
    public zzlt zzrt() {
        return zzu.zzga().zza(this.mContext, AdSizeParcel.zzk(this.mContext), false, false, this.zzbkp, this.zzcck.zzcix.zzaqv, this.zzalg, (zzs) null, this.zzbkj.zzdp());
    }
}
