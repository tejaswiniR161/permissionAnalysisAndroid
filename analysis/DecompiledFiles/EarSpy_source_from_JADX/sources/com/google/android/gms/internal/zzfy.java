package com.google.android.gms.internal;

import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzfv;
import com.google.android.gms.internal.zzlm;
import java.util.Map;

@zziy
public class zzfy {
    /* access modifiers changed from: private */
    public final Context mContext;
    /* access modifiers changed from: private */
    public final Object zzakd;
    /* access modifiers changed from: private */
    public final VersionInfoParcel zzanh;
    /* access modifiers changed from: private */
    public final String zzbqi;
    /* access modifiers changed from: private */
    public zzkw<zzfv> zzbqj;
    private zzkw<zzfv> zzbqk;
    /* access modifiers changed from: private */
    @Nullable
    public zzd zzbql;
    /* access modifiers changed from: private */
    public int zzbqm;

    static class zza {
        static int zzbqx = 60000;
        static int zzbqy = 10000;
    }

    public static class zzb<T> implements zzkw<T> {
        public void zzd(T t) {
        }
    }

    public static class zzc extends zzln<zzfz> {
        private final Object zzakd = new Object();
        /* access modifiers changed from: private */
        public final zzd zzbqz;
        private boolean zzbra;

        public zzc(zzd zzd) {
            this.zzbqz = zzd;
        }

        public void release() {
            synchronized (this.zzakd) {
                if (!this.zzbra) {
                    this.zzbra = true;
                    zza(new zzlm.zzc<zzfz>() {
                        /* renamed from: zzb */
                        public void zzd(zzfz zzfz) {
                            zzkn.m1493v("Ending javascript session.");
                            ((zzga) zzfz).zznd();
                        }
                    }, new zzlm.zzb());
                    zza(new zzlm.zzc<zzfz>() {
                        /* renamed from: zzb */
                        public void zzd(zzfz zzfz) {
                            zzkn.m1493v("Releasing engine reference.");
                            zzc.this.zzbqz.zzna();
                        }
                    }, new zzlm.zza() {
                        public void run() {
                            zzc.this.zzbqz.zzna();
                        }
                    });
                }
            }
        }
    }

    public static class zzd extends zzln<zzfv> {
        private final Object zzakd = new Object();
        /* access modifiers changed from: private */
        public zzkw<zzfv> zzbqk;
        private boolean zzbrc;
        private int zzbrd;

        public zzd(zzkw<zzfv> zzkw) {
            this.zzbqk = zzkw;
            this.zzbrc = false;
            this.zzbrd = 0;
        }

        public zzc zzmz() {
            final zzc zzc = new zzc(this);
            synchronized (this.zzakd) {
                zza(new zzlm.zzc<zzfv>() {
                    /* renamed from: zza */
                    public void zzd(zzfv zzfv) {
                        zzkn.m1493v("Getting a new session for JS Engine.");
                        zzc.zzg(zzfv.zzmw());
                    }
                }, new zzlm.zza() {
                    public void run() {
                        zzkn.m1493v("Rejecting reference for JS Engine.");
                        zzc.reject();
                    }
                });
                zzac.zzbr(this.zzbrd >= 0);
                this.zzbrd++;
            }
            return zzc;
        }

        /* access modifiers changed from: protected */
        public void zzna() {
            boolean z = true;
            synchronized (this.zzakd) {
                if (this.zzbrd < 1) {
                    z = false;
                }
                zzac.zzbr(z);
                zzkn.m1493v("Releasing 1 reference for JS Engine");
                this.zzbrd--;
                zznc();
            }
        }

        public void zznb() {
            boolean z = true;
            synchronized (this.zzakd) {
                if (this.zzbrd < 0) {
                    z = false;
                }
                zzac.zzbr(z);
                zzkn.m1493v("Releasing root reference. JS Engine will be destroyed once other references are released.");
                this.zzbrc = true;
                zznc();
            }
        }

