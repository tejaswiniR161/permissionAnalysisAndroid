package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.internal.zzae;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class zzar extends zzas {
    private static final String TAG = zzar.class.getSimpleName();
    private AdvertisingIdClient.Info zzagq;

    protected zzar(Context context) {
        super(context, "");
    }

    public static zzar zzd(Context context) {
        zza(context, true);
        return new zzar(context);
    }

    /* access modifiers changed from: protected */
    public zzae.zza zza(Context context, View view) {
        return null;
    }

    public String zza(String str, String str2) {
        return zzam.zza(str, str2, true);
    }

    public void zza(AdvertisingIdClient.Info info) {
        this.zzagq = info;
    }

    /* access modifiers changed from: protected */
    public void zza(zzbb zzbb, zzae.zza zza) {
        if (!zzbb.zzcm()) {
            zza(zzb(zzbb, zza));
        } else if (this.zzagq != null) {
            String id = this.zzagq.getId();
            if (!TextUtils.isEmpty(id)) {
                zza.zzes = zzbd.zzq(id);
                zza.zzet = 5;
                zza.zzeu = Boolean.valueOf(this.zzagq.isLimitAdTrackingEnabled());
            }
            this.zzagq = null;
        }
    }

    /* access modifiers changed from: protected */
    public List<Callable<Void>> zzb(zzbb zzbb, zzae.zza zza) {
        ArrayList arrayList = new ArrayList();
        if (zzbb.zzch() == null) {
            return arrayList;
        }
        zzbb zzbb2 = zzbb;
        arrayList.add(new zzbk(zzbb2, zzax.zzbj(), zzax.zzbk(), zza, zzbb.zzau(), 24));
        return arrayList;
    }
}
