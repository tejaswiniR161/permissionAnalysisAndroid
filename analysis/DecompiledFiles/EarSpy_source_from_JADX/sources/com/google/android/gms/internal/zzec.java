package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.internal.zzdx;
import java.util.ArrayList;
import java.util.List;

@zziy
public class zzec extends NativeAppInstallAd {
    private VideoController zzayu = new VideoController();
    private final zzeb zzblq;
    private final List<NativeAd.Image> zzblr = new ArrayList();
    private final zzdy zzbls;

    public zzec(zzeb zzeb) {
        zzdy zzdy;
        this.zzblq = zzeb;
        try {
            List<Object> images = this.zzblq.getImages();
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
            zzdx zzlo = this.zzblq.zzlo();
            if (zzlo != null) {
                zzdy = new zzdy(zzlo);
                this.zzbls = zzdy;
            }
        } catch (RemoteException e2) {
            zzb.zzb("Failed to get icon.", e2);
        }
        zzdy = null;
        this.zzbls = zzdy;
    }

    public void destroy() {
        try {
            this.zzblq.destroy();
        } catch (RemoteException e) {
            zzb.zzb("Failed to destroy", e);
        }
    }

    public CharSequence getBody() {
        try {
            return this.zzblq.getBody();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get body.", e);
            return null;
        }
    }

    public CharSequence getCallToAction() {
        try {
            return this.zzblq.getCallToAction();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get call to action.", e);
            return null;
        }
    }

    public Bundle getExtras() {
        try {
            return this.zzblq.getExtras();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get extras", e);
            return null;
        }
    }

    public CharSequence getHeadline() {
        try {
            return this.zzblq.getHeadline();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get headline.", e);
            return null;
        }
    }

    public NativeAd.Image getIcon() {
        return this.zzbls;
    }

    public List<NativeAd.Image> getImages() {
        return this.zzblr;
    }

    public CharSequence getPrice() {
        try {
            return this.zzblq.getPrice();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get price.", e);
            return null;
        }
    }

    public Double getStarRating() {
        try {
            double starRating = this.zzblq.getStarRating();
            if (starRating == -1.0d) {
                return null;
            }
            return Double.valueOf(starRating);
        } catch (RemoteException e) {
            zzb.zzb("Failed to get star rating.", e);
            return null;
        }
    }

    public CharSequence getStore() {
        try {
            return this.zzblq.getStore();
        } catch (RemoteException e) {
            zzb.zzb("Failed to get store", e);
            return null;
        }
    }

    public VideoController getVideoController() {
        try {
            if (this.zzblq.zzdw() != null) {
                this.zzayu.zza(this.zzblq.zzdw());
            }
        } catch (RemoteException e) {
            zzb.zzb("Exception occurred while getting video controller", e);
        }
        return this.zzayu;
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
            return this.zzblq.zzlp();
        } catch (RemoteException e) {
            zzb.zzb("Failed to retrieve native ad engine.", e);
            return null;
        }
    }
}