        /* access modifiers changed from: protected */
        public void zznc() {
            synchronized (this.zzakd) {
                zzac.zzbr(this.zzbrd >= 0);
                if (!this.zzbrc || this.zzbrd != 0) {
                    zzkn.m1493v("There are still references to the engine. Not destroying.");
                } else {
                    zzkn.m1493v("No reference is left (including root). Cleaning up engine.");
                    zza(new zzlm.zzc<zzfv>() {
                        /* renamed from: zza */
                        public void zzd(final zzfv zzfv) {
                            zzu.zzfz().runOnUiThread(new Runnable() {
                                public void run() {
                                    zzd.this.zzbqk.zzd(zzfv);
                                    zzfv.destroy();
                                }
                            });
                        }
                    }, new zzlm.zzb());
                }
            }
        }
    }

    public static class zze extends zzln<zzfz> {
        private zzc zzbri;

        public zze(zzc zzc) {
            this.zzbri = zzc;
        }

        public void finalize() {
            this.zzbri.release();
            this.zzbri = null;
        }

        public int getStatus() {
            return this.zzbri.getStatus();
        }

        public void reject() {
            this.zzbri.reject();
        }

        public void zza(zzlm.zzc<zzfz> zzc, zzlm.zza zza) {
            this.zzbri.zza(zzc, zza);
        }

        /* renamed from: zzf */
        public void zzg(zzfz zzfz) {
            this.zzbri.zzg(zzfz);
        }
    }

    public zzfy(Context context, VersionInfoParcel versionInfoParcel, String str) {
        this.zzakd = new Object();
        this.zzbqm = 1;
        this.zzbqi = str;
        this.mContext = context.getApplicationContext();
        this.zzanh = versionInfoParcel;
        this.zzbqj = new zzb();
        this.zzbqk = new zzb();
    }

    public zzfy(Context context, VersionInfoParcel versionInfoParcel, String str, zzkw<zzfv> zzkw, zzkw<zzfv> zzkw2) {
        this(context, versionInfoParcel, str);
        this.zzbqj = zzkw;
        this.zzbqk = zzkw2;
    }

