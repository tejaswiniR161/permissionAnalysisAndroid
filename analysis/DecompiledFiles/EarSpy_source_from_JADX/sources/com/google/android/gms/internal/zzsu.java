package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import java.lang.reflect.Field;

public final class zzsu {

    /* renamed from: OA */
    public static final zzb f2245OA = new zzb() {
        public zzb.C1327zzb zza(Context context, String str, zzb.zza zza) {
            zzb.C1327zzb zzb = new zzb.C1327zzb();
            zzb.f2254OF = zza.zzaa(context, str);
            zzb.f2255OG = zza.zzc(context, str, true);
            if (zzb.f2254OF == 0 && zzb.f2255OG == 0) {
                zzb.f2256OH = 0;
            } else if (zzb.f2254OF >= zzb.f2255OG) {
                zzb.f2256OH = -1;
            } else {
                zzb.f2256OH = 1;
            }
            return zzb;
        }
    };

    /* renamed from: OB */
    public static final zzb f2246OB = new zzb() {
        public zzb.C1327zzb zza(Context context, String str, zzb.zza zza) {
            zzb.C1327zzb zzb = new zzb.C1327zzb();
            zzb.f2254OF = zza.zzaa(context, str);
            zzb.f2255OG = zza.zzc(context, str, true);
            if (zzb.f2254OF == 0 && zzb.f2255OG == 0) {
                zzb.f2256OH = 0;
            } else if (zzb.f2255OG >= zzb.f2254OF) {
                zzb.f2256OH = 1;
            } else {
                zzb.f2256OH = -1;
            }
            return zzb;
        }
    };

    /* renamed from: OC */
    public static final zzb f2247OC = new zzb() {
        public zzb.C1327zzb zza(Context context, String str, zzb.zza zza) {
            zzb.C1327zzb zzb = new zzb.C1327zzb();
            zzb.f2254OF = zza.zzaa(context, str);
            if (zzb.f2254OF != 0) {
                zzb.f2255OG = zza.zzc(context, str, false);
            } else {
                zzb.f2255OG = zza.zzc(context, str, true);
            }
            if (zzb.f2254OF == 0 && zzb.f2255OG == 0) {
                zzb.f2256OH = 0;
            } else if (zzb.f2255OG >= zzb.f2254OF) {
                zzb.f2256OH = 1;
            } else {
                zzb.f2256OH = -1;
            }
            return zzb;
        }
    };

    /* renamed from: Ow */
    private static zzsv f2248Ow;

    /* renamed from: Ox */
    private static final zzb.zza f2249Ox = new zzb.zza() {
        public int zzaa(Context context, String str) {
            return zzsu.zzaa(context, str);
        }

        public int zzc(Context context, String str, boolean z) {
            return zzsu.zzc(context, str, z);
        }
    };

    /* renamed from: Oy */
    public static final zzb f2250Oy = new zzb() {
        public zzb.C1327zzb zza(Context context, String str, zzb.zza zza) {
            zzb.C1327zzb zzb = new zzb.C1327zzb();
            zzb.f2255OG = zza.zzc(context, str, true);
            if (zzb.f2255OG != 0) {
                zzb.f2256OH = 1;
            } else {
                zzb.f2254OF = zza.zzaa(context, str);
                if (zzb.f2254OF != 0) {
                    zzb.f2256OH = -1;
                }
            }
            return zzb;
        }
    };

    /* renamed from: Oz */
    public static final zzb f2251Oz = new zzb() {
        public zzb.C1327zzb zza(Context context, String str, zzb.zza zza) {
            zzb.C1327zzb zzb = new zzb.C1327zzb();
            zzb.f2254OF = zza.zzaa(context, str);
            if (zzb.f2254OF != 0) {
                zzb.f2256OH = -1;
            } else {
                zzb.f2255OG = zza.zzc(context, str, true);
                if (zzb.f2255OG != 0) {
                    zzb.f2256OH = 1;
                }
            }
            return zzb;
        }
    };

    /* renamed from: OD */
    private final Context f2252OD;

    public static class zza extends Exception {
        private zza(String str) {
            super(str);
        }

        private zza(String str, Throwable th) {
            super(str, th);
        }
    }

