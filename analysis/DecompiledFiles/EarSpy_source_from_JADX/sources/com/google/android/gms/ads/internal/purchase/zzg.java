package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.internal.zzia;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzkn;

@zziy
public final class zzg extends zzia.zza implements ServiceConnection {
    private Context mContext;
    private int mResultCode;
    zzb zzcbl;
    private String zzcbr;
    private zzf zzcbv;
    private boolean zzccb = false;
    private Intent zzccc;

    public zzg(Context context, String str, boolean z, int i, Intent intent, zzf zzf) {
        this.zzcbr = str;
        this.mResultCode = i;
        this.zzccc = intent;
        this.zzccb = z;
        this.mContext = context;
        this.zzcbv = zzf;
    }

    public void finishPurchase() {
        int zzd = zzu.zzgn().zzd(this.zzccc);
        if (this.mResultCode == -1 && zzd == 0) {
            this.zzcbl = new zzb(this.mContext);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            zzb.zzawu().zza(this.mContext, intent, (ServiceConnection) this, 1);
        }
    }

    public String getProductId() {
        return this.zzcbr;
    }

    public Intent getPurchaseData() {
        return this.zzccc;
    }

    public int getResultCode() {
        return this.mResultCode;
    }

    public boolean isVerified() {
        return this.zzccb;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzkn.zzde("In-app billing service connected.");
        this.zzcbl.zzav(iBinder);
        String zzcd = zzu.zzgn().zzcd(zzu.zzgn().zze(this.zzccc));
        if (zzcd != null) {
            if (this.zzcbl.zzm(this.mContext.getPackageName(), zzcd) == 0) {
                zzh.zzs(this.mContext).zza(this.zzcbv);
            }
            zzb.zzawu().zza(this.mContext, (ServiceConnection) this);
            this.zzcbl.destroy();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        zzkn.zzde("In-app billing service disconnected.");
        this.zzcbl.destroy();
    }
}
