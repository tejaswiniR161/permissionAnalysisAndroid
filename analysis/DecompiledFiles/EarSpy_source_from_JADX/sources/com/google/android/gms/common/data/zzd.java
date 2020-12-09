package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzd<T extends SafeParcelable> extends AbstractDataBuffer<T> {

    /* renamed from: zM */
    private static final String[] f1589zM = {"data"};

    /* renamed from: zN */
    private final Parcelable.Creator<T> f1590zN;

    public zzd(DataHolder dataHolder, Parcelable.Creator<T> creator) {
        super(dataHolder);
        this.f1590zN = creator;
    }

    public static <T extends SafeParcelable> void zza(DataHolder.zza zza, T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        ContentValues contentValues = new ContentValues();
        contentValues.put("data", obtain.marshall());
        zza.zza(contentValues);
        obtain.recycle();
    }

    public static DataHolder.zza zzatd() {
        return DataHolder.zzc(f1589zM);
    }

    /* renamed from: zzga */
    public T get(int i) {
        byte[] zzg = this.f1563xi.zzg("data", i, this.f1563xi.zzgb(i));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(zzg, 0, zzg.length);
        obtain.setDataPosition(0);
        T t = (SafeParcelable) this.f1590zN.createFromParcel(obtain);
        obtain.recycle();
        return t;
    }
}
