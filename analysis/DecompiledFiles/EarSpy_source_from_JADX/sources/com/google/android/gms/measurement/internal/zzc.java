package com.google.android.gms.measurement.internal;

import android.support.annotation.WorkerThread;
import android.support.p000v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzvk;
import com.google.android.gms.internal.zzvm;
import com.google.android.gms.measurement.AppMeasurement;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class zzc extends zzaa {
    zzc(zzx zzx) {
        super(zzx);
    }

    private Boolean zza(zzvk.zzb zzb, zzvm.zzb zzb2, long j) {
        if (zzb.asI != null) {
            Boolean zzbn = new zzs(zzb.asI).zzbn(j);
            if (zzbn == null) {
                return null;
            }
            if (!zzbn.booleanValue()) {
                return false;
            }
        }
        HashSet hashSet = new HashSet();
        for (zzvk.zzc zzc : zzb.asG) {
            if (TextUtils.isEmpty(zzc.asN)) {
                zzbvg().zzbwe().zzj("null or empty param name in filter. event", zzb2.name);
                return null;
            }
            hashSet.add(zzc.asN);
        }
        ArrayMap arrayMap = new ArrayMap();
        for (zzvm.zzc zzc2 : zzb2.ato) {
            if (hashSet.contains(zzc2.name)) {
                if (zzc2.ats != null) {
                    arrayMap.put(zzc2.name, zzc2.ats);
                } else if (zzc2.asx != null) {
                    arrayMap.put(zzc2.name, zzc2.asx);
                } else if (zzc2.f2261Dr != null) {
                    arrayMap.put(zzc2.name, zzc2.f2261Dr);
                } else {
                    zzbvg().zzbwe().zze("Unknown value for param. event, param", zzb2.name, zzc2.name);
                    return null;
                }
            }
        }
        for (zzvk.zzc zzc3 : zzb.asG) {
            boolean equals = Boolean.TRUE.equals(zzc3.asM);
            String str = zzc3.asN;
            if (TextUtils.isEmpty(str)) {
                zzbvg().zzbwe().zzj("Event has empty param name. event", zzb2.name);
                return null;
            }
            Object obj = arrayMap.get(str);
            if (obj instanceof Long) {
                if (zzc3.asL == null) {
                    zzbvg().zzbwe().zze("No number filter for long param. event, param", zzb2.name, str);
                    return null;
                }
                Boolean zzbn2 = new zzs(zzc3.asL).zzbn(((Long) obj).longValue());
                if (zzbn2 == null) {
                    return null;
                }
                if ((!zzbn2.booleanValue()) ^ equals) {
                    return false;
                }
            } else if (obj instanceof Double) {
                if (zzc3.asL == null) {
                    zzbvg().zzbwe().zze("No number filter for double param. event, param", zzb2.name, str);
                    return null;
                }
                Boolean zzj = new zzs(zzc3.asL).zzj(((Double) obj).doubleValue());
                if (zzj == null) {
                    return null;
                }
                if ((!zzj.booleanValue()) ^ equals) {
                    return false;
                }
            } else if (obj instanceof String) {
                if (zzc3.asK == null) {
                    zzbvg().zzbwe().zze("No string filter for String param. event, param", zzb2.name, str);
                    return null;
                }
                Boolean zzmw = new zzag(zzc3.asK).zzmw((String) obj);
                if (zzmw == null) {
                    return null;
                }
                if ((!zzmw.booleanValue()) ^ equals) {
                    return false;
                }
            } else if (obj == null) {
                zzbvg().zzbwj().zze("Missing param for filter. event, param", zzb2.name, str);
                return false;
            } else {
                zzbvg().zzbwe().zze("Unknown param type. event, param", zzb2.name, str);
                return null;
            }
        }
        return true;
    }

    private Boolean zza(zzvk.zze zze, zzvm.zzg zzg) {
        zzvk.zzc zzc = zze.asV;
        if (zzc == null) {
            zzbvg().zzbwe().zzj("Missing property filter. property", zzg.name);
            return null;
        }
        boolean equals = Boolean.TRUE.equals(zzc.asM);
        if (zzg.ats != null) {
            if (zzc.asL != null) {
                return zza(new zzs(zzc.asL).zzbn(zzg.ats.longValue()), equals);
            }
            zzbvg().zzbwe().zzj("No number filter for long property. property", zzg.name);
            return null;
        } else if (zzg.asx != null) {
            if (zzc.asL != null) {
                return zza(new zzs(zzc.asL).zzj(zzg.asx.doubleValue()), equals);
            }
            zzbvg().zzbwe().zzj("No number filter for double property. property", zzg.name);
            return null;
        } else if (zzg.f2262Dr == null) {
            zzbvg().zzbwe().zzj("User property has no value, property", zzg.name);
            return null;
        } else if (zzc.asK != null) {
            return zza(new zzag(zzc.asK).zzmw(zzg.f2262Dr), equals);
        } else {
            if (zzc.asL == null) {
                zzbvg().zzbwe().zzj("No string or number filter defined. property", zzg.name);
                return null;
            }
            zzs zzs = new zzs(zzc.asL);
            if (zzal.zznj(zzg.f2262Dr)) {
                return zza(zzs.zzmk(zzg.f2262Dr), equals);
            }
            zzbvg().zzbwe().zze("Invalid user property value for Numeric number filter. property, value", zzg.name, zzg.f2262Dr);
            return null;
        }
    }

    static Boolean zza(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() ^ z);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zza(String str, zzvk.zza[] zzaArr) {
        zzac.zzy(zzaArr);
        for (zzvk.zza zza : zzaArr) {
            for (zzvk.zzb zzb : zza.asC) {
                String str2 = AppMeasurement.zza.anr.get(zzb.asF);
                if (str2 != null) {
                    zzb.asF = str2;
                }
                for (zzvk.zzc zzc : zzb.asG) {
                    String str3 = AppMeasurement.zzd.ans.get(zzc.asN);
                    if (str3 != null) {
                        zzc.asN = str3;
                    }
                }
            }
            for (zzvk.zze zze : zza.asB) {
                String str4 = AppMeasurement.zze.ant.get(zze.asU);
                if (str4 != null) {
                    zze.asU = str4;
                }
            }
        }
        zzbvb().zzb(str, zzaArr);
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public zzvm.zza[] zza(String str, zzvm.zzb[] zzbArr, zzvm.zzg[] zzgArr) {
        Map map;
        zzvk.zze zze;
        zzi zzbvy;
        Map map2;
        zzac.zzhz(str);
        HashSet hashSet = new HashSet();
        ArrayMap arrayMap = new ArrayMap();
        ArrayMap arrayMap2 = new ArrayMap();
        ArrayMap arrayMap3 = new ArrayMap();
        Map<Integer, zzvm.zzf> zzmd = zzbvb().zzmd(str);
        if (zzmd != null) {
            for (Integer intValue : zzmd.keySet()) {
                int intValue2 = intValue.intValue();
                zzvm.zzf zzf = zzmd.get(Integer.valueOf(intValue2));
                BitSet bitSet = (BitSet) arrayMap2.get(Integer.valueOf(intValue2));
                BitSet bitSet2 = (BitSet) arrayMap3.get(Integer.valueOf(intValue2));
                if (bitSet == null) {
                    bitSet = new BitSet();
                    arrayMap2.put(Integer.valueOf(intValue2), bitSet);
                    bitSet2 = new BitSet();
                    arrayMap3.put(Integer.valueOf(intValue2), bitSet2);
                }
                for (int i = 0; i < zzf.atU.length * 64; i++) {
                    if (zzal.zza(zzf.atU, i)) {
                        zzbvg().zzbwj().zze("Filter already evaluated. audience ID, filter ID", Integer.valueOf(intValue2), Integer.valueOf(i));
                        bitSet2.set(i);
                        if (zzal.zza(zzf.atV, i)) {
                            bitSet.set(i);
                        }
                    }
                }
                zzvm.zza zza = new zzvm.zza();
                arrayMap.put(Integer.valueOf(intValue2), zza);
                zza.atm = false;
                zza.atl = zzf;
                zza.atk = new zzvm.zzf();
                zza.atk.atV = zzal.zza(bitSet);
                zza.atk.atU = zzal.zza(bitSet2);
            }
        }
        if (zzbArr != null) {
            ArrayMap arrayMap4 = new ArrayMap();
            int length = zzbArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                }
                zzvm.zzb zzb = zzbArr[i3];
                zzi zzaq = zzbvb().zzaq(str, zzb.name);
                if (zzaq == null) {
                    zzbvg().zzbwe().zzj("Event aggregate wasn't created during raw event logging. event", zzb.name);
                    zzbvy = new zzi(str, zzb.name, 1, 1, zzb.atp.longValue());
                } else {
                    zzbvy = zzaq.zzbvy();
                }
                zzbvb().zza(zzbvy);
                long j = zzbvy.aot;
                Map map3 = (Map) arrayMap4.get(zzb.name);
                if (map3 == null) {
                    Map zzat = zzbvb().zzat(str, zzb.name);
                    if (zzat == null) {
                        zzat = new ArrayMap();
                    }
                    arrayMap4.put(zzb.name, zzat);
                    map2 = zzat;
                } else {
                    map2 = map3;
                }
                for (Integer intValue3 : map2.keySet()) {
                    int intValue4 = intValue3.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue4))) {
                        zzbvg().zzbwj().zzj("Skipping failed audience ID", Integer.valueOf(intValue4));
                    } else {
                        zzvm.zza zza2 = (zzvm.zza) arrayMap.get(Integer.valueOf(intValue4));
                        BitSet bitSet3 = (BitSet) arrayMap2.get(Integer.valueOf(intValue4));
                        BitSet bitSet4 = (BitSet) arrayMap3.get(Integer.valueOf(intValue4));
                        if (zza2 == null) {
                            zzvm.zza zza3 = new zzvm.zza();
                            arrayMap.put(Integer.valueOf(intValue4), zza3);
                            zza3.atm = true;
                            bitSet3 = new BitSet();
                            arrayMap2.put(Integer.valueOf(intValue4), bitSet3);
                            bitSet4 = new BitSet();
                            arrayMap3.put(Integer.valueOf(intValue4), bitSet4);
                        }
                        for (zzvk.zzb zzb2 : (List) map2.get(Integer.valueOf(intValue4))) {
                            if (zzbvg().zzbf(2)) {
                                zzbvg().zzbwj().zzd("Evaluating filter. audience, filter, event", Integer.valueOf(intValue4), zzb2.asE, zzb2.asF);
                                zzbvg().zzbwj().zzj("Filter definition", zzal.zza(zzb2));
                            }
                            if (zzb2.asE == null || zzb2.asE.intValue() > 256) {
                                zzbvg().zzbwe().zzj("Invalid event filter ID. id", String.valueOf(zzb2.asE));
                            } else if (bitSet3.get(zzb2.asE.intValue())) {
                                zzbvg().zzbwj().zze("Event filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue4), zzb2.asE);
                            } else {
                                Boolean zza4 = zza(zzb2, zzb, j);
                                zzbvg().zzbwj().zzj("Event filter result", zza4 == null ? "null" : zza4);
                                if (zza4 == null) {
                                    hashSet.add(Integer.valueOf(intValue4));
                                } else {
                                    bitSet4.set(zzb2.asE.intValue());
                                    if (zza4.booleanValue()) {
                                        bitSet3.set(zzb2.asE.intValue());
                                    }
                                }
                            }
                        }
                    }
                }
                i2 = i3 + 1;
            }
        }
        if (zzgArr != null) {
            ArrayMap arrayMap5 = new ArrayMap();
            for (zzvm.zzg zzg : zzgArr) {
                Map map4 = (Map) arrayMap5.get(zzg.name);
                if (map4 == null) {
                    Map zzau = zzbvb().zzau(str, zzg.name);
                    if (zzau == null) {
                        zzau = new ArrayMap();
                    }
                    arrayMap5.put(zzg.name, zzau);
                    map = zzau;
                } else {
                    map = map4;
                }
                for (Integer intValue5 : map.keySet()) {
                    int intValue6 = intValue5.intValue();
                    if (hashSet.contains(Integer.valueOf(intValue6))) {
                        zzbvg().zzbwj().zzj("Skipping failed audience ID", Integer.valueOf(intValue6));
                    } else {
                        zzvm.zza zza5 = (zzvm.zza) arrayMap.get(Integer.valueOf(intValue6));
                        BitSet bitSet5 = (BitSet) arrayMap2.get(Integer.valueOf(intValue6));
                        BitSet bitSet6 = (BitSet) arrayMap3.get(Integer.valueOf(intValue6));
                        if (zza5 == null) {
                            zzvm.zza zza6 = new zzvm.zza();
                            arrayMap.put(Integer.valueOf(intValue6), zza6);
                            zza6.atm = true;
                            bitSet5 = new BitSet();
                            arrayMap2.put(Integer.valueOf(intValue6), bitSet5);
                            bitSet6 = new BitSet();
                            arrayMap3.put(Integer.valueOf(intValue6), bitSet6);
                        }
                        Iterator it = ((List) map.get(Integer.valueOf(intValue6))).iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            zze = (zzvk.zze) it.next();
                            if (zzbvg().zzbf(2)) {
                                zzbvg().zzbwj().zzd("Evaluating filter. audience, filter, property", Integer.valueOf(intValue6), zze.asE, zze.asU);
                                zzbvg().zzbwj().zzj("Filter definition", zzal.zza(zze));
                            }
                            if (zze.asE == null || zze.asE.intValue() > 256) {
                                zzbvg().zzbwe().zzj("Invalid property filter ID. id", String.valueOf(zze.asE));
                                hashSet.add(Integer.valueOf(intValue6));
                            } else if (bitSet5.get(zze.asE.intValue())) {
                                zzbvg().zzbwj().zze("Property filter already evaluated true. audience ID, filter ID", Integer.valueOf(intValue6), zze.asE);
                            } else {
                                Boolean zza7 = zza(zze, zzg);
                                zzbvg().zzbwj().zzj("Property filter result", zza7 == null ? "null" : zza7);
                                if (zza7 == null) {
                                    hashSet.add(Integer.valueOf(intValue6));
                                } else {
                                    bitSet6.set(zze.asE.intValue());
                                    if (zza7.booleanValue()) {
                                        bitSet5.set(zze.asE.intValue());
                                    }
                                }
                            }
                        }
                        zzbvg().zzbwe().zzj("Invalid property filter ID. id", String.valueOf(zze.asE));
                        hashSet.add(Integer.valueOf(intValue6));
                    }
                }
            }
        }
        zzvm.zza[] zzaArr = new zzvm.zza[arrayMap2.size()];
        int i4 = 0;
        for (Integer intValue7 : arrayMap2.keySet()) {
            int intValue8 = intValue7.intValue();
            if (!hashSet.contains(Integer.valueOf(intValue8))) {
                zzvm.zza zza8 = (zzvm.zza) arrayMap.get(Integer.valueOf(intValue8));
                if (zza8 == null) {
                    zza8 = new zzvm.zza();
                }
                zzvm.zza zza9 = zza8;
                zzaArr[i4] = zza9;
                zza9.asA = Integer.valueOf(intValue8);
                zza9.atk = new zzvm.zzf();
                zza9.atk.atV = zzal.zza((BitSet) arrayMap2.get(Integer.valueOf(intValue8)));
                zza9.atk.atU = zzal.zza((BitSet) arrayMap3.get(Integer.valueOf(intValue8)));
                zzbvb().zza(str, intValue8, zza9.atk);
                i4++;
            }
        }
        return (zzvm.zza[]) Arrays.copyOf(zzaArr, i4);
    }

    /* access modifiers changed from: protected */
    public void zzym() {
    }
}
