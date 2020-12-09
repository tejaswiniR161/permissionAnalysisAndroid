package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.support.p000v4.util.SimpleArrayMap;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ViewSwitcher;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.VideoOptionsParcel;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.client.zzp;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.internal.client.zzw;
import com.google.android.gms.ads.internal.client.zzy;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.purchase.zzk;
import com.google.android.gms.ads.internal.reward.client.zzd;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.internal.zzau;
import com.google.android.gms.internal.zzdi;
import com.google.android.gms.internal.zzdu;
import com.google.android.gms.internal.zzeh;
import com.google.android.gms.internal.zzei;
import com.google.android.gms.internal.zzej;
import com.google.android.gms.internal.zzek;
import com.google.android.gms.internal.zzhx;
import com.google.android.gms.internal.zzib;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzke;
import com.google.android.gms.internal.zzkf;
import com.google.android.gms.internal.zzkk;
import com.google.android.gms.internal.zzkm;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzkt;
import com.google.android.gms.internal.zzku;
import com.google.android.gms.internal.zzlc;
import com.google.android.gms.internal.zzlf;
import com.google.android.gms.internal.zzlt;
import com.google.android.gms.internal.zzlu;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@zziy
public final class zzv implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    public final Context zzahn;
    boolean zzanx;
    final String zzaqs;
    public String zzaqt;
    final zzau zzaqu;
    public final VersionInfoParcel zzaqv;
    @Nullable
    zza zzaqw;
    @Nullable
    public zzkm zzaqx;
    @Nullable
    public zzkt zzaqy;
    public AdSizeParcel zzaqz;
    @Nullable
    public zzke zzara;
    public zzke.zza zzarb;
    @Nullable
    public zzkf zzarc;
    @Nullable
    zzp zzard;
    @Nullable
    zzq zzare;
    @Nullable
    zzw zzarf;
    @Nullable
    zzy zzarg;
    @Nullable
    zzhx zzarh;
    @Nullable
    zzib zzari;
    @Nullable
    zzeh zzarj;
    @Nullable
    zzei zzark;
    SimpleArrayMap<String, zzej> zzarl;
    SimpleArrayMap<String, zzek> zzarm;
    NativeAdOptionsParcel zzarn;
    @Nullable
    VideoOptionsParcel zzaro;
    @Nullable
    zzdu zzarp;
    @Nullable
    zzd zzarq;
    @Nullable
    List<String> zzarr;
    @Nullable
    zzk zzars;
    @Nullable
    public zzkk zzart;
    @Nullable
    View zzaru;
    public int zzarv;
    boolean zzarw;
    private HashSet<zzkf> zzarx;
    private int zzary;
    private int zzarz;
    private zzlc zzasa;
    private boolean zzasb;
    private boolean zzasc;
    private boolean zzasd;

    public static class zza extends ViewSwitcher {
        private final zzku zzase;
        @Nullable
        private final zzlf zzasf;

        public zza(Context context, String str, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
            super(context);
            this.zzase = new zzku(context);
            this.zzase.setAdUnitId(str);
            if (context instanceof Activity) {
                this.zzasf = new zzlf((Activity) context, this, onGlobalLayoutListener, onScrollChangedListener);
            } else {
                this.zzasf = new zzlf((Activity) null, this, onGlobalLayoutListener, onScrollChangedListener);
            }
            this.zzasf.zzva();
        }

        /* access modifiers changed from: protected */
        public void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.zzasf != null) {
                this.zzasf.onAttachedToWindow();
            }
        }

        /* access modifiers changed from: protected */
        public void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.zzasf != null) {
                this.zzasf.onDetachedFromWindow();
            }
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            this.zzase.zzg(motionEvent);
            return false;
        }

        public void removeAllViews() {
            ArrayList<zzlt> arrayList = new ArrayList<>();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= getChildCount()) {
                    break;
                }
                View childAt = getChildAt(i2);
                if (childAt != null && (childAt instanceof zzlt)) {
                    arrayList.add((zzlt) childAt);
                }
                i = i2 + 1;
            }
            super.removeAllViews();
            for (zzlt destroy : arrayList) {
                destroy.destroy();
            }
        }

        public void zzhe() {
            zzkn.m1493v("Disable position monitoring on adFrame.");
            if (this.zzasf != null) {
                this.zzasf.zzvb();
            }
        }

        public zzku zzhi() {
            return this.zzase;
        }
    }

    public zzv(Context context, AdSizeParcel adSizeParcel, String str, VersionInfoParcel versionInfoParcel) {
        this(context, adSizeParcel, str, versionInfoParcel, (zzau) null);
    }

    zzv(Context context, AdSizeParcel adSizeParcel, String str, VersionInfoParcel versionInfoParcel, zzau zzau) {
        this.zzart = null;
        this.zzaru = null;
        this.zzarv = 0;
        this.zzarw = false;
        this.zzanx = false;
        this.zzarx = null;
        this.zzary = -1;
        this.zzarz = -1;
        this.zzasb = true;
        this.zzasc = true;
        this.zzasd = false;
        zzdi.initialize(context);
        if (zzu.zzgd().zztm() != null) {
            List<String> zzks = zzdi.zzks();
            if (versionInfoParcel.zzcts != 0) {
                zzks.add(Integer.toString(versionInfoParcel.zzcts));
            }
            zzu.zzgd().zztm().zzc(zzks);
        }
        this.zzaqs = UUID.randomUUID().toString();
        if (adSizeParcel.zzaxj || adSizeParcel.zzaxl) {
            this.zzaqw = null;
        } else {
            this.zzaqw = new zza(context, str, this, this);
            this.zzaqw.setMinimumWidth(adSizeParcel.widthPixels);
            this.zzaqw.setMinimumHeight(adSizeParcel.heightPixels);
            this.zzaqw.setVisibility(4);
        }
        this.zzaqz = adSizeParcel;
        this.zzaqt = str;
        this.zzahn = context;
        this.zzaqv = versionInfoParcel;
        this.zzaqu = zzau == null ? new zzau(new zzi(this)) : zzau;
        this.zzasa = new zzlc(200);
        this.zzarm = new SimpleArrayMap<>();
    }

    private void zzh(boolean z) {
        boolean z2 = true;
        if (this.zzaqw != null && this.zzara != null && this.zzara.zzbyh != null && this.zzara.zzbyh.zzvr() != null) {
            if (!z || this.zzasa.tryAcquire()) {
                if (this.zzara.zzbyh.zzvr().zzib()) {
                    int[] iArr = new int[2];
                    this.zzaqw.getLocationOnScreen(iArr);
                    int zzc = zzm.zzjr().zzc(this.zzahn, iArr[0]);
                    int zzc2 = zzm.zzjr().zzc(this.zzahn, iArr[1]);
                    if (!(zzc == this.zzary && zzc2 == this.zzarz)) {
                        this.zzary = zzc;
                        this.zzarz = zzc2;
                        zzlu zzvr = this.zzara.zzbyh.zzvr();
                        int i = this.zzary;
                        int i2 = this.zzarz;
                        if (z) {
                            z2 = false;
                        }
                        zzvr.zza(i, i2, z2);
                    }
                }
                zzhf();
            }
        }
    }

    private void zzhf() {
        View findViewById;
        if (this.zzaqw != null && (findViewById = this.zzaqw.getRootView().findViewById(16908290)) != null) {
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            this.zzaqw.getGlobalVisibleRect(rect);
            findViewById.getGlobalVisibleRect(rect2);
            if (rect.top != rect2.top) {
                this.zzasb = false;
            }
            if (rect.bottom != rect2.bottom) {
                this.zzasc = false;
            }
        }
    }

    public void destroy() {
        zzhe();
        this.zzare = null;
        this.zzarf = null;
        this.zzari = null;
        this.zzarh = null;
        this.zzarp = null;
        this.zzarg = null;
        zzi(false);
        if (this.zzaqw != null) {
            this.zzaqw.removeAllViews();
        }
        zzgz();
        zzhb();
        this.zzara = null;
    }

    public void onGlobalLayout() {
        zzh(false);
    }

    public void onScrollChanged() {
        zzh(true);
        this.zzasd = true;
    }

    public void zza(HashSet<zzkf> hashSet) {
        this.zzarx = hashSet;
    }

    public HashSet<zzkf> zzgy() {
        return this.zzarx;
    }

    public void zzgz() {
        if (this.zzara != null && this.zzara.zzbyh != null) {
            this.zzara.zzbyh.destroy();
        }
    }

    public void zzha() {
        if (this.zzara != null && this.zzara.zzbyh != null) {
            this.zzara.zzbyh.stopLoading();
        }
    }

    public void zzhb() {
        if (this.zzara != null && this.zzara.zzbtf != null) {
            try {
                this.zzara.zzbtf.destroy();
            } catch (RemoteException e) {
                zzkn.zzdf("Could not destroy mediation adapter.");
            }
        }
    }

    public boolean zzhc() {
        return this.zzarv == 0;
    }

    public boolean zzhd() {
        return this.zzarv == 1;
    }

    public void zzhe() {
        if (this.zzaqw != null) {
            this.zzaqw.zzhe();
        }
    }

    public String zzhg() {
        return (!this.zzasb || !this.zzasc) ? this.zzasb ? this.zzasd ? "top-scrollable" : "top-locked" : this.zzasc ? this.zzasd ? "bottom-scrollable" : "bottom-locked" : "" : "";
    }

    public void zzhh() {
        if (this.zzarc != null) {
            if (this.zzara != null) {
                this.zzarc.zzm(this.zzara.zzcoj);
                this.zzarc.zzn(this.zzara.zzcok);
                this.zzarc.zzae(this.zzara.zzchc);
            }
            this.zzarc.zzad(this.zzaqz.zzaxj);
        }
    }

    public void zzi(boolean z) {
        if (this.zzarv == 0) {
            zzha();
        }
        if (this.zzaqx != null) {
            this.zzaqx.cancel();
        }
        if (this.zzaqy != null) {
            this.zzaqy.cancel();
        }
        if (z) {
            this.zzara = null;
        }
    }
}
