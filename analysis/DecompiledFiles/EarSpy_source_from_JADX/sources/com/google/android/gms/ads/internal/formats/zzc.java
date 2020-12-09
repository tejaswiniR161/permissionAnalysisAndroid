package com.google.android.gms.ads.internal.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.dynamic.zze;
import com.google.android.gms.internal.zzdx;
import com.google.android.gms.internal.zziy;

@zziy
public class zzc extends zzdx.zza {
    private final Uri mUri;
    private final Drawable zzbjo;
    private final double zzbjp;

    public zzc(Drawable drawable, Uri uri, double d) {
        this.zzbjo = drawable;
        this.mUri = uri;
        this.zzbjp = d;
    }

    public double getScale() {
        return this.zzbjp;
    }

    public Uri getUri() throws RemoteException {
        return this.mUri;
    }

    public zzd zzln() throws RemoteException {
        return zze.zzac(this.zzbjo);
    }
}
