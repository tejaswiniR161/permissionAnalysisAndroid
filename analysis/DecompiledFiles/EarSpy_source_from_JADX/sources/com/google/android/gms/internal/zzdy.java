package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;

@zziy
public class zzdy extends NativeAd.Image {
    private final Drawable mDrawable;
    private final Uri mUri;
    private final double zzbjp;
    private final zzdx zzblp;

    public zzdy(zzdx zzdx) {
        Drawable drawable;
        Uri uri = null;
        this.zzblp = zzdx;
        try {
            zzd zzln = this.zzblp.zzln();
            if (zzln != null) {
                drawable = (Drawable) zze.zzae(zzln);
                this.mDrawable = drawable;
                uri = this.zzblp.getUri();
                this.mUri = uri;
                double d = 1.0d;
                d = this.zzblp.getScale();
                this.zzbjp = d;
            }
        } catch (RemoteException e) {
            zzb.zzb("Failed to get drawable.", e);
        }
        drawable = null;
        this.mDrawable = drawable;
        try {
            uri = this.zzblp.getUri();
        } catch (RemoteException e2) {
            zzb.zzb("Failed to get uri.", e2);
        }
        this.mUri = uri;
        double d2 = 1.0d;
        try {
            d2 = this.zzblp.getScale();
        } catch (RemoteException e3) {
            zzb.zzb("Failed to get scale.", e3);
        }
        this.zzbjp = d2;
    }

    public Drawable getDrawable() {
        return this.mDrawable;
    }

    public double getScale() {
        return this.zzbjp;
    }

    public Uri getUri() {
        return this.mUri;
    }
}