    public interface zzb {

        public interface zza {
            int zzaa(Context context, String str);

            int zzc(Context context, String str, boolean z);
        }

        /* renamed from: com.google.android.gms.internal.zzsu$zzb$zzb  reason: collision with other inner class name */
        public static class C1327zzb {

            /* renamed from: OF */
            public int f2254OF = 0;

            /* renamed from: OG */
            public int f2255OG = 0;

            /* renamed from: OH */
            public int f2256OH = 0;
        }

        C1327zzb zza(Context context, String str, zza zza2);
    }

    private zzsu(Context context) {
        this.f2252OD = (Context) zzac.zzy(context);
    }

    public static zzsu zza(Context context, zzb zzb2, String str) throws zza {
        zzb.C1327zzb zza2 = zzb2.zza(context, str, f2249Ox);
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 68 + String.valueOf(str).length()).append("Considering local module ").append(str).append(":").append(zza2.f2254OF).append(" and remote module ").append(str).append(":").append(zza2.f2255OG).toString());
        if (zza2.f2256OH == 0 || ((zza2.f2256OH == -1 && zza2.f2254OF == 0) || (zza2.f2256OH == 1 && zza2.f2255OG == 0))) {
            throw new zza(new StringBuilder(91).append("No acceptable module found. Local version is ").append(zza2.f2254OF).append(" and remote version is ").append(zza2.f2255OG).append(".").toString());
        } else if (zza2.f2256OH == -1) {
            return zzac(context, str);
        } else {
            if (zza2.f2256OH == 1) {
                try {
                    return zza(context, str, zza2.f2255OG);
                } catch (zza e) {
                    zza zza3 = e;
                    String valueOf = String.valueOf(zza3.getMessage());
                    Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to load remote module: ".concat(valueOf) : new String("Failed to load remote module: "));
                    if (zza2.f2254OF != 0) {
                        final int i = zza2.f2254OF;
                        if (zzb2.zza(context, str, new zzb.zza() {
                            public int zzaa(Context context, String str) {
                                return i;
                            }

                            public int zzc(Context context, String str, boolean z) {
                                return 0;
                            }
                        }).f2256OH == -1) {
                            return zzac(context, str);
                        }
                    }
                    throw new zza("Remote load failed. No local fallback found.", zza3);
                }
            } else {
                throw new zza(new StringBuilder(47).append("VersionPolicy returned invalid code:").append(zza2.f2256OH).toString());
            }
        }
    }

    private static zzsu zza(Context context, String str, int i) throws zza {
        Log.i("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 51).append("Selected remote version of ").append(str).append(", version >= ").append(i).toString());
        zzsv zzcv = zzcv(context);
        if (zzcv == null) {
            throw new zza("Failed to create IDynamiteLoader.");
        }
        try {
            zzd zza2 = zzcv.zza(zze.zzac(context), str, i);
            if (zze.zzae(zza2) != null) {
                return new zzsu((Context) zze.zzae(zza2));
            }
            throw new zza("Failed to load remote module.");
        } catch (RemoteException e) {
            throw new zza("Failed to load remote module.", e);
        }
    }

    public static int zzaa(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            String valueOf = String.valueOf("com.google.android.gms.dynamite.descriptors.");
            String valueOf2 = String.valueOf("ModuleDescriptor");
            Class<?> loadClass = classLoader.loadClass(new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(str).length() + String.valueOf(valueOf2).length()).append(valueOf).append(str).append(".").append(valueOf2).toString());
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (declaredField.get((Object) null).equals(str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf3 = String.valueOf(declaredField.get((Object) null));
            Log.e("DynamiteModule", new StringBuilder(String.valueOf(valueOf3).length() + 51 + String.valueOf(str).length()).append("Module descriptor id '").append(valueOf3).append("' didn't match expected id '").append(str).append("'").toString());
            return 0;
        } catch (ClassNotFoundException e) {
            Log.w("DynamiteModule", new StringBuilder(String.valueOf(str).length() + 45).append("Local module descriptor class for ").append(str).append(" not found.").toString());
            return 0;
        } catch (Exception e2) {
            String valueOf4 = String.valueOf(e2.getMessage());
            Log.e("DynamiteModule", valueOf4.length() != 0 ? "Failed to load module descriptor class: ".concat(valueOf4) : new String("Failed to load module descriptor class: "));
            return 0;
        }
    }

    public static int zzab(Context context, String str) {
        return zzc(context, str, false);
    }

    private static zzsu zzac(Context context, String str) {
        String valueOf = String.valueOf(str);
        Log.i("DynamiteModule", valueOf.length() != 0 ? "Selected local version of ".concat(valueOf) : new String("Selected local version of "));
        return new zzsu(context.getApplicationContext());
    }

    public static int zzc(Context context, String str, boolean z) {
        zzsv zzcv = zzcv(context);
        if (zzcv == null) {
            return 0;
        }
        try {
            return zzcv.zza(zze.zzac(context), str, z);
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("DynamiteModule", valueOf.length() != 0 ? "Failed to retrieve remote module version: ".concat(valueOf) : new String("Failed to retrieve remote module version: "));
            return 0;
        }
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.gms.internal.zzsv zzcv(android.content.Context r6) {
        /*
            r1 = 0
            java.lang.Class<com.google.android.gms.internal.zzsu> r2 = com.google.android.gms.internal.zzsu.class
            monitor-enter(r2)
            com.google.android.gms.internal.zzsv r0 = f2248Ow     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x000c
            com.google.android.gms.internal.zzsv r0 = f2248Ow     // Catch:{ all -> 0x003a }
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
        L_0x000b:
            return r0
        L_0x000c:
            com.google.android.gms.common.zzc r0 = com.google.android.gms.common.zzc.zzapd()     // Catch:{ all -> 0x003a }
            int r0 = r0.isGooglePlayServicesAvailable(r6)     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0019
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            r0 = r1
            goto L_0x000b
        L_0x0019:
            java.lang.String r0 = "com.google.android.gms"
            r3 = 3
            android.content.Context r0 = r6.createPackageContext(r0, r3)     // Catch:{ Exception -> 0x003d }
            java.lang.ClassLoader r0 = r0.getClassLoader()     // Catch:{ Exception -> 0x003d }
            java.lang.String r3 = "com.google.android.gms.chimera.container.DynamiteLoaderImpl"
            java.lang.Class r0 = r0.loadClass(r3)     // Catch:{ Exception -> 0x003d }
            java.lang.Object r0 = r0.newInstance()     // Catch:{ Exception -> 0x003d }
            android.os.IBinder r0 = (android.os.IBinder) r0     // Catch:{ Exception -> 0x003d }
            com.google.android.gms.internal.zzsv r0 = com.google.android.gms.internal.zzsv.zza.zzff(r0)     // Catch:{ Exception -> 0x003d }
            if (r0 == 0) goto L_0x0057
            f2248Ow = r0     // Catch:{ Exception -> 0x003d }
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            goto L_0x000b
        L_0x003a:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            throw r0
        L_0x003d:
            r0 = move-exception
            java.lang.String r3 = "DynamiteModule"
            java.lang.String r4 = "Failed to load IDynamiteLoader from GmsCore: "
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x003a }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x003a }
            int r5 = r0.length()     // Catch:{ all -> 0x003a }
            if (r5 == 0) goto L_0x005a
            java.lang.String r0 = r4.concat(r0)     // Catch:{ all -> 0x003a }
        L_0x0054:
            android.util.Log.e(r3, r0)     // Catch:{ all -> 0x003a }
        L_0x0057:
            monitor-exit(r2)     // Catch:{ all -> 0x003a }
            r0 = r1
            goto L_0x000b
        L_0x005a:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x003a }
            r0.<init>(r4)     // Catch:{ all -> 0x003a }
            goto L_0x0054
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzsu.zzcv(android.content.Context):com.google.android.gms.internal.zzsv");
    }

    public Context zzbdy() {
        return this.f2252OD;
    }

    public IBinder zzjd(String str) throws zza {
        try {
            return (IBinder) this.f2252OD.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            String valueOf = String.valueOf(str);
            throw new zza(valueOf.length() != 0 ? "Failed to instantiate module class: ".concat(valueOf) : new String("Failed to instantiate module class: "), e);
        }
    }
}
