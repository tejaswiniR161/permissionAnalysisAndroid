package com.google.android.gms.common.server.response;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FieldMappingDictionary extends AbstractSafeParcelable {
    public static final zzc CREATOR = new zzc();

    /* renamed from: DD */
    private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> f1785DD;

    /* renamed from: DE */
    private final ArrayList<Entry> f1786DE = null;

    /* renamed from: DF */
    private final String f1787DF;
    private final int mVersionCode;

    public static class Entry extends AbstractSafeParcelable {
        public static final zzd CREATOR = new zzd();

        /* renamed from: DG */
        final ArrayList<FieldMapPair> f1788DG;
        final String className;
        final int versionCode;

        Entry(int i, String str, ArrayList<FieldMapPair> arrayList) {
            this.versionCode = i;
            this.className = str;
            this.f1788DG = arrayList;
        }

        Entry(String str, Map<String, FastJsonResponse.Field<?, ?>> map) {
            this.versionCode = 1;
            this.className = str;
            this.f1788DG = zzau(map);
        }

        private static ArrayList<FieldMapPair> zzau(Map<String, FastJsonResponse.Field<?, ?>> map) {
            if (map == null) {
                return null;
            }
            ArrayList<FieldMapPair> arrayList = new ArrayList<>();
            for (String next : map.keySet()) {
                arrayList.add(new FieldMapPair(next, map.get(next)));
            }
            return arrayList;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzd zzd = CREATOR;
            zzd.zza(this, parcel, i);
        }

        /* access modifiers changed from: package-private */
        public HashMap<String, FastJsonResponse.Field<?, ?>> zzawh() {
            HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
            int size = this.f1788DG.size();
            for (int i = 0; i < size; i++) {
                FieldMapPair fieldMapPair = this.f1788DG.get(i);
                hashMap.put(fieldMapPair.zzcb, fieldMapPair.f1789DH);
            }
            return hashMap;
        }
    }

    public static class FieldMapPair extends AbstractSafeParcelable {
        public static final zzb CREATOR = new zzb();

        /* renamed from: DH */
        final FastJsonResponse.Field<?, ?> f1789DH;
        final int versionCode;
        final String zzcb;

        FieldMapPair(int i, String str, FastJsonResponse.Field<?, ?> field) {
            this.versionCode = i;
            this.zzcb = str;
            this.f1789DH = field;
        }

        FieldMapPair(String str, FastJsonResponse.Field<?, ?> field) {
            this.versionCode = 1;
            this.zzcb = str;
            this.f1789DH = field;
        }

        public void writeToParcel(Parcel parcel, int i) {
            zzb zzb = CREATOR;
            zzb.zza(this, parcel, i);
        }
    }

    FieldMappingDictionary(int i, ArrayList<Entry> arrayList, String str) {
        this.mVersionCode = i;
        this.f1785DD = zzi(arrayList);
        this.f1787DF = (String) zzac.zzy(str);
        zzawe();
    }

    private static HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zzi(ArrayList<Entry> arrayList) {
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Entry entry = arrayList.get(i);
            hashMap.put(entry.className, entry.zzawh());
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String next : this.f1785DD.keySet()) {
            sb.append(next).append(":\n");
            Map map = this.f1785DD.get(next);
            for (String str : map.keySet()) {
                sb.append("  ").append(str).append(": ");
                sb.append(map.get(str));
            }
        }
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc zzc = CREATOR;
        zzc.zza(this, parcel, i);
    }

    public void zzawe() {
        for (String str : this.f1785DD.keySet()) {
            Map map = this.f1785DD.get(str);
            for (String str2 : map.keySet()) {
                ((FastJsonResponse.Field) map.get(str2)).zza(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ArrayList<Entry> zzawf() {
        ArrayList<Entry> arrayList = new ArrayList<>();
        for (String next : this.f1785DD.keySet()) {
            arrayList.add(new Entry(next, this.f1785DD.get(next)));
        }
        return arrayList;
    }

    public String zzawg() {
        return this.f1787DF;
    }

    public Map<String, FastJsonResponse.Field<?, ?>> zzie(String str) {
        return this.f1785DD.get(str);
    }
}
