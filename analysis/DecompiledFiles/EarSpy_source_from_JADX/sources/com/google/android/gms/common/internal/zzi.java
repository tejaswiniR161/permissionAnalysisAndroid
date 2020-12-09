package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p000v4.util.SimpleArrayMap;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.C0609R;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.zzsi;

public final class zzi {

    /* renamed from: Cc */
    private static final SimpleArrayMap<String, String> f1731Cc = new SimpleArrayMap<>();

    public static String zzce(Context context) {
        String str = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String packageName = context.getPackageName();
        context.getApplicationContext().getPackageManager();
        try {
            return zzsi.zzcr(context).zzik(context.getPackageName()).toString();
        } catch (PackageManager.NameNotFoundException e) {
            return packageName;
        }
    }

    @Nullable
    public static String zzg(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(C0609R.string.common_google_play_services_install_title);
            case 2:
            case 42:
                return resources.getString(C0609R.string.common_google_play_services_update_title);
            case 3:
                return resources.getString(C0609R.string.common_google_play_services_enable_title);
            case 4:
            case 6:
                return null;
            case 5:
                Log.e("GoogleApiAvailability", "An invalid account was specified when connecting. Please provide a valid account.");
                return zzu(context, "common_google_play_services_invalid_account_title");
            case 7:
                Log.e("GoogleApiAvailability", "Network error occurred. Please retry request later.");
                return zzu(context, "common_google_play_services_network_error_title");
            case 8:
                Log.e("GoogleApiAvailability", "Internal error occurred. Please see logs for detailed information");
                return null;
            case 9:
                Log.e("GoogleApiAvailability", "Google Play services is invalid. Cannot recover.");
                return resources.getString(C0609R.string.common_google_play_services_unsupported_title);
            case 10:
                Log.e("GoogleApiAvailability", "Developer error occurred. Please see logs for detailed information");
                return null;
            case 11:
                Log.e("GoogleApiAvailability", "The application is not licensed to the user.");
                return null;
            case 16:
                Log.e("GoogleApiAvailability", "One of the API components you attempted to connect to is not available.");
                return null;
            case 17:
                Log.e("GoogleApiAvailability", "The specified account could not be signed in.");
                return zzu(context, "common_google_play_services_sign_in_failed_title");
            case 18:
                return resources.getString(C0609R.string.common_google_play_services_updating_title);
            case 20:
                Log.e("GoogleApiAvailability", "The current user profile is restricted and could not use authenticated features.");
                return zzu(context, "common_google_play_services_restricted_profile_title");
            default:
                Log.e("GoogleApiAvailability", new StringBuilder(33).append("Unexpected error code ").append(i).toString());
                return null;
        }
    }

    private static String zzg(Context context, String str, String str2) {
        Resources resources = context.getResources();
        String zzu = zzu(context, str);
        if (zzu == null) {
            zzu = resources.getString(C0609R.string.common_google_play_services_unknown_issue);
        }
        return String.format(resources.getConfiguration().locale, zzu, new Object[]{str2});
    }

    @NonNull
    public static String zzh(Context context, int i) {
        String zzu = i == 6 ? zzu(context, "common_google_play_services_resolution_required_title") : zzg(context, i);
        return zzu == null ? context.getResources().getString(C0609R.string.common_google_play_services_notification_ticker) : zzu;
    }

    @NonNull
    public static String zzi(Context context, int i) {
        Resources resources = context.getResources();
        String zzce = zzce(context);
        switch (i) {
            case 1:
                if (com.google.android.gms.common.util.zzi.zzb(resources)) {
                    return resources.getString(C0609R.string.common_google_play_services_install_text_tablet, new Object[]{zzce});
                }
                return resources.getString(C0609R.string.common_google_play_services_install_text_phone, new Object[]{zzce});
            case 2:
                return resources.getString(C0609R.string.common_google_play_services_update_text, new Object[]{zzce});
            case 3:
                return resources.getString(C0609R.string.common_google_play_services_enable_text, new Object[]{zzce});
            case 5:
                return zzg(context, "common_google_play_services_invalid_account_text", zzce);
            case 7:
                return zzg(context, "common_google_play_services_network_error_text", zzce);
            case 9:
                return resources.getString(C0609R.string.common_google_play_services_unsupported_text, new Object[]{zzce});
            case 16:
                return zzg(context, "common_google_play_services_api_unavailable_text", zzce);
            case 17:
                return zzg(context, "common_google_play_services_sign_in_failed_text", zzce);
            case 18:
                return resources.getString(C0609R.string.common_google_play_services_updating_text, new Object[]{zzce});
            case 20:
                return zzg(context, "common_google_play_services_restricted_profile_text", zzce);
            case 42:
                return resources.getString(C0609R.string.common_google_play_services_wear_update_text);
            default:
                return resources.getString(C0609R.string.common_google_play_services_unknown_issue, new Object[]{zzce});
        }
    }

    @NonNull
    public static String zzj(Context context, int i) {
        return i == 6 ? zzg(context, "common_google_play_services_resolution_required_text", zzce(context)) : zzi(context, i);
    }

    @NonNull
    public static String zzk(Context context, int i) {
        Resources resources = context.getResources();
        switch (i) {
            case 1:
                return resources.getString(C0609R.string.common_google_play_services_install_button);
            case 2:
                return resources.getString(C0609R.string.common_google_play_services_update_button);
            case 3:
                return resources.getString(C0609R.string.common_google_play_services_enable_button);
            default:
                return resources.getString(17039370);
        }
    }

    @Nullable
    private static String zzu(Context context, String str) {
        synchronized (f1731Cc) {
            String str2 = f1731Cc.get(str);
            if (str2 != null) {
                return str2;
            }
            Resources remoteResource = GooglePlayServicesUtil.getRemoteResource(context);
            if (remoteResource == null) {
                return null;
            }
            int identifier = remoteResource.getIdentifier(str, "string", "com.google.android.gms");
            if (identifier == 0) {
                String valueOf = String.valueOf(str);
                Log.w("GoogleApiAvailability", valueOf.length() != 0 ? "Missing resource: ".concat(valueOf) : new String("Missing resource: "));
                return null;
            }
            String string = remoteResource.getString(identifier);
            if (TextUtils.isEmpty(string)) {
                String valueOf2 = String.valueOf(str);
                Log.w("GoogleApiAvailability", valueOf2.length() != 0 ? "Got empty resource: ".concat(valueOf2) : new String("Got empty resource: "));
                return null;
            }
            f1731Cc.put(str, string);
            return string;
        }
    }
}
