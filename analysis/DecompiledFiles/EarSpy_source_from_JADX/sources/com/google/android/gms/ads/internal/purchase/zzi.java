package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.android.vending.billing.util.IabHelper;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.ads.purchase.InAppPurchaseActivity;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzkh;
import com.google.android.gms.internal.zzkn;
import org.json.JSONException;
import org.json.JSONObject;

@zziy
public class zzi {
    public void zza(Context context, boolean z, GInAppPurchaseManagerInfoParcel gInAppPurchaseManagerInfoParcel) {
        Intent intent = new Intent();
        intent.setClassName(context, InAppPurchaseActivity.CLASS_NAME);
        intent.putExtra("com.google.android.gms.ads.internal.purchase.useClientJar", z);
        GInAppPurchaseManagerInfoParcel.zza(intent, gInAppPurchaseManagerInfoParcel);
        zzu.zzfz().zzb(context, intent);
    }

    public String zzcc(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new JSONObject(str).getString("developerPayload");
        } catch (JSONException e) {
            zzkn.zzdf("Fail to parse purchase data");
            return null;
        }
    }

    public String zzcd(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new JSONObject(str).getString("purchaseToken");
        } catch (JSONException e) {
            zzkn.zzdf("Fail to parse purchase data");
            return null;
        }
    }

    public int zzd(Intent intent) {
        if (intent == null) {
            return 5;
        }
        Object obj = intent.getExtras().get(IabHelper.RESPONSE_CODE);
        if (obj == null) {
            zzkn.zzdf("Intent with no response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            String valueOf = String.valueOf(obj.getClass().getName());
            zzkn.zzdf(valueOf.length() != 0 ? "Unexpected type for intent response code. ".concat(valueOf) : new String("Unexpected type for intent response code. "));
            return 5;
        }
    }

    public int zzd(Bundle bundle) {
        Object obj = bundle.get(IabHelper.RESPONSE_CODE);
        if (obj == null) {
            zzkn.zzdf("Bundle with null response code, assuming OK (known issue)");
            return 0;
        } else if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        } else {
            if (obj instanceof Long) {
                return (int) ((Long) obj).longValue();
            }
            String valueOf = String.valueOf(obj.getClass().getName());
            zzkn.zzdf(valueOf.length() != 0 ? "Unexpected type for intent response code. ".concat(valueOf) : new String("Unexpected type for intent response code. "));
            return 5;
        }
    }

    public String zze(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getStringExtra(IabHelper.RESPONSE_INAPP_PURCHASE_DATA);
    }

    public String zzf(Intent intent) {
        if (intent == null) {
            return null;
        }
        return intent.getStringExtra(IabHelper.RESPONSE_INAPP_SIGNATURE);
    }

    public void zzt(final Context context) {
        C06591 r0 = new ServiceConnection() {
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                boolean z = false;
                zzb zzb = new zzb(context.getApplicationContext(), false);
                zzb.zzav(iBinder);
                int zzb2 = zzb.zzb(3, context.getPackageName(), IabHelper.ITEM_TYPE_INAPP);
                zzkh zzgd = zzu.zzgd();
                if (zzb2 == 0) {
                    z = true;
                }
                zzgd.zzah(z);
                context.unbindService(this);
                zzb.destroy();
            }

            public void onServiceDisconnected(ComponentName componentName) {
            }
        };
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        context.bindService(intent, r0, 1);
    }
}
