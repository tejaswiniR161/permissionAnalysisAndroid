package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zze;
import com.google.android.gms.common.stats.zzb;
import com.google.android.gms.common.zzc;
import com.google.android.gms.measurement.internal.zzm;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class zzad extends zzaa {
    /* access modifiers changed from: private */
    public final zza arP;
    /* access modifiers changed from: private */
    public zzm arQ;
    private Boolean arR;
    private final zzf arS;
    private final zzah arT;
    private final List<Runnable> arU = new ArrayList();
    private final zzf arV;

    protected class zza implements ServiceConnection, zze.zzb, zze.zzc {
        /* access modifiers changed from: private */
        public volatile boolean arY;
        private volatile zzo arZ;

        protected zza() {
        }

        @MainThread
        public void onConnected(@Nullable Bundle bundle) {
            zzac.zzhq("MeasurementServiceConnection.onConnected");
            synchronized (this) {
                try {
                    final zzm zzm = (zzm) this.arZ.zzatx();
                    this.arZ = null;
                    zzad.this.zzbvf().zzm(new Runnable() {
                        public void run() {
                            synchronized (zza.this) {
                                boolean unused = zza.this.arY = false;
                                if (!zzad.this.isConnected()) {
                                    zzad.this.zzbvg().zzbwi().log("Connected to remote service");
                                    zzad.this.zza(zzm);
                                }
                            }
                        }
                    });
                } catch (DeadObjectException | IllegalStateException e) {
                    this.arZ = null;
                    this.arY = false;
                }
            }
        }

        @MainThread
        public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zzac.zzhq("MeasurementServiceConnection.onConnectionFailed");
            zzp zzbww = zzad.this.anq.zzbww();
            if (zzbww != null) {
                zzbww.zzbwe().zzj("Service connection failed", connectionResult);
            }
            synchronized (this) {
                this.arY = false;
                this.arZ = null;
            }
        }

        @MainThread
        public void onConnectionSuspended(int i) {
            zzac.zzhq("MeasurementServiceConnection.onConnectionSuspended");
            zzad.this.zzbvg().zzbwi().log("Service connection suspended");
            zzad.this.zzbvf().zzm(new Runnable() {
                public void run() {
                    zzad.this.onServiceDisconnected(new ComponentName(zzad.this.getContext(), (!zzad.this.zzbvi().zzact() || zzad.this.anq.zzbxg()) ? "com.google.android.gms.measurement.AppMeasurementService" : "com.google.android.gms.measurement.PackageMeasurementService"));
                }
            });
        }

        @MainThread
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            zzac.zzhq("MeasurementServiceConnection.onServiceConnected");
            synchronized (this) {
                if (iBinder == null) {
                    this.arY = false;
                    zzad.this.zzbvg().zzbwc().log("Service connected with null binder");
                    return;
                }
                final zzm zzm = null;
                try {
                    String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                    if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                        zzm = zzm.zza.zzjl(iBinder);
                        zzad.this.zzbvg().zzbwj().log("Bound to IMeasurementService interface");
                    } else {
                        zzad.this.zzbvg().zzbwc().zzj("Got binder with a wrong descriptor", interfaceDescriptor);
                    }
                } catch (RemoteException e) {
                    zzad.this.zzbvg().zzbwc().log("Service connect failed to get IMeasurementService");
                }
                if (zzm == null) {
                    this.arY = false;
                    try {
                        zzb.zzawu().zza(zzad.this.getContext(), (ServiceConnection) zzad.this.arP);
                    } catch (IllegalArgumentException e2) {
                    }
                } else {
                    zzad.this.zzbvf().zzm(new Runnable() {
                        public void run() {
                            synchronized (zza.this) {
                                boolean unused = zza.this.arY = false;
                                if (!zzad.this.isConnected()) {
                                    zzad.this.zzbvg().zzbwj().log("Connected to service");
                                    zzad.this.zza(zzm);
                                }
                            }
                        }
                    });
                }
            }
        }

        @MainThread
        public void onServiceDisconnected(final ComponentName componentName) {
            zzac.zzhq("MeasurementServiceConnection.onServiceDisconnected");
            zzad.this.zzbvg().zzbwi().log("Service disconnected");
            zzad.this.zzbvf().zzm(new Runnable() {
                public void run() {
                    zzad.this.onServiceDisconnected(componentName);
                }
            });
        }

        @WorkerThread
        public void zzac(Intent intent) {
            zzad.this.zzyl();
            Context context = zzad.this.getContext();
            zzb zzawu = zzb.zzawu();
            synchronized (this) {
                if (this.arY) {
                    zzad.this.zzbvg().zzbwj().log("Connection attempt already in progress");
                    return;
                }
                this.arY = true;
                zzawu.zza(context, intent, (ServiceConnection) zzad.this.arP, 129);
            }
        }

        @WorkerThread
        public void zzbye() {
            zzad.this.zzyl();
            Context context = zzad.this.getContext();
            synchronized (this) {
                if (this.arY) {
                    zzad.this.zzbvg().zzbwj().log("Connection attempt already in progress");
                } else if (this.arZ != null) {
                    zzad.this.zzbvg().zzbwj().log("Already awaiting connection attempt");
                } else {
                    this.arZ = new zzo(context, Looper.getMainLooper(), this, this);
                    zzad.this.zzbvg().zzbwj().log("Connecting to remote service");
                    this.arY = true;
                    this.arZ.zzatu();
                }
            }
        }
    }

    protected zzad(zzx zzx) {
        super(zzx);
        this.arT = new zzah(zzx.zzaan());
        this.arP = new zza();
        this.arS = new zzf(zzx) {
            public void run() {
                zzad.this.zzabl();
            }
        };
        this.arV = new zzf(zzx) {
            public void run() {
                zzad.this.zzbvg().zzbwe().log("Tasks have been queued for a long time");
            }
        };
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void onServiceDisconnected(ComponentName componentName) {
        zzyl();
        if (this.arQ != null) {
            this.arQ = null;
            zzbvg().zzbwj().zzj("Disconnected from device MeasurementService", componentName);
            zzbyc();
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void zza(zzm zzm) {
        zzyl();
        zzac.zzy(zzm);
        this.arQ = zzm;
        zzabk();
        zzbyd();
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void zzabk() {
        zzyl();
        this.arT.start();
        if (!this.anq.zzbxg()) {
            this.arS.zzx(zzbvi().zzado());
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public void zzabl() {
        zzyl();
        if (isConnected()) {
            zzbvg().zzbwj().log("Inactivity, disconnecting from the service");
            disconnect();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r1 = getContext().getPackageManager().queryIntentServices(new android.content.Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean zzbya() {
        /*
            r5 = this;
            r0 = 0
            com.google.android.gms.measurement.internal.zzd r1 = r5.zzbvi()
            boolean r1 = r1.zzact()
            if (r1 == 0) goto L_0x000c
        L_0x000b:
            return r0
        L_0x000c:
            android.content.Context r1 = r5.getContext()
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            android.content.Context r3 = r5.getContext()
            java.lang.String r4 = "com.google.android.gms.measurement.AppMeasurementService"
            android.content.Intent r2 = r2.setClassName(r3, r4)
            r3 = 65536(0x10000, float:9.18355E-41)
            java.util.List r1 = r1.queryIntentServices(r2, r3)
            if (r1 == 0) goto L_0x000b
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x000b
            r0 = 1
            goto L_0x000b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzad.zzbya():boolean");
    }

    @WorkerThread
    private void zzbyc() {
        zzyl();
        zzabz();
    }

    @WorkerThread
    private void zzbyd() {
        zzyl();
        zzbvg().zzbwj().zzj("Processing queued up service tasks", Integer.valueOf(this.arU.size()));
        for (Runnable zzm : this.arU) {
            zzbvf().zzm(zzm);
        }
        this.arU.clear();
        this.arV.cancel();
    }

    @WorkerThread
    private void zzo(Runnable runnable) throws IllegalStateException {
        zzyl();
        if (isConnected()) {
            runnable.run();
        } else if (((long) this.arU.size()) >= zzbvi().zzbug()) {
            zzbvg().zzbwc().log("Discarding data. Max runnable queue size reached");
        } else {
            this.arU.add(runnable);
            if (!this.anq.zzbxg()) {
                this.arV.zzx(60000);
            }
            zzabz();
        }
    }

    @WorkerThread
    public void disconnect() {
        zzyl();
        zzaax();
        try {
            zzb.zzawu().zza(getContext(), (ServiceConnection) this.arP);
        } catch (IllegalArgumentException | IllegalStateException e) {
        }
        this.arQ = null;
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    @WorkerThread
    public boolean isConnected() {
        zzyl();
        zzaax();
        return this.arQ != null;
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public void zza(final UserAttributeParcel userAttributeParcel) {
        zzyl();
        zzaax();
        zzo(new Runnable() {
            public void run() {
                zzm zzc = zzad.this.arQ;
                if (zzc == null) {
                    zzad.this.zzbvg().zzbwc().log("Discarding data. Failed to set user attribute");
                    return;
                }
                try {
                    zzc.zza(userAttributeParcel, zzad.this.zzbuy().zzmi(zzad.this.zzbvg().zzbwk()));
                    zzad.this.zzabk();
                } catch (RemoteException e) {
                    zzad.this.zzbvg().zzbwc().zzj("Failed to send attribute to the service", e);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public void zza(final AtomicReference<List<UserAttributeParcel>> atomicReference, final boolean z) {
        zzyl();
        zzaax();
        zzo(new Runnable() {
            /* JADX INFO: finally extract failed */
            public void run() {
                synchronized (atomicReference) {
                    try {
                        zzm zzc = zzad.this.arQ;
                        if (zzc == null) {
                            zzad.this.zzbvg().zzbwc().log("Failed to get user properties");
                            atomicReference.notify();
                            return;
                        }
                        atomicReference.set(zzc.zza(zzad.this.zzbuy().zzmi((String) null), z));
                        zzad.this.zzabk();
                        atomicReference.notify();
                    } catch (RemoteException e) {
                        zzad.this.zzbvg().zzbwc().zzj("Failed to get user properties", e);
                        atomicReference.notify();
                    } catch (Throwable th) {
                        atomicReference.notify();
                        throw th;
                    }
                }
            }
        });
    }

    public /* bridge */ /* synthetic */ void zzaam() {
        super.zzaam();
    }

    public /* bridge */ /* synthetic */ com.google.android.gms.common.util.zze zzaan() {
        return super.zzaan();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public void zzabz() {
        zzyl();
        zzaax();
        if (!isConnected()) {
            if (this.arR == null) {
                this.arR = zzbvh().zzbwq();
                if (this.arR == null) {
                    zzbvg().zzbwj().log("State of service unknown");
                    this.arR = Boolean.valueOf(zzbyb());
                    zzbvh().zzcf(this.arR.booleanValue());
                }
            }
            if (this.arR.booleanValue()) {
                zzbvg().zzbwj().log("Using measurement service");
                this.arP.zzbye();
            } else if (this.anq.zzbxg() || !zzbya()) {
                zzbvg().zzbwc().log("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            } else {
                zzbvg().zzbwj().log("Using local app measurement service");
                Intent intent = new Intent("com.google.android.gms.measurement.START");
                intent.setComponent(new ComponentName(getContext(), zzbvi().zzact() ? "com.google.android.gms.measurement.PackageMeasurementService" : "com.google.android.gms.measurement.AppMeasurementService"));
                this.arP.zzac(intent);
            }
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

    /* access modifiers changed from: protected */
    @WorkerThread
    public void zzbxw() {
        zzyl();
        zzaax();
        zzo(new Runnable() {
            public void run() {
                zzm zzc = zzad.this.arQ;
                if (zzc == null) {
                    zzad.this.zzbvg().zzbwc().log("Discarding data. Failed to send app launch");
                    return;
                }
                try {
                    zzc.zza(zzad.this.zzbuy().zzmi(zzad.this.zzbvg().zzbwk()));
                    zzad.this.zzabk();
                } catch (RemoteException e) {
                    zzad.this.zzbvg().zzbwc().zzj("Failed to send app launch to the service", e);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public void zzbxz() {
        zzyl();
        zzaax();
        zzo(new Runnable() {
            public void run() {
                zzm zzc = zzad.this.arQ;
                if (zzc == null) {
                    zzad.this.zzbvg().zzbwc().log("Failed to send measurementEnabled to service");
                    return;
                }
                try {
                    zzc.zzb(zzad.this.zzbuy().zzmi(zzad.this.zzbvg().zzbwk()));
                    zzad.this.zzabk();
                } catch (RemoteException e) {
                    zzad.this.zzbvg().zzbwc().zzj("Failed to send measurementEnabled to the service", e);
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public boolean zzbyb() {
        zzyl();
        zzaax();
        if (zzbvi().zzact()) {
            return true;
        }
        zzbvg().zzbwj().log("Checking service availability");
        switch (zzc.zzapd().isGooglePlayServicesAvailable(getContext())) {
            case 0:
                zzbvg().zzbwj().log("Service available");
                return true;
            case 1:
                zzbvg().zzbwj().log("Service missing");
                return false;
            case 2:
                zzbvg().zzbwi().log("Service container out of date");
                return true;
            case 3:
                zzbvg().zzbwe().log("Service disabled");
                return false;
            case 9:
                zzbvg().zzbwe().log("Service invalid");
                return false;
            case 18:
                zzbvg().zzbwe().log("Service updating");
                return true;
            default:
                return false;
        }
    }

    /* access modifiers changed from: protected */
    @WorkerThread
    public void zzc(final EventParcel eventParcel, final String str) {
        zzac.zzy(eventParcel);
        zzyl();
        zzaax();
        zzo(new Runnable() {
            public void run() {
                zzm zzc = zzad.this.arQ;
                if (zzc == null) {
                    zzad.this.zzbvg().zzbwc().log("Discarding data. Failed to send event to service");
                    return;
                }
                try {
                    if (TextUtils.isEmpty(str)) {
                        zzc.zza(eventParcel, zzad.this.zzbuy().zzmi(zzad.this.zzbvg().zzbwk()));
                    } else {
                        zzc.zza(eventParcel, str, zzad.this.zzbvg().zzbwk());
                    }
                    zzad.this.zzabk();
                } catch (RemoteException e) {
                    zzad.this.zzbvg().zzbwc().zzj("Failed to send event to the service", e);
                }
            }
        });
    }

    public /* bridge */ /* synthetic */ void zzyl() {
        super.zzyl();
    }

    /* access modifiers changed from: protected */
    public void zzym() {
    }
}
