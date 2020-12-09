package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.applovin.sdk.AppLovinEventTypes;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.internal.zzard;
import com.google.android.gms.internal.zzvk;
import com.google.android.gms.internal.zzvm;
import com.google.android.gms.measurement.AppMeasurement;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class zzal extends zzz {
    zzal(zzx zzx) {
        super(zzx);
    }

    private Object zza(int i, Object obj, boolean z) {
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return zza(String.valueOf(obj), i, z);
            }
            return null;
        }
    }

    public static String zza(zzvk.zzb zzb) {
        if (zzb == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        zza(sb, 0, "filter_id", (Object) zzb.asE);
        zza(sb, 0, "event_name", (Object) zzb.asF);
        zza(sb, 1, "event_count_filter", zzb.asI);
        sb.append("  filters {\n");
        for (zzvk.zzc zza : zzb.asG) {
            zza(sb, 2, zza);
        }
        zza(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    public static String zza(zzvk.zze zze) {
        if (zze == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        zza(sb, 0, "filter_id", (Object) zze.asE);
        zza(sb, 0, "property_name", (Object) zze.asU);
        zza(sb, 1, zze.asV);
        sb.append("}\n");
        return sb.toString();
    }

    private static void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private static void zza(StringBuilder sb, int i, zzvk.zzc zzc) {
        if (zzc != null) {
            zza(sb, i);
            sb.append("filter {\n");
            zza(sb, i, "complement", (Object) zzc.asM);
            zza(sb, i, "param_name", (Object) zzc.asN);
            zza(sb, i + 1, "string_filter", zzc.asK);
            zza(sb, i + 1, "number_filter", zzc.asL);
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, zzvm.zze zze) {
        if (zze != null) {
            zza(sb, i);
            sb.append("bundle {\n");
            zza(sb, i, "protocol_version", (Object) zze.atv);
            zza(sb, i, "platform", (Object) zze.atD);
            zza(sb, i, "gmp_version", (Object) zze.atH);
            zza(sb, i, "uploading_gmp_version", (Object) zze.atI);
            zza(sb, i, "gmp_app_id", (Object) zze.anQ);
            zza(sb, i, "app_id", (Object) zze.zzck);
            zza(sb, i, "app_version", (Object) zze.afY);
            zza(sb, i, "app_version_major", (Object) zze.atQ);
            zza(sb, i, "firebase_instance_id", (Object) zze.anY);
            zza(sb, i, "dev_cert_hash", (Object) zze.atM);
            zza(sb, i, "app_store", (Object) zze.anR);
            zza(sb, i, "upload_timestamp_millis", (Object) zze.aty);
            zza(sb, i, "start_timestamp_millis", (Object) zze.atz);
            zza(sb, i, "end_timestamp_millis", (Object) zze.atA);
            zza(sb, i, "previous_bundle_start_timestamp_millis", (Object) zze.atB);
            zza(sb, i, "previous_bundle_end_timestamp_millis", (Object) zze.atC);
            zza(sb, i, "app_instance_id", (Object) zze.atL);
            zza(sb, i, "resettable_device_id", (Object) zze.atJ);
            zza(sb, i, "device_id", (Object) zze.atT);
            zza(sb, i, "limited_ad_tracking", (Object) zze.atK);
            zza(sb, i, "os_version", (Object) zze.zzct);
            zza(sb, i, "device_model", (Object) zze.atE);
            zza(sb, i, "user_default_language", (Object) zze.atF);
            zza(sb, i, "time_zone_offset_minutes", (Object) zze.atG);
            zza(sb, i, "bundle_sequential_index", (Object) zze.atN);
            zza(sb, i, "service_upload", (Object) zze.atO);
            zza(sb, i, "health_monitor", (Object) zze.anU);
            zza(sb, i, zze.atx);
            zza(sb, i, zze.atP);
            zza(sb, i, zze.atw);
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, zzvk.zzd zzd) {
        if (zzd != null) {
            zza(sb, i);
            sb.append(str);
            sb.append(" {\n");
            if (zzd.asO != null) {
                String str2 = "UNKNOWN_COMPARISON_TYPE";
                switch (zzd.asO.intValue()) {
                    case 1:
                        str2 = "LESS_THAN";
                        break;
                    case 2:
                        str2 = "GREATER_THAN";
                        break;
                    case 3:
                        str2 = "EQUAL";
                        break;
                    case 4:
                        str2 = "BETWEEN";
                        break;
                }
                zza(sb, i, "comparison_type", (Object) str2);
            }
            zza(sb, i, "match_as_float", (Object) zzd.asP);
            zza(sb, i, "comparison_value", (Object) zzd.asQ);
            zza(sb, i, "min_comparison_value", (Object) zzd.asR);
            zza(sb, i, "max_comparison_value", (Object) zzd.asS);
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, zzvk.zzf zzf) {
        if (zzf != null) {
            zza(sb, i);
            sb.append(str);
            sb.append(" {\n");
            if (zzf.asW != null) {
                String str2 = "UNKNOWN_MATCH_TYPE";
                switch (zzf.asW.intValue()) {
                    case 1:
                        str2 = "REGEXP";
                        break;
                    case 2:
                        str2 = "BEGINS_WITH";
                        break;
                    case 3:
                        str2 = "ENDS_WITH";
                        break;
                    case 4:
                        str2 = "PARTIAL";
                        break;
                    case 5:
                        str2 = "EXACT";
                        break;
                    case 6:
                        str2 = "IN_LIST";
                        break;
                }
                zza(sb, i, "match_type", (Object) str2);
            }
            zza(sb, i, "expression", (Object) zzf.asX);
            zza(sb, i, "case_sensitive", (Object) zzf.asY);
            if (zzf.asZ.length > 0) {
                zza(sb, i + 1);
                sb.append("expression_list {\n");
                for (String append : zzf.asZ) {
                    zza(sb, i + 2);
                    sb.append(append);
                    sb.append("\n");
                }
                sb.append("}\n");
            }
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, zzvm.zzf zzf) {
        int i2 = 0;
        if (zzf != null) {
            int i3 = i + 1;
            zza(sb, i3);
            sb.append(str);
            sb.append(" {\n");
            if (zzf.atV != null) {
                zza(sb, i3 + 1);
                sb.append("results: ");
                long[] jArr = zzf.atV;
                int length = jArr.length;
                int i4 = 0;
                int i5 = 0;
                while (i4 < length) {
                    Long valueOf = Long.valueOf(jArr[i4]);
                    int i6 = i5 + 1;
                    if (i5 != 0) {
                        sb.append(", ");
                    }
                    sb.append(valueOf);
                    i4++;
                    i5 = i6;
                }
                sb.append(10);
            }
            if (zzf.atU != null) {
                zza(sb, i3 + 1);
                sb.append("status: ");
                long[] jArr2 = zzf.atU;
                int length2 = jArr2.length;
                int i7 = 0;
                while (i2 < length2) {
                    Long valueOf2 = Long.valueOf(jArr2[i2]);
                    int i8 = i7 + 1;
                    if (i7 != 0) {
                        sb.append(", ");
                    }
                    sb.append(valueOf2);
                    i2++;
                    i7 = i8;
                }
                sb.append(10);
            }
            zza(sb, i3);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj != null) {
            zza(sb, i + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(10);
        }
    }

    private static void zza(StringBuilder sb, int i, zzvm.zza[] zzaArr) {
        if (zzaArr != null) {
            int i2 = i + 1;
            for (zzvm.zza zza : zzaArr) {
                if (zza != null) {
                    zza(sb, i2);
                    sb.append("audience_membership {\n");
                    zza(sb, i2, "audience_id", (Object) zza.asA);
                    zza(sb, i2, "new_audience", (Object) zza.atm);
                    zza(sb, i2, "current_data", zza.atk);
                    zza(sb, i2, "previous_data", zza.atl);
                    zza(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    private static void zza(StringBuilder sb, int i, zzvm.zzb[] zzbArr) {
        if (zzbArr != null) {
            int i2 = i + 1;
            for (zzvm.zzb zzb : zzbArr) {
                if (zzb != null) {
                    zza(sb, i2);
                    sb.append("event {\n");
                    zza(sb, i2, "name", (Object) zzb.name);
                    zza(sb, i2, "timestamp_millis", (Object) zzb.atp);
                    zza(sb, i2, "previous_timestamp_millis", (Object) zzb.atq);
                    zza(sb, i2, "count", (Object) zzb.count);
                    zza(sb, i2, zzb.ato);
                    zza(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    private static void zza(StringBuilder sb, int i, zzvm.zzc[] zzcArr) {
        if (zzcArr != null) {
            int i2 = i + 1;
            for (zzvm.zzc zzc : zzcArr) {
                if (zzc != null) {
                    zza(sb, i2);
                    sb.append("param {\n");
                    zza(sb, i2, "name", (Object) zzc.name);
                    zza(sb, i2, "string_value", (Object) zzc.f2261Dr);
                    zza(sb, i2, "int_value", (Object) zzc.ats);
                    zza(sb, i2, "double_value", (Object) zzc.asx);
                    zza(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    private static void zza(StringBuilder sb, int i, zzvm.zzg[] zzgArr) {
        if (zzgArr != null) {
            int i2 = i + 1;
            for (zzvm.zzg zzg : zzgArr) {
                if (zzg != null) {
                    zza(sb, i2);
                    sb.append("user_property {\n");
                    zza(sb, i2, "set_timestamp_millis", (Object) zzg.atX);
                    zza(sb, i2, "name", (Object) zzg.name);
                    zza(sb, i2, "string_value", (Object) zzg.f2262Dr);
                    zza(sb, i2, "int_value", (Object) zzg.ats);
                    zza(sb, i2, "double_value", (Object) zzg.asx);
                    zza(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    public static boolean zza(Context context, String str, boolean z) {
        ActivityInfo receiverInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, str), 2)) == null || !receiverInfo.enabled) {
                return false;
            }
            return !z || receiverInfo.exported;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static boolean zza(long[] jArr, int i) {
        return i < jArr.length * 64 && (jArr[i / 64] & (1 << (i % 64))) != 0;
    }

    public static long[] zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        long[] jArr = new long[length];
        int i = 0;
        while (i < length) {
            jArr[i] = 0;
            int i2 = 0;
            while (i2 < 64 && (i * 64) + i2 < bitSet.length()) {
                if (bitSet.get((i * 64) + i2)) {
                    jArr[i] = jArr[i] | (1 << i2);
                }
                i2++;
            }
            i++;
        }
        return jArr;
    }

    public static String zzb(zzvm.zzd zzd) {
        if (zzd == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        if (zzd.att != null) {
            for (zzvm.zze zze : zzd.att) {
                if (zze != null) {
                    zza(sb, 1, zze);
                }
            }
        }
        sb.append("}\n");
        return sb.toString();
    }

    public static boolean zzbb(String str, String str2) {
        if (str == null && str2 == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        return str.equals(str2);
    }

    static MessageDigest zzfi(String str) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                return null;
            }
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                if (instance != null) {
                    return instance;
                }
                i = i2 + 1;
            } catch (NoSuchAlgorithmException e) {
            }
        }
    }

    static boolean zzmx(String str) {
        zzac.zzhz(str);
        return str.charAt(0) != '_';
    }

    private int zzng(String str) {
        return "_ldl".equals(str) ? zzbvi().zzbtt() : zzbvi().zzbts();
    }

    public static boolean zznh(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    static boolean zznj(String str) {
        return str != null && str.matches("(\\+|-)?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r1 = r1.getServiceInfo(new android.content.ComponentName(r4, r5), 4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean zzq(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = 0
            android.content.pm.PackageManager r1 = r4.getPackageManager()     // Catch:{ NameNotFoundException -> 0x001a }
            if (r1 != 0) goto L_0x0008
        L_0x0007:
            return r0
        L_0x0008:
            android.content.ComponentName r2 = new android.content.ComponentName     // Catch:{ NameNotFoundException -> 0x001a }
            r2.<init>(r4, r5)     // Catch:{ NameNotFoundException -> 0x001a }
            r3 = 4
            android.content.pm.ServiceInfo r1 = r1.getServiceInfo(r2, r3)     // Catch:{ NameNotFoundException -> 0x001a }
            if (r1 == 0) goto L_0x0007
            boolean r1 = r1.enabled     // Catch:{ NameNotFoundException -> 0x001a }
            if (r1 == 0) goto L_0x0007
            r0 = 1
            goto L_0x0007
        L_0x001a:
            r1 = move-exception
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzal.zzq(android.content.Context, java.lang.String):boolean");
    }

    static long zzx(byte[] bArr) {
        int i = 0;
        zzac.zzy(bArr);
        zzac.zzbr(bArr.length > 0);
        long j = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j += (((long) bArr[length]) & 255) << i;
            i += 8;
            length--;
        }
        return j;
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public Bundle zza(String str, Bundle bundle, @Nullable List<String> list, boolean z) {
        int i;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int zzbtm = zzbvi().zzbtm();
        int i2 = 0;
        for (String str2 : bundle.keySet()) {
            if (list == null || !list.contains(str2)) {
                i = z ? zznc(str2) : 0;
                if (i == 0) {
                    i = zznd(str2);
                }
            } else {
                i = 0;
            }
            if (i != 0) {
                if (zzd(bundle2, i)) {
                    bundle2.putString("_ev", zza(str2, zzbvi().zzbtp(), true));
                    if (i == 3) {
                        zzb(bundle2, str2);
                    }
                }
                bundle2.remove(str2);
            } else if (!zzk(str2, bundle.get(str2)) && !"_ev".equals(str2)) {
                if (zzd(bundle2, 4)) {
                    bundle2.putString("_ev", zza(str2, zzbvi().zzbtp(), true));
                    zzb(bundle2, bundle.get(str2));
                }
                bundle2.remove(str2);
            } else if (!zzmx(str2) || (i2 = i2 + 1) <= zzbtm) {
                i2 = i2;
            } else {
                zzbvg().zzbwc().zze(new StringBuilder(48).append("Event can't contain more then ").append(zzbtm).append(" params").toString(), str, bundle);
                zzd(bundle2, 5);
                bundle2.remove(str2);
            }
        }
        return bundle2;
    }

    public String zza(String str, int i, boolean z) {
        if (str.length() <= i) {
            return str;
        }
        if (z) {
            return String.valueOf(str.substring(0, i)).concat("...");
        }
        return null;
    }

    public void zza(int i, String str, String str2, int i2) {
        Bundle bundle = new Bundle();
        zzd(bundle, i);
        if (!TextUtils.isEmpty(str)) {
            bundle.putString(str, str2);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        this.anq.zzbux().zzf("auto", "_err", bundle);
    }

    public void zza(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (str != null) {
                zzbvg().zzbwg().zze("Not putting event parameter. Invalid value type. name, type", str, obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public void zza(zzvm.zzc zzc, Object obj) {
        zzac.zzy(obj);
        zzc.f2261Dr = null;
        zzc.ats = null;
        zzc.asx = null;
        if (obj instanceof String) {
            zzc.f2261Dr = (String) obj;
        } else if (obj instanceof Long) {
            zzc.ats = (Long) obj;
        } else if (obj instanceof Double) {
            zzc.asx = (Double) obj;
        } else {
            zzbvg().zzbwc().zzj("Ignoring invalid (type) event param value", obj);
        }
    }

    public void zza(zzvm.zzg zzg, Object obj) {
        zzac.zzy(obj);
        zzg.f2262Dr = null;
        zzg.ats = null;
        zzg.asx = null;
        if (obj instanceof String) {
            zzg.f2262Dr = (String) obj;
        } else if (obj instanceof Long) {
            zzg.ats = (Long) obj;
        } else if (obj instanceof Double) {
            zzg.asx = (Double) obj;
        } else {
            zzbvg().zzbwc().zzj("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zza(String str, String str2, int i, Object obj) {
        if (obj == null || (obj instanceof Long) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short) || (obj instanceof Boolean) || (obj instanceof Double)) {
            return true;
        }
        if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
            return false;
        }
        String valueOf = String.valueOf(obj);
        if (valueOf.length() <= i) {
            return true;
        }
        zzbvg().zzbwe().zzd("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
        return false;
    }

    public byte[] zza(zzvm.zzd zzd) {
        try {
            byte[] bArr = new byte[zzd.mo9192db()];
            zzard zzbe = zzard.zzbe(bArr);
            zzd.zza(zzbe);
            zzbe.mo9123cO();
            return bArr;
        } catch (IOException e) {
            zzbvg().zzbwc().zzj("Data loss. Failed to serialize batch", e);
            return null;
        }
    }

    public /* bridge */ /* synthetic */ void zzaam() {
        super.zzaam();
    }

    public /* bridge */ /* synthetic */ zze zzaan() {
        return super.zzaan();
    }

    /* access modifiers changed from: package-private */
    public boolean zzaz(String str, String str2) {
        if (str2 == null) {
            zzbvg().zzbwc().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzbvg().zzbwc().zzj("Name is required and can't be empty. Type", str);
            return false;
        } else if (!Character.isLetter(str2.charAt(0))) {
            zzbvg().zzbwc().zze("Name must start with a letter. Type, name", str, str2);
            return false;
        } else {
            int i = 1;
            while (i < str2.length()) {
                char charAt = str2.charAt(i);
                if (charAt == '_' || Character.isLetterOrDigit(charAt)) {
                    i++;
                } else {
                    zzbvg().zzbwc().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    public void zzb(Bundle bundle, Object obj) {
        zzac.zzy(bundle);
        if (obj == null) {
            return;
        }
        if ((obj instanceof String) || (obj instanceof CharSequence)) {
            bundle.putLong("_el", (long) String.valueOf(obj).length());
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzba(String str, String str2) {
        if (str2 == null) {
            zzbvg().zzbwc().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzbvg().zzbwc().zzj("Name is required and can't be empty. Type", str);
            return false;
        } else {
            char charAt = str2.charAt(0);
            if (Character.isLetter(charAt) || charAt == '_') {
                int i = 1;
                while (i < str2.length()) {
                    char charAt2 = str2.charAt(i);
                    if (charAt2 == '_' || Character.isLetterOrDigit(charAt2)) {
                        i++;
                    } else {
                        zzbvg().zzbwc().zze("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            zzbvg().zzbwc().zze("Name must start with a letter or _ (underscores). Type, name", str, str2);
            return false;
        }
    }

    public /* bridge */ /* synthetic */ void zzbuv() {
        super.zzbuv();
    }

    public /* bridge */ /* synthetic */ zzc zzbuw() {
        return super.zzbuw();
    }

    public /* bridge */ /* synthetic */ zzac zzbux() {
        return super.zzbux();
    }

    public /* bridge */ /* synthetic */ zzn zzbuy() {
        return super.zzbuy();
    }

    public /* bridge */ /* synthetic */ zzg zzbuz() {
        return super.zzbuz();
    }

    public /* bridge */ /* synthetic */ zzad zzbva() {
        return super.zzbva();
    }

    public /* bridge */ /* synthetic */ zze zzbvb() {
        return super.zzbvb();
    }

    public /* bridge */ /* synthetic */ zzal zzbvc() {
        return super.zzbvc();
    }

    public /* bridge */ /* synthetic */ zzv zzbvd() {
        return super.zzbvd();
    }

    public /* bridge */ /* synthetic */ zzaf zzbve() {
        return super.zzbve();
    }

    public /* bridge */ /* synthetic */ zzw zzbvf() {
        return super.zzbvf();
    }

    public /* bridge */ /* synthetic */ zzp zzbvg() {
        return super.zzbvg();
    }

    public /* bridge */ /* synthetic */ zzt zzbvh() {
        return super.zzbvh();
    }

    public /* bridge */ /* synthetic */ zzd zzbvi() {
        return super.zzbvi();
    }

    /* access modifiers changed from: package-private */
    public boolean zzc(String str, int i, String str2) {
        if (str2 == null) {
            zzbvg().zzbwc().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() <= i) {
            return true;
        } else {
            zzbvg().zzbwc().zzd("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zzc(String str, Map<String, String> map, String str2) {
        if (str2 == null) {
            zzbvg().zzbwc().zzj("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.startsWith("firebase_")) {
            zzbvg().zzbwc().zze("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        } else if (map == null || !map.containsKey(str2)) {
            return true;
        } else {
            zzbvg().zzbwc().zze("Name is reserved. Type, name", str, str2);
            return false;
        }
    }

    public boolean zzd(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    @WorkerThread
    public boolean zzew(String str) {
        zzyl();
        if (getContext().checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzbvg().zzbwi().zzj("Permission not granted", str);
        return false;
    }

    public boolean zzg(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(zzaan().currentTimeMillis() - j) > j2;
    }

    public byte[] zzj(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzbvg().zzbwc().zzj("Failed to gzip content", e);
            throw e;
        }
    }

    public boolean zzk(String str, Object obj) {
        return zznh(str) ? zza("param", str, zzbvi().zzbtr(), obj) : zza("param", str, zzbvi().zzbtq(), obj);
    }

    public Object zzl(String str, Object obj) {
        if ("_ev".equals(str)) {
            return zza(zzbvi().zzbtr(), obj, true);
        }
        return zza(zznh(str) ? zzbvi().zzbtr() : zzbvi().zzbtq(), obj, false);
    }

    public int zzm(String str, Object obj) {
        return "_ldl".equals(str) ? zza("user property referrer", str, zzng(str), obj) : zza("user property", str, zzng(str), obj) ? 0 : 7;
    }

    public int zzmy(String str) {
        if (!zzaz("event", str)) {
            return 2;
        }
        if (!zzc("event", AppMeasurement.zza.anr, str)) {
            return 13;
        }
        return zzc("event", zzbvi().zzbtn(), str) ? 0 : 2;
    }

    public int zzmz(String str) {
        if (!zzba("event", str)) {
            return 2;
        }
        if (!zzc("event", AppMeasurement.zza.anr, str)) {
            return 13;
        }
        return zzc("event", zzbvi().zzbtn(), str) ? 0 : 2;
    }

    public Object zzn(String str, Object obj) {
        return "_ldl".equals(str) ? zza(zzng(str), obj, true) : zza(zzng(str), obj, false);
    }

    public int zzna(String str) {
        if (!zzaz("user property", str)) {
            return 6;
        }
        if (!zzc("user property", AppMeasurement.zze.ant, str)) {
            return 15;
        }
        return zzc("user property", zzbvi().zzbto(), str) ? 0 : 6;
    }

    public int zznb(String str) {
        if (!zzba("user property", str)) {
            return 6;
        }
        if (!zzc("user property", AppMeasurement.zze.ant, str)) {
            return 15;
        }
        return zzc("user property", zzbvi().zzbto(), str) ? 0 : 6;
    }

    public int zznc(String str) {
        if (!zzaz("event param", str)) {
            return 3;
        }
        if (!zzc("event param", (Map<String, String>) null, str)) {
            return 14;
        }
        return zzc("event param", zzbvi().zzbtp(), str) ? 0 : 3;
    }

    public int zznd(String str) {
        if (!zzba("event param", str)) {
            return 3;
        }
        if (!zzc("event param", (Map<String, String>) null, str)) {
            return 14;
        }
        return zzc("event param", zzbvi().zzbtp(), str) ? 0 : 3;
    }

    public boolean zzne(String str) {
        if (TextUtils.isEmpty(str)) {
            zzbvg().zzbwc().log("Measurement Service called without google_app_id");
            return false;
        } else if (!str.startsWith("1:")) {
            zzbvg().zzbwe().zzj("Measurement Service called with unknown id version", str);
            return true;
        } else if (zznf(str)) {
            return true;
        } else {
            zzbvg().zzbwc().zzj("Invalid google_app_id. Firebase Analytics disabled. See", "https://goo.gl/FZRIUV");
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean zznf(String str) {
        zzac.zzy(str);
        return str.matches("^1:\\d+:android:[a-f0-9]+$");
    }

    public boolean zzni(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return zzbvi().zzbuu().equals(str);
    }

    public Bundle zzt(@NonNull Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        Bundle bundle = null;
        if (uri != null) {
            try {
                if (uri.isHierarchical()) {
                    str4 = uri.getQueryParameter("utm_campaign");
                    str3 = uri.getQueryParameter("utm_source");
                    str2 = uri.getQueryParameter("utm_medium");
                    str = uri.getQueryParameter("gclid");
                } else {
                    str = null;
                    str2 = null;
                    str3 = null;
                    str4 = null;
                }
                if (!TextUtils.isEmpty(str4) || !TextUtils.isEmpty(str3) || !TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str)) {
                    bundle = new Bundle();
                    if (!TextUtils.isEmpty(str4)) {
                        bundle.putString("campaign", str4);
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        bundle.putString("source", str3);
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        bundle.putString("medium", str2);
                    }
                    if (!TextUtils.isEmpty(str)) {
                        bundle.putString("gclid", str);
                    }
                    String queryParameter = uri.getQueryParameter("utm_term");
                    if (!TextUtils.isEmpty(queryParameter)) {
                        bundle.putString("term", queryParameter);
                    }
                    String queryParameter2 = uri.getQueryParameter("utm_content");
                    if (!TextUtils.isEmpty(queryParameter2)) {
                        bundle.putString(AppLovinEventTypes.USER_VIEWED_CONTENT, queryParameter2);
                    }
                    String queryParameter3 = uri.getQueryParameter("aclid");
                    if (!TextUtils.isEmpty(queryParameter3)) {
                        bundle.putString("aclid", queryParameter3);
                    }
                    String queryParameter4 = uri.getQueryParameter("cp1");
                    if (!TextUtils.isEmpty(queryParameter4)) {
                        bundle.putString("cp1", queryParameter4);
                    }
                    String queryParameter5 = uri.getQueryParameter("anid");
                    if (!TextUtils.isEmpty(queryParameter5)) {
                        bundle.putString("anid", queryParameter5);
                    }
                }
            } catch (UnsupportedOperationException e) {
                zzbvg().zzbwe().zzj("Install referrer url isn't a hierarchical URI", e);
            }
        }
        return bundle;
    }

    public byte[] zzw(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
        } catch (IOException e) {
            zzbvg().zzbwc().zzj("Failed to ungzip content", e);
            throw e;
        }
    }

    public long zzy(byte[] bArr) {
        zzac.zzy(bArr);
        MessageDigest zzfi = zzfi("MD5");
        if (zzfi != null) {
            return zzx(zzfi.digest(bArr));
        }
        zzbvg().zzbwc().log("Failed to get MD5");
        return 0;
    }

    public /* bridge */ /* synthetic */ void zzyl() {
        super.zzyl();
    }
}
