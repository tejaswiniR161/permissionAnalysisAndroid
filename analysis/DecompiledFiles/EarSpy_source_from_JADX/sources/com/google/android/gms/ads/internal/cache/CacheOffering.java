package com.google.android.gms.ads.internal.cache;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.Nullable;
import com.google.android.gms.ads.internal.zzu;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.zziy;
import com.google.android.gms.internal.zzkn;
import java.util.List;

@zziy
public class CacheOffering extends AbstractSafeParcelable {
    public static final zzd CREATOR = new zzd();
    @Nullable
    public final String url;
    public final int version;
    public final long zzavv;
    public final String zzavw;
    public final String zzavx;
    public final String zzavy;
    public final Bundle zzavz;
    public final boolean zzawa;

    CacheOffering(int i, @Nullable String str, long j, String str2, String str3, String str4, Bundle bundle, boolean z) {
        this.version = i;
        this.url = str;
        this.zzavv = j;
        this.zzavw = str2 == null ? "" : str2;
        this.zzavx = str3 == null ? "" : str3;
        this.zzavy = str4 == null ? "" : str4;
        this.zzavz = bundle == null ? new Bundle() : bundle;
        this.zzawa = z;
    }

    @Nullable
    public static CacheOffering zzag(String str) {
        return zze(Uri.parse(str));
    }

    @Nullable
    public static CacheOffering zze(Uri uri) {
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                zzkn.zzdf(new StringBuilder(62).append("Expected 2 path parts for namespace and id, found :").append(pathSegments.size()).toString());
                return null;
            }
            String str = pathSegments.get(0);
            String str2 = pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter("url");
            boolean equals = "1".equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            long parseLong = queryParameter2 == null ? 0 : Long.parseLong(queryParameter2);
            Bundle bundle = new Bundle();
            for (String next : zzu.zzgb().zzh(uri)) {
                if (next.startsWith("tag.")) {
                    bundle.putString(next.substring("tag.".length()), uri.getQueryParameter(next));
                }
            }
            return new CacheOffering(1, queryParameter, parseLong, host, str, str2, bundle, equals);
        } catch (NullPointerException | NumberFormatException e) {
            zzkn.zzd("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
