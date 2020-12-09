package com.facebook.ads.internal.action;

import android.content.Context;
import android.net.Uri;

/* renamed from: com.facebook.ads.internal.action.b */
public class C0435b {
    /* renamed from: a */
    public static C0434a m813a(Context context, Uri uri) {
        String authority = uri.getAuthority();
        String queryParameter = uri.getQueryParameter("video_url");
        if ("store".equals(authority)) {
            if (queryParameter != null) {
                return null;
            }
            return new C0436c(context, uri);
        } else if ("open_link".equals(authority)) {
            return new C0437d(context, uri);
        } else {
            return null;
        }
    }
}
