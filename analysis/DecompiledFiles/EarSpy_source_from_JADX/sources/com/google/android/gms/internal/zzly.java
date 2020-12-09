package com.google.android.gms.internal;

import android.os.RemoteException;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzab;
import com.google.android.gms.ads.internal.client.zzac;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.util.zzf;
import java.util.HashMap;
import java.util.Map;

@zziy
public class zzly extends zzab.zza {
    /* access modifiers changed from: private */
    public final Object zzakd = new Object();
    private boolean zzakg = true;
    /* access modifiers changed from: private */
    public final zzlt zzbkr;
    private final float zzcwo;
    private int zzcwp;
    /* access modifiers changed from: private */
    public zzac zzcwq;
    /* access modifiers changed from: private */
    public boolean zzcwr;
    private boolean zzcws;
    private float zzcwt;
    private float zzcwu;

    public zzly(zzlt zzlt, float f) {
        this.zzbkr = zzlt;
        this.zzcwo = f;
    }

    private void zzdl(String str) {
        zze(str, (Map<String, String>) null);
    }

    private void zze(String str, @Nullable Map<String, String> map) {
        final HashMap hashMap = map == null ? new HashMap() : new HashMap(map);
        hashMap.put("action", str);
        zzu.zzfz().runOnUiThread(new Runnable() {
            public void run() {
                zzly.this.zzbkr.zza("pubVideoCmd", (Map<String, ?>) hashMap);
            }
        });
    }

    private void zzi(final int i, final int i2) {
        zzu.zzfz().runOnUiThread(new Runnable() {
            public void run() {
                boolean z = false;
                synchronized (zzly.this.zzakd) {
                    boolean z2 = i != i2;
                    boolean z3 = !zzly.this.zzcwr && i2 == 1;
                    boolean z4 = z2 && i2 == 1;
                    boolean z5 = z2 && i2 == 2;
                    boolean z6 = z2 && i2 == 3;
                    zzly zzly = zzly.this;
                    if (zzly.this.zzcwr || z3) {
                        z = true;
                    }
                    boolean unused = zzly.zzcwr = z;
                    if (zzly.this.zzcwq != null) {
                        if (z3) {
                            try {
                                zzly.this.zzcwq.zzjw();
                            } catch (RemoteException e) {
                                zzkn.zzd("Unable to call onVideoStart()", e);
                            }
                        }
                        if (z4) {
                            try {
                                zzly.this.zzcwq.zzjx();
                            } catch (RemoteException e2) {
                                zzkn.zzd("Unable to call onVideoPlay()", e2);
                            }
                        }
                        if (z5) {
                            try {
                                zzly.this.zzcwq.zzjy();
                            } catch (RemoteException e3) {
                                zzkn.zzd("Unable to call onVideoPause()", e3);
                            }
                        }
                        if (z6) {
                            try {
                                zzly.this.zzcwq.onVideoEnd();
                            } catch (RemoteException e4) {
                                zzkn.zzd("Unable to call onVideoEnd()", e4);
                            }
                        }
                    }
                }
            }
        });
    }

    public float getAspectRatio() {
        float f;
        synchronized (this.zzakd) {
            f = this.zzcwu;
        }
        return f;
    }

    public int getPlaybackState() {
        int i;
        synchronized (this.zzakd) {
            i = this.zzcwp;
        }
        return i;
    }

    public boolean isMuted() {
        boolean z;
        synchronized (this.zzakd) {
            z = this.zzcws;
        }
        return z;
    }

    public void pause() {
        zzdl("pause");
    }

    public void play() {
        zzdl("play");
    }

    public void zza(float f, int i, boolean z, float f2) {
        int i2;
        synchronized (this.zzakd) {
            this.zzcwt = f;
            this.zzcws = z;
            i2 = this.zzcwp;
            this.zzcwp = i;
            this.zzcwu = f2;
        }
        zzi(i2, i);
    }

    public void zza(zzac zzac) {
        synchronized (this.zzakd) {
            this.zzcwq = zzac;
        }
    }

    public void zzap(boolean z) {
        synchronized (this.zzakd) {
            this.zzakg = z;
        }
        zze("initialState", zzf.zze("muteStart", z ? "1" : "0"));
    }

    public float zzju() {
        return this.zzcwo;
    }

    public float zzjv() {
        float f;
        synchronized (this.zzakd) {
            f = this.zzcwt;
        }
        return f;
    }

    public void zzn(boolean z) {
        zzdl(z ? "mute" : "unmute");
    }
}
