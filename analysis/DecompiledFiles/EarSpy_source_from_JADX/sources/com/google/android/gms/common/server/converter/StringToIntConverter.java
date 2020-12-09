package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.zza<String, Integer> {
    public static final zzb CREATOR = new zzb();

    /* renamed from: Do */
    private final HashMap<String, Integer> f1770Do;

    /* renamed from: Dp */
    private final SparseArray<String> f1771Dp;

    /* renamed from: Dq */
    private final ArrayList<Entry> f1772Dq;
    private final int mVersionCode;

    public static final class Entry extends AbstractSafeParcelable {
        public static final zzc CREATOR = new zzc();

        /* renamed from: Dr */
        final String f1773Dr;

        /* renamed from: Ds */
        final int f1774Ds;
        final int versionCode;

        Entry(int i, String str, int i2) {
            this.versionCode = i;
            this.f1773Dr = str;
            this.f1774Ds = i2;
        }

        Entry(String str, int i) {
            this.versionCode = 1;
            this.f1773Dr = str;
            this.f1774Ds = i;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzc zzc = CREATOR;
            zzc.zza(this, parcel, i);
        }
    }

    public StringToIntConverter() {
        this.mVersionCode = 1;
        this.f1770Do = new HashMap<>();
        this.f1771Dp = new SparseArray<>();
        this.f1772Dq = null;
    }

    StringToIntConverter(int i, ArrayList<Entry> arrayList) {
        this.mVersionCode = i;
        this.f1770Do = new HashMap<>();
        this.f1771Dp = new SparseArray<>();
        this.f1772Dq = null;
        zzh(arrayList);
    }

    private void zzh(ArrayList<Entry> arrayList) {
        Iterator<Entry> it = arrayList.iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            zzj(next.f1773Dr, next.f1774Ds);
        }
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb zzb = CREATOR;
        zzb.zza(this, parcel, i);
    }

    /* access modifiers changed from: package-private */
    public ArrayList<Entry> zzavp() {
        ArrayList<Entry> arrayList = new ArrayList<>();
        for (String next : this.f1770Do.keySet()) {
            arrayList.add(new Entry(next, this.f1770Do.get(next).intValue()));
        }
        return arrayList;
    }

    public int zzavq() {
        return 7;
    }

    public int zzavr() {
        return 0;
    }

    /* renamed from: zzd */
    public String convertBack(Integer num) {
        String str = this.f1771Dp.get(num.intValue());
        return (str != null || !this.f1770Do.containsKey("gms_unknown")) ? str : "gms_unknown";
    }

    public StringToIntConverter zzj(String str, int i) {
        this.f1770Do.put(str, Integer.valueOf(i));
        this.f1771Dp.put(i, str);
        return this;
    }
}
