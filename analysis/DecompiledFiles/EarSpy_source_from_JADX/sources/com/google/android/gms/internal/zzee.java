package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzdx;
import java.util.ArrayList;
import java.util.List;

@zziy
public class zzee extends NativeContentAd {
    private final List<NativeAd.Image> zzblr = new ArrayList();
    private final zzed zzblt;
    private final zzdy zzblu;

    public zzee(zzed zzed) {
        zzdy zzdy;
        this.zzblt = zzed;
        try {
            List<Object> images = this.zzblt.getImages();
            if (images != null) {
                for (Object zze : images) {
                    zzdx zze2 = zze(zze);
                    if (zze2 != null) {
                        this.zzblr.add(new zzdy(zze2));
                    }
                }
            }
        } catch (RemoteException e) {
            zzb.zzb("Failed to get image.", e);
        }
        try {
            zzdx zzlt = this.zzblt.zzlt();
            if (zzlt != null) {
                zzdy = new zzdy(zzlt);
                this.zzblu = zzdy;
            }
        } catch (RemoteException e2) {
            zzb.zzb("Failed to get icon.", e2);
        }
        zzdy = null;
        this.zzblu = zzdy;
    }

    public void destroy() {
        try {
            this.zzblt.destroy();
        } catch (RemoteException e) {
            zzb.zzb("Failed to destroy", e);
        }
    }

    public CharSequence getAdvertiser() {
        try {
            return this.zzblt.getAdvertiser();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get attribution.", e);
            return null;
        }
    }

    public CharSequence getBody() {
        try {
            return this.zzblt.getBody();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get body.", e);
            return null;
        }
    }

    public CharSequence getCallToAction() {
        try {
            return this.zzblt.getCallToAction();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get call to action.", e);
            return null;
        }
    }

    public Bundle getExtras() {
        try {
            return this.zzblt.getExtras();
        } catch (RemoteException e) {
            zzb.zzd("Failed to get extras", e);
            return null;
        }
    }

    public CharSequence getHeadline() {
        try {
            return this.zzblt.getHeadline();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get headline.", e);
            return null;
        }
    }

    public List<NativeAd.Image> getImages() {
        return this.zzblr;
    }

    public NativeAd.Image getLogo() {
        return this.zzblu;
    }

    /* access modifiers changed from: package-private */
    public zzdx zze(Object obj) {
        if (obj instanceof IBinder) {
            return zzdx.zza.zzab((IBinder) obj);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzlp */
    public zzd zzdl() {
        try {
            return this.zzblt.zzlp();
        } catch (RemoteException e) {
            zzb.zzb("Failed to retrieve native ad engine.", e);
            return null;
        }
    }
}
