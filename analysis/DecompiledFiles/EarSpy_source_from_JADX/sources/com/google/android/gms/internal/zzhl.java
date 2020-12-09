package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.internal.zzhk;
import java.util.Map;

@zziy
public class zzhl extends zzhm implements zzev {
    private final Context mContext;
    private final WindowManager zzasl;
    private final zzlt zzbkr;
    private final zzda zzbvt;
    DisplayMetrics zzbvu;
    private float zzbvv;
    int zzbvw = -1;
    int zzbvx = -1;
    private int zzbvy;
    int zzbvz = -1;
    int zzbwa = -1;
    int zzbwb = -1;
    int zzbwc = -1;

    public zzhl(zzlt zzlt, Context context, zzda zzda) {
        super(zzlt);
        this.zzbkr = zzlt;
        this.mContext = context;
        this.zzbvt = zzda;
        this.zzasl = (WindowManager) context.getSystemService("window");
    }

    private void zznx() {
        this.zzbvu = new DisplayMetrics();
        Display defaultDisplay = this.zzasl.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zzbvu);
        this.zzbvv = this.zzbvu.density;
        this.zzbvy = defaultDisplay.getRotation();
    }

    private void zzoc() {
        int[] iArr = new int[2];
        this.zzbkr.getLocationOnScreen(iArr);
        zze(zzm.zzjr().zzc(this.mContext, iArr[0]), zzm.zzjr().zzc(this.mContext, iArr[1]));
    }

    private zzhk zzof() {
        return new zzhk.zza().zzv(this.zzbvt.zzkj()).zzu(this.zzbvt.zzkk()).zzw(this.zzbvt.zzko()).zzx(this.zzbvt.zzkl()).zzy(this.zzbvt.zzkm()).zznw();
    }

    public void zza(zzlt zzlt, Map<String, String> map) {
        zzoa();
    }

    public void zze(int i, int i2) {
        int i3 = this.mContext instanceof Activity ? zzu.zzfz().zzk((Activity) this.mContext)[0] : 0;
        if (this.zzbkr.zzdt() == null || !this.zzbkr.zzdt().zzaxj) {
            this.zzbwb = zzm.zzjr().zzc(this.mContext, this.zzbkr.getMeasuredWidth());
            this.zzbwc = zzm.zzjr().zzc(this.mContext, this.zzbkr.getMeasuredHeight());
        }
        zzc(i, i2 - i3, this.zzbwb, this.zzbwc);
        this.zzbkr.zzvr().zzd(i, i2);
    }

    /* access modifiers changed from: package-private */
    public void zzny() {
        this.zzbvw = zzm.zzjr().zzb(this.zzbvu, this.zzbvu.widthPixels);
        this.zzbvx = zzm.zzjr().zzb(this.zzbvu, this.zzbvu.heightPixels);
        Activity zzvn = this.zzbkr.zzvn();
        if (zzvn == null || zzvn.getWindow() == null) {
            this.zzbvz = this.zzbvw;
            this.zzbwa = this.zzbvx;
            return;
        }
        int[] zzh = zzu.zzfz().zzh(zzvn);
        this.zzbvz = zzm.zzjr().zzb(this.zzbvu, zzh[0]);
        this.zzbwa = zzm.zzjr().zzb(this.zzbvu, zzh[1]);
    }

    /* access modifiers changed from: package-private */
    public void zznz() {
        if (this.zzbkr.zzdt().zzaxj) {
            this.zzbwb = this.zzbvw;
            this.zzbwc = this.zzbvx;
            return;
        }
        this.zzbkr.measure(0, 0);
    }

    public void zzoa() {
        zznx();
        zzny();
        zznz();
        zzod();
        zzoe();
        zzoc();
        zzob();
    }

    /* access modifiers changed from: package-private */
    public void zzob() {
        if (zzkn.zzbf(2)) {
            zzkn.zzde("Dispatching Ready Event.");
        }
        zzby(this.zzbkr.zzvu().zzcs);
    }

    /* access modifiers changed from: package-private */
    public void zzod() {
        zza(this.zzbvw, this.zzbvx, this.zzbvz, this.zzbwa, this.zzbvv, this.zzbvy);
    }

    /* access modifiers changed from: package-private */
    public void zzoe() {
        this.zzbkr.zzb("onDeviceFeaturesReceived", zzof().toJson());
    }
}