    private zzd zza(@Nullable final zzau zzau) {
        final zzd zzd2 = new zzd(this.zzbqk);
        zzu.zzfz().runOnUiThread(new Runnable() {
            public void run() {
                final zzfv zza = zzfy.this.zza(zzfy.this.mContext, zzfy.this.zzanh, zzau);
                zza.zza(new zzfv.zza() {
                    public void zzmx() {
                        zzkr.zzcrf.postDelayed(new Runnable() {
                            /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
                                return;
                             */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public void run() {
                                /*
                                    r3 = this;
                                    com.google.android.gms.internal.zzfy$1$1 r0 = com.google.android.gms.internal.zzfy.C09071.C09081.this
                                    com.google.android.gms.internal.zzfy$1 r0 = com.google.android.gms.internal.zzfy.C09071.this
                                    com.google.android.gms.internal.zzfy r0 = com.google.android.gms.internal.zzfy.this
                                    java.lang.Object r1 = r0.zzakd
                                    monitor-enter(r1)
                                    com.google.android.gms.internal.zzfy$1$1 r0 = com.google.android.gms.internal.zzfy.C09071.C09081.this     // Catch:{ all -> 0x0043 }
                                    com.google.android.gms.internal.zzfy$1 r0 = com.google.android.gms.internal.zzfy.C09071.this     // Catch:{ all -> 0x0043 }
                                    com.google.android.gms.internal.zzfy$zzd r0 = r0     // Catch:{ all -> 0x0043 }
                                    int r0 = r0.getStatus()     // Catch:{ all -> 0x0043 }
                                    r2 = -1
                                    if (r0 == r2) goto L_0x0025
                                    com.google.android.gms.internal.zzfy$1$1 r0 = com.google.android.gms.internal.zzfy.C09071.C09081.this     // Catch:{ all -> 0x0043 }
                                    com.google.android.gms.internal.zzfy$1 r0 = com.google.android.gms.internal.zzfy.C09071.this     // Catch:{ all -> 0x0043 }
                                    com.google.android.gms.internal.zzfy$zzd r0 = r0     // Catch:{ all -> 0x0043 }
                                    int r0 = r0.getStatus()     // Catch:{ all -> 0x0043 }
                                    r2 = 1
                                    if (r0 != r2) goto L_0x0027
                                L_0x0025:
                                    monitor-exit(r1)     // Catch:{ all -> 0x0043 }
                                L_0x0026:
                                    return
                                L_0x0027:
                                    com.google.android.gms.internal.zzfy$1$1 r0 = com.google.android.gms.internal.zzfy.C09071.C09081.this     // Catch:{ all -> 0x0043 }
                                    com.google.android.gms.internal.zzfy$1 r0 = com.google.android.gms.internal.zzfy.C09071.this     // Catch:{ all -> 0x0043 }
                                    com.google.android.gms.internal.zzfy$zzd r0 = r0     // Catch:{ all -> 0x0043 }
                                    r0.reject()     // Catch:{ all -> 0x0043 }
                                    com.google.android.gms.internal.zzkr r0 = com.google.android.gms.ads.internal.zzu.zzfz()     // Catch:{ all -> 0x0043 }
                                    com.google.android.gms.internal.zzfy$1$1$1$1 r2 = new com.google.android.gms.internal.zzfy$1$1$1$1     // Catch:{ all -> 0x0043 }
                                    r2.<init>()     // Catch:{ all -> 0x0043 }
                                    r0.runOnUiThread(r2)     // Catch:{ all -> 0x0043 }
                                    java.lang.String r0 = "Could not receive loaded message in a timely manner. Rejecting."
                                    com.google.android.gms.internal.zzkn.m1493v(r0)     // Catch:{ all -> 0x0043 }
                                    monitor-exit(r1)     // Catch:{ all -> 0x0043 }
                                    goto L_0x0026
                                L_0x0043:
                                    r0 = move-exception
                                    monitor-exit(r1)     // Catch:{ all -> 0x0043 }
                                    throw r0
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfy.C09071.C09081.C09091.run():void");
                            }
                        }, (long) zza.zzbqy);
                    }
                });
                zza.zza("/jsLoaded", (zzev) new zzev() {
                    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
                        return;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void zza(com.google.android.gms.internal.zzlt r4, java.util.Map<java.lang.String, java.lang.String> r5) {
                        /*
                            r3 = this;
                            com.google.android.gms.internal.zzfy$1 r0 = com.google.android.gms.internal.zzfy.C09071.this
                            com.google.android.gms.internal.zzfy r0 = com.google.android.gms.internal.zzfy.this
                            java.lang.Object r1 = r0.zzakd
                            monitor-enter(r1)
                            com.google.android.gms.internal.zzfy$1 r0 = com.google.android.gms.internal.zzfy.C09071.this     // Catch:{ all -> 0x0051 }
                            com.google.android.gms.internal.zzfy$zzd r0 = r0     // Catch:{ all -> 0x0051 }
                            int r0 = r0.getStatus()     // Catch:{ all -> 0x0051 }
                            r2 = -1
                            if (r0 == r2) goto L_0x001f
                            com.google.android.gms.internal.zzfy$1 r0 = com.google.android.gms.internal.zzfy.C09071.this     // Catch:{ all -> 0x0051 }
                            com.google.android.gms.internal.zzfy$zzd r0 = r0     // Catch:{ all -> 0x0051 }
                            int r0 = r0.getStatus()     // Catch:{ all -> 0x0051 }
                            r2 = 1
                            if (r0 != r2) goto L_0x0021
                        L_0x001f:
                            monitor-exit(r1)     // Catch:{ all -> 0x0051 }
                        L_0x0020:
                            return
                        L_0x0021:
                            com.google.android.gms.internal.zzfy$1 r0 = com.google.android.gms.internal.zzfy.C09071.this     // Catch:{ all -> 0x0051 }
                            com.google.android.gms.internal.zzfy r0 = com.google.android.gms.internal.zzfy.this     // Catch:{ all -> 0x0051 }
                            r2 = 0
                            int unused = r0.zzbqm = r2     // Catch:{ all -> 0x0051 }
                            com.google.android.gms.internal.zzfy$1 r0 = com.google.android.gms.internal.zzfy.C09071.this     // Catch:{ all -> 0x0051 }
                            com.google.android.gms.internal.zzfy r0 = com.google.android.gms.internal.zzfy.this     // Catch:{ all -> 0x0051 }
                            com.google.android.gms.internal.zzkw r0 = r0.zzbqj     // Catch:{ all -> 0x0051 }
                            com.google.android.gms.internal.zzfv r2 = r0     // Catch:{ all -> 0x0051 }
                            r0.zzd(r2)     // Catch:{ all -> 0x0051 }
                            com.google.android.gms.internal.zzfy$1 r0 = com.google.android.gms.internal.zzfy.C09071.this     // Catch:{ all -> 0x0051 }
                            com.google.android.gms.internal.zzfy$zzd r0 = r0     // Catch:{ all -> 0x0051 }
                            com.google.android.gms.internal.zzfv r2 = r0     // Catch:{ all -> 0x0051 }
                            r0.zzg(r2)     // Catch:{ all -> 0x0051 }
                            com.google.android.gms.internal.zzfy$1 r0 = com.google.android.gms.internal.zzfy.C09071.this     // Catch:{ all -> 0x0051 }
                            com.google.android.gms.internal.zzfy r0 = com.google.android.gms.internal.zzfy.this     // Catch:{ all -> 0x0051 }
                            com.google.android.gms.internal.zzfy$1 r2 = com.google.android.gms.internal.zzfy.C09071.this     // Catch:{ all -> 0x0051 }
                            com.google.android.gms.internal.zzfy$zzd r2 = r0     // Catch:{ all -> 0x0051 }
                            com.google.android.gms.internal.zzfy.zzd unused = r0.zzbql = r2     // Catch:{ all -> 0x0051 }
                            java.lang.String r0 = "Successfully loaded JS Engine."
                            com.google.android.gms.internal.zzkn.m1493v(r0)     // Catch:{ all -> 0x0051 }
                            monitor-exit(r1)     // Catch:{ all -> 0x0051 }
                            goto L_0x0020
                        L_0x0051:
                            r0 = move-exception
                            monitor-exit(r1)     // Catch:{ all -> 0x0051 }
                            throw r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfy.C09071.C09112.zza(com.google.android.gms.internal.zzlt, java.util.Map):void");
                    }
                });
                final zzld zzld = new zzld();
                C09123 r2 = new zzev() {
                    public void zza(zzlt zzlt, Map<String, String> map) {
                        synchronized (zzfy.this.zzakd) {
                            zzkn.zzde("JS Engine is requesting an update");
                            if (zzfy.this.zzbqm == 0) {
                                zzkn.zzde("Starting reload.");
                                int unused = zzfy.this.zzbqm = 2;
                                zzfy.this.zzb(zzau);
                            }
                            zza.zzb("/requestReload", (zzev) zzld.get());
                        }
                    }
                };
                zzld.set(r2);
                zza.zza("/requestReload", (zzev) r2);
                if (zzfy.this.zzbqi.endsWith(".js")) {
                    zza.zzbk(zzfy.this.zzbqi);
                } else if (zzfy.this.zzbqi.startsWith("<html>")) {
                    zza.zzbm(zzfy.this.zzbqi);
                } else {
                    zza.zzbl(zzfy.this.zzbqi);
                }
                zzkr.zzcrf.postDelayed(new Runnable() {
                    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
                        return;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public void run() {
                        /*
                            r3 = this;
                            com.google.android.gms.internal.zzfy$1 r0 = com.google.android.gms.internal.zzfy.C09071.this
                            com.google.android.gms.internal.zzfy r0 = com.google.android.gms.internal.zzfy.this
                            java.lang.Object r1 = r0.zzakd
                            monitor-enter(r1)
                            com.google.android.gms.internal.zzfy$1 r0 = com.google.android.gms.internal.zzfy.C09071.this     // Catch:{ all -> 0x003b }
                            com.google.android.gms.internal.zzfy$zzd r0 = r0     // Catch:{ all -> 0x003b }
                            int r0 = r0.getStatus()     // Catch:{ all -> 0x003b }
                            r2 = -1
                            if (r0 == r2) goto L_0x001f
                            com.google.android.gms.internal.zzfy$1 r0 = com.google.android.gms.internal.zzfy.C09071.this     // Catch:{ all -> 0x003b }
                            com.google.android.gms.internal.zzfy$zzd r0 = r0     // Catch:{ all -> 0x003b }
                            int r0 = r0.getStatus()     // Catch:{ all -> 0x003b }
                            r2 = 1
                            if (r0 != r2) goto L_0x0021
                        L_0x001f:
                            monitor-exit(r1)     // Catch:{ all -> 0x003b }
                        L_0x0020:
                            return
                        L_0x0021:
                            com.google.android.gms.internal.zzfy$1 r0 = com.google.android.gms.internal.zzfy.C09071.this     // Catch:{ all -> 0x003b }
                            com.google.android.gms.internal.zzfy$zzd r0 = r0     // Catch:{ all -> 0x003b }
                            r0.reject()     // Catch:{ all -> 0x003b }
                            com.google.android.gms.internal.zzkr r0 = com.google.android.gms.ads.internal.zzu.zzfz()     // Catch:{ all -> 0x003b }
                            com.google.android.gms.internal.zzfy$1$4$1 r2 = new com.google.android.gms.internal.zzfy$1$4$1     // Catch:{ all -> 0x003b }
                            r2.<init>()     // Catch:{ all -> 0x003b }
                            r0.runOnUiThread(r2)     // Catch:{ all -> 0x003b }
                            java.lang.String r0 = "Could not receive loaded message in a timely manner. Rejecting."
                            com.google.android.gms.internal.zzkn.m1493v(r0)     // Catch:{ all -> 0x003b }
                            monitor-exit(r1)     // Catch:{ all -> 0x003b }
                            goto L_0x0020
                        L_0x003b:
                            r0 = move-exception
                            monitor-exit(r1)     // Catch:{ all -> 0x003b }
                            throw r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzfy.C09071.C09134.run():void");
                    }
                }, (long) zza.zzbqx);
            }
        });
        return zzd2;
    }

    /* access modifiers changed from: protected */
    public zzfv zza(Context context, VersionInfoParcel versionInfoParcel, @Nullable zzau zzau) {
        return new zzfx(context, versionInfoParcel, zzau, (com.google.android.gms.ads.internal.zzd) null);
    }

    /* access modifiers changed from: protected */
    public zzd zzb(@Nullable zzau zzau) {
        final zzd zza2 = zza(zzau);
        zza2.zza(new zzlm.zzc<zzfv>() {
            /* renamed from: zza */
            public void zzd(zzfv zzfv) {
                synchronized (zzfy.this.zzakd) {
                    int unused = zzfy.this.zzbqm = 0;
                    if (!(zzfy.this.zzbql == null || zza2 == zzfy.this.zzbql)) {
                        zzkn.m1493v("New JS engine is loaded, marking previous one as destroyable.");
                        zzfy.this.zzbql.zznb();
                    }
                    zzd unused2 = zzfy.this.zzbql = zza2;
                }
            }
        }, new zzlm.zza() {
            public void run() {
                synchronized (zzfy.this.zzakd) {
                    int unused = zzfy.this.zzbqm = 1;
                    zzkn.m1493v("Failed loading new engine. Marking new engine destroyable.");
                    zza2.zznb();
                }
            }
        });
        return zza2;
    }

    public zzc zzc(@Nullable zzau zzau) {
        zzc zzc2;
        synchronized (this.zzakd) {
            if (this.zzbql == null || this.zzbql.getStatus() == -1) {
                this.zzbqm = 2;
                this.zzbql = zzb(zzau);
                zzc2 = this.zzbql.zzmz();
            } else if (this.zzbqm == 0) {
                zzc2 = this.zzbql.zzmz();
            } else if (this.zzbqm == 1) {
                this.zzbqm = 2;
                zzb(zzau);
                zzc2 = this.zzbql.zzmz();
            } else {
                zzc2 = this.zzbqm == 2 ? this.zzbql.zzmz() : this.zzbql.zzmz();
            }
        }
        return zzc2;
    }

    public zzc zzmy() {
        return zzc((zzau) null);
    }
}
