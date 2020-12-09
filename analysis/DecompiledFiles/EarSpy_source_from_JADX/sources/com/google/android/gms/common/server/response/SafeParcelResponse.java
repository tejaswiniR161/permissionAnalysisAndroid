package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.util.zzb;
import com.google.android.gms.common.util.zzc;
import com.google.android.gms.common.util.zzp;
import com.google.android.gms.common.util.zzq;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SafeParcelResponse extends FastSafeParcelableJsonResponse {
    public static final zze CREATOR = new zze();

    /* renamed from: DB */
    private final FieldMappingDictionary f1790DB;

    /* renamed from: DI */
    private final Parcel f1791DI;

    /* renamed from: DJ */
    private final int f1792DJ = 2;

    /* renamed from: DK */
    private int f1793DK;

    /* renamed from: DL */
    private int f1794DL;
    private final String mClassName;
    private final int mVersionCode;

    SafeParcelResponse(int i, Parcel parcel, FieldMappingDictionary fieldMappingDictionary) {
        this.mVersionCode = i;
        this.f1791DI = (Parcel) zzac.zzy(parcel);
        this.f1790DB = fieldMappingDictionary;
        if (this.f1790DB == null) {
            this.mClassName = null;
        } else {
            this.mClassName = this.f1790DB.zzawg();
        }
        this.f1793DK = 2;
    }

    private void zza(StringBuilder sb, int i, Object obj) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                sb.append(obj);
                return;
            case 7:
                sb.append("\"").append(zzp.zzii(obj.toString())).append("\"");
                return;
            case 8:
                sb.append("\"").append(zzc.zzp((byte[]) obj)).append("\"");
                return;
            case 9:
                sb.append("\"").append(zzc.zzq((byte[]) obj));
                sb.append("\"");
                return;
            case 10:
                zzq.zza(sb, (HashMap) obj);
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException(new StringBuilder(26).append("Unknown type = ").append(i).toString());
        }
    }

    private void zza(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Parcel parcel, int i) {
        switch (field.zzavr()) {
            case 0:
                zzb(sb, field, (Object) zza(field, Integer.valueOf(zza.zzg(parcel, i))));
                return;
            case 1:
                zzb(sb, field, (Object) zza(field, zza.zzk(parcel, i)));
                return;
            case 2:
                zzb(sb, field, (Object) zza(field, Long.valueOf(zza.zzi(parcel, i))));
                return;
            case 3:
                zzb(sb, field, (Object) zza(field, Float.valueOf(zza.zzl(parcel, i))));
                return;
            case 4:
                zzb(sb, field, (Object) zza(field, Double.valueOf(zza.zzn(parcel, i))));
                return;
            case 5:
                zzb(sb, field, (Object) zza(field, zza.zzp(parcel, i)));
                return;
            case 6:
                zzb(sb, field, (Object) zza(field, Boolean.valueOf(zza.zzc(parcel, i))));
                return;
            case 7:
                zzb(sb, field, (Object) zza(field, zza.zzq(parcel, i)));
                return;
            case 8:
            case 9:
                zzb(sb, field, (Object) zza(field, zza.zzt(parcel, i)));
                return;
            case 10:
                zzb(sb, field, (Object) zza(field, zzq(zza.zzs(parcel, i))));
                return;
            case 11:
                throw new IllegalArgumentException("Method does not accept concrete type.");
            default:
                throw new IllegalArgumentException(new StringBuilder(36).append("Unknown field out type = ").append(field.zzavr()).toString());
        }
    }

    private void zza(StringBuilder sb, String str, FastJsonResponse.Field<?, ?> field, Parcel parcel, int i) {
        sb.append("\"").append(str).append("\":");
        if (field.zzawb()) {
            zza(sb, field, parcel, i);
        } else {
            zzb(sb, field, parcel, i);
        }
    }

    private void zza(StringBuilder sb, Map<String, FastJsonResponse.Field<?, ?>> map, Parcel parcel) {
        SparseArray<Map.Entry<String, FastJsonResponse.Field<?, ?>>> zzav = zzav(map);
        sb.append('{');
        int zzcq = zza.zzcq(parcel);
        boolean z = false;
        while (parcel.dataPosition() < zzcq) {
            int zzcp = zza.zzcp(parcel);
            Map.Entry entry = zzav.get(zza.zzgv(zzcp));
            if (entry != null) {
                if (z) {
                    sb.append(",");
                }
                zza(sb, (String) entry.getKey(), (FastJsonResponse.Field) entry.getValue(), parcel, zzcp);
                z = true;
            }
        }
        if (parcel.dataPosition() != zzcq) {
            throw new zza.C1271zza(new StringBuilder(37).append("Overread allowed size end=").append(zzcq).toString(), parcel);
        }
        sb.append('}');
    }

    private static SparseArray<Map.Entry<String, FastJsonResponse.Field<?, ?>>> zzav(Map<String, FastJsonResponse.Field<?, ?>> map) {
        SparseArray<Map.Entry<String, FastJsonResponse.Field<?, ?>>> sparseArray = new SparseArray<>();
        for (Map.Entry next : map.entrySet()) {
            sparseArray.put(((FastJsonResponse.Field) next.getValue()).zzavy(), next);
        }
        return sparseArray;
    }

    private void zzb(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Parcel parcel, int i) {
        if (field.zzavw()) {
            sb.append("[");
            switch (field.zzavr()) {
                case 0:
                    zzb.zza(sb, zza.zzw(parcel, i));
                    break;
                case 1:
                    zzb.zza(sb, (T[]) zza.zzy(parcel, i));
                    break;
                case 2:
                    zzb.zza(sb, zza.zzx(parcel, i));
                    break;
                case 3:
                    zzb.zza(sb, zza.zzz(parcel, i));
                    break;
                case 4:
                    zzb.zza(sb, zza.zzaa(parcel, i));
                    break;
                case 5:
                    zzb.zza(sb, (T[]) zza.zzab(parcel, i));
                    break;
                case 6:
                    zzb.zza(sb, zza.zzv(parcel, i));
                    break;
                case 7:
                    zzb.zza(sb, zza.zzac(parcel, i));
                    break;
                case 8:
                case 9:
                case 10:
                    throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
                case 11:
                    Parcel[] zzag = zza.zzag(parcel, i);
                    int length = zzag.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        if (i2 > 0) {
                            sb.append(",");
                        }
                        zzag[i2].setDataPosition(0);
                        zza(sb, field.zzawd(), zzag[i2]);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unknown field type out.");
            }
            sb.append("]");
            return;
        }
        switch (field.zzavr()) {
            case 0:
                sb.append(zza.zzg(parcel, i));
                return;
            case 1:
                sb.append(zza.zzk(parcel, i));
                return;
            case 2:
                sb.append(zza.zzi(parcel, i));
                return;
            case 3:
                sb.append(zza.zzl(parcel, i));
                return;
            case 4:
                sb.append(zza.zzn(parcel, i));
                return;
            case 5:
                sb.append(zza.zzp(parcel, i));
                return;
            case 6:
                sb.append(zza.zzc(parcel, i));
                return;
            case 7:
                sb.append("\"").append(zzp.zzii(zza.zzq(parcel, i))).append("\"");
                return;
            case 8:
                sb.append("\"").append(zzc.zzp(zza.zzt(parcel, i))).append("\"");
                return;
            case 9:
                sb.append("\"").append(zzc.zzq(zza.zzt(parcel, i)));
                sb.append("\"");
                return;
            case 10:
                Bundle zzs = zza.zzs(parcel, i);
                Set<String> keySet = zzs.keySet();
                keySet.size();
                sb.append("{");
                boolean z = true;
                for (String str : keySet) {
                    if (!z) {
                        sb.append(",");
                    }
                    sb.append("\"").append(str).append("\"");
                    sb.append(":");
                    sb.append("\"").append(zzp.zzii(zzs.getString(str))).append("\"");
                    z = false;
                }
                sb.append("}");
                return;
            case 11:
                Parcel zzaf = zza.zzaf(parcel, i);
                zzaf.setDataPosition(0);
                zza(sb, field.zzawd(), zzaf);
                return;
            default:
                throw new IllegalStateException("Unknown field type out");
        }
    }

    private void zzb(StringBuilder sb, FastJsonResponse.Field<?, ?> field, Object obj) {
        if (field.zzavv()) {
            zzb(sb, field, (ArrayList<?>) (ArrayList) obj);
        } else {
            zza(sb, field.zzavq(), obj);
        }
    }

    private void zzb(StringBuilder sb, FastJsonResponse.Field<?, ?> field, ArrayList<?> arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                sb.append(",");
            }
            zza(sb, field.zzavq(), (Object) arrayList.get(i));
        }
        sb.append("]");
    }

    public static HashMap<String, String> zzq(Bundle bundle) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (String str : bundle.keySet()) {
            hashMap.put(str, bundle.getString(str));
        }
        return hashMap;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public String toString() {
        zzac.zzb(this.f1790DB, (Object) "Cannot convert to JSON on client side.");
        Parcel zzawi = zzawi();
        zzawi.setDataPosition(0);
        StringBuilder sb = new StringBuilder(100);
        zza(sb, this.f1790DB.zzie(this.mClassName), zzawi);
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zze zze = CREATOR;
        zze.zza(this, parcel, i);
    }

    public Map<String, FastJsonResponse.Field<?, ?>> zzavs() {
        if (this.f1790DB == null) {
            return null;
        }
        return this.f1790DB.zzie(this.mClassName);
    }

    public Parcel zzawi() {
        switch (this.f1793DK) {
            case 0:
                this.f1794DL = com.google.android.gms.common.internal.safeparcel.zzb.zzcr(this.f1791DI);
                com.google.android.gms.common.internal.safeparcel.zzb.zzaj(this.f1791DI, this.f1794DL);
                this.f1793DK = 2;
                break;
            case 1:
                com.google.android.gms.common.internal.safeparcel.zzb.zzaj(this.f1791DI, this.f1794DL);
                this.f1793DK = 2;
                break;
        }
        return this.f1791DI;
    }

    /* access modifiers changed from: package-private */
    public FieldMappingDictionary zzawj() {
        switch (this.f1792DJ) {
            case 0:
                return null;
            case 1:
                return this.f1790DB;
            case 2:
                return this.f1790DB;
            default:
                throw new IllegalStateException(new StringBuilder(34).append("Invalid creation type: ").append(this.f1792DJ).toString());
        }
    }

    public Object zzia(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }

    public boolean zzib(String str) {
        throw new UnsupportedOperationException("Converting to JSON does not require this method.");
    }
}
