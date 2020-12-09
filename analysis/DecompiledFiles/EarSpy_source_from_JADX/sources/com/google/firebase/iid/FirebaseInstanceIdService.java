package com.google.firebase.iid;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.WorkerThread;
import android.util.Log;
import com.facebook.ads.AdError;
import com.google.firebase.FirebaseApp;

public class FirebaseInstanceIdService extends zzb {
    private static BroadcastReceiver bhu;
    private static final Object bhv = new Object();
    private static boolean bhw = false;
    /* access modifiers changed from: private */
    public boolean bhx = false;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        if (r0.zztz(com.google.firebase.iid.zzd.afY) != false) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        if (r3.mo11733E().mo11766J() == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0022, code lost:
        zzet(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x000a, code lost:
        r0 = r3.mo11731C();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000e, code lost:
        if (r0 == null) goto L_0x0022;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void zza(android.content.Context r2, com.google.firebase.iid.FirebaseInstanceId r3) {
        /*
            java.lang.Object r1 = bhv
            monitor-enter(r1)
            boolean r0 = bhw     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0009
            monitor-exit(r1)     // Catch:{ all -> 0x0026 }
        L_0x0008:
            return
        L_0x0009:
            monitor-exit(r1)     // Catch:{ all -> 0x0026 }
            com.google.firebase.iid.zzg$zza r0 = r3.mo11731C()
            if (r0 == 0) goto L_0x0022
            java.lang.String r1 = com.google.firebase.iid.zzd.afY
            boolean r0 = r0.zztz(r1)
            if (r0 != 0) goto L_0x0022
            com.google.firebase.iid.zze r0 = r3.mo11733E()
            java.lang.String r0 = r0.mo11766J()
            if (r0 == 0) goto L_0x0008
        L_0x0022:
            zzet(r2)
            goto L_0x0008
        L_0x0026:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0026 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.zza(android.content.Context, com.google.firebase.iid.FirebaseInstanceId):void");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008e A[Catch:{ IOException -> 0x00a1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ab A[SYNTHETIC, Splitter:B:51:0x00ab] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0071 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void zza(android.content.Intent r9, boolean r10) {
        /*
            r8 = this;
            r2 = 1
            r1 = 0
            java.lang.Object r3 = bhv
            monitor-enter(r3)
            r0 = 0
            bhw = r0     // Catch:{ all -> 0x0010 }
            monitor-exit(r3)     // Catch:{ all -> 0x0010 }
            java.lang.String r0 = com.google.firebase.iid.zzf.zzdj(r8)
            if (r0 != 0) goto L_0x0013
        L_0x000f:
            return
        L_0x0010:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0010 }
            throw r0
        L_0x0013:
            com.google.firebase.iid.FirebaseInstanceId r0 = com.google.firebase.iid.FirebaseInstanceId.getInstance()
            com.google.firebase.iid.zzg$zza r3 = r0.mo11731C()
            if (r3 != 0) goto L_0x004d
            java.lang.String r1 = r0.mo11732D()     // Catch:{ IOException -> 0x0035, SecurityException -> 0x0044 }
            if (r1 == 0) goto L_0x003e
            boolean r1 = r8.bhx     // Catch:{ IOException -> 0x0035, SecurityException -> 0x0044 }
            if (r1 == 0) goto L_0x002e
            java.lang.String r1 = "FirebaseInstanceId"
            java.lang.String r2 = "get master token succeeded"
            android.util.Log.d(r1, r2)     // Catch:{ IOException -> 0x0035, SecurityException -> 0x0044 }
        L_0x002e:
            zza((android.content.Context) r8, (com.google.firebase.iid.FirebaseInstanceId) r0)     // Catch:{ IOException -> 0x0035, SecurityException -> 0x0044 }
            r8.onTokenRefresh()     // Catch:{ IOException -> 0x0035, SecurityException -> 0x0044 }
            goto L_0x000f
        L_0x0035:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            r8.zzd(r9, r0)
            goto L_0x000f
        L_0x003e:
            java.lang.String r0 = "returned token is null"
            r8.zzd(r9, r0)     // Catch:{ IOException -> 0x0035, SecurityException -> 0x0044 }
            goto L_0x000f
        L_0x0044:
            r0 = move-exception
            java.lang.String r1 = "FirebaseInstanceId"
            java.lang.String r2 = "Unable to get master token"
            android.util.Log.e(r1, r2, r0)
            goto L_0x000f
        L_0x004d:
            com.google.firebase.iid.zze r4 = r0.mo11733E()
            java.lang.String r0 = r4.mo11766J()
            r3 = r0
        L_0x0056:
            if (r3 == 0) goto L_0x00be
            java.lang.String r0 = "!"
            java.lang.String[] r0 = r3.split(r0)
            int r5 = r0.length
            r6 = 2
            if (r5 != r6) goto L_0x0071
            r5 = r0[r1]
            r6 = r0[r2]
            r0 = -1
            int r7 = r5.hashCode()     // Catch:{ IOException -> 0x00a1 }
            switch(r7) {
                case 83: goto L_0x007a;
                case 84: goto L_0x006e;
                case 85: goto L_0x0084;
                default: goto L_0x006e;
            }
        L_0x006e:
            switch(r0) {
                case 0: goto L_0x008e;
                case 1: goto L_0x00ab;
                default: goto L_0x0071;
            }
        L_0x0071:
            r4.zztv(r3)
            java.lang.String r0 = r4.mo11766J()
            r3 = r0
            goto L_0x0056
        L_0x007a:
            java.lang.String r7 = "S"
            boolean r5 = r5.equals(r7)     // Catch:{ IOException -> 0x00a1 }
            if (r5 == 0) goto L_0x006e
            r0 = r1
            goto L_0x006e
        L_0x0084:
            java.lang.String r7 = "U"
            boolean r5 = r5.equals(r7)     // Catch:{ IOException -> 0x00a1 }
            if (r5 == 0) goto L_0x006e
            r0 = r2
            goto L_0x006e
        L_0x008e:
            com.google.firebase.iid.FirebaseInstanceId r0 = com.google.firebase.iid.FirebaseInstanceId.getInstance()     // Catch:{ IOException -> 0x00a1 }
            r0.zzts(r6)     // Catch:{ IOException -> 0x00a1 }
            boolean r0 = r8.bhx     // Catch:{ IOException -> 0x00a1 }
            if (r0 == 0) goto L_0x0071
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r5 = "subscribe operation succeeded"
            android.util.Log.d(r0, r5)     // Catch:{ IOException -> 0x00a1 }
            goto L_0x0071
        L_0x00a1:
            r0 = move-exception
            java.lang.String r0 = r0.getMessage()
            r8.zzd(r9, r0)
            goto L_0x000f
        L_0x00ab:
            com.google.firebase.iid.FirebaseInstanceId r0 = com.google.firebase.iid.FirebaseInstanceId.getInstance()     // Catch:{ IOException -> 0x00a1 }
            r0.zztt(r6)     // Catch:{ IOException -> 0x00a1 }
            boolean r0 = r8.bhx     // Catch:{ IOException -> 0x00a1 }
            if (r0 == 0) goto L_0x0071
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r5 = "unsubscribe operation succeeded"
            android.util.Log.d(r0, r5)     // Catch:{ IOException -> 0x00a1 }
            goto L_0x0071
        L_0x00be:
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r1 = "topic sync succeeded"
            android.util.Log.d(r0, r1)
            goto L_0x000f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.zza(android.content.Intent, boolean):void");
    }

    private void zza(zzf zzf, Bundle bundle) {
        String zzdj = zzf.zzdj(this);
        if (zzdj == null) {
            Log.w("FirebaseInstanceId", "Unable to respond to ping due to missing target package");
            return;
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        intent.setPackage(zzdj);
        intent.putExtras(bundle);
        zzf.zzs(intent);
        intent.putExtra("google.to", "google.com/iid");
        intent.putExtra("google.message_id", zzf.zzbov());
        sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }

    /* access modifiers changed from: private */
    public static Intent zzagk(int i) {
        Context applicationContext = FirebaseApp.getInstance().getApplicationContext();
        Intent intent = new Intent("ACTION_TOKEN_REFRESH_RETRY");
        intent.putExtra("next_retry_delay_in_seconds", i);
        return FirebaseInstanceIdInternalReceiver.zzg(applicationContext, intent);
    }

    private void zzagl(int i) {
        ((AlarmManager) getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + ((long) (i * AdError.NETWORK_ERROR_CODE)), PendingIntent.getBroadcast(this, 0, zzagk(i * 2), 268435456));
    }

    private String zzai(Intent intent) {
        String stringExtra = intent.getStringExtra("subtype");
        return stringExtra == null ? "" : stringExtra;
    }

    private int zzb(Intent intent, boolean z) {
        int intExtra = intent == null ? 10 : intent.getIntExtra("next_retry_delay_in_seconds", 0);
        if (intExtra < 10 && !z) {
            return 30;
        }
        if (intExtra < 10) {
            return 10;
        }
        if (intExtra > 28800) {
            return 28800;
        }
        return intExtra;
    }

    private void zzd(Intent intent, String str) {
        boolean zzeu = zzeu(this);
        final int zzb = zzb(intent, zzeu);
        Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(str).length() + 47).append("background sync failed: ").append(str).append(", retry in ").append(zzb).append("s").toString());
        synchronized (bhv) {
            zzagl(zzb);
            bhw = true;
        }
        if (!zzeu) {
            if (this.bhx) {
                Log.d("FirebaseInstanceId", "device not connected. Connectivity change received registered");
            }
            if (bhu == null) {
                bhu = new BroadcastReceiver() {
                    public void onReceive(Context context, Intent intent) {
                        if (FirebaseInstanceIdService.zzeu(context)) {
                            if (FirebaseInstanceIdService.this.bhx) {
                                Log.d("FirebaseInstanceId", "connectivity changed. starting background sync.");
                            }
                            FirebaseInstanceIdService.this.getApplicationContext().unregisterReceiver(this);
                            context.sendBroadcast(FirebaseInstanceIdService.zzagk(zzb));
                        }
                    }
                };
            }
            getApplicationContext().registerReceiver(bhu, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
    }

    static void zzet(Context context) {
        if (zzf.zzdj(context) != null) {
            synchronized (bhv) {
                if (!bhw) {
                    context.sendBroadcast(zzagk(0));
                    bhw = true;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean zzeu(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private zzd zztu(String str) {
        if (str == null) {
            return zzd.zzb(this, (Bundle) null);
        }
        Bundle bundle = new Bundle();
        bundle.putString("subtype", str);
        return zzd.zzb(this, bundle);
    }

    @WorkerThread
    public void onTokenRefresh() {
    }

    /* access modifiers changed from: protected */
    public Intent zzae(Intent intent) {
        return FirebaseInstanceIdInternalReceiver.m1498F();
    }

    public boolean zzag(Intent intent) {
        this.bhx = Log.isLoggable("FirebaseInstanceId", 3);
        if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) {
            return false;
        }
        String zzai = zzai(intent);
        if (this.bhx) {
            String valueOf = String.valueOf(zzai);
            Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Register result in service ".concat(valueOf) : new String("Register result in service "));
        }
        zztu(zzai).mo11759I().zzv(intent);
        return true;
    }

    public void zzah(Intent intent) {
        String zzai = zzai(intent);
        zzd zztu = zztu(zzai);
        String stringExtra = intent.getStringExtra("CMD");
        if (this.bhx) {
            String valueOf = String.valueOf(intent.getExtras());
            Log.d("FirebaseInstanceId", new StringBuilder(String.valueOf(zzai).length() + 18 + String.valueOf(stringExtra).length() + String.valueOf(valueOf).length()).append("Service command ").append(zzai).append(" ").append(stringExtra).append(" ").append(valueOf).toString());
        }
        if (intent.getStringExtra("unregistered") != null) {
            zzg H = zztu.mo11758H();
            if (zzai == null) {
                zzai = "";
            }
            H.zzku(zzai);
            zztu.mo11759I().zzv(intent);
        } else if ("gcm.googleapis.com/refresh".equals(intent.getStringExtra("from"))) {
            zztu.mo11758H().zzku(zzai);
            zza(intent, false);
        } else if ("RST".equals(stringExtra)) {
            zztu.zzboq();
            zza(intent, true);
        } else if ("RST_FULL".equals(stringExtra)) {
            if (!zztu.mo11758H().isEmpty()) {
                zztu.zzboq();
                zztu.mo11758H().zzbow();
                zza(intent, true);
            }
        } else if ("SYNC".equals(stringExtra)) {
            zztu.mo11758H().zzku(zzai);
            zza(intent, false);
        } else if ("PING".equals(stringExtra)) {
            zza(zztu.mo11759I(), intent.getExtras());
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void zzm(android.content.Intent r5) {
        /*
            r4 = this;
            r1 = 0
            java.lang.String r0 = r5.getAction()
            if (r0 != 0) goto L_0x0009
            java.lang.String r0 = ""
        L_0x0009:
            r2 = -1
            int r3 = r0.hashCode()
            switch(r3) {
                case -1737547627: goto L_0x0019;
                default: goto L_0x0011;
            }
        L_0x0011:
            r0 = r2
        L_0x0012:
            switch(r0) {
                case 0: goto L_0x0023;
                default: goto L_0x0015;
            }
        L_0x0015:
            r4.zzah(r5)
        L_0x0018:
            return
        L_0x0019:
            java.lang.String r3 = "ACTION_TOKEN_REFRESH_RETRY"
            boolean r0 = r0.equals(r3)
            if (r0 == 0) goto L_0x0011
            r0 = r1
            goto L_0x0012
        L_0x0023:
            r4.zza((android.content.Intent) r5, (boolean) r1)
            goto L_0x0018
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.FirebaseInstanceIdService.zzm(android.content.Intent):void");
    }
}
