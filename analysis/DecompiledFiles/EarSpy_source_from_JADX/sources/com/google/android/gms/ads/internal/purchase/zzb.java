package com.google.android.gms.ads.internal.purchase;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import com.android.vending.billing.util.IabHelper;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzkn;

@zziy
public class zzb {
    private final Context mContext;
    Object zzcbi;
    private final boolean zzcbj;

    public zzb(Context context) {
        this(context, true);
    }

    public zzb(Context context, boolean z) {
        this.mContext = context;
        this.zzcbj = z;
    }

    public void destroy() {
        this.zzcbi = null;
    }

    public void zzav(IBinder iBinder) {
        try {
            this.zzcbi = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService$Stub").getDeclaredMethod("asInterface", new Class[]{IBinder.class}).invoke((Object) null, new Object[]{iBinder});
        } catch (Exception e) {
            if (this.zzcbj) {
                zzkn.zzdf("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.");
            }
        }
    }

    public int zzb(int i, String str, String str2) {
        try {
            Class<?> loadClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return ((Integer) loadClass.getDeclaredMethod("isBillingSupported", new Class[]{Integer.TYPE, String.class, String.class}).invoke(loadClass.cast(this.zzcbi), new Object[]{Integer.valueOf(i), str, str2})).intValue();
        } catch (Exception e) {
            if (this.zzcbj) {
                zzkn.zzd("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            }
            return 5;
        }
    }

    public Bundle zzb(String str, String str2, String str3) {
        try {
            Class<?> loadClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) loadClass.getDeclaredMethod("getBuyIntent", new Class[]{Integer.TYPE, String.class, String.class, String.class, String.class}).invoke(loadClass.cast(this.zzcbi), new Object[]{3, str, str2, IabHelper.ITEM_TYPE_INAPP, str3});
        } catch (Exception e) {
            if (this.zzcbj) {
                zzkn.zzd("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            }
            return null;
        }
    }

    public int zzm(String str, String str2) {
        try {
            Class<?> loadClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return ((Integer) loadClass.getDeclaredMethod("consumePurchase", new Class[]{Integer.TYPE, String.class, String.class}).invoke(loadClass.cast(this.zzcbi), new Object[]{3, str, str2})).intValue();
        } catch (Exception e) {
            if (this.zzcbj) {
                zzkn.zzd("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            }
            return 5;
        }
    }

    public Bundle zzn(String str, String str2) {
        try {
            Class<?> loadClass = this.mContext.getClassLoader().loadClass("com.android.vending.billing.IInAppBillingService");
            return (Bundle) loadClass.getDeclaredMethod("getPurchases", new Class[]{Integer.TYPE, String.class, String.class, String.class}).invoke(loadClass.cast(this.zzcbi), new Object[]{3, str, IabHelper.ITEM_TYPE_INAPP, str2});
        } catch (Exception e) {
            if (this.zzcbj) {
                zzkn.zzd("IInAppBillingService is not available, please add com.android.vending.billing.IInAppBillingService to project.", e);
            }
            return null;
        }
    }
}
