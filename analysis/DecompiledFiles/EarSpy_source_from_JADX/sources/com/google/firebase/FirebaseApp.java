package com.google.firebase;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.p000v4.util.ArrayMap;
import android.util.Log;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.common.util.zzt;
import com.google.android.gms.internal.zzamz;
import com.google.android.gms.internal.zzana;
import com.google.android.gms.internal.zzanb;
import com.google.android.gms.internal.zzanc;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.auth.GetTokenResult;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class FirebaseApp {
    public static final String DEFAULT_APP_NAME = "[DEFAULT]";
    private static final List<String> aSH = Arrays.asList(new String[]{"com.google.firebase.auth.FirebaseAuth", "com.google.firebase.iid.FirebaseInstanceId"});
    private static final List<String> aSI = Collections.singletonList("com.google.firebase.crash.FirebaseCrash");
    private static final List<String> aSJ = Arrays.asList(new String[]{"com.google.android.gms.measurement.AppMeasurement"});
    private static final List<String> aSK = Arrays.asList(new String[0]);
    private static final Set<String> aSL = Collections.emptySet();
    static final Map<String, FirebaseApp> afS = new ArrayMap();
    /* access modifiers changed from: private */
    public static final Object zzaok = new Object();
    private final FirebaseOptions aSM;
    private final AtomicBoolean aSN = new AtomicBoolean(false);
    private final AtomicBoolean aSO = new AtomicBoolean();
    private final List<zza> aSP = new CopyOnWriteArrayList();
    private final List<zzb> aSQ = new CopyOnWriteArrayList();
    private final List<Object> aSR = new CopyOnWriteArrayList();
    private zzanb aSS;
    private final String mName;
    private final Context zzask;

    public interface zza {
        void zzb(@NonNull zzanc zzanc);
    }

    public interface zzb {
        void zzcp(boolean z);
    }

    @TargetApi(24)
    private static class zzc extends BroadcastReceiver {
        private static AtomicReference<zzc> aST = new AtomicReference<>();
        private final Context zzask;

        public zzc(Context context) {
            this.zzask = context;
        }

        /* access modifiers changed from: private */
        public static void zzeq(Context context) {
            if (aST.get() == null) {
                zzc zzc = new zzc(context);
                if (aST.compareAndSet((Object) null, zzc)) {
                    IntentFilter intentFilter = new IntentFilter("android.intent.action.USER_UNLOCKED");
                    intentFilter.addDataScheme("package");
                    context.registerReceiver(zzc, intentFilter);
                }
            }
        }

        public void onReceive(Context context, Intent intent) {
            synchronized (FirebaseApp.zzaok) {
                for (FirebaseApp zza : FirebaseApp.afS.values()) {
                    zza.zzcnx();
                }
            }
            unregister();
        }

        public void unregister() {
            this.zzask.unregisterReceiver(this);
        }
    }

    protected FirebaseApp(Context context, String str, FirebaseOptions firebaseOptions) {
        this.zzask = (Context) zzac.zzy(context);
        this.mName = zzac.zzhz(str);
        this.aSM = (FirebaseOptions) zzac.zzy(firebaseOptions);
    }

    public static List<FirebaseApp> getApps(Context context) {
        ArrayList arrayList;
        zzana zzew = zzana.zzew(context);
        synchronized (zzaok) {
            arrayList = new ArrayList(afS.values());
            Set<String> O = zzana.m1355N().mo8784O();
            O.removeAll(afS.keySet());
            for (String next : O) {
                arrayList.add(initializeApp(context, zzew.zzua(next), next));
            }
        }
        return arrayList;
    }

    @Nullable
    public static FirebaseApp getInstance() {
        FirebaseApp firebaseApp;
        synchronized (zzaok) {
            firebaseApp = afS.get(DEFAULT_APP_NAME);
            if (firebaseApp == null) {
                String valueOf = String.valueOf(zzt.zzaxy());
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 116).append("Default FirebaseApp is not initialized in this process ").append(valueOf).append(". Make sure to call FirebaseApp.initializeApp(Context) first.").toString());
            }
        }
        return firebaseApp;
    }

    public static FirebaseApp getInstance(@NonNull String str) {
        FirebaseApp firebaseApp;
        String concat;
        synchronized (zzaok) {
            firebaseApp = afS.get(zzrr(str));
            if (firebaseApp == null) {
                List<String> zzcnw = zzcnw();
                if (zzcnw.isEmpty()) {
                    concat = "";
                } else {
                    String valueOf = String.valueOf(zzz.zzhy(", ").zza(zzcnw));
                    concat = valueOf.length() != 0 ? "Available app names: ".concat(valueOf) : new String("Available app names: ");
                }
                throw new IllegalStateException(String.format("FirebaseApp with name %s doesn't exist. %s", new Object[]{str, concat}));
            }
        }
        return firebaseApp;
    }

    public static FirebaseApp initializeApp(Context context) {
        FirebaseApp initializeApp;
        synchronized (zzaok) {
            if (afS.containsKey(DEFAULT_APP_NAME)) {
                initializeApp = getInstance();
            } else {
                FirebaseOptions fromResource = FirebaseOptions.fromResource(context);
                initializeApp = fromResource == null ? null : initializeApp(context, fromResource);
            }
        }
        return initializeApp;
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions) {
        return initializeApp(context, firebaseOptions, DEFAULT_APP_NAME);
    }

    public static FirebaseApp initializeApp(Context context, FirebaseOptions firebaseOptions, String str) {
        FirebaseApp firebaseApp;
        zzana zzew = zzana.zzew(context);
        zzep(context);
        String zzrr = zzrr(str);
        if (!(context instanceof Application)) {
            context = context.getApplicationContext();
        }
        synchronized (zzaok) {
            zzac.zza(!afS.containsKey(zzrr), (Object) new StringBuilder(String.valueOf(zzrr).length() + 33).append("FirebaseApp name ").append(zzrr).append(" already exists!").toString());
            zzac.zzb(context, (Object) "Application context cannot be null.");
            firebaseApp = new FirebaseApp(context, zzrr, firebaseOptions);
            afS.put(zzrr, firebaseApp);
        }
        zzew.zzg(firebaseApp);
        firebaseApp.zza(FirebaseApp.class, firebaseApp, aSH);
        if (firebaseApp.zzcnu()) {
            firebaseApp.zza(FirebaseApp.class, firebaseApp, aSI);
            firebaseApp.zza(Context.class, firebaseApp.getApplicationContext(), aSJ);
        }
        return firebaseApp;
    }

    private <T> void zza(Class<T> cls, T t, Iterable<String> iterable) {
        boolean z;
        if (zzs.zzaxw()) {
            boolean isDeviceProtectedStorage = this.zzask.isDeviceProtectedStorage();
            if (isDeviceProtectedStorage) {
                zzc.zzeq(this.zzask);
            }
            z = isDeviceProtectedStorage;
        } else {
            z = false;
        }
        for (String next : iterable) {
            if (z) {
                try {
                    if (!aSK.contains(next)) {
                    }
                } catch (ClassNotFoundException e) {
                    if (aSL.contains(next)) {
                        throw new IllegalStateException(String.valueOf(next).concat(" is missing, but is required. Check if it has been removed by Proguard."));
                    }
                    Log.d("FirebaseApp", String.valueOf(next).concat(" is not linked. Skipping initialization."));
                } catch (NoSuchMethodException e2) {
                    throw new IllegalStateException(String.valueOf(next).concat("#getInstance has been removed by Proguard. Add keep rule to prevent it."));
                } catch (InvocationTargetException e3) {
                    Log.wtf("FirebaseApp", "Firebase API initialization failure.", e3);
                } catch (IllegalAccessException e4) {
                    String valueOf = String.valueOf(next);
                    Log.wtf("FirebaseApp", valueOf.length() != 0 ? "Failed to initialize ".concat(valueOf) : new String("Failed to initialize "), e4);
                }
            }
            Method method = Class.forName(next).getMethod("getInstance", new Class[]{cls});
            int modifiers = method.getModifiers();
            if (Modifier.isPublic(modifiers) && Modifier.isStatic(modifiers)) {
                method.invoke((Object) null, new Object[]{t});
            }
        }
    }

    private void zzcnt() {
        zzac.zza(!this.aSO.get(), (Object) "FirebaseApp was deleted");
    }

    private static List<String> zzcnw() {
        com.google.android.gms.common.util.zza zza2 = new com.google.android.gms.common.util.zza();
        synchronized (zzaok) {
            for (FirebaseApp name : afS.values()) {
                zza2.add(name.getName());
            }
            zzana N = zzana.m1355N();
            if (N != null) {
                zza2.addAll(N.mo8784O());
            }
        }
        ArrayList arrayList = new ArrayList(zza2);
        Collections.sort(arrayList);
        return arrayList;
    }

    /* access modifiers changed from: private */
    public void zzcnx() {
        zza(FirebaseApp.class, this, aSH);
        if (zzcnu()) {
            zza(FirebaseApp.class, this, aSI);
            zza(Context.class, this.zzask, aSJ);
        }
    }

    public static void zzcp(boolean z) {
        synchronized (zzaok) {
            Iterator it = new ArrayList(afS.values()).iterator();
            while (it.hasNext()) {
                FirebaseApp firebaseApp = (FirebaseApp) it.next();
                if (firebaseApp.aSN.get()) {
                    firebaseApp.zzcq(z);
                }
            }
        }
    }

    private void zzcq(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        for (zzb zzcp : this.aSQ) {
            zzcp.zzcp(z);
        }
    }

    @TargetApi(14)
    private static void zzep(Context context) {
        if (zzs.zzaxn() && (context.getApplicationContext() instanceof Application)) {
            zzamz.zza((Application) context.getApplicationContext());
        }
    }

    private static String zzrr(@NonNull String str) {
        return str.trim();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FirebaseApp)) {
            return false;
        }
        return this.mName.equals(((FirebaseApp) obj).getName());
    }

    @NonNull
    public Context getApplicationContext() {
        zzcnt();
        return this.zzask;
    }

    @NonNull
    public String getName() {
        zzcnt();
        return this.mName;
    }

    @NonNull
    public FirebaseOptions getOptions() {
        zzcnt();
        return this.aSM;
    }

    public Task<GetTokenResult> getToken(boolean z) {
        zzcnt();
        return this.aSS == null ? Tasks.forException(new FirebaseApiNotAvailableException("firebase-auth is not linked, please fall back to unauthenticated mode.")) : this.aSS.zzcr(z);
    }

    public int hashCode() {
        return this.mName.hashCode();
    }

    public String toString() {
        return zzab.zzx(this).zzg("name", this.mName).zzg("options", this.aSM).toString();
    }

    public void zza(@NonNull zzanb zzanb) {
        this.aSS = (zzanb) zzac.zzy(zzanb);
    }

    @UiThread
    public void zza(@NonNull zzanc zzanc) {
        Log.d("FirebaseApp", "Notifying auth state listeners.");
        int i = 0;
        for (zza zzb2 : this.aSP) {
            zzb2.zzb(zzanc);
            i++;
        }
        Log.d("FirebaseApp", String.format("Notified %d auth state listeners.", new Object[]{Integer.valueOf(i)}));
    }

    public void zza(@NonNull zza zza2) {
        zzcnt();
        zzac.zzy(zza2);
        this.aSP.add(zza2);
    }

    public void zza(zzb zzb2) {
        zzcnt();
        if (this.aSN.get() && zzamz.m1353L().mo8771M()) {
            zzb2.zzcp(true);
        }
        this.aSQ.add(zzb2);
    }

    public boolean zzcnu() {
        return DEFAULT_APP_NAME.equals(getName());
    }

    public String zzcnv() {
        String valueOf = String.valueOf(com.google.android.gms.common.util.zzc.zzr(getName().getBytes()));
        String valueOf2 = String.valueOf(com.google.android.gms.common.util.zzc.zzr(getOptions().getApplicationId().getBytes()));
        return new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length()).append(valueOf).append("+").append(valueOf2).toString();
    }
}
