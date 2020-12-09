package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.SystemClock;
import com.android.vending.billing.util.IabHelper;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.internal.zzib;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzkm;
import com.google.android.gms.internal.zzkn;
import com.google.android.gms.internal.zzkr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@zziy
public class zzc extends zzkm implements ServiceConnection {
    /* access modifiers changed from: private */
    public Context mContext;
    private final Object zzakd;
    /* access modifiers changed from: private */
    public zzib zzbpt;
    private boolean zzcbk;
    private zzb zzcbl;
    private zzh zzcbm;
    private List<zzf> zzcbn;
    /* access modifiers changed from: private */
    public zzk zzcbo;

    public zzc(Context context, zzib zzib, zzk zzk) {
        this(context, zzib, zzk, new zzb(context), zzh.zzs(context.getApplicationContext()));
    }

    zzc(Context context, zzib zzib, zzk zzk, zzb zzb, zzh zzh) {
        this.zzakd = new Object();
        this.zzcbk = false;
        this.zzcbn = null;
        this.mContext = context;
        this.zzbpt = zzib;
        this.zzcbo = zzk;
        this.zzcbl = zzb;
        this.zzcbm = zzh;
        this.zzcbn = this.zzcbm.zzg(10);
    }

    private void zze(long j) {
        do {
            if (!zzf(j)) {
                zzkn.m1493v("Timeout waiting for pending transaction to be processed.");
            }
        } while (!this.zzcbk);
    }

    private boolean zzf(long j) {
        long elapsedRealtime = 60000 - (SystemClock.elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zzakd.wait(elapsedRealtime);
        } catch (InterruptedException e) {
            zzkn.zzdf("waitWithTimeout_lock interrupted");
        }
        return true;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.zzakd) {
            this.zzcbl.zzav(iBinder);
            zzqo();
            this.zzcbk = true;
            this.zzakd.notify();
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        zzkn.zzde("In-app billing service disconnected.");
        this.zzcbl.destroy();
    }

    public void onStop() {
        synchronized (this.zzakd) {
            zzb.zzawu().zza(this.mContext, (ServiceConnection) this);
            this.zzcbl.destroy();
        }
    }

    /* access modifiers changed from: protected */
    public void zza(final zzf zzf, String str, String str2) {
        final Intent intent = new Intent();
        zzu.zzgn();
        intent.putExtra(IabHelper.RESPONSE_CODE, 0);
        zzu.zzgn();
        intent.putExtra(IabHelper.RESPONSE_INAPP_PURCHASE_DATA, str);
        zzu.zzgn();
        intent.putExtra(IabHelper.RESPONSE_INAPP_SIGNATURE, str2);
        zzkr.zzcrf.post(new Runnable() {
            public void run() {
                try {
                    if (zzc.this.zzcbo.zza(zzf.zzcbz, -1, intent)) {
                        zzc.this.zzbpt.zza(new zzg(zzc.this.mContext, zzf.zzcca, true, -1, intent, zzf));
                    } else {
                        zzc.this.zzbpt.zza(new zzg(zzc.this.mContext, zzf.zzcca, false, -1, intent, zzf));
                    }
                } catch (RemoteException e) {
                    zzkn.zzdf("Fail to verify and dispatch pending transaction");
                }
            }
        });
    }

    public void zzfc() {
        synchronized (this.zzakd) {
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            zzb.zzawu().zza(this.mContext, intent, (ServiceConnection) this, 1);
            zze(SystemClock.elapsedRealtime());
            zzb.zzawu().zza(this.mContext, (ServiceConnection) this);
            this.zzcbl.destroy();
        }
    }

    /* access modifiers changed from: protected */
    public void zzqo() {
        if (!this.zzcbn.isEmpty()) {
            HashMap hashMap = new HashMap();
            for (zzf next : this.zzcbn) {
                hashMap.put(next.zzcca, next);
            }
            String str = null;
            while (true) {
                Bundle zzn = this.zzcbl.zzn(this.mContext.getPackageName(), str);
                if (zzn == null || zzu.zzgn().zzd(zzn) != 0) {
                    break;
                }
                ArrayList<String> stringArrayList = zzn.getStringArrayList(IabHelper.RESPONSE_INAPP_ITEM_LIST);
                ArrayList<String> stringArrayList2 = zzn.getStringArrayList(IabHelper.RESPONSE_INAPP_PURCHASE_DATA_LIST);
                ArrayList<String> stringArrayList3 = zzn.getStringArrayList(IabHelper.RESPONSE_INAPP_SIGNATURE_LIST);
                String string = zzn.getString(IabHelper.INAPP_CONTINUATION_TOKEN);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= stringArrayList.size()) {
                        break;
                    }
                    if (hashMap.containsKey(stringArrayList.get(i2))) {
                        String str2 = stringArrayList.get(i2);
                        String str3 = stringArrayList2.get(i2);
                        String str4 = stringArrayList3.get(i2);
                        zzf zzf = (zzf) hashMap.get(str2);
                        if (zzf.zzcbz.equals(zzu.zzgn().zzcc(str3))) {
                            zza(zzf, str3, str4);
                            hashMap.remove(str2);
                        }
                    }
                    i = i2 + 1;
                }
                if (string == null || hashMap.isEmpty()) {
                    break;
                }
                str = string;
            }
            for (String str5 : hashMap.keySet()) {
                this.zzcbm.zza((zzf) hashMap.get(str5));
            }
        }
    }
}
