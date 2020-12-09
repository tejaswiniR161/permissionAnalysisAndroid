package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.zzae;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class zzat extends zzas {
    private static final String TAG = zzat.class.getSimpleName();

    protected zzat(Context context, String str, boolean z) {
        super(context, str, z);
    }

    public static zzat zza(String str, Context context, boolean z) {
        zza(context, z);
        return new zzat(context, str, z);
    }

    /* access modifiers changed from: protected */
    public List<Callable<Void>> zzb(zzbb zzbb, zzae.zza zza) {
        if (zzbb.zzch() == null || !this.zzagr) {
            return super.zzb(zzbb, zza);
        }
        int zzau = zzbb.zzau();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zzb(zzbb, zza));
        arrayList.add(new zzbk(zzbb, zzax.zzbj(), zzax.zzbk(), zza, zzau, 24));
        return arrayList;
    }
}
