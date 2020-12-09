package com.google.android.gms.internal;

import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;

public class zzau {
    private static final String[] zzahb = {"/aclk", "/pcs/click"};
    private String zzagx = "googleads.g.doubleclick.net";
    private String zzagy = "/pagead/ads";
    private String zzagz = "ad.doubleclick.net";
    private String[] zzaha = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private zzap zzahc;

    public zzau(zzap zzap) {
        this.zzahc = zzap;
    }

    private Uri zza(Uri uri, Context context, String str, boolean z, View view) throws zzav {
        try {
            boolean zzb = zzb(uri);
            if (zzb) {
                if (uri.toString().contains("dc_ms=")) {
                    throw new zzav("Parameter already exists: dc_ms");
                }
            } else if (uri.getQueryParameter("ms") != null) {
                throw new zzav("Query parameter already exists: ms");
            }
            String zza = z ? this.zzahc.zza(context, str, view) : this.zzahc.zzb(context);
            return zzb ? zzb(uri, "dc_ms", zza) : zza(uri, "ms", zza);
        } catch (UnsupportedOperationException e) {
            throw new zzav("Provided Uri is not in a valid state");
        }
    }

    private Uri zza(Uri uri, String str, String str2) throws UnsupportedOperationException {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl");
        }
        return indexOf != -1 ? Uri.parse(uri2.substring(0, indexOf + 1) + str + "=" + str2 + "&" + uri2.substring(indexOf + 1)) : uri.buildUpon().appendQueryParameter(str, str2).build();
    }

    private Uri zzb(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf(";adurl");
        if (indexOf != -1) {
            return Uri.parse(uri2.substring(0, indexOf + 1) + str + "=" + str2 + ";" + uri2.substring(indexOf + 1));
        }
        String encodedPath = uri.getEncodedPath();
        int indexOf2 = uri2.indexOf(encodedPath);
        return Uri.parse(uri2.substring(0, encodedPath.length() + indexOf2) + ";" + str + "=" + str2 + ";" + uri2.substring(encodedPath.length() + indexOf2));
    }

    public Uri zza(Uri uri, Context context) throws zzav {
        return zza(uri, context, (String) null, false, (View) null);
    }

    public Uri zza(Uri uri, Context context, View view) throws zzav {
        try {
            return zza(uri, context, uri.getQueryParameter("ai"), true, view);
        } catch (UnsupportedOperationException e) {
            throw new zzav("Provided Uri is not in a valid state");
        }
    }

    public void zza(MotionEvent motionEvent) {
        this.zzahc.zza(motionEvent);
    }

    public boolean zza(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.zzagx) && uri.getPath().equals(this.zzagy);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public zzap zzaw() {
        return this.zzahc;
    }

    @Deprecated
    public Uri zzb(Uri uri, Context context) throws zzav {
        return zza(uri, context, (View) null);
    }

    public void zzb(String str, String str2) {
        this.zzagx = str;
        this.zzagy = str2;
    }

    public boolean zzb(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            return uri.getHost().equals(this.zzagz);
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean zzc(Uri uri) {
        if (uri == null) {
            throw new NullPointerException();
        }
        try {
            String host = uri.getHost();
            for (String endsWith : this.zzaha) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    public boolean zzd(Uri uri) {
        if (!zzc(uri)) {
            return false;
        }
        for (String endsWith : zzahb) {
            if (uri.getPath().endsWith(endsWith)) {
                return true;
            }
        }
        return false;
    }

    public void zzm(String str) {
        this.zzaha = str.split(",");
    }
}
