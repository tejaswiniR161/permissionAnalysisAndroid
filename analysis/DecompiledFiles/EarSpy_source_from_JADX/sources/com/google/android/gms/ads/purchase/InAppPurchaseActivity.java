package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzm;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzhy;

public class InAppPurchaseActivity extends Activity {
    public static final String CLASS_NAME = "com.google.android.gms.ads.purchase.InAppPurchaseActivity";
    public static final String SIMPLE_CLASS_NAME = "InAppPurchaseActivity";
    private zzhy zzcxo;

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        try {
            if (this.zzcxo != null) {
                this.zzcxo.onActivityResult(i, i2, intent);
            }
        } catch (RemoteException e) {
            zzb.zzd("Could not forward onActivityResult to in-app purchase manager:", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzcxo = zzm.zzjs().zzb((Activity) this);
        if (this.zzcxo == null) {
            zzb.zzdf("Could not create in-app purchase manager.");
            finish();
            return;
        }
        try {
            this.zzcxo.onCreate();
        } catch (RemoteException e) {
            zzb.zzd("Could not forward onCreate to in-app purchase manager:", e);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        try {
            if (this.zzcxo != null) {
                this.zzcxo.onDestroy();
            }
        } catch (RemoteException e) {
            zzb.zzd("Could not forward onDestroy to in-app purchase manager:", e);
        }
        super.onDestroy();
    }
}
