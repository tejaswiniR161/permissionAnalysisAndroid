package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import com.google.android.gms.common.util.zzs;
import java.util.ArrayList;
import java.util.List;

@zziy
public class zzct {
    private final Object zzaui = new Object();
    private zza zzauj = null;
    private boolean zzauk = false;

    @TargetApi(14)
    static class zza implements Application.ActivityLifecycleCallbacks {
        @Nullable
        private Activity mActivity;
        private Context mContext;
        /* access modifiers changed from: private */
        public List<zzb> mListeners = new ArrayList();
        /* access modifiers changed from: private */
        public final Object zzakd = new Object();
        private boolean zzaom = false;
        /* access modifiers changed from: private */
        public boolean zzaul = true;
        /* access modifiers changed from: private */
        public boolean zzaum = false;
        private Runnable zzaun;
        private long zzauo;

        zza() {
        }

        private void setActivity(Activity activity) {
            synchronized (this.zzakd) {
                if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                    this.mActivity = activity;
                }
            }
        }

        @Nullable
        public Activity getActivity() {
            return this.mActivity;
        }

        @Nullable
        public Context getContext() {
            return this.mContext;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onActivityDestroyed(android.app.Activity r3) {
            /*
                r2 = this;
                java.lang.Object r1 = r2.zzakd
                monitor-enter(r1)
                android.app.Activity r0 = r2.mActivity     // Catch:{ all -> 0x0016 }
                if (r0 != 0) goto L_0x0009
                monitor-exit(r1)     // Catch:{ all -> 0x0016 }
            L_0x0008:
                return
            L_0x0009:
                android.app.Activity r0 = r2.mActivity     // Catch:{ all -> 0x0016 }
                boolean r0 = r0.equals(r3)     // Catch:{ all -> 0x0016 }
                if (r0 == 0) goto L_0x0014
                r0 = 0
                r2.mActivity = r0     // Catch:{ all -> 0x0016 }
            L_0x0014:
                monitor-exit(r1)     // Catch:{ all -> 0x0016 }
                goto L_0x0008
            L_0x0016:
                r0 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x0016 }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzct.zza.onActivityDestroyed(android.app.Activity):void");
        }

        public void onActivityPaused(Activity activity) {
            setActivity(activity);
            this.zzaum = true;
            if (this.zzaun != null) {
                zzkr.zzcrf.removeCallbacks(this.zzaun);
            }
            Handler handler = zzkr.zzcrf;
            C08381 r1 = new Runnable() {
                public void run() {
                    synchronized (zza.this.zzakd) {
                        if (!zza.this.zzaul || !zza.this.zzaum) {
                            zzkn.zzdd("App is still foreground");
                        } else {
                            boolean unused = zza.this.zzaul = false;
                            zzkn.zzdd("App went background");
                            for (zzb zzk : zza.this.mListeners) {
                                try {
                                    zzk.zzk(false);
                                } catch (Exception e) {
                                    zzkn.zzb("OnForegroundStateChangedListener threw exception.", e);
                                }
                            }
                        }
                    }
                }
            };
            this.zzaun = r1;
            handler.postDelayed(r1, this.zzauo);
        }

        public void onActivityResumed(Activity activity) {
            boolean z = false;
            setActivity(activity);
            this.zzaum = false;
            if (!this.zzaul) {
                z = true;
            }
            this.zzaul = true;
            if (this.zzaun != null) {
                zzkr.zzcrf.removeCallbacks(this.zzaun);
            }
            synchronized (this.zzakd) {
                if (z) {
                    for (zzb zzk : this.mListeners) {
                        try {
                            zzk.zzk(true);
                        } catch (Exception e) {
                            zzkn.zzb("OnForegroundStateChangedListener threw exception.", e);
                        }
                    }
                } else {
                    zzkn.zzdd("App is still foreground.");
                }
            }
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
            setActivity(activity);
        }

        public void onActivityStopped(Activity activity) {
        }

        public void zza(Application application, Context context) {
            if (!this.zzaom) {
                application.registerActivityLifecycleCallbacks(this);
                if (context instanceof Activity) {
                    setActivity((Activity) context);
                }
                this.mContext = context;
                this.zzauo = zzdi.zzbdc.get().longValue();
                this.zzaom = true;
            }
        }

        public void zza(zzb zzb) {
            this.mListeners.add(zzb);
        }
    }

    public interface zzb {
        void zzk(boolean z);
    }

    @Nullable
    public Activity getActivity() {
        Activity activity = null;
        synchronized (this.zzaui) {
            if (zzs.zzaxn()) {
                if (this.zzauj != null) {
                    activity = this.zzauj.getActivity();
                }
            }
        }
        return activity;
    }

    @Nullable
    public Context getContext() {
        Context context = null;
        synchronized (this.zzaui) {
            if (zzs.zzaxn()) {
                if (this.zzauj != null) {
                    context = this.zzauj.getContext();
                }
            }
        }
        return context;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initialize(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.Object r2 = r4.zzaui
            monitor-enter(r2)
            boolean r0 = r4.zzauk     // Catch:{ all -> 0x001f }
            if (r0 != 0) goto L_0x004c
            boolean r0 = com.google.android.gms.common.util.zzs.zzaxn()     // Catch:{ all -> 0x001f }
            if (r0 != 0) goto L_0x000f
            monitor-exit(r2)     // Catch:{ all -> 0x001f }
        L_0x000e:
            return
        L_0x000f:
            com.google.android.gms.internal.zzde<java.lang.Boolean> r0 = com.google.android.gms.internal.zzdi.zzbdb     // Catch:{ all -> 0x001f }
            java.lang.Object r0 = r0.get()     // Catch:{ all -> 0x001f }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x001f }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x001f }
            if (r0 != 0) goto L_0x0022
            monitor-exit(r2)     // Catch:{ all -> 0x001f }
            goto L_0x000e
        L_0x001f:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x001f }
            throw r0
        L_0x0022:
            r1 = 0
            android.content.Context r0 = r5.getApplicationContext()     // Catch:{ all -> 0x001f }
            if (r0 != 0) goto L_0x002a
            r0 = r5
        L_0x002a:
            boolean r3 = r0 instanceof android.app.Application     // Catch:{ all -> 0x001f }
            if (r3 == 0) goto L_0x004e
            android.app.Application r0 = (android.app.Application) r0     // Catch:{ all -> 0x001f }
        L_0x0030:
            if (r0 != 0) goto L_0x0039
            java.lang.String r0 = "Can not cast Context to Application"
            com.google.android.gms.internal.zzkn.zzdf(r0)     // Catch:{ all -> 0x001f }
            monitor-exit(r2)     // Catch:{ all -> 0x001f }
            goto L_0x000e
        L_0x0039:
            com.google.android.gms.internal.zzct$zza r1 = r4.zzauj     // Catch:{ all -> 0x001f }
            if (r1 != 0) goto L_0x0044
            com.google.android.gms.internal.zzct$zza r1 = new com.google.android.gms.internal.zzct$zza     // Catch:{ all -> 0x001f }
            r1.<init>()     // Catch:{ all -> 0x001f }
            r4.zzauj = r1     // Catch:{ all -> 0x001f }
        L_0x0044:
            com.google.android.gms.internal.zzct$zza r1 = r4.zzauj     // Catch:{ all -> 0x001f }
            r1.zza((android.app.Application) r0, (android.content.Context) r5)     // Catch:{ all -> 0x001f }
            r0 = 1
            r4.zzauk = r0     // Catch:{ all -> 0x001f }
        L_0x004c:
            monitor-exit(r2)     // Catch:{ all -> 0x001f }
            goto L_0x000e
        L_0x004e:
            r0 = r1
            goto L_0x0030
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzct.initialize(android.content.Context):void");
    }

    public void zza(zzb zzb2) {
        synchronized (this.zzaui) {
            if (zzs.zzaxn()) {
                if (zzdi.zzbdb.get().booleanValue()) {
                    if (this.zzauj == null) {
                        this.zzauj = new zza();
                    }
                    this.zzauj.zza(zzb2);
                }
            }
        }
    }
}
